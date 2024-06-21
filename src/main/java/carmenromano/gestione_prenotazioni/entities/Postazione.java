package carmenromano.gestione_prenotazioni.entities;

import carmenromano.gestione_prenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "postazione")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private  String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int numeroMassimoOccupanti;
    @ManyToOne
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazione;

    public Postazione(TipoPostazione tipoPostazione, String descrizione, int numeroMassimoOccupanti, Edificio edificio) {
        this.tipoPostazione = tipoPostazione;
        this.descrizione = descrizione;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMassimoOccupanti=" + numeroMassimoOccupanti +
                '}';
    }
}
