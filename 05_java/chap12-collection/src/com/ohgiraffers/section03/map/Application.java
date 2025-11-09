package com.ohgiraffers.section03.map;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        /*
        * Map 인터페이스
        * - key(K)와 value(V)를 하나의 쌍(Entry)으로 묶어서 관리한다.
        * - key는 중복 저장을 허용하지 않는다.
        * - value는 중복 저장을 허용한다.
        * - 저장 순서를 유지하지 않는다 (HashMap의 경우)*/
        // Map<Key 타입, Value 타입> 변수명 = new 사용할 클래스명<>();
        Map<String, String> hmap = new HashMap<>();

        // put() 메소드를 이용하여 키-값 쌍을 저장
        hmap.put("one", "java");
        hmap.put("two", "jbdc");
        hmap.put("three", "mysql");
        hmap.put("two", "html");    // key 값이 중복되면 새로운 value로 덮어쓴다
        hmap.put("four", "java");   // key 값만 다르면 value값은 중복 허용

        System.out.println(hmap);   // {four=java, one=java, two=html, three=mysql}

        // get(key) 메소드를 사용하여 키에 해당하는 값을 가져온다.
        System.out.println(hmap.get("one")); // java

        // remove(key)
        hmap.remove("four");
        System.out.println(hmap);   // {one=java, two=html, three=mysql}

        /*
        * keySet() : 키만 가져옴
        * values() : 값만 가져옴
        * entrySet() : 키와 값을 쌍으로 가져옴*/

        // keySet() : 모든 키를 Set으로 반환받아, 키를 하나씩 꺼내고 get()으로 값을 찾는다.
        System.out.println("==== keySet() 이용 ====");
        Set<String> keys = hmap.keySet(); // Keyset은 Set타입으로 반환하니 Set으로 받는다
        // 반복자를 사용하여 꺼내기
        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String value = hmap.get(key);
            System.out.println(key + " = " + value);
        }

        // values() : 모든 값들만 Collection으로 반환받아 순회하는 방법 (키는 알 수 없음!)
        System.out.println("==== values() 이용 ====");
        Collection<String> values = hmap.values();
        for(String value : values) {
            System.out.println(value);
        }

        // entrySet() : 모든 키-값 쌍(Entry)을 Set으로 반환 받는 방법 (가장 효율적)
        System.out.println("==== entrySet() 이용 ====");
        Set<Map.Entry<String, String>> entrySet = hmap.entrySet();
        // Set으로 받아오니까 iterator 반복자 사용
        Iterator<Map.Entry<String, String>> entryIter = entrySet.iterator();
        while (entryIter.hasNext()) {
            Map.Entry<String, String> entry = entryIter.next();
            // entry 객체에서 getKey(), getValue()를 호출하여 키와 값을 얻을 수 있다.
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
