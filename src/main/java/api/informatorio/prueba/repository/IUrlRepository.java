package api.informatorio.prueba.repository;
import api.informatorio.prueba.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUrlRepository extends JpaRepository<Url, Long> {

}
