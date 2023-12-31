package com.InventorSoftAcademy.DAL;

import java.util.List;

public interface DataAccessLayer<T> {
    void create(T entity) throws Exception;

    T read(Long id) throws Exception;

    void update(T currentEntity, T updatedEntity) throws Exception;

    void delete(Long id) throws Exception;

    List<T> getAll() throws Exception;
}
