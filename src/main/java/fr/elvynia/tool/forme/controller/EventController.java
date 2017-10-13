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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.elvynia.tool.forme.entity.Event;
import fr.elvynia.tool.forme.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController extends BaseController<EventService, Event> {

	@Override
	@ResponseBody
	@PostMapping({ "", "/" })
	public Event create(@RequestBody final Event Event) {
		return super.create(Event);
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
	public Event get(@PathVariable final Integer id) {
		return super.get(id);
	}

	@Override
	@ResponseBody
	@RequestMapping("")
	public List<Event> list() {
		return super.list();
	}

	@ResponseBody
	@RequestMapping("/")
	public List<Event> list(@RequestParam final Integer missionId) {
		return this.service.listByMission(missionId);
	}

	@ResponseBody
	@PutMapping({ "", "/" })
	public Event update(@RequestBody final Event Event, final HttpServletResponse response) throws IOException {
		if (Event.getId() == null) {
			response.sendError(HttpStatus.BAD_REQUEST.value(), "Property id is missing to update.");
			return null;
		}
		return super.update(Event);
	}
}
