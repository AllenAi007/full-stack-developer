/**
 * Active Navigation Bar for which is selected for current page
 * @constructor
 */
function ActiveNavigationBar() {
    $("ul.nav li a[href='" + location.pathname + "']").parent().attr("class", "active");
}

$(document).ready(function () {
    ActiveNavigationBar();
});