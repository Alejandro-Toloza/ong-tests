package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationDTO {

    private Long id;
    private String name;
    private String image;
    private String address;
    private Integer phone;
    private String url_linkedin;
    private String url_facebook;
    private String url_instagram;

}
