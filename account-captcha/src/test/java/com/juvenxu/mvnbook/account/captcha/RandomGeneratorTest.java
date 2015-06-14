package com.juvenxu.mvnbook.account.captcha;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertFalse;


/**
 * Unit test for simple App.
 */
public class RandomGeneratorTest 
{
	@Test
	public void testGetRandomString() throws Exception {
		Set<String> randoms = new HashSet<>(100);
		for (int i = 0; i < 100; i++) {
			String random = RandomGenerator.getRandomString();
			assertFalse(randoms.contains(random));
			randoms.add(random);
		}
	}
}
