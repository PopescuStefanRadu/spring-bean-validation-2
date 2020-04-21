package ro.popescustefanradu.validationdoizero.queryparams;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.math.BigDecimal;
import java.util.*;

@RestControllerAdvice("ro.popescustefanradu.validationdoizero.queryparams")
public class FilterAdvice {


//    class VoucherFilter {
//        List<ShowParamsController.Filter<BigDecimal>> voucherValue = new ArrayList<>();
//        List<ShowParamsController.Filter<String>> asdQwe = new ArrayList<>();
//    }
//
//    @ModelAttribute
//    public Map<String, List<ShowParamsController.Filter>> filters(@RequestParam Map<String, String> requestParams) {
//        HashMap<String, List<ShowParamsController.Filter<?>>> stringListHashMap = new HashMap<>();
//        ShowParamsController.Filter filter = new ShowParamsController.Filter();
//        filter.setType(ShowParamsController.FilterType.IN);
//        filter.setValue("asd");
//        List<ShowParamsController.Filter> filters = stringListHashMap.computeIfAbsent("key", k -> new LinkedList<>());
//        filters.add(filter);
//        return stringListHashMap;
//    }


    // nameIn =
}
