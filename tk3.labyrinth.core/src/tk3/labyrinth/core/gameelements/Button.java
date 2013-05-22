package tk3.labyrinth.core.gameelements;

public class Button extends GameElement {

	private IActivatable referencedElement;

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	public IActivatable getReferencedElement() {
		return referencedElement;
	}

	public void setReferencedElement(IActivatable referencedElement) {
		this.referencedElement = referencedElement;
	}
}
