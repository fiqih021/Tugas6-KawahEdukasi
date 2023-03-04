package Controller;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import Model.Penghuni;

/**
 * FruitResource
 */
@Path("/penghuni")
public class PenghuniResource {

    @GET
    public List<Penghuni> listPenghuni() {
        List<Penghuni> listPenghuni = Penghuni.listAll();
        return listPenghuni;
    }

    @GET
    @Path("/{id}")
    public Penghuni get(UUID id) {
        return Penghuni.findById(id);
    }

    @POST
    @Transactional
    public List<Penghuni> create(Penghuni penghuni) {
        penghuni.id = UUID.randomUUID();
        penghuni.persist();
        return Penghuni.listAll();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Penghuni update(UUID id, Penghuni penghuni) {
        Penghuni entity = Penghuni.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the Penghuni parameter to the existing entity
        entity.asal = penghuni.asal;
        entity.jenisKelamin = penghuni.jenisKelamin;
        entity.nama = penghuni.nama;
        entity.nik = penghuni.nik;
        entity.noHp = penghuni.noHp;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(UUID id) {
        Penghuni entity = Penghuni.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }

}