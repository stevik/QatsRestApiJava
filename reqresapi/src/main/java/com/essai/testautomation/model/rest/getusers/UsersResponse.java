package com.essai.testautomation.model.rest.getusers;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsersResponse{
    private Integer perPage;
    private Integer total;
    private List<DataItem> data;
    private Integer page;
    private Integer totalPages;
    private Support support;
}