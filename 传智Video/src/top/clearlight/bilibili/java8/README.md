## 记录一下B站具体学习网站地址
Java8学习视频网站:<https://www.bilibili.com/video/av35195879?t=656&p=15>

## 解决Stream无法重用的问题
```java
public class test {
    public static void main(String[] args){
         /*
              解决Stream无法重用的问题
           */
          String[] array = {"a", "b", "c", "d", "e"};
  
          Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
  
          //get new stream
          streamSupplier.get().forEach(x -> System.out.println(x));
  
          //get another new stream
          long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
          System.out.println(count);
  
          /*
              解决方法2
           */
          Supplier<Stream<String>> streamSupplier2
                  = () -> Stream.of("A", "B", "C", "D");
          Optional<String> result1 = streamSupplier2.get().findAny();
          System.out.println(result1.get());
          Optional<String> result2 = streamSupplier2.get().findFirst();
          System.out.println(result2.get());

         List<Employee> emp = Arrays.asList(
                      new Employee(100, "Tary", 18, 3000),
                      new Employee(100, "Mary", 18, 3000),
                      new Employee(100, "Oary", 18, 4900),
                      new Employee(101, "Jack", 38, 3000),
                      new Employee(102, "BOb", 28, 5000),
                      new Employee(103, "Aom", 18, 6000)
              );

          Supplier<Stream<List<Employee>>> streamSupplier3 = () -> Stream.of(emp);
          streamSupplier3.get().forEach(System.out::println);
          streamSupplier3.get().forEach(System.out::println);

    }
}
```