package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationBasicDTO {

    private Long id;
    private String name;
    private Integer phone;
    private String address;
    private String image;
    private String email;
    private String welcomeText;
    private String aboutUsText;
    private String url_linkedin;
    private String url_facebook;
    private String url_instagram;

}
