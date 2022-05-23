package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutos extends BaseTela{

    public FormularioDeAdicaoDeProdutos(WebDriver app){
        super(app);
    }
    public FormularioDeAdicaoDeProdutos preencherNomeProduto(String produtoNome){
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }
    public FormularioDeAdicaoDeProdutos preencherValorProduto(String produtoValor){
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }
    public FormularioDeAdicaoDeProdutos preencherCorProduto(String produtoCor){
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCor);
        return this;
    }
    public FormularioDeAdicaoDeProdutos submissaoComErro(){
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }
    public String obterMensagemDeErro() {
        return capturarToast();
    }
}