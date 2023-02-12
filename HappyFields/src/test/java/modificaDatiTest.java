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
                Arguments.of("bombonera","avellino",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40)
                /*Arguments.of("M.Lenzi",11,"SA", "AvellinoviaguidoD'orso", "Via Circumvallazione 8", 120, 100, 40),
                Arguments.of("M.Lenzi",11,"SAL", "Avellino", "Via Circumvallazione 8 Antonello Italiano", 120, 100, 40),
                Arguments.of("M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8 Antonello Di Dio", 120, 100, 40),
                Arguments.of("M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 620, 100, 40),
                Arguments.of("M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 500, 40),
                Arguments.of("M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 140),
                Arguments.of("M.Lenzi",11,"SA", "Avellino", "Via Circumvallazione 8", 120, 100, 40)*/
        );
    };

    @ParameterizedTest
    @MethodSource("provideUserInfo")
    public void testModificaCampi(String idc, String nome, int num_giocatori, String provincia, String citta, String via, double costo, double lunghezza, double larghezza){
        assertTrue(gs.doModificaCampo(idc,nome,num_giocatori,provincia,citta,via,costo,lunghezza,larghezza));

    }



}
