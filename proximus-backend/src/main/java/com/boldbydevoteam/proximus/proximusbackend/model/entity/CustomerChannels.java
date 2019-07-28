package com.boldbydevoteam.proximus.proximusbackend.model.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 * This entity is responsible to connect both the Customer and the Channel entities;
 */
@Data
@Document(collection="customerChannels")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class CustomerChannels extends BaseEntity {
    private String customerId;
    private List<String> activeChannels;
}
