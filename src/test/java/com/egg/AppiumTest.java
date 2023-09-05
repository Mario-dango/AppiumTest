package com.egg;

import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;


public class AppiumTest extends BaseTest {

    private static DesiredCapabilities cap = new DesiredCapabilities();
    private static AndroidDriver<AndroidElement> driver = null;

    @BeforeAll
    public static void antesDeTodo() throws MalformedURLException{        
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        //  Ejercicio  2 agregar para accionar la calculadora
        // cap.setCapability("appPackage", "com.android.settings");
        // cap.setCapability("appActivity", ".Settings");        
        // cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", ".Calculator");     
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
    }

    @AfterEach
    public void luegoDeCadaUno(){
        driver.quit();
    }


    @Test
    @Tag("ParteUno")
    public void parteUno() {
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

    @Test
    @Tag("ParteDos")
    public void parteDos() {
        //  Ejercicio 7: Cambiar Orientación de Pantalla 
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.rotate(ScreenOrientation.PORTRAIT);
        
        //  Ejercicio 8: Verificar el Modo Avión
        if (driver.getConnection().isAirplaneModeEnabled()) {
            System.out.println("Está Activado");
            Assertions.assertTrue(driver.getConnection().isAirplaneModeEnabled(), "No verifica modo avion activado");
        } else {
            System.out.println("Está Desactivado");
            Assertions.assertFalse(driver.getConnection().isAirplaneModeEnabled(), "No verifica modo avion desactivado");
        }

        //  Ejercicio 9: Obtener Versión de Android
        String versionAdnroid = driver.getCapabilities().getCapability(MobileCapabilityType.PLATFORM_VERSION).toString();
        System.out.println(versionAdnroid);
        Assertions.assertEquals("5.1.1", versionAdnroid);


        //  Ejercicio 11: Cerrar y Relanzar la Aplicación
        driver.closeApp();
        
    }

    
    @Test
    @Tag("ParteDosSwipe")
    public void parteDosSwipe() {
        //  Ejercicio 10: Desplazarse Hacia Arriba en Pantalla
        int endX = 1300;
        int endY = 400;
        int startX = endX;
        int startY = 2000;
        // PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        // Sequence swipe = new Sequence(finger, 1);
        // swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
        //         PointerInput.Origin.viewport(), startX, startY));
        // swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // swipe.addAction(new WaitAction(WaitOptions.waitOptions(Duration.ofMillis(300))));
        // swipe.addAction(finger.createPointerMove(Duration.ofMillis(300),
        //         PointerInput.Origin.viewport(), endX, endY));
        // swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // // Ejecuta el deslizamiento
        // driver.perform(Arrays.asList(swipe));
    }
}
