package fr.ensma.a3.ia.convdevdal.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

	Optional<T> getById (final String id);
	List<T> getAll();
	void save(final T entity);
	void update(final T entity);
	void delete(final T entity);

}
