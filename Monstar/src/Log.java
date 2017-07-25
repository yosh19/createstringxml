import java.io.File;
import java.util.logging.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
public class Log {
 
	public Logger logger;
	FileHandler fh;
	 
	public Log(String file_name)  throws IOException{
		
		File f = new File(file_name);
		if(!f.exists()) {
			f.createNewFile();
		}
		fh = new FileHandler(file_name, true);
		logger = Logger.getLogger("test");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
	} 
}