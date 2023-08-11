var eprev = document.querySelector('.prev');
var enext = document.querySelector('.next');
var esico = document.getElementById('icolist').getElementsByTagName('li');
var eicolist = document.querySelector('#icolist');
var eimglist = document.querySelector('#imglist');
var left = 0;//移动变量
var timer;//定时器

run();
function run() {//滚动函数run
    if (left <= -3520) {//滚完一圈重置
        left = 0;
    }
    var m = Math.floor(-left / 704);
    //每20ms运行一次run，每次偏移left累积-44
    eimglist.style.marginLeft = left + 'px';
    //添加变量n，滚完一张图停2000ms
    var n = (left % 704 == 0) ? n = 2000 : n = 20;
    left -= 44;
    timer = setTimeout(run, n);
    icochange(m);
}
//做一个图片定位函数
function imgchange(n) {
    let lt = - (n * 704);
    eimglist.style.marginLeft = lt + 'px';
    left = lt;
}
eprev.onclick = function () {
    let prevgo = Math.floor(-left / 704) - 1;
    if (prevgo == -1) { prevgo = 4; }
    imgchange(prevgo);
    var m = Math.floor(-left / 704);
    icochange(m);
}
enext.onclick = function () {
    let nextgo = Math.floor(-left / 704) + 1;
    if (nextgo == 5) { nextgo = 0; }
    imgchange(nextgo);
    var m = Math.floor(-left / 704);
    icochange(m);
}
//图标变红
function icochange(m) {
    for (let i = 0; i < esico.length; i++) {
        esico[i].style.backgroundColor = '';
    }
    if (m < esico.length) {
        esico[m].style.backgroundColor = 'red';
    }
}
//列表点击事件
eicolist.onclick = function () {
    var tg = event.target;
    let ico = tg.innerHTML - 1;
    imgchange(ico);
    icochange(ico);
}
eimglist.onmouseover = function () {
    clearTimeout(timer);
}
eimglist.onmouseout = function () {
    run();
}
