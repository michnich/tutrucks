<%@ include file="header.jsp"%>
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
                        <button type="button" class="form-control btn btn-danger" id="removeCategory">Remove</button> 
                    </div>
                    <div class="panel-body outerWrapper">
                        <div class ="container-fluid containerWrapper">
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                        
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
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
                <div class="panel panel-default panelCloneWrapper">
                    <div class="panel-heading">
                        <input type="text" class="form-control" placeholder="Category Title">
                        <input type="text" class="form-control" placeholder="Category Description">
                        <button type="button" class="form-control btn btn-danger" id="removeCategory">Remove</button> 
                    </div>
                    <div class="panel-body outerWrapper">
                        <div class ="container-fluid containerWrapper">
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                              
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-danger removeItem">Remove</button>       
                                </div>                        
                            </div>
                            <div class="row-fluid cloneWrapper">
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" placeholder="Item Name">
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" placeholder="Item Price">       
                                </div> 
                                <div class="col-sm-2">
                                    <button type="button" class="form-control btn btn-primary">Add tags</button>
                                </div>
                                <div class="col-sm-2">
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
            </div>
            <button type="button" class="btn btn-primary" id="addCategory">New Category</button>
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="footer.html"%>
<script src="cloneMenu.js"></script>