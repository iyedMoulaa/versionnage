
 
<%@page import="Model.Beans.Utilisateur"%>
<%@page import="Model.modUser"%>
<%@page import="java.util.List"%>
<%@page import="Model.modSujet"%>
<%@page import="Model.modTheme"%>
<%@page import="Model.Beans.Sujet"%>
<%@page import="Model.Beans.theme"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta name="Generator" content="Drupal 7 (http://drupal.org)" />
<link rel="shortcut icon" href="https://demo.weebpal.com/forum-plus/sites/all/themes/forum_plus/favicon.ico" type="image/vnd.microsoft.icon" />
<title>Forums | Forum Plus</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="HandheldFriendly" content="true" >
<meta name="apple-touch-fullscreen" content="YES" >
<link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_NkdTB0Ds0gO6QaQ3Ao68vRMpULGJnFODbJpqRaVre0E.css" media="all" />
<link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_rsFpG9NJN-BA74v-Fc0S7W0C-Xi30j-9YfzgimEuZc4.css" media="all" />
<link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_OaYsGw0EJ0GPB24Fldg8einkRlNVsqvYUB_tlGva1sU.css" media="all" />
<link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_iexaIaWGfRC_1Fju7wR1C-bea2ElPWmvMcW28X1VTu0.css" media="all" />
<link type="text/css" rel="stylesheet" href="https://demo.weebpal.com/forum-plus/sites/default/files/css/css_M5_Pu5tRF5Wc2rxBuJn-TcQv32cGlqnsEA9yKb1XHjY.css" media="all" />
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_JLxuxbhhrFRy-sBnijHkR0TGGHgiukMPv94zvDWgQ3g.js"></script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_Ppr5AOv5GkdSTdDgONfw1UyTWrMn0kcR9ik2kCHyspQ.js"></script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_HbkvvgzNC18WXNiqFnb8JhvjPjPgcTypcrzhCmMMr6s.js"></script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_lw-DPZ-HQ7Cc9JEP7MHS7BsQc_H-AEh-TpKKrlj1yLo.js"></script>
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
        });z
      }
    }
  })(jQuery);

//--><!]]>
</script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_3Z-K2am6L8-xBwxw9xNNG45ULXEJKdsYF9tYAjl7ar4.js"></script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_4yi5kXu8VAk3CNUNYxSvMsDMLg-N5H1YjjcABGw2Lu8.js"></script>
<script type="text/javascript">
</script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script> 
<script>
    function nbrusercourant(){ 
        setInterval(function(){  
	$.ajax({
	async: false,
	url: "test",
	success: function(data){
        
	$("#user_courant").html(data);}
	});
	},5000); 
    }
</script>
<script>
 
     <% modUser moduser= new modUser(); %>
     function myFunction(){ 
         setInterval(function(){  
            var x = new Date().toLocaleString();  
             document.getElementById("timer").innerHTML=x;

         },1000 );
     }
 
</script>
</head>



<body class="html front not-logged-in one-sidebar sidebar-first page-forum i18n-en" onLoad="nbrusercourant(),myFunction()" >
<%
if(null == session.getAttribute("user") ) {
    response.sendRedirect("svtUser");
    return;
}
%>
   
 
<div id="skip-link">
        <a href="" class="element-invisible element-focusable">Skip to main content</a>
    </div>
    <div id="page" >
        <section id="headline" class="headline section">
            <div class="container">
                <div class="region region-headline">
                    <div id="block-block-1" class="block block-block"></div>
                    <div id="block-system-user-menu" class="block block-system block-menu">
                        <div class="block-inner">    
                            <div class="content">
                                <a href="svtUser?action=lagout">D�connexion</a>
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
                          

                            <div class="content">
                                <p id="timer"></p> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <nav class="collapse navbar-collapse  navbar navbar-default width" id="main-menu-inner">
                <div class="container-inner">
                    <span class="btn-close"><i class="fa fa-times"></i></span>
                        <div class="region region-main-menu">
                            <div id="block-system-main-menu" class="block block-system block-menu">
                                <div class="block-inner"></div>
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
                            <span class="welcome-message">Bienvenu dans Jeune Forum</span>  
                        </div>
                    </div>
               </div>
            </div>
        </div>
    </section>
    
    <section id="main" class="main section">
        <div class="container">
            <div class="row">
                <div id="main-area" class="col-sm-9">
                    <div id="content" class="column">
                        <a id="main-content"></a>
                        <div class="region region-content">
                            <div id="block-system-main" class="block block-system">
                                <div class="block-inner">
                                    <div class="content">
                                        <div id="forum">
                                        <br><br>
        
                                            <div class="forum-table-wrap">
                                                <div class="forum-table-superheader">
                                                    <div class="forum-table-name">
                                                        Les Th�mes
                                                    </div>
                                                    <span id="forum-collapsible-2" class="forum-collapsible" >&nbsp;</span>
                                                    <div class="forum-table-description"></div>
                                                </div>
                                                <div id="forum-table-2">
                                                    <table class="forum-table forum-table-forums">
                                                        <thead class="forum-header">
                                                            <tr>
                                                                <th class="forum-icon">&nbsp;</th>
                                                                <th class="forum-name" colspan="2">Forum</th>
                                                                <th class="forum-posts">Sujets</th>
                                                                <th class="forum-last-post">Dernier sujet</th>
                                                            </tr>
                                                        </thead>

                                                        <tbody id="forum-table-2-content">
                                                        <%    
                                                            ArrayList<theme> attribut = (ArrayList<theme>)request.getAttribute("lstTheme");   
                                                            ArrayList<Sujet> attribut2 = (ArrayList<Sujet>)request.getAttribute("lstSujet");  
                                                            for(theme thm: attribut)
                                                            {
                                                            %>
                                                                <tr id="forum-1" class="forum-row even container-1-child">
                                                                    <td class="forum-list-icon forum-list-icon-default">
                                                                        <span class="forum-list-icon-wrapper"><span>No new</span></span>
                                                                    </td>
                                                                    <td class="forum-details" colspan="2">
                                                                        <div class="forum-name">
                                                                            <a href="svtServlet?id=<%=thm.getId_theme() %>&titre=<%=thm.getTitre()%>"><%=thm.getTitre() %></a>
                                                                        </div>
                                                                    </td>
                                                                    <td class="forum-number-topics">
                                                                        <div class="forum-number-topics"><%= new modSujet().lister(thm.getId_theme()).size()  %>                                     </div>
                                                                    </td>
                                                                    <td class="forum-last-reply">
                                                                    <% 
                                                                        List<Sujet> lstSjt = new modSujet().lister(thm.getId_theme());
                                                                        if(lstSjt.size()>0)
                                                                        {
                                                                        Sujet sj = lstSjt.get(0);   
                                                                        String ch = sj.getTitre();                  
                                                                        %>                  
                                                                        <a href="svtServlet?action=listerSujet&id=<%= sj.getId_sujet() %>"><%= ch %></a><br>
                                                                        By <%= sj.getUser().getUsername() %><br>
                                                                        <%= sj.getDate_sujet() %><br>
                                                                        <% }%>
                                                                    </td>
                                                                </tr>
                                                            <% } %>
                                                            </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        <br>
                                        <div id="forum-statistics">
                                            <div id="forum-statistics-header">Informations</div>
                                            <div id="forum-statistics-active-header" class="forum-statistics-sub-header">                                             
                                       
                                                
                                                Membres connect�s: <span id="user_courant"></span>
                                            </div>
                                            <div id="forum-statistics-statistics-header" class="forum-statistics-sub-header">
                                                Statistics  
                                            </div>
                                            <div id="forum-statistics-statistics-body" class="forum-statistics-sub-body">
                                                <div id="forum-statistics-topics">
                                                <% ArrayList<Utilisateur> lstuser = (ArrayList<Utilisateur>)request.getAttribute("lstuser"); %>
                                                    Themes: <%= attribut.size() %>, Posts: <%= attribut2.size() %>, Users:<%= lstuser.size() %>
                                                </div>
                                                <div id="forum-statistics-latest-users">
                                                    Bienvenu les derni�rs membres: 
                                                    <span class="username"><%= lstuser.get(0).getUsername() %></span>, 
                                                    <span class="username"><%= lstuser.get(1).getUsername() %></span>, 
                                                    <span class="username"><%= lstuser.get(2).getUsername() %></span>, 
                                                    <span class="username"><%= lstuser.get(3).getUsername() %></span>  
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
                <br><br><br>
                <aside id="sidebar-first" class="sidebar col-sm-3">
                    <div class="region region-sidebar-first">
                        <div id="block-views-new-forum-posts-block--2" class="block block-views">
                            <div class="block-inner">
                                <h2><span>Derniers Sujets</span></h2>    
                                <div class="content">
                                    <div class="view view-new-forum-posts view-id-new_forum_posts view-display-id-block view-dom-id-37cebcb98231b067cd6f98bc38f47f0a">
                                        <%    
                                        Sujet sjt=null;
                                        for(int i=0;i<3;i++)
                                        {
                                            sjt=attribut2.get(i);
                                        %>
                                        <div class="view-content">
                                            <div class="views-row views-row-1 views-row-odd views-row-first">
                                                <div class="views-field views-field-picture">        
                                                    <div class="field-content">
                                                        <img src="images/logo.png" width="45" height="45" alt="" />
                                                    </div>  
                                                </div>  
                                                <div class="views-field views-field-title">        
                                                    <span class="field-content">
                                                        <a text-transform=capitalize href="svtServlet?action=listerSujet&id=<%=sjt.getId_sujet()%>" ><%=sjt.getTitre()%>
                                                        </a>
                                                    </span>  
                                                </div>  
                                                <div class="views-field views-field-name">        
                                                    <span class="field-content">By <%= sjt.getUser().getUsername() %>
                                                        <span class="username"></span>                            
                                                    </span>  
                                                </div>  
                                                <div class="views-field views-field-created">        
                                                    <span class="field-content"><%=sjt.getDate_sujet() %></span>  
                                                </div>  
                                            </div>
                                        </div>
                                       <% } %> 
                                    </div>
                                </div>
                                <br>
                                <div id="block-forum-active" class="block block-forum">
                                    <div class="block-inner">
                                        <h2><span>Les probl�mes des jeunes</span></h2>
                                        <div class="content">
                                            <div class="item-list">
                                                <ul>
                                                    <% for(theme thm: attribut)  
                                                    {
                                                        List<Sujet> lstSjt = new modSujet().lister(thm.getId_theme());
                                                          Sujet sj = lstSjt.get(0);   
                                                          String ch = sj.getTitre();
                                                    %>
                                                    <%=thm.getTitre()+" : "+lstSjt.size()*100/attribut2.size()+"%"%>
                                                    <svg width="293" height="25">
                                                    <%

                                                    %>
                                                    <rect  width="<%=lstSjt.size()*293/attribut2.size() %>" height="15" style="fill:#348bc2"/>    
                                                    </svg>
                                                         <% } %>  
                                                </ul> 
                                            </div>
                                        </div>
                                    </div>
                                <a title="Back to Top" class="btn-btt" href="#Top" style="display: none;">Top</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </section>
<script src="/cdn-cgi/scripts/84a23a00/cloudflare-static/email-decode.min.js"></script>
<script type="text/javascript" src="https://demo.weebpal.com/forum-plus/sites/default/files/js/js_5idECjjAo-X5YdkT65CaIiodkWmZlZv-WjSkHlWhoYk.js"></script>
</body>
</html>

              
              
              
              
              
              