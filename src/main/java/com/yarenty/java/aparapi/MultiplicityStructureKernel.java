package com.yarenty.java.aparapi;

import java.util.List;


import scala.Long;
import scala.Tuple2;
import scala.collection.Iterator;

import com.amd.aparapi.*;

import com.yarenty.scala.aparapi.*;

import static  scala.collection.JavaConversions.*;

public class MultiplicityStructureKernel {


	/***
	 * NOT WORKING!!!
	 * 
	 * OUTPUT:
	 * <code>
com.amd.aparapi.internal.exception.ClassParseException: @0 NEW We don't support new instructions
	at com.amd.aparapi.internal.model.MethodModel.createListOfInstructions(MethodModel.java:280)
	at com.amd.aparapi.internal.model.MethodModel.init(MethodModel.java:1656)
	at com.amd.aparapi.internal.model.MethodModel.<init>(MethodModel.java:1472)
	at com.amd.aparapi.internal.model.ClassModel.getMethodModel(ClassModel.java:2589)
	at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2622)
	at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2631)
	at com.amd.aparapi.internal.kernel.KernelRunner.execute(KernelRunner.java:935)
	at com.amd.aparapi.Kernel.execute(Kernel.java:1985)
	at com.amd.aparapi.Kernel.execute(Kernel.java:1916)
	at com.amd.aparapi.Kernel.execute(Kernel.java:1886)
	at com.yarenty.java.aparapi.MultiplicityStructureKernel.go(MultiplicityStructureKernel.java:36)
	at com.yarenty.scala.aparapi.main$.main(main.scala:64)
	at com.yarenty.scala.aparapi.main.main(main.scala)
	 * </code>
	 * 
	 * @param in
	 * @return
	 */
	
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
