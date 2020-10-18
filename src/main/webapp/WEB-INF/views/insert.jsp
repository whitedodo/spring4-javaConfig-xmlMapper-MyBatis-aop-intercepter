<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="${contextPath}/file/write_ok" method="post" enctype="multipart/form-data">


<table class="board_tbl">
	<tr>
		<td>첨부(Attachments)</td>
		<td align="left">
			<input type="file" name="mediaFile" placeholder="파일 선택" multiple/>
			<input type="file" name="mediaFile" placeholder="파일 선택" multiple/>
		</td>
	</tr>
</table>

 <input type="submit" value="업로드">
</form>
</body>
</html>