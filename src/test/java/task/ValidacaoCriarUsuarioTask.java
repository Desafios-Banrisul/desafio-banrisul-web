package task;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page.FormularioCriaNovoUsuarioPage;
import suporte.relatorio.Relatorio;
import suporte.relatorio.Screenshot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoCriarUsuarioTask {
    private WebDriver driver;
    private FormularioCriaNovoUsuarioPage formularioCriaNovoUsuario;

    public ValidacaoCriarUsuarioTask(WebDriver driver) {
        this.driver = driver;
        formularioCriaNovoUsuario = new FormularioCriaNovoUsuarioPage(driver);
    }

    public void validaFormularioCriarUsuario(){
        try {
            Assertions.assertAll(
                    () -> Assertions.assertEquals("Novo Usuário!!", formularioCriaNovoUsuario.getHeaderNovoUsuario().getText(), "Descrição do formulário esta incorreta"),
                    () -> Assertions.assertEquals("Nome *", formularioCriaNovoUsuario.getLabelNome().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Último nome *", formularioCriaNovoUsuario.getLabelUltimoNome().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Email *", formularioCriaNovoUsuario.getLabelEmail().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Endereço", formularioCriaNovoUsuario.getLabelEndereco().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Universidade", formularioCriaNovoUsuario.getLabelUniversidade().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Profissão", formularioCriaNovoUsuario.getLabelProfissao().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Gênero", formularioCriaNovoUsuario.getLabelGenero().getText(), "Descrição esta incorreta"),
                    () -> Assertions.assertEquals("Idade", formularioCriaNovoUsuario.getLabelIdade().getText(), "Descrição esta incorreta")
            );

            Relatorio.log(Status.PASS, "Descrição dos campos esta correta", Screenshot.fullPageBase64(driver));
        }catch (Error | Exception e){
            Relatorio.log(Status.FAIL, "Descrição dos campos esta incorreta", Screenshot.fullPageBase64(driver));
        }
    }

    public void validaEmail(){
        try {
            Assertions.assertEquals(true, isEmailValido(formularioCriaNovoUsuario.getInputEmail().getAttribute("value")));
            Relatorio.log(Status.PASS, "Email válido", Screenshot.fullPageBase64(driver));
        }catch (Error | Exception e){
            Relatorio.log(Status.FAIL, "Email inválido", Screenshot.fullPageBase64(driver));
        }
    }

    public static boolean isEmailValido(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher matcher = p.matcher(email);
        return matcher.matches();
    }
}

