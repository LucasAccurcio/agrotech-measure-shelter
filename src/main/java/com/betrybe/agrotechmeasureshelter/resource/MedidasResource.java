package com.betrybe.agrotechmeasureshelter.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.betrybe.agrotechmeasureshelter.model.Measurements;
import com.betrybe.agrotechmeasureshelter.service.MedidasService;

@Path("/medidas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedidasResource {

  @Inject
  MedidasService medidasService;

  @POST
  public Response create(Measurements measurements) {
    medidasService.add(measurements);
    return Response.status(201).build();
  }

  @GET
  public List<Measurements> listAll() {
    return medidasService.list();
  }
}
