import time

startTime = time.time()
area = 0
for x in range(0,100):
    for y in range(0,100):
        radiusSQ = (x-50)*(x-50)+(y-50)*(y-50)
        if (radiusSQ<2500):
            area = area + 1
print(area/2500.0)
print(time.time()-startTime)
