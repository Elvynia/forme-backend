package fr.elvynia.tool.forme.service;

import java.util.List;

public interface FormeService<T> {

	public T create(final T entity);

	public boolean delete(final Integer id);

	public List<T> list();

	public T read(final Integer id);

	public T update(final T entity);
}
