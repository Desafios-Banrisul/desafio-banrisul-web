package task;

import org.openqa.selenium.WebDriver;
import page.HomePage;

public class ConsultaPaginaHomeTask {
    private WebDriver driver;
    private HomePage home;
    private ValidacaoPaginaHomeTask validacaoPaginaHomeTask;

    public ConsultaPaginaHomeTask(WebDriver driver) {
        this.driver = driver;
        home = new HomePage(driver);
        validacaoPaginaHomeTask = new ValidacaoPaginaHomeTask(driver);
    }

    public void clicarBtnComecarAutomacaoWeb(){
        home.getBtnAutomacaoWeb().click();
    }

    public void iniciarAutomacaoWeb(){
        validacaoPaginaHomeTask.validaCarregouElementosAutomacaoDeWebPaginaHome();
        validacaoPaginaHomeTask.validaInformacoesPaginaHome();
        clicarBtnComecarAutomacaoWeb();
    }
}
