package com.preventDiabet.GatewayMicroservice.utils;

public enum DiabetEvaluation {
        NONE ("None"),
        BORDERLINE ("Borderline"),
        IN_DANGER ("In Danger"),
        EARLY_ONSET ("Early Onset");

        private String level;

        DiabetEvaluation(String level) {
            this.level = level;
        }

        public String getLevelInString() {
            return level;
        }
}
