<%-- 
    Document   : afficherSujet
    Created on : 17 nov. 2017, 20:30:55
    Author     : HP
--%>

<%@page import="Model.Beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Beans.commentaire"%>
<%@page import="Model.Beans.Sujet"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta name="Generator" content="Drupal 7 (http://drupal.org)" />
    <link rel="canonical" href="/forum-plus/en/forum/learn-d7-coding-or-d8" />
    <link rel="shortlink" href="/forum-plus/en/node/69" />
    <link rel="shortcut icon" href="https://demo.weebpal.com/forum-plus/sites/all/themes/forum_plus/favicon.ico" type="image/vnd.microsoft.icon" />
    <title>Jeune Forum</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="HandheldFriendly" content="true" >
    <meta name="apple-touch-fullscreen" content="YES" >
    <link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_NkdTB0Ds0gO6QaQ3Ao68vRMpULGJnFODbJpqRaVre0E.css" media="all" />
    <link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_rsFpG9NJN-BA74v-Fc0S7W0C-Xi30j-9YfzgimEuZc4.css" media="all" />
    <link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_OaYsGw0EJ0GPB24Fldg8einkRlNVsqvYUB_tlGva1sU.css" media="all" />
    <link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_ayfZgHrCt2ILFwX7dUhpCp-XjgVji4HCU8MX0WVYh4I.css" media="all" />
    <link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_M5_Pu5tRF5Wc2rxBuJn-TcQv32cGlqnsEA9yKb1XHjY.css" media="all" />
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_JLxuxbhhrFRy-sBnijHkR0TGGHgiukMPv94zvDWgQ3g.js"></script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_Ppr5AOv5GkdSTdDgONfw1UyTWrMn0kcR9ik2kCHyspQ.js"></script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_7o34_CSAfa1KVfkQFFDB2pJEG0y7zSPJLXOA99PTPK8.js"></script>
    <script type="text/javascript">
        <!--//--><![CDATA[//><!--
        var switchTo5x = true;
        //--><!]]>
    </script>
    <script type="text/javascript" src="https://ws.sharethis.com/button/buttons.js"></script>
    <script type="text/javascript">
        <!--//--><![CDATA[//><!--
        if (stLight !== undefined) { stLight.options({"publisher":"dr-a85e6aaa-c9f-35e2-a90b-580084f3d3b","version":"5x"}); }
        //--><!]]>
    </script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_D5Bdu0sUiQhrSqYMAeYlMQy4jnLFiXA3uqamzyrd8lw.js"></script>
    <script type="text/javascript">
        <!--//--><![CDATA[//><!--
          (function ($) {
            Drupal.behaviors.skinMenuAction = {
              attach: function (context) {
                jQuery(".change-layout-button").on("click", function() {
                  var layout_class = $(this).attr("id");
                  var layout_width = 1250;
                  jQuery.cookie("weebpal_layout", layout_class, {path: "/forum-plus/"});
                  jQuery("#page").removeAttr("style");
                  jQuery("#page").removeClass("boxed");
                  jQuery(".background").addClass("hidden");
                  var current_background = jQuery.cookie("weebpal_background");
                  jQuery("body").removeClass(current_background);
                  if (layout_class != "layout-default") {
                    jQuery("#page").css("max-width", layout_width);
                    jQuery("#page").css("margin", "0 auto");
                    jQuery("#page").addClass("boxed");
                    jQuery(".background").removeClass("hidden");
                    jQuery("body").addClass(current_background);
                  }
                  $(".change-layout-button").removeClass("active");
                  if(!$(this).hasClass("active"))
                      $(this).addClass("active");
                  return false;
                });
              }
            }
          })(jQuery);

        //--><!]]>
    </script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_9fhVLQWhPXHROlaFsf8AKyig-CwdeXLtzhWD1BHwfbw.js"></script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_yEv7Gmhd9xDxEy-vpkTFdRiHgIGkxIw_0t26IFwOI_Q.js"></script>
    <script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_4yi5kXu8VAk3CNUNYxSvMsDMLg-N5H1YjjcABGw2Lu8.js"></script>
    <script type="text/javascript">
        <!--//--><![CDATA[//><!--
        jQuery.extend(Drupal.settings, {"basePath":"\/forum-plus\/","pathPrefix":"en\/","ajaxPageState":{"theme":"forum_plus","theme_token":"zJxO-K44cS4G9xUGvS3GcNHn40O8SmdI8QlVFc4xBKs","jquery_version":"1.8","js":{"sites\/all\/modules\/jquery_update\/replace\/jquery\/1.8\/jquery.min.js":1,"misc\/jquery.once.js":1,"misc\/drupal.js":1,"sites\/all\/modules\/jquery_update\/replace\/ui\/ui\/minified\/jquery.ui.core.min.js":1,"sites\/all\/modules\/jquery_update\/replace\/ui\/external\/jquery.cookie.js":1,"sites\/all\/modules\/jquery_update\/replace\/misc\/jquery.form.min.js":1,"misc\/ajax.js":1,"sites\/all\/modules\/jquery_update\/js\/jquery_update.js":1,"sites\/all\/modules\/modal_forms\/js\/modal_forms_login.js":1,"misc\/progress.js":1,"sites\/all\/modules\/ctools\/js\/modal.js":1,"sites\/all\/modules\/modal_forms\/js\/modal_forms_popup.js":1,"0":1,"https:\/\/ws.sharethis.com\/button\/buttons.js":1,"1":1,"sites\/all\/libraries\/ddslick\/jquery.ddslick.min.js":1,"2":1,"sites\/all\/modules\/fivestar\/js\/fivestar.js":1,"sites\/all\/libraries\/chosen\/chosen.jquery.min.js":1,"sites\/all\/modules\/lang_dropdown\/lang_dropdown.js":1,"sites\/all\/modules\/chosen\/chosen.js":1,"sites\/all\/themes\/forum_plus\/vendor\/bootstrap\/js\/bootstrap.js":1,"sites\/all\/themes\/forum_plus\/js\/jquery.smooth-scroll.js":1,"sites\/all\/themes\/forum_plus\/js\/jquery.cookie.js":1,"sites\/all\/themes\/forum_plus\/js\/jquery.matchHeight.js":1,"sites\/all\/themes\/forum_plus\/js\/moment.js":1,"sites\/all\/themes\/forum_plus\/js\/accordion_menu.js":1,"sites\/all\/themes\/forum_plus\/js\/weebpal.js":1,"sites\/all\/themes\/forum_plus\/js\/forum_plus.js":1},"css":{"modules\/system\/system.base.css":1,"modules\/system\/system.menus.css":1,"modules\/system\/system.messages.css":1,"modules\/system\/system.theme.css":1,"misc\/ui\/jquery.ui.core.css":1,"misc\/ui\/jquery.ui.theme.css":1,"sites\/all\/libraries\/chosen\/chosen.css":1,"sites\/all\/modules\/chosen\/css\/chosen-drupal.css":1,"modules\/book\/book.css":1,"sites\/all\/modules\/calendar\/css\/calendar_multiday.css":1,"modules\/comment\/comment.css":1,"sites\/all\/modules\/date\/date_api\/date.css":1,"modules\/field\/theme\/field.css":1,"sites\/all\/modules\/message\/message_example\/css\/message_example.css":1,"modules\/node\/node.css":1,"modules\/search\/search.css":1,"modules\/user\/user.css":1,"modules\/forum\/forum.css":1,"sites\/all\/modules\/views\/css\/views.css":1,"sites\/all\/modules\/ckeditor\/css\/ckeditor.css":1,"sites\/all\/modules\/ctools\/css\/ctools.css":1,"sites\/all\/modules\/ctools\/css\/modal.css":1,"sites\/all\/modules\/modal_forms\/css\/modal_forms_popup.css":1,"sites\/all\/modules\/tagclouds\/tagclouds.css":1,"sites\/all\/modules\/advanced_forum\/styles\/naked\/advanced-forum.naked.structure.css":1,"sites\/all\/themes\/forum_plus\/css\/advanced_forum\/plus\/advanced-forum.plus.style.css":1,"sites\/all\/modules\/advanced_forum\/styles\/naked\/advanced-forum.naked.images.css":1,"sites\/all\/themes\/forum_plus\/css\/advanced_forum\/plus\/advanced-forum.plus.images.css":1,"sites\/all\/modules\/lang_dropdown\/ddslick\/ddsDefault.css":1,"sites\/all\/modules\/fivestar\/css\/fivestar.css":1,"sites\/all\/modules\/fivestar\/widgets\/basic\/basic.css":1,"sites\/all\/themes\/forum_plus\/vendor\/bootstrap\/css\/bootstrap.css":1,"sites\/all\/themes\/forum_plus\/vendor\/bootstrap\/css\/bootstrap-theme.css":1,"sites\/all\/themes\/forum_plus\/css\/styles.css":1}},"CToolsModal":{"loadingText":"Loading...","closeText":"Close Window","closeImage":"\u003Cimg src=\u0022https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/ctools\/images\/icon-close-window.png\u0022 alt=\u0022Close window\u0022 title=\u0022Close window\u0022 \/\u003E","throbber":"\u003Cimg src=\u0022https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/ctools\/images\/throbber.gif\u0022 alt=\u0022Loading\u0022 title=\u0022Loading...\u0022 \/\u003E"},"modal-popup-small":{"modalSize":{"type":"fixed","width":500,"height":350},"modalOptions":{"opacity":0.85,"background":"#000"},"animation":"fadeIn","modalTheme":"ModalFormsPopup","throbber":"\u003Cimg src=\u0022https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/modal_forms\/images\/loading_animation.gif\u0022 alt=\u0022Loading...\u0022 title=\u0022Loading\u0022 \/\u003E","closeText":"Close"},"modal-popup-medium":{"modalSize":{"type":"fixed","width":550,"height":500},"modalOptions":{"opacity":0.85,"background":"#000"},"animation":"fadeIn","modalTheme":"ModalFormsPopup","throbber":"\u003Cimg src=\u0022https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/modal_forms\/images\/loading_animation.gif\u0022 alt=\u0022Loading...\u0022 title=\u0022Loading\u0022 \/\u003E","closeText":"Close"},"modal-popup-large":{"modalSize":{"type":"scale","width":0.8,"height":0.8},"modalOptions":{"opacity":0.85,"background":"#000"},"animation":"fadeIn","modalTheme":"ModalFormsPopup","throbber":"\u003Cimg src=\u0022https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/modal_forms\/images\/loading_animation.gif\u0022 alt=\u0022Loading...\u0022 title=\u0022Loading\u0022 \/\u003E","closeText":"Close"},"lang_dropdown":{"language":{"jsWidget":{"languageicons":{"en":"https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/languageicons\/flags\/en.png","ar":"https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/languageicons\/flags\/ar.png","fr":"https:\/\/demo.weebpal.com\/forum-plus\/sites\/all\/modules\/languageicons\/flags\/fr.png"},"widget":"ddslick","width":"165","height":"0","showSelectedHTML":1,"imagePosition":"left"}}},"urlIsAjaxTrusted":{"\/forum-plus\/en\/forum\/learn-d7-coding-or-d8":true},"chosen":{"selector":"select#edit-order, select#edit-sort, .forum-tools select, select#edit-forum","minimum_single":0,"minimum_multiple":20,"minimum_width":170,"options":{"disable_search":true,"disable_search_threshold":0,"search_contains":false,"placeholder_text_multiple":"Choose some options","placeholder_text_single":"Choose an option","no_results_text":"No results match","inherit_select_classes":true}}});
        //--><!]]>
    </script>
</head>
<body class="html front not-logged-in one-sidebar sidebar-first page-forum i18n-en" onLoad="myFunction()">
<%
if(null == session.getAttribute("user") ) {
    response.sendRedirect("svtUser");
    return;
}
%>
    <div id="skip-link">
        <a href="#main-content" class="element-invisible element-focusable">Skip to main content</a>
    </div>
    <div id="page" >
        <section id="headline" class="headline section">
            <div class="container">
                <div class="region region-headline">
                    <div id="block-block-1" class="block block-block"></div>
                    <div id="block-system-user-menu" class="block block-system block-menu">
                        <div class="block-inner">    
                            <div class="content">
                                <a href="svtUser?action=lagout">Déconnexion</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="block-search-form" class="block block-search">
                    <div class="block-inner">
                        <div class="content">
                            <form action="svtRecherche" method="post" id="search-block-form" accept-charset="UTF-8">
                                <div>
                                    <div class="container-inline">
                                        <h2 class="element-invisible">Search form</h2>
                                        <div class="form-item form-type-textfield form-item-search-block-form">
                                            <label class="element-invisible" for="edit-search-block-form--2">Search </label>
                                            <input title="Enter the terms you wish to search for." type="text" id="edit-search-block-form--2" name="search_block_form" value="" size="15" maxlength="128" class="form-text" />
                                        </div>
                                        <div class="form-actions form-wrapper" id="edit-actions">
                                            <input type="submit" id="edit-submit" name="op" value="Search" class="form-submit" />
                                        </div>
                                        <input type="hidden" name="form_build_id" value="form-SElngE_vUeVH7vtLu4cbVm1x7PVU9ts91eTBKe7dDSE" />
                                        <input type="hidden" name="form_id" value="search_block_form" />
                                    </div>
                                </div>
                            </form>  
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>      
    <header id="header" class="header section">
        <div class="container">
            <div class="navbar-header">
                <a href="svtTheme" title="Back to Home" rel="home" id="logo">
                    <img src="images\logo.png"/>
                </a>
                <div class="region region-header">
                    <div id="block-block-12" class="block block-block submenu-extend">
                        <div class="block-inner">     
                            <script>
                                function myFunction(){
                                    setInterval(function(){  
                                        var x = new Date().toLocaleString();
                                        document.getElementById("timer").innerHTML=x;
                                     },1000);
                                     }
                            </script>
                            <div class="content">
                                <p id="timer"></p> 
                            </div>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <nav class="collapse navbar-collapse  navbar navbar-default width" id="main-menu-inner">
                <div class="container-inner">
                    <span class="btn-close"><i class="fa fa-times"></i></span>
                    <div class="region region-main-menu">
                        <div id="block-system-main-menu" class="block block-system block-menu">
                            <div class="block-inner">  </div>
                        </div>
                    </div>
                </div>
            </nav>
            <a id="menu-toggle" class="navbar-toggle" href="#menu-toggle">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </div>
    </header>
    <section id="welcome" class="section-title section">
        <div class="container">
            <div class="region region-welcome">
                <div id="block-block-9" class="block block-block welcome-block">
                    <div class="block-inner">
                        <div class="content">
                            <span class="welcome-message">Nouveau Sujet</span>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br><br>
    <section id="tabs" class="tabs">
        <div class="container">
            <h2 class="element-invisible">Primary tabs</h2>
            <ul class="tabs primary">
                <li class="active">
                    <a href="svtTheme" class="active">Themes
                        <span class="element-invisible">(active tab)</span>
                    </a>
                </li>
                <li class="active">
                    <a href="/forum-plus/en/forum" class="active">Sujets
                        <span class="element-invisible">(active tab)</span>
                    </a>
                </li>
            </ul>      
        </div>
    </section>
    <section id="tabs" class="tabs">
        <div class="container"></div>
    </section>
    <section id="main" class="main section">
        <div class="container">
            <div class="row">
                <div id="main-area" class="col-sm-12">
                    <div id="content" class="column">
                        <a id="main-content"></a>
                        <div class="region region-content">
                            <div id="block-system-main" class="block block-system">
                                <div class="block-inner">
                                    <div class="content">  
                                        <div id="forum-topic-header" class="forum-topic-header clearfix">
                                            <div id="post-69" class="forum-post clearfix en posted-by-1" >
                                                <div class="forum-post-info clearfix">
                                                    <span class="forum-post-number">
                                                        <a href="/forum-plus/en/forum/learn-d7-coding-or-d8" class="active"></a>
                                                    </span>
                                                </div> 
                                                <form action="svtServlet" method="post">
                                                    <div class="forum-post-wrapper">
                                                        <div class="forum-post-panel-sub">
                                                            <div class="author-pane">
                                                                <div class="author-pane-inner">
                                                                    <div class="author-pane-section author-pane-general">
                                                                        <div class="status-picture">
                                                                            <%
                                                                            Utilisateur  user =(Utilisateur)session.getAttribute("user");  
                                                                            %>
                                                                            <div class="picture">
                                                                                <img src="<%= user.getImage() %>" alt="admin&#039;s picture" title="admin&#039;s picture" />  
                                                                            </div>
                                                                        </div>        
                                                                        <div class="author-pane-line author-offline"></div>
                                                                        <div class="author-pane-line author-name">
                                                                            <span class="username"><%= user.getUsername() %></span>      
                                                                        </div>         
                                                                        <div class="author-pane-line author-joined">
                                                                            <span class="author-pane-label">Rejoint:</span> <%= user.getDateInscri() %>       
                                                                        </div>
                                                                    </div>
                                                                    <div class="author-pane-section author-pane-contact"></div>
                                                                    <div class="author-pane-section author-pane-admin"></div>
                                                                </div>
                                                            </div>
                                                        </div>   
                                                        <div class="forum-post-panel-main clearfix">
                                                            <div class="forum-post-title">
                                                                <input type="text" placeholder="Titre de sujet" name="titre"/>       
                                                            </div>
                                                            <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>
                                                            <div class="forum-post-content">
                                                                <div class="field field-name-body field-type-text-with-summary field-label-hidden">
                                                                    <div class="field-items">
                                                                        <div class="field-item even">
                                                                            <p><textarea cols="160" rows="10" placeholder="Contenu du sujet" name="contenu"></textarea></p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="field field-name-field-vote field-type-fivestar field-label-hidden">
                                                                    <div class="field-items">
                                                                        <div class="field-item even">
                                                                            <div>
                                                                                <div  class="clearfix  fivestar-combo-text fivestar-smart-stars fivestar-average-stars fivestar-form-item fivestar-basic">
                                                                                    <div class="form-item form-type-fivestar form-item-vote">
                                                                                        <div class="fivestar-static-form-item">
                                                                                            <div class="form-item form-type-item"></div>
                                                                                        </div>
                                                                                    </div>  
                                                                                </div>
                                                                            </div>
                                                                        </div>                                                  
                                                                    </div>     
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="forum-post-footer clearfix">
                                                            <div class="forum-post-links">
                                                                <ul class="links inline">
                                                                    <li class="sharethis first">
                                                                        <span class="sharethis-buttons">
                                                                            <div class="sharethis-wrapper">
                                                                                <input type="submit" value="Envoyer" name="action"/>
                                                                            </div>
                                                                        </span>
                                                                    </li>
                                                                    <li class="comment_forbidden last" ></li>
                                                                </ul>    
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br><br>
    <footer id="footer" class="section">
        <div class="container">
            <div class="region region-footer">
                <div id="block-menu-menu-footer-menu" class="block block-menu">
                    <div class="block-inner"></div>
                </div>
                <div id="block-block-5" class="block block-block">
                    <div class="block-inner">
                        <div class="content">
                            <p>Crée par Weslati Ghaith,Zliaa Elyes,Moulaa Med Iyed. Copyright©2017.Tous droits réservés</p>
                        </div>
                    </div>
                </div>
            </div>
      </div>
    </footer>  
    <script src="/cdn-cgi/scripts/84a23a00/cloudflare-static/email-decode.min.js"></script><script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_5idECjjAo-X5YdkT65CaIiodkWmZlZv-WjSkHlWhoYk.js"></script>
</body>
</html>