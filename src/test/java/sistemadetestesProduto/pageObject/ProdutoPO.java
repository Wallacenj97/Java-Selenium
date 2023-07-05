package sistemadetestesProduto.pageObject;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Esta classe representa a página de objeto (Page Object) para a funcionalidade de Produto.
 * Ela contém métodos para interagir com os elementos da página e realizar ações relacionadas aos produtos.
 */
public class ProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(className = "table")
    public WebElement tabela;

    @FindBy(id = "mensagem")
    public WebElement mensagem;

    /**
     * Construtor da classe ProdutoPO.
     *
     * @param driver O WebDriver usado para interagir com a página.
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Escreve um texto em um elemento de entrada (input) da página.
     *
     * @param input O elemento de entrada onde o texto será escrito.
     * @param texto O texto a ser escrito no elemento de entrada.
     */
    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    /**
     * Realiza um duplo clique no botão de criação de produto.
     * Isso pode ser usado para abrir um formulário de criação de produto, por exemplo.
     */
    public void duploClick() {
        buttonCriar.click();
        buttonCriar.click();
    }

    /**
     * Realiza o cadastro de um produto preenchendo os campos com os valores fornecidos.
     *
     * @param codigo     O código do produto.
     * @param nome       O nome do produto.
     * @param quantidade A quantidade do produto.
     * @param valor      O valor do produto.
     * @param data       A data do produto.
     */
    public void cadastrar(String codigo, String nome, String quantidade, String valor, String data) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        buttonSalvar.click();
        buttonSair.click();
    }

	@FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr/td[6]/button[2]")
	public WebElement buttonExcluir;
    
    public boolean confere(WebElement valor) {
		String valorDaLinha = valor.getText();
		if(valorDaLinha == "") {
			System.out.println("Produto excluído.");
			return true;
		} else {
			System.out.println("Falha ao excluir.");
			return false;
		}
	}
    
    
}