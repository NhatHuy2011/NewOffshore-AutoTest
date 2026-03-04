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
                        "run"));

        MAP.put(new TestId("Singapore", "Company Management Transfer"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_CompanyManagementTransfer_Test",
                        "selectTransfer_For_Local_HasAccounting"));

        MAP.put(new TestId("Singapore", "Company Renewal"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_MaintainCompanyCompany_Test",
                        "selectMaintain_For_Local_NoAccounting"));

        MAP.put(new TestId("Singapore", "Business Banking"),
                TestTarget.of("org.newoffshore.flow.singapore.Singapore_BusinessBanking_Flow",
                        "run"));

        MAP.put(new TestId("Singapore", "Accounting Services"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_AccountingService_Test",
                        "selectAccouting"));

        MAP.put(new TestId("Singapore", "Commercial Contract"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_CommercialContract_Test",
                        "selectCommercialContract_Custom",
                        "selectCommercialContract_Templates"));

        MAP.put(new TestId("Singapore", "Employment Pass"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_EmploymentPass_Test",
                        "selectEmploymentPass",
                        "selectDependentPass"));

        MAP.put(new TestId("Singapore", "Nominee Directorship"),
                TestTarget.of("org.newoffshore.test.apply.singapore.Singapore_NomineeService_Test",
                        "selectNomineeDirectorship"));
    }

    public static Optional<TestTarget> find(String country, String service) {
        return Optional.ofNullable(MAP.get(new TestId(country, service)));
    }
}