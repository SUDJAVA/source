package com.om.hib.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.om.hib.dao.HelicopterDAO;
import com.om.hib.dto.HelicopterDTO;

public class XLwriteTest {
	public static void main(String[] args) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("mySheet");
		HelicopterDAO dao = new HelicopterDAO();
		List<HelicopterDTO> list = dao.getHelicopterList();
		int n = 0;
       
		for (HelicopterDTO dto : list) {
			Row row = sheet.createRow(n);
			for (int i = 0; i <= 3; i++) {
				Cell cell = row.createCell(i);
				if (i == 0)
					cell.setCellValue(dto.getHId());
				if (i == 1)
					cell.setCellValue(dto.getHName());
				if (i == 2)
					cell.setCellValue(dto.gethCountryName());
				if (i == 3)
					cell.setCellValue(dto.gethPrice());
			}
			n++;
		}

		try {
			FileOutputStream fos = new FileOutputStream("E:\\writeXl.xls");
			workbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
