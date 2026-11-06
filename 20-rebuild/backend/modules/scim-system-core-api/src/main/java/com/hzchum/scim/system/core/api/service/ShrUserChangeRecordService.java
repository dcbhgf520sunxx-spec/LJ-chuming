package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;

public interface ShrUserChangeRecordService extends IService<ShrUserChangeRecord> {
   PageVO<ShrUserChangeRecord> getAll(
      String jobName, String deptName, String name, String phone, Integer userType, Integer crudType, Integer pageNumber, Integer pageSize
   );
}
