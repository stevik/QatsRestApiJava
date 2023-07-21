package com.essai.testautomation.tests;

import com.essai.testautomation.helpers.PostUserRequestHelper;
import com.essai.testautomation.model.rest.postuser.UserRequest;
import com.essai.testautomation.model.rest.postuser.UserResponse;
import com.essai.testautomation.teststeps.ReqResApiRestTestSteps;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PostUserTest {

    private static final ReqResApiRestTestSteps REQRESAPI_REST_TEST_STEPS = new ReqResApiRestTestSteps();


    @ParameterizedTest
    @CsvFileSource(resources = "/new_users.csv", numLinesToSkip = 1, delimiter = ';')
    public void postUserTest(String name, String job) {
        // prepare
        UserRequest request = PostUserRequestHelper.createPostUserRequest(name, job);

        // execute
        UserResponse response = REQRESAPI_REST_TEST_STEPS.postUserRequest(request, 2000L);

        // verify
        REQRESAPI_REST_TEST_STEPS.verifyPostUserResponse(request, response);
    }
}
