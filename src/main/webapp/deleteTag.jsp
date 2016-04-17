<%@page import="edu.temple.tutrucks.Item"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@page import="edu.temple.tutrucks.Taggable"%>
<%@page import="java.util.Set"%>
<%@page import="edu.temple.tutrucks.Tag"%>
<%@ include file="header.html"%>
<div class="container">
    <form>
        <fieldset class="form-control">
            <h3>Enter a tag to delete</h3>
            <input type="text" name="tagName">
        </fieldset>
        <button type="submit" class='btn btn-primary' name='submitted'>Submit</button>
    </form>
    
    <%
        if (request.getParameter("submitted") != null) {
            Tag deleteTag = Tag.findTag(request.getParameter("tagName"));
            if (deleteTag == null) {
                out.println("<div class='container'>"
                        + "<h3>That tag does not exist.</h3>"
                        + "</div>");
            }
            else {
                Set<Truck> trucks = deleteTag.getTrucks();
                out.print("<div class='container'>"
                        + "<h3>These trucks will have this tag removed</h3>"
                        + "<div class='row-fluid'>");                
                for (Truck t: trucks) {
                    out.print("<div class='col-sm-3'>"
                            + "<h5>" + t.getTruckName() +"</h5>"
                            + "</div>");
                }
                
                out.println("</div>"
                        + "</div>");
                
                Set<Item> items = deleteTag.getItems();
                out.print("<div class='container'>"
                        + "<h3>These items will have this tag removed</h3>"
                        + "<div class='row-fluid'>"); 
                
                 for (Item t: items) {
                    out.print("<div class='col-sm-3'>"
                            + "<h5>" + t.getItemName() +"</h5>"
                            + "</div>");
                }
                
                out.println("</div>"
                        + "</div>");
            }
        }
    %>
    
    <div class='container'>
        <h3>These entities will have this tag removed</h3>
        <div class='row-fluid'>
            <div class='col-sm-3'>
                <h5>Name</h5>
            </div>
        </div>
    </div>
    
</div>

<%@ include file="footer.html"%>