/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author demi
 */
public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }
    
    public void cadastrar (Produto produto){
        this.em.persist(produto);
    }
    
    public void atualizar(Produto produto){
        this.em.merge(produto);
    }
    
    public void remover(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }
    
    public Produto buscarPorId(Long id){
        Produto produto = em.find(Produto.class, id);
        return produto;
    }
    
    public List<Produto> buscarTodos(){
        // Na linguagem MySQL seria:
        // SELECT * FROM produtos, porém em jpql direcionamos a pesquisa para a entidade
        // Que no caso é Produto.
        String jpql = "SELECT p FROM Produto p";
        
        //Em em.createQrery é possível somente por no parâmetro o String jpql,
        //Mas aqui vamos específicar qual Classe será retornada na lista.
        return em.createQuery(jpql, Produto.class).getResultList();
    }
    
    public List<Produto> buscarNome(String nome){
        //Primeiramente é importante observar que p.nome é o atributo nome da entidade Produto
        // e ':nome' é um apelido dado a String nome que virá no parâmentro do método.
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)// Aqui estamos atribuindo a variável nome a :nome sem os ':'
                .getResultList();
    }
    
    public List<Produto> buscarNomeDaCategoria(String nome){
        // Perceba que a consulta aponta para o atributo de categoria que é atributo do Produto
         String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)// Aqui estamos atribuindo a variável nome a :nome sem os ':'
                .getResultList();
    }
    
    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        //Primeiramente é importante observar que p.nome é o atributo nome da entidade Produto
        // e ':nome' é um apelido dado a String nome que virá no parâmentro do método.
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)// Aqui estamos atribuindo a variável nome a :nome sem os ':'
                .getSingleResult(); // Esse método trará apenas um resultado. 
    }
}
