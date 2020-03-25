
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;


@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean nuevoUsuario = true;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("VisitanteRecurrente") && c.getValue().equals("si")) {
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        String mensaje = null;

        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("VisitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio =.=";
        } else {
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio 0.0";
        }

        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();

        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);

        }

        String articuloNuevo = request.getParameter("articulo");

        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        double uno = 0;
        int uno1=0;
        double dos = 0;
        int dos2=0;
        double tres = 0;
        int tres3=0;
        double cuatro = 0;
        int cuatro4=0;
        double cinco = 0;
        int cinco5=0;
        double seis = 0;
        int seis6=0;
        double siete = 0;
        int siete7=0;
        double ocho=0;
        int ocho8=0;
        double nueve=0;
        int nueve9=0;
        double diez=0;
        int diez10=0;

        for (String articulo : articulos) {
            switch (articulo) {
                case "3D Kanojo: Real Girl":
                    uno = uno + 250.00;
                    uno1=uno1+1;
                    break;
                case "Boku No Hero":
                    dos = dos + 100.00;
                    dos2= dos2+1;
                    break;
                case "Goblin Slayer":
                    tres = tres + 200;
                    tres3= tres3+1;
                    break;
                case "Bunny Girl Senpai":
                    cuatro = cuatro + 100;
                    cuatro4= cuatro4+1;
                    break;
                case "Mayo Chiki":
                    cinco = cinco + 300;
                    cinco5= cinco5+1;
                    break;
                case "Naruto":
                    seis = seis + 400.00;
                    seis6= seis6+1;
                    break;
                case "Quintillizas":
                    siete = siete + 250.00;
                    siete7= siete7+1;
                    break;
                case "Sword Art Online":
                    ocho=ocho+400;
                    ocho8= ocho8+1;
                case "Re-Life":
                    nueve=nueve+ 150;
                    nueve9= nueve9+1;
                    break;
                case "Plastic of Memories":
                    diez=diez+ 350;
                    diez10= diez10+1;
                    break;
            }
        }

        double suma = uno + dos + tres + cuatro + cinco + seis+ siete + ocho + nueve + diez;
        try (
                PrintWriter out = response.getWriter()) {
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <link href=\"css/e.css\" rel=\"stylesheet\" type=\"text/css\"/>\n"
                    + "        <title>Mangas</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "    <header><h1>Carrito Mangas</h1></header>"
                    + "        <br/>\n"
                    + "        <div id=\"main\">\n"
                    + "            <nav>\n"
                    
                    + "                <ul>\n"
                    + "                    <li><a href=\"/EjemploCarritoCompra\">Regresar</a></li>\n"
                    + "                </ul>\n"
                    + "            </nav>\n"
                    + "        </div>\n"
                    + "        <br/>\n"
                    + "    <center>\n"
                    + "        <table id=\"table\">\n"
                    + "<tr id=\"encabezado\">\n"
                    + "                <td>\n"
                    + "                    <h3>" +"Imagen"+ "</h3>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>" + "Costo X Pieza" + "</h3>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>" + "Piezas" + "</h3>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>" + "Costo" + "</h3>\n"
                    + "                </td>\n"
                    + "            </tr>");
            if (uno > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/Manga3D.jpg\" width=\"150\" height=\"200\"/><h3>3D Kanojo: Real Girl</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 250.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + uno1 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + uno + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (dos > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaBoku.jpg\" width=\"150\" height=\"200\"/><h3>Boku No Hero</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 100.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + dos2 +" pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + dos + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (tres > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaGoblin.jpg\" width=\"150\" height=\"200\"/><h3>Goblin Slayer</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 200.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + tres3 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + tres + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
             if (siete > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaQuinti.jpg\" width=\"150\" height=\"200\"/><h3>Goblin Slayer</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 250.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + siete7 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + siete + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (cuatro > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaBunnyGirlSennpai.jpg\" width=\"150\" height=\"200\"/><h3>Bunny Girl Senpai</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 100.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + cuatro4 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + cuatro + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (cinco > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaMayo.jpg\" width=\"150\" height=\"200\"/><h3>Mayo Chiki</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 300.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + cinco5 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + cinco + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (seis > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaNaruto.jpg.png\" width=\"150\" height=\"200\"/><h3>Naruto</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 400.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + seis6 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + seis + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (ocho > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaSAO.png\" width=\"150\" height=\"200\"/><h3>Sword Art Online</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 400.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + ocho8 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + ocho + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (nueve > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaReLife.jpg\" width=\"150\" height=\"200\"/><h3>Re-Life</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 150.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + nueve9 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + nueve + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            if (diez > 0) {
                out.println("<tr>\n"
                        + "                <td>\n"
                        + "                    <img src=\"ImagenesManga/MangaPlastic.jpg\" width=\"150\" height=\"200\"/><h3>Plastic of Memories</h3><br/>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h2>" + "$ 350.00" + "</h2>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>" + diez10 + " pzas</h3>\n"
                        + "                </td>\n"
                        + "                <td>\n"
                        + "                    <h3>$" + diez + "</h3>\n"
                        + "                </td>\n"
                        + "            </tr>");
            }
            out.println("<tr>\n"
                    + "                <td id=\"encabezado\">\n"
                    + "                    <h3>Total:</h3><br/>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>" + " " + "</h3>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>" + " " + "</h3>\n"
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    <h3>$" + suma + "</h3>\n"
                    + "                </td>\n"
                    + "            </tr>");
            out.println("           <tr>\n"
                    + "                <td colspan=\"3\">\n"
                    + "                    <form id=\"fomr1\" method=\"GET\" action=\"/EjemploCarritoCompra/CarritoServlet\">\n"
                    + "                    </form>\n"
                    + "                </th>\n"
                    + "            </tr>");
            out.println("</table>\n"
                    + "    </center>\n"
                    + "    <br/>\n"
                    + "</body>\n"
                    + "</html>");
        }
    }
}

   

