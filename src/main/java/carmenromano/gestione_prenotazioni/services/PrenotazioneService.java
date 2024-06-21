package carmenromano.gestione_prenotazioni.services;

import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import carmenromano.gestione_prenotazioni.exceptions.NotFoundException;
import carmenromano.gestione_prenotazioni.repositories.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepo prenotazioneRepo;

    public void save(Prenotazione prenotazione) {
        UUID utenteId = prenotazione.getUtente().getId();
        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        UUID postazioneId = prenotazione.getPostazione().getId();

        if (!isPostazioneLibera(postazioneId, dataPrenotazione)) {
            throw new RuntimeException("La postazione non è disponibile per la data: " + dataPrenotazione);
        }

        if (prenotazioneRepo.findByUtenteIdAndDataPrenotazione(utenteId, dataPrenotazione)) {
            throw new RuntimeException("L'utente con ID " + utenteId + " ha già una prenotazione per la data " + dataPrenotazione);
        }

        prenotazioneRepo.save(prenotazione);
        System.out.println("Prenotazione salvata con successo.");
    }

    public Prenotazione findById(UUID id) {
        return prenotazioneRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Prenotazione prenotazione = prenotazioneRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        prenotazioneRepo.delete(prenotazione);
    }
    public boolean isPostazioneLibera(UUID postazioneId, LocalDate data) {
        List<Prenotazione> prenotazioni = prenotazioneRepo.findByPostazioneIdAndDataPrenotazione(postazioneId, data);
        return prenotazioni.isEmpty();
    }
}
