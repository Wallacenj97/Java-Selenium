package sistemadetestesProduto.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    //  System.out.println(texto);
    }

    @Test
    public void TC02_naoDeveCadastrarProdutoComValorVazio(){
        produtoPage.buttonSair.click();
        produtoPage.buttonCriar.click();
        produtoPage.cadastrar("300", "Detergente", "25", "", "26/12/2023");
        assertEquals(produtoPage.mensagem.getText(), "Todos os campos são obrigatórios para o cadastro!");
    }
    
    
    @Test
    public void TC03_deveExcluirUmProdutoCriado() {
        // Executa a ação de exclusão do produto
        produtoPage.buttonExcluir.click();
        
        // Verifica se o produto foi excluído com sucesso
        boolean produtoExcluido = produtoPage.produtoNaoEstaNaLista("Código do Produto");
        assertTrue("Produto não foi excluído com sucesso", produtoExcluido);
    }

	
		
}