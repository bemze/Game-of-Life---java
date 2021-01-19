package game.of.life;

public class GameOfLife {

    public static void main(String[] args) {
System.out.println("Random generated");
        char[][] field = new char[10][10];
        boolean go = true;
        int sk = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                

                if (Math.random() < 0.2) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
                 System.out.print(field[i][j] + " ");
            }
            System.out.println("");
                
        }
//
//   
        //originalus paveiksliukas
        System.out.println("Original");

//        char[][] field = {
//            {'.', 'X', '.', 'X'},
//            {'.', '.', 'X', '.'},
//            {'.', 'X', 'X', '.'},
//            {'.', '.', '.', '.'}
//        };
        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[i].length; j++) {

                System.out.print(field[i][j] + " ");

            }

            System.out.println("");

        }
 System.out.println("-----------");
 
 // 3 lygis, sukurtas naujas masyvas, kur bus saugoma informacija ivykusiu ileteraciju
 char[][][] history = new char[50][field.length][field[0].length];
 
        for (int g = 0; g < 50; g++) {
            //paimu nauja lapa ir padedam i stalciuka
            history[g] = field;
            //isspausdina nauja lauka, nuo jo imsime stumdyti kaimynus
            char[][] nextField = new char[field.length][field[0].length]; //0 apsaugo jei nebutu kvadrato formos

            for (int i = 0; i < nextField.length; i++) {// per visas eilutes{
                for (int j = 0; j < nextField[i].length; j++) { // per visus stulpelius{
                    int count = 0; //kaimynu skaiciavimas
                    //patikrinimas
                    //jeigu virs i ir j eilutes nieko nera, kaimynu kiekis padideja
                    if (i > 0) {
                        if (j > 0) {
                            if (field[i - 1][j - 1] == 'X') {
                                count++;
                            }
                        }
                        // tikrinam virs esanti elementa
                        if (field[i - 1][j] == 'X') {
                            count++;
                        }
                        if (j < field[i].length - 1) {
                            if (field[i - 1][j + 1] == 'X') {
                                count++;
                            }
                        }
                    }
                    //tikrinam sone esancius elementus
                    if (j > 0) {
                        if (field[i][j - 1] == 'X') {
                            count++;
                        }
                    }
                    if (j < field[i].length - 1) {
                        if (field[i][j + 1] == 'X') {
                            count++;
                        }
                    }
                    if (i < field.length - 1) {
                        if (j > 0) {
                            if (field[i + 1][j - 1] == 'X') {
                                count++;
                            }

                            // tikrinam virs esanti elementa
                            if (field[i + 1][j] == 'X') {
                                count++;
                            }
                            if (j < field[i].length - 1) {
                                if (field[i + 1][j + 1] == 'X') {
                                    count++;
                                }
                                
                        }
                    }
                        
                    }
                   
                     if (field[i][j] == 'X'){
                            if (count ==2 || count == 3) {
                                nextField[i][j] = 'X';
                            }else {
                                nextField[i][j] = '.';
                            }
                            }else {
                         if (count == 3) {
                                nextField[i][j] = 'X';
                            }else {
                                nextField[i][j] = '.';
                            }
                     }
                }
               
            }
            //2 lygis, palyginimas ar laukai lygus
            //133 eilutei optimizavimas, jei "sutampa" = false - ciklas nutruksta
            int h;
            for ( h = g; h >= 0; h--) { //3 lygio palyginimas
                char[][] f = history[h];
                boolean sutampa = true;
            for (int i = 0; sutampa && i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] != nextField[i][j] ){
                        sutampa = false;
                    }
                }
            }
            if(sutampa){
                break;
            }
            }
            if(h>=0){
                System.out.println("Iteration " + (g + 1) + " same as " + h);
                break;
            }
             field = nextField;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println( (g + 1) + "-----------------");
        }
    }
}