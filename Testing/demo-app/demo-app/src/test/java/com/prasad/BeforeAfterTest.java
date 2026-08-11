package com.prasad;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BeforeAfterTest {
    BeforeAfter obj = new BeforeAfter();
    
    @BeforeAll
    void bo(){
        System.out.println("Before all tests");
    }
    
    @BeforeEach
    void init(){
        System.out.println("Before test");
    }

    @AfterEach 
    void outit(){
        System.out.println("After test");
    }

    @AfterAll
    void ao(){
        System.out.println("After all tests");
    }

    @Test
    void testHello(){
        System.out.println("Actual Test");
        assertNotNull(obj.returnString(), () -> "no string object found");
    }

    @Test
    void testInt(){
        System.out.println("Actual Test");
        assertNotNull(obj.returnInt(), () -> "no int returned");    
    }
}
