package com.ohgiraffers.section03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;

// com.ohgiraffers 하위 폴더에 있는 특정 어노테이션을 가진 클래스를 빈으로 등록한다.
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

    /* CompotnentScan?
    * basePackages로 설정된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean으로 등록
    * @Component 어노테이션이 작성 된 클래스를 인식하여 bean으로 등록
    * 목적에 따라 @Controller, @Service, @Repository, @Configuration 등을 사용 */


}
