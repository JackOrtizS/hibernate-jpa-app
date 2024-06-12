package org.example;

import jakarta.persistence.EntityManager;
import org.example.Util.JpaUtil;
import org.example.entity.Cliente;

import java.util.List;

public class HibernateListar {

    public static void main(String[] arg){
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("SELECT c  FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
