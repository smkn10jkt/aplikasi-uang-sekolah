package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="t_tahun_ajaran")
public class TahunAjaran {
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
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date mulai;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date selesai;
}
