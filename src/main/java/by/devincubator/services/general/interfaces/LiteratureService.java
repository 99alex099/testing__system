package by.devincubator.services.general.interfaces;

import by.devincubator.entities.Literature;

public interface LiteratureService {

    Literature findById(Integer id);
    Literature save(Literature literature);
    void delete(Literature literature);
}
