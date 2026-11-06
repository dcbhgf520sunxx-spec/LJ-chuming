function PX(e) {
  return W({ url: "/api/v2/wms/inbound/application/selfBuying/gas", method: "post", data: e });
}
function gd(e) {
  return e.boolPartyA = false, W({ url: "/api/v2/wms/report/raw-materials/inbound/template/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function is(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/beginPeriodInbound/template/excel", method: "get", responseType: "blob", params: e });
}
function Nft(e) {
  return W({ url: "/api/wms/report/raw-materials/inventoryBegin/excel", method: "get", responseType: "blob", params: e });
}
function Ed(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/inbound/purchaseDetail", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
function OX(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "get", params: e });
}
function Vu(e) {
  return W({ url: "/api/v2/wms/inbound/application/record/raw-materials", method: "put", data: e });
}
function kX(e) {
  return W({ module: "wms", url: "inbound/application/record/raw-materials", method: "delete", data: e });
}
function DX(e) {
  return W({ url: `/api/v2/wms/inbound/application/record/raw-materials/${e}`, method: "get" });
}
const Lft = { get: OX, edit: Vu, del: kX, detail: DX }, wu = { __name: "begin-confirm", props: { visible: { type: Boolean, default: false }, basicClass: { type: Number }, viewList: { type: Array }, className: { type: String }, submit: { type: Function }, title: { type: String } }, emits: ["update:visible", "closed", "success"], setup(e, { expose: o, emit: n }) {
  const c = e, u = Z(false), r = n, { visible: E, handleClose: y } = Ta({ props: c, emit: r, field: "visible" });
  function b() {
    r("closed");
  }
  async function V() {
    try {
      u.value = true, await c.submit(), u.value = false, r("success");
    } catch (M) {
      console.log(M, "=========>");
    } finally {
      u.value = false;
    }
  }
  return o({ handleClose: y }), (M, g) => {
    const S = Ve("common-button"), h = Ve("common-drawer");
    return w(), U(h, { modelValue: l(E), "onUpdate:modelValue": g[0] || (g[0] = (T) => Gt(E) ? E.value = T : null), "before-close": l(y), title: e.title ? `${e.title}入库单据预览` : `${e.className}入库单据预览`, size: "100%", onClosed: b }, { titleRight: p(() => [s(S, { loading: u.value, size: "default", type: "primary", onClick: V }, { default: p(() => g[1] || (g[1] = [Te("提交")])), _: 1, __: [1] }, 8, ["loading"])]), content: p(() => [xt(M.$slots, "default")]), _: 3 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, xX = Object.freeze(Object.defineProperty({ __proto__: null, default: wu }, Symbol.toStringTag, { value: "Module" }));
function c3() {
  const { loaded: e, inboundSteelCfg: o } = aa(), n = Z(0), c = Ee(() => e ? o.value.trainsDiffType === bo.PERCENTAGE.V ? `车次/船次重量与入库钢材重量的误差不可超过入库钢材重量的${o.value.trainsDiff || 0}%（${n.value}kg）` : `车次/船次重量与入库钢材重量的误差不可超过${o.value.trainsDiff || 0} ${nr}` : "请等待wms车次/船次重量配置信息加载后再试");
  function u(E, y) {
    return !!(y || !E);
  }
  function r(E, y, { inboundSteelCfg: b }) {
    if (!e) return "请等待wms车次/船次重量配置信息加载后再试";
    if (Ae(y) && Ae(E)) return {};
    let V = false;
    const M = b.value.trainsDiff, g = b.value.trainsDiffType, S = +ji(E - y, 0);
    return n.value = +ji(y * (M / 100), 0), g === bo.PERCENTAGE.V && (V = +ji(Math.abs(y - E), 0) > n.value), g === bo.NUMBER.V && (V = St(Math.abs(y - E), "kg", nr, 0) > M), { hasOver: V, overNum: S };
  }
  return { overDiffTip: c, weightOverDiff: (E, y) => r(E, y, { inboundSteelCfg: o }), diffSubmitValidate: (E) => u(E, o.value.overDiffSubmittable) };
}
const UX = { __name: "branch-company-select", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, labelName: { type: String, default: "全部分公司" }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择公司主体" }, level: { type: Number, default: void 0 } }, emits: ["update:modelValue", "change", "currentChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(false), E = Z(), y = Z([]);
  Ce(() => u.modelValue, (M) => {
    console.log(M), E.value = M;
  }, { immediate: true });
  function b(M) {
    if (c("update:modelValue", M), c("change", M), M) {
      const g = y.value.find((S) => S.id === M) || {};
      c("currentChange", g);
    } else c("currentChange", {});
  }
  V();
  async function V() {
    let M = [];
    y.value = [];
    try {
      r.value = true;
      const { content: g } = await pC();
      g && g.length > 0 && (M = g, A(u.level) && (M = M.filter((S) => S.level === u.level)));
    } catch (g) {
      console.log("获取分公司列表", g);
    } finally {
      y.value = M, r.value = false;
    }
  }
  return o({ options: y }), (M, g) => {
    const S = Ve("common-select");
    return w(), U(S, { modelValue: E.value, "onUpdate:modelValue": g[0] || (g[0] = (h) => E.value = h), clearable: e.clearable, dataStructure: { key: "id", label: "name", value: "id" }, default: u.default, disabled: u.disabled, loading: r.value, options: y.value, placeholder: e.placeholder, size: e.size, type: "other", filterable: "", style: { width: "200px" }, onChange: b }, null, 8, ["modelValue", "clearable", "default", "disabled", "loading", "options", "placeholder", "size"]);
  };
} }, d3 = (e, o = true) => {
  const n = Ht(), c = Ee(() => n.state.config.loaded.purchaseWorkshop);
  if (o && n.dispatch("config/fetchPurchaseWorkshop"), e) {
    const u = Ce(c, (r) => {
      r && setTimeout(() => {
        e(), u();
      }, 0);
    }, { immediate: true });
  }
  return { purchaseWorkshop: Ee(() => n.state.config.purchaseWorkshop), loaded: Ee(() => n.state.config.loaded.purchaseWorkshop) };
}, YX = { __name: "purchase-workshop-select", props: { modelValue: { type: [Array, Number, String, void 0], default: void 0 }, factoryId: { type: [Number, String, void 0], default: void 0 }, workshopType: { type: [Number, String], default: void 0 }, size: { type: String, default: "small" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择车间" }, defaultValue: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, choseIndex: { type: [Number, String], default: void 0 }, disabledVal: { type: Array, default: () => [] }, reload: { type: Boolean, default: true } }, emits: ["change", "update:modelValue", "nameChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(), E = Z([]), { loaded: y, purchaseWorkshop: b } = d3(S, u.reload);
  Ce(() => u.modelValue, (h) => {
    r.value = h, u.default && Ae(h) && A(E.value) && (r.value = E.value[0].id, V(r.value));
  }, { immediate: true }), Ce([b, () => u.factoryId, () => u.workshopType], () => {
    M();
  }, { immediate: true, deep: true });
  function V(h) {
    if (u.modelValue !== h) {
      c("update:modelValue", h), c("change", h);
      const T = E.value.find((_) => _.id === h) || {};
      A(T) && A(u.choseIndex) && (T.choseIndex = u.choseIndex), c("nameChange", T);
    }
  }
  function M() {
    E.value = [];
    let h = [];
    try {
      A(b.value) && (h = At(b.value).map((_) => ({ id: _.id, name: _.name })));
    } catch (T) {
      console.log("获取车间列表", T);
    } finally {
      E.value = h, A(E.value) && u.default && !r.value && (r.value = E.value[0].id), V(r.value);
    }
  }
  function g(h) {
    return b.value.find((T) => T.id === h);
  }
  function S() {
  }
  return o({ getOption: g }), (h, T) => {
    const _ = Ve("common-select");
    return w(), U(_, ii(h.$attrs, { modelValue: r.value, "onUpdate:modelValue": T[0] || (T[0] = (f) => r.value = f), size: e.size, disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !l(y), clearable: e.clearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, allLabelText: "全部车间", disabledVal: e.disabledVal, filterable: "", placeholder: e.placeholder, options: E.value, onChange: V }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"]);
  };
} };
const KX = { class: "head-container" }, WX = { key: 0 }, jX = { style: { width: "100%", "overflow-x": "auto" } }, FX = { class: "customize-option-item" }, zX = { class: "flex-rsc label" }, BX = { class: "extra-label" }, HX = { __name: "header", props: { materialType: { type: Number }, workshopReload: { type: Boolean, default: true }, visible: { type: Boolean } }, setup(e) {
  const o = e, n = Z([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), c = { supplierId: void 0, serialNumber: void 0, projectId: void 0, branchCompanyId: void 0, createTime: [], dataStatus: rl.PASSED.V, orderPlace: Bt.FACTORY.V, workshopId: void 0, isOpened: { value: void 0, resetAble: false }, level: { value: Bt.FACTORY.V, resetAble: false } }, { crud: u, query: r } = f_(c), E = Z([]);
  async function y() {
    let V = [];
    try {
      if (!r.workshopId) return;
      V = await k5(r.workshopId) || [], E.value = V;
    } catch (M) {
      console.log("获取生产车间对应供应商", M);
    } finally {
      E.value = V;
    }
  }
  function b() {
    y(), u.toQuery();
  }
  return Ce(() => o.visible, (V) => {
    V ? u.query.isOpened = true : u.query.isOpened = void 0;
  }, { deep: true, immediate: true }), (V, M) => {
    const g = Ve("common-select-v2"), S = Rl, h = Mt, T = _t("parse-enum");
    return w(), Q("div", KX, [l(u).searchToggle ? (w(), Q("div", WX, [s(YX, { modelValue: l(r).workshopId, "onUpdate:modelValue": M[0] || (M[0] = (_) => l(r).workshopId = _), reload: e.workshopReload, class: "filter-item", clearable: "", placeholder: "关联车间", onChange: b }, null, 8, ["modelValue", "reload"]), s(g, { modelValue: l(r).supplierId, "onUpdate:modelValue": M[1] || (M[1] = (_) => l(r).supplierId = _), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !l(r).workshopId, options: E.value, class: "filter-item", clearable: "", placeholder: "请选择供应商", size: "default", style: { width: "280px" }, type: "other", onChange: l(u).toQuery }, { view: p(({ data: _ }) => [C("div", jX, [C("span", FX, [C("span", zX, [C("span", null, K(_.name), 1)]), C("span", null, [C("span", BX, [M[6] || (M[6] = C("span", { class: "title" }, "类型：", -1)), qe(C("span", null, null, 512), [[T, { e: l(wn), v: _.supplierClassification, bit: true, split: " | " }]])])])])])]), _: 1 }, 8, ["modelValue", "disabled", "options", "onChange"]), s(S, { modelValue: l(r).createTime, "onUpdate:modelValue": M[2] || (M[2] = (_) => l(r).createTime = _), "default-time": n.value, shortcuts: l(k1), class: "filter-item", "end-placeholder": "编制日期", "range-separator": ":", size: "default", "start-placeholder": "编制日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: l(u).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(h, { modelValue: l(r).serialNumber, "onUpdate:modelValue": M[3] || (M[3] = (_) => l(r).serialNumber = _), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "按采购合同编号搜索", size: "default", style: { width: "200px" }, onKeyup: $i(l(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(ca, { modelValue: l(r).projectId, "onUpdate:modelValue": M[4] || (M[4] = (_) => l(r).projectId = _), class: "filter-item", clearable: "", placeholder: "所属项目", style: { width: "240px" }, onChange: l(u).toQuery }, null, 8, ["modelValue", "onChange"]), s(UX, { modelValue: l(r).branchCompanyId, "onUpdate:modelValue": M[5] || (M[5] = (_) => l(r).branchCompanyId = _), level: l(Uc).COMPANY.V, class: "filter-item", clearable: "", placeholder: "采购单位", style: { width: "240px" }, onChange: l(u).toQuery }, null, 8, ["modelValue", "level", "onChange"]), s(l(b_))])) : H("", true)]);
  };
} }, qX = ut(HX, [["__scopeId", "data-v-12f521b3"]]), GX = { __name: "purchase-list", props: { modelValue: { type: Boolean, default: false }, materialType: { type: Number }, workshopReload: { type: Boolean, default: true } }, emits: ["update:modelValue", "handleCurrentRow"], setup(e, { expose: o, emit: n }) {
  const c = e, u = n, { visible: r, handleClose: E } = Ta({ emit: u, props: c }), y = Z(0), b = Z(0), V = Ee(() => [...cD, ["invoiceType", ["parse-enum", fi]], ["amount", ["to-thousand", Ze.YUAN]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"], ["otherMaterialNames", "split"]]), M = Z(), g = Z(), { detailRef: S, openDetail: h } = hl(), T = Z(), { CRUD: _, crud: f } = cu({ title: "采购合同列表", invisibleColumns: [], requiredQuery: ["isOpened"], crudApi: { get: x5 } }, M), { maxHeight: m } = Kt({ mainBox: ".requisitions-application-preview", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], navbar: false, clientHRepMainH: true, paginate: true, extraHeight: y.value + 500 }, r);
  _.HOOK.beforeRefresh = () => {
    f.query.isOpened = true;
  }, _.HOOK.handleRefresh = (P, { data: L }) => {
    L.content = L.content.map((O) => {
      const x = Js(Pe.ENUM, O.basicClass, "L");
      return O.typeText = x.join(" | "), O;
    }), T.value = L.content;
  };
  const R = () => {
    E(), pt(() => {
      var P, L;
      y.value = (P = document.querySelector("#navbar")) == null ? void 0 : P.offsetHeight, b.value = (L = document.querySelector(".sidebar-container")) == null ? void 0 : L.offsetWidth;
    });
  };
  function v(P) {
    Ae(P) || (u("handleCurrentRow", P), E());
  }
  function N(P) {
    P && h(P);
  }
  return Ce(() => r.value, (P) => {
    P ? (f.query.materialType = c.materialType, f.query.isOpened = true, f.toQuery()) : (f.query.isOpened = void 0, f.resetQuery());
  }, { deep: true, immediate: true }), El(() => {
    R(), window.addEventListener("resize", R);
  }), o({ purchaseList: T }), (P, L) => {
    const O = vt, x = Ve("common-button"), I = Ve("common-table"), Y = Ve("common-dialog"), ee = _t("permission"), B = oi;
    return w(), Q(Qe, null, [s(Y, { ref_key: "dialogRef", ref: g, modelValue: l(r), "onUpdate:modelValue": L[0] || (L[0] = (q) => Gt(r) ? r.value = q : null), "before-close": l(E), modal: false, "append-to-body": "", "custom-class": "requisitions-application-preview", "show-close": "", title: "采购合同列表", width: "1500px" }, { default: p(() => [s(qX, { ref: "headerRef", "material-type": e.materialType, workshopReload: e.workshopReload }, null, 8, ["material-type", "workshopReload"]), qe((w(), U(I, { ref_key: "tableRef", ref: M, data: l(f).data, "data-format": V.value, "max-height": l(m), style: { width: "100%" }, onCurrentChange: v }, { default: p(() => [s(O, { align: "center", label: "序号", type: "index", width: "60" }), s(O, { label: "采购合同编号", "min-width": "140px", prop: "serialNumber", "show-overflow-tooltip": "" }), s(O, { label: "供应商", "min-width": "150px", prop: "supplier.name", "show-overflow-tooltip": "" }), s(O, { label: "合同类型", "min-width": "85px", prop: "boolAnnual", "show-overflow-tooltip": "" }, { default: p(({ row: q }) => [Te(K(q.boolAnnual ? "年度合同" : "非年度合同"), 1)]), _: 1 }), s(O, { label: "物料种类", "min-width": "130px", prop: "typeText", "show-overflow-tooltip": "" }), s(O, { label: "合同额", "min-width": "100px", prop: "amount", "show-overflow-tooltip": "" }), s(O, { label: "关联项目", "min-width": "100px", prop: "projectsFullName", "show-overflow-tooltip": "" }), s(O, { label: "采购单位", "min-width": "120px", prop: "branchCompany.name", "show-overflow-tooltip": "" }), s(O, { label: "编制日期", width: "130px", prop: "createTime", "show-overflow-tooltip": "" }), s(O, { align: "left", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: { sourceRow: q } }) => [qe(s(x, { icon: "el-icon-view", size: "default", type: "info", onClick: Pi((ae) => N(q.id), ["stop"]) }, null, 8, ["onClick"]), [[ee, l(tn)]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[B, l(f).loading]]), s(td)]), _: 1 }, 8, ["modelValue", "before-close"]), s(ol, { ref_key: "purchaseOrderRef", ref: S, api: l(Tr) }, { default: p(() => [s(ks, { showBtn: false })]), _: 1 }, 8, ["api"])], 64);
  };
} };
const QX = { __name: "index", props: { size: { type: String }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, placeholder: { type: String }, materialType: { type: Number }, purchaseId: { type: Number }, edit: { type: Boolean, default: false }, defaultForm: { type: Object, default: () => ({}) }, workshopReload: { type: Boolean, default: true } }, emits: ["handleGetRow"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(), E = Z(), y = Z(false), b = Ee(() => {
    var S;
    return (S = E.value) == null ? void 0 : S.length;
  }), V = Ee(() => {
    var S;
    return (S = r.value) == null ? void 0 : S.purchaseList;
  });
  function M() {
    y.value = true;
  }
  function g(S) {
    c("handleGetRow", S), E.value = S == null ? void 0 : S.serialNumber;
  }
  return Ce(() => u.purchaseId, (S) => {
    var h, T;
    Ae(u.purchaseId) && (E.value = null), u.edit && (E.value = (T = (h = u.defaultForm) == null ? void 0 : h.purchaseOrder) == null ? void 0 : T.serialNumber);
  }), o({ purchaseListData: V }), (S, h) => {
    const T = Mt;
    return w(), Q(Qe, null, [s(T, { modelValue: E.value, "onUpdate:modelValue": h[0] || (h[0] = (_) => E.value = _), clearable: e.clearable, disabled: e.disabled, maxlength: b.value, placeholder: e.placeholder, size: e.size, class: "purchase-sn-select", onClear: g, onClick: M }, null, 8, ["modelValue", "clearable", "disabled", "maxlength", "placeholder", "size"]), s(GX, { ref_key: "purchaseListRef", ref: r, modelValue: y.value, "onUpdate:modelValue": h[1] || (h[1] = (_) => y.value = _), materialType: e.materialType, onHandleCurrentRow: g, workshopReload: u.workshopReload }, null, 8, ["modelValue", "materialType", "workshopReload"])], 64);
  };
} }, ZX = ut(QX, [["__scopeId", "data-v-f3b01ef1"]]);
const JX = { __name: "index", props: { purchaseId: { type: [Array, Number, String] }, info: { type: Object }, reload: { type: Boolean, default: true }, detailable: { type: Boolean, default: true }, basicClass: { type: Number }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择采购合同编号" }, defaultForm: { type: Object, default: () => ({}) }, edit: { type: Boolean, default: false } }, emits: ["change", "info-change", "update:purchaseId", "update:supplierId", "update:info"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(), E = Z({}), y = Z([]), { detailRef: b, openDetail: V } = hl();
  Ce(() => c.purchaseId, (f) => {
    r.value = f, c.edit && T();
  }, { immediate: true });
  async function M() {
    var m;
    let f = [];
    try {
      f = (m = u.value) == null ? void 0 : m.purchaseListData, c.basicClass && (f = f == null ? void 0 : f.filter((R) => R.basicClass & c.basicClass), f = f == null ? void 0 : f.map((R) => {
        var v;
        return R.projectNames = R.projects ? R.projects.map((N) => N.shortName).join("、") : "", (v = R.details) == null || v.map((N) => (N.specification = N.model || N.specification, N)), R;
      })), y.value = f, _();
    } catch (R) {
      console.log("获取可入库供应商对应采购单", R);
    } finally {
      y.value = f;
    }
  }
  function g(f) {
    r.value = f == null ? void 0 : f.id, M(), h(r.value);
  }
  function S(f) {
    f && V(f);
  }
  function h(f) {
    let m = f;
    Ae(m) && (m = void 0);
    const R = !el(m, c.purchaseId), v = Ae(m) && Ae(c.purchaseId);
    R && !v && (n("update:purchaseId", m), n("change", m, c.purchaseId), T(m, c.purchaseId));
  }
  function T(f, m) {
    let R = {}, v = {};
    c.edit ? R = c.defaultForm.purchaseOrder : (R = f ? E.value[f] : null, v = m ? E.value[m] : null), n("update:info", R), n("info-change", R, v);
  }
  function _() {
    var f;
    E.value = {}, A(y.value) && y.value.forEach((m) => {
      E.value[m.id] = m;
    }), A(r.value) && (((f = y.value) == null ? void 0 : f.findIndex((m) => m.id === r.value)) > -1 ? T(r.value) : (r.value = void 0, h(r.value)));
  }
  return (f, m) => {
    const R = _c, v = ml, N = _t("permission");
    return w(), Q("span", { class: Zt([{ "show-detail-icon": c.detailable && l(Ai)(l(tn)) }, "purchase-sn-select-container"]) }, [s(ZX, { ref_key: "purchaseSelectRef", ref: u, clearable: c.clearable, defaultForm: c.defaultForm, disabled: e.disabled, edit: c.edit, "material-type": e.basicClass, placeholder: e.placeholder, purchaseId: c.purchaseId, size: e.size, onHandleGetRow: g }, null, 8, ["clearable", "defaultForm", "disabled", "edit", "material-type", "placeholder", "purchaseId", "size"]), c.detailable ? qe((w(), Q("span", { key: 0, class: Zt([{ "not-allowed": !r.value }, "detail-icon pointer"]), onClick: m[0] || (m[0] = Pi((P) => S(r.value), ["stop"])) }, [s(v, { color: r.value ? "#1881ef" : "#c1c2c5" }, { default: p(() => [s(R)]), _: 1 }, 8, ["color"])], 2)), [[N, l(tn)]]) : H("", true), s(ol, { ref_key: "purchaseOrderRef", ref: b, api: l(Tr) }, { default: p(() => [s(ks, { showBtn: false })]), _: 1 }, 8, ["api"])], 2);
  };
} }, XX = ut(JX, [["__scopeId", "data-v-121815d8"]]), { handleMeteChangeCalcPrice: $X } = ma("weighingTotalWeight"), xr = vi[Ge.STEEL_PLATE.V], m3 = { title: "钢板入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: xr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: xr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: xr.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: xr.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: xr.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "金额", field: "amount", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_10" }, { label: "备注", field: "remark", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, m3.rules)) return;
  const n = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const u = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Ge.STEEL_PLATE.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [];
  const V = [];
  if (E.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = u.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, y.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, y.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, y.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && V.push(N);
        }
      }
      if (V.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of u) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, y.push(f.id);
      break;
    }
    T || b.push(h.classifyName);
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((h) => `“${h}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  const M = _e.state.config.classifySpec, g = [];
  for (let h = 0; h < y.length; h++) M[y[h]] === void 0 && !g.includes(y[h]) && g.push(y[h]);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of E) {
    if (((S = r == null ? void 0 : r[h.classifyId]) == null ? void 0 : S.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = M[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.material ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        _ = m;
        break;
      }
    }
    if (_) {
      h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.classifySerialNumber = _.classify.serialNumber, h.serialNumber = _.serialNumber, h.classifyId = _.classify.id, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision;
      let m = 0;
      for (const R in c) Number(R) === h.classifyId && (m = c[R]);
      h.steelDensity = m, h.theoryWeight = await na({ classifyId: h.classifyId, name: h.classifyFullName, length: h.length, width: h.width, thickness: h.thickness }), A(h.theoryWeight) && h.quantity ? h.theoryTotalWeight = Be(h.theoryWeight * h.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : h.theoryTotalWeight = void 0, h.weighingTotalWeight = h.weighingTotalWeight || h.theoryTotalWeight, (!h.unitPrice || !h.amount) && $X(h);
    } else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系管理员/仓库人员添加`);
  }
  return E;
} }, { handleMeteChangeCalcPrice: e$ } = ma("weighingTotalWeight"), Ur = vi[Ge.STEEL_PLATE.V];
function xb(e, o) {
  return Number(e) >= 0;
}
function t$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "钢板期初入库清单-错误清单", sheetName: "错误清单" });
}
const p3 = { title: "钢板期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Ur.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Ur.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Ur.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: Ur.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Ur.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: xb, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: xb, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (e) => {
  var R;
  if (!gi(e, p3.rules)) return;
  const n = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const u = _e.state.config.rawMatClsList.filter((v) => v.basicClass === Ge.STEEL_PLATE.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [];
  const V = [], M = [], g = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const S = _e.state.config.workshopNameV2, h = _e.state.config.warehouseV2, _ = _e.state.project.userProjectsMap[Ot].map((v) => (v.fullName = di(v, null, false), v));
  E.forEach((v, N) => {
    let P = false;
    const L = pi(v.classifyName.split("/"));
    if (L.length === 1) {
      const x = u.filter((I) => I.name === v.classifyName) || [];
      if (A(x)) if (x.length === 1) P = true, v.classifyId = x[0].id, y.push(x[0].id);
      else {
        const I = [];
        for (const ee of x) if (ee.isLeaf) for (let B = 0; B < ee.fullPathId.length; B++) ee.id !== ee.fullPathId[B] && I.push(ee.fullPathId[B]);
        const Y = x.find((ee) => Ae(ee.parent) && !I.includes(ee.id));
        if (A(Y)) P = true, v.classifyId = Y.id, y.push(Y.id);
        else {
          const ee = x.filter((B) => B.isLeaf) || [];
          if (ee.length === 1) {
            let B = true;
            x.forEach((q) => {
              ee[0].fullPathId.includes(q.id) || (B = false);
            }), B && (P = true, v.classifyId = ee[0].id, y.push(ee[0].id));
          } else for (const B of x) A(B.parent) && !I.includes(B.id) && V.push(B);
        }
      }
      V.length > 1 && g.push({ rowIndex: N + 1, error: `科目名称"${v.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const x of u) if (x.fullPathName.length >= L.length && mi(x.fullPathName.slice(-L.length), L)) {
      P = true, v.classifyId = x.id, y.push(x.id);
      break;
    }
    P || (b.push(v.classifyName), M.some((x) => x.classifyName === v.classifyName) || M.push({ rowIndex: N + 1, classifyName: v.classifyName }));
    const O = Ge.STEEL_PLATE.V;
    eo(v, N, { workshopNameV2List: S, warehouseV2List: h, arr: _, errorList: g, basicClass: O });
  }), b = Array.from(new Set(b)), b.length > 0 && (g.push({ rowIndex: M[0].rowIndex, error: `${M.map((v) => `"${v.classifyName}"`).join("、")}${M.length > 1 ? "等" : ""}物料种类不存在` }), M.shift());
  const f = _e.state.config.classifySpec, m = [];
  for (let v = 0; v < y.length; v++) f[y[v]] === void 0 && !m.includes(y[v]) && m.push(y[v]);
  m.length > 0 && (m.forEach((v) => {
    f[v] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", m));
  for (const v of E) {
    if (((R = r == null ? void 0 : r[v.classifyId]) == null ? void 0 : R.isLeaf) === false) {
      g.push({ rowIndex: E.indexOf(v) + 1, error: `${v.classifyName}不是末级科目` });
      continue;
    }
    const N = f[v.classifyId];
    if ((N == null ? void 0 : N.hasUnitConfig) === false) {
      g.push({ rowIndex: E.indexOf(v) + 1, error: `${v.classifyName}未配置核算单位` });
      continue;
    }
    let P;
    const L = v.material ?? "";
    if (N && Array.isArray(N.specList)) {
      for (const O of N.specList) if (L === O.spec) {
        P = O;
        break;
      }
    }
    if (P) {
      v.uid = Tt(), v.sn = P.sn, v.specificationLabels = P.specificationLabels, v.classifySerialNumber = P.classify.serialNumber, v.serialNumber = P.serialNumber, v.classifyId = P.classify.id, v.classifyFullName = P.classify.fullName, v.classifyName = P.classify.name, v.classifyParentFullName = P.classify.parentFullName, v.basicClass = P.classify.basicClass, v.specification = P.spec, v.specificationMap = P.specKV, v.measureUnit = P.classify.measureUnit, v.accountingUnit = P.classify.accountingUnit, v.accountingPrecision = P.classify.accountingPrecision, v.measurePrecision = P.classify.measurePrecision;
      let O = 0;
      for (const x in c) Number(x) === v.classifyId && (O = c[x]);
      v.steelDensity = O, v.theoryWeight = await na({ classifyId: v.classifyId, name: v.classifyFullName, length: v.length, width: v.width, thickness: v.thickness }), A(v.theoryWeight) && v.quantity ? v.theoryTotalWeight = Be(v.theoryWeight * v.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : v.theoryTotalWeight = void 0, v.weighingTotalWeight = v.weighingTotalWeight || v.theoryTotalWeight, (!v.unitPrice || !v.amount) && e$(v);
    } else {
      const O = `${v.classifyName}下不存在规格为"${L}"的材料，请联系管理员/仓库人员添加`;
      g.some((x) => x.error === O) || g.push({ rowIndex: E.indexOf(v) + 1, error: O });
      continue;
    }
  }
  if (g.length > 0) t$(g);
  else return E;
} }, { handleMeteChangeCalcPrice: i$ } = ma("weighingTotalWeight"), Kd = vi[Ge.SECTION_STEEL.V], h3 = { title: "型材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "材质", field: "material", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Kd.length.precision, excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", precision: Kd.measure.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Kd.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材规格不能为空" }] }, format: async (e) => {
  var g, S;
  if (!gi(e, h3.rules)) return;
  const n = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const c = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Ge.SECTION_STEEL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [];
  if (r.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = c.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, E.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, E.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, E.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && b.push(N);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of c) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, E.push(f.id);
      break;
    }
    T || y.push(h.classifyName);
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((h) => `“${h}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  const V = _e.state.config.classifySpec, M = [];
  for (let h = 0; h < E.length; h++) V[E[h]] === void 0 && !M.includes(E[h]) && M.push(E[h]);
  M.length > 0 && (M.forEach((h) => {
    V[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const h of r) {
    if (((g = u == null ? void 0 : u[h.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = V[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.material ? `${h.specification} * ${h.material}` : `${h.specification}`;
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (m.status) _ = m;
        else throw new Error(`${f}被禁用，请开启后重新导入`);
        break;
      }
    }
    if (_) {
      const m = (S = _.nationalStandardOptions.find((N) => N.boolDefault === true)) == null ? void 0 : S.standardId;
      h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.unitWeight = _.unitWeight, h.nationalStandardOptions = _.nationalStandardOptions, h.standardId = m;
      let R;
      const v = [];
      for (const N in h.specificationMap) N.indexOf("standard") > -1 ? R = h.specificationMap[N] : v.push(h.specificationMap[N]);
      h.sectionSteelSpec = R, h.doNotSectionSteelSpec = v.join(" * "), h.theoryWeight = await xa({ length: h.length, unitWeight: h.unitWeight }), A(h.theoryWeight) && h.quantity ? h.theoryTotalWeight = Be(h.theoryWeight * h.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : h.theoryTotalWeight = void 0, h.weighingTotalWeight = h.weighingTotalWeight || h.theoryTotalWeight, a$(h), (!h.unitPrice || !h.amount) && i$(h);
    } else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
function a$(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: l$ } = ma("weighingTotalWeight"), Wd = vi[Ge.SECTION_STEEL.V];
function Ub(e, o) {
  return Number(e) >= 0;
}
function o$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "型材期初入库清单-错误清单", sheetName: "错误清单" });
}
const f3 = { title: "型材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Wd.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: Wd.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Wd.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_14" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: Ub, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: Ub, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (e) => {
  var m, R;
  if (!gi(e, f3.rules)) return;
  const n = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const c = _e.state.config.rawMatClsList.filter((v) => v.basicClass === Ge.SECTION_STEEL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [], V = [], M = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const g = _e.state.config.workshopNameV2, S = _e.state.config.warehouseV2, T = _e.state.project.userProjectsMap[Ot].map((v) => (v.fullName = di(v, null, false), v));
  r.forEach((v, N) => {
    let P = false;
    const L = pi(v.classifyName.split("/"));
    if (L.length === 1) {
      const x = c.filter((I) => I.name === v.classifyName) || [];
      if (A(x)) if (x.length === 1) P = true, v.classifyId = x[0].id, E.push(x[0].id);
      else {
        const I = [];
        for (const ee of x) if (ee.isLeaf) for (let B = 0; B < ee.fullPathId.length; B++) ee.id !== ee.fullPathId[B] && I.push(ee.fullPathId[B]);
        const Y = x.find((ee) => Ae(ee.parent) && !I.includes(ee.id));
        if (A(Y)) P = true, v.classifyId = Y.id, E.push(Y.id);
        else {
          const ee = x.filter((B) => B.isLeaf) || [];
          if (ee.length === 1) {
            let B = true;
            x.forEach((q) => {
              ee[0].fullPathId.includes(q.id) || (B = false);
            }), B && (P = true, v.classifyId = ee[0].id, E.push(ee[0].id));
          } else for (const B of x) A(B.parent) && !I.includes(B.id) && b.push(B);
        }
      }
      b.length > 1 && M.push({ rowIndex: N + 1, error: `科目名称"${v.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const x of c) if (x.fullPathName.length >= L.length && mi(x.fullPathName.slice(-L.length), L)) {
      P = true, v.classifyId = x.id, E.push(x.id);
      break;
    }
    P || (y.push(v.classifyName), V.some((x) => x.classifyName === v.classifyName) || V.push({ rowIndex: N + 1, classifyName: v.classifyName }));
    const O = Ge.SECTION_STEEL.V;
    eo(v, N, { workshopNameV2List: g, warehouseV2List: S, arr: T, errorList: M, basicClass: O });
  }), y = Array.from(new Set(y)), y.length > 0 && (M.push({ rowIndex: V[0].rowIndex, error: `${V.map((v) => `"${v.classifyName}"`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在` }), V.shift());
  const _ = _e.state.config.classifySpec, f = [];
  for (let v = 0; v < E.length; v++) _[E[v]] === void 0 && !f.includes(E[v]) && f.push(E[v]);
  f.length > 0 && (f.forEach((v) => {
    _[v] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", f));
  for (const v of r) {
    if (((m = u == null ? void 0 : u[v.classifyId]) == null ? void 0 : m.isLeaf) === false) {
      M.push({ rowIndex: r.indexOf(v) + 1, error: `${v.classifyName}不是末级科目` });
      continue;
    }
    const N = _[v.classifyId];
    if ((N == null ? void 0 : N.hasUnitConfig) === false) {
      M.push({ rowIndex: r.indexOf(v) + 1, error: `${v.classifyName}未配置核算单位` });
      continue;
    }
    let P;
    const L = `${v.specification} * ${v.material}`;
    if (N && Array.isArray(N.specList)) {
      for (const O of N.specList) if (L === O.spec) {
        P = O;
        break;
      }
    }
    if (P) {
      const O = (R = P.nationalStandardOptions.find((Y) => Y.boolDefault === true)) == null ? void 0 : R.standardId;
      v.uid = Tt(), v.sn = P.sn, v.specificationLabels = P.specificationLabels, v.serialNumber = P.serialNumber, v.classifySerialNumber = P.classify.serialNumber, v.classifyId = P.classify.id, v.classifyFullName = P.classify.fullName, v.classifyName = P.classify.name, v.classifyParentFullName = P.classify.parentFullName, v.basicClass = P.classify.basicClass, v.specification = P.spec.split("*").slice(0, -1).join("*"), v.specificationMap = P.specKV, v.measureUnit = P.classify.measureUnit, v.accountingUnit = P.classify.accountingUnit, v.accountingPrecision = P.classify.accountingPrecision, v.measurePrecision = P.classify.measurePrecision, v.unitWeight = P.unitWeight, v.nationalStandardOptions = P.nationalStandardOptions, v.standardId = O;
      let x;
      const I = [];
      for (const Y in v.specificationMap) Y.indexOf("standard") > -1 ? x = v.specificationMap[Y] : I.push(v.specificationMap[Y]);
      v.sectionSteelSpec = x, v.doNotSectionSteelSpec = I.join(" * "), v.theoryWeight = await xa({ length: v.length, unitWeight: v.unitWeight }), A(v.theoryWeight) && v.quantity ? v.theoryTotalWeight = Be(v.theoryWeight * v.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : v.theoryTotalWeight = void 0, v.weighingTotalWeight = v.weighingTotalWeight || v.theoryTotalWeight, n$(v), (!v.unitPrice || !v.amount) && l$(v);
    } else {
      const O = `${v.classifyName}下不存在规格为"${L}"的材料，请联系管理员/仓库人员添加`;
      M.some((x) => x.error === O) || M.push({ rowIndex: r.indexOf(v) + 1, error: O });
      continue;
    }
  }
  if (M.length > 0) o$(M);
  else return r;
} };
function n$(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: s$ } = ma("weighingTotalWeight"), Du = vi[Ge.STEEL_COIL.V], g3 = { title: "钢卷入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Du.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Du.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Du.length.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Du.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_10" }, { label: "备注", field: "remark", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (!gi(e, g3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg, c = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [];
  if (r.forEach((S) => {
    let h = false;
    const T = pi(S.classifyName.split("/"));
    if (T.length === 1) {
      const _ = c.filter((f) => f.name === S.classifyName) || [];
      if (A(_)) if (_.length === 1) h = true, S.classifyId = _[0].id, E.push(_[0].id);
      else {
        const f = [];
        for (const R of _) if (R.isLeaf) for (let v = 0; v < R.fullPathId.length; v++) R.id !== R.fullPathId[v] && f.push(R.fullPathId[v]);
        const m = _.find((R) => Ae(R.parent) && !f.includes(R.id));
        if (A(m)) h = true, S.classifyId = m.id, E.push(m.id);
        else {
          const R = _.filter((v) => v.isLeaf) || [];
          if (R.length === 1) {
            let v = true;
            _.forEach((N) => {
              R[0].fullPathId.includes(N.id) || (v = false);
            }), v && (h = true, S.classifyId = R[0].id, E.push(R[0].id));
          } else for (const v of _) A(v.parent) && !f.includes(v.id) && b.push(v);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${S.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const _ of c) if (_.fullPathName.length >= T.length && mi(_.fullPathName.slice(-T.length), T)) {
      h = true, S.classifyId = _.id, E.push(_.id);
      break;
    }
    h || y.push(S.classifyName);
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((S) => `“${S}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  const V = _e.state.config.classifySpec, M = [];
  for (let S = 0; S < E.length; S++) V[E[S]] === void 0 && !M.includes(E[S]) && M.push(E[S]);
  M.length > 0 && (M.forEach((S) => {
    V[S] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const S of r) {
    if (((g = u == null ? void 0 : u[S.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${S.classifyName}不是末级科目`);
    const h = V[S.classifyId];
    if (h.hasUnitConfig === false) throw new Error(`${S.classifyName}未配置核算单位`);
    let T;
    const _ = S.material ?? "";
    if (h && Array.isArray(h.specList)) {
      for (const f of h.specList) if (_ === f.spec) {
        T = f;
        break;
      }
    }
    if (T) {
      S.uid = Tt(), S.sn = T.sn, S.specificationLabels = T.specificationLabels, S.serialNumber = T.serialNumber, S.classifySerialNumber = T.classify.serialNumber, S.classifyId = T.classify.id, S.classifyFullName = T.classify.fullName, S.classifyName = T.classify.name, S.classifyParentFullName = T.classify.parentFullName, S.basicClass = T.classify.basicClass, S.specification = T.spec, S.specificationMap = T.specKV, S.measureUnit = T.classify.measureUnit, S.accountingUnit = T.classify.accountingUnit, S.accountingPrecision = T.classify.accountingPrecision, S.measurePrecision = T.classify.measurePrecision;
      let f = 0;
      for (const m in n) Number(m) === S.classifyId && (f = n[m]);
      S.steelDensity = f, await r$(S), S.length = S.length || S.theoryLength, (!S.unitPrice || !S.amount) && s$(S);
    } else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
async function r$(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const { handleMeteChangeCalcPrice: u$ } = ma("mete"), Tm = { title: "辅材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, Tm.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((g) => g.basicClass === Ge.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [];
  if (u.forEach((g) => {
    let S = false;
    const h = pi(g.classifyName.split("/"));
    if (h.length === 1) {
      const T = n.filter((_) => _.name === g.classifyName) || [];
      if (A(T)) if (T.length === 1) S = true, g.classifyId = T[0].id, r.push(T[0].id);
      else {
        const _ = [];
        for (const m of T) if (m.isLeaf) for (let R = 0; R < m.fullPathId.length; R++) m.id !== m.fullPathId[R] && _.push(m.fullPathId[R]);
        const f = T.find((m) => Ae(m.parent) && !_.includes(m.id));
        if (A(f)) S = true, g.classifyId = f.id, r.push(f.id);
        else {
          const m = T.filter((R) => R.isLeaf) || [];
          if (m.length === 1) {
            let R = true;
            T.forEach((v) => {
              m[0].fullPathId.includes(v.id) || (R = false);
            }), R && (S = true, g.classifyId = m[0].id, r.push(m[0].id));
          } else for (const R of T) A(R.parent) && !_.includes(R.id) && y.push(R);
        }
      }
      if (y.length > 1) throw new Error(`科目名称“${g.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const T of n) if (T.fullPathName.length >= h.length && mi(T.fullPathName.slice(-h.length), h)) {
      S = true, g.classifyId = T.id, r.push(T.id);
      break;
    }
    S || E.push(g.classifyName);
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((g) => `“${g}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  const b = _e.state.config.classifySpec, V = [];
  for (let g = 0; g < r.length; g++) b[r[g]] === void 0 && !V.includes(r[g]) && V.push(r[g]);
  V.length > 0 && (V.forEach((g) => {
    b[g] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", V));
  for (const g of u) {
    if (((M = c == null ? void 0 : c[g.classifyId]) == null ? void 0 : M.isLeaf) === false) throw new Error(`${g.classifyName}不是末级科目`);
    const S = b[g.classifyId];
    if (S.hasUnitConfig === false) throw new Error(`${g.classifyName}未配置核算单位`);
    let h;
    const T = g.specification ?? "";
    if (S && Array.isArray(S.specList)) {
      for (const _ of S.specList) if (T === _.spec) {
        if (h = _, g.measureUnit) {
          if (!h.classify.measureUnit) throw new Error(`${g.classifyName}不存在计量单位`);
          if (!await ti(h.classify.measureUnit, g.measureUnit)) throw new Error(`${g.classifyName}填写的计量单位错误，单位应为：“${h.classify.measureUnit}”`);
        }
        if (g.accountingUnit && !await ti(h.classify.accountingUnit, g.accountingUnit)) throw new Error(`${g.classifyName}填写的核算单位错误，单位应为：“${h.classify.accountingUnit}”`);
        break;
      }
    }
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0), (!g.unitPrice || !g.amount) && u$(g);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, E3 = { title: "其它入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, E3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((g) => g.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [];
  if (u.forEach((g) => {
    let S = false;
    const h = pi(g.classifyName.split("/"));
    if (h.length === 1) {
      const T = n.filter((_) => _.name === g.classifyName) || [];
      if (A(T)) if (T.length === 1) S = true, g.classifyId = T[0].id, r.push(T[0].id);
      else {
        const _ = [];
        for (const m of T) if (m.isLeaf) for (let R = 0; R < m.fullPathId.length; R++) m.id !== m.fullPathId[R] && _.push(m.fullPathId[R]);
        const f = T.find((m) => Ae(m.parent) && !_.includes(m.id));
        if (A(f)) S = true, g.classifyId = f.id, r.push(f.id);
        else {
          const m = T.filter((R) => R.isLeaf) || [];
          if (m.length === 1) {
            let R = true;
            T.forEach((v) => {
              m[0].fullPathId.includes(v.id) || (R = false);
            }), R && (S = true, g.classifyId = m[0].id, r.push(m[0].id));
          } else for (const R of T) A(R.parent) && !_.includes(R.id) && y.push(R);
        }
      }
      if (y.length > 1) throw new Error(`科目名称“${g.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const T of n) if (T.fullPathName.length >= h.length && mi(T.fullPathName.slice(-h.length), h)) {
      S = true, g.classifyId = T.id, r.push(T.id);
      break;
    }
    S || E.push(g.classifyName);
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((g) => `“${g}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  const b = _e.state.config.classifySpec, V = [];
  for (let g = 0; g < r.length; g++) b[r[g]] === void 0 && !V.includes(r[g]) && V.push(r[g]);
  V.length > 0 && (V.forEach((g) => {
    b[g] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", V));
  for (const g of u) {
    if (((M = c == null ? void 0 : c[g.classifyId]) == null ? void 0 : M.isLeaf) === false) throw new Error(`${g.classifyName}不是末级科目`);
    const S = b[g.classifyId];
    if (S.hasUnitConfig === false) throw new Error(`${g.classifyName}未配置核算单位`);
    let h;
    const T = g.specification ?? "";
    if (S && Array.isArray(S.specList)) {
      for (const _ of S.specList) if (T === _.spec) {
        if (h = _, g.measureUnit) {
          if (!h.classify.measureUnit) throw new Error(`${g.classifyName}不存在计量单位`);
          if (!await ti(h.classify.measureUnit, g.measureUnit)) throw new Error(`${g.classifyName}填写的计量单位错误，单位应为：“${h.classify.measureUnit}”`);
        }
        if (g.accountingUnit && !await ti(h.classify.accountingUnit, g.accountingUnit)) throw new Error(`${g.classifyName}填写的核算单位错误，单位应为：“${h.classify.accountingUnit}”`);
        break;
      }
    }
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, y3 = { title: "气体入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "备注", field: "remark", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, y3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((g) => g.basicClass === Ge.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [];
  if (u.forEach((g) => {
    let S = false;
    const h = pi(g.classifyName.split("/"));
    if (h.length === 1) {
      const T = n.filter((_) => _.name === g.classifyName) || [];
      if (A(T)) if (T.length === 1) S = true, g.classifyId = T[0].id, r.push(T[0].id);
      else {
        const _ = [];
        for (const m of T) if (m.isLeaf) for (let R = 0; R < m.fullPathId.length; R++) m.id !== m.fullPathId[R] && _.push(m.fullPathId[R]);
        const f = T.find((m) => Ae(m.parent) && !_.includes(m.id));
        if (A(f)) S = true, g.classifyId = f.id, r.push(f.id);
        else {
          const m = T.filter((R) => R.isLeaf) || [];
          if (m.length === 1) {
            let R = true;
            T.forEach((v) => {
              m[0].fullPathId.includes(v.id) || (R = false);
            }), R && (S = true, g.classifyId = m[0].id, r.push(m[0].id));
          } else for (const R of T) A(R.parent) && !_.includes(R.id) && y.push(R);
        }
      }
      if (y.length > 1) throw new Error(`科目名称“${g.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const T of n) if (T.fullPathName.length >= h.length && mi(T.fullPathName.slice(-h.length), h)) {
      S = true, g.classifyId = T.id, r.push(T.id);
      break;
    }
    S || E.push(g.classifyName);
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((g) => `“${g}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  const b = _e.state.config.classifySpec, V = [];
  for (let g = 0; g < r.length; g++) b[r[g]] === void 0 && !V.includes(r[g]) && V.push(r[g]);
  V.length > 0 && (V.forEach((g) => {
    b[g] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", V));
  for (const g of u) {
    if (((M = c == null ? void 0 : c[g.classifyId]) == null ? void 0 : M.isLeaf) === false) throw new Error(`${g.classifyName}不是末级科目`);
    const S = b[g.classifyId];
    if (S.hasUnitConfig === false) throw new Error(`${g.classifyName}未配置核算单位`);
    let h;
    const T = g.specification ?? "";
    if (S && Array.isArray(S.specList)) {
      for (const _ of S.specList) if (T === _.spec) {
        if (h = _, g.measureUnit) {
          if (!h.classify.measureUnit) throw new Error(`${g.classifyName}不存在计量单位`);
          if (!await ti(h.classify.measureUnit, g.measureUnit)) throw new Error(`${g.classifyName}填写的计量单位错误，单位应为：“${h.classify.measureUnit}”`);
        }
        if (g.accountingUnit && !await ti(h.classify.accountingUnit, g.accountingUnit)) throw new Error(`${g.classifyName}填写的核算单位错误，单位应为：“${h.classify.accountingUnit}”`);
        break;
      }
    }
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, { handleMeteChangeCalcPrice: c$ } = ma("mete"), T3 = { title: "其它钢材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "备注", field: "remark", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, T3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((g) => g.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [];
  if (u.forEach((g) => {
    let S = false;
    const h = pi(g.classifyName.split("/"));
    if (h.length === 1) {
      const T = n.filter((_) => _.name === g.classifyName) || [];
      if (A(T)) if (T.length === 1) S = true, g.classifyId = T[0].id, r.push(T[0].id);
      else {
        const _ = [];
        for (const m of T) if (m.isLeaf) for (let R = 0; R < m.fullPathId.length; R++) m.id !== m.fullPathId[R] && _.push(m.fullPathId[R]);
        const f = T.find((m) => Ae(m.parent) && !_.includes(m.id));
        if (A(f)) S = true, g.classifyId = f.id, r.push(f.id);
        else {
          const m = T.filter((R) => R.isLeaf) || [];
          if (m.length === 1) {
            let R = true;
            T.forEach((v) => {
              m[0].fullPathId.includes(v.id) || (R = false);
            }), R && (S = true, g.classifyId = m[0].id, r.push(m[0].id));
          } else for (const R of T) A(R.parent) && !_.includes(R.id) && y.push(R);
        }
      }
      if (y.length > 1) throw new Error(`科目名称“${g.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const T of n) if (T.fullPathName.length >= h.length && mi(T.fullPathName.slice(-h.length), h)) {
      S = true, g.classifyId = T.id, r.push(T.id);
      break;
    }
    S || E.push(g.classifyName);
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((g) => `“${g}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  const b = _e.state.config.classifySpec, V = [];
  for (let g = 0; g < r.length; g++) b[r[g]] === void 0 && !V.includes(r[g]) && V.push(r[g]);
  V.length > 0 && (V.forEach((g) => {
    b[g] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", V));
  for (const g of u) {
    if (((M = c == null ? void 0 : c[g.classifyId]) == null ? void 0 : M.isLeaf) === false) throw new Error(`${g.classifyName}不是末级科目`);
    const S = b[g.classifyId];
    if (S.hasUnitConfig === false) throw new Error(`${g.classifyName}未配置核算单位`);
    let h;
    const T = g.specification ?? "";
    if (S && Array.isArray(S.specList)) {
      for (const _ of S.specList) if (T === _.spec) {
        if (h = _, g.measureUnit) {
          if (!h.classify.measureUnit) throw new Error(`${g.classifyName}不存在计量单位`);
          if (!await ti(h.classify.measureUnit, g.measureUnit)) throw new Error(`${g.classifyName}填写的计量单位错误，单位应为：“${h.classify.measureUnit}”`);
        }
        if (g.accountingUnit && !await ti(h.classify.accountingUnit, g.accountingUnit)) throw new Error(`${g.classifyName}填写的核算单位错误，单位应为：“${h.classify.accountingUnit}”`);
        break;
      }
    }
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0), (!g.unitPrice || !g.amount) && c$(g);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, Yr = vi[Ge.STEEL_PLATE.V], _3 = { title: "钢板入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Yr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Yr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Yr.length.precision, excelField: "__EMPTY_4" }, { label: "本次实收数量（张）", field: "quantity", type: "number", precision: Yr.measure.precision, excelField: "__EMPTY_5" }, { label: "实收量（t）", field: "weighingTotalWeight", type: "number", precision: Yr.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var _;
  if (!gi(e, _3.rules)) return;
  const n = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const u = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.STEEL_PLATE.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [], M = [], g = [];
  const S = [];
  if (E.forEach((f) => {
    let m = false;
    const R = pi(f.classifyName.split("/"));
    if (R.length === 1) {
      const v = u.filter((N) => N.name === f.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, f.classifyId = v[0].id, y.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, f.classifyId = P.id, y.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, f.classifyId = L[0].id, y.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && S.push(O);
        }
      }
      if (S.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of u) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, y.push(v.id);
      break;
    }
    if (m || b.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : V.push(f.shortName);
    }
    if (f.workshopName) {
      const v = _e.state.config.workshopNameV2.find((N) => N.name === f.workshopName);
      A(v) ? f.workshopId = v.id : M.push(f.workshopName);
    }
    if (f.workshopName && f.warehouseName) {
      const v = _e.state.config.warehouseV2.find((N) => N.name === f.warehouseName);
      A(v) ? f.warehouseId = v.id : g.push(f.warehouseName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((f) => `“${f}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}仓库不存在`);
  if (g = Array.from(new Set(g)), g.length > 0) throw new Error(`${g.map((f) => `“${f}”`).join("、")}${g.length > 1 ? "等" : ""}存储位置不存在`);
  const h = _e.state.config.classifySpec, T = y.filter((f) => h[f] === void 0);
  T.length > 0 && (T.forEach((f) => {
    h[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", T));
  for (const f of E) {
    if (((_ = r == null ? void 0 : r[f.classifyId]) == null ? void 0 : _.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
    const m = h[f.classifyId];
    if (m.hasUnitConfig === false) throw new Error(`${f.classifyName}未配置核算单位`);
    let R;
    const v = f.material ?? "";
    if (m && Array.isArray(m.specList)) {
      for (const N of m.specList) if (v === N.spec) {
        R = N;
        break;
      }
    }
    if (R) {
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.classifySerialNumber = R.classify.serialNumber, f.serialNumber = R.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision;
      let N = 0;
      for (const P in c) Number(P) === f.classifyId && (N = c[P]);
      f.steelDensity = N, f.theoryWeight = await na({ classifyId: f.classifyId, name: f.classifyFullName, length: f.length, width: f.width, thickness: f.thickness }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight;
    } else throw new Error(`${f.classifyName}下不存在规格为“${v}”的材料，请联系管理员/仓库人员添加`);
  }
  return E;
} }, jd = vi[Ge.SECTION_STEEL.V], b3 = { title: "型材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "材质", field: "material", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: jd.length.precision, excelField: "__EMPTY_3" }, { label: "本次实收数（根）", field: "quantity", type: "number", precision: jd.measure.precision, excelField: "__EMPTY_4" }, { label: "实收量（t）", field: "weighingTotalWeight", type: "number", precision: jd.weight.precision, excelField: "__EMPTY_5" }, { label: "品牌", field: "brand", excelField: "__EMPTY_6" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_7" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_11" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var T, _;
  if (!gi(e, b3.rules)) return;
  const n = await _a();
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const c = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.SECTION_STEEL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [], b = [], V = [], M = [];
  const g = [];
  if (r.forEach((f) => {
    let m = false;
    const R = pi(f.classifyName.split("/"));
    if (R.length === 1) {
      const v = c.filter((N) => N.name === f.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, f.classifyId = v[0].id, E.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, f.classifyId = P.id, E.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, f.classifyId = L[0].id, E.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && g.push(O);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of c) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, E.push(v.id);
      break;
    }
    if (m || y.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : b.push(f.shortName);
    }
    if (f.workshopName) {
      const v = _e.state.config.workshopNameV2.find((N) => N.name === f.workshopName);
      A(v) ? f.workshopId = v.id : V.push(f.workshopName);
    }
    if (f.workshopName && f.warehouseName) {
      const v = _e.state.config.warehouseV2.find((N) => N.name === f.warehouseName);
      A(v) ? f.warehouseId = v.id : M.push(f.warehouseName);
    }
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((f) => `“${f}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((f) => `“${f}”`).join("、")}${b.length > 1 ? "等" : ""}项目不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}仓库不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}存储位置不存在`);
  const S = _e.state.config.classifySpec, h = E.filter((f) => S[f] === void 0);
  h.length > 0 && (h.forEach((f) => {
    S[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const f of r) {
    if (((T = u == null ? void 0 : u[f.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
    const m = S[f.classifyId];
    if (m.hasUnitConfig === false) throw new Error(`${f.classifyName}未配置核算单位`);
    let R;
    const v = `${f.specification} * ${f.material}`;
    if (m && Array.isArray(m.specList)) {
      for (const N of m.specList) if (v === N.spec) {
        R = N;
        break;
      }
    }
    if (R) {
      const N = (_ = R.nationalStandardOptions.find((O) => O.boolDefault === true)) == null ? void 0 : _.standardId;
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.serialNumber = R.serialNumber, f.classifySerialNumber = R.classify.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision, f.unitWeight = R.unitWeight, f.nationalStandardOptions = R.nationalStandardOptions, f.standardId = N;
      let P;
      const L = [];
      for (const O in f.specificationMap) O.indexOf("standard") > -1 ? P = f.specificationMap[O] : L.push(f.specificationMap[O]);
      f.sectionSteelSpec = P, f.doNotSectionSteelSpec = L.join(" * "), f.theoryWeight = await xa({ length: f.length, unitWeight: f.unitWeight }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight, d$(f);
    } else throw new Error(`${f.classifyName}下不存在规格为“${v}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
function d$(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const xu = vi[Ge.STEEL_COIL.V], V3 = { title: "钢卷入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: xu.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: xu.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: xu.length.precision, excelField: "__EMPTY_4" }, { label: "实收重（t）", field: "weighingTotalWeight", type: "number", precision: xu.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var T;
  if (!gi(e, V3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const c = _e.state.config.rawMatClsList.filter((_) => _.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [], b = [], V = [], M = [];
  const g = [];
  if (r.forEach((_) => {
    let f = false;
    const m = pi(_.classifyName.split("/"));
    if (m.length === 1) {
      const R = c.filter((v) => v.name === _.classifyName) || [];
      if (A(R)) if (R.length === 1) f = true, _.classifyId = R[0].id, E.push(R[0].id);
      else {
        const v = [];
        for (const P of R) if (P.isLeaf) for (let L = 0; L < P.fullPathId.length; L++) P.id !== P.fullPathId[L] && v.push(P.fullPathId[L]);
        const N = R.find((P) => Ae(P.parent) && !v.includes(P.id));
        if (A(N)) f = true, _.classifyId = N.id, E.push(N.id);
        else {
          const P = R.filter((L) => L.isLeaf) || [];
          if (P.length === 1) {
            let L = true;
            R.forEach((O) => {
              P[0].fullPathId.includes(O.id) || (L = false);
            }), L && (f = true, _.classifyId = P[0].id, E.push(P[0].id));
          } else for (const L of R) A(L.parent) && !v.includes(L.id) && g.push(L);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${_.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const R of c) if (R.fullPathName.length >= m.length && mi(R.fullPathName.slice(-m.length), m)) {
      f = true, _.classifyId = R.id, E.push(R.id);
      break;
    }
    if (f || y.push(_.classifyName), _.shortName) {
      const R = _e.state.project.projectAllType.find((v) => v.shortName === _.shortName);
      A(R) ? _.projectId = R.id : b.push(_.shortName);
    }
    if (_.workshopName) {
      const R = _e.state.config.workshopNameV2.find((v) => v.name === _.workshopName);
      A(R) ? _.workshopId = R.id : V.push(_.workshopName);
    }
    if (_.workshopName && _.warehouseName) {
      const R = _e.state.config.warehouseV2.find((v) => v.name === _.warehouseName);
      A(R) ? _.warehouseId = R.id : M.push(_.warehouseName);
    }
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((_) => `“${_}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((_) => `“${_}”`).join("、")}${b.length > 1 ? "等" : ""}项目不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((_) => `“${_}”`).join("、")}${V.length > 1 ? "等" : ""}仓库不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((_) => `“${_}”`).join("、")}${M.length > 1 ? "等" : ""}存储位置不存在`);
  const S = _e.state.config.classifySpec, h = E.filter((_) => S[_] === void 0);
  h.length > 0 && (h.forEach((_) => {
    S[_] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const _ of r) {
    if (((T = u == null ? void 0 : u[_.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${_.classifyName}不是末级科目`);
    const f = S[_.classifyId];
    if (f.hasUnitConfig === false) throw new Error(`${_.classifyName}未配置核算单位`);
    let m;
    const R = _.material ?? "";
    if (f && Array.isArray(f.specList)) {
      for (const v of f.specList) if (R === v.spec) {
        m = v;
        break;
      }
    }
    if (m) {
      _.uid = Tt(), _.sn = m.sn, _.specificationLabels = m.specificationLabels, _.serialNumber = m.serialNumber, _.classifySerialNumber = m.classify.serialNumber, _.classifyId = m.classify.id, _.classifyFullName = m.classify.fullName, _.classifyName = m.classify.name, _.classifyParentFullName = m.classify.parentFullName, _.basicClass = m.classify.basicClass, _.specification = m.spec, _.specificationMap = m.specKV, _.measureUnit = m.classify.measureUnit, _.accountingUnit = m.classify.accountingUnit, _.accountingPrecision = m.classify.accountingPrecision, _.measurePrecision = m.classify.measurePrecision;
      let v = 0;
      for (const N in n) Number(N) === _.classifyId && (v = n[N]);
      _.steelDensity = v, await m$(_), _.length = _.length ? St(_.length, "mm", "m") : _.theoryLength;
    } else throw new Error(`${_.classifyName}下不存在规格为“${R}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
async function m$(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const _m = { title: "辅材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "颜色", field: "color", excelField: "__EMPTY_4" }, { label: "品牌", field: "brand", excelField: "__EMPTY_5" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_6" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_7" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_8" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_9" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, _m.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, w3 = { title: "其它入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "颜色", field: "color", excelField: "__EMPTY_4" }, { label: "品牌", field: "brand", excelField: "__EMPTY_5" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_6" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_7" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_8" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_9" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, w3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, S3 = { title: "气体入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "颜色", field: "brand", excelField: "__EMPTY_4" }, { label: "品牌", field: "brand", excelField: "__EMPTY_5" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_6" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_7" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_8" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_9" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, S3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, v3 = { title: "其它钢材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "颜色", field: "color", excelField: "__EMPTY_4" }, { label: "品牌", field: "brand", excelField: "__EMPTY_5" }, { label: "炉批号", field: "brand", excelField: "__EMPTY_6" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_7" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_8" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_9" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_10" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, v3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, { handleMeteChangeCalcPrice: p$ } = ma("weighingTotalWeight"), Kr = vi[Ge.STEEL_PLATE.V], R3 = { title: "钢板入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Kr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Kr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Kr.length.precision, excelField: "__EMPTY_4" }, { label: "本次实收数量（张）", field: "quantity", type: "number", precision: Kr.measure.precision, excelField: "__EMPTY_5" }, { label: "实收量（kg）", field: "weighingTotalWeight", type: "number", precision: Kr.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_10" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_14" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var _;
  if (!gi(e, R3.rules)) return;
  const n = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const u = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.STEEL_PLATE.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [], M = [], g = [];
  const S = [];
  if (E.forEach((f) => {
    let m = false;
    const R = pi(f.classifyName.split("/"));
    if (R.length === 1) {
      const v = u.filter((N) => N.name === f.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, f.classifyId = v[0].id, y.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, f.classifyId = P.id, y.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, f.classifyId = L[0].id, y.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && S.push(O);
        }
      }
      if (S.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of u) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, y.push(v.id);
      break;
    }
    if (m || b.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : V.push(f.shortName);
    }
    if (f.workshopName) {
      const v = _e.state.config.workshopNameV2.find((N) => N.name === f.workshopName);
      A(v) ? f.workshopId = v.id : M.push(f.workshopName);
    }
    if (f.workshopName && f.warehouseName) {
      const v = _e.state.config.warehouseV2.find((N) => N.name === f.warehouseName);
      A(v) ? f.warehouseId = v.id : g.push(f.warehouseName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((f) => `“${f}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}仓库不存在`);
  if (g = Array.from(new Set(g)), g.length > 0) throw new Error(`${g.map((f) => `“${f}”`).join("、")}${g.length > 1 ? "等" : ""}存储位置不存在`);
  const h = _e.state.config.classifySpec, T = y.filter((f) => h[f] === void 0);
  T.length > 0 && (T.forEach((f) => {
    h[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", T));
  for (const f of E) {
    if (((_ = r == null ? void 0 : r[f.classifyId]) == null ? void 0 : _.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
    const m = h[f.classifyId];
    if (m.hasUnitConfig === false) throw new Error(`${f.classifyName}未配置核算单位`);
    let R;
    const v = f.material ?? "";
    if (m && Array.isArray(m.specList)) {
      for (const N of m.specList) if (v === N.spec) {
        R = N;
        break;
      }
    }
    if (R) {
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.classifySerialNumber = R.classify.serialNumber, f.serialNumber = R.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision;
      let N = 0;
      for (const P in c) Number(P) === f.classifyId && (N = c[P]);
      f.steelDensity = N, f.theoryWeight = await na({ classifyId: f.classifyId, name: f.classifyFullName, length: f.length, width: f.width, thickness: f.thickness }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight, (!f.unitPrice || !f.amount) && p$(f);
    } else throw new Error(`${f.classifyName}下不存在规格为“${v}”的材料，请联系管理员/仓库人员添加`);
  }
  return E;
} }, { handleMeteChangeCalcPrice: h$ } = ma("weighingTotalWeight"), Fd = vi[Ge.SECTION_STEEL.V], M3 = { title: "型材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "材质", field: "material", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Fd.length.precision, excelField: "__EMPTY_3" }, { label: "本次实收数（根）", field: "quantity", type: "number", precision: Fd.measure.precision, excelField: "__EMPTY_4" }, { label: "实收量（kg）", field: "weighingTotalWeight", type: "number", precision: Fd.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_9" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_13" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var T, _;
  if (!gi(e, M3.rules)) return;
  const n = await _a();
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const c = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.SECTION_STEEL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [], b = [], V = [], M = [];
  const g = [];
  if (r.forEach((f) => {
    let m = false;
    const R = pi(f.classifyName.split("/"));
    if (R.length === 1) {
      const v = c.filter((N) => N.name === f.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, f.classifyId = v[0].id, E.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, f.classifyId = P.id, E.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, f.classifyId = L[0].id, E.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && g.push(O);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of c) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, E.push(v.id);
      break;
    }
    if (m || y.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : b.push(f.shortName);
    }
    if (f.workshopName) {
      const v = _e.state.config.workshopNameV2.find((N) => N.name === f.workshopName);
      A(v) ? f.workshopId = v.id : V.push(f.workshopName);
    }
    if (f.workshopName && f.warehouseName) {
      const v = _e.state.config.warehouseV2.find((N) => N.name === f.warehouseName);
      A(v) ? f.warehouseId = v.id : M.push(f.warehouseName);
    }
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((f) => `“${f}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((f) => `“${f}”`).join("、")}${b.length > 1 ? "等" : ""}项目不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}仓库不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}存储位置不存在`);
  const S = _e.state.config.classifySpec, h = E.filter((f) => S[f] === void 0);
  h.length > 0 && (h.forEach((f) => {
    S[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const f of r) {
    if (((T = u == null ? void 0 : u[f.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
    const m = S[f.classifyId];
    if (m.hasUnitConfig === false) throw new Error(`${f.classifyName}未配置核算单位`);
    let R;
    const v = `${f.specification} * ${f.material}`;
    if (m && Array.isArray(m.specList)) {
      for (const N of m.specList) if (v === N.spec) {
        R = N;
        break;
      }
    }
    if (R) {
      const N = (_ = R.nationalStandardOptions.find((O) => O.boolDefault === true)) == null ? void 0 : _.standardId;
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.serialNumber = R.serialNumber, f.classifySerialNumber = R.classify.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision, f.unitWeight = R.unitWeight, f.nationalStandardOptions = R.nationalStandardOptions, f.standardId = N;
      let P;
      const L = [];
      for (const O in f.specificationMap) O.indexOf("standard") > -1 ? P = f.specificationMap[O] : L.push(f.specificationMap[O]);
      f.sectionSteelSpec = P, f.doNotSectionSteelSpec = L.join(" * "), f.theoryWeight = await xa({ length: f.length, unitWeight: f.unitWeight }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight, f$(f), (!f.unitPrice || !f.amount) && h$(f);
    } else throw new Error(`${f.classifyName}下不存在规格为“${v}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
function f$(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: g$ } = ma("weighingTotalWeight"), Uu = vi[Ge.STEEL_COIL.V], A3 = { title: "钢卷入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Uu.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Uu.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Uu.length.precision, excelField: "__EMPTY_4" }, { label: "实收重（kg）", field: "weighingTotalWeight", type: "number", precision: Uu.weight.precision, excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var T;
  if (!gi(e, A3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const c = _e.state.config.rawMatClsList.filter((_) => _.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [], b = [], V = [], M = [];
  const g = [];
  if (r.forEach((_) => {
    let f = false;
    const m = pi(_.classifyName.split("/"));
    if (m.length === 1) {
      const R = c.filter((v) => v.name === _.classifyName) || [];
      if (A(R)) if (R.length === 1) f = true, _.classifyId = R[0].id, E.push(R[0].id);
      else {
        const v = [];
        for (const P of R) if (P.isLeaf) for (let L = 0; L < P.fullPathId.length; L++) P.id !== P.fullPathId[L] && v.push(P.fullPathId[L]);
        const N = R.find((P) => Ae(P.parent) && !v.includes(P.id));
        if (A(N)) f = true, _.classifyId = N.id, E.push(N.id);
        else {
          const P = R.filter((L) => L.isLeaf) || [];
          if (P.length === 1) {
            let L = true;
            R.forEach((O) => {
              P[0].fullPathId.includes(O.id) || (L = false);
            }), L && (f = true, _.classifyId = P[0].id, E.push(P[0].id));
          } else for (const L of R) A(L.parent) && !v.includes(L.id) && g.push(L);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${_.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const R of c) if (R.fullPathName.length >= m.length && mi(R.fullPathName.slice(-m.length), m)) {
      f = true, _.classifyId = R.id, E.push(R.id);
      break;
    }
    if (f || y.push(_.classifyName), _.shortName) {
      const R = _e.state.project.projectAllType.find((v) => v.shortName === _.shortName);
      A(R) ? _.projectId = R.id : b.push(_.shortName);
    }
    if (_.workshopName) {
      const R = _e.state.config.workshopNameV2.find((v) => v.name === _.workshopName);
      A(R) ? _.workshopId = R.id : V.push(_.workshopName);
    }
    if (_.workshopName && _.warehouseName) {
      const R = _e.state.config.warehouseV2.find((v) => v.name === _.warehouseName);
      A(R) ? _.warehouseId = R.id : M.push(_.warehouseName);
    }
  }), y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((_) => `“${_}”`).join("、")}${y.length > 1 ? "等" : ""}物料种类不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((_) => `“${_}”`).join("、")}${b.length > 1 ? "等" : ""}项目不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((_) => `“${_}”`).join("、")}${V.length > 1 ? "等" : ""}仓库不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((_) => `“${_}”`).join("、")}${M.length > 1 ? "等" : ""}存储位置不存在`);
  const S = _e.state.config.classifySpec, h = E.filter((_) => S[_] === void 0);
  h.length > 0 && (h.forEach((_) => {
    S[_] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const _ of r) {
    if (((T = u == null ? void 0 : u[_.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${_.classifyName}不是末级科目`);
    const f = S[_.classifyId];
    if (f.hasUnitConfig === false) throw new Error(`${_.classifyName}未配置核算单位`);
    let m;
    const R = _.material ?? "";
    if (f && Array.isArray(f.specList)) {
      for (const v of f.specList) if (R === v.spec) {
        m = v;
        break;
      }
    }
    if (m) {
      _.uid = Tt(), _.sn = m.sn, _.specificationLabels = m.specificationLabels, _.serialNumber = m.serialNumber, _.classifySerialNumber = m.classify.serialNumber, _.classifyId = m.classify.id, _.classifyFullName = m.classify.fullName, _.classifyName = m.classify.name, _.classifyParentFullName = m.classify.parentFullName, _.basicClass = m.classify.basicClass, _.specification = m.spec, _.specificationMap = m.specKV, _.measureUnit = m.classify.measureUnit, _.accountingUnit = m.classify.accountingUnit, _.accountingPrecision = m.classify.accountingPrecision, _.measurePrecision = m.classify.measurePrecision;
      let v = 0;
      for (const N in n) Number(N) === _.classifyId && (v = n[N]);
      _.steelDensity = v, await E$(_), _.length = _.length ? St(_.length, "mm", "m") : _.theoryLength, (!_.unitPrice || !_.amount) && g$(_);
    } else throw new Error(`${_.classifyName}下不存在规格为“${R}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
async function E$(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const { handleMeteChangeCalcPrice: y$ } = ma("mete"), bm = { title: "辅材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_4" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_11" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, bm.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0), (!T.unitPrice || !T.amount) && y$(T);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, { handleMeteChangeCalcPrice: T$ } = ma("mete"), N3 = { title: "其它入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_4" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_11" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, N3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0), (!T.unitPrice || !T.amount) && T$(T);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, { handleMeteChangeCalcPrice: _$ } = ma("mete"), L3 = { title: "其它钢材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "本次实收数", field: "quantity", type: "number", excelField: "__EMPTY_2" }, { label: "本次实收量", field: "mete", type: "number", excelField: "__EMPTY_3" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_4" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目", field: "shortName", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "唯一标识", field: "uniqueIdentification", excelField: "__EMPTY_12" }], rules: { uniqueIdentification: [{ required: true, message: "唯一标识不能为空" }], classifyName: [{ required: true, message: "物料种类不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, L3.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2");
  const n = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [], b = [], V = [];
  const M = [];
  if (u.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || E.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : y.push(T.shortName);
    }
    if (T.workshopName) {
      const m = _e.state.config.workshopNameV2.find((R) => R.name === T.workshopName);
      A(m) ? T.workshopId = m.id : b.push(T.workshopName);
    }
    if (T.workshopName && T.warehouseName) {
      const m = _e.state.config.warehouseV2.find((R) => R.name === T.warehouseName);
      A(m) ? T.warehouseId = m.id : V.push(T.warehouseName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((T) => `“${T}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((T) => `“${T}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  if (b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}仓库不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}存储位置不存在`);
  const g = _e.state.config.classifySpec, S = r.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of u) {
    if (((h = c == null ? void 0 : c[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.specification ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        if (f = R, T.measureUnit) {
          if (!f.classify.measureUnit) throw new Error(`${T.classifyName}不存在计量单位`);
          if (!await ti(f.classify.measureUnit, T.measureUnit)) throw new Error(`${T.classifyName}填写的计量单位错误，单位应为：“${f.classify.measureUnit}”`);
        }
        if (T.accountingUnit && !await ti(f.classify.accountingUnit, T.accountingUnit)) throw new Error(`${T.classifyName}填写的核算单位错误，单位应为：“${f.classify.accountingUnit}”`);
        break;
      }
    }
    if (f) T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullPathId = f.classify.fullPathId, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision, T.measureUnit || (T.quantity = void 0), T.quantity && (T.quantity = Be(T.quantity, T.measurePrecision)), T.mete && (T.mete = Be(T.mete, T.accountingPrecision)), T.measureUnit || (T.quantity = void 0), (!T.unitPrice || !T.amount) && _$(T);
    else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, yd = { __name: "price-set-columns", props: { weightAttribute: { type: String, default: "weighingTotalWeight" }, isRequiredIdentifier: { type: Boolean, default: false } }, setup(e) {
  const o = e, { handleUnitPriceChange: n, handleAmountChange: c } = Al(o.weightAttribute);
  return (u, r) => {
    const E = Ve("common-input-number"), y = vt;
    return w(), Q(Qe, null, [s(y, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, Zl({ default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.unitPrice, "onUpdate:modelValue": (V) => b.unitPrice = V, controls: false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (V) => l(n)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : H("", true)]), _: 2 }, [e.isRequiredIdentifier ? { name: "header", fn: p(() => [r[0] || (r[0] = C("span", { style: { color: "red" } }, "*", -1)), r[1] || (r[1] = Te("含税单价 "))]), key: "0" } : void 0]), 1024), s(y, { align: "center", label: "含税金额", prop: "amount", width: "135px" }, Zl({ default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.amount, "onUpdate:modelValue": (V) => b.amount = V, controls: false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "含税金额", size: "default", onChange: (V) => l(c)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : H("", true)]), _: 2 }, [e.isRequiredIdentifier ? { name: "header", fn: p(() => [r[2] || (r[2] = C("span", { style: { color: "red" } }, "*", -1)), r[3] || (r[3] = Te("含税金额 "))]), key: "0" } : void 0]), 1024)], 64);
  };
} }, b$ = Object.freeze(Object.defineProperty({ __proto__: null, default: yd }, Symbol.toStringTag, { value: "Module" })), I3 = { __name: "import-amount-error-fix-dialog", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, amountRules: { type: Object, default: () => {
} }, list: { type: Array, default: () => [] } }, emits: ["success", "update:visible", "apply"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z([]), r = Ee(() => [...Da, ["remark", "empty-text"]]), E = Z([]), { visible: y, handleClose: b } = Ta({ emit: n, props: c, field: "visible", showHook: S }), { tableValidate: V, wrongCellMask: M } = ui({ rules: Ee(() => c.amountRules) }), { maxHeight: g } = Kt({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300 }, y);
  function S() {
    E.value = c.list;
  }
  async function h() {
    const { validResult: T } = V(E.value);
    T && (n("apply", c.list), b());
  }
  return (T, _) => {
    const f = Ve("common-button"), m = Ve("common-table"), R = Ve("common-dialog");
    return w(), U(R, { modelValue: l(y), "onUpdate:modelValue": _[1] || (_[1] = (v) => Gt(y) ? y.value = v : null), "before-close": l(b), "show-close": false, "close-on-click-modal": false, width: "1500px", "custom-class": "import-amount-error-fix-dialog", title: "批量导入-金额修复" }, { titleRight: p(() => [s(f, { size: "default", type: "warning", onClick: l(b) }, { default: p(() => _[2] || (_[2] = [Te("取消导入")])), _: 1, __: [2] }, 8, ["onClick"]), s(f, { size: "default", type: "primary", onClick: h }, { default: p(() => _[3] || (_[3] = [Te("应 用")])), _: 1, __: [3] })]), default: p(() => [s(m, { data: E.value, "cell-class-name": l(M), "return-source-data": "", "data-format": r.value, "max-height": l(g), "expand-row-keys": u.value, "row-key": "id" }, { default: p(() => [s(Ha, { data: E.value, "expand-row-keys": u.value, "onUpdate:expandRowKeys": _[0] || (_[0] = (v) => u.value = v), "row-key": "id", fixed: "left" }, { default: p(({ row: v }) => [C("p", null, [_[4] || (_[4] = Te(" 备注：")), C("span", null, K(v.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(fa, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(za, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(yd, { weightAttribute: "mete" }), s(Ba, { "basic-class": e.basicClass }, null, 8, ["basic-class"])]), _: 1 }, 8, ["data", "cell-class-name", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, V$ = Object.freeze(Object.defineProperty({ __proto__: null, default: I3 }, Symbol.toStringTag, { value: "Module" })), { handleMeteChangeCalcPrice: w$ } = ma("weighingTotalWeight"), Yu = vi[Ge.STEEL_COIL.V];
function Yb(e, o) {
  return Number(e) >= 0;
}
function S$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "钢卷期初入库清单-错误清单", sheetName: "错误清单" });
}
const C3 = { title: "钢卷期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Yu.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Yu.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Yu.length.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Yu.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_9" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_10" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_11" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_12" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_13" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: Yb, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: Yb, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var m;
  if (!gi(e, C3.rules)) return;
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const c = _e.state.config.rawMatClsList.filter((R) => R.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [], V = [], M = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const g = _e.state.config.workshopNameV2, S = _e.state.config.warehouseV2, T = _e.state.project.userProjectsMap[Ot].map((R) => (R.fullName = di(R, null, false), R));
  r.forEach((R, v) => {
    let N = false;
    const P = pi(R.classifyName.split("/"));
    if (P.length === 1) {
      const O = c.filter((x) => x.name === R.classifyName) || [];
      if (A(O)) if (O.length === 1) N = true, R.classifyId = O[0].id, E.push(O[0].id);
      else {
        const x = [];
        for (const Y of O) if (Y.isLeaf) for (let ee = 0; ee < Y.fullPathId.length; ee++) Y.id !== Y.fullPathId[ee] && x.push(Y.fullPathId[ee]);
        const I = O.find((Y) => Ae(Y.parent) && !x.includes(Y.id));
        if (A(I)) N = true, R.classifyId = I.id, E.push(I.id);
        else {
          const Y = O.filter((ee) => ee.isLeaf) || [];
          if (Y.length === 1) {
            let ee = true;
            O.forEach((B) => {
              Y[0].fullPathId.includes(B.id) || (ee = false);
            }), ee && (N = true, R.classifyId = Y[0].id, E.push(Y[0].id));
          } else for (const ee of O) A(ee.parent) && !x.includes(ee.id) && b.push(ee);
        }
      }
      b.length > 1 && M.push({ rowIndex: v + 1, error: `科目名称"${R.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const O of c) if (O.fullPathName.length >= P.length && mi(O.fullPathName.slice(-P.length), P)) {
      N = true, R.classifyId = O.id, E.push(O.id);
      break;
    }
    N || (y.push(R.classifyName), V.some((O) => O.classifyName === R.classifyName) || V.push({ rowIndex: v + 1, classifyName: R.classifyName }));
    const L = Ge.STEEL_COIL.V;
    eo(R, v, { workshopNameV2List: g, warehouseV2List: S, arr: T, errorList: M, basicClass: L });
  }), y = Array.from(new Set(y)), y.length > 0 && (M.push({ rowIndex: V[0].rowIndex, error: `${V.map((R) => `"${R.classifyName}"`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在` }), V.shift());
  const _ = _e.state.config.classifySpec, f = [];
  for (let R = 0; R < E.length; R++) _[E[R]] === void 0 && !f.includes(E[R]) && f.push(E[R]);
  f.length > 0 && (f.forEach((R) => {
    _[R] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", f));
  for (const R of r) {
    if (((m = u == null ? void 0 : u[R.classifyId]) == null ? void 0 : m.isLeaf) === false) {
      M.push({ rowIndex: r.indexOf(R) + 1, error: `${R.classifyName}不是末级科目` });
      continue;
    }
    const v = _[R.classifyId];
    if ((v == null ? void 0 : v.hasUnitConfig) === false) {
      M.push({ rowIndex: r.indexOf(R) + 1, error: `${R.classifyName}未配置核算单位` });
      continue;
    }
    let N;
    const P = R.material ?? "";
    if (v && Array.isArray(v.specList)) {
      for (const L of v.specList) if (P === L.spec) {
        N = L;
        break;
      }
    }
    if (N) {
      R.uid = Tt(), R.sn = N.sn, R.specificationLabels = N.specificationLabels, R.serialNumber = N.serialNumber, R.classifySerialNumber = N.classify.serialNumber, R.classifyId = N.classify.id, R.classifyFullName = N.classify.fullName, R.classifyName = N.classify.name, R.classifyParentFullName = N.classify.parentFullName, R.basicClass = N.classify.basicClass, R.specification = N.spec, R.specificationMap = N.specKV, R.measureUnit = N.classify.measureUnit, R.accountingUnit = N.classify.accountingUnit, R.accountingPrecision = N.classify.accountingPrecision, R.measurePrecision = N.classify.measurePrecision;
      let L = 0;
      for (const O in n) Number(O) === R.classifyId && (L = n[O]);
      R.steelDensity = L, await v$(R), R.length = R.length || R.theoryLength, (!R.unitPrice || !R.amount) && w$(R);
    } else {
      const L = `${R.classifyName}下不存在规格为"${P}"的材料，请联系管理员/仓库人员添加`;
      M.some((O) => O.error === L) || M.push({ rowIndex: r.indexOf(R) + 1, error: L });
      continue;
    }
  }
  if (M.length > 0) S$(M);
  else return r;
} };
async function v$(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const { handleMeteChangeCalcPrice: R$ } = ma("mete");
function Kb(e, o) {
  return Number(e) >= 0;
}
function M$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "其他钢材期初入库清单-错误清单", sheetName: "错误清单" });
}
const P3 = { title: "其它钢材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: Kb, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: Kb, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, P3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const M = _e.state.project.userProjectsMap, g = _e.state.config.workshopNameV2, S = _e.state.config.warehouseV2, h = M[Ot].map((m) => (m.fullName = di(m, null, false), m));
  u.forEach((m, R) => {
    let v = false;
    const N = pi(m.classifyName.split("/"));
    if (N.length === 1) {
      const L = n.filter((O) => O.name === m.classifyName) || [];
      if (A(L)) if (L.length === 1) v = true, m.classifyId = L[0].id, r.push(L[0].id);
      else {
        const O = [];
        for (const I of L) if (I.isLeaf) for (let Y = 0; Y < I.fullPathId.length; Y++) I.id !== I.fullPathId[Y] && O.push(I.fullPathId[Y]);
        const x = L.find((I) => Ae(I.parent) && !O.includes(I.id));
        if (A(x)) v = true, m.classifyId = x.id, r.push(x.id);
        else {
          const I = L.filter((Y) => Y.isLeaf) || [];
          if (I.length === 1) {
            let Y = true;
            L.forEach((ee) => {
              I[0].fullPathId.includes(ee.id) || (Y = false);
            }), Y && (v = true, m.classifyId = I[0].id, r.push(I[0].id));
          } else for (const Y of L) A(Y.parent) && !O.includes(Y.id) && y.push(Y);
        }
      }
      y.length > 1 && V.push({ rowIndex: R + 1, error: `科目名称"${m.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const L of n) if (L.fullPathName.length >= N.length && mi(L.fullPathName.slice(-N.length), N)) {
      v = true, m.classifyId = L.id, r.push(L.id);
      break;
    }
    v || (E.push(m.classifyName), b.some((L) => L.classifyName === m.classifyName) || b.push({ rowIndex: R + 1, classifyName: m.classifyName }));
    const P = Pe.OTHER_STEEL_MATERIALS.V;
    eo(m, R, { workshopNameV2List: g, warehouseV2List: S, arr: h, errorList: V, basicClass: P });
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((m) => `"${m.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const T = _e.state.config.classifySpec, _ = [];
  for (let m = 0; m < r.length; m++) T[r[m]] === void 0 && !_.includes(r[m]) && _.push(r[m]);
  _.length > 0 && (_.forEach((m) => {
    T[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", _));
  for (const m of u) {
    if (((f = c == null ? void 0 : c[m.classifyId]) == null ? void 0 : f.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不是末级科目` });
      continue;
    }
    const R = T[m.classifyId];
    if ((R == null ? void 0 : R.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}未配置核算单位` });
      continue;
    }
    let v;
    const N = m.specification ?? "";
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        if (v = P, m.measureUnit && (v.classify.measureUnit || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不存在计量单位` }), !await ti(v.classify.measureUnit, m.measureUnit))) {
          V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` });
          continue;
        }
        m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0), (!m.unitPrice || !m.amount) && R$(m);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) M$(V);
  else return u;
} }, { handleMeteChangeCalcPrice: A$ } = ma("mete");
function Wb(e, o) {
  return Number(e) >= 0;
}
function N$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "辅材期初入库清单-错误清单", sheetName: "错误清单" });
}
const O3 = { title: "辅材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: Wb, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: Wb, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, O3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Pe.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const M = _e.state.config.workshopNameV2, g = _e.state.config.warehouseV2, h = _e.state.project.userProjectsMap[Ot].map((m) => (m.fullName = di(m, null, false), m));
  u.forEach((m, R) => {
    let v = false;
    const N = pi(m.classifyName.split("/"));
    if (N.length === 1) {
      const L = n.filter((O) => O.name === m.classifyName) || [];
      if (A(L)) if (L.length === 1) v = true, m.classifyId = L[0].id, r.push(L[0].id);
      else {
        const O = [];
        for (const I of L) if (I.isLeaf) for (let Y = 0; Y < I.fullPathId.length; Y++) I.id !== I.fullPathId[Y] && O.push(I.fullPathId[Y]);
        const x = L.find((I) => Ae(I.parent) && !O.includes(I.id));
        if (A(x)) v = true, m.classifyId = x.id, r.push(x.id);
        else {
          const I = L.filter((Y) => Y.isLeaf) || [];
          if (I.length === 1) {
            let Y = true;
            L.forEach((ee) => {
              I[0].fullPathId.includes(ee.id) || (Y = false);
            }), Y && (v = true, m.classifyId = I[0].id, r.push(I[0].id));
          } else for (const Y of L) A(Y.parent) && !O.includes(Y.id) && y.push(Y);
        }
      }
      y.length > 1 && V.push({ rowIndex: R + 1, error: `科目名称"${m.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const L of n) if (L.fullPathName.length >= N.length && mi(L.fullPathName.slice(-N.length), N)) {
      v = true, m.classifyId = L.id, r.push(L.id);
      break;
    }
    v || (E.push(m.classifyName), b.some((L) => L.classifyName === m.classifyName) || b.push({ rowIndex: R + 1, classifyName: m.classifyName }));
    const P = Pe.MATERIAL.V;
    eo(m, R, { workshopNameV2List: M, warehouseV2List: g, arr: h, errorList: V, basicClass: P });
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((m) => `"${m.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const T = _e.state.config.classifySpec, _ = [];
  for (let m = 0; m < r.length; m++) T[r[m]] === void 0 && !_.includes(r[m]) && _.push(r[m]);
  _.length > 0 && (_.forEach((m) => {
    T[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", _));
  for (const m of u) {
    if (((f = c == null ? void 0 : c[m.classifyId]) == null ? void 0 : f.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不是末级科目` });
      continue;
    }
    const R = T[m.classifyId];
    if ((R == null ? void 0 : R.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}未配置核算单位` });
      continue;
    }
    let v;
    const N = m.specification ?? "";
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        v = P, m.measureUnit && (v.classify.measureUnit || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不存在计量单位` }), await ti(v.classify.measureUnit, m.measureUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` })), m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0), (!m.unitPrice || !m.amount) && A$(m);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) N$(V);
  else return u;
} };
function jb(e, o) {
  return Number(e) >= 0;
}
function L$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "办公用品期初入库清单-错误清单", sheetName: "错误清单" });
}
const k3 = { title: "办公用品期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "含税金额", field: "amount", excelField: "__EMPTY_8" }, { label: "不含税金额", field: "amountExcludingVatFreight", excelField: "__EMPTY_9" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_10" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_11" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], amount: [{ required: true, message: "含税金额不能为空" }, { validator: jb, message: "含税金额不能小于0" }], amountExcludingVatFreight: [{ required: true, message: "不含税金额不能为空" }, { validator: jb, message: "不含税金额不能小于0" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, k3.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  _e.state.config.loaded.workshopNameV2 || await _e.dispatch("config/fetchWorkshopNameV2"), _e.state.config.loaded.warehouseV2 || await _e.dispatch("config/fetchWarehouseV2"), _e.state.project.loaded || await _e.dispatch("project/fetchUserProjects");
  const M = _e.state.config.workshopNameV2, g = _e.state.config.warehouseV2, h = _e.state.project.userProjectsMap[Ot].map((m) => (m.fullName = di(m, null, false), m));
  u.forEach((m, R) => {
    let v = false;
    const N = pi(m.classifyName.split("/"));
    if (N.length === 1) {
      const L = n.filter((O) => O.name === m.classifyName) || [];
      if (A(L)) if (L.length === 1) v = true, m.classifyId = L[0].id, r.push(L[0].id);
      else {
        const O = [];
        for (const I of L) if (I.isLeaf) for (let Y = 0; Y < I.fullPathId.length; Y++) I.id !== I.fullPathId[Y] && O.push(I.fullPathId[Y]);
        const x = L.find((I) => Ae(I.parent) && !O.includes(I.id));
        if (A(x)) v = true, m.classifyId = x.id, r.push(x.id);
        else {
          const I = L.filter((Y) => Y.isLeaf) || [];
          if (I.length === 1) {
            let Y = true;
            L.forEach((ee) => {
              I[0].fullPathId.includes(ee.id) || (Y = false);
            }), Y && (v = true, m.classifyId = I[0].id, r.push(I[0].id));
          } else for (const Y of L) A(Y.parent) && !O.includes(Y.id) && y.push(Y);
        }
      }
      y.length > 1 && V.push({ rowIndex: R + 1, error: `科目名称"${m.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const L of n) if (L.fullPathName.length >= N.length && mi(L.fullPathName.slice(-N.length), N)) {
      v = true, m.classifyId = L.id, r.push(L.id);
      break;
    }
    v || (E.push(m.classifyName), b.some((L) => L.classifyName === m.classifyName) || b.push({ rowIndex: R + 1, classifyName: m.classifyName }));
    const P = Ge.OTHER.V;
    eo(m, R, { workshopNameV2List: M, warehouseV2List: g, arr: h, errorList: V, basicClass: P });
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((m) => `"${m.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const T = _e.state.config.classifySpec, _ = [];
  for (let m = 0; m < r.length; m++) T[r[m]] === void 0 && !_.includes(r[m]) && _.push(r[m]);
  _.length > 0 && (_.forEach((m) => {
    T[m] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", _));
  for (const m of u) {
    if (((f = c == null ? void 0 : c[m.classifyId]) == null ? void 0 : f.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不是末级科目` });
      continue;
    }
    const R = T[m.classifyId];
    if ((R == null ? void 0 : R.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}未配置核算单位` });
      continue;
    }
    let v;
    const N = m.specification ?? "";
    if (R && Array.isArray(R.specList)) {
      for (const P of R.specList) if (N === P.spec) {
        v = P, m.measureUnit && (v.classify.measureUnit || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不存在计量单位` }), await ti(v.classify.measureUnit, m.measureUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` })), m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) L$(V);
  else return u;
} };
function I$(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "气体期初入库清单-错误清单", sheetName: "错误清单" });
}
