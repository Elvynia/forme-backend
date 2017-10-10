package fr.elvynia.tool.forme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.elvynia.tool.forme.dao.InvoiceDao;
import fr.elvynia.tool.forme.entity.Invoice;

/**
 * Invoice management. FIXME: exception handling.
 *
 * @author jmasson
 *
 */
@Service
public class InvoiceService implements FormeService<Invoice> {

	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Invoice create(Invoice entity) {
		return this.invoiceDao.save(entity);
	}

	@Override
	public boolean delete(Integer id) {
		this.invoiceDao.delete(id);
		return false;
	}

	@Override
	public List<Invoice> list() {
		return this.invoiceDao.findAll();
	}

	@Override
	public Invoice read(Integer id) {
		return this.invoiceDao.findOne(id);
	}

	@Override
	public Invoice update(Invoice entity) {
		return this.invoiceDao.save(entity);
	}
}
