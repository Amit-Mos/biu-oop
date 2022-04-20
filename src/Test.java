import java.util.Random;

public class Test {
    public static Expression_David e_David;
    public static Expression_David finish_David;

    public static Expression randomExpression(String[] array) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(12);
        Expression e;
        if (randomNumber == 11) {
            e = new Val(true);
            e_David = new Val_David(true);
        } else if (randomNumber == 10) {
            e = new Val(false);
            e_David = new Val_David(false);
        } else {
            e = new Var(array[randomNumber]);
            e_David = new Var_David(array[randomNumber]);
        }
        return e;
    }

    public static Expression createExpression(){
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf((char)(97 + i));
        }
        Expression finish = new Val(true);
        finish_David = new Val_David(true);
        for (int j = 0; j < 2; j++) {
            Expression e = randomExpression(array);

            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                int randomNumber1 = rand.nextInt(7);
                int randomNumber2 = rand.nextInt(7);
                int randomNumber3 = rand.nextInt(10);
                switch(randomNumber1) {
                    case 0:
                        if (randomNumber2 == 0) {
                            e = new And(e, e);
                            e_David = new And_David(e_David, e_David);
                        } else if (randomNumber2 == 1) {
                            e = new And(new Val(true), e);
                            e_David = new And_David(new Val_David(true), e_David);
                        } else if (randomNumber2 == 2) {
                            e = new And(e, new Val(true));
                            e_David = new And_David(e_David, new Val_David(true));
                        } else if (randomNumber2 == 3) {
                            e = new And(e, new Val(false));
                            e_David = new And_David(e_David, new Val_David(false));
                        } else if (randomNumber2 == 4) {
                            e = new And(new Val(false), e);
                            e_David = new And_David(new Val_David(false), e_David);
                        } else if (randomNumber2 == 5) {
                            e = new And(e, new Var(array[randomNumber3]));
                            e_David = new And_David(e_David, new Var_David(array[randomNumber3]));
                        } else if (randomNumber2 == 6) {
                            e = new And(new Var(array[randomNumber3]), e);
                            e_David = new And_David(new Var_David(array[randomNumber3]), e_David);
                        }
                        break;
                    case 1:
                        if (randomNumber2 == 0) {
                            e = new Or(e, e);
                            e_David = new Or_David(e_David, e_David);
                        } else if (randomNumber2 == 1) {
                            e = new Or(new Val(true), e);
                            e_David = new Or_David(new Val_David(true), e_David);
                        } else if (randomNumber2 == 2) {
                            e = new Or(e, new Val(true));
                            e_David = new Or_David(e_David, new Val_David(true));
                        } else if (randomNumber2 == 3) {
                            e = new Or(e, new Val(false));
                            e_David = new Or_David(e_David, new Val_David(false));
                        } else if (randomNumber2 == 4) {
                            e = new Or(new Val(false), e);
                            e_David = new Or_David(new Val_David(false), e_David);
                        } else if (randomNumber2 == 5) {
                            e = new Or(e, new Var(array[randomNumber3]));
                            e_David = new Or_David(e_David, new Var_David(array[randomNumber3]));
                        } else if (randomNumber2 == 6) {
                            e = new Or(new Var(array[randomNumber3]), e);
                            e_David = new Or_David(new Var_David(array[randomNumber3]), e_David);
                        }
                        break;
                    case 2:
                        if (randomNumber2 == 0) {
                            e = new Xor(e, e);
                            e_David = new Xor_David(e_David, e_David);
                        } else if (randomNumber2 == 1) {
                            e = new Xor(new Val(true), e);
                            e_David = new Xor_David(new Val_David(true), e_David);
                        } else if (randomNumber2 == 2) {
                            e = new Xor(e, new Val(true));
                            e_David = new Xor_David(e_David, new Val_David(true));
                        } else if (randomNumber2 == 3) {
                            e = new Xor(e, new Val(false));
                            e_David = new Xor_David(e_David, new Val_David(false));
                        } else if (randomNumber2 == 4) {
                            e = new Xor(new Val(false), e);
                            e_David = new Xor_David(new Val_David(false), e_David);
                        } else if (randomNumber2 == 5) {
                            e = new Xor(e, new Var(array[randomNumber3]));
                            e_David = new Xor_David(e_David, new Var_David(array[randomNumber3]));
                        } else if (randomNumber2 == 6) {
                            e = new Xor(new Var(array[randomNumber3]), e);
                            e_David = new Xor_David(new Var_David(array[randomNumber3]), e_David);
                        }
                        break;
                    case 3:
                        if (randomNumber2 == 0) {
                            e = new Nand(e, e);
                            e_David = new Nand_David(e_David, e_David);

                        } else if (randomNumber2 == 1) {
                            e = new Nand(new Val(true), e);
                            e_David = new Nand_David(new Val_David(true), e_David);

                        } else if (randomNumber2 == 2) {
                            e = new Nand(e, new Val(true));
                            e_David = new Nand_David(e_David, new Val_David(true));

                        } else if (randomNumber2 == 3) {
                            e = new Nand(e, new Val(false));
                            e_David = new Nand_David(e_David, new Val_David(false));

                        } else if (randomNumber2 == 4) {
                            e = new Nand(new Val(false), e);
                            e_David = new Nand_David(new Val_David(false), e_David);

                        } else if (randomNumber2 == 5) {
                            e = new Nand(e, new Var(array[randomNumber3]));
                            e_David = new Nand_David(e_David, new Var_David(array[randomNumber3]));

                        } else if (randomNumber2 == 6) {
                            e = new Nand(new Var(array[randomNumber3]), e);
                            e_David = new Nand_David(new Var_David(array[randomNumber3]), e_David);

                        }
                        break;
                    case 4:
                        if (randomNumber2 == 0) {
                            e = new Nor(e, e);
                            e_David = new Nor_David(e_David, e_David);

                        } else if (randomNumber2 == 1) {
                            e = new Nor(new Val(true), e);
                            e_David = new Nor_David(new Val_David(true), e_David);

                        } else if (randomNumber2 == 2) {
                            e = new Nor(e, new Val(true));
                            e_David = new Nor_David(e_David, new Val_David(true));

                        } else if (randomNumber2 == 3) {
                            e = new Nor(e, new Val(false));
                            e_David = new Nor_David(e_David, new Val_David(false));

                        } else if (randomNumber2 == 4) {
                            e = new Nor(new Val(false), e);
                            e_David = new Nor_David(new Val_David(false), e_David);

                        } else if (randomNumber2 == 5) {
                            e = new Nor(e, new Var(array[randomNumber3]));
                            e_David = new Nor_David(e_David, new Var_David(array[randomNumber3]));

                        } else if (randomNumber2 == 6) {
                            e = new Nor(new Var(array[randomNumber3]), e);
                            e_David = new Nor_David(new Var_David(array[randomNumber3]), e_David);

                        }
                        break;
                    case 5:
                        if (randomNumber2 == 0) {
                            e = new Xnor(e, e);
                            e_David = new Xnor_David(e_David, e_David);

                        } else if (randomNumber2 == 1) {
                            e = new Xnor(new Val(true), e);
                            e_David = new Xnor_David(new Val_David(true), e_David);

                        } else if (randomNumber2 == 2) {
                            e = new Xnor(e, new Val(true));
                            e_David = new Xnor_David(e_David, new Val_David(true));

                        } else if (randomNumber2 == 3) {
                            e = new Xnor(e, new Val(false));
                            e_David = new Xnor_David(e_David, new Val_David(false));

                        } else if (randomNumber2 == 4) {
                            e = new Xnor(new Val(false), e);
                            e_David = new Xnor_David(new Val_David(false), e_David);

                        } else if (randomNumber2 == 5) {
                            e = new Xnor(e, new Var(array[randomNumber3]));
                            e_David = new Xnor_David(e_David, new Var_David(array[randomNumber3]));

                        } else if (randomNumber2 == 6) {
                            e = new Xnor(new Var(array[randomNumber3]), e);
                            e_David = new Xnor_David(new Var_David(array[randomNumber3]), e_David);

                        }
                        break;
                    case 6:
                        e = new Not(e);
                        e_David = new Not_David(e_David);
                        break;
                }
            }
            int randomNumber4 = rand.nextInt(5);
            switch (randomNumber4) {
                case 0:
                    finish = new And(finish, e);
                    finish_David = new And_David(finish_David, e_David);
                    break;
                case 1:
                    finish = new Or(finish, e);
                    finish_David = new Or_David(finish_David, e_David);

                    break;
                case 2:
                    finish = new Xor(finish, e);
                    finish_David = new Xor_David(finish_David, e_David);
                    break;
                case 3:
                    finish = new Xnor(finish, e);
                    finish_David = new Xnor_David(finish_David, e_David);
                    break;
                case 4:
                    finish = new Nand(finish, e);
                    finish_David = new Nand_David(finish_David, e_David);
                    break;
                case 5:
                    finish = new Nor(finish, e);
                    finish_David = new Nor_David(finish_David, e_David);
                    break;
            }
        }
        return finish;
    }

    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            Expression amit = createExpression();
            if (amit.simplify().toString().equals(finish_David.simplify().toString())) {
                System.out.println(i);
                System.out.println("Original:     " + amit.toString());
                System.out.println("Amit:     " + amit.simplify().toString());
                System.out.println("David:     " + finish_David.simplify().toString());
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
            } else {
                counter++;
            }
        }
        System.out.println(counter);
    }

}
