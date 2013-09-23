package net.slipp.domain.summary;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageFromLinkTag extends ImageFromTag{

	public String image(Document doc) {
		Element element = doc.head();
		Elements imgElements = element.getElementsByTag("link");
		for (Element imgElement : imgElements) {
			if (hasImage(imgElement)) {
				return imgElement.attr("href");
			}
		}
		return null;
	}

	private boolean hasImage(Element imgElement) {
		return "image/x-icon".equals(imgElement.attr("type"));
	}
}
