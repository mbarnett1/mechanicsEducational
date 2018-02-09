<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<meta charset="utf-8">
<title>Beam</title>
<script src="konva.js"> </script>


<div class="container-fluid">
    <form action="/beamServlet" method="GET">
        Length:
        <input type="text" name="length" id="length" value="100"><br>
        Pin Support Location (m):
        <input type="text" name="pinLocation" id="pinLocation" value="0"><br>
        Roller Support Location (m):
        <input type="text" name="rollerLocation" id="rollerLocation" value="100"><br>
        Load Location (m):
        <input type="text" name="loadLocation" id="loadLocation" value="50"><br>
        Load Magnitude (N):
        <input type="text" name="loadMagnitude" id="loadMagnitude" value="100"><br>
        Load Orientation (deg) 0 is up clockwise is positive:
        <input type="text" name="angle" id="angle" value="180"><br>

        <input type="submit" value="Submit">
    </form>

    <div id="container"></div>
    <div id="container2"></div>
    <script src="beam.js"></script>



    <h2> beam length: ${beam.length} </h2>
    <h2> pin reaction x: ${pinReactionX} </h2>
    <h2> pin reaction y: ${pinReactionY} </h2>
    <h2> roller reaction y: ${rollerReactionY} </h2>









</div>
</body>
</html>

