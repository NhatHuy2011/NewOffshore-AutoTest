package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.CompanyDocument;
import org.newoffshore.pages.apply.company_information.SelectCompany;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_Accounting_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_AccountingService_Flow extends BaseFlow {
    public void runAccountingService(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService hongKongGroupOfService = new HongKong_GroupOfService(driver);
            hongKongGroupOfService.selectGroupAccounting();

            HongKong_Accounting_Service accountingServiceDetail = new HongKong_Accounting_Service(driver);
            accountingServiceDetail.selectAccounting();

            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            SelectCompany selectCompany = new SelectCompany(driver);
            selectCompany.selectCompanyAndNext();

            CompanyDocument companyDocument = new CompanyDocument(driver);
            companyDocument.fillCompanyDocumentAndNext();
        } finally {
            tearDown();
        }
    }
}
