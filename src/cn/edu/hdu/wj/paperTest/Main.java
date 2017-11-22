package cn.edu.hdu.wj.paperTest;


public class Main {
	public static void main(String args[]) {

		do {
			GP.dfsPath();
		} while (!Datas.allCovered());
	}

}
