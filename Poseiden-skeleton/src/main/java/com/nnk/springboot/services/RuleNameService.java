package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.interfaces.IRuleNameService;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleNameService implements IRuleNameService {
    private final RuleNameRepository ruleNameRepository;

    public RuleNameService(RuleNameRepository ruleNameRepository) {
        this.ruleNameRepository = ruleNameRepository;
    }

    @Override
    public void createRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    @Override
    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    @Override
    public Optional<RuleName> findById(Integer ruleNameId) {
        return ruleNameRepository.findById(ruleNameId);
    }

    @Override
    public void updateRuleName(RuleName ruleName) {
        ruleNameRepository.save(ruleName);
    }

    @Override
    public void deleteRuleName(RuleName ruleName) {
        ruleNameRepository.delete(ruleName);
    }
}
