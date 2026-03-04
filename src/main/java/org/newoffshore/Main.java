package org.newoffshore;

import org.newoffshore.ui.data.TestDataSeeder;
import org.newoffshore.ui.model.*;
import org.newoffshore.ui.render.ModernTreeRenderer;
import org.newoffshore.ui.render.StatusPillRenderer;

import org.newoffshore.runner.FlowReflectionRunner;
import org.newoffshore.runner.TestRegistry;
import org.newoffshore.runner.TestTarget;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

/**
 * AutoTest UI Mock (Java Swing)
 * - Left: Countries + Services (JTree)
 * - Center: Test table (Country, Service, Status, Duration, Last Run, Message)
 * - Bottom: Log console (exceptions + run logs)
 * - Top: Actions (Run Selected, Export HTML, Export Excel, Clear, Reset)
 */
public class Main extends JFrame {

    // ===== Data =====
    private final Map<String, List<String>> countryServices = new LinkedHashMap<>();
    private final TestTableModel tableModel = new TestTableModel();
    private final JTable table = new JTable(tableModel);
    private final JTextArea logArea = new JTextArea(10, 80);

    private final JLabel selectionLabel = new JLabel("Selection: (none)");
    private final JLabel summaryLabel = new JLabel("Summary: PASS 0 | FAIL 0 | PENDING 0");

    private JTree tree;
    private DefaultTreeModel treeModel;

    // Keep current selection context
    private String selectedCountry = null;
    private String selectedService = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setNimbusLookAndFeel();
            new Main().setVisible(true);
        });
    }

    public Main() {
        super("Auto Test Runner — UI Mock (Java Swing)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 720));
        setLocationRelativeTo(null);

        countryServices.putAll(TestDataSeeder.seed());

        buildUI();
        loadAllTestsIntoTable(); // show everything by default
        updateSummary();
    }

    private static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
        } catch (Exception ignored) {}
    }

    private void buildUI() {
        JPanel root = new JPanel(new BorderLayout());
        root.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(root);

        // ===== Top toolbar =====
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setBorder(new EmptyBorder(6, 6, 6, 6));

        JButton btnRunSelected = makePrimaryButton("Run");
        JButton btnExportHtml  = new JButton("Export HTML");
        JButton btnExportExcel = new JButton("Export Excel");
        JButton btnClearLog    = new JButton("Clear Log");
        JButton btnReset       = new JButton("Reset Status");

        toolbar.add(btnRunSelected);
        toolbar.add(Box.createHorizontalStrut(8));
        toolbar.addSeparator();
        toolbar.add(btnExportHtml);
        toolbar.add(btnExportExcel);
        toolbar.addSeparator();
        toolbar.add(btnReset);
        toolbar.add(btnClearLog);

        root.add(toolbar, BorderLayout.NORTH);

        // ===== Left sidebar: JTree =====
        treeModel = new DefaultTreeModel(buildTreeNodes());
        tree = new JTree(treeModel);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.setBorder(new EmptyBorder(8, 8, 8, 8));
        tree.setRowHeight(26);
        tree.setCellRenderer(new ModernTreeRenderer());

        tree.addTreeSelectionListener(e -> onTreeSelectionChanged());

        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setBorder(BorderFactory.createTitledBorder("Countries & Services"));

        // ===== Center: table panel =====
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setBorder(new EmptyBorder(0, 10, 0, 0));

        JPanel header = new JPanel(new GridLayout(2, 1, 6, 6));
        selectionLabel.setBorder(new EmptyBorder(4, 6, 4, 6));
        summaryLabel.setBorder(new EmptyBorder(4, 6, 4, 6));
        header.add(selectionLabel);
        header.add(summaryLabel);

        centerPanel.add(header, BorderLayout.NORTH);

        table.setRowHeight(28);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getColumnModel().getColumn(2).setCellRenderer(new StatusPillRenderer());
        table.getColumnModel().getColumn(0).setPreferredWidth(140);
        table.getColumnModel().getColumn(1).setPreferredWidth(260);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);
        table.getColumnModel().getColumn(5).setPreferredWidth(420);

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Test Results"));
        centerPanel.add(tableScroll, BorderLayout.CENTER);

        // ===== Bottom: log console =====
        logArea.setEditable(false);
        logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane logScroll = new JScrollPane(logArea);
        logScroll.setBorder(BorderFactory.createTitledBorder("Execution Log"));

        JSplitPane centerSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, centerPanel, logScroll);
        centerSplit.setResizeWeight(0.68);
        centerSplit.setBorder(null);

        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, centerSplit);
        mainSplit.setResizeWeight(0.25);
        mainSplit.setBorder(null);

        root.add(mainSplit, BorderLayout.CENTER);

        // ===== Actions =====
        btnRunSelected.addActionListener(e -> runSelected());
        btnClearLog.addActionListener(e -> logArea.setText(""));
        btnReset.addActionListener(e -> {
            tableModel.resetStatuses();
            log("Reset all statuses to PENDING");
            updateSummary();
        });

        btnExportHtml.addActionListener(e -> {
            log("Export HTML: (mock) Generate a report.html from table data");
            JOptionPane.showMessageDialog(this,
                    "Mock export HTML done.\n(Replace with real exporter)",
                    "Export HTML",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnExportExcel.addActionListener(e -> {
            log("Export Excel: (mock) Generate a report.xlsx from table data");
            JOptionPane.showMessageDialog(this,
                    "Mock export Excel done.\n(Replace with real exporter)",
                    "Export Excel",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private JButton makePrimaryButton(String text) {
        JButton b = new JButton(text);
        b.setFont(b.getFont().deriveFont(Font.BOLD));
        b.setFocusPainted(false);
        return b;
    }

    private DefaultMutableTreeNode buildTreeNodes() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("ROOT");

        for (String country : countryServices.keySet()) {
            DefaultMutableTreeNode countryNode =
                    new DefaultMutableTreeNode(new NodeData(NodeType.COUNTRY, country, null));

            countryNode.add(new DefaultMutableTreeNode(new NodeData(NodeType.ACTION, "▶ Run Full Suite", country)));

            for (String service : countryServices.get(country)) {
                countryNode.add(new DefaultMutableTreeNode(new NodeData(NodeType.SERVICE, service, country)));
            }
            root.add(countryNode);
        }
        return root;
    }

    private void onTreeSelectionChanged() {
        TreePath path = tree.getSelectionPath();
        selectedCountry = null;
        selectedService = null;

        if (path == null) {
            selectionLabel.setText("Selection: (none)");
            return;
        }

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        Object userObject = node.getUserObject();
        if (!(userObject instanceof NodeData nd)) {
            selectionLabel.setText("Selection: (none)");
            return;
        }

        if (nd.type == NodeType.COUNTRY) {
            selectedCountry = nd.label;
            selectionLabel.setText("Selection: Country — " + selectedCountry);
            loadCountryIntoTable(selectedCountry);
        } else if (nd.type == NodeType.SERVICE) {
            selectedCountry = nd.country;
            selectedService = nd.label;
            selectionLabel.setText("Selection: " + selectedCountry + " → " + selectedService);
            loadServiceIntoTable(selectedCountry, selectedService);
        } else if (nd.type == NodeType.ACTION) {
            selectedCountry = nd.country;
            selectionLabel.setText("Selection: " + selectedCountry + " → Run Full Suite");
            loadCountryIntoTable(selectedCountry);
        }
        updateSummary();
    }

    private void loadAllTestsIntoTable() {
        List<TestRow> rows = new ArrayList<>();
        for (String country : countryServices.keySet()) {
            for (String service : countryServices.get(country)) {
                rows.add(TestRow.pending(country, service));
            }
        }
        tableModel.setRows(rows);
    }

    private void loadCountryIntoTable(String country) {
        List<TestRow> rows = new ArrayList<>();
        for (String service : countryServices.getOrDefault(country, List.of())) {
            rows.add(tableModel.getOrCreate(country, service));
        }
        tableModel.setRows(rows);
    }

    private void loadServiceIntoTable(String country, String service) {
        TestRow row = tableModel.getOrCreate(country, service);
        tableModel.setRows(List.of(row));
    }

    private void runSelected() {
        if (selectedCountry == null) {
            warn("Please select a country or service in the left panel.");
            return;
        }
        if (selectedService != null) {
            runTests(List.of(tableModel.getOrCreate(selectedCountry, selectedService)));
        } else {
            runTests(new ArrayList<>(tableModel.getRows()));
        }
    }

    private void runTests(List<TestRow> rows) {
        if (rows.isEmpty()) {
            warn("No tests to run.");
            return;
        }

        log("==============================================");
        log("Run started: " + now());
        log("Tests count: " + rows.size());

        SwingWorker<Void, TestUpdate> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (TestRow r : rows) {
                    TestTarget target = TestRegistry.find(r.country, r.service).orElse(null);
                    if (target == null) {
                        publish(new TestUpdate(r.country, r.service, Status.FAIL, 0, now(),
                                "No mapping found in TestRegistry"));
                        continue;
                    }

                    FlowReflectionRunner.RunResult result = FlowReflectionRunner.run(target);

                    if (result.passed()) {
                        publish(new TestUpdate(r.country, r.service, Status.PASS, result.durationMs(), now(), result.message()));
                    } else {
                        publish(new TestUpdate(r.country, r.service, Status.FAIL, result.durationMs(), now(), result.message()));
                        if (result.stacktrace() != null && !result.stacktrace().isBlank()) {
                            publish(new TestUpdate(r.country, r.service, Status.FAIL, result.durationMs(), now(), result.stacktrace()));
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(List<TestUpdate> chunks) {
                for (TestUpdate u : chunks) {
                    tableModel.applyUpdate(u);

                    boolean stack = looksLikeStacktrace(u.message);

                    if (u.status == Status.RUNNING) {
                        log("[RUN] " + u.country + " / " + u.service);
                    } else if (u.status == Status.PASS) {
                        log("[PASS] " + u.country + " / " + u.service + " (" + u.durationMs + "ms) - " + safe(u.message));
                    } else if (u.status == Status.FAIL && !stack) {
                        log("[FAIL] " + u.country + " / " + u.service + " (" + u.durationMs + "ms) - " + safe(u.message));
                    } else if (u.status == Status.FAIL && stack) {
                        log("[EXCEPTION] " + u.country + " / " + u.service + "\n" + u.message);
                    }
                }
                updateSummary();
            }

            @Override
            protected void done() {
                log("Run finished: " + now());
                log("==============================================");
                updateSummary();
            }
        };

        worker.execute();
    }

    private static String safe(String s) {
        return s == null ? "" : s;
    }

    private static boolean looksLikeStacktrace(String msg) {
        if (msg == null || msg.isBlank()) return false;
        return (msg.contains("\n") && (msg.contains("\n\tat ") || msg.contains("\n    at ")))
                || msg.contains("Exception")
                || msg.contains("AssertionError")
                || msg.contains("org.opentest4j");
    }

    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Notice", JOptionPane.WARNING_MESSAGE);
    }

    private void log(String msg) {
        logArea.append("[" + now() + "] " + msg + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void updateSummary() {
        int pass = 0, fail = 0, pending = 0, running = 0;
        for (TestRow r : tableModel.getRows()) {
            switch (r.status) {
                case PASS -> pass++;
                case FAIL -> fail++;
                case RUNNING -> running++;
                case PENDING -> pending++;
            }
        }
        summaryLabel.setText("Summary: PASS " + pass + " | FAIL " + fail + " | RUNNING " + running + " | PENDING " + pending);
    }
}