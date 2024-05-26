/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author demi
 */
public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence
                .createEntityManagerFactory("loja");
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
