package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Timestamp creationDate;
    private Timestamp updateDate;

}
