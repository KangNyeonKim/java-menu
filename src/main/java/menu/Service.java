package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static menu.MenuBook.CATEGORIES;
import static menu.MenuBook.CATEGORY_MENUS;

public class Service {
    public static final int CATEGORY_DUPLICATE_LIMIT = 2;

    public void recommendDayCategory(List<String> recommendedCategories) {
        String selectedCategory = selectRandomCategory();
        while (hasMoreThanLimit(selectedCategory, recommendedCategories)) {
            selectedCategory = selectRandomCategory();
        }
        recommendedCategories.add(selectedCategory);
    }

    public String selectRandomCategory() {
        return CATEGORIES.get(Randoms.pickNumberInRange(0, CATEGORIES.size() - 1));
    }

    private boolean hasMoreThanLimit(String selectedCategory, List<String> recommendedCategories) {
        return Collections.frequency(recommendedCategories, selectedCategory) >= CATEGORY_DUPLICATE_LIMIT;
    }

        }
    }

    }
}
