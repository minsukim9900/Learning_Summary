
public abstract class DisplayArticleTemplate {
	
	protected Article article;

	public DisplayArticleTemplate(Article article) {
		super();
		this.article = article;
	}
	
	public final void display() {
		title();
		content();
		footer();
	}
	
	protected abstract void title();
	protected abstract void content();
	protected abstract void footer();
	
}
