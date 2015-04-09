
public class hero_C extends hero {
	public hero_C(){
		super();
	}
	
	public hero_C(hero c){
		super(c);
	}
	
	protected void setHP() {
		HP = (Math.random() * 100 + 400);
	};

	protected void setMP() {
		MP = (Math.random() * 100 + 1000);
	};

	protected void setPhysical_ATK() {
		Physical_ATK = 0;
	};

	protected void setPhysical_DEF() {
		Physical_DEF = (Math.random() * 5 + 5);
	};

	protected void setMagic_ATK() {
		Magic_ATK = (Math.random() * 10 + 40);
	};

	protected void setMagic_DEF() {
		Magic_DEF = (Math.random() * 10 + 30);
	};

	protected void setPhysical_Vampire() {
		Physical_Vampire = 0;
	};

	protected void setMagic_Vampire() {
		Magic_Vampire = (Math.random() * 5 + 10);
	};
	
	protected String getSkillName_one(){
		return "群星殞落 魔法攻擊提高100傷害 / 消耗魔力 40";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 40 > 0){
			a.HP = a.HP - (this.Magic_ATK + 100) / (1 - a.Magic_DEF / 100);
			this.MP = this.MP - 40;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "星之祝福 回復體力200點 / 消耗魔力 80";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 80 > 0){
			this.HP = this.HP + 200;
			this.MP = this.MP - 80;
		}
		else{
			System.out.println("魔力不足 使用普翁攻擊");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "魔力灌注 魔法攻擊提高5%魔力值的傷害 / 消耗魔力 20";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 20 > 0){
			a.HP = a.HP - (this.Magic_ATK + 0.05 * this.MP)	* (1 - a.Magic_DEF / 100);
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
		a.HP = a.HP - this.Magic_ATK * (1 - a.Magic_DEF / 100);
		this.HP = this.HP + this.Magic_Vampire;
	}
}