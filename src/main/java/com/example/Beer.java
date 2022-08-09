package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

	private String name;

	private String style;

	private String yeast;
	
	private String hop;

	private String malt;
	
}
