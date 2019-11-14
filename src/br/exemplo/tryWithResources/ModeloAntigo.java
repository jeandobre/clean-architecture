package br.exemplo.tryWithResources;

import java.io.*;

public class ModeloAntigo {

    //Nao usar mais
    //try-finally - Não é mais a melhor maneira de fechar os recursos!
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            return br.readLine();
        } finally {
            br.close();
        }
    }

    //try-finally é feito quando usado em mais de um recurso!
    static void copy(String src, String dst) throws IOException{
        InputStream in = new FileInputStream(src);
        try{
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[10];
                int n;
                while((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
