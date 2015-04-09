package hw2_F74011140_V01;
import java.lang.Math;

public class hero_B extends hero{
	public void sethero_B(){
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
		System.out.println("英雄 B");
		System.out.printf("體力值 %.2f\n", this.HP);
		System.out.printf("魔力值 %.2f\n", this.MP);
		System.out.printf("物理攻擊 %.2f\n", this.Physical_ATK);
		System.out.printf("魔法攻擊 %.2f\n", this.Magic_ATK);
		System.out.printf("物理防禦 %.2f\n", this.Physical_DEF);
		System.out.printf("魔法防禦 %.2f\n", this.Magic_DEF);
		System.out.printf("物理吸血 %.2f\n", this.Physical_Vampire);
		System.out.printf("魔法吸血 %.2f\n", this.Magic_Vampire);
		System.out.println("技能：");
		System.out.println("疾若奔雷 物理攻擊提高50傷害 / 消耗魔力 40");
		System.out.println("熊性大發 造成對方自身血量15%的物理傷害(無視防禦) / 消耗魔力 35");
		System.out.println("轟雷電爪 物理攻擊附加100魔法攻擊 / 消耗魔力 100");
	}
	
	public void getInformation(){
		System.out.printf("英雄 B 體力 %.2f 魔力%.2f\n", this.HP, this.MP);
	}
	
	public double getHP(){
		return this.HP;
	}
	
	public double getMP(){
		return this.MP;
	}

	public void setHP(){
		HP = (Math.random() * 200 + 800);
	};
	
	public void setMP(){
		MP = (Math.random() * 100 + 200);
	};
	
	public void setPhysical_ATK(){
		Physical_ATK = (Math.random() * 10 + 20);
	};
	
	public void setPhysical_DEF(){
		Physical_DEF = (Math.random() * 10 + 20);
	};
	
	public void setMagic_ATK(){
		Magic_ATK = 0;
	};
	
	public void setMagic_DEF(){
		Magic_DEF = (Math.random() * 10 + 20);
	};
	
	public void setPhysical_Vampire(){
		Physical_Vampire = 0;
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
				if(this.MP - 40 > 0){
					System.out.printf("英雄B 疾若奔雷 %.2f;", ( this.Physical_ATK + 50 ) / ( 1 - a.Physical_DEF / 100 ));
					a.HP = a.HP - ( this.Physical_ATK + 50 ) / ( 1 - a.Physical_DEF / 100 );
					this.MP = this.MP - 40;
				}
				else{
					System.out.printf("英雄B 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				}
				break;
			case 4:
			case 5:
			case 6:
				if(this.MP - 35 > 0){
					System.out.printf("英雄B 熊性大發 %.2f;", this.HP * 0.15);
					a.HP = a.HP - this.HP * 0.15;
					this.MP = this.MP - 35;
				}
				else{
					System.out.printf("英雄B 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				}
				break;
			case 7:
				if(this.MP - 100 > 0){
					System.out.printf("英雄B 轟雷電爪 %.2f;", this.Physical_ATK * ( 1 - a.Physical_DEF / 100 ) + 100 * ( 1 - a.Magic_DEF / 100 ));
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 ) - 100 * ( 1 - a.Magic_DEF / 100 );
					this.MP = this.MP - 100;
				}
				else{
					System.out.printf("英雄B 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				}
				break;
			default:
				System.out.printf("英雄B 物理攻擊 %.2f;", this.Physical_ATK);
				a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				break;
		}
		
		return a;
	};
}