package task;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page.DetalhesDadosUsuarioPage;
import suporte.relatorio.Relatorio;
import suporte.relatorio.Screenshot;
import utilitarios.FileOperations;


public class ValidacaoDetalhesDadosUsuarioTask {
    private WebDriver driver;
    private DetalhesDadosUsuarioPage detalhesDadosUsuarioPage;

    public ValidacaoDetalhesDadosUsuarioTask(WebDriver driver) {
        this.driver = driver;
        detalhesDadosUsuarioPage = new DetalhesDadosUsuarioPage(driver);
    }

    public void validaDadosCadastradosDoUsuario(){
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("nome"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(1).getText())),

                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("ultimoNome"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(2).getText())),

                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("email"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(3).getText())),

                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("universidade"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(4).getText())),

                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("profissao"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(6).getText())),

                    () -> Assertions.assertEquals(FileOperations.getPropriedade("csv").getProperty("endereco"),
                            obterInformacaoFormatada(detalhesDadosUsuarioPage.getIndexDadosCadastradosDoUsuario(8).getText()))
            );

            Relatorio.log(Status.PASS, "Dados cadastrados com sucesso", Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            Relatorio.log(Status.FAIL,"Dados não foram cadastrados", Screenshot.fullPageBase64(driver));
        }
    }

    public void validaMensagemUsuarioCriadoComSucesso() {
        try {
            Assertions.assertEquals("Usuário Criado com sucesso",
                    detalhesDadosUsuarioPage.getMensagemUsuarioCriadoComSucesso().getText());

            Relatorio.log(Status.PASS, "Mensagem esta correta", Screenshot.fullPageBase64(driver));
        } catch (Exception e) {
            Relatorio.log(Status.FAIL, "Mensagem não esta correta", Screenshot.fullPageBase64(driver));
        }
    }

    public String obterInformacaoFormatada(String dado){
        String[] newDado = dado.split(": ");
        return newDado[1];
    }
}
