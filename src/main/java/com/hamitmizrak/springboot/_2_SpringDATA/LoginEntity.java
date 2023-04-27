package com.hamitmizrak.springboot._2_SpringDATA;

import com.hamitmizrak.data.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
*/


public class LoginEntity{}
/*

@Entity
@Table(name = "login")
public class LoginEntity extends BaseEntity implements Serializable {
    public static final Long serialVersionUID=1L;

    private String name;
    private String surname;

    @Column(name = "email",unique = true,nullable = true,length = 200,insertable = true,updatable = true)
    private String email;

    @Column(name ="password")
    private String password;

    //Database eklemek istemediğimiz özellikleri
    @Transient
    private String specialData;
}
*/
