package com.essai.testautomation.model.rest.postuser;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String job;
}
