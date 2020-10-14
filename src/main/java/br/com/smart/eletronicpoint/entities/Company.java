package br.com.smart.eletronicpoint.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "creation_date", nullable = false)
    private Date dataCriacao;

    @Column(name = "update_date", nullable = false)
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employer> funcionarios;

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
