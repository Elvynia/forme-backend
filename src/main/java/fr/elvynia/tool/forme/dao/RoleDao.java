package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.elvynia.tool.forme.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

}
