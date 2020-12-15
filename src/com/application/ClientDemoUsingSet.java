package com.application;

import com.application.model.Employee;

import java.util.*;

public class ClientDemoUsingSet {


    public static void main(String[] args) {

        // Create a Set
        Set<Employee> set = new TreeSet<>();

        Employee emp1 = new Employee("01","abc","hr");
        Employee emp2 = new Employee("02","def","tech");
        Employee emp3 = new Employee("03","pqr","operations");
        Employee emp4 = new Employee("04","test","test");

        set.add(new Employee("02","def","coe"));
        set.add(emp4);
        set.add(emp1);
        set.add(emp2);//duplicated empId -> did not add to the set
        set.add(emp3);
        //set.add(null);
        //set.remove(emp2);

        // display the elements of the set
        // insertion order in set is not preserved
        for(Employee emp: set){
            System.out.println(emp);
        }

        System.out.println("----------- Converting to List-----------");
        // Converting the set into list
        List<Employee> convertedList = new ArrayList<>(set);
        convertedList.add(new Employee("111","Anastasiya","Technology"));
        // Convert the list data in descending order -?> Collections.sort() of Collection framework
        Collections.sort(convertedList, new Comparator<Employee>() {
            @Override
            public int compare(Employee obj1, Employee obj2) {
                return obj2.getEmpId().compareTo(obj1.getEmpId());
            }
        });
        for(Employee e : convertedList){
            System.out.println(e);
        }


        // Example with Sorted Set
        TreeSet<String> dataSet = new TreeSet<>();
        dataSet.add("Zeal");
        dataSet.add("Rat");
        dataSet.add("Cat");
        dataSet.add("Mat");
        dataSet.add("Bat");
        dataSet.add("Hat");
        //dataSet.add(null); // Null is not accepted in Treeset
        dataSet.add("Bat");

        System.out.println("---------------Sorted Set  -> TreeSet Example------------------");
        for(String str : dataSet){
            System.out.println(str);
        }

        System.out.println("------------TreeSet in Descending order---------------");
        Iterator<String> iterator = dataSet.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------");

        // TO check if any object is present without iteration
        if(dataSet.contains("Mat")){
            System.out.println("Data is available");
        }else{
            System.out.println("Data is not available");
        }

        System.out.println("First Element : " +dataSet.first());
        System.out.println("Last Element : "+dataSet.last());

        System.out.println("Is the treeset empty "+dataSet.isEmpty());

        // Conversion from Set to Array and printing it
        System.out.println("------------------------Conversion from Set to Array and printing it---------------");
        Object[] ar = dataSet.toArray();
        for(int i = 0; i < ar.length ; i++){
            System.out.println(ar[i]);
        }

    }

}
