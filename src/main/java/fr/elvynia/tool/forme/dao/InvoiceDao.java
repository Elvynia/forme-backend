package fr.elvynia.tool.forme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.elvynia.tool.forme.entity.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Integer> {

}
