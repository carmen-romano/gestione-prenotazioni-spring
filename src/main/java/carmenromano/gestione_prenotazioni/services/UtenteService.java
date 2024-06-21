package carmenromano.gestione_prenotazioni.services;

import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import carmenromano.gestione_prenotazioni.entities.Utente;
import carmenromano.gestione_prenotazioni.exceptions.NotFoundException;
import carmenromano.gestione_prenotazioni.repositories.EdificioRepo;
import carmenromano.gestione_prenotazioni.repositories.PostazioneRepo;
import carmenromano.gestione_prenotazioni.repositories.PrenotazioneRepo;
import carmenromano.gestione_prenotazioni.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    UtenteRepo utenteRepo;

    public void save(Utente utente){
        utenteRepo.save(utente);
    }

    public Utente findById(UUID id) {
        return utenteRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Utente utente = utenteRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        utenteRepo.delete(utente);
    }
}
