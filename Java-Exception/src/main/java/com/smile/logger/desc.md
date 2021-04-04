<strong>【强制】不要用 <code>System.out.println</code> 代替日志框架</strong>
<strong>【强制】不要打印敏感信息，如果需要打印可以考虑对敏感信息脱敏处理</strong>
<strong>【推荐】除非业务需要，尽量不要打印大文本 (含富文本)。如果要打印可以截取前 M 个字符。</strong>
<strong>用切面或 Filter 在 dubbo 或 Controller 层做切面来打印调用的参数、返回值和响应时间以及捕捉和打印异常日志。</strong>
<strong>【推荐】在依赖的二方或三方接口的参数、返回值和异常处打印日志。</strong>
<strong>【推荐】 在接收消息的地方打印日志。</strong>
<strong>【推荐】 在定时任务的开始和结束的地方。</strong>
<strong>【推荐】 在异步任务的开始和结束的地方。</strong>
<strong>【推荐】面向测试打印日志。</strong>