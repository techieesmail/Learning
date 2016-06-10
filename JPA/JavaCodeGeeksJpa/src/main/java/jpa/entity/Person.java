package jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class Person {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CARD_ID")
	private IdCard idCard;
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Phone> phones = new ArrayList<Phone>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
