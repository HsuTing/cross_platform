
public class hero_B extends hero {
	public hero_B(){
		super();
	}
	
	public hero_B(hero b){
		super(b);
	}
	
	protected void setHP() {
		HP = (Math.random() * 200 + 800);
	};

	protected void setMP() {
		MP = (Math.random() * 100 + 200);
	};

	protected void setPhysical_ATK() {
		Physical_ATK = (Math.random() * 10 + 20);
	};

	protected void setPhysical_DEF() {
		Physical_DEF = (Math.random() * 10 + 20);
	};

	protected void setMagic_ATK() {
		Magic_ATK = 0;
	};

	protected void setMagic_DEF() {
		Magic_DEF = (Math.random() * 10 + 20);
	};

	protected void setPhysical_Vampire() {
		Physical_Vampire = 0;
	};

	protected void setMagic_Vampire() {
		Magic_Vampire = 0;
	};
	
	protected String getSkillName_one(){
		return "疾若奔雷 物理攻擊提高50傷害 / 消耗魔力 40";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 40 > 0){
			a.HP = a.HP - (this.Physical_ATK + 50) / (1 - a.Physical_DEF / 100);
			this.MP = this.MP - 40;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "熊性大發 造成對方自身血量15%的物理傷害(無視防禦) / 消耗魔力 35";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 35 > 0){
			a.HP = a.HP - this.HP * 0.15;
			this.MP = this.MP - 35;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "轟雷電爪 物理攻擊附加100魔法攻擊 / 消耗魔力 100";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 100 > 0){
			a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100) - 100 * (1 - a.Magic_DEF / 100);
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