package com.application.model;

import java.util.Objects;

public class Employee implements Comparable{
    private String empId;
    private String empName;
    private String empDept;

    public Employee(String empId, String empName, String empDept) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    //@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return empId.equals(employee.empId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(empId);
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empDept='" + empDept + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object object) {
        Employee e = (Employee) object;
        return this.empId.compareTo(e.getEmpId());
    }
}
