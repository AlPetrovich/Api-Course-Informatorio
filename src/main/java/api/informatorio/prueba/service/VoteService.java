package api.informatorio.prueba.service;
import api.informatorio.prueba.entity.*;
import api.informatorio.prueba.repository.IStartupRepository;
import api.informatorio.prueba.repository.IUserRepository;
import api.informatorio.prueba.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
@Service
public class VoteService implements IVoteService{
    @Autowired
    IVoteRepository iVoteRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IStartupRepository iStartupRepository;
    @Override
    public Vote createVote(Long userId, Long startupId, Vote vote) {
        User user= iUserRepository.getById(userId);
        Startup startup= iStartupRepository.getById(startupId);
        startup.setCounterVote(startup.getCounterVote()+1);
        vote.setUser(user);
        vote.setStartup(startup);
        return iVoteRepository.save(vote);
    }
    @Override
    public Vote findById(Long id) {
        return iVoteRepository.getById(id);
    }
    @Override
    public Set<Vote> getVotesByUser(Long id) {
        return iVoteRepository.getVotesByUser(id);
    }


}
