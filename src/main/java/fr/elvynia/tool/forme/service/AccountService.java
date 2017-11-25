package fr.elvynia.tool.forme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.elvynia.tool.forme.dao.AccountDao;
import fr.elvynia.tool.forme.dao.CompanyDao;
import fr.elvynia.tool.forme.dao.RoleDao;
import fr.elvynia.tool.forme.entity.Account;
import fr.elvynia.tool.forme.entity.Company;
import fr.elvynia.tool.forme.entity.Role;

@Service
public class AccountService implements FormeService<Account> {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleDao roleDao;

	public void addResponsability(int accountId, int companyId) {
		final Account account = this.accountDao.findOne(accountId);
		account.getCompanies().add(this.companyDao.findOne(companyId));
		this.accountDao.save(account);
	}

	@Override
	public Account create(Account entity) {
		// Crypt password.
		entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
		return this.accountDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.accountDao.delete(id);
		return false;
	}

	@Override
	public List<Account> list() {
		return this.accountDao.findAll();
	}

	public List<Role> listRoles() {
		return this.roleDao.findAll();
	}

	@Override
	public Account read(Integer id) {
		return this.accountDao.findOne(id);
	}

	public void removeResponsability(int accountId, int companyId) {
		final Account account = this.accountDao.findOne(accountId);
		final int index = account.getCompanies().stream().map(Company::getId).collect(Collectors.toList())
				.indexOf(companyId);
		if (index >= 0) {
			account.getCompanies().remove(index);
			this.accountDao.save(account);
		}
	}

	@Override
	public Account update(Account entity) {
		Account db = this.accountDao.findOne(entity.getId());
		if (!StringUtils.isEmpty(entity.getPassword())) {
			entity.setPassword(this.passwordEncoder.encode(entity.getPassword()));
		} else {
			entity.setPassword(db.getPassword());
		}
		return this.accountDao.save(entity);
	}

}
