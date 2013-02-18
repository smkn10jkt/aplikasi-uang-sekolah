package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="m_konfigurasi_tagihan")
public class KonfigurasiTagihan {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @NotEmpty
    @Column(name = "kode", nullable = false, unique = true)
    private String kode;

    @NotNull
    @NotEmpty
    @Column(name = "nama")
    private String nama;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_kelas", nullable = false)
    private Kelas kelas;

    @OneToMany(mappedBy = "konfigurasiTagihan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KonfigurasiTagihanDetail> daftarKonfigurasiTagihanDetail
            = new ArrayList<KonfigurasiTagihanDetail>();

    public List<KonfigurasiTagihanDetail> getDaftarKonfigurasiTagihanDetail() {
        return daftarKonfigurasiTagihanDetail;
    }

    public void setDaftarKonfigurasiTagihanDetail(List<KonfigurasiTagihanDetail> daftarKonfigurasiTagihanDetail) {
        this.daftarKonfigurasiTagihanDetail = daftarKonfigurasiTagihanDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}
