package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest

@ActiveProfiles("test")
class OperatorServiceImplTest {
    @Mock
    OperatorRepository operatorRepository;
    @InjectMocks
    OperatorServiceImpl operatorService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void retrieveAllOperators() {
        Operator operator = new Operator();
        operator.setIdOperateur(1L);
        operator.setFname("testOp");
        operator.setLname("testtesttest");

        Mockito.when(operatorRepository.findById(1L)).thenReturn(Optional.of(operator));

        // Act
        Operator retrievedOperator = operatorService.retrieveOperator(1L);

        // Assert
        assertNotNull(retrievedOperator);
        assertEquals(1L, retrievedOperator.getIdOperateur()); // Improved assertion for better readability
        assertEquals("test", retrievedOperator.getFname());

        Mockito.verify(operatorRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    void addOperator() {

        // Given
        Operator operator = new Operator();
        // Set up the operator object if needed

        // Mocking repository behavior
        when(operatorRepository.save(operator)).thenReturn(operator);

        // When
        Operator result = operatorService.addOperator(operator);

        // Then
        assertEquals(operator, result);
        // Add more assertions if necessary
    }

    @Test
    void deleteOperator() {
    }

    @Test
    void updateOperator() {
    }

    @Test
    void retrieveOperator() {
    }
}