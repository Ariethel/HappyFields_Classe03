import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Campo;
import model.Gestore;
import model.Utente;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import registrazione.*;
import java.util.stream.Stream;
import gestioneDatiGestore.*;




public class modificaDatiTest {
    gestioneGestoreService gs = new gestioneGestoreImpl();

    public static Stream<Arguments> provideUserInfo() {
        return Stream.of(
                // Numero giocatori troppo alto
                Arguments.of("bombonera","M. Lenzi",13,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40),
                // Città troppo lunga
                Arguments.of("bombonera","M. Lenzi",11,"SA", "AvellinoviaguidoD'orso", "Via Circumvallazione 8", 120, 100, 40),
                // Provincia troppo lunga
                Arguments.of("bombonera","M.Lenzi",11,"SAL", "Avellino", "Via Circumvallazione 8", 120, 100, 40),
                // Via troppo lunga
                Arguments.of("bombonera","M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8 Antonello Di Dio", 120, 100, 40),
                // Costo troppo alto
                Arguments.of("bombonera","M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 620, 100, 40),
                // Lunghezza troppo lunga
                Arguments.of("bombonera","M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 500, 40),
                // Larghezza troppo lunga
                Arguments.of("bombonera","M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 140),
                // Nome troppo lungo
                Arguments.of("bombonera","M.Lenzi Anto Di Capuo   ",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40),
                // Nome con caratteri speciali
                Arguments.of("bombonera","M.Lenzi!;",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40),
                // Il test va a buon fine
                Arguments.of("bombonera","M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40)
        );
    };

    @ParameterizedTest
    @MethodSource("provideUserInfo")
    public void testModificaCampi(String idc, String nome, int num_giocatori, String provincia, String citta, String via, double costo, double lunghezza, double larghezza){
        assertTrue(gs.doModificaCampo(idc,nome,num_giocatori,provincia,citta,via,costo,lunghezza,larghezza));

    }



}
