package exp_01.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
        @PathVariable("number1") String number1,
        @PathVariable("number2") String number2
    ) throws IllegalArgumentException, IllegalAccessException {
        if (!isNumeric(number1) || !isNumeric(number2)) {
            throw new IllegalArgumentException();
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    private Double convertToDouble(String number) throws IllegalAccessException {
        if (number == null || number.isEmpty()) {
            throw new IllegalAccessException();
        }
        number = number.replace(",", ".");
        return Double.parseDouble(number);
    }
    
    private boolean isNumeric(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        String num = number.replace(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // http://localhost:8080/math/subtract/3/5
    // http://localhost:8080/math/division/3/5


}
