package exer;

public class Demo {
	private static String[] names = {"bill","hill","jill"};
	
	public static void main(String[] args) {
		try {
			checkUsername("hill");
			System.out.println("注册成功");
		} catch (RegisterException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public static boolean checkUsername(String uname) throws RegisterException{
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			if(name.equals(uname)){
				throw new RegisterException("亲," + name + "已经被注册了~");
			}
		}
		return true;
	}
}
