<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
<form action="hello" method="post">
<table>
<tr>
<td><label>Kwota kredytu:</label></td>
<td><input type="number" name="amount"></td>
</tr>
<tr>
<td><label>Ilość rat:</label></td>
<td><input type="number" name="rates_count"></td>
</tr>
<tr>
<td><label>Oprocentowanie:</label></td>
<td><input type="number" name="percent"></td>
</tr>
<tr>
<td><label>Opłata stała:</label></td>
<td><input type="number" name="const_rate_amount"></td>
</tr>
<tr>
<td><label>Rodzaj rat:</label></td>
<td>
<input type="radio" name="rates_type" value="decrease">Malejące
<input type="radio" name="rates_type" value="const">Stałe
</td>
</tr>
</table>
<br/>
<input type="submit" value="Harmonogram spłat >">
</form>
</body>
</html>