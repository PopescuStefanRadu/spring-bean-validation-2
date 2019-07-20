package ro.popescustefanradu.validationdoizero

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import spock.lang.Specification

@SpringBootTest
class ValidationdoizeroApplicationSpecIT extends Specification {

    @Autowired
    Environment env


    def "expect an environment to exist"() {
        expect:
        env != null
    }
}
