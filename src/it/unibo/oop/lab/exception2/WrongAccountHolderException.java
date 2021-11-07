package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException{
    @Override
    public String toString() {
	return "WrongAccount";
    }
    public String getMessage() {
	return this.toString();
	
    }
    
}
