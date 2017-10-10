package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.elvynia.tool.forme.entity.Estimate;

public interface EstimateDao extends JpaRepository<Estimate, Integer> {

}
