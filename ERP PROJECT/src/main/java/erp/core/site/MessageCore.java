package erp.core.site;

import java.util.ArrayList;
import java.util.Map;

public class MessageCore {
	// 1: OK, 2: Error

	private Map<String, Object> m_map;
	public ArrayList<String> lstMessage = new ArrayList<String>();

	public MessageCore(Map<String, Object> map) {
		// TODO Auto-generated constructor stub
		m_map = map;
		m_map.put("messageList", lstMessage);

	}

	public void showError() {
		// TODO Auto-generated method stub
		m_map.put("messageStatus", 2);
	}

	public void showMessage() {
		// TODO Auto-generated method stub
		m_map.put("messageStatus", 1);
	}
	
	public void setConfirm(){
		m_map.put("messageStatus", 3);
	}

	public void showMessage(String RedirectLink) {
		// TODO Auto-generated method stub
		m_map.put("redirectLink", RedirectLink);
	}

}
