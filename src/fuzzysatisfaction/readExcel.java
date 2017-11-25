/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzysatisfaction;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author ratih
 */
public class readExcel {
    private static final String FILE_NAME = "C:\\Users\\ratih\\OneDrive\\Documents\\NetBeansProjects\\fuzzyChart\\myFirstData.xlsx";
    public double[][] readDataset(String filePath){
        System.out.println("File location:"+filePath);
        double[][] dataset = new double[2][41];
        try {

            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int i = 0;
            
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                
                

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        //System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        //System.out.print(currentCell.getNumericCellValue() + "--");
                        if(dataset[0][i]==0){
                            dataset[0][i] = currentCell.getNumericCellValue();
                            //System.out.println("Data 0-"+ i +": "+dataset[0][i]);
                        }
                        else{
                            dataset[1][i] = currentCell.getNumericCellValue();
                            //System.out.println("Data 1-"+ i +": "+dataset[1][i]);
                        }
                        
                    }
                      
                }
                //System.out.println();
                 i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataset.clone();
    }
    
}
