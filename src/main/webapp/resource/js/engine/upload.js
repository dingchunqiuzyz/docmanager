var BASE_URL = "/upload";
var filesupload = new Array();

var uploader = WebUploader.create({

    // swf文件路径
    swf :'/js/Uploader.swf',

    // 文件接收服务端。
    server : '/upload',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick : '#picker',

    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize : false,
    //可接受文件类型
    accept:[
        {
            title: 'Images',
            extensions: 'jpg,jpeg,bmp,png',
            mimeTypes: 'image/jpg,image/jpeg,image/png,image/bmp'
        },
        {
            title: 'pdf',
            extensions: 'pdf',
            mimeTypes: 'application/pdf'
        },
    ]
});

// 当有文件被添加进队列的时候
var $list = $("#thelist");
uploader.on('fileQueued', function(file) {
    /*  $list.append( '<div id="' + file.id + '" class="item">' +
     '<h4 class="info">' + file.name + '</h4>'+
     '<div class="progress"><div class="progress-bar" role="progressbar"  aria-valuemin="0" aria-valuemax="100" ></div></div>'+
     '<p class="state">等待上传... ' +
     '</div>' );
     */

    addFile(file);

});

function addFile(file) {
    /////////////构造一棵dom列表，来显示文档/////////////
    var $li = $('<div id="' + file.id + '" class="item">'
        + '<h4 class="info">' + file.name + '</h4></div>');
    var $progress = $('<div class="progress"><div class="progress-bar" role="progressbar"  aria-valuemin="0" aria-valuemax="100" ></div></div>');
    var $state = $('<p class="state">等待上传...  </p>');
    var $btndelte =$('<input type="button" class="btn btn-danger" value="删除"/>');
    $state.append($btndelte);
    $li.append($progress);
    $li.append($state);
    $list.append($li);
    //////////////////////////

    ///删除上传的文件
    $btndelte.on('click', function() {//删除
        $li.remove();
        uploader.removeFile(file, true);
    });
}

//改变进度条
uploader.on('uploadProgress',
    function(file, percentage) {
        var $li = $('#' + file.id), $percent = $li
            .find('.progress .progress-bar');
        // 避免重复创建
        if (!$percent.length) {
            $percent = $(
                '<div class="progress progress-striped active">'
                + '<div class="progress-bar" role="progressbar" style="width: 0%">'
                + '</div>' + '</div>')
                .appendTo($li).find('.progress-bar');
        }
        $li.find('p.state').text('上传中');

        $percent.css('width', percentage * 100 + '%');
    });
//上传成功
uploader.on('uploadSuccess', function(file, json) {
    $('#' + file.id).find('p.state').text('已上传');
    filesupload.push(json['path']);
});

uploader.on('uploadError', function(file) {
    $('#' + file.id).find('p.state').text('上传出错');
});

uploader.on('uploadComplete', function(file) {
    $('#' + file.id).find('.progress').fadeOut();
});
$("#ctlBtn").click(function() {

    uploader.upload();
});