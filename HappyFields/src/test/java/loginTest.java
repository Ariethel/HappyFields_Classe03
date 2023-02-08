import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import autenticazione.*;
public class loginTest {
    autenticazioneService as = new autenticazioneServiceImpl();

    @Test
    public void testPasswordChecker(){
        String username = "annac01";
        String password = "Annachiara";
        assertTrue(as.doCheckPassword(username, password));
    }
}
