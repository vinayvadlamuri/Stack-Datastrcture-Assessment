package com.bmw.assignment;

import com.bmw.assignment.stackdatastrctureassignment.StackDataStructureAssignmentApplication;
import com.bmw.assignment.stackdatastrctureassignment.impl.StackArrayAssignment;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = StackDataStructureAssignmentApplication.class)
class StackDataStructureAssignmentApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(StackDataStructureAssignmentApplicationTests.class);
    private StackArrayAssignment<Integer> stackArrayAssignment;

    @BeforeEach
    public void setUp() {
        stackArrayAssignment = new StackArrayAssignment();
    }

    private void initializeStack(Integer... args){
        Arrays.asList(args).forEach( e -> stackArrayAssignment.push(e));
    }

    @Test
    @Order(1)
    @DisplayName("Test to push values to Stack")
    public void testPushStack() {
        logger.info("Pushing values to stack {} {} {}", 40,66,99);
        stackArrayAssignment.push(40);
        stackArrayAssignment.push(66);
        stackArrayAssignment.push(99);
        logger.info("Pushing values to stack completed");
        assertEquals(3, stackArrayAssignment.count());
    }

    @Test
    @Order(2)
    @DisplayName("Test to pop out values from Stack")
    public void testPopStack() {
        initializeStack(40,60,99);
        logger.info("Popping out stack value {}", stackArrayAssignment.pop());
        logger.info("Popping out stack value {}", stackArrayAssignment.pop());
        logger.info("Popping out stack value {}", stackArrayAssignment.pop());
        assertEquals(0, stackArrayAssignment.count());
    }

    @Test
    @Order(3)
    @DisplayName("Test to prove Stack is empty")
    public void testEmptyStack() {
        logger.info("Is stack is empty ? : {}",stackArrayAssignment.isEmpty() );
        assertTrue(stackArrayAssignment.isEmpty());
    }

    @Test
    @Order(4)
    @DisplayName("Test to prove Stack is count")
    public void testStackCount() {
        logger.info("The count of current stack before initializing : {}",stackArrayAssignment.count());
        initializeStack(40,60,99);
        logger.info("The count of current stack after initializing : {}",stackArrayAssignment.count());
        assertEquals(3, stackArrayAssignment.count());
    }

}
