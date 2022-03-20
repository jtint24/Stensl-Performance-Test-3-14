import groovy.time.TimeCategory
import groovy.time.TimeDuration

class TwoSum {
      static void main(String[] args) {
            Date start = new Date()
            int[] array = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            for (int index = 0; index<array.length; index++) {
                  array[index] = index;
            }
            for (int index1 = 0; index1<array.length; index1++) {
                  for (int index2 = index1+1; index2<array.length; index2++) {
                        if (array[index1]+array[index2] == 197) {
                              println(index1+index2);
                        }
                  }
            }
            println(TimeCategory.minus(new Date(), start))
      }
}