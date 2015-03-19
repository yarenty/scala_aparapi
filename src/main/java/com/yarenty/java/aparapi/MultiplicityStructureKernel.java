package com.yarenty.java.aparapi;

import java.util.List;


import scala.Long;
import scala.Tuple2;
import scala.collection.Iterator;

import com.amd.aparapi.*;

import com.yarenty.scala.aparapi.*;

import static  scala.collection.JavaConversions.*;

public class MultiplicityStructureKernel {


	
	public float[] go(final List<Tuple2<Long, ComplicatedStructure>> in) {
		

		final float out[] = new float[in.size()]; //out[in.length];


		
		Kernel kernel = new Kernel(){
		   @Override public void run(){
		      int i = getGlobalId();
		      out[i]=((ComplicatedStructure)in.get(i)._2 ).value() * ((ComplicatedStructure)in.get(i)._2).value();
		   }
		};
		
		
		kernel.execute(Range.create(in.size()));
		
		if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)){
			   System.out.println("Kernel not execute on the GPU!");
		} else {
			System.out.println("Execution mode::" + kernel.getExecutionMode());
		}
		
		
		kernel.dispose();
		
		return out;
	}
	
}
