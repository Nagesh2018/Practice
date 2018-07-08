package othertests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeObject {

	public static void main(String[] args) {
		RectangleA rect = new RectangleA(12,5);
		SerializeToFile(rect, "rectSerialized");
		
		RectangleA deSerializedRect = (RectangleA)DeSerializeFromFileToObject("rectSerialized");
		System.out.println("Rect Area is " +deSerializedRect.area());
	}


	public static void SerializeToFile(Object classObject, String fileName) {

		try {
			FileOutputStream fileStream = new FileOutputStream(fileName);

			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

			objectStream.writeObject(classObject);

			objectStream.close();
			fileStream.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static Object DeSerializeFromFileToObject( String fileName) {

		try {
			FileInputStream fis = new FileInputStream(fileName);

			ObjectInputStream objectStream = new ObjectInputStream(fis);

			Object deserializeObject  = objectStream.readObject();

			objectStream.close();
			fis.close();
			
			return deserializeObject;


		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

}
