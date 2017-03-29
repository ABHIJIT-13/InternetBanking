

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//PDFGenerate
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@WebServlet("/Register")
public class Register extends HttpServlet
{
	public static String FILE="C:/Users/David Johnson/Desktop/test.pdf";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection cn=null;
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			//cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_bank","root","ANUJ");
			//String q="insert into temp_regd values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String param[]={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15","a16","a17","a18","a19","a20","a21","a22","a23","a24","a25","a26","a27","a28","a29","a30","a31","a32","a33","a34"};
			String details[]=new String[34];
			PrintWriter pw=response.getWriter();
			for(int i=0;i<34;i++)
			{
				details[i]=request.getParameter(param[i]);
				pw.println(details[i]);
			}
			/*PreparedStatement ps=cn.prepareStatement(q);
		    for(int i=0;i<34;i++)
			{   
			if((i!=21)&&(i!=22))
			{
				ps.setString(i+1, details[i]);
			}

			else
			{
				File fin = new File(details[i]);
		         FileInputStream inputStream = new FileInputStream(fin);
		         ps.setBinaryStream(i+1, (InputStream) inputStream, (int)(fin.length()));
		         pw.println(details[i]);
			}
			}
			ps.executeUpdate();*/

			Document doc=new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(FILE));
			doc.open();
			doc.setPageSize(PageSize.A4);
			doc.addTitle("Personal Details");
			Rectangle rect= new Rectangle(36,108);
			rect.setBorder(Rectangle.BOX);
			rect.setBorderWidth(1);
			rect.setBorderColor(BaseColor.BLACK);
			
			Font font = new Font(Font.FontFamily.TIMES_ROMAN, 15,  Font.UNDERLINE | Font.BOLD);
			Font font2 = new Font(Font.FontFamily.HELVETICA, 20, Font.ITALIC| Font.UNDERLINE | Font.BOLD);
			Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
			Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 5);
			Paragraph p0=new Paragraph("Friendly Bank",font2);
			Paragraph p=new Paragraph("Application Form",font);
			p0.setAlignment(Element.ALIGN_CENTER);
			p0.setSpacingAfter(10);
			p0.setSpacingBefore(0);
			p.setAlignment(Element.ALIGN_CENTER);
			p.setSpacingAfter(25);
			
			
			
			PdfPTable table = new PdfPTable(2);
			float[] columnWidths = {4f,2f};
	        table.setWidths(columnWidths);
			PdfPTable intable=new PdfPTable(2);
			float[] columnWidths1 = {1f,2f};
	        intable.setWidths(columnWidths1);
			
	        PdfPCell in11=new PdfPCell(new Paragraph("1.Name:",font3));
			in11.setBorderColor(BaseColor.WHITE);
			PdfPCell in12=new PdfPCell(new Paragraph(details[0]+details[1]+details[2]+details[3],font3));
			in12.setBorderColor(BaseColor.WHITE);
			intable.addCell(in11);
			intable.addCell(in12);
			
			PdfPCell in21=new PdfPCell(new Paragraph("2.Email ID:",font3));
			PdfPCell in22=new PdfPCell(new Paragraph("email",font3));
			in21.setBorderColor(BaseColor.WHITE);
			in22.setBorderColor(BaseColor.WHITE);
			intable.addCell(in21);
			intable.addCell(in22);
			
			PdfPCell in31=new PdfPCell(new Paragraph("3.City:",font3));
			PdfPCell in32=new PdfPCell(new Paragraph("Bhubaneswar",font3));
			in31.setBorderColor(BaseColor.WHITE);
			in32.setBorderColor(BaseColor.WHITE);
			intable.addCell(in31);
			intable.addCell(in32);
			
			PdfPCell cell1 = new PdfPCell(intable);
			cell1.setPaddingLeft(10);
			cell1.setBorderColor(BaseColor.WHITE);			
			
			Image image = Image.getInstance("C:/Users/David Johnson/Desktop/male-passport-size-2.jpg");
			image.scaleAbsolute(250, 300);
			image.setBorder(1);
			PdfPCell cell2 = new PdfPCell(image);
			cell2.setPaddingLeft(0);
			cell2.setBorderColor(BaseColor.WHITE);			
			
			table.addCell(cell1);
		    table.addCell(cell2);		
			
			
			doc.add(p0);
			doc.add(p);
			doc.add(table);
			doc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
