package com.yarenty.scala.aparapi

import com.amd.aparapi.Kernel
import com.amd.aparapi.Range

object simpleAdd {

  /**
   *   NOT WORKING ON GPU:
   *  <pre> <code>
   *   Mar 20, 2015 1:15:38 PM com.amd.aparapi.internal.model.ClassModel$AttributePool <init>
   * WARNING: Found unexpected Attribute (name = Scala)
   * Scope block from 5 to  30
   * Mar 20, 2015 1:15:38 PM com.amd.aparapi.internal.kernel.KernelRunner warnFallBackAndExecute
   * WARNING: Reverting to Java Thread Pool (JTP) for class com.yarenty.scala.aparapi.simpleAdd$$anon$1: Object array elements cannot contain
   * com.amd.aparapi.internal.exception.ClassParseException: Object array elements cannot contain
   * at com.amd.aparapi.internal.model.Entrypoint.updateObjectMemberFieldAccesses(Entrypoint.java:324)
   * at com.amd.aparapi.internal.model.Entrypoint.<init>(Entrypoint.java:657)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2623)
   * at com.amd.aparapi.internal.model.ClassModel.getEntrypoint(ClassModel.java:2631)
   * at com.amd.aparapi.internal.kernel.KernelRunner.execute(KernelRunner.java:935)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1985)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1916)
   * at com.amd.aparapi.Kernel.execute(Kernel.java:1886)
   * at com.yarenty.scala.aparapi.simpleAdd$.addMe(simpleAdd.scala:26)
   * at com.yarenty.scala.aparapi.main$.main(main.scala:20)
   * </code> </pre>
   */
  def addMe() {

    val size = 512

    val a = Array.fill[Float](size) { scala.util.Random.nextFloat }
    val b = Array.fill[Float](size) { scala.util.Random.nextFloat }

    var sum = Array.fill[Float](size)(0);

    val kernel = new Kernel() {
      @Override
      def run() {
        val gid = getGlobalId();
        sum(gid) = a(gid) + b(gid);
      }
    };

    kernel.execute(Range.create(512));

    var i = 0
    for (i <- 0 to 20) {
      printf("%6.2f + %6.2f = %8.2f\n", a(i), b(i), sum(i));
    }

    if (!kernel.getExecutionMode().equals(Kernel.EXECUTION_MODE.GPU)) {
      println("Kernel not execute on the GPU!");
    } else {
      println("Execution mode::" + kernel.getExecutionMode());
    }

    kernel.dispose();
  }

}