package com.yarenty.scala.aparapi

import com.amd.aparapi.Kernel
import com.amd.aparapi.Range
import java.lang.Float
import scala.collection.JavaConversions._

object simpleAddUsingForcedDoubles {

  /**
   * NOT WORKING ON GPU:
   *
   * Mar 20, 2015 1:17:25 PM com.amd.aparapi.internal.model.ClassModel$AttributePool <init>
   * WARNING: Found unexpected Attribute (name = Scala)
   * com.amd.aparapi.internal.exception.ClassParseException: @47 AASTORE We don't support copying refs in kernels
   * at com.amd.aparapi.internal.model.MethodModel.createListOfInstructions(MethodModel.java:284)
   * at com.amd.aparapi.internal.model.MethodModel.init(MethodModel.java:1656)
   * at com.amd.aparapi.internal.model.MethodModel.<init>(MethodModel.java:1472)
   * at com.amd.aparapi.internal.model.ClassModel.getMethodModel(ClassModel.java:2589)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2622)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2631)
   * at com.amd.aparapi.internal.kernel.KernelRunner.execute(KernelRunner.java:935)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1985)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1916)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1886)
   * at com.yarenty.scala.aparapi.simpleAddUsingJavaFloats$.addMe(simpleAddUsingJavaFloats.scala:29)
   * at com.yarenty.scala.aparapi.main$.main(main.scala:22)
   * at com.yarenty.scala.aparapi.main.main(main.scala)
   * Mar 20, 2015 1:17:25 PM com.amd.aparapi.internal.kernel.KernelRunner warnFallBackAndExecute
   * WARNING: Reverting to Java Thread Pool (JTP) for class com.yarenty.scala.aparapi.simpleAddUsingJavaFloats$$anon$1: @47 AASTORE We don't support copying refs in kernels
   * com.amd.aparapi.internal.exception.ClassParseException: @47 AASTORE We don't support copying refs in kernels
   * at com.amd.aparapi.internal.model.MethodModel.createListOfInstructions(MethodModel.java:284)
   * at com.amd.aparapi.internal.model.MethodModel.init(MethodModel.java:1656)
   * at com.amd.aparapi.internal.model.MethodModel.<init>(MethodModel.java:1472)
   * at com.amd.aparapi.internal.model.ClassModel.getMethodModel(ClassModel.java:2589)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2622)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2631)
   * at com.amd.aparapi.internal.kernel.KernelRunner.execute(KernelRunner.java:935)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1985)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1916)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1886)
   * at com.yarenty.scala.aparapi.simpleAddUsingJavaFloats$.addMe(simpleAddUsingJavaFloats.scala:29)
   * at com.yarenty.scala.aparapi.main$.main(main.scala:22)
   * at com.yarenty.scala.aparapi.main.main(main.scala)
   */

  def addMe() {

    val size = 512

    val a: Seq[Double] = scala.Array.fill[Double](size) { scala.util.Random.nextDouble }
    val b: Seq[Double] = scala.Array.fill[Double](size) { scala.util.Random.nextDouble }


    var sum = Array.ofDim[Double](size); 

    val kernel = new Kernel() {
      // @Override
      def run() {
        val gid = getGlobalId();
        sum(gid) = a(gid) + b(gid);
      }
    };

    kernel.execute(Range.create(512));

    if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)) {
      println("Kernel not execute on the GPU!");
    } else {
      println("Execution mode::" + kernel.getExecutionMode());
    }

    var i = 0
    for (i <- 0 to 20) {
      printf("%6.2f + %6.2f = %8.2f\n", a(i), b(i), sum(i));
    }

    kernel.dispose();
  }

}