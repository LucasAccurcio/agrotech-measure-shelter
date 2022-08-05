package com.betrybe.agrotechmeasureshelter.test.resource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.service.MeasurementsService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusMock;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import java.util.List;
import java.util.ArrayList;
import javax.inject.Inject;

@QuarkusTest
public class MeasurementsResourceTest {

  @Inject
  MeasurementsService measurementsService;

  @BeforeAll
  public static void setup() {
    List<Measurements> mockList = new ArrayList<Measurements>();
    Measurements mockMeasurement = new Measurements("507f1f77bcf86cd799439011", 15.33, 3.33, 3.33);
    MeasurementsService mockService = Mockito.mock(MeasurementsService.class);
    Mockito.when(mockService.list()).thenReturn(mockList);
    Mockito.doNothing().when(mockService).add(mockMeasurement);
    QuarkusMock.installMockForType(mockService, MeasurementsService.class);
  }

  @Test
  public void testSuccesfulGetRequest() {
    given().when().get("/measurements").then().statusCode(200).body(containsString("[]"));
  }

  @Test
  public void testSuccesfulPostRequest() {
    Measurements mockMeasurement = new Measurements("507f1f77bcf86cd799439011", 15.33, 3.33, 3.33);
    given().body(mockMeasurement).header("Content-Type", "application/json").when()
        .post("/measurements").then().statusCode(201);
  }
}
