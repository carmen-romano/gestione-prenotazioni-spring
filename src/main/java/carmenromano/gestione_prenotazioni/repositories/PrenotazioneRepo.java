package carmenromano.gestione_prenotazioni.repositories;

import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, UUID> {

    List<Prenotazione> findByPostazioneIdAndDataPrenotazione(UUID postazioneId, LocalDate dataPrenotazione);

    boolean existsByUtenteIdAndDataPrenotazione(UUID utenteId, LocalDate dataPrenotazione);
}


