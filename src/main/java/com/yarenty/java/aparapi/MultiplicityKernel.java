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
	
	
	public float[] go(final float[] in) {
		
//		final int size = 100;
//		final float in[] = new float[size]; // initialization of in[0..8191] omitted
		final float out[] = new float[in.length]; //out[in.length];

		
		Kernel kernel = new Kernel(){
		   @Override public void run(){
		      int i = getGlobalId();
		      out[i]=in[i]*in[i];
		   }
		};
		
		
		kernel.execute(Range.create(in.length));
		
		if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)){
			   System.out.println("Kernel not execute on the GPU!");
		} else {
			System.out.println("Execution mode::" + kernel.getExecutionMode());
		}
		
		
		kernel.dispose();
		
		return out;
	}
	
}
