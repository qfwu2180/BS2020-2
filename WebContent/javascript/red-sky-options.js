var t_browser_has_css3;
var t_css3_array = ['transition','-webkit-transition','-moz-transition','-o-transition','-ms-transition'];
var t_css3_index;
$(document).ready(function(){
    var t_css3_test = $('body');
    for(t_css3_index=0, t_css3_test.css(t_css3_array[t_css3_index],'');t_css3_index<t_css3_array.length&&null==t_css3_test.css(t_css3_array[t_css3_index]);t_css3_test.css(t_css3_array[++t_css3_index],''));
    if(t_css3_index<t_css3_array.length)
        t_browser_has_css3 = true;
    else
        t_browser_has_css3 = false;
    load_filters();
});



//FILTERS
var load_filters = function(){
    $('.filter .filters').each(function(){
        var t_menu_time = 300;   //time of menu animation in miliseconds
        var t_recipe_time = 400;   //time of recipe animation in miliseconds
        var t = $(this);
        var t_container = t.parent('.filtersContainer');
        var t_options = t.children('li');
        var t_options_array = $.makeArray(t_options);
        var t_active_class = 'filtersActive';
        var t_active_select = '.'+t_active_class;
        var t_options_all = 'all';
        var t_options_selected = t_options_all;
        var t_recipes_container = $('.recipes');
        var t_recipes = t_recipes_container.children('.columns');
        var t_categories = [];
        var t_columns = 4;
        var t_top_indent;
        var t_left_indent;
        var t_height;
        var t_width;
        var t_margin_top;
        var t_margin_left;
        t_recipes.each(function(i){
            t_categories.push($(this).attr('data-categories').replace(/^\s+/,'').replace(/\s+$/,'').replace(/\s+/g,' ').toLowerCase().split(' '));
        });
        var t_options_click;
        t_options.click(function(){
            t_options_click(this);
        });
        var t_hover_on;
        var t_hover_off;
        t.hover(function(){
            t_hover_on();
        },function(){
            t_hover_off();
        });
        var t_w = $(window);
        var t_w_level = -1;
        var t_update = function(width_new){
            if(t_w_level!=3&&width_new<=480){
                t_w_level = 3;
                t_hover_on = function(){}
                t_hover_off = function(){}
                t_recipes.removeAttr('style').each(function(i){
                    if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected))
                        $(this).css({display:'block'});
                    else
                        $(this).css({display:'none'});
                });
                t_container.removeAttr('style');
                t.css({width:'auto',marginLeft:0});
                t_recipes_container.removeAttr('style');
                t_options_click = function(e){
                    if(t_options.filter(t_active_select).not(e).removeClass(t_active_class).length){
                        var t_current = $(e);
                        t_current.addClass(t_active_class);
                        t_options_selected = t_current.html().toLowerCase();
                        var t_index = 0;
                        t_recipes.each(function(i){
                            if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                                $(this).css({display:'block'});
                                t_index++;
                            }else{
                                $(this).css({display:'none'});
                            }
                        });
                    }
                }
            }else if(t_w_level!=2&&width_new>480&&width_new<=767){
                t_w_level = 2;
                t_hover_on = function(){}
                t_hover_off = function(){}
                t_recipes.removeAttr('style').each(function(i){
                    if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected))
                        $(this).css({display:'block'});
                    else
                        $(this).css({display:'none'});
                });
                t_container.removeAttr('style');
                t.css({width:'auto',marginLeft:0});
                t_recipes_container.removeAttr('style');
                t_options_click = function(e){
                    if(t_options.filter(t_active_select).not(e).removeClass(t_active_class).length){
                        var t_current = $(e);
                        t_current.addClass(t_active_class);
                        t_options_selected = t_current.html().toLowerCase();
                        var t_index = 0;
                        t_recipes.each(function(i){
                            if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                                $(this).css({display:'block'});
                                t_index++;
                            }else{
                                $(this).css({display:'none'});
                            }
                        });
                    }
                }
            }else if(t_w_level!=1&&width_new>768&&width_new<=959){
                t_w_level = 1;
                t_top_indent = 152;
                t_left_indent = 197;
                t_height = 152;
                t_width = 177;
                t_margin_top = t_height/2;
                t_margin_left = t_width/2;
                (function(){
                    var t_index = 0;
                    t_recipes.each(function(i){
                        $(this).css({position:'absolute',top:t_top_indent*Math.floor(i/t_columns),left:t_left_indent*(i%t_columns)});
                        if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                            $(this).css({display:'block',height:t_height,width:t_width,opacity:1,marginTop:0,marginLeft:0,top:t_top_indent*Math.floor(t_index/t_columns),left:t_left_indent*(t_index%t_columns)});
                            t_index++;
                        }else
                            $(this).css({display:'none',top:0,left:0,height:0,width:0,opacity:0,marginTop:t_margin_top,marginLeft:t_margin_left});
                    });
                    t_recipes_container.css({height:t_top_indent*(1+Math.floor((t_index-1)/t_columns))});
                })();
                t_container.removeAttr('style');
                t.css({width:'auto',marginLeft:0});
                t_hover_on = function(){}
                t_hover_off = function(){}
                t_options_click = function(e){
                    if(t_options.filter(t_active_select).not(e).removeClass(t_active_class).length){
                        var t_current = $(e);
                        t_current.addClass(t_active_class);
                        t_options_selected = t_current.html().toLowerCase();
                        var t_index = 0;
                        t_recipes.each(function(i){
                            if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                                $(this).css({display:'block'}).stop().animate({height:t_height,width:t_width,opacity:1,marginTop:0,marginLeft:0,top:t_top_indent*Math.floor(t_index/t_columns),left:t_left_indent*(t_index%t_columns)},{duration:t_recipe_time,queue:false});
                                t_index++;
                            }else{
                                var t_current_recipe = $(this);
                                t_current_recipe.stop().animate({height:0,width:0,opacity:0,marginTop:t_margin_top,marginLeft:t_margin_left},{duration:t_recipe_time,queue:false,complete:function(){
                                    t_current_recipe.css({display:'none',top:0,left:0});
                                }});
                            }
                        });
                        t_recipes_container.css({height:t_top_indent*(1+Math.floor((t_index-1)/t_columns))});
                    }
                }
            }else if(t_w_level!=0&&width_new>960){
                t_w_level = 0;
                t_top_indent = 173;
                t_left_indent = 247.5;
                t_height = 173;
                t_width = 217.5;
                t_margin_top = t_height/2;
                t_margin_left = t_width/2;
                (function(){
                    var t_index = 0;
                    t_recipes.each(function(i){
                        $(this).css({position:'absolute',top:t_top_indent*Math.floor(i/t_columns),left:t_left_indent*(i%t_columns)});
                        if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                            $(this).css({display:'block',height:t_height,width:t_width,opacity:1,marginTop:0,marginLeft:0,top:t_top_indent*Math.floor(t_index/t_columns),left:t_left_indent*(t_index%t_columns)});
                            t_index++;
                        }else
                            $(this).css({display:'none',top:0,left:0,height:0,width:0,opacity:0,marginTop:t_margin_top,marginLeft:t_margin_left});
                    });
                    t_recipes_container.css({height:t_top_indent*(1+Math.floor((t_index-1)/t_columns))});
                })();
                t_container.css({width:t_options.filter(t_active_select).outerWidth(true)});
                t.css({width:999999,marginLeft:(function(){
                    var t_left = 0;
                    t_options.filter(':lt('+t_options_array.indexOf(t_options.filter(t_active_select)[0])+')').each(function(){
                        t_left += $(this).outerWidth(true);
                    });
                    return -t_left;
                })()});
                t_hover_on = function(){
                    var t_width = 0;
                    t_options.each(function(){
                        t_width += $(this).outerWidth(true);
                    });
                    t.stop().animate({marginLeft:0},{duration:t_menu_time,queue:false});
                    t_container.stop().animate({width:t_width},{duration:t_menu_time,queue:false});
                }
                t_hover_off = function(){
                    var t_left = 0;
                    t_options.filter(':lt('+t_options_array.indexOf(t_options.filter(t_active_select)[0])+')').each(function(){
                        t_left += $(this).outerWidth(true);
                    });
                    t.stop().animate({marginLeft:-t_left},{duration:t_menu_time,queue:false});
                    t_container.stop().animate({width:t_options.filter(t_active_select).outerWidth(true)},{duration:t_menu_time,queue:false});
                }
                t_options_click = function(e){
                    if(t_options.filter(t_active_select).not(e).removeClass(t_active_class).length){
                        var t_current = $(e);
                        t_current.addClass(t_active_class);
                        t_options_selected = t_current.html().toLowerCase();
                        var t_index = 0;
                        t_recipes.each(function(i){
                            if(t_options_all==t_options_selected||-1!=t_categories[i].indexOf(t_options_selected)){
                                $(this).css({display:'block'}).stop().animate({height:t_height,width:t_width,opacity:1,marginTop:0,marginLeft:0,top:t_top_indent*Math.floor(t_index/t_columns),left:t_left_indent*(t_index%t_columns)},{duration:t_recipe_time,queue:false});
                                t_index++;
                            }else{
                                var t_current_recipe = $(this);
                                t_current_recipe.stop().animate({height:0,width:0,opacity:0,marginTop:t_margin_top,marginLeft:t_margin_left},{duration:t_recipe_time,queue:false,complete:function(){
                                    t_current_recipe.css({display:'none',top:0,left:0});
                                }});
                            }
                        });
                        t_recipes_container.css({height:t_top_indent*(1+Math.floor((t_index-1)/t_columns))});
                    }
                }
            }
        }
        t_update(t_w.width());
        t_w.resize(function(){
            t_update(t_w.width());
        });
    });
};




//IE fix
if (!Array.prototype.indexOf) {
    Array.prototype.indexOf = function(obj, start) {
        for (var i = (start || 0), j = this.length; i < j; i++) {
            if (this[i] === obj) {return i;}
        }
        return -1;
    }
}