package Base;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author douglas
 */
public class HTTPClient {

    private final String USER_AGENT;

    public HTTPClient() {
        USER_AGENT = "Mozzila/5.0";
    }

    public String get(String url) throws Exception {
        URL obj;
        HttpsURLConnection conexao;
        String output, linhaInput, parametrosURL;
        BufferedReader input;
        DataOutputStream escrita;
        StringBuilder resposta;
        int condigoResposta;

        // criando URL
        obj = new URL(url);

        // adicionando header
        conexao = (HttpsURLConnection) obj.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setRequestProperty("User-Agent", USER_AGENT);
        conexao.setRequestProperty("Accept-Language", "en-US,en;q=0.5,pt-BR,pt;q=0.8");

        //parametrosURL = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // enviando requisicao post
        // conexao.setDoOutput(true);
        // escrita = new DataOutputStream(conexao.getOutputStream());
        //escrita.writeBytes(parametrosURL);
        //escrita.flush();
        //escrita.close();
        // recebendo resposta
        condigoResposta = conexao.getResponseCode();
        output = "Enviando requisição GET para URL: " + url
                //+ "Parametros POST: " + parametrosURL
                + "\nCódigo de Resposta: " + Integer.toString(condigoResposta) + "\n\n";

        input = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

        resposta = new StringBuilder();

        while ((linhaInput = input.readLine()) != null) {
            resposta.append(linhaInput);
            resposta.append("\n");
        }

        input.close();

        output += resposta.toString();

        return output;
    }

}
