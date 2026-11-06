package com.hzchum.scim.business.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface BusinessCheckInfoService extends IService<BusinessCheckInfo> {
   PageVO<CheckInfoDO> listInfo(Long projectId, Integer type, Integer status, List<LocalDateTime> dateTimeList, Integer pageNumber, Integer pageSize);

   Integer countList();

   void listExcel(Long projectId, Integer type, HttpServletResponse response);
}
