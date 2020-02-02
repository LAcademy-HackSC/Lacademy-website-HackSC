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
        String path = "C:\\Users\\tonyl\\OneDrive\\Desktop\\Lacademyweb\\tonykey.json";
        Instance serviceAccount;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serviceAccount = mapper.readValue(new File(path), Instance.class);

        QuickStart.authExplicit();
        QuickStart qs = new QuickStart(serviceAccount.getProject_id());


    Student test = new Student();
    ArrayList<HistoryTutor> testArr = test.getHistory("Student 2");
    System.out.println(testArr.get(0).getDateslist().get(0));

//        ApiFuture<QuerySnapshot> future =
//                qs.getDb().collection("Student").document("First Student").collection("History").get();
//// future.get() blocks on response
//        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//        for (DocumentSnapshot document : documents) {
//            Map<String, Object> ew = document.getData();
//            ArrayList ew2 = (ArrayList) (ew.get("Date"));
//            System.out.println(ew.get("Date"));
//            System.out.println(ew2.get(0));
//            System.out.println(document.getId() + document.getData().toString()); //+ " => " + document.toObject(String.class));
//        }






        //Login log = new Login();
        //log.parseLoginJson("C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\test.json");


    }
}
