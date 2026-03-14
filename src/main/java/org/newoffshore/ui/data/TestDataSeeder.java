package org.newoffshore.ui.data;

import java.util.*;

public final class TestDataSeeder {
    private TestDataSeeder() {}

    public static Map<String, List<String>> seed() {
        Map<String, List<String>> countryServices = new LinkedHashMap<>();

        countryServices.put("Singapore", Arrays.asList(
                "Form A Company", "Company Management Transfer", "Company Renewal", "Nominee Directorship",
                "Accounting Services", "Employment Pass", "Commercial Contract", "Business Banking"
        ));
        countryServices.put("Hong Kong", Arrays.asList(
                "Form A Company", "Company Management Transfer", "Company Renewal", "Company Restoration",
                "Accounting Services", "Business Banking", "Close Company"
        ));
        countryServices.put("USA", Arrays.asList(
                "Form A Company (LLC)", "Company Management Transfer", "Company Renewal", "Accounting Services",
                "Close your US LLC Delaware", "Revive your US LLC Delaware", "Business Banking", "Conversion of other US LLC to Delaware"
        ));
        countryServices.put("BVI", Arrays.asList(
                "Form A Company (IBC)", "Company Management Transfer", "Nominee Services", "Company Renewal",
                "Close your company/ Dissolution", "Restore your company", "Shelf Company Purchase", "Business Banking", "Continuation/Discontinuation Service"
        ));
        countryServices.put("Panama", Arrays.asList(
                "Form A Company", "Company Management Transfer", "Nominee Services", "Company Renewal",
                "Close your company/ Dissolution", "Restore your company", "Business Banking"
        ));

        return countryServices;
    }
}