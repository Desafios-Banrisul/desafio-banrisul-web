package task;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import page.FormularioCriaNovoUsuarioPage;
import utilitarios.FileOperations;

import java.io.IOException;
import java.util.Locale;

public class ConsultaCriarNovoUsuarioTask {
    private WebDriver driver;
    private FormularioCriaNovoUsuarioPage formularioCriaNovoUsuario;
    private ValidacaoCriarUsuarioTask validacaoCriarUsuario;
    FileOperations file = new FileOperations();
    Faker faker = new Faker(new Locale("pt-BR"));

    public ConsultaCriarNovoUsuarioTask(WebDriver driver) {
        this.driver = driver;
        formularioCriaNovoUsuario = new FormularioCriaNovoUsuarioPage(driver);
        validacaoCriarUsuario = new ValidacaoCriarUsuarioTask(driver);
    }

    public void preencherFormularioCadastroNovoUsuario() throws IOException {
        String nome = faker.address().firstName();
        String ultimoNome = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String endereco = faker.address().streetAddress();
        String universidade = faker.university().name();
        String profissao = faker.company().profession();

        addDadoCSV("nome", nome);
        addDadoCSV("ultimoNome", ultimoNome);
        addDadoCSV("email", email);
        addDadoCSV("endereco", endereco);
        addDadoCSV("universidade", universidade);
        addDadoCSV("profissao", profissao);

        validacaoCriarUsuario.validaFormularioCriarUsuario();
        formularioCriaNovoUsuario.getInputNome().sendKeys(nome);
        formularioCriaNovoUsuario.getInputUltimoNome().sendKeys(ultimoNome);
        formularioCriaNovoUsuario.getInputEmail().sendKeys(email);
        formularioCriaNovoUsuario.getInputEndereco().sendKeys(endereco);
        formularioCriaNovoUsuario.getInputUniversidade().sendKeys(universidade);
        formularioCriaNovoUsuario.getInputProfissao().sendKeys(profissao);
        validacaoCriarUsuario.validaEmail();
    }

    public void clicarBtnCriarNovoUsuario(){
        formularioCriaNovoUsuario.getBtnCriarUsuario().click();
    }

    public void addDadoCSV(String key, String valor) throws IOException {
        file.setPropriedade("csv", key, valor);
    }
}
