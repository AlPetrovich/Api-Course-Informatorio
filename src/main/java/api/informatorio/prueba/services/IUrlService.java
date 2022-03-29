package api.informatorio.prueba.services;
import api.informatorio.prueba.entities.Url;
import api.informatorio.prueba.entities.UrlDTO;

public interface IUrlService {
    public void createUrl(Url url);
    public void deleteUrl(Long id);
    public UrlDTO findUrl(Long id);
}
