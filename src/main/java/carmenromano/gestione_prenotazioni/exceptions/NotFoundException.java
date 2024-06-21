package carmenromano.gestione_prenotazioni.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Elemento con ID: " + id + " non trovato");
    }
}

