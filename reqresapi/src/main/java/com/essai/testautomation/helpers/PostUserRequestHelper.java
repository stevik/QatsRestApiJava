package com.essai.testautomation.helpers;

import com.essai.testautomation.model.rest.postuser.PostUserRequest;

public class PostUserRequestHelper {

    private PostUserRequestHelper() {

    }

    public static PostUserRequest createPostUserRequest(String name, String job) {
        return PostUserRequest.builder()
                .name(name)
                .job(job)
                .build();

    }
}
