package cn.edu.hdu.ckt.testcase;
//���յĸ��ݲ����Ͳ�����Ӧ��������Ӳ���ʽ��
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AddBdsType {
	public static void main(String[] args) {//�����ܷ�����
		Map<String,String> map = new HashMap<String,String>();
		String condition="cycle=2.5ms--control_mode==0#control_mode:int8_t--motor_state==True &&  ap.throttle_zero==False#motor_state:bool,ap.throttle_zero:bool";
//		System.out.println("cycle=2.5ms");
//		System.out.println("control_mode==0#control_mode:int8_t");
//		System.out.println("motor_state==True &&  ap.throttle_zero==False#motor_state:bool,ap.throttle_zero:bool");
		map.put("control_mode","int8_t");
		map.put("motor_state","bool");
		map.put("ap.throttle_zero","bool");
		map.put("moto","double");
		//Set<String> set = map.keySet();
		//System.out.println("=================================="+set.toString());
		//System.out.println("keyset���ϣ�"+set);
		String cs1 = getcs(map);
		String cs2 = getDoubleCs(map);
		String cs3 = getBoolCs(map);
		System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
		System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
		System.out.println("����condition���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);
		
		System.out.println("-----------");
		
		String s1 = add_bds(map);
		String s2 = add_doublebds(map);
		System.out.println("����condition���������������ʽΪ��"+s1);
		System.out.println("����condition�������С������ʽΪ��"+s2);
		
		
		
//		for (String key : set) {
//			//System.out.println("key���������ͣ�"+map.get(key));
//			System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+map.get(key));
//			
//		}
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * ��������Ͳ���ʽ
	 * @param getmap
	 * @return
	 */
	public static String add_bds(Map<String,String> getmap){
		List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		//System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			//System.out.println("key���������ͣ�"+getmap.get(key));
			//System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key).equals("int8_t")){
				//String s="-128<="+key.trim()+"<=127,"+key.trim()+"��integers";
				String s="-128<="+key.trim()+"<=128";
				list.add(s);
			}
			if(getmap.get(key).equals("uint8_t")){
				//String s="0<="+key.trim()+"<=255,"+key.trim()+"��integers";
				String s="0<="+key.trim()+"<=256";
				list.add(s);	
			}
			if(getmap.get(key).equals("int16_t")){
				//String s="-32768<="+key.trim()+"<=32767,"+key.trim()+"��integers";
				String s="-32768<="+key.trim()+"<=32768";
				list.add(s);
			}
			if(getmap.get(key).equals("uint16_t")){
				//String s="0<="+key.trim()+"<=65535,"+key.trim()+"��integers";
				String s="0<="+key.trim()+"<=65536";
				list.add(s);
			}
			if(getmap.get(key).equals("int32_t")){
				//String s="-2147483648<="+key.trim()+"<=2147483647,"+key.trim()+"��integers";
				//String s="-2147483648<="+key.trim()+"<=2147483647";
				String s="-32768<="+key.trim()+"<=32768";
				list.add(s);
			}
			if(getmap.get(key).equals("uint32_t")){
				//String s="0<="+key.trim()+"<=4294967295,"+key.trim()+"��integers";
				//String s="0<="+key.trim()+"<=4294967295";
				String s="0<="+key.trim()+"<=65536";
				list.add(s);
			}
			if(getmap.get(key).equals("int64_t")){
				//String s="-9223372036854775808<="+key.trim()+"<=9223372036854775807,"+key.trim()+"��integers";
				//String s="-9223372036854775808<="+key.trim()+"<=9223372036854775807";
				String s="-32768<="+key.trim()+"<=32768";
				list.add(s);
			}
			if(getmap.get(key).equals("uint64_t")){
				//String s="0<="+key.trim()+"<=1844674407370955161,"+key.trim()+"��integers";
				//String s="0<="+key.trim()+"<=1844674407370955161";
				String s="0<="+key.trim()+"<=65537";
				list.add(s);
			}
			/*if(getmap.get(key).equals("float")){
				String s="-32768.00<="+key.trim()+"<=32769.00";
				list1.add(s);
			}
			if(getmap.get(key).equals("double")){
				String s="-32768.00<"+key.trim()+"<32770.00";
				list1.add(s);
			}*/
		}
		if(list.size()>1){
			ss=list.get(0);
			for(int j=1;j<list.size();j++){
				s1=list.get(j);
				ss=ss+","+s1;
			}
		}
		if(list.size()==1){
			ss=list.get(0);
		}	
		if(list.size()<=0){
			return null;
		}
		return ss;
		
	}
	
	
	
	/**
	 * ���С���͵Ĳ���ʽ
	 * @param getmap
	 * @return
	 */
	public static String add_doublebds(Map<String,String> getmap){
		List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		//System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			//System.out.println("key���������ͣ�"+getmap.get(key));
			//System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key).equals("float")){
				String s="-32768.00<="+key.trim()+"<=32769.00";
				list1.add(s);
			}
			if(getmap.get(key).equals("double")){
				String s="-32768.00<"+key.trim()+"<32770.00";
				list1.add(s);
			}
		}
		if(list1.size()>1){
			ss=list1.get(0);
			for(int j=1;j<list1.size();j++){
				s1=list1.get(j);
				ss=ss+","+s1;
			}
		}
		if(list1.size()==1){
			ss=list1.get(0);
		}	
		if(list1.size()<=0){
			return null;
		}
		return ss;
		
	}


	
	
	/**
	 * ��Ӳ����͵Ĳ���ʽ
	 * @param getmap
	 * @return
	 */
	public static String add_boolbds(String boolcs){
		List<String> list1=new ArrayList<String>(); //������ӵĲ�������ʽ
		String s1=new String();
		String ss=new String();
		if(boolcs.contains(",")){
			String[] css=boolcs.split(",");
			for(String cs:css){
				String s=cs+"=True||"+cs+"=False";
				list1.add(s);
			}
		}else{
			String s=boolcs+"=True||"+boolcs+"=False";
			list1.add(s);
		}
		
		if(list1.size()>1){
			ss=list1.get(0);
			for(int j=1;j<list1.size();j++){
				s1=list1.get(j);
				ss=ss+","+s1;
			}
		}
		if(list1.size()==1){
			ss=list1.get(0);
		}	
		if(list1.size()<=0){
			return null;
		}
		return ss;
		
	}


	
	
	/**
	 * �õ���������ֵ����
	 * @param getmap
	 * @return
	 */
	public static String getcs(Map<String,String> getmap){
		//List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		//List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		List<String> list2=new ArrayList<String>(); //��������Ͳ���
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		//System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			//System.out.println("key���������ͣ�"+getmap.get(key));
			//System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key).equals("int8_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("uint8_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("int16_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("uint16_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("int32_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("uint32_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("int64_t")){
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("uint64_t")){
				list2.add(key.trim());
			}
		}
		if(list2.size()>1){
			ss=list2.get(0);
			for(int j=1;j<list2.size();j++){
				s1=list2.get(j);
				ss=ss+","+s1;
			}
		}
		if(list2.size()==1){
			ss=list2.get(0);
		}	
		if(list2.size()<=0){
			return null;
		}
		return ss;
		
	}
	
	
	
	
	/**
	 * �õ�С������ֵ����
	 * @param getmap
	 * @return
	 */
	public static String getDoubleCs(Map<String,String> getmap){
		//List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		//List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		List<String> list2=new ArrayList<String>(); //���С������ֵ����
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		//System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			//System.out.println("key���������ͣ�"+getmap.get(key));
			//System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key).equals("float")){
				//String s="<="+key.trim()+"<=";
				list2.add(key.trim());
			}
			if(getmap.get(key).equals("double")){
				//String s="<="+key.trim()+"<=";
				list2.add(key.trim());
			}
		}
		if(list2.size()>1){
			ss=list2.get(0);
			for(int j=1;j<list2.size();j++){
				s1=list2.get(j);
				ss=ss+","+s1;
			}
		}
		if(list2.size()==1){
			ss=list2.get(0);
		}	
		if(list2.size()<=0){
			return null;
		}
		return ss;
		
	}
	
	
	/**
	 * �õ�bool����ֵ����
	 * @param getmap
	 * @return
	 */
	public static String getBoolCs(Map<String,String> getmap){
		//List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		//List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		List<String> list2=new ArrayList<String>(); //��Ų�������ֵ����
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		//System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			//System.out.println("key���������ͣ�"+getmap.get(key));
			//System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key).equals("bool")){
				//String s="<="+key.trim()+"<=";
				list2.add(key.trim());
			}
		}
		if(list2.size()>1){
			ss=list2.get(0);
			for(int j=1;j<list2.size();j++){
				s1=list2.get(j);
				ss=ss+","+s1;
			}
		}
		if(list2.size()==1){
			ss=list2.get(0);
		}	
		if(list2.size()<=0){
			return null;
		}
		return ss;
		
	}
	
}

