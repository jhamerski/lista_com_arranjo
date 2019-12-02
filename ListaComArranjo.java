
import java.lang.reflect.Array;
import java.util.Arrays;

public class ListaComArranjo<E> {

    E[] elementos;
    int tamanho;

    public ListaComArranjo(Class<E> classeComp) {
        elementos = (E[]) Array.newInstance(classeComp, 10);
        tamanho = 0;
    }

    public int obterTamanho() {
        return tamanho;
    }

    public E obter(int posicao) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException("índice inválido");
        }
        return elementos[posicao];
    }

    public void adicionar(int posicao, E elemento) {
        if (posicao > tamanho) {
            throw new IllegalArgumentException("índice inválido");
        }

        if (tamanho == elementos.length) {
            E[] novosElementos = Arrays.copyOf(elementos, Math.round(1.5f * tamanho));
            for (int i = 0; i < tamanho; i++) {
                novosElementos[i] = elementos[i];
            }
            elementos = novosElementos;
        }

        for (int i = tamanho; i > posicao; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[posicao] = elemento;
        tamanho++;
    }

    public void remover(int posicao) {
        if (posicao > tamanho) {
            throw new IllegalArgumentException("Lista vazia");
        }
        for (int i = posicao; i < tamanho; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamanho - 1] = null;
        tamanho -= tamanho;
    }

    public int encontrar(E numero) {
        if (elementos == null) {
            throw new IllegalArgumentException("Lista Vazia");
        }

        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == numero) {
                return i + 1;
            }
        }
        return 0;
    }

}
