package com.yarenty.scala.aparapi

object tstsheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(96); 
  println("Welcome to the Scala worksheet");$skip(55); 

  val c = java.lang.Class.forName("java.lang.Double");System.out.println("""c  : Class[_] = """ + $show(c ));$skip(15); 
  val size = 5;System.out.println("""size  : Int = """ + $show(size ));$skip(67); 

  val a = Array.fill[Float](size) { scala.util.Random.nextFloat };System.out.println("""a  : Array[Float] = """ + $show(a ));$skip(66); 
  val b = Array.fill[Float](size) { scala.util.Random.nextFloat };System.out.println("""b  : Array[Float] = """ + $show(b ));$skip(82); 

  var s = Array.fill[Float](size)(0);System.out.println("""s  : Array[Float] = """ + $show(s ));$skip(34); ; // if not initialized like that - no JTP!!

  var s2 = Array.ofDim[Float](5)


  import java.lang.reflect.Array;System.out.println("""s2  : Array[Float] = """ + $show(s2 ));$skip(81); 

  var sum: Object = Array.newInstance(c, 10);System.out.println("""sum  : Object = """ + $show(sum ));$skip(37); 

  var out = sum.asInstanceOf[Array];System.out.println("""out  : java.lang.reflect.Array = """ + $show(out ))}

}
