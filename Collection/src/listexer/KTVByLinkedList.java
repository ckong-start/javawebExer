package listexer;

import java.util.LinkedList;
import java.util.Scanner;

public class KTVByLinkedList {
	private static LinkedList<String> musicList = new LinkedList<>();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		enterview();
	}
	
	private static void enterview(){
		System.out.println("-------------欢迎来到点歌系统------------");
		System.out.println("1.添加歌曲至列表");
		System.out.println("2.将歌曲置顶");
		System.out.println("3.将歌曲前移一位");
		System.out.println("4.退出");
		addMusicList();
		System.out.println("初始化歌曲列表：" + musicList);
		boolean isFlag = true;
		while(isFlag){
			System.out.print("请输入要执行的操作序号：");
			int key = sc.nextInt();
			switch(key){
			case 1:
				addMusic();
				break;
			case 2:
				setTop();
				break;
			case 3:
				setBefore();
				break;
			case 4:
				System.out.println("----------------退出---------------");
				System.out.println("您已退出系统");
				isFlag = false;
				break;
			default:
				System.out.println("------------------------------");
				System.out.println("功能选择有误，请输入正确的功能序号！");
				break;
			}
			System.out.println("当前歌曲列表：" + musicList);
		}
	}
	//执行将歌曲置前一位
	private static void setBefore() {
		System.out.println("请输入要置前的歌曲名称：");
		String musicName = sc.next();
		int musicIndex = musicList.indexOf(musicName);
		if(musicIndex < 0){
			System.out.println("当前列表中没有输入的歌曲！");
		}else if(musicIndex == 0){
			System.out.println("当前歌曲已在最顶部！");
		}else {
			musicList.remove(musicIndex);
			musicList.add(musicIndex - 1, musicName);
			System.out.println("已将歌曲" + musicName + "置前一位");
		}
	}
	//执行将歌曲置顶
	private static void setTop() {
		System.out.println("请输入要置顶的歌曲名称：");
		String musicName = sc.next();
		int musicIndex = musicList.indexOf(musicName);
		if(musicIndex < 0){
			System.out.println("当前列表中没有输入的歌曲！");
		}else{
			musicList.remove(musicIndex);
			musicList.addFirst(musicName);
			System.out.println("已将歌曲" + musicName + "置顶");
		}
		
	}
	//执行添加歌曲
	private static void addMusic() {
		System.out.println("请输入要添加的歌曲名称：");
		String musicName = sc.next();
		musicList.addLast("musicName");
		System.out.println("已添加歌曲：" + musicName);
		
	}
	
	//初始时添加歌曲名称
	private static void addMusicList(){
		musicList.add("菊花台");
		musicList.add("江南style");
		musicList.add("学猫叫");
		musicList.add("双节棍");
		musicList.add("突然的自我");
	}
}
