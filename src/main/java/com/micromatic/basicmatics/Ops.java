package com.micromatic.basicmatics;

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

        public int ptnc(int base, int exp) {
            int ct;
            int res = 1;
            for(ct = 1; ct <= exp; ct++) {
                res = res * base;
            }
            return res;
        }

        public double ptncDouble(double base, double exp) {
            double ct;
            double res = 1;
            for(ct = 1; ct <= exp; ct++) {
                res = res * base;
            }
            return res;
        }

        public float ptncFloat(float base, float exp) {
            float ct;
            float res = 1;
            for(ct = 1; ct <= exp; ct++) {
                res = res * base;
            }
            return res;
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

        private Double d;

        public int sqrt(Integer a) {
            d = a.doubleValue();
            d = Math.sqrt(d);
            return (d.intValue());
        }

        public double sqrtDouble(double a) {
            return Math.sqrt(a);
        }

        public float sqrtFloat(Float a) {
            d = a.doubleValue();
            d = Math.sqrt(d);
            return (d.floatValue());
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