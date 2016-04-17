<%@ include file="header.html"%>
<div class="container">
    <h1>Add a new truck</h1>
    <form>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="truckName">Truck Name</label>
            </div>
            <div class="col-sm-8">
                <input type="text" placeholder="Name" class="form-control" id="truckName">
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Truck Location</label>
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Latitude" class="form-control" id="latitude">
            </div>
            <div class="col-sm-4">
                <input type="text" placeholder="Longitude" class="form-control" id="longitude">
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Hours of Operation</label>
                <small class="text-muted" style="display:block">Something something format</small>
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="openTime" placeholder="Opening Time">
            </div>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="closeTime" placeholder="Closing Time">
            </div>
        </fieldset>
        <!--NICK CAN WE DO AUTOCOMPLETE HERE??-->
        <fieldset class="form-group">
            <div class="col-sm-4">
                <label for="location">Tags</label>
                <small class="text-muted" style="display:block">Separate each tag with a comma or something</small>
            </div>
            <div class="col-sm-8">
                <textarea id="tags" rows="4" cols="100"></textarea>
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
<script src="addTruck.js"></script>