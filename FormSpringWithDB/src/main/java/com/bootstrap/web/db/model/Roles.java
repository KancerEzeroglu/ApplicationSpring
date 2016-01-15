package com.bootstrap.web.db.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author shaines
 */
@Entity
@Table( name = "ROLES_INFO" )
public class Roles implements Serializable
{
    /**
     * Serialization id
     */
    private static final long serialVersionUID = 1L;

    /**
     * The Customer's id attribute
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="roles_seq")
    @SequenceGenerator(name="roles_seq", sequenceName="roles_seq")
    @Column( name = "ID" )
    private long id;

    @Column( name = "ROLESNAME" )
    private String rolesName;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


	public Roles()
    {
    }

    public Roles( String rolesName)
    {
        this.rolesName = rolesName;
    }

   

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }
    public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}