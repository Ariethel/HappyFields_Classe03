import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.Gestore;
import model.Utente;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import registrazione.*;
import java.util.stream.Stream;
import gestioneDatiGestore.*;




public class modificaDatiTest {
    gestioneGestoreService mds = new gestioneGestoreImpl();

    public static Stream<Arguments> provideUserInfo() {
        return Stream.of(
                Arguments.of("Antonio Paolo Giovanni Tammaro Aniello Dos Santos Da Lima", "carlos2121!T", "SA", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Carlos!!$", "carlos2121!T", "SA", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Antonio", "carlos2121!T", "SA", "", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Antonio", "carlos2121!T", "Sale", "Fisciano", "Via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Antonio", "carlos2121!T", "SA", "Fisciano", "via Circumvallazione Tuoro Contrada Pietà 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Antonio", "Carlos", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627 ),
                Arguments.of("Antonio", "carlos21??", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627),
                Arguments.of("Antonio", "Carlos2121!", "SA", "Fisciano", "via Circumvallazione 8", "iban", "preferenza", 1245613627)
        );
    };



}
