package com.hzchum.pangu.common.base;

import java.io.Serializable;

public interface Persistable<ID extends Serializable> extends Serializable {
   ID getId();
}
