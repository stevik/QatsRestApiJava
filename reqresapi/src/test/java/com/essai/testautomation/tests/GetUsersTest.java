package com.essai.testautomation.tests;

import com.essai.testautomation.model.rest.getusers.UsersResponse;
import com.essai.testautomation.teststeps.ReqResApiRestTestSteps;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetUsersTest {

    private static final ReqResApiRestTestSteps REQRESAPI_REST_TEST_STEPS = new ReqResApiRestTestSteps();


    @Test
    public void getUsersPage2Test() {
        // prepare
        int expectedTotal = 12;
        Map<Integer, String> expectedLastNames = Map.of(
                7, "Lawson",
                8, "Ferguson");

        // execute
        UsersResponse usersResponse = REQRESAPI_REST_TEST_STEPS.getUsersRequest(2);

        // verify
        REQRESAPI_REST_TEST_STEPS.verifyUsersResponse(usersResponse, expectedTotal, expectedLastNames);
    }
}
