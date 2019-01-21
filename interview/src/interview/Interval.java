package interview;

public class Interval implements Comparable<Interval> {
	
	int lowLimit;
	int highLimit;

	public Interval(int startLowLimit, int startHighLimit) {
		lowLimit = startLowLimit;
		highLimit = startHighLimit;
	}
	
	public int getLowLimit() {return lowLimit;}
	public void setLowLimit(int newLowLimit) {lowLimit = newLowLimit;}
	
	public int getHighLimit() {return highLimit;}
	public void setHighLimit(int newHighLimit) {highLimit = newHighLimit;}
	
	public void printInterval() {
		System.out.println("["+lowLimit+","+highLimit+"]");
	}
	
	public int compareTo(Interval other) {
		return Integer.compare(lowLimit, other.lowLimit);
	}
}