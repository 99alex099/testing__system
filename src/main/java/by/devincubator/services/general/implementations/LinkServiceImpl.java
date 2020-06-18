package by.devincubator.services.general.implementations;

import by.devincubator.repository.LinkRepository;
import by.devincubator.entities.Link;
import by.devincubator.services.general.exceptions.LinkIdIsIncorrectException;
import by.devincubator.services.general.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link findById(Integer id) {
        return linkRepository.findById(id)
                .orElseThrow(() -> new LinkIdIsIncorrectException(id));
    }

    @Override
    public Link save(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public void delete(Link link) {
        linkRepository.delete(link);
    }
}
