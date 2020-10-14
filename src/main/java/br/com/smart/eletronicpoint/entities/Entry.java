package br.com.smart.eletronicpoint.entities;

import br.com.smart.eletronicpoint.enums.TypeEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "localization", nullable = false)
    private String localization;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEnum type;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employer employer;

    @Column(name = "creation_date", nullable = false)
    private Date dataCriacao;

    @Column(name = "update_date", nullable = false)
    private Date dataAtualizacao;

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
