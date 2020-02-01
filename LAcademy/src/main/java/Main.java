import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String path = "C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\LAcademy-11261bcdb733.json";
        Instance serviceAccount;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serviceAccount = mapper.readValue(new File(path), Instance.class);

        QuickStart.authExplicit("C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\lacademy-e1e8a-firebase-adminsdk-ybrvw-1f4a96ef88.json");
        QuickStart qs = new QuickStart(serviceAccount.getProject_id());


        // Stuff to test adding stuff to database.
        Map<String, String> doc = new HashMap<String, String>();
        doc.put("name", "Los Angeles");
        doc.put("state", "CA");
        doc.put("country", "USA");
        ApiFuture<WriteResult> future = qs.getDb().collection("cities").document("LA").set(doc);
        System.out.println("Update time: " + future.get().getUpdateTime());

//
//        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
//                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                        .build();
//
//        Firestore db = firestoreOptions.getService();
    }
}
