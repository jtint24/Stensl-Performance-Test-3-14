import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

class TwoSum {
    public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int index = 0; index<100; index++) {
	    	array.add(index);
		}
		for (int index1 = 0; index1<array.size(); index1++) {
	    	for (int index2 = index1; index2<array.size(); index2++) {
				if (array.get(index1)+array.get(index2) == 197) {
		    		System.out.println(index1+index2);
				}
	    	}
		}
		System.out.println(-(startTime-System.currentTimeMillis())/1000.0);
    }
}
