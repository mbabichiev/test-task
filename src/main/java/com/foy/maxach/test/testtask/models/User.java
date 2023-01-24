package com.foy.maxach.test.testtask.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class User {

    @Id
    @JsonIgnore
    String id;
    @JsonProperty("Firstname")
    String firstname;
    @JsonProperty("Lastname")
    String lastname;
    @JsonIgnore
    String dateOfBirth;
    @JsonProperty("Age")
    int age;

}
