package menu;

import java.util.List;

public class View {
    public void printStartComment() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printCoachNameInputComment() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printHateMenuInputComment(String coachName) {
        System.out.println();
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public void printResult(List<Coach> coaches, List<String> categories) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(buildCategoryLine(categories));
        for (Coach coach : coaches) {
            System.out.println(buildResultLine(coach));
        }
    }

    private String buildResultLine(Coach coach) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ").append(coach.getName());
        for (String recommendedMenu : coach.getRecommendedMenus()) {
            sb.append(" | ").append(recommendedMenu);
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String buildCategoryLine(List<String> categories) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 카테고리");
        for (String category : categories) {
            sb.append(" | ").append(category);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void printEndMessage() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");

    }
}
