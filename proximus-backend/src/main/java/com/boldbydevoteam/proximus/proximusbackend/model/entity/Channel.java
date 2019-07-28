package com.boldbydevoteam.proximus.proximusbackend.model.entity;

import java.util.List;

import com.boldbydevoteam.proximus.proximusbackend.model.enums.Category;
import com.boldbydevoteam.proximus.proximusbackend.model.enums.Resolution;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="channel")
@Getter
@RequiredArgsConstructor
public class Channel {
    @Id
    private String id;
    private String name;
    private Integer number;
    private Resolution resolution;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Category> categories;
    private Boolean activeByDefault = Boolean.FALSE;
}
