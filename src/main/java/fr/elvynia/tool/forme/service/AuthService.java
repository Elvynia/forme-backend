package fr.elvynia.tool.forme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.AccountDao;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.accountDao.findOneByUsername(username);
	}

}
