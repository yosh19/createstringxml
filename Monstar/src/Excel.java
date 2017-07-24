//package Excel;

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



public class Excel {

    public static void main(String[] args) throws IOException {

        // 変更元を取込
        FileInputStream in 
            = new FileInputStream("test.xlsx");

        Workbook book = null;
        try {
	    // 今回、WorkBookはWorkbookFactoryを使って作成します
	    book = WorkbookFactory.create(in);

	} catch (EncryptedDocumentException e1) {
	    e1.printStackTrace();

	} catch (InvalidFormatException e1) {
   	    e1.printStackTrace();
	}

// 「サンプル」という名前のシートを取得
	Sheet sheet = book.getSheet("サンプル");


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

/*ここから	
	for (int i = 0 ; i < last ; i++) {

		//１行ずつ取得
		Row row = sheet.getRow(i);
		
		//if(row != null) {
			Cell a1 = row.getCell(1);
		//}
			//if(a1 != null) {
	System.out.println(i);
				Row row3 = sheet.createRow(0);
			    Cell cellA3 = row3.createCell(0);
			    cellA3.setCellValue("<resource123>"+ a1); 
			//}
		

	}
ここまで*/	
	

/*	
	  for (var i=3; i<lastRow; i++){
		    //C列取得
		    var valueOfC = sheet.getRange(i,2).getValue(); 
		    //D列取得
		    var valueOfD = sheet.getRange(i,3).getValue();
		    
		    sheet3.getRange(i,1).setValue('<string name='+'\"'+valueOfC+'\"'+'>'+valueOfD+'</string>')

		  }	
*/	
/*	
//3列目	
	for (int i = 0 ; i < 6 ; i++) {
	
	//１行ずつ取得
	Row row = sheet.getRow(i);

	//列
	Cell a2 = row.getCell(2);    
	
	System.out.println(a2);	
	a2.setCellValue(""+a2);
	}	
*/


	
	
	// ここから出力処理
	FileOutputStream out = null;
	try {
	    // 出力先のファイルを指定
	    out = new FileOutputStream("test8.xlsx");
	    // 上記で作成したブックを出力先に書き込み
	    book.write(out);

	} catch (FileNotFoundException e) {
	    System.out.println(e.getStackTrace());

	} finally {
	    // 最後はちゃんと閉じておきます
	    out.close();
	    book.close();
	}
    }
}

//シートからデータ取得
	//シート読み込み

//コピー先のシート選択

//最終行取得

////1行目<?xml version="1.0" encoding="utf-8"?>

//開始タグ

//ループで単語部分を表示

//閉じタグ













