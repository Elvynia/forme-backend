package fr.elvynia.tool.forme.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.elvynia.tool.forme.M_TYPE;

@Entity
public class Mission implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Company client;

	@Column
	private Boolean closed;

	@Column
	private Integer duration;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mission")
	@JsonIgnore
	private List<Event> events;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String label;

	@Column
	private String place;

	@Column
	private String title;

	@Column
	private Float tjm;

	@Column
	private Boolean travelCosts;

	@Column
	private Integer type;

	public Company getClient() {
		return this.client;
	}

	public Boolean getClosed() {
		return this.closed;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public Integer getId() {
		return this.id;
	}

	public String getLabel() {
		return this.label;
	}

	public String getPlace() {
		return this.place;
	}

	public String getTitle() {
		return this.title;
	}

	public Float getTjm() {
		return this.tjm;
	}

	public Boolean getTravelCosts() {
		return this.travelCosts;
	}

	public M_TYPE getType() {
		return M_TYPE.byId(this.type);
	}

	public void setClient(Company client) {
		this.client = client;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTjm(Float tjm) {
		this.tjm = tjm;
	}

	public void setTravelCosts(Boolean travelCosts) {
		this.travelCosts = travelCosts;
	}

	public void setType(M_TYPE type) {
		this.type = type.getId();
	}
}
