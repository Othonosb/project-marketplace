// Vamos testar o programa antes de colocar para produção.
package view;

import model.Producer;

public class Test {

    public static void main(String[] args) {
        Producer ps4 = new Producer("PlayStation 4", 1899.99);
        Producer xbox360 = new Producer("Xbox 360", 1599.99);

        System.out.println(ps4);
        System.out.println(xbox360);
    }
}
