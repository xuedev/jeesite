<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<html>
<head>
    <title>文件上传示例</title>
    <meta name="decorator" content="default"/>
    <script src="${ctxStatic}/jquery/jquery.1.12.4.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/webuploader-0.1.5/webuploader.min.js" type="text/javascript"></script>
    <style>
        .upload-img {
            width: 150px;
            height: 150px;
        }

        #prevModal {
            width: 100%;
            height: 100%;
            text-align: center;
            display: none;
        }

        #img_prev {
            max-width: 98%;
            max-height: 98%;
            margin: 10px auto
        }
    </style>
</head>
<body>
　
<div class="layui-form-item">
    <label class="layui-form-label">图片</label>
    <div class="layui-input-inline">
        <img class="upload-img" id="demo1" name="demo1" onclick="imagePre()">
    </div>
</div>


<button id="picker">
    选择图片
</button>

<script>
    //实例化
    var uploader = WebUploader.create({
        // swf文件路径
        swf: '${pageContext.request.contextPath}/webuploader-0.1.5/Uploader.swf',
        // 选择文件的按钮。可选。
        method: 'post',
        // 选完文件后，是否自动上传。
        auto: true,
        // 文件接收服务端。
        server: '${pageContext.request.contextPath}/fileupload/saveImage', //在做这个demo的时候，并没有服务器地址，我使用的是HBuilder自带的浏览器打开文件，复制url
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            "id": '#picker',
            "multiple": false
        }
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        , resize: false
        // 只允许选择图片文件
        , accept: {
            title: '图片文件',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });

    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {

    });
    //档文件被移除队列de时候
    uploader.on("fileDequeued", function (file) {

    });
    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {

    });
    //开始上传
    uploader.on('startUpload', function (file) {

    });
    //上传成功
    uploader.on('uploadSuccess', function (file, response) {
        $("#demo1").removeAttr("src");
        $('#demo1').attr('src', response.data.url); //图片链接（base64）
    });
    //上传失败
    uploader.on('uploadError', function (file) {
        alert("上传失败");
    });
    //上传完成
    uploader.on('uploadComplete', function (file) {
        alert("完成");
    });
</script>
</body>
</html>