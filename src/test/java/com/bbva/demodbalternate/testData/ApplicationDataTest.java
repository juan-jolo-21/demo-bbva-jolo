package com.bbva.demodbalternate.testData;

import java.util.Arrays;
import java.util.List;

import com.bbva.demodbalternate.model.Application;
import com.bbva.demodbalternate.testData.PersonDataTest;

public class ApplicationDataTest {


    public PersonDataTest personDataTest = new PersonDataTest();

    public Application a1 = new Application();
    public Application a2 = new Application();
    public Application a3 = new Application();
    public Application a4 = new Application();
    public Application a5 = new Application();

    public List<Application> mockListApplications ;

    public ApplicationDataTest(){

        
        a1.setPerson(personDataTest.p1);
        a2.setPerson(personDataTest.p2);
        a3.setPerson(personDataTest.p3);
        a4.setPerson(personDataTest.p4);
        a5.setPerson(personDataTest.p5);

        a1.setId("ACC001");
        a2.setId("ACC002");
        a3.setId("ACC003");
        a4.setId("ACC004");
        a5.setId("ACC005");

        a1.setProduct_name("platinum");
        a2.setProduct_name("platinum");
        a3.setProduct_name("platinum");
        a4.setProduct_name("platinum");
        a5.setProduct_name("platinum");

        a1.setApproved_credit_limit(4000);
        a2.setApproved_credit_limit(4000);
        a3.setApproved_credit_limit(4000);
        a4.setApproved_credit_limit(4000);
        a5.setApproved_credit_limit(4000);

        a1.setCredit_state("normal");
        a2.setCredit_state("normal");
        a3.setCredit_state("normal");
        a4.setCredit_state("normal");
        a5.setCredit_state("normal");

        a1.setApplication_state("approved");
        a2.setApplication_state("approved");
        a3.setApplication_state("approved");
        a4.setApplication_state("approved");
        a5.setApplication_state("approved");

        mockListApplications = Arrays.asList(a1,a2,a3,a4,a5);
    }
}
