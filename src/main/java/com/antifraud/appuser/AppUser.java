package com.antifraud.appuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table
@NoArgsConstructor
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Enumerated(EnumType.STRING)
    private List<AppUserRole> appUserRoles;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isAccountNonExpired = true;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isAccountNonLocked = false;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isCredentialsNonExpired = true;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isEnabled = false;

    public AppUser(String firstname,
                   String lastname,
                   String email,
                   String password,
                   List<AppUserRole> appUserRoles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.appUserRoles = appUserRoles;
    }

    public AppUser(String firstname,
                   String lastname,
                   String email,
                   String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        appUserRoles.forEach(appUserRole -> authorities.add(
                new SimpleGrantedAuthority(appUserRole.toString())
        ));

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}
