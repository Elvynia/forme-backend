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
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private Float amount;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	@JsonIgnore
	private Company client;

	@Column
	private Date creationDate;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Boolean pending;

	@Column
	private Boolean received;

	@Column
	private Date receptionDate;

	@Column
	private Boolean travelCosts;

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

	public Date getCreationDate() {
		return this.creationDate;
	}

	public Integer getId() {
		return this.id;
	}

	public Boolean getPending() {
		return this.pending;
	}

	public Boolean getReceived() {
		return this.received;
	}

	public Date getReceptionDate() {
		return this.receptionDate;
	}

	public Boolean getTravelCosts() {
		return this.travelCosts;
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

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public void setReceived(Boolean received) {
		this.received = received;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
	}

	public void setTravelCosts(Boolean travelCosts) {
		this.travelCosts = travelCosts;
	}
}
