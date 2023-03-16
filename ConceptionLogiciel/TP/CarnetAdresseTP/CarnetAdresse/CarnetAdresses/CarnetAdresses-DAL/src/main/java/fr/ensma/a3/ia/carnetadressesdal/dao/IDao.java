package fr.ensma.a3.ia.carnetadressesdal.dao;

import java.util.List;
import java.util.Optional;

/**
 * Interface DAO générique.
 *
 * @author Mikky Richard
 *
 * @param <T> Type manipulé par le DAO
 */
public interface IDao<T> {

    public Optional<T> getById(int id);

    public Optional<T> getByValue(T elem);

    List<T> getAll();

    void create(T elem);

    void update(T elem);

    void delete(T elem);

}
