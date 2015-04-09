
public class hero_A extends hero {
	public hero_A(){
		super();
	}
	
	public hero_A(hero a){
		super(a);
	}
	
	protected void setHP() {
		HP = (Math.random() * 100 + 400);
	};

	protected void setMP() {
		MP = (Math.random() * 50 + 300);
	};

	protected void setPhysical_ATK() {
		Physical_ATK = (Math.random() * 20 + 40);
	};

	protected void setPhysical_DEF() {
		Physical_DEF = (Math.random() * 10 + 10);
	};

	protected void setMagic_ATK() {
		Magic_ATK = 0;
	};

	protected void setMagic_DEF() {
		Magic_DEF = (Math.random() * 10 + 0);
	};

	protected void setPhysical_Vampire() {
		Physical_Vampire = (Math.random() * 10 + 15);
	};

	protected void setMagic_Vampire() {
		Magic_Vampire = 0;
	};
	
	protected String getSkillName_one(){
		return "三重爪擊 連續攻擊三次 / 消耗魔力 30";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 30 > 0){
			a.HP = a.HP - 3 * this.Physical_ATK	* (1 - a.Physical_DEF / 100);
			this.MP = this.MP - 30;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "橫掃千軍 攻擊對方生命15%血量 / 消耗魔力 100";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 100 > 0){
			a.HP = a.HP * (1 - 0.15);
			this.MP = this.MP - 100;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "兇殘打擊 物理攻擊對方並附加50無視防禦傷害 / 消耗魔力 50";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 50 > 0){
			a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100) - 50;
			this.MP = this.MP - 50;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getNormalName(){
		return "普通攻擊";
	}
	
	protected void getNormal(hero a){
		a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100);
		this.HP = this.HP + this.Physical_Vampire;
	}
}