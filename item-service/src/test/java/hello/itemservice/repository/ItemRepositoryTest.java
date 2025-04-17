package hello.itemservice.repository;


import static org.assertj.core.api.Assertions.assertThat;

import hello.itemservice.domain.item.Item;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("사과", 2000, 2);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("item1", 2000, 2);
        Item item2= new Item("item2", 100000, 3);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void update() {
        //given
        Item item = new Item("item1", 2000, 2);
        itemRepository.save(item);
        Long itemId = item.getId();


        //when
        Item updateParam = new Item ("item2", 100000, 3);
        itemRepository.update(itemId, updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

}