package com.yarenty.scala.aparapi

object tstsheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val c = java.lang.Class.forName("java.lang.Double")
                                                  //> c  : Class[_] = class java.lang.Double
  val size = 5                                    //> size  : Int = 5

  val a = Array.fill[Float](size) { scala.util.Random.nextFloat }
                                                  //> a  : Array[Float] = Array(0.15943962, 0.027510107, 0.45128012, 0.02070266, 0
                                                  //| .42278826)
  val b = Array.fill[Float](size) { scala.util.Random.nextFloat }
                                                  //> b  : Array[Float] = Array(0.89914227, 0.12810189, 0.37656754, 0.9926107, 0.1
                                                  //| 3674831)

  var s = Array.fill[Float](size)(0); // if not initialized like that - no JTP!!
                                                  //> s  : Array[Float] = Array(0.0, 0.0, 0.0, 0.0, 0.0)

  var s2 = Array.ofDim[Float](5)                  //> s2  : Array[Float] = Array(0.0, 0.0, 0.0, 0.0, 0.0)


  import java.lang.reflect.Array

  var sum: Object = Array.newInstance(c, 10)      //> sum  : Object = Array(null, null, null, null, null, null, null, null, null, 
                                                  //| null)

  var out = sum.asInstanceOf[Array]               //> java.lang.ClassCastException: [Ljava.lang.Double; cannot be cast to java.lan
                                                  //| g.reflect.Array
                                                  //| 	at com.yarenty.scala.aparapi.tstsheet$$anonfun$main$1.apply$mcV$sp(com.y
                                                  //| arenty.scala.aparapi.tstsheet.scala:21)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at com.yarenty.scala.aparapi.tstsheet$.main(com.yarenty.scala.aparapi.ts
                                                  //| tsheet.scala:3)
                                                  //| 	at com.yarenty.scala.aparapi.tstsheet.main(com.yarenty.scala.aparapi.tst
                                                  //| sheet.scala)

}