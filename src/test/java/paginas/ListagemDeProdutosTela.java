package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListagemDeProdutosTela extends BaseTela{

    public ListagemDeProdutosTela(WebDriver app){
        super(app);
    }
    public FormularioDeAdicaoDeProdutos abrirTelaAdicaoProduto() {
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioDeAdicaoDeProdutos(app);
    }

}
