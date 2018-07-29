package homework;
/*
//"select ename salary, from employee"
 再console印出:
 
select
employee
ename
salary
*/
 
import java.util.ArrayList;
import java.util.List;

public class Homework1 {

	public static void main(String[] args) {

		String str = "seleCT EnAmE sAlArY, from, employee  ";   //將字串"sele..."放入str這個型態為String變數
		String str1[] = str.split(",| ");                   //將字串"sele..."用", "和" "來分割(split)在賦予給型態為String的陣列 str1
		
//		for(String ss : str1) {                              //此迴圈是為了要看分割後的結果                              
//			System.out.print(ss);                            //如果沒有使用 則會印出 [Ljava.lang.String;@4101f2ae
//		}
		
		List<String> liststr = new ArrayList<>();      //new一個ArrayList的物件
		
		for (String str2 : str1) {                           //5.0版for迴圈   冒號(:)後面放要處理的元素 再將元素放入 型態為String的變數str2 下方則編寫要如何處理
			if (!str2.isEmpty()) {                           //if() 放入str2內的元素 如果判斷不是空白   
				liststr.add(str2.toLowerCase());             //則用liststr物件呼叫add方法 新增到 str2 (再用toLowerCase全部轉成小寫)
			}                                         
		}                                                    //↑以上迴圈用來處理如果字串中加入許多的空白該怎麼處理↑
		System.out.println("篩選過後的元素並放入liststr內:" + liststr);
		for (int x = 0; x < liststr.size(); x++) {           //for迴圈...中間條件為 liststr的元素個數 size()回傳元素內的個數
			if (liststr.get(x).equals("employee")) {         //xxx.get(n) 的方法是指回傳第n個元素 如果回傳第n個元素 (equals方法是判斷是否相同) 和"employee"相同 
				liststr.add(1, liststr.get(x));              //則將這個元素加入(方法是add)到liststr內 註標為"1" (也就是第二個) 
				break;                                       //將employee變成第2個之後 就停止這個迴圈 
			}
		}
		System.out.println("將employee放到前面之後(原employee不變):" + liststr);
		
		int n = liststr.size();                              //算出總共有幾個元素
		liststr.remove(n - 1);                               //這兩個remove是為了只保留符合題目要的
		liststr.remove(n - 2);                               //※如果在後面多加了其他的字或其他符號 則無法符合題目要的※
		for (String str3 : liststr)                          //再將liststr內的東西 一個一個給str3 
			System.out.println(str3);                        //再印出來。
	}

}
