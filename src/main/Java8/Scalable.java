package main.Java8;

public interface Scalable {

    //abstract methods implicitly public
    void setScale(double scale);

    double DEFAULT_SCALE = 1.0;

    //method implicitly public
    static boolean isScalable(Object obj ){
        return obj instanceof Scalable;
    }

    default void resetScale() {
        setScale(DEFAULT_SCALE);
    }
}
