$(document).ready(function() {
    function jump(count) {
        window.setTimeout(function(){
            count--;
            if(count > 0) {
                $('#num').attr('innerHTML', count);
                jump(count);
            } else {
                location.href="/doctor_index";
            }
        }, 1000);
    }
    jump(3);
});