package com.yarenty.java.aparapi;

import com.amd.aparapi.*;

import static  scala.collection.JavaConversions.*;

public class MultiplicityKernel {

//	final float in[] = new float[8192]; // initialization of in[0..8191] omitted
//	final float out[] = new float[8129]; //out[in.length];
//
//	
//	
//	public void init() {
//		for (int i=0; i< in.length; i++) {
//			in[i] = (float) Math.random();
//		}
//	}
//	
	
	
	public void go() {
		
		final int size = 100;
		final float in[] = new float[size]; // initialization of in[0..8191] omitted
		final float out[] = new float[size]; //out[in.length];

		for (int i=0; i< in.length; i++) {
			in[i] = (float) Math.random();
		}
	
		
		Kernel kernel = new Kernel(){
		   @Override public void run(){
		      int i = getGlobalId();
		      out[i]=in[i]*in[i];
		   }
		};
		
		
		kernel.execute(Range.create(in.length));
		
		if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)){
			   System.out.println("Kernel not execute on the GPU!");
		}
		
		
		kernel.dispose();
	}
	
}
