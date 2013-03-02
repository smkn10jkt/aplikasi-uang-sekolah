package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_siswa", nullable = false)
    private Siswa siswa;

    @NotNull
    @Column(name = "waktu_pembayaran", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date waktuPembayaran = new Date();
    

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String penerima;

    private String keterangan;

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public Date getWaktuPembayaran() {
        return waktuPembayaran;
    }

    public void setWaktuPembayaran(Date waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
    }
    
    
}
