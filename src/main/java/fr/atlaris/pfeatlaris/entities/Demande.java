package fr.atlaris.pfeatlaris.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_DEMANDE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class Demande {
    @Id
    @Column(name = "DEMANDE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "DEMANDE_DATE_CREATED")
    @EqualsAndHashCode.Include
    private LocalDateTime dateCreated;
    @Column(name = "DEMANDE_DATE_ACCEPTED")
    @EqualsAndHashCode.Include
    private LocalDateTime dateAccpted;
    @Column(name = "DEMANDE_STATE")
    @EqualsAndHashCode.Include
    private int state;
    @Column(name = "DEMANDE_TYPE")
    @EqualsAndHashCode.Include
    private String type;
    @Column(name = "DEMANDE_NAME_SOCIETE")
    @EqualsAndHashCode.Include
    private String nameSociéte;
    @Column(name = "DEMANDE_MATRICULE_FISCAL_SOCIETE")
    @EqualsAndHashCode.Include
    private String matriculeFiscalSociete;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name ="U_ID" ,referencedColumnName = "U_ID")
    private  User client;



    public Demande(Long id, String type, String nameSociéte, String matriculeFiscalSociete) {
        this.id = id;
        this.type = type;
        this.nameSociéte = nameSociéte;
        this.matriculeFiscalSociete = matriculeFiscalSociete;
    }

}
