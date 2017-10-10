package fr.elvynia.tool.forme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.CompanyDao;
import fr.elvynia.tool.forme.entity.Company;

/**
 * Company management. FIXME: exception handling.
 *
 * @author jmasson
 *
 */
@Service
public class CompanyService implements FormeService<Company> {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company create(Company entity) {
		return this.companyDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.companyDao.delete(id);
		return false;
	}

	@Override
	public List<Company> list() {
		return this.companyDao.findAll();
	}

	@Override
	public Company read(Integer id) {
		return this.companyDao.findOne(id);
	}

	@Override
	public Company update(Company entity) {
		return this.companyDao.save(entity);
	}
}
