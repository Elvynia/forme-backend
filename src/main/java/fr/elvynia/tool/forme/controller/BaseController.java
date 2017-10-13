package fr.elvynia.tool.forme.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.elvynia.tool.forme.service.FormeService;

public class BaseController<SERVICE extends FormeService<ENTITY>, ENTITY> {

	@Autowired
	protected SERVICE service;

	public ENTITY create(final ENTITY entity) {
		return this.service.create(entity);
	}

	public void delete(final Integer id) {
		this.service.delete(id);
	}

	public ENTITY get(final Integer id) {
		return this.service.read(id);
	}

	public List<ENTITY> list() {
		return this.service.list();
	}

	public ENTITY update(final ENTITY entity) throws IOException {
		return this.service.update(entity);
	}
}
