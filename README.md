# DubboTester
一个idea的 测试dubbo的插件
=========================
1、概述：
-------------

在使用dubbo开发的过程中有的时候需要测试自己写的dubbo接口 于是乎就有了 DubboTest 插件
本插件根据 https://github.com/yanglanxing/DubboTest 改编.适配了最新版本对idea</br>

另,多谢@yanglanxing 大佬的插件 如有启发,请点star


2、编译流程
-------------
1) 下载jdk11 </br>
  
2) clone 本项目 

3) 打开idea 设置grable jvm为jdk11

4) 在idea中 打开gradle 侧边栏选项卡，执行 task--> build --> assemble 等待执行完成 

5) 执行完成后 在生成的build文件夹的distributions文件夹下复制DubboTester-x.x.x.zip安装到idea中

6) 开始愉快的dubbo测试吧
