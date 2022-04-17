package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {
    static private final int NMaxATMTRANSACTIONS = 10;

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
	/*
	 * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a scelta,
	 * con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
	 * 
	 * 2) Effetture un numero di operazioni a piacere per verificare che le
	 * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
	 * di un id utente errato, oppure al superamento del numero di operazioni ATM
	 * gratuite.
	 */
	AccountHolder a1 = new AccountHolder("Mario", "Verdi", 123);
	AccountHolder a2 = new AccountHolder("Luca", "Rossi", 321);
	BankAccount b1 = new StrictBankAccount(a1.getUserID(), 10000.00, NMaxATMTRANSACTIONS);
	BankAccount b2 = new StrictBankAccount(a2.getUserID(), 10000.00, NMaxATMTRANSACTIONS);
	try {
	    //b2.withdraw(a2.getUserID(), 10001.00);
	    // b1.deposit(a2.getUserID(), 1000.00);
	    for (int i = 0; i < 10; i++) {
		b1.depositFromATM(a1.getUserID(), 1000.00);
		b2.depositFromATM(a2.getUserID(), 500.00);
	    }

	} catch (WrongAccountHolderException w) {
	    System.out.println(w.getMessage());
	    assertNotNull(w.getMessage());
	    fail("account error");
	} catch (TransactionsOverQuotaException t) {
	    System.out.println(t);
	    fail("quote error");
	} catch (NotEnoughFoundsException n) {
	    System.out.println(n);
	    fail("founds error");
	} finally {
	    System.out.println(b1);
	    System.out.println(b2);
	}

    }

}
