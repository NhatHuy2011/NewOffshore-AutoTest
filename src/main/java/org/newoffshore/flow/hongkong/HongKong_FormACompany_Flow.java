package org.newoffshore.flow.hongkong;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.company_information.CompanyInformation;
import org.newoffshore.pages.apply.contact_information.ContactInformation;
import org.newoffshore.pages.apply.member_information.MemberInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.SpeakAndCheckout;
import org.newoffshore.pages.apply.service.hongkong.HongKong_FormACompany_Service;
import org.newoffshore.pages.apply.service.hongkong.HongKong_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class HongKong_FormACompany_Flow extends BaseFlow {

    protected void executeFlow() {
        //Contact Information
        ContactInformation contactInformationPage = new ContactInformation(driver);
        contactInformationPage.fillContactInformation();

        //Speak And Checkout
        SpeakAndCheckout speakAndCheckout = new SpeakAndCheckout(driver);
        speakAndCheckout.selectCheckOut();

        //Select Group Of Service
        HongKong_GroupOfService groupOfService = new HongKong_GroupOfService(driver);
        groupOfService.selectGroupFormACompany();

        //Select Service Detail
        HongKong_FormACompany_Service formACompanyService = new HongKong_FormACompany_Service(driver);
        formACompanyService.selectIncorp_Has_Accounting();

        //Select Payment Method
        PaymentInformation paymentInformation = new PaymentInformation(driver);
        paymentInformation.fillPaymentInformation();

        //Fill Company Information
        CompanyInformation companyInformation = new CompanyInformation(driver);
        companyInformation.fillCompanyInformation_HongKong();

        //Member Information
        MemberInformation memberInformation = new MemberInformation(driver);
        memberInformation.fillMemberInformation();
    }
}
