<%@page import="java.util.List"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@ include file="header.html"%>
<div class="container">
    <form>
        <fieldset class="form-group form-inline">
            <label>Select a Truck to Delete</label>
            <select class="form-control" name="truckName">
                <%
                    Truck selected = new Truck();
                    boolean submitted = false;
                    List<String> list = Truck.getAllTruckNames();
                    for (String s : list) {
                        out.print("<option>" + s + "</option>");
                    }
                %>
            </select>
            <button class="btn btn-danger">Delete Truck</button>    
        </fieldset>
    </form>
</div>
<%@ include file="footer.html"%>
