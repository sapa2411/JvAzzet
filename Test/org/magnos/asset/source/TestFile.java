/* 
 * NOTICE OF LICENSE
 * 
 * This source file is subject to the Open Software License (OSL 3.0) that is 
 * bundled with this package in the file LICENSE.txt. It is also available 
 * through the world-wide-web at http://opensource.org/licenses/osl-3.0.php
 * If you did not receive a copy of the license and are unable to obtain it 
 * through the world-wide-web, please send an email to magnos.software@gmail.com 
 * so we can send you a copy immediately. If you use any of this software please
 * notify me via our website or email, your feedback is much appreciated. 
 * 
 * @copyright   Copyright (c) 2011 Magnos Software (http://www.magnos.org)
 * @license     http://opensource.org/licenses/osl-3.0.php
 * 				Open Software License (OSL 3.0)
 */

package org.magnos.asset.source;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.magnos.asset.Assets;
import org.magnos.asset.image.GifFormat;

/**
 * Tests the {@link FileSource} class.
 * 
 * @author Philip Diffenderfer
 *
 */
public class TestFile 
{

	@BeforeClass
	public static void onBefore() 
	{
		Assets.addFormat( new GifFormat() );
		Assets.setDefaultSource( new FileSource() );
	}
	
	@AfterClass
	public static void onAfter()
	{
		Assets.reset();
	}
	
	@Test
	public void testFile()
	{
		BufferedImage[] images = Assets.load("Test/dance.gif");
		
		assertNotNull( images );
		
		assertEquals( 8, images.length );
		
		for (BufferedImage frame : images) 
		{
			assertNotNull( frame );
			assertEquals( 50, frame.getWidth() );
			assertEquals( 50, frame.getHeight() );
		}
	}
	
}
