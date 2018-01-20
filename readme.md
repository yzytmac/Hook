**Android的Hook技术** 

我们都知道启动一个Activity必须要在清单文件中注册，如果我们清单文件中没有注册该怎么启动呢？此时就需要用到钩子技术hook。
在ActivityManagerService中会将要启动的intent进行安检（就是要到清单文件中进行扫描），如果清单文件中没有注册就无法通过安检，那么我们就用一个已经注册过的activity来代替我们没注册的activity来进行安检，当通过安检之后就替换会我们原来的activity 的intent。所以就在进安检之前要挂一个钩子进行动态代理，过完安检之后再挂一个钩子来替换回原意图。整个操作都在HookAmsUtil 中进行。使用时我们只需要在Application的onCreate方法中初始化就好。详情参见代码。  

**Hook的作用**  
启动清单中未注册的Activity。  
为什么不直接在清单中注册好Activity呢？因为有些Activity我们并不知道。比如插件化开发。所以hook技术最主要的用途就是插件化开发来启动插件中的Activity。这里先以启动本地未注册的Activity来演示，后期再结合插件化来启动插件中的Activity  
有什么错误欢迎指出，邮箱： yzytmac@163.com  
- 如果觉得有用，不吝啬在右上角给我一个Star。谢谢！！  
![](https://raw.githubusercontent.com/yzytmac/yzytmac.github.io/master/images/star.png)  
