package com.lt.option;

/**
 * @author : litang
 * @date : Create in 2020/4/24
 * @Description
 */
class Outer {
    Nested nested;
    Nested getNested() {
        return nested;
    }
}
class Nested {
    Inner inner;
    Inner getInner() {
        return inner;
    }
}
class Inner {
    String foo;
    String getFoo() {
        return foo;
    }
}
