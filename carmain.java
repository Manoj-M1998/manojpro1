import java.util.Scanner;

public class carmain {
    public static void main(String[] args) {
        int carmodel = 0, cnt, costc = 0, costo = 0, cost = 0, costr = 0;
        int f = 0, total = 0, emi4 = 0, emi7 = 0;
        String x[] = new String[5];
        int y[]=new int[5];
        int mp[]=new int[]{1,1,1,1,1};
        int  payment = 0;
        boolean mi;
        Scanner in = new Scanner(System.in);
        System.out.println("car type \n1.hatchback \n2.saloon \n3.estate");
        System.out.println("enter number to see price");

        //Scanner sc=new Scanner(System.in);
        carmodel = in.nextInt();


        if (carmodel == 1) {
            hatchback car = new hatchback();
            System.out.println("model is " + car.getType());
            System.out.println("price is " + car.getPrice());
            costc = car.getPrice();
        } else if (carmodel == 2) {
            saloon car = new saloon();
            System.out.println("model is " + car.getType());
            System.out.println("price is " + car.getPrice());
            costc = car.getPrice();
        } else if (carmodel == 3) {
            estate car = new estate();
            System.out.println("model is " + car.getType());
            System.out.println("price is " + car.getPrice());
            costc = car.getPrice();
        } else {
            System.out.println("car not available");


        }
        System.out.println("\nextra options");

        int cls = 45000;
        int sn = 5500;
        int ps = 10000;
        int bc = 350;
        int ss = 1000;
        System.out.println("---------------Optional charges--------------");
        System.out.println("1.Set of luxury seats-----:" + cls);
        System.out.println("2.Parking sensors --------:" + ps);
        System.out.println("3.Satellite Navigation ---:" + sn);
        System.out.println("4.Bluetooth Connectivity -:" + bc);
        System.out.println("5.Sound System -----------:" + ss + "\n");
        System.out.println("To instal optional press respective numbers and then enter if not press 6 or above");

        int A[] = new int[]{45000, 5500, 10000, 350, 1000};
        int B[] = new int[]{0, 0, 0, 0, 0};
        String C[] = new String[]{"Set of luxury seats:","Parking sensors :","Satellite Navigation :","Bluetooth Connectivity :","Sound System :"};
        cnt = in.nextInt();
        while (cnt < 6) {
            if (B[cnt - 1] != 1) {
                B[cnt - 1] = 1;
                costo = costo + A[cnt - 1];
            }
            cnt = in.nextInt();
        }
        boolean z;
        System.out.println("Are you an regular customer\n enter true or false");
        //System.out.println("1.Yes\n2.No");
        mi = in.nextBoolean();
        if (mi) {
            System.out.println("Buying new one by returning old one?\n if yes enter true or else false");
            z = in.nextBoolean();
            if (z) {
                System.out.println("car type which you would like trade in \n1.hatchback \n2.saloon \n3.estate");
                System.out.println("enter number to see price");
                carmodel = in.nextInt();


                if (carmodel == 1) {
                    hatchback car = new hatchback();
                    System.out.println("price is " + car.getReturnPrice());
                    costr = car.getReturnPrice();
                } else if (carmodel == 2) {
                    saloon car = new saloon();
                    System.out.println("price is " + car.getReturnPrice());
                    costr = car.getReturnPrice();
                } else if (carmodel == 3) {
                    estate car = new estate();
                    System.out.println("price is " + car.getReturnPrice());
                    costr = car.getReturnPrice();

                } else {
                    System.out.println("Car is not available for exchange");

                }
            }
            else
            {
                System.out.println("");
            }
        }
        else
        {
            System.out.println("--------We welcome you----------");
        }


        System.out.println("Car price is ----------:" + costc);
        System.out.println("Optional cost is ------:" + costo);
        if (mi) {
            f = (costc + costo) / 10;
            System.out.println("Regular customer discount -----:" + f);
        } else {
            f = (costc + costo) / 20;
            System.out.println("Regular customer discount ------:" + f);
        }
        System.out.println("Exchange of car discount -:" + costr);
        cost = costc + costo - f - costr;
        System.out.println("total cost price is ------:" + cost);
        System.out.println("Way of paying money\n1.Full payment\n2.Emi");
        payment = in.nextInt();
        int year = 0;
        if (payment == 1) {
            System.out.println("total cost price is -------:" + cost);
            //total = cost - cost / 100;
            System.out.println("Your cash back amount is --:" + cost / 100);
            System.out.println("Do you need offered optional extras  instead of cash back");
            System.out.println("1.yes\n2.No");
            int hr = in.nextInt();
            if (hr == 1) {
                System.out.println("Select Your optional extras");
                int j = 0;
                int hm = 0;
                int lm = 1;
                while (j < 5) {
                    if (B[j] != 1 && A[j] < cost / 100) {
                        System.out.println(lm+"."+C[j] + "" + A[j]);
                        x[hm] = C[j];
                        y[hm] = A[j];
                        mp[hm] = 0;
                        hm++;
                        lm++;
                    }
                    j++;
                }
                int lv = in.nextInt();
                if (mp[lv-1] == 0) {
                    System.out.println(x[lv-1] + " is added instead of cash back");
                    mp[lv - 1] = 0;
                } else {
                    System.out.println("Invalid input");
                }

            } else
                System.out.println("Your Cash back is :" + (cost / 100));
            //System.out.println("Total amount to be paid is :" + total);
        }

        else {
            System.out.println("Enter duration");
            year = in.nextInt();
            if (year >= 4 && year <7) {
                System.out.println("total cost price is:" + cost);
                System.out.println("Since ur duration is less than 7 years ur interest is 0%");
                total = cost;
                emi4 = cost / (year * 12);
                System.out.println("Equal Monthly installments for 4years is :" + emi4);
                System.out.println("Total amount to be paid is :" + total);
            } else if (year >= 7) {
                System.out.println("total cost price is:" + cost);
                System.out.println("Since ur duration is greater than 5 years ur interest is 5% for total amount");
                System.out.println("Interest for " + cost + " is :" + (cost / 20));
                total = cost + cost / 20;
                emi7 = cost / (year * 12);
                System.out.println("Equal Monthly installments for 7years is :" + emi7);
                System.out.println("Total amount to be paid is :" + total);
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }
    }
}
