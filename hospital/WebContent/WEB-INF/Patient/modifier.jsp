<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Patient</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Patient</h1>
			</div>
			<c:choose>
				 <c:when test="${empty message}">
   						
 				 </c:when>
 				 <c:otherwise>
 			    	 <div class="alert alert-success">${message}</div>
 				 </c:otherwise>
			</c:choose>
			
		</div>
  
		<div class="row">
			<div class="col-lg-12">
			   <div class="col-md-2"></div>
			   <div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">Modifier Patient</div>
					<div class="panel-body">
						
                      <c:choose>
	           
	           
						 <c:when test="${empty listeMedecins}">
					   						<div class="alert alert-danger">liste vide</div>
					 	 </c:when>
					 	 <c:otherwise>
					 			    	  <c:forEach items="${listeMedecins}" var="p">

							   <form  action="/ges_consultation/SevPatient" method="post" >
							        <input type="hidden" name="id" value="${p.id }">
									<div class="form-group">
										<label>Matricule</label>
										<input class="form-control"   name="matricule" value="${p.matricule}"
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Prenom et Nom </label>
										<input class="form-control"  name="nom" value="${p.nom }"
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Date de Naissance</label>
										<input type="date" class="form-control"  name="dateNaisse"  value="${p.dateNaissance}"
										value="">
										 
									</div>
									<div class="form-group">
										<label>Telephone</label>
										<input class="form-control"  name="tel" value="${p.tel }"
										value="">
										 
									</div>
									<div class="form-group">
										<label>Sexe</label>
										<select name="sexe" class="form-control">
										      <option value="M">M</option>
										      <option  value="F">F</option>
										</select>
					 
									</div>
									<div class="form-group">
										<label>Groupe Sanguin</label>
										<select name="gs" class="form-control">
										      <option value="Oplus">Oplus</option>
										      <option  value="Onegatif">Onegatif</option>
										      <option  value="ABnegatif">ABnegatif</option>
										      <option  value="ABplus">ABplus</option>
										      <option  value="Anegatif">Anegatif</option>
										      <option  value="Bplus">Bplus</option>
										      <option  value="Bnegatif">Bnegatif</option>
										</select>
					 
									</div>
									
									 
								<input type="submit" id="creer_client" class="btn btn-primary" value="Modifer">
								<button type="reset" class="btn btn-default">Annuler</button>
							  </form>
											   </c:forEach>
					 				 </c:otherwise>
						   </c:choose>
						 </div>
						
				    </div>
			   </div>
			  <div class="col-md-2"></div>
			   
			   
			 </div>
	  </div>
<!-- 	fin form -->
  </div>	
<jsp:include page="/layout/footer.jsp"/>
