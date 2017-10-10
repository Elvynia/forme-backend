package fr.elvynia.tool.forme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.EstimateDao;
import fr.elvynia.tool.forme.entity.Estimate;

@Service
public class EstimateService implements FormeService<Estimate> {

	@Autowired
	private EstimateDao estimateDao;

	@Override
	public Estimate create(Estimate entity) {
		return this.estimateDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.estimateDao.delete(id);
		return false;
	}

	@Override
	public List<Estimate> list() {
		return this.estimateDao.findAll();
	}

	@Override
	public Estimate read(Integer id) {
		return this.estimateDao.findOne(id);
	}

	@Override
	public Estimate update(Estimate entity) {
		return this.estimateDao.save(entity);
	}

}
