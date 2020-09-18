package com.licslan.week01.array.generic;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Student implements Comparable<Student>{

    public Student(Integer age){
        this.age=age;
    }
    private Integer age;

    /**
     * 覆盖之前Object的equals
     * */
    @Override
    public boolean equals(Object o){
        //判断一下条件
        if(this==o) return true;
        if(o==null) return false;
        if(this.getClass()!=o.getClass()) return false;

        Student another = (Student)o;
        return this.age.equals(another.age);
    }


    @Override
    public int compareTo(Student another) {
        //        if(this.age>another.age)return 1;
        //        else if(this.age==another.age)return 0;
        //        else return -1;
        //简写
        return this.age-another.age;
    }

    //类的设计者维护
    @Override
    public String toString(){
        return String.format("Student(age: %d)",age);
    }

    public static void main(String[] args) {
        //默认10个学生
        Array<Student> studentArray = new Array<>();
        studentArray.addFirst(new Student(28));
        studentArray.addFirst(new Student(30));
        studentArray.addFirst(new Student(29));
        System.out.println(studentArray);
        studentArray.remove(1);
        System.out.println(studentArray);

    }
}
