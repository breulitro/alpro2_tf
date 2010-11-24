package pucrs.bst;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

//TODO: pode alterar as classes fornecidas pelo professor?
public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root; //raiz

    private static final class Node<T> implements Serializable{

        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        private T item;

        public Node(T element) {
            parent = null;
            left = null;
            right = null;
            item = element;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> n) {
            right = n;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> n) {
            left = n;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> n) {
            parent = n;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T element) {
            item = element;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(E item) {
        root = new Node<E>(item);
    }

    public boolean contains(E element) {
        Node<E> nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    private Node<E> searchNodeRef(E element, Node<E> target) {
        int r;
        if (element == null || target == null) {
            return null;
        }
        r = target.getItem().compareTo(element);
        if (r == 0) {
            return target;
        } else if (r > 0) {
            return searchNodeRef(element, target.getLeft());
        } else {
            return searchNodeRef(element, target.getRight());
        }
    }

    public void add(E element) {
        Node<E> aux = new Node<E>(element);
        if (root == null) {
            root = aux;
            return;
        }
        Node<E> atual = root;
        boolean inseriu = false;
        while (!inseriu) {
            int comp = atual.getItem().compareTo(element);
            if (comp < 0) {
                // Novo no' deve ser inserido na subarvore da direita
                if (atual.getRight() == null) {
                    atual.setRight(aux);
                    aux.setParent(atual);
                    inseriu = true;
                } else {
                    atual = atual.getRight();
                }
            } else {
                // Novo no' deve ser inserido na subarvore da esquerda
                if (atual.getLeft() == null) {
                    atual.setLeft(aux);
                    aux.setParent(atual);
                    inseriu = true;
                } else {
                    atual = atual.getLeft();
                }
            }
        }
    }

    /**
     * Remove um elemento da arvore (ponto de entrada)
     * @param item elemento a ser removido
     * @return true se conseguiu remover, false se nao encontrar
     */
    public boolean remove(E item) {
        if (root == null) {
            // Arvore vazia
            return false;
        } else {
            if (root.getItem().compareTo(item) == 0) {
                // Caso especial: removendo a raiz
                // Solucao: transformar em um caso de remover um no
                // com filho a esquerda

                // 1) Cria-se um novo no para ser a raiz temporaria
                Node<E> auxRoot = new Node<E>(null);
                // 2) Adiciona a raiz antiga como filho da esquerda
                auxRoot.setLeft(root);
                // 3) Remove usando o algoritmo normal
                boolean result = remove(root, item, auxRoot);
                // 4) Finalmente, faz a nova raiz ser o no que ficou
                // a esquerda da raiz temporaria
                root = auxRoot.getLeft();
                return result;
            } else {
                // Caso normal: chama o metodo auxiliar recursivo
                return remove(root, item, null);
            }
        }
    }

    /**
     * Remove recursivamente na arvore binaria de pesquisa
     * @param n no atual
     * @param item elemento a ser removido
     * @param parent referencia para o no pai do atual
     * @return true se removeu com sucesso, false se nao encontrou
     */
    private boolean remove(Node<E> n, E item, Node<E> parent) {
        // Obtem resultado da comparacao
        int comp = n.getItem().compareTo(item);
        // Busca o item na subarvore correta
        if (comp > 0) {
            // Item e' menor que o elemento no no'
            if (n.getLeft() != null) {
                // Tem filho a esquerda, chama recursivamente para a subarvore da esquerda
                return remove(n.getLeft(), item, n);
            } else {
                // Nao encontrou
                return false;
            }
        } else if (comp < 0) {
            // Item e' maior que o elemento no no'
            if (n.getRight() != null) {
                // Tem filho a direita, chama recursivamente para a subarvore da direita
                return remove(n.getRight(), item, n);
            } else {
                // Nao encontrou
                return false;
            }
        } // Neste ponto, encontrou o item
        else {
            // Dois filhos ?
            if (n.getLeft() != null && n.getRight() != null) {
                // Caso 1: no' a ser removido tem dois filhos
                // 1) Procura menor elemento na subarvore da direita
                Node<E> smallest = smallest(n.getRight());
                // 2) Copia o valor como o item do no' atual
                n.setItem(smallest.getItem());
                // 3) Agora ha duas copias do mesmo valor, entao e'
                // preciso remover a segunda, da subarvore da direita.
                remove(n.getRight(), smallest.getItem(), n);
            } // Apenas um filho: agora e' preciso ligar com o pai
            // do no' removido
            // No' removido e' filho da esquerda ?
            else if (parent.getLeft() == n) {
                // Qual no' deve ser ligado ao pai ?
                if (n.getLeft() != null) {
                    parent.setLeft(n.getLeft());
                } else {
                    parent.setLeft(n.getRight());
                }
            } // No' removido e' filho da direita ?
            else if (parent.getRight() == n) {
                // Qual no' deve ser ligado ao pai ?
                if (n.getLeft() != null) {
                    parent.setRight(n.getLeft());
                } else {
                    parent.setRight(n.getRight());
                }
            }
            return true;
        }
    }

    /**
     * Retorna referencia para o nodo que contem o MENOR elemento da arvore
     * cuja raiz foi passada por parametro.
     * @param n nodo a partir do qual deve-se procurar o menor elemento.
     * @return referencia para o nodo que contem o menor elemento.
     */
    private Node<E> smallest(Node<E> n) {
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node<E> n) {
        if (n.getLeft() != null) {
            printTree(n.getLeft());
        }
        System.out.println(n.getItem());
        if (n.getRight() != null) {
            printTree(n.getRight());
        }
    }

    public void printStructure() {
        internalPrint(root, 0);
    }

    private void internalPrint(Node<E> n, int depth) {
        if (n != null) {
            internalPrint(n.getRight(), depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(n.getItem());
            internalPrint(n.getLeft(), depth + 1);
        }
    }

	public E find(E elem) {
        Node<E> result = searchNodeRef(elem, root);
        if (result != null) {
            return result.getItem();
        }
        return null;
    }

    public List<E> traversalCentral() {
        List<E> res = new ArrayList<E>();
        if (root != null) {
            traversalCentralAux(root, res);
        }
        return res;
    }

    private void traversalCentralAux(Node<E> tree, List<E> res) {
        if (tree.getLeft() != null) {
            traversalCentralAux(tree.getLeft(), res);
        }
        res.add(tree.getItem());
        if (tree.getRight() != null) {
            traversalCentralAux(tree.getRight(), res);
        }
    }

    public Iterator<E> getIteratorCentral() {
        return new IteratorCentral<E>(root);
    }

    private class IteratorCentral<T> implements Iterator<T> {
        // pilha contera nos pais ainda nao visitados do no atual

        private Stack<Node<T>> stack = new Stack<Node<T>>();

        // inicializa a pilha com todos os nos descendentes da esquerda
        public IteratorCentral(Node<T> tree) {
            Node<T> aux = tree;
            while (aux != null) {
                stack.push(aux);
                aux = aux.getLeft();
            }
        }

        public boolean hasNext() {
            return (!stack.isEmpty());
        }

        public T next() {
            if (stack.isEmpty() || stack.peek() == null) {
                throw new NoSuchElementException();
            }
            Node<T> aux = stack.pop();
            T top = aux.getItem();
            if (aux.getRight() != null) {
                aux = aux.getRight();
                while (aux != null) {
                    stack.push(aux);
                    aux = aux.getLeft();
                }
            }
            return top;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
	
	public String toString() {
		return toString(root);
	}

	private String toString(Node<E> n) {
		String s = null;

		if (n.getLeft() != null)
			s = toString(n.getLeft());

		s += n.getItem().toString();

		if (n.getRight() != null)
			s += toString(n.getRight());
		
		return s;
	}

	public void serialize(String path) {
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(new FileOutputStream(path));
			//TODO: dá prá ser?
			os.writeObject(root);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (os != null) {
			try {
				System.out.println("Fechando Arquivo Serialização");
				os.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void deserialize(String path) {
		ObjectInputStream os = null;		
		try {
			os = new ObjectInputStream(new FileInputStream(path));
			root = (Node<E>) os.readObject();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if (os != null) {
			try {
				System.out.println("Fechando Arquivo Deserialização");
				os.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		printStructure();
	}

	//FIXME: Isso é usado?
	public Node<E> getRoot() {
		return root;
	}
}
