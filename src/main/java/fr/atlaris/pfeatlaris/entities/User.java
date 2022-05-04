package fr.atlaris.pfeatlaris.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Proxy(lazy = false)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "U_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "U_LAST_NAME")
    @EqualsAndHashCode.Include
    private String lastName;
    @Column(name = "U_FIRST_NAME")
    @EqualsAndHashCode.Include
    private String firstName;
    @Column(name = "U_ADRESS")
    @EqualsAndHashCode.Include
    private String adress;
    @Column(name = "U_FAX")
    @EqualsAndHashCode.Include
    private String fax;
    @Column(name = "U_EMAIL")
    @EqualsAndHashCode.Include
    private String email;
    @Column(name = "U_CITY")
    @EqualsAndHashCode.Include
    private String city;
    @Column(name = "U_PICURE")
    @EqualsAndHashCode.Include
    private String picture;
    @Column(name = "U_ACTIVE")
    @EqualsAndHashCode.Include
    private boolean active;
    @Column(name = "U_DATE_NESS")
    @EqualsAndHashCode.Include
    private LocalDateTime dateNaissanced;
    @Column(name = "U_DATE_CREATED")
    @EqualsAndHashCode.Include
    private LocalDateTime dateCreated;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Group> groups=new ArrayList<>();
    @Column(name = "U_USER_NAME")
    private String userName;
    @Column(name = "U_PASSWORD")
    private String password;
    @Column(name = "U_CIN")
    private String cin;
    @Column(name = "U_MATFISC")
    private String matriculeFiscale;
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Demande> demandes;
    @JsonIgnore
    @OneToOne
    private Contrat contrat;


}

