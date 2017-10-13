package fr.elvynia.tool.forme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.MissionDao;
import fr.elvynia.tool.forme.entity.Event;
import fr.elvynia.tool.forme.entity.Mission;

@Service
public class MissionService implements FormeService<Mission> {

	@Autowired
	private MissionDao missionDao;

	@Override
	public Mission create(Mission entity) {
		return this.missionDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.missionDao.delete(id);
		return false;
	}

	@Override
	public List<Mission> list() {
		return this.missionDao.findAll();
	}

	public List<Event> listEvents(Integer missionId) {
		final Mission mission = this.missionDao.findOne(missionId);
		return mission.getEvents();
	}

	@Override
	public Mission read(Integer id) {
		return this.missionDao.findOne(id);
	}

	@Override
	public Mission update(Mission entity) {
		return this.update(entity);
	}

}
