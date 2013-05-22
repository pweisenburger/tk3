package tk3.labyrinth.core.gameelements;

public class Button extends GameElement {
	private IActivatable referencedElement;
	
	public void initReferencedElement(IActivatable referencedElement) {
		if (this.referencedElement != null && this.referencedElement != referencedElement)
			throw new UnsupportedOperationException("Referenced element already set");
		this.referencedElement = referencedElement;
	}
	
	@Override
	public boolean isTraversable() {
		return true;
	}
	
	public IActivatable getReferencedElement() {
		return referencedElement;
	}
}
