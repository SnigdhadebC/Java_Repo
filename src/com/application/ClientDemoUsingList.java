package com.application;

import com.application.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientDemoUsingList {
    //instance variable
    private List<Employee> empList = new ArrayList<>();

    /**
     *
     * @param emp
     */
    public void addEmployeeToList(Employee emp){
        empList.add(emp);
    }

    /**
     *
     */
    public void displayEmployees(){
        for(int i = 0; i < empList.size() ; i++){
            System.out.println(empList.get(i));
        }
    }

    /**
     *
     * @param indexNo
     */
    public void removeEmployee(int indexNo){
        empList.remove(indexNo);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("01","abc","hr");
        Employee emp2 = new Employee("02","def","tech");
        Employee emp3 = new Employee("03","pqr","operations");

        // call the method to add employee obj
        ClientDemoUsingList d = new ClientDemoUsingList();
        d.addEmployeeToList(emp1);
        d.addEmployeeToList(emp2);
        d.addEmployeeToList(emp3);

        // display the employees
        d.displayEmployees();

//       remove 2nd index from the list
        d.removeEmployee(1);
//
        System.out.println("---------------------------------------------------");
        //print the list again
        d.displayEmployees();
        System.out.println("### "+d.empList.get(1));

//        // remove all the data from list
//        System.out.println("---------------------------------------------------");
//        System.out.println("Removing the entire list : ");
//        for(int i = 0; i <= d.empList.size(); i++){
//            d.empList.remove(i);
//        }
//
//        //print the list again
//        System.out.println("List after deletion");
//        d.empList.clear();
//        d.displayEmployees();

    // Adding another collection of Employee to this employee list
        List<Employee> newEmployeeList = new ArrayList<>();
        newEmployeeList.add(new Employee("001","qwe","dept1"));
        newEmployeeList.add(new Employee("002","asd","dept1"));
        newEmployeeList.add(new Employee("003","zxc","dept1"));

        //d.empList.addAll(newEmployeeList); // adding a list to already existing list
        d.empList.addAll(1,newEmployeeList);
        // get the index of any object in a list
        int result = d.empList.indexOf(emp3);
        d.empList.add(emp3);
        System.out.println("------------------------New List-------------");
        d.displayEmployees();

        // Using indexOf and lastIndexOf
        int result2 = d.empList.lastIndexOf(emp3);
        System.out.println("Index of empid 02 is "+(result +1));
        System.out.println("Last Index of empid 02 is "+(result2 +1));

        // Sublist
        List<Employee> tempList = d.empList.subList(2,6);
        System.out.println("------------------------SubList-------------");
        // Using for-each loop
        for(Employee emp : tempList){
            System.out.println(emp); //code
        }

        // Using Iterator
        // Removing all elements from list
        Iterator<Employee> iterator = tempList.iterator();
        while(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

}
