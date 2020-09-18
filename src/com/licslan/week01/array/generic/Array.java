package com.licslan.week01.array.generic;


/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class Array<E> {

    //泛型数组改造  泛型 1.5+支持  此时不支持动态扩缩容
    /**类设计者需要注意你这个类怎么设计 ！！！ <内存级别CRUD></内存级别CRUD>
     * 怎么使用  我们对于我们的这个类要做什么要很清楚  用户根据我们暴露的公有方法接口来调用
     * 我们使用数组这个数据结构对我们数据进行内存级别的增删改查
     * 其实像一些大型软件或者数据库也是进行业务上面的增删改查 更高级别的抽象了
     * */
    //private 不想用户去随便修改我们的属性
    private E[] data;//定义一个数组
    private int size;//数组中实际的元素大小

    //构造方法 初始化一个空数组  数组大小为capacity
    public Array(int capacity){
        this.data=(E[]) new Object[capacity];
        this.size=0;
    }

    //默认无参构造方法 大小为10
    public Array(){
        this(10);
    }

    //获取数组的大小
    public int getSize(){
        return size;
    }

    //获取数组的容量  容量和这个数组的长度相同
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向数组中添加元素  数组最后的一个元素后面添加一个元素就行
    public void addLast(E e){
        //如果size==data.length的话 此时不可以再往里面添加了 data.length = capacity 这个是和容量相同的 无法自动扩容目前  所以无法添加的此时
        if(size == data.length) throw new IllegalArgumentException("addLast element failed! Array is Full");
        //如果size此时=0 那么data[0]=e 就是数组中的第一个元素的值为e
        data[size]=e;
        //向后移动一位
        size++;
        //同义 data[size++]=e
    }

    //addLast可以复用下面的向指定位置添加元素这个方法
    public void addLast1(E e){
        this.add(size,e);
    }

    //addFirst可以复用下面的向指定位置添加元素这个方法
    public void addFirst(E e){
        this.add(0,e);
    }

    //向数组指定索引位置添加元素e
    public void add(int index,E e){
        //如果size==data.length的话 此时不可以再往里面添加了
        if(size == data.length) throw new IllegalArgumentException("add element failed! Array is Full");
        //index必须大于零 或者在之前数组实际大小的范围之内选择插入元素 不能选择大于size范围去操作
        if(index<0||index>size) throw new IllegalArgumentException("add element failed! Array is required index>=0 and index<=size");
        for (int i = size-1; i >=index ; i--) {
            data[i+1]=data[i]; //将值往后面移动一位
        }
        data[index]=e;//将值赋值给原来位置上面的值 覆盖一下
        size++; //插入了一个元素 size加一位
    }

    //覆盖父类的toString()
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    //获得指定index的值
    public E get(int index){
        if(index<0||index>=size) throw new IllegalArgumentException("get failed! Array is required index>=0 and index<=size");
        return data[index];
    }

    //修改指定index的值
    public void set(int index,E e){
        if(index<0||index>=size) throw new IllegalArgumentException("set failed! Array is required index>=0 and index<=size");
        data[index]=e;
    }

    //给定一个元素是否 搜索是否存在这个元素
    public boolean contains(E e){
        for (int i = 0; i < size; i++)
            //类的比较用equals  值比较
            if (data[i].equals(e)) return true;
            //if (data[i] == e) return true; 引用比较
        return false;
    }


    //给定一个元素找到并返回它的索引 if not return -1
    public int find(E e){
        for (int i = 0; i < size; i++)
            if (data[i].equals(e)) return i;
            //if (data[i] == e) return i;
        return -1;
    }

    //删除一个元素 返回删除的那个值是多少
    public E remove(int index){
        //index必须大于零 或者在之前数组实际大小的范围之内选择插入元素 不能选择大于size范围去操作
        if(index<0||index>=size) throw new IllegalArgumentException("remove element failed! Array is required index>=0 and index<=size");
        E ret = data[index];
        for (int i = index + 1; i < size ; i++)
            data[i-1]=data[i]; //将值往前面移动一位
        //data[index]=e;//将值赋值给原来位置上面的值 覆盖一下  已经get不到这个值了  所有没有问题 但使用泛型的时候data[size]这个值其实还存在的 现在是类对象了 所有需要注意优化一下 不然会占用空间
        size--; //删除了一个元素 size减一位
        data[size] = null; //提高垃圾回收效率  如果后面有要新添加的对象就没有什么事情了  这种对象可以称为 loitering objects  （闲散的对象） !=内存泄漏   data[size] = null;不写也可以
        return ret;
    }

    //删除第一个
    public E removeFirst(){
       return this.remove(0);
    }

    //删除最后一个
    public E removeLast(){
        return this.remove(size-1);
    }

    //删除元素  此时删除是可以存放重复元素的 怎么保证都删除呢 只要可以找到这个元素
    public void removeElement(E e){
        int index = find(e);
        if(index!=-1)
            remove(index);
    }

    //递归是可以解决的
    public void removeElementALL(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
            removeElementALL(e);
        }
    }



}
