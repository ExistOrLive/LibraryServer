<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
   <form action="readerActionchangePassword.action" method="post">
       <table>
   
         <tr>
               <td>id</td>
               <td><input type="text" name="id"/><td>
         </tr>
         <tr>
              <td>密码</td>
               <td><input type="password" name="password"/><td>
         </tr>
         
         <tr>
              <td>新密码</td>
               <td><input type="password" name="newPassword"/><td>
         </tr>
         
          
          <tr>
              
               <td ><input type="submit" value="提交"/></td>  <td ><input type="reset" value="重置"/></td>
         </tr>
  </table> 

    </form>

</body>
</html>