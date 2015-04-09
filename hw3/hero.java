import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public abstract class hero {
	private String Name;
	private int job;
	private int Level;
	private int Experience;

	protected double HP;
	protected double MP;
	protected double Physical_ATK;
	protected double Physical_DEF;
	protected double Magic_ATK;
	protected double Magic_DEF;
	protected double Physical_Vampire;
	protected double Magic_Vampire;
	
	public hero(){
	}
	
	public hero(hero a){
		this.Name = a.Name;
		this.job = a.job;
		this.Level = a.Level;
		this.Experience = a.Experience;
		this.HP = a.HP;
		this.MP = a.MP;
		this.Physical_ATK = a.Physical_ATK;
		this.Physical_DEF = a.Physical_DEF;
		this.Magic_ATK = a.Magic_ATK;
		this.Magic_DEF = a.Magic_DEF;
		this.Physical_Vampire = a.Physical_Vampire;
		this.Magic_Vampire = a.Magic_Vampire;
	}
	
	public void getInformation() {
		System.out.println("名字：" + this.getName());
		System.out.printf("等級 %d\n", this.getLevel());
		System.out.printf("經驗值 %d/%d\n", this.getExperience(), this.getLevel() * 1000);
		System.out.printf("體力值 %.2f\n", this.HP);
		System.out.printf("魔力值 %.2f\n", this.MP);
		System.out.printf("物理攻擊 %.2f\n", this.Physical_ATK);
		System.out.printf("魔法攻擊 %.2f\n", this.Magic_ATK);
		System.out.printf("物理防禦 %.2f\n", this.Physical_DEF);
		System.out.printf("魔法防禦 %.2f\n", this.Magic_DEF);
		System.out.printf("物理吸血 %.2f\n", this.Physical_Vampire);
		System.out.printf("魔法吸血 %.2f\n", this.Magic_Vampire);
		System.out.println("技能：");
		System.out.println(this.getSkillName_one());
		System.out.println(this.getSkillName_two());
		System.out.println(this.getSkillName_three());
	}
	
	public void rand(String name, int level){
		this.setName(name);
		this.randLevel(level);
		this.setExperience();
		this.setHP();
		this.setMP();
		this.setPhysical_ATK();
		this.setPhysical_DEF();
		this.setMagic_ATK();
		this.setMagic_DEF();
		this.setPhysical_Vampire();
		this.setMagic_Vampire();
		this.levelup();
	}
	
	public void produce(String name, int job){
		if(this.checkNameList(name) == true){
			System.out.println("此名稱已被使用");
		}
		else{
			try{
				PrintWriter writer = new PrintWriter(new FileOutputStream(name + ".txt"));
				
				this.setName(name);
				this.setJob(job);
				this.setLevel();
				this.setExperience();
				this.setHP();
				this.setMP();
				this.setPhysical_ATK();
				this.setPhysical_DEF();
				this.setMagic_ATK();
				this.setMagic_DEF();
				this.setPhysical_Vampire();
				this.setMagic_Vampire();
				
				this.save();
				this.addNameList();
				
				writer.flush();
				writer.close();
			}
			catch (FileNotFoundException ex){
				System.out.println("無法產生新英雄");
				System.exit(0);
			}
		}
	}
	
	public void load(String name){
		Scanner filein = null;
		
		try{
			filein = new Scanner(new FileInputStream(name + ".txt"));
			
			this.setName(filein.nextLine());
			this.setJob(filein.nextInt());
			this.setLevel(filein.nextInt());
			this.setExperience(filein.nextInt());
			this.setHP(filein.nextDouble());
			this.setMP(filein.nextDouble());
			this.setPhysical_ATK(filein.nextDouble());
			this.setPhysical_DEF(filein.nextDouble());
			this.setMagic_ATK(filein.nextDouble());
			this.setMagic_DEF(filein.nextDouble());
			this.setPhysical_Vampire(filein.nextDouble());
			this.setMagic_Vampire(filein.nextDouble());
			
			filein.close();
		}
		catch(FileNotFoundException e){
			System.out.println("無法找到此英雄");
			System.exit(0);
		}
	}
	
	public void save(){
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(this.Name + ".txt"));
			
			writer.println(this.Name);
			writer.println(this.job);
			writer.println(this.Level);
			writer.println(this.Experience);
			writer.println(this.HP);
			writer.println(this.MP);
			writer.println(this.Physical_ATK);
			writer.println(this.Physical_DEF);
			writer.println(this.Magic_ATK);
			writer.println(this.Magic_DEF);
			writer.println(this.Physical_Vampire);
			writer.println(this.Magic_Vampire);
			
			System.out.println("儲存成功");
			
			writer.flush();
			writer.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("無法儲存英雄資料");
			System.exit(0);
		}
	}
	
	public void addNameList(){
		Scanner filein = null;
		String[] NameList;
		int amount = 0;
		try
		{
			filein = new Scanner(new FileInputStream("Name.txt"));
			
			if(filein.hasNext() == false){
				try {
					PrintWriter writer = new PrintWriter(new FileOutputStream("Name.txt"));
					
					writer.println(this.Name);
					
					writer.flush();
					writer.close();
					return;
				}
				catch (FileNotFoundException ex){
					System.out.println("無法將英雄名單加入名單中");
					filein.close();
					return;
				}
			}
			else{
				while(filein.hasNext() == true){
					amount = amount + 1;
					filein.nextLine();
				}
			}
			
			filein = new Scanner(new FileInputStream("Name.txt"));
			NameList = new String[amount];
			
			for(int i = 0; i < NameList.length; i++){
				NameList[i] = filein.nextLine();
			}
			filein.close();
			
			try {
				PrintWriter writer = new PrintWriter(new FileOutputStream("Name.txt"));
				
				for(int i = 0; i < NameList.length; i++){
					writer.println(NameList[i]);
				}
				writer.println(this.Name);
				
				writer.flush();
				writer.close();
				return;
			}
			catch (FileNotFoundException ex){
				System.out.println("無法將英雄名單加入名單中");
				return;
			}
		}
		catch(FileNotFoundException e)
		{
			try {
				PrintWriter writer = new PrintWriter(new FileOutputStream("Name.txt"));
				
				writer.println(this.Name);
				
				writer.flush();
				writer.close();
				return;
			}
			catch (FileNotFoundException ex){
				return;
			}
		}
	}
	
	public void showNameList(){
		Scanner filein = null;
		try
		{
			filein = new Scanner(new FileInputStream("Name.txt"));
			
			if(filein.hasNext() == false){
				System.out.println("英雄名單是空白的");
			}
			else{
				while(filein.hasNext() == true){
					System.out.println(filein.nextLine());
				}
			}

			filein.close();
		}
		catch(FileNotFoundException e)
		{
			try {
				PrintWriter writer = new PrintWriter(new FileOutputStream("Name.txt"));
				
				writer.flush();
				writer.close();
			}
			catch (FileNotFoundException ex) {
			}
		}
	}
	
	public boolean checkNameList(String name){
		Scanner filein = null;
		try{
			filein = new Scanner(new FileInputStream(name + ".txt"));
			filein.close();
			return true;
		}
		catch(FileNotFoundException e){
			return false;
		}
	}
	
	public void addExperience(hero a){
		if(a.Level >= this.Level){
			System.out.println("獲得了 " + (100 + 100 * (a.Level - this.Level)) + "點經驗");
			this.Experience = this.Experience + 100 + 100 * (a.Level - this.Level);
			if(this.Experience >= this.Level * 1000){
				this.Experience = this.Experience - this.Level * 1000;
				this.Level = this.Level + 1;
				
				this.levelup();
				System.out.println("恭喜升級了 你的等級：" + this.getLevel());
			}
		}
		else{
			System.out.println("獲得了 " + 100 / (this.Level - a.Level) + "點經驗");
			this.Experience = this.Experience + 100 / (this.Level - a.Level);
			if(this.Experience >= this.Level * 1000){
				this.Experience = this.Experience - this.Level * 1000;
				this.Level = this.Level + 1;

				this.levelup();
				System.out.println("恭喜升級了 你的等級：" + this.getLevel());
			}
		}
		
	}
	
	private void levelup(){		
		this.HP = this.HP + 1.1 * this.Level;
		this.MP = this.MP + 1.1 * this.Level;
		this.Physical_ATK = this.Physical_ATK + 1.1 * this.Level;
		this.Physical_DEF = this.Physical_DEF + 1.1 * this.Level;
		this.Magic_ATK = this.Magic_ATK + 1.1 * this.Level;
		this.Magic_DEF = this.Magic_DEF + 1.1 * this.Level;
		this.Physical_Vampire = this.Physical_Vampire + 1.1 * this.Level;
		this.Magic_Vampire = this.Magic_Vampire + 1.1 * this.Level;
	}
	
	public void chooseSkill(int choice, hero a){
		switch(choice){
			case 1:
				this.getSkill_one(a);
				break;
			case 2:
				this.getSkill_two(a);
				break;
			case 3:
				this.getSkill_three(a);
				break;
			default:
				this.getNormal(a);
				break;
		}
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setJob(int job){
		this.job = job;
	}
	
	public int getjob(){
		return this.job;
	}
	
	public void randLevel(int level){
		this.Level = level - (int)(Math.random() * 3);
		if(this.Level <= 0)
			this.Level = 1;
	}

	protected void setLevel() {
		this.Level = 1;
	}

	private void setLevel(int level) {
		this.Level = level;
	}
	
	public int getLevel() {
		return this.Level;
	}

	protected void setExperience() {
		this.Experience = 0;
	}

	private void setExperience(int experience) {
		this.Experience = experience;
	}
	
	public int getExperience() {
		return this.Experience;
	}

	abstract void setHP();

	private void setHP(double hp) {
		this.HP = hp;
	}
	
	public double getHP(){
		return this.HP;
	}

	abstract void setMP();

	private void setMP(double mp) {
		this.MP = mp;
	}
	
	public double getMP(){
		return this.MP;
	}

	abstract void setPhysical_ATK();

	private void setPhysical_ATK(double physical_ATK) {
		this.Physical_ATK = physical_ATK;
	}

	abstract void setPhysical_DEF();

	private void setPhysical_DEF(double physical_DEF) {
		this.Physical_DEF = physical_DEF;
	}

	abstract void setMagic_ATK();

	private void setMagic_ATK(double magic_ATK) {
		this.Magic_ATK = magic_ATK;
	}

	abstract void setMagic_DEF();

	private void setMagic_DEF(double magic_DEF) {
		this.Magic_DEF = magic_DEF;
	}

	abstract void setPhysical_Vampire();

	private void setPhysical_Vampire(double physical_Vampire) {
		this.Physical_Vampire = physical_Vampire;
	}

	abstract void setMagic_Vampire();

	private void setMagic_Vampire(double magic_Vampire) {
		this.Magic_Vampire = magic_Vampire;
	}
	
	public String getSkillName(int skill){
		String temp;
		switch(skill){
		case 1:
			temp = this.getSkillName_one();
			break;
		case 2:
			temp = this.getSkillName_two();
			break;
		case 3:
			temp = this.getSkillName_three();
			break;
		default:
			temp = this.getNormalName();
			break;
		}
		
		return temp;
	}
	
	abstract String getSkillName_one();
	abstract void getSkill_one(hero a);
	abstract String getSkillName_two();
	abstract void getSkill_two(hero a);
	abstract String getSkillName_three();
	abstract void getSkill_three(hero a);
	abstract String getNormalName();
	abstract void getNormal(hero a);
}
