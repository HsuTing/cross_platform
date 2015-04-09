import java.util.Scanner;


public class HW3_F74011140_V01 {
	public void ChoosePK(hero main, Scanner keyboard){
		System.out.println();
		System.out.println("----------------------------");
		main.showNameList();
		System.out.println("----------------------------");
		System.out.println("��ܤ@�ӭ^��:");
		String name = keyboard.nextLine();
		if(main.checkNameList(name) == false){
			System.out.println("���^�����b�W���");
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

					System.out.println("��ܧޯ�:");
					System.out.println("1." + a.getSkillName_one());
					System.out.println("2." + a.getSkillName_two());
					System.out.println("3." + a.getSkillName_three());
					System.out.println("4." + a.getNormalName());
					int temp = keyboard.nextInt();
					keyboard.nextLine();
					a.chooseSkill(temp, b);
					System.out.println("���� " + b.getName());
					temp = (int)(Math.random() * 10);
					System.out.println(b.getName() + "���" + b.getSkillName(temp));
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
					System.out.println(b.getName() + "���" + b.getSkillName(temp));
					System.out.println();
					System.out.println("����A�F");
					System.out.println("��ܧޯ�");
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
			System.out.println("���ߧA��Ĺ�F!!!!");
			main.addExperience(b);
			System.out.println("----------------------------");
		}
		else{
			System.out.println("----------------------------");
			System.out.println("�A��FQQ");
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
		System.out.println("��J'1'�ϨϥΪ̥i�H�ۦ�гy�@�Ө���");
		System.out.println("��J'2'��ܧA�{�b�ұ���^������T");
		System.out.println("��J'3'�P�{�����^�����");
		System.out.println("��J'4'�P�H��������");
		System.out.println("��J'5'Ū��");
		System.out.println("��J'6'���J�ҫ��w���^��");
		System.out.println("��J'7'�N���^������T�x�s�_��");
		System.out.println("��J'8'���}���{��");
		
		System.out.println("�C�����ⳣ�|���T�اޯ�A�᭱����һݪ��]�k�ȡA���]�O�����ɡA�u�|�ϥδ��q����");
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name = "";
		hero main = new hero_A();
		HW3_F74011140_V01 control = new HW3_F74011140_V01();
		
		System.out.println("1. ���ͷs�^��");
		System.out.println("2. Ū��");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		
		switch(choice){
			case 1:
				System.out.println("��J�^���W�r:");
				name = keyboard.next();
				System.out.println("���¾�~:");
				System.out.println("1.�Ԥh 2.�Z�J 3.���v");
				choice = keyboard.nextInt();
				main = control.creatHero(choice);
				main.produce(name, choice);
				break;
			case 2:
				System.out.println("��J�^���W�r:");
				name = keyboard.next();
				main.load(name);
				main = control.creatHero(main.getjob());
				main.load(name);
				break;
			default:
				System.out.println("�п�J1�Ϊ�2");
				break;
		}
		
		if(main.getName() != null){
			do{
				choice = 0;
				System.out.println("----------------------------");
				System.out.println("1. ���ͷs�^��");
				System.out.println("2. �^����T");
				System.out.println("3. �P�{���^�����");
				System.out.println("4. �H�����");
				System.out.println("5. �x�s");
				System.out.println("6. ���J");
				System.out.println("7. ���}");
				System.out.println("8. ���U");
				System.out.println("----------------------------");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				
				switch(choice){
					case 1:
						System.out.println("----------------------------");
						System.out.println("��J�^���W�r:");
						name = keyboard.next();
						System.out.println("���¾�~:");
						System.out.println("1.�Ԥh 2.�Z�J 3.���v");
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
						System.out.println("��J�^���W�r:");
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
