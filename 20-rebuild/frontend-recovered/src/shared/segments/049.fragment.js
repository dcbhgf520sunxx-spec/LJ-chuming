const rH = { class: "aux-mat-requisitions-application-container" }, uH = { class: "filter-container" }, cH = { class: "filter-right-box" }, dH = { class: "filter-item" }, mH = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(e, { expose: o, emit: n }) {
  Ht();
  const c = n, u = e, r = { list: [], originInventoryInfo: {} }, E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z({}), S = Z(), h = Z(false), T = Ge.OTHER.V, _ = Z({});
  yi("useInventoryInfo", _), yi("matSpecRef", y);
  const { cu: f, form: m, FORM: R } = Pa({ title: "其它申购", defaultForm: r, clearDraftCallback: B, api: u.isEdit ? nn.edit : nn.add }, b, u.detail), v = Ee(() => {
    var oe;
    let j = [], le = [];
    return A(m.list) && (j = JSON.parse(JSON.stringify(m.list)), le = (oe = Array.from(new Set(j == null ? void 0 : j.map((ye) => ye.classifyId)))) == null ? void 0 : oe.map((ye) => j == null ? void 0 : j.find((ce) => ce.classifyId === ye))), le.length;
  }), N = Ee(() => {
    var j;
    return (j = m.list) == null ? void 0 : j.filter((le) => {
      var oe, ye;
      return (ye = (oe = f == null ? void 0 : f.submitResult) == null ? void 0 : oe.data) == null ? void 0 : ye.includes(le.classifyId);
    });
  });
  Ce(() => u.detail, (j = {}) => {
    m.materialType = j.materialType, m.branchCompanyId = j.branchCompanyId, m.level = j.level, m.serialNumber = j.serialNumber;
  }, { deep: true, immediate: true });
  const { maxHeight: P } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => V.value.loaded), { maxHeight: L } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: u.isTsData ? 0 : 200 });
  B(), Dt(() => {
    var j;
    if ((j = m.list) != null && j.length) {
      const le = {};
      for (let oe = 0; oe < m.list.length; oe++) {
        const ye = m.list[oe];
        ye.requisitionMode === Ui.USE_INVENTORY.V && (le[ye.materialInventoryId] ? le[ye.materialInventoryId] += ye.quantity : le[ye.materialInventoryId] = ye.quantity);
      }
      _.value = le;
    }
  }), R.HOOK.afterSubmit = () => {
    c("success"), B();
  };
  function O(j, le) {
    g.value = j, S.value = le, M.value = true;
  }
  function x(j, le) {
    const oe = le.id;
    m.originInventoryInfo || (m.originInventoryInfo = {}), m.originInventoryInfo[oe] = { quantity: le.quantity, frozenQuantity: le.frozenQuantity }, m.list[S.value].quantity = j, m.list[S.value].canUseQuantity = le.quantity, m.list[S.value].color = le.color, m.list[S.value].brand = le.brand, m.list[S.value].unitNet = le.unitNet, m.list[S.value].mete = le.quantity * le.unitNet, m.list[S.value].requisitionMode = Ui.USE_INVENTORY.V, m.list[S.value].materialInventoryId = oe;
  }
  function I() {
    return Ae(m.branchCompanyId) ? (ot.warning("请选择申购单位"), false) : A(N.value) ? (ot.error("请先删除标红数据并重新添加"), false) : E.value ? E.value.validate() : true;
  }
  function Y() {
    return E.value ? E.value.TSValidate() : true;
  }
  function ee(j) {
    return E.value.rowInit(j);
  }
  function B() {
    y.value && y.value.clear();
  }
  function q() {
    var j;
    if (A(N.value) && A((j = f == null ? void 0 : f.submitResult) == null ? void 0 : j.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    h.value = true;
  }
  function ae(j) {
    var le;
    try {
      (le = f == null ? void 0 : f.submitResult) != null && le.data && (f.submitResult.data = null), f.props.import(j);
    } catch (oe) {
      ot.error({ message: oe.message, duration: 5e3 });
    }
  }
  return f.props.import = (j) => {
    m.list.push.apply(m.list, j);
    const le = Ce(y, () => {
      y.value && (y.value.initSelected(j.map((oe) => ({ sn: oe.sn, classifyId: oe.classifyId }))), pt(() => {
        le();
      }));
    }, { immediate: true });
  }, o({ form: m, TSValidateTable: Y }), (j, le) => {
    const oe = Ve("common-button"), ye = jt, ce = Li, se = Ve("common-drawer");
    return w(), Q("div", rH, [s(wr, { "basic-class": l(T), isTsData: e.isTsData, "show-total": false, validate: I }, { default: p(() => {
      var he, be;
      return [C("div", uH, [C("div", cH, [C("div", dH, [s(_u, { "right-label": v.value, "show-unit": "" }, null, 8, ["right-label"])]), s(oe, { class: "filter-item", type: "success", onClick: q }, { default: p(() => le[3] || (le[3] = [Te(" 添加物料 ")])), _: 1, __: [3] }), s(ye, { content: "请删除全部标红数据", disabled: !(l(A)(N.value) && l(A)((be = (he = l(f)) == null ? void 0 : he.submitResult) == null ? void 0 : be.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Ro, { template: l(Z_), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: ae }, null, 8, ["template"])]), _: 1 }, 8, ["disabled"]), s(ia, { fn: l(uu), params: { basicClass: l(T), receiptType: l(It).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: p(() => le[4] || (le[4] = [Te(" 办公用品清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), s(ce, { ref_key: "formRef", ref: b, model: l(m) }, { default: p(() => [s(dd, { ref_key: "tableRef", ref: E, "max-height": l(L), onSearchInventory: O }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "isTsData"]), s(se, { ref_key: "drawerRef", ref: V, modelValue: h.value, "onUpdate:modelValue": le[1] || (le[1] = (he) => h.value = he), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [s(to, { ref_key: "matSpecRef", ref: y, modelValue: l(m).list, "onUpdate:modelValue": le[0] || (le[0] = (he) => l(m).list = he), "basic-class": l(T), "max-height": l(P), "row-init-fn": ee, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), s(l(Tu), { visible: M.value, "onUpdate:visible": le[2] || (le[2] = (he) => M.value = he), params: g.value, onUseInventory: x }, null, 8, ["visible", "params"])]);
  };
} }, Bv = ut(mH, [["__scopeId", "data-v-c2609559"]]), pH = Object.freeze(Object.defineProperty({ __proto__: null, default: Bv }, Symbol.toStringTag, { value: "Module" }));
const hH = { class: "aux-mat-requisitions-application-container" }, fH = { class: "filter-container" }, gH = { class: "filter-right-box" }, EH = { class: "filter-item" }, yH = { __name: "index", props: { detail: { type: Object }, isEdit: { type: Boolean, default: false }, isTsData: { type: Boolean, default: false } }, emits: ["success"], setup(e, { expose: o, emit: n }) {
  Ht();
  const c = n, u = e, r = { list: [], originInventoryInfo: {} }, E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z({}), S = Z(), h = Z(false), T = Ge.GAS.V, _ = Z({});
  yi("useInventoryInfo", _), yi("matSpecRef", y);
  const { cu: f, form: m, FORM: R } = Pa({ title: "气体申购", defaultForm: r, clearDraftCallback: B, api: u.isEdit ? nn.edit : nn.add }, b, u.detail);
  Ce(() => u.detail, (j = {}) => {
    m.materialType = j.materialType, m.branchCompanyId = j.branchCompanyId, m.level = j.level, m.serialNumber = j.serialNumber;
  }, { deep: true, immediate: true });
  const { maxHeight: v } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => V.value.loaded), { maxHeight: N } = Kt({ mainBox: ".requisitions-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".requisitions-application-header", ".requisitions-application-select", ".requisitions-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: u.isTsData ? 0 : 200 }), P = Ee(() => {
    var oe;
    let j = [], le = [];
    return A(m.list) && (j = JSON.parse(JSON.stringify(m.list)), le = (oe = Array.from(new Set(j == null ? void 0 : j.map((ye) => ye.classifyId)))) == null ? void 0 : oe.map((ye) => j == null ? void 0 : j.find((ce) => ce.classifyId === ye))), le.length;
  }), L = Ee(() => {
    var j;
    return (j = m.list) == null ? void 0 : j.filter((le) => {
      var oe, ye;
      return (ye = (oe = f == null ? void 0 : f.submitResult) == null ? void 0 : oe.data) == null ? void 0 : ye.includes(le.classifyId);
    });
  });
  B(), Dt(() => {
    var j;
    if ((j = m.list) != null && j.length) {
      const le = {};
      for (let oe = 0; oe < m.list.length; oe++) {
        const ye = m.list[oe];
        ye.requisitionMode === Ui.USE_INVENTORY.V && (le[ye.materialInventoryId] ? le[ye.materialInventoryId] += ye.quantity : le[ye.materialInventoryId] = ye.quantity);
      }
      _.value = le;
    }
  }), R.HOOK.afterSubmit = () => {
    c("success"), B();
  };
  function O(j, le) {
    g.value = j, S.value = le, M.value = true;
  }
  function x(j, le) {
    const oe = le.id;
    m.originInventoryInfo || (m.originInventoryInfo = {}), m.originInventoryInfo[oe] = { quantity: le.quantity, frozenQuantity: le.frozenQuantity }, m.list[S.value].quantity = j, m.list[S.value].canUseQuantity = le.quantity, m.list[S.value].color = le.color, m.list[S.value].brand = le.brand, m.list[S.value].unitNet = le.unitNet, m.list[S.value].mete = le.quantity * le.unitNet, m.list[S.value].requisitionMode = Ui.USE_INVENTORY.V, m.list[S.value].materialInventoryId = oe;
  }
  function I() {
    return Ae(m.branchCompanyId) ? (ot.warning("请选择申购单位"), false) : A(L.value) ? (ot.error("请先删除标红数据并重新添加"), false) : E.value ? E.value.validate() : true;
  }
  function Y() {
    return E.value ? E.value.TSValidate() : true;
  }
  function ee(j) {
    return E.value.rowInit(j);
  }
  function B() {
    y.value && y.value.clear();
  }
  function q() {
    if (A(L.value)) return ot.error("请先删除标红数据并重新添加"), false;
    h.value = true;
  }
  function ae(j) {
    var le;
    try {
      (le = f == null ? void 0 : f.submitResult) != null && le.data && (f.submitResult.data = null), f.props.import(j);
    } catch (oe) {
      ot.error({ message: oe.message, duration: 5e3 });
    }
  }
  return f.props.import = (j) => {
    m.list.push.apply(m.list, j);
    const le = Ce(y, () => {
      y.value && (y.value.initSelected(j.map((oe) => ({ sn: oe.sn, classifyId: oe.classifyId }))), pt(() => {
        le();
      }));
    }, { immediate: true });
  }, o({ form: m, TSValidateTable: Y }), (j, le) => {
    const oe = Ve("common-button"), ye = Li, ce = Ve("common-drawer");
    return w(), Q("div", hH, [s(wr, { "basic-class": l(T), isTsData: e.isTsData, "show-total": false, validate: I }, { default: p(() => [C("div", fH, [C("div", gH, [C("div", EH, [s(_u, { "right-label": P.value, "show-unit": "" }, null, 8, ["right-label"])]), s(oe, { class: "filter-item", type: "success", onClick: q }, { default: p(() => le[3] || (le[3] = [Te(" 添加物料 ")])), _: 1, __: [3] }), s(Ro, { template: l(Z_), "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", onSuccess: ae }, null, 8, ["template"]), s(ia, { fn: l(uu), params: { basicClass: l(T), receiptType: l(It).REQUISITIONS.V }, class: "filter-item", size: "default", type: "info" }, { default: p(() => le[4] || (le[4] = [Te(" 气体清单模板下载 ")])), _: 1, __: [4] }, 8, ["fn", "params"])])]), s(ye, { ref_key: "formRef", ref: b, model: l(m) }, { default: p(() => [s(dd, { ref_key: "tableRef", ref: E, "max-height": l(N), onSearchInventory: O }, null, 8, ["max-height"])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["basic-class", "isTsData"]), s(ce, { ref_key: "drawerRef", ref: V, modelValue: h.value, "onUpdate:modelValue": le[1] || (le[1] = (se) => h.value = se), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [s(to, { ref_key: "matSpecRef", ref: y, modelValue: l(m).list, "onUpdate:modelValue": le[0] || (le[0] = (se) => l(m).list = se), "basic-class": l(T), "max-height": l(v), "row-init-fn": ee, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), s(l(Tu), { visible: M.value, "onUpdate:visible": le[2] || (le[2] = (se) => M.value = se), params: g.value, onUseInventory: x }, null, 8, ["visible", "params"])]);
  };
} }, Hv = ut(yH, [["__scopeId", "data-v-ccacd4a1"]]), TH = Object.freeze(Object.defineProperty({ __proto__: null, default: Hv }, Symbol.toStringTag, { value: "Module" })), qv = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.branchCompanyEnum);
  if (n.value || o.dispatch("config/fetchBranchCompanyEnumConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { branchCompanyEnum: Ee(() => o.state.config.branchCompanyEnum), loaded: n };
}, _H = { class: "customize-option-item" }, bH = { class: "label" }, J_ = { __name: "branch-company-select-v3", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择公司主体" }, defaultLevel: { type: [Number, String], default: void 0 }, showExtra: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false } }, emits: ["update:modelValue", "change", "currentChange"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { loaded: r, branchCompanyEnum: E } = qv(), y = Ee(() => {
    let V = E.value;
    return c.defaultLevel && (V = V.filter((M) => M.level === c.defaultLevel)), V;
  });
  function b(V) {
    if (n("update:modelValue", V), n("change", V), V) {
      const M = y.value.find((g) => g.id === V) || {};
      n("currentChange", M);
    } else n("currentChange", {});
  }
  return Ce(() => c.modelValue, (V) => {
    u.value = V;
  }, { immediate: true }), (V, M) => {
    const g = Ve("common-select");
    return w(), U(g, ii({ modelValue: u.value, "onUpdate:modelValue": M[0] || (M[0] = (S) => u.value = S), allLabelText: "全部", clearable: e.clearable, disabled: e.disabled, loading: !l(r), multiple: e.multiple, options: y.value, placeholder: e.placeholder, showExtra: e.showExtra, showOptionAll: e.showOptionAll, size: e.size, filterable: "" }, V.$attrs, { onChange: b }), { view: p(({ data: S }) => [C("span", _H, [C("span", bH, K(S.name), 1)])]), _: 1 }, 16, ["modelValue", "clearable", "disabled", "loading", "multiple", "options", "placeholder", "showExtra", "showOptionAll", "size"]);
  };
} };
const VH = { class: "requisitions-application-select" }, wH = { __name: "form", props: { isTsData: { type: Boolean, default: false } }, emits: ["saveSuccess", "detailSuccess"], setup(e, { emit: o }) {
  const n = Ht(), c = o, u = e, r = { materialType: ct.STEEL.V, branchCompanyId: void 0, finishedProductType: Fa.STRUC_MANUFACTURED.V, arrivalTime: "", attachments: void 0, serialNumber: "", steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [], remark: "", level: void 0, list: [] }, E = Ee(() => {
    let P = [];
    return g.value && (V.materialType & ct.MANUFACTURED.V ? P = [ct.STEEL.V, ct.MATERIAL.V, ct.GAS.V, ct.OTHER.V] : P = [ct.MANUFACTURED.V]), P;
  }), { CRUD: y, crud: b, form: V } = An(r), M = Ee(() => b.status.cu > y.STATUS.NORMAL), g = Ee(() => b.status.edit > 0), S = Ee(() => !!(V.materialType & ct.MANUFACTURED.V)), h = Z(), T = Ee(() => u.isTsData ? true : !g.value), _ = Z(), f = Ee(() => {
    switch (V.materialType) {
      case ct.STEEL.V:
        return Yv;
      case ct.MATERIAL.V:
        return Wv;
      case ct.MANUFACTURED.V:
        return zv;
      case ct.OTHER.V:
        return Bv;
      case ct.GAS.V:
        return Hv;
      default:
        return;
    }
  }), { steelDensityCfg: m } = cn();
  yi("steelDensityCfg", m), y.HOOK.beforeEditDetailLoaded = async (P, L) => {
    var O;
    A(L.tsData) && Ae(L.detailList) && (L.detailList = JSON.parse(L.tsData)), await n.dispatch("wms/fetchSteelDensityCfg"), S.value ? (L.materialType & ct.MANUFACTURED.V && (L.materialType = ct.MANUFACTURED.V), (O = h.value) == null || O.refresh(), L.list = L.detailList.map((x) => (x.totalLength = St(Be(x.totalLength, Ft.LENGTH_DP), Ft.LENGTH, "m"), x.totalWeight = St(Be(x.totalWeight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), x.weight = St(Be(x.weight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), x.totalArea = St(Be(x.totalArea, Ft.AREA_DP), Ft.AREA, "m²"), x)), _.value = _s(L), _.value.list.forEach((x) => {
      x.name = x.manufacturedName, x.serialNumber = x.manufacturedSn, V.finishedProductType === Fa.STRUC_MANUFACTURED.V && (x.productId = x.artifactEnclosureId, x.netWeight = x.weight), V.finishedProductType === Fa.ENCL_MANUFACTURED.V && (x.id = x.artifactEnclosureId, x.category = x.manufacturedType);
    })) : (L.originInventoryInfo || (L.originInventoryInfo = {}), L.materialType & ct.STEEL.V && (L.materialType = ct.STEEL.V), L.list = L.detailList.map((x) => {
      var I, Y;
      return x.materialInventoryId ? (x.requisitionMode = Ui.USE_INVENTORY.V, L.originInventoryInfo[x.materialInventoryId] ? (L.originInventoryInfo[x.materialInventoryId].frozenQuantity -= x.quantity, L.originInventoryInfo[x.materialInventoryId].frozenQuantity < 0 && (L.originInventoryInfo[x.materialInventoryId].frozenQuantity = 0)) : L.originInventoryInfo[x.materialInventoryId] = { quantity: (I = x.materialFreezeNum) == null ? void 0 : I.quantity, frozenQuantity: ((Y = x.materialFreezeNum) == null ? void 0 : Y.frozenQuantity) - x.quantity }) : x.requisitionMode = Ui.PURCHASE.V, x;
    }), await Qt(L.list), L.list = await Ut(L.list, { toSmallest: false, toNum: true }));
  }, Ce(() => V.materialType, (P, L) => {
    P && L && P !== L && P !== ct.STEEL.V && (V.list = []), P === ct.MANUFACTURED.V && Ae(V.finishedProductType) && (V.finishedProductType = Fa.STRUC_MANUFACTURED.V), P !== ct.MANUFACTURED.V && (V.finishedProductType = void 0);
  });
  function R() {
    n.dispatch("approval_list/fetchApprovalNum"), n.dispatch("approval_list/fetchApprovalNum", at.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchSubNum", at.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchRejNum", at.REQUISITIONS_V2.V), b.cancelCU(), c("detailSuccess"), b.refresh();
  }
  function v(P) {
    V.branchCompany = P, V.level = P == null ? void 0 : P.level;
  }
  async function N() {
    h.value.TSValidateTable();
    const P = JSON.parse(JSON.stringify(h.value.form));
    P.materialType & ct.STEEL.V && (P.list = [...P.steelPlateList, ...P.sectionSteelList, ...P.steelCoilList], P.list.forEach((L) => {
      L.mete = L.weighingTotalWeight, L.weight = L.weighingTotalWeight;
    }), A(P.otherSteelMaterialList) && (P.list = [...P.list, ...P.otherSteelMaterialList])), A(P.list) ? (P.list = await Ut(P.list, { toSmallest: true, toNum: true }), A(P.attachments) && (P.attachmentIds = P.attachments.map((L) => L.id)), P.clickTime = n.state.config.getTreeClickTime, P.tsData = JSON.stringify(P.list), await f5(P).then(async (L) => {
      L === true && (ot.success("暂存成功"), c("saveSuccess"), R(), await n.dispatch("approval_list/fetchTSNum", at.REQUISITIONS_V2.V));
    })) : ot.error("请填写数据");
  }
  return (P, L) => {
    const O = Ve("common-button"), x = Ve("common-radio-button"), I = Mt, Y = Ve("common-drawer");
    return w(), U(Y, { ref: "drawerRef", "before-close": l(b).cancelCU, "content-loading": l(b).editDetailLoading, "show-close": true, title: l(b).status.title, visible: M.value, "custom-class": "requisitions-application-record-form", size: "100%" }, Zl({ titleRight: p(() => [l(Ai)(l(dD).scmTemporaryStoragePM.add) && T.value && !S.value ? (w(), U(O, { key: 0, class: "filter-item", size: "default", type: "warning", onClick: N }, { default: p(() => L[4] || (L[4] = [Te(" 暂存 ")])), _: 1, __: [4] })) : H("", true)]), _: 2 }, [M.value ? { name: "content", fn: p(() => [C("div", VH, [s(x, { modelValue: l(V).materialType, "onUpdate:modelValue": L[0] || (L[0] = (ee) => l(V).materialType = ee), disabledVal: E.value, options: l(ct).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabledVal", "options"]), S.value ? (w(), U(x, { key: 0, modelValue: l(V).finishedProductType, "onUpdate:modelValue": L[1] || (L[1] = (ee) => l(V).finishedProductType = ee), options: l(Fa).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])) : H("", true), s(J_, { modelValue: l(V).branchCompanyId, "onUpdate:modelValue": L[2] || (L[2] = (ee) => l(V).branchCompanyId = ee), disabled: !!l(V).boolUsed, class: "input-underline", clearable: "", placeholder: "请选择申购单位", style: { width: "240px" }, onCurrentChange: v }, null, 8, ["modelValue", "disabled"]), s(I, { modelValue: l(V).serialNumber, "onUpdate:modelValue": L[3] || (L[3] = (ee) => l(V).serialNumber = ee), modelModifiers: { trim: true }, disabled: !!l(V).boolUsed, class: "input-underline", maxlength: "30", style: { width: "240px" }, placeholder: "申购单号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), l(b).status.cu > l(y).STATUS.NORMAL ? (w(), U(Ri(f.value), { key: 0, ref_key: "applicationRef", ref: h, detail: l(V), formHistory: _.value, isEdit: g.value, isTsData: u.isTsData, onSuccess: R }, null, 40, ["detail", "formHistory", "isEdit", "isTsData"])) : H("", true)]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "title", "visible"]);
  };
} }, X_ = ut(wH, [["__scopeId", "data-v-31beab22"]]), SH = Object.freeze(Object.defineProperty({ __proto__: null, default: X_ }, Symbol.toStringTag, { value: "Module" }));
const vH = { class: "subscript" }, RH = { key: 0, class: "table-cell-triangle-frozen" }, MH = ["onClick"], AH = { key: 1, class: "text" }, NH = { __name: "index", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, showIndex: { type: Boolean, default: true }, showClassification: { type: Boolean, default: false }, showSerialNumber: { type: Boolean, default: true }, showProject: { type: Boolean, default: false }, showRejectStatus: { type: Boolean, default: false }, showPartyA: { type: Boolean, default: true }, showPartyATransfer: { type: Boolean, default: false }, partyAPosition: { type: String, default: "index" }, showIsWhole: { type: Boolean, default: false }, showOutboundMode: { type: Boolean, default: false }, showOddmentByHalfOut: { type: Boolean, default: false }, showFrozenTip: { type: Boolean, default: false }, frozenViewable: { type: Boolean, default: false }, rejectDetailViewable: { type: Boolean, default: false }, fixed: { type: String }, sortable: { type: Boolean, default: false }, warehouseSort: { type: Boolean, default: false }, returnSortable: { type: Boolean, default: false }, classifyNameAlias: { type: String, default: "物料种类" }, showTip: { type: Boolean, default: false }, specificationLable: { type: String, default: "规格" }, isSerialNumber: { type: Boolean, default: true } }, emits: ["refresh", "unfreeze-success"], setup(e, { emit: o }) {
  const n = o, c = e;
  ft("isBegin", false);
  const u = Z({}), r = Z(false), E = Z(false), y = Z(0), b = Ee(() => !!(c.basicClass & ho)), V = Ee(() => !c.basicClass || c.basicClass > ua ? 160 : 120), M = Ee(() => Ae(c.columns) || c.columns.visible("classifyName")), g = Ee(() => c.showSerialNumber && (Ae(c.columns) || c.columns.visible("serialNumber"))), S = Ee(() => c.frozenViewable && Ai(sd.frozenDetail)), h = Ee(() => c.sortable === true ? "custom" : false), { maxHeight: T } = Kt({ mainBox: ".wms-material-freeze-record-view", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => r.value || E.value));
  function _(v) {
    const N = v.sourceRow ? v.sourceRow : v;
    y.value = 0, u.value = JSON.parse(JSON.stringify(N)), r.value = true;
  }
  function f(v) {
    if (!c.rejectDetailViewable) return;
    const N = v.sourceRow ? v.sourceRow : v;
    u.value = JSON.parse(JSON.stringify(N)), E.value = true;
  }
  function m(v, N, P) {
    ++y.value, n("unfreeze-success", v, N, P);
  }
  function R(v) {
    y.value > 0 && n("refresh"), v();
  }
  return (v, N) => {
    var I;
    const P = Ve("table-cell-tag"), L = vt, O = jt, x = Ve("common-dialog");
    return w(), Q(Qe, null, [xt(v.$slots, "indexTag", {}, void 0, true), e.showIndex ? (w(), U(L, { key: 0, fixed: e.fixed, align: "center", label: "序号", type: "index", width: "55" }, { default: p(({ row: Y, $index: ee }) => [e.showPartyA && e.partyAPosition === "index" ? (w(), U(P, { key: 0, show: !!Y.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(ee + 1), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), xt(v.$slots, "afterIndex", {}, void 0, true), e.showProject ? (w(), U(L, { key: 1, fixed: e.fixed, prop: "project", align: "left", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [e.showPartyA && e.partyAPosition === "project" ? (w(), U(P, { key: 0, offset: 15, show: !!Y.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(Y.project), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), g.value ? (w(), U(L, { key: 2, fixed: e.fixed, prop: e.isSerialNumber ? "serialNumber" : "materialSn", sortable: h.value, align: "center", label: "物料编号", "min-width": "110px", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [xt(v.$slots, "snTag", { row: Y }, void 0, true), e.showPartyATransfer && Y.partyATransferType ? (w(), U(P, { key: 0, color: l(Mo).V[Y.partyATransferType].COLOR, name: l(Mo).VL[Y.partyATransferType], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showIsWhole && Y.materialIsWhole === l(Dl).ODDMENT.V ? (w(), U(P, { key: 1, color: l(Dl).V[Y.materialIsWhole].COLOR, name: l(Dl).VL[Y.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOddmentByHalfOut ? (w(), U(P, { key: 2, color: Y.outboundRelationType === l(gl).CUT.V || Y.outboundRelationType === l(gl).CUT_TRANSFER.V ? "#214283" : "#e6a23c", name: Y.outboundRelationType === l(gl).CUT.V || Y.outboundRelationType === l(gl).CUT_TRANSFER.V ? "切割半出" : "半出余料", show: !!Y.boolOddmentByHalfOut }, null, 8, ["color", "name", "show"])) : H("", true), e.showOutboundMode && Y.materialOutboundMode === l(Oa).HALF.V ? (w(), U(P, { key: 3, color: l(Oa).V[Y.materialOutboundMode].COLOR, name: l(Oa).VL[Y.materialOutboundMode], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOutboundMode && Y.basicClass & l(Ci).STEEL_COIL.V && Y.length ? (w(), U(P, { key: 4, name: Y.boolBasicClassChange ? "出至钢板库" : "条板出库", offset: 15, color: "#e6a23c" }, null, 8, ["name"])) : H("", true), e.showRejectStatus ? (w(), Q(Qe, { key: 5 }, [l(A)(Y.rejectStatus) && Y.rejectStatus !== l(Wl).NONE.V ? (w(), U(P, { key: 0, class: Zt({ pointer: e.rejectDetailViewable }), color: l(Wl).V[Y.rejectStatus].COLOR, name: l(Wl).VL[Y.rejectStatus], onClick: (ee) => f(Y) }, null, 8, ["class", "color", "name", "onClick"])) : H("", true)], 64)) : H("", true), e.showTip && (Y.basicClass === l(Ci).STEEL_PLATE.V || Y.basicClass === l(Ci).SECTION_STEEL.V) ? (w(), U(P, { key: 6, color: "#f23c3c", offset: 15, show: Y.boolReturns || Y.boolRemnant, name: "退余料" }, null, 8, ["show"])) : H("", true), C("span", null, K(e.isSerialNumber ? Y.serialNumber : Y.materialSn), 1)]), _: 3 }, 8, ["fixed", "prop", "sortable"])) : H("", true), e.showClassification && !b.value ? (w(), U(L, { key: 3, fixed: e.fixed, align: "center", label: "分类", "min-width": "100px", prop: "classification", "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), M.value ? (w(), U(L, { key: 4, fixed: e.fixed, label: e.classifyNameAlias, width: V.value, align: "center", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [C("div", vH, [e.showFrozenTip && Y.boolHasFrozen ? (w(), Q("span", RH)) : H("", true), s(O, { content: Y.classifyParentFullName, disabled: !Y.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [C("span", null, [S.value && Y.boolHasFrozen ? (w(), Q("span", { key: 0, class: "freeze-text text", onClick: (ee) => _(Y) }, K(Y.classifyName), 9, MH)) : (w(), Q("span", AH, K(Y.classifyName), 1))])]), _: 2 }, 1032, ["content", "disabled"])])]), _: 1 }, 8, ["fixed", "label", "width"])) : H("", true), s(L, { key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "180px", fixed: e.fixed, "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [Te(K(Y.specification), 1)]), _: 1 }, 8, ["fixed"]), s(x, { modelValue: r.value, "onUpdate:modelValue": N[0] || (N[0] = (Y) => r.value = Y), "before-close": R, title: `冻结记录：${u.value.classifyName} ${((I = u.value) == null ? void 0 : I.specification) || ""}`, "custom-class": "wms-material-freeze-record-view", "show-close": "", top: "10vh", width: "1300px" }, { default: p(() => [s(Eu, { material: u.value, "max-height": l(T), onUnfreezeSuccess: m }, null, 8, ["material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"]), s(x, { modelValue: E.value, "onUpdate:modelValue": N[1] || (N[1] = (Y) => E.value = Y), title: `退货记录：${u.value.classifyName} ${u.value.specification}`, "custom-class": "wms-material-reject-material-record-view", "show-close": "", top: "10vh", width: "80%" }, { default: p(() => [s(yu, { "basic-class": u.value.basicClass, list: u.value.rejectList, material: u.value, "max-height": l(T), "has-border": "" }, null, 8, ["basic-class", "list", "material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"])], 64);
  };
} }, LH = ut(NH, [["__scopeId", "data-v-5f6614f7"]]), Gv = { __name: "procurement-tracking", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) }, showType: { type: String, default: "purchase" } }, emits: ["update:visible"], setup(e, { emit: o }) {
  const n = Z(), c = o, u = e, { visible: r, handleClose: E } = Ta({ emit: c, props: u, field: "visible", showHook: g }), y = Ee(() => !!(u.info.basicClass & ct.MANUFACTURED.V));
  ft("permission");
  const { maxHeight: b } = Kt({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, r), V = Z([]), M = Z(false);
  function g() {
    S();
  }
  async function S() {
    if (u.info.id) try {
      M.value = true;
      const _ = await (u.showType === "purchase" ? V5 : w5)(u.info.id);
      _.forEach((f) => {
        var m;
        return u.showType === "purchase" ? f.purchaseSN = f.serialNumber : (f.purchaseSN = f.purchaseSerialNumber, f.materialSn = f.materialSn || ((m = u.info) == null ? void 0 : m.materialSn)), f;
      }), await Qt(_), await Ut(_), y.value && _.forEach((f) => {
        f.totalLength = St(Be(f.totalLength, Ft.LENGTH_DP), Ft.LENGTH, "m"), f.totalWeight = St(Be(f.totalWeight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), f.weight = St(Be(f.weight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), f.totalArea = St(Be(f.totalArea, Ft.AREA_DP), Ft.AREA, "m²");
      }), V.value = _;
    } catch (T) {
      console.log(T);
    } finally {
      M.value = false;
    }
  }
  function h(T) {
    return Hi(T, { props: ["quantity", ["mete", 2]] });
  }
  return (T, _) => {
    const f = vt, m = wi, R = Ve("common-table"), v = Ve("common-drawer"), N = oi;
    return w(), U(v, { ref_key: "drawerRef", ref: n, modelValue: l(r), "onUpdate:modelValue": _[0] || (_[0] = (P) => Gt(r) ? r.value = P : null), "before-close": l(E), direction: "rtl", size: "100%", title: `${e.showType === "purchase" ? "采购单已采购明细" : "实际已入库明细"}` }, { titleRight: p(() => _[1] || (_[1] = [])), content: p(() => [y.value ? qe((w(), U(R, { key: 1, data: V.value, "max-height": l(b), style: { width: "100%" } }, { default: p(() => [s(f, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), s(f, { align: "left", label: "采购单号", "min-width": "200px", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(P.purchaseSN || "-"), 1)]), _: 1 }), u.info.finishedProductType === l(Fa).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(f, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(P.quantity), 1)]), _: 1 }), s(f, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: P } }) => [C("span", null, K(l(Be)(P.weight, 2)), 1)]), _: 1 }), s(f, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: P } }) => [C("span", null, K(P.totalWeight), 1)]), _: 1 })], 64)) : (w(), Q(Qe, { key: 1 }, [s(f, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(l(Xi).VL[P.manufacturedType]), 1)]), _: 1 }), s(f, { align: "center", label: "编号", "min-width": "120px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(f, { align: "center", label: "总重（kg）", "min-width": "150px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64))]), _: 1 }, 8, ["data", "max-height"])), [[N, M.value]]) : qe((w(), U(R, { key: 0, data: V.value, "max-height": l(b), "show-summary": "", "summary-method": h, style: { width: "100%" } }, { default: p(() => [u.showType === "purchase" ? (w(), U(fa, { key: 0, isSerialNumber: false }, { afterIndex: p(() => [s(f, { align: "left", label: "采购单号", "min-width": "200px", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(P.purchaseSN || "-"), 1)]), _: 1 })]), _: 1 })) : (w(), U(LH, { key: 1, isSerialNumber: false }, { afterIndex: p(() => [s(f, { align: "left", label: "采购单号", "min-width": "200px", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(P.purchaseSN || "-"), 1)]), _: 1 })]), _: 1 })), s(za), s(f, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: p(({ row: { sourceRow: P } }) => [Te(K(l(di)(P.project)), 1)]), _: 1 }), s(f, { align: "left", label: "品牌", prop: "brand" }), u.showType === "inbound" ? (w(), U(f, { key: 2, align: "left", label: "入库单号", "min-width": "200px", prop: "inboundSerialNumber" }, { default: p(({ row: { sourceRow: P } }) => [P.inboundSerialNumber ? (w(), U(m, { key: 0 }, { default: p(() => [Te(K(P.inboundSerialNumber), 1)]), _: 2 }, 1024)) : (w(), U(m, { key: 1, type: "warning" }, { default: p(() => _[2] || (_[2] = [Te("外购收货")])), _: 1, __: [2] }))]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "max-height"])), [[N, M.value]])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, IH = Object.freeze(Object.defineProperty({ __proto__: null, default: Gv }, Symbol.toStringTag, { value: "Module" }));
const CH = { class: "print-wrap" }, PH = { style: { display: "flex", "justify-content": "space-between" } }, OH = { class: "table-header" }, kH = { key: 1 }, DH = { style: { display: "flex" } }, xH = { key: 0 }, UH = { key: 1 }, YH = { style: { color: "#0d84ff" } }, KH = { style: { color: "#0d84ff" } }, WH = { style: { color: "#0d84ff" } }, jH = { class: "table-remark" }, FH = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, showButtom: { type: Boolean, default: false } }, setup(e) {
  const o = Ht(), n = e, c = ft("permission"), u = Z([["arrivalTime", ["parse-time", "{y}-{m}-{d}"]]]), r = Z([...Da, ...u.value]), E = Z(), { CRUD: y, crud: b, detail: V } = qi(), M = Z("purchase"), g = Z({ classifyName: void 0, specification: void 0 }), S = Z([]);
  function h() {
    const Y = [];
    JSON.parse(JSON.stringify(V.detailList)).forEach((B) => {
      (!g.value.classifyName || B.classifyName.includes(g.value.classifyName)) && (!g.value.specification || B.specification.includes(g.value.specification)) && Y.push(B);
    }), S.value = Y;
  }
  const { maxHeight: T } = Kt({ mainBox: ".requisitions-application-record-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !b.detailLoading)), _ = Ee(() => !!(V.materialType & va.MANUFACTURED.V)), f = Z(false), m = Z({ dataId: void 0, opinion: void 0, decision: void 0 }), R = Z(false), v = Z(false), N = Z({});
  y.HOOK.beforeDetailLoaded = async (Y, ee) => {
    var B;
    m.value = { dataId: void 0, opinion: void 0, decision: void 0 }, R.value = false, _.value ? (ee.detailList.forEach((q) => {
      q.totalLength = St(Be(q.totalLength, Ft.LENGTH_DP), Ft.LENGTH, "m"), q.totalWeight = St(Be(q.totalWeight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), q.weight = St(Be(q.weight, Ft.WEIGHT_DP), Ft.WEIGHT, "kg"), q.totalArea = St(Be(q.totalArea, Ft.AREA_DP), Ft.AREA, "m²");
    }), ee.projectNames = [], (B = ee.projectInfos) == null || B.forEach((q) => {
      ee.projectNames.push(di(q));
    }), ee.projectNames = ee.projectNames.join(",")) : (g.value = {}, await Qt(ee.detailList), ee.detailList.forEach((q) => {
      q.basicClass === Ge.STEEL_COIL.V && (q.measureUnit = "米", q.measurePrecision = 3), q.materialInventoryId ? q.requisitionMode = Ui.USE_INVENTORY.V : q.requisitionMode = Ui.PURCHASE.V;
    }), ee.detailList = await Ut(ee.detailList, { toSmallest: false, toNum: false }, { mete: ["mete", "havePurchasedMete", "unPurchaseMete", "inboundMete"] }), S.value = JSON.parse(JSON.stringify(ee.detailList)));
  };
  async function P(Y) {
    const ee = { dataId: V.id, opinion: m.value.opinion, decision: Y, approveRecordId: V.approveRecordIdNow };
    if (Y === Lt.REFUSE.V && Ae(ee.opinion)) {
      ot.error("请输入审批意见"), R.value = true;
      return;
    }
    await WU(ee).then(async (B) => {
      Y === Lt.PASS.V ? ot.success("审批通过") : (ot.error("审批驳回"), await o.dispatch("approval_list/fetchRejNum", at.REQUISITIONS_V2.V)), await o.dispatch("approval_list/fetchApprovalNum", at.REQUISITIONS_V2.V), await o.dispatch("approval_list/fetchSubNum", at.REQUISITIONS_V2.V), await b.toQuery(), await b.cancelDetail();
    });
  }
  async function L(Y) {
    f.value = true;
    try {
      const ee = { id: Y.id, delButtonType: Y.delButtonType };
      await p5(ee).then(async (B) => {
        B && (ot.success(`${Ko.VL[Y.delButtonType]}成功`), await o.dispatch("approval_list/fetchApprovalNum", at.REQUISITIONS_V2.V), await o.dispatch("approval_list/fetchApprovalNum"), await o.dispatch("approval_list/fetchSubNum", at.REQUISITIONS_V2.V), await o.dispatch("approval_list/fetchRejNum", at.REQUISITIONS_V2.V), await b.toQuery(), await b.cancelDetail());
      });
    } catch (ee) {
      console.log(ee);
    } finally {
      f.value = false;
    }
  }
  function O(Y, ee) {
    M.value = ee, v.value = true, N.value = Y;
  }
  function x(Y) {
    return Hi(Y, { props: [["quantity", 3], ["mete", ei.weight.precision], "havePurchasedMete", "unPurchaseMete"] });
  }
  function I(Y) {
    return Hi(Y, { props: [["quantity", 3], "totalWeight", "havePurchasedMete", "unPurchaseMete"] });
  }
  return (Y, ee) => {
    const B = Ve("print-table"), q = wi, ae = Mt, j = Ve("common-button"), le = pa, oe = Ve("table-cell-tag"), ye = vt, ce = Fm, se = Ve("common-table"), he = Ve("common-drawer"), be = _t("permission");
    return w(), Q(Qe, null, [s(he, { ref_key: "drawerRef", ref: E, modelValue: l(b).detailVisible, "onUpdate:modelValue": ee[7] || (ee[7] = (me) => l(b).detailVisible = me), "before-close": l(b).cancelDetail, "content-loading": l(b).detailLoading, "show-close": true, "custom-class": "requisitions-application-record-detail", size: "80%", title: "申购详情" }, Zl({ titleRight: p(() => {
      var me, ge, Le;
      return [C("div", CH, [qe(s(B, { "api-key": _.value ? ((me = l(V)) == null ? void 0 : me.materialType) === l(Ge).STRUC_MANUFACTURED.V ? "scmManufRequisitionsDetail" : "scmManufEnclosureRequisitionsDetail" : "scmRequisitionsDetail", params: (ge = l(V)) == null ? void 0 : ge.id, size: "mini", type: "warning" }, null, 8, ["api-key", "params"]), [[be, (Le = l(c)) == null ? void 0 : Le.print]])])];
    }), _: 2 }, [l(A)(l(V)) ? { name: "content", fn: p(() => [C("div", PH, [C("div", OH, [s(q, { effect: "plain", size: "large" }, { default: p(() => {
      var me;
      return [Te("申购编号：" + K((me = l(V)) == null ? void 0 : me.serialNumber), 1)];
    }), _: 1 }), s(q, { effect: "plain", size: "large", type: "success" }, { default: p(() => {
      var me;
      return [Te("申购人：" + K((me = l(V)) == null ? void 0 : me.applicantName), 1)];
    }), _: 1 }), l(V).materialType & l(ct).MANUFACTURED.V ? (w(), U(q, { key: 0, effect: "plain", size: "large", type: "danger" }, { default: p(() => {
      var me;
      return [Te(" 项目：" + K((me = l(V)) == null ? void 0 : me.projectNames), 1)];
    }), _: 1 })) : H("", true), _.value ? H("", true) : (w(), Q("span", kH, [s(ae, { modelValue: g.value.classifyName, "onUpdate:modelValue": ee[0] || (ee[0] = (me) => g.value.classifyName = me), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "物料种类", size: "default", style: { width: "200px" }, onBlur: h, onClear: h }, null, 8, ["modelValue"]), s(ae, { modelValue: g.value.specification, "onUpdate:modelValue": ee[1] || (ee[1] = (me) => g.value.specification = me), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "200px", "margin-left": "10px" }, onBlur: h, onClear: h }, null, 8, ["modelValue"])]))]), C("div", DH, [!e.ApprovalFlag && e.showButtom ? (w(), Q("div", xH, [s(V_, { data: { id: l(V).id }, permission: l(c), "show-del": false, "show-edit": l(Ae)(l(V).purchaseCreationState) && l(V).dataStatus === l(rl).UNDER_APPROVAL.V || l(V).purchaseCreationState === l(Yo).NOT_STARTED.V && l(V).dataStatus === l(rl).PASSED.V || l(V).purchaseCreationState === l(Yo).NOT_STARTED.V && l(V).dataStatus === l(rl).UNDER_APPROVAL.V }, null, 8, ["data", "permission", "show-edit"]), l(Ai)(l(c).del) && l(V).delButtonType !== l(Ko).NO_DEL.V && (l(V).purchaseCreationState === l(Yo).NOT_STARTED.V || l(Ae)(l(V).purchaseCreationState)) ? (w(), U(le, { key: 0, title: `您确定要${l(Ko).VL[l(V).delButtonType]}该条数据吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", onConfirm: ee[2] || (ee[2] = (me) => L(l(V))) }, { reference: p(() => [s(j, { loading: f.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => [Te(K(l(Ko).VL[l(V).delButtonType] || "删除"), 1)]), _: 1 }, 8, ["loading"])]), _: 1 }, 8, ["title"])) : H("", true), s(ia, { fn: l(A2), params: { id: l(V).id }, size: "mini" }, { default: p(() => ee[9] || (ee[9] = [Te(" 申购采购跟踪下载 ")])), _: 1, __: [9] }, 8, ["fn", "params"])])) : (w(), Q("div", UH, [n.ApprovalFlag && l(Ai)(l(c).approvalCfg) ? (w(), U(le, { key: 0, title: "确认通过", onConfirm: ee[3] || (ee[3] = (me) => P(l(Lt).PASS.V)) }, { reference: p(() => [s(j, { class: "filter-item", size: "default", type: "success" }, { default: p(() => ee[10] || (ee[10] = [Te("通过")])), _: 1, __: [10] })]), _: 1 })) : H("", true), n.ApprovalFlag && l(Ai)(l(c).approvalCfg) ? (w(), U(le, { key: 1, title: "确认驳回", onConfirm: ee[4] || (ee[4] = (me) => P(l(Lt).REFUSE.V)) }, { reference: p(() => [s(j, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => ee[11] || (ee[11] = [Te(" 驳回")])), _: 1, __: [11] })]), _: 1 })) : H("", true), s(ia, { fn: l(A2), params: { id: l(V).id }, size: "mini" }, { default: p(() => ee[12] || (ee[12] = [Te(" 申购采购跟踪下载 ")])), _: 1, __: [12] }, 8, ["fn", "params"])]))])]), _.value ? (w(), U(se, { key: 1, data: l(V).detailList, "data-format": u.value, "max-height": l(T), "summary-method": I, "show-summary": "" }, { default: p(() => [s(ye, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), l(V).finishedProductType === l(Fa).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(ye, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [Te(K(me.quantity), 1)]), _: 1 }), s(ye, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [C("span", null, K(l(Be)(me.weight, 2)), 1)]), _: 1 }), s(ye, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [C("span", null, K(me.totalWeight), 1)]), _: 1 })], 64)) : (w(), Q(Qe, { key: 1 }, [s(ye, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: me } }) => [Te(K(l(Xi).VL[me.manufacturedType]), 1)]), _: 1 }), s(ye, { align: "center", label: "编号", "min-width": "120px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(ye, { align: "center", label: "总重（kg）", "min-width": "150px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)), s(ye, { align: "center", label: "已采购量", "min-width": "100px", prop: "havePurchasedMete", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [s(ce, { underline: false, onClick: (ge) => O(me, "purchase") }, { default: p(() => [C("span", WH, K(me.havePurchasedMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), s(ye, { align: "center", label: "未采购量", "min-width": "100px", prop: "unPurchaseMete", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [Te(K(me.unPurchaseMete), 1)]), _: 1 }), s(ye, { align: "center", label: "到厂日期", "min-width": "120px", prop: "arrivalTime", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])) : (w(), U(se, { key: 0, data: S.value, "data-format": r.value, "max-height": l(T), "summary-method": x, "show-summary": "" }, { default: p(() => [s(ye, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: p(({ row: me, $index: ge }) => [s(oe, { name: l(Ui).USE_INVENTORY.L, show: me.requisitionMode === l(Ui).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), C("span", null, K(ge + 1), 1)]), _: 1 }), s(fa, { isSerialNumber: false, showIndex: false, fixed: "left" }), s(za), s(ye, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: p(({ row: { sourceRow: me } }) => {
      var ge, Le, Ie;
      return [Te(K(l(A)((ge = me.project) == null ? void 0 : ge.shortName) ? `${(Le = me.project) == null ? void 0 : Le.serialNumber} ${(Ie = me.project) == null ? void 0 : Ie.shortName}` : "-"), 1)];
    }), _: 1 }), s(Ba), s(ye, { align: "center", label: "实际入库量", "min-width": "100px", prop: "inboundMete", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [s(ce, { underline: false, onClick: (ge) => O(me, "inbound") }, { default: p(() => [C("span", YH, K(me.inboundMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), s(ye, { align: "center", label: "已采购量", "min-width": "100px", prop: "havePurchasedMete", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [s(ce, { underline: false, onClick: (ge) => O(me, "purchase") }, { default: p(() => [C("span", KH, K(me.havePurchasedMete), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 }), s(ye, { align: "center", label: "未采购量", "min-width": "100px", prop: "unPurchaseMete", "show-overflow-tooltip": "" }, { default: p(({ row: me }) => [Te(K(me.unPurchaseMete), 1)]), _: 1 }), s(ye, { align: "center", label: "到厂日期", prop: "arrivalTime", "show-overflow-tooltip": "", width: "120px" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), C("div", jH, [ee[13] || (ee[13] = C("span", null, "备注", -1)), C("span", null, [C("span", null, K(l(V).remark), 1)])]), s(dl, { files: l(V).attachments, "onUpdate:files": ee[5] || (ee[5] = (me) => l(V).attachments = me), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传附件", "show-download": "", style: { "margin-top": "10px" } }, null, 8, ["files", "file-classify"]), n.ApprovalFlag ? (w(), Q("div", { key: 2, class: Zt(R.value ? "table-remark isApproval-not" : "table-remark") }, [ee[14] || (ee[14] = C("span", { style: { padding: "0 4px", display: "block", width: "63px" } }, "审批意见", -1)), s(ae, { modelValue: m.value.opinion, "onUpdate:modelValue": ee[6] || (ee[6] = (me) => m.value.opinion = me), rows: 2, class: "remark input-border-none", maxlength: "200", placeholder: "请填写审批意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])], 2)) : H("", true)]), key: "0" } : void 0]), 1032, ["modelValue", "before-close", "content-loading"]), s(l(X_), { "show-ts-buttom": false, onDetailSuccess: l(b).cancelDetail }, null, 8, ["onDetailSuccess"]), s(Gv, { visible: v.value, "onUpdate:visible": ee[8] || (ee[8] = (me) => v.value = me), info: N.value, showType: M.value }, null, 8, ["visible", "info", "showType"])], 64);
  };
} }, $_ = ut(FH, [["__scopeId", "data-v-883d7b50"]]), zH = Object.freeze(Object.defineProperty({ __proto__: null, default: $_ }, Symbol.toStringTag, { value: "Module" })), Qv = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.supplyUsedProject);
  if (n.value || o.dispatch("config/fetchSupplyUsedProject"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, supplyUsedProject: Ee(() => o.state.config.supplyUsedProject) };
}, Zv = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.annualSuppliers);
  if (n.value || o.dispatch("config/fetchAnnualSupplier"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { annualLoaded: n, annualSuppliers: Ee(() => o.state.config.annualSuppliers), annualSupplierKV: Ee(() => o.state.config.annualSupplierKV) };
}, BH = { style: { "text-align": "right" } }, HH = { __name: "add-supplier", emits: ["close"], setup(e, { emit: o }) {
  const n = o, c = Ht(), u = Z(), r = Z(false), E = { name: "", socialCode: "", supplierClass: Yn.LOGISTICS.V, supplierClassification: Yn.LOGISTICS.V }, y = Z({ ...E }), b = { name: [{ required: true, message: "请输入供应商名称", trigger: "blur" }, { min: 2, max: 32, message: "长度在 2 到 32 个字符", trigger: "blur" }], supplierClass: [{ required: true, message: "请选择供应商分类", trigger: "blur" }] };
  function V() {
    y.value = { ...E };
  }
  async function M() {
    const S = await u.value.validate();
    try {
      S && (r.value = true, await O_([{ ...y.value }]), g(), V(), Di({ title: "新增成功", type: "success" }), c.dispatch("config/fetchSuppliers"));
    } catch (h) {
      console.log("新增供应商", h);
    } finally {
      r.value = false;
    }
  }
  function g() {
    n("close");
  }
  return (S, h) => {
    const T = Mt, _ = Zi, f = Ve("common-button"), m = Li;
    return w(), U(m, { ref_key: "formRef", ref: u, model: y.value, rules: b, size: "default", "label-width": "100px" }, { default: p(() => [s(_, { label: "物流单位", prop: "name" }, { default: p(() => [s(T, { modelValue: y.value.name, "onUpdate:modelValue": h[0] || (h[0] = (R) => y.value.name = R), maxlength: "32", "show-word-limit": "", placeholder: "请输入供应商名称" }, null, 8, ["modelValue"])]), _: 1 }), s(_, { label: "社会统一代码", prop: "socialCode" }, { default: p(() => [s(T, { modelValue: y.value.socialCode, "onUpdate:modelValue": h[1] || (h[1] = (R) => y.value.socialCode = R), placeholder: "请输入社会统一代码", maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), C("div", BH, [s(f, { loading: r.value, type: "primary", size: "default", onClick: M }, { default: p(() => h[2] || (h[2] = [Te("提 交")])), _: 1, __: [2] }, 8, ["loading"]), s(f, { size: "default", onClick: g }, { default: p(() => h[3] || (h[3] = [Te("关闭")])), _: 1, __: [3] })])]), _: 1 }, 8, ["model"]);
  };
} };
const qH = { style: { "overflow-x": "auto", width: "100%" } }, GH = { class: "customize-option-item" }, QH = { class: "flex-rsc label" }, ZH = { key: 0, class: "extra-label" }, JH = { key: 1 }, XH = { __name: "index", props: { modelValue: { type: [Number, String, Array] }, basicClass: { type: Number }, logisticsCreateable: { type: Boolean, default: false }, showType: { type: Boolean, default: true }, type: { type: Number, default: vo.RAW_MATERIAL.V | vo.MANUFACTURED.V | vo.OTHER.V }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" }, isAnnual: { type: Boolean, default: false } }, emits: ["change", "info-change", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = { add: ["scm_supplier:add"] }, r = Z(false), E = Z(), { loaded: y, suppliers: b, supplierKV: V } = hu(m), { annualLoaded: M, annualSuppliers: g, annualSupplierKV: S } = Zv(), h = Ee(() => c.isAnnual ? M : y), T = Ee(() => {
    let N = [];
    if (c.isAnnual ? N = g.value : N = c.showHide ? b.value : b.value.filter((P) => P.boolHide === ru.FALSE.V), c.basicClass) {
      if (c.mode === "contained") return N == null ? void 0 : N.filter((P) => (P.basicClass & c.basicClass) === P.basicClass);
      if (c.mode === "contain") return N == null ? void 0 : N.filter((P) => (P.basicClass & c.basicClass) === c.basicClass);
      if (c.mode === "cross") return N == null ? void 0 : N.filter((P) => P.basicClass & c.basicClass);
    }
    if (c.type) {
      if (c.typeMode === "contained") return N == null ? void 0 : N.filter((P) => (P.type & c.type) === P.type);
      if (c.typeMode === "contain") return N == null ? void 0 : N.filter((P) => (P.type & c.type) === c.type);
      if (c.typeMode === "cross") return N == null ? void 0 : N.filter((P) => P.type & c.type);
    }
    return N;
  });
  Ce(() => c.modelValue, (N) => {
    E.value = N;
  }, { immediate: true });
  function _(N) {
    let P = N;
    Ae(P) && (P = void 0);
    const L = !el(P, c.modelValue), O = Ae(P) && Ae(c.modelValue);
    L && !O && (n("update:modelValue", P), n("change", P), f(P, c.modelValue));
  }
  function f(N, P) {
    const L = c.isAnnual ? S.value : V.value, O = N ? L[N] : null, x = P ? L[P] : null;
    n("info-change", O, x);
  }
  function m() {
    A(E.value) ? f(E.value) : v();
  }
  function R() {
    r.value = false;
  }
  function v() {
    pt(() => {
      if (!(Ae(T.value) || E.value) && c.default) {
        E.value = T.value[0].id, _(E.value);
        return;
      }
    });
  }
  return (N, P) => {
    const L = Ve("common-select-v2"), O = Wm, x = ml, I = La, Y = _t("parse-enum"), ee = _t("permission");
    return w(), Q("span", { class: Zt([{ "show-add-icon": c.logisticsCreateable }, "supplier-sn-select-container"]) }, [s(L, { modelValue: E.value, "onUpdate:modelValue": P[0] || (P[0] = (B) => E.value = B), clearable: c.clearable, "collapse-tags": c.collapseTags, disabled: c.disabled, filterable: c.filterable, loading: !h.value, multiple: c.multiple, options: T.value, placeholder: c.placeholder, size: c.size, class: "supplier-sn-select", onChange: _ }, { view: p(({ data: B }) => [C("div", qH, [C("span", GH, [C("span", QH, [C("span", null, K(B.name), 1)]), C("span", null, [c.showType ? (w(), Q("span", ZH, [P[3] || (P[3] = C("span", { class: "title" }, "类型：", -1)), qe(C("span", null, null, 512), [[Y, { e: l(wn), v: B.basicClass, bit: true, split: " | " }]])])) : H("", true)])])])]), _: 1 }, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "loading", "multiple", "options", "placeholder", "size"]), s(I, { visible: r.value, "onUpdate:visible": P[2] || (P[2] = (B) => r.value = B), placement: "top", width: "450" }, { reference: p(() => [c.logisticsCreateable ? (w(), Q("span", { key: 0, class: "add-icon pointer", onClick: P[1] || (P[1] = Pi((B) => r.value = !r.value, ["stop"])) }, [qe((w(), U(x, { color: "#1881ef" }, { default: p(() => [s(O)]), _: 1 })), [[ee, u.add]])])) : (w(), Q("span", JH))]), default: p(() => [s(HH, { onClose: R })]), _: 1 }, 8, ["visible"])], 2);
  };
} }, pd = ut(XH, [["__scopeId", "data-v-58920bac"]]);
const $H = { class: "head-container" }, eq = { style: { display: "flex" } }, tq = { class: "filter-item procurement-status" }, iq = { __name: "requisition-order", setup(e, { expose: o }) {
  var T;
  const n = (T = ft("cu")) == null ? void 0 : T.form, c = Z(), u = Z(false), r = Z([]), E = Z({ times: [$a().startOf("month").valueOf(), $a().valueOf()], purchaseCreationState: void 0 }), y = Z([["projects", "parse-project"]]);
  function b(_) {
    var f;
    return ((f = n.oriquisitionArr) == null ? void 0 : f.findIndex((m) => m.applyPurchaseId === _.id)) > -1 ? false : _.purchaseCreationState !== Yo.COMPLETED.V;
  }
  const V = Z([]), M = Ee(() => {
    var f;
    let _ = [];
    if (n.materialTypeTotal) for (const m in ct.ENUM) A(n.materialTypeTotal) && !((f = n.materialTypeTotal) != null && f.includes(ct.ENUM[m].V)) && _.push(ct.ENUM[m].V);
    else n.materialType & ct.STEEL.V ? (_.push(ct.GAS.V), _.push(ct.MATERIAL.V), _.push(ct.OTHER.V)) : n.materialType ? _.push(ct.STEEL.V) : _ = [], n.id && A(V.value) && (_ = [..._, ...V.value]);
    return _;
  });
  async function g() {
    r.value = [];
    try {
      u.value = true;
      const { content: _ } = await YU({ filterUseInventory: true, materialType: n.currentMaterial, level: n.level, projectAttribute: n.projectAttribute, branchCompanyId: n.branchCompanyId, ...E.value }), f = [];
      r.value = _.map((m, R) => {
        var v;
        return A((v = n.requisitionsKV) == null ? void 0 : v[m.id]) && f.push(R), m;
      }), await pt(() => {
        f.forEach((m) => {
          var R;
          (R = c.value) == null || R.toggleRowSelection(r.value[m], void 0);
        });
      });
    } catch (_) {
      console.log(_, "获取申购单列表失败");
    } finally {
      u.value = false;
    }
  }
  function S(_, f) {
    const m = _.findIndex((R) => R.id === f.id) !== -1;
    m && Ae(n.requisitionsKV[f.id]) && (n.requisitionsKV[f.id] = JSON.parse(JSON.stringify(f))), !m && A(n.requisitionsKV[f.id]) && delete n.requisitionsKV[f.id];
  }
  function h(_) {
    const f = !!(_ != null && _.length);
    r.value.forEach((m) => {
      f && Ae(n.requisitionsKV[m.id]) && (n.requisitionsKV[m.id] = JSON.parse(JSON.stringify(m))), !f && A(n.requisitionsKV[m.id]) && delete n.requisitionsKV[m.id];
    });
  }
  return o({ fetchList: g }), (_, f) => {
    const m = Rl, R = Ve("common-select"), v = Ve("common-radio-button"), N = vt, P = wi, L = Ve("common-table"), O = oi;
    return w(), Q("div", null, [C("div", $H, [C("div", eq, [s(m, { modelValue: E.value.times, "onUpdate:modelValue": f[0] || (f[0] = (x) => E.value.times = x), class: "date-item filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "220px" }, type: "daterange", "value-format": "x", onChange: g }, null, 8, ["modelValue"]), C("div", tq, [f[4] || (f[4] = C("span", { class: "title" }, " 采购状态 ", -1)), s(R, { modelValue: E.value.purchaseCreationState, "onUpdate:modelValue": f[1] || (f[1] = (x) => E.value.purchaseCreationState = x), options: l(Yo).ENUM, class: "filter-item input-border-none", "show-option-all": "", size: "default", style: { width: "140px", padding: "0" }, type: "enum", onChange: g }, null, 8, ["modelValue", "options"])])]), s(v, { modelValue: l(n).currentMaterial, "onUpdate:modelValue": f[2] || (f[2] = (x) => l(n).currentMaterial = x), "disabled-val": M.value, options: l(ct).ENUM, class: "filter-item", size: "default", type: "enum", onChange: g }, null, 8, ["modelValue", "disabled-val", "options"]), s(ca, { key: "siteProjectId", modelValue: E.value.projectId, "onUpdate:modelValue": f[3] || (f[3] = (x) => E.value.projectId = x), branchCompanyId: l(n).branchCompanyId, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "155px" }, onChange: g }, null, 8, ["modelValue", "branchCompanyId"])]), qe((w(), U(L, { ref_key: "tableRef", ref: c, data: r.value, "data-format": y.value, style: { width: "100%" }, onSelect: S, onSelectAll: h }, { default: p(() => [s(N, { selectable: b, align: "center", class: "selection", type: "selection", width: "55" }), s(N, { align: "center", label: "序号", type: "index", width: "55" }), s(N, { align: "center", label: "申购单号", "min-width": "90", prop: "serialNumber" }, { default: p(({ row: { sourceRow: x } }) => [x != null && x.id ? (w(), U(l(H_), { key: 0, receipt: x, "receipt-types": ["REQUISITIONS"] }, null, 8, ["receipt"])) : H("", true)]), _: 1 }), s(N, { align: "center", label: "关联项目", "min-width": "120", prop: "projects", "show-overflow-tooltip": "" }), s(N, { align: "center", label: "状态", prop: "purchaseCreationState", width: "90" }, { default: p(({ row: { sourceRow: x } }) => {
      var I;
      return [x.purchaseCreationState ? (w(), U(P, { key: 0, type: (I = l(Yo).V[x.purchaseCreationState]) == null ? void 0 : I.T, effect: "plain" }, { default: p(() => [Te(K(l(Yo).VL[x.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : H("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format"])), [[O, u.value]])]);
  };
} }, Jv = ut(iq, [["__scopeId", "data-v-5fb7f3e5"]]), aq = Object.freeze(Object.defineProperty({ __proto__: null, default: Jv }, Symbol.toStringTag, { value: "Module" }));
function Al(e = "mete") {
  const o = (u, r) => {
    Ho(u) > 10 && (r.unitPrice = Be(u, 10), u = r.unitPrice), r.priceType = "unitPrice", r.amount = A(u) && A(r[e]) ? Be(u * r[e], Ze.YUAN) : void 0;
  }, n = (u, r) => {
    r.priceType = "amount", r.unitPrice = A(u) && A(r[e]) ? Be(u / r[e], 10) : void 0;
  };
  return { handleUnitPriceChange: o, handleAmountChange: n, handleMeteChangeCalcPrice: (u) => {
    u.priceType = "unitPrice", u.unitPrice && !u.amount && !u.priceType && (u.priceType = "unitPrice"), !u.unitPrice && u.amount && !u.priceType && (u.priceType = "amount"), u.priceType === "unitPrice" && o(u.unitPrice, u), u.priceType === "amount" && n(u.amount, u);
  } };
}
const lq = { key: 0 }, oq = { class: "color-green" }, nq = { key: 1 }, Xv = { __name: "steel-plate-table", emits: ["add-purchase"], setup(e, { expose: o, emit: n }) {
  var v;
  const c = n, u = ft("purchaseCfg"), r = Ge.STEEL_PLATE.V, E = ft("bcListObj"), y = (v = ft("cu")) == null ? void 0 : v.form, { baseUnit: b } = ai(r), { handleMeteChangeCalcPrice: V } = Al("weighingTotalWeight"), M = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ required: false, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: g, wrongCellMask: S } = ui({ rules: M, errorMsg: "请修正【钢板清单】中标红的信息" });
  function h(N) {
    var L;
    let P = 0;
    return y.steelPlateList.forEach((O) => {
      O.applyPurchaseDetailId === N.applyPurchaseDetailId && (P += O.weighingTotalWeight || 0 || O.mete || 0);
    }), !!((L = u.value) != null && L.applyAndProcureMeteDiffState && P && P >= N.maxCanPurchaseMete || y.projectId && N.projectId !== y.projectId);
  }
  function T(N) {
    Ce([() => N.length, () => N.width, () => N.thickness, b], () => _(N)), Ce([() => N.theoryWeight, () => N.quantity], () => f(N)), Ce([() => N.weighingTotalWeight], () => V(N));
  }
  async function _(N) {
    N.theoryWeight = await na({ classifyId: N.classifyId, name: N.classifyFullName, length: N.length, width: N.width, thickness: N.thickness });
  }
  function f(N) {
    A(N.theoryWeight) && N.quantity ? (N.theoryTotalWeight = Be(N.theoryWeight * N.quantity, b.value.weight.precision), N.weighingTotalWeight = Be(N.theoryWeight * N.quantity, b.value.weight.precision)) : (N.theoryTotalWeight = void 0, N.weighingTotalWeight = void 0);
  }
  function m(N, P) {
    c("add-purchase", N, P);
  }
  function R(N) {
    const { validResult: P } = g(N);
    return P;
  }
  return o({ rowWatch: T, validate: R }), (N, P) => {
    const L = vt, O = jt, x = Ve("common-button"), I = Ve("common-table");
    return w(), U(I, ii({ "cell-class-name": l(S), data: l(E).steelPlateList, "show-empty-symbol": false, "return-source-data": "" }, N.$attrs), { default: p(() => {
      var Y;
      return [s(L, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(L, { align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" }, { default: p(({ row: ee }) => [C("span", null, K(ee.purchaseSN), 1)]), _: 1 }), s(L, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(L, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: ee }) => [s(O, { content: l(Ma)(ee), placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(ee)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(L, { align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "", width: "80" }), s(L, { label: `申购数 (${l(b).measure.unit})`, align: "right", prop: "quantity", width: "140" }, { default: p(({ row: ee }) => [C("span", null, K(ee.originQuantity), 1)]), _: 1 }, 8, ["label"]), s(L, { prop: "maxCanPurchaseMete", label: `${(Y = l(u)) != null && Y.applyAndProcureMeteDiffState ? `最大采购量/申购量
 (` + l(b).weight.unit + ")" : "申购量(" + l(b).weight.unit + ")"}`, align: "right" }, { default: p(({ row: ee }) => {
        var B;
        return [ee.accountingUnit ? (w(), Q("span", lq, [(B = l(u)) != null && B.applyAndProcureMeteDiffState ? (w(), Q(Qe, { key: 0 }, [C("span", oq, K(ee.maxCanPurchaseMete), 1), Te(" / " + K(ee.originMete), 1)], 64)) : (w(), Q(Qe, { key: 1 }, [Te(K(ee.originMete), 1)], 64))])) : (w(), Q("span", nq, "-"))];
      }), _: 1 }, 8, ["label"]), s(L, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "90" }), s(L, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: p(({ row: ee }) => [C("span", null, K(l(A)(ee.arrivalTime) ? l(Qi)(ee.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(L, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: p(({ row: ee }) => [C("span", null, K(l(A)(ee.project) ? l(di)(ee.project) : "-"), 1)]), _: 1 }), s(L, { align: "center", fixed: "right", label: "操作", width: "90" }, { default: p(({ row: ee, $index: B }) => {
        var q, ae;
        return [s(O, { content: h(ee) && ((q = l(u)) != null && q.applyAndProcureMeteDiffState) ? `超出最大采购量：${ee.maxCanPurchaseMete} ${l(b).weight.unit}` : "", disabled: !(h(ee) && ((ae = l(u)) != null && ae.applyAndProcureMeteDiffState)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(x, { disabled: h(ee), icon: "el-icon-plus", size: "default", type: "warning", onClick: (j) => m(ee, B) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1032, ["content", "disabled"])];
      }), _: 1 })];
    }), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, sq = Object.freeze(Object.defineProperty({ __proto__: null, default: Xv }, Symbol.toStringTag, { value: "Module" })), rq = { key: 0 }, uq = { class: "color-green" }, cq = { key: 1 }, $v = { __name: "section-steel-table", emits: ["add-purchase"], setup(e, { expose: o, emit: n }) {
  var N;
  const c = n, u = ft("purchaseCfg"), r = Ge.SECTION_STEEL.V, E = ft("bcListObj"), y = (N = ft("cu")) == null ? void 0 : N.form, { baseUnit: b } = ai(r), { handleMeteChangeCalcPrice: V } = Al("weighingTotalWeight"), M = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }] }, { tableValidate: g, wrongCellMask: S } = ui({ rules: M, errorMsg: "请修正【型材清单】中标红的信息" });
  function h(P) {
    var O;
    let L = 0;
    return y.sectionSteelList.forEach((x) => {
      x.applyPurchaseDetailId === P.applyPurchaseDetailId && (L += x.weighingTotalWeight || 0 || x.mete || 0);
    }), !!((O = u.value) != null && O.applyAndProcureMeteDiffState && L && L >= P.maxCanPurchaseMete || y.projectId && P.projectId !== y.projectId);
  }
  function T(P) {
    Ce([() => P.length, () => P.unitWeight, b], () => _(P), { immediate: true }), Ce([() => P.theoryWeight, () => P.quantity], () => {
      m(P);
    }), Ce([() => P.length, () => P.quantity], () => {
      f(P);
    }), Ce([() => P.weighingTotalWeight], () => V(P));
  }
  async function _(P) {
    P.theoryWeight = await xa({ length: P.length, unitWeight: P.unitWeight });
  }
  function f(P) {
    A(P.length) && P.quantity ? P.totalLength = Na({ length: P.length, quantity: P.quantity }) : P.totalLength = void 0;
  }
  function m(P) {
    A(P.theoryWeight) && P.quantity ? (P.theoryTotalWeight = Be(P.theoryWeight * P.quantity, b.value.weight.precision), P.weighingTotalWeight = Be(P.theoryWeight * P.quantity, b.value.weight.precision)) : (P.theoryTotalWeight = void 0, P.weighingTotalWeight = void 0);
  }
  function R(P, L) {
    c("add-purchase", P, L);
  }
  function v(P) {
    const { validResult: L } = g(P);
    return L;
  }
  return o({ rowWatch: T, validate: v }), (P, L) => {
    const O = vt, x = jt, I = Ve("common-button"), Y = Ve("common-table"), ee = Ve("common-drawer"), B = _t("empty-text");
    return w(), Q(Qe, null, [s(Y, ii(P.$attrs, { data: l(E).sectionSteelList, "cell-class-name": l(S), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: p(() => {
      var q;
      return [s(O, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), s(O, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: p(({ row: ae }) => [C("span", null, K(ae.purchaseSN), 1)]), _: 1 }), s(O, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), s(O, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: p(({ row: ae }) => [s(x, { content: ae.classifyParentFullName, disabled: !ae.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[B, ae.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(O, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: ae }) => [s(x, { content: l(Ma)(ae), placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(ae)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(O, { prop: "length", align: "center", label: `定尺长度 (${l(b).length.unit})`, "min-width": "120" }, null, 8, ["label"]), s(O, { prop: "quantity", align: "right", label: `申购数(${l(b).measure.unit})`, width: "140" }, { default: p(({ row: ae }) => [C("span", null, K(ae.originQuantity), 1)]), _: 1 }, 8, ["label"]), s(O, { prop: "totalLength", align: "center", label: "总长度 (m)" }), s(O, { prop: "maxCanPurchaseMete", label: `${(q = l(u)) != null && q.applyAndProcureMeteDiffState ? `最大采购量/申购量
 (` + l(b).weight.unit + ")" : "申购量(" + l(b).weight.unit + ")"}`, align: "right" }, { default: p(({ row: ae }) => {
        var j;
        return [ae.accountingUnit ? (w(), Q("span", rq, [(j = l(u)) != null && j.applyAndProcureMeteDiffState ? (w(), Q(Qe, { key: 0 }, [C("span", uq, K(ae.maxCanPurchaseMete), 1), Te(" / " + K(ae.originMete), 1)], 64)) : (w(), Q(Qe, { key: 1 }, [Te(K(ae.originMete), 1)], 64))])) : (w(), Q("span", cq, "-"))];
      }), _: 1 }, 8, ["label"]), s(O, { prop: "brand", label: "品牌", align: "center" }), s(O, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: p(({ row: ae }) => [C("span", null, K(l(A)(ae.arrivalTime) ? l(Qi)(ae.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(O, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: p(({ row: ae }) => [C("span", null, K(l(A)(ae.project) ? l(di)(ae.project) : "-"), 1)]), _: 1 }), s(O, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: p(({ row: ae, $index: j }) => {
        var le, oe;
        return [s(x, { content: h(ae) && ((le = l(u)) != null && le.applyAndProcureMeteDiffState) ? `超出最大采购量：${ae.maxCanPurchaseMete} ${l(b).weight.unit}` : "", disabled: !(h(ae) && ((oe = l(u)) != null && oe.applyAndProcureMeteDiffState)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(I, { icon: "el-icon-plus", disabled: h(ae), type: "warning", size: "default", onClick: (ye) => R(ae, j) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1032, ["content", "disabled"])];
      }), _: 1 })];
    }), _: 1 }, 16, ["data", "cell-class-name"]), s(ee, { ref: "drawerRef", modelValue: P.materialSelectVisible, "onUpdate:modelValue": L[1] || (L[1] = (q) => P.materialSelectVisible = q), title: "型材规格选择", "show-close": true, size: 900, "custom-class": "material-spec-select" }, { content: p(() => [s(ba, { ref: "specRef", modelValue: P.editList, "onUpdate:modelValue": L[0] || (L[0] = (q) => P.editList = q), visible: P.materialSelectVisible, classifyId: P.editRow.classifyId, "show-classify": false, mode: "selector", "max-height": P.specSelectMaxHeight, "expand-query": "", onChange: P.handleSpecChange }, null, 8, ["modelValue", "visible", "classifyId", "max-height", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, dq = Object.freeze(Object.defineProperty({ __proto__: null, default: $v }, Symbol.toStringTag, { value: "Module" })), mq = { key: 0 }, pq = { class: "color-green" }, hq = { key: 1 }, eR = { __name: "steel-coil-table", emits: ["add-purchase"], setup(e, { expose: o, emit: n }) {
  var R;
  const c = n, u = Ge.STEEL_COIL.V, r = ft("bcListObj"), E = (R = ft("cu")) == null ? void 0 : R.form, y = ft("purchaseCfg"), { baseUnit: b } = ai(u), V = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: Vi, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { pattern: Vi, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { pattern: Vi, message: "长度必须大于0", trigger: "blur" }] }, { tableValidate: M, wrongCellMask: g } = ui({ rules: V, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function S(v) {
    var P;
    let N = 0;
    return E.steelCoilList.forEach((L) => {
      L.applyPurchaseDetailId === v.applyPurchaseDetailId && (N += L.weighingTotalWeight || 0 || L.mete || 0);
    }), !!((P = y.value) != null && P.applyAndProcureMeteDiffState && N && N >= v.maxCanPurchaseMete || E.projectId && v.projectId !== E.projectId);
  }
  function h(v) {
    Ce([() => v.weighingTotalWeight, () => v.width, () => v.thickness, b], () => T(v)), Ce([() => v.theoryLength], () => _(v));
  }
  async function T(v) {
    v.theoryLength = await il({ classifyId: v.classifyId, name: v.classifyFullName, weight: v.weighingTotalWeight, width: v.width, thickness: v.thickness });
  }
  function _(v) {
    A(v.theoryLength) ? v.length = v.theoryLength * 1 : v.length = void 0;
  }
  function f(v, N) {
    c("add-purchase", v, N);
  }
  function m(v) {
    const { validResult: N } = M(v);
    return N;
  }
  return o({ rowWatch: h, validate: m }), (v, N) => {
    const P = vt, L = jt, O = Ve("common-button"), x = Ve("common-table");
    return w(), U(x, ii(v.$attrs, { data: l(r).steelCoilList, "cell-class-name": l(g), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: p(() => {
      var I;
      return [s(P, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), s(P, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: p(({ row: Y }) => [C("span", null, K(Y.purchaseSN), 1)]), _: 1 }), s(P, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), s(P, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }), s(P, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [s(L, { content: l(Ma)(Y), placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(Y)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(P, { prop: "maxCanPurchaseMete", label: `${(I = l(y)) != null && I.applyAndProcureMeteDiffState ? `最大采购量/申购量
 (` + l(b).weight.unit + ")" : "申购量(" + l(b).weight.unit + ")"}`, align: "right" }, { default: p(({ row: Y }) => {
        var ee;
        return [Y.accountingUnit ? (w(), Q("span", mq, [(ee = l(y)) != null && ee.applyAndProcureMeteDiffState ? (w(), Q(Qe, { key: 0 }, [C("span", pq, K(Y.maxCanPurchaseMete), 1), Te(" / " + K(Y.originMete), 1)], 64)) : (w(), Q(Qe, { key: 1 }, [Te(K(Y.originMete), 1)], 64))])) : (w(), Q("span", hq, "-"))];
      }), _: 1 }, 8, ["label"]), s(P, { prop: "thickness", align: "center", label: `厚 (${l(b).thickness.unit})` }, null, 8, ["label"]), s(P, { prop: "width", align: "center", label: `宽 (${l(b).width.unit})` }, null, 8, ["label"]), s(P, { prop: "length", align: "center", label: "长 (m)" }), s(P, { prop: "color", label: "颜色", align: "center" }), s(P, { prop: "brand", label: "品牌", align: "center" }), s(P, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [C("span", null, K(l(A)(Y.arrivalTime) ? l(Qi)(Y.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(P, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [C("span", null, K(l(A)(Y.project) ? l(di)(Y.project) : "-"), 1)]), _: 1 }), s(P, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: p(({ row: Y, $index: ee }) => {
        var B, q;
        return [s(L, { content: S(Y) && ((B = l(y)) != null && B.applyAndProcureMeteDiffState) ? `超出最大采购量：${Y.maxCanPurchaseMete} ${l(b).weight.unit}` : "", disabled: !(S(Y) && ((q = l(y)) != null && q.applyAndProcureMeteDiffState)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(O, { icon: "el-icon-plus", disabled: S(Y), type: "warning", size: "default", onClick: (ae) => f(Y, ee) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1032, ["content", "disabled"])];
      }), _: 1 })];
    }), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} }, fq = Object.freeze(Object.defineProperty({ __proto__: null, default: eR }, Symbol.toStringTag, { value: "Module" })), gq = { key: 0 }, Eq = { key: 1 }, yq = { key: 0 }, Tq = { class: "color-green" }, _q = { key: 1 }, tR = { __name: "other-steel-material-table", emits: ["add-purchase"], setup(e, { expose: o, emit: n }) {
  var f;
  const c = n;
  Pe.OTHER_STEEL_MATERIALS.V;
  const u = ft("bcListObj"), r = (f = ft("cu")) == null ? void 0 : f.form, E = ft("purchaseCfg"), { handleMeteChangeCalcPrice: y } = Al("mete"), V = { quantity: [{ validator: (m, R) => R.measureUnit ? !!m : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Vi, message: "核算量必须大于0", trigger: "blur" }] }, { tableValidate: M, wrongCellMask: g } = ui({ rules: V, errorMsg: "请修正【其它钢材清单】中标红的信息" });
  function S(m) {
    var v;
    let R = 0;
    return r.otherSteelMaterialList.forEach((N) => {
      N.applyPurchaseDetailId === m.applyPurchaseDetailId && (R += N.weighingTotalWeight || 0 || N.mete || 0);
    }), !!((v = E.value) != null && v.applyAndProcureMeteDiffState && R && R >= m.maxCanPurchaseMete || r.projectId && m.projectId !== r.projectId);
  }
  function h(m) {
    Ce([() => m.mete], () => y(m));
  }
  function T(m, R) {
    c("add-purchase", m, R);
  }
  function _(m) {
    const { validResult: R } = M(m);
    return R;
  }
  return o({ rowWatch: h, validate: _ }), (m, R) => {
    const v = vt, N = jt, P = Ve("common-button"), L = Ve("common-table"), O = _t("empty-text");
    return w(), U(L, ii({ "cell-class-name": l(g), data: l(u).otherSteelMaterialList, "show-empty-symbol": false, "return-source-data": "" }, m.$attrs), { default: p(() => {
      var x;
      return [s(v, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(v, { align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" }, { default: p(({ row: I }) => [C("span", null, K(I.purchaseSN), 1)]), _: 1 }), s(v, { align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(v, { align: "center", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }), s(v, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: I }) => [s(N, { content: l(Ma)(I), placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(I)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(v, { align: "center", label: "型号", prop: "model", "show-overflow-tooltip": "" }), s(v, { align: "center", label: "计量单位", prop: "measureUnit", "show-overflow-tooltip": "", width: "80" }), s(v, { align: "right", label: "申购数", prop: "quantity" }, { default: p(({ row: I }) => [I.measureUnit ? (w(), Q("span", gq, K(I.originQuantity), 1)) : (w(), Q("span", Eq, "-"))]), _: 1 }), s(v, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: p(({ row: I }) => [qe((w(), Q("span", null, [Te(K(I.accountingUnit), 1)])), [[O]])]), _: 1 }), s(v, { prop: "maxCanPurchaseMete", label: `${(x = l(E)) != null && x.applyAndProcureMeteDiffState ? "最大采购量/申购量" : "申购量"}`, align: "right" }, { default: p(({ row: I }) => {
        var Y;
        return [I.accountingUnit ? (w(), Q("span", yq, [(Y = l(E)) != null && Y.applyAndProcureMeteDiffState ? (w(), Q(Qe, { key: 0 }, [C("span", Tq, K(I.maxCanPurchaseMete), 1), Te(" / " + K(I.originMete), 1)], 64)) : (w(), Q(Qe, { key: 1 }, [Te(K(I.originMete), 1)], 64))])) : (w(), Q("span", _q, "-"))];
      }), _: 1 }, 8, ["label"]), s(v, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "", width: "90" }), s(v, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: p(({ row: I }) => [C("span", null, K(l(A)(I.arrivalTime) ? l(Qi)(I.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), s(v, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: p(({ row: I }) => [C("span", null, K(l(A)(I.project) ? l(di)(I.project) : "-"), 1)]), _: 1 }), s(v, { align: "center", label: "备注", prop: "remark", "show-overflow-tooltip": "" }), s(v, { align: "center", fixed: "right", label: "操作", width: "90" }, { default: p(({ row: I, $index: Y }) => {
        var ee, B;
        return [s(N, { content: S(I) && ((ee = l(E)) != null && ee.applyAndProcureMeteDiffState) ? `超出最大采购量：${I.maxCanPurchaseMete}` : "", disabled: !(S(I) && ((B = l(E)) != null && B.applyAndProcureMeteDiffState)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(P, { disabled: S(I), icon: "el-icon-plus", size: "default", type: "warning", onClick: (q) => T(I, Y) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1032, ["content", "disabled"])];
      }), _: 1 })];
    }), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, bq = Object.freeze(Object.defineProperty({ __proto__: null, default: tR }, Symbol.toStringTag, { value: "Module" })), Vq = { class: "head-container" }, wq = { key: 0 }, Sq = { key: 0 }, iR = { __name: "index", emits: ["requisitionBasicClassChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Z(), r = Z(oa.STEEL_PLATE.V), E = { [oa.STEEL_PLATE.K]: "steelPlateList", [oa.SECTION_STEEL.K]: "sectionSteelList", [oa.STEEL_COIL.K]: "steelCoilList", [oa.OTHER_STEEL_MATERIALS.K]: "otherSteelMaterialList" }, y = Ct({ steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }), b = Ct({ steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }), V = Z({});
  yi("bcListObj", y);
  const M = Ee(() => {
    var R, v;
    const m = [];
    for (const N in oa.ENUM) (R = y[E[N]]) != null && R.length || m.push(oa[N].V);
    return m.length === ((v = Object.keys(oa.ENUM)) == null ? void 0 : v.length) ? [] : m;
  }), g = Ee(() => {
    switch (r.value) {
      case oa.STEEL_PLATE.V:
        return Xv;
      case oa.SECTION_STEEL.V:
        return $v;
      case oa.STEEL_COIL.V:
        return eR;
      default:
        return tR;
    }
  });
  Ce(() => u, () => {
    u.value && S();
  }, { immediate: true, deep: true });
  function S() {
    y[E[oa.VK[r.value]]].forEach((m) => {
      u.value.rowWatch(m);
    });
  }
  function h() {
    const m = b[E[oa.VK[r.value]]];
    console.log(m, "basicList1111");
    const R = m.filter((v) => (V.value.purchaseSN ? v.purchaseSN.indexOf(V.value.purchaseSN) > -1 : true) && (V.value.classifyName ? v.classifyName.indexOf(V.value.classifyName) > -1 : true) && (V.value.serialNumber ? v.serialNumber.indexOf(V.value.serialNumber) > -1 : true) && (V.value.brand ? v.brand.indexOf(V.value.brand) > -1 : true) && (V.value.length ? v.length === Number(V.value.length) : true) && (V.value.thickness ? v.thickness === Number(V.value.thickness) : true) && (V.value.width ? v.width === Number(V.value.width) : true) && (V.value.color ? v.color.indexOf(V.value.color) > -1 : true) && (V.value.specification ? v.specMerge.indexOf(V.value.specification) > -1 : true));
    y[E[oa.VK[r.value]]] = [...R], S();
  }
  function T() {
    V.value = {};
    for (const m in E) y[E[m]] = b[E[m]];
    c("requisitionBasicClassChange", r);
  }
  function _() {
    T();
  }
  function f(m) {
    if (V.value = {}, y.sectionSteelList = [], y.steelPlateList = [], y.steelCoilList = [], y.otherSteelMaterialList = [], b.sectionSteelList = [], b.steelPlateList = [], b.steelCoilList = [], b.otherSteelMaterialList = [], r.value = oa.STEEL_PLATE.V, !(m != null && m.length)) return;
    let R = oa.STEEL_PLATE.V;
    m.forEach((v, N) => {
      y[E[oa.VK[v.basicClass]]].push(Ct(v)), b[E[oa.VK[v.basicClass]]].push(Ct(v)), R = v.basicClass < R || N === 0 ? v.basicClass : R;
    }), r.value = R, S();
  }
  return o({ initList: f }), (m, R) => {
    const v = Ve("common-radio-button"), N = Mt, P = Ve("common-button");
    return w(), Q(Qe, null, [C("div", Vq, [s(v, { modelValue: r.value, "onUpdate:modelValue": R[0] || (R[0] = (L) => r.value = L), disabledVal: M.value, options: l(oa).ENUM, class: "filter-item", clearable: "", type: "enum", onChange: T }, { suffix: p(({ item: L }) => {
      var O;
      return [(O = y[E[L.K]]) != null && O.length ? (w(), Q("span", wq, "(" + K(y[E[L.K]].length) + ")", 1)) : H("", true)];
    }), _: 1 }, 8, ["modelValue", "disabledVal", "options"]), r.value && !(r.value & l(va).MANUFACTURED.V) ? (w(), Q("div", Sq, [s(N, { modelValue: V.value.purchaseSN, "onUpdate:modelValue": R[1] || (R[1] = (L) => V.value.purchaseSN = L), class: "filter-item", clearable: "", placeholder: "申购单号", size: "default", style: { width: "180px" } }, null, 8, ["modelValue"]), s(N, { modelValue: V.value.serialNumber, "onUpdate:modelValue": R[2] || (R[2] = (L) => V.value.serialNumber = L), class: "filter-item", clearable: "", placeholder: "编号", size: "default", style: { width: "180px" } }, null, 8, ["modelValue"]), s(N, { modelValue: V.value.classifyName, "onUpdate:modelValue": R[3] || (R[3] = (L) => V.value.classifyName = L), class: "filter-item", clearable: "", placeholder: "物料种类", size: "default", style: { width: "150px" } }, null, 8, ["modelValue"]), s(N, { modelValue: V.value.specification, "onUpdate:modelValue": R[4] || (R[4] = (L) => V.value.specification = L), class: "filter-item", clearable: "", placeholder: "规格材质", size: "default", style: { width: "140px" } }, null, 8, ["modelValue"]), r.value & l(Pe).SECTION_STEEL.V ? H("", true) : (w(), U(N, { key: 0, modelValue: V.value.thickness, "onUpdate:modelValue": R[5] || (R[5] = (L) => V.value.thickness = L), class: "filter-item", clearable: "", placeholder: "厚", size: "default", style: { width: "100px" } }, null, 8, ["modelValue"])), r.value & l(Pe).SECTION_STEEL.V ? H("", true) : (w(), U(N, { key: 1, modelValue: V.value.width, "onUpdate:modelValue": R[6] || (R[6] = (L) => V.value.width = L), class: "filter-item", clearable: "", placeholder: "宽", size: "default", style: { width: "100px" } }, null, 8, ["modelValue"])), s(N, { modelValue: V.value.length, "onUpdate:modelValue": R[7] || (R[7] = (L) => V.value.length = L), class: "filter-item", clearable: "", placeholder: "长", size: "default", style: { width: "100px" } }, null, 8, ["modelValue"]), r.value & l(Pe).STEEL_COIL.V ? (w(), U(N, { key: 2, modelValue: V.value.color, "onUpdate:modelValue": R[8] || (R[8] = (L) => V.value.color = L), class: "filter-item", clearable: "", placeholder: "颜色", size: "default", style: { width: "100px" } }, null, 8, ["modelValue"])) : H("", true), s(P, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: Pi(h, ["stop"]) }, { default: p(() => R[9] || (R[9] = [Te(" 搜索 ")])), _: 1, __: [9] }), s(P, { class: "filter-item", icon: "el-icon-refresh", size: "default", type: "warning", onClick: Pi(_, ["stop"]) }, { default: p(() => R[10] || (R[10] = [Te(" 重置 ")])), _: 1, __: [10] })])) : H("", true)]), r.value ? (w(), U(Ri(g.value), ii({ key: 0, ref_key: "compRef", ref: u }, m.$attrs), null, 16)) : H("", true)], 64);
  };
} }, vq = Object.freeze(Object.defineProperty({ __proto__: null, default: iR }, Symbol.toStringTag, { value: "Module" })), Rq = { key: 0 }, Mq = { key: 1 }, Aq = { key: 0 }, Nq = { class: "color-green" }, Lq = { key: 1 }, Zu = { __name: "index", emits: ["add-purchase"], setup(e, { expose: o, emit: n }) {
  var R;
  const { handleMeteChangeCalcPrice: c } = Al("mete"), u = n, r = (R = ft("cu")) == null ? void 0 : R.form, E = Z([]), y = ft("purchaseCfg"), V = { quantity: [{ validator: (v, N) => N.measureUnit ? !!v : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Vi, message: "核算量必须大于0", trigger: "blur" }] }, { tableValidate: M, wrongCellMask: g } = ui({ rules: V }), S = Ee(() => {
    switch (r.currentMaterial) {
      case ct.MATERIAL.V:
        return r.auxiliaryMaterialList;
      case ct.OTHER.V:
        return r.otherList;
      default:
        return r.gasList;
    }
  });
  function h(v) {
    var P;
    let N = 0;
    return S.value.forEach((L) => {
      L.applyPurchaseDetailId === v.applyPurchaseDetailId && (N += L.weighingTotalWeight || 0 || L.mete || 0);
    }), !!((P = y.value) != null && P.applyAndProcureMeteDiffState && N && N >= v.maxCanPurchaseMete || r.projectId && v.projectId !== r.projectId);
  }
  function T(v, N) {
    u("add-purchase", v, N);
  }
  function _(v) {
    Ce([() => v.mete], () => c(v));
  }
  function f(v) {
    const { validResult: N } = M(v);
    return N;
  }
  function m(v) {
    E.value = At(v);
  }
  return o({ initList: m, validate: f, rowWatch: _ }), (v, N) => {
    const P = vt, L = jt, O = Ve("common-button"), x = Ve("common-table"), I = _t("empty-text");
    return w(), U(x, ii(v.$attrs, { data: E.value, "cell-class-name": l(g), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: p(() => {
      var Y;
      return [s(P, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), s(P, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: p(({ row: ee }) => [C("span", null, K(ee.purchaseSN), 1)]), _: 1 }), s(P, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), s(P, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: p(({ row: ee }) => [s(L, { content: ee.classifyParentFullName, disabled: !ee.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[I, ee.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(P, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: ee }) => [s(L, { content: l(Ma)(ee), placement: "left" }, { default: p(() => [C("span", null, K(l(Ki)(ee)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(P, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: p(({ row: ee }) => [qe((w(), Q("span", null, [Te(K(ee.measureUnit), 1)])), [[I]])]), _: 1 }), s(P, { prop: "quantity", label: "申购数", align: "right" }, { default: p(({ row: ee }) => [ee.measureUnit ? (w(), Q("span", Rq, K(ee.originQuantity), 1)) : (w(), Q("span", Mq, "-"))]), _: 1 }), s(P, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: p(({ row: ee }) => [qe((w(), Q("span", null, [Te(K(ee.accountingUnit), 1)])), [[I]])]), _: 1 }), s(P, { prop: "maxCanPurchaseMete", label: `${(Y = l(y)) != null && Y.applyAndProcureMeteDiffState ? "最大采购量/申购量" : "申购量"}`, align: "right" }, { default: p(({ row: ee }) => {
        var B;
        return [ee.accountingUnit ? (w(), Q("span", Aq, [(B = l(y)) != null && B.applyAndProcureMeteDiffState ? (w(), Q(Qe, { key: 0 }, [C("span", Nq, K(ee.maxCanPurchaseMete), 1), Te(" / " + K(ee.originMete), 1)], 64)) : (w(), Q(Qe, { key: 1 }, [Te(K(ee.originMete), 1)], 64))])) : (w(), Q("span", Lq, "-"))];
      }), _: 1 }, 8, ["label"]), s(P, { prop: "color", label: "颜色", align: "center" }), s(P, { prop: "brand", label: "品牌", align: "center" }), s(P, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: p(({ row: ee, $index: B }) => {
        var q, ae;
        return [s(L, { content: h(ee) && ((q = l(y)) != null && q.applyAndProcureMeteDiffState) ? `超出最大采购量：${ee.maxCanPurchaseMete}` : "", disabled: !(h(ee) && ((ae = l(y)) != null && ae.applyAndProcureMeteDiffState)), class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(O, { icon: "el-icon-plus", disabled: h(ee), type: "warning", size: "default", onClick: (j) => T(ee, B) }, null, 8, ["disabled", "onClick"])]), _: 2 }, 1032, ["content", "disabled"])];
      }), _: 1 })];
    }), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} }, Iq = Object.freeze(Object.defineProperty({ __proto__: null, default: Zu }, Symbol.toStringTag, { value: "Module" }));
const Cq = { class: "requisition-main-content" }, Pq = { class: "content-left" }, Oq = { class: "content-right" }, kq = { class: "right-head flex-rbs" }, Dq = { class: "requisitions-list" }, xq = { __name: "index", emits: ["add-purchase", "requisitionBasicClassChange"], setup(e, { expose: o, emit: n }) {
  var m;
  const c = n, u = (m = ft("cu")) == null ? void 0 : m.form, r = Z(), E = Z(), y = Z(false), b = Z([]), V = ft("purchaseCfg"), M = Ee(() => {
    var R;
    return ((R = u.requisitions) == null ? void 0 : R.map((v) => v.id)) || [];
  });
  Ce(M, (R, v) => {
    mi(R, v) || h();
  }, { immediate: true, deep: true });
  const g = Ee(() => u == null ? void 0 : u.currentMaterial);
  Ce(g, (R) => {
    h();
  });
  const S = Ee(() => {
    switch (g.value) {
      case ct.STEEL.V:
        return iR;
      case ct.MATERIAL.V:
        return Zu;
      case ct.OTHER.V:
        return Zu;
      default:
        return Zu;
    }
  });
  async function h() {
    var R, v, N, P, L;
    if (b.value = [], !((R = M.value) != null && R.length)) {
      pt(() => {
        var O;
        return (O = E.value) == null ? void 0 : O.initList([]);
      });
      return;
    }
    try {
      y.value = true;
      const O = await av({ ids: M.value }) || [];
      let x = O == null ? void 0 : O.filter((I) => I.basicClass & u.currentMaterial);
      x.map((I) => {
        var Y, ee;
        I.accountingUnit = void 0, I.projectId = (Y = I.project) == null ? void 0 : Y.id, I.projectAttribute = (ee = I.project) == null ? void 0 : ee.projectAttribute, I.applyPurchaseDetailId = I.id;
      }), await Qt(x), b.value = await Ut(x, { toSmallest: false, toNum: true }, { mete: ["mete", "productMete"] });
      for (let I = 0; I < b.value.length; I++) {
        b.value[I].basicClass === Ge.SECTION_STEEL.V && (b.value[I].standardId = b.value[I].standardId || ((v = b.value[I].nationalStandardOptions.find((ae) => ae.boolDefault === true)) == null ? void 0 : v.standardId));
        const Y = b.value[I];
        Y.applyPurchaseDetailId = Y.id, Y.purchaseSN = (N = u.requisitionsKV[Y.applyPurchaseId]) == null ? void 0 : N.serialNumber, Y.productQuantity = Y.productQuantity || 0, Y.productMete = Y.productMete || 0;
        const ee = Y.mete, B = Y.quantity;
        Y.originMete = ee, Y.originQuantity = B;
        const q = ((P = u.detailQuantityAndMetes) == null ? void 0 : P.find((ae) => ae.id === Y.applyPurchaseDetailId)) || {};
        (L = V.value) != null && L.applyAndProcureMeteDiffState ? Y.canPurchaseMete = ee * (1 + V.value.applyAndProcureMeteDiff / 100) - Y.productMete > 0 ? ee * (1 + V.value.applyAndProcureMeteDiff / 100) - Y.productMete : 0 : Y.canPurchaseMete = ee - Y.productMete > 0 ? ee - Y.productMete : 0, Y.maxCanPurchaseMete = Y.canPurchaseMete + ((q == null ? void 0 : q.mete) || 0), Y.maxCanPurchaseMete = Be(Y.maxCanPurchaseMete, Y.accountingPrecision), Y.canPurchaseQuantity = B - Y.productQuantity > 0 ? B - Y.productQuantity : 0, Y.basicClass & ua && (Y.purchaseTotalWeight = Y.mete, Y.weighingTotalWeight = Y.maxCanPurchaseMete, Y.basicClass & Ge.STEEL_PLATE.V && (Y.theoryWeight = await na({ classifyId: Y.classifyId, name: Y.classifyFullName, length: Y.length, width: Y.width, thickness: Y.thickness }), Y.theoryTotalWeight = Y.theoryWeight * Y.quantity), Y.basicClass & Ge.SECTION_STEEL.V && (Y.theoryWeight = await xa({ length: Y.length, unitWeight: Y.unitWeight }), Y.theoryTotalWeight = Y.theoryWeight * Y.quantity, Y.totalLength = Na({ length: Y.length, quantity: Y.quantity })));
      }
      pt(() => {
        var I;
        (I = E.value) == null || I.initList(b.value), y.value = false;
      });
    } catch (O) {
      y.value = false, console.log(O, "获取可采购列表失败");
    }
  }
  function T(R, v) {
    R.uid = Tt(), R.id = void 0, c("add-purchase", R);
  }
  function _(R) {
    c("requisitionBasicClassChange", R);
  }
  async function f() {
    pt(() => {
      var R;
      return (R = r.value) == null ? void 0 : R.fetchList();
    }), await h();
  }
  return o({ openInit: f }), (R, v) => {
    const N = wi, P = oi;
    return w(), Q("div", Cq, [C("div", Pq, [s(l(Jv), { ref_key: "requisitionOrderRef", ref: r }, null, 512)]), v[1] || (v[1] = C("div", { class: "vertical-dashed-divider" }, null, -1)), C("div", Oq, [C("div", kq, [C("span", Dq, [v[0] || (v[0] = C("span", { class: "label" }, "申购清单", -1)), (w(true), Q(Qe, null, ki(l(u).requisitions, (L) => (w(), U(N, { key: L.id, class: "requisitions-sn-tag", effect: "plain", type: "success" }, { default: p(() => [Te(K(L.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), qe((w(), U(Ri(S.value), { ref_key: "compRef", ref: E, onAddPurchase: T, onRequisitionBasicClassChange: _ }, null, 544)), [[P, y.value]])])]);
  };
} }, e2 = ut(xq, [["__scopeId", "data-v-c06a693d"]]), Uq = Object.freeze(Object.defineProperty({ __proto__: null, default: e2 }, Symbol.toStringTag, { value: "Module" }));
function Yq(e) {
  return W({ module: "scm", url: "apply-purchase", method: "get", params: e });
}
function Kq(e) {
  return W({ module: "scm", url: `apply-purchase/${e}`, method: "get" });
}
function bft(e) {
  return W({ module: "scm", url: `apply-purchase/schedule/${e}`, method: "get" });
}
function Vft({ id: e }) {
  return W({ module: "scm", url: `apply-purchase/excel/${e}`, method: "get", responseType: "blob" });
}
function Wq(e) {
  return W({ module: "scm", url: "apply-purchase", method: "post", data: e });
}
function jq(e) {
  return W({ module: "scm", url: "apply-purchase", method: "put", data: e });
}
function Fq(e) {
  return W({ module: "scm", url: "apply-purchase", method: "delete", params: { id: e[0] } });
}
function wft({ id: e, enabled: o }) {
  return W({ module: "scm", url: "apply-purchase/enabled", method: "put", params: { id: e, enabled: o } });
}
function Sft(e) {
  return W({ module: "scm", url: "apply-purchase/brief", method: "get", params: e });
}
function vft(e) {
  return W({ module: "scm", url: "apply-purchase/can-purchase-detail", method: "get", params: e });
}
function zq(e) {
  return W({ module: "scm", url: "purchase-order/purchasing/structure-class", method: "get", params: e });
}
function Bq(e) {
  return W({ module: "scm", url: "purchase-order/purchasing/artifact-enclosure-detail", method: "get", params: e });
}
function Rft(e) {
  return W({ module: "wms", url: "material-inventory/apply-purchase-steel", method: "get", params: e });
}
const Mft = { add: Wq, edit: jq, del: Fq, detail: Kq, get: Yq };
const Hq = { class: "tag-tabs" }, qq = { __name: "tag-tabs", props: { modelValue: { type: [Number, String, Array, void 0], default: void 0 }, data: { type: Array, default: () => [] }, itemKey: { type: String, default: "id" }, itemName: { type: String, default: "name" }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, default: { type: Boolean, default: false }, unselectable: { type: Boolean, default: false }, hit: { type: Boolean, default: true }, unselectedTagType: { type: String, default: "info" }, selectedTagType: { type: String, default: "success" } }, emits: ["update:modelValue", "change"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(), E = Z(), y = Z(), b = Z(0), V = Z(false), M = new ResizeObserver((m) => {
    var v, N;
    if (!(typeof ((v = y.value) == null ? void 0 : v.clientWidth) == "number" && typeof ((N = r.value) == null ? void 0 : N.clientWidth) == "number")) {
      V.value = false;
      return;
    }
    V.value = y.value.clientWidth > r.value.clientWidth;
  });
  Ce(() => y.value, () => {
    y.value && M.observe(y.value);
  }), bl(() => {
    M.unobserve(y.value);
  });
  const g = Z();
  Ce(() => V.value, () => {
    pt(() => {
      var m;
      g.value = ((m = E.value) == null ? void 0 : m.clientWidth) || 0;
    });
  }, { immediate: true });
  const S = Ee(() => {
    var R;
    let m = b.value * g.value;
    return (R = y.value) != null && R.clientWidth && (b.value + 1) * g.value > y.value.clientWidth && (m = y.value.clientWidth - g.value), V.value ? `transform:translateX(-${m}px)` : "";
  });
  function h(m) {
    let R = b.value;
    m === "left" && R--, m === "right" && (R + 1) * g.value < y.value.clientWidth && R++, b.value = R >= 0 ? R : 0;
  }
  function T(m) {
    if (u.unselectable) {
      _(void 0);
      return;
    }
    const R = m[u.itemKey];
    if (!u.multiple) u.modelValue !== R && _(R);
    else {
      const v = u.modelValue ? At(u.modelValue) : [];
      if (!v.includes(R)) v.push(R), _(v);
      else {
        if (u.default && v && (v == null ? void 0 : v.length) === 1) return;
        const N = v.findIndex((P) => P === R);
        N !== -1 && v.splice(N, 1), _(v);
      }
    }
  }
  function _(m) {
    c("update:modelValue", m), c("change", m);
  }
  function f(m) {
    if (m) return u.data.find((R) => R[u.itemKey] === m);
  }
  return o({ getOption: f }), (m, R) => {
    const v = YV, N = ml, P = wi, L = Km;
    return w(), Q("div", Hq, [C("div", { class: "tag-tabs-content", ref_key: "tagTabsContentRef", ref: r }, [V.value ? (w(), Q("span", { key: 0, style: { "margin-right": "5px", cursor: "pointer" }, onClick: R[0] || (R[0] = (O) => h("left")) }, [s(N, null, { default: p(() => [s(v)]), _: 1 })])) : H("", true), C("div", { class: "tag-scroll", ref_key: "tagScrollRef", ref: E }, [C("div", { class: "tag-list", ref_key: "tagListRef", ref: y, style: ri(S.value) }, [(w(true), Q(Qe, null, ki(e.data, (O, x) => (w(), Q("span", { class: "tag-item", key: O[e.itemKey] || x }, [s(P, { hit: e.hit, effect: e.multiple ? e.modelValue.includes(O[e.itemKey]) ? "light" : "plain" : O[e.itemKey] == e.modelValue ? "light" : "plain", type: e.multiple ? e.modelValue.includes(O[e.itemKey]) ? e.selectedTagType : e.unselectedTagType : O[e.itemKey] == e.modelValue ? e.selectedTagType : e.unselectedTagType, "disable-transitions": true, size: e.size, class: Zt({ angle: O.hasAngle }), onClick: (I) => T(O) }, { default: p(() => [xt(m.$slots, "default", { item: O }, void 0, true)]), _: 2 }, 1032, ["hit", "effect", "type", "size", "class", "onClick"])]))), 128))], 4)], 512), V.value ? (w(), Q("span", { key: 1, style: { "margin-left": "5px", cursor: "pointer" }, onClick: R[1] || (R[1] = (O) => h("right")) }, [s(N, null, { default: p(() => [s(L)]), _: 1 })])) : H("", true)], 512)]);
  };
} }, Gq = ut(qq, [["__scopeId", "data-v-8c3b9baa"]]), Qq = { class: "head-container" }, Zq = { style: { float: "right" } }, aR = { __name: "manuf-list", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, maxHeight: { type: Number } }, emits: ["add"], setup(e, { emit: o }) {
  var P;
  const n = o, c = e, u = Z({}), r = Z([]), E = Z([]), y = Z(false), b = Z([]), V = (P = ft("crud")) == null ? void 0 : P.form, { handleSizeChange: M, handleCurrentChange: g, total: S, setTotalPage: h, queryPage: T } = Q_({ fetchHook: m });
  Ce([() => c.projectId, () => u.value.monomerId, () => u.value.areaId], () => {
    u.value.projectId = c.projectId, m();
  }, { immediate: true }), Ce(() => c.visible, (L) => {
    L && R();
  }, { immediate: true });
  function _(L) {
    return !!L.canPurchaseQuantity;
  }
  function f() {
    u.value.monomerId = void 0, u.value.areaId = void 0, u.value.serialNumber = void 0, m();
  }
  async function m() {
    var L;
    if (r.value = [], b.value = [], u.value.structureClassId = void 0, !!u.value.projectId) try {
      const { content: O } = await zq({ ...u.value });
      O != null && O.length && (r.value = O, u.value.structureClassId = (L = O[0]) == null ? void 0 : L.id, R());
    } catch (O) {
      console.log(O, "获取构件类型");
    }
  }
  async function R() {
    if (u.value.structureClassId) try {
      y.value = true;
      const { content: L, totalElements: O } = await Bq({ ...u.value, ...T });
      b.value = L.map((x) => {
        var I;
        if (A((I = V.manufListObj) == null ? void 0 : I[x.id])) {
          const Y = At(V.manufListObj[x.id]);
          x.canPurchaseQuantity = x.quantity - x.purchaseQuantity - Y.curPurchaseQuantity;
        } else x.canPurchaseQuantity = x.quantity - x.purchaseQuantity;
        return x.canPurchaseQuantity = x.canPurchaseQuantity > 0 ? x.canPurchaseQuantity : 0, x.curPurchaseQuantity = x.canPurchaseQuantity, x.basicClass = on.STRUC_MANUFACTURED.V, x;
      }), h(O);
    } catch (L) {
      console.log(L, "获取成品清单");
    } finally {
      y.value = false;
    }
  }
  function v(L) {
    E.value = L;
  }
  function N() {
    if (!E.value.length) {
      ot.warning("请至少选择一条数据");
      return;
    }
    n("add", E.value);
  }
  return (L, O) => {
    const x = Mt, I = Ve("common-button"), Y = vt, ee = Ve("common-input-number"), B = Ve("common-table"), q = Fn, ae = oi;
    return w(), Q("div", null, [C("div", Qq, [s(l(md), { monomerId: u.value.monomerId, "onUpdate:monomerId": O[0] || (O[0] = (j) => u.value.monomerId = j), areaId: u.value.areaId, "onUpdate:areaId": O[1] || (O[1] = (j) => u.value.areaId = j), areaType: l(su).OUTSOURCE.V, clearable: "", areaClearable: "", "project-id": c.projectId }, null, 8, ["monomerId", "areaId", "areaType", "project-id"]), s(x, { modelValue: u.value.serialNumber, "onUpdate:modelValue": O[2] || (O[2] = (j) => u.value.serialNumber = j), modelModifiers: { trim: true }, placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: $i(m, ["enter"]) }, null, 8, ["modelValue"]), s(I, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: Pi(m, ["stop"]) }, { default: p(() => O[4] || (O[4] = [Te("搜索")])), _: 1, __: [4] }), s(I, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: Pi(f, ["stop"]) }, { default: p(() => O[5] || (O[5] = [Te(" 重置 ")])), _: 1, __: [5] }), C("div", null, [r.value.length ? (w(), U(l(Gq), { key: 0, modelValue: u.value.structureClassId, "onUpdate:modelValue": O[3] || (O[3] = (j) => u.value.structureClassId = j), class: "filter-item", style: ri(["width:calc(100% - 230px)", { display: "inline-block" }]), data: r.value, itemKey: "id", onChange: R }, { default: p(({ item: j }) => [C("span", null, K(j.name) + "(件/kg)：", 1), C("span", null, K(j.quantity) + "/" + K(j.mete), 1)]), _: 1 }, 8, ["modelValue", "data"])) : H("", true), C("span", Zq, [s(I, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-plus", onClick: N }, { default: p(() => O[6] || (O[6] = [Te(" 选择加入 ")])), _: 1, __: [6] })])])]), qe((w(), U(B, { data: b.value, "max-height": e.maxHeight, style: { width: "100%" }, onSelectionChange: v }, { default: p(() => [s(Y, { type: "selection", width: "55", align: "center", selectable: _ }), s(Y, { label: "序号", type: "index", align: "center", width: "60" }), s(Y, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), s(Y, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), s(Y, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(Y, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(Y, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), s(Y, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), s(Y, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), s(Y, { prop: "quantity", label: "清单数量", align: "center", "show-overflow-tooltip": "" }), s(Y, { prop: "canPurchaseQuantity", label: "可采购数量", align: "center", "show-overflow-tooltip": "" }), s(Y, { label: "采购数量", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }, { default: p(({ row: { sourceRow: j } }) => [s(ee, { modelValue: j.curPurchaseQuantity, "onUpdate:modelValue": (le) => j.curPurchaseQuantity = le, min: 0, max: j.canPurchaseQuantity, "controls-position": "right", controls: false, step: 5, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), s(Y, { prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height"])), [[ae, y.value]]), s(q, { total: l(S), "current-page": l(T).pageNumber, "page-size": l(T).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(M), onCurrentChange: l(g) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} }, Jq = Object.freeze(Object.defineProperty({ __proto__: null, default: aR }, Symbol.toStringTag, { value: "Module" })), lR = { __name: "price-set-columns", props: { weightAttribute: { type: String, default: "weighingTotalWeight" }, form: { type: Object, default: void 0 }, isRequiredIdentifier: { type: Boolean, default: false } }, setup(e) {
  const o = e, { handleUnitPriceChange: n, handleAmountChange: c } = Al(o.weightAttribute);
  return (u, r) => {
    const E = Ve("common-input-number"), y = vt;
    return w(), Q(Qe, null, [s(y, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, Zl({ default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.unitPrice, "onUpdate:modelValue": (V) => b.unitPrice = V, controls: false, disabled: b.boolOriginalDetail ? !!b.boolUsed : false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (V) => l(n)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])) : H("", true)]), _: 2 }, [e.isRequiredIdentifier ? { name: "header", fn: p(() => [r[0] || (r[0] = C("span", { style: { color: "red" } }, "*", -1)), r[1] || (r[1] = Te("含税单价 "))]), key: "0" } : void 0]), 1024), s(y, { align: "center", label: "金额", prop: "amount", width: "135px" }, Zl({ default: p(({ row: b }) => [b ? (w(), U(E, { key: 0, modelValue: b.amount, "onUpdate:modelValue": (V) => b.amount = V, controls: false, disabled: b.boolOriginalDetail ? !!b.boolUsed : false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "金额", size: "default", onChange: (V) => l(c)(V, b) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : H("", true)]), _: 2 }, [e.isRequiredIdentifier ? { name: "header", fn: p(() => [r[2] || (r[2] = C("span", { style: { color: "red" } }, "*", -1)), r[3] || (r[3] = Te("金额 "))]), key: "0" } : void 0]), 1024)], 64);
  };
} }, Xq = Object.freeze(Object.defineProperty({ __proto__: null, default: lR }, Symbol.toStringTag, { value: "Module" })), $q = { key: 1 }, oR = { __name: "index", setup(e, { expose: o }) {
  var P;
  const n = Ge.MATERIAL.V, { purchaseCfg: c } = aa(), u = ft("matSpecRef"), r = (P = ft("cu")) == null ? void 0 : P.form, E = ft("cu");
  function y({ row: L, rowIndex: O }) {
    var x, I;
    if ((I = (x = E == null ? void 0 : E.submitResult) == null ? void 0 : x.data) != null && I.includes(L.classifyId)) return { backgroundColor: "#ffdede" };
  }
  const b = { [Pe.STEEL_PLATE.V]: "steelPlateList", [Pe.SECTION_STEEL.V]: "sectionSteelList", [Pe.STEEL_COIL.V]: "steelCoilList", [Pe.OTHER_STEEL_MATERIALS.V]: "otherSteelMaterials", [Pe.MATERIAL.V]: "MATERIAL", [Pe.OTHER.V]: "OTHER", [Pe.GAS.V]: "GAS" }, V = Z();
  Ce(() => r, (L) => {
    V.value = r[b[L.currentBasicClass]];
  }, { deep: true }), Dt(() => {
    var x;
    (A(r.steelPlateList) || A(r.sectionSteelList) || A(r.steelCoilList) || A(r.otherSteelMaterials) || A(r.MATERIAL) || A(r.OTHER) || A(r.GAS)) && (r.list = [...r.steelPlateList, ...r.sectionSteelList, ...r.steelCoilList, ...r.otherSteelMaterials, ...r.MATERIAL, ...r.OTHER, ...r.GAS]);
    let L = 0, O = 0;
    A(r.list) && ((x = r.list) == null || x.forEach((I) => {
      r.currentBasicClass & ct.STEEL.V && (O += I.mete || 0, r.meteUnit = "kg"), L += Number(I.amount) || 0;
    })), r.amount = Be(L, Ze.YUAN), r.mete = O;
  });
  const g = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Vi, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (L, O) => A(O.mete) && A(O.unitPrice) ? +Be(O.mete * O.unitPrice, Ze.YUAN) == +L : false, message: "金额有误，请手动修改", trigger: "blur" }] }, { handleMeteChangeCalcPrice: S } = Al("mete"), { tableValidate: h, wrongCellMask: T } = ui({ rules: g });
  function _(L) {
    var I, Y;
    let O;
    L.classify.basicClass === Pe.SECTION_STEEL.V && (O = (Y = (I = L.nationalStandardOptions) == null ? void 0 : I.find((ee) => ee.boolDefault === true)) == null ? void 0 : Y.standardId);
    const x = Ct({ uid: Tt(), sn: L.sn, specificationLabels: L.specificationLabels, serialNumber: L.serialNumber, classifyId: L.classify.id, classifyFullPathId: L.classify.fullPathId, classifyFullName: L.classify.fullName, classifyName: L.classify.name, classifySerialNumber: L.classify.serialNumber, classifyParentFullName: L.classify.parentFullName, basicClass: L.classify.basicClass, model: L.model, specification: L.spec, specificationMap: L.specKV, accountingUnit: L.classify.accountingUnit, accountingPrecision: L.classify.accountingPrecision, measurePrecision: L.classify.measurePrecision, outboundUnitType: L.classify.outboundUnitType, unitNet: L.unitNet, accountingUnitNet: L.accountingUnitNet, nationalStandardOptions: L.nationalStandardOptions, mete: L.mete, inboundMete: 0, unitPrice: L.unitPrice, remark: L.remark, standardId: O, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0 });
    if (L.classify.basicClass === Pe.SECTION_STEEL.V) {
      let ee;
      const B = [];
      for (const q in x.specificationMap) q.indexOf("standard") > -1 ? ee = x.specificationMap[q] : B.push(x.specificationMap[q]);
      x.sectionSteelSpec = ee, x.doNotSectionSteelSpec = B.join(" * "), x.placeholder = "定尺长";
    } else L.classify.basicClass === Pe.STEEL_PLATE.V || L.classify.basicClass === Pe.STEEL_COIL.V ? x.placeholder = "厚 * 宽 * 长" : x.placeholder = "规格";
    return f(x), x;
  }
  function f(L) {
    Ce([() => L.mete], () => {
      S(L);
    });
  }
  const m = { steelPlateList: r.steelPlateList, sectionSteelList: r.sectionSteelList, steelCoilList: r.steelCoilList, otherSteelMaterials: r.otherSteelMaterials, MATERIAL: r.MATERIAL, OTHER: r.OTHER, GAS: r.GAS };
  function R(L, O) {
    var x, I, Y, ee, B, q, ae, j, le, oe, ye;
    if (u.value) u.value.delListItem(L.sn, O);
    else {
      let ce = "";
      for (const se in m) r[se].forEach((he) => {
        he.basicClass === L.basicClass && (ce = se);
      });
      if ((x = r[ce]) == null || x.splice(O, 1), r.list.splice(O, 1), (Y = (I = E == null ? void 0 : E.submitResult) == null ? void 0 : I.data) != null && Y.includes(L.classifyId)) {
        const se = (ee = E == null ? void 0 : E.submitResult) == null ? void 0 : ee.data.findIndex((be) => be === L.classifyId);
        r.list.filter((be) => be.classifyId === L.classifyId).length === 1 && ((B = E == null ? void 0 : E.submitResult) == null || B.data.splice(se, 1));
      }
      A(r.copyList) && r.copyList.splice(r.copyList.findIndex((se) => se.id === L.id), 1);
    }
    if (((q = r.list) == null ? void 0 : q.length) !== ((ae = r.copyList) == null ? void 0 : ae.length)) {
      const ce = (j = r.project) == null ? void 0 : j.findIndex((se) => se.id === L.projectId);
      r.project.splice(ce, 1);
    }
    if (((le = r.list) == null ? void 0 : le.length) === ((oe = r.copyList) == null ? void 0 : oe.length)) {
      const ce = (ye = r.copyList) == null ? void 0 : ye.filter((se) => se.projectId === L.projectId);
      if (!(ce != null && ce.length)) {
        const se = r.project.findIndex((he) => he.id === L.projectId);
        r.project.splice(se, 1);
      }
    }
  }
  function v(L) {
    L.amount = A(L.unitPrice) ? Be(L.unitPrice * L.mete, Ze.YUAN) : void 0;
  }
  function N() {
    var x;
    if (Ae(r.steelPlateList) && Ae(r.sectionSteelList) && Ae(r.steelCoilList) && Ae(r.otherSteelMaterials) && Ae(r.MATERIAL) && Ae(r.OTHER) && Ae(r.GAS)) return ot.warning("请填写数据"), false;
    const { validResult: L } = h(r.list);
    r.basicClass = 0, r.steelPlateList.length && (r.basicClass = r.basicClass | Pe.STEEL_PLATE.V), r.sectionSteelList.length && (r.basicClass = r.basicClass | Pe.SECTION_STEEL.V), r.steelCoilList.length && (r.basicClass = r.basicClass | Pe.STEEL_COIL.V), r.otherSteelMaterials.length && (r.basicClass = r.basicClass | Pe.OTHER_STEEL_MATERIALS.V), r.MATERIAL.length && (r.basicClass = r.basicClass | Pe.MATERIAL.V), r.OTHER.length && (r.basicClass = r.basicClass | Pe.OTHER.V), r.GAS.length && (r.basicClass = r.basicClass | Pe.GAS.V);
    const O = (x = r.list) == null ? void 0 : x.find((I) => {
      var Y, ee;
      return (ee = (Y = E == null ? void 0 : E.submitResult) == null ? void 0 : Y.data) == null ? void 0 : ee.includes(I.classifyId);
    });
    return A(O) ? (ot.error("请先删除标红数据并重新添加"), false) : L;
  }
  return o({ rowInit: _, validate: N, rowWatch: f }), (L, O) => {
    const x = vt, I = jt, Y = Mt, ee = Ve("common-input-number"), B = Ve("common-button"), q = Ve("common-table"), ae = _t("empty-text");
    return w(), U(q, ii({ "cell-class-name": l(T), data: V.value, "row-style": y, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, L.$attrs), { default: p(() => [s(x, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(x, { align: "center", fixed: "left", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), s(x, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: j }) => [s(I, { content: j.classifyParentFullName, disabled: !j.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ae, j.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(x, { align: "center", fixed: "left", label: "规格", prop: "model", "show-overflow-tooltip": "" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.model, "onUpdate:modelValue": (le) => j.model = le, modelModifiers: { trim: true }, disabled: !!l(r).boolUsed, placeholder: j.placeholder, maxlength: "60", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "placeholder"])]), _: 1 }), s(x, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: j }) => [s(I, { content: j.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ae, j.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), s(x, { align: "center", label: "采购量", prop: "mete" }, { default: p(({ row: j }) => {
      var le;
      return [!l(r).useRequisitions || l(r).useRequisitions && ((le = l(c)) == null ? void 0 : le.quantity) & l(n) && j.outboundUnitType === l(hi).MEASURE.V ? (w(), U(ee, { key: 0, modelValue: j.mete, "onUpdate:modelValue": (oe) => j.mete = oe, controls: false, disabled: !!l(r).boolUsed, max: 999999999, min: 0, precision: j.measurePrecision, step: 1, placeholder: "采购量", size: "default", onChange: (oe) => v(j) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision", "onChange"])) : qe((w(), Q("span", $q, [Te(K(j.mete || "-"), 1)])), [[ae]])];
    }), _: 1 }), s(x, { align: "center", label: "单位", prop: "accountingUnit" }, { default: p(({ row: j }) => [qe((w(), Q("span", null, [Te(K(j.accountingUnit), 1)])), [[ae]])]), _: 1 }), s(lR, { "weight-attribute": "mete" }), s(x, { align: "center", label: "备注", prop: "remark" }, { default: p(({ row: j }) => [s(Y, { modelValue: j.remark, "onUpdate:modelValue": (le) => j.remark = le, modelModifiers: { trim: true }, disabled: !!l(r).boolUsed, maxlength: "60", placeholder: "备注", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(r).boolUsed ? H("", true) : (w(), U(x, { key: 0, align: "center", fixed: "right", label: "操作", width: "70" }, { default: p(({ row: j, $index: le }) => [s(B, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (oe) => R(j, le) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} }, eG = Object.freeze(Object.defineProperty({ __proto__: null, default: oR }, Symbol.toStringTag, { value: "Module" }));
const tG = { class: "main-content" }, iG = { class: "form-content" }, aG = { class: "form-left" }, lG = { key: 0 }, oG = { key: 0 }, nG = { class: "flex-rss child-mr-10" }, sG = { key: 0 }, rG = { key: 0 }, uG = { key: 0 }, cG = { key: 0 }, dG = { style: { "word-break": "break-all" } }, mG = { class: "form-right" }, pG = { __name: "submit-preview", props: { modelValue: { type: Boolean, default: false }, loading: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false }, edit: { type: Boolean, default: false } }, emits: ["update:modelValue", "submit"], setup(e, { emit: o }) {
  var h;
  const n = Ht(), { supplierKV: c } = hu(), u = Z(), r = o, E = e, y = (h = ft("cu")) == null ? void 0 : h.form, b = ft("cu"), { visible: V, handleClose: M } = Ta({ emit: r, props: E }), { maxHeight: g } = Kt({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, u);
  Ce(() => y, (T) => {
    console.log(T);
  }, { deep: true, immediate: true }), Ce(() => b == null ? void 0 : b.submitResult, () => {
    var T;
    ((T = b == null ? void 0 : b.submitResult) == null ? void 0 : T.code) === 40206 && (n.dispatch("config/fetchMatClsTree"), b.submitResult.code = null, n.state.config.classifySpec = { specKV: [] });
  }, { deep: true });
  function S(T) {
    r("submit", T), setTimeout(() => {
      M();
    });
  }
  return (T, _) => {
    const f = Ve("common-button"), m = Zi, R = Ml, v = Li, N = Ve("common-drawer"), P = _t("parse-enum");
    return w(), U(N, { ref_key: "drawerRef", ref: u, modelValue: l(V), "onUpdate:modelValue": _[3] || (_[3] = (L) => Gt(V) ? V.value = L : null), "before-close": l(M), direction: "rtl", size: "100%", title: "提交预览" }, { titleRight: p(() => [l(Ai)(l(DS).scmTemporaryStoragePM.add) && e.isPassedEdit && !E.edit ? (w(), U(f, { key: 0, loading: e.loading, size: "default", type: "warning", onClick: _[0] || (_[0] = (L) => S(l(co).YES.V)) }, { default: p(() => _[4] || (_[4] = [Te(" 暂存 ")])), _: 1, __: [4] }, 8, ["loading"])) : H("", true), s(f, { loading: e.loading, size: "default", type: "success", onClick: l(M) }, { default: p(() => _[5] || (_[5] = [Te(" 上一步 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"]), s(f, { loading: e.loading, size: "default", type: "primary", onClick: _[1] || (_[1] = (L) => S(l(co).NO.V)) }, { default: p(() => _[6] || (_[6] = [Te(" 发起审批 ")])), _: 1, __: [6] }, 8, ["loading"])]), content: p(() => [C("div", tG, [l(A)(l(y)) ? (w(), U(v, { key: 0, model: l(y), "label-position": "left", "label-width": "100px", size: "default" }, { default: p(() => [C("div", iG, [C("div", aG, [s(m, { label: "项目经理", prop: "projectManagerName" }, { default: p(() => {
      var L, O;
      return [(L = l(y).projectManager) != null && L.name ? (w(), Q("span", lG, K(((O = l(y).projectManager) == null ? void 0 : O.name) || "-"), 1)) : H("", true)];
    }), _: 1 }), s(m, { label: "所属项目", prop: "projects" }, { default: p(() => [l(y).projects ? (w(), Q("span", oG, K(l(y).projects.fullName), 1)) : H("", true)]), _: 1 }), s(m, { label: "材料类型", prop: "basicClass" }, { default: p(() => [C("div", nG, [l(y).materialType & l(ct).MATERIAL.V ? H("", true) : qe((w(), Q("span", sG, null, 512)), [[P, { e: l(ct), v: l(y).materialType, extra: "：" }]]), qe(C("span", null, null, 512), [[P, { e: l(Pe), v: l(y).basicClass, bit: true, split: " | " }]])])]), _: 1 }), s(m, { label: "供应商", prop: "supplier" }, { default: p(() => [l(y).supplierId ? (w(), Q("span", rG, K(l(c)[l(y).supplierId].shortName), 1)) : H("", true)]), _: 1 }), s(m, { label: "签订主体", prop: "purchaseOrderBranchCompanyDTO", style: { width: "100%" } }, { default: p(() => [l(y).branchCompany ? (w(), Q("span", uG, K(l(y).branchCompany.name), 1)) : H("", true)]), _: 1 }), l(y).materialType & l(ct).STEEL.V ? (w(), U(m, { key: 0, label: "合同量", prop: "mete" }, { default: p(() => [C("span", null, K(l(y).mete) + " " + K(l(y).meteUnit), 1)]), _: 1 })) : H("", true), s(m, { label: "发票税率", prop: "branchCompanyName", style: { width: "100%" } }, { default: p(() => [qe(C("span", null, null, 512), [[P, { e: l(fi), v: l(y).invoiceType }]]), l(y).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", cG, "（" + K(l(y).taxRate) + "%）", 1)) : H("", true)]), _: 1 }), s(m, { label: "物流方式", prop: "logistics" }, { default: p(() => [qe(C("span", null, null, 512), [[P, { e: l(Bi), v: l(y).logisticsPayerType }]])]), _: 1 }), s(m, { label: "合同额", prop: "amount" }, { default: p(() => [C("span", null, K(l(y).amount) + " 元", 1)]), _: 1 }), s(m, { label: "物流信息", prop: "logistics" }, { default: p(() => [qe(C("span", null, null, 512), [[P, { e: l(Bi), v: l(y).logisticsPayerType }]])]), _: 1 }), s(m, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: p(() => [C("span", dG, K(l(y).remark), 1)]), _: 1 }), s(R, null, { default: p(() => _[7] || (_[7] = [C("span", { class: "title" }, "附件", -1)])), _: 1, __: [7] }), s(dl, { files: l(y).attachments, "onUpdate:files": _[2] || (_[2] = (L) => l(y).attachments = L), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])]), _[9] || (_[9] = C("div", { class: "vertical-dashed-divider" }, null, -1)), C("div", mG, [_[8] || (_[8] = C("div", { class: "right-head flex-rbs" }, [C("span", { class: "right-head-content" }, [C("span", { class: "label" }, "采购清单")])], -1)), s(ad, { list: l(y).list, "material-type": l(y).materialType, "max-height": l(g) - 150 }, null, 8, ["list", "material-type", "max-height"])])])]), _: 1 }, 8, ["model"])) : H("", true)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, nR = ut(pG, [["__scopeId", "data-v-cb979075"]]), hG = Object.freeze(Object.defineProperty({ __proto__: null, default: nR }, Symbol.toStringTag, { value: "Module" }));
Pe.STEEL_PLATE.V;
Pe.SECTION_STEEL.V;
Pe.STEEL_COIL.V;
async function Ju(e) {
  var c, u;
  e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterials = [], e.MATERIAL = [], e.OTHER = [], e.GAS = [];
  const o = [];
  let n;
  for (const r of e.list) {
    switch (r.uid = r.id, r.weighingTotalWeight = r.mete, r.specificationMap = r.specKV, r.projectId = r.projectId || ((c = r.project) == null ? void 0 : c.id), r.warehouseId = r.warehouseId || ((u = r.warehouse) == null ? void 0 : u.id), r.basicClass) {
      case Pe.STEEL_PLATE.V:
        e.steelPlateList.push(r);
        break;
      case Pe.SECTION_STEEL.V:
        e.sectionSteelList.push(r);
        break;
      case Pe.STEEL_COIL.V:
        e.steelCoilList.push(r);
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        e.otherSteelMaterials.push(r);
        break;
      case Pe.MATERIAL.V:
        e.MATERIAL.push(r);
        break;
      case Pe.GAS.V:
        e.GAS.push(r);
        break;
      case Pe.OTHER.V:
        e.OTHER.push(r);
        break;
    }
    o.push(n);
  }
  await Promise.all(o);
}
const sR = { title: "辅材采购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "型号", field: "model", excelField: "__EMPTY_2" }, { label: "单位", field: "accountingUnit", excelField: "__EMPTY_3" }, { label: "采购量", field: "mete", type: "number", excelField: "__EMPTY_4" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_5" }, { label: "备注", field: "remark", excelField: "__EMPTY_6" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M, g, S;
  if (!gi(e, sR.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => true), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [];
  if (u.forEach((h) => {
    let T = false;
    const _ = pi(h.classifyName.split("/"));
    if (_.length === 1) {
      const f = n.filter((m) => m.name === h.classifyName) || [];
      if (A(f)) if (f.length === 1) T = true, h.classifyId = f[0].id, r.push(f[0].id);
      else {
        const m = [];
        for (const v of f) if (v.isLeaf) for (let N = 0; N < v.fullPathId.length; N++) v.id !== v.fullPathId[N] && m.push(v.fullPathId[N]);
        const R = f.find((v) => Ae(v.parent) && !m.includes(v.id));
        if (A(R)) T = true, h.classifyId = R.id, r.push(R.id);
        else {
          const v = f.filter((N) => N.isLeaf) || [];
          if (v.length === 1) {
            let N = true;
            f.forEach((P) => {
              v[0].fullPathId.includes(P.id) || (N = false);
            }), N && (T = true, h.classifyId = v[0].id, r.push(v[0].id));
          } else for (const N of f) A(N.parent) && !m.includes(N.id) && y.push(N);
        }
      }
      if (y.length > 1) throw new Error(`科目名称“${h.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const f of n) if (f.fullPathName.length >= _.length && mi(f.fullPathName.slice(-_.length), _)) {
      T = true, h.classifyId = f.id, r.push(f.id);
      break;
    }
    if (T || E.push(h.classifyName), h.shortName) {
      const f = _e.state.project.projectAllType.find((m) => m.shortName === h.shortName);
      h.projectId = f.id;
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((h) => `“${h}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  const b = _e.state.config.classifySpec, V = r.filter((h) => b[h] === void 0);
  V.length > 0 && (V.forEach((h) => {
    b[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", V));
  for (const h of u) {
    if (((M = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : M.isLeaf) === false) throw new Error(`${h.classifyName}不是末级科目`);
    const T = b[h.classifyId];
    if (T.hasUnitConfig === false) throw new Error(`${h.classifyName}未配置核算单位`);
    let _;
    const f = h.specification ?? "";
    if (T && Array.isArray(T.specList)) {
      for (const m of T.specList) if (f === m.spec) {
        if (_ = m, h.measureUnit) {
          if (!_.classify.measureUnit) throw new Error(`${h.classifyName}不存在计量单位`);
          if (!await ti(_.classify.measureUnit, h.measureUnit)) throw new Error(`${h.classifyName}填写的计量单位错误，单位应为：“${_.classify.measureUnit}”`);
        }
        if (h.accountingUnit && !await ti(_.classify.accountingUnit, h.accountingUnit)) throw new Error(`${h.classifyName}填写的核算单位错误，单位应为：“${_.classify.accountingUnit}”`);
        break;
      }
    }
    if (_) {
      let m;
      if (_.classify.basicClass & Pe.SECTION_STEEL.V && (m = (S = (g = _.nationalStandardOptions) == null ? void 0 : g.find((R) => R.boolDefault === true)) == null ? void 0 : S.standardId), h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.standardId = m, h.sectionSteelSpec = void 0, h.doNotSectionSteelSpec = void 0, h.basicClass & Pe.SECTION_STEEL.V) {
        let R;
        const v = [];
        for (const N in h.specificationMap) N.indexOf("standard") > -1 ? R = h.specificationMap[N] : v.push(h.specificationMap[N]);
        h.sectionSteelSpec = R, h.doNotSectionSteelSpec = v.join(" * ");
      }
      h.measureUnit || (h.quantity = void 0), h.mete && h.unitPrice && (h.amount = Be(h.mete * h.unitPrice, Ze.YUAN));
    } else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} };
const fG = { style: { display: "flex" } }, gG = { style: { flex: "1", "text-align": "right" } }, EG = { class: "main-content" }, yG = { class: "order-details" }, TG = { class: "flex-rss child-mr-10" }, _G = { class: "flex-rss child-mr-10" }, bG = { class: "flex-rss child-mr-10" }, VG = { class: "form-right" }, wG = { key: 0, class: "right-head flex-rbs" }, SG = { class: "right-head-content" }, vG = { key: 0, class: "label" }, RG = { key: 0 }, MG = { key: 0, class: "opt-content" }, AG = { key: 1, class: "right-head flex-rbs" }, NG = { class: "right-head-content" }, LG = { key: 0 }, IG = { key: 2, class: "right-head flex-rec" }, CG = { class: "opt-content" }, PG = { key: 5, class: "table-remark" }, OG = { class: "con" }, kG = { class: "con" }, DG = { key: 6 }, xG = { __name: "has-detail-form", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, Approval: { type: Boolean, default: false }, isRequisition: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false } }, emits: "success", setup(e, { emit: o }) {
  const n = Ht(), c = o, u = { attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterials: [], MATERIAL: [], OTHER: [], GAS: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {} }, r = e, E = ft("supplyUsedProject"), y = ft("projectAllType"), b = Z(false), V = Ee(() => {
    let Ye = [];
    return h.materialType & ct.STEEL.V ? (Ye.push(ct.GAS.V), Ye.push(ct.MATERIAL.V), Ye.push(ct.OTHER.V)) : h.materialType ? Ye.push(ct.STEEL.V) : Ye = [], h.id && A(Ie.value) && (Ye = [...Ye, ...Ie.value]), Ye;
  }), M = Z([]), g = Z(), { cu: S, form: h, FORM: T } = Pa({ title: "采购合同", formStore: !r.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: u, useDraftCallback: _, clearDraftCallback: f, api: r.edit ? gw : fw }, g, r.detail);
  Ce(() => r.detail, (Ye = {}) => {
    h.boolInSourcing = Ye.boolInSourcing, h.useRequisitions = Ye.useRequisitions, h.materialType = r.detail.materialType, h.purchaseType = r.detail.purchaseType, h.currentBasicClass = r.detail.currentBasicClass, h.supplyType = r.detail.supplyType, h.boolUsed = r.detail.boolUsed;
  }, { deep: true, immediate: true }), yi("cu", S);
  function _() {
  }
  function f() {
  }
  const m = (Ye, Fe, et) => {
    h.boolTemporaryStorage || (h.invoiceType || h.invoiceType === 0 ? h.invoiceType === fi.SPECIAL.V && !h.taxRate ? et(new Error("请选择税率")) : et() : et(new Error("请选择发票及税率"))), et();
  }, R = (Ye, Fe, et) => {
    Ye.field === "supplierId" && (A(h.supplierId) || et(new Error(Ye.message))), Ye.field === "projectManagerId" && (A(h.projectManagerId) || et(new Error(Ye.message))), Ye.field === "projectId" && (A(h.projectId) || et(new Error(Ye.message))), !h.boolTemporaryStorage && !Fe && et(new Error(Ye.message)), et();
  }, v = Z({}), N = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], materialType: [{ required: true, validator: R, message: "请选择材料类型", trigger: "change" }], projectManagerId: [{ required: true, validator: R, message: "请选择项目经理", trigger: "change" }], projectId: [{ required: true, validator: R, message: "请选择项目", trigger: "change" }], supplyType: [{ required: true, validator: R, message: "请选择供货类型", trigger: "change" }], supplierId: [{ required: true, validator: R, message: "请选择供应商", trigger: "change" }], boolInSourcing: [{ required: true, message: "请选择是否为内包制", trigger: "change" }] }, P = { logisticsPayerType: [{ required: true, validator: R, message: "请选择物流费用承担方", trigger: "change" }], invoiceType: [{ required: true, validator: m, trigger: "change" }], taxRate: [{ max: 2, validator: R, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, validator: R, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, validator: R, message: "请填写合同额", trigger: "blur" }] }, O = { auxMaterialIds: [{ required: true, validator: (Ye, Fe, et) => {
    !h.boolTemporaryStorage && !Fe && (h.isAllMaterial || Fe ? et() : et(new Error("请选择辅材"))), et();
  }, trigger: "change" }] }, I = { otherMaterialIds: [{ required: true, validator: (Ye, Fe, et) => {
    !h.boolTemporaryStorage && !Fe && (h.isAllOtherMaterial || Fe ? et() : et(new Error("请选择办公类型科目"))), et();
  }, trigger: "change" }] }, ee = { gasMaterialIds: [{ required: true, validator: (Ye, Fe, et) => {
    !h.boolTemporaryStorage && !Fe && (h.isAllGAS || Fe ? et() : et(new Error("请选择气体科目"))), et();
  }, trigger: "change" }] };
  Dt(() => {
    if (r.dialogVisible) {
      const Ye = v.value;
      tw(Ye), Object.assign(Ye, N), Object.assign(Ye, P), h.materialType & ct.MATERIAL.V && !h.useRequisitions && Object.assign(Ye, O), h.materialType & ct.OTHER.V && !h.useRequisitions && Object.assign(Ye, I), h.materialType & ct.GAS.V && !h.useRequisitions && Object.assign(Ye, ee), pt(() => {
        g.value && g.value.clearValidate();
      });
    }
  });
  const B = Ee(() => false);
  Ce(() => h.materialType, async (Ye, Fe) => {
    h.currentMaterial = h.materialType, Ye & ct.MATERIAL.V && (h.basicClass = h.materialType, h.currentBasicClass = Pe.MATERIAL.V), Ye & ct.OTHER.V && (h.basicClass = h.materialType, h.currentBasicClass = Pe.OTHER.V), Ye & ct.STEEL.V && (h.basicClass = Pe.STEEL_PLATE.V | Pe.STEEL_COIL.V | Pe.SECTION_STEEL.V | Pe.OTHER_STEEL_MATERIALS.V, h.currentBasicClass = Pe.STEEL_PLATE.V), Ye & ct.GAS.V && (h.basicClass = h.materialType, h.currentBasicClass = Pe.GAS.V), await ae(Ye, Fe);
  }, { deep: true }), Ce(() => h.materialType, (Ye, Fe) => {
    const et = Js(Pe.ENUM, Ye), lt = Js(Pe.ENUM, Fe);
    Ye === ct.STEEL.V ? M.value = et : Ye ? (et.length > lt.length ? et == null || et.forEach((bt) => {
      let gt = false;
      lt == null || lt.forEach((qt) => {
        bt.V === qt.V && (gt = true);
      }), gt || M.value.push(bt);
    }) : lt == null || lt.forEach((bt) => {
      let gt = false;
      if (et == null || et.forEach((qt) => {
        bt.V === qt.V && (gt = true);
      }), !gt) {
        const qt = M.value.findIndex((kt) => kt.V === bt.V);
        M.value.splice(qt, 1), h.list = [], h.MATERIAL = [], h.OTHER = [], h.GAS = [], h.requisitionsKV = {}, h.actualRequisitionIds = [], h.manufListObj = {}, be.value && be.value.clear();
      }
    }), h.currentBasicClass = M.value[M.value.length - 1].V) : M.value = [];
  }, { immediate: true });
  const q = Ee(() => h.materialType ? oR : null), ae = (Ye, Fe) => {
    Fe !== ct.STEEL.V && Ye === ct.STEEL.V && (h.MATERIAL = [], h.OTHER = [], h.GAS = [], h.list = [], h.requisitionsKV = {}, h.actualRequisitionIds = [], h.manufListObj = {}, h.manufMergeObj = {}, h.mete = 0, h.amount = 0, be.value && be.value.clear()), Fe === ct.STEEL.V && Ye !== ct.STEEL.V && (h.sectionSteelList = [], h.steelPlateList = [], h.steelCoilList = [], h.otherSteelMaterials = [], h.list = [], h.requisitionsKV = {}, h.actualRequisitionIds = [], h.manufListObj = {}, h.manufMergeObj = {}, h.mete = 0, h.amount = 0, be.value && be.value.clear());
  }, j = { [Pe.STEEL_PLATE.V]: "steelPlateList", [Pe.SECTION_STEEL.V]: "sectionSteelList", [Pe.STEEL_COIL.V]: "steelCoilList", [Pe.OTHER_STEEL_MATERIALS.V]: "otherSteelMaterials", [Pe.MATERIAL.V]: "MATERIAL", [Pe.OTHER.V]: "OTHER", [Pe.GAS.V]: "GAS" }, le = Z(false);
  Ce(() => h.isAllMaterial, (Ye, Fe) => {
    var et;
    if (Ye === true) {
      h.auxMaterialIds = [];
      return;
    }
    !le.value && ((et = h.auxMaterialIds) == null ? void 0 : et.length) === 0 && Ye === false && h[j[Pe.MATERIAL.V]].length !== 0 && (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), h.isAllMaterial = Fe);
  }, { deep: true }), Ce(() => h.isAllGAS, (Ye, Fe) => {
    var et;
    if (Ye === true) {
      h.gasMaterialIds = [];
      return;
    }
    !le.value && ((et = h.gasMaterialIds) == null ? void 0 : et.length) === 0 && Ye === false && h[j[Pe.GAS.V]].length !== 0 && (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), h.isAllGAS = Fe);
  }, { deep: true }), Ce(() => h.isAllOtherMaterial, (Ye, Fe) => {
    var et;
    if (Ye === true) {
      h.otherMaterialIds = [];
      return;
    }
    !le.value && ((et = h.otherMaterialIds) == null ? void 0 : et.length) === 0 && (Ye || h[j[Pe.OTHER.V]].length !== 0 && (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), h.isAllOtherMaterial = Fe));
  }, { deep: true }), Ce(() => h.otherMaterialIds, (Ye, Fe) => {
    if (h.isAllOtherMaterial !== true && !le.value && Fe && (Ye == null ? void 0 : Ye.length) < (Fe == null ? void 0 : Fe.length)) {
      let et, lt = true;
      Ye.length ? (Fe == null || Fe.forEach((bt) => {
        let gt = false;
        Ye == null || Ye.forEach((qt) => {
          qt && bt === qt && (gt = true);
        }), gt || (et = bt);
      }), h[j[Pe.OTHER.V]].length && h[j[Pe.OTHER.V]].forEach((bt) => {
        bt.classifyId === et && (lt = false);
      })) : h[j[Pe.OTHER.V]].length && (lt = false), lt || (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), pt(() => {
        h.otherMaterialIds = Fe;
      }));
    }
  }, { deep: true }), Ce(() => h.gasMaterialIds, (Ye, Fe) => {
    if (h.isAllGAS !== true && !le.value && Fe && (Ye == null ? void 0 : Ye.length) < (Fe == null ? void 0 : Fe.length)) {
      let et, lt = true;
      Ye.length ? (Fe == null || Fe.forEach((bt) => {
        let gt = false;
        Ye == null || Ye.forEach((qt) => {
          qt && bt === qt && (gt = true);
        }), gt || (et = bt);
      }), h[j[Pe.MATERIAL.V]].length && h[j[Pe.MATERIAL.V]].forEach((bt) => {
        bt.classifyId === et && (lt = false);
      })) : h[j[Pe.MATERIAL.V]].length && (lt = false), lt || (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), pt(() => {
        h.otherMaterialIds = Fe;
      }));
    }
  }, { deep: true }), Ce(() => h.auxMaterialIds, (Ye, Fe) => {
    if (h.isAllMaterial !== true && !le.value && Fe && (Ye == null ? void 0 : Ye.length) < (Fe == null ? void 0 : Fe.length)) {
      let et, lt = true;
      Ye.length ? (Fe == null || Fe.forEach((bt) => {
        let gt = false;
        Ye == null || Ye.forEach((qt) => {
          qt && bt === qt && (gt = true);
        }), gt || (et = bt);
      }), h[j[Pe.GAS.V]].length && h[j[Pe.GAS.V]].forEach((bt) => {
        bt.classifyId === et && (lt = false);
      })) : h[j[Pe.GAS.V]].length && (lt = false), lt || (ot.error("采购清单已有该类型科目数据，请先清除该科目数据"), pt(() => {
        h.otherMaterialIds = Fe;
      }));
    }
  }, { deep: true });
  const oe = Ee(() => sR), ye = Ee(() => h.project || []), ce = Z(), se = Z(), he = Z(), be = Z(), me = Z(false), ge = Z(false), Le = Z([]), Ie = Z([]), Se = Ee(() => {
    var Ye;
    return (Ye = h.list) == null ? void 0 : Ye.filter((Fe) => {
      var et, lt;
      return (lt = (et = S == null ? void 0 : S.submitResult) == null ? void 0 : et.data) == null ? void 0 : lt.includes(Fe.classifyId);
    });
  });
  yi("matSpecRef", be), Ce(() => be.value, () => {
    var Ye;
    (Ye = be.value) == null || Ye.initSelected(h[j[h.currentBasicClass]]);
  });
  const { maxHeight: X } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => {
    var Ye;
    return (Ye = se.value) == null ? void 0 : Ye.loaded;
  }), { maxHeight: $ } = Kt({ mainBox: ".manufactured-select-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 50, minHeight: 300 }, () => {
    var Ye;
    return (Ye = he.value) == null ? void 0 : Ye.loaded;
  });
  function k(Ye) {
    return ce.value.rowInit(Ye);
  }
  function J() {
    var Ye, Fe, et;
    if (h.materialType & ct.MATERIAL.V && !h.isAllMaterial && !((Ye = h.auxMaterialIds) != null && Ye.length)) {
      ot.warning("请先选择辅材明细");
      return;
    }
    if (h.materialType & ct.OTHER.V && !h.isAllOtherMaterial && !((Fe = h.otherMaterialIds) != null && Fe.length)) {
      ot.warning("请先选择办公类型明细");
      return;
    }
    h.materialType & ct.GAS.V && !h.isAllGAS && !((et = h.gasMaterialIds) != null && et.length) && ot.warning("请先选择气体明细");
  }
  function z() {
    var Ye, Fe, et, lt;
    if (A(Se.value) && A((Ye = S == null ? void 0 : S.submitResult) == null ? void 0 : Ye.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    if (h.materialType & ct.MATERIAL.V && !h.isAllMaterial && !((Fe = h.auxMaterialIds) != null && Fe.length)) {
      ot.warning("请先选择辅材明细");
      return;
    }
    if (h.materialType & ct.OTHER.V && !h.isAllOtherMaterial && !((et = h.otherMaterialIds) != null && et.length)) {
      ot.warning("请先选择办公类型明细");
      return;
    }
    if (h.materialType & ct.GAS.V && !h.isAllGAS && !((lt = h.gasMaterialIds) != null && lt.length)) {
      ot.warning("请先选择气体明细");
      return;
    }
    me.value = true;
  }
  function F(Ye) {
    for (let Fe = 0; Fe < Ye.length; Fe++) {
      const et = At(Ye[Fe]), lt = et.curPurchaseQuantity * et.netWeight || 0;
      Ae(h.manufListObj[et.id]) ? h.manufListObj[et.id] = { ...et, rowKey: et.id, curPurchaseWeight: lt } : (h.manufListObj[et.id].curPurchaseQuantity += et.curPurchaseQuantity, h.manufListObj[et.id].curPurchaseWeight = Be(h.manufListObj[et.id].curPurchaseWeight + lt, 2));
    }
    ge.value = false;
  }
  async function G(Ye) {
    var Fe, et;
    try {
      let lt = true;
      if (Ye.forEach((Ii) => {
        var ra, wa, Eo;
        if (Ii.basicClass & h.materialType || (lt = false), !h.isAllMaterial && ((ra = h.auxMaterialIds) != null && ra.length)) for (let da = 0; da < h.auxMaterialIds.length; da++) if (Ii.classifyId !== h.auxMaterialIds[da]) lt = false;
        else {
          lt = true;
          return;
        }
        if (!h.isAllGAS && ((wa = h.gasMaterialIds) != null && wa.length)) for (let da = 0; da < h.gasMaterialIds.length; da++) if (Ii.classifyId !== h.gasMaterialIds[da]) lt = false;
        else {
          lt = true;
          return;
        }
        if (!h.isAllOtherMaterial && ((Eo = h.otherMaterialIds) != null && Eo.length)) for (let da = 0; da < h.otherMaterialIds.length; da++) if (Ii.classifyId !== h.otherMaterialIds[da]) lt = false;
        else {
          lt = true;
          return;
        }
      }), !lt) {
        ot({ type: "error", message: "清单内存在当前所选材料类型以外的物料" });
        return;
      }
      const bt = j[h.currentBasicClass];
      h.list.push.apply(h.list, Ye), await Ju(h);
      const gt = h[bt].length, qt = h[bt].length;
      if ((Fe = ce.value) != null && Fe.rowWatch) for (let Ii = gt; Ii < qt; Ii++) (et = ce.value) == null || et.rowWatch(h[bt][Ii]);
      const kt = Ce(be, () => {
        be.value && (be.value.initSelected(Ye.map((Ii) => ({ sn: Ii.sn, classifyId: Ii.classifyId }))), pt(() => {
          kt();
        }));
      }, { immediate: true });
    } catch (lt) {
      ot.error({ message: lt.message, duration: 5e3 });
    }
  }
  function ie(Ye) {
    Ye === Pe.MATERIAL.V && (h.isAllMaterial = false, h.auxMaterialIds = []), Ye === Pe.GAS.V && (h.isAllGAS = false, h.gasMaterialIds = []), Ye === Pe.OTHER.V && (h.isAllOtherMaterial = false, h.otherMaterialIds = []);
  }
  function ue() {
    le.value = true, h.isAllMaterial = false, h.auxMaterialIds = [], h.isAllGAS = false, h.gasMaterialIds = [], h.isAllOtherMaterial = false, h.otherMaterialIds = [], h.MATERIAL = [], h.OTHER = [], h.GAS = [], h.list = [], h.requisitionsKV = {}, h.actualRequisitionIds = [], h.manufListObj = {}, h.manufMergeObj = {}, pt(() => {
      h.mete = 0;
    }), h.amount = 0, be.value && be.value.clear();
  }
  const ne = Z(), te = Z(false);
  Dt(() => {
    var bt;
    h.requisitions = Ps(h.requisitionsKV);
    const Ye = ["steelPlateList", "steelCoilList", "sectionSteelList", "otherSteelMaterialList"], Fe = ["MATERIAL", "OTHER", "GAS"], et = h.materialType & ct.STEEL.V ? Ye : Fe, lt = [];
    if (A(et)) for (let gt = 0; gt < et.length; gt++) {
      const qt = [];
      (bt = h[et[gt]]) == null || bt.forEach((kt) => {
        kt.applyPurchaseId ? h.requisitions.findIndex((Ii) => Ii.id === kt.applyPurchaseId) > -1 && (lt.push(kt.applyPurchaseId), A(h.requisitionsKV) && A(h.requisitionsKV[kt.applyPurchaseId]) && (h.requisitionsKV[kt.applyPurchaseId].purchaseCreationState = h.requisitionsKV[kt.applyPurchaseId].purchaseCreationState || ys.DURING.V), qt.push(kt)) : qt.push(kt);
      }), h[et[gt]] = qt;
    }
    h.actualRequisitionIds = Tn(lt);
  });
  function de() {
    if (!h.branchCompanyId) {
      ot.warning("请先选择签订主体");
      return;
    }
    Ae(n.state.config.getTreeClickTime) && n.dispatch("fetchTreeClickTime"), te.value = true, Ae(n.state.config.getTreeClickTime) && n.commit("SET_CLICK_TIME"), pt(() => {
      var Ye;
      return (Ye = ne.value) == null ? void 0 : Ye.openInit();
    });
  }
  function pe(Ye) {
    var Fe;
    Ye.basicClass & ct.STEEL.V && (Ye.weightMeasurementMode = h.weightMeasurementMode && h.weightMeasurementMode !== Wt.MIXTURE.V ? h.weightMeasurementMode : Wt.THEORY.V, Ye.weighingTotalWeight = Ye.mete), h.requisitions.findIndex((et) => et.id === Ye.applyPurchaseId) > -1 && (h.actualRequisitionIds.includes(Ye.applyPurchaseId) || h.actualRequisitionIds.push(Ye.applyPurchaseId), A(h.requisitionsKV) && A(h.requisitionsKV[Ye.applyPurchaseId]) && (h.requisitionsKV[Ye.applyPurchaseId].purchaseCreationState = ys.DURING.V)), h[j[Ye.basicClass]].push(Ye), Ye.basicClass & h.currentBasicClass && ((Fe = ce.value) == null || Fe.rowWatch(Ye));
  }
  function re(Ye) {
    let Fe = [];
    A(Ye == null ? void 0 : Ye.basicClass) && (Fe = Js(Pe.ENUM, Ye.basicClass, "V"));
    const et = [];
    for (let gt = 0; gt < Fe.length; gt++) et.push({ V: Fe[gt] });
    const lt = [], bt = [];
    for (const gt in ct.ENUM) et.findIndex((qt) => qt.V & ct.ENUM[gt].V) < 0 ? lt.findIndex((qt) => qt.V === ct.ENUM[gt].V) < 0 && (lt.push(ct.ENUM[gt]), bt.push(ct.ENUM[gt].V)) : Le.value.push(ct.ENUM[gt].V);
    Ie.value = h.id ? bt : [];
  }
  function we() {
    r.isPassedEdit && h.boolSysgen && (Oe.value.supplierId === h.supplierId ? h.serialNumber = Oe.value.serialNumber : h.serialNumber = void 0);
  }
  const Ke = Z(false);
  async function Me() {
    var Fe;
    if (A(Se.value)) return ot.error("请先删除标红数据并重新添加"), false;
    if (h.boolTemporaryStorage = false, !await g.value.validate() || ce.value && !((Fe = ce.value) != null && Fe.validate()) && !h.boolUsed) return false;
    Ke.value = true;
  }
  T.HOOK.afterToCU = () => {
    h.clickAddTime = (/* @__PURE__ */ new Date()).getTime();
  }, T.HOOK.beforeValidateCU = () => {
    b.value = false;
  };
  async function Ne() {
    let Ye = true;
    const Fe = [], et = [];
    h.projectId && (!r.edit || r.edit && h.projectId !== h.originEditProjectId) && et.push(h.projectId);
    for (let lt = 0; lt < et.length; lt++) {
      const bt = et[lt];
      if (E.value.includes(bt) && Fe.findIndex((gt) => gt.id === bt) < 0) {
        const gt = y.value.find((qt) => qt.id === bt);
        Fe.push(gt);
      }
    }
    if (A(Fe)) {
      const lt = Fe.map((bt) => bt.name).join("、");
      await zi.confirm(`您已经为《${lt}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        Ye = true;
      }).catch((bt) => {
        Ye = false;
      });
    }
    return Ye;
  }
  T.HOOK.beforeSubmit = async () => {
    var Fe, et;
    return r.isPassedEdit && r.edit && (h.dataStatus === rl.PASSED.V && (S.api = Ic), h.dataStatus === rl.UNDER_APPROVAL.V && (S.api = Cc)), h.clickTime = n.state.config.getTreeClickTime, h.weightMeasurementMode = void 0, h.boolTemporaryStorage === false && !((Fe = ce.value) != null && Fe.validate()) && !h.boolUsed || !((et = g.value) != null && et.validate()) ? false : await Ne();
  }, T.HOOK.afterSubmit = async () => {
    Ie.value = [], Le.value = [], await n.dispatch("config/fetchSupplyUsedProject"), c("success");
  }, S.submitFormFormat = async (Ye) => (await Qt(Ye.list), Ye.attachmentIds = Ye.attachments ? Ye.attachments.map((Fe) => Fe.id) : void 0, Ye.auxMaterialIds = Ye.isAllMaterial ? [0] : Ye.auxMaterialIds, Ye.otherMaterialIds = Ye.isAllOtherMaterial ? [0] : Ye.otherMaterialIds, Ye.gasMaterialIds = Ye.isAllGAS ? [0] : Ye.gasMaterialIds, Ye.projectId && (Ye.projectIds = [Ye.projectId]), Ye.useRequisitions && (Ye.applyPurchaseIds = Ye.actualRequisitionIds), B.value ? (Ye.list = [], ce != null && ce.value && (ce == null ? void 0 : ce.value.fetchResList()).forEach((et) => {
    const { curPurchaseQuantity: lt, basicClass: bt } = Ye.manufListObj[et.rowKey];
    Ye.list.push({ artifactEnclosureId: et.id, quantity: lt, basicClass: bt, pricingMethod: et.pricingMethod, unitPrice: et.unitPrice, amount: et.amount, destination: et.destination });
  })) : Ye.list = await Ut(Ye.list, { toSmallest: true, toNum: true }), Ye.useRequisitions && Ye.list.forEach((Fe) => {
    Fe.applyPurchaseDetailId || (Fe.applyPurchaseDetailId = Fe.id);
  }), Ye);
  async function He(Ye) {
    try {
      if (A(Se.value)) return ot.error("请先删除标红数据并重新添加"), false;
      h.boolTemporaryStorage = !!Ye, S.form.clickTime = n.state.config.getTreeClickTime, await S.submit();
    } catch (Fe) {
      console.log("采购合同提交", Fe);
    }
  }
  const ze = Z([]), Oe = Z({});
  async function Re() {
    await hw({}).then((Fe) => {
      ze.value = Fe;
    });
  }
  function fe(Ye) {
    var Fe;
    r.isRequisition ? h.boolInSourcing = false : h.boolInSourcing = true, h.projectId = void 0, h.projects = {}, h.projectManager = (Fe = ze.value) == null ? void 0 : Fe.find((et) => et.id === h.projectManagerId);
  }
  T.HOOK.beforeToEdit = async (Ye, Fe) => {
    Fe.list = _s(Fe.copyList), Oe.value.serialNumber = Fe.serialNumber, Oe.value.supplierId = Fe.supplierId;
  };
  const { branchCompanyEnum: Ue } = qv();
  async function Je(Ye) {
    var Fe, et, lt, bt;
    if (r.isRequisition) {
      if (h.boolInSourcing = false, Ye) {
        h.list = h.copyList;
        const gt = [];
        (Fe = h.list) == null || Fe.forEach((qt, kt) => {
          var Ii;
          ((Ii = qt.project) == null ? void 0 : Ii.id) === Ye && gt.push(qt);
        }), h.list = gt, await Ju(h);
      }
    } else h.boolInSourcing = true, h.useRequisitions = false;
    h.branchCompanyId = void 0, A(h.projectId) && (h.projects = y.value.find((gt) => gt.id === h.projectId), h.branchCompanyId = (et = h.projects) == null ? void 0 : et.contractSignBodyId, Ue.value.length > 0 && (h.branchCompany = Ue.value.find((gt) => gt.id === h.branchCompanyId)), h.boolInSourcing = ((lt = h.projects) == null ? void 0 : lt.projectAttribute) === vl.LUMP_SUM_SYSTEM.V, h.projectAttribute = (bt = h.projects) == null ? void 0 : bt.projectAttribute);
  }
  function Xe() {
    r.isRequisition ? setTimeout(async () => {
      h.list = h.copyList, await Ju(h);
    }, 200) : h.useRequisitions = false, h.branchCompanyId = void 0, h.projects = {}, h.projectId = void 0;
  }
  return El(() => {
    Re();
  }), (Ye, Fe) => {
    const et = Ve("common-button"), lt = Ve("common-radio"), bt = Zi, gt = Mt, qt = Ve("common-select"), kt = Fo, Ii = Ve("common-radio-button"), ra = wi, wa = jt, Eo = Li, da = Ve("common-drawer");
    return w(), Q("div", null, [C("div", fG, [C("div", null, [xt(Ye.$slots, "chose", {}, void 0, true)]), C("div", gG, [s(et, { size: "default", type: "primary", onClick: Me }, { default: p(() => Fe[28] || (Fe[28] = [Te(" 下一步 ")])), _: 1, __: [28] }), (e.isPassedEdit ? e.isPassedEdit && !r.edit : r.edit) ? (w(), U(et, { key: 0, size: "default", type: "warning", onClick: Fe[0] || (Fe[0] = (Tl) => He(l(co).YES.V)) }, { default: p(() => Fe[29] || (Fe[29] = [Te(" 暂 存 ")])), _: 1, __: [29] })) : H("", true)])]), C("div", EG, [s(Eo, { ref_key: "detailFormRef", ref: g, model: l(h), rules: v.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: p(() => {
      var Tl, os, ns, Cn, ao, Vl, Qo, Sa;
      return [C("div", { style: ri(`height: ${e.maxHeight.value}px`), class: "form-content" }, [C("div", { style: ri(b.value ? "width:0px;padding:0;" : ""), class: "form-left" }, [C("div", yG, [l(h).boolInSourcing ? H("", true) : (w(), U(bt, { key: 0, label: "是否绑定申购", prop: "useRequisitions", required: "" }, { default: p(() => [s(lt, { modelValue: l(h).useRequisitions, "onUpdate:modelValue": Fe[1] || (Fe[1] = (it) => l(h).useRequisitions = it), disabled: !!l(h).boolUsed && r.isRequisition, options: l(ea).ENUM, type: "enum", onChange: ue }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })), s(bt, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: p(() => [s(gt, { modelValue: l(h).serialNumber, "onUpdate:modelValue": Fe[2] || (Fe[2] = (it) => l(h).serialNumber = it), modelModifiers: { trim: true }, disabled: !!l(h).boolUsed && (r.rewriting || r.edit), class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), B.value ? H("", true) : (w(), U(bt, { key: 1, class: "el-form-item-3", label: "项目经理", prop: "projectManagerId" }, { default: p(() => [s(qt, { modelValue: l(h).projectManagerId, "onUpdate:modelValue": Fe[3] || (Fe[3] = (it) => l(h).projectManagerId = it), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !!l(h).boolUsed, options: ze.value, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择项目经理", size: "default", style: { width: "100%" }, type: "other", onChange: fe }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })), B.value ? H("", true) : (w(), U(bt, { key: 2, class: "el-form-item-3", label: "项目", prop: "projectId" }, { default: p(() => [s(ca, { modelValue: l(h).projectId, "onUpdate:modelValue": Fe[4] || (Fe[4] = (it) => l(h).projectId = it), dataStructure: { key: "id", label: "name", value: "id" }, defaultOptions: ye.value, disabled: !l(A)(l(h).projectManagerId) && !!l(h).boolUsed, projectManagerId: l(h).projectManagerId, class: "input-underline", clearable: "", "is-not-self-support": "", style: { width: "100%" }, onChange: Je, onClear: Xe }, null, 8, ["modelValue", "defaultOptions", "disabled", "projectManagerId"])]), _: 1 })), s(bt, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: p(() => [s(J_, { modelValue: l(h).branchCompanyId, "onUpdate:modelValue": Fe[5] || (Fe[5] = (it) => l(h).branchCompanyId = it), defaultLevel: l(h).boolInSourcing ? "" : l(ou).CONSTRUCTION_SITE.V, disabled: true, class: "input-underline", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "defaultLevel"])]), _: 1 }), s(bt, { class: "el-form-item-3", label: "材料类型", prop: "materialType" }, { default: p(() => [s(qt, { modelValue: l(h).materialType, "onUpdate:modelValue": Fe[6] || (Fe[6] = (it) => l(h).materialType = it), disabled: l(h).id && Le.value.length === 1 || !!l(h).boolUsed, disabledVal: V.value, options: l(ct).ENUM, class: "input-underline", clearable: "", mode: "bit", multiple: "", placeholder: "请选择材料类型", size: "default", style: { width: "100%" }, type: "enum", onClear: ue, onRemoveTag: ie }, null, 8, ["modelValue", "disabled", "disabledVal", "options"])]), _: 1 }), l(h).materialType & l(ct).MATERIAL.V && !l(h).useRequisitions ? (w(), U(bt, { key: 3, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: p(() => [C("div", TG, [s(kt, { modelValue: l(h).isAllMaterial, "onUpdate:modelValue": Fe[7] || (Fe[7] = (it) => l(h).isAllMaterial = it), disabled: !!l(h).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(h).auxMaterialIds, "onUpdate:modelValue": Fe[8] || (Fe[8] = (it) => l(h).auxMaterialIds = it), "basic-class": l(Pe).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: l(h).boolUsed ? !!l(h).boolUsed : l(h).isAllMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), l(h).materialType & l(ct).OTHER.V && !l(h).useRequisitions ? (w(), U(bt, { key: 4, class: "el-form-item-5", label: "办公用品明细", prop: "otherMaterialIds" }, { default: p(() => [C("div", _G, [s(kt, { modelValue: l(h).isAllOtherMaterial, "onUpdate:modelValue": Fe[9] || (Fe[9] = (it) => l(h).isAllOtherMaterial = it), disabled: !!l(h).boolUsed, border: "", label: "所有办公用品科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(h).otherMaterialIds, "onUpdate:modelValue": Fe[10] || (Fe[10] = (it) => l(h).otherMaterialIds = it), "basic-class": l(Pe).OTHER.V, "collapse-tags": false, deep: 2, disabled: l(h).boolUsed ? !!l(h).boolUsed : l(h).isAllOtherMaterial, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择办公用品科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), l(h).materialType & l(ct).GAS.V && !l(h).useRequisitions ? (w(), U(bt, { key: 5, class: "el-form-item-5", label: "气体明细", prop: "gasMaterialIds" }, { default: p(() => [C("div", bG, [s(kt, { modelValue: l(h).isAllGAS, "onUpdate:modelValue": Fe[11] || (Fe[11] = (it) => l(h).isAllGAS = it), disabled: !!l(h).boolUsed, border: "", label: "所有气体科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(h).gasMaterialIds, "onUpdate:modelValue": Fe[12] || (Fe[12] = (it) => l(h).gasMaterialIds = it), "basic-class": l(Pe).GAS.V, "collapse-tags": false, deep: 2, disabled: l(h).boolUsed ? !!l(h).boolUsed : l(h).isAllGAS, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择气体科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), s(bt, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: p(() => [s(pd, { modelValue: l(h).supplierId, "onUpdate:modelValue": Fe[13] || (Fe[13] = (it) => l(h).supplierId = it), "basic-class": l(h).materialType, disabled: !!l(h).boolUsed || r.rewriting || r.edit, type: l(h).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "cross", onChange: we, onInfoChange: re }, null, 8, ["modelValue", "basic-class", "disabled", "type"])]), _: 1 }), s(bt, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: p(() => [s(Xn, { invoiceType: l(h).invoiceType, "onUpdate:invoiceType": Fe[14] || (Fe[14] = (it) => l(h).invoiceType = it), taxRate: l(h).taxRate, "onUpdate:taxRate": Fe[15] || (Fe[15] = (it) => l(h).taxRate = it), classification: l(h).materialType, disabled: !!l(h).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), s(bt, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: p(() => [s(lt, { modelValue: l(h).logisticsPayerType, "onUpdate:modelValue": Fe[16] || (Fe[16] = (it) => l(h).logisticsPayerType = it), disabled: !!l(h).boolUsed, options: l(Bi).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(bt, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: p(() => [s(gt, { modelValue: l(h).remark, "onUpdate:modelValue": Fe[17] || (Fe[17] = (it) => l(h).remark = it), disabled: !!l(h).boolUsed, rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(dl, { files: l(h).attachments, "onUpdate:files": Fe[18] || (Fe[18] = (it) => l(h).attachments = it), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])], 4), C("div", { style: ri(b.value ? "display:none;" : ""), class: "vertical-dashed-divider" }, null, 4), C("div", VG, [s(D1, { "is-active": b.value, class: "hamburger-container", onToggleClick: Fe[19] || (Fe[19] = (it) => b.value = !b.value) }, null, 8, ["is-active"]), l(h).useRequisitions ? (w(), Q("div", wG, [C("span", SG, [l(h).useRequisitions ? (w(), Q("span", vG, " 关联申购单号 ")) : H("", true), l(h).materialType & l(ct).STEEL.V && !l(h).boolUsed ? (w(), U(Ii, { key: 1, modelValue: l(h).currentBasicClass, "onUpdate:modelValue": Fe[20] || (Fe[20] = (it) => l(h).currentBasicClass = it), options: l(oa).ENUM, clearable: "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "enum" }, { suffix: p(({ item: it }) => {
        var tt, Vt;
        return [(tt = l(h)[j[it.V]]) != null && tt.length ? (w(), Q("span", RG, "(" + K((Vt = l(h)[j[it.V]]) == null ? void 0 : Vt.length) + ")", 1)) : H("", true)];
      }), _: 1 }, 8, ["modelValue", "options"])) : H("", true), (w(true), Q(Qe, null, ki(l(h).actualRequisitionIds, (it) => (w(), U(ra, { key: it, class: "preparation-sn-tag", effect: "plain", size: "large" }, { default: p(() => {
        var tt, Vt, Nt;
        return [Te(K((Vt = (tt = l(h).requisitionsKV) == null ? void 0 : tt[it]) == null ? void 0 : Vt.serialNumber) + " ", 1), (Nt = l(h).requisitionsKV) != null && Nt[it] ? (w(), U(qt, { key: 0, modelValue: l(h).requisitionsKV[it].purchaseCreationState, "onUpdate:modelValue": (Rt) => l(h).requisitionsKV[it].purchaseCreationState = Rt, disabled: !!l(h).boolUsed, options: l(ys).ENUM, class: "input-border-none", placeholder: "请选择采购状态", size: "default", style: { width: "130px" }, type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])) : H("", true)];
      }), _: 2 }, 1024))), 128))]), !l(h).boolUsed && l(h).materialType ? (w(), Q("span", MG, [s(et, { disabled: l(Ae)(l(h).branchCompanyId), size: "default", type: "success", onClick: de }, { default: p(() => Fe[30] || (Fe[30] = [Te(" 选择申购物料 ")])), _: 1, __: [30] }, 8, ["disabled"])])) : H("", true)])) : H("", true), l(h).useRequisitions ? H("", true) : (w(), Q("div", AG, [C("span", NG, [Fe[31] || (Fe[31] = C("span", { class: "label" }, "采购清单", -1)), !l(h).boolUsed && !l(h).useRequisitions ? (w(), U(Ii, { key: 0, modelValue: l(h).currentBasicClass, "onUpdate:modelValue": Fe[21] || (Fe[21] = (it) => l(h).currentBasicClass = it), disabledVal: [], options: M.value, clearable: "", style: { "vertical-align": "middle" }, type: "enum" }, { suffix: p(({ item: it }) => {
        var tt, Vt;
        return [(tt = l(h)[j[it.V]]) != null && tt.length ? (w(), Q("span", LG, " (" + K((Vt = l(h)[j[it.V]]) == null ? void 0 : Vt.length) + ") ", 1)) : H("", true)];
      }), _: 1 }, 8, ["modelValue", "options"])) : H("", true)])])), !l(h).boolUsed && l(h).materialType ? (w(), Q("div", IG, [C("span", CG, [B.value ? H("", true) : (w(), U(et, { key: 0, class: "filter-item", size: "default", type: "success", onClick: z }, { default: p(() => Fe[32] || (Fe[32] = [Te(" 添加物料 ")])), _: 1, __: [32] })), !B.value && !(!(l(h).materialType & l(ct).MATERIAL.V && !l(h).isAllMaterial && !((Tl = l(h).auxMaterialIds) != null && Tl.length)) && !(l(h).materialType & l(ct).OTHER.V && !l(h).isAllOtherMaterial && !((os = l(h).otherMaterialIds) != null && os.length)) && !(l(h).materialType & l(ct).GAS.V && !l(h).isAllGAS && !((ns = l(h).gasMaterialIds) != null && ns.length))) ? (w(), U(et, { key: 1, class: "filter-item", icon: "el-icon-upload", size: "default", type: "warning", onClick: J }, { default: p(() => Fe[33] || (Fe[33] = [Te(" 清单导入 ")])), _: 1, __: [33] })) : H("", true), !B.value && !(l(h).materialType & l(ct).MATERIAL.V && !l(h).isAllMaterial && !((Cn = l(h).auxMaterialIds) != null && Cn.length)) && !(l(h).materialType & l(ct).OTHER.V && !l(h).isAllOtherMaterial && !((ao = l(h).otherMaterialIds) != null && ao.length)) && !(l(h).materialType & l(ct).GAS.V && !l(h).isAllGAS && !((Vl = l(h).gasMaterialIds) != null && Vl.length)) ? (w(), U(wa, { key: 2, content: "请删除全部标红数据", disabled: !(l(A)(Se.value) && l(A)((Sa = (Qo = l(S)) == null ? void 0 : Qo.submitResult) == null ? void 0 : Sa.data)), class: "item", effect: "dark", placement: "top" }, { default: p(() => {
        var it, tt;
        return [s(Ro, { disabled: l(A)(Se.value) && l(A)((tt = (it = l(S)) == null ? void 0 : it.submitResult) == null ? void 0 : tt.data), template: oe.value, "btn-name": "清单导入", "btn-size": "default", "btn-type": "warning", class: "filter-item", icon: "el-icon-upload", "open-loading": "", style: { "margin-left": "10px" }, onSuccess: G }, null, 8, ["disabled", "template"])];
      }), _: 1 }, 8, ["disabled"])) : H("", true), !B.value && !l(h).boolUsed ? (w(), U(ia, { key: 3, fn: l(uu), params: { basicClass: l(h).currentBasicClass, receiptType: l(xc).BG_PURCHASE.V }, class: "filter-item", style: { "margin-left": "10px" }, type: "info" }, { default: p(() => Fe[34] || (Fe[34] = [Te(" 清单模板下载 ")])), _: 1, __: [34] }, 8, ["fn", "params"])) : H("", true), s(wa, { disabled: !!l(h).projectId, content: "请先选择项目", effect: "light", placement: "left-start" }, { default: p(() => [C("span", null, [B.value ? (w(), U(et, { key: 0, disabled: !l(h).projectId, class: "filter-item", icon: "el-icon-plus", size: "default", type: "success", onClick: Fe[22] || (Fe[22] = (it) => ge.value = true) }, { default: p(() => Fe[35] || (Fe[35] = [Te(" 添加制成品 ")])), _: 1, __: [35] }, 8, ["disabled"])) : H("", true)])]), _: 1 }, 8, ["disabled"])])])) : H("", true), l(h).boolUsed ? (w(), U(ad, { key: 4, "bool-use-requisitions": l(h).useRequisitions, list: l(h).details, "material-type": l(h).materialType, "max-height": e.maxHeight - 150 }, null, 8, ["bool-use-requisitions", "list", "material-type", "max-height"])) : (w(), U(Ri(q.value), { key: 3, ref_key: "compRef", ref: ce, maxHeight: e.maxHeight - 150 }, null, 8, ["maxHeight"])), l(h).materialType ? (w(), Q("div", PG, [l(h).materialType & (l(ct).MATERIAL.V | l(ct).OTHER.V | l(ct).GAS.V) ? H("", true) : (w(), Q(Qe, { key: 0 }, [Fe[36] || (Fe[36] = C("span", { class: "title" }, "合同量", -1)), C("span", OG, [C("span", null, K(l(h).mete), 1), C("span", null, K(l(h).meteUnit), 1)])], 64)), Fe[37] || (Fe[37] = C("span", { class: "title" }, "合同额", -1)), C("span", kG, K(l(h).amount) + " 元", 1)])) : H("", true), l(h).materialType ? H("", true) : (w(), Q("div", DG, Fe[38] || (Fe[38] = [C("div", { class: "my-code" }, "请选择材料类型", -1)])))])], 4)];
    }), _: 1 }, 8, ["model", "rules"])]), s(da, { modelValue: te.value, "onUpdate:modelValue": Fe[23] || (Fe[23] = (Tl) => te.value = Tl), "custom-class": "material-requisition-select", direction: "btt", size: "70%", title: "申购选择" }, { content: p(() => [s(e2, { ref_key: "requisitionListRef", ref: ne, onAddPurchase: pe }, null, 512)]), _: 1 }, 8, ["modelValue"]), s(da, { ref_key: "materialSpecSelectDrawer", ref: se, modelValue: me.value, "onUpdate:modelValue": Fe[25] || (Fe[25] = (Tl) => me.value = Tl), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [s(to, { ref_key: "matSpecRef", ref: be, modelValue: l(h)[j[l(h).currentBasicClass]], "onUpdate:modelValue": Fe[24] || (Fe[24] = (Tl) => l(h)[j[l(h).currentBasicClass]] = Tl), "basic-class": l(h).currentBasicClass, "classify-ids": l(h).materialType & l(ct).MATERIAL.V ? l(h).auxMaterialIds : l(h).materialType & l(ct).OTHER.V ? l(h).otherMaterialIds : l(h).materialType & l(ct).GAS.V ? l(h).gasMaterialIds : [], "max-height": l(X), "row-init-fn": k, "table-width": 350, visible: me.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "classify-ids", "max-height", "visible"])]), _: 1 }, 8, ["modelValue"]), s(da, { ref_key: "manufSelectDrawerRef", ref: he, modelValue: ge.value, "onUpdate:modelValue": Fe[26] || (Fe[26] = (Tl) => ge.value = Tl), "custom-class": "manufactured-select-drawer", "show-close": "", size: "80%", title: "制成品选择" }, { content: p(() => [s(aR, { maxHeight: l($), "project-id": l(h).projectId, visible: ge.value, onAdd: F }, null, 8, ["maxHeight", "project-id", "visible"])]), _: 1 }, 8, ["modelValue"]), s(nR, { modelValue: Ke.value, "onUpdate:modelValue": Fe[27] || (Fe[27] = (Tl) => Ke.value = Tl), edit: r.edit, "is-passed-edit": e.isPassedEdit, onSubmit: He }, null, 8, ["modelValue", "edit", "is-passed-edit"])]);
  };
} }, rR = ut(xG, [["__scopeId", "data-v-7e13f43e"]]), UG = Object.freeze(Object.defineProperty({ __proto__: null, default: rR }, Symbol.toStringTag, { value: "Module" })), YG = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.unit);
  if (n.value || o.dispatch("config/fetchUnit"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { unit: Ee(() => o.state.config.unit), loaded: n };
}, KG = { style: { float: "left" } }, WG = { key: 0, style: { float: "right", "font-size": "13px" } }, jG = { style: { float: "left" } }, FG = { key: 0, style: { float: "right", "font-size": "13px" } }, uR = { __name: "index", props: { modelValue: { type: [Number, String, Array] }, options: { type: [Array, Object], default: () => [] }, showForbidden: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, unshowOptions: { type: Array, default: () => [] }, placeholder: { type: String, default: "单位" }, disabledName: { type: Array, default: () => [] }, group: { type: Boolean, default: true }, showSymbol: { type: Boolean, default: true }, unitType: { type: String } }, emits: ["change", "blur", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), { unit: r, loaded: E } = YG(), y = Ee(() => {
    let g = [];
    return c.unitType ? g = r.value[c.unitType] || [] : g = r.value.ALL || [], c.showForbidden || (g = g.filter((S) => S.enabled)), g;
  }), b = Ee(() => {
    let g;
    if (c.unitType) {
      for (const S of r.value.GROUP) S.type === c.unitType && (g = [S]);
      g = [];
    } else g = r.value.GROUP || [];
    return c.showForbidden || (g = JSON.parse(JSON.stringify(g)), g.forEach((S) => {
      S.options = S.options.filter((h) => h.enabled);
    })), g;
  });
  Ce(() => c.modelValue, (g) => {
    u.value = g;
  }, { immediate: true });
  function V(g) {
    g === "" && (g = void 0), n("update:modelValue", g), n("change", g);
  }
  function M(g) {
    n("blur", g);
  }
  return (g, S) => {
    const h = zo, T = KV, _ = Bo;
    return w(), U(_, { class: "unit-select", modelValue: u.value, "onUpdate:modelValue": S[0] || (S[0] = (f) => u.value = f), size: e.size, loading: !l(E), disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, clearable: e.clearable, filterable: e.filterable, placeholder: e.placeholder, onChange: V, onBlur: M }, { default: p(() => [e.group ? (w(true), Q(Qe, { key: 1 }, ki(b.value, (f) => (w(), U(T, { key: f.name, label: f.name }, { default: p(() => [(w(true), Q(Qe, null, ki(f.options, (m) => (w(), Q(Qe, null, [e.unshowOptions.indexOf(m.name) === -1 ? (w(), U(h, { key: m.id, label: m.name, value: m.name, disabled: e.disabledName.includes(m.name) }, { default: p(() => [C("span", jG, K(m.name), 1), e.showSymbol ? (w(), Q("span", FG, K(m.symbol), 1)) : H("", true)]), _: 2 }, 1032, ["label", "value", "disabled"])) : H("", true)], 64))), 256))]), _: 2 }, 1032, ["label"]))), 128)) : (w(true), Q(Qe, { key: 0 }, ki(y.value, (f) => (w(), Q(Qe, null, [e.unshowOptions.indexOf(f.name) === -1 ? (w(), U(h, { key: f.id, label: f.name, value: f.name, disabled: e.disabledName.includes(f.name) }, { default: p(() => [C("span", KG, K(f.name), 1), e.showSymbol ? (w(), Q("span", WG, K(f.symbol), 1)) : H("", true)]), _: 2 }, 1032, ["label", "value", "disabled"])) : H("", true)], 64))), 256))]), _: 1 }, 8, ["modelValue", "size", "loading", "disabled", "multiple", "collapse-tags", "clearable", "filterable", "placeholder"]);
  };
} }, cR = { __name: "basic-class-select-v2", props: { modelValue: { type: [Array, Number] }, type: { type: [Number, String] }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, unshowOptions: { type: Array, default: () => [] }, showExtra: { type: Boolean, default: false }, extraOptionLabel: { type: String, default: "同上" }, extraOptionValue: { type: [Number, String, Array, Boolean], default: -1 }, placeholder: { type: String, default: "基础分类" }, textAlign: { type: String, default: "left" }, allLabelText: { type: String, default: "全部" }, allVal: { type: [Number, String], default: void 0 }, disabledVal: { type: Array, default: () => [] }, dataStructure: { type: Object } }, emits: ["change", "blur", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false), r = Z(), E = Ee(() => {
    if (typeof c.type == "string") {
      if (c.type === "raw") return Ci.ENUM;
      if (c.type === "manuf") return bs.ENUM;
    }
    if (typeof c.type == "number") {
      if (c.type === Fi.RAW_MATERIAL.V) return Ci.ENUM;
      if (c.type === Fi.MANUFACTURED.V) return bs.ENUM;
    }
    return Pe.ENUM;
  });
  Ce(() => c.modelValue, (V) => {
    r.value = V;
  }, { immediate: true });
  function y(V) {
    Ae(V) && (V = void 0), console.log(V), n("update:modelValue", V), n("change", V);
  }
  function b(V) {
    n("blur", V);
  }
  return (V, M) => {
    const g = Ve("common-select");
    return w(), U(g, { modelValue: r.value, "onUpdate:modelValue": M[0] || (M[0] = (S) => r.value = S), options: E.value, showExtra: c.showExtra, "extra-option-label": c.extraOptionLabel, "extra-option-value": c.extraOptionValue, size: c.size, disabled: e.disabled, "disabled-val": c.disabledVal, multiple: c.multiple, placeholder: c.placeholder, "collapse-tags": c.collapseTags, loading: u.value, clearable: c.clearable, filterable: c.filterable, textAlign: c.textAlign, unshowOptions: c.unshowOptions, type: "enum", mode: "bit", onChange: y, onBlur: b }, null, 8, ["modelValue", "options", "showExtra", "extra-option-label", "extra-option-value", "size", "disabled", "disabled-val", "multiple", "placeholder", "collapse-tags", "loading", "clearable", "filterable", "textAlign", "unshowOptions"]);
  };
} };
function zG(e) {
  return W({ url: "/api/oa/flow/doCheckPermission", method: "get", params: e });
}
const BG = { style: { display: "flex" } }, HG = { style: { flex: "1", "text-align": "right" } }, qG = { class: "main-content" }, GG = { class: "form-left" }, QG = { class: "order-details" }, ZG = { class: "flex-rss child-mr-10" }, JG = { class: "flex-rss child-mr-10" }, XG = { class: "flex-rss child-mr-10" }, $G = { class: "flex-rss child-mr-10" }, eQ = { class: "flex-rss child-mr-10" }, tQ = { class: "input-underline flex-rss child-mr-10" }, iQ = { class: "input-underline flex-rss child-mr-10" }, aQ = { class: "form-right" }, lQ = { class: "right-head flex-rbs" }, oQ = { class: "assoc-preparation-list" }, nQ = { key: 0, class: "opt-content" }, sQ = { __name: "raw-material", props: { edit: { type: Boolean, default: false }, dialogVisible: { type: Boolean, default: false }, detail: { type: Object }, maxHeight: { type: Number, default: 100 }, heightStyle: { type: String, default: "" }, Approval: { type: Boolean, default: false }, rewriting: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false } }, emits: "success", setup(e, { emit: o }) {
  const n = { serialNumber: void 0, boolPartyA: false, supplyType: Ni.SELF.V, purchaseType: Fi.RAW_MATERIAL.V, basicClass: null, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, isAllGAS: false, gasMaterialIds: void 0, projectIds: void 0, projectId: void 0, projectManagerId: null, requisitionsSN: void 0, supplierId: void 0, branchCompanyId: void 0, mete: void 0, amount: void 0, invoiceType: fi.SPECIAL.V, taxRate: void 0, logisticsPayerType: Bi.SUPPLIER.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [] }, c = o, u = Z(), r = Z([]), E = ft("supplyUsedProject"), y = ft("projectAllType"), b = e, { cu: V, form: M, FORM: g } = Pa({ title: "采购合同", formStore: !b.edit, formStoreKey: "SUPPLY_CHAIN_PURCHASE_ORDER", defaultForm: n, useDraftCallback: S, clearDraftCallback: h, api: b.edit ? Pc : fw }, u, b.detail);
  yi("cu", V);
  function S() {
  }
  function h() {
  }
  const T = (G, ie, ue) => {
    !M.boolTemporaryStorage && !ie && (M.invoiceType || M.invoiceType === 0 ? M.invoiceType === fi.SPECIAL.V && Ae(M.taxRate) ? ue(new Error("请选择税率")) : ue() : ue(new Error("请选择发票及税率"))), ue();
  }, _ = (G, ie, ue) => {
    G.field === "supplierId" && (A(M.supplierId) || ue(new Error(G.message))), G.field === "projectManagerId" && (A(M.projectManagerId) || ue(new Error(G.message))), G.field === "projectId" && (A(M.projectId) || ue(new Error(G.message))), !M.boolTemporaryStorage && !ie && ue(new Error(G.message)), ue();
  }, f = Z({}), m = { serialNumber: [{ max: 30, message: "订单编号长度不可超过30位", trigger: "blur" }], supplyType: [{ required: true, validator: _, message: "请选择供货类型", trigger: "change" }], purchaseType: [{ required: true, validator: _, message: "请选择物料种类", trigger: "change" }], basicClass: [{ required: true, validator: _, message: "请选择物料类型", trigger: "change" }], supplierId: [{ required: true, validator: _, message: "请选择供应商", trigger: "change" }], projectManagerId: [{ required: true, validator: _, message: "请选择项目经理", trigger: "change" }], projectId: [{ required: true, validator: _, message: "请选择项目", trigger: "change" }] }, R = { logisticsPayerType: [{ required: true, validator: _, message: "请选择物流费用承担方", trigger: "change" }], invoiceType: [{ required: true, validator: T, trigger: "change" }], taxRate: [{ max: 2, validator: _, message: "请输入税率", trigger: "blur" }], mete: [{ required: true, validator: _, message: "请填写合同量", trigger: "blur" }], amount: [{ required: true, validator: _, message: "请填写合同额", trigger: "blur" }] }, v = { projectIds: [{ required: true, validator: _, message: "请选择项目", trigger: "change" }] }, P = { auxMaterialIds: [{ required: true, validator: (G, ie, ue) => {
    !M.boolTemporaryStorage && !ie && (M.isAllMaterial || ie ? ue() : ue(new Error("请选择辅材"))), ue();
  }, trigger: "change" }] }, O = { otherMaterialIds: [{ required: true, validator: (G, ie, ue) => {
    !M.boolTemporaryStorage && !ie && (M.isAllOtherMaterial || ie ? ue() : ue(new Error("请选择办公用品"))), ue();
  }, trigger: "change" }] }, I = { gasMaterialIds: [{ required: true, validator: (G, ie, ue) => {
    !M.boolTemporaryStorage && !ie && (M.isAllGAS || ie ? ue() : ue(new Error("请选择气体"))), ue();
  }, trigger: "change" }] }, Y = Z([]);
  Dt(() => {
    if (b.dialogVisible) {
      const G = f.value;
      tw(G), Object.assign(G, m), M.boolPartyA ? (Object.assign(G, v), delete G.supplierId) : Object.assign(G, R), M.basicClass & Pe.MATERIAL.V && Object.assign(G, P), M.basicClass & Pe.OTHER.V && Object.assign(G, O), M.basicClass & Pe.GAS.V && Object.assign(G, I), pt(() => {
        u.value && u.value.clearValidate();
      });
    }
  });
  const ee = Ee(() => M.preparationSNList && M.preparationSNList.length > 0), B = Z(), q = Z(/* @__PURE__ */ new Map()), ae = Z([]), j = Ee(() => {
    let G = [];
    return B.value ? G = q.value.get(B.value) : G = ae.value, G || [];
  }), le = Z(false), oe = Z([]), ye = Z({});
  function ce(G) {
    let ie = [];
    A(G == null ? void 0 : G.basicClass) && (ie = Ra.getBits(Pe.ENUM, G.basicClass, "V"));
    const ue = [];
    for (let te = 0; te < ie.length; te++) ue.push({ V: ie[te] });
    const ne = [];
    for (const te in Pe.ENUM) ue.findIndex((de) => de.V & Pe.ENUM[te].V) < 0 && (ne.includes(Pe.ENUM[te].V) || ne.push(Pe.ENUM[te].V));
    r.value = M.id ? ne : [];
  }
  function se() {
    M.boolSysgen && (ye.value.supplierId === M.supplierId ? M.serialNumber = ye.value.serialNumber : M.serialNumber = void 0);
  }
  g.HOOK.afterToAdd = () => {
  }, g.HOOK.afterToCU = () => {
    M.clickTime = (/* @__PURE__ */ new Date()).getTime();
  }, g.HOOK.beforeToCU = () => {
    B.value = void 0, q.value = /* @__PURE__ */ new Map(), ae.value = [];
  }, g.HOOK.beforeToEdit = async (G, ie) => {
    ye.value.serialNumber = ie.serialNumber, ye.value.supplierId = ie.supplierId, Array.isArray(ie.preparationList) && ie.preparationList.length > 0 && (await Qt(ie.preparationList), await Ut(ie.preparationList, { toNum: true }), ie.preparationList.forEach((ue) => {
      const ne = q.value.get(ue.preparationSN);
      ne ? ne.push(ue) : q.value.set(ue.preparationSN, [ue]);
      const te = ae.value.findIndex((de) => de.serialNumber === ue.serialNumber && de.color === ue.color && de.brand === ue.brand);
      if (te > -1) ae.value[te].quantity += ue.quantity, ae.value[te].mete += ue.mete, ae.value[te].preparationSNList.push(ue.preparationSN);
      else {
        const de = At(ue);
        de.preparationSNList = [ue.preparationSN], ae.value.push(de);
      }
    }));
  }, g.HOOK.beforeSubmit = async () => {
    const G = [], ie = [];
    M.projectId && (!b.edit || b.edit && M.projectId !== M.originEditProjectId) && ie.push(M.projectId);
    for (let ne = 0; ne < ie.length; ne++) {
      const te = ie[ne];
      if (E.value.includes(te) && G.findIndex((de) => de.id === te) < 0) {
        const de = y.value.find((pe) => pe.id === te);
        G.push(de);
      }
    }
    let ue = true;
    if (A(G)) {
      const ne = G.map((te) => te.name).join("、");
      await zi.confirm(`您已经为《${ne}》创建过采购，是否继续创建，请确认?`, "提示", { distinguishCancelAndClose: true, confirmButtonText: "确认", cancelButtonText: "取消" }).then(() => {
        ue = true;
      }).catch((te) => {
        ue = false;
      });
    }
    return ue;
  };
  const he = Ht(), be = ft("dataId");
  g.HOOK.afterSubmit = async (G) => {
    be.value = await G.submitResult.data, await he.dispatch("config/fetchSupplyUsedProject"), r.value = [], c("success");
  }, V.submitFormFormat = (G) => (G.attachmentIds = G.attachments ? G.attachments.map((ie) => ie.id) : void 0, G.auxMaterialIds = G.isAllMaterial ? [0] : G.auxMaterialIds, G.otherMaterialIds = G.isAllOtherMaterial ? [0] : G.otherMaterialIds, G.gasMaterialIds = G.isAllGAS ? [0] : G.gasMaterialIds, G);
  function me(G) {
    if (!ge()) return false;
    G !== B.value ? B.value = G : B.value = void 0;
  }
  function ge() {
    return le.value ? (ot.warning({ message: "请先“保存”或“取消编辑”分拣信息", duration: 4e3 }), false) : true;
  }
  function Le() {
    le.value = true, oe.value = At(j.value);
  }
  function Ie(G, ie) {
    oe.value.splice(ie, 1);
  }
  function Se() {
    le.value = false;
  }
  function X() {
    le.value = false, q.value.set(B.value, oe.value);
  }
  async function $(G) {
    try {
      M.boolTemporaryStorage = G, M.projectId && (M.projectIds = [M.projectId]), b.isPassedEdit && b.edit && (M.dataStatus === rl.PASSED.V && (V.api = Ic), M.dataStatus === rl.UNDER_APPROVAL.V && (V.api = Cc)), await V.submit(), he.dispatch("approval_list/fetchSubNum", at.PURCHASE_ORDER_BG.V);
    } catch (ie) {
      console.log("采购合同提交", ie);
    }
  }
  async function k() {
    let G = "";
    V.form.purchaseType === 1 ? G = "材料合同审批流程（初鸣）" : V.form.purchaseType === 2 && (G = "外委加工合同审批/结算流程（初鸣）"), await zG({ requestName: G, sqr: he.getters.user.oaUserId });
  }
  async function J(G) {
    try {
      await k(), await $(G);
    } catch (ie) {
      console.log(ie);
    }
  }
  async function z(G) {
    await hw({ projectAttribute: G }).then((ue) => {
      Y.value = ue;
    });
  }
  async function F(G) {
    var ie, ue, ne, te;
    M.branchCompanyId = void 0, A(M.projectId) ? (M.projects = (ie = y.value) == null ? void 0 : ie.find((de) => de.id === M.projectId), M.branchCompanyId = (ue = M.projects) == null ? void 0 : ue.contractSignBodyId, M.boolInSourcing = ((ne = M.projects) == null ? void 0 : ne.projectAttribute) === 3, M.projectAttribute = (te = M.projects) == null ? void 0 : te.projectAttribute) : M.projects = void 0;
  }
  return Ce(() => M.branchCompanyId, (G) => {
    pt(() => {
      A(M.projects) && (M.branchCompanyId = M.projects.contractSignBodyId);
    });
  }, { deep: true }), El(() => {
    z();
  }), (G, ie) => {
    const ue = Ve("common-button"), ne = Mt, te = Zi, de = Ve("common-select"), pe = Ve("common-radio"), re = Fo, we = Ve("common-input-number"), Ke = wi, Me = vt, Ne = Ve("common-table"), He = Li, ze = _t("split");
    return w(), Q("div", null, [C("div", BG, [C("div", null, [xt(G.$slots, "chose", {}, void 0, true)]), C("div", HG, [s(ue, { loading: l(V).status.edit === l(g).STATUS.PROCESSING, size: "mini", type: "primary", onClick: ie[0] || (ie[0] = (Oe) => J(l(co).NO.V)) }, { default: p(() => ie[25] || (ie[25] = [Te(" 预 览 ")])), _: 1, __: [25] }, 8, ["loading"]), (e.isPassedEdit ? e.isPassedEdit && !b.edit : b.edit) ? (w(), U(ue, { key: 0, size: "default", type: "warning", onClick: ie[1] || (ie[1] = (Oe) => J(l(co).YES.V)) }, { default: p(() => ie[26] || (ie[26] = [Te(" 暂 存 ")])), _: 1, __: [26] })) : H("", true)])]), C("div", qG, [s(He, { ref_key: "formRef", ref: u, model: l(M), rules: f.value, "label-position": "right", "label-width": "110px", size: "default" }, { default: p(() => [C("div", { style: ri(`height: ${e.maxHeight}px`), class: "form-content" }, [C("div", GG, [C("div", QG, [s(te, { class: "el-form-item-1", label: "采购合同编号", prop: "serialNumber" }, { default: p(() => [s(ne, { modelValue: l(M).serialNumber, "onUpdate:modelValue": ie[2] || (ie[2] = (Oe) => l(M).serialNumber = Oe), modelModifiers: { trim: true }, disabled: !!l(M).boolUsed && (b.rewriting || b.edit), class: "input-underline", maxlength: "30", placeholder: "可输入采购合同编号（不填写则自动生成）", size: "default" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(te, { class: "el-form-item-3", label: "项目经理", prop: "projectManagerId" }, { default: p(() => [s(de, { modelValue: l(M).projectManagerId, "onUpdate:modelValue": ie[3] || (ie[3] = (Oe) => l(M).projectManagerId = Oe), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !!l(M).boolUsed, options: Y.value, class: "input-underline", clearable: "", filterable: "", placeholder: "请选择项目经理", size: "default", type: "other", onChange: ie[4] || (ie[4] = () => {
      l(M).projectId = void 0, l(M).branchCompanyId = void 0, l(M).projects = {}, l(M).boolInSourcing = true;
    }) }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), l(M).useRequisitions ? H("", true) : (w(), U(te, { key: 0, class: "el-form-item-3", label: "选择项目", prop: "projectId" }, { default: p(() => [s(ca, { modelValue: l(M).projectId, "onUpdate:modelValue": ie[5] || (ie[5] = (Oe) => l(M).projectId = Oe), branchCompanyId: l(M).branchCompanyId, disabled: !l(A)(l(M).projectManagerId) && !!l(M).boolUsed, projectManagerId: l(M).projectManagerId, class: "input-underline", clearable: "", "is-not-self-support": "", style: { width: "100%" }, onChange: F, onClear: ie[6] || (ie[6] = (Oe) => l(M).projects = {}) }, null, 8, ["modelValue", "branchCompanyId", "disabled", "projectManagerId"])]), _: 1 })), s(te, { class: "el-form-item-18", label: "签订主体", prop: "branchCompanyId" }, { default: p(() => [s(J_, { modelValue: l(M).branchCompanyId, "onUpdate:modelValue": ie[7] || (ie[7] = (Oe) => l(M).branchCompanyId = Oe), defaultLevel: l(M).boolInSourcing ? "" : l(ou).CONSTRUCTION_SITE.V, disabled: true, class: "input-underline", placeholder: "合同签订主体", style: { width: "100%" } }, null, 8, ["modelValue", "defaultLevel"])]), _: 1 }), s(te, { class: "el-form-item-3", label: "采购类型", prop: "purchaseType" }, { default: p(() => [C("div", ZG, [s(pe, { modelValue: l(M).purchaseType, "onUpdate:modelValue": ie[8] || (ie[8] = (Oe) => l(M).purchaseType = Oe), disabled: l(M).id && !!l(M).boolUsed, options: l(Fi).ENUM, type: "enum" }, null, 8, ["modelValue", "disabled", "options"])])]), _: 1 }), s(te, { class: "el-form-item-3", label: "材料类型", prop: "basicClass" }, { default: p(() => [C("div", JG, [s(cR, { modelValue: l(M).basicClass, "onUpdate:modelValue": ie[9] || (ie[9] = (Oe) => l(M).basicClass = Oe), disabled: !!l(M).boolUsed, "disabled-val": l(M).id ? r.value : [], type: l(M).purchaseType, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择物料种类", style: { flex: "auto" } }, null, 8, ["modelValue", "disabled", "disabled-val", "type"])])]), _: 1 }), l(M).basicClass & l(Pe).MATERIAL.V ? (w(), U(te, { key: 1, class: "el-form-item-5", label: "辅材明细", prop: "auxMaterialIds" }, { default: p(() => [C("div", XG, [s(re, { modelValue: l(M).isAllMaterial, "onUpdate:modelValue": ie[10] || (ie[10] = (Oe) => l(M).isAllMaterial = Oe), disabled: !!l(M).boolUsed, border: "", label: "所有辅材", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(M).auxMaterialIds, "onUpdate:modelValue": ie[11] || (ie[11] = (Oe) => l(M).auxMaterialIds = Oe), "basic-class": l(Pe).MATERIAL.V, "collapse-tags": false, deep: 2, disabled: !!l(M).boolUsed || l(M).isAllMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择辅材", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), l(M).basicClass & l(Pe).OTHER.V ? (w(), U(te, { key: 2, class: "el-form-item-5", label: "办公用品明细", prop: "otherMaterialIds" }, { default: p(() => [C("div", $G, [s(re, { modelValue: l(M).isAllOtherMaterial, "onUpdate:modelValue": ie[12] || (ie[12] = (Oe) => l(M).isAllOtherMaterial = Oe), disabled: !!l(M).boolUsed, border: "", label: "所有办公用品科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(M).otherMaterialIds, "onUpdate:modelValue": ie[13] || (ie[13] = (Oe) => l(M).otherMaterialIds = Oe), "basic-class": l(Pe).OTHER.V, "collapse-tags": false, deep: 2, disabled: !!l(M).boolUsed || l(M).isAllOtherMaterial, class: "input-underline", clearable: "", isDefaultExpand: "", multiple: "", placeholder: "请选择办公用品科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), l(M).basicClass & l(Pe).GAS.V ? (w(), U(te, { key: 3, class: "el-form-item-5", label: "气体明细", prop: "gasMaterialIds" }, { default: p(() => [C("div", eQ, [s(re, { modelValue: l(M).isAllGAS, "onUpdate:modelValue": ie[14] || (ie[14] = (Oe) => l(M).isAllGAS = Oe), disabled: !!l(M).boolUsed, border: "", label: "所有气体科目", size: "default", style: { "margin-top": "3px", "margin-right": "5px" } }, null, 8, ["modelValue", "disabled"]), s(Ql, { modelValue: l(M).gasMaterialIds, "onUpdate:modelValue": ie[15] || (ie[15] = (Oe) => l(M).gasMaterialIds = Oe), "basic-class": l(Pe).GAS.V, "collapse-tags": false, deep: 2, disabled: !!l(M).boolUsed || l(M).isAllGAS, class: "input-underline", clearable: "", multiple: "", placeholder: "请选择气体科目", separator: " > ", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "disabled"])])]), _: 1 })) : H("", true), s(te, { class: "el-form-item-7", label: "供应商", prop: "supplierId" }, { default: p(() => [s(pd, { modelValue: l(M).supplierId, "onUpdate:modelValue": ie[16] || (ie[16] = (Oe) => l(M).supplierId = Oe), "basic-class": l(M).basicClass, disabled: !!l(M).boolUsed || b.rewriting || b.edit, type: l(M).purchaseType, class: "input-underline", clearable: "", filterable: "", mode: "contain", onChange: se, onInfoChange: ce }, null, 8, ["modelValue", "basic-class", "disabled", "type"])]), _: 1 }), l(M).boolPartyA ? H("", true) : (w(), Q(Qe, { key: 4 }, [s(te, { class: "el-form-item-8", label: "合同量", prop: "mete", style: { display: "inline-flex", width: "320px" } }, { default: p(() => [C("div", tQ, [s(we, { modelValue: l(M).mete, "onUpdate:modelValue": ie[17] || (ie[17] = (Oe) => l(M).mete = Oe), controls: false, max: 999999999999, step: 1, autocomplete: "off", placeholder: "请填写合同量", style: { width: "100%" } }, null, 8, ["modelValue"]), s(uR, { modelValue: l(M).meteUnit, "onUpdate:modelValue": ie[18] || (ie[18] = (Oe) => l(M).meteUnit = Oe), disabled: !!l(M).boolUsed, clearable: "", filterable: "", size: "default", style: { width: "80px", flex: "none" } }, null, 8, ["modelValue", "disabled"])])]), _: 1 }), s(te, { class: "el-form-item-9", label: "合同额", "label-width": "80px", prop: "amount", style: { display: "inline-flex", width: "240px" } }, { default: p(() => [C("div", iQ, [s(we, { modelValue: l(M).amount, "onUpdate:modelValue": ie[19] || (ie[19] = (Oe) => l(M).amount = Oe), controls: false, disabled: !!l(M).boolUsed, max: 999999999999, precision: l(Ze).YUAN, step: 1, autocomplete: "off", class: "input-underline", placeholder: "请填写合同额", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "precision"]), ie[27] || (ie[27] = C("span", null, "元", -1))])]), _: 1 }), s(te, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType" }, { default: p(() => [s(Xn, { invoiceType: l(M).invoiceType, "onUpdate:invoiceType": ie[20] || (ie[20] = (Oe) => l(M).invoiceType = Oe), taxRate: l(M).taxRate, "onUpdate:taxRate": ie[21] || (ie[21] = (Oe) => l(M).taxRate = Oe), classification: l(M).basicClass, disabled: !!l(M).boolUsed, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification", "disabled"])]), _: 1 }), s(te, { class: "el-form-item-17", label: "物流费用承担", prop: "logisticsPayerType" }, { default: p(() => [s(pe, { modelValue: l(M).logisticsPayerType, "onUpdate:modelValue": ie[22] || (ie[22] = (Oe) => l(M).logisticsPayerType = Oe), disabled: !!l(M).boolUsed, options: l(Bi).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })], 64)), s(te, { class: "el-form-item-14", "label-width": "0", prop: "remark" }, { default: p(() => [s(ne, { modelValue: l(M).remark, "onUpdate:modelValue": ie[23] || (ie[23] = (Oe) => l(M).remark = Oe), disabled: !!l(M).boolUsed, rows: 3, maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(dl, { files: l(M).attachments, "onUpdate:files": ie[24] || (ie[24] = (Oe) => l(M).attachments = Oe), "file-classify": l(cl).PURCHASE_ORDER_ATT.V, "is-restrictt-character": false, showView: true, class: "el-form-item-15", "empty-text": "暂未上传采购合同附件", "show-download": "" }, null, 8, ["files", "file-classify"])])]), ee.value ? (w(), Q(Qe, { key: 0 }, [ie[32] || (ie[32] = C("div", { class: "vertical-dashed-divider" }, null, -1)), C("div", aQ, [C("div", lQ, [C("span", oQ, [ie[28] || (ie[28] = C("span", { class: "label" }, "关联备料单", -1)), (w(true), Q(Qe, null, ki(l(M).preparationSNList, (Oe) => (w(), U(Ke, { key: Oe, effect: B.value === Oe ? "dark" : "plain", class: "preparation-sn-tag", onClick: (Re) => me(Oe) }, { default: p(() => [Te(K(Oe), 1)]), _: 2 }, 1032, ["effect", "onClick"]))), 128))]), B.value ? (w(), Q("span", nQ, [le.value ? (w(), Q(Qe, { key: 1 }, [s(ue, { size: "default", onClick: Pi(Se, ["stop"]) }, { default: p(() => ie[30] || (ie[30] = [Te("取消编辑")])), _: 1, __: [30] }), s(ue, { size: "default", type: "success", onClick: Pi(X, ["stop"]) }, { default: p(() => ie[31] || (ie[31] = [Te("保存")])), _: 1, __: [31] })], 64)) : (w(), U(ue, { key: 0, size: "default", type: "warning", onClick: Le }, { default: p(() => ie[29] || (ie[29] = [Te(" 编辑分拣信息 ")])), _: 1, __: [29] }))])) : H("", true)]), s(Ne, { ref: "tableRef", data: le.value ? oe.value : j.value, "default-expand-all": false, "max-height": e.maxHeight - 150, "highlight-current-row": "", "row-key": "id" }, { default: p(() => [s(Me, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), B.value ? H("", true) : (w(), U(Me, { key: "preparationSNList", fixed: "left", label: "备料单号", "min-width": "140px", prop: "preparationSNList", "show-overflow-tooltip": "" }, { default: p(({ row: Oe }) => [qe(C("span", null, null, 512), [[ze, Oe.preparationSNList]])]), _: 1 })), s(fa, { "show-index": false, specificationLable: "型号", fixed: "left", "spec-merge": "" }), s(Ba, { fixed: "left" }), s(za), le.value ? (w(), U(Me, { key: 1, align: "center", fixed: "right", label: "操作", width: "80px" }, { default: p(({ $index: Oe }) => [s(ue, { icon: "el-icon-delete", size: "default", type: "danger", onClick: Pi((Re) => Ie(Oe), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["data", "max-height"])])], 64)) : H("", true)], 4)]), _: 1 }, 8, ["model", "rules"])])]);
  };
} }, dR = ut(sQ, [["__scopeId", "data-v-a6354581"]]), rQ = Object.freeze(Object.defineProperty({ __proto__: null, default: dR }, Symbol.toStringTag, { value: "Module" }));
const uQ = { key: 0, class: "el-form-item el-form-item" }, cQ = { __name: "index", props: { Approval: { type: Boolean, default: false }, rewriting: { type: Boolean, default: false }, journalId: { type: Number, default: void 0 }, requisitionList: { type: Array, default: () => [] }, isRequisition: { type: Boolean, default: false }, isPassedEdit: { type: Boolean, default: false } }, setup(e) {
  const o = Ht(), { projectAllType: n } = Wa(), { supplyUsedProject: c } = Qv();
  yi("supplyUsedProject", c), yi("projectAllType", n);
  const u = e, r = { useRequisitions: false, boolInSourcing: true, serialNumber: void 0, supplyType: Ni.SELF.V, materialType: void 0, purchaseType: Fi.RAW_MATERIAL.V, currentBasicClass: void 0, applicantId: void 0, projectManagerName: void 0, isAllMaterial: false, auxMaterialIds: void 0, isAllOtherMaterial: false, otherMaterialIds: void 0, isAllGAS: false, gasMaterialIds: void 0, projectIds: void 0, projectId: void 0, projects: void 0, supplierId: void 0, supplier: void 0, branchCompanyId: void 0, purchaseOrderBranchCompanyDTO: void 0, branchCompany: void 0, mete: void 0, meteUnit: "", amount: void 0, invoiceType: fi.SPECIAL.V, taxRate: void 0, weightMeasurementMode: Wt.THEORY.V, logisticsPayerType: Bi.SUPPLIER.V, remark: void 0, attachments: void 0, attachmentIds: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterials: [], MATERIAL: [], OTHER: [], GAS: [], requisitions: [], requisitionsKV: {}, actualRequisitionIds: [], manufListObj: {}, manufMergeObj: {}, boolDetail: false }, { purchaseCfg: E } = aa(), y = Z("620px"), b = Z(), { CRUD: V, crud: M, form: g } = An(r, b), S = Ee(() => M.status.cu > V.STATUS.NORMAL), h = Ee(() => M.status.edit > 0);
  Ce(() => g.boolDetail, (m) => {
    y.value = m ? "100%" : "620px";
  }, { deep: true, immediate: true });
  const T = Ee(() => {
    switch (g.boolDetail) {
      case ea.TRUE.V:
        return rR;
      default:
        return dR;
    }
  });
  Ce([() => S.value, () => u.requisitionList], () => {
    var m, R;
    if (S.value) if (y.value = "620px", A(u.requisitionList)) {
      Ae(o.state.config.getTreeClickTime) && (o.state.config.getTreeClickTime = (/* @__PURE__ */ new Date()).getTime());
      const v = JSON.parse(JSON.stringify(u.requisitionList)), N = [], P = {};
      v == null || v.map((x) => {
        var I, Y;
        x.isRequisition = true, x.projectId = (I = x.project) == null ? void 0 : I.id, (Y = x.detailList) == null || Y.forEach((ee) => {
          (!ee.projectAttribute || Number(ee.projectAttribute) === vl.JOINT_VENTURE.V) && N.push(ee);
        }), P[x.id] = { id: x.id, serialNumber: x.serialNumber, purchaseCreationState: ys.DURING.V };
      });
      const L = [];
      for (let x = 0; x < N.length; x++) {
        L.includes(N[x].basicClass) || L.push(N[x].basicClass), N[x].basicClass === Ge.SECTION_STEEL.V && (N[x].standardId = N[x].standardId || ((m = N[x].nationalStandardOptions.find((B) => B.boolDefault === true)) == null ? void 0 : m.standardId));
        const I = N[x];
        I.isFirst = true, I.purchaseSN = (R = P[I.applyPurchaseId]) == null ? void 0 : R.serialNumber, I.productQuantity = I.productQuantity || 0, I.productMete = I.productMete || 0;
        const Y = I.mete, ee = I.quantity;
        I.originMete = Y, I.originQuantity = ee, I.canPurchaseQuantity = ee - I.productQuantity > 0 ? ee - I.productQuantity : 0, I.canPurchaseMete = Y - I.productMete > 0 ? Y - I.productMete : 0, I.quantity = I.canPurchaseQuantity, I.basicClass & sl ? (I.purchaseTotalWeight = I.mete, I.weighingTotalWeight = I.canPurchaseMete) : I.mete = I.canPurchaseMete;
      }
      let O;
      for (let x = 0; x < L.length; x++) L[x] & sl ? O = sl : O = O ? O | L[x] : L[x];
      pt(() => {
        g.boolDetail = true, y.value = "100%", g.useRequisitions = true, g.boolInSourcing = false, g.projectAttribute = vl.JOINT_VENTURE.V, g.actualRequisitionIds = v.map((I) => I.id), g.requisitionsKV = P, g.copyList = N, g.branchCompanyId = u.requisitionList[0].branchCompanyId, g.purchaseOrderBranchCompanyDTO = u.requisitionList[0].branchCompany, g.branchCompany = u.requisitionList[0].branchCompany, g.level = u.requisitionList[0].level, g.materialType = O, g.steelPlateList = [], g.sectionSteelList = [], g.steelCoilList = [], g.otherSteelMaterialList = [], g.auxiliaryMaterialList = [], g.otherList = [], g.gasList = [], N.forEach((I) => {
          var Y, ee;
          switch (I.uid = I.id, I.weighingTotalWeight = I.mete, I.specificationMap = I.specKV, I.projectId = I.projectId || ((Y = I.project) == null ? void 0 : Y.id), I.warehouseId = I.warehouseId || ((ee = I.warehouse) == null ? void 0 : ee.id), I.unit = I.accountingUnit, I.basicClass) {
            case Pe.STEEL_PLATE.V:
              g.steelPlateList.push(I);
              break;
            case Pe.SECTION_STEEL.V:
              g.sectionSteelList.push(I);
              break;
            case Pe.STEEL_COIL.V:
              g.steelCoilList.push(I);
              break;
            case Pe.OTHER_STEEL_MATERIALS.V:
              g.otherSteelMaterialList.push(I);
              break;
            case Pe.MATERIAL.V:
              g.auxiliaryMaterialList.push(I);
              break;
            case Pe.GAS.V:
              g.gasList.push(I);
              break;
            case Pe.OTHER.V:
              g.otherList.push(I);
              break;
          }
        }), g.materialTypeTotal = Js(ct.ENUM, g.materialType, "V"), A(g.materialTypeTotal) && (g.materialTypeTotal.includes(ct.STEEL.V) ? g.currentBasicClass = Pe.STEEL_PLATE.V : g.materialTypeTotal.includes(ct.MATERIAL.V) ? (g.currentMaterial = ct.MATERIAL.V, g.currentBasicClass = Pe.MATERIAL.V) : g.materialTypeTotal.includes(ct.OTHER.V) ? (g.currentMaterial = ct.OTHER.V, g.currentBasicClass = Pe.OTHER.V) : (g.currentMaterial = ct.GAS.V, g.currentBasicClass = Pe.GAS.V)), g.isFirst = true, g.needFirstWatch = true;
        const x = [];
        g.copyList.forEach((I) => {
          let Y = true;
          x.length && (x == null || x.forEach((ee) => {
            ee.id === I.project.id && (Y = false);
          })), Y && I.project && x.push(I.project);
        }), g.project = x;
      }), console.log(g, "form");
    } else g.id || (g.boolDetail = A(E.value.boolHaveDetail) ? E.value.boolHaveDetail : true, pt(() => {
      g.boolDetail === ea.TRUE.V ? y.value = "100%" : (y.value = "620px", g.materialType = void 0);
    }));
  }, { immediate: true, deep: true });
  const { maxHeight: _ } = Kt({ mainBox: ".purchase-order-raw-mat-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, S);
  V.HOOK.beforeEditDetailLoaded = async (m) => {
    var v, N, P, L, O;
    y.value = "620px", Ae(g.attachments) && (g.attachments = []), g.useRequisitions = A(g.applyPurchase);
    let R = {};
    if (g.useRequisitions && (R = Uo(g.applyPurchase)), g.isAllMaterial = (v = g.auxMaterialIds) == null ? void 0 : v.includes(0), g.isAllOtherMaterial = (N = g.otherMaterialIds) == null ? void 0 : N.includes(0), g.isAllGAS = (P = g.gasMaterialIds) == null ? void 0 : P.includes(0), g.supplierId = g.supplier ? g.supplier.id : void 0, g.boolInSourcing = g.projectAttribute === 3, g.projectManagerId = (L = g.projectManager) == null ? void 0 : L.id, A(g.projects) && (g.projectId = (O = g.projects[0]) == null ? void 0 : O.id), g.originEditProjectId = g.projectId, g.clickTime = (/* @__PURE__ */ new Date()).getTime(), g.boolDetail) {
      y.value = "100%", await Qt(g.details), await Ut(g.details, { toNum: true }), g.list = JSON.parse(JSON.stringify(g.details)), A(g.list) && (g.list = g.list.map((x) => {
        var I;
        return x.purchaseSN = (I = R[x.applyPurchaseId]) == null ? void 0 : I.serialNumber, x.purchaseTotalWeight = x.applyPurchaseMete, x;
      }), await Ju(g)), Object.assign(g, { requisitionsKV: R });
      for (const x in Pe.ENUM) if (Pe[x].V & g.basicClass) {
        g.currentBasicClass = Pe[x].V;
        break;
      }
    }
  };
  async function f() {
    y.value = "620px", M.cancelCU(), M.refresh(), await o.dispatch("approval_list/fetchTSNum", at.PURCHASE_ORDER_BG.V), await o.dispatch("approval_list/fetchApprovalNum", at.PURCHASE_ORDER_BG.V);
  }
  return (m, R) => {
    const v = Ve("common-radio"), N = Ve("common-drawer");
    return w(), U(N, { ref: "drawerRef", "before-close": l(M).cancelCU, "close-on-click-modal": false, contentLoading: l(M).editDetailLoading, "show-close": true, size: y.value, title: h.value ? "编辑采购订单（内包制合营）" : "新增采购订单（内包制合营）", visible: S.value, "custom-class": "purchase-order-raw-mat-form", "destroy-on-close": "" }, { titleAfter: p(() => R[1] || (R[1] = [])), content: p(() => [C("div", null, [l(M).status.cu > l(V).STATUS.NORMAL ? (w(), U(Ri(T.value), { key: 0, Approval: u.Approval, detail: l(g), dialogVisible: S.value, edit: h.value, "is-passed-edit": u.isPassedEdit, "is-requisition": u.isRequisition, maxHeight: l(_) - 50, rewriting: u.rewriting, onSuccess: f }, { chose: p(() => [h.value ? H("", true) : (w(), Q("div", uQ, [R[2] || (R[2] = C("div", { class: "el-form-item__label", style: { "font-weight": "700", "font-size": "14px", width: "110px" } }, [C("span", { style: { color: "#f56c6c", "font-weight": "normal", "margin-right": "4px" } }, "*"), Te(" 是否有明细 ")], -1)), s(v, { modelValue: l(g).boolDetail, "onUpdate:modelValue": R[0] || (R[0] = (P) => l(g).boolDetail = P), options: l(ea).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]))]), _: 1 }, 40, ["Approval", "detail", "dialogVisible", "edit", "is-passed-edit", "is-requisition", "maxHeight", "rewriting"])) : H("", true)])]), _: 1 }, 8, ["before-close", "contentLoading", "size", "title", "visible"]);
  };
} }, mR = ut(cQ, [["__scopeId", "data-v-079dedc0"]]), dQ = Object.freeze(Object.defineProperty({ __proto__: null, default: mR }, Symbol.toStringTag, { value: "Module" })), Xu = Pe.STEEL_PLATE.V, Ib = Pe.SECTION_STEEL.V, Dr = Pe.STEEL_COIL.V;
async function mQ({ classifyId: e, name: o, length: n, width: c, thickness: u, quantity: r = 1 }, E = false) {
  if (!o || !n || !c || !u) return null;
  const y = await _a(), b = await id(), V = y[Xu].length.unit, M = y[Xu].weight.unit, g = E || b === Zn.SINGLE.V ? y[Xu].weight.precision : 5, S = _e.state.wms.steelDensityCfg;
  let h = 0;
  for (const m in S) Number(m) === e && (h = S[m]);
  let T;
  const _ = St(n, V, "m"), f = St(c, V, "m");
  return T = _ * f * u * h, T = St(T, "kg", M, g), Be(T * r, g);
}
function pQ({ length: e = 0, lengthUnit: o = "mm", quantity: n = 1, precision: c = 3 }, u = true) {
  const r = u ? c : 10, E = (e * n).toFixed(r);
  return St(E, o, "m", r);
}
async function hQ({ length: e, quantity: o = 1, unitWeight: n }, c = false) {
  if (!e || !o || !n) return null;
  const u = await _a(), r = await id(), E = u[Ib].length.unit, y = u[Ib].weight.unit, b = c || r === Zn.SINGLE.V ? u[Xu].weight.precision : 5;
  let V;
  return V = St(e, E, "m", 3) * n, V = St(V, "kg", y, b), Be(V * o, b);
}
async function fQ({ classifyId: e, name: o, weight: n, width: c, thickness: u, quantity: r = 1 }) {
  if (!n || !r || !c || !u) return null;
  const E = _e.state.wms.steelDensityCfg;
  let y = 0;
  for (const m in E) Number(m) === e && (y = E[m]);
  const b = await _a(), V = b[Dr].width.unit, M = b[Dr].length.unit, g = b[Dr].length.precision, S = b[Dr].weight.unit, h = b[Dr].weight.precision;
  let T;
  const _ = St(n, S, "kg", h), f = St(c, V, "m", 3);
  return T = _ / (f * u * y), T = St(T, "m", M), Number((T * r).toFixed(g));
}
async function Xr(e) {
  var u, r;
  const o = await _a();
  e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [], e.otherSteelMaterialList = [], e.auxiliaryMaterialList = [], e.otherList = [], e.gasList = [], e.structureList = [], e.enclosureList = [];
  const n = [];
  let c;
  for (const E of e.list) {
    switch (E.uid = E.id, E.weighingTotalWeight = E.mete, E.specificationMap = E.specKV, E.projectId = E.projectId || ((u = E.project) == null ? void 0 : u.id), E.warehouseId = E.warehouseId || ((r = E.warehouse) == null ? void 0 : r.id), E.basicClass) {
      case Pe.STEEL_PLATE.V:
        c = mQ({ classifyId: E.classifyId, name: E.classifyFullName, length: E.length, width: E.width, thickness: E.thickness }).then((y) => {
          E.theoryWeight = y, E.theoryTotalWeight = Be(E.theoryWeight * (E.quantity || 0), o[Pe.STEEL_PLATE.V].weight.precision), E.rowIndex = e.steelPlateList.length, e.steelPlateList.push(E);
        });
        break;
      case Pe.SECTION_STEEL.V:
        c = hQ({ length: E.length, unitWeight: E.unitWeight }).then((y) => {
          E.theoryWeight = y, E.theoryTotalWeight = Be(E.theoryWeight * (E.quantity || 0), o[Pe.SECTION_STEEL.V].weight.precision), E.length && E.quantity ? E.totalLength = pQ({ length: E.length, quantity: E.quantity }) : E.totalLength = 0, E.rowIndex = e.sectionSteelList.length, e.sectionSteelList.push(E);
        });
        break;
      case Pe.STEEL_COIL.V:
        c = fQ({ classifyId: E.classifyId, name: E.classifyFullName, weight: E.weighingTotalWeight, width: E.width, thickness: E.thickness }).then((y) => {
          E.theoryLength = y, E.quantity = E.length, E.rowIndex = e.steelCoilList.length, e.steelCoilList.push(E);
        });
        break;
      case Pe.OTHER_STEEL_MATERIALS.V:
        E.rowIndex = e.otherSteelMaterialList.length, e.otherSteelMaterialList.push(E);
        break;
      case Pe.MATERIAL.V:
        E.rowIndex = e.auxiliaryMaterialList.length, e.auxiliaryMaterialList.push(E);
        break;
      case Pe.GAS.V:
        E.rowIndex = e.gasList.length, e.gasList.push(E);
        break;
      case Pe.OTHER.V:
        E.rowIndex = e.otherList.length, e.otherList.push(E);
        break;
      case Pe.STRUC_MANUFACTURED.V:
        E.rowIndex = e.structureList.length, e.structureList.push(E);
        break;
      case Pe.ENCL_MANUFACTURED.V:
        E.rowIndex = e.enclosureList.length, e.enclosureList.push(E);
        break;
    }
    n.push(c);
  }
  await Promise.all(n);
}
function ma(e = "mete") {
  const o = (u, r) => {
    Ho(u) > 10 && (r.unitPrice = Be(u, 10), u = r.unitPrice), r.priceType = "unitPrice", r.amount = A(u) ? Be(u * r[e], Ze.YUAN) : void 0;
  }, n = (u, r) => {
    r.priceType = "amount", r.unitPrice = A(u) ? Be(u / r[e], 10) : void 0;
  };
  return { handleUnitPriceChange: o, handleAmountChange: n, handleMeteChangeCalcPrice: (u) => {
    u.unitPrice && !u.amount && !u.priceType && (u.priceType = "unitPrice"), !u.unitPrice && u.amount && !u.priceType && (u.priceType = "amount"), !(!u.priceType || !u[e]) && (u.priceType === "unitPrice" && o(u.unitPrice, u), u.priceType === "amount" && n(u.amount, u));
  } };
}
const { handleMeteChangeCalcPrice: gQ } = ma("mete"), EQ = vi[Ge.STEEL_PLATE.V], pR = { title: "钢板采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "型号", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", excelField: "__EMPTY_5" }, { label: "重量（t）", field: "weighingTotalWeight", type: "number", precision: EQ.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_9" }, { label: "计量方式", field: "weightMeasurementModeName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var _;
  if (!gi(e, pR.rules)) return;
  const n = [];
  for (const f in Wt.ENUM) n.push(Wt.ENUM[f]);
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType");
  const c = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const u = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const r = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.STEEL_PLATE.V), E = _e.state.config.rawMatClsKV, y = At(e), b = [];
  let V = [], M = [], g = [];
  const S = [];
  if (y.forEach((f) => {
    let m = false;
    const R = pi(f.classifyName.split("/"));
    if (R.length === 1) {
      const v = r.filter((N) => N.name === f.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, f.classifyId = v[0].id, b.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, f.classifyId = P.id, b.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, f.classifyId = L[0].id, b.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && S.push(O);
        }
      }
      if (S.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of r) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, b.push(v.id);
      break;
    }
    if (m || V.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : M.push(f.shortName);
    }
    if (f.weightMeasurementModeName) {
      const v = n.find((N) => N.L === f.weightMeasurementModeName);
      A(v) ? f.weightMeasurementMode = v.V : g.push(f.weightMeasurementModeName);
    }
  }), V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}项目不存在`);
  if (g = Array.from(new Set(g)), g.length > 0) throw new Error(`${g.map((f) => `“${f}”`).join("、")}${g.length > 1 ? "等" : ""}计量方式不存在，应填理计或磅计`);
  const h = _e.state.config.classifySpec, T = b.filter((f) => h[f] === void 0);
  T.length > 0 && (T.forEach((f) => {
    h[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", T));
  for (const f of y) {
    if (((_ = E == null ? void 0 : E[f.classifyId]) == null ? void 0 : _.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
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
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.serialNumber = R.serialNumber, f.classifySerialNumber = R.classify.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.model = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision;
      let N = 0;
      for (const P in u) Number(P) === f.classifyId && (N = u[P]);
      f.steelDensity = N, f.theoryWeight = await na({ classifyId: f.classifyId, name: f.classifyFullName, length: f.length, width: f.width, thickness: f.thickness }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, c[Ge.STEEL_PLATE.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight, f.mete = f.weighingTotalWeight, console.log(f.weighingTotalWeight, f.mete), (!f.unitPrice || !f.amount) && gQ(f);
    } else throw new Error(`${f.classifyName}下不存在规格为“${v}”的材料，请联系初鸣售后人员添加`);
  }
  return console.log(y), y;
} }, { handleMeteChangeCalcPrice: yQ } = ma("mete"), TQ = vi[Ge.SECTION_STEEL.V], hR = { title: "型材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "*型号", field: "specification", excelField: "__EMPTY_1" }, { label: "规格", field: "model", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", excelField: "__EMPTY_4" }, { label: "总长度（m）", field: "totalLength", type: "number", excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: TQ.weight.precision, excelField: "__EMPTY_6" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_10" }, { label: "计量方式", field: "weightMeasurementModeName", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材型号不能为空" }] }, format: async (e) => {
  var T, _;
  if (console.log(e), !gi(e, hR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType");
  const n = [];
  for (const f in Wt.ENUM) n.push(Wt.ENUM[f]);
  const c = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const u = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.SECTION_STEEL.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [], M = [];
  const g = [];
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
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && g.push(O);
        }
      }
      if (g.length > 1) throw new Error(`科目名称“${f.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const v of u) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, f.classifyId = v.id, y.push(v.id);
      break;
    }
    if (m || b.push(f.classifyName), f.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === f.shortName);
      A(v) ? f.projectId = v.id : V.push(f.shortName);
    }
    if (f.weightMeasurementModeName) {
      const v = n.find((N) => N.L === f.weightMeasurementModeName);
      A(v) ? f.weightMeasurementMode = v.V : M.push(f.weightMeasurementModeName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((f) => `“${f}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((f) => `“${f}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  if (M = Array.from(new Set(M)), M.length > 0) throw new Error(`${M.map((f) => `“${f}”`).join("、")}${M.length > 1 ? "等" : ""}计量方式不存在，应填理计或磅计`);
  const S = _e.state.config.classifySpec, h = y.filter((f) => S[f] === void 0);
  h.length > 0 && (h.forEach((f) => {
    S[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const f of E) {
    if (((T = r == null ? void 0 : r[f.classifyId]) == null ? void 0 : T.isLeaf) === false) throw new Error(`${f.classifyName}不是末级科目`);
    const m = S[f.classifyId];
    if (m.hasUnitConfig === false) throw new Error(`${f.classifyName}未配置核算单位`);
    let R;
    const v = bQ(f.specification);
    if (m && Array.isArray(m.specList)) {
      for (const N of m.specList) if (v === N.spec) {
        if (N.status) R = N;
        else throw new Error(`${v}被禁用，请开启后重新导入`);
        break;
      }
    }
    if (R) {
      const N = (_ = R.nationalStandardOptions.find((O) => O.boolDefault === true)) == null ? void 0 : _.standardId;
      f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.serialNumber = R.serialNumber, f.classifySerialNumber = R.classify.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.model = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision, f.unitWeight = R.unitWeight, f.standardId = N;
      let P;
      const L = [];
      for (const O in f.specificationMap) O.indexOf("standard") > -1 ? P = f.specificationMap[O] : L.push(f.specificationMap[O]);
      f.sectionSteelSpec = P, f.doNotSectionSteelSpec = L.join(" * "), f.theoryWeight = await xa({ length: f.length, unitWeight: f.unitWeight }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, c[Ge.SECTION_STEEL.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight || f.theoryTotalWeight, _Q(f), f.mete = f.weighingTotalWeight, (!f.unitPrice || !f.amount) && yQ(f);
    } else throw new Error(`${f.classifyName}下不存在型号为“${v}”的材料，请联系初鸣售后人员添加`);
  }
  return console.log(E), E;
} };
function _Q(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
function bQ(e) {
  const o = e.replace(/\s+/g, ""), n = o.lastIndexOf("*");
  return n > -1 ? o.substring(0, n) + " * " + o.substring(n + 1) : o.substring(n + 1);
}
const { handleMeteChangeCalcPrice: VQ } = ma("mete"), wQ = vi[Ge.STEEL_COIL.V], fR = { title: "钢卷采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "型号", field: "material", excelField: "__EMPTY_1" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: wQ.weight.precision, excelField: "__EMPTY_2" }, { label: "厚（mm）", field: "thickness", type: "number", excelField: "__EMPTY_3" }, { label: "宽（mm）", field: "width", type: "number", excelField: "__EMPTY_4" }, { label: "长（mm）", field: "length", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, fR.rules)) return;
  const n = [];
  for (const T in Wt.ENUM) n.push(Wt.ENUM[T]);
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg, u = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.STEEL_COIL.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [], V = [];
  const M = [];
  if (E.forEach((T) => {
    let _ = false;
    const f = pi(T.classifyName.split("/"));
    if (f.length === 1) {
      const m = u.filter((R) => R.name === T.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, T.classifyId = m[0].id, y.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, T.classifyId = v.id, y.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, T.classifyId = N[0].id, y.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && M.push(P);
        }
      }
      if (M.length > 1) throw new Error(`科目名称“${T.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const m of u) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, T.classifyId = m.id, y.push(m.id);
      break;
    }
    if (_ || b.push(T.classifyName), T.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === T.shortName);
      A(m) ? T.projectId = m.id : V.push(T.shortName);
    }
  }), b = Array.from(new Set(b)), b.length > 0) throw new Error(`${b.map((T) => `“${T}”`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在`);
  if (V = Array.from(new Set(V)), V.length > 0) throw new Error(`${V.map((T) => `“${T}”`).join("、")}${V.length > 1 ? "等" : ""}项目不存在`);
  const g = _e.state.config.classifySpec, S = y.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of E) {
    if (((h = r == null ? void 0 : r[T.classifyId]) == null ? void 0 : h.isLeaf) === false) throw new Error(`${T.classifyName}不是末级科目`);
    const _ = g[T.classifyId];
    if (_.hasUnitConfig === false) throw new Error(`${T.classifyName}未配置核算单位`);
    let f;
    const m = T.material ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        f = R;
        break;
      }
    }
    if (f) {
      T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.model = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision;
      let R = 0;
      for (const v in c) Number(v) === T.classifyId && (R = c[v]);
      T.steelDensity = R, await SQ(T), T.length = T.length || T.theoryLength, T.quantity = T.length, T.mete = T.weighingTotalWeight, (!T.unitPrice || !T.amount) && VQ(T);
    } else throw new Error(`${T.classifyName}下不存在规格为“${m}”的材料，请联系初鸣售后人员添加`);
  }
  return E;
} };
async function SQ(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const gR = { title: "其它钢材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "型号", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "金额", field: "amount", excelField: "__EMPTY_7" }, { label: "颜色", field: "color", excelField: "__EMPTY_8" }, { label: "品牌", field: "brand", excelField: "__EMPTY_9" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (console.log(e), !gi(e, gR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [];
  if (u.forEach((S) => {
    let h = false;
    const T = pi(S.classifyName.split("/"));
    if (T.length === 1) {
      const _ = n.filter((f) => f.name === S.classifyName) || [];
      if (A(_)) if (_.length === 1) h = true, S.classifyId = _[0].id, r.push(_[0].id);
      else {
        const f = [];
        for (const R of _) if (R.isLeaf) for (let v = 0; v < R.fullPathId.length; v++) R.id !== R.fullPathId[v] && f.push(R.fullPathId[v]);
        const m = _.find((R) => Ae(R.parent) && !f.includes(R.id));
        if (A(m)) h = true, S.classifyId = m.id, r.push(m.id);
        else {
          const R = _.filter((v) => v.isLeaf) || [];
          if (R.length === 1) {
            let v = true;
            _.forEach((N) => {
              R[0].fullPathId.includes(N.id) || (v = false);
            }), v && (h = true, S.classifyId = R[0].id, r.push(R[0].id));
          } else for (const v of _) A(v.parent) && !f.includes(v.id) && b.push(v);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${S.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const _ of n) if (_.fullPathName.length >= T.length && mi(_.fullPathName.slice(-T.length), T)) {
      h = true, S.classifyId = _.id, r.push(_.id);
      break;
    }
    if (h || E.push(S.classifyName), S.shortName) {
      const _ = _e.state.project.projectAllType.find((f) => f.shortName === S.shortName);
      A(_) ? S.projectId = _.id : y.push(S.shortName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((S) => `“${S}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((S) => `“${S}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const V = _e.state.config.classifySpec, M = r.filter((S) => V[S] === void 0);
  M.length > 0 && (M.forEach((S) => {
    V[S] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const S of u) {
    if (((g = c == null ? void 0 : c[S.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${S.classifyName}不是末级科目`);
    const h = V[S.classifyId];
    if (h.hasUnitConfig === false) throw new Error(`${S.classifyName}未配置核算单位`);
    let T;
    const _ = S.specification ?? "";
    if (h && Array.isArray(h.specList)) {
      for (const f of h.specList) if (_ === f.spec) {
        if (T = f, S.measureUnit) {
          if (!T.classify.measureUnit) throw new Error(`${S.classifyName}不存在计量单位`);
          if (!await ti(T.classify.measureUnit, S.measureUnit)) throw new Error(`${S.classifyName}填写的计量单位错误，单位应为：“${T.classify.measureUnit}”`);
        }
        if (S.accountingUnit && !await ti(T.classify.accountingUnit, S.accountingUnit)) throw new Error(`${S.classifyName}填写的核算单位错误，单位应为：“${T.classify.accountingUnit}”`);
        break;
      }
    }
    if (console.log(T), T) S.uid = Tt(), S.sn = T.sn, S.specificationLabels = T.specificationLabels, S.serialNumber = T.serialNumber, S.classifySerialNumber = T.classify.serialNumber, S.classifyId = T.classify.id, S.classifyFullPathId = T.classify.fullPathId, S.classifyFullName = T.classify.fullName, S.classifyName = T.classify.name, S.classifyParentFullName = T.classify.parentFullName, S.basicClass = T.classify.basicClass, S.specification = T.spec, S.model = T.spec, S.specificationMap = T.specKV, S.measureUnit = T.classify.measureUnit, S.accountingUnit = T.classify.accountingUnit, S.accountingPrecision = T.classify.accountingPrecision, S.measurePrecision = T.classify.measurePrecision, S.measureUnit || (S.quantity = void 0), S.mete && S.unitPrice && (S.amount = Be(S.mete * S.unitPrice, Ze.YUAN));
    else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系初鸣售后人员添加`);
  }
  return console.log(u), u;
} }, ER = { title: "辅材采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (!gi(e, ER.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Pe.MATERIAL.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [];
  if (u.forEach((S) => {
    let h = false;
    const T = pi(S.classifyName.split("/"));
    if (T.length === 1) {
      const _ = n.filter((f) => f.name === S.classifyName) || [];
      if (A(_)) if (_.length === 1) h = true, S.classifyId = _[0].id, r.push(_[0].id);
      else {
        const f = [];
        for (const R of _) if (R.isLeaf) for (let v = 0; v < R.fullPathId.length; v++) R.id !== R.fullPathId[v] && f.push(R.fullPathId[v]);
        const m = _.find((R) => Ae(R.parent) && !f.includes(R.id));
        if (A(m)) h = true, S.classifyId = m.id, r.push(m.id);
        else {
          const R = _.filter((v) => v.isLeaf) || [];
          if (R.length === 1) {
            let v = true;
            _.forEach((N) => {
              R[0].fullPathId.includes(N.id) || (v = false);
            }), v && (h = true, S.classifyId = R[0].id, r.push(R[0].id));
          } else for (const v of _) A(v.parent) && !f.includes(v.id) && b.push(v);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${S.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const _ of n) if (_.fullPathName.length >= T.length && mi(_.fullPathName.slice(-T.length), T)) {
      h = true, S.classifyId = _.id, r.push(_.id);
      break;
    }
    if (h || E.push(S.classifyName), S.shortName) {
      const _ = _e.state.project.projectAllType.find((f) => f.shortName === S.shortName);
      A(_) ? S.projectId = _.id : y.push(S.shortName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((S) => `“${S}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((S) => `“${S}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const V = _e.state.config.classifySpec, M = r.filter((S) => V[S] === void 0);
  M.length > 0 && (M.forEach((S) => {
    V[S] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const S of u) {
    if (((g = c == null ? void 0 : c[S.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${S.classifyName}不是末级科目`);
    const h = V[S.classifyId];
    if (h.hasUnitConfig === false) throw new Error(`${S.classifyName}未配置核算单位`);
    let T;
    const _ = S.specification ?? "";
    if (h && Array.isArray(h.specList)) {
      for (const f of h.specList) if (_ === f.spec) {
        if (T = f, S.measureUnit) {
          if (!T.classify.measureUnit) throw new Error(`${S.classifyName}不存在计量单位`);
          if (!await ti(T.classify.measureUnit, S.measureUnit)) throw new Error(`${S.classifyName}填写的计量单位错误，单位应为：“${T.classify.measureUnit}”`);
        }
        if (S.accountingUnit && !await ti(T.classify.accountingUnit, S.accountingUnit)) throw new Error(`${S.classifyName}填写的核算单位错误，单位应为：“${T.classify.accountingUnit}”`);
        break;
      }
    }
    if (T) S.uid = Tt(), S.sn = T.sn, S.specificationLabels = T.specificationLabels, S.serialNumber = T.serialNumber, S.classifySerialNumber = T.classify.serialNumber, S.classifyId = T.classify.id, S.classifyFullPathId = T.classify.fullPathId, S.classifyFullName = T.classify.fullName, S.classifyName = T.classify.name, S.classifyParentFullName = T.classify.parentFullName, S.basicClass = T.classify.basicClass, S.specification = T.spec, S.model = T.spec, S.specificationMap = T.specKV, S.measureUnit = T.classify.measureUnit, S.accountingUnit = T.classify.accountingUnit, S.accountingPrecision = T.classify.accountingPrecision, S.measurePrecision = T.classify.measurePrecision, S.measureUnit || (S.quantity = void 0), S.mete && S.unitPrice && (S.amount = Be(S.mete * S.unitPrice, Ze.YUAN));
    else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, yR = { title: "办公用品采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (!gi(e, yR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Ge.OTHER.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [];
  if (u.forEach((S) => {
    let h = false;
    const T = pi(S.classifyName.split("/"));
    if (T.length === 1) {
      const _ = n.filter((f) => f.name === S.classifyName) || [];
      if (A(_)) if (_.length === 1) h = true, S.classifyId = _[0].id, r.push(_[0].id);
      else {
        const f = [];
        for (const R of _) if (R.isLeaf) for (let v = 0; v < R.fullPathId.length; v++) R.id !== R.fullPathId[v] && f.push(R.fullPathId[v]);
        const m = _.find((R) => Ae(R.parent) && !f.includes(R.id));
        if (A(m)) h = true, S.classifyId = m.id, r.push(m.id);
        else {
          const R = _.filter((v) => v.isLeaf) || [];
          if (R.length === 1) {
            let v = true;
            _.forEach((N) => {
              R[0].fullPathId.includes(N.id) || (v = false);
            }), v && (h = true, S.classifyId = R[0].id, r.push(R[0].id));
          } else for (const v of _) A(v.parent) && !f.includes(v.id) && b.push(v);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${S.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const _ of n) if (_.fullPathName.length >= T.length && mi(_.fullPathName.slice(-T.length), T)) {
      h = true, S.classifyId = _.id, r.push(_.id);
      break;
    }
    if (h || E.push(S.classifyName), S.shortName) {
      const _ = _e.state.project.projectAllType.find((f) => f.shortName === S.shortName);
      A(_) ? S.projectId = _.id : y.push(S.shortName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((S) => `“${S}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((S) => `“${S}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const V = _e.state.config.classifySpec, M = r.filter((S) => V[S] === void 0);
  M.length > 0 && (M.forEach((S) => {
    V[S] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const S of u) {
    if (((g = c == null ? void 0 : c[S.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${S.classifyName}不是末级科目`);
    const h = V[S.classifyId];
    if (h.hasUnitConfig === false) throw new Error(`${S.classifyName}未配置核算单位`);
    let T;
    const _ = S.specification ?? "";
    if (h && Array.isArray(h.specList)) {
      for (const f of h.specList) if (_ === f.spec) {
        if (T = f, S.measureUnit) {
          if (!T.classify.measureUnit) throw new Error(`${S.classifyName}不存在计量单位`);
          if (!await ti(T.classify.measureUnit, S.measureUnit)) throw new Error(`${S.classifyName}填写的计量单位错误，单位应为：“${T.classify.measureUnit}”`);
        }
        if (S.accountingUnit && !await ti(T.classify.accountingUnit, S.accountingUnit)) throw new Error(`${S.classifyName}填写的核算单位错误，单位应为：“${T.classify.accountingUnit}”`);
        break;
      }
    }
    if (T) S.uid = Tt(), S.sn = T.sn, S.specificationLabels = T.specificationLabels, S.serialNumber = T.serialNumber, S.classifySerialNumber = T.classify.serialNumber, S.classifyId = T.classify.id, S.classifyFullPathId = T.classify.fullPathId, S.classifyFullName = T.classify.fullName, S.classifyName = T.classify.name, S.classifyParentFullName = T.classify.parentFullName, S.basicClass = T.classify.basicClass, S.specification = T.spec, S.model = T.spec, S.specificationMap = T.specKV, S.measureUnit = T.classify.measureUnit, S.accountingUnit = T.classify.accountingUnit, S.accountingPrecision = T.classify.accountingPrecision, S.measurePrecision = T.classify.measurePrecision, S.measureUnit || (S.quantity = void 0), S.mete && S.unitPrice && (S.amount = Be(S.mete * S.unitPrice, Ze.YUAN));
    else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, TR = { title: "气体采购清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "*物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "含税单价", field: "unitPrice", excelField: "__EMPTY_6" }, { label: "颜色", field: "color", excelField: "__EMPTY_7" }, { label: "品牌", field: "brand", excelField: "__EMPTY_8" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (!gi(e, TR.rules)) return;
  _e.state.project.projectAllTypeLoaded || await _e.dispatch("project/fetchProjectAllType"), _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Pe.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [], y = [];
  const b = [];
  if (u.forEach((S) => {
    let h = false;
    const T = pi(S.classifyName.split("/"));
    if (T.length === 1) {
      const _ = n.filter((f) => f.name === S.classifyName) || [];
      if (A(_)) if (_.length === 1) h = true, S.classifyId = _[0].id, r.push(_[0].id);
      else {
        const f = [];
        for (const R of _) if (R.isLeaf) for (let v = 0; v < R.fullPathId.length; v++) R.id !== R.fullPathId[v] && f.push(R.fullPathId[v]);
        const m = _.find((R) => Ae(R.parent) && !f.includes(R.id));
        if (A(m)) h = true, S.classifyId = m.id, r.push(m.id);
        else {
          const R = _.filter((v) => v.isLeaf) || [];
          if (R.length === 1) {
            let v = true;
            _.forEach((N) => {
              R[0].fullPathId.includes(N.id) || (v = false);
            }), v && (h = true, S.classifyId = R[0].id, r.push(R[0].id));
          } else for (const v of _) A(v.parent) && !f.includes(v.id) && b.push(v);
        }
      }
      if (b.length > 1) throw new Error(`科目名称“${S.classifyName}”在科目配置中存在同名的情况，需要带上父级科目名称如“一级科目/二级科目/末级科目”`);
    } else for (const _ of n) if (_.fullPathName.length >= T.length && mi(_.fullPathName.slice(-T.length), T)) {
      h = true, S.classifyId = _.id, r.push(_.id);
      break;
    }
    if (h || E.push(S.classifyName), S.shortName) {
      const _ = _e.state.project.projectAllType.find((f) => f.shortName === S.shortName);
      A(_) ? S.projectId = _.id : y.push(S.shortName);
    }
  }), E = Array.from(new Set(E)), E.length > 0) throw new Error(`${E.map((S) => `“${S}”`).join("、")}${E.length > 1 ? "等" : ""}物料种类不存在`);
  if (y = Array.from(new Set(y)), y.length > 0) throw new Error(`${y.map((S) => `“${S}”`).join("、")}${y.length > 1 ? "等" : ""}项目不存在`);
  const V = _e.state.config.classifySpec, M = r.filter((S) => V[S] === void 0);
  M.length > 0 && (M.forEach((S) => {
    V[S] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", M));
  for (const S of u) {
    if (((g = c == null ? void 0 : c[S.classifyId]) == null ? void 0 : g.isLeaf) === false) throw new Error(`${S.classifyName}不是末级科目`);
    const h = V[S.classifyId];
    if (h.hasUnitConfig === false) throw new Error(`${S.classifyName}未配置核算单位`);
    let T;
    const _ = S.specification ?? "";
    if (h && Array.isArray(h.specList)) {
      for (const f of h.specList) if (_ === f.spec) {
        if (T = f, S.measureUnit) {
          if (!T.classify.measureUnit) throw new Error(`${S.classifyName}不存在计量单位`);
          if (!await ti(T.classify.measureUnit, S.measureUnit)) throw new Error(`${S.classifyName}填写的计量单位错误，单位应为：“${T.classify.measureUnit}”`);
        }
        if (S.accountingUnit && !await ti(T.classify.accountingUnit, S.accountingUnit)) throw new Error(`${S.classifyName}填写的核算单位错误，单位应为：“${T.classify.accountingUnit}”`);
        break;
      }
    }
    if (T) S.uid = Tt(), S.sn = T.sn, S.specificationLabels = T.specificationLabels, S.serialNumber = T.serialNumber, S.classifySerialNumber = T.classify.serialNumber, S.classifyId = T.classify.id, S.classifyFullPathId = T.classify.fullPathId, S.classifyFullName = T.classify.fullName, S.classifyName = T.classify.name, S.classifyParentFullName = T.classify.parentFullName, S.basicClass = T.classify.basicClass, S.specification = T.spec, S.model = T.spec, S.specificationMap = T.specKV, S.measureUnit = T.classify.measureUnit, S.accountingUnit = T.classify.accountingUnit, S.accountingPrecision = T.classify.accountingPrecision, S.measurePrecision = T.classify.measurePrecision, S.measureUnit || (S.quantity = void 0), S.mete && S.unitPrice && (S.amount = Be(S.mete * S.unitPrice, Ze.YUAN));
    else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系初鸣售后人员添加`);
  }
  return u;
} }, vQ = { NET: { L: "净重", K: "NET", V: 0 }, GROSS: { L: "毛重", K: "GROSS", V: 1 }, NONE: { L: "不显示", K: "NONE", V: -1 } };
ve(vQ);
const $n = { LONGITUDINAL: { L: "纵向", K: "LONGITUDINAL", V: 1 }, TRANSVERSE: { L: "横向", K: "TRANSVERSE", V: 2 }, LONGITUDINAL_NO_LIMIT: { L: "纵向（不限高度）", K: "LONGITUDINAL_NO_LIMIT", V: 3 } };
ve($n);
