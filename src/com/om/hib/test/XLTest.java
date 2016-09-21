package com.om.hib.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.om.hib.dao.HelicopterDAO;
import com.om.hib.dto.HelicopterDTO;

public class XLTest {
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			try {
				Workbook workbook = new HSSFWorkbook(new FileInputStream(
						fc.getSelectedFile()));
				Sheet sheet = workbook.getSheetAt(1);
				String[] str = new String[20];

				HelicopterDAO dao = new HelicopterDAO();
				int n = 0;
				for (Row row : sheet) {
					HelicopterDTO dto = new HelicopterDTO();
					for (Cell cell : row) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						str[n] = cell.getStringCellValue();
						n++;
					}
					dto.setHName(str[0]);
					dto.sethCountryName(str[1]);
					dto.sethPrice((Double.parseDouble(str[2])));
					dao.save(dto);
					n = 0;
					System.out.println();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}