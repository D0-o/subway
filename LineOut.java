package subway1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class LineOut {
	
	static String filename;
	public static void Filename(String file) {
		filename=file;
	}
	public  static String LineOut(Station startAddress,Station endAddress) {

		StringBuffer sb = new StringBuffer();
		File file=new File("D:\\"+filename);
		Line result = Dijkstra.set(startAddress, endAddress);
		OutputStreamWriter outputStreamWriter;
		try {
			
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file),"GBK");
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			writer.write((result.getPass().size()+1)+"\r\n");
			writer.write(startAddress.getname()+"\r\n");
			for(int i=0;i<result.getPass().size()-1;i++) {
				writer.write(result.getPass().get(i).getname()+"\r\n");
				
	        	if(!result.getPass().get(i+1).getLine().equals(result.getPass().get(i).getLine())){
	        		writer.write(result.getPass().get(i+1).getLine()+"\r\n");
	        	}
	        }
			writer.write(endAddress.getname()+"\r\n");
			  writer.close();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		sb.append("经过站点数：" + result.getPass().size()+"\n");
		
		sb.append("乘"+result.getPass().get(0).getLine()+"\n");
		sb.append(startAddress.getname()+"\n");
		for(int i=0;i<result.getPass().size()-1;i++) {
			sb.append(result.getPass().get(i).getname()+"\n");
        	if(!result.getPass().get(i+1).getLine().equals(result.getPass().get(i).getLine())){
        		sb.append("->换乘"+result.getPass().get(i+1).getLine()+"\n");
        	}
        }
		sb.append(endAddress.getname()+"\n");
		return sb.toString();
	}

	public static void searchstations(String routename) {
		System.out.println("searchstations:"+filename);
		File file=new File("D:\\"+filename);
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file),"GBK");
			BufferedWriter writer = new BufferedWriter(outputStreamWriter);
			List<Station> list = Data.subwaymap.get(routename);    
			writer.write(routename+" ");
				for(int i=0;i<list.size();i++){
					writer.write(list.get(i).getname()+" ");
						}
				writer.close();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}