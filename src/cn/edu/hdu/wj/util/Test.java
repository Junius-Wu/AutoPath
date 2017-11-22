package cn.edu.hdu.wj.util;

import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import Jama.Matrix;
import cn.edu.hdu.ckt.handle.*;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.ckt.testcase.*;
import cn.edu.hdu.wj.bean.*;

public class Test {
	private static ArrayList<Automatic> paths;

	public static void main(String args[]) throws Exception {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time1=System.currentTimeMillis();  
		String TimeString = time.format(new java.util.Date());
		System.out.println(TimeString);
		
		int min = Integer.MAX_VALUE;
		// 用法
		Automatic automatic = GetAutomatic.getAutomatic("UAVForXStreamGaoDuV9.xml");
		
		// 迁移覆盖的所有路径
		paths = GeneratePath.getFormatPathFromAutomatic(copy(automatic), 200);

//		
		System.out.println("Min =" + min);
// 性能测试的一条路径
//		GeneratePath.getPerformPathFromAutomatic(automatic);
		TimeString = time.format(new java.util.Date());
		System.out.println(TimeString);
	}

	private static Automatic copy(Automatic automatic) {
		Automatic res = new Automatic();
		res.setClockSet(new ArrayList<String>() );
		res.getClockSet().addAll(automatic.getClockSet());
		res.setInitState(automatic.getInitState());
		res.setName(automatic.getName());
		res.setStateSet(new ArrayList<>());
		res.getStateSet().addAll(automatic.getStateSet());
		res.setTransitionSet(new ArrayList<>());
		res.getTransitionSet().addAll(automatic.getTransitionSet());
		return res;
	}
}
