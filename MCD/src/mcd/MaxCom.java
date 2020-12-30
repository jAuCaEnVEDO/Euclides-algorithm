package mcd;

import java.util.ArrayList;

public class MaxCom {

    private ArrayList<Integer> numbers = new ArrayList<>();

    public MaxCom(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public void print() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

    public void organice() {
        int temp;
        int size = numbers.size();
        for (int i = 0;i < size-1; i++) {
            for(int j = i+1;j<size;j++){
                if(numbers.get(i) > numbers.get(j)){
                    temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
    }

    public String mcd() {
        int mcd = numbers.get(0);
        int res, cos, resA = 1;
        String pantalla = "";
        for (int i = 1; i < numbers.size(); i++) {
            int div = numbers.get(i);
            if (mcd == 0) {
                pantalla += "Como la division entre 0 no esta definida el MCD es 1";
                return pantalla;
            }
            res = div % mcd;
            cos = div / mcd;
            pantalla += div + " = " + "(" + mcd + ")" + cos + "+" + res + "<br>";
            if (res == 0) {
                pantalla += "<br>";
            } else {
                numbers.set(i, mcd);
                mcd = res;
                i--;
            }
            resA = res;
        }
        pantalla += "<p style=color:red;>MCD: " + mcd + "</p>";
        return pantalla;
    }
}
