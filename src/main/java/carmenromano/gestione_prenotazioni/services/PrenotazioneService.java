package carmenromano.gestione_prenotazioni.services;

import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import carmenromano.gestione_prenotazioni.exceptions.NotFoundException;
import carmenromano.gestione_prenotazioni.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepo prenotazioneRepo;

    public void save(Prenotazione prenotazione){
        prenotazioneRepo.save(prenotazione);
    }

    public Prenotazione findById(UUID id) {
        return prenotazioneRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Prenotazione prenotazione = prenotazioneRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        prenotazioneRepo.delete(prenotazione);
    }
}
