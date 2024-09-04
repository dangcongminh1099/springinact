import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainClass {
    public static void main(String[] args)throws Exception {
        encryptAES();
    }

    public static void encryptAES() throws Exception{
        String strSecretKey = "pC1pckFEXTKrzYCOsdrsXq7iF9Lji9WO";
        String salt = "olhAJzTW0Sya9HIE";
        String text = "{\"personalInfo\": {\"cifNo\": \"20008886\",\"mobileNo\": \"0888888896\",\"customerName\": \"NGUYEN HAO NAM\",\"idNumber\": \"034092006672\",\"idType\": \"IC\",\"idIssueDate\": \"2019-07-15\",\"address\": \"66 Ngo 73 Nguyen Trai, Khuong Trung, Th nh Xuan, Ha Noi 66 Ngo 73 Nguyen Trai, K huong Trung, Thanh Xuan, Ha Noi\",\"birthday\": \"1990-01-01\",\"career\": \"N0001\",\"position\": \"A0001\",\"taxCode\": \"1234567890\"},\"bookingInfo\": {\"exRate\": 7698000,\"receiveBranch\": \"04500\",\"dateReceive\": \"2024-08-20\",\"amountXAU\": 10,\"amountVND\": 1000000,\"costCenter\": \"04500\",\"REFNumberIsReserve\": \"D240816004990814\"},\"paymentExpire\": \"2030-08-16T18:15:50\"}";

        byte[] encodedKey = strSecretKey.getBytes();
        byte[] iv = salt.getBytes();
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForEncryption = Cipher.getInstance("AES/CTR/NoPadding");
        aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] byteDataToEncrypt = text.getBytes("UTF-8");
        byte[] byteCipherText = aesCipherForEncryption
                .doFinal(byteDataToEncrypt);
        System.out.println(Base64.toBase64String(byteCipherText));
    }
}
