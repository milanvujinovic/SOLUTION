This code was written in Java using Eclipse IDE. One way of running it is:
	1 - Create new Java project
	2 - Into this project import the folder "interview" along with its contents, overwriting the existing files in the new project
	3 - Run "Interview.java"

In the solution I have assumed that an interval is a pair of non-negative integers, and that an interval is always closed.

Aproximate time for solving was 4 hours.

There are two methods of filling out the list of intervals. In "Interview.java", line 13 "fillOutIntervals1" uses the intervals like the ones from the task assignment. This can be changed to "fillOutIntervals2" which uses a random number generator to fill out the list of intervals.

1) According to the Java documentation, the time complexity of "Collection.sort(intervals)" is log(n). In the "merge" method, in worst case, we iterate over the length of the whole ArrayList, and if the worst case we remove elements until there are no more elements except for the first one, so that means the complexity is n*(n-1). Together, that means the worst case time complexity of the "merge" function is O(log(n) + n*(n-1)). This might be improved by not removing elements from the same ArrayList, but creating a new ArrayList where intervals are copied when needed.

2) According to the Java documentation, temporary storage requirements of "Collection.sort" can reach n/2 object references, where n is the number of intervals in the ArrayList. One idea how to prevent the program from running out of memory would be to ensure that before running the "Collection.sort" there is enough heap memory for n/2 object references.

3) As mentioned in point 2, the maximum amount of additional memory this program uses is n/2 object references, where n is the number of intervals in the ArrayList. This is due to the use of "Collection.sort". If we were not to use "Collection.sort", another solution might be to create a new ArrayList, iterate over the existing intervals, and take each interval from the existing ArrayList, and put it into the new ArrayList into the appropriate place (this might mean removing, adding or editing the intervals in the new list). This other solution however, would in the worst case require double the amount of memory of the existing ArrayList.