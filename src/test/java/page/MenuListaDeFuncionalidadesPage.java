package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitarios.Esperas;

public class MenuListaDeFuncionalidadesPage {
    private WebDriver driver;
    private Esperas espera;

    public MenuListaDeFuncionalidadesPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(driver);
    }

    public WebElement getBtnFormulario() {
        return espera.visibilidadeDoElemento(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/a"));
    }

    public WebElement getBtnCriarUsuario() {
        return espera.visibilidadeDoElemento(By.xpath("/html/body/div[2]/div[1]/ul/li[1]/div/ul/li[1]/a"));
    }
}