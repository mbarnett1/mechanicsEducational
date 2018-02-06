<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>

<meta charset="utf-8">
<title>Beam</title>
<script type="text/javascript" src="wz_jsgraphics.js"></script>


<div class="container-fluid">
    <form action="/beamServlet" method="GET">
        Length:
        <input type="text" name="length" id="length" value="0"><br>
        Pin Support Location (m):
        <input type="text" name="pinLocation" id="pinLocation"><br>
        Roller Support Location (m):
        <input type="text" name="rollerLocation" id="rollerLocation"><br>
        Load Location (m):
        <input type="text" name="loadLocation" id="loadLocation"><br>
        Load Magnitude (N):
        <input type="text" name="loadMagnitude" id="loadMagnitude"><br>
        Load Orientation (deg) 0 is up clockwise is positive:
        <input type="text" name="angle" id="angle"><br>


        <input type="submit" value="Submit">
    </form>



    <div id="Canvas" style="position:relative;height:100px;width:100px;"> </div>

    <h2> beam length: ${beamLength} </h2>
    <h2> pin reaction x: ${pinReactionX} </h2>
    <h2> pin reaction y: ${pinReactionY} </h2>
    <h2> roller reaction y: ${rollerReactionY} </h2>








</body>
</html>

<script type="text/javascript">
    jg.fillPolygon(new Array(0,10,200), new Array(0,10,100));


</script>