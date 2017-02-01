<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="532411867569-jp7ke86otk5vuakl491vi80tdlsjprs3.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
    </script>
    <script src="https://apis.google.com/js/client:platform.js?onload=start" async defer>
    </script>

    <script type="text/javascript" src="/resources/js/home.js" />

    <script>
        function start() {
            gapi.load('auth2', function() {
                auth2 = gapi.auth2.init({
                    client_id: '532411867569-jp7ke86otk5vuakl491vi80tdlsjprs3.apps.googleusercontent.com',
                    // Scopes to request in addition to 'profile' and 'email'
                    //scope: 'additional_scope'
                });
            });
        }
    </script>

</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>


<a href="#" onclick="signOut();">Sign out</a>


<button id="signinButton" onclick="signin()">Sign in with Google</button>

</body>
</html>