package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.CompanyInformation;
import org.newoffshore.pages.apply.member_information.MemberInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.hongkong.HongKong_CompanyManagementTransfer_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_CompanyTransfer_Flow extends BaseFlow {
    public void runCompanyTransfer(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.HONGKONG));

            //Select Group Of Service
            HongKong_GroupOfService groupOfService = new HongKong_GroupOfService(driver);
            groupOfService.selectGroupCompanyManagementTransfer();

            //Select Service Detail
            HongKong_CompanyManagementTransfer_Service transferService = new HongKong_CompanyManagementTransfer_Service(driver);
            transferService.selectCompanyManagementTransfer_Has_Accounting();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            //Fill Company Information
            CompanyInformation companyInformation = new CompanyInformation(driver);
            companyInformation.fillCompanyInformation_HongKong();

            //Member Information
            MemberInformation memberInformation = new MemberInformation(driver);
            memberInformation.fillMemberInformation();
        }finally {
            tearDown();
        }
    }
}
