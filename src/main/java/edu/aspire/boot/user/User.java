package edu.aspire.boot.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import edu.aspire.boot.model.BankAccounts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="Gives all the details of the user")
@Entity
public class User

{
    @Id
    @GeneratedValue
	private int id;
	
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes="The name should not be less than two characters")
	private String name;
     
	@Past
	@ApiModelProperty(notes="birthdate cannot be the in future ")
	private Date Dob;
	
	@OneToMany(mappedBy="user")
	private List<Post> post;
	//private List<BankAccounts> bankAccountsList;

	public User() {

	}


	/*public User(int id, String name, Date Dob,List<BankAccounts> bankAccountsList) {
		super();
		this.id = id;
		this.name = name;
		this.Dob = Dob;
		this.bankAccountsList = bankAccountsList;
	}*/
	public User(int id, String name, Date Dob) {
		super();
		this.id = id;
		this.name = name;
		this.Dob = Dob;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}
	

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
/*
	public List<BankAccounts> getBankAccountsList() {
		return bankAccountsList;
	}

	public void setBankAccountsList(List<BankAccounts> bankAccountsList) {
		this.bankAccountsList = bankAccountsList;
	}
*/
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", Dob=" + Dob + "]";
	}

}
