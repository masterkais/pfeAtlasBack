package fr.atlaris.pfeatlaris.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "T_DETAIL_CONTRAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class DetailContrat {
    @Id
    @Column(name = "DETAIL_CONTRAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @OneToOne( fetch = FetchType.LAZY)
    private Contrat contrat;

}
