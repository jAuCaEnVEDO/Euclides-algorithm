package mcd;

import java.util.ArrayList;

public class MaxCom {

    private ArrayList<Integer> numbers = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
    public ArrayList<Integer> comb = new ArrayList<>();
    public ArrayList<Integer> enteros = new ArrayList<>();

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
    }

    public void printa(ArrayList<Integer> b) {
        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) + " ");
        }
    }

    public void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void organice() {
        int temp;
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
    }

    public String mcd() {
        int mcd = numbers.get(0);
        int res, cos, counter = 0, resA = 1, divf = 0, cosf = 0;
        String pantalla = "Paso 1: <br><br>Se halla el MCD mediante el algoritmo de Euclides.<br><br>";
        String pantalla2 = "Paso 2: <br><br>Se despejan los residuos existentes en las combinaciones<br>lineales anteriores. (Exceptuando aquellos que son cero)<br><br>";
        String pantalla4 = "Paso 3: <br><br>Con las equivalencia halladas en el paso 2, remplazamos estos<br>valores para así llegar a una combinación lineal del mcd.<br><br>";
        String line1 = "";
        for (int i = 1; i < numbers.size(); i++) {
            int div = numbers.get(i);
            if (mcd == 0) {
                pantalla += "Como la division entre 0 no esta definida el MCD es 1";
                return pantalla;
            }
            res = div % mcd;
            cos = div / mcd;
            pantalla += div + " = " + "(" + mcd + ")" + cos + "+" + res + "<br>";
            ArrayList<Integer> n = new ArrayList<>();
            if (res == 0) {
                //pantalla += "<br>";
            } else {
                counter++;
                n.add(0, res);
                n.add(1, div);
                n.add(2, -cos);
                n.add(3, mcd);
                matriz.add(n);
                enteros.add(res);
                enteros.add(div);
                enteros.add(mcd);
                pantalla2 += res + "=" + div + "" + "+" + "(" + (-cos) + ")" + "" + mcd + "<br>";
                line1 = res + "=" + div + "" + "+" + "(" + (-cos) + ")" + "" + mcd + "<br>";
                numbers.set(i, mcd);
                mcd = res;
                i--;
            }
            divf = div;
            cosf = cos;
            resA = res;
        }
        pantalla4 += line1;
        for (int i = matriz.size() - 1; i >= 0; i--) {
            for (int j = 1; j < matriz.get(i).size(); j++) {
                if (i == matriz.size() - 1) {

                    comb.add(matriz.get(i).get(j));
                } else {
                    for (int k = 0; k < comb.size(); k++) {
                        if (comb.get(k) == matriz.get(i).get(0)) {
                            if (k != 0) {
                                int temp = comb.get(k - 1);
                                comb.remove(k);
                                comb.remove(k - 1);
                                comb.add(temp);
                                comb.add(matriz.get(i).get(1));
                                comb.add(matriz.get(i).get(2) * temp);
                                comb.add(matriz.get(i).get(3));
                            } else {
                                comb.remove(k);
                                comb.add(matriz.get(i).get(1));
                                comb.add(matriz.get(i).get(2));
                                comb.add(matriz.get(i).get(3));
                            }
                            for (int l = 0; l < comb.size(); l++) {
                                for (int m = 0; m < comb.size(); m++) {
                                    if (comb.get(l) == comb.get(m) && m != l) {
                                        pantalla4 += add();
                                        printa(comb);
                                        System.out.println();
                                        if (l == 0 && m != 0) {

                                            System.out.println("Hay dos 1" + comb.get(m));
                                            int esct = comb.get(m - 1);
                                            int temp = comb.get(m);
                                            delete(comb, esct);
                                            delete(comb, temp);
                                            comb.add(esct + 1);
                                            comb.add(temp);
                                        }
                                        if (m == 0 && l != 0) {
                                            System.out.println("Hay dos 2" + comb.get(m));
                                            int esct = comb.get(l - 1);
                                            int temp = comb.get(l);
                                            delete(comb, esct);
                                            delete(comb, temp);
                                            comb.add(esct + 1);
                                            comb.add(temp);
                                        }
                                        if (m != 0 && l != 0) {
                                            System.out.println("Hay dos 3" + comb.get(m));
                                            int esct = comb.get(m - 1);
                                            int esct2 = comb.get(l - 1);
                                            int temp = comb.get(m);
                                            delete(comb, esct);
                                            delete(comb, esct2);
                                            delete(comb, temp);
                                            comb.add(esct + esct2);
                                            comb.add(temp);
                                        }
                                    }
                                }
                            }
                            pantalla4 += add();
                            printa(comb);
                            System.out.println();
                        }
                    }
                }
            }
        }
        if (counter == 0) {
            String pantalla3 = "";
            for (int i = 0; i < numbers.size(); i++) {
                if (i == 0) {
                    pantalla3 += numbers.get(i) + "=" + numbers.get(i) + "(1)";
                } else {
                    pantalla3 += " + " + numbers.get(i) + "(0)";
                }
            }

            return "Todos los numeros ingresados son divisibles por el numero<br>menor de ellos, el cual podemos expresar como combinacion<br>lineal de los todos los numeros.<br>" + pantalla3;
        }
        pantalla += "<br>" + pantalla2;
        pantalla += "<br>" + pantalla4;
        //pantalla += "<p style=color:red;>MCD: " + mcd + "</p>";
        printa(enteros);
        return pantalla;
    }

    private String add() {
        String a = "";
        int b = 0;
        for (int i = 0; i < enteros.size(); i++) {
            if (comb.get(0) == enteros.get(i)) {
                i = enteros.size();
                b++;
            }
        }
        if (b == 0) {
            for (int j = 0; j < comb.size(); j++) {
                if (j % 2 == 0 && (j + 1) < comb.size() && j != 0) {
                    a += " + " + "(" + comb.get(j) + ")" + comb.get(j + 1);
                }
                if (j % 2 == 0 && (j + 1) < comb.size() && j == 0) {
                    a += " = " + "(" + comb.get(j) + ")" + comb.get(j + 1);
                }
            }
        } else {
            for (int j = 0; j < comb.size(); j++) {
                if (j == 0) {
                    a += " = " + "(" + comb.get(j) + ")";
                }
                if (j % 2 != 0 && (j + 1) < comb.size()) {
                    a += " + " + "(" + comb.get(j) + ")" + comb.get(j + 1);
                }
            }
        }
        a += "<br>";
        return a;
    }

    private void delete(ArrayList<Integer> a, int n) {
        for (int i = 0; i < a.size(); i++) {
            if (n == a.get(i)) {
                a.remove(i);
            }
        }
    }
}
