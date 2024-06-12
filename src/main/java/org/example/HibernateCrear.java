package org.example;

import jakarta.persistence.EntityManager;
import org.example.Util.JpaUtil;
import org.example.entity.Cliente;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();


        try {

            String nombre = JOptionPane.showInputDialog("Ingresa el nombre: ");
            String apellido = JOptionPane.showInputDialog("Ingresa el apellido: ");
            String pago = JOptionPane.showInputDialog("Ingresa la forma de pago: ");
            em.getTransaction().begin();

            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.persist(c);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        }finally {
            em.close();
        }
    }
}
