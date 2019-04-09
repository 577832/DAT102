package no.hvl.dat102.KjedetKoe;


public class LinearNode<T> {

	private LinearNode<T> neste;
	private T element;
	public LinearNode(T element) {
		super();
		this.neste = null;
		this.element = element;
	}
	public LinearNode<T> getNeste() {
		return neste;
	}
	public void setNeste(LinearNode<T> neste) {
		this.neste = neste;
	}
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
}// class

