package com.yarenty.java.aparapi;

import com.amd.aparapi.*;

import static scala.collection.JavaConversions.*;

public class MultiplicityKernel {

	public float[] go(final float[] in) {

		final float out[] = new float[in.length];

		Kernel kernel = new Kernel() {
			@Override
			public void run() {
				int i = getGlobalId();
				out[i] = in[i] * in[i];
			}
		};

		kernel.execute(Range.create(in.length));

		if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)) {
			System.out.println("Kernel not execute on the GPU!");
		} else {
			System.out.println("Execution mode::" + kernel.getExecutionMode());
		}

		kernel.dispose();

		return out;
	}

}
