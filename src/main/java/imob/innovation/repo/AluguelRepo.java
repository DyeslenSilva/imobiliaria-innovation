package imob.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import imob.innovation.model.Aluguel;

public interface AluguelRepo extends JpaRepository<Aluguel, Integer> {

}
