package carmenromano.gestione_prenotazioni.repositories;

import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, UUID> {
}
