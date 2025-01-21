import java.util.ArrayList;

public class MainEntry {
	public static void main(String[] args) {
		
		String title = "디자인 패턴";
		
		ArrayList<String> content = new ArrayList<>();
		content.add("얄루");
		content.add("얄루");
		content.add("얄루");
		content.add("얄루");
		
		String footer = "2025.01.21 김민수";
		
		Article article = new Article(title, content, footer);
		
		System.out.println("[CASE-1]");
		DisplayArticleTemplate style1 = new SimpleDisplayArticle(article);
		style1.display();
		
		System.out.println();
		System.out.println("[CASE-2]");
		DisplayArticleTemplate style2 = new CaptionDisplayArticle(article);
		style2.display();
	}
}
