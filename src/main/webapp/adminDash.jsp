<%@ include file="header.jsp"%>
<style>
    a {
        color: black;
    }
    a:hover {
        color: #A41E35;
    }
</style>
<div class="container">
    <h1>Admin Dashboard</h1>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="addTruck.jsp">Add a Truck</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="editTruck.jsp">Edit a Truck</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="deleteTruck.jsp">Delete a Truck</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="deleteReviews.jsp">Delete Reviews</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="editMenu.jsp">Edit Menu</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="addTag.jsp">Add a Tag</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="deleteTag.jsp">Delete a Tag</a></h4>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="well">
            <h4><a href="addTruckImage.jsp">Add a truck image</a></h4>
        </div>
    </div>
</div>
<%@ include file="footer.html"%>