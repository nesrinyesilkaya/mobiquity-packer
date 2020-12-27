package com.mobiquity.formatter;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.mobiquity.enums.PackageResultFormatterTypes;
import com.mobiquity.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageResultFormatterFactoryTest {

	@Test
	public void testGetFormatter() throws APIException {
		IPackageResultFormatter<?> formatter = PackageResultFormatterFactory.getFormatter(PackageResultFormatterTypes.AS_STRING);
		assertTrue(formatter instanceof PackageResultStringFormatter);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Result formatter not found.*")
	public void testGetFormatterNoFormatterExceptionIsThrown() throws APIException {
		PackageResultFormatterFactory.getFormatter(null);
	}

}
