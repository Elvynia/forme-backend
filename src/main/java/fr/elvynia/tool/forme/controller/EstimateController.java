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

import fr.elvynia.tool.forme.entity.Estimate;
import fr.elvynia.tool.forme.service.EstimateService;

@Controller
@RequestMapping("/estimate")
public class EstimateController extends BaseController<EstimateService, Estimate> {

	@Override
	@ResponseBody
	@PostMapping({ "", "/" })
	public Estimate create(@RequestBody final Estimate estimate) {
		return super.create(estimate);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final Integer id) {
		super.delete(id);
	}

	@Override
	@ResponseBody
	@RequestMapping("/{id}")
	public Estimate get(@PathVariable final Integer id) {
		return super.get(id);
	}

	@Override
	@ResponseBody
	@RequestMapping({ "", "/" })
	public List<Estimate> list() {
		return super.list();
	}

	@ResponseBody
	@PutMapping({ "", "/" })
	public Estimate update(@RequestBody final Estimate estimate, final HttpServletResponse response)
			throws IOException {
		if (estimate.getId() == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Property id is missing to update.");
			return null;
		}
		return super.update(estimate);
	}
}
