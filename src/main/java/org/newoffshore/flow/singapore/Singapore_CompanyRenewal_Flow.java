package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.singapore.Singapore_MaintainCompany_Step5;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_CompanyMaintenance_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_CompanyRenewal_Flow extends BaseFlow {
    public void runCompanyRenewal(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupCompanyMaintenance();

            Singapore_CompanyMaintenance_Service companyMaintenanceServiceDetail = new Singapore_CompanyMaintenance_Service(driver);
            companyMaintenanceServiceDetail.selectMaintain_For_Local_NoAccounting();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Select Company
            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext("The One Digi Singapore");

            //Fill Company Info
            Singapore_MaintainCompany_Step5 maintainCompanyCompanyInfo = new Singapore_MaintainCompany_Step5(driver);
            maintainCompanyCompanyInfo.setSingaporeMaintainCompanyStep5();
        } finally {
            tearDown();
        }
    }
}
