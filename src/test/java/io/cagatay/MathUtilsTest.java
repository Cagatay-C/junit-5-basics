package io.cagatay;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " 
		+ testInfo.getTags());
	}
	
//	@BeforeAll
//	void beforeAllInit() {
//		System.out.println("This needs to run before all...");
//	}

//	@AfterEach
//	void cleanUp() {
//		System.out.println("Cleaning up..");
//	}
	
	@Tag("Math")
	@Nested
	@DisplayName("Add method")
	class AddTest{
		
	@Test
	@DisplayName("When adding two positive numbers")
	void testAdd() {
		assertEquals(2,mathUtils.add(1, 1),"Should return sum of two numbers");
	}
	
	@Test
	@DisplayName("When adding one negative and one positive numbers")
	void testAddNegPos() {
		int expected = 0;
		int actual = mathUtils.add(-1, 1);
		assertEquals(expected,actual,() -> "Should return " + expected +" but it was " + actual );
	}
	
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Testing multiply method")
	void testMultiply() {
		assertAll(() -> assertEquals(4,mathUtils.multiply(2, 2)),
				() -> assertEquals(-2,mathUtils.multiply(-1, 2)),
				() -> assertEquals(0,mathUtils.multiply(0, 1)));
	}
	
	@Tag("Circle")
	@Test
	void testComputeRadius() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),"Should return right circle area");
	}
	
	@Tag("Math")
	@Test
//	@RepeatedTest(3)
//	@EnabledOnOs(OS.LINUX)
	void testDivide() {
//		repetitionInfo.getCurrentRepetition();
		boolean isServerUp = true;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by 0 should throw arithmetich exception");
	}
	
//	@Test
//	@DisplayName("TDD method should not run")
//	@Disabled
//	void testDisabled() {
//		fail("This test should be disabled");
//	}
	
}
