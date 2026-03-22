package com.example.session7.exercise07;

public class Fraction {
    // 1. Tính Đóng gói (Encapsulation): Giấu trạng thái bên trong bằng 'private'
    private int numerator;
    private int denominator;

    @Override
    public String toString() {
        if (this.denominator == 1)
            return String.valueOf(this.numerator);
        if (this.numerator == 0)
            return "0";
        return this.numerator + "/" + this.denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không được phép bằng 0.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.simplify();
    }

    // Nghiệp vụ: Cộng, Trừ, Nhân, Chia
    // Mỗi hàm trả về một Object Fraction MỚI, không làm thay đổi Object hiện tại
    public Fraction add(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDemominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDemominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDemominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDemominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDemominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDemominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Không thể chia cho phân số có tử số bằng 0.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDemominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDemominator);
    }

    private void simplify() {
        int gcd = findGCD(Math.abs(this.numerator), Math.abs(this.denominator));
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(a, a % b);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không được phép bằng 0.");
        }
        this.denominator = denominator;
        this.simplify();
    }

}
