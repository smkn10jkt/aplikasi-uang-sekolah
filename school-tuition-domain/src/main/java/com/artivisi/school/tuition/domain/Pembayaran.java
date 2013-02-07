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
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuPembayaran = new Date();

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String penerima;

    private String keterangan;

    @OneToMany(mappedBy = "pembayaran", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PembayaranDetail> daftarPembayaranDetail = new ArrayList<PembayaranDetail>();
}
