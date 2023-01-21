package StepDefinitaions;

import Utilities.GenWebDr;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void before(){
        System.out.println("Senaryo basladi");
    }

    @After
    public void after(){
        System.out.println("Senaryo bitti");
        GenWebDr.quitDriver();
    }
}
