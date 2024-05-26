/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author demi
 */
public class CadastroDeProduto {
    public static void main(String[] args) {
        // cadastrarProduto();
        Long id = 1l; //Isso é um 1L = 1l
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto p = produtoDAO.buscarPorId(1l);
        System.out.println(p.getPreco());
        
        // Aqui se torna visivel a importancia de delegar a responsabilidade de pesquisa para a classe DAO
        List<Produto> produtos = produtoDAO.buscarNomeDaCategoria("CELULARES");
        produtos.forEach(f -> System.out.println(f.getNome()));
        
        BigDecimal  precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xaomi Redmi");
        System.out.println("Preço do Produto: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);
        
        Categoria celulares = new Categoria("CELULARES");
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        
        Produto celular = new Produto("A Bela e a Fera", "Livro Clássico", new BigDecimal("50"), celulares);
        
        // Esse bloco se torna padrão quando vamos fazer o commit de um objeto no banco.
        try{
            em.getTransaction().begin();
            
            categoriaDAO.cadastrar(celulares);
            dao.cadastrar(celular);
            
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
