package com.yarenty.java.aparapi;

import java.util.List;


import scala.Long;
import scala.Tuple2;
import scala.collection.Iterator;

import com.amd.aparapi.*;

import com.yarenty.scala.aparapi.*;

import static  scala.collection.JavaConversions.*;

public class MultiplicityToupleKernel {


	
	
	public float[] go(final List<Tuple2<Long, Float>> in) {
		
//		final int size = 100;
//		final float in[] = new float[size]; // initialization of in[0..8191] omitted
		final float out[] = new float[in.size()]; //out[in.length];

		
		Kernel kernel = new Kernel(){
		   @Override public void run(){
		      int i = getGlobalId();
		      out[i]=in.get(i)._2 *in.get(i)._2;
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
