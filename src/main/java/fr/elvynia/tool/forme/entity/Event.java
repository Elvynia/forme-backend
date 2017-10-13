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
public class Event implements Serializable {

	private static final long serialVersionUID = 3199103763384152415L;

	@Column
	private Date end;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "missionId", referencedColumnName = "id")
	@JsonIgnore
	private Mission mission;

	@Column
	private Date start;

	public Date getEnd() {
		return this.end;
	}

	public Integer getId() {
		return this.id;
	}

	public Mission getMission() {
		return this.mission;
	}

	@JsonGetter
	public Integer getMissionId() {
		if (this.mission != null) {
			return this.mission.getId();
		} else {
			return null;
		}
	}

	public Date getStart() {
		return this.start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	@JsonSetter
	public void setMissionId(Integer MissionId) {
		final Mission mission = new Mission();
		mission.setId(MissionId);
		this.mission = mission;
	}

	public void setStart(Date start) {
		this.start = start;
	}

}
