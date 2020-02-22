package exer.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	//private Integer totalCount;// 总商品数量
	//private BigDecimal totalPrice;// 总商品价格
	private Map<Integer, CartItem> items = new HashMap<>();// 购物车中的商品项<商品编号，商品信息>

	/**
	 * 添加商品项
	 * 
	 * @param cartItem
	 */
	public void addItem(CartItem cartItem) {

		CartItem item = items.get(cartItem.getId());
		if (item == null) {
			items.put(cartItem.getId(), cartItem);
		} else {
			item.setCount(item.getCount() + 1);
			item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
	}

	/**
	 * 删除商品项
	 * 
	 * @param id
	 */
	public void deleteItem(Integer id) {
		items.remove(id);
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		items.clear();
	}

	/**
	 * 修改商品数量
	 */
	public BigDecimal updateCount(Integer id, Integer count) {
		CartItem item = items.get(id);
		if (item != null) {
			if(count == 0) {
				deleteItem(id);
			}
			item.setCount(count);
			item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
			return item.getTotalPrice();
		}else {
			return null;
		}
	}

	public Integer getTotalCount() {
		Integer totalCount = 0;
		for (CartItem item : items.values()) {
			totalCount += item.getCount();
		}
		
		return totalCount;
	}

	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0);
		for (CartItem item : items.values()) {
			
			totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
		return totalPrice;
	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + ", items=" + items + "]";
	}

}
