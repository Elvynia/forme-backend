package fr.elvynia.tool.forme.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.elvynia.tool.forme.entity.Account;
import fr.elvynia.tool.forme.entity.Role;
import fr.elvynia.tool.forme.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController<AccountService, Account> {

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PostMapping("/add/:companyId")
	public void addResponsability(@PathVariable final int companyId, @RequestBody final Account account) {
		this.service.addResponsability(account.getId(), companyId);
	}

	@Override
	@ResponseBody
	@PostMapping({ "", "/" })
	public Account create(@RequestBody final Account company) {
		return super.create(company);
	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		super.delete(id);
	}

	@Override
	@ResponseBody
	@RequestMapping("/{id}")
	public Account get(@PathVariable final Integer id) {
		return super.get(id);
	}

	@Override
	@ResponseBody
	@RequestMapping({ "", "/" })
	public List<Account> list() {
		return super.list();
	}

	@ResponseBody
	@RequestMapping({ "/role", "/role/" })
	public List<Role> listRoles() {
		return this.service.listRoles();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PostMapping("/remove/:companyId")
	public void removeResponsability(@PathVariable final int companyId, @RequestBody final Account account) {
		this.service.removeResponsability(account.getId(), companyId);
	}

	@ResponseBody
	@PutMapping({ "", "/" })
	public Account update(@RequestBody final Account company, final HttpServletResponse response) throws IOException {
		if (company.getId() == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Property id is missing to update.");
			return null;
		}
		return super.update(company);
	}
}
