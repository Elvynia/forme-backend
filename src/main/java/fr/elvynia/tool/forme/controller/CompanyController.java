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

import fr.elvynia.tool.forme.entity.Company;
import fr.elvynia.tool.forme.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController<CompanyService, Company> {

	@Override
	@ResponseBody
	@PostMapping({ "", "/" })
	public Company create(@RequestBody final Company company) {
		return super.create(company);
	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(Integer id) {
		super.delete(id);
	}

	@Override
	@ResponseBody
	@RequestMapping("/{id}")
	public Company get(@PathVariable final Integer id) {
		return super.get(id);
	}

	@Override
	@ResponseBody
	@RequestMapping({ "", "/" })
	public List<Company> list() {
		return super.list();
	}

	@ResponseBody
	@PutMapping({ "", "/" })
	public Company update(@RequestBody final Company company, final HttpServletResponse response) throws IOException {
		if (company.getId() == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Property id is missing to update.");
			return null;
		}
		return super.update(company);
	}
}
