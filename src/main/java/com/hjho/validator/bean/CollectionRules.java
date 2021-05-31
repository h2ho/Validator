package com.hjho.validator.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CollectionRules {

	@Autowired(required = false)
    private List<IRule> rules;

}
