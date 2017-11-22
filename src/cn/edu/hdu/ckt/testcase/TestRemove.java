package cn.edu.hdu.ckt.testcase;

public class TestRemove {

	public static void main(String[] args) {
		String bbb = "y>1,x!=0,x==0";
		System.out.println(Remove(bbb));

	}
	/**
	 * �������mathematica���Ϊ�գ�������ʽ����ì�ܣ������Ա�
	 * �Ƴ�ì�ܵĲ���ʽ��ȡ��һ������ʽ
	 */
	public static String Remove(String bbb){
		System.out.println("ԭ������ʽ��"+bbb);
		String cs1 = null;
		String cs2 = null;
		String bds[] = bbb.split(",");

		for(int i=0;i<bds.length-1;i++){
			for(int j=i+1;j<bds.length;j++){
				//System.out.println(bds[i]+"------"+bds[j]);
				//System.out.println(getNumber(bds[i]));
				//System.out.println(getNumber(bds[j]));
				if(getNumber(bds[i]) && getNumber(bds[j])){					
					String[] css = bds[i].trim().split("[-!+<>=]=?");
					for(String cs:css){						
						if(!cs.equals("")){
							int s1=cs.trim().substring(0,1).toCharArray()[0];
							if(!((s1>=48&&s1<=57)||s1==45)){//��һ��Ϊ����
								cs1 = cs;
								//System.out.println("��һ������ʽ������"+cs);
							}
						}				
					}
					String[] css1 = bds[j].trim().split("[-!+<>=]=?");
					for(String cs:css1){
						
						if(!cs.equals("")){
							int s1=cs.trim().substring(0,1).toCharArray()[0];
							if(!((s1>=48&&s1<=57)||s1==45)){//��һ��Ϊ����
								cs2 = cs;
								//System.out.println("�ڶ�������ʽ������"+cs);
							}
						}				
					}
					if(cs1.equals(cs2)){
						String bds1 = bds[i]+","+bds[j];
						String cs = cs1;
						String solution = Mathematica.getSolution2(bds1, cs);
						//System.out.println("solution---"+solution);
						if(solution.equals("{}")){
							bbb=bbb.replaceAll(bds[i]+",", "");								
						}						
					}					 
				}
			}
		}
		System.out.println("�����Ĳ���ʽ"+bbb);
		return bbb;
	}

	/**
	 * �ж�ÿ������ʽ������Ƿ�ֻ��һ��
	 * @param domain1
	 * @return
	 */
	public static boolean getNumber(String bds) {

		int number=0;
		String[] css = bds.trim().split("[!-+<>=]=?");
		for(String cs:css){
			if(!cs.equals("")){
				int s1=cs.trim().substring(0,1).toCharArray()[0];
				if(!((s1>=48&&s1<=57)||s1==45)){//��һ��Ϊ����
					number++;
				}
			}				
		}
		if(number<=1){
			//System.out.println("һ������");
			return true;
		}else{
			//System.out.println("�������");
			return false;
		}

	}
}
