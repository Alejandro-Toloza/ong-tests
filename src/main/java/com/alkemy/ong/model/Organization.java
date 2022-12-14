package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@SQLDelete(sql="UPDATE organizations SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name="organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "User name cannot not be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "User image cannot not be empty")
    private String image;

    private String address;

    private Integer phone;
    @Column(name = "url_linkedin")
    private String urlLinkedin;
    @Column(name = "url_facebook")
    private String urlFacebook;
    @Column(name = "url_instagram")
    private String urlInstagram;

    @NotNull(message = "User email cannot not be empty")
    private String email;

    @NotNull(message = "User Welcome cannot not be empty")
    @Column(name = "welcome_text", columnDefinition = "TEXT")
    private String welcomeText;

    @Column(name = "about_us_text", columnDefinition = "TEXT")
    private String aboutUsText;

    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name="creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name="update_date")
    private LocalDateTime updateDate;



}
