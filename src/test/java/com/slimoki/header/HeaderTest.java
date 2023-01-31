package com.slimoki.header;

public class HeaderTest extends HeaderPage{
    public void verifyIfAktualnosciLoaded(){
        HeaderPage headerPage = new HeaderPage();

        headerPage.clickOn("aktualnosci");
    }
}
