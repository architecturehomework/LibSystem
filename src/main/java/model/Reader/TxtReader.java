package model.Reader;

import java.io.*;

public class TxtReader extends Reader {
    @Override
    public String getText(String filePath) throws IOException {
        File file = new File(filePath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String str = "";
        String line = br.readLine();
        while (line != null) {
            str += line;
            line = br.readLine();
        }
        br.close();

        return str;
    }
}
