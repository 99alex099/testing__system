package by.devincubator.services.general.implementations;

import by.devincubator.repository.LiteratureRepository;
import by.devincubator.entities.Literature;
import by.devincubator.services.general.exceptions.LiteratureIdIsIncorrectException;
import by.devincubator.services.general.interfaces.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiteratureServiceImpl implements LiteratureService {

    @Autowired
    private LiteratureRepository literatureRepository;

    @Override
    public Literature findById(Integer id) {
        return literatureRepository.findById(id)
                .orElseThrow(
                        () -> new LiteratureIdIsIncorrectException(id)
                );
    }

    @Override
    public Literature save(Literature literature) {
        return literatureRepository.save(literature);
    }

    @Override
    public void delete(Literature literature) {
        literatureRepository.delete(literature);
    }
}
