import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.AbstractList;

/**
 * TODO: Implement your own array based list. For full credit, do not import
 * ArrayList.
 *
 */
public class ArrayBasedList<E> extends AbstractList<E> {
	public class Node {
		private E currentNode;
		private Node nextNode;

		public Node(E currentNode) {
			super();
			this.currentNode = currentNode;
			this.nextNode = null;
		}

		public E getCurrentNode() {
			return currentNode;
		}

		public void setCurrentNode(E currentNode) {
			this.currentNode = currentNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

	}

	private Node allNodes;

	public Node getallNodes() {
		return allNodes;
	}

	public void setallNodes(Node allProducts) {
		this.allNodes = allProducts;
	}

	public ArrayBasedList() {
		this.setallNodes(new Node(null));
	}

	@Override
	public E get(int index) {
		if (this.getallNodes().getCurrentNode() != null) {
			Node currentNode = this.getallNodes();
			int i = 0;
			while (currentNode.getNextNode() != null) {
				if (i == index) {
					return currentNode.getCurrentNode();
				}
				currentNode = currentNode.getNextNode();
				i++;
			}
			if (i == index) {
				return currentNode.getCurrentNode();
			}
		}
		return null;

	}

	@Override
	public int size() {
		int size = 0;
		if (this.getallNodes().getCurrentNode() != null) {
			Node currentNode = this.getallNodes();
			size++;
			while (currentNode.getNextNode() != null) {
				size++;
				currentNode = currentNode.getNextNode();
			}
		}
		return size < Integer.MAX_VALUE ? size : Integer.MAX_VALUE;
	}

	public void printArrayBasedList() {
		if (this.getallNodes().getCurrentNode() == null) {
			System.out.println("There is no element");
		} else {
//			System.out.println("printing elements");
			Node currentNode = this.getallNodes();
			while (currentNode.getNextNode() != null) {
				System.out.print(currentNode.getCurrentNode().toString()+" ");
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getCurrentNode().toString());
//			System.out.println("printing finished");
		}
	}
	

	@Override
	public boolean add(E e) {
		if (this.getallNodes().getCurrentNode() == null) {
			this.getallNodes().setCurrentNode(e);
			return true;
		} else {
			Node currentNode = this.getallNodes();
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			Node newNode = new Node(e);
			currentNode.setNextNode(newNode);
			return true;
		}

	}

	@Override
	public void add(int index, E element) {
		int i = 0;
		Node newNode = new Node(element);
		Node currentNode = this.getallNodes();
		if (index == i) {
			newNode.setNextNode(currentNode);
			this.setallNodes(newNode);
			return;
		}
		if (currentNode.getCurrentNode() != null) {
			while (currentNode.getNextNode() != null) {
				i++;
				if (i == index) {
					newNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(newNode);
					return;
				}
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}

	@Override
	public E set(int index, E element) {
		int i = 0;
		E previousE = null;
		Node currentNode = this.getallNodes();
		if (index == i) {
			previousE = currentNode.getCurrentNode();
			currentNode.setCurrentNode(element);
			return previousE;
		} else if (currentNode.getCurrentNode() != null) {
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
				i++;
				if (i == index) {
					previousE = currentNode.getCurrentNode();
					currentNode.setCurrentNode(element);
					return previousE;
				}

			}
		}
		return previousE;
	}

	@Override
	public E remove(int index) {
		int i = 0;
		E previousE = null;
		Node currentNode = this.getallNodes();
		if (index == i) {
			previousE = currentNode.getCurrentNode();
			this.setallNodes(currentNode.getNextNode());
			return previousE;
		} else if (currentNode.getCurrentNode() != null) {
			Node previousNode = currentNode;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
				i++;
				if (i == index) {
					previousE = currentNode.getCurrentNode();
					previousNode.setNextNode(currentNode.getNextNode());
					return previousE;
				}
				previousNode = currentNode;
			}
		}
		return previousE;
	}

	public void swapValue(int insertIndex, int removeIndex) {
		this.add(insertIndex, this.remove(removeIndex));
	}

}
