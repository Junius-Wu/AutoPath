package cn.edu.hdu.ckt.testcase;
//���ݲ����Ͳ�����Ӧ��������Ӳ���ʽ��
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class add_bdscs {
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
		System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			System.out.println("key���������ͣ�"+getmap.get(key));
			System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key)=="int8_t"){
				String s="-128<="+key.trim()+"<=127,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="uint8_t"){
				String s="0<="+key.trim()+"<=255,"+key.trim()+"��integers";
				list.add(s);	
			}
			if(getmap.get(key)=="int16_t"){
				String s="-32768<="+key.trim()+"<=32767,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="uint16_t"){
				String s="0<="+key.trim()+"<=65535,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="int32_t"){
				String s="-2147483648<="+key.trim()+"<=2147483647,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="uint32_t"){
				String s="0<="+key.trim()+"<=4294967295,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="int64_t"){
				String s="-9223372036854775808<="+key.trim()+"<=9223372036854775807,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="uint64_t"){
				String s="0<="+key.trim()+"<=1844674407370955161,"+key.trim()+"��integers";
				list.add(s);
			}
			if(getmap.get(key)=="float"){
				String s="<="+key.trim()+"<=";
				list1.add(s);
			}
			if(getmap.get(key)=="double"){
				String s="<="+key.trim()+"<=";
				list1.add(s);
			}
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
	 * ��ӷ���ֵ�͵Ĳ���ʽ
	 * @param getmap
	 * @return
	 */
	public static String add_doublebds(Map<String,String> getmap){
		List<String> list=new ArrayList<String>(); //�����ֵ����ʽ
		List<String> list1=new ArrayList<String>(); //��Ų�������ʽ
		String s1=new String();
		String ss=new String();
		
		Set<String> keySet = getmap.keySet();
		System.out.println("keySet���ϣ�"+keySet);
		for (String key : keySet) {
			System.out.println("key���������ͣ�"+getmap.get(key));
			System.out.println("key.trim()���������ƣ�"+key.trim());
			if(getmap.get(key)=="int8_t"){
				String s="-128<="+key.trim()+"<=127";
				list.add(s);
			}
			if(getmap.get(key)=="uint8_t"){
				String s="0<="+key.trim()+"<=255";
				list.add(s);	
			}
			if(getmap.get(key)=="int16_t"){
				String s="-32768<="+key.trim()+"<=32767";
				list.add(s);
			}
			if(getmap.get(key)=="uint16_t"){
				String s="0<="+key.trim()+"<=65535";
				list.add(s);
			}
			if(getmap.get(key)=="int32_t"){
				String s="-2147483648<="+key.trim()+"<=2147483647";
				list.add(s);
			}
			if(getmap.get(key)=="uint32_t"){
				String s="0<="+key.trim()+"<=4294967295";
				list.add(s);
			}
			if(getmap.get(key)=="int64_t"){
				String s="-9223372036854775808<="+key.trim()+"<=9223372036854775807";
				list.add(s);
			}
			if(getmap.get(key)=="uint64_t"){
				String s="0<="+key.trim()+"<=1844674407370955161";
				list.add(s);
			}
			if(getmap.get(key)=="float"){
				String s="<="+key.trim()+"<=";
				list1.add(s);
			}
			if(getmap.get(key)=="double"){
				String s="<="+key.trim()+"<=";
				list1.add(s);
			}
		}
		if(list1.size()>1){
			ss=list.get(0);
			for(int j=1;j<list.size();j++){
				s1=list.get(j);
				ss=ss+","+s1;
			}
		}
		if(list1.size()==1){
			ss=list.get(0);
		}	
		if(list1.size()<=0){
			return null;
		}
		return ss;
		
	}


}
