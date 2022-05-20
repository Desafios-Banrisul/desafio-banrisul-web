package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitarios.Esperas;

public class FormularioCriaNovoUsuarioPage {
    private WebDriver driver;
    private Esperas espera;

    public FormularioCriaNovoUsuarioPage(WebDriver driver) {
        this.driver = driver;
        espera = new Esperas(driver);
    }

    public WebElement getHeaderNovoUsuario() {
        return espera.visibilidadeDoElemento(By.xpath("/html/body/div[2]/div[2]/div[2]/div/h5"));
    }

    public WebElement getLabelNome() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[1]/div[1]/div/label"));
    }

    public WebElement getInputNome() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_name"));
    }

    public WebElement getLabelUltimoNome() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[1]/div[2]/div/label"));
    }

    public WebElement getInputUltimoNome() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_lastname"));
    }

    public WebElement getLabelEmail() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[2]/div[1]/div/label"));
    }

    public WebElement getInputEmail() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_email"));
    }

    public WebElement getLabelEndereco() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[2]/div[2]/div/label"));
    }

    public WebElement getInputEndereco() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_address"));
    }

    public WebElement getLabelUniversidade() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[3]/div[1]/div/label"));
    }

    public WebElement getInputUniversidade() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_university"));
    }

    public WebElement getLabelProfissao() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[3]/div[2]/div/label"));
    }

    public WebElement getInputProfissao() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_profile"));
    }

    public WebElement getLabelGenero(){
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[4]/div[1]/div/label"));
    }

    public WebElement getInputGenero() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_gender"));
    }

    public WebElement getLabelIdade() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[4]/div[2]/div/label"));
    }

    public WebElement getInputIdade() {
        return espera.visibilidadeDoElemento(By.cssSelector("#user_age"));
    }

    public WebElement getBtnCriarUsuario() {
        return espera.visibilidadeDoElemento(By.xpath("//*[@id=\"new_user\"]/div[5]/div/div/input"));
    }
}
