# -*- coding: utf-8 -*-
import time
start = time.time()
address = "fourscore and seven years ago our fathers brought forth, on this continent, a new nation, conceived in liberty, and dedicated to the proposition that all men are created equal. now we are engaged in a great civil war, testing whether that nation, or any nation so conceived, and so dedicated, can long endure. we are met on a great battle-field of that war. we have come to dedicate a portion of that field, as a final resting-place for those who here gave their lives, that that nation might live. it is altogether fitting and proper that we should do this. but, in a larger sense, we cannot dedicate, we cannot consecrate—we cannot hallow—this ground. the brave men, living and dead, who struggled here, have consecrated it far above our poor power to add or detract. the world will little note, nor long remember what we say here, but it can never forget what they did here. it is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. it is rather for us to be here dedicated to the great task remaining before us—that from these honored dead we take increased devotion to that cause for which they here gave the last full measure of devotion—that we here highly resolve that these dead shall not have died in vain—that this nation, under god, shall have a new birth of freedom, and that government of the people, by the people, for the people, shall not perish from the earth."
for count in range(99):
    noAAddress = ""
    for index in range(0,len(address)):
        if not address[index] == "a":
            noAAddress = noAAddress + address[index]
    reversedAddress = ""
    for index in range(0,len(noAAddress)):
        reversedAddress = noAAddress[index] + reversedAddress
    print(reversedAddress)
        
print(time.time()-start)
