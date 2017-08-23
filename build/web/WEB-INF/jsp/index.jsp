<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Movie Page</title>
    <link rel="stylesheet" href="../indexStyle.css" type="text/css">
</head>

<body>
    <header>

        <nav id="menu-bar">
            <div id="heading">
                <h1>Like it or Leave it</h1>
                <img src="../film-reel.png" alt="Logo">
            </div>
            <ul>
                <li><a href="#">Log in</a></li>
                <li><a href="#">Top Lists</a></li>
                <li><a href="#">Gallery</a></li>
                <li><a href="#">About Us</a></li>
            </ul>
        </nav>
    </header>
    <div id="movie">

        <div id="movie-holder">
            <div id="cover">
                <img src="../La-Grande-Bellezza.jpg" alt="">
            </div>
            <div id="movie-info">
                <h1>La Grande Bellezza</h1>
                <p class="director">Paolo Sorentino</p>
            </div>
            <div id="gallery">
                <span>Show gallery</span>
                <a href=""></a>
            </div>
        </div>
        <div id="like-or-leave">
            <button id="like"></button>
            <div class="arrows">
                <a href=""><img src="../arrowUp.png" alt="ArrowUp" id="arrow-up" class="arrow"></a>
                <hr>
                <a href=""><img src="../arrowDown.png" alt="ArrowDown" id="arrow-down" class="arrow"></a>
            </div>
            <button id="dislike"></button>
        </div>

        <div id="desc">
            <div id="description">
                <p>The Great Beauty (Italian: La grande bellezza [la ˈɡrande belˈlettsa]) is a 2013 Italian art drama film co-written and directed by Paolo Sorrentino. Filming took place in Rome starting on 9 August 2012. It premiered at the 2013 Cannes Film Festival where it was screened in competition for the Palme d'Or. It was shown at the 2013 Toronto International Film Festival and at the 2013 Reykjavik European Film Festival.</p>
                <br>
                <p>The film won Best Foreign Language Film at the 86th Academy Awards, as well as the Golden Globe and the BAFTA award in the same category. It is a co-production between the Italian Medusa Film and Indigo Film and the French Babe Films, with support from Banca Popolare di Vicenza, Pathé and France 2 Cinéma. With a production budget of €9.2 million, the film has so far grossed over $24 million worldwide.</p>
            </div>
            <div id="towatch">
                <span>Watch Later</span>
                <a href=""></a>
            </div>
        </div>
    </div>
    <footer>
        <p>Developed by Marko Radulović ©</p>
        <a id="google"></a>
        <a id="twitter"></a>
        <a id="fb"></a>
    </footer>
</body>

</html>
