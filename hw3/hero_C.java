
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
		return "�s�P�f�� �]�k��������100�ˮ` / �����]�O 40";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 40 > 0){
			a.HP = a.HP - (this.Magic_ATK + 100) / (1 - a.Magic_DEF / 100);
			this.MP = this.MP - 40;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "�P������ �^�_��O200�I / �����]�O 80";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 80 > 0){
			this.HP = this.HP + 200;
			this.MP = this.MP - 80;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "�]�O��` �]�k��������5%�]�O�Ȫ��ˮ` / �����]�O 20";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 20 > 0){
			a.HP = a.HP - (this.Magic_ATK + 0.05 * this.MP)	* (1 - a.Magic_DEF / 100);
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getNormalName(){
		return "���q����";
	}
	
	protected void getNormal(hero a){
		a.HP = a.HP - this.Magic_ATK * (1 - a.Magic_DEF / 100);
		this.HP = this.HP + this.Magic_Vampire;
	}
}