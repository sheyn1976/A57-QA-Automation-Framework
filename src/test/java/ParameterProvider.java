import org.testng.annotations.DataProvider;

import java.util.UUID;

public class ParameterProvider{
    @DataProvider(name = "IncorrectCredentialValues")
    public Object[][] provideIncorrectCredentials() {
        return new Object[][]{
                {"", ""},
                {"i@testpro.io", "$33wrong"},
                {"insert into table...", "insert into table..."},
                {UUID.randomUUID().toString(),UUID.randomUUID().toString()}
                //  {"ilya.sheynblat+1@testpro.io","$Ma1947va"}
        };
    }
}
