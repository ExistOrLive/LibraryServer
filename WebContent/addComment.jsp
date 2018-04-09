<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="commentActionaddComment.action" method="post">
    <table>
    
          <tr>
              <td>Bookid</td>
               <td><input type="text" name="bookId.id"/><td>
         </tr>
   
         <tr>
              <td>ReaderId</td>
               <td><input type="text" name="readerId.id"/><td>
         </tr>
         <tr>
              <td>content</td>
               <td><input type="text" name="content"/><td>
         </tr>
          
            
       <tr>
              
               <td ><input type="submit" name="提交"/></td>
         </tr>
  </table> 

    </form>

</body>
</html>