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

}
