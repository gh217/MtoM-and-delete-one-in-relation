package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vechicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vechicleName;
	
	@ManyToMany
	private Set<UserDetails> userList=new HashSet<>();
	
	public void remov(UserDetails user) {
		this.userList.remove(user);
		user.getVechicle().remove(this);	
	}
	
	public Set<UserDetails> getUserList() {
		return userList;
	}
	
	public void setUserList(Set<UserDetails> userList) {
		this.userList = userList;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVechicleName() {
		return vechicleName;
	}
	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}
	
}
