package com.hamitmizrak.business.dto;

import com.hamitmizrak.annotation.RegisterUniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//DTO ==> validation
public class RegisterDto implements Serializable {

    //serileştirme
    public static final long serialVersionUID = 1L;

    // ID
    private Long id;

    // USERNAME
    @NotNull(message = "{register.username.validation.constraints.NotNull.message}")
    private String uname;

    // EMAIL: Spring Security için unutma: username ve password almak zorundasın
    @NotNull(message = "{register.email.validation.constraints.NotNull.message}")
    @Email
    @Size(max = 200)
    @RegisterUniqueEmail
    private String email;

    // PASSWORD
    // Json create yapıldığı görünmez yapmak için ancak validation sıkıntı oluyor. 404 hatası döner
    // @JsonIgnore yerine @JsonView yazabiliriz.
    // Hm123456@
    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", message = "{register.password.pattern.validation.constraints.NotNull.message}")
    @Size(min = 7, max = 30)
    private String passwd;

    // Kullanıcı aktif mi pasif mi
    private String check;
    private String image;

    // Sistem tarihi almak
    private Date createdDate;

    //Object Pageable
    private Object object;

    //UserDetails için
    private Collection<? extends GrantedAuthority> getAuthorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    //Constructor
    public RegisterDto(String uname, String email, String passwd, String check, String image) {
        this.uname = uname;
        this.email = email;
        this.passwd = passwd;
        this.check = check;
        this.image = image;
    }

}