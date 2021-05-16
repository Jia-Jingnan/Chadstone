创建webdriver对象的时候：  
1.启动了浏览器  
2.启动了驱动实例  

定位元素的方法以及优先级  
1.id:元素的id属性值具有唯一性  
2.name：元素的name属性虽然不具备唯一性，但重复的情况也不多，基本根据业务场景定义name，
在没有id时考虑name  
3.根据元素的样式来定位元素，可能返回的是一个元素集合，页面含有多个相同样式的元素，
多个元素使用findElements定位元素，从集合中取出要用的元素，通过索引取出元素，单个使用findElement定位元素  
4.tagName:根据元素的标签名来定位元素，取元素的用法同className  
5.linkText:根据超链接文本值定位元素,partialLinkText 
6.cssSelector: css选择器定位元素
    id:id选择器
    样式选择器定位
    标签选择器