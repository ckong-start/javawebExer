package part3;

public class SingleLinkedList {
	protected HeroNode head = new HeroNode(0, "", "", null);
	protected HeroNode node;
	protected HeroNode temp = head;
	
	class HeroNode {
		private int no;
		private String name;
		private String nickName;
		private HeroNode next;

		public HeroNode() {
			super();
		}

		public HeroNode(int no, String name, String nickName, HeroNode next) {
			super();
			this.no = no;
			this.name = name;
			this.nickName = nickName;
			this.next = next;
		}

		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
		}
		
	}
	//添加的方法
	public int add(int no, String name, String nickName) {
		node = new HeroNode(no, name, nickName, null);
		try {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//遍历显示
	public void list() {
		if (head.next == null) {
			System.out.println("[]");
			return;
		}
		HeroNode temp = head.next;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}
}


