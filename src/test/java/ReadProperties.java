import com.infy.qa.base.TestBase;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties  {

        static WebDriver driver;

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties (  );
        FileInputStream ip = new FileInputStream ("/Users/rajeev.kumar/git/" +
                "OradianInfyTask/src/main/java/com/infy/qa/config/config.properties"  );

        prop.load ( ip );

        //System.out.println (prop.getProperty ( "url" ) );
        System.out.println (prop.getProperty (  "name" ));
        System.out.println (prop.get (  "age    " ));

        String url = prop.getProperty ( "URL" );
        System.out.println (url );






    }
}
