package part3;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		singleLinkedList.add(1, "宋江", "及时雨");
		singleLinkedList.add(2, "卢俊义", "玉麒麟");
		singleLinkedList.add(3, "吴用", "智多星");
		singleLinkedList.add(4, "公孙胜", "入云龙");
		
		singleLinkedList.list();
	}
}

