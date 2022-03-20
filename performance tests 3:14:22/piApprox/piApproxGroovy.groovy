import groovy.time.TimeCategory
import groovy.time.TimeDuration

class piApproxGroovy {
    static void main(String[] args) {
        Date start = new Date()
        float area = 0
        for (int x = 0; x<100; x++) {
            for (int y = 0; y<100; y++) {
                int radiusSQ = (x-50)*(x-50)+(y-50)*(y-50)
                if (radiusSQ<2500) {
                    area++
                }
            }
        }
        println(area/2500.0)
        println(duration)
        Date end = new Date()
        TimeDuration duration = TimeCategory.minus(end, start)
    }
}
