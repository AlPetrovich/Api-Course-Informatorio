package api.informatorio.prueba.repositories;
import api.informatorio.prueba.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrlRepository extends JpaRepository<Url, Long> {

}
