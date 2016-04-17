<%@page import="edu.temple.tutrucks.Truck"%>
<%@page import="java.util.List"%>
<%@ include file="header.html"%>
<form>
    <fieldset class='container'>
        <label for="tagName">New Tag</label>
        <input type="text" placeholder="Name" id="tagName">
    </fieldset>

    <fieldset class="form-group">
        <div class='col-sm-12'>
            <label>Select trucks to apply the tag to:</label>     
        </div>
        <%
            List<String> allTrucks = Truck.getAllTruckNames();
            for (String name : allTrucks) {
                out.print("<div class='col-sm-2'>"
                        + "<div class='checkbox'>"
                        + "<label>"
                        + "<input type='checkbox' value=" + name
                        + ">" + name + "</label>"
                        + "</div>"
                        + "</div>");
            }
        %>

    </fieldset>
    <button type="submit" class='btn btn-primary'>Submit</button>
</form>

<%@include file="footer.html"%>