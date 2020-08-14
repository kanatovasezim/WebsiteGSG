"use strict";
// Wrapping all JavaScript code into a IIFE function for prevent global variables creation
// and pass in jQuery to be mapped to $.
(function($) {
    jQuery(document).ready(function () {

        //team-slider
        $('.team-slider-item span').on('mouseenter', function () {
            var $item = $(this).closest('.team-slider-item');
            $('.team-slider-item.active').removeClass('active');
            $item.addClass('active');
        });

        //team-slider title last word
        $('.slide-title span').html(function(){
            // separate the text by spaces
            var text= $(this).text().split(' ');
            // drop the last word and store it in a variable
            var last = text.pop();
            // join the text back and if it has more than 1 word add the span tag
            // to the last word
            return text.join(" ") + (text.length > 0 ? ' <span class="last">'+last+'</span>' : last);
        });

    });
//end of IIFE function
})(jQuery);