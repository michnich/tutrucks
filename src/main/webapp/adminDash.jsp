<%@ include file="header.jsp"%>
<style>
    body {
        shadow: none;
        color: white;
    }
    .spacer {
        margin-top: 100%;
    }
    .thumbnail {
        position: absolute;
        top: 15px;
        bottom: 0;
        left: 15px;
        right: 0;
        text-align:center;
        padding-top:calc(20% - 30px);
        background-color: #A41E35;
        border: solid white 6px;
        font-weight: bold;
    }
    a.thumbnail:hover {
        text-decoration: none;
        color: #999;
        border: solid #999 6px;
    }
    h3{
        font-weight: bold;
    }


</style>
<div class="container">
    <h1>Admin Dashboard</h1>
    <div class="row">
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <a class="thumbnail"href="addTruck.jsp"><h3>Add a Truck</h3>
                <i style="font-size: 4.5vw; padding-top: 10px;" class="glyphicon glyphicon-plus"></i></a>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <a class="thumbnail"href="editTruck.jsp"><h3>Edit a Truck</h3>
                <i style="font-size: 4.5vw; padding-top: 10px;" class="glyphicon glyphicon-edit"></i></a>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <a class="thumbnail"href="deleteTruck.jsp"><h3>Delete a Truck</h3>
                <i style="font-size: 4.5vw; padding-top: 10px;" class="glyphicon glyphicon-trash"></i> </a>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <h4><a class="thumbnail"href="addTruckImage.jsp">Add a truck image</a></h4>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <h4><a class="thumbnail"href="deleteReviews.jsp">Delete Reviews</a></h4>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <h4><a class="thumbnail"href="editMenu.jsp">Edit Menu</a></h4>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <h4><a class="thumbnail"href="addTag.jsp">Add a Tag</a></h4>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6">
            <div class="spacer"></div>
            <h4><a class="thumbnail"href="deleteTag.jsp">Delete a Tag</a></h4>
        </div>
    </div>
</div>
<%@ include file="footer.html"%>