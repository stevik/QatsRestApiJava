package com.essai.testautomation.model.rest.getusers;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DataItem {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

}