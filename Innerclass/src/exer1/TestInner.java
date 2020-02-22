package exer1;

public class TestInner {
	public static void main(String[] args) {
		Body b = new Body();
		Body.Heart h = b.new Heart();
		h.jump();
		b.setLive(false);
		h.jump();
	}
}
class Body{
	private boolean live = true;

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	class Heart{
		void jump(){
			if(live == true)System.out.println("心脏在跳动");
			if(live == false)System.out.println("心脏停止跳动");
		}
	}
}