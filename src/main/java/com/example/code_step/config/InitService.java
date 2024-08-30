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
import com.example.code_step.step.domain.Step;
import com.example.code_step.step.domain.StepAndProblem;
import com.example.code_step.step.domain.Unit;
import com.example.code_step.step.infrastructure.*;
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
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class InitService implements CommandLineRunner {

    private final RankRepository rankRepository;
    private final RankJpaRepository rankJpaRepository;
    private final LanguageJpaRepository languageJpaRepository;
    private final UnitJpaRepository unitJpaRepository;
    private final ProblemJpaRepository problemJpaRepository;
    private final ChoiceJpaRepository choiceJpaRepository;
    private final StepJapRepository stepJapRepository;
    private final StepAndProblemJpaRepository stepAndProblemJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        initDB();
    }

    private void initRank(ObjectMapper objectMapper) throws IOException {
        ArrayList<Rank> ranks = objectMapper.readValue(resourceJsonToString("json/rank.json"),
                new TypeReference<ArrayList<Rank>>() {}
        );

        if(rankJpaRepository.count() == 0){
            rankJpaRepository.saveAll(ranks.stream().map(RankJpaEntity::from).toList());
        }
    }

    private void initLanguage(ObjectMapper objectMapper) throws IOException {
        ArrayList<Language> languages = objectMapper.readValue(resourceJsonToString("json/language.json"),
                new TypeReference<ArrayList<Language>>() {
                }
        );


        ArrayList<Unit> units = objectMapper.readValue(resourceJsonToString("json/unit.json"),
                new TypeReference<ArrayList<Unit>>() {
                }
        );


        if (languageJpaRepository.count() == 0) {
            languageJpaRepository.saveAll(languages.stream().map(LanguageJpaEntity::from).toList());
        }

        if (unitJpaRepository.count() == 0)
            unitJpaRepository.saveAll(units.stream().map(UnitJpaEntity::from).toList());
    }

    private void initProblem(ObjectMapper objectMapper) throws IOException {

        ArrayList<ProblemBasicInfo> problems = objectMapper.readValue(resourceJsonToString("json/problem.json"),
                new TypeReference<ArrayList<ProblemBasicInfo>>() {}
        );

        ArrayList<ChoiceJpaEntity> choices = objectMapper.readValue(resourceJsonToString("json/choice.json"),
                new TypeReference<ArrayList<ChoiceJpaEntity>>() {}
        );


        if(problemJpaRepository.count() == 0)
                problemJpaRepository.saveAll(problems.stream().map(ProblemJpaEntity::from).toList());


        if(choiceJpaRepository.count() == 0)
            choiceJpaRepository.saveAll(choices);

        //Step를 Random 하게 생성
        if(stepJapRepository.count() == 0){
            List<Unit> units = unitJpaRepository.findAll().stream().map(UnitJpaEntity::toModel).toList();
            for(Unit unit : units){

                List<StepAndProblemJpaEntity> stepAndProblemJpaEntities = new ArrayList<>();
                int r = (int) (Math.random() * 3 + 5);
                for(int i = 0; i < r; i++){
                    //step 생성
                    StepJpaEntity stepJpaEntity = StepJpaEntity.builder()
                                    .unitId(unit.getId())
                                    .compensationId(10L)
                                    .orderNumber(i + 1)
                            .build();

                    //저장한 뒤에 지정된 id를 가져와야 한다.
                    stepJpaEntity = stepJapRepository.save(stepJpaEntity);

                    //랜덤하게 problem 가져오기
                    List<ProblemJpaEntity> problemJpaEntities = getRandomProblems((int) (Math.random() * 3 + 3));


                    //생성한 step과 랜덤으로 가져온 problem 연결하기
                    int j = 1;
                    for (ProblemJpaEntity problem : problemJpaEntities) {
                        stepAndProblemJpaEntities.add(
                                connectStepAndProblem(problem, stepJpaEntity, j++)
                        );
                    }

                }

                //step 및 problem 연결한 정보 저장
                stepAndProblemJpaRepository.saveAll(stepAndProblemJpaEntities);
            }
        }
    }

    public StepAndProblemJpaEntity connectStepAndProblem( ProblemJpaEntity problem, StepJpaEntity step, int orderNumber) {
        return StepAndProblemJpaEntity.builder()
                .problemId(problem.getId())
                .stepId(step.getId())
                .orderNumber(orderNumber)
                .build();
    }


    public List<ProblemJpaEntity> getRandomProblems(int n) throws IOException {
        List<ProblemJpaEntity> problemJpaEntities = new ArrayList<>();
        long problemNumber = problemJpaRepository.count();
        for(int i = 0; i < n; i++){
            problemJpaEntities.add(
                    problemJpaRepository.findById((long) (Math.random() * (int)problemNumber + 1)).orElse(null)
            );
        }

        return problemJpaEntities;
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
