package br.edu.ifpb.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Leanderson Coelho
 * Classe responsável por fazer o gerenciamentos dos tokens utilizados para autenticidade na aplicação
 */
public class TokenManager {

    /**
     * Chave que será usado na construção dos tokens
     */
    private static String key = "SECRET_TOKEN";

    /**
     * Chave que será usado para capturar os tokens dos usuários que usurão o serviço
     */
    public static final String TOKEN_HEADER = "Authentication";

    /**
     * Cria um novo token para um usuário que se autentica com login
     * @param usermane Nome do usuário que fez o login e necessita de um token.
     * @return token de acesso a api.
     */
    public static String create(String usermane){
        return Jwts.builder()
                .setSubject(usermane)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    /**
     * Decodificar token
     * @return Retorna o conteúdo de um token que está criptografado.
     */
    public static Jws<Claims> decode(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

}
