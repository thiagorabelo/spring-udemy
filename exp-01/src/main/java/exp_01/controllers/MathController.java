package exp_01.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exp_01.converters.NumberConverter;
import exp_01.exception.UnsupportedMathOperationException;
import exp_01.math.SimpleMath;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/sub/{number1}/{number2}")
    public Double sub(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        return math.sub(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/mul/{number1}/{number2}")
    public Double mul(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        return math.mul(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/div/{number1}/{number2}")
    public Double div(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        if (NumberConverter.convertToDouble(number2) == 0.0D) {
            throw new UnsupportedMathOperationException("Can not divide by 0");
        }
        return math.div(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number1) || !NumberConverter.isNumeric(number2)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        return math.mean(NumberConverter.convertToDouble(number1), NumberConverter.convertToDouble(number2));
    }

    @RequestMapping("/sqrt/{number1}")
    public Double sqrt(@PathVariable("number") String number) throws UnsupportedMathOperationException {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        return math.sqrt(NumberConverter.convertToDouble(number));
    }
}
