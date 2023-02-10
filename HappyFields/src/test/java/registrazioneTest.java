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

    public static Stream<Arguments> providesStringForPasswordChecker() {
        return Stream.of(
                Arguments.of("annac01", "Annachiara"), // Username e password esistenti
                Arguments.of("root", "errore"), // Username esistente, password nuova
                Arguments.of("provaErrore", "errore"), // Username e password nuovi
                Arguments.of("", ""), // Username e password vuoti
                Arguments.of("!!231", "errore") // Username con caratteri fuori dal range
        );
    }

    @ParameterizedTest
    @MethodSource("providesStringForPasswordChecker")
    public void testUserRegister(String username, String password){
        Utente u = new Utente(username, password, "NA", "citta", "via", "1234567890", "basket", 123123123);
        assertTrue(rs.doAddUser(u));

    }

    @ParameterizedTest
    @MethodSource("providesStringForPasswordChecker")
    public void testManagerRegister(String username, String password){
        Gestore g = new Gestore(username, password, "NA", "citta", "via", "1234567890", "basket", "123123123", 123123123);
        assertTrue(rs.doAddManager(g));
    }



}
