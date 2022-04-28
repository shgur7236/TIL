package Stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TravelCustomerTest {
    public static void main(String[] args){

        TravelCustomer customerKAK = new TravelCustomer("외부인", 40, 100);
        TravelCustomer customerSONG = new TravelCustomer("송정윤", 20, 100);
        TravelCustomer customerOH = new TravelCustomer("오종진", 13, 50);

        List<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
        customerList.add(customerKAK);
        customerList.add(customerSONG);
        customerList.add(customerOH);

        System.out.println("고객 명단 출력");
        customerList.stream().map(c->c.getName()).forEach(s-> System.out.println(s));

        System.out.println("여행비용");
        System.out.println(customerList.stream().mapToInt(c->c.getPrice()).sum());

        System.out.println("20살 이상 고객이름 정렬");
        customerList.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).sorted().forEach(s-> System.out.println(s));
    }
}
