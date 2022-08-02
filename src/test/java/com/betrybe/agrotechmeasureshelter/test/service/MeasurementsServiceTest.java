package com.betrybe.agrotechmeasureshelter.test.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.repository.MeasurementsRepository;
import com.betrybe.agrotechmeasureshelter.service.MeasurementsService;
import com.mongodb.assertions.Assertions;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class MeasurementsServiceTest {

  @InjectMock
  MeasurementsService measurementsService;

  @InjectMock
  MeasurementsRepository measurementsRepository;

  @BeforeAll
  public static void setup() {
    List<Measurements> mockList = new ArrayList<Measurements>();
    Measurements mockMeasurement = new Measurements("507f1f77bcf86cd799439011", 15.33, 3.33, 3.33);
    MeasurementsRepository mockRepository = Mockito.mock(MeasurementsRepository.class);
    Mockito.when(mockRepository.listAll()).thenReturn(mockList);
    QuarkusMock.installMockForType(mockRepository, MeasurementsRepository.class);
  }

  @Test
  public void testListAllMeasurements() {
    List<Measurements> emptyList = measurementsService.list();
    Assertions.assertTrue(emptyList.size() == 0);
  }

}
