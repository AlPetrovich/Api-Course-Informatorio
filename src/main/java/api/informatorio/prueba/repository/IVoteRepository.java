package api.informatorio.prueba.repository;
import api.informatorio.prueba.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Set;
@Repository
public interface IVoteRepository extends JpaRepository<Vote, Long> {
    @Query("FROM Vote v inner join User u on u.id= v.user.id WHERE v.user.id= :id")
    Set<Vote> getVotesByUser(@Param("id") Long id);

}


