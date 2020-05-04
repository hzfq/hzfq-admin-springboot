package top.hzfq.admin.model;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/4/9
 */
public class PageModel {

    private int page;
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
