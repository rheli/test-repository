package com.slimoki.header;

import com.slimoki.body.BodyTest;
import org.slf4j.LoggerFactory;

public class HeaderTest extends HeaderPage{

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HeaderTest.class);

    public void verifyIfAktualnosciLoaded(){
        HeaderPage headerPage = new HeaderPage();

        headerPage.clickOn("aktualnosci");
    }
}
