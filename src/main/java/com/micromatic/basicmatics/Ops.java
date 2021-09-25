package com.micromatic.basicmatics;

import static java.lang.Math.pow;

public class Ops {
    public static class Divide {

        public int division(int a, int b) {
            return a / b;
        }

        public float divisionFloat(float a, float b) {
            return a / b;
        }

        public double divisionDouble(double a, double b) {
            return a / b;
        }

        public int divisionRest(int a, int b) {
            return a % b;
        }

        public float divisionFloatRest(float a, float b) {
            return a % b;
        }

        public double divisionDoubleRest(double a, double b) {
            return a % b;
        }
    }

    public static class Mtpl {

        public int mtpl(int a, int b) {
            return a * b;
        }

        public float mtplFloat(float a, float b) {
            return a * b;
        }

        public double mtplDouble(double a, double b) {
            return a * b;
        }
    }

    public static class Potence {

        public int ptnc(Integer base, Integer exp) {
            return (int) pow(base, exp);
        }

        public double ptncDouble(double base, double exp) {
            return pow(base, exp);
        }

        public float ptncFloat(float base, float exp) {
            return (float) pow(base, exp);
        }
    }

    public static class Rest {

        public int rest(int a, int b) {
            return a - b;
        }

        public float restFloat(float a, float b) {
            return a - b;
        }

        public double restDouble(double a, double b) {
            return a - b;
        }
    }

    public static class Sqrt {

        public int sqrt(Integer a) {
            return (int) Math.sqrt(a);
        }

        public double sqrtDouble(double a) {
            return Math.sqrt(a);
        }

        public float sqrtFloat(Float a) {
            return (float) Math.sqrt(a);
        }
    }

    public static class Sume {

        public int sume(int a, int b) {
            return a + b;
        }

        public float sumeFloat(float a, float b) {
            return a + b;
        }

        public double sumeDouble(double a, double b) {
            return a + b;
        }
    }
}