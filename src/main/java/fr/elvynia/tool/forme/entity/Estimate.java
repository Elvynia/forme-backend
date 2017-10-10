package fr.elvynia.tool.forme.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Estimate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private Float amount;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	@JsonIgnore
	private Company client;

	@Column
	private Date date;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Boolean signed;

	public Float getAmount() {
		return this.amount;
	}

	public Company getClient() {
		return this.client;
	}

	@JsonGetter
	public Integer getClientId() {
		if (this.client != null) {
			return this.client.getId();
		} else {
			return null;
		}
	}

	public Date getDate() {
		return this.date;
	}

	public Integer getId() {
		return this.id;
	}

	public Boolean getSigned() {
		return this.signed;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public void setClient(Company client) {
		this.client = client;
	}

	@JsonSetter
	public void setClientId(Integer clientId) {
		final Company company = new Company();
		company.setId(clientId);
		this.client = company;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSigned(Boolean signed) {
		this.signed = signed;
	}
}
