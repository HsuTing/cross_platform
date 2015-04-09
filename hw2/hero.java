package hw2_F74011140_V01;

public abstract class hero {	
	protected double HP;
	protected double MP;
	protected double Physical_ATK;
	protected double Physical_DEF;
	protected double Magic_ATK;
	protected double Magic_DEF;
	protected double Physical_Vampire;
	protected double Magic_Vampire;
	
	protected abstract void getOriginal();
	protected abstract void getInformation();
	protected abstract double getHP();
	protected abstract double getMP();
	protected abstract void setHP();
	protected abstract void setMP();
	protected abstract void setPhysical_ATK();
	protected abstract void setPhysical_DEF();
	protected abstract void setMagic_ATK();
	protected abstract void setMagic_DEF();
	protected abstract void setPhysical_Vampire();
	protected abstract void setMagic_Vampire();
	protected abstract hero skill(hero a);
}