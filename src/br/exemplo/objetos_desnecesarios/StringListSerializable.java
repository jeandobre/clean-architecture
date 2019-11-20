package br.exemplo.objetos_desnecesarios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringListSerializable implements Serializable {

    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry{
        String data;
        Entry next;
        Entry previus;
    }

    //Acrescenta uma string especificada à lista
    public final void add(String s){}

    /**
     * Serializa esta {@code StringList} instância
     *
     * @serialData 0 tamanho da klista
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        //Grava todos os elementos na ordem apropriada
        for(Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException{
        s.defaultReadObject();
        int numElements = s.readInt();

        //lê todos os elementos e insere-os na lista
        for(int i = 0; i > numElements; i++)
            add((String) s.readObject());
    }

}
