package fr.atlaris.pfeatlaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_ENQUETE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class Enquete {
    @Id
    @Column(name = "ENQUETE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @JsonIgnore
    @Column(name = "ENQUETE_DATE")
    @EqualsAndHashCode.Include
    private LocalDateTime dateEnquete;
    @JsonIgnore
    @Column(name = "ENQUETE_DATE_CLOTURER")
    @EqualsAndHashCode.Include
    private LocalDateTime dateFiniEnquete;
    @Column(name = "ENQUETE_STATE")
    @EqualsAndHashCode.Include
    @JsonIgnore
    private int state;
    @OneToOne
    private Demande demande;
    private String pathRapport;

}
