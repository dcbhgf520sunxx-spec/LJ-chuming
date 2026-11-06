function mS(e, o, n = Rs.TYPE.normal) {
  if (!e.isRegister) return false;
  const c = o || e.form;
  try {
    return ci.set(`${Rs.KEY_PREFIX}_${e.key}`, { type: n, content: c }, e.expired), true;
  } catch (u) {
    return console.log("缓存错误信息", u), console.log("缓存", c), false;
  }
}
function Y2(e) {
  ci.remove(`${Rs.KEY_PREFIX}_${e.key}`);
}
function K2(e, o) {
  if (!e.isRegister) return;
  o.bStatus.cu > 0 && !tu(e.initForm, e.form) && mS(e, null, Rs.TYPE.browserClose);
}
function q9(e) {
  return ci.get(`${Rs.KEY_PREFIX}_${e}`);
}
const Et = {};
function cu(e, o, n = true) {
  const c = ci.get(`visibleKey_${e.title}`);
  c && Array.isArray(c) && (e.invisibleColumns = c);
  const u = Z9(e);
  return Object.seal(u), n ? G9(u, o) : { crud: u };
}
function G9(e, o) {
  const n = Z({});
  yi("crud", e), yi("permission", e.permission);
  const c = Mn(), u = e.registerVM(Et.VM_TYPE.PRESENTER, c, 0);
  return u.tableRef = o, e.ref.table = o, bl(() => {
    e.unregisterVM(c), delete e.ref.table;
  }), Ym(() => {
    e.init();
  }), El(() => {
    e.queryOnPresenterCreated && e.toQuery(), o && Ce(o, () => {
      o && o.value && e.setColumns();
    }, { immediate: true });
  }), n.value = e.obColumns(n), e.tableColumns = n, { CRUD: u.CRUD, crud: e, columns: n };
}
function f_(e) {
  const o = ft("crud"), n = Mn(), c = o.registerVM(Et.VM_TYPE.HEADER, n, 1);
  for (const u in e) typeof e[u] != "object" && (e[u] = { value: e[u], resetAble: true }), e[u] instanceof Array ? o.query[u] = e[u] : o.query[u] = e[u].value;
  return Object.assign(o.defaultQuery, JSON.parse(JSON.stringify(e))), El(() => {
    o.queryOnPresenterCreated && o.toQuery();
  }), bl(() => {
    o.unregisterVM(n);
  }), { CRUD: c.CRUD, crud: o, query: o.query };
}
function An(e = {}, o, n) {
  const c = ft("crud"), u = Mn(), r = c.registerVM(Et.VM_TYPE.FORM, u, 2);
  c.defaultForm = e, r.formRef = o, c.ref.form = o, c.resetForm();
  let E = {};
  if (c.formStore) {
    const y = A(n) ? n : c.formStoreKey;
    E = U9(y, { useDraftCallback: c.useFormDraftCallback, clearDraftCallback: c.clearFormDraftCallback });
  }
  return bl(() => {
    c.unregisterVM(u), delete c.ref.form;
  }), { CRUD: r.CRUD, crud: c, form: c.form, ADD_FORM: E };
}
function Yrt(e, o) {
  const n = ft("crud"), c = Mn(), u = n.registerVM(Et.VM_TYPE.BATCH_FORM, c, 3);
  n.defaultBatchForm = e, u.formRef = o, n.ref.batchForm = o, n.resetBatchForm();
  let r = {};
  return n.formStore && (r = F9(n.formStoreKey, { useDraftCallback: n.useBatchFormDraftCallback, clearDraftCallback: n.clearBatchFormDraftCallback })), bl(() => {
    n.unregisterVM(c), delete n.ref.batchForm;
  }), { CRUD: u.CRUD, crud: n, form: n.batchForm, ADD_FORM: r };
}
function qi() {
  const e = ft("crud"), o = Mn(), n = e.registerVM(Et.VM_TYPE.DETAIL, o, 4);
  return e.resetRowDetail(), bl(() => {
    e.unregisterVM(o);
  }), { CRUD: n.CRUD, crud: e, detail: e.rowDetail };
}
function Q9() {
  const e = ft("crud"), o = Mn(), n = e.registerVM(Et.VM_TYPE.PAGINATION, o, 5);
  return bl(() => {
    e.unregisterVM(o);
  }), { CRUD: n.CRUD, crud: e, page: e.page };
}
function ed(e = {}) {
  const o = ft("crud"), n = Mn(), c = o.registerVM(Et.VM_TYPE.OTHER, n);
  return bl(() => {
    o.unregisterVM(n);
  }), { CRUD: c.CRUD, crud: o };
}
function Z9(e) {
  const o = J9(), n = a7(o, e), c = X9(n), u = uo.cloneDeep(c), r = Ct(Object.assign({}, u));
  return $9(r, c), e7(r), t7(r, c), i7(r, c), r;
}
function J9() {
  return { title: "", url: "", emptyText: "等待加载", data: [], dataPath: "content", selections: [], query: {}, requiredQuery: [], params: {}, refreshResult: [], rowDetail: {}, detailFormApi: true, form: {}, batchForm: {}, defaultBatchForm: () => {
  }, defaultForm: () => {
  }, formStoreKey: "", formStore: false, useFormDraftCallback: null, clearFormDraftCallback: null, useBatchFormDraftCallback: null, clearBatchFormDraftCallback: null, invisibleColumns: ["createTime", "updateTime"], requiredSubmitField: [], requiredBatchSubmitField: [], submitResult: null, sort: ["id.desc"], multiLineSorting: false, time: 50, firstQueryTime: null, detailKey: "id", crudApi: { add: (e) => {
  }, batchAdd: (e) => {
  }, delete: (e) => {
  }, edit: (e) => {
  }, get: (e) => {
  } }, optShow: { batchAdd: false, add: true, edit: false, del: true, download: false }, props: {}, hasPagination: true, permission: {}, queryOnPresenterCreated: true, queryable: true, debug: false, addSuccessText: "新增成功", submitResultJudge: false };
}
function X9(e) {
  const { tablePageSize: o } = ka("tablePageSize");
  return { ...e, initOptions: e, dataStatus: {}, msg: { submit: "提交成功", add: e.addSuccessText, edit: "编辑成功", del: "删除成功" }, page: { page: 1, size: o.value, total: 0, hasNextPage: true }, detailVisible: false, detailLoading: false, editDetailLoading: false, firstLoaded: false, loading: false, downloadLoading: false, delAllLoading: false, searchToggle: true };
}
function $9(e, o) {
  Object.assign(e, { defaultSort: o.sort, multiLineSorting: o.multiLineSorting, defaultQuery: JSON.parse(JSON.stringify(o.query)), vms: [], ref: {}, tableColumns: {}, status: { add: Et.STATUS.NORMAL, edit: Et.STATUS.NORMAL, get cu() {
    if (this.add === Et.STATUS.NORMAL && this.edit === Et.STATUS.NORMAL) return Et.STATUS.NORMAL;
    if (this.add === Et.STATUS.PREPARED || this.edit === Et.STATUS.PREPARED) return Et.STATUS.PREPARED;
    if (this.add === Et.STATUS.PROCESSING || this.edit === Et.STATUS.PROCESSING) return Et.STATUS.PROCESSING;
    throw new Error("错误的状态");
  }, get title() {
    return this.add > Et.STATUS.NORMAL ? `新增${o.title}` : this.edit > Et.STATUS.NORMAL ? `编辑${o.title}` : "";
  } }, bStatus: { batchAdd: Et.STATUS.NORMAL, batchEdit: Et.STATUS.NORMAL, get cu() {
    if (this.batchAdd === Et.STATUS.NORMAL && this.batchEdit === Et.STATUS.NORMAL) return Et.STATUS.NORMAL;
    if (this.batchAdd === Et.STATUS.PREPARED || this.batchEdit === Et.STATUS.PREPARED) return Et.STATUS.PREPARED;
    if (this.batchAdd === Et.STATUS.PROCESSING || this.batchEdit === Et.STATUS.PROCESSING) return Et.STATUS.PROCESSING;
    throw new Error("错误的状态");
  }, get title() {
    return this.batchAdd > Et.STATUS.NORMAL ? `新增${o.title}` : this.batchEdit > Et.STATUS.NORMAL ? `编辑${o.title}` : "";
  } }, detailTitle: `${o.title}详情` });
}
function e7(e) {
  const o = () => {
    e.notify(e.msg.submit, Et.NOTIFICATION_TYPE.SUCCESS);
  }, n = () => {
    e.notify(e.msg.add, Et.NOTIFICATION_TYPE.SUCCESS);
  }, c = () => {
    e.notify(e.msg.edit, Et.NOTIFICATION_TYPE.SUCCESS);
  }, u = () => {
    e.notify(e.msg.del, Et.NOTIFICATION_TYPE.SUCCESS);
  }, r = () => !e.requiredQuery.some((ae) => Ae(e.query[ae])), E = () => !e.requiredSubmitField.some((ae) => e.form[ae] === null || e.form[ae] === void 0), y = () => !e.requiredBatchSubmitField.some((ae) => e.batchForm[ae] === null || e.batchForm[ae] === void 0), b = async () => {
    if (!e.queryable) return;
    const q = /* @__PURE__ */ new Set();
    if (e.vms.forEach((le) => le && q.add(le.vm)), !q.size) {
      setTimeout(() => {
        e.toQuery();
      }, Et.QUERY_DEBOUNCE_TIME);
      return;
    }
    if (!r()) {
      e.data = [], e.page.total = 0, e.emptyText = "暂无数据";
      return;
    }
    const ae = Date.now();
    (e.firstQueryTime && ae - e.firstQueryTime > Et.QUERY_DEBOUNCE_TIME || !e.firstQueryTime && e.firstQueryTime !== 0) && (e.firstQueryTime ? ee() : (B(), e.firstQueryTime = ae));
  }, V = async () => {
    var ae;
    if (!Ai(e.permission.get)) {
      e.emptyText = "暂无权限";
      return;
    }
    if (e.emptyText = "加载中", !await Ei(e, Et.HOOK.beforeRefresh) && !r()) {
      e.data = [], e.page.total = 0, e.emptyText = "重新加载";
      return;
    }
    let q = [];
    e.selectAllChange();
    try {
      e.loading = true, q = await e.crudApi.get(e.getQueryParams());
      const j = e.refreshResult.length + 1;
      e.refreshResult.push(j);
      const le = { data: q };
      e.emptyText = "暂无数据", await Ei(e, Et.HOOK.handleRefresh, le), Math.max(...e.refreshResult) === j && (e.page.total = q.totalElements || 0, e.page.hasNextPage = q.hasNextPage, e.data = A(e.dataPath) ? le.data[e.dataPath] || [] : le.data || [], e.resetDataStatus(), e.loading = false, e.refreshResult = []);
    } catch (j) {
      e.page.total = 0, e.page.hasNextPage = false, e.data = [], (ae = j == null ? void 0 : j.message) != null && ae.cancel || (e.emptyText = "加载失败", e.loading = false), e.resetDataStatus(), console.log("crud-加载（刷新）数据", j);
    } finally {
      setTimeout(async () => {
        e.firstLoaded = true, await Ei(e, Et.HOOK.afterRefresh, q);
      }, e.time);
    }
  }, M = async (q, ae) => {
    e.detailLoading = false, e.detailFormApi && typeof e.crudApi.detail == "function" ? (e.resetRowDetail(q), e.detailLoading = true, e.crudApi.detail(q.id, { ...ae }).then((j) => {
      e.resetRowDetail({ rowDetail: { ...q }, ...j }), Ei(e, Et.HOOK.beforeDetailLoaded, e.rowDetail).then(() => {
        e.detailLoading = false;
      });
    }).catch(() => {
      g(), ot.error("加载失败"), e.detailLoading = false;
    })) : e.resetRowDetail(q), await Ei(e, Et.HOOK.beforeToDetail, e.rowDetail) && (e.detailVisible = true, await Ei(e, Et.HOOK.afterToDetail, e.rowDetail));
  }, g = async (q) => {
    await Ei(e, Et.HOOK.beforeDetailCancel, q) && (e.resetRowDetail(), e.detailVisible = false, await Ei(e, Et.HOOK.afterDetailCancel, q));
  }, S = async () => {
    await Ei(e, Et.HOOK.beforeToAdd, e.form) && await Ei(e, Et.HOOK.beforeToCU, e.form) && (e.status.add = Et.STATUS.PREPARED, e.submitResult = null, await Ei(e, Et.HOOK.afterToAdd, e.form), await Ei(e, Et.HOOK.afterToCU, e.form));
  }, h = async (q) => {
    e.resetForm(JSON.parse(JSON.stringify(q))), e.editDetailLoading = false, e.detailFormApi && typeof e.crudApi.detail == "function" && (e.editDetailLoading = true, e.crudApi.detail(q[e.detailKey]).then((ae) => {
      e.resetForm(JSON.parse(JSON.stringify(ae))), Ei(e, Et.HOOK.beforeEditDetailLoaded, e.form).then(() => {
        e.editDetailLoading = false;
      });
    }).catch(() => {
      R(), ot.error("加载失败"), e.editDetailLoading = false;
    })), await Ei(e, Et.HOOK.beforeToEdit, e.form) && await Ei(e, Et.HOOK.beforeToCU, e.form) && (e.status.edit = Et.STATUS.PREPARED, e.submitResult = null, e.getDataStatus(q.id).edit = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterToEdit, e.form), await Ei(e, Et.HOOK.afterToCU, e.form));
  }, T = async () => {
    await Ei(e, Et.HOOK.beforeToBatchAdd, e.batchForm) && await Ei(e, Et.HOOK.beforeToBCU, e.batchForm) && (e.bStatus.batchAdd = Et.STATUS.PREPARED, e.submitResult = null, await Ei(e, Et.HOOK.afterToBatchAdd, e.batchForm), await Ei(e, Et.HOOK.afterToBCU, e.batchForm));
  }, _ = async (q) => {
    e.resetBatchForm(JSON.parse(JSON.stringify(q))), await Ei(e, Et.HOOK.beforeToBatchEdit, e.batchForm) && await Ei(e, Et.HOOK.beforeToBCU, e.batchForm) && (e.bStatus.edit = Et.STATUS.PREPARED, e.submitResult = null, e.getDataStatus(q.id).batchEdit = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterToBatchEdit, e.batchForm), await Ei(e, Et.HOOK.afterToBCU, e.batchForm));
  }, f = (q) => {
    e.getDataStatus(q.id).delete = Et.STATUS.PREPARED;
  }, m = async (q) => {
    await Ei(e, Et.HOOK.beforeDeleteCancel, q) && (e.getDataStatus(q.id).delete = Et.STATUS.NORMAL, await Ei(e, Et.HOOK.afterDeleteCancel, q));
  }, R = async () => {
    const q = e.status.add, ae = e.status.edit;
    if (q === Et.STATUS.PREPARED) {
      if (!await Ei(e, Et.HOOK.beforeAddCancel, e.form)) return;
      e.status.add = Et.STATUS.NORMAL;
    }
    if (ae === Et.STATUS.PREPARED) {
      if (!await Ei(e, Et.HOOK.beforeEditCancel, e.form)) return;
      e.status.edit = Et.STATUS.NORMAL, e.getDataStatus(e.form.id).edit = Et.STATUS.NORMAL;
    }
    e.resetForm(), q === Et.STATUS.PREPARED && await Ei(e, Et.HOOK.afterAddCancel, e.form), ae === Et.STATUS.PREPARED && await Ei(e, Et.HOOK.afterEditCancel, e.form), e.ref.form && pt(() => {
      e.ref.form.clearValidate();
    });
  }, v = async () => {
    const q = e.bStatus.batchAdd, ae = e.bStatus.batchEdit;
    if (q === Et.STATUS.PREPARED) {
      if (!await Ei(e, Et.HOOK.beforeBatchAddCancel, e.batchForm)) return;
      e.bStatus.batchAdd = Et.STATUS.NORMAL;
    }
    if (ae === Et.STATUS.PREPARED) {
      if (!await Ei(e, Et.HOOK.beforeBatchEditCancel, e.batchForm)) return;
      e.bStatus.batchEdit = Et.STATUS.NORMAL, e.getDataStatus(e.batchForm.id).batchEdit = Et.STATUS.NORMAL;
    }
    e.resetBatchForm(), q === Et.STATUS.PREPARED && await Ei(e, Et.HOOK.afterBatchAddCancel, e.batchForm), ae === Et.STATUS.PREPARED && await Ei(e, Et.HOOK.afterBatchEditCancel, e.batchForm), e.ref.batchForm && pt(() => {
      e.ref.batchForm.clearValidate();
    });
  }, N = async () => {
    E() && await Ei(e, Et.HOOK.beforeValidateCU) && e.ref.form.validate(async (q) => {
      q && await Ei(e, Et.HOOK.afterValidateCU) && (e.status.add === Et.STATUS.PREPARED ? L() : e.status.edit === Et.STATUS.PREPARED && O());
    });
  }, P = async () => {
    y() && await Ei(e, Et.HOOK.beforeValidateBCU) && e.ref.batchForm.validate(async (q) => {
      q && await Ei(e, Et.HOOK.afterValidateBCU) && (e.bStatus.batchAdd === Et.STATUS.PREPARED ? x() : e.bStatus.batchEdit === Et.STATUS.PREPARED && I());
    });
  }, L = async () => {
    if (await Ei(e, Et.HOOK.beforeSubmit)) try {
      e.status.add = Et.STATUS.PROCESSING;
      const q = await e.submitFormFormat(uo.cloneDeep(e.form));
      e.submitResult = await e.crudApi.add(q), await Ei(e, Et.HOOK.afterAddSuccess), e.status.add = Et.STATUS.NORMAL, e.resetForm(), e.ref.form && pt(() => {
        e.ref.form.clearValidate();
      }), e.addSuccessNotify(), await Ei(e, Et.HOOK.afterSubmit), e.toQuery();
    } catch (q) {
      console.log("添加", q), e.status.add = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterAddError);
    }
  }, O = async () => {
    var q;
    if (await Ei(e, Et.HOOK.beforeSubmit)) try {
      e.status.edit = Et.STATUS.PROCESSING;
      const ae = await e.submitFormFormat(uo.cloneDeep(e.form));
      if (e.submitResult = await e.crudApi.edit(ae), ((q = e == null ? void 0 : e.submitResult) == null ? void 0 : q.code) === 40206 && e.submitResultJudge) {
        e.status.edit = Et.STATUS.PREPARED;
        return;
      }
      e.status.edit = Et.STATUS.NORMAL, e.getDataStatus(e.form.id).edit = Et.STATUS.NORMAL, e.editSuccessNotify(), e.resetForm(), e.ref.form && pt(() => {
        e.ref.form.clearValidate();
      }), await Ei(e, Et.HOOK.afterSubmit), e.refresh();
    } catch (ae) {
      console.log("编辑", ae), e.status.edit = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterEditError);
    }
  }, x = async () => {
    if (await Ei(e, Et.HOOK.beforeBatchSubmit)) try {
      e.bStatus.batchAdd = Et.STATUS.PROCESSING;
      const q = await e.submitBatchFormFormat(uo.cloneDeep(e.batchForm));
      e.submitResult = await e.crudApi.batchAdd(q), await Ei(e, Et.HOOK.afterBatchAddSuccess), e.bStatus.batchAdd = Et.STATUS.NORMAL, e.resetBatchForm(), e.addSuccessNotify(), await Ei(e, Et.HOOK.afterBatchSubmit), e.toQuery();
    } catch (q) {
      console.log("添加", q), e.bStatus.batchAdd = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterBatchAddError);
    }
  }, I = async () => {
    if (await Ei(e, Et.HOOK.beforeBatchSubmit)) try {
      e.bStatus.batchEdit = Et.STATUS.PROCESSING, e.submitResult = await e.crudApi.batchEdit(e.batchForm), e.bStatus.batchEdit = Et.STATUS.NORMAL, e.getDataStatus(e.batchForm.id).edit = Et.STATUS.NORMAL, e.editSuccessNotify(), e.resetBatchForm(), await Ei(e, Et.HOOK.afterBatchSubmit), e.refresh();
    } catch (q) {
      console.log("编辑", q), e.bStatus.batchEdit = Et.STATUS.PREPARED, await Ei(e, Et.HOOK.afterBatchEditError);
    }
  }, Y = async (q) => {
    let ae = false, j;
    const le = [];
    if (q instanceof Array ? (ae = true, q.forEach((oe) => {
      le.push(oe.id);
    })) : (le.push(q.id), j = e.getDataStatus(q.id)), !!await Ei(e, Et.HOOK.beforeDelete, q)) return ae || (j.delete = Et.STATUS.PROCESSING), e.crudApi.del(le).then(async (oe) => {
      if (console.log(oe), ae ? e.delAllLoading = false : j.delete = Et.STATUS.PREPARED, e.dleChangePage(1), oe.data === false) {
        ot({ message: oe.message, type: "error" }), e.refresh();
        return;
      }
      e.delSuccessNotify(), await Ei(e, Et.HOOK.afterDelete, q), e.refresh();
    }).catch(() => {
      ae ? e.delAllLoading = false : j.delete = Et.STATUS.PREPARED;
    });
  }, ee = Nc(async () => {
    B();
  }, Et.QUERY_DEBOUNCE_TIME, false), B = async () => {
    await Ei(e, Et.HOOK.beforeToQuery) && (e.page.page = 1, e.page.hasNextPage = true, e.firstLoaded = false, e.refresh(), await Ei(e, Et.HOOK.afterToQuery));
  };
  Object.assign(e, { submitSuccessNotify: o, addSuccessNotify: n, editSuccessNotify: c, delSuccessNotify: u, toQuery: b, refresh: V, toDetail: M, cancelDetail: g, toAdd: S, toEdit: h, toDelete: f, cancelDelete: m, cancelCU: R, submitCU: N, doDelete: Y, cancelBCU: v, submitBCU: P, toBatchAdd: T, toBatchEdit: _, doBatchAdd: x, doBatchEdit: I });
}
function t7(e, o) {
  Object.assign(e, { doExport: async (ee) => {
    try {
      e.downloadLoading = true, await rS(e.crudApi.download, ee);
    } catch (B) {
      console.log(B);
    } finally {
      e.downloadLoading = false;
    }
  }, getQueryParams: () => ({ pageNumber: e.hasPagination ? e.page.page : void 0, pageSize: e.hasPagination ? e.page.size : void 0, sort: e.sort, ...e.query, ...e.params }), pageChangeHandler: async (ee) => {
    e.page.page = ee, await e.refresh();
  }, sizeChangeHandler: async (ee) => {
    e.page.size = ee, e.page.page = 1, await e.refresh();
  }, dleChangePage: (ee) => {
    e.data.length === ee && e.page.page !== 1 && (e.page.page -= 1);
  }, resetQuery: async (ee = true) => {
    if (!await Ei(e, Et.HOOK.beforeResetQuery, o)) return;
    const B = JSON.parse(JSON.stringify(e.defaultQuery)), q = e.query;
    Object.keys(q).forEach((ae) => {
      B[ae] ? typeof B[ae] == "object" && A(B[ae].resetAble) ? B[ae].resetAble && (q[ae] = B[ae].value) : q[ae] = B[ae] : q[ae] = void 0;
    }), ee && e.toQuery();
  }, resetRowDetail: (ee) => {
    const B = ee || {}, q = e.rowDetail || {};
    for (const ae in q) q[ae] = void 0;
    for (const ae in B) q[ae] = B[ae];
  }, resetForm: (ee) => {
    const B = e.ref.form;
    B && B.resetFields();
    const q = ee || (typeof e.defaultForm == "object" ? JSON.parse(JSON.stringify(e.defaultForm)) : {}), ae = e.form || {};
    for (const j in ae) ae[j] = void 0;
    for (const j in q) ae[j] = q[j];
    B && pt(() => {
      B.clearValidate();
    });
  }, resetBatchForm: (ee) => {
    const B = e.ref.batchForm;
    B && B.resetFields();
    const q = ee || (typeof e.defaultBatchForm == "object" ? JSON.parse(JSON.stringify(e.defaultBatchForm)) : e.defaultBatchForm()), ae = e.batchForm;
    for (const j in ae) ae[j] = void 0;
    for (const j in q) ae[j] = q[j];
  }, reloadDetail: (ee) => {
    const B = ee || (e.rowDetail ? e.rowDetail.id : void 0);
    B && e.detailFormApi && typeof e.crudApi.detail == "function" && (e.detailLoading = true, e.crudApi.detail(B).then((q) => {
      e.resetRowDetail(q), e.resetRowDetail({ rowDetail: { ...o.rowDetail }, ...q }), Ei(e, Et.HOOK.beforeDetailLoaded, e.rowDetail).then(() => {
        e.detailLoading = false;
      });
    }).catch((q) => {
      console.log("详情加载失败", q), ot.error("详情加载失败"), e.detailLoading = false;
    }));
  }, validateField: (ee) => {
    e.ref.form.validateField(ee);
  }, validateFieldForBatch: (ee) => {
    e.ref.batchForm.validateField(ee);
  }, submitFormFormat: (ee) => ee, submitBatchFormFormat: (ee) => ee, resetDataStatus: () => {
    const ee = {};
    function B(q = []) {
      console.log(e.data, q, "111111"), q.forEach((ae) => {
        ee[ae.id] = { delete: 0, edit: 0, batchEdit: 0 }, ae.children && B(ae.children);
      });
    }
    B(e.data), e.dataStatus = ee || [];
  }, getDataStatus: (ee) => e.dataStatus[ee], selectionChangeHandler: (ee) => {
    e.selections = ee;
  }, selectAllChange: (ee) => {
    ee && ee.length === e.data.length ? ee.forEach((B) => {
      e.selectChange(ee, B);
    }) : e.ref.table && e.ref.table.clearSelection();
  }, selectChange: (ee, B) => {
    ee.find((q) => q.id === B.id) ? B.children && B.children.forEach((q) => {
      e.ref.table.toggleRowSelection(q, true), ee.push(q), q.children && e.selectChange(ee, q);
    }) : e.toggleRowSelection(ee, B);
  }, toggleRowSelection: (ee, B) => {
    B.children && B.children.forEach((q) => {
      e.ref.table.toggleRowSelection(q, false);
      for (const ae in ee) if (ee[ae].id === q.id) {
        ee.splice(ae, 1);
        break;
      }
      q.children && e.toggleRowSelection(ee, q);
    });
  }, handleSortChange: ({ column: ee, prop: B, order: q }) => {
    let ae = [];
    if (e.multiLineSorting) {
      if (q) {
        const j = q === "ascending" ? "asc" : "desc", le = e.sort;
        let oe = [], ye = [], ce, se = false;
        le.length > 1 ? (ye = le == null ? void 0 : le.slice(0, le.length - 1), oe = le == null ? void 0 : le.slice(-1), ye.forEach((he, be) => {
          he.includes(B) && (se = true, ce = be);
        }), se ? ye[ce] = `${B}.${j}` : ye.push(`${B}.${j}`), ae = [...ye, ...oe]) : (le.forEach((he, be) => {
          he.includes(B) && (se = true, ce = be);
        }), se ? le[ce] = `${B}.${j}` : le.unshift(`${B}.${j}`), ae = le);
      } else {
        const j = e.sort;
        let le, oe = false;
        j.forEach((ye, ce) => {
          ye.includes(B) && (oe = true, le = ce);
        }), oe && j.splice(le, 1), ae = j, console.log(j);
      }
      console.log(ae, "sort");
    } else q ? ae = [`${B}.${q === "ascending" ? "asc" : "desc"}`] : ae = e.defaultSort;
    e.sort = ae, e.toQuery();
  }, notify: (ee, B = Et.NOTIFICATION_TYPE.INFO) => {
    Di({ title: ee, type: B, duration: 2500 });
  }, setColumns: () => {
    e.ref.table && pt(() => {
      const ee = e.tableColumns, B = uo.cloneDeep(ee);
      Object.keys(ee).forEach((ae) => {
        ae !== "visible" && delete ee[ae];
      }), e.ref.table.getColumns().forEach((ae) => {
        !ae.property || ae.type !== "default" || (ee[ae.property] = { label: ae.label, visible: true });
      }), pt(() => {
        Object.keys(ee).forEach((j) => {
          j !== "visible" && delete ee[j];
        }), e.ref.table.getColumns().forEach((j) => {
          !j.property || j.type !== "default" || (ee[j.property] = { label: j.label }, B[j.property] ? ee[j.property].visible = B[j.property].visible : ee[j.property].visible = e.invisibleColumns.indexOf(j.property) === -1);
        });
      });
    });
  }, obColumns: (ee) => ({ visible(B) {
    return !ee || !ee.value[B] ? true : ee.value[B].visible;
  } }), updateProp: (ee, B) => {
    e.props[ee] = B;
  } });
}
function i7(e, o) {
  Object.assign(e, { init: () => {
    Object.assign(e, uo.cloneDeep(o)), e.status.add = Et.STATUS.NORMAL, e.status.edit = Et.STATUS.NORMAL, e.bStatus.batchAdd = Et.STATUS.NORMAL, e.bStatus.batchEdit = Et.STATUS.NORMAL;
  }, registerVM: (E, y, b = -1) => {
    const V = { uid: y.uid, uuid: `${y.uid}_${(/* @__PURE__ */ new Date()).getTime()}_${e.vms.length}`, type: E, vm: y, CRUD: { HOOK: {}, STATUS: Et.STATUS, NOTIFICATION_TYPE: Et.NOTIFICATION_TYPE } };
    return b < 0 ? e.vms.push(V) : (e.vms.length = Math.max(e.vms.length, b), e.vms.splice(b, 1, V)), V;
  }, unregisterVM: (E) => e.vms.splice(e.vms.findIndex((b) => b && b.uid === E.uid), 1), findVM: (E, y = "type") => e.vms.find((b) => b && b[y] === E).vm });
}
async function Ei(e, o) {
  e.debug;
  let n = true;
  const c = [e];
  for (let u = 2; u < arguments.length; ++u) c.push(arguments[u]);
  for (const u of e.vms) u && u.CRUD.HOOK[o] && (n = await u.CRUD.HOOK[o].apply(u, c) !== false && n);
  return n;
}
function a7(e, o) {
  const n = { ...e };
  return Object.keys(e).forEach((c) => {
    Object.prototype.hasOwnProperty.call(o, c) && (n[c] = o[c]);
  }), n;
}
Et.QUERY_DEBOUNCE_TIME = 350;
Et.VM_TYPE = { PRESENTER: "presenter", HEADER: "header", PAGINATION: "pagination", FORM: "form", DETAIL: "detail", BATCH_FORM: "batchForm", OTHER: "other" };
Et.STATUS = { NORMAL: 0, PREPARED: 1, PROCESSING: 2 };
Et.NOTIFICATION_TYPE = { SUCCESS: "success", WARNING: "warning", INFO: "info", ERROR: "error" };
Et.HOOK = { beforeToQuery: "beforeToQuery", afterToQuery: "afterToQuery", beforeRefresh: "beforeRefresh", afterRefresh: "afterRefresh", beforeDelete: "beforeDelete", afterDelete: "afterDelete", beforeDeleteCancel: "beforeDeleteCancel", afterDeleteCancel: "afterDeleteCancel", beforeToDetail: "beforeToDetail", afterToDetail: "afterToDetail", beforeDetailLoaded: "beforeDetailLoaded", beforeDetailCancel: "beforeDetailCancel", afterDetailCancel: "afterDetailCancel", beforeToAdd: "beforeToAdd", afterToAdd: "afterToAdd", beforeEditDetailLoaded: "beforeEditDetailLoaded", beforeToEdit: "beforeToEdit", afterToEdit: "afterToEdit", beforeToCU: "beforeToCU", afterToCU: "afterToCU", beforeValidateCU: "beforeValidateCU", afterValidateCU: "afterValidateCU", beforeAddCancel: "beforeAddCancel", afterAddCancel: "afterAddCancel", beforeEditCancel: "beforeEditCancel", afterEditCancel: "afterEditCancel", beforeSubmit: "beforeSubmit", afterSubmit: "afterSubmit", afterAddSuccess: "afterAddSuccess", afterAddError: "afterAddError", afterEditError: "afterEditError", beforeToBatchAdd: "beforeToBatchAdd", afterToBatchAdd: "afterToBatchAdd", beforeToBatchEdit: "beforeToBatchEdit", afterToBatchEdit: "afterToBatchEdit", beforeToBCU: "beforeToBCU", afterToBCU: "afterToBCU", beforeValidateBCU: "beforeValidateBCU", afterValidateBCU: "afterValidateBCU", beforeBatchAddCancel: "beforeBatchAddCancel", afterBatchAddCancel: "afterBatchAddCancel", beforeBatchEditCancel: "beforeBatchEditCancel", afterBatchEditCancel: "afterBatchEditCancel", beforeBatchSubmit: "beforeBatchSubmit", afterBatchSubmit: "afterBatchSubmit", afterBatchAddSuccess: "afterBatchAddSuccess", afterBatchAddError: "afterBatchAddError", afterBatchEditError: "afterBatchEditError", beforeResetQuery: "beforeResetQuery", afterResetQuery: "afterResetQuery", handleRefresh: "handleRefresh" };
function l7(e) {
  if (e instanceof HTMLElement) {
    if (e.scrollTop > 0) return true;
    {
      e.scrollTop++;
      const o = e.scrollTop;
      return o && (e.scrollTop = 0), o > 0;
    }
  }
}
function o7(e = "", { attribute: o } = {}) {
  const n = document.createElement("span");
  o && o.forEach((u, r) => {
    n.setAttribute(r, u);
  }), n.style.display = "inline-block", n.textContent = e, document.body.appendChild(n);
  const c = n.clientWidth;
  return document.body.removeChild(n), c;
}
function pS(e, o) {
  if (e instanceof HTMLElement) return window.getComputedStyle(e)[o];
}
function hS(e) {
  if (Ae(e)) return;
  const o = e.match(/^\d+\.?\d*/);
  return Ae(o) ? void 0 : Number(o[0]);
}
function n7(e) {
  if (Ae(e)) return [null, null];
  if (typeof e == "string") {
    const o = e.match(/^\d+\.?\d*/);
    if (Ae(o)) return [null, null];
    const n = o[0];
    return [Number(n), e.substring(n.length)];
  }
  if (typeof e == "number") return [e, null];
}
const s7 = ".el-pagination", r7 = "#navbar";
function Kt({ mainBox: e, extraBox: o = ".head-container", wrapperBox: n = ".app-container", navbar: c = !e, paginate: u = false, extraHeight: r = 0, minHeight: E = 400, clientHRepMainH: y = false } = {}, b) {
  const V = Z(0), M = Z(), g = Z(), S = Z(false);
  El(() => {
    if (A(b)) {
      let T;
      switch (b.constructor.name) {
        case "Function":
        case "RefImpl":
        case "EL":
        case "ComputedRefImpl":
          T = b;
          break;
        default:
          T = b;
      }
      Ce(T, (_) => {
        _ ? j2(h, S) : F2(h);
      }, { immediate: true });
    } else j2(h, S);
  }), A6(() => {
    S.value && h();
  }), bl(() => {
    F2(h);
  });
  const h = () => {
    V.value = u7({ clientHRepMainH: y, mainBox: e, extraBox: o, wrapperBox: n, navbar: c, paginate: u, extraHeight: r, minHeight: E }), g.value = `height: ${V.value}px`, M.value = `max-height: ${V.value}px`;
  };
  return { maxHeight: V, heightStyle: g, maxHeightStyle: M, fixMaxHeight: () => pt(() => h()) };
}
function u7({ clientHRepMainH: e, mainBox: o, extraBox: n, wrapperBox: c, navbar: u, paginate: r, extraHeight: E, minHeight: y }) {
  const [b, V] = d7(o), M = Ld(n, b), g = c7(c, b), S = r ? Ld(s7, b) : 0, h = u ? Ld(r7, b) : 0, T = W2(E), _ = W2(y), f = m7(b);
  let m;
  e ? m = document.documentElement.clientHeight - cc(b, ["marginTop", "marginBottom", "paddingTop", "paddingBottom"]) : m = V;
  const R = m - h - g - M - S - T - f - 1;
  return R > _ ? R : _;
}
function c7(e, o) {
  return fS(e, o, ["paddingTop", "paddingBottom"]);
}
function Ld(e, o) {
  return fS(e, o, ["height", "marginTop", "marginBottom"]);
}
function fS(e, o, n) {
  let c = 0, u = e;
  return u instanceof Array || (u = u ? [u] : []), u = gS(u), u.forEach((r) => {
    const E = nm(r, o);
    E && (c += cc(E, n));
  }), c;
}
function cc(e, o) {
  return o.reduce((n, c) => n + hS(pS(e, c)) || 0, 0);
}
function gS(e) {
  let o = [];
  e instanceof Array && (o = JSON.parse(JSON.stringify(e))), typeof e == "string" && (o = e.split(","));
  const n = o.map((c) => {
    let u;
    return c = c.trim(), c.substr(0, 1) === "." && (u = "class"), c.substr(0, 1) === "#" && (u = "id"), u ? { name: c.substr(1, c.length), type: u } : null;
  });
  return qm(n);
}
function nm(e, o) {
  if (e.type === "class") {
    const n = document.getElementsByClassName(e.name);
    if (Ae(n)) return null;
    if (o) for (let c = 0; c < n.length; c++) {
      const u = n[c];
      if (o.contains(u)) return u;
    }
    else return n[0];
  }
  if (e.type === "id") {
    const n = document.getElementById(e.name);
    if (o) {
      if (o.contains(n)) return n;
    } else return n;
  }
  return null;
}
function d7(e) {
  if (Ae(e)) return [document.documentElement, document.documentElement.clientHeight || 0];
  const o = gS(e);
  let n;
  if (o.length > 0) {
    let r = null;
    o.forEach((E, y) => {
      r = nm(E, r);
    }), n = r;
  } else n = nm(o);
  const c = cc(n, ["height"]), u = cc(n, ["paddingTop", "paddingBottom"]);
  return [n, c - u];
}
function m7(e) {
  const o = l7(e), n = window.innerWidth - document.body.clientWidth;
  return o ? n : 0;
}
function W2(e) {
  if (Ae(e)) return 0;
  const o = n7(e);
  let n;
  switch (o[1]) {
    case "vh":
      n = document.documentElement.clientHeight * o[0] / 100;
      break;
    case "vw":
      n = document.documentElement.clientWidth * o[0] / 100;
      break;
    default:
      n = o[0];
  }
  return n;
}
function j2(e, o) {
  pt(() => {
    e(), window.addEventListener("resize", e, { passive: false }), o.value = true;
  });
}
function F2(e) {
  window.removeEventListener("resize", e);
}
const p7 = { __name: "Pagination", props: { pageSizes: { type: Array, default: () => [10, 20, 30, 40, 50, 100, 200, 500] } }, setup(e) {
  const { crud: o, page: n } = Q9();
  return (c, u) => {
    const r = Fn;
    return w(), U(r, { "current-page": l(n).page, "onUpdate:currentPage": u[0] || (u[0] = (E) => l(n).page = E), "page-size": l(n).size, "onUpdate:pageSize": u[1] || (u[1] = (E) => l(n).size = E), "page-sizes": e.pageSizes, total: l(n).total, layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: u[2] || (u[2] = (E) => l(o).sizeChangeHandler(E)), onCurrentChange: l(o).pageChangeHandler }, null, 8, ["current-page", "page-size", "page-sizes", "total", "onCurrentChange"]);
  };
} }, td = ut(p7, [["__scopeId", "data-v-a8d0f55e"]]), ES = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.workshopName);
  if (n.value || o.dispatch("config/fetchWorkshopName"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { workshopName: Ee(() => o.state.config.workshopName), workshopNameKV: Ee(() => o.state.config.workshopNameKV), mesWorkShopName: Ee(() => o.state.config.mesWorkShopName), loaded: n };
};
const h7 = { key: 1, class: "subscript" }, f7 = { class: "table-cell-tag-container" }, g7 = { __name: "index", props: { name: { type: String, default: "" }, type: { type: String }, color: { type: String, default: jA }, textColor: { type: String, default: "#FFFFFF" }, placement: { type: String, default: "left" }, show: { type: Boolean, default: true }, offset: { type: Number, default: 0 } }, setup(e) {
  const o = e, n = { factory: "#1682e6", partyA: "#e64242", transfer: "#e64242", supplement: "#f56c6c", transferOutbound: "#409eff", unfreeze: "#f78989", printed: "#0f9747" }, c = Ee(() => {
    var r;
    return ((r = o.name) == null ? void 0 : r.length) <= 4;
  }), u = Ee(() => {
    if (o.name) {
      let r = o.color;
      return o.type && n[o.type] && (r = n[o.type]), { "background-color": r, color: o.textColor };
    }
    return {};
  });
  return (r, E) => {
    const y = jt;
    return w(), Q(Qe, null, [e.show ? (w(), Q("span", { key: 0, style: ri({ "margin-left": `${o.offset}px` }) }, null, 4)) : H("", true), e.show ? (w(), Q("div", h7, [C("span", f7, [C("span", { style: ri(u.value), class: "table-cell-tag" }, [s(y, { content: o.name, disabled: c.value, "open-delay": 300, placement: o.placement, effect: "light" }, { default: p(() => {
      var b;
      return [C("span", null, K((b = o.name) == null ? void 0 : b.substr(0, 4)), 1)];
    }), _: 1 }, 8, ["content", "disabled", "placement"])], 4)])])) : H("", true)], 64);
  };
} }, g_ = ut(g7, [["__scopeId", "data-v-d997ec37"]]), Os = { __name: "workshop-table-cell-tag", props: { id: { type: Number }, offset: { type: Number, default: 15 } }, setup(e) {
  const o = e, { workshopNameKV: n } = ES(), c = Ee(() => n.value[o.id]);
  return (u, r) => (w(), Q("span", { class: "workshop-table-cell-tag", style: ri({ "margin-left": `${o.offset}px` }) }, [c.value ? (w(), U(g_, { key: 0, name: c.value.name, color: c.value.tagColor }, null, 8, ["name", "color"])) : H("", true)], 4));
} };
async function _a() {
  const e = _e.getters.baseUnit;
  return A(e) ? e : (await _e.dispatch("wms/fetchWmsConfig"), _e.getters.baseUnit);
}
async function du(e = 1) {
  try {
    return _e.state.config.loaded.unit || await _e.dispatch("config/fetchUnit"), _e.state.config.unit.MAP;
  } catch {
    if (e && e <= 10) return await Vs(1e3), await du(++e);
    throw new Error("加载单位失败");
  }
}
