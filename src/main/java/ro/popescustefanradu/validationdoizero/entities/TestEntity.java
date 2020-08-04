package ro.popescustefanradu.validationdoizero.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TestEntity {
    @Id
    private String pk;

    private String someVal;
}
