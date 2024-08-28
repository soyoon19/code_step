package com.example.code_step.config;

import com.example.code_step.problem.domain.Choice;
import com.example.code_step.problem.domain.Problem;
import com.example.code_step.problem.domain.ProblemBasicInfo;
import com.example.code_step.problem.infrastructure.ChoiceJpaEntity;
import com.example.code_step.problem.infrastructure.ChoiceJpaRepository;
import com.example.code_step.problem.infrastructure.ProblemJpaEntity;
import com.example.code_step.problem.infrastructure.ProblemJpaRepository;
import com.example.code_step.rank.application.repository.RankRepository;
import com.example.code_step.rank.domain.Rank;
import com.example.code_step.rank.infrastructure.RankJpaEntity;
import com.example.code_step.rank.infrastructure.RankJpaRepository;
import com.example.code_step.step.domain.Language;
import com.example.code_step.step.domain.Unit;
import com.example.code_step.step.infrastructure.LanguageJpaEntity;
import com.example.code_step.step.infrastructure.LanguageJpaRepository;
import com.example.code_step.step.infrastructure.UnitJpaEntity;
import com.example.code_step.step.infrastructure.UnitJpaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitService implements CommandLineRunner {

    private final RankRepository rankRepository;
    private final RankJpaRepository rankJpaRepository;
    private final LanguageJpaRepository languageJpaRepository;
    private final UnitJpaRepository unitJpaRepository;
    private final ProblemJpaRepository problemJpaRepository;
    private final ChoiceJpaRepository choiceJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        initDB();
    }

    private void initRank(ObjectMapper objectMapper) throws IOException {
        ArrayList<Rank> ranks = objectMapper.readValue(resourceJsonToString("json/rank.json"),
                new TypeReference<ArrayList<Rank>>() {}
        );

        if(rankJpaRepository.count() == 0){
            for (Rank rank : ranks)
                rankJpaRepository.save(RankJpaEntity.from(rank));
        }
    }

    private void initLanguage(ObjectMapper objectMapper) throws IOException {
        ArrayList<Language> languages = objectMapper.readValue(resourceJsonToString("json/language.json"),
                new TypeReference<ArrayList<Language>>() {}
        );


        ArrayList<Unit> units = objectMapper.readValue(resourceJsonToString("json/unit.json"),
                new TypeReference<ArrayList<Unit>>() {}
        );


        if(languageJpaRepository.count() == 0){
            for (Language language : languages)
                languageJpaRepository.save(LanguageJpaEntity.from(language));
        }

        if(unitJpaRepository.count() == 0)
            for(Unit unit : units)
                unitJpaRepository.save(UnitJpaEntity.from(unit));
    }

    private void initProblem(ObjectMapper objectMapper) throws IOException {
        ArrayList<ProblemBasicInfo> problems = objectMapper.readValue(resourceJsonToString("json/problem.json"),
                new TypeReference<ArrayList<ProblemBasicInfo>>() {}
        );

        ArrayList<ChoiceJpaEntity> choices = objectMapper.readValue(resourceJsonToString("json/choice.json"),
                new TypeReference<ArrayList<ChoiceJpaEntity>>() {}
        );


        if(problemJpaRepository.count() == 0){
            for (ProblemBasicInfo problem : problems)
                problemJpaRepository.save(ProblemJpaEntity.from(problem));
        }

        if(choiceJpaRepository.count() == 0)
            for(ChoiceJpaEntity choice : choices)
                choiceJpaRepository.save((choice));
    }



    private void initDB() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        initRank(objectMapper);
        initLanguage(objectMapper);
        initProblem(objectMapper);
    }


    public static String resourceJsonToString(String path){
        String str = "";
        String sb = "";
        ClassPathResource resource = null;
        InputStreamReader reader = null;

        //static폴더의 json파일을 string으로 저장
        try {
            resource = new ClassPathResource("static/" + path);
            reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {
                sb += str + "\n";
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return sb;
    }
}
