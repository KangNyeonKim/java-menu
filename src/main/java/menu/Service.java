package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static menu.MenuBook.CATEGORIES;
import static menu.MenuBook.CATEGORY_MENUS;

public class Service {
    public static final int CATEGORY_DUPLICATE_LIMIT = 2;
    public static final int WEEKDAYS = 5;


    public void recommendDayCategory(List<String> recommendedCategories) {
        String selectedCategory = selectRandomCategory();
        while (hasMoreThanLimit(selectedCategory, recommendedCategories)) {
            selectedCategory = selectRandomCategory();
        }
        recommendedCategories.add(selectedCategory);
    }

    public String selectRandomCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(1, CATEGORIES.size()) - 1);
    }

    private boolean hasMoreThanLimit(String selectedCategory, List<String> recommendedCategories) {
        return Collections.frequency(recommendedCategories, selectedCategory) >= CATEGORY_DUPLICATE_LIMIT;
    }

    public void recommendMenuToCoach(Coach coach, String recommendedDayCategory) {
        String selectedRandomMenu = selectRandomMenu(recommendedDayCategory);
        while (isDuplicateMenu(selectedRandomMenu, coach) || isHateMenu(selectedRandomMenu, coach)){
            selectedRandomMenu = selectRandomMenu(recommendedDayCategory);
        }
        coach.addRecommendedMenu(selectedRandomMenu);
    }

    private boolean isDuplicateMenu(String selectedRandomMenu, Coach coach) {
        return coach.getRecommendedMenus().contains(selectedRandomMenu);
    }

    private boolean isHateMenu(String selectedRandomMenu, Coach coach) {
        return coach.getHateMenus().contains(selectedRandomMenu);
    }

    private String selectRandomMenu(String category) {
        return Randoms.shuffle(CATEGORY_MENUS.get(category)).get(0);
    }

    public List<String> recommendWeekMenu(List<Coach> coaches) {
        List<String> recommendedCategories = new ArrayList<>();
        for (int dayIdx = 0; dayIdx < WEEKDAYS ; dayIdx++) {
            recommendDayCategory(recommendedCategories);
            String todayCategory = recommendedCategories.get(dayIdx);
            recommendDayMenuToCoaches(coaches, todayCategory);
        }
        return recommendedCategories;
    }
    private void recommendDayMenuToCoaches(List<Coach> coaches, String recommendedDayCategory) {
        coaches.forEach((coach)-> recommendMenuToCoach(coach, recommendedDayCategory));
    }
}

