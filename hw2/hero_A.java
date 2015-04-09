package hw2_F74011140_V01;
import java.lang.Math;

public class hero_A extends hero{
	public void sethero_A(){
		setHP();
		setMP();
		setPhysical_ATK();
		setPhysical_DEF();
		setMagic_ATK();
		setMagic_DEF();
		setPhysical_Vampire();
		setMagic_Vampire();
		getOriginal();
	}
	
	public void getOriginal(){
		System.out.println("英雄 A");
		System.out.printf("體力值 %.2f\n", this.HP);
		System.out.printf("魔力值 %.2f\n", this.MP);
		System.out.printf("物理攻擊 %.2f\n", this.Physical_ATK);
		System.out.printf("魔法攻擊 %.2f\n", this.Magic_ATK);
		System.out.printf("物理防禦 %.2f\n", this.Physical_DEF);
		System.out.printf("魔法防禦 %.2f\n", this.Magic_DEF);
		System.out.printf("物理吸血 %.2f\n", this.Physical_Vampire);
		System.out.printf("魔法吸血 %.2f\n", this.Magic_Vampire);
		System.out.println("技能：");
		System.out.println("三重爪擊 連續攻擊三次 / 消耗魔力 30");
		System.out.println("橫掃千軍 攻擊對方生命15%血量 / 消耗魔力 100");
		System.out.println("兇殘打擊 物理攻擊對方並附加50無視防禦傷害 / 消耗魔力 50");
	}
	
	public void getInformation(){
		System.out.printf("英雄 A 體力 %.2f 魔力%.2f\n", this.HP, this.MP);
	}
	
	public double getHP(){
		return this.HP;
	}
	
	public double getMP(){
		return this.MP;
	}

	public void setHP(){
		HP = (Math.random() * 100 + 400);
	};
	
	public void setMP(){
		MP = (Math.random() * 50 + 100);
	};
	
	public void setPhysical_ATK(){
		Physical_ATK = (Math.random() * 20 + 40);
	};
	
	public void setPhysical_DEF(){
		Physical_DEF = (Math.random() * 10 + 10);
	};
	
	public void setMagic_ATK(){
		Magic_ATK = 0;
	};
	
	public void setMagic_DEF(){
		Magic_DEF = (Math.random() * 10 + 0);
	};
	
	public void setPhysical_Vampire(){
		Physical_Vampire = (Math.random() * 10 + 15);
	};
	
	public void setMagic_Vampire(){
		Magic_Vampire = 0;
	};
	
	public hero skill(hero a){
		int choose = (int)(Math.random() * 10 + 0);
		
		switch(choose){
			case 1:
			case 2:
			case 3:
				if(this.MP - 30 > 0){
					System.out.printf("英雄A 三重爪擊 %.2f;", 3 * this.Physical_ATK * ( 1 - a.Physical_DEF / 100 ));
					a.HP = a.HP - 3 * this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
					this.MP = this.MP - 30;
				}
				else{
					System.out.printf("英雄A 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
					this.HP = this.HP + this.Physical_Vampire;
				}
				break;
			case 4:
				if(this.MP - 100 > 0){
					System.out.printf("英雄A 橫掃千軍 %.2f;", a.HP * 0.15);
					a.HP = a.HP * (1 - 0.15);
					this.MP = this.MP - 100;
				}
				else{
					System.out.printf("英雄A 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
					this.HP = this.HP + this.Physical_Vampire;
				}
				break;
			case 5:
			case 6:
				if(this.MP - 50 > 0){
					System.out.printf("英雄A 兇殘打擊 %.2f;", this.Physical_ATK * ( 1 - a.Physical_DEF / 100 ) + 50);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 ) - 50;
					this.MP = this.MP - 50;
				}
				else{
					System.out.printf("英雄A 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
					this.HP = this.HP + Physical_Vampire;
				}
				break;
			default:
				System.out.printf("英雄A 物理攻擊 %.2f;", this.Physical_ATK);
				a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				this.HP = this.HP + this.Physical_Vampire;
				break;
		}
		
		return a;
	};
}