/**
 * Created by naveen on 1/31/17.
 */

function start() {
    gapi.load('auth2', function() {
        auth2 = gapi.auth2.init({
            client_id: '532411867569-jp7ke86otk5vuakl491vi80tdlsjprs3.apps.googleusercontent.com',
            // Scopes to request in addition to 'profile' and 'email'
            //scope: 'additional_scope'
        });
    });
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}

function signin() {
    // signInCallback defined in step 6.

    auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
};

function onSignIn(googleUser) {
    // Useful data for your client-side scripts:

    var id_token = googleUser.getAuthResponse().id_token;


    var auth2 = gapi.auth2.init();

    if (auth2.isSignedIn.get()) {

        var profile = auth2.currentUser.get().getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        id_token = googleUser.getAuthResponse().id_token;
        console.log("ID AuthResult: " + id_token);
        alert(profile.getName());
    }

}

function signInCallback(authResult) {
    if (authResult['code']) {

        // Hide the sign-in button now that the user is authorized, for example:
        $('#signinButton').attr('style', 'display: none');
        console.log("Hiiii",authResult['code']);

        // Send the code to the server
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/validate',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(authResult),
            success: function(result) {
                console.log("SUCCESS: ", result);
                // Handle or verify the server response.

            },
            processData: false,

        });
    } else {
        // There was an error.
    }
}


