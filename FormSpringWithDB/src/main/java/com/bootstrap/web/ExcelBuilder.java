package com.bootstrap.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.bootstrap.web.db.model.NewWebGame;

public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<NewWebGame> gamesListExcel = (List<NewWebGame>) model
				.get("gamesListExcel");

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		HSSFSheet sheet = workbook.createSheet("Games List");
		sheet.setDefaultColumnWidth(30);

		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);

		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("Name");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Created Date");
		header.getCell(2).setCellStyle(style);

		int rowCount = 1;
		for (NewWebGame games : gamesListExcel) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(games.getId());
            aRow.createCell(1).setCellValue(games.getName());
            aRow.createCell(2).setCellValue(df.format(games.getDate()));
		}
	}

}
