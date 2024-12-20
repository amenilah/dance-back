package org.sid.ebankingbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VenuePlan")
public class VenuePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPlan")
    private Long idPlan;
    private Long totalSeats;
    private float length_S; // Corrigé pour 'length'
    private float width_S; // Corrigé pour 'width'
    private Long userid;
    @ElementCollection
    @CollectionTable(name = "SeatStructure")
    @MapKeyColumn(name = "rowLabel")
    @Column(name = "numberOfSeats")
    private Map<RowLabel, Integer> seatStructure;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="venuePlan", fetch = FetchType.EAGER)
    private List<Places> places; // Liste des sièges plutôt que "places"

    @OneToOne(mappedBy="venuePlan")
    @JsonIgnore
    private Venue venue;
}