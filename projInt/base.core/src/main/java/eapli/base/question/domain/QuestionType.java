package eapli.base.question.domain;

public enum QuestionType {
    MATCHING("MATCHING"),
    MULTIPLE_CHOICE("MULTIPLE CHOICE"),
    SHORT_ANSWER("SHORT"),
    NUMERICAL("NUMERICAL"),
    MISSING_WORDS("MISSING WORDS"),
    TRUE_FALSE("TRUE/FALSE");

    private final String displayName;

    QuestionType(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    public static QuestionType defineFromString(String value) {
       value = value.replace("#","");
        for (QuestionType questionType : QuestionType.values()) {
            if (questionType.displayName.equalsIgnoreCase(value)) {
                return questionType;
            }
        }
        throw new IllegalArgumentException("No enum constant with display name: " + value);
    }
}
