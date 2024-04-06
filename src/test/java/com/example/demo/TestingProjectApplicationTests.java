package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class TestingProjectApplicationTests {

    Calculator underTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
		int numberOne = 20;
		int numberTwo = 30;

		int result = underTest.add(numberOne, numberTwo);

		int expected = 50;

		Assertions.assertEquals(expected, result);
	}

	class Calculator{
		int add(int a, int b){
			return a + b;
		}
	}

}
