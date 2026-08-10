package com.prasad;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class AppTest{
    @Test
    public void test(){
        App obj = new App();

        assertEquals("avaJ", obj.reverseString("Java"));
    }
}
