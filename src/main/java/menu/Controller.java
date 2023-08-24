package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
    private final View view;
    private final Scanner scanner = new Scanner(System.in);

    Controller(View view) {
        this.view = view;
    }

    public void start() {
        view.printStartComment();
        List<String> coachNames = readCoachNames();
        List<Coach> coaches = readHateMenus(coachNames);
        System.out.println("coaches = " + coaches);
    }

    private List<Coach> readHateMenus(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            view.printHateMenuInputComment(coachName);
            Coach coach = resolveHateMenuInput(coachName);
            coaches.add(coach);
        }
        return coaches;
    }

    private Coach resolveHateMenuInput(String coachName) {
        Coach coach = new Coach(coachName);
        List<String> hateMenus = parseInputLine();
        try{
            validateHateMenus(hateMenus);
            hateMenus.forEach(coach::addHateMenus);
            return coach;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return resolveHateMenuInput(coachName);
        }
    }

    private void validateHateMenus(List<String> hateMenus) {
        if (hateMenus.size() > 2) throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개 이하 입력해야 합니다.");
    }

    private List<String> parseInputLine() {
        return List.of(scanner.nextLine().split(", "));
    }

    private List<String> readCoachNames() {
        view.printCoachNameInputComment();
        List<String> coachNames = resolveCoachInput();
        return coachNames;
    }

    private List<String> resolveCoachInput() {
        List<String> coachNames = parseInputLine();
        try {
            validateCoachNames(coachNames);
            return coachNames;
        }catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return resolveCoachInput();
        }
    }


    private void validateCoachNames(List<String> coachNames) {
        if (coachNames.size() < 2) throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        if (coachNames.size() > 5) throw new IllegalArgumentException("코치는 최대 5명 이하 입력해야 합니다.");
        coachNames.forEach(this::validateCoachName);
    }

    private void validateCoachName(String coachName) {
        if (coachName.length() < 2) throw new IllegalArgumentException("코치 이름은 최소 2글자 이상 입력해야 합니다.");
        if (coachName.length() > 4) throw new IllegalArgumentException("코치 이름은 최대 4글자 이하 입력해야 합니다.");
    }
}
