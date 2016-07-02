/*
*/
;
!function () {
    //全局配置
    layer.config({
        extend: [
            'extend/layer.ext.js'
        ]
        //,skin: 'layer-ext-moon'
    });
    //一睹为快
    $('#chutiyan>a').on('click', function () {
        var othis = $(this), index = othis.index();
        //alert(index);
        switch (index) {
            case 0:
                var icon = -1;
                (function changeIcon() {
                    var index = layer.alert('Hi，你好！ 点击确认更换图标', {
                        icon: icon,
                        shadeClose: true,
                        title: icon === -1 ? '初体验 - layer 2.0' : 'icon：' + icon + ' - layer 2.0'
                    }, changeIcon);
                    if (8 === ++icon) layer.close(index);
                } ());
                break;
            case 1:
                var icon = 0;
                (function changeIcon1() {
                    var index = layer.alert('点击确认更换图标', {
                        icon: icon,
                        shadeClose: true,
                        skin: 'layer-ext-moon',
                        shift: 5,
                        title: icon === -1 ? '第三方扩展皮肤' : 'icon：' + icon
                    }, changeIcon1);
                    if (9 === ++icon) {
                        layer.confirm('怎么样，是否很喜欢该皮肤，是否下载？', {
                            skin: 'layer-ext-moon'
                        }, function (index, layero) {
                            layero.find('.layui-layer-btn0').attr({
                                href: 'http://www.pintuer.com/jsplugins/layerSkin/index.html#p_down',
                                target: '_blank'
                            });
                            layer.close(index);
                        });
                    };
                } ());
                break;
            case 2:
                layer.msg('玩命提示中');
                break;
            case 3:
                //捕获页
                layer.open({
                    type: 1,
                    shade: false,
                    title: false, //不显示标题
                    content: $('.alert'), //捕获的元素
                    cancel: function (index) {
                        layer.close(index);
                        this.content.show();
                        layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
                    }
                });
                break;
            case 4:
                layer.open({
                    type: 1,
                    area: ['420px', '240px'],
                    skin: 'layui-layer-rim', //加上边框
                    content: '<div style="padding:20px;">即直接给content传入html字符<br>当内容宽高超过定义宽高，会自动出现滚动条。<br><br><br><br><br><br><br><br><br><br><br>很高兴在下面遇见你</div>'
                });
                break;
            case 5:
                layer.open({
                    type: 1,
                    skin: 'layui-layer-demo',
                    closeBtn: false,
                    area: '350px',
                    shift: 2,
                    shadeClose: true,
                    content: '<div style="padding:20px;">即传入skin:"样式名"，然后你就可以为所欲为了。<br>你怎么样给她整容都行<br><br><br>我是华丽的酱油==。</div>'
                });
                break;
            case 6:
                layer.tips('Hi，我是tips', this);
                break;
            case 7:
                //iframe层
                layer.open({
                    type: 2,
                    title: '拼图APP模块',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['320px', '640px'],
                    content: 'http://www.pintuer.com/app/sample/index.html' //iframe的url
                });
                break;
            case 8:
                //iframe窗
                layer.open({
                    type: 2,
                    title: false,
                    closeBtn: false,
                    shade: [0],
                    area: ['340px', '215px'],
                    offset: 'rb', //右下角弹出
                    time: 2000, //2秒后自动关闭
                    shift: 2,
                    content: ['http://layer.layui.com/test/guodu.html', 'no'], //iframe的url，no代表不显示滚动条
                    end: function () { //此处用于演示
                        layer.open({
                            type: 2,
                            title: '很多时候，我们想最大化看，比如像这个页面。',
                            shadeClose: true,
                            shade: false,
                            maxmin: true, //开启最大化最小化按钮
                            area: ['1150px', '650px'],
                            content: 'http://www.pintuer.com/'
                        });
                    }
                });
                break;
            case 9:
                var ii = layer.load(0, { shade: false });
                setTimeout(function () {
                    layer.close(ii)
                }, 5000);
                break;
            case 10:
                var iii = layer.load(1, {
                    shade: [0.1, '#fff']
                });
                setTimeout(function () {
                    layer.close(iii)
                }, 3000);
                break;
            case 11:
                layer.tips('我是另外一个tips，只不过我长得跟之前那位稍有些不一样。', this, {
                    tips: [1, '#3595CC'],
                    time: 4000
                });
                break;
            case 12:
                layer.prompt({ title: '输入任何口令，并确认', formType: 1 }, function (pass) {
                    layer.prompt({ title: '随便写点啥，并确认', formType: 2 }, function (text) {
                        layer.msg('演示完毕！您的口令：' + pass + '<br>您最后写下了：' + text);
                    });
                });
                break;
            case 13:
                layer.tab({
                    area: ['600px', '300px'],
                    tab: [{
                        title: '无题',
                        content: '<div style="padding:20px; line-height:30px; text-align:center">欢迎体验layer.tab<br>此时此刻不禁让人吟诗一首：<br>一入前端深似海<br>从此妹纸是浮云<br>以下省略七个字<br>。。。。。。。<br>——贤心</div>'
                    }, {
                        title: 'TAB2',
                        content: '<div style="padding:20px;">TAB2该说些啥</div>'
                    }, {
                        title: 'TAB3',
                        content: '<div style="padding:20px;">有一种坚持叫：layer</div>'
                    }]
                });
                break;
            default:
                break;
        }
    });
} ();