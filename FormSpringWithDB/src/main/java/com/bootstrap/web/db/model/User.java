package com.bootstrap.web.db.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author shaines
 */
@Entity
@Table( name = "USER_INFO" )
public class User implements Serializable
{
    /**
     * Serialization id
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Customer's id attribute
     */
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "USER_ID" )
    private long userId;

	@Column( name = "FIRSTNAME" )
    private String firstName;

    @Column( name = "LASTNAME" )
    private String lastName;

    @Column( name = "EMAIL" )
    private String email;

    @Column( name = "PASSWORD" )
    private String password;
    
    @Column( name = "USERNAME" )
    private String username;
    
    @OneToMany( mappedBy = "user" )
    private List<Roles> roles;

	public User()
    {
    }

    public User( String firstName,
                     String lastName,
                     String email,
                     String password,
                     String username,
                     ArrayList<Roles> roles)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
    public String getUsername() {
		return username;
	}
    public void setUsername(String username) {
		this.username = username;
	}
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }
    public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Roles> roles) {
		this.roles = roles;
	}
}