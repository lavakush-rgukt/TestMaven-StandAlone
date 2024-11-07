package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.List.of;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;

public class Java8Concepcts {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,10,4,5,6,7,8,8);

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("emp1",1,1,"cse"));
        empList.add(new Employee("emp2",2,2,"ece"));
        empList.add(new Employee("emp3",3,3,"cvl"));
        empList.add(new Employee("emp4",4,4,"cse"));
        empList.add(new Employee("emp5",5,5,"ece"));
        empList.add(new Employee("emp6",6,6,"cvl"));
        empList.add(new Employee("emp7",7,7,"mech"));


    //Intermidiate Operations
    //1.Filter(Predicate<T>)
        System.out.println("Filter");
        Stream stream = list
                .stream()
                .filter(x-> x%2==0);
        stream.forEach(x->System.out.println(x));

    //2.Map(Function<T,R>)
        System.out.println("Map");
        Stream map = list
                .stream()
                .map(x->x*2);
        map.forEach(x-> System.out.println(x));
    //3.distinct
        System.out.println("distinct");
        Stream distinct = list
                .stream()
                .distinct();
        distinct.forEach(x-> System.out.println(x));
    //4.sorted
        System.out.println("sorted");
        Stream sorted = list
                .stream()
                .sorted(Comparator.reverseOrder()); //without comparater it will go by ascending order
        //.sorted(Comparator.comparing(Employee::salary).reversed) //if costum order
        sorted.forEach(x-> System.out.println(x));
        System.out.println("sorted emp");
        Stream<Employee> elist = empList
                .stream()
                .sorted(Comparator.comparing(Employee::getSal));
        elist.forEach(x-> System.out.println(x.getName() +" "+ x.getSal()));

    //5.limit
        System.out.println("limit");
        Stream<Employee> limit= empList
                .stream()
                .limit(2);
        limit.forEach(x-> System.out.println(x.getName()));

    //6.skip
        System.out.println("skip");
        Stream<Employee> skip = empList
                .stream()
                .skip(2);
        skip.forEach(x-> System.out.println(x.getName()));

    //terminal operators
    //1.collect
        System.out.println("collect");
        List<String> collect=empList
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    //2.forEach
        System.out.println("foreach");
         /*empList
                .stream()
                .forEach(x->x.setName("abc"));
         empList.forEach(x-> System.out.println(x.getName()));*/
        //3.reduce
        Optional<Integer> sum = empList
                .stream()
                .map(Employee::getSal)
                .reduce(Integer::sum);
        System.out.println("reduce sum="+sum);

        //4.count
        long count=empList
                .stream()
                .map(Employee::getName)
                .count();
        System.out.println("count="+count);
        //5.anymatch
        Boolean anymatch = empList
                .stream()
                .map(Employee::getName)
                .anyMatch(x->x.startsWith("1"));
        System.out.println("anymatch="+anymatch);

        //6min max
        Optional<Integer> minSal=empList
                .stream()
                .map(Employee::getSal)
                .min(Integer::min);

        minSal.ifPresent(x-> System.out.println("minsal"+x));

        Optional<Integer>  maxSal=empList
                .stream()
                .map(Employee::getSal)
                .max(Integer::max);
        maxSal.ifPresent(x-> System.out.println("maxsal"+maxSal));


        //of method to get normal array to work on as steam

        System.out.println("ofExample");
        Stream.of(1,2,3).forEach(x-> System.out.println(x));




        ///Q: How do you find the highest salary using Streams?

        Optional<Employee> highistSal=empList
                .stream()
                .max(Comparator.comparing(Employee::getSal));
        highistSal.ifPresent(x-> System.out.println("hight Sal="+x.getName()));

        //Q.How would you sort employees by their salary in descending order using Streams?
        List<Employee> orderBySalDesc = empList
                .stream()
                .sorted(Comparator.comparing(Employee::getSal).reversed())
                .collect(Collectors.toList());
        orderBySalDesc.forEach(x-> System.out.println(x.getSal()));

        //Q: How do you count the number of employees in a specific department?
        long salCount = empList
                .stream()
                .filter(x->x.getName().startsWith("e"))
                .count();
        System.out.println("calCount"+salCount);

        //Q: How do you collect the names of all employees into a list?
        List<String> empNames=empList
                .stream()
                .map(x->x.getName())
                .collect(Collectors.toList());

        empNames.forEach(System.out::println);

        //Q: How do you find the average salary of all employees?
        OptionalDouble avgSal=empList
                .stream()
                .mapToInt(x->x.getSal())
                .average();

        avgSal.ifPresent(System.out::println);

        //7. Q: How do you group employees by department using Streams?
        Map<String,List<Employee>> goupByDept=empList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept));
        goupByDept.forEach(
                (dept,et)-> {
                    System.out.println(dept + " ->");
                    et.forEach(x-> System.out.println(x.getName()));
                }        );

//Q: How do you check if all employees have a salary greater than a certain threshold?

        boolean allempSalgreaterthanzero=empList
                .stream()
                .allMatch(x->x.getSal()>0);
        System.out.println("allempSalgreaterthanzero "+allempSalgreaterthanzero);
//9. Q: How do you reduce the list of employees to find the total sum of their salaries?

        Integer sumOfSals=empList
                .stream()
                .map(Employee::getSal)
                .reduce(0,Integer::sum);

        System.out.println("sumOfSals->"+sumOfSals);


//11. Q: How do you convert a list of employees to a map where the key is the employee's id and the value is the employee object?

        Map<Integer,Employee> empMap=empList
                .stream()
                .collect(Collectors.toMap(Employee::getEmpid,x->x));

//12. Q: How do you flat map a list of departments, where each department has a list of employees, to get all employees?

        /*List<Employee> flatMap= empList
                .stream()
                .flatMap(Collection::stream);*/



//        1. Q: How do you find the second highest-paid employee using Streams?

        Optional<Employee> secondHighestSal = empList
                .stream()
                .sorted(Comparator.comparing(Employee::getSal).reversed())
                .skip(1)
                .findFirst();

        secondHighestSal.ifPresent(x-> System.out.println(x.getName() + " "+x.getSal()));

//2. Q: How would you group employees by department and calculate the average salary per department?
        Map<String,Double> empGroupByDepAvgSalDept=empList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSal)));
        empGroupByDepAvgSalDept.forEach((dept,avgsal)->{
            System.out.println(dept+" "+avgsal);
        });


//8. Q: How do you concatenate all employee names into a single string, separated by commas?
        String allEmpName=empList
                .stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        System.out.println("allEmpName->"+allEmpName);


        System.out.println("available process->"+Runtime.getRuntime().availableProcessors());


        String abc="abcdabcd";
        Map<String,Long> noOfRepetedChar= Arrays.stream(abc.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        noOfRepetedChar.forEach((cr,cnt)->{
            System.out.println(cr + " "+cnt);
        });

        String[] tempArr = {"apple","banana","apple"};
        Map<String,Long> noOfRepeted = Arrays.stream(tempArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        noOfRepeted.forEach((item,cnt)->{

            System.out.println(item+ " "+cnt);
        });


        //sort employe by name than employee by sal
        List<Employee> sortedByNameAndSal=empList
                .stream()
                .sorted(
                        Comparator.comparing(Employee::getName)
                                .thenComparing(Employee::getDept)
                                .thenComparing(Comparator.comparing(Employee::getSal).reversed())
                )
                .collect(Collectors.toList());
        sortedByNameAndSal.forEach(
                x->{
                    System.out.println("sortedByNameAndSal "+x.getName()+" "+x.getSal()+" "+x.getDept());
                }
        );

//replace aa->zz bb->yy cc->xx
        String mytempString = "aa bb cc hello world aa mytext";

        String rslt = Arrays.stream(mytempString.split(" "))
                .map(x-> {

                    if (x.contains("aa")) {
                        x="zz";
                    } return x;}
                    )
                .collect(Collectors.joining(" "));

        System.out.println(rslt);


        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Collection<List<Integer>> evenOddList = oneToTen.stream()
                .collect(collectingAndThen(partitioningBy(i -> i % 2 == 0),Map::values));

        System.out.println(evenOddList);


        Map<Boolean, List<Integer>> evenAddOddSeparation = oneToTen.stream()
                .collect(partitioningBy(i -> i % 2 == 0));

        System.out.println(evenAddOddSeparation);


///Find the frequency of each character in a string using Java 8 streams

        String testAbc= "hello";

        Map<String,Long> lllist =  Arrays.asList(testAbc.split(""))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(lllist);



        //Find the frequency of each element in an array or a list
        String[] mytempArr = {"avc","bbc","abc","abc"};

        Map<String,Long> ttt = Arrays.asList(mytempArr)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(ttt);

//Sort a given list of decimals in reverse order


        ArrayList<Object> al = new ArrayList<>();
        al.add(new Employee("emp1",1,1,"cse"));
        al.add("abc");
        al.add(1);

        String[] arr = "asdf! asdf ".split("[ !,?._'@]+");



        List<String> ss = Arrays.asList(arr)
                .stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());

        Map<String,String> hh = new HashMap<>();
        hh.put("a","a");




    }
}