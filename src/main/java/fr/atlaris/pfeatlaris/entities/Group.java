package fr.atlaris.pfeatlaris.entities;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "T_GROUPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "GR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "GR_PRIVILEGED", unique = true, nullable = false)
    private String privileged;

}