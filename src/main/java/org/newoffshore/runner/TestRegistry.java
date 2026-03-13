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
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_CompanyManagementTransfer_Test",
                        "runCompanyTransfer"));

        MAP.put(new TestId("Singapore", "Company Renewal"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_MaintainCompanyCompany_Test",
                        "runCompanyRenewal"));

        MAP.put(new TestId("Singapore", "Business Banking"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_BusinessBanking_Flow",
                        "runBusinessBank"));

        MAP.put(new TestId("Singapore", "Accounting Services"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_AccountingService_Test",
                        "runAccounting"));

        MAP.put(new TestId("Singapore", "Commercial Contract"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_CommercialContract_Test",
                        "runCommercialContractTemplate",
                        "runCommercialContractCustom"));

        MAP.put(new TestId("Singapore", "Employment Pass"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_EmploymentPass_Test",
                        "runEmploymentPass",
                        "runDependantPass"));

        MAP.put(new TestId("Singapore", "Nominee Directorship"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_NomineeService_Test",
                        "runNomineeService"));
    }

    public static Optional<TestTarget> find(String country, String service) {
        return Optional.ofNullable(MAP.get(new TestId(country, service)));
    }
}