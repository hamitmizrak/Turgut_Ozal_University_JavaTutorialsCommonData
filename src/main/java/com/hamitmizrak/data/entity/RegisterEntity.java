package com.hamitmizrak.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

//lombok
@Data
@NoArgsConstructor
@Builder

//Entity
@Entity
@Table(name = "register")
public class RegisterEntity extends BaseEntity implements Serializable, UserDetails{
    //serileştirme
    public static final long serialVersionUID = 1L;

    //String => columnDefinition = "varchar(255) default 'adınızı girmediniz'"
    //INT    => columnDefinition = "integer default 44"
    @Column(name = "username", columnDefinition = "varchar(255) default 'adınızı girmediniz'")
    private String uname;

    //@Column(name ="user_email",unique = true)
    @Column(name = "email")
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255) default 'Hm123456@'")
    // 1.YOL
    // spring.jackson.mapper.default-view-inclusion=true
     @JsonIgnore // bu field json görünmesini sağlamamak için
    private String passwd;

    @Column(name = "is_check", columnDefinition = "boolean default false")
    private String check;

    @Column(name = "image")
    private String image;

    //Constructor
    public RegisterEntity(String uname, String email, String passwd, String check,String image) {
        this.uname = uname;
        this.email = email;
        this.passwd = passwd;
        this.check = check;
        this.image = image;
    }

    /////////////////////////////////////////////////
    // UserDetails
    //Login için gerekli oldu yeni ekledim
    //Roller:adminPage, kullanıcı
    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_admin");
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public String getPassword() {
        return this.getPasswd();
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    @Column(name = "account")
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //spring.jackson.mapper.default-view-inclusion=true
    @JsonIgnore // bu field json görünmesini sağlamamak için
    public boolean isEnabled() {
        return true;
    }
}