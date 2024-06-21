package carmenromano.gestione_prenotazioni.services;

import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.exceptions.NotFoundException;
import carmenromano.gestione_prenotazioni.repositories.EdificioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EdificioService {
    @Autowired
    EdificioRepo edificioRepo;

    public void save(Edificio edificio){
        edificioRepo.save(edificio);
    }

    public Edificio findById(UUID id) {
        return edificioRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Edificio edificio = edificioRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        edificioRepo.delete(edificio);
    }
    public List<Edificio> findAll() {
        return edificioRepo.findAll();
    }
}
