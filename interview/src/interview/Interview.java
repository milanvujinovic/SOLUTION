package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Interview {
	
	public static void main(String[] args) {

		ArrayList<Interval> listOfIntervals = new ArrayList<Interval>();
		
		fillOutIntervals2(listOfIntervals);
		
		System.out.println("Non merged");
		for(int i=0; i< listOfIntervals.size();i++) {
			listOfIntervals.get(i).printInterval();
		}

		listOfIntervals = merge(listOfIntervals);
		
		System.out.println("Merged");
		for(int i=0; i< listOfIntervals.size();i++) {
			listOfIntervals.get(i).printInterval();
		}
	}

	// The method merge accepts intervals as parameter and returns an ArrayList<Interval> such that the overlapping intervals have been merged.
	static ArrayList<Interval> merge(ArrayList<Interval> intervals){
		if (intervals != null) {
			// Firstly, the intervals are sorted according to their lower limits
			Collections.sort(intervals);
			
			// Only merge the intervals if there is more than 1 interval
			if (intervals.size() > 1) {
				// i starts at the first interval, j at the second interval
				int i = 0;
				int j = 1;
				Interval x;
				Interval y;
				
				// Iterate until there are no more intervals to check
				while(j != intervals.size()) {
					x = intervals.get(i);
					y = intervals.get(j);
					
					// If interval at index i subsumes interval at index j
					if (overlap(x,y) == 2) {
						// Interval at index j is removed, iteration is continued with intervals shifted to the left
						intervals.remove(j);
					// If interval at index i partially overlaps with interval at index j
					} else if (overlap(x, y) == 1) {
						// Set the high limit of interval at index i to the high limit of the interval at index j
						intervals.get(i).setHighLimit(y.getHighLimit());
						// Interval at index j is removed, iteration is continued with intervals shifter to the left
						intervals.remove(j);
					} else {
						// No overlap between intervals at index i and j, increase i and j to check next pair of intervals
						i++;
						j++;
					}
				}
			}
		}
		return intervals;
	}
	
	// The method overlap accepts interval x and interval y as parameters, and returns the following:
	// 0 - if there is not overlap between intervals, i.e. x = [2,4] and y = [7,10]
	// 1 - if interval x partially overlaps with interval y, i.e. x = [2,5] and y = [4,9]
	// 2 - if  interval x subsumes interval y, i.e. x = [2,10] and y = [4,6]
	static int overlap (Interval x, Interval y) {
		if (x.getHighLimit() >= y.getLowLimit()) {
			if (x.getHighLimit() >= y.getHighLimit()) {
				return 2;
			}
			return 1;
		}
		return 0;
	}
	
	// Fills out the provided ArrayList with intervals like in the task assignment
	static void fillOutIntervals1 (ArrayList<Interval> intervals) {
		Interval i1 = new Interval(25,30);
		Interval i2 = new Interval(2, 19);
		Interval i3 = new Interval(14, 23);
		Interval i4 = new Interval(4, 8);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
	}
	
	// Fills out the provided ArrayList with random intervals. maxNum is used to denote
	// the maximum high limit of a interval. nrIntervals denotes the number of intervals in the
	// ArrayList.
	static void fillOutIntervals2 (ArrayList<Interval> intervals) {
		Random rand = new Random();
		
		int maxNum = 30;
		int nrIntevals = 4;
		
		for (int i = 0; i < nrIntevals; i++) {
			int first = rand.nextInt(maxNum);
			int second = rand.nextInt(maxNum);

			if (first < second) {
				intervals.add(new Interval(first, second));
			} else {
				intervals.add(new Interval(second, first));
			}		
		}
	}
}
