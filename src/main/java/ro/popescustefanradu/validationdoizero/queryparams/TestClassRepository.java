package ro.popescustefanradu.validationdoizero.queryparams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TestClassRepository extends JpaRepository<ShowParamsController.TestFilterModel, String>, JpaSpecificationExecutor<ShowParamsController.TestFilterModel> {
}
