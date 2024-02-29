package tests.api;

import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    static Response createResponse;
    static Response deleteResponse;
    static String id;

    @BeforeAll
    public static void setUp() {
        createResponse = CreateRequest.createEntity();
        id = createResponse.getBody().asString();
    }

    @AfterAll
    public static void tearDown() {
        deleteResponse = DeleteRequest.deleteEntityByID(id);
    }
}
