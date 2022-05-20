package test;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import suporte.TesteBase;
import suporte.relatorio.Relatorio;
import suporte.relatorio.Screenshot;
import suporte.relatorio.TipoRelatorio;
import task.*;
import utilitarios.EsperaFixa;

public class CriarNovoUsuario extends TesteBase {
    private final WebDriver driver = this.getDriver();
   ConsultaPaginaHomeTask consultaPaginaHomeTask = new ConsultaPaginaHomeTask(driver);
    ConsultaListaDeFuncionalidadesTask consultaListaDeFuncionalidadesTask = new ConsultaListaDeFuncionalidadesTask(driver);
    ConsultaCriarNovoUsuarioTask consultaCriarNovoUsuario = new ConsultaCriarNovoUsuarioTask(driver);
    ConsultaDetalhesDadosUsuarioTask consultaDetalhesDadosUsuarioTask = new ConsultaDetalhesDadosUsuarioTask(driver);

    @Test
    public void realizarCadastroNovoUsuario() {
        try {
            Relatorio.criaTeste("Realizar Cadastro de Usuário com Sucesso" , TipoRelatorio.SINGLE);
            consultaPaginaHomeTask.iniciarAutomacaoWeb();
            consultaListaDeFuncionalidadesTask.abrirFormularioParaCadastrarNovoUsuario();
            consultaCriarNovoUsuario.preencherFormularioCadastroNovoUsuario();
            consultaCriarNovoUsuario.clicarBtnCriarNovoUsuario();
            EsperaFixa.esperaEmSegundos(5);
            consultaDetalhesDadosUsuarioTask.validarCadastroRealizadoComSucesso();
        }catch (Exception e){
            Relatorio.log(Status.ERROR, e.getMessage(), Screenshot.fullPageBase64(driver));
        }
    }
}
