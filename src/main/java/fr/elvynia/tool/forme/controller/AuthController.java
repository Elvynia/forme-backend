package fr.elvynia.tool.forme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.elvynia.tool.forme.dao.AccountDao;
import fr.elvynia.tool.forme.entity.Account;

@Controller
public class AuthController {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AccountDao accountDao;

	@PostMapping("/login")
	@ResponseBody
	public Account login(@RequestBody final Account account) {
		return this.accountDao.findOneByUsername(account.getUsername());
	}
}
