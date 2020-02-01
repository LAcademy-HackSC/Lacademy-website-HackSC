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


        // Stuff to test adding stuff to database.
        CollectionReference cities = qs.getDb().collection("cities");
        List<ApiFuture<WriteResult>> futures = new ArrayList<>();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", "San Francisco");
        data1.put("state", "CA");
        data1.put("country", "USA");
        data1.put("capital", false);
        data1.put("population", 860000);
        data1.put("regions", Arrays.asList("west_coast", "norcal"));
        cities.document("SF").set(data1);
        ApiFutures.allAsList(futures).get();

       // DocumentReference docRef = qs.getDb().collection("cities").document("SF");
        DocumentReference docRef = qs.getDb().collection("cities").document("SF");
// asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
// ...
// future.get() blocks on response
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }

//        Map<String, String> doc = new HashMap<String, String>();
//        doc.put("name", "Los Angeles");
//        doc.put("state", "CA");
//        doc.put("country", "USA");
//        ApiFuture<WriteResult> future = qs.getDb().collection("cities").document("LA").set(doc);
//        System.out.println("Update time: " + future.get().getUpdateTime());
//        System.out.println();

//
//        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
//                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                        .build();
//
//        Firestore db = firestoreOptions.getService();
    }
}
