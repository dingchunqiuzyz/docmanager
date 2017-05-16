<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>

<body>
<div class="container-fluid">
  <div class="panel panel-primary">
    <div class="panel-heading">
      <h3 class="panel-title text-center">${c.fileName}文件详情</h3>
    </div>
    <div class="panel-body">

      <div class="row">
        <span class="text text-danger text-center col-sm-offset-1">文件名称：${c.fileName}</span>
        <span class="text text-danger text-center ">所属主题：${c.projectName}</span>
        <span class="text text-danger text-center ">作者：${c.teacherName}</span>
        <span class="text text-danger text-center ">完成时间：<fmt:formatDate value="${c.fileDate}" pattern="yyyy-MM-dd"/></span>
        <span class="text text-danger text-center ">所属类型：${c.fileType}</span>
        <a class="btn btn-success text-center glyphicon glyphicon-download-alt" href="${pageContext.request.contextPath}/download/${c.cacheId}/one">下载</a>
        <button class="btn btn-success text-center glyphicon glyphicon-arrow-left" id="backBtn">返回</button>
      </div>
      <div class="row" id="context">



      </div>
    </div>

  </div>

</div>
</body>

<%@include file="/WEB-INF/jsp/commonjs.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/pdfobject.js"></script>
<script type="text/javascript">
  $(function(){

    var docName = '${c.fileName}';
    var ext= docName.slice(docName.lastIndexOf("."),docName.length);
    if(ext==".pdf"){//是pdf文档
      PDFObject.embed("${c.filePath}", "#context");

    }else if(ext==".png"||ext==".bmp"||ext==".jpg"||ext==".pic"){//bmp、gif、jpg、pic、png
        var filePath = '${c.filePath}';
        var image = $("<img class=\"thumbnail\" src="+filePath+" width='100%' />");
        $("#context").append(image);
    }


    //返回按钮
    $("#backBtn").click(function(){
      window.history.back();
    });
  });


</script>
</html>