package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메서드에 사용하겠다는 타겟설정
@Retention(RetentionPolicy.RUNTIME)//언제까지 이 애노테이션 정보를 유지할것인가
public @interface LogExecutionTime {
}
