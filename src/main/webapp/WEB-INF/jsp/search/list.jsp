
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入head--%>
<%@include file="/WEB-INF/jsp/commonhead.jsp"%>

<body>
<%@include file="/WEB-INF/jsp/commonNav.jsp"%>
<div class="container-fluid">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title text-center">文件检索</h3>
        </div>
        <div class="panel-body">
            <form class="form-inline col-sm-offset-1" id="userForm" action="/search/list" method="post">
                <div class="row ">

                    <select class="form-control" name="fileType" id="fileType">
                        <option  value="">全部</option>
                        <option value="学术论文">学术论文</option>
                        <option value="项目">科研项目</option>
                        <option value="著作">著作书籍</option>
                        <option value="专利">专利</option>
                        <option value="获奖">成果获奖</option>
                        <option value="成果转化">成果转化</option>
                        <option value="论证报告">论证报告</option>
                    </select>


                    <input class="form-control " type="text" name="startDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${cache.startDate}"  pattern="yyyy-MM-dd"/>" placeholder="起始时间">
                    <input class="form-control " type="text" name="endDate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${cache.endDate}"  pattern="yyyy-MM-dd"/>" placeholder="结束时间">
                </div>

                <div class="row ">
                    <input type="hidden" id="pageNum" name="pageNum" value="${info.size==0?'1':info.pageNum}"/>
                    <input class="form-control" type="text" id="teacherName" name="teacherName" value="${cache.teacherName}" placeholder="教师名称">
                    <select class="form-control" id="fkTeacherCode" name="fkTeacherCode" >
                        <option value="">请输先入名称</option>
                    </select>
                    <input class="form-control " type="text" name="fileName" value="${cache.fileName}" placeholder="文件名称">
                    <label id="info"></label>
                    <button class="btn bg-primary  glyphicon glyphicon-zoom-in " id="btnSearch" type="submit" >搜索</button>
                    <button class="btn bg-primary glyphicon glyphicon-print " type="button" id="batchDownloadBtn">批量下载</button>
                </div>
            </form>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th><input type="checkbox" class="checkbox" id="selectAllBtn"></th>
                        <th>文件名称</th>
                        <th>作者</th>
                        <th>教工号</th>
                        <th>主题</th>
                        <th>时间</th>
                        <th>类别</th>
                        <th>作者排名</th>
                        <th>预览</th>
                        <th>下载</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${info.list}" var="f" varStatus="vs">
                    <tr>
                        <td><input type="checkbox" class="checkbox" name="fileId" value="${f.cacheId}" ></td>
                        <td>${f.fileName}</td>
                        <td>${f.teacherName}</td>
                        <td>${f.fkTeacherCode}</td>
                        <td>${f.projectName}</td>
                        <td><fmt:formatDate value="${f.fileDate}" pattern="yyyy-MM-dd"/> </td>
                        <td>${f.fileType}</td>
                        <td>${f.orders}</td>
                        <td><a class="glyphicon glyphicon-eye-open" href="${pageContext.request.contextPath}/search/${f.cacheId}/preview">预览</a></td>
                        <td><a href="${pageContext.request.contextPath}/download/${f.cacheId}/one" class="glyphicon glyphicon-download-alt">下载</a></td>
                    </tr>
                </c:forEach>

                <c:if test="${info.size==0}">
                    <tr>
                        <td colspan="10" class="text text-center text-danger">没有搜索到结果</td>

                    </tr>

                </c:if>

                </tbody>
            </table>
            <div class="panel-footer">
                <c:if test="${info.size>0}">
                    <nav>
                        <ul class="pagination pull-right">
                            <li><a href="javascript:;" onclick="mysearch.judgePage(1)">
                                <div class="text-primary">首页</div>
                            </a></li>
                            <c:forEach items="${info.navigatepageNums}" var="pageNum">
                                <li class="${info.pageNum==pageNum?'active':''}"><a href="javascript:;" onclick="mysearch.judgePage('${pageNum}')">${pageNum} </a></li>
                            </c:forEach>
                            <li><a href="javascript:;" onclick="mysearch.judgePage(${info.lastPage})">
                                <div class="text-primary">尾页</div>
                            </a></li>
                        </ul>
                    </nav>
                </c:if>
            </div>
        </div>

    </div>
    <!--表格结束 -->



</div>
</body>
<%@include file="/WEB-INF/jsp/commonBottom.jsp" %>
<%@include file="/WEB-INF/jsp/commonjs.jsp"%>
<%--本页面用到的js --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/engine/search.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>
<script>
    $(function(){

        //让下拉框选中
        $("#fileType").val('${cache.fileType}');

    var code = '${cache.fkTeacherCode}';
    if(code!=null&&""!=null){
        mysearch.init(code);
    }

     //全选orNot

        $("#selectAllBtn").click(function(){
            var isChecked=this.checked;
            $(":checkbox[name='fileId']").prop("checked",isChecked);
        });

        $("#batchDownloadBtn").click(function(){

           var idsCheck= $(":input:checked[name='fileId']");
            if(idsCheck.length==0){
                Alert('请选中要下载的文件!');
                return;
            }
            var url ="/download/many?ids=";
            var ids = new Array();
            idsCheck.each(function(index,elemtnt){
                ids.push(elemtnt.value);
            });
            var allId= ids.join("&ids=");
            url+=allId;
            //alert(url);
            window.location.href=url;
        });


    });


</script>
</html>