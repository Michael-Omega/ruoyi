package com.ruoyi.common.service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class QiniuCloudService {
    @Value("${qiniu.AccessKey}")
    private String ACCESS_KEY;
    @Value("${qiniu.SecretKey}")
    private String SECRET_KEY;
    /**
     * 仓库
     */
    @Value("${qiniu.Bucket}")
    private String BUCKET;
    /**
     * 七牛云外网访问地址
     */
    @Value("${qiniu.cdn.prefix}")
    public String QINIU_UPLOAD_SITE;

    public String upload(MultipartFile file, String fileName) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET);
        try {
            Response response = null;

            response = uploadManager.put(file.getInputStream(), fileName, upToken, null, null);

            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileKey(String name) {
        String prefix = "/upload/" + new SimpleDateFormat("yyyy/MM").format(new Date());
        name = StringUtils.trimToNull(name);
        if (name == null) {
            return prefix + "/" + UUID.randomUUID() + "." + null;
        } else {
            name = name.replace('\\', '/');
            name = name.substring(name.lastIndexOf("/") + 1);
            int index = name.lastIndexOf(".");
            String ext = null;
            if (index >= 0) {
                ext = StringUtils.trimToNull(name.substring(index + 1));
            }
            return prefix + "/" + UUID.randomUUID() + "." + (ext == null ? null : (ext));
        }
    }
}
