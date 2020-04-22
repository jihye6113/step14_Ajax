package ex1129.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestLIBServlet")
public class SuggestLIBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String [] words= {
	   "�ڹ����α׷���","�ڹٶ�?","java�����ϱ�",
	   "Ajax�� �����ΰ�","ajax�� ������.", "javaScript ����",
	   "�� ���α׷���","������Ʈ �����ϱ�","���� ���ۿ���",
	   "jsp ����","jQuery �н�","jsp ������"
	};
	
	public List<String> search(String keyWord){
		List<String> list = new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		return list;
	}
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String keyWord = request.getParameter("keyWord");
		
		//���۵� ������ �ܾ�� �����ϴ� ������ ã�Ƽ� ����
		List<String> list = this.search(keyWord);
		
		//javaScript�� �˼� �ִ� json���·� list�� ��ȯ�ؼ� ����
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.println(arr);
	}

}






