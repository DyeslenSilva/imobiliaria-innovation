package imob.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import imob.innovation.model.Funcionario;

public interface FuncionarioRepo extends JpaRepository<Funcionario, Integer> {

}
