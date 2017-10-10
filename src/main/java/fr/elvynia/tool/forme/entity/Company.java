package fr.elvynia.tool.forme.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private String address;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String rcs;

	@Column
	@Length(min = 9, max = 9)
	private String siren;

	@Column
	@Length(min = 13, max = 13)
	private String siret;

	@Column
	@Length(min = 3, max = 3)
	private String trigram;

	public List<String> getAddress() {
		if (this.address != null) {
			return Arrays.asList(this.address.split("\n"));
		} else {
			return new ArrayList<>();
		}
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getRcs() {
		return this.rcs;
	}

	public String getSiren() {
		return this.siren;
	}

	public String getSiret() {
		return this.siret;
	}

	public String getTrigram() {
		return this.trigram;
	}

	public void setAddress(List<String> address) {
		this.address = address.stream().collect(Collectors.joining("\n"));
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRcs(String rcs) {
		this.rcs = rcs;
	}

	public void setSiren(String siren) {
		this.siren = siren;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public void setTrigram(String trigram) {
		this.trigram = trigram;
	}

}
