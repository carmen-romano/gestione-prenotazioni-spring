package carmenromano.gestione_prenotazioni.repositories;

import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepo extends JpaRepository<Postazione, UUID> {
    List<Postazione> findByTipoPostazioneAndEdificio_Città(TipoPostazione tipoPostazione, String citta);


}
