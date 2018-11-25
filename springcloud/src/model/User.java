package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {

	@Id
	@Column(name="USER_ID")
	public Long userID;
	
	@Column(name="FIRST_NAME")
	public String firstName;
	
	@Column(name="LAST_NAME")
	public String lastName;

	public Long getUserID() {
		return userID;
	}

	public void setUser_ID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_Name) {
		this.firstName = first_Name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_Name) {
		this.lastName = last_Name;
	}
	
	
	
	
}
