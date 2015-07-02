package erp.core.site;

import java.util.Map;

public class Paging {
	private Map<String, Object> m_map;

	public Paging(Map<String, Object> map) {
		// TODO Auto-generated constructor stub
		m_map = map;

	}

	public void setTotalRows() {
		// TODO Auto-generated method stub
		m_map.put("messageStatus", 2);
	}

	public void setPage() {
		// TODO Auto-generated method stub
		m_map.put("messageStatus", 1);
	}
	
	public void setPageSize() {
		// TODO Auto-generated method stub
		m_map.put("messageStatus", 1);
	}

	public void showPaging(String RedirectLink) {
		// TODO Auto-generated method stub
		m_map.put("redirectLink", RedirectLink);
	}
	
}
