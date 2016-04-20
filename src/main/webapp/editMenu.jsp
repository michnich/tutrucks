<%@page import="edu.temple.tutrucks.User"%>
<%@page import="java.util.Set"%>
<%@page import="edu.temple.tutrucks.Item"%>
<%@page import="edu.temple.tutrucks.Menu"%>
<%@page import="java.util.List"%>
<%@page import="edu.temple.tutrucks.Truck"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<style>
    body {
        color: black;
    }
</style>
<div class="cover container">
    <form action="editMenu" method="post">
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
            <button class="btn btn-primary" name="submitted" value="">Submit</button>    
        </fieldset>
    </form>
    <form>
        <input type="hidden" name="truckName" value=<%out.print("'" + selected.getTruckName() + "'");%>>
        <fieldset class="form-group formWrapper">
            <div class="container containerPanelWrapper">
                <div class="panel panel-default panelCloneWrapper hidden">
                    <div class="panel-heading">
                        <input type="text" class="form-control" name="categoryTitle" placeholder="Category Title">
                        <input type="text" class="form-control" name="categoryDescription" placeholder="Category Description">
                        <button type="button" class="form-control btn btn-danger" id="removeCategory">Remove</button> 
                    </div>
                    <div class="panel-body outerWrapper">
                        <div class ="container-fluid containerWrapper">
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="itemName" placeholder="Item Name">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" name="itemPrice" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-3">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="itemName" placeholder="Item Name">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" name="itemPrice" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-3">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="itemName" placeholder="Item Name">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" name="itemPrice" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-3">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                              
                            </div>      
                        </div>
                        <div class="row-fluid">
                            <div class="col-sm-2 col-sm-push-10">
                                <button type="button" class="btn btn-primary addItem">New Item</button>
                            </div> 
                        </div>  
                    </div>
                </div>
                <%
                    selected = Truck.getTruckByName(request.getParameter("truckName"));
                    out.print("<h2>" + selected.getTruckName() + "</h2>");
                    List<Menu> menu = selected.getMenus();
                    for (Menu m : menu) {
                        if (m == null) {
                            continue;
                        }

                        String menuName = m.getMenuName();
                        String menuDescription = "";

                        if (m.getDescription() != null) {
                            menuDescription = m.getDescription();
                        }

                        out.print("<div class='panel panel-default panelCloneWrapper'>"
                                + "<div class='panel-heading'>"
                                + "<input type='text' class='form-control' name='categoryName' value='" + menuName + "'>"
                                + "<input type='text' class='form-control' name='categoryTitle' value='" + menuDescription + "'>"
                                + "<button type='button' class='form-control btn btn-danger' id='removeCategory'>Remove</button> "
                                + "</div>"
                                + "<div class='panel-body outerWrapper'>"
                                + "<div class ='container-fluid containerWrapper'>");
                        Set<Item> items = m.getItems();
                        for (Item i : items) {
                            String itemName = "";
                            double itemPrice = 0;
                            if (i.getItemName() != null) {
                                itemName = i.getItemName();
                            }
                            if (i.getPrice() != 0) {
                                itemPrice = i.getPrice();
                            }

                            out.print("<div class='row-fluid cloneWrapper'>"
                                    + "<div class='col-sm-6'>"
                                    + "<input type='text' class='form-control' name='itemName' value='" + itemName + "'>"
                                    + "</div>"
                                    + "<div class='col-sm-3'>"
                                    + "<input type='text' class='form-control' name='itemPrice' value='" + itemPrice + "'>"
                                    + "</div>"
                                    + "<div class='col-sm-3'>"
                                    + "<button type='button' class='form-control btn btn-danger removeItem'>Remove</button>       "
                                    + "</div>"
                                    + "</div>");
                        }

                        out.print("</div>"
                                + "<div class='row-fluid'>"
                                + "<div class='col-sm-2 col-sm-push-10'>"
                                + "<button type='button' class='btn btn-primary addItem'>New Item</button>"
                                + "</div>"
                                + "</div>"
                                + "</div>"
                                + "</div>");

                    }
                %>
            </div>
            <button type="button" class="btn btn-primary" id="addCategory">New Category</button>
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button
    </form>
</div>
<%@ include file="footer.html"%>
<script src="cloneMenu.js"></script>