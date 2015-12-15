package tritpo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class openBrowser {//->BrowserHelper
	public static void OpenVk(String adress){//OpenBrowser(url)
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI(adress));
		} catch (IOException | URISyntaxException e) {
			
			e.printStackTrace();
		}
	}
}