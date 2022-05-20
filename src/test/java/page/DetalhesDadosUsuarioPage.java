package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitarios.Esperas;

public class DetalhesDadosUsuarioPage {
    private WebDriver driver;
    private Esperas espera;

    public DetalhesDadosUsuarioPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(driver);
    }

    public WebElement getMensagemUsuarioCriadoComSucesso() {
        return espera.visibilidadeDoElemento(By.cssSelector("#notice"));
    }

    public WebElement getIndexDadosCadastradosDoUsuario(int index) {
        return espera.visibilidadeDoElemento(By.xpath("/html/body/div[2]/div[2]/div[3]/div/p[" + index + "]"));
    }
}
