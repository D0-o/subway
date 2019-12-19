package subway1;

import subway.Manager;
import subway.Route;
import subway.Subway;

public class Main{

	
	public static void main(String[] args)  {
		boolean f=false;
		if(args.length==2||args.length==6||args.length==7) {
			if(args.length==2) {
				if(("-map").equals(args[0])) {
					Data.TxttoData("D:\\"+args[1]);
					}else {
						System.out.println("格式错误！");
					}
			}
			
			if(args.length==7) {
				if(("-b").equals(args[0])) {
					if(("-o").equals(args[5])) {
						LineOut.Filename(args[6]);
						}else {
							System.out.println("格式错误！");
						}
					if(("-map").equals(args[3])) {
						Data.TxttoData("D:\\"+args[4]);
						}else {
							System.out.println("格式错误！");
						}
					LineOut.LineOut(Data.toStation(args[1]),Data.toStation(args[2]));
			   }else {
					System.out.println("格式错误！");
				}
			}
			
			if(args.length==6) {
				if(("-a").equals(args[0])) {
					if(("-o").equals(args[4])) {
							LineOut.Filename(args[5]);
							}else {
								System.out.println("格式错误！");
							}
						if(("-map").equals(args[2])) {
							Data.TxttoData("D:\\"+args[3]);
							}else {
								System.out.println("格式错误！");
							}
						LineOut.searchstations(args[1]);;
				   }else {
						System.out.println("格式错误！");
					}
			}
		}
		else
			System.out.println("格式错误！");
	}
}