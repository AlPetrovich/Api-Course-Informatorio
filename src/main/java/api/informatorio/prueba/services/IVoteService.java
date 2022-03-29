package api.informatorio.prueba.services;
import api.informatorio.prueba.entities.Vote;
import java.util.Set;

public interface IVoteService {

    public Vote createVote(Long userId, Long startupId, Vote vote);
    public Vote findById(Long id);
    public Set<Vote> getVotesByUser(Long id);
}
