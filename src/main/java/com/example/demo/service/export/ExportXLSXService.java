package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExportXLSXService {

    public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("clients");
        
        
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nom");
        headerRow.createCell(1).setCellValue("Prenom");
        
        
        for (int i=0; i< clients.size();i++) {
        	
        	XSSFRow row = sheet.createRow(i+1);
        	row.createCell(0).setCellValue(clients.get(i).getNom());
        	row.createCell(1).setCellValue(clients.get(i).getPrenom());
        
        
        
        }

        workbook.write(os);
        workbook.close();
    }
}