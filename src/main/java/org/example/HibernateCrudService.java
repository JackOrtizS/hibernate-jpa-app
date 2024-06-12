package org.example;

import jakarta.persistence.EntityManager;
import org.example.Util.JpaUtil;
import org.example.entity.Cliente;
import org.example.services.ClienteService;
import org.example.services.ClienteServiceImpl;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ClienteService service = new ClienteServiceImpl(em);

        try {
            System.out.println("================= Listar ========================");
            List<Cliente> clientes = service.listar();
            clientes.forEach(System.out::println);

            System.out.println("================= Obtener por ID =================");
            Optional<Cliente> optionalCliente = service.porId(1L);
            optionalCliente.ifPresent(System.out::println);

            System.out.println("================= Insertar nuevo cliente =================");
            Cliente cliente = new Cliente();
            cliente.setNombre("Rosa");
            cliente.setApellido("Salazar");
            cliente.setFormaPago("paypal");
            service.guardar(cliente);
            System.out.println("Cliente guardado");

            System.out.println("================= Editar cliente =================");
            Long id = cliente.getId();
            optionalCliente = service.porId(id);
            optionalCliente.ifPresent(c -> {
                c.setFormaPago("TC");
                service.guardar(c);
                System.out.println("Cliente editado con éxito");
            });

            System.out.println("================= Listar después de editar =================");
            clientes = service.listar();
            clientes.forEach(System.out::println);

            System.out.println("================= Eliminar cliente =================");
            id = cliente.getId();
            optionalCliente = service.porId(id);
            optionalCliente.ifPresent(c -> {
                service.eliminar(c.getId());
                System.out.println("Cliente eliminado");
            });

            System.out.println("================= Listar después de eliminar =================");
            clientes = service.listar();
            clientes.forEach(System.out::println);
        } finally {
            em.close();
        }
    }
}
