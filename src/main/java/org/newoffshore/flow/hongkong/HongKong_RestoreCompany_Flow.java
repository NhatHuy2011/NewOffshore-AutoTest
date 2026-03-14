package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.hongkong.HongKong_RestoreCompany_Step5;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CompanyRestoration_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_RestoreCompany_Flow extends BaseFlow {
    public void runRestoreCompany(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
            hongKongGroupOfService.selectGroupCompanyRestoration();

            HongKong_CompanyRestoration_Service companyRestorationServiceDetail = new HongKong_CompanyRestoration_Service(driver);
            companyRestorationServiceDetail.selectCompanyRestoration();

            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentNotSelectMethod();

            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();

            HongKong_RestoreCompany_Step5 hongKongRestoreStep5 = new HongKong_RestoreCompany_Step5(driver);
            hongKongRestoreStep5.setHongKongRestoreCompany();
        } finally {
            tearDown();
        }
    }
}
