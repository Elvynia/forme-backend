package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.elvynia.tool.forme.entity.Mission;

public interface MissionDao extends JpaRepository<Mission, Integer> {

}
