package imob.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import imob.innovation.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
