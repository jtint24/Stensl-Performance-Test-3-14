import java.time.Instant;
import java.time.Duration;

class PiApprox {
    public static void main(String[] args) {
	long startTime = System.currentTimeMillis();
	float area = 0;
	for (int i = 0; i<100; i++) {
	    for (int j = 0; j<100; j++) {
		int radiusSQ = (50-i)*(50-i)+(50-j)*(50-j);
		if (radiusSQ<2500) {
		    area++;
		}
	    }
	}
	System.out.println(area/2500.0);
	System.out.println(-(startTime-System.currentTimeMillis())/1000.0);
    }
}
