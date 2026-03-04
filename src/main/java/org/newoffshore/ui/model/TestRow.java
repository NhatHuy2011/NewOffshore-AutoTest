package org.newoffshore.ui.model;

public class TestRow {
    public final String country;
    public final String service;
    public Status status;
    public long durationMs;
    public String lastRun;
    public String message;

    public TestRow(String country, String service) {
        this.country = country;
        this.service = service;
        this.status = Status.PENDING;
        this.durationMs = 0;
        this.lastRun = "";
        this.message = "";
    }

    public static TestRow pending(String country, String service) {
        return new TestRow(country, service);
    }
}