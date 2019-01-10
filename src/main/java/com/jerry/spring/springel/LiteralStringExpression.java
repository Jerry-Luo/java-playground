package com.jerry.spring.springel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;

public class LiteralStringExpression {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("'Hello World!!'");
        System.out.println(exp.getValue());

        Expression expression = parser.parseExpression("'Hello World'.concat('!')");
        System.out.println(expression.getValue());

        // invokes 'getBytes()'
        Expression exp1 = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[])exp1.getValue();
        System.out.println(new String(bytes, StandardCharsets.UTF_8));

        // invokes 'getBytes().length'
        Expression exp2 = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp2.getValue();
        System.out.println(length);

        Expression exp3 = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp3.getValue(String.class);
        System.out.println(message);


//        // Create and set a calendar
//        GregorianCalendar c = new GregorianCalendar();
//        c.set(1856, 7, 9);
//
//        // The constructor arguments are name, birthday, and nationality.
//        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
//
//        ExpressionParser parser = new SpelExpressionParser();
//
//        Expression exp = parser.parseExpression("name");
//        String name = (String) exp.getValue(tesla);
//        // name == "Nikola Tesla"
//
//        exp = parser.parseExpression("name == 'Nikola Tesla'");
//        boolean result = exp.getValue(tesla, Boolean.class);
//        // result == true
    }
}
