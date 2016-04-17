<%@page import="java.util.List"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@ include file="header.html"%>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAeqH8j_vGz84by2ewV7qGyeolyNx8Xb68&callback=initMap"></script>
    <script src="allMapJS.js"></script>

      <%
          List<Truck> trucks = Truck.getAllTrucks();
          out.print("<script>"
                  + "var trucks = [];\n"
                  + "var truck = {};\n");
          
            for (Truck t: trucks){
            if (t == null) {
                continue;
            }
            out.print("truck = {"
                    + "name: '" + t.getTruckName() + "',\n"
                    + "lat: " + t.getLatitude() + ",\n"
                    + "lng: " + t.getLongitude() + "};\n"
                    + "trucks.push(truck);\n");
            }

          out.print("</script>");
      %>
      <div class="container">
          <div class="col-sm-6">
              <div id="map"></div>
          </div>
          
      </div>
<%@ include file="footer.html"%>