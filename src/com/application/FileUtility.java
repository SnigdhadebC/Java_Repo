package com.application;

import com.application.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {


    public void writeToFileUsingFileWriter(String message){
        System.out.println("Input : "+message);
        File file = new File("C:\\Trainning for Java\\qwerty.txt");
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(message);
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void readFromFileUsingBufferedReader(){
        File file = new File("C:\\Trainning for Java\\qwerty.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String message = null;
            while((message = bufferedReader.readLine()) != null){
                System.out.println("Message #### :"+message);
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    public void writeToFile(List<Employee> message) throws IOException {
        System.out.println("Writing to a file......");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File file = new File("C:\\Trainning for Java\\abc.txt");
            if(file.exists()){
                // if file exists delete the previous file and recreate a new one;
                file.delete();
            }

            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(message);
           // converting string to byte array
           // oos.write(message.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
       } finally{
           // oos.close();
        }
        System.out.println("Writing to a file completed!!!!");
    }

    public void readFromFile() throws IOException {
        System.out.println("Reading from a file......");
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            fis = new FileInputStream("C:\\Trainning for Java\\abc.txt");
            ois = new ObjectInputStream(fis);
            //ois.readByte();// you have to convert from byte to string
            List<Employee> empList = (List<Employee>)ois.readObject();
            System.out.println("##  Message received ## ");
            for(Employee e : empList){ // for-each loop
                System.out.println(e);
            }

        }catch(IOException | ClassNotFoundException exception){
            exception.printStackTrace();
        }finally{
            ois.close();
        }
        System.out.println("Reading from a file completed!!!!");
    }

    public static void main(String[] args) {

        FileUtility file = new FileUtility();
        Employee emp = new Employee("01","X","Testing");
        Employee emp1 = new Employee("02","Y","HR");
        Employee emp2 = new Employee("03","Z","Devops");
        Employee emp3 = new Employee("04","A","OPs");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        try { // checked exception
            //1. write to a file
            file.writeToFile(employees);
            // 2. read from that file
            file.readFromFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                file.writeToFileUsingFileWriter("Hello World of Java..");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                file.writeToFileUsingFileWriter("Today is the last session I will miss you guys....");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                file.readFromFileUsingBufferedReader();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
