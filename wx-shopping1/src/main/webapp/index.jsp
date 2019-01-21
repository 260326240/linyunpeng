<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/linyunpeng/add" method="post">
		<p>
			名称：<input type="text" name="cropName">
		</p>
		<p>
			价格：<input type="text" name="cropPrice">
		</p>
		<p>
			库存：<input type="text" name="cropKucun">
		</p>
		<p>
			运费：<input type="text" name="cropYunfei">
		</p>
		<p>
			发货地：<input type="text" name="cropFahuodi">
		</p>
		<p>
			描述：<input type="text" name="cropDescribe">
		</p>
		<p>
			imaAdd1:<input type="text" name="imaAdd1" maxlength="100000">
		</p>
		<p>
			imaAdd2:<input type="text" name="imaAdd2" maxlength="100000">
		</p>
		<p>
			imaAdd3:<input type="text" name="imaAdd3" maxlength="100000">
		</p>
		<p>
			imaTouxiang:<input type="text" name="imaTouxiang" maxlength="100000">
		</p>

		<p>
			<input type="submit" value="提交">
		</p>
	</form>
	<form action="/linyunpeng/update" method="post">
		<p>
			长名称：<input type="text" name="cropchangename">
		</p>
		<p>
			名称：<input type="text" name="cropName">
		</p>
		<p>
			价格：<input type="text" name="cropPrice">
		</p>
		<p>
			库存：<input type="text" name="cropKucun">
		</p>
		<p>
			运费：<input type="text" name="cropYunfei">
		</p>
		<p>
			发货地：<input type="text" name="cropFahuodi">
		</p>
		<p>
			描述：<input type="text" name="cropDescribe">
		</p>
		<p>
			imaAdd1:<input type="text" name="imaAdd1" maxlength="100000">
		</p>
		<p>
			imaAdd2:<input type="text" name="imaAdd2" maxlength="100000">
		</p>
		<p>
			imaAdd3:<input type="text" name="imaAdd3" maxlength="100000">
		</p>
		<p>
			imaTouxiang:<input type="text" name="imaTouxiang" maxlength="100000">
		</p>

		<p>
			<input type="submit" value="提交">
		</p>
	</form>

</body>
</html>