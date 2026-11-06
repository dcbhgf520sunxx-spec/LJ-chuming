const kO = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.BusinessModuleEnum);
  if (n.value || o.dispatch("config/fetchBusinessModuleEnumConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { BusinessModuleEnum: Ee(() => o.state.config.BusinessModuleEnum), loaded: n };
}, b_ = { __name: "RR.operation", props: { resetBtn: { type: Boolean, default: true } }, emits: ["resetClick"], setup(e, { emit: o }) {
  const n = e, c = o;
  function u() {
    c("resetClick"), r.resetQuery();
  }
  const r = ft("crud");
  return (E, y) => {
    const b = Ve("common-button");
    return w(), Q(Qe, null, [s(b, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: Pi(l(r).toQuery, ["stop"]) }, { default: p(() => y[0] || (y[0] = [Te("搜索")])), _: 1, __: [0] }, 8, ["onClick"]), n.resetBtn ? (w(), U(b, { key: 0, class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: Pi(u, ["stop"]) }, { default: p(() => y[1] || (y[1] = [Te(" 重置 ")])), _: 1, __: [1] })) : H("", true)], 64);
  };
} };
const DO = { class: "crud-opts" }, xO = { class: "crud-opts-left" }, UO = { class: "crud-opts-right" }, YO = { class: "column-list" }, KO = { __name: "CRUD.operation", props: { showRefresh: { type: Boolean, default: true }, showGrid: { type: Boolean, default: true }, showSearch: { type: Boolean, default: true }, addBatchText: { type: String, default: "批量新增" }, addText: { type: String, default: "新增" }, delText: { type: String, default: "删除" }, disabled: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = ft("permission"), c = Z(true), u = Z(false), { CRUD: r, crud: E } = ed(), { device: y } = ka("device");
  function b(h) {
    zi.confirm(`确认${o.delText}选中的${h.length}条数据?`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
      E.delAllLoading = true, E.doDelete(h);
    }).catch(() => {
    });
  }
  function V(h) {
    if (h === false) {
      c.value = true;
      return;
    }
    for (const T in E.tableColumns) E.tableColumns[T].visible = h;
    g(), c.value = h, u.value = false;
  }
  function M(h) {
    let T = 0, _ = 0;
    for (const f in E.tableColumns) f !== "visible" && (++T, _ += E.tableColumns[f].visible ? 1 : 0);
    if (_ === 0) {
      E.notify("请至少选择一列", r.NOTIFICATION_TYPE.WARNING), pt(function() {
        h.visible = true;
      });
      return;
    }
    g(), c.value = _ === T, u.value = _ !== T && _ !== 0;
  }
  function g() {
    const h = [];
    for (const T in E.tableColumns) !E.tableColumns[T].visible && T !== "visible" && h.push(T);
    ci.remove(`visibleKey_${E.title}`), ci.set(`visibleKey_${E.title}`, h);
  }
  function S() {
    E.searchToggle = !E.searchToggle, pt(() => {
      var h = document.createEvent("Event");
      h.initEvent("resize", true, true), window.dispatchEvent(h);
    });
  }
  return (h, T) => {
    const _ = Ve("common-button"), f = Fo, m = La, R = _t("permission");
    return w(), Q("div", DO, [C("span", xO, [xt(h.$slots, "optLeft", {}, void 0, true), l(E).optShow.batchAdd ? qe((w(), U(_, { key: 0, class: "filter-item", size: "default", type: "primary", icon: "el-icon-plus", disabled: e.disabled, onClick: Pi(l(E).toBatchAdd, ["stop"]) }, { default: p(() => [Te(K(o.addBatchText), 1)]), _: 1 }, 8, ["disabled", "onClick"])), [[R, l(n).add]]) : H("", true), l(E).optShow.add ? qe((w(), U(_, { key: 1, class: "filter-item", size: "default", type: "primary", icon: "el-icon-plus", disabled: e.disabled, onClick: Pi(l(E).toAdd, ["stop"]) }, { default: p(() => [Te(K(o.addText), 1)]), _: 1 }, 8, ["disabled", "onClick"])), [[R, l(n).add]]) : H("", true), l(E).optShow.edit ? qe((w(), U(_, { key: 2, class: "filter-item", size: "default", type: "success", icon: "el-icon-edit", disabled: e.disabled || l(E).selections.length !== 1, onClick: T[0] || (T[0] = Pi((v) => l(E).toEdit(l(E).selections[0]), ["stop"])) }, { default: p(() => T[5] || (T[5] = [Te(" 修改 ")])), _: 1, __: [5] }, 8, ["disabled"])), [[R, l(n).edit]]) : H("", true), l(E).optShow.del ? qe((w(), U(_, { key: 3, class: "filter-item", type: "danger", icon: "el-icon-delete", size: "default", loading: l(E).delAllLoading, disabled: e.disabled || l(E).selections.length === 0, onClick: T[1] || (T[1] = Pi((v) => b(l(E).selections), ["stop"])) }, { default: p(() => [Te(K(o.delText), 1)]), _: 1 }, 8, ["loading", "disabled"])), [[R, l(n).del]]) : H("", true), l(E).optShow.download ? (w(), U(_, { key: 4, loading: l(E).downloadLoading, disabled: e.disabled || !l(E).data.length, class: "filter-item", size: "default", type: "warning", icon: "el-icon-download", onClick: Pi(l(E).doExport, ["stop"]) }, { default: p(() => T[6] || (T[6] = [Te(" 导出 ")])), _: 1, __: [6] }, 8, ["loading", "disabled", "onClick"])) : H("", true), xt(h.$slots, "optRight", {}, void 0, true)]), C("span", UO, [l(y) !== "mobile" ? xt(h.$slots, "viewLeft", { key: 0 }, void 0, true) : H("", true), s(l(PV), { style: { "max-width": "142px", "margin-left": "6px" } }, { default: p(() => [o.showSearch ? (w(), U(l(xo), { key: 0, size: "default", plain: "", type: "info", icon: "el-icon-search", style: ri({ border: !o.showRefresh && !o.showGrid ? "1px solid #d3d4d6" : "" }), onClick: T[2] || (T[2] = Pi((v) => S(), ["stop"])) }, null, 8, ["style"])) : H("", true), o.showRefresh ? (w(), U(l(xo), { key: 1, size: "default", icon: "el-icon-refresh", onClick: T[3] || (T[3] = Pi((v) => l(E).refresh(), ["stop"])) })) : H("", true), o.showGrid ? (w(), U(m, { key: 2, placement: "bottom-end", width: "150", trigger: "click" }, { reference: p(() => [s(l(xo), { size: "default", icon: "el-icon-menu" })]), default: p(() => [C("div", YO, [s(f, { modelValue: c.value, "onUpdate:modelValue": T[4] || (T[4] = (v) => c.value = v), indeterminate: u.value, onChange: V, size: "default" }, { default: p(() => T[7] || (T[7] = [Te(" 全选 ")])), _: 1, __: [7] }, 8, ["modelValue", "indeterminate"]), (w(true), Q(Qe, null, ki(l(E).tableColumns, (v) => (w(), Q(Qe, null, [typeof v == "object" ? (w(), U(f, { key: v.label, modelValue: v.visible, "onUpdate:modelValue": (N) => v.visible = N, size: "default", onChange: (N) => M(v) }, { default: p(() => [Te(K(v.label), 1)]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : H("", true)], 64))), 256))])]), _: 1 })) : H("", true)]), _: 1 })])]);
  };
} }, vS = ut(KO, [["__scopeId", "data-v-c0b497bc"]]);
const WO = { class: "head-container" }, jO = { class: "filter-item title" }, FO = { class: "filter-item title", style: { padding: "0 5px" } }, zO = { __name: "header", props: { form: { type: Object, default: () => ({}) }, BusinessModuleEnum: { type: Object, default: () => ({}) }, dialogVisible: { type: Boolean, default: false }, subjoinMsgBool: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Z([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { reviewStatus: void 0, moduleType: void 0, componentNameList: void 0, versionsName: void 0, recordSerialNumber: void 0, typeTime: 1, times: [], dataSerialNumber: void 0, applicant: void 0, lastApprover: void 0, waitMeCheck: false, meLaunch: false, subjoinMsg: void 0, fulfill: false, isOpened: { value: void 0, resetAble: false } }, { crud: u, query: r } = f_(c), E = { APPLICATION_TIME: { L: "申请时间", K: "APPLICATION_TIME", V: 1 }, LAST_OPERATION_TIME: { L: "最后操作时间", K: "LAST_OPERATION_TIME", V: 2 } };
  function y() {
    r.fulfill && (r.waitMeCheck = false), u.toQuery();
  }
  function b() {
    r.waitMeCheck && (r.fulfill = false), u.toQuery();
  }
  function V() {
    r.waitMeCheck = false, u.toQuery();
  }
  return Ce(() => o.dialogVisible, async (M) => {
    await u.resetQuery(), r.moduleType = o.form.moduleType, r.componentNameList = o.form.componentNameList, r.waitMeCheck = o.form.waitMeCheck, r.meLaunch = o.form.meLaunch, r.reviewStatus = o.form.reviewStatus;
  }, { immediate: true, deep: true }), (M, g) => {
    const S = Ve("common-radio-button"), h = Ve("common-select"), T = Mt, _ = Rl, f = Fo;
    return w(), Q("div", WO, [qe(C("div", null, [s(S, { modelValue: l(r).reviewStatus, "onUpdate:modelValue": g[0] || (g[0] = (m) => l(r).reviewStatus = m), options: l(ws).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: V }, null, 8, ["modelValue", "options"]), s(h, { modelValue: l(r).moduleType, "onUpdate:modelValue": g[1] || (g[1] = (m) => l(r).moduleType = m), dataStructure: { key: "moduleType", label: "moduleTypeName", value: "moduleType" }, options: o.BusinessModuleEnum, class: "filter-item", clearable: "", placeholder: "业务模块", style: { width: "180px" }, type: "other", onChange: l(u).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(h, { modelValue: l(r).componentNameList, "onUpdate:modelValue": g[2] || (g[2] = (m) => l(r).componentNameList = m), options: l(at).ENUM, unshowOptions: [l(at).RETURN_V2.K, l(at).PURCHASE_ORDER_BG.K], class: "filter-item", clearable: "", multiple: "", placeholder: "流程类型", style: { width: "180px" }, type: "enum", onChange: l(u).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), s(T, { modelValue: l(r).versionsName, "onUpdate:modelValue": g[3] || (g[3] = (m) => l(r).versionsName = m), class: "filter-item", clearable: "", placeholder: "流程名称", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), s(T, { modelValue: l(r).recordSerialNumber, "onUpdate:modelValue": g[4] || (g[4] = (m) => l(r).recordSerialNumber = m), class: "filter-item", clearable: "", placeholder: "流程编号", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), C("div", jO, [s(h, { modelValue: l(r).typeTime, "onUpdate:modelValue": g[5] || (g[5] = (m) => l(r).typeTime = m), options: E, class: "filter-item input-border-none", placeholder: "业务模块", style: { width: "140px", "margin-right": "0", "border-radius": "0", "margin-bottom": "0" }, type: "enum", onChange: g[6] || (g[6] = (m) => l(r).times = void 0) }, null, 8, ["modelValue"]), s(_, { modelValue: l(r).times, "onUpdate:modelValue": g[7] || (g[7] = (m) => l(r).times = m), "default-time": n.value, disabledDate: (m) => m.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: l(k1), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px", "margin-bottom": "0", "margin-right": "0" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: l(u).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"])]), s(T, { modelValue: l(r).dataSerialNumber, "onUpdate:modelValue": g[8] || (g[8] = (m) => l(r).dataSerialNumber = m), class: "filter-item", clearable: "", placeholder: "单据编号", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), s(T, { modelValue: l(r).applicant, "onUpdate:modelValue": g[9] || (g[9] = (m) => l(r).applicant = m), class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), s(T, { modelValue: l(r).lastApprover, "onUpdate:modelValue": g[10] || (g[10] = (m) => l(r).lastApprover = m), class: "filter-item", clearable: "", placeholder: "最后审批人", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), e.subjoinMsgBool ? (w(), U(T, { key: 0, modelValue: l(r).subjoinMsg, "onUpdate:modelValue": g[11] || (g[11] = (m) => l(r).subjoinMsg = m), class: "filter-item", clearable: "", placeholder: "附加信息", size: "default", style: { width: "200px" }, onClear: l(u).toQuery, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"])) : H("", true), C("div", FO, [l(Ae)(l(r).reviewStatus) || l(r).reviewStatus === l(ws).WITHDRAW.V ? (w(), U(f, { key: 0, modelValue: l(r).waitMeCheck, "onUpdate:modelValue": g[12] || (g[12] = (m) => l(r).waitMeCheck = m), class: "checkedStyle", label: "待我审批的", size: "large", onChange: b }, null, 8, ["modelValue"])) : H("", true), s(f, { modelValue: l(r).meLaunch, "onUpdate:modelValue": g[13] || (g[13] = (m) => l(r).meLaunch = m), class: "checkedStyle", label: "我发起的", size: "large", onChange: l(u).toQuery }, null, 8, ["modelValue", "onChange"]), s(f, { modelValue: l(r).fulfill, "onUpdate:modelValue": g[14] || (g[14] = (m) => l(r).fulfill = m), class: "checkedStyle", label: "我审批过的", size: "large", onChange: y }, null, 8, ["modelValue"])]), s(l(b_))], 512), [[ln, l(u).searchToggle]]), s(l(vS))]);
  };
} }, BO = ut(zO, [["__scopeId", "data-v-05b9f2ea"]]);
const HO = { class: "app-tree" }, qO = { style: { display: "block", width: "80%", height: "80%" } }, GO = { class: "remark" }, QO = { class: "title" }, ZO = { key: 0, class: "title", style: { color: "#999" } }, JO = { key: 0, class: "title" }, XO = { __name: "approval-tree", props: { data: { type: Array, default: () => [] } }, setup(e) {
  const o = e;
  return (n, c) => {
    var b;
    const u = _o, r = wi, E = OV, y = kV;
    return w(), Q("div", HO, [s(y, { active: (b = o.data) == null ? void 0 : b.length, direction: "vertical" }, { default: p(() => [(w(true), Q(Qe, null, ki(e.data, (V) => (w(), U(E, { key: V.id, title: V.typeName }, { icon: p(() => [C("i", qO, [s(u, { "icon-class": `wms-${V.iconSvg}`, style: { width: "100%", height: "100%" } }, null, 8, ["icon-class"])])]), description: p(() => [(w(true), Q(Qe, null, ki(V.wmsApproveRecordDetailDTOS, (M) => {
      var g;
      return w(), Q("div", { key: M }, [C("div", GO, [C("div", QO, K((g = M.userSimpleResponseVOS) == null ? void 0 : g.name), 1), M.decision === l(nl).APPROVED.V || M.decision === l(nl).REJECT.V ? (w(), Q("div", ZO, [C("span", null, K(l(nl).VL[M.decision]) + " · " + K(M == null ? void 0 : M.approveTime), 1)])) : H("", true)]), M != null && M.opinion ? (w(), Q("div", JO, [s(r, { style: { width: "100%" }, type: "primary" }, { default: p(() => [Te(K(M == null ? void 0 : M.opinion), 1)]), _: 2 }, 1024)])) : H("", true)]);
    }), 128))]), _: 2 }, 1032, ["title"]))), 128))]), _: 1 }, 8, ["active"])]);
  };
} }, RS = ut(XO, [["__scopeId", "data-v-6da8f834"]]), tl = { __name: "index", props: { data: { type: [Array, Object] }, showTreeNum: { type: Number }, showTreeBtn: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Z([]), c = Z();
  function u(y) {
    var b, V;
    Object.prototype.toString.call(o.data) === "[object Object]" ? n.value = o.data.wmsApproveFlowDTOS : (b = o.data) == null || b.forEach((M) => {
      M.id === y && (n.value = M.wmsApproveFlowDTOS);
    }), (V = n.value) == null || V.forEach((M) => {
      var g;
      switch ((g = M == null ? void 0 : M.wmsApproveRecordDetailDTOS) == null || g.forEach((S) => {
        S.approveTime = Qi(S.approveTime);
      }), M == null ? void 0 : M.reviewStatus) {
        case nl.REJECT.V:
          M.iconSvg = "reject";
          break;
        case nl.APPROVED.V:
          M.iconSvg = "pass";
          break;
        case (nl.PENDING_REVIEW.V || nl.NOT_STARTED_YET.V):
          M.iconSvg = "auditing";
          break;
        case nl.NOT_STARTED_YET.V:
          M.type === Pn.CC.V ? M.iconSvg = "cc" : M.iconSvg = "auditing";
          break;
        case nl.REVOKE.V:
          M.iconSvg = "revoke_1";
          break;
      }
    });
  }
  function r(y) {
    u(y);
  }
  function E() {
    var y;
    Object.prototype.toString.call(o.data) === "[object Array]" && (o.showTreeNum ? c.value = o.showTreeNum : c.value = (y = o.data[o.data.length - 1]) == null ? void 0 : y.id);
  }
  return Ce(() => o.data, async (y, b) => {
    b || await E(), await u(c.value);
  }, { deep: true, immediate: true }), (y, b) => {
    const V = Ve("common-radio-button");
    return w(), Q(Qe, null, [l(A)(o.data) && o.data.length !== 1 && Object.prototype.toString.call(o.data) !== "[object Object]" && o.showTreeBtn ? (w(), U(V, { key: 0, modelValue: c.value, "onUpdate:modelValue": b[0] || (b[0] = (M) => c.value = M), dataStructure: { key: "id", label: "name", value: "id" }, options: o.data, class: "filter-item", style: { "margin-top": "10px" }, type: "other", onChange: r }, null, 8, ["modelValue", "options"])) : H("", true), s(RS, { data: n.value }, null, 8, ["data"])], 64);
  };
} };
const $O = { class: "ud-operation", style: { display: "inline-block" } }, ek = { style: { "text-align": "right", margin: "0" } }, tk = { __name: "UD.operation", props: { data: { type: Object, required: true }, disabledDetail: { type: Boolean, default: false }, disabledEdit: { type: Boolean, default: false }, disabledDel: { type: Boolean, default: false }, showDetail: { type: Boolean, default: false }, showDel: { type: Boolean, default: true }, showEdit: { type: Boolean, default: true }, editType: { type: String, default: "primary" }, detailType: { type: String, default: "info" }, detailIcon: { type: String, default: "el-icon-view" }, delType: { type: String, default: "danger" }, delIcon: { type: String, default: "el-icon-delete" }, delPrompt: { type: String, default: "确定删除本条数据吗？" }, beforeToDetail: { type: Function }, beforeToEdit: { type: Function } }, setup(e) {
  const o = e, n = ft("permission"), c = Z(false), { crud: u } = ed(), r = Ee(() => {
    const T = o.data;
    return T && (T.sourceRow ? T.sourceRow : T);
  });
  function E() {
    c.value = false, u.cancelDelete(r.value);
  }
  function y() {
    c.value = true;
  }
  function b() {
    c.value = false, u.doDelete(r.value);
  }
  function V() {
    setTimeout(() => {
      document.addEventListener("click", h, { passive: false });
    }, 0);
  }
  function M() {
    document.removeEventListener("click", h);
  }
  function g(T) {
    typeof o.beforeToDetail == "function" && o.beforeToDetail(T), setTimeout(() => {
      u.toDetail(T);
    }, 0);
  }
  async function S(T) {
    console.log(T), typeof o.beforeToEdit == "function" && await o.beforeToEdit(T), setTimeout(() => {
      u.toEdit(T);
    }, 0);
  }
  function h(T) {
    c.value = false;
  }
  return (T, _) => {
    const f = Ve("common-button"), m = La, R = _t("permission");
    return w(), Q("span", $O, [o.showDetail ? qe((w(), U(f, { key: 0, disabled: o.disabledDetail, icon: o.detailIcon, type: o.detailType, size: "default", onClick: _[0] || (_[0] = Pi((v) => g(r.value), ["stop"])) }, null, 8, ["disabled", "icon", "type"])), [[R, l(n).get]]) : H("", true), o.showEdit ? qe((w(), U(f, { key: 1, disabled: o.disabledEdit, type: o.editType, icon: "el-icon-edit", size: "default", onClick: _[1] || (_[1] = Pi((v) => S(r.value), ["stop"])) }, null, 8, ["disabled", "type"])), [[R, l(n).edit]]) : H("", true), o.showDel && l(Ai)(l(n).del) ? (w(), U(m, { key: 2, visible: c.value, "onUpdate:visible": _[2] || (_[2] = (v) => c.value = v), placement: "top", trigger: "manual", width: "180", onHide: M, onShow: V }, { reference: p(() => [s(f, { disabled: o.disabledDel, icon: o.delIcon, loading: l(u).dataStatus[e.data.id].delete === 2, type: o.delType, size: "default", onClick: Pi(y, ["stop"]) }, null, 8, ["disabled", "icon", "loading", "type"])]), default: p(() => [C("p", null, K(o.delPrompt), 1), C("div", ek, [s(f, { link: true, size: "default", onClick: E }, { default: p(() => _[3] || (_[3] = [Te("取消")])), _: 1, __: [3] }), s(f, { size: "default", type: "primary", onClick: b }, { default: p(() => _[4] || (_[4] = [Te("确定")])), _: 1, __: [4] })])]), _: 1 }, 8, ["visible"])) : H("", true)]);
  };
} }, V_ = ut(tk, [["__scopeId", "data-v-1d7e978c"]]);
function ik(e) {
  return W({ module: "plan", url: "drawing/struct", method: "get", params: e, cancelKey: false });
}
function ak(e) {
  return W({ module: "plan", url: "drawing/struct", method: "delete", data: e });
}
function lk({ id: e }) {
  return W({ module: "plan", url: `drawing/struct/${e}/export`, method: "get", responseType: "blob" });
}
function Dut(e) {
  return W({ module: "plan", url: "drawing/struct/export", method: "get", timeout: 6e6, responseType: "blob", params: e });
}
function xut(e) {
  return W({ module: "plan", url: "drawing/struct/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Uut(e) {
  return W({ module: "plan", url: "drawing/struct/compile", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Yut({ productId: e, productType: o, projectType: n }) {
  return W({ module: "plan", url: "drawing/pc/num", method: "get", params: { productId: e, productType: o, projectType: n } });
}
function MS({ productType: e, number: o, projectType: n, monomerId: c, serialNumber: u, productId: r }) {
  return W({ module: "plan", url: "drawing/product", method: "get", responseType: "blob", timeout: 6e6, params: { productType: e, number: o, projectType: n, monomerId: c, serialNumber: u, productId: r } });
}
const Kut = { get: ik, del: ak, download: lk };
function ok(e) {
  return W({ module: "plan", url: "enclosure/v2/listPage", method: "get", params: e });
}
function nk(e) {
  return W({ url: "/api/plan/enclosure-change", method: "post", data: e });
}
function sk(e) {
  return W({ url: "/api/plan/enclosure/V2/saveList", params: { areaId: e.areaId }, method: "post", data: e.list });
}
function Wut(e, o) {
  return W({ module: "plan", url: `enclosure/v2/updateStatus/${e}`, method: "put", params: o });
}
function rk(e) {
  return W({ module: "plan", url: "enclosure", method: "delete", data: [e] });
}
function jut(e) {
  return W({ module: "plan", url: `enclosure/clearByAreaId/${e}`, method: "delete" });
}
function Fut(e) {
  return W({ url: "/api/plan/enclosure", method: "delete", data: e });
}
function zut(e) {
  return W({ module: "plan", url: "enclosure/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function But(e) {
  return W({ url: "/api/plan/enclosure/v2/import", responseType: "blob", headers: { "Content-Type": "multipart/form-data" }, method: "post", data: e });
}
function Hut(e) {
  return W({ module: "plan", url: `enclosure/download/${e.category}`, responseType: "blob", method: "get" });
}
function qut() {
  return W({ url: "/api/plan/enclosure/inventory/download", method: "get", responseType: "blob" });
}
function Gut(e) {
  return W({ module: "plan", url: "enclosure/export", responseType: "blob", method: "get", params: e });
}
function Qut(e) {
  return W({ module: "plan", url: "enclosure/saveDrawing", method: "post", data: e });
}
function uk(e) {
  return W({ module: "plan", url: `enclosure/preview/${e}`, responseType: "blob", timeout: 6e6, method: "get" });
}
function Zut(e) {
  return W({ module: "plan", url: "enclosure/getSum", method: "get", params: e });
}
function Jut(e) {
  return W({ module: "plan", url: "enclosure/importAttachment/drawing", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Xut(e) {
  return W({ module: "plan", url: "enclosure/importAttachment/zip", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function $ut(e) {
  return W({ url: "/api/plan/monomer/monomer_area/list", method: "get", params: e });
}
function ect(e) {
  return W({ url: "/api/plan/enclosure/v2/export", method: "get", responseType: "blob", params: e });
}
function tct(e) {
  return console.log(e, "/api/plan/enclosure/v2/getSum"), W({ url: "/api/plan/enclosure/v2/getSum", method: "get", params: e });
}
const ict = { get: ok, edit: nk, del: rk, add: sk };
const ck = { class: "root-content" }, dk = { class: "imgBox" }, mk = ["src"], pk = { class: "operate-content" }, hk = { class: "operate-left" }, fk = { class: "quick-operation" }, gk = { key: 0, class: "load-box" }, Ek = { __name: "drawing-img", props: { modelValue: { type: Boolean, default: false }, fullscreen: { type: Boolean, default: true }, serialNumber: { type: String, default: void 0 }, attachmentId: { type: Number, default: void 0 }, showType: { type: String, default: void 0 }, id: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c, field: "modelValue", showHook: S }), E = Z(), y = Z(), b = Z(false), V = Z(false), M = Z(100), g = Z(0);
  async function S() {
    if (!u.value) return;
    const P = c.showType ? "附件" : "图纸";
    try {
      V.value = true;
      const L = c.showType ? await Lc({ id: c.id }) : await uk(c.attachmentId);
      y.value = await h(L);
    } catch (L) {
      console.log(`获取${P}`, L), r(), Di({ title: `获取${P}失败`, type: "error", duration: 2e3 });
    } finally {
      V.value = false;
    }
  }
  function h(P) {
    return console.log(P, "dsds"), new Promise((L, O) => {
      if (P && P.data && P.data.size) {
        const x = P.data, I = new window.FileReader();
        I.readAsArrayBuffer(x), I.onload = function(Y) {
          const ee = Y.target.result, B = x.type, q = new Blob([ee], { type: B }), ae = window.URL.createObjectURL(q);
          console.log(ae), L(ae);
        };
      } else O();
    });
  }
  function T() {
    M.value += 20, N();
  }
  function _() {
    M.value <= 20 || (M.value += -20, N());
  }
  function f() {
    g.value += 90;
    const P = E.value;
    P && (P.style.transform = `rotate(${g.value}deg)`);
  }
  function m() {
    g.value -= 90;
    const P = E.value;
    P && (P.style.transform = `rotate(${g.value}deg)`);
  }
  function R() {
    g.value = 0, M.value = 100, N(), v();
  }
  function v() {
    const P = E.value;
    P && (P.style.margin = "0 auto");
  }
  function N() {
    const P = E.value;
    P && (P.style.width = parseInt(M.value) + "%", P.style.height = parseInt(M.value) + "%");
  }
  return (P, L) => {
    const O = _o, x = hr, I = ml, Y = Tc;
    return w(), U(Y, { title: "图纸预览", modelValue: l(u), "onUpdate:modelValue": L[3] || (L[3] = (ee) => Gt(u) ? u.value = ee : null), width: "80%", fullscreen: e.fullscreen, class: Zt("drawing-pdf-dialog"), "before-close": l(r) }, { default: p(() => [C("div", ck, [C("div", { class: "img-content", onDblclick: L[0] || (L[0] = (ee) => b.value = true), onClick: L[1] || (L[1] = (ee) => b.value = false) }, [C("div", dk, [V.value ? H("", true) : (w(), Q("img", { key: 0, ref_key: "imgRef", ref: E, class: "img", src: y.value, style: { "user-select": "none" } }, null, 8, mk))])], 32), qe(C("div", pk, [C("div", hk, K(e.serialNumber), 1), L[4] || (L[4] = C("div", { class: "operate-middle" }, null, -1)), L[5] || (L[5] = C("div", { class: "operate-right" }, null, -1))], 512), [[ln, b.value && !e.showType]]), C("div", fk, [C("div", { class: "icon-box", onClick: T }, [s(O, { class: "icon", "icon-class": "comp-zoom" })]), C("div", { class: "icon-box", onClick: _ }, [s(O, { class: "icon", "icon-class": "comp-zoom-out" })]), C("div", { class: "icon-box", onClick: f }, [s(O, { class: "icon", "icon-class": "comp-clockwise-rotate" })]), C("div", { class: "icon-box", onClick: m }, [s(O, { class: "icon", "icon-class": "comp-counterclockwise-rotate" })]), C("div", { class: "icon-box", onClick: R }, [s(O, { class: "icon", "icon-class": "comp-restore-size" })]), C("div", { class: "icon-box", onClick: L[2] || (L[2] = (...ee) => l(r) && l(r)(...ee)) }, [s(O, { class: "icon", "icon-class": "comp-quit" })])])]), V.value ? (w(), Q("div", gk, [s(I, null, { default: p(() => [s(x)]), _: 1 })])) : H("", true)]), _: 1 }, 8, ["modelValue", "fullscreen", "before-close"]);
  };
} }, $2 = (e) => new Promise((o, n) => {
  const c = document.createElement("script");
  c.onload = o, c.onerror = n, c.src = e, console.log(e, "src"), document.body.append(c);
}), yk = (e) => new Promise((o, n) => {
  const c = document.createElement("link");
  c.onload = o, c.onerror = n, c.setAttribute("rel", "stylesheet"), c.setAttribute("type", "text/css"), c.href = e, document.body.append(c);
}), Tk = (e) => $2(`${e}/pdf/build/pdf.js`).then(() => Promise.all([$2(`${e}/pdf/web/pdf_viewer.js`), yk(`${e}/pdf/web/pdf_viewer.css`)]));
const _k = { class: "pdf-view" }, eb = "canvas-watermark", bk = { __name: "pdf", props: { url: { type: String, default: "" }, scale: { type: Number, default: 1 }, rotation: { type: Number, default: 0 }, type: { type: String, default: "canvas" }, pdfjsDistPath: { type: String, default: "." }, watermarkImage: { type: [String, Object], default: "" }, watermarkOptions: { type: Object, default: () => ({ x: 0, y: 0, widthPercent: 0.25, widthPx: null, offsetX: 0, offsetY: 0, opacity: 1 }) } }, emits: ["pdf-error"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(null);
  El(() => {
    f().then(() => {
      g(), m();
    });
  }), Ce(() => c.url, () => {
    r.value && r.value._cancelRendering(), m();
  }), Ce(() => c.scale, () => {
    console.log(r.value), r.value && (r.value.currentScaleValue = c.scale, E.value.setViewer(r.value));
  }), Ce(() => c.rotation, () => {
    r.value.pagesRotation = c.rotation, E.value.setViewer(r.value);
  }), Ce(() => [c.watermarkImage, c.watermarkOptions], () => {
    g();
  }, { deep: true });
  async function g() {
    const R = c.watermarkImage;
    if (!R) {
      V.value = "", h();
      return;
    }
    if (R instanceof ArrayBuffer || R instanceof Uint8Array || R instanceof Blob) {
      let v = R instanceof Uint8Array ? R.buffer : R;
      R instanceof ArrayBuffer && (v = R);
      const N = R instanceof Blob ? R : new Blob([v], { type: "image/png" });
      V.value = URL.createObjectURL(N), h();
      return;
    }
    if (typeof R == "string") {
      V.value = R, h();
      return;
    }
    V.value = "", h();
  }
  function S(R, v, N = 0, P = 0) {
    const L = { left: "0%", center: "50%", right: "100%", top: "0%", bottom: "100%" }, O = typeof R == "number" ? `calc(${R}px + ${N}px)` : `calc(${L[R] || "50%"} + ${N}px)`, x = typeof v == "number" ? `calc(${v}px + ${P}px)` : `calc(${L[v] || "50%"} + ${P}px)`;
    return `${O} ${x}`;
  }
  function h() {
    const R = u.value;
    if (!R) return;
    R.querySelectorAll(".canvasWrapper").forEach((N) => {
      getComputedStyle(N).position === "static" && (N.style.position = "relative");
      let P = N.querySelector(`.${eb}`);
      if (P || (P = document.createElement("div"), P.className = eb, N.appendChild(P)), !V.value) {
        P.style.display = "none";
        return;
      }
      P.style.display = "block", P.style.position = "absolute", P.style.left = "0", P.style.top = "0", P.style.width = "100%", P.style.height = "100%", P.style.pointerEvents = "none", P.style.zIndex = "10", P.style.backgroundImage = `url(${V.value})`, P.style.backgroundRepeat = "no-repeat";
      const L = c.watermarkOptions || {}, O = typeof L.widthPercent == "number" ? L.widthPercent : 0.25, x = typeof L.widthPx == "number" ? L.widthPx : null;
      x ? P.style.backgroundSize = `${Math.max(1, x)}px auto` : P.style.backgroundSize = `${Math.round(O * 100)}% auto`;
      const I = S(L.x, L.y, L.offsetX || 0, L.offsetY || 0);
      if (P.style.backgroundPosition = I, P.style.opacity = typeof L.opacity == "number" ? String(L.opacity) : "0.5", L.x && L.y) {
        const Y = N.offsetWidth, ee = N.offsetHeight, B = Y * L.x, q = ee * L.y;
        P.style.left = `${B + (L.offsetX || 0)}px`, P.style.top = `${q + (L.offsetY || 0)}px`;
      }
    });
  }
  function T() {
    const R = u.value;
    if (!R) return;
    M.value && M.value.disconnect();
    const v = new MutationObserver(() => {
      h();
    });
    v.observe(R, { childList: true, subtree: true }), M.value = v;
  }
  function _({ source: R }) {
    R.currentScaleValue = c.scale, h(), T();
  }
  async function f() {
    let R = window.pdfjsLib, v = window.pdfjsViewer;
    if (!R || !v) try {
      await Tk(c.pdfjsDistPath), b.value = `${c.pdfjsDistPath}/pdf/cmaps/`, R = window.pdfjsLib, R.GlobalWorkerOptions.workerSrc = `${c.pdfjsDistPath}/pdf/build/pdf.worker.js`, v = window.pdfjsViewer;
    } catch (x) {
      console.log(x, "pdfjs文件获取失败");
      return;
    }
    const N = u.value, P = new v.EventBus(), L = new v.PDFLinkService({ eventBus: P });
    E.value = L;
    const O = new v.PDFViewer({ container: N, eventBus: P, linkService: E.value, renderer: c.type, textLayerMode: 0, downloadManager: new v.DownloadManager({}), enableWebGL: true });
    r.value = O, E.value.setViewer(r.value), P.on("pagesinit", _);
  }
  function m() {
    if (c.url && !(Ae(r.value) || Ae(E.value))) return A(y.value) && (y.value.destroy(), y.value = null), y.value = window.pdfjsLib.getDocument({ cMapUrl: b.value, cMapPacked: true, url: c.url }), y.value.promise.then((R) => {
      R.loadingTask.destroyed || !c.url || (r.value.setDocument(R), E.value.setDocument(R, null), y.value = null);
    }).catch((R) => {
      n("pdf-error", R);
    });
  }
  return bl(() => {
    M.value && (M.value.disconnect(), M.value = null);
  }), (R, v) => (w(), Q("div", _k, [C("div", { id: "viewerContainer", ref_key: "containerRef", ref: u }, v[0] || (v[0] = [C("div", { id: "viewer", class: "pdfViewer" }, null, -1)]), 512)]));
} }, Vk = ut(bk, [["__scopeId", "data-v-ca26ad32"]]);
const wk = { class: "root-content" }, Sk = { class: "operate-content" }, vk = { class: "operate-left" }, Rk = { class: "operate-middle" }, Mk = { class: "quick-operation" }, Ak = { key: 0, class: "load-box" }, Nk = { __name: "drawing-pdf", props: { modelValue: { type: Boolean, default: false }, fullscreen: { type: Boolean, default: true }, serialNumber: { type: String, default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, showType: { type: String, default: void 0 }, id: { type: Number, default: void 0 } }, emits: ["update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c, field: "modelValue" }), E = "/assets", y = Z(), b = Z(1), V = Z(0), M = Z(false), g = Z(), S = Z(), h = Z(false), T = Z(false);
  Ce(() => c.modelValue, (x) => {
    x && (u.value = true, _());
  }, { immediate: true });
  async function _() {
    m();
    const x = c.showType ? "附件" : "图纸";
    try {
      T.value = true;
      const I = { productId: c.productId, productType: c.productType, serialNumber: c.serialNumber, monomerId: c.monomerId }, Y = c.showType ? await Lc({ id: c.id }) : await MS(I);
      y.value = await f(Y);
    } catch (I) {
      console.log(`获取${x}`, I), r(), Di({ title: `获取${x}失败`, type: "error", duration: 2e3 });
    } finally {
      T.value = false;
    }
  }
  function f(x) {
    return new Promise((I, Y) => {
      if (x && x.data && x.data.size) {
        const ee = x.data, B = new window.FileReader();
        B.readAsArrayBuffer(ee), B.onload = function(q) {
          console.log(q, ee);
          const ae = q.target.result, j = ee.type, le = new Blob([ae], { type: j }), oe = window.URL.createObjectURL(le);
          console.log(oe), I(oe);
        };
      } else Y();
    });
  }
  function m() {
    g.value = 1, S.value = 1;
    const x = document.getElementById("pdfBox");
    x && (x.scrollTop = 0), O();
  }
  function R(x) {
    const I = c.showType ? "附件" : "图纸";
    Di({ title: `加载${I}失败，请确认是否已上传该${I}`, type: "error", duration: 3e3 }), console.error(x);
  }
  function v() {
    b.value += 0.2;
  }
  function N() {
    b.value -= 0.2;
  }
  function P() {
    V.value += 90;
  }
  function L() {
    V.value -= 90;
  }
  function O() {
    V.value = 0, b.value = 1;
  }
  return (x, I) => {
    const Y = _o, ee = hr, B = ml, q = Tc;
    return w(), U(q, { title: "图纸预览", modelValue: l(u), "onUpdate:modelValue": I[4] || (I[4] = (ae) => Gt(u) ? u.value = ae : null), width: "80%", fullscreen: e.fullscreen, class: Zt("drawing-pdf-dialog"), "before-close": l(r) }, { default: p(() => [qe(C("div", wk, [C("div", { class: "pdf-content", onDblclick: I[1] || (I[1] = (ae) => M.value = true), onClick: I[2] || (I[2] = (ae) => M.value = false) }, [C("div", { id: "pdfBox", ref: "pdfBox", class: "pdf-box", onMousedown: I[0] || (I[0] = (...ae) => x.move && x.move(...ae)) }, [s(l(Vk), { url: y.value, scale: b.value, rotation: V.value, onPdfError: R, type: "canvas", pdfjsDistPath: E }, null, 8, ["url", "scale", "rotation"])], 544)], 32), qe(C("div", Sk, [C("div", vk, K(e.serialNumber), 1), C("div", Rk, K(`${g.value} / ${S.value}`), 1), I[5] || (I[5] = C("div", { class: "operate-right" }, null, -1))], 512), [[ln, M.value && !e.showType]]), C("div", Mk, [C("div", { class: "icon-box", onClick: v }, [s(Y, { class: "icon", "icon-class": "comp-zoom" })]), C("div", { class: "icon-box", onClick: N }, [s(Y, { class: "icon", "icon-class": "comp-zoom-out" })]), C("div", { class: "icon-box", onClick: P }, [s(Y, { class: "icon", "icon-class": "comp-clockwise-rotate" })]), C("div", { class: "icon-box", onClick: L }, [s(Y, { class: "icon", "icon-class": "comp-counterclockwise-rotate" })]), C("div", { class: "icon-box", onClick: O }, [s(Y, { class: "icon", "icon-class": "comp-restore-size" })]), C("div", { class: "icon-box", onClick: I[3] || (I[3] = (...ae) => l(r) && l(r)(...ae)) }, [s(Y, { class: "icon", "icon-class": "comp-quit" })])])], 512), [[ln, !h.value]]), T.value || h.value ? (w(), Q("div", Ak, [s(B, null, { default: p(() => [s(ee)]), _: 1 })])) : H("", true)]), _: 1 }, 8, ["modelValue", "fullscreen", "before-close"]);
  };
} }, AS = { __name: "show-pdf-and-img", props: { isVisible: { type: Boolean, required: false }, fullscreen: { type: Boolean, default: true }, serialNumber: { type: String, default: void 0 }, monomerId: { type: [Number, String], default: void 0 }, productId: { type: Number, default: void 0 }, productType: { type: Number, default: void 0 }, showType: { type: String, default: void 0 }, id: { type: Number, default: void 0 } }, emits: ["close"], setup(e, { emit: o }) {
  const n = e, c = Z(), u = Z(), r = Z(), E = o, y = Ee(() => c.value === "pdf"), b = Z(false), V = Z(false);
  Ce(() => n.isVisible, (g) => {
    g && M();
  }, { immediate: true });
  async function M() {
    try {
      const g = { productId: n.productId, productType: n.productType, serialNumber: n.serialNumber, monomerId: n.monomerId }, S = n.showType ? await Lc({ id: n.id }) : await MS(g), h = n.showType ? "附件" : "图纸";
      if (S.headers["content-disposition"]) {
        const T = S.headers["content-disposition"].split("=")[1].split(".");
        c.value = T[T.length - 1], b.value = c.value !== "pdf", V.value = c.value === "pdf";
      } else Di({ title: `获取${h}失败，请确认是否已上传${h}`, type: "error", duration: 3e3 });
    } catch (g) {
      console.log("获取图纸", g);
    }
  }
  return (g, S) => (w(), Q("div", null, [y.value ? H("", true) : (w(), U(l(Ek), { key: 0, ref_key: "imgRef", ref: r, modelValue: b.value, "onUpdate:modelValue": S[0] || (S[0] = (h) => b.value = h), fullscreen: e.fullscreen, "serial-number": e.serialNumber, showType: e.showType, id: e.id, onClose: S[1] || (S[1] = (h) => E("close")) }, null, 8, ["modelValue", "fullscreen", "serial-number", "showType", "id"])), y.value ? (w(), U(l(Nk), { key: 1, ref_key: "pdfRef", ref: u, modelValue: V.value, "onUpdate:modelValue": S[2] || (S[2] = (h) => V.value = h), fullscreen: e.fullscreen, "serial-number": e.serialNumber, showType: e.showType, id: e.id, onClose: S[3] || (S[3] = (h) => E("close")) }, null, 8, ["modelValue", "fullscreen", "serial-number", "showType", "id"])) : H("", true)]));
} }, NS = "/static/png/watermark-40e7bec5.png";
function LS(e) {
  const o = e && e.headers, n = o && (o["content-disposition"] || o["Content-Disposition"]);
  if (!n) return "";
  const c = decodeURIComponent(n).match(/filename\*=UTF-8''(.+)|filename="(.+)"|filename=(.+)/i);
  return c && (c[1] || c[2] || c[3]) || "";
}
async function Lk(e) {
  if (!e) return null;
  if (e instanceof ArrayBuffer) return e;
  if (e instanceof Uint8Array) return e.buffer;
  if (e instanceof Blob) return await e.arrayBuffer();
  try {
    return await new Blob([e]).arrayBuffer();
  } catch {
    return null;
  }
}
async function IS(e, o = {}) {
  const { watermarkImage: n = NS, tileScale: c = 0.09, widthPt: u = null, heightPt: r = null, position: E = { x: 0.88, y: 0.33, offsetX: 0, offsetY: 0 }, opacity: y = 1 } = o || {}, b = e instanceof Uint8Array ? e : new Uint8Array(e), V = await N6.load(b);
  async function M(v) {
    return v ? v instanceof ArrayBuffer ? v : v instanceof Uint8Array ? v.buffer : v instanceof Blob ? await v.arrayBuffer() : typeof v == "string" ? await (await fetch(v)).arrayBuffer() : null : null;
  }
  const g = await M(n);
  if (!g) return b;
  let S = null;
  try {
    S = await V.embedPng(g);
  } catch {
    try {
      S = await V.embedJpg(g);
    } catch {
      throw new Error("watermarkImage 不是有效的 PNG/JPG 或嵌入失败");
    }
  }
  const h = S.width, T = S.height, _ = h / (T || 1);
  function f(v, N, P, L = 0, O = false) {
    if (typeof P == "number") return P >= 0 && P <= 1 ? v * P + (L || 0) : P + (L || 0);
    switch ((P || "").toString()) {
      case "left":
      case "top":
        return 0 + (L || 0);
      case "right":
      case "bottom":
        return v - N + (L || 0);
      case "center":
      default:
        return (v - N) / 2 + (L || 0);
    }
  }
  const m = V.getPages();
  for (const v of m) {
    const { width: N, height: P } = v.getSize();
    let L, O;
    if (u != null) L = u, O = r ?? L / _;
    else if (r != null) O = r, L = u ?? O * _;
    else {
      const B = N / (P || 1);
      _ >= B ? (L = N * Math.max(0.01, Math.min(0.9, c)), O = L / _) : (O = P * Math.max(0.01, Math.min(0.9, c)), L = O * _);
    }
    const x = f(N, L, E.x, E.offsetX || 0, false), I = f(P, O, E.y, E.offsetY || 0, true), Y = x, ee = P - I - O;
    v.drawImage(S, { x: Y, y: ee, width: L, height: O, opacity: y });
  }
  return await V.save();
}
async function Ik(e, o = {}, n = () => {
}) {
  const u = await new L6().loadAsync(e), E = Object.keys(u.files).map((v) => ({ name: v, fileObj: u.files[v] })).filter(({ name: v, fileObj: N }) => !N.dir && v.toLowerCase().endsWith(".pdf")), y = E.length;
  if (y === 0) return n({ phase: "done", processed: 0, total: 0, percent: 100 }), await u.generateAsync({ type: "blob" });
  async function b(v) {
    return v ? v instanceof ArrayBuffer ? v : v instanceof Uint8Array ? v.buffer : v instanceof Blob ? await v.arrayBuffer() : typeof v == "string" ? await (await fetch(v)).arrayBuffer() : null : null;
  }
  const V = o.watermarkImage || NS;
  let M = null;
  try {
    M = await b(V);
  } catch (v) {
    console.warn("预取 watermarkImage 失败：", v);
  }
  M && (o = Object.assign({}, o, { watermarkImage: M }));
  const g = navigator.hardwareConcurrency || 4, S = Math.max(1, Math.min(6, Math.floor(g / 1.5)));
  let h = 0, T = 0;
  async function _(v) {
    try {
      const N = await v.fileObj.async("arraybuffer"), P = await IS(N, o);
      u.file(v.name, P);
    } catch (N) {
      console.error(`给 ${v.name} 添加水印失败，保留原文件`, N);
    } finally {
      T++;
      const N = Math.round(T / y * 80);
      n({ phase: "processing", processed: T, total: y, percent: N });
    }
  }
  const f = new Array(S).fill(0).map(async () => {
    for (; ; ) {
      const v = h++;
      if (v >= E.length) break;
      await _(E[v]);
    }
  });
  await Promise.all(f);
  const m = o.fastZip ? "STORE" : "DEFLATE", R = await u.generateAsync({ type: "blob", compression: m }, (v) => {
    const N = Math.round(80 + (v.percent || 0) * 0.2);
    n({ phase: "zipping", percent: N, processed: T, total: y });
  });
  return n({ phase: "done", processed: T, total: y, percent: 100 }), R;
}
async function Ck(e) {
  const o = this, n = Array.prototype.slice.call(arguments);
  n.shift();
  try {
    const c = await e.apply(o, n);
    if (console.log(c), CS(c)) Di({ title: "导出成功", type: "success", duration: 2 * 1e3 });
    else throw Di({ title: "导出失败", type: "error", duration: 2 * 1e3 }), Error("导出失败");
  } catch (c) {
    throw Error(c);
  }
}
async function Pk(e) {
  const o = this, n = Array.prototype.slice.call(arguments);
  n.shift();
  try {
    const c = await e.apply(o, n);
    Ok(c);
  } catch (c) {
    throw Error(c);
  }
}
async function CS(e, o, { watermark: n = true, watermarkOptions: c = {}, zipProgressCb: u } = {}) {
  const r = e && e.data, E = e && e.headers;
  if (!r || !E) return false;
  const y = (E["content-type"] || "").toLowerCase(), b = o || LS(e) || "", V = y && y.includes("zip") || b.toLowerCase().endsWith(".zip"), M = await Lk(r);
  if (!M) return false;
  let g = null;
  try {
    if (V && n) {
      g = Dn.service({ lock: true, text: "处理中 0%", background: "rgba(255, 255, 255, 0.5)", fullscreen: true });
      const h = await Ik(M, c, (m) => {
        typeof u == "function" && u(m);
        try {
          const R = m.percent != null ? `${m.percent}%` : `${Math.round(m.processed / Math.max(1, m.total) * 100)}%`, v = document.querySelector(".el-loading-text");
          v && (v.innerText = `处理中 ${R}`);
        } catch (R) {
          console.log(R);
        }
      }), T = window.URL.createObjectURL(h), _ = document.createElement("a");
      _.href = T;
      const f = b || `watermarked_${Qi(/* @__PURE__ */ new Date(), "{y}{m}{d}{h}{i}{s}")}.zip`;
      return _.download = f, document.body.appendChild(_), _.click(), document.body.removeChild(_), window.URL.revokeObjectURL(T), Di({ title: "导出成功", type: "success", duration: 2e3 }), true;
    } else {
      const S = await IS(M, c), h = new Blob([S], { type: "application/pdf" }), T = window.URL.createObjectURL(h), _ = document.createElement("a");
      _.href = T;
      const f = b || `download_${Qi(/* @__PURE__ */ new Date(), "{y}{m}{d}{h}{i}{s}")}.pdf`;
      return _.download = f, document.body.appendChild(_), _.click(), document.body.removeChild(_), window.URL.revokeObjectURL(T), Di({ title: "下载成功", type: "success", duration: 2e3 }), true;
    }
  } catch (S) {
    return console.error("下载/加水印失败", S), Di({ title: "导出失败", type: "error", duration: 2e3 }), false;
  } finally {
    if (g) try {
      g.close();
    } catch (S) {
      console.log(S);
    }
  }
}
function Ok(e, { fileName: o, successMsg: n, errorMsg: c } = {}) {
  const u = e.headers.result && decodeURIComponent(e.headers.result).split(";");
  if (console.log("res", e), u) {
    const r = u[0].split("=")[1], E = u[1].split("=")[1], y = LS(e) || "";
    r === "20000" ? (Di.success({ title: `${o || y}下载请求成功, 正在下载`, message: n }), CS(e, y)) : Di.error({ title: `${o || y}下载请求失败`, message: c || `${E}` });
  } else Di.error("下载请求失败");
}
const ia = { __name: "index", props: { params: { type: null, default: void 0 }, disabled: { type: Boolean, default: false }, fn: { type: Function, default: Lc }, size: { type: String, default: "default" }, type: { type: String, default: "warning" }, icon: { type: String, default: "el-icon-download" }, boolElLoading: { type: Boolean, default: false }, loadingText: { type: String, default: "正在下载，请稍后" }, responseHeaderResult: { type: Boolean, default: false }, boolDrawing: { type: Boolean, default: false } }, emits: ["download-success"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false);
  let r;
  async function E(y) {
    try {
      u.value = true, c.boolElLoading && (r = Dn.service({ lock: true, text: c.loadingText, fullscreen: true, background: "rgba(255, 255, 255, 0.5)" })), await (c.responseHeaderResult ? c.boolDrawing ? Pk : P9 : c.boolDrawing ? Ck : rS)(c.fn, c.params), n("download-success");
    } catch (b) {
      console.log("通用导出", b);
    } finally {
      u.value = false, c.boolElLoading && r && r.close();
    }
  }
  return (y, b) => {
    const V = Ve("common-button");
    return w(), U(V, { loading: u.value, disabled: c.disabled, type: c.type, icon: c.icon, size: c.size, onClick: Pi(E, ["stop"]) }, { default: p(() => [xt(y.$slots, "default")]), _: 3 }, 8, ["loading", "disabled", "type", "icon", "size"]);
  };
} };
const kk = { class: "upload-container" }, Dk = { class: "attachment-content" }, xk = { key: 0 }, Uk = { __name: "UploadList", props: { data: { type: Object, default: void 0 }, files: { type: Array, default: () => [] }, fileClassify: { type: Number, default: cl.NORMAL.V }, downloadFn: { type: Function, default: void 0 }, downloadPerm: { type: Array, default: void 0 }, accept: { type: String, default: "" }, downloadParams: { type: Object, default: () => ({}) }, showDownload: { type: Boolean, default: false }, showView: { type: Boolean, default: false }, uploadable: { type: Boolean, default: true }, limit: { type: Number, default: void 0 }, emptyText: { type: String, default: "暂未上传文件" }, hasBeforeConfirm: { type: Boolean, default: false }, beforeMessage: { type: String, default: "确认上传吗？" }, successMessage: { type: String, default: "上传成功" }, showFileList: { type: Boolean, default: false }, size: { type: String, default: "default" }, icon: { type: String, default: "el-icon-upload-filled" }, btnName: { type: String, default: "" }, btnType: { type: String, default: "primary" }, disabled: { type: Boolean, default: false }, maxHeight: { type: [String, Number] }, delDisabled: { type: Boolean, default: false }, isSingle: { type: Boolean, default: false }, isRestricttCharacter: { type: Boolean, default: false } }, emits: ["update:files", "change"], setup(e, { emit: o }) {
  const n = o, c = e, { fileUploadApi: u } = ka("fileUploadApi"), r = Z(), E = Z({ Authorization: or() }), y = Z(false), b = Z([]), V = Z(), M = Z(false), g = Z();
  Dt(() => {
    V.value = c.files || [];
  });
  function S(O) {
    (O.name.indexOf(".pdf") > -1 || O.name.indexOf(".png") > -1 || O.name.indexOf(".jpg") > -1 || O.name.indexOf(".jpeg") > -1) && (g.value = O.id, M.value = true);
  }
  function h(O, x) {
    const I = x >= 0 && x <= V.value.length - 1 ? V.value[x].id : void 0;
    return { ...c.downloadParams, id: I };
  }
  function T(O) {
    const x = [...V.value];
    x.splice(O, 1), n("update:files", x);
  }
  function _(O) {
    if (f(), y.value = false, O && O.code === 2e4) {
      const x = [O.data];
      c.isSingle ? (V.value = [], V.value.push(O.data), n("update:files", V.value)) : (n("update:files", V.value.concat(O.data)), b.value = b.value.concat(x.map((I) => I.id))), ot.success("上传成功");
    } else ot.error(O && O.message ? O.message : "上传失败");
  }
  function f() {
    var O;
    (O = r.value) == null || O.clearFiles(), r.value && r.value.uploadRef && (r.value.uploadRef.fileList.length = 0);
  }
  function m() {
    f(), y.value = false, ot.error("上传失败");
  }
  function R() {
    y.value = true;
  }
  function v(O, x) {
    for (const I in V.value) if (O.uid === V.value[I].uid) {
      const Y = [...V.value];
      Y.splice(I, 1), n("update:files", Y), n("change");
      break;
    }
  }
  function N(O, x) {
    ot.warning(`当前限制选择 ${c.limit} 个文件`);
  }
  function P(O) {
    if (c.isRestricttCharacter) {
      const x = O.name;
      if (/[\u4e00-\u9fa5]/.test(x)) return ot.warning("当前上传限制文件名包含中文汉字！"), false;
    }
    return c.hasBeforeConfirm ? zi.confirm(c.beforeMessage) : true;
  }
  function L(O, x) {
    if (O && O.status === "success") return zi.confirm(`确定移除 ${O.name}？`);
  }
  return (O, x) => {
    const I = vt, Y = Ve("common-button"), ee = Ve("common-table"), B = _t("parse-time"), q = _t("permission");
    return w(), Q("div", kk, [C("div", Dk, [s(ee, { data: V.value, "empty-text": e.emptyText, "max-height": c.maxHeight, style: { width: "100%" } }, { default: p(() => [s(I, { align: "center", label: "序号", type: "index", width: "60" }), s(I, { "show-overflow-tooltip": true, label: "名称", "min-width": "150", prop: "name" }), xt(O.$slots, "applicant", {}, void 0, true), s(I, { "show-overflow-tooltip": true, align: "center", label: "上传时间", prop: "createTime", width: "100" }, { default: p(({ row: ae }) => [qe(C("span", null, null, 512), [[B, { val: ae.createTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), s(I, { width: e.uploadable && c.showDownload && c.showView ? 190 : e.uploadable && c.showDownload || c.showDownload && c.showView ? 117 : 97, align: "left", label: "操作" }, { default: p(({ row: ae, $index: j }) => [e.uploadable ? (w(), U(Y, { key: 0, disabled: c.delDisabled || ae.rowDelDisabled, icon: "el-icon-delete", size: "default", type: "danger", onClick: (le) => T(j) }, null, 8, ["disabled", "onClick"])) : H("", true), qe(s(ia, { fn: c.downloadFn, params: h(ae, j) }, null, 8, ["fn", "params"]), [[ln, c.showDownload], [q, c.downloadPerm]]), c.showView && [".pdf", ".png", ".jpg", ".jpeg"].some((le) => {
      var oe;
      return (oe = ae.name) == null ? void 0 : oe.toLowerCase().endsWith(le);
    }) ? (w(), U(Y, { key: 1, icon: "el-icon-view", size: "default", onClick: (le) => S(ae) }, null, 8, ["onClick"])) : H("", true)]), _: 1 }, 8, ["width"])]), _: 3 }, 8, ["data", "empty-text", "max-height"]), M.value ? (w(), U(AS, { key: 0, id: g.value, isVisible: M.value, showType: "attachment", onClose: x[0] || (x[0] = (ae) => M.value = false) }, null, 8, ["id", "isVisible"])) : H("", true), e.uploadable ? (w(), U(l(DV), { key: 1, ref_key: "uploadRef", ref: r, accept: c.accept, action: l(u), "before-remove": L, "before-upload": P, data: { ...c.data, fileType: c.fileClassify }, disabled: c.disabled, headers: E.value, limit: c.limit, "on-error": m, "on-exceed": N, "on-progress": R, "on-remove": v, "on-success": _, "show-file-list": c.showFileList, class: "upload-box", multiple: "" }, { default: p(() => [s(Y, { disabled: c.disabled, icon: c.icon, loading: y.value, size: c.size, type: c.btnType }, { default: p(() => [c.btnName ? (w(), Q("span", xk, K(c.btnName), 1)) : H("", true)]), _: 1 }, 8, ["disabled", "icon", "loading", "size", "type"])]), _: 1 }, 8, ["accept", "action", "data", "disabled", "headers", "limit", "show-file-list"])) : H("", true)])]);
  };
} }, dl = ut(Uk, [["__scopeId", "data-v-950aa6e7"]]);
function Hi(e, { props: o = [], precision: n, toThousandFields: c = [] } = {}) {
  const { columns: u, data: r } = e, E = [];
  return u.forEach((y, b) => {
    if (b === 0) {
      E[b] = "合计";
      return;
    }
    const V = o.findIndex((M) => Array.isArray(M) ? M[0] === y.property : M === y.property);
    if (V > -1) {
      const M = r.map((T) => {
        let _ = T;
        return T && T.sourceRow && (_ = T.sourceRow), Number(mn(_, y.property));
      });
      let g = n;
      const S = [], h = o[V];
      Array.isArray(h) && h.length === 2 && (g = h[1]), M.every((T) => isNaN(T)) || (E[b] = M.reduce((T, _) => isNaN(_) ? T : (S.push(Ho(_)), T + _), 0), Ae(g) && (g = S.getMax(), g = g > 2 ? 2 : g), c.includes(y.property) ? E[b] = Mi(E[b], g) : E[b] = ji(E[b], g));
    }
  }), E;
}
function mn(e, o) {
  if (!Ae(e)) return o ? o.split(".").reduce((c, u) => typeof c == "object" && c ? c[u] : void 0, e) : e;
}
