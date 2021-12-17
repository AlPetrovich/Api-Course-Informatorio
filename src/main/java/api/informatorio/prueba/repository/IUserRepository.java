package api.informatorio.prueba.repository;
import api.informatorio.prueba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.Set;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    //CONSULTA (OBTENER TODOS LOS USUARIOS DE LA CIUDAD DE RESISTENCIA)
    @Query("FROM User u WHERE u.city = :city")
    Set<User> getUserByCity(@Param("city") String city);
    @Query("FROM User u WHERE u.creationDate > :date")
    Set<User> getUserByDate(@Param("date")Date creationDate);
}
