package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.Util.JpaUtil;
import org.example.entity.Cliente;

import java.util.Scanner;

public class HibernatePorId {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();

        /*
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.id = ?1", Cliente.class);
        System.out.print("Ingresa el ID: ");
        Long pago = s.nextLong();
        query.setParameter(1,pago);
        Cliente  c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();
        */

        System.out.print("Ingresa el ID: ");
        Long id = s.nextLong();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);
        em.close();
    }
}
