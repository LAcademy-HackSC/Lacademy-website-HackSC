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

//        futures.add(cities.document("DC").set(new City("Washington D.C.", null, "USA", true, 680000L,
//                Arrays.asList("east_coast"))));
//        futures.add(cities.document("SF").set(new City("San Francisco", "CA", "USA", false, 860000L,
//                Arrays.asList("west_coast", "norcal"))));
//        futures.add(cities.document("LA").set(new City("Los Angeles", "CA", "USA", false, 3900000L,
//                Arrays.asList("west_coast", "socal"))));
//
//        futures.add(cities.document("TOK").set(new City("Tokyo", null, "Japan", true, 9000000L,
//                Arrays.asList("kanto", "honshu"))));
//        futures.add(cities.document("BJ").set(new City("Beijing", null, "China", true, 21500000L,
//                Arrays.asList("jingjinji", "hebei"))));

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
    }
}
