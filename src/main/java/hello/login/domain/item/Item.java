package hello.login.domain.item;

import lombok.Data;

@Data
public class Item {

    /**
     *  domain / 도메인 = 화면,ui,기술 인프라 등등의 영역은 제외한 시스템이 구현해야 하는 핵심 비즈니스 업무 영역을 말한다
     *  또한 향후에 web을 다른 기술로 바꾸어도 도메인은 그대로 유지할 수 있어야한다.
     */

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}