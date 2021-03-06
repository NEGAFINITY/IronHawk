package com.negafinity.ironhawk.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader
{
	public BufferedImage loadImage(String path) throws IOException
	{
		BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path));
		return image;
	}
}
