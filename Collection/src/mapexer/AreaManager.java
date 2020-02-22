package mapexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class AreaManager {
	private HashMap<Province,HashSet<City>> map;
	public AreaManager(){
		map = new HashMap<Province,HashSet<City>>();	
		HashSet<City> bj = new HashSet<City>();
		bj.add(new City(1,"北京市",1));
		map.put(new Province(1,"北京市"), bj);
		HashSet<City> hn = new HashSet<City>();
		hn.add(new City(1,"海口市",2));
		hn.add(new City(2,"三亚市",2));
		map.put(new Province(2,"海南省"), hn);
		HashSet<City> zj = new HashSet<City>();
		zj.add(new City(1,"绍兴市",3));
		zj.add(new City(2,"温州市",3));
		zj.add(new City(3,"湖州市",3));
		zj.add(new City(4,"嘉兴市",3));
		zj.add(new City(5,"台州市",3));
		zj.add(new City(6,"金华市",3));
		zj.add(new City(7,"舟山市",3));
		zj.add(new City(8,"衢州市",3));
		zj.add(new City(9,"丽水市",3));
		map.put(new Province(3,"浙江省"), zj);
		
	}
	public static void main(String[] args) {
		AreaManager areaManager = new AreaManager();
		HashSet<City> city = null;
		try {
			city = areaManager.findCity(3);
			city.forEach(t->System.out.println(t));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public HashSet<City> findCity(int pid) throws Exception{
		 Collection<HashSet<City>> values = map.values();
		 for (HashSet<City> hashSet : values) {
			for (City city : hashSet) {
				if(pid == city.getPid())return hashSet;
			}
		}
		throw new Exception("未查找到该城市");
	}
}
class Province{
	private int id;
	private String name;
	public Province(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Provice [id=" + id + ", name=" + name + "]";
	}
	
}
class City{
	private int id;
	private String name;
	private int pid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public City(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	
}