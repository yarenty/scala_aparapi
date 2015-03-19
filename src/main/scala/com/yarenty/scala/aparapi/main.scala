package com.yarenty.scala.aparapi

import scala.collection.JavaConversions._
import com.yarenty.java.aparapi._

object main {
  def main(args: Array[String]) {
    println("Main starting")
    
    println("get OpenCL info");
    Info.getInfo();
    
    
    println("and try some simple kernel");

    SimpleAdd.addMe();
    
    println("and try some kernel with simple array copy");
    val cl = new MultiplicityKernel();
    
   // cl.init();
    
    val in = Array.fill[Float](10){scala.util.Random.nextFloat*10}
    // and go go go ;-)
    val out = cl.go(in)
    
    println(in.mkString(", "))
    println(out.mkString(", "))
    
    
    
  }
    
  
  
}