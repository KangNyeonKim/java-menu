package menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

class MenuBookTest {
    @DisplayName("새로운 카테고리 추가 실페")
    @Test
    void modifyCategories() {
        //given

        //when
        Executable addCategory = () -> MenuBook.CATEGORIES.add("test");

        //then
        Assertions.assertThrows(UnsupportedOperationException.class, addCategory);
    }

    @DisplayName("카테고리 메뉴 Map에 새로운 항목 추가 실패")
    @Test
    void modifyCategoryMeuns() {
        //given

        //when
        Executable addCategory = () -> MenuBook.CATEGORY_MENUS.put("testCategory", List.of("menu1","menu2"));

        //then
        Assertions.assertThrows(UnsupportedOperationException.class, addCategory);
    }

    @DisplayName("카테고리 메뉴 List에 새로운 메뉴 추가 실패")
    @Test
    void modifyCategoryMeuns2() {
        //given

        //when
        Executable addCategory = () -> MenuBook.CATEGORY_MENUS.get("중식").add("메뉴");

        //then
        Assertions.assertThrows(UnsupportedOperationException.class, addCategory);
    }
}