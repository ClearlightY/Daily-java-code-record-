package top.clearlight.book.javaconcurrentprogam.threadsafe;

public class NotThreadSafe {
    // StringBuilder sb = new StringBuilder();
    int[] a = {1};
    public /*synchronized*/ void add(int text) {
        // this.sb.append(text);
        a[0] += text;
    }

    public void Print() {
        // System.out.println(sb.toString());
        System.out.println(a[0]);
    }
}
