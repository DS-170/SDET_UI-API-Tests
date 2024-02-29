package tests.api;

import api.requests.GetRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class APITests {
    private static Response getResponse;

    @BeforeAll
    public static void setUp() {
        getResponse = GetRequest.getEntityById(1);
    }

    @Test
    public void apiGetTest() {
        /*create + get id*/

        Assertions.assertEquals(getResponse.getStatusCode(), 405);

        /*deleteById*/
    }
}
