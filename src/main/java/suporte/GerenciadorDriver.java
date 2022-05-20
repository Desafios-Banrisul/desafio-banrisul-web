package suporte;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class GerenciadorDriver {
    private static WebDriver driver;

    private static WebDriver getGerenciadorDriver (TipoDriver navegador){

        switch (navegador){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opcoesChrome = new ChromeOptions();
                opcoesChrome.addArguments("--start-maximized");
                driver = new ChromeDriver(opcoesChrome);
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions opcoesFirefox = new FirefoxOptions();
                opcoesFirefox.addArguments("--incognito");
                driver = new FirefoxDriver(opcoesFirefox);
                break;

            case HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions headless = new ChromeOptions();
                headless.addArguments("--headless");
                driver = new ChromeDriver(headless);
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                MutableCapabilities capacidades = new MutableCapabilities();
                capacidades.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
                capacidades.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
                driver = new InternetExplorerDriver();
                break;

            default:
                break;
        }
        return driver;
    }

    public static WebDriver getDriver(TipoDriver navegador){
        if(driver == null){
            driver = getGerenciadorDriver(navegador);
        }
        return driver;
    }

    public static void encerrarDrive(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
