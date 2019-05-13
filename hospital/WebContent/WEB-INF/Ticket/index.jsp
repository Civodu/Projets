<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Comptablité</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Ticket</h1>
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
					<div class="panel-heading">Génere Ticket</div>
					<div class="panel-body">
						


							   <form  action="/ges_consultation/TicketServlet" method="post" >
							        <input type="hidden" name="id" value="0">
									<div class="form-group">
										<label>Code</label>
										<input class="form-control"   name="code" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Date </label>
										<input class="form-control"  name="date" require
										value="">
										 
									</div>
                                  <c:choose>
	                              <c:when test="${empty listePatient}">
					   			   <div class="alert alert-danger">liste vide</div>
					 			   </c:when>
					 			   <c:otherwise>    
									<div class="form-group">
										<label>Matricule Patient</label>
										<select name="id_p" class="form-control">
					 			    	  <c:forEach items="${listePatient}" var="p">
										      <option  value="${p.id }">${p.matricule }</option>
										 </c:forEach>
								       </select>
									</div>
					 			 </c:otherwise>
						        </c:choose>
						        <c:choose>
	                              <c:when test="${empty listeSpecialite}">
					   			   <div class="alert alert-danger">liste vide</div>
					 			   </c:when>
					 			   <c:otherwise>    
									<div class="form-group">
										<label>Specialite</label>
										<select name="id_s" class="form-control">
					 			    	  <c:forEach items="${listeSpecialite}" var="s">
										      <option  value="${s.id }">${s.nom }</option>
										 </c:forEach>
								       </select>
									</div>
					 			 </c:otherwise>
						        </c:choose>
						         <c:choose>
	                              <c:when test="${empty listeCaisse}">
					   			   <div class="alert alert-danger">liste vide</div>
					 			   </c:when>
					 			   <c:otherwise>    
									<div class="form-group">
										<label>Matricule caisse</label>
										<select name="id_c" class="form-control">
					 			    	  <c:forEach items="${listeCaisse}" var="d">
										      <option  value="${d.id }">${d.matricule }</option>
										 </c:forEach>
								       </select>
									</div>
					 			 </c:otherwise>
						        </c:choose>
									 
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
	   <div class="panel-heading">Liste des Tickets</div>
		   <div class="panel-body">
			<table data-toggle="table" data-url="tables/data1.json"
			  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" 
			  data-search="true" data-select-item-name="toolbar1" data-pagination="true"
			   data-sort-name="name" data-sort-order="desc">
   					     <thead>
						    <tr>
						        <th data-field="matricule" data-sortable="true" >Code Ticket</th>
						        <th data-field="date" data-sortable="true">Date</th>
						        <th data-field="nom_p"  data-sortable="true">Nom Patient</th>
						        <th data-field="tarif" data-sortable="true">Tarif</th>
						        <th data-field="speci" data-sortable="true">Specialite</th>					       
						    </tr>
						    </thead>
							<tbody>
					       <c:choose>
	           
	           
									 <c:when test="${empty listeMedecins}">
					   						<div class="alert alert-danger">liste vide</div>
					 				 </c:when>
					 				 <c:otherwise>
					 			    	  <c:forEach items="${listeMedecins}" var="l">
										      
										      
										      <tr>
										      		        

											    <td>${l.code}</td>
											    <td>${l.datePrise}</td>
											    <td>${l.patient.nom}</td>
											    <td>${l.specialite.tarif}</td>
											    <td>${l.specialite.nom}</td>
											   
												<td><a href="/hospital/TicketServlet?id=${l.id}&ins=delete" 
												class="btn btn-danger" >
												<i class="glyphicon glyphicon-trash"></i></a> </td>
							
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
