package cn.edu.hdu.ckt.testcase;
//Ϊ��ͬ�������͵Ĳ�������Լ������ʽ���Լ����ÿ��Ǩ���еĲ���
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.edu.hdu.ckt.handle.*;


public class BdsCs {

	public static void main(String[] args) {

		String xml="loop6ForXStream.xml";
		Automatic automatic=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		//Automatic auto = AddType.addType(automatic);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(automatic);//�������״̬���ǵĳ����������
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){
			System.out.println("������������:"+a.getName());
			for(Transition tran:a.getTransitionSet()){
				System.out.println("�������ƣ�"+tran.getName());
				System.out.println("�����¼�����Լ����"+tran.getEventSet());
				Map<String,String> map = new HashMap<String,String>();
				Map<String,String> map1 = new HashMap<String,String>();
				Map<String,String> map3 = new HashMap<String,String>();
//////////////////////////in����ʼ///////////////////////////////////////
				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
//				System.out.println("--------------------------in------------------------");	
//				System.out.println("in---->"+tran.getIn());	//in���������
				
				
				if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
//					System.out.println("keySet���ϣ�"+tran.getIn());
				}
				else{//map����ֵ�����в����Ͳ�����Ӧ����
					map3 = GetMap.get_inMap(tran.getIn());
//					Set<String> keySet = map3.keySet();
//					System.out.println("keySet���ϣ�"+keySet);
					String cs1 = AddBdsType.getcs(map3);
					String cs2 = AddBdsType.getDoubleCs(map3);
					String cs3 = AddBdsType.getBoolCs(map3);
//					System.out.println("����in���͵õ�����������ʽ�еĲ���������"+cs1);
//					System.out.println("����in���͵õ���С������ʽ�еĲ���������"+cs2);
//					System.out.println("����in���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);
//					
//					System.out.println("-----------");
					
					String s1 = AddBdsType.add_bds(map3);			
					String s2 = AddBdsType.add_doublebds(map3);
//					System.out.println("����in���������������ʽΪ��"+s1);
//					System.out.println("����in�������С������ʽΪ��"+s2);
					
					/*for (String key : keySet) {
						//System.out.println("key���������ͣ�"+map.get(key));
						System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_inMap(tran.getIn()).get(key));
						
					}*/

				}
				

///////////////////////////in�������//////////////////////////////////////
//////////////////////////out����ʼ///////////////////////////////////////
				
//				System.out.println("out---->"+tran.getOut());
				
				
				
//////////////////////////out�������///////////////////////////////////////
//////////////////////////condition����ʼ///////////////////////////////////////
				System.out.println("--------------------------condition------------------------");
				//Map<String,String> map = new HashMap<String,String>();
				//Map<String,String> map1 = new HashMap<String,String>();
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replace("false", "False").replace("true", "True");
					//System.out.println("tran.getCondition():::"+tran.getCondition());
					if(tran.getCondition().contains("/")){
						
						String conditonValue = tran.getCondition().split("/")[1];
						System.out.println("//condition//---->"+conditonValue);
						//System.out.println("==================================");
						if(GetMap.get_condMap(conditonValue)==null){
							System.out.println("keySet����1��"+GetMap.get_condMap(conditonValue));
						}
						else{
							if(!(GetMap.get_condMap(conditonValue)==null)){
								map = GetMap.get_condMap(conditonValue);//�����У�Ҫ���������
//								Set<String> set = map.keySet();
//								Collection<String> coll = map.values();
								//System.out.println("==================================");
//								System.out.println("keyset����2��"+set);
//								System.out.println("------------------values����4��"+coll);
								
								String cs1 = AddBdsType.getcs(map);
								String cs2 = AddBdsType.getDoubleCs(map);
								String cs3 = AddBdsType.getBoolCs(map);
//								System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
//								System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
//								System.out.println("����condition���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);								
								System.out.println("-----------");								
								String s1 = AddBdsType.add_bds(map);
//								String s2 = AddBdsType.add_doublebds(map);
//								System.out.println("����condition���������������ʽΪ��"+s1);
//								System.out.println("����condition�������С������ʽΪ��"+s2);
								
								/*for (String key : set) {
									//System.out.println("key���������ͣ�"+map.get(key));
									System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(conditonValue).get(key));
									
								}*/

							}
						}
						
					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("condition---->"+tran.getCondition());
							if(GetMap.get_condMap(tran.getCondition())==null){
								System.out.println("keySet����3��"+GetMap.get_condMap(tran.getCondition()));
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									map1 = GetMap.get_condMap(tran.getCondition());//�����У�Ҫ���������
									//System.out.println("==================================");
//									Set<String> set =map1.keySet();
//									Collection<String> coll = map1.values();
									//System.out.println("==================================");
//									System.out.println("keyset����4��"+set);
//									System.out.println("------------------values���ϣ�"+coll);
									
									String cs1 = AddBdsType.getcs(map1);
									String cs2 = AddBdsType.getDoubleCs(map1);
									String cs3 = AddBdsType.getBoolCs(map1);
//									System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
//									System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
//									System.out.println("����condition���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);									
//									System.out.println("-----------");									
									String s1 = AddBdsType.add_bds(map1);
//									String s2 = AddBdsType.add_doublebds(map1);
//									System.out.println("����condition���������������ʽΪ��"+s1);
//									System.out.println("����condition�������С������ʽΪ��"+s2);
									
								/*	for (String key : set) {
										//System.out.println("key���������ͣ�"+map.get(key));
										System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(tran.getCondition()).get(key));
										
									}*/

								}
							}
							
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
//						System.out.println("condition--null-->"+tran.getCondition());	
					}
					
				}
				
				
				
//////////////////////////condition�������///////////////////////////////////////
				
				System.out.println("*************************Ǩ�Ʒָ��**************************");
			}
			System.out.println("-------------------------------���������ָ��----------------------------------");
		}
	}
}




