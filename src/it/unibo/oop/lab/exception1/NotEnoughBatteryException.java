package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{
    private static final int BATTERY_EMPTY = 0;
    private final int batterylevel;
    public NotEnoughBatteryException(int batterylevel) {
	super();
	this.batterylevel = batterylevel;
    }
    @Override
    public String toString() {
	return "NotEnoughBatteryException [batterylevel=" + batterylevel + "]";
    }
    @Override
    public String getMessage() {
        return this.toString();
    }
}
