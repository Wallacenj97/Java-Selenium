package sistemadetestesProduto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestesProduto.pageObject.ProdutoPO;

/**
 * Classe de testes automatizados para a funcionalidade de Produto.
 * Essa classe contém testes para verificar o correto funcionamento das funcionalidades de cadastro de produtos.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
    private static ProdutoPO produtoPage;

    /**
     * Configuração inicial dos testes.
     * Inicializa a página de objeto (Page Object) do Produto e o WebDriver antes da execução dos testes.
     */
    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    /**
     * Teste de cadastro de produto com todos os campos preenchidos.
     * Verifica se um produto é cadastrado corretamente e se as informações aparecem na tabela de produtos.
     */
    @Test
    public void TC01_deveCadastrarProdutoComTodosOsCampos() {
        produtoPage.buttonCriar.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("0205", "Arroz", "1", "18,00", "02/07/2023");
        String texto = produtoPage.tabela.getText();
        assertTrue(texto.contains("0205"));
        assertTrue(texto.contains("Arroz"));
        assertTrue(texto.contains("1"));
        assertTrue(texto.contains("18,00"));
        assertTrue(texto.contains("2023-07-02"));
        //System.out.println(texto);
    }

    @Test
    public void TC002_naoDeveCadastrarProdutoComCodigoVazio() {
        //produtoPage.buttonSair.click(
        produtoPage.buttonCriar.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("", "Caixa de leite", "30", "3,00", "03/07/2023");
        assertEquals(produtoPage.mensagem.getText(), "Todos os campos são obrigatórios para o cadastro!");
    }
    
    @Test
    public void TC03_naoDeveCadastrarProdutoComCodigoMaiorQueQuatroCaracteres() {
        produtoPage.buttonCriar.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("12345", "Feijão", "2", "5,00", "05/07/2023");
        String mensagem = produtoPage.getMensagemErro();
        assertEquals("O código do produto deve conter no máximo 4 caracteres", mensagem);
     //   System.out.println(mensagem);
    }
    
    
	
		
}