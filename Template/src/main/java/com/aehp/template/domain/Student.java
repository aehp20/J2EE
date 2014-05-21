package com.aehp.template.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(
    name = "STUDENT")
public class Student implements Serializable {

    private static final long serialVersionUID = 10000L;

    @Id
    @Column(
        name = "ID")
    private int id;

    @Column(
        name = "NAME")
    private String name;

    @Column(
    	name = "EMAIL")
    private String email;

    @Column(
       	name = "LOGIN")
    private String login;

    @Column(
       	name = "PASSWORD")
    private String password;

    @Column(
        name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonSerialize(
//        using = JsonDateTimeWithSecondsSerializer.class)
    private Date creationTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
