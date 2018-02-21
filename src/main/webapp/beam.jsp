<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<meta charset="utf-8">
<title>Beam</title>
<script src="konva.js"> </script>
<script src="beam.js"></script>


<div class="container-fluid">
    <form action="/beamServlet" method="GET">
        Length:
        <input type="text" name="length" id="length" value="${beam.length}" required><br>
        Pin Support Location (m):
        <input type="text" name="pinLocation" id="pinLocation" value="${beam.pinDistance}" required><br>
        Roller Support Location (m):
        <input type="text" name="rollerLocation" id="rollerLocation" value="${beam.rollerDistance}" required><br>
        Load Location (m):
        <input type="text" name="loadLocation" id="loadLocation" value="${beam.forceDistance}" required><br>
        Load Magnitude (N):
        <input type="text" name="loadMagnitude" id="loadMagnitude" value="${beam.force}" required><br>
        Load Orientation (deg) 0 is up clockwise is positive:
        <input type="text" name="angle" id="angle" value="${beam.forceAngle*180/3.1415926535}" required><br>



        <input type="submit" value="Submit">


    </form>

    <div id="container"></div>
    <div id="container2"></div>


    <h2> pin reaction x: ${beam.pinReactionX} </h2>
    <h2> pin reaction y: ${beam.pinReactionY} </h2>
    <h2> roller reaction y: ${beam.rollerReactionY} </h2>

    <script>
        createDiagram();
    </script>









</div>
</body>
</html>

