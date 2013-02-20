package com.artivisi.school.tuition.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_tagihan")
public class Tagihan {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @Column(name = "periode_tagihan", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date periodeTagihan;
    @NotNull
    @Column(name = "jatuh_tempo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date jatuhTempo;

    @OneToMany(mappedBy = "tagihan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TagihanDetail> daftarTagihanDetail = new ArrayList<TagihanDetail>();

    public List<TagihanDetail> getDaftarTagihanDetail() {
        return daftarTagihanDetail;      
    }
      public void setDaftarTagihanDetail(List<TagihanDetail> daftarTagihanDetail) {
        this.daftarTagihanDetail = daftarTagihanDetail;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPeriodeTagihan() {
        return periodeTagihan;
    }

    public void setPeriodeTagihan(Date periodeTagihan) {
        this.periodeTagihan = periodeTagihan;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }
    
}
