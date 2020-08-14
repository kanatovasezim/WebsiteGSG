(function () {
    'use strict';
    window.addEventListener('load', function () {
        var forms = document.getElementsByClassName('needs-valid');
        // var price = document.getElementById('packagePriceInput').value;
        // var discountPrice = document.getElementById('packageDisPriceInput').value;
        // var p=document.getElementsByName('price');
        // // var d=document.getElementsByName('discountPrice');
        // console.log(price);
        // console.log(discountPrice);
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                // if (price<discount)
                //     form.checkValidity(false);
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

// let message = document.querySelector('.mail-message');
//
// let form = document.querySelector('.mail1');
// form.onsubmit = function(evt) {
//     evt.preventDefault();
//     message.textContent = 'Сообщение отправлено!';
//
// };
