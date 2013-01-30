package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="t_tagihan_detail")
public class TagihanDetail {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tagihan", nullable = false)
    private Tagihan tagihan;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_jenis_biaya", nullable = false)
    private JenisBiaya jenisBiaya;

    @NotNull
    @Column(name = "nilai_tagihan", nullable = false)
    private BigDecimal nilaiTagihan;

    @NotNull
    @Column(name = "nilai_dibayar", nullable = false)
    private BigDecimal nilaiDibayar = BigDecimal.ZERO;

    @NotNull
    @Column(nullable = false)
    private Boolean lunas = Boolean.FALSE;
}
