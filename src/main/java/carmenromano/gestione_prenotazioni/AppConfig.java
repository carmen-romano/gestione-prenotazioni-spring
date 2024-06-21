package carmenromano.gestione_prenotazioni;

import carmenromano.gestione_prenotazioni.entities.Edificio;
import carmenromano.gestione_prenotazioni.entities.Postazione;
import carmenromano.gestione_prenotazioni.entities.Utente;
import carmenromano.gestione_prenotazioni.enums.TipoPostazione;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;
import java.util.Random;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    Faker faker = new Faker(new Locale("it"));

    @Bean(name = "edificio")
    public Edificio getEdificio(){
        String nome = faker.company().name();
        String città = faker.address().city();
        String indirizzo = faker.address().streetAddress();
        return new Edificio(nome,città,indirizzo);
    }

    @Bean(name = "postazione")
    public Postazione getPostazione(){
        Random random = new Random();
        TipoPostazione tipoPostazione = TipoPostazione.values()
                [random.nextInt(TipoPostazione.values().length)];
        String descrizione = faker.company().catchPhrase();
        int numeroMassimoOccupanti = faker.number().numberBetween(1, 100);
        return new Postazione(tipoPostazione,descrizione,numeroMassimoOccupanti,getEdificio());
    }


    @Bean(name = "utente")
    public Utente getUtente(){
        String nome = faker.name().firstName();
        String cognome = faker.name().lastName();
        String username = faker.name().username();
        String email = faker.internet().emailAddress().toString();
        return new Utente(username,email,cognome,nome);
    }


}
