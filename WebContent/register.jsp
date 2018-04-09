<%@ page language="java" contentType="text/html; charset=utf-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>


 <form action="readerActionregister.action" method="post">
    <table>
   
         <tr>
               <td>昵称</td>
               <td><input type="text" name="name"/><td>
         </tr>
         <tr>
              <td>密码</td>
               <td><input type="password" name="password"/><td>
         </tr>
          
          <tr>    
               <td>手机号码</td> 
               <td> <input type="text" name="telNum" /> </td>
          </tr>
        
         <tr>    <td>学号</td> <td> <input type="text" name="stuNum" /> </td></tr> 
         
          <tr>
              
               <td ><input type="submit" value="提交"/></td>  <td ><input type="reset" value="重置"/></td>
         </tr>
  </table> 

    </form>


</body>
</html>