package task;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page.MenuListaDeFuncionalidadesPage;
import suporte.relatorio.Relatorio;
import suporte.relatorio.Screenshot;

public class ValidacaoListaDeFuncionalidadesTask {
    private WebDriver driver;
    MenuListaDeFuncionalidadesPage listaDeFuncionalidades;
    private ConsultaListaDeFuncionalidadesTask consultaListaDeFuncionalidadesTask;

    public ValidacaoListaDeFuncionalidadesTask(WebDriver driver) {
        this.driver = driver;
        listaDeFuncionalidades = new MenuListaDeFuncionalidadesPage(driver);
    }

    public void validaBtnFormularioListaDeFuncionalidades(){
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(true, listaDeFuncionalidades.getBtnFormulario().isDisplayed(), "Botão Formulário esta visível"),
                    () -> Assertions.assertEquals("Formulário", listaDeFuncionalidades.getBtnFormulario().getText(), "Botão esta com a descrição incorreta")
            );

            Relatorio.log(Status.PASS, "Acessando formulário", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Relatorio.log(Status.FAIL,"Não foi possivel acessar formulário", Screenshot.fullPageBase64(driver));
        }
    }

    public void validaBtnCriarUsuariosListaDeFuncionalidades(){
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(true, listaDeFuncionalidades.getBtnCriarUsuario().isDisplayed(), "Botão Criar Usuários esta visível"),
                    () -> Assertions.assertEquals("Criar Usuários", listaDeFuncionalidades.getBtnCriarUsuario().getText(), "Botão esta com a descrição incorreta")
            );

            Relatorio.log(Status.PASS, "Acessando formulário para criação de novos usuários", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Relatorio.log(Status.FAIL,"Não foi possivel acessar formulário para criação de novos usuários", Screenshot.fullPageBase64(driver));
        }
    }
}
