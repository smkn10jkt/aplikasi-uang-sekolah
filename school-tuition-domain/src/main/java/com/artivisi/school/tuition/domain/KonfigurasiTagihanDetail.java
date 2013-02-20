package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="m_konfigurasi_tagihan_detail")
public class KonfigurasiTagihanDetail {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_konfigurasi_tagihan")
    private KonfigurasiTagihan konfigurasiTagihan;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_jenis_biaya")
    private JenisBiaya jenisBiaya;

    @NotNull
    @Column(nullable = false)
    private BigDecimal nilai;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JenisBiaya getJenisBiaya() {
        return jenisBiaya;
    }

    public void setJenisBiaya(JenisBiaya jenisBiaya) {
        this.jenisBiaya = jenisBiaya;
    }

    public KonfigurasiTagihan getKonfigurasiTagihan() {
        return konfigurasiTagihan;
    }

    public void setKonfigurasiTagihan(KonfigurasiTagihan konfigurasiTagihan) {
        this.konfigurasiTagihan = konfigurasiTagihan;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}
