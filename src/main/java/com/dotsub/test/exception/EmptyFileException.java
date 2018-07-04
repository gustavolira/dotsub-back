package com.dotsub.test.exception;

public class EmptyFileException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmptyFileException() {
        super("File must not be empty!");
    }
	
	

}
