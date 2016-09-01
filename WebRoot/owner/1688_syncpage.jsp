<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>1688数据同步</title> 
<%@ include file="/owner/common/owner-sc.jsp"%>
<script src="${ctx}/owner/js/layout.js" type="text/javascript"></script>
</head>  
<body>
    <div id="main">
        <div position="left" title="主菜单">
            <%@ include file="/owner/left.jsp" %>
        </div>
        <div id="maincontent" position="center" title=" ">
          <div style="text-align:center;margin-top:50px">
      <input type="button" value="同步1688数据" id="sync1688Data" name="sync1688Data" class="button-common" style="width:150px;height:40px"/>
            </div>
        </div>
        <div position="top">
          <%@ include file="/owner/top.jsp" %>
        </div>
        <div position="bottom">
         <%@ include file="/owner/bottom.jsp" %>
        </div>
    </div>
    <br />
    <div style="display:none;">
    </div>
</body>    
 
<script type="text/javascript">
 
    $(function() {
      $.expandAccordionMenu("syncmenu");
        $("#sync1688Data").click(f_sync1688Data);

    });

    function f_sync1688Data() {

      $.ligerDialog.confirm('同步后数据将全部恢复初始化、标准价格会重置，确定要同步么?',
        function(yes) {
            if (yes) {


           $.ligerDialog.waitting('数据正在同步中,请稍候...'); 


              setTimeout(
          function(){
            j4tg.ajaxPost("${ctx}/owner/wE688SyncData.action", "json", false, {},
              function(data) {
                  $.ligerDialog.closeWaitting();

                  if (data.status == "S") {
                      
                      $.ligerDialog.success('数据同步成功');
                  }else{

                   $.ligerDialog.error(data.message);
                   setTimeout(function(){ location.href="${ctx}/common/wE688Login.action";},3000);
                    
                  }

              },
              function(data) {
                $.ligerDialog.closeWaitting();
                $.ligerDialog.error(data.message);
                console.log(data.message);
                
            });
          }
        ,300);


            }
        });
          
        

    }
</script>
</html>