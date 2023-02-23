package o_a_ex.AOP;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect

public class aop {
    @Before("execution(* o_a_ex.Services.Services.*.ajouter*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        Date d = new Date();
        log.info(String.valueOf(d));
    }
}
