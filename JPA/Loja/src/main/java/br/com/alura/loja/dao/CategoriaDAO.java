/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author demi
 */
public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void cadastrar (Categoria categoria){
        this.em.persist(categoria);
    }
    
    public void atualizar(Categoria categoria){
        this.em.merge(categoria);
    }
    
    public void remover(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }
}
