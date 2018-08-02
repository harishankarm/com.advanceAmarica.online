package com.advanceAmerica.unitTest;



import java.io.File;


import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;

public class Samp {

	public static void main(String[] args) {
		try {
		 //Loading an existing document
	      File file = new File("D:/Hari/SCM.pdf");
	      PDDocument document = PDDocument.load(file);

	      //Instantiate PDFTextStripper class
	      PDFTextStripper pdfStripper;
		
	      pdfStripper = new PDFTextStripper();
		

	      //Retrieving text from PDF document
	      String text = pdfStripper.getText(document);
	      System.out.println(text);
if(text.contains("A service provider to whichsd"))
{
	System.out.println("Pass");
}else{
	System.out.println("Fails");
}
	      //Closing the document
	      document.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
