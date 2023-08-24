package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private final List<String> hateMenus = new ArrayList<>();
    private final List<String> recommendedMenus = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getHateMenus() {
        return List.copyOf(hateMenus);
    }

    public void addHateMenus(String menu) {
        hateMenus.add(menu);
    }

    public List<String> getRecommendedMenus() {
        return List.copyOf(recommendedMenus);
    }

    public void addRecommendedMenu(String menu) {
        recommendedMenus.add(menu);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", hateMenus=" + hateMenus +
                ", recommendedMenus=" + recommendedMenus +
                '}';
    }
}
