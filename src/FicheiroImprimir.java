package POOTrabalho.src;

import java.io.*;

public class FicheiroImprimir {

    public int guardaEstado(String nomeFicheiro) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fos = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            return 1;
        } catch (IOException e) {
            return 2;
        }
        return 0;
    }

    public static Vizinhanca carregaDados(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(file);
        Vizinhanca gfm = (Vizinhanca) ois.readObject();
        ois.close();
        return gfm;
    }
}
