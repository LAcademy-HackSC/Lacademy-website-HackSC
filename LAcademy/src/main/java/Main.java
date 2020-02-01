import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Instance serviceAccount;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        serviceAccount = mapper.readValue(new File("C:\\Users\\Alex\\Desktop\\LAcademy-11261bcdb733.json"), Instance.class);

        // System.out.println(serviceAccount.getProject_id());
        QuickStart qs = new QuickStart(serviceAccount.getProject_id());

//
//        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
//                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                        .build();
//
//        Firestore db = firestoreOptions.getService();
    }
}
