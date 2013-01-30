package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_kelas")
public class Kelas {
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
    @JoinColumn(name = "id_tahun_ajaran", nullable = false)
    private TahunAjaran tahunAjaran;
}
