import java.util.Stack;
class Postion
{
	int x;//行坐标
	int y;//列坐标
	int direction;//方向 -1代表还没有走任何方向,0下边,1右边,2上边,3左边
	public Postion(int x, int y )
	{
		
		this.x = x;
		this.y = y;
		this.direction = -1;
	}
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {//通过坐标判断是否相等
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postion other = (Postion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Postion [x=" + x + ", y=" + y + ", direction=" + direction
				+ "]";
	}
}
public class MiGong {
	 int a[][]={
			   {1,1,1,1,1,1},
			   {1,0,0,0,0,1},
			   {1,0,1,1,0,1},
			   {1,0,1,0,0,1},
			   {1,0,0,0,0,1},
			   {1,1,1,1,1,1}
	 };//地图
	 int startX=1;//入口位置x
	 int startY=1;//入口位置y
	 int endX=4;//出口位置x
	 int endY=4;//出口位置y
	 Stack<Postion> stack = new Stack<Postion>();//栈的定义
	 public static void main(String []args)
	 {
		 new MiGong().go();
	 }
	 public void printPath()
	 {
		 Object [] array =stack.toArray();//把栈转化为数组
		 for(int i =0;i<array.length;i++)
		 {
			 Postion pos = (Postion)array[i];//得到坐标
			 System.out.print("["+pos.x +" "+pos.y +"]");//打印坐标
		 }
		 System.out.println();
	 }
	 public void go()
	 {
		 //起始坐标进栈
		 stack.push(new Postion(startX,startY) );
		 //当栈不为空的时候
		 while(stack.size()>0)
		 {
			 //获取栈顶元素
			 Postion currentPostion = stack.peek();
			 //如果是目的地，则输出路径，，
			 if(currentPostion.x==this.endX&&currentPostion.y == this.endY)
			 {
				 System.out.println("找到一条路径");
				 printPath();//打印路线
				 stack.pop();//出栈栈顶元素
				 continue;//继续往下循环
			 }
			 //direction+1，方向加1
			 currentPostion.direction++;
			 if(currentPostion.direction==4)//路走完了
			 {
				 stack.pop(); //出栈
				 continue;//进行下一轮循环
			 }	
			 Postion nextPostion=null;
			 if(currentPostion.direction==0)//下边
			 {
				 //计算新坐标
				   nextPostion = new Postion(currentPostion.x,currentPostion.y+1);
			 }
			 else if(currentPostion.direction==1)//右边
			 {
				   nextPostion = new Postion(currentPostion.x+1,currentPostion.y);
			 }
			 else if(currentPostion.direction==2)//上边
			 {
				   nextPostion = new Postion(currentPostion.x,currentPostion.y-1);
			 }
			 else if(currentPostion.direction==3)//左边
			 {
				   nextPostion = new Postion(currentPostion.x-1,currentPostion.y);
			 }
			 if(a[nextPostion.x][nextPostion.y]==0 )//如果这个位置不是墙或砖
			 {
				 if(stack.contains(nextPostion)==false)//如果没有走过这个位置
				 {
					 stack.push(nextPostion);//这个位置可以走，进栈
				 }
			 } 
			  
		 }
	 }
}
