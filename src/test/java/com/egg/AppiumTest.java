package com.egg;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    @Test
    public void bawy() throws MalformedURLException {
        
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        //  Ejercicio  2 agregar para accionar la calculadora
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", ".Calculator");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
        System.out.println(driver.getDeviceTime());

        //  Ejercicio 3 en adelante (interaccción con el dispositivo)
        driver.findElementById("com.android.calculator2:id/digit_2").click();
        driver.findElementById("com.android.calculator2:id/op_add").click();
        driver.findElementById("com.android.calculator2:id/digit_3").click();
        driver.findElementById("com.android.calculator2:id/eq").click();

        String resultado = driver.findElementById("com.android.calculator2:id/result").getText();
        System.out.println("El resultado es: " + resultado);

        //  Ejercicio 4 (Orientación de pantalla)
        System.out.println("La orientación es: ");
        System.out.println(driver.getOrientation());
        
        //  Ejercicio 5 (estado de conección a internet)
        System.out.println("Resultado de conexión a internet: ");
        System.out.println(driver.getSessionDetails());

        //  Ejercicio 6 ()
        System.out.println("El nombre es: ");
        System.out.println(driver.getAutomationName());
        
    }
}
