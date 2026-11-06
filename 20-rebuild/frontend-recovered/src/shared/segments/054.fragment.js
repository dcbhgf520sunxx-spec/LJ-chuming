function kft(e) {
  return W({ module: "wms", url: `inbound/application/record/quality-testing/${e}`, method: "get" });
}
const Dft = { get: Tle, edit: _le, del: Vle, detail: wle }, Sle = { class: "mtb-10" }, vle = { class: "color-green" }, Rle = { key: 0 }, Mle = { key: 1 }, n4 = { __name: "struc-manuf-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Z(), { form: u } = Wi(), r = Z([]), E = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }] }, y = Ee(() => Object.assign({}, E)), { tableValidate: b, wrongCellMask: V } = ui({ rules: y });
  function M(T) {
    Ce([() => T.quantity, () => T.weight, () => T.length, () => T.area], () => g(T), { immediate: true });
  }
  function g(T) {
    let _ = false, f, m = 1;
    T.wageQuotaType === Gi.WEIGHT.V ? (f = T.weight, m = 1e3) : T.wageQuotaType === Gi.LENGTH.V ? f = St(T.length, "mm", "m", Ze.COM_T__MM) : T.wageQuotaType === Gi.AREA.V ? f = St(T.surfaceArea, "mm²", "㎡", 6) : f = 1, A(f) && T.quantity ? (T.mete = Be(f * T.quantity, T.accountingPrecision), T.amount = Be(T.unitPrice * T.mete / m, Ze.YUAN), _ = true) : (T.mete = 0, T.amount = 0, _ = false), u.selectObj[T.mergeId] = {}, u.selectObj[T.mergeId] = { ...T, isSelected: _ };
  }
  function S() {
    const T = u.strucManufList.filter((f) => {
      var m;
      return !!(n.boolPartyA || (m = u.selectObj[f.mergeId]) != null && m.isSelected);
    });
    if (Ae(T)) return true;
    const { validResult: _ } = b(T);
    return _;
  }
  function h(T, _) {
  }
  return o({ validate: S, toggleRowSelection: h, rowWatch: M }), (T, _) => {
    const f = Mt, m = vt, R = jt, v = Ve("common-input-number"), N = Ve("common-table");
    return w(), U(N, ii({ ref_key: "tableRef", ref: c, "cell-class-name": l(V), data: l(u).strucManufList, "expand-row-keys": r.value, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, T.$attrs), { default: p(() => [s(Ha, { "expand-row-keys": r.value, "onUpdate:expandRowKeys": _[0] || (_[0] = (P) => r.value = P), data: l(u).strucManufList, fixed: "left", "row-key": "uid" }, { default: p(({ row: P }) => [C("div", Sle, [s(f, { modelValue: P.remark, "onUpdate:modelValue": (L) => P.remark = L, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(m, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(m, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "长度（mm）", prop: "length", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "计价方式", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, K(l(Gi).VL[P.wageQuotaType]), 1)]), _: 1 }), s(m, { align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, K(P.accountingUnit), 1)]), _: 1 }), s(m, { align: "center", label: "采购数量", prop: "purchaseQuantity", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, [s(R, { content: "已入库数量", effect: "dark", placement: "top" }, { default: p(() => [C("span", vle, K(P.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(P.purchaseQuantity), 1)])]), _: 1 }), s(m, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: p(({ row: P }) => [s(v, { modelValue: P.quantity, "onUpdate:modelValue": (L) => P.quantity = L, controls: false, max: P.canPurchaseQuantity, min: 0, precision: 0, step: 1, placeholder: "本次实收数", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), s(m, { label: "核算量", align: "center", "min-width": "120px", prop: "mete" }, { default: p(({ row: P }) => [P.wageQuotaType === l(Gi).WEIGHT.V ? (w(), Q("span", Rle, K(l(St)(P.mete, l(vi)[l(Pe).STRUC_MANUFACTURED.V].showWeight.unit, l(vi)[l(Pe).STRUC_MANUFACTURED.V].weight.unit)), 1)) : (w(), Q("span", Mle, K(P.mete), 1))]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} }, Ale = Object.freeze(Object.defineProperty({ __proto__: null, default: n4 }, Symbol.toStringTag, { value: "Module" })), Nle = { class: "mtb-10" }, Lle = { class: "color-green" }, Ile = { key: 0 }, Cle = { key: 1 }, s4 = { __name: "encl-manuf-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, c = Z(), { form: u } = Wi(), r = Z([]), E = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Vi, message: "数量必须大于0", trigger: "blur" }] }, y = Ee(() => Object.assign({}, E)), { tableValidate: b, wrongCellMask: V } = ui({ rules: y });
  function M(T) {
    Ce([() => T.quantity, () => T.weight, () => T.length, () => T.area], () => g(T), { immediate: true });
  }
  function g(T) {
    let _ = false, f, m = 1;
    T.wageQuotaType === Gi.WEIGHT.V ? (f = T.weight, m = 1e3) : T.wageQuotaType === Gi.LENGTH.V ? f = St(T.length, "mm", "m", Ze.COM_T__MM) : T.wageQuotaType === Gi.AREA.V ? f = St(T.surfaceArea, "mm²", "㎡", 6) : f = 1, A(f) && T.quantity ? (T.mete = Be(f * T.quantity, T.accountingPrecision), T.amount = Be(T.unitPrice * T.mete / m, Ze.YUAN), _ = true) : (T.mete = 0, T.amount = 0, _ = false), u.selectObj[T.mergeId] = {}, u.selectObj[T.mergeId] = { ...T, isSelected: _ };
  }
  function S() {
    var f;
    const T = (f = u.enclManufList) == null ? void 0 : f.filter((m) => {
      var R;
      return !!(n.boolPartyA || (R = u.selectObj[m.mergeId]) != null && R.isSelected);
    });
    if (Ae(T)) return true;
    const { validResult: _ } = b(T);
    return _;
  }
  function h(T, _) {
  }
  return o({ validate: S, toggleRowSelection: h, rowWatch: M }), (T, _) => {
    const f = Mt, m = vt, R = jt, v = Ve("common-input-number"), N = Ve("common-table");
    return w(), U(N, ii({ ref_key: "tableRef", ref: c, "cell-class-name": l(V), data: l(u).enclManufList, "expand-row-keys": r.value, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, T.$attrs), { default: p(() => [s(Ha, { "expand-row-keys": r.value, "onUpdate:expandRowKeys": _[0] || (_[0] = (P) => r.value = P), data: l(u).enclManufList, fixed: "left", "row-key": "uid" }, { default: p(({ row: P }) => [C("div", Nle, [s(f, { modelValue: P.remark, "onUpdate:modelValue": (L) => P.remark = L, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(m, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(m, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(m, { key: "specification", "show-overflow-tooltip": true, label: "板型", "min-width": "100px", prop: "specification" }), s(m, { key: "width", label: `有效宽度
(mm)`, "show-overflow-tooltip": true, "min-width": "100px", prop: "width" }), s(m, { key: "thickness", label: `厚度
(mm)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "thickness" }), s(m, { key: "length", label: `单长
(㎜)`, "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "length" }), s(m, { key: "totalArea", label: "总面积(㎡)", "show-overflow-tooltip": true, align: "left", "min-width": "100px", prop: "totalArea" }), s(m, { key: "totalLength", label: "总长度(m)", align: "left", "min-width": "100px", prop: "totalLength" }), s(m, { key: "weight", label: "总重量(kg)", align: "left", "min-width": "100px", prop: "weight" }), s(m, { key: "brand", "show-overflow-tooltip": true, label: "品牌", prop: "brand", width: "100px" }), s(m, { key: "color", "show-overflow-tooltip": true, label: "颜色", prop: "color", width: "80px" }), s(m, { align: "center", label: "计价方式", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, K(l(Gi).VL[P.wageQuotaType]), 1)]), _: 1 }), s(m, { align: "center", label: "核算单位", prop: "accountingUnit", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, K(P.accountingUnit), 1)]), _: 1 }), s(m, { align: "center", label: "采购数量", prop: "purchaseQuantity", "show-overflow-tooltip": "" }, { default: p(({ row: P }) => [C("span", null, [s(R, { content: "已入库数量", effect: "dark", placement: "top" }, { default: p(() => [C("span", Lle, K(P.inboundQuantity), 1)]), _: 2 }, 1024), Te(" / " + K(P.purchaseQuantity), 1)])]), _: 1 }), s(m, { align: "center", label: "本次实收数", "min-width": "120px", prop: "quantity" }, { default: p(({ row: P }) => [s(v, { modelValue: P.quantity, "onUpdate:modelValue": (L) => P.quantity = L, controls: false, max: P.canPurchaseQuantity, min: 0, precision: 0, step: 1, placeholder: "本次实收数", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), s(m, { label: "核算量", align: "center", "min-width": "120px", prop: "mete" }, { default: p(({ row: P }) => [P.wageQuotaType === l(Gi).WEIGHT.V ? (w(), Q("span", Ile, K(l(St)(P.mete, l(vi)[l(Pe).ENCL_MANUFACTURED.V].showWeight.unit, l(vi)[l(Pe).ENCL_MANUFACTURED.V].weight.unit)), 1)) : (w(), Q("span", Cle, K(P.mete), 1))]), _: 1 }), s(m, { key: "remark", "show-overflow-tooltip": true, label: "备注", prop: "remark", width: "80px" })]), _: 1 }, 16, ["cell-class-name", "data", "expand-row-keys"]);
  };
} }, Ple = Object.freeze(Object.defineProperty({ __proto__: null, default: s4 }, Symbol.toStringTag, { value: "Module" }));
const Ole = { class: "manuf-inbound-application-container" }, kle = { class: "filter-container" }, Dle = { class: "filter-left-box" }, xle = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success"], setup(e, { emit: o }) {
  const n = o, c = Z({}), u = e, r = Pe.STRUC_MANUFACTURED.V | Pe.ENCL_MANUFACTURED.V, E = Ee(() => {
    var ge, Le;
    return ((Le = (ge = S.value) == null ? void 0 : ge.details[0]) == null ? void 0 : Le.projectId) || void 0;
  }), y = { strucManufList: { K: "strucManufList", L: Pe.STRUC_MANUFACTURED.L, V: Pe.STRUC_MANUFACTURED.V, TABLE: n4 }, enclManufList: { K: "enclManufList", L: Pe.ENCL_MANUFACTURED.L, V: Pe.ENCL_MANUFACTURED.V, TABLE: s4 } }, b = { purchaseId: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], strucManufList: [], enclManufList: [] }, V = Z(), M = Z(), g = Z(), S = Z(), h = Z(false), T = Z({}), _ = Z(), f = Z([]), m = Z(false), R = Ct({ strucManufList: null, enclManufList: null }), v = Ee(() => false);
  function N(ge) {
    var Ie, Se;
    return ((Se = (Ie = Y[ge === "strucManufList" ? "originStructureList" : "originEnclosureList"]) == null ? void 0 : Ie.filter((X) => {
      var $, k;
      return (k = ($ = Y.selectObj) == null ? void 0 : $[X.mergeId]) == null ? void 0 : k.isSelected;
    })) == null ? void 0 : Se.length) || 0;
  }
  const P = Ee(() => {
    const ge = [];
    return A(Y.originStructureList) && Y.originStructureList.forEach((Le) => {
      var Ie, Se;
      (m.value || (Se = (Ie = Y.selectObj) == null ? void 0 : Ie[Le.mergeId]) != null && Se.isSelected) && (Le.wageQuotaType === Gi.WEIGHT.V ? Le.showManufWeight = St(Le.mete, vi[Pe.STRUC_MANUFACTURED.V].showWeight.unit, vi[Pe.STRUC_MANUFACTURED.V].weight.unit) : Le.showManufWeight = Le.mete, ge.push(Le));
    }), A(Y.originEnclosureList) && Y.originEnclosureList.forEach((Le) => {
      var Ie, Se;
      (m.value || (Se = (Ie = Y.selectObj) == null ? void 0 : Ie[Le.mergeId]) != null && Se.isSelected) && (Le.wageQuotaType === Gi.WEIGHT.V ? Le.showManufWeight = St(Le.mete, vi[Pe.STRUC_MANUFACTURED.V].showWeight.unit, vi[Pe.STRUC_MANUFACTURED.V].weight.unit) : Le.showManufWeight = Le.mete, ge.push(Le));
    }), ge;
  }), L = Ee(() => {
    let ge = 0;
    return !m.value && v.value && P.value.forEach((Le) => {
      A(Le.amount) && (ge += +Le.amount);
    }), ji(ge, 2);
  }), O = Ee(() => {
    let ge = 0;
    return P.value.forEach((Le) => {
      A(Le.mete) && (ge += +Le.mete);
    }), ji(ge, 2);
  });
  yi("matSpecRef", M);
  const x = (ge) => {
    const Le = { strucManufList: null, enclManufList: null }, Ie = ["strucManufList", "enclManufList"];
    let Se = false;
    Ie.forEach((X) => {
      if (A(ge[X])) {
        if (!Se) {
          Se = true;
          const $ = Ce(h, (k) => {
            k && pt(() => {
              _.value = X, $();
            });
          }, { immediate: true });
        }
        ge[X] = ge[X].map(($) => Ct($)), Le[X] = Ce(R, ($) => {
          $[X] && (ge[X].forEach((k) => {
            var J, z;
            $[X].rowWatch(k), !m.value && ((z = (J = ge.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected);
          }), pt(() => {
            Le[X]();
          }));
        }, { immediate: true, deep: true });
      }
    }), q();
  }, { cu: I, form: Y, FORM: ee } = Pa({ title: "制成品入库", formStore: !u.edit, formStoreKey: "WMS_INBOUND_APPLICATION_MANUF", permission: ib, defaultForm: b, useDraftCallback: x, clearDraftCallback: me, api: u.edit ? ble : yle }, g, u.detail);
  let B = {};
  u.edit ? B = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 20 } : B = { mainBox: ".manuf-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 300, extraHeight: 20 };
  const { fixMaxHeight: q, maxHeight: ae, maxHeightStyle: j } = Kt(B), le = Ee(() => _.value ? y[_.value].TABLE : y.strucManufList.TABLE);
  Ce(_, (ge) => {
    f.value = Y[ge], ge && pt(() => {
      R[ge] || (R[ge] = V.value);
    });
  }, { immediate: true }), Ce(f, (ge) => {
    Y[_.value] = ge;
  }), Ce(() => O.value, (ge) => {
    I.props.totalWeight = ge;
  }), me();
  const oe = Ee(() => !u.edit);
  ee.HOOK.beforeToEdit = async (ge, Le) => {
    var Ie;
    u.edit && (Le.purchaseId = (Ie = Le.purchaseOrder) == null ? void 0 : Ie.id, Le.logistics || (Le.logistics = {}), x(Le));
  }, ee.HOOK.afterSubmit = () => {
    u.edit && n("success"), me();
  };
  function ye() {
    if (_.value) {
      const ge = [], Le = ["monomerId", "areaId", "manufacturedSn", "specification", "material", "manufacturedType"];
      (_.value === "strucManufList" ? Y.originStructureList : Y.originEnclosureList).forEach((Se) => {
        var $;
        let X = true;
        for (let k = 0; k < Le.length; k++) {
          const J = Le[k];
          if (c.value[J]) {
            if ((J === "monomerId" || J === "areaId") && _.value === "strucManufList") {
              if (Se[J] !== c.value[J]) {
                X = false;
                break;
              }
            } else if ((($ = Se[J]) == null ? void 0 : $.indexOf(c.value[J])) < 0) {
              X = false;
              break;
            }
          }
        }
        X && ge.push(Se);
      }), Y[_.value] = ge;
    } else Y.strucManufList = [], Y.enclManufList = [];
  }
  function ce() {
    if (c.value = {}, Y[_.value] = [], _.value) {
      const ge = _.value === "strucManufList" ? Y.originStructureList : Y.originEnclosureList;
      Y[_.value] = ge;
    }
  }
  function se() {
    if (!m.value && Ae(P.value)) return ot.warning("请选择数据"), false;
    const ge = he();
    return ge && (Y.list = P.value), ge;
  }
  function he() {
    return Object.keys(R).every((ge) => R[ge] ? R[ge].validate() : true);
  }
  async function be(ge) {
    var Le;
    if (me(), S.value = ge, I.props.order = ge, oe.value && (Y.strucManufList = [], Y.enclManufList = [], Y.originStructureList = [], Y.originEnclosureList = []), m.value = false, ge) {
      if (Object.keys(y).forEach((Ie) => {
        y[Ie].V & ge.basicClass && (_.value || (_.value = y[Ie].K), T.value[Ie] = false), (m.value || !(y[Ie].V & ge.basicClass)) && (Y[Ie] = []);
      }), pt(() => {
        R[_.value] = V.value;
      }), (Le = ge == null ? void 0 : ge.details) != null && Le.length) {
        Y.list = ge.details, Y.strucManufList = [], Y.enclManufList = [];
        for (const Ie of Y.list) switch (Ie.basicClass) {
          case Pe.STRUC_MANUFACTURED.V:
            Y.strucManufList.push(Ie);
            break;
          case Pe.ENCL_MANUFACTURED.V:
            Y.enclManufList.push(Ie);
            break;
        }
        Y.originStructureList = Y.strucManufList, Y.originEnclosureList = Y.enclManufList, x(Y);
      }
    } else pt(() => {
      R.strucManufList = null, R.enclManufList = null;
    });
    h.value = true;
  }
  function me() {
    T.value = { strucManufList: true, enclManufList: true }, _.value = void 0, h.value = false, m.value = false;
  }
  return (ge, Le) => {
    var J, z, F;
    const Ie = Is, Se = Mt, X = Ve("common-button"), $ = Li, k = _t("permission");
    return qe((w(), Q("div", Ole, [s(Ar, { basicClass: r, "current-basic-class": (J = y[_.value]) == null ? void 0 : J.V, "total-value": O.value, "total-amount": L.value, "show-total-amount": !m.value && v.value, "contract-unit": (z = S.value) == null ? void 0 : z.unit, "hideen-begin": true, "contract-value": (F = S.value) == null ? void 0 : F.mete, validate: se, edit: u.edit, "is-manuf": "", unit: "", "total-name": "总量合计", onPurchaseOrderChange: be }, { default: p(() => [C("div", kle, [C("div", Dle, [s(l(Ls), { modelValue: _.value, "onUpdate:modelValue": Le[0] || (Le[0] = (G) => _.value = G), size: "default", class: "filter-item" }, { default: p(() => [(w(), Q(Qe, null, ki(y, (G) => s(Ie, { key: G.K, value: G.K, disabled: T.value[G.K] }, { default: p(() => [Te(K(G.L) + K(N(G.K) ? `(${N(G.K)})` : ""), 1)]), _: 2 }, 1032, ["value", "disabled"])), 64))]), _: 1 }, 8, ["modelValue"]), _.value === "strucManufList" ? (w(), U(l(md), { key: 0, areaId: c.value.areaId, "onUpdate:areaId": Le[1] || (Le[1] = (G) => c.value.areaId = G), monomerId: c.value.monomerId, "onUpdate:monomerId": Le[2] || (Le[2] = (G) => c.value.monomerId = G), "project-id": E.value, areaClearable: "", clearable: "", onChange: ye }, null, 8, ["areaId", "monomerId", "project-id"])) : H("", true), s(Se, { modelValue: c.value.manufacturedSn, "onUpdate:modelValue": Le[3] || (Le[3] = (G) => c.value.manufacturedSn = G), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入编号搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(Se, { modelValue: c.value.specification, "onUpdate:modelValue": Le[4] || (Le[4] = (G) => c.value.specification = G), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入规格搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(Se, { modelValue: c.value.material, "onUpdate:modelValue": Le[5] || (Le[5] = (G) => c.value.material = G), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入材质搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), s(X, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: Pi(ye, ["stop"]) }, { default: p(() => Le[6] || (Le[6] = [Te(" 搜索 ")])), _: 1, __: [6] }), s(X, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: Pi(ce, ["stop"]) }, { default: p(() => Le[7] || (Le[7] = [Te(" 重置 ")])), _: 1, __: [7] })]), Le[8] || (Le[8] = C("div", { class: "filter-right-box" }, null, -1))]), s($, { ref_key: "formRef", ref: g, model: l(Y) }, { default: p(() => [(w(), U(Ri(le.value), { ref_key: "manufRef", ref: V, "max-height": l(ae), style: ri(l(j)), "bool-party-a": m.value, fillableAmount: v.value }, null, 8, ["max-height", "style", "bool-party-a", "fillableAmount"]))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["current-basic-class", "total-value", "total-amount", "show-total-amount", "contract-unit", "contract-value", "edit"])])), [[k, l(ib)]]);
  };
} }, Ec = ut(xle, [["__scopeId", "data-v-8bde3b17"]]), Ule = Object.freeze(Object.defineProperty({ __proto__: null, default: Ec }, Symbol.toStringTag, { value: "Module" }));
const Yle = { __name: "form", setup(e) {
  const { CRUD: o, crud: n, form: c } = An(), { baseUnit: u } = ai(), r = Ee(() => {
    switch (c.basicClass) {
      case Ge.STEEL_PLATE.V:
      case Ge.SECTION_STEEL.V:
      case Ge.STEEL_COIL.V:
      case Pe.OTHER_STEEL_MATERIALS.V:
        return wm;
      case Ge.MATERIAL.V:
        return a4;
      case Ge.GAS.V:
        return o4;
      case Ge.STRUC_MANUFACTURED.V:
      case Ge.ENCL_MANUFACTURED.V:
        return Ec;
      case Ge.OTHER.V:
        return l4;
      default:
        return c.basicClass & ua ? wm : void 0;
    }
  });
  function E(b) {
    var V, M;
    b.materialIsWholeName = b.materialIsWhole === 2 ? "余料" : "整料", b.profileLibraryStandard = (b == null ? void 0 : b.nationalStandard) || void 0, b.workshopName = (V = b == null ? void 0 : b.workshop) == null ? void 0 : V.name, b.warehouseName = (M = b == null ? void 0 : b.warehouse) == null ? void 0 : M.name, b.projectSerialNumber = di(b.project);
  }
  o.HOOK.beforeEditDetailLoaded = async (b, V) => {
    var g, S, h, T;
    const M = JSON.parse(V.jsonData);
    A(M) && (V.list = (M == null ? void 0 : M.list) || []), await Qt(V.list), V.list = await Ut(V.list, { toSmallest: false, toNum: true }), V.list.forEach((_) => {
      var f, m, R, v;
      V.inboundWay === si.OPENING_RECEIPT.V ? E(_) : _.warehouseName = ((f = _.workshop) == null ? void 0 : f.name) || _.warehouseName, _.workshopId = ((m = _.workshop) == null ? void 0 : m.id) || _.workshopId, _.warehouseId = ((R = _.warehouse) == null ? void 0 : R.id) || _.warehouseId, _.projectId = ((v = _.project) == null ? void 0 : v.id) || _.projectId, _.amountExcludingVatFreight = _.amountExcludingVAT;
    }), V.workshopId = (g = V.mesWorkshop) == null ? void 0 : g.id, V.logistics = A(M) && A(M.logisticsOrder) ? M.logisticsOrder : null, V.supplierId = (h = (S = V.purchaseOrder) == null ? void 0 : S.supplier) == null ? void 0 : h.id, V.supplyType !== Ni.PARTY_A.V && A((T = V.purchaseOrder) == null ? void 0 : T.details) && (V.originList = At(V.list), await Es(V.originList), V.list = [], V.editObj = {}, V.originList.forEach((_) => {
      var f, m;
      _.applyPurchaseId = _.applyPurchaseId || _.mergeId, _.basicClass & (Ge.STEEL_PLATE.V | Ge.SECTION_STEEL.V) && (_.theoryTotalWeight = Be(_.theoryWeight * _.quantity, u.value[_.basicClass].weight.precision)), V.editObj[_.mergeId] ? (V.editObj[_.mergeId].applyPurchaseObj[_.applyPurchaseId] ? V.editObj[_.mergeId].applyPurchaseObj[_.applyPurchaseId].push({ ..._ }) : V.editObj[_.mergeId].applyPurchaseObj[_.applyPurchaseId] = [{ ..._ }], V.editObj[_.mergeId].quantity += _.quantity, V.editObj[_.mergeId].mete += _.mete) : (V.editObj[_.mergeId] = { ..._, applyPurchaseObj: { [_.applyPurchaseId]: [{ ..._ }] }, isSelected: true }, _.basicClass & Ge.SECTION_STEEL.V && A(V.purchaseOrder) && (V.editObj[_.mergeId].length = ((m = (f = V.purchaseOrder) == null ? void 0 : f.details.find((R) => R.id === _.mergeId)) == null ? void 0 : m.length) || V.editObj[_.mergeId].length));
    })), V.inboundWay === si.OPENING_RECEIPT.V && (V.jsonData = JSON.stringify(V));
  };
  function y() {
    n.cancelCU(), n.refresh();
  }
  return (b, V) => {
    const M = Ve("common-drawer");
    return w(), U(M, { ref: "drawerRef", "before-close": l(n).cancelCU, "content-loading": l(n).editDetailLoading, "show-close": true, title: l(n).status.title, visible: l(n).status.cu > l(o).STATUS.NORMAL, "custom-class": "raw-mat-inbound-application-record-form", size: "90%" }, { content: p(() => [(w(), U(Ri(r.value), { detail: l(c), edit: "", onSuccess: y, onBeginClose: l(n).cancelCU }, null, 40, ["detail", "onBeginClose"]))]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, r4 = ut(Yle, [["__scopeId", "data-v-8b2060cd"]]), Kle = Object.freeze(Object.defineProperty({ __proto__: null, default: r4 }, Symbol.toStringTag, { value: "Module" }));
const Wle = { key: 0, class: "footer" }, jle = { key: 1 }, Fle = { key: 1 }, zle = { __name: "partyA-detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, { decimalPrecision: u } = Ln(), r = ft("permission"), E = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", u.value.wms]], ["unitPriceNoFreight", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["amountNoFreight", ["to-thousand", Ze.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["inputVATNoFreight", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), y = Z(), b = Z([]), { CRUD: V, crud: M, detail: g } = qi(), { inboundFillWayCfg: S } = aa(), h = Z(), T = Z(), _ = Z(false), f = Ee(() => {
    var Se;
    let Ie = 0;
    return (Se = g.list) == null || Se.forEach((X) => {
      Ie += Number(X.mete) || 0;
    }), Be(Ie, ei.weight.precision);
  }), { maxHeight: m } = Kt({ mainBox: ".raw-mat-inbound-application-record-preview", extraBox: [".el-drawer__header", ".inspection-return-info", ".el-pagination"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10, paginate: true }, () => Ee(() => !M.detailLoading)), R = Ee(() => g.purchaseOrder || {}), v = Ee(() => g.reviewStatus === Lt.PASS.V && R.value.logisticsPayerType === Bi.DEMAND.V), N = Ee(() => A(S.value) ? Ae(R.value.details) && S.value.amountFillWay === $l.REVIEWING.V || A(R.value.details) && S.value.passedInboundState === Sl.MODIFY.V : false), P = Ee(() => Ai(r.showAmount) && (Ae(R.value.details) || A(R.value.details) && (S.value.passedInboundState === Sl.MODIFY.V || S.value.passedInboundState === Sl.SHOW.V))), L = Z(Lt.PASS.V), O = Ee(() => (g == null ? void 0 : g.supplyType) === Ni.PARTY_A.V), x = Ee(() => g.basicClass & va.MANUFACTURED.V), I = Ee(() => R.value.logisticsPayerType === Bi.DEMAND.V && (S.value ? S.value.freightShowScene === Aa.INVENTORY_REVIEW.V : true)), Y = Ee(() => g.inboundWay === si.OPENING_RECEIPT.V ? M.detailLoading ? "入库单" : `入库单：${g.serialNumber}` : M.detailLoading ? "入库单" : `入库单：${g.serialNumber}（ ${R.value.supplier ? R.value.supplier.name : "无供应商"} ）`), ee = Ee(() => {
    const Ie = P.value && !O.value && R.value.projects && R.value.requisitionsSN, Se = P.value && O.value && R.value.projects && R.value.requisitionsSN;
    return !(Ie || Se);
  });
  V.HOOK.beforeDetailLoaded = async (Ie, Se) => {
    h.value = void 0, Se.list.map((X) => {
      X.originUnitPrice = X.unitPrice, X.originAmount = X.amount;
    }), await Qt(Se.list), Se.list = await Ut(Se.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), !(Se.qualityTestingEnum & Pl.UNREVIEWED.V) && (Se.originList = At(Se.list), Se.list = Se.originList.filter((X) => X.qualityTestingEnum & (Pl.ALL_PASS.V | Pl.NO.V)), Se.returnList = Se.originList.filter((X) => X.qualityTestingEnum & Pl.ALL_REFUSE.V), Se.logistics = A(Se.logistics) ? Se.logistics : {}, Se.originLogistics = A(Se.logistics) ? At(Se.logistics) : {});
  };
  function B(Ie) {
    return Hi({ ...Ie, data: Le.value || [] }, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN], ["amountNoFreight", Ze.YUAN], ["amountExcludingVATNoFreight", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight", "amountExcludingVATNoFreight"] });
  }
  const q = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, ae = Ee(() => {
    const Ie = {};
    return N.value && !O.value && g.editMoney && L.value === Lt.PASS.V && Object.assign(Ie, q), Ie;
  }), { tableValidate: j, cleanUpData: le, wrongCellMask: oe } = ui({ rules: ae });
  async function ye() {
    const { validResult: Ie, dealList: Se } = j(g.list);
    Ie && (g.list = Se);
    let X = true;
    return I.value && T.value && (X = await T.value.validate()), Ie && X;
  }
  async function ce(Ie) {
    return le(Ie.list), Ie.list = await Ut(Ie.list, { toSmallest: true, toNum: true }), Ie;
  }
  async function se(Ie) {
    var Se, X, $, k, J, z, F, G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne;
    try {
      _.value = true, L.value = Ie;
      const He = c.componentName === at.INBOUND_PARTY_A.V ? _S : uv;
      let ze = true;
      if (Ie === Lt.REFUSE.V ? (ze = true, Ae(h.value) && (ot.error("请输入审批意见"), ze = false)) : ze = await ye(g), !ze) return;
      const Oe = At(g);
      let Re = await ce(Oe);
      if (((Se = R.value) == null ? void 0 : Se.logisticsPayerType) === Bi.SUPPLIER.V && (Re.logistics = void 0), Ae(Re.logistics)) Re.logistics = null;
      else {
        const Je = {};
        ((X = Re.originLogistics) == null ? void 0 : X.freight) !== (($ = Re.logistics) == null ? void 0 : $.freight) && (Je.freight = (k = Re.logistics) == null ? void 0 : k.freight), ((J = Re.originLogistics) == null ? void 0 : J.freightWeight) !== ((z = Re.logistics) == null ? void 0 : z.freightWeight) && (Je.freightWeight = (F = Re.logistics) == null ? void 0 : F.freightWeight), ((G = Re.originLogistics) == null ? void 0 : G.loadingCharge) !== ((ie = Re.logistics) == null ? void 0 : ie.loadingCharge) && (Je.loadingCharge = (ue = Re.logistics) == null ? void 0 : ue.loadingCharge), ((ne = Re.originLogistics) == null ? void 0 : ne.invoiceType) !== ((te = Re.logistics) == null ? void 0 : te.invoiceType) && (Je.invoiceType = (de = Re.logistics) == null ? void 0 : de.invoiceType), ((pe = Re.originLogistics) == null ? void 0 : pe.taxRate) !== ((re = Re.logistics) == null ? void 0 : re.taxRate) && (Je.taxRate = (we = Re.logistics) == null ? void 0 : we.taxRate), ((Ke = Re.originLogistics) == null ? void 0 : Ke.supplierId) !== ((Me = Re.logistics) == null ? void 0 : Me.supplierId) && (Je.supplierId = (Ne = Re.logistics) == null ? void 0 : Ne.supplierId), Ae(Je) ? Re.logistics = null : Re.logistics = Je;
      }
      const fe = { approveRecordId: g.approveRecordId, decision: Ie, opinion: h.value }, Ue = [];
      g.editMoney && (Re.list.map((Je) => {
        (Je.originUnitPrice !== Je.unitPrice || Je.originAmount !== Je.amount) && Ue.push({ amount: Je.amount, id: Je.id, unitPrice: Je.unitPrice });
      }), Re.inboundDetailMoneyDTOParams = Ue), Ie === Lt.REFUSE.V && (Re = { id: g.id }), await He(fe, Re), n("auditSuccess");
    } catch (He) {
      console.log("入库审核提交", He);
    } finally {
      _.value = false;
    }
  }
  function he(Ie, Se) {
    Ho(Ie) > 10 && (Se.unitPrice = Be(Ie, 10), Ie = Se.unitPrice), Se.amount = A(Ie) ? Be(Ie * Se.mete, 2) : void 0;
  }
  function be(Ie, Se) {
    Se.unitPrice = A(Ie) ? Be(Ie / Se.mete, 10) : void 0;
  }
  const me = Z(1), ge = Z(20), Le = Ee(() => (g.list || []).slice((me.value - 1) * ge.value, me.value * ge.value));
  return (Ie, Se) => {
    const X = wi, $ = Ve("common-button"), k = pa, J = La, z = qa, F = Ga, G = Ml, ie = Ve("common-input-number"), ue = vt, ne = Ve("common-table"), te = Mt, de = Ve("common-drawer"), pe = oi;
    return w(), U(de, { ref_key: "drawerRef", ref: y, "before-close": l(M).cancelDetail, "content-loading": l(M).detailLoading, "show-close": true, title: Y.value, visible: l(M).detailVisible, "custom-class": "raw-mat-inbound-application-review-detail", size: "100%" }, { titleAfter: p(() => {
      var re;
      return [s(X, null, { default: p(() => [Te(K(l(A)(l(g).purchaseOrder) ? "自购" : "甲供"), 1)]), _: 1 }), s(C_, { detail: l(g), order: R.value }, null, 8, ["detail", "order"]), s(X, { type: (re = l(Lt).V[l(g).reviewStatus]) == null ? void 0 : re.TAG }, { default: p(() => [Te(K(l(Lt).VL[l(g).reviewStatus]), 1)]), _: 1 }, 8, ["type"]), s(X, { effect: "plain" }, { default: p(() => [Te("入库时间：" + K(l(Qi)(l(g).createTime, "{y}-{m}-{d}")), 1)]), _: 1 })];
    }), titleRight: p(() => {
      var re;
      return [c.ApprovalFlag ? (w(), Q("div", Wle, [s(k, { title: "确认通过", onConfirm: Se[0] || (Se[0] = (we) => se(l(Lt).PASS.V)) }, { reference: p(() => [s($, { class: "filter-item", size: "default", type: "success", loading: _.value }, { default: p(() => Se[6] || (Se[6] = [Te("通过")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), s(k, { title: "确认驳回", onConfirm: Se[1] || (Se[1] = (we) => se(l(Lt).REFUSE.V)) }, { reference: p(() => [s($, { class: "filter-item", size: "default", type: "danger", loading: _.value }, { default: p(() => Se[7] || (Se[7] = [Te(" 驳回 ")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : H("", true), ((re = l(g).wmsApproveRecordFlowDTOS) == null ? void 0 : re.length) !== 0 ? (w(), U(J, { key: 1, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s($, { size: "default" }, { default: p(() => Se[8] || (Se[8] = [Te("查看审批记录")])), _: 1, __: [8] })]), default: p(() => [s(tl, { data: l(g).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), s(br, { "purchase-id": R.value.id, size: "default" }, null, 8, ["purchase-id"])];
    }), content: p(() => {
      var re, we;
      return [l(A)(l(g).purchaseOrder) ? (w(), U(F, { key: 0, column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(z, { label: "采购合同号", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke;
        return [Te(K((Ke = l(g).purchaseOrder) == null ? void 0 : Ke.serialNumber), 1)];
      }), _: 1 }), s(z, { label: "供应商", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke, Me;
        return [Te(K((Me = (Ke = l(g).purchaseOrder) == null ? void 0 : Ke.supplier) == null ? void 0 : Me.name), 1)];
      }), _: 1 }), s(z, { label: "合同额", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke;
        return [Te(K(l(Mi)((Ke = l(g).purchaseOrder) == null ? void 0 : Ke.amount, l(Ze).YUAN)), 1)];
      }), _: 1 }), s(z, { label: "累计入库额(元)", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).sumAmount), 1)]), _: 1 }), s(z, { label: "采购创建人", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke;
        return [Te(K((Ke = l(g).purchaseOrder) == null ? void 0 : Ke.applicantName), 1)];
      }), _: 1 }), s(z, { label: "办理人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).applicantName), 1)]), _: 1 }), s(z, { label: "质检人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).qualityTestingEnum ? l(g).qualityTestingEnum === l(Pl).NO.V ? "无需质检" : l(g).qualityTestingUserName : "-"), 1)]), _: 1 }), l(A)(l(g).logistics) ? (w(), Q(Qe, { key: 0 }, [R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(z, { key: 0, label: "运输费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke;
        return [Te(K((Ke = l(g).logistics) == null ? void 0 : Ke.freightInitial), 1)];
      }), _: 1 })) : H("", true), R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(z, { key: 1, label: "装车费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke;
        return [Te(K((Ke = l(g).logistics) == null ? void 0 : Ke.loadingCharge), 1)];
      }), _: 1 })) : H("", true), R.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(z, { key: 2, label: "物流费发票及税率", "label-class-name": "contractLabel" }, { default: p(() => {
        var Ke, Me, Ne;
        return [Te(K((Ke = l(g).logistics) != null && Ke.invoiceType ? l(fi).VL[(Me = l(g).logistics) == null ? void 0 : Me.invoiceType] + "【" + ((Ne = l(g).logistics) == null ? void 0 : Ne.taxRate) + "%】" : "-"), 1)];
      }), _: 1 })) : H("", true)], 64)) : H("", true), l(A)(l(g).logistics) && l(A)(l(g).logistics.freightWeight) ? (w(), U(z, { key: 1, label: "运输重量", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).logistics.freightWeight) + " " + K(l(ei).weight.unit), 1)]), _: 1 })) : H("", true), l(A)(l(g).logistics) && l(A)(l(g).logistics.supplierName) ? (w(), U(z, { key: 2, label: "物流单位", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).logistics.supplierName), 1)]), _: 1 })) : H("", true)]), _: 1 })) : (w(), U(F, { key: 1, column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(z, { label: "录入办理人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(g).applicantName), 1)]), _: 1 }), s(z, { label: "", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(f.value), 1)]), _: 1 })]), _: 1 })), (re = l(g).returnList) != null && re.length ? (w(), U(P_, { key: 2, "basic-class": l(g).basicClass, boolPartyA: O.value, list: l(g).returnList, showAmount: P.value, showTableColumnSecondary: ee.value, class: "inspection-return-info" }, null, 8, ["basic-class", "boolPartyA", "list", "showAmount", "showTableColumnSecondary"])) : H("", true), s(G, null, { default: p(() => Se[9] || (Se[9] = [C("span", { class: "title" }, "入库明细", -1)])), _: 1, __: [9] }), qe((w(), U(ne, { "cell-class-name": l(oe), data: Le.value, "data-format": E.value, "expand-row-keys": b.value, "max-height": l(m) - 180, "summary-method": B, "row-key": "id", "show-summary": "" }, { default: p(() => {
        var Ke;
        return [s(Ha, { "expand-row-keys": b.value, "onUpdate:expandRowKeys": Se[2] || (Se[2] = (Me) => b.value = Me), data: l(g).list, fixed: "left", "row-key": "id" }, { default: p(({ row: Me }) => [ee.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": l(g).basicClass, row: Me, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [Se[10] || (Se[10] = Te(" 备注：")), C("span", null, K(Me.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(g).basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(za, { "basic-class": l(g).basicClass }, null, 8, ["basic-class"]), ee.value ? (w(), U(Ba, { key: 0, "basic-class": l(g).basicClass }, null, 8, ["basic-class"])) : H("", true), P.value && !O.value ? (w(), Q(Qe, { key: 1 }, [l(Ae)((Ke = l(g).purchaseOrder) == null ? void 0 : Ke.details) && N.value && l(g).editMoney ? (w(), Q(Qe, { key: 0 }, [s(ue, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, { default: p(({ row: { sourceRow: Me } }) => [Me && c.ApprovalFlag ? (w(), U(ie, { key: 0, modelValue: Me.unitPrice, "onUpdate:modelValue": (Ne) => Me.unitPrice = Ne, controls: false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (Ne) => he(Ne, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (w(), Q("span", jle, K(Me.unitPrice || "-"), 1))]), _: 1 }), s(ue, { align: "center", label: "金额", prop: "amount", width: "135px" }, { default: p(({ row: { sourceRow: Me } }) => [Me && c.ApprovalFlag ? (w(), U(ie, { key: 0, modelValue: Me.amount, "onUpdate:modelValue": (Ne) => Me.amount = Ne, controls: false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "金额", size: "default", onChange: (Ne) => be(Ne, Me) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (w(), Q("span", Fle, K(Me.amount || "-"), 1))]), _: 1 })], 64)) : (w(), U(dc, { key: 1, showFreight: v.value }, null, 8, ["showFreight"]))], 64)) : H("", true), s(ue, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), x.value ? (w(), U(ue, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (w(), U(xl, { key: 2 }))];
      }), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"])), [[pe, l(M).loading]]), s(mc, { total: (we = l(g).list) == null ? void 0 : we.length, "size-change": ge.value, "onUpdate:sizeChange": Se[3] || (Se[3] = (Ke) => ge.value = Ke), "page-change": me.value, "onUpdate:pageChange": Se[4] || (Se[4] = (Ke) => me.value = Ke) }, null, 8, ["total", "size-change", "page-change"]), c.ApprovalFlag ? (w(), Q(Qe, { key: 3 }, [I.value && l(g).editMoney ? (w(), U(cd, { key: 0, ref_key: "logisticsRef", ref: T, disabled: Ie.formDisabled, form: l(g).logistics, showType: "audit", class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : H("", true), s(te, { modelValue: h.value, "onUpdate:modelValue": Se[5] || (Se[5] = (Ke) => h.value = Ke), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])], 64)) : H("", true)];
    }), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, u4 = ut(zle, [["__scopeId", "data-v-a9198200"]]), Ble = Object.freeze(Object.defineProperty({ __proto__: null, default: u4 }, Symbol.toStringTag, { value: "Module" }));
function Hle(e) {
  return W({ url: "/api/v2/wms/inbound/application/partyASteel", method: "post", data: e });
}
function qle(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/partyASteel", n = "post"), W({ url: o, method: n, data: e });
}
function Gle(e) {
  return W({ url: "/api/v2/wms/inbound/application/partyA/auxiliary-material", method: "post", data: e });
}
function Qle(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/partyA/auxiliary-material", n = "post"), W({ url: o, method: n, data: e });
}
function Zle(e) {
  return W({ url: "/api/v2/wms/inbound/application/partyA/other-material", method: "post", data: e });
}
function Jle(e) {
  let o = "", n = "";
  return e != null && e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/partyA/other-material", n = "post"), W({ url: o, method: n, data: e });
}
function Xle(e) {
  return W({ url: "/api/v2/wms/inbound/application/partyA/gas", method: "post", data: e });
}
function $le(e) {
  let o = "", n = "";
  return e.id ? (o = "/api/v2/wms/inbound/application/record/raw-materials", n = "put") : (o = "/api/wms/begin/inbound/application/partyA/gas", n = "post"), W({ url: o, method: n, data: e });
}
function bd(e) {
  return e.boolPartyA = true, W({ url: "/api/v2/wms/report/raw-materials/inbound/template/excel", method: "get", responseType: "blob", timeout: 6e7, params: e });
}
const c4 = { __name: "manufactured", props: { list: { type: Array, default: () => [] }, maxHeight: { type: Number } }, setup(e) {
  const o = Z([["destination", ["parse-enum", Bt]], ["pricingMethod", ["parse-enum", Ca]]]);
  function n(c) {
    return Hi(c, { props: ["amount", "mete"], toThousandFields: ["amount", "mete"] });
  }
  return (c, u) => {
    const r = vt, E = Ve("common-table");
    return w(), U(E, { ref: "tableRef", data: e.list, "show-summary": false, "summary-method": n, "data-format": o.value, "max-height": e.maxHeight, "highlight-current-row": "", "row-key": "id" }, { default: p(() => [s(r, { label: "序号", type: "index", align: "center", width: "60" }), s(r, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), s(r, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), s(r, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(r, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(r, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), s(r, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), s(r, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), s(r, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), s(r, { label: "总重(kg)", align: "center", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: y } }) => [C("span", null, K(l(Be)(y.quantity * y.netWeight, 2)), 1)]), _: 1 }), s(r, { prop: "pricingMethod", label: "计价方式", align: "center", "show-overflow-tooltip": "" }), s(v_, { showAmountExcludingVAT: false, showInputVAT: false }), s(r, { prop: "destination", label: "目的地", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]);
  };
} }, eoe = Object.freeze(Object.defineProperty({ __proto__: null, default: c4 }, Symbol.toStringTag, { value: "Module" })), Mm = { __name: "raw-material", props: { list: { type: Array, default: () => [] }, maxHeight: { type: Number }, materialType: { type: Number }, boolUseRequisitions: { type: Boolean, default: false } }, setup(e) {
  const o = [["weightMeasurementMode", ["parse-enum", Wt]]];
  function n(c) {
    return Hi(c, { props: ["amount", "mete"], toThousandFields: ["amount", "mete"] });
  }
  return (c, u) => {
    const r = vt, E = Ve("common-table");
    return w(), U(E, { ref: "tableRef", data: e.list, "max-height": e.maxHeight, "show-summary": false, "summary-method": n, "data-format": o, "default-expand-all": false, "highlight-current-row": "", "row-key": "id" }, { default: p(() => [s(r, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e.boolUseRequisitions ? (w(), U(r, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : H("", true), s(fa, { "spec-merge": "", fixed: "left", "show-index": false }), s(Ba, { fixed: "left" }), s(za), s(v_, { showAmountExcludingVAT: false, showInputVAT: false }), e.materialType !== l(va).MATERIAL.V ? (w(), U(r, { key: 1, prop: "weightMeasurementMode", label: "计量方式", align: "center", "show-overflow-tooltip": "" })) : H("", true)]), _: 1 }, 8, ["data", "max-height"]);
  };
} }, toe = Object.freeze(Object.defineProperty({ __proto__: null, default: Mm }, Symbol.toStringTag, { value: "Module" })), d4 = { __name: "index", props: { materialType: { type: Number }, list: { type: Array, default: () => [] }, maxHeight: { type: Number }, boolUseRequisitions: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.materialType) {
      case va.MANUFACTURED.V:
        return c4;
      case va.STEEL.V:
      case va.MATERIAL.V:
        return Mm;
      default:
        return Mm;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { list: e.list, maxHeight: e.maxHeight, materialType: e.materialType, "bool-use-requisitions": e.boolUseRequisitions }, null, 8, ["list", "maxHeight", "materialType", "bool-use-requisitions"]));
} }, ioe = Object.freeze(Object.defineProperty({ __proto__: null, default: d4 }, Symbol.toStringTag, { value: "Module" }));
const aoe = { key: 0 }, loe = { class: "main-content" }, ooe = { class: "flex-rss child-mr-10" }, noe = { key: 0 }, soe = { key: 0 }, roe = { key: 0 }, uoe = { key: 0 }, coe = { style: { "word-break": "break-all" } }, doe = { class: "pre-wrap" }, moe = { class: "form-right" }, poe = { class: "right-head flex-rbs" }, hoe = { class: "right-head-content" }, foe = { class: "label" }, goe = { class: "table-remark" }, Eoe = { class: "con" }, yoe = { class: "con" }, Toe = { __name: "index", setup(e) {
  const { CRUD: o, crud: n, detail: c } = qi(), { maxHeight: u, heightStyle: r } = Kt({ mainBox: ".purchase-order-raw-mat-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, () => n.detailVisible), E = Ee(() => A(c) && c.serialNumber ? `订单：${c.serialNumber}` : "订单"), y = Ee(() => c.purchaseStatus === wo.FINISHED.V), b = Ee(() => c.settlementStatus === sn.SETTLED.V), V = Ee(() => {
    var M;
    return !!((M = c.applyPurchase) != null && M.length);
  });
  return o.HOOK.beforeDetailLoaded = async (M, g) => {
    var h;
    await Qt(g.details), await Ut(g.details, { toNum: true });
    const S = {};
    if ((h = g.applyPurchase) != null && h.length) for (const T of g.applyPurchase) S[T.id] = T;
    g.details.forEach((T) => {
      var _;
      T.purchaseSN = (_ = S == null ? void 0 : S[T.applyPurchaseId]) == null ? void 0 : _.serialNumber;
    });
  }, (M, g) => {
    const S = wi, h = Zi, T = Ml, _ = Li, f = Ve("common-drawer"), m = _t("parse-enum"), R = _t("empty-text"), v = _t("parse-time");
    return w(), U(f, { ref: "drawerRef", visible: l(n).detailVisible, "content-loading": l(n).detailLoading, "before-close": l(n).cancelDetail, title: E.value, "show-close": true, size: l(A)(l(c).details) ? "100%" : "620px", "custom-class": "purchase-order-raw-mat-detail" }, Zl({ content: p(() => [C("div", loe, [l(A)(l(c)) ? (w(), U(_, { key: 0, model: l(c), size: "default", "label-position": "left", "label-width": "100px" }, { default: p(() => [C("div", { class: "form-content", style: ri(l(r)) }, [C("div", { class: "form-left", style: ri(`width:${l(A)(l(c).details) ? "450px" : "100%"}`) }, [s(h, { label: "物料种类", prop: "basicClass" }, { default: p(() => [C("div", ooe, [l(c).materialType & l(va).MATERIAL.V ? H("", true) : qe((w(), Q("span", noe, null, 512)), [[m, { e: l(va), v: l(c).materialType, extra: "：" }]]), qe(C("span", null, null, 512), [[m, { e: l(Ge), v: l(c).basicClass, bit: true, split: " | " }]])])]), _: 1 }), s(h, { label: "合同量", prop: "mete" }, { default: p(() => [C("span", null, K(l(c).mete) + " " + K(l(c).meteUnit), 1)]), _: 1 }), s(h, { label: "合同额", prop: "amount" }, { default: p(() => [C("span", null, K(l(c).amount) + " 元", 1), g[2] || (g[2] = Te(" 【")), qe(C("span", null, null, 512), [[m, { e: l(fi), v: l(c).invoiceType }]]), l(c).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", soe, "（" + K(l(c).taxRate) + "%）", 1)) : H("", true), g[3] || (g[3] = Te("】 "))]), _: 1, __: [2, 3] }), s(h, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: p(() => [qe(C("span", null, null, 512), [[m, { e: l(Jl), v: l(c).purchaseOrderPaymentMode }]])]), _: 1 }), l(Ae)(l(c).details) ? (w(), U(h, { key: 0, prop: "weightMeasurementMode", label: "计量方式" }, { default: p(() => [qe(C("span", null, null, 512), [[m, { e: l(Wt), v: l(c).weightMeasurementMode }]])]), _: 1 })) : H("", true), s(h, { label: "物流信息", prop: "logistics" }, { default: p(() => [qe(C("span", null, null, 512), [[m, { e: l(Xa), v: l(c).logisticsTransportType }]]), g[4] || (g[4] = Te(" （费用")), qe(C("span", null, null, 512), [[m, { e: l(Bi), v: l(c).logisticsPayerType }]]), g[5] || (g[5] = Te("） "))]), _: 1, __: [4, 5] }), s(h, { label: "供应商", prop: "supplier" }, { default: p(() => [l(c).supplier ? (w(), Q("span", roe, K(l(c).supplier.name), 1)) : H("", true)]), _: 1 }), s(h, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: p(() => [l(c).branchCompany ? (w(), Q("span", uoe, K(l(c).branchCompany.name), 1)) : H("", true)]), _: 1 }), s(h, { label: "创建人", prop: "applicantName" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).applicantName), 1)])), [[R]]), g[6] || (g[6] = Te(" （创建时间：")), qe(C("span", null, null, 512), [[v, l(c).createTime]]), g[7] || (g[7] = Te("） "))]), _: 1, __: [6, 7] }), s(h, { label: "最后操作人", prop: "lastOperatorName" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).lastOperatorName), 1)])), [[R]]), g[8] || (g[8] = Te(" （操作时间：")), qe(C("span", null, null, 512), [[v, l(c).userUpdateTime]]), g[9] || (g[9] = Te("） "))]), _: 1, __: [8, 9] }), s(h, { label: "备注", prop: "remark", style: { width: "100%" } }, { default: p(() => [C("span", coe, K(l(c).remark), 1)]), _: 1 }), s(h, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: p(() => [C("span", doe, K(l(c).projects ? l(c).projects.map((N) => l(di)(N, null, false)).join(`
`) : ""), 1)]), _: 1 }), s(T, null, { default: p(() => g[10] || (g[10] = [C("span", { class: "title" }, "附件", -1)])), _: 1, __: [10] }), s(dl, { "show-download": "", "file-classify": l(cl).PURCHASE_ORDER_ATT.V, files: l(c).attachments, "onUpdate:files": g[0] || (g[0] = (N) => l(c).attachments = N), uploadable: false, "empty-text": "暂未上传采购合同附件" }, null, 8, ["file-classify", "files"])], 4), l(A)(l(c).details) ? (w(), Q(Qe, { key: 0 }, [g[13] || (g[13] = C("div", { class: "vertical-dashed-divider" }, null, -1)), C("div", moe, [C("div", poe, [C("span", hoe, [C("span", foe, K(V.value ? "关联申购单号" : "采购清单"), 1), (w(true), Q(Qe, null, ki(l(c).applyPurchase, (N) => (w(), U(S, { key: N.id, effect: "plain", class: "preparation-sn-tag" }, { default: p(() => [Te(K(N.serialNumber), 1)]), _: 2 }, 1024))), 128))])]), s(d4, { "material-type": l(c).materialType, list: l(c).details, "max-height": l(u) - 150, "bool-use-requisitions": V.value }, null, 8, ["material-type", "list", "max-height", "bool-use-requisitions"]), C("div", goe, [g[11] || (g[11] = C("span", { class: "title" }, "合同量", -1)), C("span", Eoe, K(l(c).mete) + " " + K(l(c).meteUnit), 1), g[12] || (g[12] = C("span", { class: "title" }, "合同额", -1)), C("span", yoe, K(l(c).amount) + " 元", 1)])])], 64)) : H("", true)], 4)]), _: 1 }, 8, ["model"])) : H("", true)])]), _: 2 }, [l(A)(l(c)) ? { name: "titleAfter", fn: p(() => [l(c).boolPartyA ? (w(), U(S, { key: 0, type: "danger", effect: "dark", size: "default" }, { default: p(() => g[1] || (g[1] = [Te("甲供")])), _: 1, __: [1] })) : H("", true), s(S, { type: y.value ? "success" : l(c).boolUsed ? "warning" : "info", effect: y.value ? "dark" : "plain", size: "default" }, { default: p(() => [qe(C("span", null, null, 512), [[m, { e: l(wo), v: l(c).purchaseStatus }]]), l(c).boolUsed && l(c).purchaseStatus === l(wo).UNFINISHED.V ? (w(), Q("span", aoe, " (有入库)")) : H("", true)]), _: 1 }, 8, ["type", "effect"]), qe(s(S, { type: b.value ? "success" : "info", effect: b.value ? "dark" : "plain", size: "default" }, null, 8, ["type", "effect"]), [[m, { e: l(sn), v: l(c).settlementStatus }]])]), key: "0" } : void 0]), 1032, ["visible", "content-loading", "before-close", "title", "size"]);
  };
} }, m4 = ut(Toe, [["__scopeId", "data-v-5b372665"]]), _oe = Object.freeze(Object.defineProperty({ __proto__: null, default: m4 }, Symbol.toStringTag, { value: "Module" }));
const boe = { class: "customize-option-item" }, Voe = { class: "flex-rsc label" }, woe = { class: "extra-label" }, Soe = { key: 0, class: "extra-label" }, voe = { class: "more-text-info ellipsis-text" }, Roe = { key: 1, class: "extra-label" }, Moe = { class: "more-text-info ellipsis-text" }, Aoe = { __name: "index", props: { modelValue: { type: [Array, Number, String] }, info: { type: Object }, reload: { type: Boolean, default: true }, detailable: { type: Boolean, default: true }, basicClass: { type: Number }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, onlyOneDefault: { type: Boolean, default: false }, placeholder: { type: String, default: "选择采购合同编号" } }, emits: ["change", "info-change", "update:modelValue", "update:info"], setup(e, { emit: o }) {
  const n = o, c = e, u = Ee(() => ({ value: "id", label: "serialNumber", key: "id" })), r = Z(), E = Z({}), { loaded: y, purchaseOrder: b } = zS(_, c.reload), V = Ee(() => {
    let m = At(b.value);
    return c.basicClass && (m = m.filter((R) => R.basicClass & c.basicClass), m = m.map((R) => (R.projectNames = R.projects ? R.projects.map((v) => v.shortName).join("、") : "", R))), m;
  }), { detailRef: M, openDetail: g } = hl();
  Ce(() => c.modelValue, (m) => {
    r.value = m, f();
  }, { immediate: true });
  function S(m) {
    m && g(m);
  }
  function h(m) {
    let R = m;
    Ae(R) && (R = void 0);
    const v = !el(R, c.modelValue), N = Ae(R) && Ae(c.modelValue);
    v && !N && (n("update:modelValue", R), n("change", R, c.modelValue), T(R, c.modelValue));
  }
  function T(m, R) {
    const v = m ? E.value[m] : null, N = R ? E.value[R] : null;
    n("update:info", v), n("info-change", v, N);
  }
  function _() {
    E.value = {}, A(V.value) && V.value.forEach((m) => {
      E.value[m.id] = m;
    }), A(r.value) ? T(r.value) : f();
  }
  function f() {
    if (!(Ae(V.value) || r.value)) {
      if (c.onlyOneDefault && V.value.length === 1) {
        r.value = V.value[0].value, h(r.value);
        return;
      }
      if (c.default) {
        r.value = V.value[0].value, h(r.value);
        return;
      }
      Ae(r.value) && A(c.info) && T();
    }
  }
  return (m, R) => {
    const v = _c, N = ml, P = jt, L = Ve("common-select"), O = _t("permission"), x = _t("parse-enum");
    return w(), Q("span", { class: Zt(["purchase-sn-select-container", { "show-detail-icon": c.detailable && l(Ai)(l(tn)) }]) }, [s(L, { modelValue: r.value, "onUpdate:modelValue": R[0] || (R[0] = (I) => r.value = I), size: e.size, disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !l(y), clearable: e.clearable, filterable: "", placeholder: e.placeholder, options: V.value, "data-structure": u.value, class: "purchase-sn-select", onChange: h }, { view: p(({ data: I }) => [C("span", boe, [C("span", Voe, [s(P, { content: "点击可查看详情", placement: "left", "show-after": 1e3 }, { default: p(() => [c.detailable ? qe((w(), U(N, { key: 0, onClick: Pi((Y) => S(I.id), ["stop"]), class: "pointer", color: "#1881ef" }, { default: p(() => [s(v)]), _: 2 }, 1032, ["onClick"])), [[O, l(tn)]]) : H("", true)]), _: 2 }, 1024), C("span", null, K(I.serialNumber), 1)]), C("span", null, [C("span", woe, [R[2] || (R[2] = C("span", { class: "title" }, "类型：", -1)), qe(C("span", null, null, 512), [[x, { e: l(Ge), v: I.basicClass, bit: true, split: " | " }]])]), I.supplier ? (w(), Q("span", Soe, [R[3] || (R[3] = C("span", { class: "title" }, "供应商：", -1)), C("span", voe, K(I.supplier.name), 1)])) : H("", true), I.projectNames ? (w(), Q("span", Roe, [R[4] || (R[4] = C("span", { class: "title" }, "项目：", -1)), C("span", Moe, K(I.projectNames), 1)])) : H("", true)])])]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "placeholder", "options", "data-structure"]), c.detailable ? qe((w(), Q("span", { key: 0, class: Zt(["detail-icon pointer", { "not-allowed": !r.value }]), onClick: R[1] || (R[1] = Pi((I) => S(r.value), ["stop"])) }, [s(N, { color: r.value ? "#1881ef" : "#c1c2c5" }, { default: p(() => [s(v)]), _: 1 }, 8, ["color"])], 2)), [[O, l(tn)]]) : H("", true), s(ol, { ref_key: "purchaseOrderRef", ref: M, api: l(U1) }, { default: p(() => [s(m4)]), _: 1 }, 8, ["api"])], 2);
  };
} }, Noe = ut(Aoe, [["__scopeId", "data-v-006f2737"]]), Loe = { key: 0, style: { display: "inline-block", "margin-left": "6px" } }, p4 = { __name: "STORE.operation", props: { type: { type: String, default: "crud" }, isBegin: { type: Boolean, default: false } }, emits: ["clear"], setup(e, { emit: o }) {
  const n = o, c = e;
  let u;
  switch (c.type) {
    case "crud":
      u = "fmStore";
      break;
    case "crudBatch":
      u = "bfmStore";
      break;
    case "cu":
      u = "cuFmStore";
      break;
    case "normal":
      u = "nfmStore";
      break;
    default:
      u = "fmStore";
      break;
  }
  const r = ft(u);
  function E() {
    r.saveStoreForm() && ot.success("已存为草稿");
  }
  function y() {
    r.resetForm(), n("clear");
  }
  return (b, V) => {
    const M = Ve("common-button");
    return l(r) ? (w(), Q("span", Loe, [c.isBegin ? H("", true) : (w(), U(M, { key: 0, plain: "", size: "default", type: "warning", onClick: E }, { default: p(() => V[0] || (V[0] = [Te("存为草稿")])), _: 1, __: [0] })), s(M, { plain: "", size: "default", type: "info", onClick: y }, { default: p(() => V[1] || (V[1] = [Te("清空")])), _: 1, __: [1] })])) : H("", true);
  };
} }, { handleMeteChangeCalcPrice: Ioe } = ma("weighingTotalWeight"), Wr = vi[Ge.STEEL_PLATE.V], h4 = { title: "钢板入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Wr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Wr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Wr.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: Wr.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Wr.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "备注", field: "remark", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, h4.rules)) return;
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
      h.steelDensity = m, h.theoryWeight = await na({ classifyId: h.classifyId, name: h.classifyFullName, length: h.length, width: h.width, thickness: h.thickness }), A(h.theoryWeight) && h.quantity ? h.theoryTotalWeight = Be(h.theoryWeight * h.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : h.theoryTotalWeight = void 0, h.weighingTotalWeight = h.weighingTotalWeight || h.theoryTotalWeight, (!h.unitPrice || !h.amount) && Ioe(h);
    } else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系管理员/仓库人员添加`);
  }
  return E;
} }, { handleMeteChangeCalcPrice: Coe } = ma("weighingTotalWeight"), zd = vi[Ge.SECTION_STEEL.V], f4 = { title: "型材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "材质", field: "material", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: zd.length.precision, excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", precision: zd.measure.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: zd.weight.precision, excelField: "__EMPTY_5" }, { label: "品牌", field: "brand", excelField: "__EMPTY_6" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_7" }, { label: "备注", field: "remark", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "型材规格不能为空" }] }, format: async (e) => {
  var g, S;
  if (!gi(e, f4.rules)) return;
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
      h.sectionSteelSpec = R, h.doNotSectionSteelSpec = v.join(" * "), h.theoryWeight = await xa({ length: h.length, unitWeight: h.unitWeight }), A(h.theoryWeight) && h.quantity ? h.theoryTotalWeight = Be(h.theoryWeight * h.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : h.theoryTotalWeight = void 0, h.weighingTotalWeight = h.weighingTotalWeight || h.theoryTotalWeight, Poe(h), (!h.unitPrice || !h.amount) && Coe(h);
    } else throw new Error(`${h.classifyName}下不存在规格为“${f}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
function Poe(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: Ooe } = ma("weighingTotalWeight"), Ku = vi[Ge.STEEL_COIL.V], g4 = { title: "钢卷入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Ku.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Ku.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Ku.length.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Ku.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "备注", field: "remark", excelField: "__EMPTY_9" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var g;
  if (!gi(e, g4.rules)) return;
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const c = _e.state.config.rawMatClsList.filter((S) => S.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
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
      S.steelDensity = f, await koe(S), S.length = S.length || S.theoryLength, (!S.unitPrice || !S.amount) && Ooe(S);
    } else throw new Error(`${S.classifyName}下不存在规格为“${_}”的材料，请联系管理员/仓库人员添加`);
  }
  return r;
} };
async function koe(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const { handleMeteChangeCalcPrice: Doe } = ma("mete"), Am = { title: "辅材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "备注", field: "remark", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, Am.rules)) return;
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
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0), (!g.unitPrice || !g.amount) && Doe(g);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, E4 = { title: "其它入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "备注", field: "remark", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, E4.rules)) return;
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
} }, y4 = { title: "气体入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "品牌", field: "brand", excelField: "__EMPTY_6" }, { label: "备注", field: "remark", excelField: "__EMPTY_7" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, y4.rules)) return;
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
} }, { handleMeteChangeCalcPrice: xoe } = ma("mete"), T4 = { title: "其它钢材入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "备注", field: "remark", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var M;
  if (!gi(e, T4.rules)) return;
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
    if (h) g.uid = Tt(), g.sn = h.sn, g.specificationLabels = h.specificationLabels, g.serialNumber = h.serialNumber, g.classifySerialNumber = h.classify.serialNumber, g.classifyId = h.classify.id, g.classifyFullPathId = h.classify.fullPathId, g.classifyFullName = h.classify.fullName, g.classifyName = h.classify.name, g.classifyParentFullName = h.classify.parentFullName, g.basicClass = h.classify.basicClass, g.specification = h.spec, g.specificationMap = h.specKV, g.measureUnit = h.classify.measureUnit, g.accountingUnit = h.classify.accountingUnit, g.accountingPrecision = h.classify.accountingPrecision, g.measurePrecision = h.classify.measurePrecision, g.measureUnit || (g.quantity = void 0), g.quantity && (g.quantity = Be(g.quantity, g.measurePrecision)), g.mete && (g.mete = Be(g.mete, g.accountingPrecision)), g.measureUnit || (g.quantity = void 0), (!g.unitPrice || !g.amount) && xoe(g);
    else throw new Error(`${g.classifyName}下不存在规格为“${T}”的材料，请联系管理员/仓库人员添加`);
  }
  return u;
} }, { handleMeteChangeCalcPrice: Uoe } = ma("weighingTotalWeight"), jr = vi[Ge.STEEL_PLATE.V];
function Yoe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供钢板期初入库清单-错误清单", sheetName: "错误清单" });
}
const _4 = { title: "钢板期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: jr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: jr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: jr.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: jr.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: jr.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], length: [{ required: true, message: "长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }] }, format: async (e) => {
  var R;
  if (!gi(e, _4.rules)) return;
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg, c = await _a();
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
      for (const x in n) Number(x) === v.classifyId && (O = n[x]);
      v.steelDensity = O, v.theoryWeight = await na({ classifyId: v.classifyId, name: v.classifyFullName, length: v.length, width: v.width, thickness: v.thickness }), A(v.theoryWeight) && v.quantity ? v.theoryTotalWeight = Be(v.theoryWeight * v.quantity, c[Ge.STEEL_PLATE.V].weight.precision) : v.theoryTotalWeight = void 0, v.weighingTotalWeight = v.weighingTotalWeight || v.theoryTotalWeight, (!v.unitPrice || !v.amount) && Uoe(v);
    } else {
      const O = `${v.classifyName}下不存在规格为"${L}"的材料，请联系管理员/仓库人员添加`;
      g.some((x) => x.error === O) || g.push({ rowIndex: E.indexOf(v) + 1, error: O });
    }
  }
  if (g.length > 0) Yoe(g);
  else return E;
} }, { handleMeteChangeCalcPrice: Koe } = ma("weighingTotalWeight"), Bd = vi[Ge.SECTION_STEEL.V];
function Woe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供型材期初入库清单-错误清单", sheetName: "错误清单" });
}
const b4 = { title: "型材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "规格", field: "specification", excelField: "__EMPTY_2" }, { label: "型材库标准", field: "profileLibraryStandard", excelField: "__EMPTY_3" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Bd.length.precision, excelField: "__EMPTY_4" }, { label: "数量（根）", field: "quantity", type: "number", precision: Bd.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Bd.weight.precision, excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "炉批号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }, { label: "整料/余料", field: "materialIsWholeName", excelField: "__EMPTY_12" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], specification: [{ required: true, message: "规格不能为空" }], profileLibraryStandard: [{ required: true, message: "型材库标准不能为空" }], length: [{ required: true, message: "定尺长度不能为空" }], quantity: [{ required: true, message: "数量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }], materialIsWholeName: [{ required: true, message: "整料/余料不能为空" }, { validator: (e, o) => ["整料", "余料"].includes(e), message: "请正确填写【整料/余料】" }] }, format: async (e) => {
  var m, R;
  if (!gi(e, b4.rules)) return;
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
      v.sectionSteelSpec = x, v.doNotSectionSteelSpec = I.join(" * "), v.theoryWeight = await xa({ length: v.length, unitWeight: v.unitWeight }), A(v.theoryWeight) && v.quantity ? v.theoryTotalWeight = Be(v.theoryWeight * v.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : v.theoryTotalWeight = void 0, v.weighingTotalWeight = v.weighingTotalWeight || v.theoryTotalWeight, joe(v), (!v.unitPrice || !v.amount) && Koe(v);
    } else {
      const O = `${v.classifyName}下不存在规格为"${L}"的材料，请联系管理员/仓库人员添加`;
      M.some((x) => x.error === O) || M.push({ rowIndex: r.indexOf(v) + 1, error: O });
    }
  }
  if (M.length > 0) Woe(M);
  else return r;
} };
function joe(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
const { handleMeteChangeCalcPrice: Foe } = ma("weighingTotalWeight"), Wu = vi[Ge.STEEL_COIL.V];
function zoe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供钢卷期初入库清单-错误清单", sheetName: "错误清单" });
}
const V4 = { title: "钢卷期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Wu.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Wu.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Wu.length.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Wu.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "卷号", field: "heatNoAndBatchNo", excelField: "__EMPTY_8" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_9" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_10" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_11" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], thickness: [{ required: true, message: "厚度不能为空" }], width: [{ required: true, message: "宽度不能为空" }], weighingTotalWeight: [{ required: true, message: "总重不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var m;
  if (!gi(e, V4.rules)) return;
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
      R.steelDensity = L, await Boe(R), R.length = R.length || R.theoryLength, (!R.unitPrice || !R.amount) && Foe(R);
    } else {
      const L = `${R.classifyName}下不存在规格为"${P}"的材料，请联系管理员/仓库人员添加`;
      M.some((O) => O.error === L) || M.push({ rowIndex: r.indexOf(R) + 1, error: L });
    }
  }
  if (M.length > 0) zoe(M);
  else return r;
} };
async function Boe(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
const { handleMeteChangeCalcPrice: Hoe } = ma("mete");
function w4(e, o) {
  if (!Array.isArray(e) || !Array.isArray(o) || e.length !== o.length) return false;
  for (let n = 0; n < e.length; n++) {
    const c = e[n], u = o[n];
    if (Array.isArray(c) && Array.isArray(u)) {
      if (!w4(c, u)) return false;
    } else if (typeof c == "string" && typeof u == "string") {
      if (Bb(c) !== Bb(u)) return false;
    } else if (c !== u) return false;
  }
  return true;
}
function Bb(e) {
  return e.trim().replace(/[（）()]/g, "").replace(/\s+/g, "");
}
function qoe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供辅材期初入库清单-错误清单", sheetName: "错误清单" });
}
const S4 = { title: "辅材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, S4.rules)) return;
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
    } else for (const L of n) if (L.fullPathName.length >= N.length && w4(L.fullPathName.slice(-N.length), N)) {
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
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0), (!m.unitPrice || !m.amount) && Hoe(m);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) qoe(V);
  else return u;
} };
function Goe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供办公用品期初入库清单-错误清单", sheetName: "错误清单" });
}
const v4 = { title: "办公用品期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, v4.rules)) return;
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
  if (V.length > 0) Goe(V);
  else return u;
} };
function Qoe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供气体期初入库清单-错误清单", sheetName: "错误清单" });
}
const R4 = { title: "气体期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, R4.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Pe.GAS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
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
    const P = Pe.GAS.V;
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
        v = P, m.measureUnit && m.measureUnit !== "-" && (v.classify.measureUnit || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}不存在计量单位` }), await ti(v.classify.measureUnit, m.measureUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` })), m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) Qoe(V);
  else return u;
} }, { handleMeteChangeCalcPrice: Zoe } = ma("mete");
function Joe(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单" }), pl({ headers: n, data: c, filename: "甲供其他钢材期初入库清单-错误清单", sheetName: "错误清单" });
}
const M4 = { title: "其它钢材期初入库清单", dlgWidth: "1500px", startRow: 2, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "品牌", field: "brand", excelField: "__EMPTY_7" }, { label: "所属项目合同编号", field: "projectSerialNumber", excelField: "__EMPTY_8" }, { label: "仓库", field: "workshopName", excelField: "__EMPTY_9" }, { label: "存储位置", field: "warehouseName", excelField: "__EMPTY_10" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], accountingUnit: [{ required: true, message: "核算单位不能为空" }], mete: [{ required: true, message: "核算量不能为空" }], projectSerialNumber: [{ required: true, message: "项目合同编号不能为空" }], workshopName: [{ required: true, message: "仓库不能为空" }], warehouseName: [{ required: true, message: "存储位置不能为空" }] }, format: async (e) => {
  var f;
  if (!gi(e, M4.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((m) => m.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
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
    const P = Pe.OTHER_STEEL_MATERIALS.V;
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
        v = P, m.measureUnit && (v.classify.measureUnit || V.push({ rowIndex: u.indexOf(m) + 1 }), await ti(v.classify.measureUnit, m.measureUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的计量单位错误，单位应为：“${v.classify.measureUnit}”` })), m.accountingUnit && (await ti(v.classify.accountingUnit, m.accountingUnit) || V.push({ rowIndex: u.indexOf(m) + 1, error: `${m.classifyName}填写的核算单位错误，单位应为：“${v.classify.accountingUnit}”` }));
        break;
      }
    }
    if (v) m.uid = Tt(), m.sn = v.sn, m.specificationLabels = v.specificationLabels, m.serialNumber = v.serialNumber, m.classifySerialNumber = v.classify.serialNumber, m.classifyId = v.classify.id, m.classifyFullPathId = v.classify.fullPathId, m.classifyFullName = v.classify.fullName, m.classifyName = v.classify.name, m.classifyParentFullName = v.classify.parentFullName, m.basicClass = v.classify.basicClass, m.specification = v.spec, m.specificationMap = v.specKV, m.measureUnit = v.classify.measureUnit, m.accountingUnit = v.classify.accountingUnit, m.accountingPrecision = v.classify.accountingPrecision, m.measurePrecision = v.classify.measurePrecision, m.measureUnit || (m.quantity = void 0), m.quantity && (m.quantity = Be(m.quantity, m.measurePrecision)), m.mete && (m.mete = Be(m.mete, m.accountingPrecision)), m.measureUnit || (m.quantity = void 0), (!m.unitPrice || !m.amount) && Zoe(m);
    else {
      const P = `${m.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      V.some((L) => L.error === P) || V.push({ rowIndex: u.indexOf(m) + 1, error: P });
    }
  }
  if (V.length > 0) Joe(V);
  else return u;
} };
const Xoe = { class: "inbound-application-header flex-rbc" }, $oe = { class: "child-mr-7" }, ene = { __name: "common-header", props: { purchaseId: { type: String }, basicClass: { type: Number }, validate: { type: Function }, currentBasicClass: { type: Number }, isManuf: { type: Boolean, default: false }, edit: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["update:purchaseId", "purchase-order-change"], setup(e, { expose: o, emit: n }) {
  const c = n, u = Ht(), r = e, E = jn(), { projects: y } = Er(), b = Z(false), V = ft("matSpecRef"), { cu: M, form: g, FORM: S } = Wi(), { overDiffTip: h, diffSubmitValidate: T } = c3(), _ = (oe, ye, ce) => {
    if (ye == null) {
      ce();
      return;
    }
    T(L.value.hasOver) ? ce() : ce(new Error("超出误差允许范围"));
  }, f = { purchaseId: [{ required: true, message: "请选择订单", trigger: "change" }], licensePlate: [{ pattern: uc, message: "请填写正确的车牌号", trigger: "blur" }], loadingWeight: [{ validator: _, trigger: "blur" }] }, m = { loadingWeight: [{ required: true, message: "请填写过磅重量", trigger: "blur" }, { validator: _, trigger: "blur" }] }, R = { licensePlate: [{ required: true, message: "请填写车牌号", trigger: "blur" }, { pattern: uc, message: "请填写正确的车牌号", trigger: "blur" }] }, v = Ee(() => {
    const oe = Object.assign({}, f);
    return O.value.logisticsTransportType === Xa.FREIGHT.V && O.value.logisticsPayerType === Bi.DEMAND.V && Object.assign(oe, R), r.basicClass & sl && O.value.weightMeasurementMode === Wt.OVERWEIGHT.V && Object.assign(oe, m), oe;
  }), N = Ee(() => {
    if (g.inboundWay === si.OPENING_RECEIPT.V) switch (r.currentBasicClass ?? r.basicClass) {
      case Pe.STEEL_PLATE.V:
        return _4;
      case Pe.SECTION_STEEL.V:
        return b4;
      case Pe.STEEL_COIL.V:
        return V4;
      case Pe.MATERIAL.V:
        return S4;
      case Pe.OTHER.V:
        return v4;
      case Pe.GAS.V:
        return R4;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return M4;
    }
    else switch (r.currentBasicClass ?? r.basicClass) {
      case Ge.STEEL_PLATE.V:
        return h4;
      case Ge.SECTION_STEEL.V:
        return f4;
      case Ge.STEEL_COIL.V:
        return g4;
      case Ge.MATERIAL.V:
        return Am;
      case Ge.OTHER.V:
        return E4;
      case Ge.GAS.V:
        return y4;
      case Pe.OTHER_STEEL_MATERIALS.V:
        return T4;
      default:
        return Am;
    }
  }), P = Z(), L = Z({}), O = Z({}), x = Ee(() => g.supplyType === Ni.PARTY_A.V);
  Dt(() => {
  }), S.HOOK.afterSubmit = async () => {
    Y(), pt(() => {
      P.value && P.value.resetFields();
    }), g.supplyType = Ni.PARTY_A.V, await u.dispatch("approval_list/fetchApprovalNum");
  };
  function I() {
    Y(), pt(() => {
      P.value && P.value.clearValidate();
    }), g.supplyType = Ni.PARTY_A.V;
  }
  function Y() {
    L.value = {}, O.value = {};
    const oe = Dt(() => {
      V.value && (V.value.clear(), pt(() => {
        oe();
      }));
    });
  }
  Ce(() => g.supplyType, () => {
    if (g.supplyType && g.supplyType === Ni.PARTY_A.V) {
      ee(void 0);
      const oe = { supplyType: g.supplyType, weightMeasurementMode: Wt.THEORY.V, basicClass: r.basicClass, projects: y.value };
      B(oe);
    } else ee(void 0), B(void 0);
  }, { immediate: true });
  function ee(oe) {
    pt(() => {
      var ye;
      L.value = {}, (ye = P == null ? void 0 : P.value) == null || ye.clearValidate();
    }), g.purchaseId = oe, c("update:purchaseId", oe);
  }
  async function B(oe, ye) {
    var ce;
    if (b.value = true, M.props.requisitions = {}, g.selectObj || (g.selectObj = {}), oe && (oe.requisitionsSN && q(oe.requisitionsSN), oe.logisticsTransportType === Xa.POST.V && (g.licensePlate = void 0), oe.logisticsTransportType === Xa.FREIGHT.V && (g.shipmentNumber = void 0), O.value && O.value.weightMeasurementMode !== oe.weightMeasurementMode && (g.loadingWeight = void 0), (ce = oe.applyPurchase) != null && ce.length ? (oe.boolApplyPurchase = true, oe.projects = []) : oe.boolApplyPurchase = false, oe.id)) {
      const { content: se = [] } = await yw(oe.id);
      await Qt(se), await Ut(se, { toNum: true }, { mete: ["mete", "inboundMete"], quantity: ["inboundQuantity", "quantity"] }), oe.details = se == null ? void 0 : se.map((he) => {
        var Le, Ie, Se, X, $, k, J, z, F, G, ie, ue, ne, te, de, pe, re, we;
        const be = {};
        he.mergeId = he.id, he.purchaseOrderDetailId = he.id, he.purchaseQuantity = he.quantity, he.purchaseMete = he.mete, he.boolApplyPurchase = false, he.canPurchaseQuantity = he.purchaseQuantity - he.inboundQuantity > 0 ? he.purchaseQuantity - he.inboundQuantity : 0;
        let me = false;
        (Le = g.selectObj) != null && Le[he.mergeId] ? me = (Ie = g.selectObj[he.mergeId]) == null ? void 0 : Ie.isSelected : r.edit && ((Se = g == null ? void 0 : g.editObj) != null && Se[he.mergeId]) && (me = ($ = (X = g == null ? void 0 : g.editObj) == null ? void 0 : X[he.mergeId]) == null ? void 0 : $.isSelected);
        let ge = he;
        if (me && (ge = { ...ge, ...(k = g == null ? void 0 : g.selectObj) == null ? void 0 : k[he.mergeId], ...(J = g == null ? void 0 : g.editObj) == null ? void 0 : J[he.mergeId] }), g.selectObj[he.mergeId] = { ...ge, isSelected: me }, (z = ge.applyPurchase) != null && z.length) {
          ge.boolApplyPurchase = true;
          let Ke = 0, Me = 0;
          const Ne = [];
          ge.applyPurchase.forEach((He) => {
            var ze, Oe, Re, fe, Ue, Je, Xe, Ye, Fe, et;
            if (He.applyPurchaseSN = He.serialNumber, be[He.id] = He, ge.basicClass & (Ge.SECTION_STEEL.V | Ge.STEEL_PLATE.V)) {
              const lt = r.edit ? (ze = g == null ? void 0 : g.editObj) == null ? void 0 : ze[ge.mergeId] : ge;
              He.sn = lt == null ? void 0 : lt.sn, He.specificationLabels = lt == null ? void 0 : lt.specificationLabels, He.serialNumber = lt == null ? void 0 : lt.serialNumber, He.classifyId = lt == null ? void 0 : lt.classifyId, He.classifyFullName = lt == null ? void 0 : lt.classifyFullName, He.classifyName = lt == null ? void 0 : lt.classifyName, He.classifyParentFullName = lt == null ? void 0 : lt.classifyParentFullName, He.basicClass = lt == null ? void 0 : lt.basicClass, He.specification = lt == null ? void 0 : lt.specification, He.specificationMap = lt == null ? void 0 : lt.specKV, He.measureUnit = lt == null ? void 0 : lt.measureUnit, He.accountingUnit = lt == null ? void 0 : lt.accountingUnit, He.measurePrecision = lt == null ? void 0 : lt.measurePrecision, He.accountingPrecision = lt == null ? void 0 : lt.accountingPrecision, He.unitWeight = lt == null ? void 0 : lt.unitWeight, He.length = lt == null ? void 0 : lt.length, He.width = lt == null ? void 0 : lt.width, He.thickness = lt == null ? void 0 : lt.thickness;
            }
            if (ge.basicClass & Ge.MATERIAL.V) {
              const lt = r.edit ? (Oe = g == null ? void 0 : g.editObj) == null ? void 0 : Oe[ge.mergeId] : ge;
              (Re = ge.applyPurchase) != null && Re.length && (He.measureUnit = lt == null ? void 0 : lt.measureUnit, He.accountingUnit = lt == null ? void 0 : lt.accountingUnit);
            }
            if ((!me || r.edit) && (He.applyPurchaseId = He.id, He.purchaseQuantity = He.quantity, He.purchaseMete = He.mete, He.quantity = null, He.mete = null), r.edit && ((Xe = (Je = (Ue = (fe = g == null ? void 0 : g.editObj) == null ? void 0 : fe[ge.mergeId]) == null ? void 0 : Ue.applyPurchaseObj) == null ? void 0 : Je[He.applyPurchaseId]) != null && Xe.length)) {
              const lt = (et = (Fe = (Ye = g == null ? void 0 : g.editObj) == null ? void 0 : Ye[ge.mergeId]) == null ? void 0 : Fe.applyPurchaseObj) == null ? void 0 : et[He.applyPurchaseId];
              for (let bt = 0; bt < lt.length; bt++) {
                const gt = lt[bt];
                He.unitWeight = gt == null ? void 0 : gt.unitWeight, He.length = gt == null ? void 0 : gt.length, He.width = gt == null ? void 0 : gt.width, He.thickness = gt == null ? void 0 : gt.thickness;
                const qt = gt.quantity, kt = gt.mete;
                He.quantity = qt, Me += qt, He.mete = kt, Ke += kt, He.theoryWeight = gt.theoryWeight, He.theoryTotalWeight = gt.theoryTotalWeight, He.originQuantity = He.quantity, He.originMete = He.mete, He != null && He.project && oe.projects.push(He == null ? void 0 : He.project), He.spanMerge = bt === 0 ? lt.length : 0, He.isBranch = bt > 0, Ne.push(JSON.parse(JSON.stringify(He)));
              }
            } else Me += He.quantity || 0, Ke += He.mete || 0, He.originQuantity = He.quantity, He.originMete = He.mete, He != null && He.project && oe.projects.push(He == null ? void 0 : He.project), Ne.push(JSON.parse(JSON.stringify(He)));
          }), ge.applyPurchase = Ne, ge.basicClass & Ge.MATERIAL.V && (r.edit ? (Qt(ge.applyPurchase), Ut(ge.applyPurchase, { toNum: true }, { mete: ["inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "purchaseQuantity"] })) : (Qt(ge.applyPurchase), Ut(ge.applyPurchase, { toNum: true }, { mete: ["mete", "inboundMete", "purchaseMete"], quantity: ["inboundQuantity", "quantity", "purchaseQuantity"] }))), ge.quantity = Me, ge.mete = Ke;
        } else ge.quantity = null, ge.mete = null;
        return r.edit && ((F = g == null ? void 0 : g.editObj) != null && F[ge.mergeId]) ? (ge.quantity = (ie = (G = g == null ? void 0 : g.editObj) == null ? void 0 : G[ge.mergeId]) == null ? void 0 : ie.quantity, ge.mete = (ne = (ue = g == null ? void 0 : g.editObj) == null ? void 0 : ue[ge.mergeId]) == null ? void 0 : ne.mete) : me && (ge.quantity = (de = (te = g == null ? void 0 : g.selectObj) == null ? void 0 : te[ge.mergeId]) == null ? void 0 : de.quantity, ge.mete = (re = (pe = g == null ? void 0 : g.selectObj) == null ? void 0 : pe[ge.mergeId]) == null ? void 0 : re.mete), ge.originQuantity = ge.quantity, ge.originMete = ge.mete, r.edit && (ge.needFirstCalcTheoryWeight = true), (we = he.inboundList) != null && we.length && (Qt(he.inboundList), Ut(he.inboundList, { toNum: true }), he.inboundList.forEach((Ke) => {
          var Me;
          Ke.applyPurchaseSN = (Me = be[Ke.applyPurchaseId]) == null ? void 0 : Me.applyPurchaseSN;
        })), ge;
      });
    }
    O.value = oe || {}, console.log(O.value), c("purchase-order-change", oe, ye), b.value = false;
  }
  async function q(oe) {
    if (Ae(oe)) return;
    const ye = [];
    oe.forEach((ce) => {
      const se = _w(ce).then((he) => {
        M.props.requisitions[ce] = he;
      });
      ye.push(se);
    }), await Promise.all(ye);
  }
  function ae(oe) {
    var ye;
    try {
      (ye = M == null ? void 0 : M.submitResult) != null && ye.data && (M.submitResult.data = null), M.props.import(oe), r.validate();
    } catch (ce) {
      ot.error({ message: ce.message, duration: 5e3 });
    }
  }
  function j() {
    E.push({ name: "RawMatInboundApplicationRecord", params: { basicClass: r.basicClass } });
  }
  async function le() {
    try {
      return P.value ? await P.value.validate() : false;
    } catch {
      return false;
    }
  }
  return o({ validate: le, contentLoading: b, form: g }), (oe, ye) => {
    var Ie, Se, X, $, k, J, z, F;
    const ce = Ve("common-radio-button"), se = Zi, he = Mt, be = Ve("common-input-number"), me = jt, ge = Li, Le = Ve("common-button");
    return w(), Q("div", Xoe, [C("div", null, [s(ge, { ref_key: "formRef", ref: P, model: l(g), rules: v.value, inline: "", "label-position": "right", "label-width": "80px", size: "default" }, { default: p(() => [s(se, { label: "" }, { default: p(() => [s(ce, { modelValue: l(g).inboundWay, "onUpdate:modelValue": ye[0] || (ye[0] = (G) => l(g).inboundWay = G), disabled: r.edit, options: l(si).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), x.value ? H("", true) : (w(), U(se, { key: 0, label: r.isManuf ? "订单号" : "", "label-width": r.isManuf ? "70px" : "0px", prop: "purchaseId" }, { default: p(() => [s(Noe, { modelValue: l(g).purchaseId, "onUpdate:modelValue": ye[1] || (ye[1] = (G) => l(g).purchaseId = G), "basic-class": r.basicClass, disabled: e.edit, class: "input-underline", style: { width: "300px" }, onChange: ee, onInfoChange: B }, null, 8, ["modelValue", "basic-class", "disabled"])]), _: 1 }, 8, ["label", "label-width"])), l(A)(O.value) ? (w(), Q(Qe, { key: 1 }, [O.value.logisticsTransportType === l(Xa).FREIGHT.V ? (w(), U(se, { key: 0, label: "车牌号", "label-width": "70px", prop: "licensePlate" }, { default: p(() => [s(he, { modelValue: l(g).licensePlate, "onUpdate:modelValue": ye[2] || (ye[2] = (G) => l(g).licensePlate = G), modelModifiers: { trim: true }, class: "input-underline", placeholder: "车牌号", style: { width: "125px" } }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), O.value.logisticsTransportType === l(Xa).POST.V ? (w(), U(se, { key: 1, label: "物流单号", "label-width": "70px", prop: "shipmentNumber" }, { default: p(() => [s(he, { modelValue: l(g).shipmentNumber, "onUpdate:modelValue": ye[3] || (ye[3] = (G) => l(g).shipmentNumber = G), modelModifiers: { trim: true }, class: "input-underline", maxlength: "100", placeholder: "物流单号", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), r.basicClass & l(sl) && O.value.weightMeasurementMode === l(Wt).OVERWEIGHT.V ? (w(), U(se, { key: 2, label: "车次过磅重量(t)", "label-width": "150px", prop: "loadingWeight" }, { default: p(() => [s(me, { content: `重量误差：${L.value.overNum} kg， ${l(h)}`, disabled: !L.value.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(be, { modelValue: l(g).loadingWeight, "onUpdate:modelValue": ye[4] || (ye[4] = (G) => l(g).loadingWeight = G), class: Zt([{ "over-weight-tip": L.value.hasOver }, "input-underline"]), controls: false, max: 999999999, min: 0, placeholder: "输入该车次重量", precision: 0, mode: "input", style: { width: "135px" } }, null, 8, ["modelValue", "class"])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : H("", true)], 64)) : H("", true)]), _: 1 }, 8, ["model", "rules"])]), C("div", $oe, [r.edit ? H("", true) : (w(), U(p4, { key: 0, "is-begin": l(g).inboundWay === l(si).OPENING_RECEIPT.V, type: "cu", onClear: I }, null, 8, ["is-begin"])), (x.value || l(Ae)((Ie = O.value) == null ? void 0 : Ie.details)) && l(g).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(me, { key: 1, content: l(A)((X = (Se = l(M)) == null ? void 0 : Se.submitResult) == null ? void 0 : X.data) ? "请删除全部标红数据" : "请先选择采购合同编号", disabled: !!l(g).purchaseId && l(g).supplyType === l(Ni).SELF.V && !l(A)((k = ($ = l(M)) == null ? void 0 : $.submitResult) == null ? void 0 : k.data), effect: "light", placement: "bottom" }, { default: p(() => {
      var G, ie;
      return [s(Ro, { disabled: !l(g).purchaseId && l(g).supplyType === l(Ni).SELF.V || l(A)((ie = (G = l(M)) == null ? void 0 : G.submitResult) == null ? void 0 : ie.data), template: N.value, "btn-name": "批量导入", "btn-size": "default", "btn-type": "success", icon: "el-icon-upload", "open-loading": "", onSuccess: ae }, null, 8, ["disabled", "template"])];
    }), _: 1 }, 8, ["content", "disabled"])) : H("", true), l(g).inboundWay === l(si).OPENING_RECEIPT.V && l(Ai)((J = r.permission) == null ? void 0 : J.import) && !r.edit ? (w(), U(Ro, { key: 2, disabled: l(g).inboundWay === l(si).ORDINARY_STORAGE.V ? !l(g).purchaseId && l(g).supplyType === l(Ni).SELF.V || l(Ae)(O.value) || l(A)((F = (z = l(M)) == null ? void 0 : z.submitResult) == null ? void 0 : F.data) : false, template: N.value, "btn-name": "期初批量导入", "btn-size": "default", "btn-type": "success", icon: "el-icon-upload", "open-loading": "", onSuccess: ae }, null, 8, ["disabled", "template"])) : H("", true), r.edit ? H("", true) : (w(), U(Le, { key: 3, icon: "el-icon-clock", size: "default", type: "info", onClick: j }))])]);
  };
} }, A4 = ut(ene, [["__scopeId", "data-v-a030f323"]]), tne = Object.freeze(Object.defineProperty({ __proto__: null, default: A4 }, Symbol.toStringTag, { value: "Module" }));
const ine = { class: "inbound-application-footer" }, ane = { class: "total-box" }, lne = { class: "total-item" }, one = { class: "total-item" }, nne = { class: "total-name" }, sne = { class: "total-item" }, rne = { class: "total-item" }, une = { __name: "common-footer", props: { permission: { type: Array, default: void 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "确认并提交" }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, showContractTotal: { type: Boolean, default: false }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, isSubmit: { type: Boolean, default: false } }, emits: ["submit"], setup(e, { emit: o }) {
  const n = Ht(), c = o, u = e, { cu: r, FORM: E } = Wi(), y = Z(false), b = Nc(async function() {
    if (u.isSubmit) try {
      if (Ae(r.form.list)) return;
      y.value = true, r.form.clickTime = n.state.config.getTreeClickTime, await r.submit(), c("submit");
    } catch (V) {
      console.log("入库表单提交", V);
    } finally {
      y.value = false;
    }
    else y.value = false, c("submit");
  }, 350, true);
  return (V, M) => {
    const g = Ve("common-button");
    return w(), Q("div", ine, [C("div", ane, [u.showContractTotal ? (w(), Q(Qe, { key: 0 }, [M[0] || (M[0] = C("div", { class: "total-name" }, "合同量", -1)), C("div", lne, K(`${u.contractValue || 0} ${u.contractUnit || ""}`), 1)], 64)) : H("", true), u.showInboundTotal ? (w(), Q(Qe, { key: 1 }, [M[1] || (M[1] = C("div", { class: "total-name" }, "已入库量", -1)), C("div", one, K(`${u.inboundValue || 0} ${u.inboundUnit || ""}`), 1)], 64)) : H("", true), u.showTotal ? (w(), Q(Qe, { key: 2 }, [C("div", nne, K(u.totalName), 1), C("div", sne, K(`${u.totalValue || 0} ${u.unit || ""}`), 1)], 64)) : H("", true), u.showTotalAmount ? (w(), Q(Qe, { key: 3 }, [M[2] || (M[2] = C("div", { class: "total-name" }, "金额合计", -1)), C("div", rne, K(`${u.totalAmount || 0} 元`), 1)], 64)) : H("", true)]), C("div", null, [xt(V.$slots, "calculator", {}, void 0, true), s(g, { loading: y.value, size: "default", style: { "margin-left": "10px" }, type: "primary", onClick: l(b) }, { default: p(() => [Te(K(e.btnName), 1)]), _: 1 }, 8, ["loading", "onClick"])])]);
  };
} }, d2 = ut(une, [["__scopeId", "data-v-0befb1e0"]]), cne = Object.freeze(Object.defineProperty({ __proto__: null, default: d2 }, Symbol.toStringTag, { value: "Module" }));
const dne = { class: "logistics-form" }, mne = { __name: "logistics-form", props: { disabled: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) } }, setup(e, { expose: o }) {
  const n = e, c = Z(), u = Z({});
  Dt(() => {
    u.value = n.form;
  });
  const b = { freight: [{ required: true, message: "请输入运费", trigger: "blur" }, { validator: (M, g, S) => {
    A(u.value.supplierId) && Ae(u.value.freight) && S(new Error("请输入运费")), S();
  }, trigger: "blur" }], freightWeight: [{ validator: (M, g, S) => {
    A(u.value.freightWeight) && (u.value.freightWeight || S(new Error("运输重量必须大于0"))), S();
  }, trigger: "blur" }], supplierId: [{ validator: (M, g, S) => {
    A(u.value.freight) && Ae(u.value.supplierId) && S(new Error("请选择供应商")), S();
  }, trigger: "change" }] };
  async function V() {
    try {
      return c.value ? await c.value.validate() : false;
    } catch {
      return false;
    }
  }
  return o({ validate: V }), (M, g) => {
    const S = Ml, h = Ve("common-input-number"), T = Zi, _ = Li;
    return w(), Q("div", dne, [s(S, null, { default: p(() => g[5] || (g[5] = [C("span", { class: "title" }, "物流信息", -1)])), _: 1, __: [5] }), s(_, { ref_key: "formRef", ref: c, model: u.value, disabled: n.disabled, rules: b, size: "default", inline: "", "label-position": "right", "label-width": "80px" }, { default: p(() => [s(T, { label: "运费", prop: "freight", "label-width": "60px" }, { default: p(() => [s(h, { class: "input-underline", modelValue: u.value.freight, "onUpdate:modelValue": g[0] || (g[0] = (f) => u.value.freight = f), type: "text", min: 0, max: 999999999, precision: l(Ze).YUAN, controls: false, placeholder: "运费", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), s(T, { label: "运输重量（kg）", prop: "freightWeight", "label-width": "120px" }, { default: p(() => [s(h, { class: "input-underline", modelValue: u.value.freightWeight, "onUpdate:modelValue": g[1] || (g[1] = (f) => u.value.freightWeight = f), type: "text", min: 0, max: 999999999, precision: l(Ze).COM_WT__KG, controls: false, placeholder: "运输重量", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), s(T, { class: "el-form-item-10", label: "发票及税率", prop: "invoiceType", "label-width": "100px" }, { default: p(() => [s(Xn, { class: "input-underline", invoiceType: u.value.invoiceType, "onUpdate:invoiceType": g[2] || (g[2] = (f) => u.value.invoiceType = f), taxRate: u.value.taxRate, "onUpdate:taxRate": g[3] || (g[3] = (f) => u.value.taxRate = f), disabled: u.value.boolUsed, default: "", classification: l(Yn).LOGISTICS.V }, null, 8, ["invoiceType", "taxRate", "disabled", "classification"])]), _: 1 }), s(T, { label: "物流单位", prop: "supplierId" }, { default: p(() => [s(k_, { class: "input-underline", modelValue: u.value.supplierId, "onUpdate:modelValue": g[4] || (g[4] = (f) => u.value.supplierId = f), type: l(vo).LOGISTICS.V, placeholder: "可选择供应商搜索", style: { width: "250px" }, "logistics-createable": "", "show-type": false, clearable: "" }, null, 8, ["modelValue", "type"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])]);
  };
} }, N4 = ut(mne, [["__scopeId", "data-v-49bb1cf5"]]), pne = Object.freeze(Object.defineProperty({ __proto__: null, default: N4 }, Symbol.toStringTag, { value: "Module" })), Kn = { __name: "project-set-columns-vxe", props: { order: { type: Object, default: () => ({}) }, requisitions: { type: Object, default: () => ({}) }, list: { type: Array, default: () => [] }, form: { type: Object, default: () => ({}) }, unShowExtra: { type: Boolean, default: false } }, setup(e) {
  const { projectAllType: o } = Wa(), n = e;
  ud();
  const c = Ee(() => {
    const u = n.order;
    if (A(u) && A(u.projects)) return u.projects.map((r) => ({ id: r.id, name: di(r, { showSerialNumber: true }) }));
    {
      const r = [];
      return o.value.forEach((E) => {
        (E.level === Bt.FACTORY.V || E.level === 3) && r.push(E);
      }), r.map((E) => ({ id: E.id, name: di(E, { showSerialNumber: true }) }));
    }
  });
  return Dt(() => {
  }), Ce(c, (u) => {
  }, { immediate: true }), (u, r) => {
    const E = Ve("vxe-column");
    return w(), U(E, { align: "center", title: "所属项目", "min-width": "180px", field: "projectId" }, { default: p(({ row: y, rowIndex: b }) => [s(n2, { modelValue: y.projectId, "onUpdate:modelValue": (V) => y.projectId = V, "show-extra": b !== 0 && !e.unShowExtra, defaultOptions: c.value, clearable: "", placeholder: "所属项目", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "defaultOptions"])]), _: 1 });
  };
} }, hne = Object.freeze(Object.defineProperty({ __proto__: null, default: Kn }, Symbol.toStringTag, { value: "Module" })), Wn = { __name: "warehouse-set-columns-vxe", props: { boolManuf: { type: Boolean, default: false }, showWarehouse: { type: Boolean, default: true }, list: { type: Array, default: () => {
} } }, setup(e) {
  const o = e, n = Z({ list: [] });
  Dt(() => {
    n.value = { list: o.list };
  });
  const { getNotDittoArr: c, initScopeList: u, handleValueChange: r, getRealVal: E } = Rn("workshopId"), y = Ee(() => c()), b = Ee(() => n.value.list || []);
  Dt(() => u(b.value));
  function V(M, g, S) {
    S.warehouseId = void 0;
  }
  return (M, g) => {
    const S = Ve("vxe-column");
    return w(), Q(Qe, null, [s(S, { field: "workshopId", align: "center", "min-width": "140px", title: "仓库" }, { default: p(({ row: h, rowIndex: T }) => [s(Mr, { modelValue: h.workshopId, "onUpdate:modelValue": (_) => h.workshopId = _, placeholder: "请选择仓库", "show-extra": T !== 0, style: { width: "100%" }, onChange: (_) => V(_, T, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "show-extra", "onChange"])]), _: 1 }), e.showWarehouse ? (w(), U(S, { key: 0, field: "warehouseId", title: "存储位置", "min-width": "140px", align: "center" }, { default: p(({ row: h, rowIndex: T }) => [s(xs, { modelValue: h.warehouseId, "onUpdate:modelValue": (_) => h.warehouseId = _, "workshop-id": l(E)(T), "basic-class": h.basicClass, style: { width: "100%" }, "show-extra": b.value[T - 1] && !y.value.includes(T), placeholder: "存储位置" }, null, 8, ["modelValue", "onUpdate:modelValue", "workshop-id", "basic-class", "show-extra"])]), _: 1 })) : H("", true)], 64);
  };
} }, fne = Object.freeze(Object.defineProperty({ __proto__: null, default: Wn }, Symbol.toStringTag, { value: "Module" }));
const gne = { key: 0 }, Ene = { class: "inventory" }, yne = { class: "right-box" }, Tne = { key: 0, class: "head-container", style: { "margin-top": "15px" } }, _ne = { class: "filter-item" }, bne = { key: 1 }, Vne = { __name: "confirm-dialog", props: { modelValue: { type: Boolean, default: false }, basicClass: { type: Number } }, emits: ["saveSuccess", "update:modelValue"], setup(e, { emit: o }) {
  const { user: n } = ka(["user"]), { realTimeValidate: c } = as(), { overDiffTip: u, weightOverDiff: r, diffSubmitValidate: E } = Va(ei, { cfgType: "inbound", weightField: "weighingTotalWeight", compareWeightField: "theoryTotalWeight", weightTip: "理论重量" }), { handleOverMete: y } = Us({ meteField: "weighingTotalWeight" }), b = Ht(), V = o, { transOverDiffTip: M, transWeightOverDiff: g } = K3(ei, { cfgType: "inbound", weightField: "loadingWeight", compareWeightField: "theoryTotalWeight", weightTip: "理论重量" }), S = e, h = Z([]), T = Z([]), _ = Z([]), f = Z(false), { visible: m, handleClose: R } = Ta({ emit: V, props: S, showHook: ne, closeHook: pe }), { cu: v, form: N, FORM: P } = Wi(), { inboundFillWayCfg: L } = aa(), { projectsAll: O } = Er(), x = Z([{ seq: "合计", quantity: "-", mete: "-", weighingTotalWeight: "-" }]), I = Z([{ seq: "合计", quantity: "-", theoryTotalWeight: "-", weighingTotalWeight: "-" }]), Y = Z({ resizable: true }), ee = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), B = Z(), q = Ee(() => Ae(v.props.order) ? {} : v.props.order.supplyType === Ni.PARTY_A.V ? { ...v.props.order, projects: O.value } : v.props.order), ae = Ee(() => L.value ? Ae(q.value.detail) ? L.value.amountFillWay === $l.APPLICATION.V : L.value.saveInboundState || !L.value.saveInboundState && !L.value.passedInboundState : false), j = Z(true), le = Ee(() => q.value.logisticsPayerType === Bi.DEMAND.V && (L.value ? L.value.freightShowScene === Aa.INVENTORY_SUBMISSION.V : true)), oe = Ee(() => {
    var He;
    return ((He = q.value) == null ? void 0 : He.supplyType) === Ni.PARTY_A.V;
  }), ye = Ee(() => q.value.materialType === va.MANUFACTURED.V), ce = Ee(() => {
    const He = ae.value && !oe.value && (q.value.projects && q.value.requisitionsSN || j.value), ze = ae.value && oe.value && q.value.projects && q.value.requisitionsSN && j.value;
    return !(He || ze);
  }), se = Z({}), he = (He, ze) => !ye.value || ye.value && ze.destination === Bt.FACTORY.V ? !!A(He) : true, be = (He, ze) => ye.value ? true : !!A(He), ge = { weighingTotalWeight: [{ validator: (He, ze) => ze.weightMeasurementMode === Wt.OVERWEIGHT.V && (ze.basicClass & Ge.STEEL_PLATE.V || ze.basicClass & Ge.SECTION_STEEL.V) ? He ? E(He, ze) : false : true, message: "超出误差允许范围,不可提交", trigger: "blur" }] }, Le = { weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: E, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], workshopId: [{ validator: he, message: "请选择仓库", trigger: "change" }], warehouseId: [{ validator: be, message: "请选择仓库", trigger: "change" }] }, Ie = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, X = { projectId: [{ validator: (He, ze) => Ae(ze.applyPurchaseId) ? !!He : true, message: "请选择项目", trigger: "change" }] }, $ = Ee(() => {
    var Oe;
    const He = { ...Le };
    return ae.value && !oe.value && Object.assign(He, Ie), A(q.value.projects) && (oe.value || !((Oe = q.value) != null && Oe.boolApplyPurchase)) && Object.assign(He, X), Object.assign(He, ge), Object.assign(He, { realTime: [{ validator: c, message: "请选择实际入库时间", trigger: "change" }] }), He;
  }), { maxHeight: k } = Kt({ mainBox: ".inbound-application-preview", extraBox: [".el-dialog__header", ".logistics-form-content", ".footer"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, m), J = Ee(() => A(h.value) && A(T.value) ? (k.value - 80) / 2 : k.value - 80), z = /* @__PURE__ */ new Map([["requisitionsSN", -1], ["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]);
  yi("ditto", z);
  const F = Z(false), { tableValidate: G, wrongCellMask: ie } = ui({ rules: $, ditto: z });
  Ce(() => v == null ? void 0 : v.submitResult, () => {
    var He;
    ((He = v == null ? void 0 : v.submitResult) == null ? void 0 : He.code) === 40206 && (b.dispatch("config/fetchMatClsTree"), v.submitResult.code = null, b.state.config.classifySpec = { specKV: [] });
  }, { deep: true });
  function ue({ row: He, rowIndex: ze }) {
    var Oe, Re, fe;
    if ((Re = (Oe = v == null ? void 0 : v.submitResult) == null ? void 0 : Oe.data) != null && Re.includes(He.classifyId) && ((fe = v == null ? void 0 : v.submitResult) == null ? void 0 : fe.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  function ne() {
    F.value = true, N.originLoadingWeight = N.loadingWeight, T.value = [], h.value = [], N.list.map((Re) => {
      var fe, Ue;
      Re.originMete = Re.mete, Re.realTime = (/* @__PURE__ */ new Date()).getTime(), (oe.value || (fe = N.selectObj[Re.mergeId]) != null && fe.isSelected || !oe.value && Ae((Ue = q.value) == null ? void 0 : Ue.details)) && (Re.weightMeasurementMode === Wt.OVERWEIGHT.V && (Re.basicClass & Ge.STEEL_PLATE.V || Re.basicClass & Ge.SECTION_STEEL.V) ? T.value.push(Re) : h.value.push(Re));
    });
    let He = 0, ze = 0, Oe = 0;
    h.value.forEach((Re) => {
      He += Re.quantity || 0, ze += Re.mete || 0, Oe += Re.weighingTotalWeight || 0;
    }), ze = ze.toFixed(ei.weight.precision), Oe = Oe.toFixed(ei.weight.precision), x.value = [{ seq: "合计", quantity: He, mete: ze, weighingTotalWeight: Oe }], we(), v.status.edit >= 1 && N.loadingWeight && (f.value = true), setTimeout(() => {
      F.value = false;
    }, 100);
  }
  const te = Ee(() => {
    let He = 0;
    return N.list.forEach((ze) => {
      A(ze.mete) && (He += +ze.mete);
    }), He ? He.toFixed(ei.weight.precision) : 0;
  });
  v.submitFormFormat = async (He) => {
    f.value || (He.loadingWeight = null), He.loginUserId = n.value.id;
    const ze = At(He.list);
    return He.list = await Ut(ze, { toSmallest: true, toNum: true }), He.list.forEach((Oe) => {
      var Re;
      ye.value && (Oe.projectId = (Re = q.value.projects) != null && Re.length ? q.value.projects[0].id : void 0);
    }), Ae(He.logistics) && (He.logistics = void 0), He.supplyType & Ni.PARTY_A.V && (He.purchaseId = void 0), He;
  };
  const { steelDensityCfg: de } = cn();
  P.HOOK.beforeSubmit = async () => {
    if (await b.dispatch("wms/fetchSteelDensityCfg"), N.loadingWeight && se.value.hasOver && f.value) return ot.error("超出误差允许范围"), false;
    if (S.basicClass & ct.STEEL.V) {
      const Oe = [];
      let Re = [];
      if (N.list.forEach((fe) => {
        (fe.basicClass === Pe.STEEL_PLATE.V || fe.basicClass === Pe.STEEL_COIL.V) && fe.steelDensity !== de.value[fe.classifyId] && (Oe.push(`<div>【${fe.classifyName}】最新设置密度与该单据创建时设置密度不一致！！！</div>`), fe.steelDensity = de.value[fe.classifyId]);
      }), Re = Array.from(new Set(Oe)), Re.length) {
        const fe = Re.join("");
        ot({ message: fe, dangerouslyUseHTMLString: true, type: "warning", duration: 5e3 });
      }
    }
    let He = true;
    if (A(T.value)) {
      const { validResult: Oe, dealList: Re } = G(T.value);
      He = Oe, Oe && (T.value = Re, T.value.forEach((fe) => {
        fe.mete = fe.weighingTotalWeight;
      }));
    }
    if (A(h.value)) {
      const { validResult: Oe, dealList: Re } = G(h.value);
      He = Oe, Oe && (h.value = Re);
    }
    let ze = true;
    return le.value && B.value && (ze = await B.value.validate()), He && ze;
  }, P.HOOK.afterSubmit = () => {
    N.selectObj = {}, R();
  };
  function pe() {
    _.value = [];
  }
  const re = Ee(() => () => {
    let He = 0;
    return A(T.value) && T.value.filter((ze) => {
      He += ze.theoryTotalWeight ? ze.theoryTotalWeight : 0;
    }), He;
  });
  function we() {
    let He = 0, ze = 0, Oe = 0;
    T.value.forEach((Re) => {
      He += Re.quantity || 0, ze += Re.theoryTotalWeight || 0, Oe += Re.weighingTotalWeight || 0;
    }), ze = ze.toFixed(ei.weight.precision), Oe = Oe.toFixed(ei.weight.precision), I.value = [{ seq: "合计", quantity: He, theoryTotalWeight: ze, weighingTotalWeight: Oe }];
  }
  function Ke() {
    if (!N.loadingWeight) {
      ot.warning("请先输入过磅重量");
      return;
    }
    let He = [], ze = 0;
    if (A(T.value) && (He = T.value.filter((fe) => (ze += fe.theoryTotalWeight ? fe.theoryTotalWeight : 0, fe.theoryTotalWeight))), se.value = g(N.loadingWeight, ze), se.value.hasOver) {
      ot.error("超出误差允许范围");
      return;
    }
    let Oe = N.loadingWeight - ze;
    const Re = (fe) => {
      fe.weighingTotalWeight = Oe ? ji(fe.theoryTotalWeight / ze * Oe + fe.theoryTotalWeight, ei.weight.precision, { toNum: true }) : fe.theoryTotalWeight, Oe -= fe.weighingTotalWeight - fe.theoryTotalWeight, ze -= fe.theoryTotalWeight, Ne(fe);
    };
    He.forEach((fe) => Re(fe)), ot.warning("已分配过磅重量"), T.value.forEach((fe) => {
      fe.mete = fe.weighingTotalWeight;
    }), we();
  }
  function Me() {
    T.value.map((He) => {
      He.weighingTotalWeight = He.originMete, He.mete = He.originMete;
    }), we(), N.loadingWeight = N.originLoadingWeight;
  }
  function Ne(He) {
    r(He), we();
  }
  return (He, ze) => {
    const Oe = wi, Re = Ve("vxe-column"), fe = Ve("vxe-table"), Ue = Fo, Je = Ve("common-input-number"), Xe = jt, Ye = Zi, Fe = Ve("common-button"), et = Li, lt = Ve("common-dialog"), bt = oi;
    return w(), U(lt, { modelValue: l(m), "onUpdate:modelValue": ze[3] || (ze[3] = (gt) => Gt(m) ? m.value = gt : null), "before-close": l(R), title: q.value.serialNumber ? `订单：${q.value.serialNumber}（${q.value.supplier ? q.value.supplier.name : ""}）` : "甲供入库", top: "5vh", "append-to-body": "", "custom-class": "inbound-application-preview", fullscreen: "", width: "1200px" }, { titleAfter: p(() => [oe.value ? H("", true) : (w(), U(s2, { key: 0, detail: l(N), order: q.value }, null, 8, ["detail", "order"]))]), titleRight: p(() => [ae.value ? (w(), U(br, { key: 0, "purchase-id": q.value.id, size: "default" }, null, 8, ["purchase-id"])) : H("", true)]), default: p(() => [l(m) ? qe((w(), U(et, { key: 0, ref: "formRef", disabled: l(v).status.edit === l(P).STATUS.PROCESSING, model: l(N) }, { default: p(() => [S.basicClass & l(sl) ? (w(), Q("div", gne, [C("div", Ene, [ze[4] || (ze[4] = C("div", { class: "left-box" }, "汇总", -1)), C("div", yne, K(te.value || 0) + K(l(ei).weight.unit), 1)])])) : H("", true), l(A)(h.value) ? (w(), Q(Qe, { key: 1 }, [s(Oe, { style: { "margin-bottom": "15px" }, type: "success" }, { default: p(() => ze[5] || (ze[5] = [Te("理计汇总")])), _: 1, __: [5] }), s(fe, { key: "`inbound_formList`", "column-config": Y.value, data: h.value, "empty-text": "暂无数据", "footer-data": x.value, "max-height": J.value, "row-style": ue, "scroll-y": ee.value, border: "", "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(Re, { type: "expand", width: "60" }, { content: p(({ row: gt }) => [ce.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": gt.basicClass, row: gt, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [ze[6] || (ze[6] = Te(" 备注：")), C("span", null, K(gt.remark), 1)])]), _: 1 }), s(hc, { "basic-class": S.basicClass }, null, 8, ["basic-class"]), ce.value ? (w(), U(fc, { key: 0, "basic-class": S.basicClass, fixed: false }, null, 8, ["basic-class"])) : H("", true), s(Re, { title: "收货数量", align: "center", field: "quantity", width: "100" }), s(Re, { title: "总重", align: "center", field: "mete", width: "100" }, { default: p(({ row: gt }) => [C("span", null, K(gt.mete ? gt.mete.toFixed(gt.accountingPrecision) : "-"), 1)]), _: 1 }), s(Kn, { list: h.value, order: q.value, unShowExtra: "" }, null, 8, ["list", "order"]), s(Wn, { list: h.value, showWarehouse: "" }, null, 8, ["list"]), s(gc, { label: "实际入库时间" })]), _: 1 }, 8, ["column-config", "data", "footer-data", "max-height", "scroll-y"])], 64)) : H("", true), l(A)(T.value) ? (w(), Q(Qe, { key: 2 }, [S.basicClass & l(sl) ? (w(), Q("div", Tne, [s(Oe, { class: "filter-item" }, { default: p(() => ze[7] || (ze[7] = [Te("磅计汇总")])), _: 1, __: [7] }), C("span", _ne, [s(Ue, { modelValue: f.value, "onUpdate:modelValue": ze[0] || (ze[0] = (gt) => f.value = gt) }, null, 8, ["modelValue"]), C("span", null, "重量分摊模式(" + K(l(ei).weight.unit) + ")", 1)]), f.value ? (w(), Q(Qe, { key: 0 }, [s(Ye, { label: "", class: "filter-item", "label-width": "0", prop: "loadingWeight" }, { default: p(() => [s(Xe, { content: `重量误差：${se.value.overNum} kg， ${l(M)}`, disabled: !se.value.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Je, { modelValue: l(N).loadingWeight, "onUpdate:modelValue": ze[1] || (ze[1] = (gt) => l(N).loadingWeight = gt), class: Zt([{ "over-weight-tip": se.value.hasOver }, "input-underline"]), controls: false, max: 999999999, min: 0, placeholder: "输入该车次重量", precision: 0, mode: "input", style: { width: "135px" }, onBlur: ze[2] || (ze[2] = (gt) => l(g)(l(N).loadingWeight, re.value)) }, null, 8, ["modelValue", "class"])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 }), s(Fe, { class: "filter-item", type: "primary", onClick: Ke }, { default: p(() => ze[8] || (ze[8] = [Te("计算")])), _: 1, __: [8] })], 64)) : H("", true), s(Fe, { class: "filter-item", type: "warning", onClick: Me }, { default: p(() => ze[9] || (ze[9] = [Te("重置")])), _: 1, __: [9] })])) : H("", true), s(fe, { key: "`inbound_weightList`", "cell-class-name": l(ie), "column-config": Y.value, data: T.value, "empty-text": "暂无数据", "footer-data": I.value, "max-height": J.value, "row-style": ue, "scroll-y": ee.value, border: "", class: "myTable-style", "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(Re, { type: "expand", width: "60" }, { content: p(({ row: gt }) => [ce.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": gt.basicClass, row: gt, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [ze[10] || (ze[10] = Te(" 备注：")), C("span", null, K(gt.remark), 1)])]), _: 1 }), s(hc, { "basic-class": S.basicClass }, null, 8, ["basic-class"]), ce.value ? (w(), U(fc, { key: 0, "basic-class": S.basicClass, fixed: false, isVxe: "" }, null, 8, ["basic-class"])) : H("", true), s(Re, { title: "收货数量", align: "center", field: "quantity", width: "100" }), s(Re, { title: "理论重量", align: "center", field: "theoryTotalWeight", "min-width": "110" }), s(Re, { align: "center", field: "weighingTotalWeight", title: "实收重量", width: "135px" }, { default: p(({ row: gt }) => [f.value ? (w(), Q("span", bne, K(gt.weighingTotalWeight ? gt.weighingTotalWeight.toFixed(l(ei).weight.precision) : "-"), 1)) : (w(), U(Xe, { key: 0, content: `理论重量：${gt.theoryTotalWeight} kg， ${l(u)}`, disabled: !gt.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(Je, { modelValue: gt.weighingTotalWeight, "onUpdate:modelValue": (qt) => gt.weighingTotalWeight = qt, class: Zt({ "over-weight-tip": gt.hasOver }), controls: false, max: 999999999, min: 0, precision: l(ei).weight.precision, "controls-position": "right", placeholder: "实收量", size: "default", onBlur: (qt) => l(y)(gt), onChange: (qt) => Ne(gt) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onBlur", "onChange"])]), _: 2 }, 1032, ["content", "disabled"]))]), _: 1 }), s(Kn, { list: T.value, order: q.value, unShowExtra: "" }, null, 8, ["list", "order"]), s(Wn, { list: T.value, showWarehouse: "" }, null, 8, ["list"]), s(gc, { label: "实际入库时间" })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "footer-data", "max-height", "scroll-y"])], 64)) : H("", true), le.value ? (w(), U(N4, { key: 3, ref_key: "logisticsRef", ref: B, disabled: l(v).status.edit === l(P).STATUS.PROCESSING, form: l(N).logistics, showType: "submit", class: "logistics-form-content" }, null, 8, ["disabled", "form"])) : H("", true)]), _: 1 }, 8, ["disabled", "model"])), [[bt, F.value]]) : H("", true), s(d2, { "show-total": false, class: "footer", "is-submit": "" })]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, L4 = ut(Vne, [["__scopeId", "data-v-961f0077"]]), wne = Object.freeze(Object.defineProperty({ __proto__: null, default: L4 }, Symbol.toStringTag, { value: "Module" }));
const Sne = { class: "main-content" }, vne = { __name: "common-wrapper", props: { basicClass: { type: Number }, currentBasicClass: { type: Number }, validate: { type: Function }, unit: { type: String, default: "" }, totalValue: { type: [Number, String], default: 0 }, contractUnit: { type: String, default: "" }, contractValue: { type: [Number, String], default: 0 }, totalName: { type: String, default: "合计" }, btnName: { type: String, default: "下一步" }, inboundUnit: { type: String, default: "" }, inboundValue: { type: [Number, String], default: 0 }, showInboundTotal: { type: Boolean, default: false }, showContractTotal: { type: Boolean, default: false }, showTotal: { type: Boolean, default: true }, showTotalAmount: { type: Boolean, default: true }, isManuf: { type: Boolean, default: false }, totalAmount: { type: [Number, String], default: 0 }, edit: { type: Boolean, default: false }, beginValidate: { type: Function }, beginPermission: { type: Object, default: () => {
} } }, emits: ["purchase-order-change", "submit"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(false), E = Z(false);
  let y = {};
  c.edit ? y = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false } : y = { extraBox: null, wrapperBox: null };
  const { heightStyle: b } = Kt(y);
  async function V() {
    if (u.value.form.inboundWay === si.ORDINARY_STORAGE.V) {
      const g = await u.value.validate();
      let S = true;
      typeof c.validate == "function" && (S = await c.validate()), g && S && (r.value = true);
    } else c.beginValidate() && (E.value = true);
  }
  function M(g, S) {
    n("purchase-order-change", g, S);
  }
  return (g, S) => (w(), Q("div", { style: ri(l(b)), class: "inbound-application-container" }, [s(A4, { ref_key: "headerRef", ref: u, "basic-class": c.basicClass, "current-basic-class": c.currentBasicClass ?? c.basicClass, edit: c.edit, isManuf: e.isManuf, permission: e.beginPermission, validate: e.validate, class: "header", onPurchaseOrderChange: M }, null, 8, ["basic-class", "current-basic-class", "edit", "isManuf", "permission", "validate"]), C("div", Sne, [xt(g.$slots, "default", {}, void 0, true)]), s(d2, { "btn-name": c.btnName, "contract-unit": c.contractUnit, "contract-value": c.contractValue, "inbound-unit": c.inboundUnit, "inbound-value": c.inboundValue, "show-total": c.showTotal, "show-total-amount": c.showTotalAmount, showContractTotal: e.showContractTotal, showInboundTotal: e.showInboundTotal, "total-amount": c.totalAmount, "total-name": c.totalName, "total-value": c.totalValue, unit: c.unit, class: "footer", onSubmit: V }, null, 8, ["btn-name", "contract-unit", "contract-value", "inbound-unit", "inbound-value", "show-total", "show-total-amount", "showContractTotal", "showInboundTotal", "total-amount", "total-name", "total-value", "unit"]), s(L4, { modelValue: r.value, "onUpdate:modelValue": S[0] || (S[0] = (h) => r.value = h), "basic-class": c.basicClass }, null, 8, ["modelValue", "basic-class"]), xt(g.$slots, "beginPreview", { onUpdateVisible: (h) => E.value = h, visible: E.value }, void 0, true)], 4));
} }, vu = ut(vne, [["__scopeId", "data-v-2abeb78c"]]), Rne = Object.freeze(Object.defineProperty({ __proto__: null, default: vu }, Symbol.toStringTag, { value: "Module" }));
function Mne({ quantityField: e = "quantity", meteField: o = "mete" }) {
  return { handleOverQuantity: (u, r = false, E = "purchaseQuantity") => {
    u[e] > u[E] && u[e] !== u.originQuantity && (u.mergeId || r) ? zi.confirm("本次实收数大于采购数，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      u.originQuantity = u[e];
    }).catch(() => {
      u[e] = u.originQuantity;
    }) : u.originQuantity = u[e];
  }, handleOverMete: (u) => {
    u[o] > u.purchaseMete && u[o] !== u.originMete && u.mergeId ? zi.confirm("本次实收量大于采购量，请确认", "提示", { confirmButtonText: "是", cancelButtonText: "否", type: "warning" }).then(() => {
      u.originMete = u[o];
    }).catch(() => {
      u[o] = u.originMete;
    }) : u.originMete = u[o];
  } };
}
const Ane = { __name: "inbound-info-table", props: { hasBorder: { type: Boolean, default: false }, material: { type: Object, default: () => ({}) }, basicClass: { type: Number }, list: { type: Array, default: () => [] } }, emits: ["del"], setup(e, { emit: o }) {
  const n = e, c = Z([...ld, ["inboundTime", ["parse-time", "{y}-{m}-{d}"]]]);
  function u(r) {
    const E = n.material.measurePrecision || 0, y = n.material.accountingPrecision || 2;
    return Hi(r, { props: [["quantity", E], ["mete", y]] });
  }
  return (r, E) => {
    const y = vt, b = Ve("common-table");
    return w(), U(b, { data: e.list, "data-format": c.value, "show-summary": false, "summary-method": u, "row-key": "id", style: { width: "100%" }, class: Zt({ "table-border-none": !e.hasBorder }) }, { default: p(() => [s(fa, { "basic-class": e.basicClass }, { afterIndex: p(() => [s(y, { prop: "inboundTime", "show-overflow-tooltip": "", align: "center", width: "100", label: "入库时间" }), s(y, { prop: "applyPurchaseSN", "show-overflow-tooltip": "", align: "center", "min-width": "120", label: "申购单" })]), _: 1 }, 8, ["basic-class"]), s(za, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(Ba, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(y, { prop: "remark", "show-overflow-tooltip": "", align: "left", "min-width": "120", label: "备注" })]), _: 1 }, 8, ["data", "data-format", "class"]);
  };
} }, Vd = ut(Ane, [["__scopeId", "data-v-25b70525"]]), Nne = Object.freeze(Object.defineProperty({ __proto__: null, default: Vd }, Symbol.toStringTag, { value: "Module" }));
const Lne = { style: {} }, Ine = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Cne = { __name: "steel-plate-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), b = Z(), { overDiffTip: V, weightOverDiff: M, diffSubmitValidate: g } = Va(r), { handleOverMete: S } = Mne({ meteField: "weighingTotalWeight" }), h = Z(false), T = Z({ resizable: true }), _ = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { specSelectMaxHeight: f, specRef: m, drawerRef: R, editRow: v, editList: N, materialSelectVisible: P, handleSpecChange: L } = fd(), O = ($, k) => A($) ? $ > 0 : true, x = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { validator: O, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: O, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: g, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: O, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: O, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: O, message: "数量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, Y = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: ($, k) => A(k.weighingTotalWeight) && A(k.unitPrice) ? +Be(k.weighingTotalWeight * k.unitPrice, Ze.YUAN) == +$ : false, message: "金额有误，请手动修改", trigger: "blur" }] }, ee = Ee(() => {
    let $ = Object.assign({}, x);
    return !n.boolPartyA && n.fillableAmount && ($ = Object.assign($, Y)), $;
  }), B = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: q, cleanUpData: ae, wrongCellMask: j } = ui({ rules: ee, ditto: B, errorMsg: "请修正【钢板清单】中标红的信息" }), { steelDensityCfg: le } = cn();
  function oe() {
  }
  function ye({ row: $, rowIndex: k }) {
    var J, z;
    if ((z = (J = E == null ? void 0 : E.submitResult) == null ? void 0 : J.data) != null && z.includes($.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce($) {
    const k = Ct({ uid: Tt(), sn: $.sn, specificationLabels: $.specificationLabels, serialNumber: $.serialNumber, classifyId: $.classify.id, classifyFullName: $.classify.fullName, classifyName: $.classify.name, classifyParentFullName: $.classify.parentFullName, classifySerialNumber: $.classify.serialNumber, basicClass: $.classify.basicClass, specification: $.spec, model: $.spec, specificationMap: $.specKV, measureUnit: $.classify.measureUnit, accountingUnit: $.classify.accountingUnit, accountingPrecision: $.classify.accountingPrecision, measurePrecision: $.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: y.steelPlateList.length > 0 ? -1 : void 0, workshopId: y.steelPlateList.length > 0 ? -1 : void 0, warehouseId: y.steelPlateList.length > 0 ? -1 : void 0, weightMeasurementMode: Wt.THEORY.V, steelDensity: A($.steelDensity) ? $.steelDensity : le.value[$.classify.id] });
    return !n.boolPartyA && n.fillableAmount && (k.unitPrice = void 0, k.amount = void 0), se(k), k;
  }
  function se($) {
    Dt(() => {
      var k, J, z, F;
      M($), $.needFirstCalcTheoryWeight && ($.boolApplyPurchase || (he($), be($)), $.boolApplyPurchase && ((J = (k = y.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected) && ($.quantity = (z = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : z.reduce((G, ie) => G + (ie.quantity || 0), 0), $.theoryTotalWeight = (F = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : F.reduce((G, ie) => G + (ie.theoryTotalWeight || 0), 0)), $.needFirstCalcTheoryWeight = false);
    }), Ce([() => $.boolApplyPurchase, () => $ == null ? void 0 : $.applyPurchase], () => {
      var k, J, z, F;
      $.boolApplyPurchase && ((J = (k = y.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected) && ($.quantity = (z = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : z.reduce((G, ie) => G + (ie.quantity || 0), 0), $.theoryTotalWeight = (F = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : F.reduce((G, ie) => G + (ie.theoryTotalWeight || 0), 0), $.weighingTotalWeight = $.theoryTotalWeight);
    }, { deep: true }), Ce(() => $, () => {
      var k, J, z;
      if (!n.boolPartyA && !n.noDetail && ((J = (k = y.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected)) {
        const F = (z = y.selectObj[$.mergeId]) == null ? void 0 : z.isSelected;
        y.selectObj[$.mergeId] = { ...y.selectObj[$.mergeId], ...$, mete: $.weighingTotalWeight, isSelected: F };
      }
    }, { deep: true }), $.boolApplyPurchase || (Ce([() => $.length, () => $.width, () => $.thickness, r], () => he($)), Ce([() => $.theoryWeight, () => $.quantity], () => be($))), Ce(() => $.weighingTotalWeight, () => {
      me($);
    });
  }
  async function he($) {
    $.theoryWeight = await na({ classifyId: $.classifyId, name: $.classifyFullName, length: $.length, width: $.width, thickness: $.thickness });
  }
  function be($) {
    A($.theoryWeight) && $.quantity ? ($.theoryTotalWeight = Be($.theoryWeight * $.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = Be($.theoryWeight * $.quantity, r.value.weight.precision))) : ($.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = void 0));
  }
  function me($) {
    A($.unitPrice) && A($.weighingTotalWeight) && ($.amount = Be($.weighingTotalWeight * $.unitPrice, Ze.YUAN));
  }
  function ge($, k, J) {
    var z, F, G, ie;
    if ((F = (z = E == null ? void 0 : E.submitResult) == null ? void 0 : z.data) != null && F.includes(J.classifyId)) {
      const ue = (G = E == null ? void 0 : E.submitResult) == null ? void 0 : G.data.findIndex((te) => te === J.classifyId);
      y.steelPlateList.filter((te) => te.classifyId === J.classifyId).length === 1 && ((ie = E == null ? void 0 : E.submitResult) == null || ie.data.splice(ue, 1));
    }
    if (u.value ? u.value.delListItem($, k) : y.steelPlateList.splice(k, 1), A(y.steelPlateList) && y.steelPlateList.length > 0) {
      const ue = y.steelPlateList[0];
      y.steelPlateList[0].projectId = ue.projectId && ue.projectId !== -1 ? ue.projectId : void 0, y.steelPlateList[0].workshopId = ue.workshopId && ue.workshopId !== -1 ? ue.workshopId : void 0, y.steelPlateList[0].warehouseId = ue.warehouseId && ue.warehouseId !== -1 ? ue.warehouseId : void 0;
    }
  }
  function Le($, k) {
    const J = JSON.parse(JSON.stringify($)), z = Ct({ uid: Tt(), sn: J.sn, specificationLabels: J.specificationLabels, classifySerialNumber: J.classifySerialNumber, serialNumber: J.serialNumber, classifyId: J.classifyId, classifyFullName: J.classifyFullName, classifyName: J.classifyName, classifyParentFullName: J.classifyParentFullName, basicClass: J.basicClass, specification: J.specification, model: J.spec, specificationMap: J.specificationMap, measureUnit: J.measureUnit, accountingUnit: J.accountingUnit, accountingPrecision: J.accountingPrecision, measurePrecision: J.measurePrecision, quantity: J.quantity, thickness: J.thickness, length: J.length, width: J.width, theoryWeight: J.theoryWeight, theoryTotalWeight: J.theoryTotalWeight, weighingTotalWeight: J.weighingTotalWeight, projectId: J.projectId, workshopId: J.workshopId, warehouseId: J.warehouseId, rowIndex: y.steelPlateList.length, weightMeasurementMode: J.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : J.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : J.amount, steelDensity: A(J.steelDensity) ? J.steelDensity : le.value[J.classify.id] });
    y.steelPlateList.push(z), se(z), u.value.initSelected([z]);
  }
  function Ie() {
    if (Ae(y.steelPlateList)) return true;
    const $ = y.steelPlateList.filter((J, z) => (J.dataIndex = z, true));
    if (Ae($)) return true;
    const { validResult: k } = q($);
    return k && (ae($), $.forEach((J) => {
      var z, F;
      y.steelPlateList[J.dataIndex].projectId = J.projectId, y.steelPlateList[J.dataIndex].workshopId = J.workshopId || ((z = J.workshop) == null ? void 0 : z.id), y.steelPlateList[J.dataIndex].warehouseId = J.warehouseId || ((F = J.warehouse) == null ? void 0 : F.id);
    })), k;
  }
  function Se($, k) {
  }
  Ce(() => y.steelPlateList, ($) => {
    b.value && b.value.updateFooter();
  }, { deep: true, immediate: true });
  function X($) {
    var k;
    return [(k = $.columns) == null ? void 0 : k.map((J, z) => {
      if (z === 0) return "合计";
      if (J.property === "quantity") return $.data.reduce((G, ie) => G + (Number(ie.quantity) || 0), 0);
      if (J.property === "weighingTotalWeight") {
        const F = $.data.reduce((G, ie) => G + (Number(ie.weighingTotalWeight) || 0), 0);
        return F == null ? void 0 : F.toFixed(r.value.weight.precision);
      }
      return null;
    })];
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Se, validate: Ie, setSelect: oe }), ($, k) => {
    const J = Mt, z = Ve("vxe-column"), F = Ve("vxe-tooltip"), G = Ve("common-input-number"), ie = jt, ue = Ve("common-radio-button"), ne = Ve("common-button"), te = Ve("vxe-table"), de = Ve("common-drawer"), pe = _t("empty-text"), re = oi;
    return w(), Q(Qe, null, [qe((w(), Q("div", null, [(w(), U(te, { key: `inbound_${l(c)}`, "cell-class-name": l(j), "column-config": T.value, data: l(y).steelPlateList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, ref_key: "tableRef", ref: b, border: "", class: "myTable-style", "footer-method": X, "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(z, { type: "expand", width: "60" }, { content: p(({ row: we }) => [C("div", Lne, [s(J, { modelValue: we.remark, "onUpdate:modelValue": (Ke) => we.remark = Ke, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(we.inboundList) ? (w(), Q("div", Ine, [s(l(Vd), { "basic-class": l(c), list: we.inboundList, material: we, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(z, { title: "序号", type: "seq", width: "55" }), s(z, { align: "center", field: "serialNumber", "min-width": "110px", title: "编号" }), s(z, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: we }) => [s(F, { content: we.classifyParentFullName, disabled: !we.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[pe, we.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: we }) => [s(F, { content: we.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(we.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { title: `厚 (${l(r).thickness.unit})`, align: "center", field: "thickness", "min-width": "100px" }, { default: p(({ row: we }) => [s(G, { modelValue: we.thickness, "onUpdate:modelValue": (Ke) => we.thickness = Ke, controls: false, max: 99999999, min: 0, precision: l(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(z, { title: `宽 (${l(r).width.unit})`, align: "center", field: "width", "min-width": "135px" }, { default: p(({ row: we }) => [s(G, { modelValue: we.width, "onUpdate:modelValue": (Ke) => we.width = Ke, controls: false, max: 99999999, min: 0, precision: l(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (Ke) => l(S)(we) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(z, { title: `长 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "135px" }, { default: p(({ row: we }) => [s(G, { modelValue: we.length, "onUpdate:modelValue": (Ke) => we.length = Ke, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (Ke) => l(S)(we) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(z, { title: `数量 (${l(r).measure.unit})`, align: "center", field: "quantity", "min-width": "135px" }, { default: p(({ row: we }) => [s(G, { modelValue: we.quantity, "onUpdate:modelValue": (Ke) => we.quantity = Ke, controls: false, max: 999999999, min: 1, precision: l(r).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(z, { key: "weighingTotalWeight", title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "135px" }, { default: p(({ row: we }) => [s(ie, { content: `理论重量：${we.theoryTotalWeight} ${l(r).weight.unit}， ${l(V)}`, disabled: !we.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(G, { modelValue: we.weighingTotalWeight, "onUpdate:modelValue": (Ke) => we.weighingTotalWeight = Ke, class: Zt({ "over-weight-tip": we.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default", style: { width: "100%" }, onChange: (Ke) => me(we) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision", "onChange"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(z, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: we }) => [s(J, { modelValue: we.brand, "onUpdate:modelValue": (Ke) => we.brand = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(z, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: we }) => [s(J, { modelValue: we.heatNoAndBatchNo, "onUpdate:modelValue": (Ke) => we.heatNoAndBatchNo = Ke, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(z, { align: "center", field: "weightMeasurementMode", title: "计量方式", width: "160px" }, { default: p(({ row: we }) => [s(ue, { modelValue: we.weightMeasurementMode, "onUpdate:modelValue": (Ke) => we.weightMeasurementMode = Ke, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), s(Kn, { list: l(y).steelPlateList, order: e.order }, null, 8, ["list", "order"]), s(Wn, { list: l(y).steelPlateList, showWarehouse: "" }, null, 8, ["list"]), s(z, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: we, rowIndex: Ke }) => [s(ne, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Me) => Le(we, Ke) }, null, 8, ["onClick"]), s(ne, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Me) => ge(we.sn, Ke, we) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[re, h.value]]), s(de, { ref_key: "drawerRef", ref: R, modelValue: l(P), "onUpdate:modelValue": k[1] || (k[1] = (we) => Gt(P) ? P.value = we : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: m, modelValue: l(N), "onUpdate:modelValue": k[0] || (k[0] = (we) => Gt(N) ? N.value = we : null), classifyId: l(v).classifyId, "max-height": l(f), "show-classify": false, visible: l(P), "expand-query": "", mode: "selector", onChange: l(L) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, I4 = ut(Cne, [["__scopeId", "data-v-0917c4f0"]]), Pne = Object.freeze(Object.defineProperty({ __proto__: null, default: I4 }, Symbol.toStringTag, { value: "Module" }));
const One = { style: { overflow: "hidden" } }, kne = { style: {} }, Dne = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, xne = { __name: "section-steel-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, u = Z(), r = ft("matSpecRef"), { baseUnit: E } = ai(c), { cu: y, form: b } = Wi(), V = Z(false), M = Z({ resizable: true }), g = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), { overDiffTip: S, weightOverDiff: h, diffSubmitValidate: T } = Va(E), { specSelectMaxHeight: _, specRef: f, drawerRef: m, editRow: R, editList: v, materialSelectVisible: N, handleSpecChange: P } = fd(), L = ($, k) => !!$, O = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], length: [{ required: true, message: "请填写定尺长度", trigger: "blur" }, { validator: L, message: "定尺长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: L, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: T, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: L, message: "重量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, I = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: ($, k) => A(k.weighingTotalWeight) && A(k.unitPrice) ? +Be(k.weighingTotalWeight * k.unitPrice, Ze.YUAN) == +$ : false, message: "金额有误，请手动修改", trigger: "blur" }] }, Y = Ee(() => {
    let $ = Object.assign({}, O);
    return !n.boolPartyA && n.fillableAmount && ($ = Object.assign($, I)), $;
  }), ee = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: B, cleanUpData: q, wrongCellMask: ae } = ui({ rules: Y, ditto: ee, errorMsg: "请修正【型材清单】中标红的信息" });
  function j() {
  }
  function le($, k) {
    const J = k.find((z) => z.standardId === $.standardId);
    $.unitWeight = J.unitWeight;
  }
  function oe({ row: $, rowIndex: k }) {
    var J, z, F;
    if ((z = (J = y == null ? void 0 : y.submitResult) == null ? void 0 : J.data) != null && z.includes($.classifyId) && ((F = y == null ? void 0 : y.submitResult) == null ? void 0 : F.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  function ye($) {
    var G;
    const k = (G = $.nationalStandardOptions.find((ie) => ie.boolDefault === true)) == null ? void 0 : G.standardId, J = Ct({ uid: Tt(), sn: $.sn, specificationLabels: $.specificationLabels, serialNumber: $.serialNumber, classifyId: $.classify.id, classifyFullName: $.classify.fullName, classifyName: $.classify.name, classifyParentFullName: $.classify.parentFullName, basicClass: $.classify.basicClass, classifySerialNumber: $.classify.serialNumber, specification: $.spec, model: $.spec, specificationMap: $.specKV, measureUnit: $.classify.measureUnit, accountingUnit: $.classify.accountingUnit, accountingPrecision: $.classify.accountingPrecision, measurePrecision: $.classify.measurePrecision, unitWeight: $.unitWeight, quantity: void 0, length: void 0, totalLength: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, hasOver: false, nationalStandardOptions: $.nationalStandardOptions, standardId: k, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0, projectId: b.sectionSteelList.length > 0 ? -1 : void 0, workshopId: b.sectionSteelList.length > 0 ? -1 : void 0, warehouseId: b.sectionSteelList.length > 0 ? -1 : void 0, weightMeasurementMode: Wt.THEORY.V });
    let z;
    const F = [];
    for (const ie in J.specificationMap) ie.indexOf("standard") > -1 ? z = J.specificationMap[ie] : F.push(J.specificationMap[ie]);
    return J.sectionSteelSpec = z, J.doNotSectionSteelSpec = F.join(" * "), !n.boolPartyA && n.fillableAmount && (J.unitPrice = void 0, J.amount = void 0), ce(J), J;
  }
  function ce($) {
    Dt(() => {
      var k, J, z, F, G, ie;
      h($), $.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected && !$.boolApplyPurchase) && (se($), be($)), $.boolApplyPurchase && ((F = (z = b.selectObj) == null ? void 0 : z[$.mergeId]) != null && F.isSelected) && ($ == null || $.applyPurchase.map((ue) => {
        A(ue.length) && A(ue.quantity) ? ue.totalLength = Na({ length: ue.length, quantity: ue.quantity }) : ue.totalLength = void 0;
      }), $.theoryTotalWeight = (G = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : G.reduce((ue, ne) => ue + (ne.theoryTotalWeight || 0), 0), $.totalLength = (ie = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : ie.reduce((ue, ne) => ue + (ne.totalLength || 0), 0)), $.needFirstCalcTheoryWeight = false);
    }), Ce([() => $.boolApplyPurchase, () => $ == null ? void 0 : $.applyPurchase], () => {
      var k, J, z, F, G;
      $.boolApplyPurchase && ((J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected) && ($.quantity = (z = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : z.reduce((ie, ue) => ie + (ue.quantity || 0), 0), $.theoryTotalWeight = (F = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0), $.weighingTotalWeight = $.theoryTotalWeight, $.totalLength = (G = $ == null ? void 0 : $.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.totalLength || 0), 0));
    }, { deep: true }), Ce(() => $, () => {
      var k, J, z;
      if (!n.boolPartyA && !n.noDetail && ((J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected)) {
        const F = (z = b.selectObj[$.mergeId]) == null ? void 0 : z.isSelected;
        b.selectObj[$.mergeId] = { ...b.selectObj[$.mergeId], ...$, mete: $.weighingTotalWeight, isSelected: F };
      }
    }, { deep: true }), $.boolApplyPurchase || (Ce([() => $.length, () => $.unitWeight, E], () => se($)), Ce([() => $.theoryWeight, () => $.quantity], () => {
      be($);
    })), Ce(() => $.weighingTotalWeight, () => {
      me($);
    }), Ce([() => $.length, () => $.quantity], () => {
      he($);
    });
  }
  async function se($) {
    $.theoryWeight = await xa({ length: $.length, unitWeight: $.unitWeight });
  }
  function he($) {
    var k, J;
    (n.boolPartyA || n.noDetail || (J = (k = b.selectObj) == null ? void 0 : k[$.mergeId]) != null && J.isSelected && !$.boolApplyPurchase) && (A($.length) && $.quantity ? $.totalLength = Na({ length: $.length, quantity: $.quantity }) : $.totalLength = void 0);
  }
  function be($) {
    A($.theoryWeight) && $.quantity ? ($.theoryTotalWeight = Be($.theoryWeight * $.quantity, E.value.weight.precision), (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = Be($.theoryWeight * $.quantity, E.value.weight.precision))) : ($.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && ($.weighingTotalWeight = void 0));
  }
  function me($) {
    A($.unitPrice) && A($.weighingTotalWeight) && ($.amount = Be($.weighingTotalWeight * $.unitPrice, Ze.YUAN));
  }
  function ge($, k, J) {
    var z, F, G, ie;
    if ((F = (z = y == null ? void 0 : y.submitResult) == null ? void 0 : z.data) != null && F.includes(J.classifyId)) {
      const ue = (G = y == null ? void 0 : y.submitResult) == null ? void 0 : G.data.findIndex((te) => te === J.classifyId);
      b.sectionSteelList.filter((te) => te.classifyId === J.classifyId).length === 1 && ((ie = y == null ? void 0 : y.submitResult) == null || ie.data.splice(ue, 1));
    }
    if (r.value ? r.value.delListItem($, k) : b.sectionSteelList.splice(k, 1), A(b.sectionSteelList) && b.sectionSteelList.length > 0) {
      const ue = b.sectionSteelList[0];
      b.sectionSteelList[0].projectId = ue.projectId && ue.projectId !== -1 ? ue.projectId : void 0, b.sectionSteelList[0].workshopId = ue.workshopId && ue.workshopId !== -1 ? ue.workshopId : void 0, b.sectionSteelList[0].warehouseId = ue.warehouseId && ue.warehouseId !== -1 ? ue.warehouseId : void 0;
    }
  }
  function Le($, k) {
    const J = JSON.parse(JSON.stringify($)), z = Ct({ uid: Tt(), sn: J.sn, specificationLabels: J.specificationLabels, classifySerialNumber: J.classifySerialNumber, serialNumber: J.serialNumber, classifyId: J.classifyId, classifyFullName: J.classifyFullName, classifyName: J.classifyName, classifyParentFullName: J.classifyParentFullName, basicClass: J.basicClass, specification: J.specification, model: J.model, specificationMap: J.specificationMap, measureUnit: J.measureUnit, accountingUnit: J.accountingUnit, accountingPrecision: J.accountingPrecision, measurePrecision: J.measurePrecision, unitWeight: J.unitWeight, quantity: J.quantity, length: J.length, totalLength: J.totalLength, theoryWeight: J.theoryWeight, theoryTotalWeight: J.theoryTotalWeight, weighingTotalWeight: J.weighingTotalWeight, hasOver: false, nationalStandardOptions: J.nationalStandardOptions, standardId: J.standardId, sectionSteelSpec: J.sectionSteelSpec, doNotSectionSteelSpec: J.doNotSectionSteelSpec, projectId: J.projectId, workshopId: J.workshopId, warehouseId: J.warehouseId, weightMeasurementMode: J.weightMeasurementMode, rowIndex: b.sectionSteelList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : J.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : J.amount });
    b.sectionSteelList.push(z), ce(z), r.value.initSelected([z]);
  }
  function Ie() {
    if (Ae(b.sectionSteelList)) return true;
    const $ = b.sectionSteelList.filter((J, z) => (J.dataIndex = z, true));
    if (Ae($)) return true;
    const { validResult: k } = B($);
    return k && (q($), $.forEach((J) => {
      var z, F;
      b.sectionSteelList[J.dataIndex].projectId = J.projectId, b.sectionSteelList[J.dataIndex].workshopId = J.workshopId || ((z = J.workshop) == null ? void 0 : z.id), b.sectionSteelList[J.dataIndex].warehouseId = J.warehouseId || ((F = J.warehouse) == null ? void 0 : F.id);
    })), k;
  }
  function Se($, k) {
    var J;
    (J = u == null ? void 0 : u.value) == null || J.toggleRowSelection($, k);
  }
  Ce(() => b.sectionSteelList, ($) => {
    u.value && u.value.updateFooter();
  }, { deep: true, immediate: true });
  function X($) {
    var k;
    return [(k = $.columns) == null ? void 0 : k.map((J, z) => {
      if (z === 0) return "合计";
      if (J.property === "quantity") return $.data.reduce((G, ie) => G + (Number(ie.quantity) || 0), 0);
      if (J.property === "weighingTotalWeight") {
        const F = $.data.reduce((G, ie) => G + (Number(ie.weighingTotalWeight) || 0), 0);
        return F == null ? void 0 : F.toFixed(E.value.weight.precision);
      }
      return null;
    })];
  }
  return o({ rowInit: ye, rowWatch: ce, toggleRowSelection: Se, validate: Ie, setSelect: j }), ($, k) => {
    const J = Mt, z = Ve("vxe-column"), F = Ve("vxe-tooltip"), G = Ve("common-input-number"), ie = Ve("common-select"), ue = jt, ne = Ve("common-radio-button"), te = Ve("common-button"), de = Ve("vxe-table"), pe = Ve("common-drawer"), re = _t("empty-text"), we = oi;
    return w(), Q(Qe, null, [qe((w(), Q("div", One, [(w(), U(de, { key: `inbound_${l(c)}`, "cell-class-name": l(ae), "column-config": M.value, data: l(b).sectionSteelList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": oe, "scroll-y": g.value, border: "", class: "myTable-style", ref_key: "tableRef", ref: u, "footer-method": X, "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(z, { type: "expand", width: "60" }, { content: p(({ row: Ke }) => [C("div", kne, [s(J, { modelValue: Ke.remark, "onUpdate:modelValue": (Me) => Ke.remark = Me, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Ke.inboundList) ? (w(), Q("div", Dne, [s(l(Vd), { "basic-class": l(c), list: Ke.inboundList, material: Ke, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(z, { title: "序号", type: "seq", width: "55" }), s(z, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(z, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Ke }) => [s(F, { content: Ke.classifyParentFullName, disabled: !Ke.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[re, Ke.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(z, { align: "center", field: "specification", "min-width": "120", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Ke }) => [s(F, { content: Ke.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ke.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(z, { title: `定尺长度 (${l(E).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Ke }) => [s(G, { modelValue: Ke.length, "onUpdate:modelValue": (Me) => Ke.length = Me, controls: false, max: 99999999, min: 0, precision: l(E).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (Me) => $.inputNumberBlur(Me, Ke) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(z, { align: "center", field: "profileLibraryStandard", "min-width": "140", title: "型材库标准" }, { default: p(({ row: Ke }) => [s(ie, { modelValue: Ke.standardId, "onUpdate:modelValue": (Me) => Ke.standardId = Me, dataStructure: { key: "standardId", label: "name", value: "standardId" }, options: Ke.nationalStandardOptions || [], placeholder: "请选择标准", style: { width: "100%" }, type: "other", onChange: (Me) => le(Ke, Ke.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 }), s(z, { title: `数量 （${l(E).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: Ke }) => [s(G, { modelValue: Ke.quantity, "onUpdate:modelValue": (Me) => Ke.quantity = Me, controls: false, max: 99999999, min: 0, precision: l(E).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" }, onBlur: (Me) => $.inputNumberBlur(Me, Ke) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(z, { title: "总长度 (m)", align: "center", "min-width": "135px", field: "totalLength" }), s(z, { title: `总重 (${l(E).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Ke }) => [s(ue, { content: `单位重量：${Ke.unitWeight} kg/m， 理论重量：${Ke.theoryTotalWeight} ${l(E).weight.unit}， ${l(S)}`, disabled: !Ke.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(G, { modelValue: Ke.weighingTotalWeight, "onUpdate:modelValue": (Me) => Ke.weighingTotalWeight = Me, class: Zt({ "over-weight-tip": Ke.hasOver }), controls: false, max: 999999999, min: 0, precision: l(E).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["title"]), s(z, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Ke }) => [s(J, { modelValue: Ke.brand, "onUpdate:modelValue": (Me) => Ke.brand = Me, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(z, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: Ke }) => [s(J, { modelValue: Ke.heatNoAndBatchNo, "onUpdate:modelValue": (Me) => Ke.heatNoAndBatchNo = Me, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(z, { align: "center", title: "计量方式", field: "weightMeasurementMode", width: "160px" }, { default: p(({ row: Ke }) => [s(ne, { modelValue: Ke.weightMeasurementMode, "onUpdate:modelValue": (Me) => Ke.weightMeasurementMode = Me, options: l(Wt).ENUM, props: { key: "K", label: "SL", value: "V" }, "unshow-val": [l(Wt).MIXTURE.V], default: "", size: "default", type: "enum" }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshow-val"])]), _: 1 }), s(Kn, { list: l(b).sectionSteelList, order: e.order }, null, 8, ["list", "order"]), s(Wn, { list: l(b).sectionSteelList, showWarehouse: "" }, null, 8, ["list"]), s(z, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Ke, rowIndex: Me }) => [s(te, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Ne) => Le(Ke, Me) }, null, 8, ["onClick"]), s(te, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ne) => ge(Ke.sn, Me, Ke) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[we, V.value]]), s(pe, { ref_key: "drawerRef", ref: m, modelValue: l(N), "onUpdate:modelValue": k[1] || (k[1] = (Ke) => Gt(N) ? N.value = Ke : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "型材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: f, modelValue: l(v), "onUpdate:modelValue": k[0] || (k[0] = (Ke) => Gt(v) ? v.value = Ke : null), classifyId: l(R).classifyId, "max-height": l(_), "show-classify": false, visible: l(N), "expand-query": "", mode: "selector", onChange: l(P) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, C4 = ut(xne, [["__scopeId", "data-v-264d17f7"]]), Une = Object.freeze(Object.defineProperty({ __proto__: null, default: C4 }, Symbol.toStringTag, { value: "Module" }));
