package Controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import Model.Penghuni;
import Service.PenghuniService;

/**
 * FruitResource
 */

@Path("/penghuni")
public class PenghuniResource {

    @Inject
    PenghuniService penghuniService;

    @GET
    public List<Penghuni> listPenghuni() {
        return penghuniService.getPenghuni();
    }

    @GET
    @Path("/{id}")
    public Penghuni get(UUID id) {
        return penghuniService.getPenghuniByUUID(id);
    }

    @POST
    public List<Penghuni> create(Penghuni penghuni) {
        return penghuniService.createPenghuni(penghuni);
    }

    @PUT
    @Path("/{id}")
    public Penghuni update(UUID id, Penghuni penghuni) {
        return penghuniService.updatePenghuni(id, penghuni);
    }

    @DELETE
    @Path("/{id}")
    public List<Penghuni> delete(UUID id) {
        return penghuniService.deletePenghuni(id);

    }

}