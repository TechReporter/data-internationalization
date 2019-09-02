package com.example.loadlocalizationapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Service;

@Service
public class DataService {

	private static final String DIRECTORY = "data/";

	public String loadFileData(String locale) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(DIRECTORY).getFile());
		String[] files = file.list();
		String content=null;
		for(String s : files) {

			if(s.contains(locale) || s.contains(locale.toUpperCase())) {
				File ff = new File(classLoader.getResource(DIRECTORY.concat(s)).getFile());
				try {
					content = new String(Files.readAllBytes(ff.toPath()));
					System.out.println("sdsfdf"+content);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

}
