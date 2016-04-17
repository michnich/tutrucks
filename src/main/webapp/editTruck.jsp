<%@page import="java.util.List"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@ include file="header.html"%>
<div class="container">
    <form>
        <fieldset class="form-group form-inline">
            <label>Select a Truck to Edit</label>
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
            <button class="btn btn-primary" name="submitted">Submit</button>    
        </fieldset>
    </form>

    <%
        if (request.getParameter("submitted") != null) {
            selected = Truck.getTruckByName(request.getParameter("truckName"));
            submitted = true;
        }
    %>
</div>
<br><br>
<div class="container">
    <form>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="truckName">Truck Name</label>
            </div>
            <div class="col-sm-8">
                <input type="text" placeholder="Name" class="form-control" id="truckName" 
                       <%
                           if (submitted) {
                               out.println("value = '" + selected.getTruckName() + "'");
                           }
                       %>
                       >
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Truck Location</label>
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Latitude" class="form-control" id="latitude"
                       <%
                           if (submitted) {
                               out.println("value = '" + selected.getLatitude() + "'");
                           }
                       %>
                       >
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Longitude" class="form-control" id="longitude"
                       <%
                           if (submitted) {
                               out.println("value = '" + selected.getLongitude() + "'");
                           }
                       %>
                       >
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Hours of Operation</label>
                <small class="text-muted" style="display:block">Something something format</small>
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="openTime" placeholder="Opening Time"
                       <%
                           if (submitted) {
                               out.println("value = '" + selected.getOpeningTime().toString() + "'");
                           }
                       %>
                       >
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="closeTime" placeholder="Closing Time" <%
                    if (submitted) {
                        out.println("value = '" + selected.getClosingTime() + "'");
                    }
                       %>
                       >
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary" name="save">Save</button>
        <%
            if (request.getParameter("save") != null) {
                //do some database updating shit
            }
        %>
    </form>
</div>
<%@ include file="footer.html"%>