package test02_polymorphism;

public class IPhone implements AlarmSound {

	@Override
	public void playalarm() {
		System.out.println("Beep beep beep!");
	}

}
