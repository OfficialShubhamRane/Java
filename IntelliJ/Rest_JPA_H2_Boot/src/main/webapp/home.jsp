<%@ page  language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
</head>
<body>

    <h1> Home Page</h1>

    <h3> Add alien from here</h3>
    <form action="addAlien">

        <label>aid: </label><br>
        <input type="text" name="aid"><br>

        <label>aName: </label><br>
        <input type="text" name="aName"><br>

        <label>tech: </label><br>
        <input type="text" name="tech"><br>
        <input type="submit">

    </form>
    <br>

    <h3> Retrieve alien from here BY AID</h3>
    <form action="fetchAlien">

        <label>aid: </label><br>
        <input type="text" name="aid"><br>
        <input type="submit">

    </form>
    <br>

    <h3> Delete alien from here</h3>
    <form action="deleteAlien">

        <label>aid: </label><br>
        <input type="text" name="aid"><br>
        <input type="submit">

    </form>
    <br>

</body>
</html>