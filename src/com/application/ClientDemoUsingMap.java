package com.application;

import com.application.model.Employee;
import com.application.model.User;

import java.util.*;

public class ClientDemoUsingMap {
    public static void main(String[] args) {
        // Create a MAP
        Map<String, Employee> amap = new TreeMap<>();
        Employee emp1 = new Employee("01","abc","hr");
        Employee emp2 = new Employee("02","def","tech");
        Employee emp3 = new Employee("03","pqr","operations");

        amap.put(emp3.getEmpId(),emp3); //03
        amap.put(emp2.getEmpId(),emp2); //02
        amap.put(emp1.getEmpId(),emp1); //01

        Set<Map.Entry<String,Employee>> entries = amap.entrySet();
        for(Map.Entry<String,Employee> entry : entries ){
            System.out.print(" Key : "+entry.getKey());
            System.out.println(" Value : "+entry.getValue());
        }
        System.out.println("-----------------To get a single value---------------");
        System.out.println(" Emp3 : "+amap.get("03"));

        // Contains key -> search operation
        int i = 2;
        while( i > 0){
            if(! amap.containsKey("04")){ // ! true = false
                amap.put("04",new Employee("04","Test","Test"));
            }else{
                // do nothing
                System.out.println(" Inside Else");
            }
            i --;
        }

        // print the map once again
        System.out.println("----------------------------------------Updated Map--------");
        Set<Map.Entry<String,Employee>> set = amap.entrySet();
        for(Map.Entry<String,Employee> entry : entries ){
            System.out.print(" Key : "+entry.getKey());
            System.out.println(" Value : "+entry.getValue());
        }

//        Iterator<Map.Entry<Integer,String>> iterator = entries.iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, String> t = iterator.next();
//            System.out.print(t.getKey());
//            System.out.println(t.getValue());
//        }

        TreeMap<User,User> tmap = new TreeMap<>(new MyComparator());
        User user1 = new User("test","test");
        User user2 = new User("admin","admin");
        User user3 = new User("admin","admin");

        tmap.put(user1,user1);
        tmap.put(user2,user2);
        //tmap.put(null,user3);


        //tmap.remove(user1);
        Set<Map.Entry<User,User>> tSet = tmap.entrySet();
        System.out.println("######################################");
        for(Map.Entry<User,User> p : tSet){
            System.out.print(p.getKey());
            System.out.println(p.getValue());
        }

    }
}

