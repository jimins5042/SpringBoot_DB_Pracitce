package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//기본적인 crud 가능 제공
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {

    //특정 itemName을 가진 데이터를 조회
    List<Item> findByItemNameLike(String itemName);

    //가격 조회
    List<Item> findByPriceLessThanEqual(Integer price);

    //아이템 네임 + 가격 동시 조회
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);

    //쿼리 직접 실행
    //@Param 반드시 필요
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
}
