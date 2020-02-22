package pojo;

import java.util.List;

public class Page<T> {
	public static final Integer PAGE_SIZE = 4;
	private Integer pageNo;
	private Integer pageSize = PAGE_SIZE;
	private Integer pageTotal;
	private Integer pageTotalCount;
	private List<T> items;
	private String uri;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(Integer pageNo, Integer pageSize, Integer pageTotal, Integer pageTotalCount, List<T> items) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.pageTotalCount = pageTotalCount;
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal + ", pageTotalCount="
				+ pageTotalCount + ", items=" + items + "]";
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		if(pageNo <= 0)pageNo = 1;
		if(pageNo > pageTotal)pageNo = pageTotal;
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	
}
