package ro.popescustefanradu.validationdoizero.queryparams;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.popescustefanradu.validationdoizero.queryparams.lib.FilterField;
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
    public static class TestEntity {
        String name;
        BigDecimal price;
    }

    @Data
    public static class TestFilterModel {
        FilterField<String> nameConditions;
        FilterField<BigDecimal> priceConditions;
    }

    @GetMapping("converter")
    public List<TestEntity> getFiltered(@QueryModel TestFilterModel filterModel) {
        Specification<TestEntity> nameSpecs = filterModel.nameConditions.toSpec((root, query) -> {
            query.distinct(true);
            return root.join("asd").get("blah");
        });
        Specification<TestEntity> priceSpecs = filterModel.priceConditions.toSpec((root, query) -> root.get("price"));
        return testClassRepository.findAll(nameSpecs.and(priceSpecs));
    }

    @GetMapping("test")
    public TestFilterModel testClass(@QueryModel TestFilterModel filterModel) {
        return filterModel;
    }

    @GetMapping("query-params")
    public Map<String, List<String>> showQueryParams(@RequestParam(required = false) MultiValueMap<String, String> params) throws JsonProcessingException {
        return params;
    }
}
