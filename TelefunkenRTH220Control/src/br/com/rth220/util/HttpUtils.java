package br.com.rth220.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Classe auxiliar que contém os métodos para as chamadas HTTP à API Rest.
 */

public class HttpUtils {

    private static HttpURLConnection conexao;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private static int codigoResposta;
    private static String retorno;
    private static String ip = "192.168.0.93";
    private static String endpoint = "http://"+ip+":8080"; //Endereço de rede e porta configurados no raspberry

    // É desejavel que o endereço ip do servidor (raspberry) seja definido como fixo ou fixado no DHCP para facilitar a configuração.
    // Se este endereço mudar, o app perderá a capacidade de se comunicar com o raspberry e terá que ser alterado aqui para que volte a funcionar.
    // A porta é escolhida na configuração do software no raspberry. Por padrão foi usada a 8080. No raspberry é o arquivo run.py

    public static void setEndpoint(String s) {
        ip = s;
        endpoint = "http://"+ip+":8080";
    }

    public static String getEndpoint(){
        return ip;
    }

    public static String defineFrequencia(int freq, String banda) throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/defineFrequencia");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            outputStream = new BufferedOutputStream(conexao.getOutputStream());
            JSONObject json = new JSONObject();
            try {
                json.put("freq", freq);
                json.put("banda", banda);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(outputStream));
            writer.write(json.toString());
            writer.flush();
            writer.close();
            outputStream.close();

            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    public static String defineModo(String modo) throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/defineModo");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            outputStream = new BufferedOutputStream(conexao.getOutputStream());
            JSONObject json = new JSONObject();
            try {
                json.put("modo", modo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(outputStream));
            writer.write(json.toString());
            writer.flush();
            writer.close();
            outputStream.close();

            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    public static String aumentaFrequencia(int step) throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/aumentaFrequencia");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            outputStream = new BufferedOutputStream(conexao.getOutputStream());
            JSONObject json = new JSONObject();
            try {
                json.put("step", step);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(outputStream));
            writer.write(json.toString());
            writer.flush();
            writer.close();
            outputStream.close();

            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    public static String diminuiFrequencia(int step) throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/diminuiFrequencia");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            outputStream = new BufferedOutputStream(conexao.getOutputStream());
            JSONObject json = new JSONObject();
            try {
                json.put("step", step);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(outputStream));
            writer.write(json.toString());
            writer.flush();
            writer.close();
            outputStream.close();

            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    public static String consultaFrequenciaAtual() throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/mostraFrequenciaAtual");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    public static String identificaBanda() throws Exception {
        try {
            URL apiEnd = new URL(endpoint + "/identificaBanda");
            conexao = (HttpURLConnection) apiEnd.openConnection();
            conexao.setDoOutput(true);
            conexao.setRequestMethod("POST");
            conexao.setReadTimeout(15000);
            conexao.setConnectTimeout(15000);
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conexao.connect();

            codigoResposta = conexao.getResponseCode();
            if (codigoResposta < HttpURLConnection.HTTP_BAD_REQUEST) {
                inputStream = conexao.getInputStream();
            } else {
                inputStream = conexao.getErrorStream();
            }
            retorno = converterInputStreamToString(inputStream);
            inputStream.close();

            conexao.disconnect();
        } catch (UnknownHostException e) {
            throw new UnknownHostException();
        }
        return retorno;
    }

    //Método comum
    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br;
            String linha;
            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine())!=null) {
                buffer.append(linha);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}