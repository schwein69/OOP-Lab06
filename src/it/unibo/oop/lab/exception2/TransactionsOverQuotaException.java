package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException{
    private final int maxTransactions;

    public TransactionsOverQuotaException(int maxTransactions) {
	super();
	this.maxTransactions = maxTransactions;
    }

    @Override
    public String toString() {
	return "Reached max number of Transactions " + maxTransactions ;
    }
    
}
