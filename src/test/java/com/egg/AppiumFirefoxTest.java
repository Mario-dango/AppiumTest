package com.egg;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFirefoxTest {

    @Test
    public void asdasd() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Configuración para Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Cambiar a nombre de tu dispositivo
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // // Inicializa la conexión con el dispositivo a través de USB
        // capabilities.setCapability(MobileCapabilityType.UDID, "udid_del_dispositivo"); // Cambiar a UDID de tu dispositivo

        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://localhost:4723");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        AppiumDriver<MobileElement> driver = new AndroidDriver<>(appiumServerURL, capabilities);

        // Abre una URL en el navegador Firefox
        driver.get("https://www.wikipedia.org");

        // Realiza alguna interacción adicional, como hacer clic en enlaces o buscar información
        // ...

        // Cierra la sesión
        driver.quit();
    }
}
