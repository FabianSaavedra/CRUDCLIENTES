package PruebaRESTFul.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PruebaRESTFul.Model.Clientes;

@Repository
public interface ClientesRepositorio extends JpaRepository<Clientes, String> {

}
