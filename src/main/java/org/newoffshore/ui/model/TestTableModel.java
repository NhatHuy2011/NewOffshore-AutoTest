package org.newoffshore.ui.model;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class TestTableModel extends AbstractTableModel {
    private final String[] cols = {"Country", "Service", "Status", "Duration (ms)", "Last Run", "Message"};
    private List<TestRow> rows = new ArrayList<>();
    private final Map<String, TestRow> cache = new HashMap<>();

    public void setRows(List<TestRow> newRows) {
        this.rows = new ArrayList<>(newRows);
        fireTableDataChanged();
    }

    public List<TestRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public TestRow getOrCreate(String country, String service) {
        String key = country + "||" + service;
        if (!cache.containsKey(key)) cache.put(key, new TestRow(country, service));
        return cache.get(key);
    }

    public void applyUpdate(TestUpdate u) {
        TestRow r = getOrCreate(u.country, u.service);
        r.status = u.status;
        r.durationMs = u.durationMs;
        r.lastRun = (u.lastRun != null) ? u.lastRun : r.lastRun;

        if (looksLikeStacktrace(u.message)) {
            r.message = "Exception (see log)";
        } else if (u.message != null) {
            r.message = u.message;
        }

        for (int i = 0; i < rows.size(); i++) {
            TestRow visible = rows.get(i);
            if (visible.country.equals(u.country) && visible.service.equals(u.service)) {
                fireTableRowsUpdated(i, i);
                break;
            }
        }
    }

    private boolean looksLikeStacktrace(String msg) {
        if (msg == null || msg.isBlank()) return false;
        return (msg.contains("\n") && (msg.contains("\n\tat ") || msg.contains("\n    at ")))
                || msg.contains("Exception")
                || msg.contains("AssertionError")
                || msg.contains("org.opentest4j");
    }

    public void resetStatuses() {
        for (TestRow r : cache.values()) {
            r.status = Status.PENDING;
            r.durationMs = 0;
            r.lastRun = "";
            r.message = "";
        }
        fireTableDataChanged();
    }

    @Override public int getRowCount() { return rows.size(); }
    @Override public int getColumnCount() { return cols.length; }
    @Override public String getColumnName(int column) { return cols[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TestRow r = rows.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> r.country;
            case 1 -> r.service;
            case 2 -> r.status;
            case 3 -> r.durationMs == 0 ? "" : r.durationMs;
            case 4 -> r.lastRun;
            case 5 -> r.message;
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) return Status.class;
        return String.class;
    }
}