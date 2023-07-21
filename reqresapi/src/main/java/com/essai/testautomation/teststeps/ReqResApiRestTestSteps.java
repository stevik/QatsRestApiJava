package com.essai.testautomation.teststeps;

import com.essai.testautomation.ReqResApi;
import com.essai.testautomation.model.rest.getusers.DataItem;
import com.essai.testautomation.model.rest.getusers.UsersResponse;
import com.essai.testautomation.model.rest.postuser.UserRequest;
import com.essai.testautomation.model.rest.postuser.UserResponse;
import com.essai.testautomation.utils.ObjectJsonMapper;

import java.time.Year;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ReqResApiRestTestSteps {

    public UsersResponse getUsersRequest(int page) {
        return ObjectJsonMapper.deserializeJson(ReqResApi.getUsers(page), UsersResponse.class);
    }

    public UserResponse postUserRequest(UserRequest request) {
        return ObjectJsonMapper.deserializeJson(ReqResApi.postUser(request), UserResponse.class);
    }

    public void verifyUsersResponse(UsersResponse actualResponse, int expectedTotalRecords, Map<Integer, String> expectedNames) {
        assertAll("Verification of GET UsersResponse",
                () -> assertThat("total", actualResponse.getTotal(), is(expectedTotalRecords)),
                () -> verifyDataOfUsersResponse(actualResponse.getData(), expectedNames),
                () -> assertThat("Size of page", actualResponse.getPerPage(), is(actualResponse.getData().size())));
    }

    private void verifyDataOfUsersResponse(List<DataItem> actualData, Map<Integer, String> expectedNames) {
        for (Map.Entry<Integer, String> entry : expectedNames.entrySet()) {
            String expectedName = entry.getValue();
            String actualName = actualData.stream()
                    .filter(a -> entry.getKey().equals(a.getId()))
                    .findFirst()
                    .map(DataItem::getLastName)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("User with id {%s} was not found", entry.getKey())));
            assertThat("LastName", actualName, is(expectedName));
        }
    }

    public static void verifyPostUserResponse(UserRequest request, UserResponse actualResponse) {

        final int expectedYear = Year.now().getValue();
        assertAll("Verification of POST UserResponse",
                () -> assertThat("Name", actualResponse.getName(), is(request.getName())),
                () -> assertThat("Job", actualResponse.getJob(), is(request.getJob())),
                () -> assertThat("Id", actualResponse.getId(), is(notNullValue())),
                () -> assertThat("Year", actualResponse.getCreatedAt().getYear(), is(expectedYear))
        );

    }
}
