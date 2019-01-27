package model.Reader;

import java.io.IOException;

public abstract class Reader {

    public abstract String getText(String filePath) throws IOException;
}
