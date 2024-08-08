package com.example.project_FullAuthentication.Entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "refresh_token")
public class refreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "expired_date", nullable = false)
    private Instant expiryDate;

    @Column(name = "`create_date`")
    private Instant createDt = Instant.now();

    @Column(name = "`update_date`")
    private Instant updateDt;
    @PreUpdate
    public void preUpdate() {
        this.updateDt = Instant.now();
    }
}
