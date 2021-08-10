package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.PageObjManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Context {

    static WebDriver driver;
    static PageObjManager pageObjectManager;
    static String servicePrice;
    static String serviceName;
    static String serviceStaffMember;
    static Properties pro;

    public static void initialize(){

        if(driver==null){
            try {
                pro = new Properties();
                pro.load(new FileInputStream(System.getProperty("user.dir")+ "/configuration/config.properties"));
            }
            catch(IOException e) {
                e.getStackTrace();
            }

             String os = System.getProperty("os.name").toLowerCase();
             String driverPath = os.equals("window") ? "driver/window/chromedriver" : "driver/mac/chromedriver";
             System.setProperty("webdriver.chrome.driver", driverPath);

             driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        if(pageObjectManager==null){
            pageObjectManager = new PageObjManager(driver);
        }
    }


    public static PageObjManager getPageObjManager(){
        return pageObjectManager;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static String getServicePrice() {
        return servicePrice;
    }

    public static void setServicePrice(String servicePrice) {
        Context.servicePrice = servicePrice;
    }

    public static String getServiceName() {
        return serviceName;
    }

    public static void setServiceName(String serviceName) {
        Context.serviceName = serviceName;
    }

    public static String getServiceStaffMember() {
        return serviceStaffMember;
    }

    public static void setServiceStaffMember(String name) {
        Context.serviceStaffMember = name;
    }

    public static String getProperty(String key){
        return pro.getProperty(key);
    }

}
