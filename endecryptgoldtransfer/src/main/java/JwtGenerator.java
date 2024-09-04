import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.security.KeyFactory;
import java.util.HashMap;
import java.util.Map;

public class JwtGenerator {

    public static void main(String[] args) {
        try {
            // Your private key string (in PKCS#8 format)
            String privateKeyString =
                    "-----BEGIN RSA PRIVATE KEY-----\n" +
                    "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWqNgjYBJ1t/GWsyhonDNyuwaxdJPrAE3+l93kgZ6W367vofhG+TpEF10RqnSODzHIIvC3QDm/t0lRekEnsHvhGfdxgThKqeqrTUcObOAHny6CMgv4nAF1QGFTKHif8uNzHUZ1E6Cffn4Ay3YOsPeeI4WngmpF6dYkdlF2nqZw+Gtre6srQU+IaqfARI83k1v4pv3wb9Kr5miBsGGLz+klW1csokjErIhDKp2jdJKiyJdulK1Rb7NoF68VnO9VBzHD81rovmPmrqsMD27ddEeN9rw1VNExYeNdTOEDeUl58GnCRnksZys4PA/u2RGoWm+rt4T+PTOGPSBlYHTMjb1NAgMBAAECggEAKbYgdRbVtYrSU79RajkI03RtY3cbtt30Og8Qy4GJh0rxs3277+Zzl8OCLHBtaaFSTo9B5vJcqrQTk//NhzAI9CcMx3uXurA1fOzdxeQl2GZdaYVypAeJLc2/xFa5ossL5uSNi7994nqSZyTtkB61x64dBGYKh0W42Ip7fmRpP3BS5cWWglNgIdwmHsw7odp/oo4Yza6SphkKvQJy2UmTTpgNVdZnaMsEG/RDtmrqFSZ/7k/hGlExid9quoLDUIcT6mH/n7HOl1gi38X/uA9AsFGBKevm720B8HP4bsqRaALQTKyf+WTtQTBmVAtW9lA4OXgkYOIXPaamIOq5IDaYjwKBgQC6lc1aQJ1FQxA0clAwDfkizHA5g6kHEzeBIi2AIQFbcfYBi1mvegwoOlL3PQiLbFH1MTG2ZVf+OHjmclxMF19i+aUXAJSIsbihDb7bl4key2L+4jVVShU4OeT1JvRqbxn5P6ehIF27oDusyBQzPkZeqkKKeLZX5+SiDioEdBxSHwKBgQDOtYUOucE/CspFb+GzEwa4rLNxbpzJy4zlfvGA+qmxSckD6Zh+jWCDJvPjAKb7ginzTjM4lSKJ1dapLP3HG9hLRGCtZ2YpNpLHiNEvg9CjTzoBv0RovvhHFc5h2AhJT1VjNKX870NWRDwEwZkuKcDJqwqdAc5VBdC2RlOJuKm7EwKBgQCd9VgmAfGiw0WiwOv14r55oU2Yw0eDf9dLcV3HzSlS+0VixVAl6FMGc2nteTQUpJ010HHfkihORgzEOyi8GkVcizAiKxGUL7C4V+SuDrm84j5qvaKdE9ym/wxAJrxgprH8etE07SutPdeHTNMdFqmIVueCRvNHtD+wmgEkSA/5zQKBgGsKQmGyvSg5HS9B1X1Wv+dHvxBhOB2jI04AI20n4FGnJMm64DXAXhbsR+ToBJA/Ahw1BX8qcx0vN56ZZr0BZUrsmKeS4Ks80Fs1NSXGu3al4yLeeb1IDuc4mou+Q+Q6ibv6mm3VNGhqoy3PVtQ52NRVlwRg2AjdHwwUdNPfZT0zAoGBAKb8qwpHK5iRnmNOTdRvhF599aMnj/QNbpOuQEHo0D3d+os7pyN5zBdyFKMNoaN1s5YO3w2LajcLzGN0vSoX2i4SpMWOBmLU7+E3icA6yL87+uRLfLa9UEMVn0kuzZjpmmdBVCv8zYMNqXqCkbDUu6pTQP7R3lcp8QIZhZqMapDX\n" +
                    "-----END RSA PRIVATE KEY-----";

            // Convert the private key string to RSAPrivateKey object
            RSAPrivateKey privateKey = getPrivateKeyFromString(privateKeyString);

            // Set custom header
            Map<String, Object> headerClaims = new HashMap<>();
            headerClaims.put("alg", "RS256"); // Algorithm
            headerClaims.put("typ", "JWT"); // Type
            // Create JWT token
            String token = JWT.create()
                    .withHeader(headerClaims) // Set custom header
                    .withIssuer("VCBBOOKING") // Set the issuer
                    .withSubject("your-subject") // Set the subject
                    .withClaim("dataEncr", "qmkD98quwZ8iJabi5tEChuk7IPHzUdEdrMWfZyJ0IrSRfJAANGw8YYlx6aZ0DEr5BkNv6aqmlhLzWGtxLns+q8snh1giohf44XXfFjMnW0yAeMRAGgX/eMpZsF2LWIfl2i6daRiUG4j/qASha5oDcDwKWLKitPsfD7y7hi6dKPPBU1+t40TdU2mkLtION39TyWqPmsINTcMjfVFOVggt0doA4w3b2bKERfwVYNqA9izCXREvEKi5A33tcEYLMr58gaQ6T0gbeI6VYHY1vnIpfQmuIgZE2zAu4fe344W5q3eDGoIOn+4+/nyMEEt+ggAvqGUxpOZYlbBBnV+oWUIs+64FvIVKrxHreV9IuctIK8Tk01RK2+GiK82ulir71VIoKosmigRrMzJimRAwhkpPDYHYBfIDQwMvaX5jWBA0OyoZ0h461KT021LJBcTdwyc8yBcU9myQtcQPeA/Q8lP335Gb40efnxrkc9yyhoggKYnAwP0bBnJeRUgBoA4eQunBsc6bCHzWYntoFHmyApy7gfrnR8HRwnVOWmnsTQyqWm1Unc7HwQ2PhZdwZjiuARCrtcSMTigal4mB9w+kvE6yEPO0sOJfHlVyorvEIRPevi/QG9VZHo02sMnbJpuy/Jh2zb0LfL6lCk5HxlX35MiQ7pPCmreQTGQWc61XAsfDh6Vawu+MssQNvgVdT3WFL80F8Kpk7iyriwyuQ5QQmuzlgz5+Msj1vTWLZLzpkeCX1XikrxIy41S/3UjkxQSg4rt4Nn9LqcPNwKoa2ZgGmRcrnyDYoQOPydd2regPj1gyGA==") // Add custom claims
                    .withIssuedAt(new Date()) // Set issued at time
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // Set expiration time (1 hour in this example)
                    .sign(Algorithm.RSA256(null, privateKey)); // Sign with the private key

            System.out.println("Generated JWT Token: " + token);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to convert a private key string to RSAPrivateKey
    private static RSAPrivateKey getPrivateKeyFromString(String key) throws Exception {
        String privateKeyPEM = key.replace("-----BEGIN RSA PRIVATE KEY-----", "")
                .replace("-----END RSA PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }
}
