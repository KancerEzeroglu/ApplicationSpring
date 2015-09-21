package com.bootstrap.web.db.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author shaines
 */
@Entity
@Table( name = "CUSTOMER" )
public class Customer implements Serializable
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
    @Column( name = "ID" )
    private long id;

    @Column( name = "FIRSTNAME" )
    private String firstName;

    @Column( name = "LASTNAME" )
    private String lastName;

    @Column( name = "EMAIL" )
    private String email;

    @Column( name = "PASSWORD" )
    private String password;


    public Customer()
    {
    }

    public Customer( String firstName,
                     String lastName,
                     String email,
                     String password )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
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
}