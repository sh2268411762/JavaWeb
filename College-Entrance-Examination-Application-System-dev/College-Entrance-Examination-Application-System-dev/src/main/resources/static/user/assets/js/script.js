initMap=!1,function(e){if("undefined"==typeof jQuery)throw"Requires jQuery to be loaded first";!function(p){"use strict";p("body");var e,o=function(){e&&clearTimeout(e),e=setTimeout(function(){p(window).trigger("resize").trigger("scroll"),e=null},50)};function t(){p(window).off("load.loader"),p(".page-loader").fadeOut(500,function(){p(this).remove()})}p(window).on("load.loader",function(){t()}),setTimeout(t,1e4),p("[data-bar]").each(function(e,t){var i=p(t),o=100*parseFloat(parseFloat(i.attr("aria-valuenow")/i.attr("aria-valuemax")));o<0?o=0:100<o&&(o=100),i.css("width",o+"%")}),p(".navbar-toggler").on("click",function(e){e.preventDefault(),p(this).toggleClass("active").closest("header").toggleClass("active")}),p('[data-role="nav-toggler"], .nav-arrow').on("click",function(e){e.preventDefault(),p(this).parent().toggleClass("active")}),p('[data-role="nav-self-toggle"]').on("click",function(e){e.preventDefault(),p(this).toggleClass("active")});var i=function(){0<p(window).scrollTop()?(p(".scroll-top").removeClass("disabled"),window.innerHeight+window.scrollY>=document.body.offsetHeight?p(".scroll-top").addClass("end"):p(".scroll-top").removeClass("end")):p(".scroll-top").addClass("disabled")};i(),p(window).on("scroll resize orientationchange focus",i),p(".scroll-top").on("click",function(e){e.preventDefault(),p("html, body").animate({scrollTop:0},1e3)}),p(".form-check .form-check-icon").on("click",function(e,t){var i=p(this).closest(".form-check").find("input.form-check-input"),o="radio"===i.attr("type")||!i.prop("checked");i.prop("checked",o)}),p('[data-role="accordion-item"]').each(function(e,t){var i=p(t);i.find('[data-role="accordion-toggle"]').on("click",function(e){e.preventDefault();var t=i.closest('[data-role="accordion-list"]');t.find('[data-role="accordion-item"]').not(i).removeClass("active"),i.addClass("active"),t.trigger("resize"),setTimeout(function(){o()},2e3)})}),p('[data-role="accordion-list"]').each(function(e,t){var i=p(t),o=function(){var e=i.find('.active[data-role="accordion-item"] [data-role="accordion-content"]');e.length?(e=e[0],i.css("minHeight",Math.max(e.clientHeight,e.offsetHeight,e.scrollHeight))):i.css("minHeight","")};i.on("resize",o),p(window).on("resize",o),i.find("[src]").on("load",o),o()}),p("[data-left]").each(function(e,t){p(t).css("left",p(t).data("left"))}),p("[data-top]").each(function(e,t){p(t).css("top",p(t).data("top"))}),p("[data-svg]").each(function(e,t){var i=p(t);i.load(i.data("svg"),null,o)}),p("[data-background]").each(function(e,t){var i=p(t);i.css("backgroundImage","url("+i.data("background")+")")}),p('[data-slider="top-main"]').each(function(e,t){p(t).find(".slick-slides").slick({infinite:!0,dots:!1,arrows:!1,asNavFor:'[data-slider="top-thumb"] .slick-slides'})}),p('[data-slider="top-side-dots"]').each(function(e,t){p(t).find(".slick-slides").slick({infinite:!0,dots:!0,arrows:!1})}),p('[data-slider="top-side-numbers"]').each(function(e,t){p(t).find(".slick-slides").slick({infinite:!0,dots:!0,arrows:!1,customPaging:function(e,t){return p(e.$slides[t]).data(),"<button>0"+(t+1)+"</button>"}})}),p('[data-slider="top-thumb"]').each(function(e,t){var i=p(t);i.find(".slick-slides").slick({slidesToShow:3,centerPadding:0,centerMode:!0,infinite:!0,dots:!1,arrows:!0,focusOnSelect:!0,swipeToSlide:!0,nextArrow:i.find(".slick-arrow-next"),prevArrow:i.find(".slick-arrow-prev"),asNavFor:'[data-slider="top-main"] .slick-slides',responsive:[{breakpoint:992,settings:{slidesToShow:3}},{breakpoint:768,settings:{slidesToShow:2}},{breakpoint:576,settings:{slidesToShow:1}}]})}),p('[data-slider="images-carousel"]').each(function(e,t){var i=p(t);i.find(".slick-slides").slick({slidesToShow:4,infinite:!0,dots:!1,arrows:!0,swipeToSlide:!0,nextArrow:i.find(".slick-arrow-next"),prevArrow:i.find(".slick-arrow-prev"),responsive:[{breakpoint:992,settings:{slidesToShow:3}},{breakpoint:768,settings:{slidesToShow:2}},{breakpoint:576,settings:{slidesToShow:1}}]})}),p('[data-slider="featured-products"]').each(function(e,t){var i=p(t);i.find(".slick-slides").slick({slidesToShow:3,infinite:!0,dots:!1,arrows:!0,focusOnSelect:!0,swipeToSlide:!0,nextArrow:i.find(".slick-arrow-next"),prevArrow:i.find(".slick-arrow-prev"),responsive:[{breakpoint:992,settings:{slidesToShow:2}},{breakpoint:768,settings:{slidesToShow:1}}]})}),p('[data-slider="testimonials"]').each(function(e,t){var i=p(t);i.find(".slick-slides").slick({slidesToShow:3,infinite:!0,dots:!1,arrows:!0,focusOnSelect:!0,swipeToSlide:!0,nextArrow:i.find(".slick-arrow-next"),prevArrow:i.find(".slick-arrow-prev"),responsive:[{breakpoint:992,settings:{slidesToShow:2}},{breakpoint:768,settings:{slidesToShow:1}}]})}),p('[data-role="fill-line"]').each(function(e,t){var r,i=p(t),o=i.find('> [data-role="fill-line-segment"]'),n=p([]),l=100,d=100,s=i.width();o.each(function(e,t){var i=p(t),o=i.data(),a=o.hasOwnProperty("minWidth")?o.minWidth:0;o.hasOwnProperty("width")?(r=o.width,o.hasOwnProperty("maxWidth")&&o.maxWidth,s<o.minWidth&&(s=o.minWidth),s>o.maxWidth&&(s=o.maxWidth),l-=s,i.width(s+"%")):(n=n.add(i),d-=a)}),n.each(function(e,t){var i=p(t),o=i.data(),a=o.hasOwnProperty("maxWidth")?o.maxWidth:100,n=o.hasOwnProperty("minWidth")?o.minWidth:0,s=o.hasOwnProperty("prefferedWidth")?o.prefferedWidth:o.minWidth+(o.maxWidth-o.minWidth)/2;a=Math.min(a,s,d,l),r=a<=n?n:Math.random()*(a-n)+n,l-=r,i.width(r+"%")}),0<l&&o.last().width(r+l+"%")}),p("[data-waypoint-counter]").each(function(e,i){p(i).waypoint({handler:function(){var t=p(i).data("waypointCounterExtra");p(i).prop("CounterValue",0).animate({CounterValue:p(i).data("waypointCounter")},{duration:2e3,step:function(e){p(this).text(Math.ceil(e)+t||"")}}),this.destroy()},offset:"bottom-in-view"})}),p(".input-spin").each(function(e,t){var i=p(t),a=i.find(".form-control"),n=i.find(".input-decrement"),s=i.find(".input-increment"),o=function(e){var t=parseInt(a.val()),i=parseInt(a.attr("min")),o=parseInt(a.attr("max"));e&&(t=isNaN(t)?0:t+e,a.val(t)),!isNaN(i)&&t<=i?(n.addClass("disabled"),a.val(i)):n.removeClass("disabled"),!isNaN(o)&&o<=t?(s.addClass("disabled"),a.val(o)):s.removeClass("disabled")};o(),a.on("blur",function(){o()}),n.on("click",function(){o(-1)}),s.on("click",function(){o(1)})}),p(".form-control-file").each(function(e,t){var i=p(t);i.on("change.fileField",function(){var e=p(this).closest(".input-group-file").find(".form-control");e.val(this.value?this.value:e.attr("data-value-current")||"")}).triggerHandler("change.fileField");var o=i.closest("form");o.length&&o.data("fileFields",(o.data("fileFields")||p([])).add(i)).off(".fileFields").on("reset.fileFields",function(){var e=p(this);setTimeout(function(){e.data("fileFields").each(function(e,t){p(t).triggerHandler("change.fileField")})})}),i.closest(".input-group-file").find(".form-control, .form-control-file-btn").on("click",function(e){e.preventDefault(),i.trigger("click")})}),"undefined"!=typeof FileReader&&p(".file-preview").each(function(e,t){var i=p(t),o=!1,a=p(t).closest(".form-group-preview").find(".form-control-file");i.find(".file-preview-image img")&&i.addClass("has-file"),i.on("click",function(e){e.preventDefault(),a.trigger("click")}),(o=new FileReader).onloadstart=function(){i.removeClass("has-file")},o.onload=function(e){i.find(".file-preview-image").empty().html('<img src="'+e.target.result+'" alt="" />'),i.addClass("has-file")},a.on("change.imageField",function(){var e=this.files?this.files:this.currentTarget.files;e.length?o.readAsDataURL(e[0]):i.removeClass("has-file").find(".file-preview-image").empty()});var n=i.closest("form");n.length&&n.data("imageFields",(n.data("imageFields")||p([])).add(a)).off(".imageFields").on("reset.imageFields",function(){var e=p(this);setTimeout(function(){e.data("imageFields").each(function(e,t){p(t).find('input[type="file"]').triggerHandler("change.imageField")})})})});p("[data-theme-accordion] .entity-expand-head").on("click",function(e){e.preventDefault();var t=p(this).closest("[data-theme-accordion]"),i=t.data("themeAccordion");p('.active[data-theme-accordion="'+i+'"]').not(t).removeClass("active"),t.toggleClass("active")}),p("[data-size").each(function(e,t){var i,o=p(t),a=p(t).data("size"),n=typeof a,s={};switch(n){case"string":0<(a=a.split(";")).length&&(i=a[0].trim())&&(s.width=i),1<a.length&&(i=a[1].trim())&&(s.height=i);break;case"number":s.width=a}o.css(s)});var c=function(e,t,i){var o=t.trim().split(" "),a=i,n=0;switch(o[0].trim()){case"left":case"top":case"right":case"bottom":a=o[0].trim();break;case"bot":a="bottom";break;default:n=o[0].trim()}1<o.length&&(n=o[1].trim()||"0"),e[a]=n};p("[data-at").each(function(e,t){var i,o=p(t),a=p(t).data("at"),n=typeof a,s={position:"absolute",transformOrigin:"50% 50%"},r="-50%",l="-50%",d=[];switch(n){case"string":0<(a=a.split(";")).length&&c(s,a[0],"left"),1<a.length&&c(s,a[1],"top"),2<a.length&&(i=a[2].trim())&&d.push("rotate("+i+")");break;case"number":s.left=a}s.hasOwnProperty("bottom")&&(l="50%"),s.hasOwnProperty("right")&&(r="50%"),d.push("translate("+r+", "+l+")"),s.transform=d.join(" "),o.css(s)}),gMapStyles="undefined"==typeof gMapStyles?{}:gMapStyles,initMap=function(){var f={};p.each(gMapStyles,function(e,t){f[e]=new google.maps.StyledMapType(t.styles,t.options)}),p(".gmap").each(function(e,t){var i=p(t),o=i.data(),a={lat:o.lat,lng:o.lng},n={lat:o.centerLat||a.lat,lng:o.centerLng||a.lng},s=o.controlPosition||"LEFT_BOTTOM",r=o.mapTypePosition||"TOP_LEFT",l=new google.maps.Map(t,{center:768<=p(window).width()?n:a,zoom:o.zoom||15,scrollwheel:!1,zoomControl:!0,zoomControlOptions:{position:google.maps.ControlPosition.LEFT_CENTER},streetViewControl:!0,streetViewControlOptions:{position:google.maps.ControlPosition[s]},mapTypeControlOptions:{mapTypeIds:["roadmap","satellite","hybrid","terrain","styled_map"],position:google.maps.ControlPosition[r],style:google.maps.MapTypeControlStyle.DEFAULT},fullscreenControl:!0}),d=o.mapStyle&&f[o.mapStyle]?o.mapStyle:"default",c=!!f[d]&&f[d];new google.maps.Marker({position:a,map:l,icon:o.marker||"./assets/images/parts/map-marker.png"}),c&&(l.mapTypes.set(d,c),l.setMapTypeId(d)),p(window).on("resize",function(){google.maps.event.trigger(l,"resize"),l.setCenter(768<=p(window).width()?n:a)})})}}(jQuery)}();