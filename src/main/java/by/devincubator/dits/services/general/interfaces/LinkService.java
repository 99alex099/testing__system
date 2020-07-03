package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Link;

public interface LinkService {
    Link findById(Integer id);

    Link save(Link link);

    void delete(Link link);
}
