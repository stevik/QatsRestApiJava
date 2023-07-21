package com.essai.testautomation.helpers;

import com.essai.testautomation.model.rest.postuser.UserRequest;

public class PostUserRequestHelper {

    private PostUserRequestHelper() {

    }

    public static UserRequest createPostUserRequest(String name, String job) {
        return UserRequest.builder()
                .name(name)
                .job(job)
                .build();

    }
}
