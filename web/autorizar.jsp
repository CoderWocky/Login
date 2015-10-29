<%-- 
    Document   : autorizar
    Created on : 28-oct-2015, 9:06:12
    Author     : alumno
--%>

<jsp:useBean id="autorizacion" scope="session" class="Usuarios.Autorizacion"/> 
<jsp:setProperty name="autorizacion" property="*"/>
<% if (autorizacion.comprobar()) { %>
  <jsp:forward page="autorizado.html"/>
<% } else { %>
  <jsp:forward page="noautorizado.html"/>
<% } %>