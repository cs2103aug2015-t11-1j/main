package storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StorageManager {
	
	protected static String getFilePath(File file){
		String str = new String(extract(file));
		return str;
	}
	
	protected static String extract(File file){
		String str = new String();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			str = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			//TODO
			e.printStackTrace();
		} catch (IOException e) {
			//TODO
			e.printStackTrace();
		}
		return str;
	}
}
