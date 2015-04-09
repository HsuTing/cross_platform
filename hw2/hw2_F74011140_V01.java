package hw2_F74011140_V01;
import java.lang.Math;

public class hw2_F74011140_V01 {
	public void PK(hero a, hero b, String temp){
		int choose = (int)(Math.random());
		int count = 1;
		
		switch(choose){
			case 0:
				while(a.getHP() > 0 || b.getHP() >0){
					System.out.println("第" + count + "回合：");
					a.skill(b);
					if(b.getHP() <= 0){
						System.out.printf("%s 體力0  魔力%.2f\n", temp, b.getMP());
						System.out.printf("%s失敗，魔王獲勝\n", temp);
						return;
					}
					b.getInformation();
					b.skill(a);
					if(a.getHP() <= 0){
						System.out.printf("魔王 體力0  魔力%.2f\n", a.getMP());
						System.out.printf("%s獲勝 共花%d回\n", temp, count);
						return;
					}
					a.getInformation();
					count = count + 1;
					System.out.println();
				}
				break;
			case 1:
				while(a.getHP() > 0 || b.getHP() >0){
					System.out.println("第" + count + "回合：");
					b.skill(a);
					if(a.getHP() <= 0){
						System.out.printf("魔王 體力0  魔力%.2f\n", a.getMP());
						System.out.printf("%s獲勝 共花%d回\n", temp, count);
						return;
					}
					a.getInformation();
					a.skill(b);
					if(b.getHP() <= 0){
						System.out.printf("%s 體力0  魔力%.2f\n", temp, b.getMP());
						System.out.printf("%s失敗，魔王獲勝\n", temp);
						return;
					}
					b.getInformation();
					count = count + 1;
					System.out.println();
				}
				break;
		}
	}

	public static void main(String[] args) {
		hw2_F74011140_V01 round = new hw2_F74011140_V01();
		hero_A A = new hero_A();
		hero_B B = new hero_B();
		hero_C C = new hero_C();
		devil Devil = new devil();
		
		System.out.println("產生的英雄數 :3");
		System.out.println("英雄素質如下");
		
		A.sethero_A();
		System.out.println();
		B.sethero_B();
		System.out.println();
		C.sethero_C();
		System.out.println();
		Devil.setDevil();
		System.out.println();
		
		System.out.println("---------------------------------------------------------");
		System.out.println("(魔王 PK 英雄A)");
		Devil.getInformation();
		A.getInformation();
		System.out.println();
		round.PK(Devil, A, "英雄A");
		Devil.resetDevil();
		
		System.out.println("---------------------------------------------------------");
		System.out.println("(魔王 PK 英雄B)");
		Devil.getInformation();
		B.getInformation();
		System.out.println();
		round.PK(Devil, B, "英雄B");
		Devil.resetDevil();
		
		System.out.println("---------------------------------------------------------");
		System.out.println("(魔王 PK 英雄C)");
		Devil.getInformation();
		C.getInformation();
		System.out.println();
		round.PK(Devil, C, "英雄C");
	}

}