package exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DouDiZhu {
	public static void main(String[] args) {
		HashMap<Integer, String> poker = new HashMap<Integer,String>();
		ArrayList<Integer> pkIndex = new ArrayList<Integer>();
		int index = 0;
		String[] color = {"黑桃","红桃","梅花","方块"};
		String[] number = {"2","A","k","Q","J","10","9","8","7","6","5","4","3"};
		pkIndex.add(index);
		poker.put(index++, "大王");
		pkIndex.add(index);
		poker.put(index++, "小王");
		
		for(int i = 0; i < number.length;i++){
			for (int j = 0; j < color.length; j++) {
				pkIndex.add(index);
				poker.put(index++, color[j] + number[i]);
			}
		}
		
		Collections.shuffle(pkIndex);
		
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> dipai = new ArrayList<Integer>();
		
		int i = 0;
		while(i <= 53){
			if(i <= 2){
				dipai.add(pkIndex.get(i));
			}else if(i % 3 == 0){
				player1.add(pkIndex.get(i));
			}else if(i % 3 == 1){
				player2.add(pkIndex.get(i));
			}else if(i % 3 == 2){
				player3.add(pkIndex.get(i));
			}
			i++;
		}
		
		show("玩家一",poker,player1);
		show("玩家二",poker,player2);
		show("玩家三",poker,player3);
		show("底牌",poker,dipai);
	}
	
	private static void show(String name, HashMap<Integer, String> poker, ArrayList<Integer> pkIndex) {
		Collections.sort(pkIndex);
		System.out.print(name + "：");
		for (int i = 0; i < pkIndex.size(); i++) {
			if (i == pkIndex.size() - 1) {
				System.out.print(poker.get(pkIndex.get(i)));
			} else {
				System.out.print(poker.get(pkIndex.get(i)) + ",");
			}
		}
		System.out.println();
	}
}
