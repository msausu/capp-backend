package sa.m.ntd.calculator.controller;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class OperationControllerIT {

    private static final String REPORT_ENDPOINT = "http://localhost:8080/api/v1/report";
    private static final String OPERATION_ENDPOINT = "http://localhost:8080/api/v1/calculator";

    @Test
    @Order(5)
    void getReportTest() {
        final String username = "john@gmail.com", password = "john0000";
        Arrays.asList(
                REPORT_ENDPOINT
                ).forEach(url -> {
            given().auth().preemptive().basic(username, password)
                    .log().all()
                    .when().get(url)
                    .then().assertThat().statusCode(HttpStatus.OK.value()).log().all();
        });
    }

    @Test
    @Order(10)
    void additionTest() throws JSONException {
        final String username = "mary@gmail.com", password = "mary0000";
        JSONObject operation = new JSONObject();
        operation.put("operation", "ADDITION");
        operation.put("amount", "1 1");
        given().auth().preemptive().basic(username, password)
                .contentType(ContentType.JSON).body(operation.toString()).log().all()
                .when().post(OPERATION_ENDPOINT)
                .then().assertThat().statusCode(HttpStatus.OK.value()).log().all();
    }

}