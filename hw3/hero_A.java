
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
		return "�T������ �s������T�� / �����]�O 30";
	}
	
	protected void getSkill_one(hero a){
		if(this.MP - 30 > 0){
			a.HP = a.HP - 3 * this.Physical_ATK	* (1 - a.Physical_DEF / 100);
			this.MP = this.MP - 30;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_two(){
		return "��d�x �������ͩR15%��q / �����]�O 100";
	}
	
	protected void getSkill_two(hero a){
		if(this.MP - 100 > 0){
			a.HP = a.HP * (1 - 0.15);
			this.MP = this.MP - 100;
		}
		else{
			System.out.println("�]�O���� �ϥδ��Χ���");
			this.getNormal(a);
		}
	}
	
	protected String getSkillName_three(){
		return "���ݥ��� ���z�������ê��[50�L�����m�ˮ` / �����]�O 50";
	}	
	
	protected void getSkill_three(hero a){
		if(this.MP - 50 > 0){
			a.HP = a.HP - this.Physical_ATK * (1 - a.Physical_DEF / 100) - 50;
			this.MP = this.MP - 50;
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