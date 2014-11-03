package com.luuf.core.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChiperTest {

	@Test
	public void test() {
		String email = "admin@bitceramics.com";
		System.out.println(ChiperUtil.encodeBCrypt(email));
		System.out.println(StringUtil.getCRC32(email));
		System.out.println(ChiperUtil.encodeBCrypt("qwerty"));
		assertTrue(true);
	}

}
