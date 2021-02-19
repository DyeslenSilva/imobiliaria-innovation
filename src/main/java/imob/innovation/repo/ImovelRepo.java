package imob.innovation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import imob.innovation.model.Imovel;

public interface ImovelRepo extends JpaRepository<Imovel, Integer> {

}
