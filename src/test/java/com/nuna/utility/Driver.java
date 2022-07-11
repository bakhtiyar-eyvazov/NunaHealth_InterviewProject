package com.nuna.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    private Driver(){ }


    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser") ;

        if(driverPool.get() == null){

            switch (browserName ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driverPool.set( new ChromeDriver() );
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                default:
                    driverPool.set( null );
                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
            }
            return driverPool.get() ;



        }else{
            return driverPool.get() ;

        }

    }


    public static void closeBrowser(){

        if(driverPool.get() != null ){
            driverPool.get().quit();
            driverPool.set( null );
        }
    }


}
