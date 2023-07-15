<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title herex</title>
<style>
.container{
width:40%;
border:2px solid black;
margin:auto;
padding:10px;
font-size:20px;
background-color: white	;
}
#form tr td input{
font-size:20px
}




</style>
</head>
<body>
<div class="container">
<h2>login	</h2>
<Form id="form" action="Log" method="post">
<table>
<tr> 
<td>enter your name</td>
<td><input type="text" name="user_name" placeholder="enter your name"/></td>
</tr>
	
<tr>
<td>enter your email</td>
<td><input type="text" name="user_email" placeholder="enter your email"/></td>
</tr>

	
<tr>
<td>enter your Adhar</td>
<td><input type="text" name="user_Adhar" placeholder="enter your Adhar"/></td>
</tr>

<di>
<tr>
<td>enter your image</td>
<td><img src="umar"></td>
</tr>


	
<tr>
<td>enter your pancard</td>
<td><input type="text" name="user_pancard" placeholder="enter your pancard"/></td>
</tr>




<tr>
<td>
<button value="submit">login</button>
<a href="NewFile.jsp">register from</a>
</td>
</tr>



</table>
</Form>
</div>
</body>
</html>
    