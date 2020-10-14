package br.com.smart.eletronicpoint.entities;


import br.com.smart.eletronicpoint.enums.ProfileEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "employer")
public class Employer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "hour_value", nullable = false)
    private BigDecimal hourValue;

    @Column(name = "cnt_hour_work", nullable = false)
    private Float cntHourWorkDay;

    @Column(name = "cnt_hour_lunch", nullable = false)
    private Float cntHourLunch;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private ProfileEnum profile;

    @Column(name = "creation_date", nullable = false)
    private Date dataCriacao;

    @Column(name = "update_date", nullable = false)
    private Date dataAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entry> entrys;

    @PrePersist
    public void prePersist(){
        final Date currentDate = new Date();
        this.dataCriacao = currentDate;
        this.dataAtualizacao = currentDate;
    }

    @PreUpdate
    public void preUpdate(){
        this.dataAtualizacao = new Date();
    }

}
