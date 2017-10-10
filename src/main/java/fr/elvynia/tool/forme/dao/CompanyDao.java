package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.elvynia.tool.forme.entity.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {

}
