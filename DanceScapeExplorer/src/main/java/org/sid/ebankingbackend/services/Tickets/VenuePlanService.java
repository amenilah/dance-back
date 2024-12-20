package org.sid.ebankingbackend.services.Tickets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.sid.ebankingbackend.entities.Places;
import org.sid.ebankingbackend.entities.RowLabel;
import org.sid.ebankingbackend.entities.Venue;
import org.sid.ebankingbackend.entities.VenuePlan;
import org.sid.ebankingbackend.repository.Tickets.PlacesRepository;
import org.sid.ebankingbackend.repository.Tickets.VenuePlanRepository;
import org.sid.ebankingbackend.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Data
@Builder
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class VenuePlanService implements IVenuePlanService{
    VenuePlanRepository venuePlanRepository;
    PlacesRepository placesRepository;
    @Autowired
    private VenueRepository venueRepository;

    public VenuePlanService() {

    }

    @Override
    public List<VenuePlan> GetAllTheatrePlan() {
        return venuePlanRepository.findAll();

    }

    @Override
    public void GetTheatrePlan(Long id) {
        venuePlanRepository.findById(id);
    }
    @Transactional
    public VenuePlan addTheatrePlanWithSeats(VenuePlan plan, Long venueId) {
        Venue venue = venueRepository.findById(venueId).get();
        plan.setVenue(venue);
        // Enregistre d'abord le TheatrePlan
         VenuePlan savedPlan = venuePlanRepository.save(plan);

        // Génère et enregistre les sièges en fonction de la structure des sièges
        for (Map.Entry<RowLabel, Integer> entry : savedPlan.getSeatStructure().entrySet()) {
            RowLabel rowLabel = entry.getKey();
            int numberOfSeatsInRow = entry.getValue();

            for (int seatNumber = 1; seatNumber <= numberOfSeatsInRow; seatNumber++) {
                Places seat = new Places(); // Crée un nouveau siège
                seat.setRowLabel(rowLabel); // Définit le label de la rangée
                seat.setSeatNumber(Long.valueOf(seatNumber)); // Définit le numéro de siège
                seat.setVenuePlan(savedPlan); // Associe le siège au plan du théâtre
                placesRepository.save(seat); // Enregistre le siège
            }
        }
        venue.setVenuePlan(savedPlan);
        venueRepository.save(venue);

        return savedPlan; // Renvoie le plan de théâtre avec ses sièges associés
    }

    @Override
    public VenuePlan ModifyTheatrePlan(VenuePlan plan) {
        return null;
    }




    @Override
    public void DeletTheatrePlan(Long id) {
        venuePlanRepository.deleteById(id);

    }

}