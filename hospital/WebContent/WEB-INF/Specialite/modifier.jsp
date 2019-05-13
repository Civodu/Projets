<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Specialite</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row" id="info">
			<div class="col-lg-12">
				<h1 class="page-header">Specialite</h1>
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
					<div class="panel-heading">Modifier Specialite</div>
					<div class="panel-body">
						
                      <c:choose>
	           
	           
						 <c:when test="${empty listeMedecins}">
					   						<div class="alert alert-danger">liste vide</div>
					 	 </c:when>
					 	 <c:otherwise>
					 			    	  <c:forEach items="${listeMedecins}" var="p">

							   <form  action="/ges_consultation/SpecialiteServlet" method="post" >
							        <input type="hidden" name="id" value="${p.id }">
									<div class="form-group">
										<label>Nom</label>
										<input class="form-control"   name="nom" value="${p.nom}" require
										value="">
										 
									</div>
                                    <div class="form-group">
										<label>Tarif Consultation </label>
										<input  type="number" class="form-control"  name="tarif" value="${p.tarif}" require
										value="">
										 
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
