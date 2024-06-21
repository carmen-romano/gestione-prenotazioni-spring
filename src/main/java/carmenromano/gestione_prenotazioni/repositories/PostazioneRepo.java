package carmenromano.gestione_prenotazioni.repositories;

import carmenromano.gestione_prenotazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, UUID> {
}
