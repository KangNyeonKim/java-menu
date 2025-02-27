package menu;

import java.util.*;

public class MenuBook {
    public static final List<String> CATEGORIES =
            Collections.unmodifiableList(List.of("일식", "한식", "중식", "아시안", "양식"));
    public static final Map<String, List<String>> CATEGORY_MENUS;

    static {
        Map<String, List<String>> categoryMenuMap = new HashMap<>();
        initCategoryMenuMap(categoryMenuMap);
        CATEGORY_MENUS = Collections.unmodifiableMap(categoryMenuMap);
    }

    private static void initCategoryMenuMap(Map<String, List<String>> categoryMenuMap) {
        categoryMenuMap.put("일식", Collections.unmodifiableList(
                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        ));
        categoryMenuMap.put("한식", Collections.unmodifiableList(
                List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        ));
        categoryMenuMap.put("중식", Collections.unmodifiableList(
                List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        ));
        categoryMenuMap.put("아시안", Collections.unmodifiableList(
                List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
        ));
        categoryMenuMap.put("양식", Collections.unmodifiableList(
                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")
        ));
    }
}
