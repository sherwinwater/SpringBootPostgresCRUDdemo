package com.sherwin.postgresdemo.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sherwin.postgresdemo.config.Auditable;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "employees")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Employee extends Auditable {

    private long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String emailId;

//    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
//    private LocalDateTime Date;
//
//    //    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//    public LocalDateTime getDate() {
//        return Date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        Date = date;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
