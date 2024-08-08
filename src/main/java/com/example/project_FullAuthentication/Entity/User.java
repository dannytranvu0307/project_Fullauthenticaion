package com.example.project_FullAuthentication.Entity;
import com.example.project_FullAuthentication.Entity.Class.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name ="user_name")
    private String user_name;

    @Column(name ="status")
    private Integer status;

    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn(name ="refresh_Token")
    private refreshToken refreshToken;

    @Column(name ="create_Date")
    private Instant createDate ;

    @Column(name ="update_Date")
    private Instant updateDate ;

    @Column(name ="verify_Code")
    private String verifyCode ;

    @Column(name ="avatar_Link")
    private String avatarLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
    @PrePersist
    public void PrePersit(){
        this.createDate = Instant.now();
    }
    @PreUpdate
    public void PreUpdate(){
        this.updateDate = Instant.now();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.userRole.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status != null && this.status == 1;
    }
}
