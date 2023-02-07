package com.gpcoder.patterns.other.dto;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll();

    Optional<T> get(Integer id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
