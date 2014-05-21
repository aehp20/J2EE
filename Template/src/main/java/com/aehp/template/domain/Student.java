package com.aehp.template.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aehp.template.json.JsonDateTimeWithSecondsSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(
    name = "STUDENT")
public class Student implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 10000L;

    /**
     * The student ID.
     */
    @Id
    @Column(
        name = "ID")
    private int id;

    /**
     * The student name.
     */
    @Column(
        name = "NAME")
    private String name;

    /**
     * The creation date time.
     */
    @Column(
        name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
//    @JsonSerialize(
//        using = JsonDateTimeWithSecondsSerializer.class)
    private Date creationTime;

    /**
     * A flag to know if the alternative is right.
     */
    @Column(
        name = "IS_ANSWER",
            nullable = false)
    private boolean isAnswer;

    
}
