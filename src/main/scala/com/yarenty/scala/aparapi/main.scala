package com.yarenty.scala.aparapi

import scala.collection.JavaConversions._
import com.yarenty.java.aparapi.MultiplicityKernel

object main {
  def main(args: Array[String]) {
    println("Main starting")
    
    val cl = new MultiplicityKernel();
    
   // cl.init();
    
    cl.go();
    
  }
    
  
  
}