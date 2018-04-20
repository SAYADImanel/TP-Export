package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.LigneFacture;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
    
    public void exportSeul(OutputStream os, ClientDTO client, List<FactureDTO> listFacture) throws IOException {
        
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("client");
        XSSFSheet sheet1 = workbook.createSheet("facture");
        
        
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nom");
        headerRow.createCell(1).setCellValue("Prenom");
        
        XSSFRow row = sheet.createRow(1);
       
        row.createCell(0).setCellValue(client.getNom());
        	
        row.createCell(1).setCellValue(client.getPrenom());	
        
        XSSFRow headerRow1 = sheet1.createRow(0);
        
        headerRow1.createCell(0).setCellValue("désignation");
        headerRow1.createCell(1).setCellValue("quantité");
        headerRow1.createCell(2).setCellValue("prixUnitaire");
        headerRow1.createCell(3).setCellValue("prixLigne");
        
        for (int i=0; i< listFacture.size();i++){
        	
        	FactureDTO uneFacture = listFacture.get(i);
        	
        	List<LigneFactureDTO> lignesDeLaFacture = uneFacture.getLigneFactures();
        	
        	 for (int j=0; j<lignesDeLaFacture.size(); j++) {
        
        		 LigneFactureDTO ligne = lignesDeLaFacture.get(j);
 	
        	
        XSSFRow row1 = sheet1.createRow(i+1);
        
        row.createCell(0).setCellValue(ligne.getDesignation());
    	
        row.createCell(1).setCellValue(ligne.getQuantite());	
        
        row.createCell(2).setCellValue(ligne.getPrixUnitaire());
        
        row.createCell(3).setCellValue(ligne.getPrixLigne());
        
        }
     }
       
        workbook.write(os);
        workbook.close();
    }
       
   
        
       
        
        
        
    
    }
    

    
       
    
