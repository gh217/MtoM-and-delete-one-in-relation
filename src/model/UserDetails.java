package model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    
    @ManyToMany(mappedBy = "userList")
    private  Set<Vechicle> vechicle = new HashSet();

	public Set<Vechicle> getVechicle() {
		return vechicle;
	}

	public void remov(Vechicle v) {
		this.vechicle.remove(v);
		v.getUserList().remove(this);	
	}
	
	public void setVechicle(Set<Vechicle> vechicle) {
		this.vechicle = vechicle;
	}

	public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", vechicle=" + vechicle
				+ ", getVechicle()=" + getVechicle() + ", getUserId()=" + getUserId() + ", getUserName()="
				+ getUserName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
