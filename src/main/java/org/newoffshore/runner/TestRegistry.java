package org.newoffshore.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class TestRegistry {
    private TestRegistry() {}

    public record TestId(String country, String service) {}

    private static final Map<TestId, TestTarget> MAP = new HashMap<>();

    static {
        // ===== Singapore =====
        MAP.put(new TestId("Singapore", "Form A Company"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_FormACompany_Flow",
                        "runFormACompany"));

        MAP.put(new TestId("Singapore", "Company Management Transfer"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_CompanyTransfer_Flow",
                        "runCompanyTransfer"));

        MAP.put(new TestId("Singapore", "Company Renewal"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_CompanyRenewal_Flow",
                        "runCompanyRenewal"));

        MAP.put(new TestId("Singapore", "Business Banking"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_BusinessBanking_Flow",
                        "runBusinessBank"));

        MAP.put(new TestId("Singapore", "Accounting Services"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_Accounting_Flow",
                        "runAccounting"));

        MAP.put(new TestId("Singapore", "Commercial Contract"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_CommercialContract_Flow",
                        "runCommercialContractTemplate",
                        "runCommercialContractCustom"));

        MAP.put(new TestId("Singapore", "Employment Pass"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_EmploymentPass_Flow",
                        "runEmploymentPass",
                        "runDependantPass"));

        MAP.put(new TestId("Singapore", "Nominee Directorship"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_NomineeService_Flow",
                        "runNomineeService"));

        // ===== HongKong =====
        MAP.put(new TestId("Hong Kong", "Form A Company"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_FormACompany_Flow",
                        "runFormACompany"));

        MAP.put(new TestId("Hong Kong", "Company Management Transfer"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_CompanyTransfer_Flow",
                        "runCompanyTransfer"));

        MAP.put(new TestId("Hong Kong", "Company Renewal"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_CompanyRenewal_Flow",
                        "runCompanyRenewal"));

        MAP.put(new TestId("Hong Kong", "Business Banking"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_BusinessBanking_Flow",
                        "runBusinessBank"));

        MAP.put(new TestId("Hong Kong", "Accounting Services"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_AccountingService_Flow",
                        "runAccountingService"));

        MAP.put(new TestId("Hong Kong", "Close Company"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_CloseCompany_Flow",
                        "runCloseCompany"));

        MAP.put(new TestId("Hong Kong", "Company Restoration"),
                TestTarget.of("org.newoffshore.flow.hongkong.HongKong_RestoreCompany_Flow",
                        "runRestoreCompany"));
    }

    public static Optional<TestTarget> find(String country, String service) {
        return Optional.ofNullable(MAP.get(new TestId(country, service)));
    }
}