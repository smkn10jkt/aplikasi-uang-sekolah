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
}
