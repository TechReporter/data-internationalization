package com.example.loadlocalizationapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	DataService dataService;
	
	@GetMapping("/getData/{locale}")
	public String getLocalData(@PathVariable("locale") String locale) {
		return dataService.loadFileData(locale);
	}
}
