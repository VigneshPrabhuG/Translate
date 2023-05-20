package com.Translate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Translate extends Base_Class {


	@Test
	void drivenData() throws Throwable {

		browserLaunch("Chrome");
		com.Pom.PageObjMode pom = new com.Pom.PageObjMode(driver);
		getUrl("https://www.google.com/");
		navigateToUrl("https://translate.google.com/");

		WebElement spanish = pom.getSpanish();
		clickOnElement(spanish);

		File f = new File("C:\\Users\\Mikae\\eclipse-workspace\\Translate\\Translate\\Excel\\File.xlsx");

		FileInputStream fis = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheetAt = wb.getSheetAt(0);

		int rows = sheetAt.getPhysicalNumberOfRows();	

		for (int i = 0; i < rows; i++) {
			Row row = sheetAt.getRow(i);

			int cells = row.getPhysicalNumberOfCells();

			for (int j = 0; j < cells; j++) {

				Cell cell = row.getCell(j);

				CellType cellType = cell.getCellType();

				if (cellType.equals(cellType.STRING)) {

					String stringCellValue = cell.getStringCellValue();

					WebElement input = pom.getInput();
					clickOnElement(input);
					inputValueElement(input, stringCellValue);
					Thread.sleep(2000);
					clearText(input);

					Thread.sleep(5000);
					wb.close();

					WebElement value = pom.getValue();
					String text = value.getText();
					System.out.println(text);


					File f1 = new File("C:\\Users\\Mikae\\eclipse-workspace\\Translate\\Translate\\Excel\\File.xlsx");

					FileInputStream fis1 = new FileInputStream(f1);

					Workbook wb1 = new XSSFWorkbook(fis1);

					List<String> st = new ArrayList<>();
					st.add("Mi nombre es este Vignesh Prabhu");
					st.add("Soy ingeniero de pruebas de software");
					st.add("Estoy trabajando en soluciones de digivir");
					st.add("Soy un buen jugador de equipo");
					st.add("Me encanta trabajar duro");

					if(st.contains(text)) {

						wb1.getSheetAt(0).getRow(i).createCell(2).setCellValue("Pass");

						FileOutputStream fos = new FileOutputStream(f);

						wb1.write(fos);
					}
					else {
						wb1.getSheetAt(0).getRow(i).createCell(2).setCellValue("Fail");

						FileOutputStream fos = new FileOutputStream(f);

						wb1.write(fos);
					}
				}	
				else if (cellType.equals(cellType.NUMERIC)) {

					double numericCellValue = cell.getNumericCellValue();

					System.out.println(numericCellValue);
				}
			}
		}
		//		wb.close();

		driver.quit();
	}


}
