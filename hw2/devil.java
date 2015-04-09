package hw2_F74011140_V01;
import java.lang.Math;

public class devil extends hero{
	private double OriginalHP;
	private double OriginalMP;
	
	public void resetDevil(){
		this.HP = OriginalHP;
		this.MP = OriginalMP;
	}
	
	public void setDevil(){
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
		System.out.println("魔王");
		System.out.printf("體力值 %.2f\n", this.HP);
		System.out.printf("魔力值 %.2f\n", this.MP);
		System.out.printf("物理攻擊 %.2f\n", this.Physical_ATK);
		System.out.printf("魔法攻擊 %.2f\n", this.Magic_ATK);
		System.out.printf("物理防禦 %.2f\n", this.Physical_DEF);
		System.out.printf("魔法防禦 %.2f\n", this.Magic_DEF);
		System.out.printf("物理吸血 %.2f\n", this.Physical_Vampire);
		System.out.printf("魔法吸血 %.2f\n", this.Magic_Vampire);
		System.out.println("技能：");
		System.out.println("毀滅一擊 無視防禦 50%物理攻擊 50%魔法攻擊 / 消耗魔力 80");
		System.out.println("自我修復 回復  10%體力 10%魔力 / 消耗魔力 0");
	}
	
	public void getInformation(){
		System.out.printf("魔王 體力 %.2f 魔力%.2f\n", this.HP, this.MP);
	}
	
	public double getHP(){
		return this.HP;
	}
	
	public double getMP(){
		return this.MP;
	}

	public void setHP(){
		HP = (Math.random() * 100 + 1000);
		OriginalHP = HP;
	};
	
	public void setMP(){
		MP = (Math.random() * 100 + 200);
		OriginalMP = MP;
	};
	
	public void setPhysical_ATK(){
		Physical_ATK = (Math.random() * 10 + 40);
	};
	
	public void setPhysical_DEF(){
		Physical_DEF = (Math.random() * 15 + 30);
	};
	
	public void setMagic_ATK(){
		Magic_ATK = (Math.random() * 20 + 90);
	};
	
	public void setMagic_DEF(){
		Magic_DEF = (Math.random() * 15 + 30);
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
			case 3:
				if(this.MP - 80 > 0){
					System.out.printf("魔王 毀滅一擊 %.2f;", this.Physical_ATK * 0.5 + this.Magic_ATK * 0.5);
					for(int i = 0; i < 3; i++){
						a.HP = a.HP - this.Physical_ATK * 0.5 - this.Magic_ATK * 0.5;
					}
					this.MP = this.MP - 80;
				}
				else{
					System.out.printf("魔王 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				}
				break;
			case 5:
			case 7:
				if(this.MP > 0){
					System.out.printf("魔王 自我修復 %.2f體力 %.2f魔力;", this.HP * 0.1, this.MP * 0.1);
					this.HP = this.HP * (1 + 0.1);
					this.MP = this.MP * (1 + 0.1);
				}
				else{
					System.out.printf("魔王 物理攻擊 %.2f;", this.Physical_ATK);
					a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				}
				break;
			default:
				System.out.printf("魔王 物理攻擊 %.2f;", this.Physical_ATK);
				a.HP = a.HP - this.Physical_ATK * ( 1 - a.Physical_DEF / 100 );
				break;
		}
		
		return a;
	};
}