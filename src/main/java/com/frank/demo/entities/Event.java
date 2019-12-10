package com.frank.demo.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//should be use to control the order of fields in the JSON response
@JsonPropertyOrder({"resourceId"})
@Entity
public class Event extends AbstractEntity {

	private String name;
	@JsonProperty("desc") //can be used to change the name of the field in the JSON Responses?
	private String description;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private ZoneId zoneId;
	private Boolean started;
	
	// we sholdn't use cascade cause when we delete an event we want to leave the organizer alone, without deleting it
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Organizer organizer;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@RestResource(exported = false)
	private Venue venue;
	
	@JsonIgnore
	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Participant> participants;	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Long getResourceId() {
		return this.id;
	}

	//since we are using Sets we need to override this methods
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Event) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
