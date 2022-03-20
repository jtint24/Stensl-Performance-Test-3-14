import groovy.time.TimeCategory
import groovy.time.TimeDuration

class stringManip {
      static void main(String[] args) {
		  Date start = new Date()
	      for (int count = 0; count<100; count++) {
	     	String address =  "fourscore and seven years ago our fathers brought forth, on this continent, a new nation, conceived in liberty, and dedicated to the proposition that all men are created equal. now we are engaged in a great civil war, testing whether that nation, or any nation so conceived, and so dedicated, can long endure. we are met on a great battle-field of that war. we have come to dedicate a portion of that field, as a final resting-place for those who here gave their lives, that that nation might live. it is altogether fitting and proper that we should do this. but, in a larger sense, we cannot dedicate, we cannot consecrate—we cannot hallow—this ground. the brave men, living and dead, who struggled here, have consecrated it far above our poor power to add or detract. the world will little note, nor long remember what we say here, but it can never forget what they did here. it is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. it is rather for us to be here dedicated to the great task remaining before us—that from these honored dead we take increased devotion to that cause for which they here gave the last full measure of devotion—that we here highly resolve that these dead shall not have died in vain—that this nation, under god, shall have a new birth of freedom, and that government of the people, by the people, for the people, shall not perish from the earth."
	     	String noAAddress = ""
	     	for (int i = 0; i<address.length(); i++) {
	     	 	if (address.charAt(i)!='a') {
		    		noAAddress = noAAddress + address.charAt(i)
		 		}
	     	}
	     	String reversedAddress = ""
	     	for (int i = 0; i<noAAddress.length(); i++) {
	     	 	reversedAddress = ""+noAAddress.charAt(i)+reversedAddress
	     	}
	     	println(reversedAddress)
	     }
	     println(TimeCategory.minus(new Date(), start))
      }
}