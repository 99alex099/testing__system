package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.repository.LiteratureRepository;
import by.devincubator.dits.entities.Literature;
import by.devincubator.dits.services.general.exception.LiteratureIdIsIncorrectException;
import by.devincubator.dits.services.general.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LiteratureServiceImpl implements LiteratureService {

    private static final String START_LINK_LITERATURE_INFO = "/literature/";

    private LiteratureRepository literatureRepository;

    @Autowired
    public void setLiteratureRepository(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }

    @Override
    public Literature findById(Integer id) {
        return literatureRepository.findById(id)
                .orElseThrow(
                        () -> new LiteratureIdIsIncorrectException(id));
    }

    @Override
    public Literature save(Literature literature) {
        return literatureRepository.save(literature);
    }

    @Override
    public void delete(Literature literature) {
        literatureRepository.delete(literature);
    }

    @Override
    public String formLinkToLiteratureInfo(Literature literature) {
        return START_LINK_LITERATURE_INFO + literature.getLiteratureId();
    }
}
