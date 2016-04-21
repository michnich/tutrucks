<%-- 
    Document   : index
    Created on : Feb 22, 2016, 9:42:19 PM
    Author     : nickdellosa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="header.jsp"%>

        <div class="cover-container">

          <div class="inner cover">
            <img src="images/TUtrucksLogo.png" alt="logo" width="75%"/>
            <p class="lead">
            <form action="search.jsp" method="GET">
                <input type="search" id="searchbar" name="criteria" class="textbox" placeholder="Search for trucks or items" />
                <input type="submit" class="search" value="Search"/>
                
            </form>
            <a href="search.jsp?criteria=truck:*">List all trucks</a>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>&copy;2016 TUtrucks</p>
              <div id="shareButton"><img src="images/fbshare.png" width="180px" height="40px"></div>
            <script>
                $(document).ready(function () {
                    $.widget("custom.styledAutocomplete", $.ui.autocomplete, {
                        _renderItem: function (ul, item) {
                            var retval;
                            var index = item.label.indexOf("<span");
                            if (index > 0) {
                                var subtext = item.label.substring(index);
                                var label = item.label.substring(0, index);
                                item.value = label;
                                retval = $("<li>").append(label).append(subtext).appendTo(ul);
                            } else {
                                retval = $("<li>").append(item.label).appendTo(ul);
                            }
                            return retval;
                        }
                    });
                   $("#searchbar").styledAutocomplete({ source: function(request, response) {
                      $.ajax("autocomplete", {
                           method: "GET",
                           dataType: "json",
                           data: { criteria: request.term, numResults: 10, subscripts: true },
                           success: function (data) {
                               response(data);
                           },
                           error: function (jqXHR, status, error) {
                               console.log("error: " + error);
                           }
                       });     
                   }});
                });
            </script>
              <script>
                  
                $(document).ready(function () {
                                        $("#shareButton").click(function() {
                                            FB.getLoginStatus(function(response) {
                                                if (response.status === 'connected') {
                                                FB.ui({
                                                    method: 'share',
                                                    href: 'http://babyhuey.cis.temple.edu/TUTrucks/',
                                                }, function(response){});
                                                //var uid = response.authResponse.userID;
                                                //var accessToken = response.authResponse.accessToken;
                                              } else if (response.status === 'not_authorized') {
                                                // the user is logged in to Facebook, 
                                                // but has not authenticated your app
                                              } else {
                                                };
                                              })
                                            });
                                        });
                                    
                                    
                                    
                </script>
            </div>
          </div>

        </div>

      

    <%@include file="footer.html" %>
