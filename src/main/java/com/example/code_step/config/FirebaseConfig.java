package com.example.code_step.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class FirebaseConfig {
    @PostConstruct
    public void init() {
        try{
            //1. 파일 가져오기
            FileInputStream serviceAccount =
                    new FileInputStream("src/main/resources/t2f4-34945-firebase-adminsdk-fo66n-134bb5eb8e.json");

            //2. 파일 설정 불러오기
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            //3. 적용하기
            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
