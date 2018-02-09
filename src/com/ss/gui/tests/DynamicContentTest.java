package com.ss.gui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ss.gui.pages.ShapeSecurityTestSuite;

public class DynamicContentTest extends ShapeSecurityTestSuite{
	@Test
	public void isTenCharTest() throws Exception {
		Assert.assertTrue(dynamic.isTenCharacterWordExits());
		System.out.println("Longest Word is "+dynamic.printLongestWord());
	}
	
	@Test
	public void isPunisherImageTest() throws Exception {
		System.out.println("Avtars Present are "+dynamic.getAvatar());
		Assert.assertTrue(dynamic.isPunisherExists());
	}
	
	

}
