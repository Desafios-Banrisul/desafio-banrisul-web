package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitarios.Esperas;

public class HomePage {
    private WebDriver driver;
    private Esperas espera;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(driver);
    }

    public WebElement getImgLogoPaginaWeb() {
        return espera.visibilidadeDoElemento(By.cssSelector("body > nav > div > img"));
    }

    public WebElement getHeaderAutomacaoWeb() {
        return espera.visibilidadeDoElemento(By.cssSelector("#index-banner > div > div:nth-child(1) > div > h4"));
    }

    public WebElement getDescricaoAutomacaoWeb() {
        return espera.visibilidadeDoElemento(By.cssSelector("#index-banner > div > div:nth-child(2) > p > font"));
    }

    public WebElement getBtnAutomacaoWeb(){
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"index-banner\"]/div/div[3]/a"));
    }
}
