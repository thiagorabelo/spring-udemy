package exp_01.math;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import exp_01.exception.UnsupportedMathOperationException;

@Service
public class SimpleMath {

    public Double sum(Double number1,Double number2){
        return number1 + number2;
    }

    public Double sub(Double number1,Double number2){
        return number1 - number2;
    }

    public Double mul(Double number1,Double number2){
        return number1 * number2;
    }

    public Double div(Double number1,Double number2){
        return number1 / number2;
    }

    public Double mean(Double number1,Double number2){
        return (number1 + number2) / 2.0D;
    }

    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }
}
