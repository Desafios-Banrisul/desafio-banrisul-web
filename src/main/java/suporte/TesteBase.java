package suporte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import suporte.relatorio.Relatorio;
import utilitarios.FileOperations;

public class TesteBase extends GerenciadorDriver {
    private static WebDriver driver;
    private String URL = FileOperations.getPropriedade("url").getProperty("url");

    public WebDriver getDriver(){
        driver = getDriver(TipoDriver.CHROME);
        return driver;
    }

    @BeforeEach
    public void iniciar(){
        getDriver().get(URL);
    }

    @AfterEach
    public void encerarDriver(){
        encerrarDrive();
        Relatorio.close();
    }
}

