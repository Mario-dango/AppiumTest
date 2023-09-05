package com.egg;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {
    
    private static DesiredCapabilities cap = new DesiredCapabilities();
    private static AndroidDriver<AndroidElement> driver = null;

    @BeforeAll
    public static void antesDeTodo() throws MalformedURLException{        
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        //  Ejercicio  2 agregar para accionar la calculadora
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", ".Calculator");        
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
    }

    @AfterEach
    public void luegoDeCadaUno(){
        driver.quit();
    }

}
