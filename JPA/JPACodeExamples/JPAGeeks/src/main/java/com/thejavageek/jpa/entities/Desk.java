package com.thejavageek.jpa.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Desk {

	@TableGenerator(table = "id_gen", name = "desk_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "desk_gen")
	private int iddesk;
	private int number;
	private String location;

	public int getIddesk() {
		return iddesk;
	}

	public void setIddesk(int iddesk) {
		this.iddesk = iddesk;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}