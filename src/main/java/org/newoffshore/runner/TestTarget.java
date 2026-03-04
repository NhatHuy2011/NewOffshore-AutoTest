package org.newoffshore.runner;

import java.util.List;

public record TestTarget(String className, List<String> methodNames) {
    public static TestTarget of(String className, String... methods) {
        return new TestTarget(className, List.of(methods));
    }
}