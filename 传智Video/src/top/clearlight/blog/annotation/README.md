>优秀博客及官方文档 :
>\
>[Java 教程](https://docs.oracle.com/javase/tutorial/java/annotations/index.html)
>
>[Java 注解笔记](https://github.com/Omooo/Android-Notes/blob/master/blogs/Java/注解.md)
>
>[秒懂，Java 注解 （Annotation）你可以这样学](https://blog.csdn.net/briblue/article/details/73824058)
>


# 一、注解语法
---
注解也是一种类型。它是在 Java SE 5.0 版本中开始引入的概念。
<br>

# 二、元注解
---
元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其他的注解上面。

**元注解有 ：**

**@Retention**: 解释说明了这个注解的存活时间

它的取值：
- RetentionPolicy.SOURCE ： 只在源码阶段保留，编码一起进行编译是将被丢弃忽视
- RetentionPolicy.CLASS : 保留到编译进行的时候，并不会被加载到JVM中
- RetentionPolicy.RUNTIME : 保留到程序运行的时候， 会被加载到JVM中，可以在程序运行时获取到它们

\
**@Documented** ： 能够将注解中的元素包含到Javadoc中

\
**@Target** : 指定了注解运用的地方,如果不写的话,可以在类,方法..都可以使用

它的取值：
- ElementType.ANNOTATION_TYPE : 可以给一个注解进行注解
- ElementType.CONSTRUCTOR : 可以给构造方法进行注解
- ElementType.FIELD : 可以给属性进行注解
- ElementType.LOCAL_VARIABLE : 可以给局部变量进行注解
- ElementType.METHOD : 可以给方法进行注解
- ElementType.PACKAGE : 可以给一个包进行注解
- ElementType.PARAMETER : 可以给一个方法内的参数进行注解
- ElementType.TYPE : 可以给一个类型进行注解, 比如 类、接口、枚举..

\
**@Inherited** : 一个超类被@Inherited注解过的注解进行注解的话,那么如果它的子类没有被任何注解应用的话,那么这个子类就继承了超类的注解

```java
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

@Test
public class A {}

public class B extends A {}
```
>注解Test被@Inherited修饰, 之后类A被Test注解, 类B继承A, 类B也拥有Test这个注解.

<br>

**@Repeatable** : 对声明或类型使用应用相同的批注.

Java 8 加进来的，属于新特性

该注解的用法：
**容器注解**
```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Container { // 属于容器，来装载多个被Repeatable注解修饰的注解
    Person[] value(); // 规定：属性必须为被Repeatable定义的注解的数组形式
                      //      且method必须为value()
}
```

**被Repeatable注解修饰的注解**
```java
import java.lang.annotation.Repeatable;import java.lang.annotation.Retention;import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Container.class)
public @interface Person {
    // 人人都是艺术家..
    String role() default "artist";
}
```

**测试类**
```java
public class ReflectTest1 {

    @Person(role = "student")
    @Person(role = "cooker")
    @Person(role = "superman")
    public void test() {
        System.out.println("用来测试Repeatable注解");
    }
	
	public static void main(String[] args) {
		 // 获取指定方法的注解
        System.out.println("\n获取指定方法的注解");
        try {
            Method test = rt.getDeclaredMethod("test", null);
            Container conAn = test.getAnnotation(Container.class);
            System.out.println("人的角色: ");
            for (Person person : conAn.value()) {
                System.out.println(person.role());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
	}

}
```


# 三、自定义注解
>**元注解 : 定义(修饰)其他注解的注解
那么自定义注解 : 使用java中的元注解定义(修饰)的注解.**
---

## 如何定义一个注解?
**格式:**

修饰符 @interface 注解名称 {
	
}

注解中可以定义成员变量,用于信息的描述,但其形式和接口中的方法的定义类似.

举例:
```java
public @interface People {

	String name();
	
	// 还可以添加默认值
	int age() default 17;
	
}
```
除了这两方面,通常还需要依靠java中的元注解来指定自定义注解的用途.

比如要上面的注解 1. 用来专门修饰方法 2. 该注解被保留的时间在运行时仍存在 
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface People {

	String name();
	
	// 还可以添加默认值
	int age() default 17;
	
}
```
这就是一个完整的自定义注解了,像java中已定义的@Override写在方法上面即可.
<br>

# 四、Java中内置的常用注解
---
官方文档 : [预定义的注解](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html)
1. @Override : 表示当前方法覆盖了父类方法
2. @Deprecation : 表示方法已经过时,使用时会有警告
3. @SuppressWarnings : 表示关闭一些警告信息(用来指定java编译器忽略特定的编译警告)
4. @SafeVarargs : (JDK1.7更新)表示专门抑制警告
5. @FunctoinalInterface : (JDK1.8更新) 表示修饰的该接口必须是函数式接口,否则编译时会报错

# 五、注解与反射
---
[获取注解中的内容]()


<br><br><br>

---
**如有错误,欢迎指正,感谢!**
<br><br>