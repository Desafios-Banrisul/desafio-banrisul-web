package task;

import org.openqa.selenium.WebDriver;
import page.MenuListaDeFuncionalidadesPage;

public class ConsultaListaDeFuncionalidadesTask {
    private WebDriver driver;
    private MenuListaDeFuncionalidadesPage listaDeFuncionalidades;
    private ValidacaoListaDeFuncionalidadesTask validacaoListaDeFuncionalidadesTask;

    public ConsultaListaDeFuncionalidadesTask(WebDriver driver) {
        this.driver = driver;
        listaDeFuncionalidades = new MenuListaDeFuncionalidadesPage(driver);
        validacaoListaDeFuncionalidadesTask = new ValidacaoListaDeFuncionalidadesTask(driver);
    }

    public void abrirFormularioParaCadastrarNovoUsuario(){
        validacaoListaDeFuncionalidadesTask.validaBtnFormularioListaDeFuncionalidades();
        clicarBtnOpcaoDeFuncionalidades();
        validacaoListaDeFuncionalidadesTask.validaBtnCriarUsuariosListaDeFuncionalidades();
        clicarBtnSubItemOpcaoDeFuncionalidadesCriarUsuario();
    }

    public void clicarBtnOpcaoDeFuncionalidades(){
        listaDeFuncionalidades.getBtnFormulario().click();
    }

    public void clicarBtnSubItemOpcaoDeFuncionalidadesCriarUsuario(){
        listaDeFuncionalidades.getBtnCriarUsuario().click();
    }
}
