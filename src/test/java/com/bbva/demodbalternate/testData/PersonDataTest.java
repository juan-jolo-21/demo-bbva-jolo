package com.bbva.demodbalternate.testData;

import com.bbva.demodbalternate.model.Person;

public class PersonDataTest {

    public Person p1 = new Person();
    public Person p2 = new Person();
    public Person p3 = new Person();
    public Person p4 = new Person();
    public Person p5 = new Person();

    public PersonDataTest() {
        p1.setName_person("Andres");
        p2.setName_person("Eduardo");
        p3.setName_person("Javier");
        p4.setName_person("Leandro");
        p5.setName_person("Javier");

        p1.setLast_name_person("Sanchez");
        p2.setLast_name_person("Lujan");
        p3.setLast_name_person("Alva");
        p4.setLast_name_person("Matamoros");
        p5.setLast_name_person("Paredes");

        p1.setDni("77411201");
        p2.setDni("77411202");
        p3.setDni("77411203");
        p4.setDni("77411204");
        p5.setDni("77411205");
    }

    
}
