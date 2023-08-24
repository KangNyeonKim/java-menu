package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static menu.MenuBook.CATEGORIES;

public class Service {
    public static final int CATEGORY_DUPLICATE_LIMIT = 2;

    public void recommendDayCategory(List<String> recommendedCategories) {
        String selectedCategory = selectRandomCategory();
        try{
            validDuplicate(selectedCategory, recommendedCategories);
            recommendedCategories.add(selectedCategory);
        }catch (IllegalStateException e) {
            recommendDayCategory(recommendedCategories);
        }
    }

    public String selectRandomCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(0, CATEGORIES.size() - 1));
    }

    private void validDuplicate(String selectedCategory, List<String> recommendedCategories) {
        if (hasMoreThanLimit(selectedCategory, recommendedCategories)){
            throw new IllegalStateException("카테고리가 중복 제한을 초과하여 선정되었습니다.");
        }
    }

    private boolean hasMoreThanLimit(String selectedCategory, List<String> recommendedCategories) {
        return Collections.frequency(recommendedCategories, selectedCategory) >= CATEGORY_DUPLICATE_LIMIT;
    }
}
