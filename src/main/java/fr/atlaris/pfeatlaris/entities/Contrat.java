package fr.atlaris.pfeatlaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_CONTRAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "DEMANDE_DATE_DEBUT_CONTRAT")
    @EqualsAndHashCode.Include
    private LocalDateTime dateDebutContrat;
    @Column(name = "DEMANDE_DATE_FIN_CONTRAT")
    @EqualsAndHashCode.Include
    private LocalDateTime dateFinContrat;
    @OneToOne
    private  User client;
    @JsonIgnore
    @OneToOne
    private DetailContrat detailContrat;




}
