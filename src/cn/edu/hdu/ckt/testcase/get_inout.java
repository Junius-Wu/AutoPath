package cn.edu.hdu.ckt.testcase;
//�������Ӧmap�Ƿ���ȷ
import java.util.ArrayList;
import java.util.Set;

import cn.edu.hdu.ckt.handle.*;


public class get_inout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String xml="read_radio2ForXStream.xml";
		String xml="loop6ForXStream.xml";
		Automatic automatic=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		//Automatic auto = AddType.addType(automatic);

		ArrayList<Automatic> testCase=StateCoverage__1.testCase(automatic);//�������״̬���ǵĳ����������

		//int i=1;	
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){

			System.out.println("������������:"+a.getName());
			for(Transition tran:a.getTransitionSet()){
				//System.out.println(/*tran.getSource()+"---->"+tran.getTarget()+*/"Լ���� "+tran.getEventSet());

				//////////////////////////in����ʼ///////////////////////////////////////
				//����in����Ĳ���ʽ�Ͳ�����ʹ�������������һһ��Ӧ
				//				System.out.println("--------------------------in------------------------");	
				//				System.out.println("in---->"+tran.getIn());					
				//				if(GetMap.get_inMap(tran.getIn())==null){
				//					//System.out.println("keySet���ϣ�null����û�в���ʽ�Ͳ���");
				//					System.out.println("keySet���ϣ�"+tran.getIn());
				//				}
				//				else{
				//					Set<String> keySet = GetMap.get_inMap(tran.getIn()).keySet();
				//					System.out.println("keySet���ϣ�"+keySet);
				//					for (String key : keySet) {
				//						//System.out.println("key���������ͣ�"+GetMap.get_inMap(tran.getIn()).get(key));
				//						//System.out.println("key.trim()���������ƣ�"+key.trim());
				//						System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_inMap(tran.getIn()).get(key));
				//					}
				//				}
				//				

				/*System.out.println("in_mapΪ��"+get_bdscs.get_inbds(tran.getIn()).keySet());*/
				///////////////////////////in�������//////////////////////////////////////
				//////////////////////////out����ʼ///////////////////////////////////////

				//				System.out.println("out---->"+tran.getOut());

				//////////////////////////out�������///////////////////////////////////////
				//////////////////////////condition����ʼ///////////////////////////////////////
				/*if(tran.getCondition().contains("--")){
					String[] condition = tran.getCondition().split("--");
					for(int j=0;i<condition.length;i++){
						System.out.println("condition---->"+condition[j]);
					}
				}
				else{
					System.out.println("condition---->"+tran.getCondition());
				}*/
				//System.out.println(tran.getEventSet());
				System.out.println("--------------------------condition------------------------");	
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replace("false", "False").replace("true", "True");
					if(tran.getCondition().contains("/")){
						String conditonValue = tran.getCondition().split("/")[1];
						System.out.println("//condition//---->"+conditonValue);
						///////////////////////////////////
						int m = 1;
						if(conditonValue.contains("--")){
							String[] tt = conditonValue.split("--");
							for(String t:tt){
								System.out.println(m+"�� "+t);
							}
						}

						/////////////////////////////////

						//System.out.println("==================================");
						/*if(GetMap.get_condMap(conditonValue)==null){
							System.out.println("keySet���ϣ�"+GetMap.get_condMap(conditonValue));
						}
						else{
							if(!(GetMap.get_condMap(conditonValue)==null)){
								Set<String> set = GetMap.get_condMap(conditonValue).keySet();
								//System.out.println("=================================="+set.toString());
								System.out.println("keyset���ϣ�"+set);
								for (String key : set) {
									//System.out.println("key���������ͣ�"+get_bdscs.get_condMap(conditonValue).get(key));
									System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(conditonValue).get(key));
								}
							}
						}*/

					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("condition---->"+tran.getCondition());

							///////////////////////////////////
							int m = 1;
							if(tran.getCondition().contains("--")){
								String[] tt = tran.getCondition().split("--");
								for(String t:tt){
									System.out.println(m+"�� "+t);
									m++;
								}
							}

							/////////////////////////////////


							/*	if(GetMap.get_condMap(tran.getCondition())==null){
								System.out.println("keySet���ϣ�"+GetMap.get_condMap(tran.getCondition()));
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									//System.out.println("==================================");
									Set<String> set = GetMap.get_condMap(tran.getCondition()).keySet();
									//System.out.println("==================================");
									System.out.println("keyset���ϣ�"+set);
									for (String key : set) {
										//System.out.println("key���������ͣ�"+get_bdscs.get_condMap(tran.getCondition()).get(key));
										//System.out.println("key.trim()���������ƣ�"+key.trim());
										System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(tran.getCondition()).get(key));
									}
								}
							}*/

						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						System.out.println("condition--null-->"+tran.getCondition());
						/*						Set<String> keySet = get_bdscs.get_condMap(tran.getIn()).keySet();
						System.out.println("keySet���ϣ�"+keySet);
						for (String key : keySet) {
							System.out.println("key���������ͣ�"+get_bdscs.get_condMap(tran.getIn()).get(key));
							System.out.println("key.trim()���������ƣ�"+key.trim());
						 */		}	
				}

			}



			//////////////////////////condition�������///////////////////////////////////////
			/*if(tran.getCondition().contains("/")){
				String[] t=tran.getCondition().split("/");
				System.out.println("condition---->"+t[1]);
			}
			else{
				System.out.println("condition---->"+tran.getCondition());
			}*/



			/*	for(Transition tran:a.getTransitionSet()){
				System.out.println(tran.getName()+"----********----Ǩ�Ʊ�����");
				System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());

				//System.out.println("�ڶ��������i����"+i+"----"+Get_yueshu.get_yueshu(tran.getEventSet().toString()));
				//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				//i++;
			}*/
			/*for(Transition tran:a.getTransitionSet()){
				System.out.println(tran.getSource()+"---->"+tran.getTarget()+"��һ�������Լ���� "+tran.getEventSet());
				System.out.println(tran.getName()+"----********----Ǩ�Ʊ�����");
				System.out.println("�ڶ��������i����"+i+"----"+Get_yueshu.get_yueshu(tran.getEventSet().toString()));
				//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				//i++;
			}*/
			System.out.println("*********************************");
		}
	}
}



