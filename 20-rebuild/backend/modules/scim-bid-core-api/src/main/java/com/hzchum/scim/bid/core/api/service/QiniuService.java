package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.bid.core.api.pojo._do.Files;
import com.hzchum.scim.bid.core.api.pojo.vo.FilesVO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface QiniuService extends IService<Files> {
   FilesVO callback(HttpServletRequest request);

   String getToken(Integer type);

   void upload(MultipartFile file, Integer type);

   String getUrl(Long id);
}
