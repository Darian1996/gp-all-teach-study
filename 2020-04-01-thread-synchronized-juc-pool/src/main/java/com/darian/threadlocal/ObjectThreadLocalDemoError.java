package com.darian.threadlocal;

/***
 *
 *
 * @author <a href="1934849492@qq.com">Darian</a> 
 * @date 2020/1/31  16:53
 */
public class ObjectThreadLocalDemoError {
    static MockObject mockObject = new MockObject();
    static ThreadLocal<MockObject> mockLocal = ThreadLocal.withInitial(() -> mockObject);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                MockObject mockObject = mockLocal.get();
                mockObject.incr();

                Println.println(mockObject.getI());
            }).start();
        }
    }

    static class MockObject {
        private int i;

        public void incr() {
            i++;
        }

        public int getI() {
            return i;
        }
    }
}
//thredId: [ 15 ] thredName: [ Thread-1 ]
//   - 2
//thredId: [ 18 ] thredName: [ Thread-4 ]
//   - 3
//thredId: [ 17 ] thredName: [ Thread-3 ]
//   - 5
//thredId: [ 16 ] thredName: [ Thread-2 ]
//   - 4
//thredId: [ 14 ] thredName: [ Thread-0 ]
//   - 1
