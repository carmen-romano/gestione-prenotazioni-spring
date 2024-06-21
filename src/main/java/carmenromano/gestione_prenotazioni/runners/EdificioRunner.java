package carmenromano.gestione_prenotazioni.runners;

import carmenromano.gestione_prenotazioni.GestionePrenotazioniApplication;
import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.entities.Prenotazione;
import carmenromano.gestione_prenotazioni.entities.Utente;
import carmenromano.gestione_prenotazioni.services.EdificioService;
import carmenromano.gestione_prenotazioni.services.PostazioneService;
import carmenromano.gestione_prenotazioni.services.PrenotazioneService;
import carmenromano.gestione_prenotazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

            Prenotazione prenotazione = new Prenotazione(LocalDate.now(),utente,postazione);
            prenotazioneService.save(prenotazione);

        } catch (Exception ex) {
            System.err.println("Errore durante l'esecuzione dell'applicazione: " + ex.getMessage());
        } finally {
            context.close();
        }
    }}
