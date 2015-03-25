# scala_aparapi
Test of connection between scala and aparapi (OpenCL)

# STATUS

## On Java side:
* default loops works perfect @see SimpleAdd.java
* sending simple structures from scala to java works  - @see MultiplicityKernel.java
* sending scala structures and internally transforms them (prepare) to simple arrays works - @see MultiplicityToupleKernel.java
* using complicated sttructures (Objects!) not working on GPU but aparapi uses JTP to run it - @see MultiplicityStructureKernel.java

## On Scala side:
* openCL info is working same as in java side - @see openclInfo.scala
* all others are not working 
	- aparapi claims that:  Found unexpected Attribute (name = Scala) ;-)
	-  and: @47 AASTORE We don't support copying refs in kernels
	-  or: Object array elements cannot contain
Basically internal structure of arrays inside scala is not same as in java, tried to force to use java fields but ... there is autoboxig involved .. which prevent using it.
	

# OUTPUT
Use java code to move structures from scala world into simple arrays understand by java/C.
 
