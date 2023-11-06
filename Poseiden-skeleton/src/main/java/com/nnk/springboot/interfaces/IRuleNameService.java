package com.nnk.springboot.interfaces;

import com.nnk.springboot.domain.RuleName;

import java.util.List;
import java.util.Optional;

public interface IRuleNameService {
    void createRuleName(RuleName ruleName);

    List<RuleName> findAll();

    Optional<RuleName> findById(Integer ruleNameId);

    void updateRuleName(RuleName ruleName);

    void deleteRuleName(RuleName ruleName);
}
