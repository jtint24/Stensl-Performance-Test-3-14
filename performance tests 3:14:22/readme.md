# Stensl Performance Testing 3/14

Written by Joshua Tint


# Abstract

Stensl is a scripting language developed by myself, Joshua Tint, as part of an honors project at Arizona State University. A version of Stensl fulfilling all functional constraints was created as of 3/9, so this performance test was done in order to measure how well the language fulfills performance constraints. This test involved three benchmark programs designed to test different functionalities and four languages including Stensl for a good sense of performance relative to other languages. Overall, Stensl was far slower than the other languages, as expected, but performed quite well in terms of memory. 


# Methodology

Because scripting languages have an inherent performance disadvantage to compiled languages, I will be doing a speed comparison against two other interpreted languages to get a better sense of how my language fares against fair competitors. The first language I will test against will be Python, chosen because it is the most popular scripting language (and arguably even the most popular language bar none). The particular Python implementation will be CPython. The second language I will test against will be Groovy, chosen because it is the most notable scripting language that also runs in the JVM. However, I’m not planning on beating, or even coming close to these languages in terms of speed or memory. Both of these languages have been worked on by large teams for decades, and thus have many optimizations that I’ve not been able to do in the last 3 months. For instance, Python uses a stack-based parser, which should in theory be much faster than my tree-based parser. CPython is also implemented in C and C++, which are faster languages than Java. Thus, a more reasonable goal for this first speed test would be somewhere in the ballpark of 10x the time of Groovy (Python ought to be faster than Groovy because it’s implemented in a faster language). For these relatively short benchmarks, memory usage ought to be closer; I expect Stensl’s usage to be in the ballpark of 5x Python or Groovy. I will also be testing my benchmarks in Java, just to see how much slower Stensl is than its implementation language. Because Java is not an interpreted language, I will be just testing the time that the Java bytecode takes to run, not counting any compile time used to make said bytecode.

All benchmarks will be run 10 times and their average speed and memory usage will be recorded by using an activity monitor. All the benchmarks will run on my 2018 MacBook Pro, which has a 2.3 GHz Quad-Core Intel Core i5 processor and 8GB of memory. 

The language versions used were Groovy 4.0.1, Python 2.7.18, and Java 14.0.2.


## Benchmark 1

The first benchmark is designed to test the speed of basic math and control flow operations. This benchmark is called the “PiApprox” benchmark. This test iterates across 10,000 points inside a square that goes from the origin of a graph to the point (100,100), inclusive of (100,100). It then determines if each point is inside a circle with radius 50 centered around (50,50). It counts the number of points which fit that criteria and uses it as an approximation for the area of the circle. It then divides that area by the square of the radius to approximate pi and prints that approximated number. The exact approximate given should be 3.13. The pseudocode for it is below:


```
area := 0
for x := 0 to 100 do
	for y := 0 to 100 do
		radiusSQ := (50-x)*(50-x) + (50-y)*(50-y)
		if radiusSQ<2500 then
			area := area + 1
		endif
	endfor
endfor
print area/2500
```



## Benchmark 2

The second benchmark is designed to test the speed of string operations. This benchmark starts with an all-lowercase plaintext copy of the Gettysburg Address, chosen because it’s a relatively long piece of text and it’s widely available. It creates a copy of this text with all the letter a’s removed. It then creates another string containing the reversed version of the a-less copy. It then prints this reversed copy. This process is repeated 100 times in order to make the benchmark take longer, allowing for greater precision on time measurements. The pseudocode for it is below:


```
address := "fourscore and seven years ago our fathers brought forth, on this continent, a new nation, conceived in liberty, and dedicated to the proposition that all men are created equal. now we are engaged in a great civil war, testing whether that nation, or any nation so conceived, and so dedicated, can long endure. we are met on a great battle-field of that war. we have come to dedicate a portion of that field, as a final resting-place for those who here gave their lives, that that nation might live. it is altogether fitting and proper that we should do this. but, in a larger sense, we cannot dedicate, we cannot consecrate—we cannot hallow—this ground. the brave men, living and dead, who struggled here, have consecrated it far above our poor power to add or detract. the world will little note, nor long remember what we say here, but it can never forget what they did here. it is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. it is rather for us to be here dedicated to the great task remaining before us—that from these honored dead we take increased devotion to that cause for which they here gave the last full measure of devotion—that we here highly resolve that these dead shall not have died in vain—that this nation, under god, shall have a new birth of freedom, and that government of the people, by the people, for the people, shall not perish from the earth."
for count := 0 to 100 do
noAAddress := ""
for index := 0 to address.length do
		if not address.charAt(index) == "a" then
			noAAddress := noAAddress + address.charAt(index)
		endif
endfor
reversedAddress := ""
for index := 0 to noAAddress.length do
		reversedAddress := noAAddress.charAt(index) + reversedAddress
endfor
print reversedAddress
endfor
```



## Benchmark 3

The final benchmark is designed to test the speed of array operations. This benchmark is essentially a brute-force 2-sum on an array of 100 integers. The array begins with all zeros, but the program fills it in with an ascending list from 0 to 99. The program then checks for a pair of elements in the list that add up to 197 (the last two elements). It then returns the sum of those two indices. For this trial, ArrayList was used rather than Array in the Java trial because its dynamic size makes it a more analogous structure to the arrays available in Stensl, Groovy, and Python. The pseudocode is below:


```
array := [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
for index := 0 to array.length do
	array[index] = index
endfor
for index1 := 0 to array.length do
	for index2 := index1+1 to array.length do
		if array[index1]+array[index2]==197 then
			print index1+index2
		endif
	endfor
endfor


```



# Data


<table>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>PiApprox Time (Seconds)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
2.6</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.261</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
2.61</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
   <td><p style="text-align: right">
0.318</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
2.37</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.316</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
2.4</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.419</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
2.38</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.358</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
2.6</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.32</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
2.29</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.332</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
2.5</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
   <td><p style="text-align: right">
0.329</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
2.44</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
   <td><p style="text-align: right">
0.507</p>

   </td>
   <td><p style="text-align: right">
0.002</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
2.38</p>

   </td>
   <td><p style="text-align: right">
0.003</p>

   </td>
   <td><p style="text-align: right">
0.335</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
2.457</p>

   </td>
   <td><p style="text-align: right">
0.0027</p>

   </td>
   <td><p style="text-align: right">
0.3495</p>

   </td>
   <td><p style="text-align: right">
0.0013</p>

   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>PiApprox Memory (MB)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
5.8</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
   <td><p style="text-align: right">
12.3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
8.4</p>

   </td>
   <td><p style="text-align: right">
5.7</p>

   </td>
   <td><p style="text-align: right">
11.6</p>

   </td>
   <td><p style="text-align: right">
12.8</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
5.9</p>

   </td>
   <td><p style="text-align: right">
10.6</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
11.6</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
5.3</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
5.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
8.2</p>

   </td>
   <td><p style="text-align: right">
5.8</p>

   </td>
   <td><p style="text-align: right">
11.6</p>

   </td>
   <td><p style="text-align: right">
5.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
8.3</p>

   </td>
   <td><p style="text-align: right">
11.6</p>

   </td>
   <td><p style="text-align: right">
6</p>

   </td>
   <td><p style="text-align: right">
11.8</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
8.4</p>

   </td>
   <td><p style="text-align: right">
5.9</p>

   </td>
   <td><p style="text-align: right">
6</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
5.7</p>

   </td>
   <td><p style="text-align: right">
10.7</p>

   </td>
   <td><p style="text-align: right">
5.7</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
16.6</p>

   </td>
   <td><p style="text-align: right">
10.6</p>

   </td>
   <td><p style="text-align: right">
11.7</p>

   </td>
   <td><p style="text-align: right">
11.8</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
13.29</p>

   </td>
   <td><p style="text-align: right">
7.39</p>

   </td>
   <td><p style="text-align: right">
9.77</p>

   </td>
   <td><p style="text-align: right">
10.09</p>

   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>StringManip Time (Seconds)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
5.75</p>

   </td>
   <td><p style="text-align: right">
0.06632685661</p>

   </td>
   <td><p style="text-align: right">
1.033</p>

   </td>
   <td><p style="text-align: right">
0.154</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
6.43</p>

   </td>
   <td><p style="text-align: right">
0.06522393227</p>

   </td>
   <td><p style="text-align: right">
0.732</p>

   </td>
   <td><p style="text-align: right">
0.155</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
7.07</p>

   </td>
   <td><p style="text-align: right">
0.07162213326</p>

   </td>
   <td><p style="text-align: right">
0.66</p>

   </td>
   <td><p style="text-align: right">
0.152</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
6.38</p>

   </td>
   <td><p style="text-align: right">
0.06679391861</p>

   </td>
   <td><p style="text-align: right">
0.661</p>

   </td>
   <td><p style="text-align: right">
0.163</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
6.4</p>

   </td>
   <td><p style="text-align: right">
0.06521487236</p>

   </td>
   <td><p style="text-align: right">
0.684</p>

   </td>
   <td><p style="text-align: right">
0.151</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
6.44</p>

   </td>
   <td><p style="text-align: right">
0.07306909561</p>

   </td>
   <td><p style="text-align: right">
0.886</p>

   </td>
   <td><p style="text-align: right">
0.142</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
6.57</p>

   </td>
   <td><p style="text-align: right">
0.06919789314</p>

   </td>
   <td><p style="text-align: right">
0.682</p>

   </td>
   <td><p style="text-align: right">
0.216</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
7.13</p>

   </td>
   <td><p style="text-align: right">
0.06635189056</p>

   </td>
   <td><p style="text-align: right">
0.695</p>

   </td>
   <td><p style="text-align: right">
0.18</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
7.02</p>

   </td>
   <td><p style="text-align: right">
0.06428313255</p>

   </td>
   <td><p style="text-align: right">
0.588</p>

   </td>
   <td><p style="text-align: right">
0.199</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
6.32</p>

   </td>
   <td><p style="text-align: right">
0.07142281532</p>

   </td>
   <td><p style="text-align: right">
0.846</p>

   </td>
   <td><p style="text-align: right">
0.362</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
6.551</p>

   </td>
   <td><p style="text-align: right">
0.06795065403</p>

   </td>
   <td><p style="text-align: right">
0.7467</p>

   </td>
   <td><p style="text-align: right">
0.1874</p>

   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>StringManip Memory (MB)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
5.6</p>

   </td>
   <td><p style="text-align: right">
2.7</p>

   </td>
   <td><p style="text-align: right">
6</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
5.6</p>

   </td>
   <td><p style="text-align: right">
2.1</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
5.8</p>

   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
6.4</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
6</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
6</p>

   </td>
   <td><p style="text-align: right">
5.9</p>

   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
5.6</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
6</p>

   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
3.4</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
5.8</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
2.1</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
5.9</p>

   </td>
   <td><p style="text-align: right">
2.7</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
4.67</p>

   </td>
   <td><p style="text-align: right">
5.84</p>

   </td>
   <td><p style="text-align: right">
3.76</p>

   </td>
   <td><p style="text-align: right">
4.32</p>

   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>TwoSum Time (Seconds)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
1.6</p>

   </td>
   <td><p style="text-align: right">
0.0006799697876</p>

   </td>
   <td><p style="text-align: right">
0.154</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
1.46</p>

   </td>
   <td><p style="text-align: right">
0.0007870197296</p>

   </td>
   <td><p style="text-align: right">
0.089</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
1.35</p>

   </td>
   <td><p style="text-align: right">
0.0005691051483</p>

   </td>
   <td><p style="text-align: right">
0.098</p>

   </td>
   <td><p style="text-align: right">
0.004</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
1.18</p>

   </td>
   <td><p style="text-align: right">
0.0005860328674</p>

   </td>
   <td><p style="text-align: right">
0.088</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
1.05</p>

   </td>
   <td><p style="text-align: right">
0.000608921051</p>

   </td>
   <td><p style="text-align: right">
0.166</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
1.27</p>

   </td>
   <td><p style="text-align: right">
0.0007100105286</p>

   </td>
   <td><p style="text-align: right">
0.094</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
1.32</p>

   </td>
   <td><p style="text-align: right">
0.0006849765778</p>

   </td>
   <td><p style="text-align: right">
0.091</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
1.29</p>

   </td>
   <td><p style="text-align: right">
0.0006749629974</p>

   </td>
   <td><p style="text-align: right">
0.093</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
1.38</p>

   </td>
   <td><p style="text-align: right">
0.001374959946</p>

   </td>
   <td><p style="text-align: right">
0.094</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
1.66</p>

   </td>
   <td><p style="text-align: right">
0.00057721138</p>

   </td>
   <td><p style="text-align: right">
0.103</p>

   </td>
   <td><p style="text-align: right">
0.001</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
1.356</p>

   </td>
   <td><p style="text-align: right">
0.0007253170013</p>

   </td>
   <td><p style="text-align: right">
0.107</p>

   </td>
   <td><p style="text-align: right">
0.0013</p>

   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td colspan="4" ><strong>TwoSum Memory (MB)</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td><em>Stensl</em>
   </td>
   <td><em>Python</em>
   </td>
   <td><em>Groovy</em>
   </td>
   <td><em>Java</em>
   </td>
  </tr>
  <tr>
   <td>Trial 1
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
5.6</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 2
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 3
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
   <td><p style="text-align: right">
7.1</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 4
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 5
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
  </tr>
  <tr>
   <td>Trial 6
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
6.2</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 7
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
   <td><p style="text-align: right">
3.7</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 8
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
5.9</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Trial 9
   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
3.2</p>

   </td>
   <td><p style="text-align: right">
6.8</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
  </tr>
  <tr>
   <td>Trial 10
   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
3.1</p>

   </td>
   <td><p style="text-align: right">
6.1</p>

   </td>
   <td><p style="text-align: right">
3</p>

   </td>
  </tr>
  <tr>
   <td>Average
   </td>
   <td><p style="text-align: right">
3.13</p>

   </td>
   <td><p style="text-align: right">
3.12</p>

   </td>
   <td><p style="text-align: right">
5.37</p>

   </td>
   <td><p style="text-align: right">
3.05</p>

   </td>
  </tr>
</table>



# Analysis


## Benchmark 1

For the piApprox benchmark, the Stensl implementation was 910x slower than Python, 7.03x slower than Groovy, and 1890x slower than Java. Python was much faster than I expected relative to Groovy and Stensl, but Stensl itself was well within the 10x neighborhood of Groovy that I set out to meet. In terms of memory, Stensl took 1.8x more memory than Python, 1.36x more than Groovy, and 1.32x more than Java, again well within the general expectations for this test.


## Benchmark 2

For the stringManip benchmark, the Stensl implementation was 96.3x slower than Python, 8.77x slower than Groovy, and 34.96x slower than Java. This was generally the fastest benchmark for Stensl relative to other languages, which makes sense because much of Stensl’s data storage is done in strings anyway, so string operations take less time in conversion. In terms of memory, Stensl took 1.25x less memory than Python, 1.24x more memory than Groovy, and 1.08x more memory than Java.


## Benchmark 3

For the twoSum benchmark, the Stensl implementation was 1356x slower than Python, 12.67x slower than Groovy, and 1043x slower than Java. This was the slowest of the three benchmarks generally, and the only one where Stensl was more than 10x slower than Groovy, albeit not by much. This signals to me that the array implementation in Stensl probably needs special attention, as it seems to be even more inefficient than the rest of the language. For memory, Stensl took just 1.003x more than Python, 1.72x less than Groovy, and 1.02x more than Java.


## Conclusion

Overall, Stensl is far slower than any of the three languages tested, but is within the expected speed that was set out at the beginning of the test. In terms of memory, Stensl performed comparably to most of the other languages used in the test across any of the benchmarks. Promisingly, the language to which Stensl is most similar on a functional level, Groovy, also seems to be its closest peer in terms of speed, with Stensl performing only around 10x slower than it on average. Array operations seem to be Stensl’s slowest area from these data, and string operations seem to be the fastest. These data provide a roadmap to improve Stensl in the future, to possibly allow it to meet or surpass Groovy. Overall, while this paper clearly shows that performance is not Stensl’s strong suit, there are some promising measurements here, such as memory usage, that are relatively good for a language in the farthest of pre-alpha states. Hopefully, Stensl will be able to improve significantly following the data of this test.
