package com.hzchum.scim.bid.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.QiniuUtil;
import com.hzchum.scim.bid.core.api.enums.FilesEnum;
import com.hzchum.scim.bid.core.api.pojo._do.Files;
import com.hzchum.scim.bid.core.api.pojo.vo.FilesVO;
import com.hzchum.scim.bid.core.api.service.QiniuService;
import com.hzchum.scim.bid.core.mapper.QiniuMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(rollbackFor = TransactionException.class)
@DS("bidding")
public class QiniuBizImpl extends ServiceImpl<QiniuMapper, Files> implements QiniuService {
   private static final Logger log = LoggerFactory.getLogger(QiniuBizImpl.class);
   @Resource
   private QiniuUtil qiniuUtil;

   @Override
   public FilesVO callback(HttpServletRequest request) {
      try {
         String line = "";
         BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
         StringBuilder sb = new StringBuilder();

         while ((line = br.readLine()) != null) {
            sb.append(line);
         }

         String decode = URLDecoder.decode(sb.toString(), "UTF-8");
         Files files = JSON.parseObject(decode, Files.class);
         Preconditions.checkArgument(files.getName().length() <= 100, "文件名称长度不能超过100");
         this.baseMapper.insert(files);
         FilesVO copy = BeanUtil.copy(files, FilesVO.class);
         FilesEnum filesEnum = FilesEnum.getByType(files.getType());
         copy.setUrl(this.qiniuUtil.getUrl(filesEnum.getIsPrivate(), files.getPath()));
         return copy;
      } catch (Exception e) {
         log.error("七牛云回调接口报错-------------------->", e);
         throw new BusinessException(ResultCodeEnum.INTERNAL_SERVER_ERROR);
      }
   }

   @Override
   public String getToken(Integer type) {
      return this.qiniuUtil.getUpToken(FilesEnum.getIsPrivateByType(type));
   }

   @Override
   public void upload(MultipartFile file, Integer type) {
      FilesEnum filesEnum = FilesEnum.getByType(type);
      String upToken = this.qiniuUtil.getUpToken(filesEnum.getIsPrivate());
      String path = filesEnum.getModule() + "_" + file.getOriginalFilename();
      this.qiniuUtil.upload(upToken, file, file.getOriginalFilename(), path, type);
   }

   @Override
   public String getUrl(Long id) {
      Files files = this.baseMapper.selectById(id);
      Preconditions.checkArgument(files != null, "文件不存在");
      FilesEnum filesEnum = FilesEnum.getByType(files.getType());
      return this.qiniuUtil.getUrl(filesEnum.getIsPrivate(), files.getPath());
   }
}
