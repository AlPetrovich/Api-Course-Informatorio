package api.informatorio.prueba.service;
import api.informatorio.prueba.entity.Url;
import api.informatorio.prueba.entity.UrlDTO;
public interface IUrlService {

    public void createUrl(Url url);
    public void deleteUrl(Long id);
    public UrlDTO findUrl(Long id);
}
