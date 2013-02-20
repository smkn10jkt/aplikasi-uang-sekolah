package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="t_pembayaran_detail")
public class PembayaranDetail {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_pembayaran", nullable = false)
    private Pembayaran pembayaran;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tagihan_detail", nullable = false)
    private TagihanDetail tagihanDetail;

    @NotNull
    @Column(nullable = false)
    private BigDecimal nilai;

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

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public TagihanDetail getTagihanDetail() {
        return tagihanDetail;
    }

    public void setTagihanDetail(TagihanDetail tagihanDetail) {
        this.tagihanDetail = tagihanDetail;
    }
    
    

}
