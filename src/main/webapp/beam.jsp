<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>


<div class="container-fluid">
    <form action="/beamServlet" method="GET">
        Length:
        <input type="text" name="length" id="length" value="${beam.length}"><br>
        Pin Support Location:
        <input type="text" name="pinLocation" id="pinLocation"><br>
        Roller Support Location:
        <input type="text" name="rollerLocation" id="rollerLocation"><br>
        Load Location:
        <input type="text" name="loadLocation" id="loadLocation"><br>
        Load Load Magnitude:
        <input type="text" name="loadMagnitude" id="loadMagnitude"><br>

        <input type="submit" value="Submit">
    </form>


<h2> ${beam.length} </h2>






</div>

</body>
</html>