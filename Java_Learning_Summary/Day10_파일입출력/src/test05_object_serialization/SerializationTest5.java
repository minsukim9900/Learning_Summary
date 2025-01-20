package test05_object_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class SerializationTest5 {
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.dat"))){
			Object obj = ois.readObject();
			
			List<Person> list = (List<Person>) obj;
			System.out.println(list);
		} catch(IOException | ClassNotFoundException e) {
			
		}
	}
}
