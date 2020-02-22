package overrideexer;

public class Cylinder extends Circle{//继承
	private double length;

	public Cylinder() {
		length = 1;
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {//this的用法
		this.length = length;
	}
	
	public double findVolume(){//计算圆柱体积
		return super.findArea() * length;//super的用法
		
	}
	public double findArea(){//计算圆柱的表面积/方法的重写
		return super.findArea() * 2 + getRadius() * 2 * Math.PI * length;
	}
}
