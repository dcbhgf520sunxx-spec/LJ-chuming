package com.hzchum.scim.bim.core.api.service;

import com.bimface.file.bean.FileBean;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

public interface BimModelClientService {
   @PostMapping(consumes = "multipart/form-data")
   @ApiOperation("远程服务调用--Bim模型文件直传")
   FileBean uploadPolicy(@RequestPart("file") File file);
}
