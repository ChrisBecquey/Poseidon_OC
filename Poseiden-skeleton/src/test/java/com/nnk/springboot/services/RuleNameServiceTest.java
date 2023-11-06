package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RuleNameServiceTest {
    @InjectMocks
    private RuleNameService ruleNameService;

    @Mock
    private RuleNameRepository ruleNameRepository;

    @Test
    void createRuleName() {
        RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
        when(ruleNameRepository.save(any())).thenReturn(rule);
        ruleNameService.createRuleName(rule);
        verify(ruleNameRepository, times(1)).save(rule);
    }

    @Test
    void findAll() {
        RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");
        RuleName rule1 = new RuleName("Rule Name2", "Description2", "Json2", "Template2", "SQL2", "SQL Part2");
        when(ruleNameRepository.findAll()).thenReturn(List.of(rule1, rule));

        List<RuleName> ruleNames = ruleNameService.findAll();
        assertEquals(ruleNames.size(), 2);
    }

    @Test
    void findById() {
        RuleName rule = new RuleName("Rule Name", "Description", "Json", "Template", "SQL", "SQL Part");

        when(ruleNameRepository.findById(anyInt())).thenReturn(Optional.of(rule));
        assertEquals(ruleNameService.findById(1), Optional.of(rule));
    }
}