//package Excel;
//import java.util.logging.*;

import java.io.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import java.util.logging.Logger;


public class Excel {

    public static void main(String[] args) throws IOException {
    		//Logger logger = Logger.getLogger( Logger.class.getName());

        // 変更元を取込
        FileInputStream in 
            = new FileInputStream("excel/string.xlsx");

        Workbook book = null;
        try {
        		// WorkBook作成
        		book = WorkbookFactory.create(in);
	
		} catch (EncryptedDocumentException e1) {
		    e1.printStackTrace();
	
		} catch (InvalidFormatException e1) {
	   	    e1.printStackTrace();
		}
        
  
		    // 「list」シートを取得
			Sheet sheet = book.getSheet("list");
			
			//出力ファイル名
		    File file = new File("string.txt");
		    FileWriter filewriter = new FileWriter(file);
		    
		    //1行目書き込み
		    filewriter.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");		    
		    
		    //2行目(開始タグ)書き込み
		    filewriter.write("<resources>\n");

		    
			//３行目〜(単語部分)書き込み
		    	int i = 0;
		    while(true) {
		    		i++;
			    Row row1 = sheet.getRow(i);
		    		
			    //No列取得
			    Cell numberRow  = row1.getCell(0);
			    if (numberRow == null || numberRow.getNumericCellValue() == 0) {
			    		break;
			    }
			    
			    //タグ列取得
			    Cell tagRow = row1.getCell(1);
			    //日本語列取得
			    Cell japaneseRow = row1.getCell(2);
			    //英語列取得
			    //Cell englishRow = row1.getCell(3);
			    
			    //No値を取得
			    double number  = numberRow.getNumericCellValue();
			    
			    //タグ値を取得
			    String tag = tagRow.getStringCellValue();
			    //日本語値を取得
			    String japanese = japaneseRow.getStringCellValue();
			    //英語値を取得
			    //String english = englishRow.getStringCellValue();
			    
			    System.out.println(number);
			    

			    
			    if(japanese != null) {
			    		//System.out.println(japanese);
				    filewriter.write("<string name=\""+ tag +"\">" + japanese+"</string>\n");
				    //String mess = "row:" + i + "jp:" + japanese;
				    //logger.info(mess);
			    }
			    
		      }
		    
          
		    //閉じタグ書き込み
		    filewriter.write("</resources>\n");
		    
		    //閉じる
		    filewriter.close();
		    

	
    }

    
}













