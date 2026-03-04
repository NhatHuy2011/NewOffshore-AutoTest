package org.newoffshore.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class FlowReflectionRunner {
    private FlowReflectionRunner() {}

    public record RunResult(boolean passed, long durationMs, String message, String stacktrace) {}

    public static RunResult run(TestTarget target) {
        long start = System.currentTimeMillis();

        try {
            Class<?> clazz = Class.forName(target.className());
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // chạy lần lượt các method trong methodNames
            for (String methodName : target.methodNames()) {
                Method m = clazz.getDeclaredMethod(methodName);
                m.setAccessible(true);
                m.invoke(instance);
            }

            long duration = System.currentTimeMillis() - start;
            return new RunResult(true, duration, "OK", null);

        } catch (InvocationTargetException e) {
            // lỗi thật nằm trong target exception
            Throwable root = e.getTargetException() != null ? e.getTargetException() : e;
            long duration = System.currentTimeMillis() - start;
            return new RunResult(false, duration, "FAILED: " + root.getClass().getSimpleName() + " - " + safe(root.getMessage()),
                    stacktrace(root));

        } catch (Throwable t) {
            long duration = System.currentTimeMillis() - start;
            return new RunResult(false, duration, "FAILED: " + t.getClass().getSimpleName() + " - " + safe(t.getMessage()),
                    stacktrace(t));
        }
    }

    private static String safe(String s) { return s == null ? "" : s; }

    private static String stacktrace(Throwable t) {
        StringBuilder sb = new StringBuilder();
        sb.append(t).append("\n");
        for (StackTraceElement el : t.getStackTrace()) {
            sb.append("\tat ").append(el).append("\n");
        }
        return sb.toString();
    }
}