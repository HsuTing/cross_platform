import java.util.Scanner;


public class HW3_F74011140_V01 {
	public void ChoosePK(hero main, Scanner keyboard){
		System.out.println();
		System.out.println("----------------------------");
		main.showNameList();
		System.out.println("----------------------------");
		System.out.println("選擇一個英雄:");
		String name = keyboard.nextLine();
		if(main.checkNameList(name) == false){
			System.out.println("此英雄不在名單當中");
		}
		else{
			hero b = new hero_A();
			b.load(name);
			b = creatHero(b.getjob());
			b.load(name);
			this.PK(main, b, keyboard);
		}
	}
	
	public void PK(hero main, hero b, Scanner keyboard){
		int choose = (int)(Math.random() * 10);
		hero a = null;
		System.out.println("----------------------------");
		
		if(main.getClass() == hero_A.class){
			a = new hero_A(main);
		}
		else if(main.getClass() == hero_B.class){
			a = new hero_B(main);
		}
		else if(main.getClass() == hero_C.class){
			a = new hero_C(main);
		}
		
		switch(choose){
			case 0:
				while((a.getHP() > 0) && (b.getHP() > 0)){
					System.out.printf("%s HP:%.2f MP:%.2f\n", a.getName(), a.getHP(), a.getMP());
					System.out.printf("%s HP:%.2f MP:%.2f\n", b.getName(), b.getHP(), b.getMP());

					System.out.println("選擇技能:");
					System.out.println("1." + a.getSkillName_one());
					System.out.println("2." + a.getSkillName_two());
					System.out.println("3." + a.getSkillName_three());
					System.out.println("4." + a.getNormalName());
					int temp = keyboard.nextInt();
					keyboard.nextLine();
					a.chooseSkill(temp, b);
					System.out.println("輪到 " + b.getName());
					temp = (int)(Math.random() * 10);
					System.out.println(b.getName() + "選擇" + b.getSkillName(temp));
					b.chooseSkill(temp, a);
					System.out.println();
				}
				break;
			default:
				while((a.getHP() > 0) && (b.getHP() > 0)){
					System.out.printf("%s HP:%.2f MP:%.2f\n", a.getName(), a.getHP(), a.getMP());
					System.out.printf("%s HP:%.2f MP:%.2f\n", b.getName(), b.getHP(), b.getMP());
					int temp = (int)(Math.random() * 10);
					b.chooseSkill(temp, a);
					System.out.println(b.getName() + "選擇" + b.getSkillName(temp));
					System.out.println();
					System.out.println("輪到你了");
					System.out.println("選擇技能");
					System.out.println("1." + a.getSkillName_one());
					System.out.println("2." + a.getSkillName_two());
					System.out.println("3." + a.getSkillName_three());
					System.out.println("4." + a.getNormalName());
					temp = keyboard.nextInt();
					keyboard.nextLine();
					a.chooseSkill(temp, b);
					System.out.println();
				}
				break;
		}
		
		if(a.HP > b.HP){
			System.out.println("----------------------------");
			System.out.println("恭喜你打贏了!!!!");
			main.addExperience(b);
			System.out.println("----------------------------");
		}
		else{
			System.out.println("----------------------------");
			System.out.println("你輸了QQ");
			System.out.println("----------------------------");
		}
	}
	
	public hero creatHero(int choice){
		hero temp = new hero_A();
		switch(choice){
			case 1:
				temp = new hero_A();
				break;
			case 2:
				temp = new hero_B();
				break;
			default:
				temp = new hero_C();
				break;
		}
		return temp;
	}
	
	public void help(){
		System.out.println("輸入'1'使使用者可以自行創造一個角色");
		System.out.println("輸入'2'顯示你現在所控制英雄的資訊");
		System.out.println("輸入'3'與現有的英雄對戰");
		System.out.println("輸入'4'與隨機角色對戰");
		System.out.println("輸入'5'讀取");
		System.out.println("輸入'6'載入所指定的英雄");
		System.out.println("輸入'7'將此英雄的資訊儲存起來");
		System.out.println("輸入'8'離開此程式");
		
		System.out.println("每隻角色都會有三種技能，後面有其所需的魔法值，當魔力不足時，只會使用普通攻擊");
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name = "";
		hero main = new hero_A();
		HW3_F74011140_V01 control = new HW3_F74011140_V01();
		
		System.out.println("1. 產生新英雄");
		System.out.println("2. 讀取");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		
		switch(choice){
			case 1:
				System.out.println("輸入英雄名字:");
				name = keyboard.next();
				System.out.println("選擇職業:");
				System.out.println("1.戰士 2.坦克 3.牧師");
				choice = keyboard.nextInt();
				main = control.creatHero(choice);
				main.produce(name, choice);
				break;
			case 2:
				System.out.println("輸入英雄名字:");
				name = keyboard.next();
				main.load(name);
				main = control.creatHero(main.getjob());
				main.load(name);
				break;
			default:
				System.out.println("請輸入1或者2");
				break;
		}
		
		if(main.getName() != null){
			do{
				choice = 0;
				System.out.println("----------------------------");
				System.out.println("1. 產生新英雄");
				System.out.println("2. 英雄資訊");
				System.out.println("3. 與現有英雄對戰");
				System.out.println("4. 隨機對戰");
				System.out.println("5. 儲存");
				System.out.println("6. 載入");
				System.out.println("7. 離開");
				System.out.println("8. 幫助");
				System.out.println("----------------------------");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				
				switch(choice){
					case 1:
						System.out.println("----------------------------");
						System.out.println("輸入英雄名字:");
						name = keyboard.next();
						System.out.println("選擇職業:");
						System.out.println("1.戰士 2.坦克 3.牧師");
						choice = keyboard.nextInt();
						hero b = control.creatHero(choice);
						b.produce(name, choice);
						if(b.getName() != null){
							System.out.println("----------------------------");
							b.getInformation();
							System.out.println("----------------------------");
						}
						break;
					case 2:
						System.out.println("----------------------------");
						main.getInformation();
						System.out.println("----------------------------");
						break;
					case 3:
						control.ChoosePK(main, keyboard);
						break;
					case 4:
						int temp = (int)(Math.random() * 3 + 1);
						b = control.creatHero(temp);
						b.rand("monster", main.getLevel());
						control.PK(main, b, keyboard);
						break;
					case 5:
						main.save();
						break;
					case 6:
						System.out.println("----------------------------");
						main.showNameList();
						System.out.println("----------------------------");
						System.out.println("輸入英雄名字:");
						name = keyboard.next();
						main.load(name);
						main = control.creatHero(main.getjob());
						main.load(name);
						break;
					case 7:
						main.save();
						break;
					case 8:
						System.out.println("----------------------------");
						control.help();
						System.out.println("----------------------------");
						break;
					default:
						choice = 0;
						break;
				}
			}while(choice != 7);
		}
		
		keyboard.close();
	}

}
