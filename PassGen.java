import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream result = new ByteArrayOutputStream();

        byte[] mass = new byte[16];
        final String symbolSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        byte[] bytes = symbolSet.getBytes();
        Random random = new Random();
        boolean chek = true;

        while (chek){

            for (int i = 0; i < mass.length; i++) {
                mass[i] = bytes[random.nextInt(symbolSet.length() - 1)];
            }

            String string = new String(mass);

            if(string.matches(".{0,}[A-Z]{1,}.{0,}") && string.matches(".{0,}[a-z]{1,}.{0,}") && string.matches(".{0,}[0-9]{1,}.{0,}")) {
                chek = false;
                try {
                    result.write(mass);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
