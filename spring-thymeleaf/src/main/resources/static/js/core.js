/**
 * Active Navigation Bar for which is selected for current page
 * @constructor
 */
function ActiveNavigationBar() {
    $("ul.nav li a[href='" + location.pathname + "']").parent().attr("class", "active");
}

function logout() {

}

$(document).ready(function () {
    ActiveNavigationBar();
    // for logout
    $("#logoutA").click(function () {
        $("#logoutForm").submit();
    });
});

