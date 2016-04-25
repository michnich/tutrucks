<%@ include file="header.jsp"%>
<style>
    body{
        text-shadow: none;
        color: white;
    }
    
    .panel .panel-heading, .panel-body{
        background-color: #A41E35;
        border: solid 5px white;
    }
    
    .panel-body {
        border-top: none;
    }
    
    .top-buffer {
        margin-top: 10px;
    }
    
    .remove {
        background-color: #A41E35;
        color: #999;
        border: solid 3px #999;

    }
    .remove:hover {
        background-color: #999;
        color: #A41E35;
        border: solid 3px #999;
    }
    
    .addButton {
        background-color: #A41E35;
        color: white;
        border: solid 3px white;
    }
    
    .addButton:hover {
        background-color: white;
        color: #A41E35;
        border: solid 3px white;
    }
</style>
<div class="container">
    <h1>Add a new truck</h1>
    <form method="post" action="truckInsert">
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="truckName">Truck Name</label>
            </div>
            <div class="col-sm-8">
                <input type="text" placeholder="Name" class="form-control" name="truckName">
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Truck Location</label>
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Latitude" class="form-control" name="latitude">
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Longitude" class="form-control" name="longitude">
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Hours of Operation</label>
                <small class="text-muted" style="display:block">HH:MM:SS</small>
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="openTime" placeholder="Opening Time">
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="closeTime" placeholder="Closing Time">
            </div>
        </fieldset>
        <fieldset class="form-group formWrapper">
            <h3>Menu</h3>
            <div class="container containerPanelWrapper">
                <div class="panel panel-default panelCloneWrapper hidden">
                    <div class="panel-heading">
                        <input type="text" class="form-control" placeholder="Category Title">
                        <input type="text" class="form-control" placeholder="Category Description">
                        <button type="button" class="form-control btn btn-danger remove" id="removeCategory">Remove</button> 
                    </div>
                    <div class="panel-body outerWrapper">
                        <div class ="container-fluid containerWrapper">
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                        
                            </div>
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                         
                            </div>      
                        </div>
                        <div class="row-fluid top-buffer">
                            <div class="col-sm-2 col-sm-push-10">
                                <button type="button" class="btn btn-primary addButton addItem">New Item</button>
                            </div> 
                        </div>  
                    </div>
                </div>   
                <div class="panel panel-default panelCloneWrapper">
                    <div class="panel-heading">
                        <input type="text" class="form-control" placeholder="Category Title">
                        <input type="text" class="form-control" placeholder="Category Description">
                        <button type="button" class="form-control btn btn-danger remove" id="removeCategory">Remove</button> 
                    </div>
                    <div class="panel-body outerWrapper">
                        <div class ="container-fluid containerWrapper">
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                        
                            </div>
                            <div class="row-fluid top-buffer cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary addButton">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger remove removeItem">Remove</button>       
                                </div>                         
                            </div>      
                        </div>
                        <div class="row-fluid top-buffer">
                            <div class="col-sm-2 col-sm-push-10">
                                <button type="button" class="btn btn-primary addButton addItem">New Item</button>
                            </div> 
                        </div>  
                    </div>
                </div>  
            </div>
            <button type="button" class="btn btn-primary addButton" id="addCategory">New Category</button>
        </fieldset>
        <button type="submit" class="btn btn-primary addButton">Submit</button>
    </form>
</div>
<%@ include file="footer.html"%>
<script src="cloneMenu.js"></script>