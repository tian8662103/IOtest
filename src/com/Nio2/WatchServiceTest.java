package com.Nio2;

import java.io.IOException;
import java.nio.file.*;

/**
 * 文件监听
 */
public class WatchServiceTest {
    public static void main(String[] args) throws Exception {
        //获取文件系统的
        WatchService watchService = FileSystems.getDefault().newWatchService();
        //为C盘根路径注册监听
        Paths.get("C:").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
        while (true) {
            WatchKey watchKey = watchService.take();
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.context() + "文件发送了 " + event.kind() + "事件！");
            }
            boolean reset = watchKey.reset();
            if (!reset) {
                break;
            }
        }
    }
}
