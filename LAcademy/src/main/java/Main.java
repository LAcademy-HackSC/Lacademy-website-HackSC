import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import org.apache.commons.logging.Log;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String path = "C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\LAcademy-11261bcdb733.json";
        Instance serviceAccount;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serviceAccount = mapper.readValue(new File(path), Instance.class);

        QuickStart.authExplicit();
        QuickStart qs = new QuickStart(serviceAccount.getProject_id());

        Login log = new Login();
        log.parseLoginJson("C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\test.json");
        //System.out.println(log.checkLogin());


    }
}
