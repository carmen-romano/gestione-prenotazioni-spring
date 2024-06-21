package carmenromano.gestione_prenotazioni.runners;

import carmenromano.gestione_prenotazioni.GestionePrenotazioniApplication;
import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import carmenromano.gestione_prenotazioni.entities.Utente;
import carmenromano.gestione_prenotazioni.enums.TipoPostazione;
import carmenromano.gestione_prenotazioni.services.EdificioService;
import carmenromano.gestione_prenotazioni.services.PostazioneService;
import carmenromano.gestione_prenotazioni.services.PrenotazioneService;
import carmenromano.gestione_prenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class EdificioRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
        try {
            Edificio edificio = context.getBean("edificio", Edificio.class);
            edificioService.save(edificio);

            Utente utente = context.getBean("utente", Utente.class);
            utenteService.save(utente);

            Postazione postazione = context.getBean("postazione", Postazione.class);
            postazioneService.save(postazione);

           Utente utenteFound= utenteService.findById(UUID.fromString("f941621a-9afc-4c3d-a2ff-badcc6bc6dc1"));
           Postazione postazione2= postazioneService.findById(UUID.fromString("05bfc95a-0e41-4338-8817-1fa0ea2d17c8"));


            Prenotazione prenotazione = new Prenotazione(LocalDate.now(),utenteFound,postazione2);
            prenotazioneService.save(prenotazione);
            utenteService.ricercaPostazioni(TipoPostazione.SALA_RIUNIONI, "Serr umbro");


        } catch (Exception ex) {
            System.err.println("Errore durante l'esecuzione dell'applicazione: " + ex.getMessage());
        } finally {
            context.close();
        }
    }}
