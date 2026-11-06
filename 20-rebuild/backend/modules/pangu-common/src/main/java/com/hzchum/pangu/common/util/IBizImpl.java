package com.hzchum.pangu.common.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class IBizImpl<S, M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBiz<T> {
   @Autowired
   protected S baseService;
}
