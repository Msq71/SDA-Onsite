package day06;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01JavaFakerClass {
    Faker faker = new Faker();

    @Test
    public void testFaker(){

        Faker faker = new Faker();
      String fullName1 =  faker.name().fullName();
      String fullName2 =  faker.name().fullName();

        System.out.println("fullName1 = " + fullName1);
        System.out.println("fullName2 = " + fullName2);

        System.out.println("faker.number().numberBetween(100,999) = " + faker.number().numberBetween(100, 999));
        System.out.println(fullName1+" "+fullName2);

        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());
        System.out.println("faker.internet().password(6,8,true,true,false) = " + faker.internet().password(6, 8, true, true, false));

    }
}
