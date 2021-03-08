//Програма за криптиране и декриптиране на текст с подаден ключ
package routecipher;

public class RouteCipherTest
{
    public static void main(String[] args)
    {
        RouteCipher object = new RouteCipher(4);
        String text = "THIS IS THE PLAIN TEXT";
        String encrypt = object.encrypt(text);
        System.out.println(encrypt);

        text = "TIEIXTXXEAHSIHSPNTLT";
        String decrypted = object.decrypt(text);
        System.out.println(decrypted);

        RouteCipher object2 = new RouteCipher(-4);
        text = "THIS IS THE PLAIN TEXT";
        encrypt = object2.encrypt(text);
        System.out.println(encrypt);

        text = "XEAHSIHTIEIXTXTLTSPN";
        decrypted = object2.decrypt(text);
        System.out.println(decrypted);

        RouteCipher object3 = new RouteCipher(5);
        text = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        encrypt = object3.encrypt(text);
        System.out.println(encrypt);

        text = "ATSYVNTEDXXTEANITROBHSOESPOEHOMEIUB";
        decrypted = object3.decrypt(text);
        System.out.println(decrypted);

        RouteCipher object4 = new RouteCipher(-5);
        text = "ABORT THE MISSION, YOU HAVE BEEN SPOTTED";
        encrypt = object4.encrypt(text);
        System.out.println(encrypt);

        text = "XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI";
        decrypted = object4.decrypt(text);
        System.out.println(decrypted);
    }
}
