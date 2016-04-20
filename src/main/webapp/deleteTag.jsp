<%@page import="edu.temple.tutrucks.Item"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@page import="edu.temple.tutrucks.Taggable"%>
<%@page import="java.util.Set"%>
<%@page import="edu.temple.tutrucks.Tag"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="container">
    <form>
        <div class="col-sm-4">
            <label>Enter a tag to delete</label>
        </div>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="tagName">
        </div>
        <div class="col-sm-4">
            <button class='btn btn-primary' name='submitted'>Submit</button>
        </div>
    </form>
    <div class="container">
    <%
        if (request.getParameter("submitted") != null) {
            Tag deleteTag = Tag.findTag(request.getParameter("tagName"));
            if (deleteTag == null) {           
                out.println("<h3>That tag does not exist.</h3>");                     
            } else {
                Set<Truck> trucks = deleteTag.getTrucks();
                out.print("<div class='container'>"
                        + "<h3>These trucks will have this tag removed</h3>"
                        + "<div class='row-fluid'>");
                for (Truck t : trucks) {
                    out.print("<div class='col-sm-3'>"
                            + "<h5>" + t.getTruckName() + "</h5>"
                            + "</div>");
                }

                out.println("</div>"
                        + "</div>");

                Set<Item> items = deleteTag.getItems();
                out.print("<div class='container'>"
                        + "<h3>These items will have this tag removed</h3>"
                        + "<div class='row-fluid'>");

                for (Item t : items) {
                    out.print("<div class='col-sm-3'>"
                            + "<h5>" + t.getItemName() + "</h5>"
                            + "</div>");
                }

                out.println("</div>"
                        + "</div>");
            }
        }
    %>
    </div>
</div>

<%@ include file="footer.html"%>