package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import paginas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Modulo de Produto")
public class ProdutoTest {
    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        //Abrir o App
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName", "Google Pixel 3");
        capacidades.setCapability("platform", "Android");
        capacidades.setCapability("udid", "192.168.195.103:5555"); //obtenha atraves do promptdeC(adb devices)
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "c:\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }
    @DisplayName("Validação do valor de Produto  não permitido")
    @Test
    public void  testValidacaodoProdutoNaoPermitido() {

        //Fazer Login
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Iphone")
                .preencherValorProduto("700001")
                .preencherCorProduto("Azul")
                .submissaoComErro()
                .obterMensagemDeErro();


        //Validar que a mensgem de valor inválido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }
    @AfterEach
    public void afterEach() {
        app.quit();
    }
}
