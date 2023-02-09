import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import autenticazione.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class loginTest {
    autenticazioneService as = new autenticazioneServiceImpl();

    public static Stream<Arguments> providesStringForPasswordChecker() {
        return Stream.of(
                Arguments.of("annac01", "Annachiara"),
                Arguments.of("provaErrore", "errore")
        );
    }

    @ParameterizedTest
    @MethodSource("providesStringForPasswordChecker")
    public void testPasswordChecker(String username, String password){
        assertTrue(as.doCheckPassword(username, password));
    }


}
