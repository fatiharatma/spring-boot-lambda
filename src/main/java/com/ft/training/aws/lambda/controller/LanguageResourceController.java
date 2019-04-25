package com.ft.training.aws.lambda.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ft.training.aws.lambda.model.Language;

@RestController
public class LanguageResourceController {

    private static final Logger logger = LoggerFactory.getLogger(LanguageResourceController.class);


    @RequestMapping(path = "/languages", method = RequestMethod.GET)
    public List<Language> listLambdaLanguages() {
        logger.debug("listLambdaLanguages get");

        return Arrays.asList(new Language("JS"),new Language("node"), new Language("java"), new Language("python"), new Language("Arduino"));
    }

}