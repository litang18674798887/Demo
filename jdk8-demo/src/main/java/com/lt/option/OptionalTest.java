package com.lt.option;

import com.lt.bean.User;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author : litang
 * @date : Create in 2019-05-23
 * @Description
 */
public class OptionalTest {


    @Test
    public void test03() throws Throwable {
        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                /* .orElseThrow(new Supplier<Throwable>() {
                     @Override
                     public Throwable get() {
                         return new NullPointerException();
                     }
                 })*/
                .ifPresent(s -> System.out.println(11111));

    }

    public static void main(String[] args) {

        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = null;
        Integer value2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

    }

    @Test
    public void test01() {

        Optional<String> optional = Optional.of("aaa");
        // isPresent（）： 如果值存在返回true，否则返回false
        System.out.println(optional.isPresent());

        // get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        System.out.println(optional.get());

        // orElse（）：如果有值则将其返回，否则返回指定的其它值
        System.out.println(optional.orElse("fffff"));

        // ifPresent（）：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }

    @Test
    public void test02() {
        User user = new User();
        Optional.ofNullable(user).orElse(createUser());
        Optional.ofNullable(user).orElseGet(() -> createUser());
    }

    public User createUser() {
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

}
