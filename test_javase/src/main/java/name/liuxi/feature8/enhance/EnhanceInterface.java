package name.liuxi.feature8.enhance;

public interface EnhanceInterface {
    public void method();

    /**
     * Java 8 还允许我们给接口添加一个非抽象的方法实现，只需要使用 default 关键字即可，这个特征又叫做扩展方法。
     * 在实现该接口时，该默认扩展方法在子类上可以直接使用，它的使用方式类似于抽象类中非抽象成员方法。但扩展方法不能够重载 Object 中的方法。例如：toString、equals、 hashCode 不能在接口中被重载。
     * @param a
     * @param b
     * @return
     */
    default int enhanceDefaultMethod(int a, int b){
        return a + b;
    }

    /**
     * 在接口中，还允许定义静态的方法。接口中的静态方法可以直接用接口来调用。
     * @param a
     * @param b
     * @return
     */
    static int enhanceStaticMethod2(int a, int b){
        return a + b;
    }
}
