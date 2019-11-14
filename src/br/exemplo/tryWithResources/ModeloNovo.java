package br.exemplo.tryWithResources;

import java.io.*;

/**
 * Usar sempre o try-with-resouces ao invés do try-finally
 * para trabalhar com recursos que devem ser fechados.
 */
public class ModeloNovo {

    //try-with-resources - a melhor maneira de fechar os recursos!
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    //try-with-resources em diversos recursos - rápido e fácil
    static void copy(String src, String dst) throws IOException{
        try(InputStream in = new FileInputStream(src)){

            OutputStream out = new FileOutputStream(dst);
            byte[] buf = new byte[10];
            int n;
            while((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);

        }
    }

    //try-with-resources com a cláusula catch
    static String firstLineOfFile(String path, String defaultVal){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        } catch (IOException e){
            return defaultVal;
        }
    }
}
