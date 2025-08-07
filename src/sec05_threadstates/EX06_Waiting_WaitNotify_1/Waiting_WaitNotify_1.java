package sec05_threadstates.EX06_Waiting_WaitNotify_1;

/*동기화만을 사용했을 때 임의적인 두 쓰레드의 실행 순서*/

class DataBox {
	int data;
	synchronized void inputData(int data) {
		this.data = data;
		//for(long i=0, sum=0; i<1_000_000_000L ; i++) {sum+=i;} //시간지연
		System.out.println("입력데이터 : "+this.data);		
	}
	synchronized void outputData() {
		//for(long i=0, sum=0; i<1_000_000_000L ; i++) {sum+=i;} //시간지연
		System.out.println("출력데이터 : "+this.data);
	}
}

public class Waiting_WaitNotify_1 {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		Thread t1 = new Thread() {
			public void run() {
				for(int i=1; i<9; i++) {
					dataBox.inputData(i);
					for(long ii=0, sum=0; ii<1_000_000_000L ; ii++) {sum+=ii;} //시간지연
				}
			};
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for(int i=1; i<9; i++) {
					dataBox.outputData();
					for(long ii=0, sum=0; ii<1_000_000_000L ; ii++) {sum+=ii;} //시간지연
				}
			};
		};
				
		t1.start();
		t2.start();
	}

}


