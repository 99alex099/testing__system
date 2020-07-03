package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.entities.Link;
import by.devincubator.dits.repository.LinkRepository;
import by.devincubator.dits.services.general.exceptions.LinkIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

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
