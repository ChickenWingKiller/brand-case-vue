package com.itheima.web.servlet.old;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Student {
    private int age;
    private String name;
    public String address;
    public Student(){}
    private Student(String name) {
        this.name = name;
    }
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    private void method(){
        System.out.println("method");
    }
    public void method1(){
        System.out.println("method1");
    }
    public void method2(String s) {
        System.out.println("method2" + s);
    }
    public String method3(String s, int i) {
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        Student s = new Student();
        Class<? extends Student> studentClass2 = s.getClass();
        System.out.println(studentClass == studentClass2);
        Class<?> studentClass3 = Class.forName("com.itheima.web.servlet.old.Student");
        System.out.println(studentClass3 == studentClass2);
        System.out.println("--------------------------------------------------");
        Constructor<?>[] constructors = studentClass.getConstructors();
        for(Constructor con : constructors) {
//            System.out.println(con);
        }
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for(Constructor con : declaredConstructors) {
//            System.out.println(con);
        }
        Constructor<Student> con = studentClass.getConstructor(String.class, int.class, String.class);
        Constructor<Student> dcon = studentClass.getDeclaredConstructor(String.class);
//        Constructor<Student> con = studentClass.getConstructor();
        System.out.println(con);
        System.out.println("--------------------------------------------------");
        Student student = con.newInstance("zhangsan", 30, "beijing");
//        dcon.setAccessible(true);
        Student s1 = dcon.newInstance("lisi");
        System.out.println(s1);
        System.out.println("--------------------------------------------------");
        Field address = studentClass.getDeclaredField("address");
        address.set(s1,"beijing");
        System.out.println(s1);
        System.out.println("--------------------------------------------------");
        Constructor<Student> constructor = studentClass.getConstructor();
        Student student1 = constructor.newInstance();
        Method method1 = studentClass.getMethod("method1");
        method1.invoke(student1);
        Method method = studentClass.getDeclaredMethod("method");
        method.invoke(student1);
        Method method2 = studentClass.getMethod("method2", String.class);
        method2.invoke(student1, "qwer");
    }
}
