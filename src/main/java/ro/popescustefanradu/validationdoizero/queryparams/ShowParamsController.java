package ro.popescustefanradu.validationdoizero.queryparams;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.popescustefanradu.validationdoizero.queryparams.lib.Filter;
import ro.popescustefanradu.validationdoizero.queryparams.lib.QueryModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query-params")
@RequiredArgsConstructor
public class ShowParamsController {

    private final TestClassRepository testClassRepository;

    @Data
    public static class TestFilterModel {
        List<Filter<String>> nameFilters;
        List<Filter<BigDecimal>> priceFilters;
    }

    @GetMapping("converter")
    public List<TestFilterModel> getFiltered(@QueryModel TestFilterModel filterModel) {
        Specification<TestFilterModel> nameSpecs = filterModel.getNameFilters().stream()
                .map(filter -> filter.<TestFilterModel>toSpec((root, query) -> {
                    query.distinct(true);
                    return root.join("asd").get("blah");
                }))
                .reduce(Specification.where(null), Specification::and);

        Specification<TestFilterModel> priceSpecs = filterModel.getPriceFilters().stream()
                .map(bigDecimalFilter -> bigDecimalFilter.<TestFilterModel>toSpec((root, query) -> {
                    return root.get("price");
                }))
                .reduce(Specification.where(null), Specification::and);

        return testClassRepository.findAll(nameSpecs.and(priceSpecs));
    }

    @GetMapping("test")
    public TestFilterModel testClass(@QueryModel TestFilterModel filterModel) {
        return filterModel;
    }

    @GetMapping("query-params")
    public Map<String,List<String>> showQueryParams(@RequestParam(required = false) MultiValueMap<String, String> params) throws JsonProcessingException {
        return params;
    }
}
