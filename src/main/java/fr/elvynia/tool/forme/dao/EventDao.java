package fr.elvynia.tool.forme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.elvynia.tool.forme.entity.Event;

public interface EventDao extends JpaRepository<Event, Integer> {

	List<Event> findAllByMission_Id(final Integer id);
}
