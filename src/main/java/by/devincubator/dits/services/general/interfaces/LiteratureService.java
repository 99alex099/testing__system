package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Literature;

public interface LiteratureService {

    Literature findById(Integer id);
    Literature save(Literature literature);
    void delete(Literature literature);
}
