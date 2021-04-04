<p>根据 JLS 异常部分的<a href="https://docs.oracle.com/javase/specs/jls/se9/html/jls-11.html#jls-11.1">相关描述</a>，我们可知受检异常主要指编译时强制检查的异常，包括非受检异常之外的其他 <code>Throwable</code> 的子类；非受检异常主要指编译器免检异常，通常包括运行时异常类和 Error相关类。</p>

Error 和 Exception 都是 Throwable的子类。 RuntimeException 和其子类都属于运行时异常。Error 类和其子类都属于错误类。RuntimeException 及其子类 和 Error类及其子类 属于非受检异常，除此之外的 其他 Throwable 子类属于受检异常。