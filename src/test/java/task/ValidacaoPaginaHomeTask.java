package task;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import suporte.relatorio.Relatorio;
import suporte.relatorio.Screenshot;
import utilitarios.EsperaFixa;

public class ValidacaoPaginaHomeTask {
    private WebDriver driver;
    private HomePage home;

    public ValidacaoPaginaHomeTask(WebDriver driver) {
        this.driver = driver;
        home = new HomePage(driver);
    }

    public void validaCarregouElementosAutomacaoDeWebPaginaHome(){
        try {
            Assertions.assertAll(
                        () -> Assertions.assertEquals(true, home.getImgLogoPaginaWeb().isDisplayed(), "Logo não esta visível"),
                        () -> Assertions.assertEquals(true, home.getHeaderAutomacaoWeb().isDisplayed(), "Header não esta visível"),
                        () -> Assertions.assertEquals(true, home.getDescricaoAutomacaoWeb().isDisplayed(), "Descrição não esta visível"),
                        () -> Assertions.assertEquals(true, home.getBtnAutomacaoWeb().isDisplayed(), "Botão automação de web não esta visível")
                );

            Relatorio.log(Status.PASS, "Carregou informações automação de web página home", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Relatorio.log(Status.FAIL,"Não carregou informações automação de web página de home", Screenshot.fullPageBase64(driver));
        }
    }

    public void validaInformacoesPaginaHome(){
        try{
            Assertions.assertAll(
                    () -> Assertions.assertEquals("Automação de Web", home.getHeaderAutomacaoWeb().getText(), "Texto header incorreto"),
                    () -> Assertions.assertEquals("Um site feito em materialize e rails com diversos tipos de funcionalidades para fazer automação.",
                            home.getDescricaoAutomacaoWeb().getText(), "Texto descrição incorreto"),
                    () -> Assertions.assertEquals("COMEÇAR AUTOMAÇÃO WEB", home.getBtnAutomacaoWeb().getText(), "Texto botão automação de web incorreto")
            );

            Relatorio.log(Status.PASS, "Carregou a página Home", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Relatorio.log(Status.FAIL,"Não carregou página de Home", Screenshot.fullPageBase64(driver));
        }
    }
}
