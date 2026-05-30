package ru.otus.steps;

import io.cucumber.java.ru.Дано;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UiSteps {

    @Дано("добавим комментарий")
    public void addComment(){
        log.info("123");
    }

}
