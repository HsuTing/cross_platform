
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
		return "�e�Y�b�p ���z��������50�ˮ` / �����]�O 40";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 40 > 0){
			a.HP = a.HP - (this.Physical_ATK + 50) / (1 - a.Physical_DEF / 100);
			this.MP = this.MP - 40;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "���ʤj�o �y�����ۨ���q15%�����z�ˮ`(�L�����m) / �����]�O 35";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 35 > 0){
			a.HP = a.HP - this.HP * 0.15;
			this.MP = this.MP - 35;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "�F�p�q�� ���z�������[100�]�k���� / �����]�O 100";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 100 > 0){
			a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100) - 100 * (1 - a.Magic_DEF / 100);
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
		a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100);
		this.HP = this.HP + this.Physical_Vampire;
	}
}