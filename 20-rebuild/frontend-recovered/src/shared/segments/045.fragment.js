const Kx = { key: 0 }, Wx = { key: 1 }, jx = { __name: "outsource-form", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const o = e, n = Z({ projectId: void 0, recipientId: void 0, quantity: void 0, remark: void 0, outboundTime: void 0, purchaseId: void 0 });
  const c = ft("maxQuantity"), u = Z([]);
  Dt(async () => {
    n.value = o.form, n.value.projectId && E();
  });
  function r() {
    n.value.quantity = c.value;
  }
  async function E() {
    if (n.value.areaBatchId = void 0, u.value = [], !n.value.projectId) return;
    const y = await rd({ projectId: n.value.projectId });
    u.value = y || [];
  }
  return (y, b) => {
    const V = Ve("common-input-number"), M = Zi, g = Ve("common-select-v2"), S = Rl, h = Mt, T = _t("to-fixed");
    return w(), Q(Qe, null, [s(M, { label: `数量(${e.material.outboundUnit})`, prop: "quantity" }, { default: p(() => [s(V, { modelValue: n.value.quantity, "onUpdate:modelValue": b[0] || (b[0] = (_) => n.value.quantity = _), max: l(c), min: 0, precision: e.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: r }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.accountingUnit ? (w(), U(M, { key: 0, label: `核算量(${e.material.accountingUnit})` }, { default: p(() => [l(A)(e.material.measureUnit) && e.material.outboundUnitType === l(hi).MEASURE.V ? qe((w(), Q("span", Kx, null, 512)), [[T, { val: n.value.quantity / e.material.quantity * e.material.mete || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", Wx, null, 512)), [[T, { val: n.value.quantity || 0, dp: e.material.accountingPrecision }]])]), _: 1 }, 8, ["label"])) : H("", true), s(M, { label: "项目", prop: "projectId" }, { default: p(() => [s(l(ca), { modelValue: n.value.projectId, "onUpdate:modelValue": b[1] || (b[1] = (_) => n.value.projectId = _), clearable: "", style: { width: "100%" }, onChange: E }, null, 8, ["modelValue"])]), _: 1 }), s(M, { label: "批次", prop: "areaBatchId" }, { default: p(() => [s(g, { modelValue: n.value.areaBatchId, "onUpdate:modelValue": b[2] || (b[2] = (_) => n.value.areaBatchId = _), options: u.value, size: "default", disabled: !n.value.projectId, collapseTags: "", filterable: "", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", class: "filter-item", placeholder: "请选择批次", style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), s(M, { label: "领用人", prop: "recipientId" }, { default: p(() => [s(Ds, { modelValue: n.value.recipientId, "onUpdate:modelValue": b[3] || (b[3] = (_) => n.value.recipientId = _), "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), s(M, { label: "所属采购合同", prop: "purchaseId" }, { default: p(() => [s(xx, { modelValue: n.value.purchaseId, "onUpdate:modelValue": b[4] || (b[4] = (_) => n.value.purchaseId = _), "basic-class": e.form.basicClass, purchaseType: l(Fi).MANUFACTURED.V, style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "purchaseType"])]), _: 1 }), s(M, { label: "出库时间", prop: "outboundTime" }, { default: p(() => [s(S, { modelValue: n.value.outboundTime, "onUpdate:modelValue": b[5] || (b[5] = (_) => n.value.outboundTime = _), placeholder: "出库时间", type: "datetime", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 }), s(M, { label: "备注", prop: "remark" }, { default: p(() => [s(h, { modelValue: n.value.remark, "onUpdate:modelValue": b[6] || (b[6] = (_) => n.value.remark = _), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, HS = ut(jx, [["__scopeId", "data-v-f1fabc8e"]]), Fx = Object.freeze(Object.defineProperty({ __proto__: null, default: HS }, Symbol.toStringTag, { value: "Module" })), Qu = Ge.STEEL_PLATE.V, Tb = Ge.SECTION_STEEL.V, pn = Ge.STEEL_COIL.V;
async function na({ classifyId: e, name: o, length: n, width: c, thickness: u, quantity: r = 1 }, E = false) {
  if (!o || !n || !c || !u) return null;
  const y = _e.state.wms.steelDensityCfg, b = await _a(), V = await id(), M = b[Qu].length.unit, g = b[Qu].weight.unit, S = E || V === Zn.SINGLE.V ? b[Qu].weight.precision : 5;
  let h = 0;
  for (const m in y) Number(m) === e && (h = y[m]);
  let T;
  const _ = St(n, M, "m"), f = St(c, M, "m");
  return T = _ * f * u * h, T = St(T, "kg", g, S), Be(T * r, S);
}
function Na({ length: e = 0, lengthUnit: o = "mm", quantity: n = 1, precision: c = 3 }, u = true) {
  const r = u ? c : 10, E = (e * n).toFixed(r);
  return St(E, o, "m", r);
}
async function xa({ length: e, quantity: o = 1, unitWeight: n }, c = false) {
  if (!e || !o || !n) return null;
  const u = await _a(), r = await id(), E = u[Tb].length.unit, y = u[Tb].weight.unit, b = c || r === Zn.SINGLE.V ? u[Qu].weight.precision : 5;
  let V;
  return V = St(e, E, "m", 3) * n, V = St(V, "kg", y, b), Be(V * o, b);
}
async function il({ classifyId: e, name: o, weight: n, width: c, thickness: u, quantity: r = 1 }) {
  if (!n || !r || !c || !u) return null;
  const E = _e.state.wms.steelDensityCfg;
  let y = 0;
  for (const m in E) Number(m) === e && (y = E[m]);
  const b = await _a(), V = b[pn].width.unit, M = b[pn].length.unit, g = b[pn].length.precision, S = b[pn].weight.unit, h = b[pn].weight.precision;
  let T;
  const _ = St(n, S, "kg", h), f = St(c, V, "m", 3);
  return T = _ / (f * u * y), T = St(T, "m", M), Number((T * r).toFixed(g));
}
async function zx({ classifyId: e, name: o, length: n, width: c, thickness: u, quantity: r = 1 }) {
  if (!n || !r || !c || !u) return null;
  const E = _e.state.wms.steelDensityCfg;
  let y = 0;
  for (const f in E) Number(f) === e && (y = E[f]);
  const b = await _a(), V = b[pn].width.unit, M = b[pn].length.unit, g = b[pn].weight.unit, S = b[pn].weight.precision;
  let h;
  const T = St(n, M, "m"), _ = St(c, V, "m");
  return h = T * _ * u * y * r, h = St(h, "kg", g, S), Be(h, S);
}
async function Bx(e) {
  var u, r;
  const o = await _a();
  e.steelPlateList = [], e.sectionSteelList = [], e.steelCoilList = [];
  const n = [];
  let c;
  for (const E of e.list) {
    switch (E.uid = E.id, E.weighingTotalWeight = E.mete, E.specificationMap = E.specKV, E.projectId = E.projectId || ((u = E.project) == null ? void 0 : u.id), E.warehouseId = E.warehouseId || ((r = E.warehouse) == null ? void 0 : r.id), E.basicClass) {
      case Ge.STEEL_PLATE.V:
        c = na({ classifyId: E.classifyId, name: E.classifyFullName, length: E.length, width: E.width, thickness: E.thickness }).then((y) => {
          E.theoryWeight = y, E.theoryTotalWeight = Be(E.theoryWeight * (E.quantity || 0), o[Ge.STEEL_PLATE.V].weight.precision), e.steelPlateList.push(E);
        });
        break;
      case Ge.SECTION_STEEL.V:
        c = xa({ length: E.length, unitWeight: E.unitWeight }).then((y) => {
          E.theoryWeight = y, E.theoryTotalWeight = Be(E.theoryWeight * (E.quantity || 0), o[Ge.SECTION_STEEL.V].weight.precision), E.length && E.quantity ? E.totalLength = Na({ length: E.length, quantity: E.quantity }) : E.totalLength = 0, e.sectionSteelList.push(E);
        });
        break;
      case Ge.STEEL_COIL.V:
        c = il({ classifyId: E.classifyId, name: E.classifyFullName, weight: E.weighingTotalWeight, width: E.width, thickness: E.thickness }).then((y) => {
          E.theoryLength = y, E.quantity = E.length, e.steelCoilList.push(E);
        });
        break;
    }
    n.push(c);
  }
  await Promise.all(n);
}
async function Es(e, { prefix: o } = {}) {
  const n = [];
  for (const c of e) {
    const u = o ? c[o] : c;
    let r;
    if (u.basicClass === dt.STEEL_PLATE.V) {
      if (u.materialIsWhole === Dl.ODDMENT.V) {
        u.theoryWeight = Be(u.mete / u.quantity);
        continue;
      }
      r = await na({ classifyId: u.classifyId, name: u.classifyFullName, length: u.length, width: u.width, thickness: u.thickness }).then((E) => {
        u.theoryWeight = E;
      });
    }
    u.basicClass === dt.SECTION_STEEL.V && (r = await xa({ length: u.length, unitWeight: u.unitWeight }).then((E) => {
      u.theoryWeight = E;
    })), u.basicClass === dt.STEEL_COIL.V && (r = await il({ classifyId: u.classifyId, weight: u.mete, width: u.width, thickness: u.thickness }).then((E) => {
      u.theoryLength = E;
    })), r && n.push(r);
  }
  await Promise.all(n);
}
const Hx = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.workshops);
  if (o.state.config.loaded.workshops || o.dispatch("config/fetchWorkshops"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { workshopKV: Ee(() => o.state.config.workshopKV), workshops: Ee(() => o.state.config.workshops), loaded: Ee(() => o.state.config.loaded.workshops) };
}, pu = { __name: "workshop-select", props: { modelValue: { type: [Array, Number, String, void 0], default: void 0 }, factoryId: { type: [Number, String, void 0], default: void 0 }, workshopType: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择车间" }, defaultValue: { type: Boolean, default: false }, showOptionAll: { type: Boolean, default: false }, showExtra: { type: Boolean, default: false }, choseIndex: { type: [Number, String], default: void 0 }, disabledVal: { type: Array, default: () => [] } }, emits: ["change", "update:modelValue", "nameChange"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z(), E = Z([]), { loaded: y, workshops: b } = Hx();
  Ce(() => u.modelValue, (S) => {
    r.value = S, u.default && Ae(S) && A(E.value) && (r.value = E.value[0].id, V(r.value));
  }, { immediate: true }), Ce([b, () => u.factoryId, () => u.workshopType], () => {
    M();
  }, { immediate: true, deep: true });
  function V(S) {
    if (u.modelValue !== S) {
      c("update:modelValue", S), c("change", S);
      const h = E.value.find((T) => T.id === S) || {};
      A(h) && A(u.choseIndex) && (h.choseIndex = u.choseIndex), c("nameChange", h);
    }
  }
  function M() {
    E.value = [];
    let S = [];
    try {
      if (A(b.value)) {
        let h = At(b.value);
        u.factoryId && (h = h.filter((T) => u.factoryId === T.factoryId)), u.workshopType && (h = h.filter((T) => u.workshopType === T.type)), S = h.map((T) => ({ id: T.id, name: T.name }));
      }
    } catch (h) {
      console.log("获取车间列表", h);
    } finally {
      E.value = S, A(E.value) && u.default && !r.value && (r.value = E.value[0].id), V(r.value);
    }
  }
  function g(S) {
    return b.value.find((h) => h.id === S);
  }
  return o({ getOption: g }), (S, h) => {
    const T = Ve("common-select");
    return w(), U(T, ii(S.$attrs, { modelValue: r.value, "onUpdate:modelValue": h[0] || (h[0] = (_) => r.value = _), size: e.size, disabled: e.disabled, multiple: e.multiple, "collapse-tags": e.collapseTags, loading: !l(y), clearable: e.clearable, showOptionAll: e.showOptionAll, showExtra: e.showExtra, allLabelText: "全部车间", disabledVal: e.disabledVal, filterable: "", placeholder: e.placeholder, options: E.value, onChange: V }), null, 16, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "showOptionAll", "showExtra", "disabledVal", "placeholder", "options"]);
  };
} };
const qx = { key: 0 }, Gx = { key: 0 }, Qx = { key: 1 }, Zx = { key: 1 }, Jx = { key: 0 }, Xx = { key: 1 }, $x = { __name: "produce-form", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const o = e, n = Z({ projectId: void 0, workshopId: void 0, recipientId: void 0, quantity: void 0, isNeedRemind: bn.YES.V, remark: void 0 }), c = Z([]);
  Dt(() => {
    n.value = o.form, n.value.projectId && M();
  }), Ce([() => n.value.materialOutboundMode, () => n.value.halfMode, () => n.value.halfSize], () => {
    o.material.basicClass === oa.STEEL_PLATE.V && b(o.material);
  }, { deep: true, immediate: true }), Ce([() => n.value.theoryWeight, () => n.value.quantity], () => {
    V(n.value);
  }, { deep: true, immediate: true });
  const u = ft("outboundCfg"), r = ft("maxQuantity"), E = Ee(() => !o.material.project || u.value.boolCanOutToOtherProject === true && o.material.boolPartyA !== true);
  function y() {
    n.value.quantity = r.value;
  }
  async function b(h) {
    let T = h.length, _ = h.width;
    n.value.materialOutboundMode === Oa.HALF.V && (n.value.halfMode === Vo.LENGTH.V ? T = n.value.halfSize : _ = n.value.halfSize), n.value.theoryWeight = await na({ classifyId: h.classifyId, name: h.classifyFullName, length: T, width: _, thickness: h.thickness });
  }
  function V(h) {
    A(h.theoryWeight) && h.quantity ? n.value.actualTheoryWeight = Be(h.theoryWeight * h.quantity, o.material.accountingPrecision) : n.value.actualTheoryWeight = void 0;
  }
  async function M() {
    if (n.value.areaBatchId = void 0, c.value = [], !n.value.projectId) return;
    const h = await rd({ projectId: n.value.projectId });
    c.value = h || [];
  }
  function g() {
    n.value.outboundMete && o.material.measureUnit && A(o.material.measurePrecision) ? n.value.quantity = Be(n.value.outboundMete / o.material.operableMete * o.material.operableQuantity, o.material.measurePrecision) : n.value.quantity = void 0;
  }
  function S() {
    n.value.outboundMete = o.material.operableMete, g();
  }
  return (h, T) => {
    const _ = Ve("common-input-number"), f = Zi, m = Ve("common-select-v2"), R = Ve("common-radio"), v = Mt, N = _t("to-fixed");
    return w(), Q(Qe, null, [n.value.materialOutboundMode === 4 && e.material.basicClass === l(Ci).STEEL_COIL.V ? (w(), Q(Qe, { key: 0 }, [s(f, { label: `核算量(${e.material.accountingUnit})`, prop: "outboundMete" }, { default: p(() => [s(_, { modelValue: n.value.outboundMete, "onUpdate:modelValue": T[0] || (T[0] = (P) => n.value.outboundMete = P), max: e.material.operableMete, min: 0, precision: e.material.accountingPrecision, "controls-position": "right", onChange: g }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: S }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.measureUnit && l(A)(e.material.measurePrecision) ? (w(), U(f, { key: 0, label: `数量(${e.material.measureUnit})` }, { default: p(() => [qe(C("span", null, null, 512), [[N, { val: n.value.outboundMete / e.material.operableMete * e.material.operableQuantity || 0, dp: e.material.measurePrecision }]])]), _: 1 }, 8, ["label"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [s(f, { label: `数量(${e.material.outboundUnit})`, prop: "quantity" }, { default: p(() => [s(_, { modelValue: n.value.quantity, "onUpdate:modelValue": T[1] || (T[1] = (P) => n.value.quantity = P), max: l(r), min: 0, precision: e.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: y }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.accountingUnit ? (w(), U(f, { key: 0, label: `核算量(${e.material.accountingUnit})` }, { default: p(() => [l(A)(e.material.measureUnit) && e.material.outboundUnitType === l(hi).MEASURE.V ? (w(), Q("div", qx, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", Gx, null, 512)), [[N, { val: n.value.quantity / e.material.operableQuantity * e.material.mete || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", Qx, null, 512)), [[N, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity / e.material.operableQuantity * e.material.mete * (n.value.halfSize / e.material.length) : n.value.quantity / e.material.operableQuantity * e.material.mete * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])])) : (w(), Q("div", Zx, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", Jx, null, 512)), [[N, { val: n.value.quantity || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", Xx, null, 512)), [[N, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity * (n.value.halfSize / e.material.length) : n.value.quantity * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])]))]), _: 1 }, 8, ["label"])) : H("", true)], 64)), e.material.basicClass === l(oa).STEEL_PLATE.V ? (w(), U(f, { key: 2, label: `理论重量(${e.material.accountingUnit})`, prop: "actualTheoryWeight" }, { default: p(() => [C("span", null, K(n.value.actualTheoryWeight || 0), 1)]), _: 1 }, 8, ["label"])) : H("", true), E.value ? (w(), Q(Qe, { key: 3 }, [s(f, { label: "项目", prop: "projectId" }, { default: p(() => [s(l(ca), { modelValue: n.value.projectId, "onUpdate:modelValue": T[2] || (T[2] = (P) => n.value.projectId = P), clearable: "", style: { width: "100%" }, onChange: M }, null, 8, ["modelValue"])]), _: 1 }), s(f, { label: "批次", prop: "areaBatchId" }, { default: p(() => [s(m, { modelValue: n.value.areaBatchId, "onUpdate:modelValue": T[3] || (T[3] = (P) => n.value.areaBatchId = P), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !n.value.projectId, options: c.value, class: "filter-item", clearable: "", collapseTags: "", filterable: "", placeholder: "请选择批次", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 })], 64)) : H("", true), s(f, { label: "车间", prop: "workshopId" }, { default: p(() => [s(l(pu), { modelValue: n.value.workshopId, "onUpdate:modelValue": T[4] || (T[4] = (P) => n.value.workshopId = P), "factory-id": n.value.factoryId, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "factory-id"])]), _: 1 }), s(f, { label: "领用人", prop: "recipientId" }, { default: p(() => [s(Ds, { modelValue: n.value.recipientId, "onUpdate:modelValue": T[5] || (T[5] = (P) => n.value.recipientId = P), "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), s(f, { label: "出库成功是否提醒", prop: "isNeedRemind" }, { default: p(() => [s(R, { modelValue: n.value.isNeedRemind, "onUpdate:modelValue": T[6] || (T[6] = (P) => n.value.isNeedRemind = P), options: l(bn).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(f, { label: "备注", prop: "remark" }, { default: p(() => [s(v, { modelValue: n.value.remark, "onUpdate:modelValue": T[7] || (T[7] = (P) => n.value.remark = P), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, qS = ut($x, [["__scopeId", "data-v-5fcfae0e"]]), eU = Object.freeze(Object.defineProperty({ __proto__: null, default: qS }, Symbol.toStringTag, { value: "Module" })), tU = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.taxRate);
  if (n.value || o.dispatch("config/fetchTaxRate"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, taxRateKV: Ee(() => o.state.config.taxRateKV) };
};
const iU = { class: "invoice-type-select flex-rsc child-mr-10" }, aU = { __name: "invoice-type-select", props: { invoiceType: { type: Number }, taxRate: { type: Number }, classification: { type: Number }, unshowOptions: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, taxDefault: { type: Boolean, default: true } }, emits: ["update:invoiceType", "update:taxRate", "change"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z(), { loaded: E, taxRateKV: y } = tU(), b = Ee(() => {
    const h = Ra.getBits(wn, c.classification, "V"), T = [];
    return h.forEach((f) => {
      T.push.apply(T, y.value[f]);
    }), Tn(T).map((f) => ({ value: f, label: `${f}` }));
  });
  Dt(() => {
    u.value = c.invoiceType, V();
  }), Dt(() => {
    r.value = c.taxRate;
  });
  function V() {
    u.value || c.default && (u.value = fi.SPECIAL.V, M(u.value));
  }
  function M(h) {
    Ae(h) && (h = void 0), h === fi.RECEIPT.V && (r.value = void 0, n("update:taxRate", void 0)), n("update:invoiceType", h), n("change", {});
  }
  function g(h) {
    Ae(h) && (h = void 0), n("update:taxRate", h), n("change", {});
  }
  function S(h) {
    r.value = h.target.value || r.value, g(r.value);
  }
  return (h, T) => {
    const _ = Ve("common-select");
    return w(), Q("span", iU, [s(_, { modelValue: u.value, "onUpdate:modelValue": T[0] || (T[0] = (f) => u.value = f), clearable: c.clearable, disabled: c.disabled, options: l(fi).ENUM, unshowOptions: c.unshowOptions, placeholder: "选择票据类型", style: { width: "150px" }, type: "enum", onChange: M }, null, 8, ["modelValue", "clearable", "disabled", "options", "unshowOptions"]), u.value !== l(fi).RECEIPT.V ? (w(), Q(Qe, { key: 0 }, [s(_, { modelValue: r.value, "onUpdate:modelValue": T[1] || (T[1] = (f) => r.value = f), clearable: c.clearable, "data-structure": { key: "id", label: "label", value: "value" }, disabled: c.disabled, loading: !l(E), options: b.value, "allow-create": "", default: e.taxDefault, filterable: "", placeholder: "税率", style: { width: "80px" }, onBlur: S, onChange: g }, null, 8, ["modelValue", "clearable", "disabled", "loading", "options", "default"]), T[2] || (T[2] = C("span", null, "%", -1))], 64)) : H("", true)]);
  };
} }, Xn = ut(aU, [["__scopeId", "data-v-65b2cfdc"]]), M_ = { __name: "branch-company-select-v2", props: { modelValue: { type: [Number, String], default: void 0 }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, showAll: { type: Boolean, default: false }, labelName: { type: String, default: "全部分公司" }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择公司主体" }, defaultLevel: { type: [Number, String], default: void 0 } }, emits: ["update:modelValue", "change", "currentChange"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false), r = Z(), E = Z([]), y = Ee(() => A(c.defaultLevel) ? E.value.filter((M) => M.level === c.defaultLevel) : E.value);
  Ce(() => c.modelValue, (M) => {
    r.value = M;
  }, { immediate: true });
  function b(M) {
    if (n("update:modelValue", M), n("change", M), M) {
      const g = E.value.find((S) => S.id === M) || {};
      n("currentChange", g);
    } else n("currentChange", {});
  }
  V();
  async function V() {
    let M = [];
    E.value = [];
    try {
      u.value = true;
      const { content: g } = await Pw();
      g && g.length > 0 && (M = g);
    } catch (g) {
      console.log("获取分公司列表", g);
    } finally {
      E.value = M, u.value = false;
    }
  }
  return (M, g) => {
    const S = Ve("common-select");
    return w(), U(S, { modelValue: r.value, "onUpdate:modelValue": g[0] || (g[0] = (h) => r.value = h), clearable: e.clearable, dataStructure: { key: "id", label: "name", value: "id" }, default: c.default, disabled: c.disabled, loading: u.value, options: y.value, placeholder: e.placeholder, size: e.size, type: "other", filterable: "", style: { width: "200px" }, onChange: b }, null, 8, ["modelValue", "clearable", "default", "disabled", "loading", "options", "placeholder", "size"]);
  };
} };
const lU = { key: 0 }, oU = { key: 0 }, nU = { key: 1 }, sU = { key: 1 }, rU = { key: 0 }, uU = { key: 1 }, cU = { __name: "for-sale-form", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const o = e;
  ai(o.material.basicClass);
  const n = Z({ quantity: void 0, isNeedRemind: bn.YES.V, remark: void 0, outboundTime: void 0, purchaseId: void 0, sellUnitPrice: void 0, sellAmount: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingWeight: void 0 });
  Dt(async () => {
    var S;
    n.value = o.form, n.value.sellUnitPrice = (S = o.material) == null ? void 0 : S.unitPrice, await y(o.material);
  });
  const c = ft("maxQuantity"), u = Ee(() => {
    var S;
    return [((S = o.material.branchCompany) == null ? void 0 : S.id) || o.material.branchCompanyId];
  });
  function r() {
    n.value.quantity = c.value;
  }
  const E = Z([Wt.THEORY, Wt.OVERWEIGHT]);
  Ce(() => [n.value.quantity, n.value.materialOutboundMode, n.value.halfMode, n.value.halfSize], () => {
    setTimeout(() => {
      y(o.material), b(n.value), n.value.theoryTotalWeight && M(n.value);
    }, 0);
  }, { deep: true }), Ce(() => n.value.weightMeasurementMode, (S) => {
    S === Wt.THEORY.V ? (n.value.weighingWeight = void 0, n.value.sellAmount = void 0, b(n.value), n.value.theoryTotalWeight && M(n.value)) : (n.value.sellAmount = void 0, n.value.theoryTotalWeight = void 0);
  }, { deep: true });
  async function y(S) {
    let h = S.length, T = S.width;
    n.value.materialOutboundMode === Oa.HALF.V && (n.value.halfMode === Vo.LENGTH.V ? h = n.value.halfSize : T = n.value.halfSize), o.material.basicClass === Ge.STEEL_PLATE.V ? n.value.theoryWeight = await na({ classifyId: S.classifyId, name: S.classifyFullName, length: h, width: T, thickness: S.thickness }) : o.material.basicClass === Ge.SECTION_STEEL.V ? n.value.theoryWeight = await xa({ length: h, unitWeight: S.unitWeight }) : o.material.basicClass === Ge.STEEL_COIL.V ? n.value.theoryWeight = await zx({ classifyId: S.classifyId, name: S.name, length: 1, width: T, thickness: S.thickness }) : n.value.theoryWeight = S.unitNet;
  }
  function b(S) {
    A(S.theoryWeight) && S.quantity ? n.value.theoryTotalWeight = Be(S.theoryWeight * S.quantity, o.material.outboundUnitPrecision || 0) : n.value.theoryTotalWeight = void 0;
  }
  const V = Ee(() => n.value.weightMeasurementMode === Wt.THEORY.V ? n.value.theoryTotalWeight : n.value.weighingWeight);
  function M(S) {
    n.value.inputMete = 0, A(S.sellUnitPrice) && A(V.value) && (n.value.sellAmount = Be(V.value * S.sellUnitPrice, Ze.YUAN)), n.value.inputMete = S.weightMeasurementMode === Wt.THEORY.V ? S.theoryTotalWeight : S.weighingWeight;
  }
  function g(S) {
    n.value.inputMete = 0, A(S.sellUnitPrice) && A(V.value) && (n.value.sellUnitPrice = Be(S.sellAmount / V.value, Ze.YUAN)), n.value.inputMete = S.weightMeasurementMode === Wt.THEORY.V ? S.theoryTotalWeight : S.weighingWeight;
  }
  return (S, h) => {
    const T = Ve("common-radio"), _ = Zi, f = Ve("common-input-number"), m = Mt, R = Rl, v = Ve("purchase-sn-select"), N = _t("to-fixed");
    return w(), Q(Qe, null, [n.value.outboundTypeSelection === l(Jt).FOR_SALE.V && e.material.basicClass & l(va).STEEL.V ? (w(), U(_, { key: 0, label: "计量方式", prop: "weightMeasurementMode" }, { default: p(() => [s(T, { modelValue: n.value.weightMeasurementMode, "onUpdate:modelValue": h[0] || (h[0] = (P) => n.value.weightMeasurementMode = P), options: E.value, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : H("", true), s(_, { label: `数量(${e.material.outboundUnit})`, prop: "quantity" }, { default: p(() => [s(f, { modelValue: n.value.quantity, "onUpdate:modelValue": h[1] || (h[1] = (P) => n.value.quantity = P), max: l(c), min: 0, precision: e.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: r }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 1, label: `核算量(${e.material.accountingUnit})`, prop: "weightMeasurementMode" }, { default: p(() => [l(A)(e.material.measureUnit) && e.material.outboundUnitType === l(hi).MEASURE.V ? (w(), Q("div", lU, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", oU, null, 512)), [[N, { val: n.value.quantity / e.material.quantity * e.material.mete || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", nU, null, 512)), [[N, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity / e.material.quantity * e.material.mete * (n.value.halfSize / e.material.length) : n.value.quantity / e.material.quantity * e.material.mete * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])])) : (w(), Q("div", sU, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", rU, null, 512)), [[N, { val: n.value.quantity || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", uU, null, 512)), [[N, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity * (n.value.halfSize / e.material.length) : n.value.quantity * e.material.mete * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])]))]), _: 1 }, 8, ["label"])) : H("", true), e.material.accountingUnit && n.value.weightMeasurementMode === l(Wt).THEORY.V && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V && n.value.weightMeasurementMode === l(Wt).THEORY.V && e.material.basicClass & l(va).STEEL.V ? (w(), U(_, { key: 2, label: `理论重量(${e.material.accountingUnit})`, prop: "theoryTotalWeight" }, { default: p(() => [C("span", null, K(n.value.theoryTotalWeight || 0), 1)]), _: 1 }, 8, ["label"])) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V && n.value.weightMeasurementMode === l(Wt).OVERWEIGHT.V ? (w(), U(_, { key: 3, label: `过磅重量(${e.material.accountingUnit})`, prop: "weighingWeight" }, { default: p(() => [s(f, { modelValue: n.value.weighingWeight, "onUpdate:modelValue": h[2] || (h[2] = (P) => n.value.weighingWeight = P), controls: false, max: 999999999, min: 1e-6, placeholder: `过磅重量(${e.material.accountingUnit})`, step: 1, size: "default", style: { width: "100%" }, onChange: h[3] || (h[3] = (P) => M(n.value)) }, null, 8, ["modelValue", "placeholder"])]), _: 1 }, 8, ["label"])) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 4, label: "出售含税单价", prop: "sellUnitPrice" }, { default: p(() => [s(f, { modelValue: n.value.sellUnitPrice, "onUpdate:modelValue": h[4] || (h[4] = (P) => n.value.sellUnitPrice = P), controls: false, max: 999999999, min: 1e-6, step: 1, placeholder: "出售含税单价（元）", size: "default", style: { width: "100%" }, onChange: h[5] || (h[5] = (P) => M(n.value)) }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 5, label: "出售含税金额", prop: "sellAmount" }, { default: p(() => [s(f, { modelValue: n.value.sellAmount, "onUpdate:modelValue": h[6] || (h[6] = (P) => n.value.sellAmount = P), controls: false, max: 999999999, min: 1e-6, step: 1, placeholder: "出售含税金额（元）", size: "default", style: { width: "100%" }, onChange: h[7] || (h[7] = (P) => g(n.value)) }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 6, label: "关联交易单位", prop: "branchCompanyId" }, { default: p(() => [s(M_, { modelValue: n.value.branchCompanyId, "onUpdate:modelValue": h[8] || (h[8] = (P) => n.value.branchCompanyId = P), disabled: !!e.form.boolUsed, unshowOptions: u.value, placeholder: "请选择关联交易单位", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "unshowOptions"])]), _: 1 })) : H("", true), n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 7, label: "购买方", prop: "purchaser" }, { default: p(() => [s(m, { modelValue: n.value.purchaser, "onUpdate:modelValue": h[9] || (h[9] = (P) => n.value.purchaser = P), modelModifiers: { trim: true }, maxlength: "100", placeholder: "请输入购买方" }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 8, label: "票型及税率", prop: "invoiceType" }, { default: p(() => [s(Xn, { invoiceType: n.value.invoiceType, "onUpdate:invoiceType": h[10] || (h[10] = (P) => n.value.invoiceType = P), taxRate: n.value.taxRate, "onUpdate:taxRate": h[11] || (h[11] = (P) => n.value.taxRate = P), classification: e.material.basicClass, class: "input-underline" }, null, 8, ["invoiceType", "taxRate", "classification"])]), _: 1 })) : H("", true), e.material.accountingUnit && n.value.outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), U(_, { key: 9, label: "出库日期", prop: "outboundTime" }, { default: p(() => [s(R, { modelValue: n.value.outboundTime, "onUpdate:modelValue": h[12] || (h[12] = (P) => n.value.outboundTime = P), disabledDate: (P) => l(xn)(P).valueOf() < l(xn)().subtract(1, "days").valueOf(), placeholder: "请选择出库日期", size: "default", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "disabledDate"])]), _: 1 })) : H("", true), n.value.outboundTypeSelection === l(Jt).OUTSOURCE.V ? (w(), U(_, { key: 10, label: "所属采购合同", prop: "purchaseId" }, { default: p(() => [s(v, { modelValue: n.value.purchaseId, "onUpdate:modelValue": h[13] || (h[13] = (P) => n.value.purchaseId = P), "basic-class": e.form.basicClass, purchaseType: l(Fi).MANUFACTURED.V, style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "purchaseType"])]), _: 1 })) : H("", true), s(_, { label: "出库成功是否提醒", prop: "isNeedRemind" }, { default: p(() => [s(T, { modelValue: n.value.isNeedRemind, "onUpdate:modelValue": h[14] || (h[14] = (P) => n.value.isNeedRemind = P), options: l(bn).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(_, { label: "备注", prop: "remark" }, { default: p(() => [s(m, { modelValue: n.value.remark, "onUpdate:modelValue": h[15] || (h[15] = (P) => n.value.remark = P), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, GS = ut(cU, [["__scopeId", "data-v-34410ac4"]]), dU = Object.freeze(Object.defineProperty({ __proto__: null, default: GS }, Symbol.toStringTag, { value: "Module" }));
const mU = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const o = e, n = Z({ outboundTypeSelection: void 0 }), c = ft("selfOutboundTypeOptions");
  Dt(async () => {
    n.value = o.form;
  });
  const u = Ee(() => {
    switch (n.value.outboundTypeSelection) {
      case Jt.OUTSOURCE.V:
        return HS;
      case Jt.FOR_SALE.V:
        return GS;
      default:
        return qS;
    }
  });
  return (r, E) => {
    const y = Ve("common-select"), b = Zi;
    return w(), Q(Qe, null, [s(b, { label: "出库类型", prop: "outboundTypeSelection" }, { default: p(() => [s(y, { modelValue: n.value.outboundTypeSelection, "onUpdate:modelValue": E[0] || (E[0] = (V) => n.value.outboundTypeSelection = V), options: l(c), size: "default", style: { width: "100%" }, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), xt(r.$slots, "extra", {}, void 0, true), (w(), U(Ri(u.value), { form: n.value, material: e.material }, null, 8, ["form", "material"]))], 64);
  };
} }, QS = ut(mU, [["__scopeId", "data-v-1ecc8d48"]]), pU = Object.freeze(Object.defineProperty({ __proto__: null, default: QS }, Symbol.toStringTag, { value: "Module" })), ud = (e) => {
  const o = Ht(), n = Ee(() => o.state.project.projectTreeLoaded);
  if (n.value || o.dispatch("project/fetchProjectTree"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, projectTree: Ee(() => o.state.project.projectTree), projectMap: Ee(() => o.state.project.projectMap), monomerMap: Ee(() => o.state.project.monomerMap), areaMap: Ee(() => o.state.project.areaMap) };
};
const hU = { key: 0 }, fU = { key: 0 }, gU = { key: 1 }, EU = { key: 1 }, yU = { key: 0 }, TU = { key: 1 }, _U = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(e) {
  const o = e;
  ud();
  const n = Z({ projectId: void 0, workshopId: void 0, recipientId: void 0, quantity: void 0, isNeedRemind: bn.YES.V, remark: void 0 }), c = Z([]), u = Z([]);
  Dt(() => {
    n.value = o.form, n.value.projectId && M();
  });
  const r = ft("outboundCfg"), E = ft("partyAOutboundTypeOptions"), y = ft("maxQuantity");
  Ee(() => !o.material.project || r.value.boolCanOutToOtherProject === true && o.material.boolPartyA !== true);
  function b() {
    n.value.quantity = y.value;
  }
  Ce([() => o.form.originProjectId], () => {
    V();
  }, { deep: true, immediate: true });
  async function V() {
    if (!o.form.originProjectId) return;
    u.value = [];
    const _ = await zD(o.form.originProjectId);
    _.forEach((f) => {
      f.fullName = di(f);
    }), u.value = _ || [], n.value.projectId = o.form.originProjectId;
  }
  async function M() {
    if (n.value.areaBatchId = void 0, c.value = [], !n.value.projectId) return;
    const _ = await rd({ projectId: n.value.projectId });
    c.value = _ || [];
  }
  Ce([() => n.value.materialOutboundMode, () => n.value.halfMode, () => n.value.halfSize], () => {
    o.material.basicClass === oa.STEEL_PLATE.V && g(o.material);
  }, { deep: true, immediate: true }), Ce([() => n.value.theoryWeight, () => n.value.quantity], () => {
    S(n.value);
  }, { deep: true, immediate: true });
  async function g(_) {
    let f = _.length, m = _.width;
    n.value.materialOutboundMode === Oa.HALF.V && (n.value.halfMode === Vo.LENGTH.V ? f = n.value.halfSize : m = n.value.halfSize), n.value.theoryWeight = await na({ classifyId: _.classifyId, name: _.classifyFullName, length: f, width: m, thickness: _.thickness });
  }
  function S(_) {
    A(_.theoryWeight) && _.quantity ? n.value.actualTheoryWeight = Be(_.theoryWeight * _.quantity, o.material.accountingPrecision) : n.value.actualTheoryWeight = void 0;
  }
  function h() {
    n.value.outboundMete && o.material.measureUnit && A(o.material.measurePrecision) ? n.value.quantity = Be(n.value.outboundMete / o.material.operableMete * o.material.operableQuantity, o.material.measurePrecision) : n.value.quantity = void 0;
  }
  function T() {
    n.value.outboundMete = o.material.operableMete, h();
  }
  return (_, f) => {
    const m = Ve("common-radio"), R = Zi, v = Ve("common-input-number"), N = Ve("common-select-v2"), P = Mt, L = _t("to-fixed");
    return w(), Q(Qe, null, [s(R, { label: "出库类型", prop: "outboundTypeSelection" }, { default: p(() => [s(m, { modelValue: n.value.outboundTypeSelection, "onUpdate:modelValue": f[0] || (f[0] = (O) => n.value.outboundTypeSelection = O), options: l(E), size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), xt(_.$slots, "extra", {}, void 0, true), s(R, { label: "出库目的地", prop: "outboundAddress" }, { default: p(() => [s(m, { modelValue: n.value.outboundAddress, "onUpdate:modelValue": f[1] || (f[1] = (O) => n.value.outboundAddress = O), options: l(So).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), n.value.materialOutboundMode === 4 && e.material.basicClass === l(Ci).STEEL_COIL.V ? (w(), Q(Qe, { key: 0 }, [s(R, { label: `核算量(${e.material.accountingUnit})`, prop: "outboundMete" }, { default: p(() => [s(v, { modelValue: n.value.outboundMete, "onUpdate:modelValue": f[2] || (f[2] = (O) => n.value.outboundMete = O), max: e.material.operableMete, min: 0, precision: e.material.accountingPrecision, "controls-position": "right", onChange: h }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: T }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.measureUnit && l(A)(e.material.measurePrecision) ? (w(), U(R, { key: 0, label: `数量(${e.material.measureUnit})` }, { default: p(() => [qe(C("span", null, null, 512), [[L, { val: n.value.outboundMete / e.material.operableMete * e.material.operableQuantity || 0, dp: e.material.measurePrecision }]])]), _: 1 }, 8, ["label"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 1 }, [s(R, { label: `数量(${e.material.outboundUnit})`, prop: "quantity" }, { default: p(() => [s(v, { modelValue: n.value.quantity, "onUpdate:modelValue": f[3] || (f[3] = (O) => n.value.quantity = O), max: l(y), min: 0, precision: e.material.outboundUnitPrecision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"]), C("span", { class: "text-clickable set-max-text", onClick: b }, "全部出库")]), _: 1 }, 8, ["label"]), e.material.accountingUnit ? (w(), U(R, { key: 0, label: `核算量(${e.material.accountingUnit})` }, { default: p(() => [l(A)(e.material.measureUnit) && e.material.outboundUnitType === l(hi).MEASURE.V ? (w(), Q("div", hU, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", fU, null, 512)), [[L, { val: n.value.quantity / e.material.operableQuantity * e.material.mete || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", gU, null, 512)), [[L, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity / e.material.operableQuantity * e.material.mete * (n.value.halfSize / e.material.length) : n.value.quantity / e.material.operableQuantity * e.material.mete * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])])) : (w(), Q("div", EU, [n.value.materialOutboundMode === l(Oa).WHOLE.V || o.material.basicClass !== l(Ci).STEEL_PLATE.V && o.material.basicClass !== l(Ci).SECTION_STEEL.V ? qe((w(), Q("span", yU, null, 512)), [[L, { val: n.value.quantity || 0, dp: e.material.accountingPrecision }]]) : qe((w(), Q("span", TU, null, 512)), [[L, { val: (n.value.halfMode === l(Vo).LENGTH.V ? n.value.quantity * (n.value.halfSize / e.material.length) : n.value.quantity * (n.value.halfSize / e.material.width)) || 0, dp: e.material.accountingPrecision }]])]))]), _: 1 }, 8, ["label"])) : H("", true)], 64)), e.material.basicClass === l(oa).STEEL_PLATE.V ? (w(), U(R, { key: 2, label: `理论重量(${e.material.accountingUnit})`, prop: "actualTheoryWeight" }, { default: p(() => [C("span", null, K(n.value.actualTheoryWeight || 0), 1)]), _: 1 }, 8, ["label"])) : H("", true), s(R, { label: "项目", prop: "projectId" }, { default: p(() => [s(N, { modelValue: n.value.projectId, "onUpdate:modelValue": f[4] || (f[4] = (O) => n.value.projectId = O), dataStructure: { key: "id", label: "fullName", value: "id" }, options: u.value, class: "filter-item", clearable: "", collapseTags: "", filterable: "", placeholder: "请选择项目", size: "default", style: { width: "100%" }, onChange: M }, null, 8, ["modelValue", "options"])]), _: 1 }), s(R, { label: "批次", prop: "areaBatchId" }, { default: p(() => [s(N, { modelValue: n.value.areaBatchId, "onUpdate:modelValue": f[5] || (f[5] = (O) => n.value.areaBatchId = O), dataStructure: { key: "id", label: "name", value: "id" }, disabled: !n.value.projectId, options: c.value, class: "filter-item", clearable: "", collapseTags: "", filterable: "", placeholder: "请选择批次", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), s(R, { label: "车间", prop: "workshopId" }, { default: p(() => [s(l(pu), { modelValue: n.value.workshopId, "onUpdate:modelValue": f[6] || (f[6] = (O) => n.value.workshopId = O), "factory-id": n.value.factoryId, clearable: "", placeholder: "可选择车间", style: { width: "100%" } }, null, 8, ["modelValue", "factory-id"])]), _: 1 }), s(R, { label: "领用人", prop: "recipientId" }, { default: p(() => [s(Ds, { modelValue: n.value.recipientId, "onUpdate:modelValue": f[7] || (f[7] = (O) => n.value.recipientId = O), "collapse-tags": false, clearable: "", filterable: "", placeholder: "领用人", "show-all-levels": "", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), s(R, { label: "出库成功是否提醒", prop: "isNeedRemind" }, { default: p(() => [s(m, { modelValue: n.value.isNeedRemind, "onUpdate:modelValue": f[8] || (f[8] = (O) => n.value.isNeedRemind = O), options: l(bn).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(R, { label: "备注", prop: "remark" }, { default: p(() => [s(P, { modelValue: n.value.remark, "onUpdate:modelValue": f[9] || (f[9] = (O) => n.value.remark = O), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, ZS = ut(_U, [["__scopeId", "data-v-5324f43b"]]), bU = Object.freeze(Object.defineProperty({ __proto__: null, default: ZS }, Symbol.toStringTag, { value: "Module" })), _r = { __name: "common-material-info", props: { material: { type: Object } }, setup(e) {
  const o = e, n = Ee(() => {
    const c = o.material.workshop ? o.material.workshop.name : "", u = o.material.warehouse ? o.material.warehouse.name : "";
    return `${c} - ${u}`;
  });
  return (c, u) => {
    const r = wi, E = Zi, y = jt, b = _t("empty"), V = _t("parse-project"), M = _t("empty-text");
    return w(), Q(Qe, null, [s(E, { label: "物料" }, { label: p(() => [u[1] || (u[1] = C("span", null, "物料", -1)), e.material.boolPartyA ? (w(), U(r, { key: 0, type: "danger", style: { "margin-left": "10px" } }, { default: p(() => u[0] || (u[0] = [Te("甲供")])), _: 1, __: [0] })) : H("", true)]), default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.classifyFullName }]])]), _: 1 }), e.material.specificationLabels ? (w(), U(E, { key: 0, label: "规格" }, { default: p(() => [s(y, { content: e.material.specificationLabels, disabled: !e.material.specificationLabels, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.specification }]])]), _: 1 }, 8, ["content", "disabled"])]), _: 1 })) : H("", true), xt(c.$slots, "afterSpec"), e.material.color ? (w(), U(E, { key: 1, label: "颜色" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.color }]])]), _: 1 })) : H("", true), s(E, { label: "品牌" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.brand }]])]), _: 1 }), xt(c.$slots, "afterBrand"), e.material.project ? (w(), Q(Qe, { key: 2 }, [s(E, { label: "项目" }, { default: p(() => [qe(C("span", null, null, 512), [[V, { project: e.material.project, onlyShortName: true }], [M]])]), _: 1 }), s(E, { label: "单体" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.monomerName }]])]), _: 1 }), s(E, { label: "区域" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: e.material.areaName }]])]), _: 1 })], 64)) : H("", true), s(E, { label: "仓库" }, { default: p(() => [qe(C("span", null, null, 512), [[b, { val: n.value }]])]), _: 1 })], 64);
  };
} }, VU = Object.freeze(Object.defineProperty({ __proto__: null, default: _r }, Symbol.toStringTag, { value: "Module" })), JS = { __name: "steel-plate", props: { material: { type: Object } }, setup(e) {
  return (o, n) => {
    const c = Zi;
    return w(), U(_r, { material: e.material }, { afterSpec: p(() => [s(c, { label: "厚 * 宽 * 长" }, { default: p(() => [C("span", null, K(`${e.material.thickness}mm * ${e.material.width}mm * ${e.material.length}mm`), 1)]), _: 1 })]), afterBrand: p(() => [s(c, { label: "炉批号" }, { default: p(() => [C("span", null, K(e.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"]);
  };
} }, wU = Object.freeze(Object.defineProperty({ __proto__: null, default: JS }, Symbol.toStringTag, { value: "Module" })), XS = { __name: "section-steel", props: { material: { type: Object } }, setup(e) {
  return (o, n) => {
    const c = Zi;
    return w(), U(_r, { material: e.material }, { afterSpec: p(() => [s(c, { label: "定尺长度" }, { default: p(() => [C("span", null, K(`${e.material.length}mm`), 1)]), _: 1 })]), afterBrand: p(() => [s(c, { label: "炉批号" }, { default: p(() => [C("span", null, K(e.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"]);
  };
} }, SU = Object.freeze(Object.defineProperty({ __proto__: null, default: XS }, Symbol.toStringTag, { value: "Module" })), $S = { __name: "steel-coil", props: { material: { type: Object } }, setup(e) {
  return (o, n) => {
    const c = Zi;
    return w(), U(_r, { material: e.material }, { afterSpec: p(() => [s(c, { label: "厚 * 宽" }, { default: p(() => [C("span", null, K(`${e.material.thickness}mm * ${e.material.width}mm`), 1)]), _: 1 })]), afterBrand: p(() => [s(c, { label: "炉批号" }, { default: p(() => [C("span", null, K(e.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"]);
  };
} }, vU = Object.freeze(Object.defineProperty({ __proto__: null, default: $S }, Symbol.toStringTag, { value: "Module" })), dm = { __name: "aux-mat", props: { material: { type: Object } }, setup(e) {
  return (o, n) => (w(), U(_r, { material: e.material }, null, 8, ["material"]));
} }, RU = Object.freeze(Object.defineProperty({ __proto__: null, default: dm }, Symbol.toStringTag, { value: "Module" })), ev = { __name: "gas", props: { material: { type: Object } }, setup(e) {
  return (o, n) => (w(), U(_r, { material: e.material }, null, 8, ["material"]));
} }, MU = Object.freeze(Object.defineProperty({ __proto__: null, default: ev }, Symbol.toStringTag, { value: "Module" })), aa = (e) => {
  const o = Ht(), n = Ee(() => o.state.wms.loaded.config);
  if (n.value || o.dispatch("wms/fetchWmsConfig"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, baseUnit: Ee(() => o.state.wms.baseUnit), inboundSteelCfg: Ee(() => o.state.wms.inboundSteelCfg), purchaseCfg: Ee(() => o.state.wms.purchaseCfg), inboundFillWayCfg: Ee(() => o.state.wms.inboundFillWayCfg), outboundCfg: Ee(() => o.state.wms.outboundCfg), selfOutboundTypeOptions: Ee(() => {
    const c = [];
    if (A(o.state.wms.outboundCfg) && o.state.wms.outboundCfg.outboundType) {
      const u = Ra.getBits(Jt.ENUM, o.state.wms.outboundCfg.outboundType, "V") || [];
      Ra.toArr(Jt).forEach((E) => {
        u.includes(E.V) && E.V !== Jt.CONSTRUCTION_SITE_USE.V && c.push(E);
      });
    }
    return c;
  }), partyAOutboundTypeOptions: Ee(() => {
    const c = [];
    if (A(o.state.wms.outboundCfg) && o.state.wms.outboundCfg.outboundType) {
      const u = Ra.getBits(Jt.ENUM, o.state.wms.outboundCfg.outboundType, "V") || [];
      [Jt.PRODUCE].forEach((E) => {
        u.includes(E.V) && c.push(E);
      });
    }
    return c;
  }), rejectCfg: Ee(() => o.state.wms.rejectCfg), reportCfg: Ee(() => o.state.wms.reportCfg), partyABorrowReturnCfg: Ee(() => o.state.wms.partyABorrowReturnCfg), basicShowCfg: Ee(() => o.state.wms.basicShowCfg), materialWeightingCfg: Ee(() => o.state.wms.materialWeightingCfg), returnCfg: Ee(() => o.state.wms.returnCfg), inventoryLossCfg: Ee(() => o.state.wms.inventoryLossCfg), coilPlateConvertList: Ee(() => o.state.wms.coilPlateConvertList), produceOutboundEditConf: Ee(() => o.state.wms.produceOutboundEditConf), priceAbnormal: Ee(() => o.state.wms.priceAbnormal) };
};
const AU = { key: 1 }, NU = { class: "material-info" }, LU = { class: "form-info" }, IU = { key: 2 }, CU = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object }, record: { type: Object } }, emits: ["success", "update:visible"], setup(e, { emit: o }) {
  const n = o, c = e, u = Ee(() => {
    const B = c.material;
    return console.log(B, "obj"), B.mete = B.frozenMete, B.quantity = B.frozenQuantity, B;
  }), r = Z(false), { visible: E, handleClose: y } = Ta({ emit: n, props: c, field: "visible", showHook: L }), { selfOutboundTypeOptions: b } = aa();
  yi("selfOutboundTypeOptions", b);
  const { outboundCfg: V, partyAOutboundTypeOptions: M } = aa();
  yi("outboundCfg", V), yi("partyAOutboundTypeOptions", M);
  const g = Ee(() => {
    var B;
    return (B = S.value) == null ? void 0 : B.enlargeWth;
  });
  Kt({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, g);
  const S = Z(), h = Ee(() => (console.log(c.record, "record"), c.material.outboundUnitType === hi.MEASURE.V ? c.record.quantity : c.record.mete));
  yi("maxQuantity", h);
  const T = (B, q, ae) => {
    if (Ae(q)) return ae(new Error("请填写数量"));
    if (q <= 0) return ae(new Error("数量必须大于0"));
    if (q > h.value) return ae(new Error("数量不可超过可操作数量"));
    ae();
  }, _ = (B, q, ae) => {
    R.value.invoiceType || R.value.invoiceType === 0 ? R.value.invoiceType === fi.SPECIAL.V && !R.value.taxRate ? ae(new Error("请选择税率")) : ae() : ae(new Error("请选择发票及税率")), ae();
  }, f = Ee(() => {
    let B = { quantity: [{ required: true, validator: T, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], thawingMethod: [{ require: true, message: "请选择解冻方式", trigger: "change" }] };
    return R.value.thawingMethod === oo.OUTBOUND.V && (B = Object.assign(B, { projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }] })), R.value.outboundTypeSelection === Jt.PRODUCE.V && (B = Object.assign(B, { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }] })), R.value.outboundTypeSelection === Jt.FOR_SALE.V && (B = Object.assign(B, { theoryTotalWeight: [{ required: true, message: "请输入理论重量", trigger: "blur" }], weighingWeight: [{ required: true, message: "请输入过磅重量", trigger: "blur" }], sellUnitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], sellAmount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], weightMeasurementMode: [{ required: true, message: "请选择计量方式", trigger: "change" }], unitPrice: [{ required: true, message: "请输入出售含税单价", trigger: "blur" }], amount: [{ required: true, message: "请输入出售含税金额", trigger: "blur" }], measuringMethod: [{ required: true, message: "请选择计量方式", trigger: "change" }], invoiceType: [{ required: true, validator: _, trigger: "change" }] })), B;
  }), m = Z(), R = Z({}), v = Ht();
  BD(m, R, ["quantity"]), Ce(() => c.record, (B) => {
    N(B);
  }, { immediate: true, deep: true });
  function N(B) {
    var ae;
    const q = { thawingMethod: oo.FREEZE.V, quantity: void 0, remark: void 0, outboundTypeSelection: Jt.PRODUCE.V, projectId: c.material.project ? c.material.project.id : void 0, materialId: c.material.id, weightMeasurementMode: Wt.THEORY.V, factoryId: (ae = c.material.factory) == null ? void 0 : ae.id, outboundUnit: c.material.outboundUnit, outboundUnitPrecision: c.material.outboundUnitPrecision, outboundAddress: So.FACTORY.V, recipientId: void 0 };
    B && (q.id = B.id, q.materialId = B.materialId, q.materialFreezeRecordId = B.id), R.value = q, L();
  }
  Ce(() => R.value.thawingMethod, (B) => {
    var q, ae, j, le;
    R.value.projectId = c.material.project ? c.material.project.id : void 0, B === oo.FREEZE.V ? R.value.materialId = (q = c.record) == null ? void 0 : q.id : R.value.materialId = (j = (ae = c.record) == null ? void 0 : ae.receipt) == null ? void 0 : j.id, R.value.factoryId = (le = c.material.factory) == null ? void 0 : le.id, R.value.outboundUnit = c.material.outboundUnit, R.value.outboundUnitPrecision = c.material.outboundUnitPrecision, R.value.outboundAddress = So.FACTORY.V, R.value.recipientId = void 0;
  }), Ce(() => R.value.outboundTypeSelection, (B) => {
    var ae;
    let q = { thawingMethod: R.value.thawingMethod, quantity: void 0, remark: void 0, outboundTypeSelection: R.value.outboundTypeSelection, projectId: c.material.project ? c.material.project.id : void 0, materialId: c.material.id, factoryId: (ae = c.material.factory) == null ? void 0 : ae.id, outboundUnit: c.material.outboundUnit, outboundUnitPrecision: c.material.outboundUnitPrecision, outboundAddress: So.FACTORY.V, recipientId: void 0 };
    if (B === Jt.FOR_SALE.V) {
      const j = { weightMeasurementMode: Wt.THEORY.V, quantity: void 0, sellUnitPrice: void 0, sellAmount: void 0, theoryTotalWeight: void 0, weighingWeight: void 0, invoiceType: fi.SPECIAL.V, inputMete: void 0, taxRate: void 0 };
      q = Object.assign(q, j);
    }
    R.value = q;
  });
  function P() {
    pt(() => {
      m.value && m.value.resetFields();
    });
  }
  function L(B) {
    pt(() => {
      m.value && m.value.clearValidate(B);
    });
  }
  const O = Ee(() => u.value.boolPartyA ? u.value.basicClass & ct.STEEL.V ? gD.outbound : u.value.basicClass & Ci.MATERIAL.V ? ED.outbound : u.value.basicClass & Ci.GAS.V ? TD.outbound : u.value.basicClass & Ci.OTHER.V ? yD.outbound : null : u.value.basicClass & ct.STEEL.V ? mD.outbound : u.value.basicClass & Ci.MATERIAL.V ? pD.outbound : u.value.basicClass & Ci.GAS.V ? fD.outbound : u.value.basicClass & Ci.OTHER.V ? hD.outbound : null), x = Ee(() => {
    switch (R.value.thawingMethod) {
      case oo.FREEZE.V:
        return mb;
      case oo.OUTBOUND.V:
        if (u.value.basicClass & Ci.STEEL_PLATE.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return YD;
        }
        else if (u.value.basicClass & Ci.SECTION_STEEL.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return KD;
        }
        else if (u.value.basicClass & Ci.STEEL_COIL.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return WD;
        }
        else if (u.value.basicClass & Ci.MATERIAL.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return pb;
        }
        else if (u.value.basicClass & Ci.GAS.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return jD;
        }
        else if (u.value.basicClass & Ci.OTHER.V) switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return FD;
        }
        else switch (R.value.outboundTypeSelection) {
          case Jt.OUTSOURCE.V:
            return us;
          case Jt.FOR_SALE.V:
            return I.value ? ss : rs;
          default:
            return pb;
        }
      default:
        return mb;
    }
  }), I = Z(false);
  async function Y(B) {
    var q, ae, j, le, oe;
    try {
      r.value = true, I.value = B, (q = c.record) != null && q.boolBatten && (R.value.quantity = h.value);
      const ye = await m.value.validate();
      if (await v.dispatch("approval_list/fetchApprovalNum"), !ye) return false;
      let ce = At(R.value);
      ce = { ...ce, boolPartyA: c.material.boolPartyA, outboundUnitType: c.material.outboundUnitType, unitNet: c.material.unitNet, outboundQuantity: c.material.outboundUnitType === hi.MEASURE.V ? ce.quantity : c.material.measureUnit && c.material.mete ? ce.quantity / c.material.mete * c.material.quantity : void 0, outboundMete: c.material.outboundUnitType === hi.MEASURE.V ? c.material.accountingUnit && c.material.quantity ? c.material.quantity / c.material.quantity * c.material.mete : void 0 : ce.quantity }, await Ut(ce, { basicClass: c.material.basicClass, measureUnit: c.material.measureUnit, measurePrecision: c.material.measurePrecision, accountingUnit: c.material.accountingUnit, accountingPrecision: c.material.accountingPrecision, toNum: true, toSmallest: true }, { quantity: ["outboundQuantity"], mete: ["inputMete", "outboundMete"], amount: ["sellUnitPrice"] });
      let se = { materialId: (j = (ae = c.record) == null ? void 0 : ae.receipt) == null ? void 0 : j.id, quantity: ce.outboundUnitType === hi.MEASURE.V ? ce.outboundQuantity : ce.outboundMete, remark: ce.remark, recipientId: ce.recipientId, measureUnit: c.material.measureUnit, measurePrecision: c.material.measurePrecision, accountingUnit: c.material.accountingUnit, accountingPrecision: c.material.accountingPrecision };
      if (ce.thawingMethod === oo.FREEZE.V) {
        const he = { id: (le = c.record) == null ? void 0 : le.id };
        se = Object.assign(se, he);
      } else {
        const he = { workshopId: ce.workshopId, outboundUnit: ce.outboundUnit, outboundUnitPrecision: ce.outboundUnitPrecision, outboundAddress: ce.outboundAddress, projectId: ce.projectId, outboundTypeSelection: ce.outboundTypeSelection, materialFreezeRecordId: (oe = c.record) == null ? void 0 : oe.id, boolPartyA: ce.boolPartyA };
        if (se = Object.assign(se, he), ce.thawingMethod === oo.OUTBOUND.V) {
          if (ce.outboundTypeSelection === Jt.OUTSOURCE.V) {
            const be = { purchaseId: ce.purchaseId, recipientId: ce.recipientId };
            se = Object.assign(se, be);
          }
          if (ce.outboundTypeSelection === Jt.FOR_SALE.V) {
            const be = { weightMeasurementMode: ce.weightMeasurementMode, sellUnitPrice: ce.sellUnitPrice, sellAmount: ce.sellAmount, invoiceType: ce.invoiceType, inputMete: ce.inputMete, taxRate: ce.taxRate, branchCompanyId: ce.branchCompanyId };
            se = Object.assign(se, be);
          }
        }
      }
      await x.value(se), n("success", ce), y(), P();
    } catch (ye) {
      console.log("解冻", ye);
    } finally {
      r.value = false;
    }
  }
  const ee = Ee(() => {
    switch (c.material.basicClass) {
      case Ci.STEEL_PLATE.V:
        return JS;
      case Ci.SECTION_STEEL.V:
        return XS;
      case Ci.STEEL_COIL.V:
        return $S;
      case Ci.MATERIAL.V:
        return dm;
      case Ci.GAS.V:
        return ev;
      default:
        return dm;
    }
  });
  return Ce(() => E.value, (B) => {
    B && N(c.record);
  }), (B, q) => {
    const ae = Ve("common-button"), j = Ve("common-radio"), le = Zi, oe = Li, ye = Ve("common-dialog");
    return w(), U(ye, { modelValue: l(E), "onUpdate:modelValue": q[3] || (q[3] = (ce) => Gt(E) ? E.value = ce : null), "before-close": l(y), "show-close": true, "custom-class": "wms-unfreeze-handling", title: "解冻办理", top: "2vh", width: "900px" }, { titleRight: p(() => [R.value.thawingMethod === l(oo).FREEZE.V ? (w(), U(ae, { key: 0, loading: r.value, size: "default", type: "primary", onClick: Y }, { default: p(() => q[4] || (q[4] = [Te(" 确认解冻 ")])), _: 1, __: [4] }, 8, ["loading"])) : (w(), Q("span", AU, [R.value.outboundTypeSelection && R.value.outboundTypeSelection !== l(Jt).PRODUCE.V ? (w(), U(ae, { key: 0, loading: r.value, size: "default", type: "primary", onClick: q[0] || (q[0] = (ce) => Y(true)) }, { default: p(() => q[5] || (q[5] = [Te(" 提交审核 ")])), _: 1, __: [5] }, 8, ["loading"])) : H("", true), s(ae, { loading: r.value, size: "default", type: "success", onClick: q[1] || (q[1] = (ce) => Y(false)) }, { default: p(() => q[6] || (q[6] = [Te(" 保存至出库清单 ")])), _: 1, __: [6] }, 8, ["loading"])]))]), default: p(() => [s(oe, { ref_key: "formRef", ref: m, model: R.value, rules: f.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: p(() => {
      var ce;
      return [C("div", NU, [(w(), U(Ri(ee.value), { material: u.value }, null, 8, ["material"]))]), C("div", LU, [((ce = e.record) == null ? void 0 : ce.freezeType) === l(fl).MANUAL.V && l(Ai)(O.value) ? (w(), U(le, { key: 0, label: "方式" }, { default: p(() => [s(j, { modelValue: R.value.thawingMethod, "onUpdate:modelValue": q[2] || (q[2] = (se) => R.value.thawingMethod = se), options: l(oo).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : H("", true), R.value.thawingMethod === l(oo).FREEZE.V ? (w(), U(FS, { key: 1, form: R.value, material: u.value, record: e.record }, null, 8, ["form", "material", "record"])) : (w(), Q("div", IU, [e.material.boolPartyA ? (w(), U(ZS, { key: 1, form: R.value, material: u.value }, null, 8, ["form", "material"])) : (w(), U(QS, { key: 0, form: R.value, material: u.value }, null, 8, ["form", "material"]))]))])];
    }), _: 1 }, 8, ["model", "rules"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, tv = ut(CU, [["__scopeId", "data-v-7a4aa502"]]), PU = Object.freeze(Object.defineProperty({ __proto__: null, default: tv }, Symbol.toStringTag, { value: "Module" }));
function OU(e) {
  return W({ module: "scm_V2", url: "apply-purchase", method: "get", params: e });
}
function kU(e) {
  return W({ module: "scm_V2", url: "apply-purchase/getTS", method: "get", params: e });
}
function iv(e) {
  return W({ module: "scm_V2", url: `apply-purchase/${e}`, method: "get" });
}
function DU(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
function xU(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
function UU(e) {
  return W({ module: "scm_V2", url: "apply-purchase", method: "delete", params: { id: e[0] } });
}
function xht() {
  return W({ module: "scm_V2", url: "apply-purchase/clearTS", method: "delete" });
}
function YU(e) {
  return W({ module: "scm_V2", url: "apply-purchase/brief", method: "get", params: e });
}
function KU(e) {
  return W({ url: "/api/v2/scm/apply-purchase/manufactured/brief", method: "get", params: e });
}
function av(e) {
  return W({ module: "scm_V2", url: "apply-purchase/can-purchase-detail", method: "get", params: e });
}
function WU(e) {
  return W({ module: "scm_V2", url: "apply-purchase/approval", method: "post", data: e });
}
function Uht(e) {
  return W({ module: "scm_V2", url: "apply-purchase/updatePurchaseCreationStateById", method: "post", data: e });
}
const Yht = { add: DU, edit: xU, del: UU, detail: iv, get: OU, getTS: kU };
function jU(e) {
  return W({ module: "wms", url: "inbound/application/review/raw-materials", method: "get", params: e });
}
function lv(e) {
  return W({ module: "wms", url: `inbound/application/review/raw-materials/${e}`, method: "get" });
}
function Kht(e) {
  return W({ module: "wms", url: "inbound/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function Wht(e) {
  return W({ module: "wms", url: "inbound/application/review/raw-materials/returned", method: "put", data: e });
}
function jht(e) {
  return W({ module: "wms", url: "inbound/application/review/raw-materials/passed", method: "put", data: e });
}
const Fht = { get: jU, detail: lv };
function FU(e) {
  return W({ url: "/api/wms/outbound/manufactured/application/record", method: "get", params: e });
}
function ov(e) {
  return W({ module: "wms", url: `outbound/manufactured/application/record/${e}`, method: "get" });
}
const zht = { get: FU, detail: ov };
function zU(e) {
  return W({ module: "wms", url: "transfer/application/review/raw-materials", method: "get", params: e });
}
function nv(e) {
  return W({ module: "wms", url: `transfer/application/review/raw-materials/${e}`, method: "get" });
}
function Bht(e) {
  return W({ module: "wms", url: "transfer/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function Hht(e) {
  return W({ module: "wms", url: "transfer/application/review/raw-materials/returned", headers: { "Content-Type": "application/x-www-form-urlencoded" }, method: "put", data: e });
}
function qht(e) {
  return W({ module: "wms", url: "transfer/application/review/raw-materials/passed", method: "put", data: e });
}
const Ght = { get: zU, detail: nv };
function BU(e) {
  return W({ module: "wms", url: "move_material/application/review/raw-materials", method: "get", params: e });
}
function A_(e) {
  return W({ module: "wms", url: `move_material/raw-materials/${e}`, method: "get" });
}
function Qht(e) {
  return W({ module: "wms", url: "move_material/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function Zht(e) {
  return W({ module: "wms", url: "move_material/application/review/raw-materials/returned", headers: { "Content-Type": "application/x-www-form-urlencoded" }, method: "put", data: e });
}
function Jht(e) {
  return W({ module: "wms", url: "move_material/application/review/raw-materials/passed", method: "put", params: e });
}
function HU(e) {
  return W({ url: `/api/wms/move_material/revocation/${e.id}`, method: "post" });
}
function qU(e) {
  return W({ url: "/api/wms/move_material/review", method: "put", params: e });
}
