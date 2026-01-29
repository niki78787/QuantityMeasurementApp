package org.example;

import java.util.Objects;

public class QuantityMeasurementApp {

    // ============================
    // UC2: Static Compare Methods
    // ============================

    public static boolean compareFeet(double v1, double v2) {
        return Double.compare(v1, v2) == 0;
    }

    public static boolean compareInches(double v1, double v2) {
        return Double.compare(v1, v2) == 0;
    }

    // ============================
    // UC1: FEET Value Object
    // ============================
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            // UC1: same reference
            if (this == obj) return true;

            // UC1: null comparison
            if (obj == null) return false;

            // UC1: type safety (prevents comparing with String/Integer/etc.)
            if (getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            // UC1: value comparison
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    // ============================
    // UC1: INCHES Value Object
    // ============================
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}