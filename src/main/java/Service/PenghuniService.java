package Service;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;

import Model.Penghuni;

@ApplicationScoped
public class PenghuniService {
    public List<Penghuni> getPenghuni() {
        List<Penghuni> listPenghuni = Penghuni.listAll();
        return listPenghuni;
    }

    public Penghuni getPenghuniByUUID(UUID id) {
        return Penghuni.findById(id);
    }

    @Transactional
    public List<Penghuni> createPenghuni(Penghuni penghuni) {
        penghuni.id = UUID.randomUUID();
        penghuni.persist();
        return Penghuni.listAll();
    }

    @Transactional
    public Penghuni updatePenghuni(UUID id, Penghuni penghuni) {
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

    @Transactional
    public List<Penghuni> deletePenghuni(UUID id) {
        Penghuni entity = Penghuni.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
        return Penghuni.listAll();
    }

}
