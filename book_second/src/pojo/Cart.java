package pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items = new ArrayList<CartItem>();

	// 添加商品
	public void addItem(CartItem cartItem) {
		String name = cartItem.getName();
		for (CartItem item : items) {
			if (name.equals(item.getName())) {
				item.setCount(item.getCount() + 1);
				item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
				return;
			}
		}
		items.add(cartItem);
	}

	// 删除商品
	public void deleteItem(Integer id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == id) {
				items.remove(i);
				return;
			}
		}
	}

	// 清空商品
	public void clear() {
		items.clear();
	}

	// 修改数量
	public void updateCount(Integer id, Integer count) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == id) {
				CartItem item = items.get(i);
				item.setCount(count);
				item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
				return;
			}
		}
	}

	// 购物车商品
	public List<CartItem> getItems() {
		return items;
	}

	// 购物车总数量
	public Integer getTotalCount() {
		Integer totalCount = 0;
		for (CartItem item : items) {
			totalCount += item.getCount();
		}
		return totalCount;
	}

	// 购物车总价
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0);
		for (CartItem item : items) {
			totalPrice = totalPrice.add(item.getTotalPrice());
		}
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + "]";

	}

}
