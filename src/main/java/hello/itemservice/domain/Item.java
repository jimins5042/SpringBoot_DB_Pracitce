package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "item") //테이블 이름과 클래스 이름이 같을 경우 생략 가능
public class Item {

    @Id//PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //키 자동 증가
    private Long id;

    @Column(name = "item_name", length = 10)
    //이 어노테이션 생략시 필드의 이름을 컬럼명으로 사용
    private String itemName;
    private Integer price;
    private Integer quantity;

    // JPA는 기본 생성자가 필수로 있어야 함
    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
