<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
   <form action="eBookActionlist.action" method="post">
    <table>
    
          <tr>
              <td>id</td>
               <td><input type="text" name="id"/><td>
         </tr>
   
         <tr>
              <td>ISBN</td>
               <td><input type="text" name="ISBN"/><td>
         </tr>
         <tr>
              <td>title</td>
               <td><input type="text" name="name"/><td>
         </tr>
          
            
        <tr>    <td>type</td> <td> <input type="text" name="type" /> </td></tr>
        
         <tr>    <td>key</td> <td> <input type="text" name="key" /> </td></tr> 
         
          <tr>
              
               <td ><input type="submit" value="提交"/></td>
         </tr>
  </table> 

    </form>
</body>
</html>