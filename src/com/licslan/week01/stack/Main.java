package com.licslan.week01.stack;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Main {

    /***
     * 栈也是一种线性结构
     * 相比数组 栈是数组操作的子集
     * 只能从一段添加元素  也只能从一端取出元素  (栈顶  后进先出 LIFO)
     * 计算机领域不可思议的作用 1. Undo  撤销动作  2.系统栈的调用  3.括号匹配 - 编译器
     * */

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1000);
        for (int i = 0; i < 5; i++) {
            stack.push(i*100);
            System.out.println(stack);
        }
        System.out.println("栈顶元素： "+stack.peek());
        stack.pop();
        System.out.println("栈顶元素： "+stack.peek());
        System.out.println(stack);
    }
    //    测试用例结果
    //    Stack:  [1000,0] Top
    //    Stack:  [1000,0,100] Top
    //    Stack:  [1000,0,100,200] Top
    //    Stack:  [1000,0,100,200,300] Top
    //    Stack:  [1000,0,100,200,300,400] Top
    //    栈顶元素： 1000
    //    栈顶元素： 1000
    //    Stack:  [1000,0,100,200,300] Top
}
