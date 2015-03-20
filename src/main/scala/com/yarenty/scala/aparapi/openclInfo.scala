package com.yarenty.scala.aparapi

import com.amd.aparapi.device.Device
import com.amd.aparapi.device.OpenCLDevice
import com.amd.aparapi.internal.opencl.OpenCLPlatform

import scala.collection.JavaConversions._

object openclInfo {
  
  def getInfo {
    	println("Starting")
		val platforms = (new OpenCLPlatform()).getOpenCLPlatforms()
		println("Machine contains " + platforms.size() + " OpenCL platforms")
		
		var platformc = 0
		var platform = platforms.get(0)
		for (platform <- platforms) {
			println("Platform " + platformc + "{")
			println("   Name    : \"" + platform.getName() + "\"")
			println("   Vendor  : \"" + platform.getVendor() + "\"")
			println("   Version : \"" + platform.getVersion() + "\"")
			val devices = platform.getOpenCLDevices()
			println("   Platform contains " + devices.size() + " OpenCL devices")
			var devicec = 0
			var device = devices.get(0)
			for ( device <- devices) {
				println("   Device " + devicec + "{")
				println("       Type                  : " + device.getType())
				println("       GlobalMemSize         : " + device.getGlobalMemSize())
				println("       LocalMemSize          : " + device.getLocalMemSize())
				println("       MaxComputeUnits       : " + device.getMaxComputeUnits())
				println("       MaxWorkGroupSizes     : " + device.getMaxWorkGroupSize())
				println("       MaxWorkItemDimensions : " + device.getMaxWorkItemDimensions())
				println("   }")
				devicec += 1
			}
			println("}")
			platformc += 1
		}
/*
		var bestDevice = OpenCLDevice.best()
		if (bestDevice == null) {
			println("OpenCLDevice.best() returned null!")
		} else {
			println("OpenCLDevice.best() returned { ")
			println("   Type                  : " + bestDevice.getType())
			println("   GlobalMemSize         : " + ((OpenCLDevice) bestDevice).getGlobalMemSize())
			println("   LocalMemSize          : " + ((OpenCLDevice) bestDevice).getLocalMemSize())
			println("   MaxComputeUnits       : " + ((OpenCLDevice) bestDevice).getMaxComputeUnits())
			println("   MaxWorkGroupSizes     : " + ((OpenCLDevice) bestDevice).getMaxWorkGroupSize())
			println("   MaxWorkItemDimensions : " + ((OpenCLDevice) bestDevice).getMaxWorkItemDimensions())
			println("}")
		}
  */
    	
  }

}