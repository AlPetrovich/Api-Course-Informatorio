package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.User;
import api.informatorio.prueba.entity.Vote;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

public interface IVoteService {
    //alta y consultar todos los votos de un usuario
    public Vote createVote(Long userId, Long startupId, Vote vote);

    public Vote findById(Long id);

    public Set<Vote> getVotesByUser(Long id);

}
