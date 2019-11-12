package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column
	protected String username;
	@Column
	protected String name;
	@Column
	protected String password;
	@Column 
	protected String role;
	
	/*Id*/
	public abstract int getId();
	
	public abstract void setId(int id);
	
	/*Username*/
	public abstract String getUsername();
	
	public abstract void setUsername(String username);
	
	/**/
	public abstract String getName();
	
	public abstract void setName(String name);
	
	/*Password*/
	public abstract String getPassword();
	
	public abstract void setPassword(String password);
	
	/*Role*/
	public abstract String getRole();
	
	public abstract void setRole(String role);
	
}
