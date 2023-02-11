import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Gestore;
import model.Utente;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import registrazione.*;
import java.util.stream.Stream;

public class registrazioneTest {
    registrazioneService rs = new registrazioneServiceImpl();

    public static Stream<Arguments> provideUserInfo() {
        return Stream.of(
                // Nome troppo lungo
                Arguments.of("Antonio Paolo Giovanni Tammaro Aniello Dos Santos Da Lima", "carlos2121!T", "SA", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                // Nome con caratteri speciali
                Arguments.of("Carlos!!$", "carlos2121!T", "SA", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                // Citta vuota
                Arguments.of("Antonio", "carlos2121!T", "SA", "", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                // Provincia troppo lunga
                Arguments.of("Antonio", "carlos2121!T", "Sale", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                // Via troppo lunga
                Arguments.of("Antonio", "carlos2121!T", "SA", "Fisciano", "via Circumvallazione Tuoro Contrada Pietà 8", "iban", "preferenza", 1245613627 ),
                // Password troppo corta e senza caratteri speciali
                Arguments.of("Antonio", "Carlos", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                // Password senza lettera maiuscola
                Arguments.of("Antonio", "carlos21??", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627),
                // Inserimento corretto
                Arguments.of("Antonio", "Carlos2121!", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627)
                );
    }

    @ParameterizedTest
    @MethodSource("provideUserInfo")
    public void testUserRegister(String username, String password, String provincia, String citta, String via, String iban, String preferenza, long telefono){
        Utente u = new Utente(username, password, provincia, citta, via, iban, preferenza, telefono);
        assertTrue(rs.doAddUser(u));
    }

}
