# java-mapper-performance-test
this project evaluates performance using manual mapping, bean utils map and property utils map. 

It runs 100K times, manual mapping, bean utils and property utils mapping for 3 string, 1 integer and 1 big decimal object. 
It generates random object for each of mapping.

<b>Output</b><br/>
Hand Coded : 62<br/>
Bean Utils : 1858<br/>
%increase = 29.967741 times<br/>
Property Utils : 611<br/>
%increase = 9.854838 times<br/>
<br/>
all in milliseconds
