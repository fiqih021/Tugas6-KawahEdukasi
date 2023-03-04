package Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Penghuni extends PanacheEntityBase {
    @Id
    @Column(name = "id", nullable = false)
    public UUID id;
    public String nama;
    public String asal;
    public String nik;
    public String jenisKelamin;
    public String noHp;

    public Penghuni(UUID id, String nama, String asal, String nik, String jenisKelamin, String noHp) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.noHp = noHp;
    }

    public Penghuni() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

}
