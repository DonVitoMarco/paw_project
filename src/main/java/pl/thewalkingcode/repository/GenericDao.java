package pl.thewalkingcode.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, PK> {

    T create(T t);

    T update(T t);

    T read(PK pk);

    List<T> readAll();

}
