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

}
