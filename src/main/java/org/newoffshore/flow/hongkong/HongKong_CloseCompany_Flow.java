package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.company_information.order_addons.hongkong.HongKong_CloseCompany_Step5;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CloseCompany_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_CloseCompany_Flow extends BaseFlow {
    public void runCloseCompany() throws InterruptedException{
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
            hongKongGroupOfService.selectGroupCloseCompany();

            HongKong_CloseCompany_Service closeCompanyServiceDetail = new HongKong_CloseCompany_Service(driver);
            closeCompanyServiceDetail.selectCloseCompany();

            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentNotSelectMethod();

            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();

            HongKong_CloseCompany_Step5 hongkongAccountingStep5 = new HongKong_CloseCompany_Step5(driver);
            hongkongAccountingStep5.selectHongKongAccountingServiceStep5();
        } finally {
            tearDown();
        }
    }
}
