<!--
 * @Author: 天天修改
 * @Date: 2019-12-18 10:17:43
 * @LastEditTime : 2019-12-19 12:01:15
 * @LastEditors  : Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /xquery/README.md
 -->
# XQUERY
xquery是一个开发库(小程序原生)，剥离自原项目aotoo-hub，xquery基于小程序类似于jquery基于web，可以方便的融入到现有的小程序项目中  

xquery包含以下这些特性  

* 组件选取
* 嵌套结构
* 事件函数封装
* 钩子方法
* 支持数据过期机制    
* lru缓存机制  
* markdown支持
* html支持
* 方便扩展内置/外部插件 

> xquery源码中有`.styl`类型的样式文件，使用stylus命令行编译

## 如何使用  
clone或下载本项目，如下所示  

### 源码目录
    components 
        ├─ aotoo ✔︎核心代码必须有
        ├─ actionSide  弹窗组件
        ├─ form  表单组件
        ├─ calendar  日历组件
        ├─ markit  文档组件
        ├─ templates ✔︎模板
        │
       css  日历、文档、表单样式
        │
      app.json  注册全局组件

 > 勾选文件必须有，属于核心文件，组件可以按照需求增减    

#### 小程序放置目录
![](./css/structor.jpeg)



## 文件及目录说明  

#### components
基础目录  

#### components/aotoo
核心代码目录  

#### components/actionSide
弹窗组件  

#### components/calendar
日历组件  

#### components/form
表单组件  

#### components/markit
markdown/html组件  

#### css
一些组件的样式库，需要在小程序项目中引入  

#### app.json
文件中`usingComponents`字段必须设置，否则无法使用(可以根据需求删减)  

## DEMO小程序 

![DEMO小程序](./css/xquery.png)