package com.xhf.test;

import cn.hutool.core.io.FileUtil;
import org.junit.Test;

import java.io.File;

/**
 * @author 谢红飞
 * description:
 * date 2020-8-21 22:56
 */
public class FileTest {

    @Test
    public void test1() {

        String path = "G:\\尚硅谷\\尚硅谷-韩顺平图解Java数据结构和算法\\视频";
        File directory = FileUtil.file(path);
        String[] videos = directory.list();

        for (String video : videos) {
            System.out.println(video);
            String newName = video.replaceAll("-尚硅谷-老韩图解Java数据结构和算法", "");
            File file = FileUtil.file(path + "\\" + video);
            FileUtil.rename(file, newName, false, true);
        }


    }
}
