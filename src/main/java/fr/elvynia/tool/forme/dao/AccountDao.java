package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.elvynia.tool.forme.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

	Account findOneByUsername(final String username);
}
