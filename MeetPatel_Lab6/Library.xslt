<?xml version="1.0" encoding="UTF-8"?> <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">
<html>
<body>
<h2>List of books having amazon rating greater than 4.5</h2> <table border="1">
<tr bgcolor="#9acd32"> <th>Book name</th> <th>Amazon rating</th> </tr>
<xsl:for-each select="library/book">
<xsl:if test="AmazonRating > 4.5"><tr>
<td><xsl:value-of select="BookName"/></td>
<td><xsl:value-of select="AmazonRating"/></td>
</tr></xsl:if>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>


<?xml version="1.0" encoding="UTF-8"?> <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">
<html>
<body>
<h2>fiction books</h2> <table border="1">
<tr bgcolor="#9acd32"> <th>Book name</th> </tr>
<xsl:for-each select="library/book"> <xsl:if test="Genre='Fiction'"> <tr>
<td><xsl:value-of select="BookName"/></td> </tr></xsl:if>
</xsl:for-each> </table> <h2>Non-fiction books</h2> <table border="1">
<tr bgcolor="#9acd32"> <th>Book name</th> </tr>
<xsl:for-each select="library/book"> <xsl:if test="Genre='NonFiction'"> <tr>
<td><xsl:value-of select="BookName"/></td> </tr></xsl:if>
</xsl:for-each> </table> </body> </html> </xsl:template>
</xsl:stylesheet>


<?xml version="1.0" encoding="UTF-8"?> <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">
<html>
<body>
<h2>Book With the Highest Price</h2>
<xsl:for-each select="//Price">
<xsl:sort data-type="number" order="descending"/>
<xsl:if test="position()=1">Highest Price:<xsl:value-of select="."/></xsl:if>
</xsl:for-each >
<xsl:for-each select="library/book">
<xsl:if test="price=The_highest">
<xsl:value-of select="BookName"/>
</xsl:if>
</xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>


<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <xsl:template match="/">
<html>
<body>
<h2>Number of Warehouses in London</h2> <table border="1">
<tr bgcolor="#9acd32"> <th>Warehouses</th> </tr>
<tr>
<td><xsl:value-of select="count(items/warehouse[Location='London'])"/></td>
</tr>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>


<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> <xsl:template match="/">
<html>
<body>
<h2>List of books with specific ISBN Number</h2> <table border="1">
<tr bgcolor="#9acd32"> <th>Book name</th> <th>ISBN</th>
</tr>
<xsl:for-each select="library/book">
<xsl:if test="ISBN = 1338099132">	<tr>
<td><xsl:value-of select="BookName"/></td>
<td><xsl:value-of select="ISBN"/></td>
</tr></xsl:if>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
