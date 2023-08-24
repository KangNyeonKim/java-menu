package menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {
    private static final Service service = new Service();

    @DisplayName("랜덤 카테고리 선정")
    @Test
    void selectRandomCategory() {
        //given

        //when
        String selected = service.selectRandomCategory();

        //then
        Assertions.assertTrue(MenuBook.CATEGORIES.contains(selected));
    }

    @DisplayName("카테고리 추천")
    @Test
    void recommendDayCategory() {
        //given
        List<String> recommendedCategories = new ArrayList<>(List.of("중식", "한식"));
        //when
        service.recommendDayCategory(recommendedCategories);
        //then
        assertThat(recommendedCategories.size()).isEqualTo(3);
    }

    /* private 메서드 테스트
    @DisplayName("카테고리 중복 추천 검증")
    @Test
    void validDuplicateCategory() {
        //given
        List<String> recommendedCategories = new ArrayList<>(List.of("중식", "중식"));
        //when

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> service.validDuplicate("중식", recommendedCategories));
    }
     */

    @Test
    void recommendDayMenu() {
        //given
        String recommendedCategory = "한식";
        Coach coach = new Coach("코치");

        //when
        service.recommendMenuToCoach(coach, recommendedCategory);

        //then
        assertThat(coach.getRecommendedMenus().get(0)).isIn(MenuBook.CATEGORY_MENUS.get("한식"));
    }
}