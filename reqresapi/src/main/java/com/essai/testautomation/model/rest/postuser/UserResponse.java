package com.essai.testautomation.model.rest.postuser;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String name;
    private String job;
    private int id;
    private OffsetDateTime createdAt;
}
