package org.newoffshore.flow.singapore;

import org.newoffshore.constant.Constant;
import org.newoffshore.flow.BaseFlow;
import org.newoffshore.pages.apply.applicant_information.DependentPass_ApplicantInformation;
import org.newoffshore.pages.apply.applicant_information.EmploymentPass_ApplicantInformation;
import org.newoffshore.pages.apply.payment.PaymentInformation;
import org.newoffshore.pages.apply.service.singapore.Singapore_EmploymentPass_Service;
import org.newoffshore.pages.apply.service.singapore.Singapore_GroupOfService;
import org.newoffshore.utils.ConfigReader;

public class Singapore_EmploymentPass_Flow extends BaseFlow {
    public void runEmploymentPass(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupEmploymentPass();

            Singapore_EmploymentPass_Service singaporeEmploymentPassService = new Singapore_EmploymentPass_Service(driver);
            singaporeEmploymentPassService.selectEmploymentPass();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentInformation();

            EmploymentPass_ApplicantInformation employmentPassApplicantInformation = new EmploymentPass_ApplicantInformation(driver);
            employmentPassApplicantInformation.fillEmploymentPass();
        } finally {
            tearDown();
        }
    }

    public void runDependantPass(){
        try {
            setUp(ConfigReader.getUrl(), ConfigReader.getUrlOffer(Constant.SINGAPORE));

            //Select Group Of Service
            Singapore_GroupOfService singaporeGroupOfService = new Singapore_GroupOfService(driver);
            singaporeGroupOfService.selectGroupEmploymentPass();

            Singapore_EmploymentPass_Service singaporeEmploymentPassService = new Singapore_EmploymentPass_Service(driver);
            singaporeEmploymentPassService.selectDependantPass();

            //Select Payment Method
            PaymentInformation paymentInformation = new PaymentInformation(driver);
            paymentInformation.fillPaymentNotSelectMethod();

            DependentPass_ApplicantInformation dependentPassApplicantInformation = new DependentPass_ApplicantInformation(driver);
            dependentPassApplicantInformation.fillDependentPass();
        } finally {
            tearDown();
        }
    }
}
