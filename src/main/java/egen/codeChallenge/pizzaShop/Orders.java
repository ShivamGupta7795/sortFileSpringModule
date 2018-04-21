package egen.codeChallenge.pizzaShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Orders {
	
	@Autowired
	private processOrder order;
	
	public void sortOrder(String srcFileName, String destFileName) {
		order.sortOrder(srcFileName, destFileName);
	}
	
}
