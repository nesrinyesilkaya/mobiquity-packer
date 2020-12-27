package com.mobiquity.calculator;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.mobiquity.enums.PackageCalculatorTypes;
import com.mobiquity.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageCalculatorFactoryTest {

	@Test
	public void testGetCalculator() throws APIException {
		IPackageCalculator calculator = PackageCalculatorFactory.getCalculator(PackageCalculatorTypes.DYNAMIC_CALCULATOR);
		assertTrue(calculator instanceof DynamicPackageCalculator);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Package calculator not found.*")
	public void testGetCalculatorNoCalculatorExceptionIsThrown() throws APIException {
		PackageCalculatorFactory.getCalculator(null);
	}
}
