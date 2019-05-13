<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Medecins</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Medecins</h1>
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
					<div class="panel-heading">Ajouter Medecin</div>
					<div class="panel-body">
						


							   <form  action="/ges_consultation/SevMedecin" method="post" >
							        <input type="hidden" name="id" value="0">
									<div class="form-group">
										<label>Matricule</label>
										<input class="form-control"   name="matricule" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Prenom et Nom </label>
										<input class="form-control"  name="nom" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Date de Naissance</label>
										<input type="date" class="form-control"  name="dateNaisse" require
										value="">
										 
									</div>
									<div class="form-group">
										<label>Telephone</label>
										<input class="form-control"  name="tel"  require
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
										<label>Grade</label>
										<input class="form-control" name="grade"  require
										value="">
										 
									</div>
									<div class="form-group">
										<label>Login</label>
										<input class="form-control" name="login" require
										value="">
										 
									</div>
									<div class="form-group">
										<label>Password</label>
										<input type="password" class="form-control" name="password"  require
										value="">
										 
									</div>
									 
								<input type="submit" id="creer_client" class="btn btn-primary" value="Valider">
								<button type="reset" class="btn btn-default">Annuler</button>
							  </form>
								
						 </div>
						
				    </div>
			   </div>
			  <div class="col-md-2"></div>
			   
			   
			 </div>
	  </div>
<!-- 	fin form -->
  <div class="row">
	 <div class="col-lg-12">
		<div class="panel panel-default">
	   <div class="panel-heading">Liste des Medecins</div>
		   <div class="panel-body">
			<table data-toggle="table" data-url="tables/data1.json"
			  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" 
			  data-search="true" data-select-item-name="toolbar1" data-pagination="true"
			   data-sort-name="name" data-sort-order="desc">
   					     <thead>
						    <tr>
						        <th data-field="matricule" data-sortable="true" >Matricule</th>
						        <th data-field="nom" data-sortable="true">Prénom & Nom</th>
						        <th data-field="tel"  data-sortable="true">Téléphone</th>
						        <th data-field="email" data-sortable="true">Email</th>
						        <th data-field="naissance" data-sortable="true">Date Niassance</th>
						        <th data-field="grade" data-sortable="true">Grade</th>
						       
						    </tr>
						    </thead>
							<tbody>
					       <c:choose>
	           
	           
									 <c:when test="${empty listeMedecins}">
					   						<div class="alert alert-danger">liste vide</div>
					 				 </c:when>
					 				 <c:otherwise>
					 			    	  <c:forEach items="${listeMedecins}" var="p">
										      
										      
										      <tr>

											    <td>${p.matricule}</td>
											    <td>${p.nom}</td>
											    <td>${p.tel}</td>
											    <td>${p.email}</td>
											    <td>${p.dateNaissance}</td>
											    <td>${p.grade}</td>
												<td><a href="/ges_consultation/SevMedecin?id=${p.id}&ins=delete&f=${p.matricule}" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-trash"></i></a> </td>
												<td><a href="/ges_consultation/SevMedecin?id=${p.id}&ins=modifier" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-edit"></i></a> </td>
				   
											  
											  </tr>
										   </c:forEach>
					 				 </c:otherwise>
						   </c:choose>
				
							</tbody>
						</table>
                         	
					     </div>
					 </div>

			  </div>
	
	</div>	
</div>	
<jsp:include page="/layout/footer.jsp"/>
