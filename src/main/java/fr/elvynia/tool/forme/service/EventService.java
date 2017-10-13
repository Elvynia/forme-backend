package fr.elvynia.tool.forme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.EventDao;
import fr.elvynia.tool.forme.entity.Event;

@Service
public class EventService implements FormeService<Event> {

	@Autowired
	private EventDao eventDao;

	@Override
	public Event create(Event entity) {
		return this.eventDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.eventDao.delete(id);
		return false;
	}

	@Override
	public List<Event> list() {
		return this.eventDao.findAll();
	}

	public List<Event> listByMission(final Integer missionId) {
		return this.eventDao.findAllByMission_Id(missionId);
	}

	@Override
	public Event read(Integer id) {
		return this.eventDao.findOne(id);
	}

	@Override
	public Event update(Event entity) {
		return this.eventDao.save(entity);
	}

}
