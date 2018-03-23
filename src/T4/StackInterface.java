/*
 * Stack interface from lecture
 */
package T4;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public interface StackInterface<E> {
    E push(E obj);
    E peek();
    E pop();
    boolean empty();
}
