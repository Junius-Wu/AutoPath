package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;



public class Mathematica {
	private static String parameter1;    //����ʽ���
	private static String parameter2;    //����
	private static String result;        //����Ľ�

	private static Map<String, String> varToVoc;

	public static String getSolution(String param1, String param2) {

		KernelLink ml = null;

		String path = "-linkmode launch -linkname 'D:\\Mathematica\\10.2\\MathKernel.exe'";
		try {

			ml = MathLinkFactory.createKernelLink(path);
		} catch (MathLinkException e) {
			System.out.println("Fatal error opening link: " + e.getMessage());
			return null;
		}

		try {
			// Get rid of the initial InputNamePacket the kernel will send
			// when it is launched.
			ml.discardAnswer();

			ml.evaluate("<<MyPackage.m");
			ml.discardAnswer();

			ml.putFunction("FindInstance", 3);

			ml.endPacket();
			ml.waitForAnswer();
			String result1 = ml.getString();

			// If you want the result back as a string, use evaluateToInputForm
			// or evaluateToOutputForm. The second arg for either is the
			// requested page width for formatting the string. Pass 0 for
			// PageWidth->Infinity. These methods get the result in one
			// step--no need to call waitForAnswer.
			String strResult = ml.evaluateToOutputForm(
					"A = SetAccuracy[FindInstance[" + param1 + ", " + param2
					+ ", 50], 20]; A[[RandomInteger[{1, Length[A]}]]]",
					0);
			// System.out.println(strResult);
			return strResult;

		} catch (MathLinkException e) {
			System.out.println("MathLinkException occurred: " + e.getMessage());
		} finally {
			ml.close();
		}
		return null;

	}
	/**
	 * ���������ֵ��
	 * @param param1  bds
	 * @param param2  cs
	 * @return
	 */
	public static KernelLink ml;
	public static final String PATH ="-linkmode launch -linkname 'D:\\Mathematica\\10.2\\MathKernel.exe'";
	public static String getSolution2(String param1, String param2) {

//		KernelLink ml = null;
//
//		String path = "-linkmode launch -linkname 'D:\\Mathematica\\10.2\\MathKernel.exe'";
		try {

			if (ml == null) {

				ml = MathLinkFactory.createKernelLink(PATH);
				ml.discardAnswer();

				ml.evaluate("<<MyPackage.m");
				ml.discardAnswer();

				ml.putFunction("FindInstance", 3);

				ml.endPacket();
				ml.waitForAnswer();
				String result1 = ml.getString();
			}
		} catch (MathLinkException e) {
			System.out.println("Fatal error opening link: " + e.getMessage());
			return null;
		}

		try {
			// Get rid of the initial InputNamePacket the kernel will send
			// when it is launched.
//			ml.discardAnswer();
//
//			ml.evaluate("<<MyPackage.m");
//			ml.discardAnswer();
//
//			ml.putFunction("FindInstance", 3);
//
//			ml.endPacket();
//			ml.waitForAnswer();
//			String result1 = ml.getString();

			// If you want the result back as a string, use evaluateToInputForm
			// or evaluateToOutputForm. The second arg for either is the
			// requested page width for formatting the string. Pass 0 for
			// PageWidth->Infinity. These methods get the result in one
			// step--no need to call waitForAnswer.

			// ��param1��param2�в�����ʶ����˳��ȫ���滻Ϊ26����ĸ,��ֹ��������������mathematica�������޷�����
			replace(param1, param2);
			//System.out.println(parameter1 + "======" + parameter2);
			//			System.out.println("����ʽ��"+parameter1 + "----�����������" + parameter2);
			/*String strResult = ml.evaluateToOutputForm(
					"SetAccuracy[FindInstance[{" + parameter1 + "}, {"
							+ parameter2 + "}, 1], 3]", 0);*/
			String strResult = ml.evaluateToOutputForm(
					"FindInstance[{" + parameter1 + "}, {"
							+ parameter2 + "},Integers, 40]", 0);
			System.out.println("mma����������ʽ"+parameter1);
			System.out.println("mma����������"+parameter2);
			// System.out.println(strResult);
			// �ٽ��滻�Ĳ�����ʶ���滻��ԭ��
			recovery(strResult);
			//System.out.println(result);
			return result;

		} catch (Exception e) {
			System.out.println("MathLinkException occurred: " + e.getMessage());
		} finally {
//			ml.close();
			// ml = null;
		}
		return null;
	}
	/**
	 * ������Ĳ�����
	 * @param param1  boolbds
	 * @param param2  boolcs
	 * @return
	 */
	public static String getSolution3(String param1, String param2) {

		KernelLink ml = null;
		String path = "-linkmode launch -linkname 'D:\\Mathematica\\10.2\\MathKernel.exe'";
		try {

			ml = MathLinkFactory.createKernelLink(path);
		} catch (MathLinkException e) {
			System.out.println("Fatal error opening link: " + e.getMessage());
			return null;
		}

		try {
			// Get rid of the initial InputNamePacket the kernel will send
			// when it is launched.
			ml.discardAnswer();

			ml.evaluate("<<MyPackage.m");
			ml.discardAnswer();

			ml.putFunction("FindInstance", 3);

			ml.endPacket();
			ml.waitForAnswer();
			String result1 = ml.getString();

			// If you want the result back as a string, use evaluateToInputForm
			// or evaluateToOutputForm. The second arg for either is the
			// requested page width for formatting the string. Pass 0 for
			// PageWidth->Infinity. These methods get the result in one
			// step--no need to call waitForAnswer.

			// ��param1��param2�в�����ʶ����˳��ȫ���滻Ϊ26����ĸ,��ֹ��������������mathematica�������޷�����
			replace(param1, param2);
			//System.out.println(parameter1 + "======" + parameter2);
			//			System.out.println("����ʽ��"+parameter1 + "----�����������" + parameter2);
			String strResult = ml.evaluateToOutputForm(
					"FindInstance[{" + parameter1 + "}, {"
							+ parameter2 + "},Booleans, 1]", 0);
//			System.out.println("mma�в�������ʽ"+parameter1);
//			System.out.println("mma�в�������"+parameter2);
			// System.out.println(strResult);
			// �ٽ��滻�Ĳ�����ʶ���滻��ԭ��
			recovery(strResult);
			//System.out.println(result);
			return result;

		} catch (MathLinkException e) {
			System.out.println("MathLinkException occurred: " + e.getMessage());
		} finally {
			ml.close();
		}
		return null;
	}





	/**
	 * �������С���Ľ�
	 * @param param1  boolbds
	 * @param param2  boolcs
	 * @return
	 */
	public static String getSolution4(String param1, String param2) {

//		KernelLink ml = null;
//		
//		String path = "-linkmode launch -linkname 'D:\\Mathematica\\10.2\\MathKernel.exe'";
		try {

			//ml = MathLinkFactory.createKernelLink(path);
			if (ml == null) {

				ml = MathLinkFactory.createKernelLink(PATH);
				ml.discardAnswer();

				ml.evaluate("<<MyPackage.m");
				ml.discardAnswer();

				ml.putFunction("FindInstance", 3);

				ml.endPacket();
				ml.waitForAnswer();
				String result1 = ml.getString();
			}
		} catch (MathLinkException e) {
			System.out.println("Fatal error opening link: " + e.getMessage());
			return null;
		}

		try {
			// Get rid of the initial InputNamePacket the kernel will send
			// when it is launched.
//			ml.discardAnswer();
//
//			ml.evaluate("<<MyPackage.m");
//			ml.discardAnswer();
//
//			ml.putFunction("FindInstance", 3);
//
//			ml.endPacket();
//			ml.waitForAnswer();
//			String result1 = ml.getString();

			// If you want the result back as a string, use evaluateToInputForm
			// or evaluateToOutputForm. The second arg for either is the
			// requested page width for formatting the string. Pass 0 for
			// PageWidth->Infinity. These methods get the result in one
			// step--no need to call waitForAnswer.

			// ��param1��param2�в�����ʶ����˳��ȫ���滻Ϊ26����ĸ,��ֹ��������������mathematica�������޷�����
			replace(param1, param2);
			//System.out.println(parameter1 + "======" + parameter2);
			//			System.out.println("����ʽ��"+parameter1 + "----�����������" + parameter2);
			String strResult = ml.evaluateToOutputForm(
					"SetAccuracy[FindInstance[{" + parameter1 + "}, {"
							+ parameter2 + "}, 40], 3]", 0);
//			System.out.println("mma��С������ʽ"+parameter1);
//			System.out.println("mma��С������"+parameter2);
			// System.out.println(strResult);
			// �ٽ��滻�Ĳ�����ʶ���滻��ԭ��
			recovery(strResult);
			//System.out.println(result);
			return result;

		} catch (Exception e) {
			System.out.println("MathLinkException occurred: " + e.getMessage());
		} finally {
//			ml.close();
		}
		return null;
	}


	
	/*public static void closes(){
		if(ml==null){
			ml.close();
		}
	}*/



	/**
	 * ���������еı�����ԭΪ�����Ĳ�����ʶ��
	 * 
	 * @param strResult
	 */
	private static void recovery(String strResult) {
		Set<String> keySet = varToVoc.keySet();
		for (String key : keySet) {
			strResult = strResult.replace(varToVoc.get(key) + " ", key.trim());
			System.out.println(varToVoc.get(key)+"--"+key.trim());
		}
		result = strResult;
	}

	/**
	 * ��������ʶ������ĸ���滻
	 * 
	 * @param param1
	 * @param param2
	 */
	private static void replace1(String param1, String param2) {
		String[] vars = param2.split(",");
		varToVoc = new HashMap<String, String>();
		char vocabulary = 'A';		
		for (String var : vars) {
			param2 = param2.replace(var.trim(), vocabulary + "");
			param1 = param1.replace(var.trim(), vocabulary + "");
			varToVoc.put(var.trim(), vocabulary + "");
			vocabulary = (char) (vocabulary + 1);
		}
		parameter1 = param1;
		parameter2 = param2;
		// System.out.println(param1 + "---" + param2);

	}
	
	
	
	/**
	 * ��������ʶ������ĸ���滻
	 * 
	 * @param param1
	 * @param param2
	 */
	private static void replace(String param1, String param2) {
		String[] vars = param2.split(",");
		varToVoc = new HashMap<String, String>();
		char vocabulary = 'a';
		// �滻������
		for (int i = 0; i < vars.length; i++) {
			varToVoc.put(vars[i].trim(), vocabulary + "");
			vars[i] = vocabulary + "";
			vocabulary = (char) (vocabulary + 1);
		}
		// �滻����ʽ��
		String[] inequals = param1.split(",");
		//for (int i = inequals.length-1; i >=0; i--) {
		for (int i = 0; i <inequals.length; i++) {
			//System.out.println(i+":::"+inequals[i].trim());
			String inequ = inequals[i].trim();
			List<String> names = filter(inequ);         //
			for (String name : names) {
				
				String value = varToVoc.get(name);   //a b c
				//System.out.println("ȡ����ֵ��"+value);
				//System.out.println("�滻�Ĳ�����"+name);
				inequals[i] = inequals[i].replace(name, value);//////������
				//System.out.println("�滻�󲻵�ʽ"+inequals[i]);
			}
		}

		parameter1 = compose(inequals);
		parameter2 = compose(vars);
		// System.out.println(param1 + "---" + param2);

	}

	private static String compose(String[] vars) {
		String str = "";
		for (int i = 0; i < vars.length; i++) {
			if (i < vars.length - 1) {
				str = str + vars[i] + ",";
			} else {
				str = str + vars[i];
			}
		}
		return str;
	}

	private static List<String> filter(String inequ) {
		List<String> list=new ArrayList<String>();
		List<String> list1=new ArrayList<String>();
		Set<String> keySet = varToVoc.keySet();
		String[] split = inequ.split("[-+<>=!]=?");
		
		for (String string : split) {
            //System.out.println("++++++  "+string);
			for (String key : keySet) {
				if (string.trim().equals(key.trim())) {
					//System.out.println("--->  "+string.trim());
					list.add(string.trim());
					//return string.trim();
				}
			}
		}
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				
				return str2.length()-str1.length();
			}
		});
		return list;
		//return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	


}
