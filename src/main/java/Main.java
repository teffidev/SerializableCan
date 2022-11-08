import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Proceso de guardar y escribir en un archivo:
        List<Dog> dogs = new ArrayList<>();

        Dog dog1 = new Dog(3, "Firulais");
        Dog dog2 = new Dog(5, "Garfield");
        Dog dog3 = new Dog(10, "Toto");
        Dog dog4 = new Dog(2, "Candy");
        Dog dog5 = new Dog(6, "Rufus");

        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);

        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream = new FileOutputStream("DogList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dogs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Proceso de leer y capturar el archivo:
        List<Dog> dogs2 = new ArrayList<>();

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("DogList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            dogs2 = (List<Dog>) objectInputStream.readObject();

            for (Dog dog : dogs2) {
                System.out.println(dog.getName() + " | " + dog.getAge());
            }

        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
