package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.hongkong.HongKong_MaintainCompany_Step5;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CompanyMaintain_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_CompanyRenewal_Flow extends BaseFlow {
    public void runCompanyRenewal(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
            hongKongGroupOfService.selectGroupCompanyMaintenance();

            HongKong_CompanyMaintain_Service companyMaintainServiceDetail = new HongKong_CompanyMaintain_Service(driver);
            companyMaintainServiceDetail.selectCompanyMaintain();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();

            HongKong_MaintainCompany_Step5 hongKongStep5 = new HongKong_MaintainCompany_Step5(driver);
            hongKongStep5.setHongKongMaintainCompanyStep5();
        } finally {
            tearDown();
        }
    }
}
