import org.testng.annotations.DataProvider;

import java.util.UUID;


public class ParameterProvider {

    @DataProvider(name = "incorrectCredentialValues")
    public Object[][] provideIncorrectCredentials() {
        return new Object[][] {
                {"", ""},
                {"test@gmail.com", "qwerrtyyy"},
                {"insert into table...", "insert into table..."},
                {UUID.randomUUID().toString(), UUID.randomUUID().toString()}
        };
    }
}





