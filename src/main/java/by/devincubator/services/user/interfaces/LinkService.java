package by.devincubator.services.user.interfaces;

import by.devincubator.entities.Link;

public interface LinkService {
    Link findById(Integer id);
    Link save(Link link);
    void delete(Link link);
}
