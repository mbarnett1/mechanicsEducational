<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<meta charset="utf-8">
<title>Truss</title>

<div class="container-fluid">
    <form action="/trussServlet" method="GET">
        Member 1:
        x1<input type="text" name="1x1" id="1x1">
        y1<input type="text" name="1y1" id="1y1">
        x2<input type="text" name="1x2" id="1x2">
        y2<input type="text" name="1y2" id="1y2">
        <br>

        Member 2:
        x1<input type="text" name="2x1" id="2x1">
        y1<input type="text" name="2y1" id="2y1">
        x2<input type="text" name="2x2" id="2x2">
        y2<input type="text" name="2y2" id="2y2">
        <br>

        Member 3:
        x1<input type="text" name="3x1" id="3x1">
        y1<input type="text" name="3y1" id="3y1">
        x2<input type="text" name="3x2" id="3x2">
        y2<input type="text" name="3y2" id="3y2">
        <br>
        <br>
        <br>

        Roller Support:
        x<input type="text" name="rx" id="rx">
        y<input type="text" name="ry" id="ry">
        <br>

        Pin Support:
        x<input type="text" name="px" id="px">
        y<input type="text" name="py" id="py">
        <br>


        Force:
        magnitude<input type="text" name="fm" id="fm">
        angle    <input type="text" name="fa" id="fa">
        x        <input type="text" name="fx" id="fx">
        y        <input type="text" name="fy" id="fy">
        <br>

        <input type="submit" value="Submit">

    </form>
</div>




</body>
</html>
