package com.yarenty.scala.aparapi

import scala.collection.JavaConversions._
import com.yarenty.java.aparapi._
import com.yarenty.scala.aparapi.ComplicatedStructure

object main {
  def main(args: Array[String]) {
    println("Main starting")
    
    println("get OpenCL info")
    Info.getInfo()
    
    
    println("and try some simple kernel")

    SimpleAdd.addMe()
    
    println("and try some kernel with simple array copy")
    val cl = new MultiplicityKernel()
    
   // cl.init();
    
    val in = Array.fill[Float](10){scala.util.Random.nextFloat*10}
    // and go go go ;-)
    val out = cl.go(in)
    
    println(in.mkString(", "))
    println(out.mkString(", "))
    
    
    
    
    val tpl :List[(Long,java.lang.Float)] = List(
      ( 1111111l, 1.0f),
      ( 1111111l, 2.0f),
      ( 1111111l, 3.0f),
      ( 1111111l, 4.0f),
      ( 1111111l, 5.0f)
    )
  
    println("and try some kernel with complicated strycture copy")
    
    val cl2 = new MultiplicityToupleKernel()
    
    val out2 = cl2.go(tpl)
  
    println(out2.mkString(", "))
    
    
    
    
    val database  = List(
      ( 1111111l, ComplicatedStructure(1,1,1.0f)),
      ( 1111111l, ComplicatedStructure(1,1,2.0f)),
      ( 1111111l, ComplicatedStructure(1,1,3.0f)),
      ( 1111111l, ComplicatedStructure(1,1,4.0f)),
      ( 1111111l, ComplicatedStructure(1,1,5.0f))
    )
  
    println("and try some kernel with complicated strycture copy")
    
    val cl3 = new MultiplicityStructureKernel()
    
    val out3 = cl3.go(database)
  
    println(out3.mkString(", "))
  
  }
  
}