package thisexer;

public class BoyGirlTest {
public static void main(String[] args) {
	Boy boy = new Boy("罗密欧", 22);
	Girl girl = new Girl("朱丽叶",18);
	Girl girl1 = new Girl("祝英台",18);
	boy.shout();
	girl.marry(boy);
	int compare = girl.compare(girl1);
	if(compare > 0){
		System.out.println(girl.getName() + "big");
	}else if(compare < 0){
		System.out.println(girl1.getName() + "big");
	}else {
		System.out.println("the same age");
	}
}
}
