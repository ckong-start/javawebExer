package StreamAPI;

import java.util.stream.Stream;

import org.junit.Test;

public class Test2 {

	@Test
	public void test1(){
		Stream<String> stream = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		stream.forEach(t->System.out.println(t));
	}
	
	@Test
	public void test2(){
		Stream<String> stream = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		Stream<String> filter = stream.filter(t->t.startsWith("张"));
		filter.forEach(t->System.out.println(t));
	}
	
	@Test
	public void test3(){
		Stream<String> stream = Stream.of("123","456","789","198","654","432");
		Stream<Integer> map = stream.map(m->Integer.parseInt(m));
		map.forEach(s->System.out.println(s));
	}
	
	@Test
	public void test4(){
		Stream<String> stream = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		System.out.println(stream.count());
	}
	
	@Test
	public void test5(){
		Stream<String> stream = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		Stream<String> limit = stream.limit(5);
		limit.forEach(t->System.out.println(t));
	}
	
	@Test
	public void test6(){
		Stream<String> stream = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		Stream<String> skip = stream.skip(5);
		skip.forEach(t->System.out.println(t));
	}
	
	@Test
	public void test7(){
		Stream<String> stream1 = Stream.of("张三丰","周芷若","张无忌","杨过","张翠山","黄蓉","小龙女");
		Stream<String> stream2 = Stream.of("123","456","789","198","654","432");
		Stream<String> concat = Stream.concat(stream1, stream2);
		concat.forEach(t->System.out.println(t));
	}
}
