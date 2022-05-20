package task;

import org.openqa.selenium.WebDriver;

public class ConsultaDetalhesDadosUsuarioTask {
    private WebDriver driver;
    private ValidacaoDetalhesDadosUsuarioTask validacaoDetalhesDadosUsuarioTask;

    public ConsultaDetalhesDadosUsuarioTask(WebDriver driver) {
        this.driver = driver;
       validacaoDetalhesDadosUsuarioTask = new ValidacaoDetalhesDadosUsuarioTask(driver);
    }

    public void validarCadastroRealizadoComSucesso(){
        validacaoDetalhesDadosUsuarioTask.validaMensagemUsuarioCriadoComSucesso();
        validacaoDetalhesDadosUsuarioTask.validaDadosCadastradosDoUsuario();
    }
}
