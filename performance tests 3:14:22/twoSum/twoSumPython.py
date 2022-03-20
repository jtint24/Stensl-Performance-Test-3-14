import time
start = time.time()

array = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

for index in range(0,len(array)):
    array[index] = index

for index1 in range(0,len(array)):
    for index2 in range(index1+1,len(array)):
        if (array[index1]+array[index2] == 197):
            print(index1+index2)
            
print(time.time()-start)
