<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/inc/header.jsp"/> 
-->
<br><br>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-primary">
            <div class="panel-heading">Se Connecter</div>
            <div class="panel-body">
            
                <form role="form" action="/ges_consultation/Login"  method="post">
                    <fieldset>
                        <div class="form-group">
                    <input class="form-control" placeholder="Saisir Votre Pseudo" name="email" type="email" autofocus="" required="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Saisir votre mot de passe" name="password" type="password" value="" required="">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Se connecter">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
	
<!-- <jsp:include page="/inc/footer.jsp"/> 
-->
