package org.newoffshore.ui.model;

public class TestUpdate {
    public final String country;
    public final String service;
    public final Status status;
    public final long durationMs;
    public final String lastRun;
    public final String message;

    public TestUpdate(String country, String service, Status status, long durationMs, String lastRun, String message) {
        this.country = country;
        this.service = service;
        this.status = status;
        this.durationMs = durationMs;
        this.lastRun = lastRun;
        this.message = message;
    }
}