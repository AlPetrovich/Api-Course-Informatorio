package api.informatorio.prueba.repository;
import api.informatorio.prueba.entity.Startup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface IStartupRepository extends JpaRepository<Startup,Long> {
    @Query("FROM Startup su WHERE su.published = :false ")
    Set<Startup> getStartupByPublished(@Param("false") boolean published);
    @Query("SELECT id, content, description, name, counterVote FROM Startup s order by s.counterVote desc")
    Set<Startup> getStartupRanking();

}
