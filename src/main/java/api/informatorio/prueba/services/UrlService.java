package api.informatorio.prueba.services;
import api.informatorio.prueba.entities.Url;
import api.informatorio.prueba.entities.UrlDTO;
import api.informatorio.prueba.repositories.IUrlRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UrlService implements IUrlService{
    @Autowired
    IUrlRepository iUrlRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void createUrl(Url url) {
        iUrlRepository.save(url);
    }
    @Override
    public void deleteUrl(Long id) {
        iUrlRepository.deleteById(id);
    }
    @Override
    public UrlDTO findUrl(Long id) {
        Optional<Url> url=iUrlRepository.findById(id);
        UrlDTO urlDTO= null;
        if (url.isPresent()){
            urlDTO = mapper.convertValue(url, UrlDTO.class);
        }
        return urlDTO;
    }
}
