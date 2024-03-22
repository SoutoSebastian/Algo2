package aed;


class Funciones {
    int cuadrado(int x) {
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        boolean res = false;
        if (n % 2 == 0) {
            res = true;
        }

        return res;
        
    }


            

    boolean esBisiesto(int n) {
        boolean res = false;
        if (n % 4 == 0 && n%100 != 0 || n % 400 == 0) {
            res = true;
        }

        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        if (n != 0) {
        for ( int i = 1; i <= n ; i++) {
            res = res * i;
        }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res;
        if (n < 2) {
            res = 1;
        }
        else {
            res = n * factorialRecursivo(n-1);
        }
        
        return res;
    }

    boolean esPrimo(int n) {
        boolean res = true;
        int Div = 0;
        if (n < 2) {
            res = false;
        }
        for ( int i = 1 ; i<=n ; i++) {
            if (divideA(i,n) == true) {
                Div++;
            }
        }

        if (Div > 2) {
            res = false;
        }
        return res;

    }

    boolean divideA (int d, int n) {
        boolean res = false;
        for ( int i = 0; d*i<=Math.abs(n); i++) {
            if (Math.abs(n) == d*i) {
                res =  true;
            }

        }
        return res;

    }
    

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++ ) {
            res = res + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i]) == true) {
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i = 0; i < numeros.length; i++) {
            if (divideA(2,numeros[i]) == false) {
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;

        for (int i = 0; i<s1.length(); i++) {
            if (s1.length() > s2.length()) {
                res = false;
            }
            else if (s1.charAt(i) != s2.charAt(i)) {
                res = false;
            }
        }


        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;

        for (int i = 0; i<s1.length(); i++) {
            if (s1.length() > s2.length()) {
                res = false;
            }
            else if (s1.charAt(s1.length()-i-1) != s2.charAt(s2.length()-i-1)) {
                res = false;
            }
        }


        return res;

    }

}
