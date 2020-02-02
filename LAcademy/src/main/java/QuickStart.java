import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.Lists;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QuickStart {
    public static Firestore db;

    public QuickStart(String projectId) throws IOException {
        FileInputStream input = new FileInputStream("C:\\Users\\Alex\\Documents\\Lacademy-website-HackSC-\\lacademy-e1e8a-firebase-adminsdk-ybrvw-1f4a96ef88.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(input))
                .build();

        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        this.db = db;
    }

    public static void authExplicit() throws IOException {
//        // You can specify a credential file by providing a path to GoogleCredentials.
//        // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.
//        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
//                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        // Explicitly request service account credentials from the compute engine instance.
        GoogleCredentials credentials = ComputeEngineCredentials.create();
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

    }

    public Firestore getDb() {
        return db;
    }

    public void setDb(Firestore db) {
        this.db = db;
    }
}
