package edu.aspire.boot.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.aspire.boot.model.BankAccounts;

@Component

public class UserDaoService
{
	
	private static List<User> users=new ArrayList<>();
	
	private static int usersCount=3;
	private static List<BankAccounts> bankAccountsList = new ArrayList<>();
	
	static
	{
		bankAccountsList.add(new BankAccounts(21344,555,"Bank Of America"));
		users.add(new User(1,"ab",new Date()));
		users.add(new User(2,"cd",new Date()));
		users.add(new User(3,"ef",new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		
		if(user.getId()==0)
		{
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

	
	public User deleteById(int id)
	{
		
  Iterator<User>  iterator=users.iterator();
  
  while(iterator.hasNext())
  {
	 
	  
	 User user=iterator.next();
	 
	 if(user.getId()==id)
	 {
		 iterator.remove();
		 
		 return user;
	 }
	 
	  
  }
  
  return null;
	}
		
	}


