package com.crm.vtiger.Genericutility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public static String getRandomData()
	{
		Random random= new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * @Abinash
	 * this method is used to generate current date
	 * @return current date
	 */
	public static String getCurrentDate()
	{
		Date date = new Date();
		String currentdate = date.toString();
		return currentdate;
	}

}


