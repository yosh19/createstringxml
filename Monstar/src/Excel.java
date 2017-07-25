//package Excel;
import java.util.logging.*;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.security.tools.keytool.Resources_zh_TW;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.logging.Logger;


public class Excel {

    public static void main(String[] args) throws IOException {
    		//final Logger logger = Logger.getLogger( Logger.class.getName());
    		//Log my_log = new Log("test.txt");

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
			

		    //Row row2 = sheet.createRow(2);
		    //my_log.logger.setLevel(row2.);


		    File file = new File("test9.txt");
		    FileWriter filewriter = new FileWriter(file);     
			
		    for (int i = 0 ; i < 6 ; i++){
			    Row row1 = sheet.getRow(i);
		    		Cell cell = row1.getCell(1);
			    String japanese = cell.getStringCellValue();
			    if(japanese != null) {
			    		//System.out.println(japanese);
				    filewriter.write(japanese+"\r\n");
			    }
		      }
		    
          
		    //filewriter.write(japanese);
		    filewriter.close();
		    
		    /*

//１行目("<?xml version=\"1.0\" encoding=\"utf-8\" ?>")
	Row row1 = sheet.createRow(0);
    Cell cellA1 = row1.createCell(0);
    cellA1.setCellValue("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");    

//2行目/開始タグ("<resource>")
	Row row2 = sheet.createRow(1);
    Cell cellA2 = row2.createCell(0);
    cellA2.setCellValue("<resource>");    	


//単語部分
	//最終行を取得
	int last = sheet.getLastRowNum();
	System.out.println(last);
	
	//対象範囲を取得(2行目と3行目)
	Row row5 = sheet.getRow(6);
	Row row6 = sheet.getRow(7);
	
	
	for (int i = 0 ; i < last ; i++) {
		//for (int j =0; j < last ; j++) {
		
			//値が入っている2行目をGet
			Cell cell = row5.getCell(i);
			System.out.println(i);				

			//値が入っている2行目に"良いね"を入れる
			if(cell != null) {
				row6.createCell(i).setCellValue("良いね");
			}
		//}

		
	}

*/
/*
	// ここから出力処理
	FileOutputStream out = null;
	try {
	    // 出力先のファイルを指定
	    out = new FileOutputStream("test8.txt");
	    // 上記で作成したブックを出力先に書き込み
	    book.write(out);

	} catch (FileNotFoundException e) {
	    System.out.println(e.getStackTrace());

	} finally {
	    // 最後はちゃんと閉じておきます
	    out.close();
	    book.close();
	}
*/
	
    }

    
}













