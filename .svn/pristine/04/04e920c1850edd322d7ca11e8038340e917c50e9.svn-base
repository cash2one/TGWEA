package com.etaoguan.wea.client.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationCodeImgServlet extends HttpServlet {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1788090586547021610L;
	
	public static final String VALIDATION_CODE_NAME_IN_SESSION = "validateCode";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			doService(req, resp);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			doService(req, resp);

	}

	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        response.reset();
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

//        int width = 70, height = 24;
		int width = 58, height = 18;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.setColor(getRandColor(200, 250));

        for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		String sRand = "";

		if(request.getParameter("sRand")==null) {
			for (int i = 0; i < 4; i++) {
				String rand = String.valueOf(random.nextInt(10));
				sRand += rand;

                g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
				if(i%2==0)
					g.drawString(rand, 12 * i + 1, 16 + i);

                else
					g.drawString(rand, 12 * i + 1, 18 - i);
			}
		}
		else {
			sRand = request.getParameter("sRand");
			for(int i=0; i<sRand.length(); i++) {
				g.setColor(new Color(20 + random.nextInt(110), 20 + random
						.nextInt(110), 20 + random.nextInt(110)));

				if(i%2==0)
					g.drawString(sRand.substring(i, i+1), 13 * i + 1, 20 + 2*i);
				else
					g.drawString(sRand.substring(i, i+1), 13 * i + 1, 20 - 2*i);
			}
		}

        request.getSession(true).setAttribute(VALIDATION_CODE_NAME_IN_SESSION, sRand);

        g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());

		response.setStatus( HttpServletResponse.SC_OK );
		response.flushBuffer();
	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	public static void main(String[] args) {
		String[] arrs={"1","2"};
		String st="123";
		System.out.println(arrs.getClass());
		System.out.println(st.getClass());
	}
}
