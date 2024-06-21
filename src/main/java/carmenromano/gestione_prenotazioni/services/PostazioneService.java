package carmenromano.gestione_prenotazioni.services;

import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.exceptions.NotFoundException;
import carmenromano.gestione_prenotazioni.repositories.EdificioRepo;
import carmenromano.gestione_prenotazioni.repositories.PostazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepo postazioneRepo;

    @Autowired
    private EdificioRepo edificioRepo;

    @Transactional
    public void save(Postazione postazione) {
        Edificio edificio = postazione.getEdificio();
        if (edificio.getId() == null) {
            edificio = edificioRepo.save(edificio);
        }
        postazione.setEdificio(edificio);
        postazioneRepo.save(postazione);
    }

    public Postazione findById(UUID id) {
        return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Transactional
    public void findByIdAndDelete(UUID id) {
        Postazione postazione = postazioneRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        postazioneRepo.delete(postazione);
    }
}
