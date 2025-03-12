package com.utilityfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {

	private static FileInputStream fileInput;
	private static Properties property;

	private static void setUpPropertyFile() {

		File file1 = new File(
				"C:\\Users\\tejas\\eclipse-workspace\\TestNGLumaProject\\src\\main\\resources\\LumaTestData.properties");
		try {
			fileInput = new FileInputStream(file1);
			property = new Properties();
			property.load(fileInput);
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR OCCURED DURING FILE LOADING IN FILE INPUT STREAM");
		} catch (IOException e) {
			Assert.fail("ERROR OCCURED DURING FILE READING WITH PROPERTY KEY");
		}
	}

	public String getDataProperty(String KeyData) {
		setUpPropertyFile();
		String datavalue = property.getProperty(KeyData);
		return datavalue;

	}
}
