package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_BusinessBank_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_BusinessBank_Flow extends BaseFlow {
    public void runBusinessBank(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
            hongKongGroupOfService.selectGroupBusinessBank();

            HongKong_BusinessBank_Service businessBankServiceDetail = new HongKong_BusinessBank_Service(driver);
            businessBankServiceDetail.selectBusinessBank();

            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();
        } finally {
            tearDown();
        }
    }
}
