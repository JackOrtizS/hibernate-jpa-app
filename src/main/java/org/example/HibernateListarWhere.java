package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.Util.JpaUtil;
import org.example.entity.Cliente;

import java.util.Scanner;

public class HibernateListarWhere {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();

        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.formaPago = ?1", Cliente.class);

        System.out.print("Ingresa una forma de pago: ");
        String pago = s.next().toUpperCase();
        query.setParameter(1,pago);
        Cliente  c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();

    }
}
