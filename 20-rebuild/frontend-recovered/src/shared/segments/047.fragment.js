const xY = { style: { "overflow-x": "auto", width: "100%" } }, UY = { class: "customize-option-item" }, YY = { class: "flex-rsc label" }, KY = { key: 0, class: "extra-label" }, WY = { key: 1 }, jY = { __name: "index", props: { modelValue: { type: [Number, String] }, basicClass: { type: Number }, logisticsCreateable: { type: Boolean, default: false }, showType: { type: Boolean, default: true }, type: { type: Number, default: vo.RAW_MATERIAL.V | vo.MANUFACTURED.V | vo.OTHER.V }, mode: { type: String, default: "contained" }, typeMode: { type: String, default: "cross" }, showHide: { type: Boolean, default: false }, size: { type: String, default: "default" }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, collapseTags: { type: Boolean, default: false }, default: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择供应商" } }, emits: ["change", "info-change", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, u = { add: ["scm_supplier:add"] }, r = Z(false), E = Z(), { loaded: y, suppliers: b, supplierKV: V } = hu(h), M = Ee(() => {
    const f = c.showHide ? b.value : b.value.filter((m) => m.boolHide === ru.FALSE.V);
    if (c.basicClass) {
      if (c.mode === "contained") return f.filter((m) => (m.basicClass & c.basicClass) === m.basicClass);
      if (c.mode === "contain") return f.filter((m) => (m.basicClass & c.basicClass) === c.basicClass);
      if (c.mode === "cross") return f.filter((m) => m.basicClass & c.basicClass);
    }
    if (c.type) {
      if (c.typeMode === "contained") return f.filter((m) => (m.type & c.type) === m.type);
      if (c.typeMode === "contain") return f.filter((m) => (m.type & c.type) === c.type);
      if (c.typeMode === "cross") return f.filter((m) => m.type & c.type);
    }
    return f;
  });
  Ce(() => c.modelValue, (f) => {
    E.value = f;
  }, { immediate: true });
  function g(f) {
    let m = f;
    Ae(m) && (m = void 0);
    const R = !el(m, c.modelValue), v = Ae(m) && Ae(c.modelValue);
    R && !v && (n("update:modelValue", m), n("change", m), S(m, c.modelValue));
  }
  function S(f, m) {
    const R = f ? V.value[f] : null, v = m ? V.value[m] : null;
    n("info-change", R, v);
  }
  function h() {
    A(E.value) ? S(E.value) : _();
  }
  function T() {
    r.value = false;
  }
  function _() {
    pt(() => {
      if (!(Ae(M.value) || E.value) && c.default) {
        E.value = M.value[0].id, g(E.value);
        return;
      }
    });
  }
  return (f, m) => {
    const R = Ve("common-select-v2"), v = Wm, N = ml, P = La, L = _t("parse-enum"), O = _t("permission");
    return w(), Q("span", { class: Zt(["supplier-sn-select-container", { "show-add-icon": c.logisticsCreateable }]) }, [s(R, { modelValue: E.value, "onUpdate:modelValue": m[0] || (m[0] = (x) => E.value = x), size: c.size, disabled: c.disabled, multiple: c.multiple, "collapse-tags": c.collapseTags, loading: !l(y), clearable: c.clearable, filterable: c.filterable, placeholder: c.placeholder, options: M.value, class: "supplier-sn-select", onChange: g }, { view: p(({ data: x }) => [C("div", xY, [C("span", UY, [C("span", YY, [C("span", null, K(x.name), 1)]), C("span", null, [c.showType ? (w(), Q("span", KY, [m[3] || (m[3] = C("span", { class: "title" }, "类型：", -1)), qe(C("span", null, null, 512), [[L, { e: l(wn), v: x.basicClass, bit: true, split: " | " }]])])) : H("", true)])])])]), _: 1 }, 8, ["modelValue", "size", "disabled", "multiple", "collapse-tags", "loading", "clearable", "filterable", "placeholder", "options"]), s(P, { visible: r.value, "onUpdate:visible": m[2] || (m[2] = (x) => r.value = x), placement: "top", width: "450" }, { reference: p(() => [c.logisticsCreateable ? (w(), Q("span", { key: 0, class: "add-icon pointer", onClick: m[1] || (m[1] = Pi((x) => r.value = !r.value, ["stop"])) }, [qe((w(), U(N, { color: "#1881ef" }, { default: p(() => [s(v)]), _: 1 })), [[O, u.add]])])) : (w(), Q("span", WY))]), default: p(() => [s(DY, { onClose: T })]), _: 1 }, 8, ["visible"])], 2);
  };
} }, k_ = ut(jY, [["__scopeId", "data-v-2c48631e"]]);
const FY = { key: 0, class: "logistics-form form" }, zY = { __name: "logistics-form", props: { disabled: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) }, showType: { type: String, default: "submit" }, editFreight: { type: Boolean, default: false } }, setup(e, { expose: o }) {
  const n = e, { inboundFillWayCfg: c } = aa(), u = Z(), r = Z({});
  Dt(() => {
    r.value = n.form;
  });
  const E = Ee(() => n.showType === "submit" && (y.value || b.value || V.value || M.value || g.value) || n.showType !== "submit"), y = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.money === m : true;
  }), b = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.weight === m : true;
  }), V = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.loadingFee === m : true;
  }), M = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.invoiceTax === m : true;
  }), g = Ee(() => {
    const m = n.showType === "submit" ? Aa.INVENTORY_SUBMISSION.V : Aa.INVENTORY_REVIEW.V;
    return c.value ? c.value.logisticsUnit === m : true;
  }), _ = { freight: [{ validator: (m, R, v) => {
    (n.showType === "submit" || n.showType === "audit" && n.editFreight) && Ae(r.value.freight) && v(new Error("请输入运费")), v();
  }, message: "请输入运费", trigger: "blur" }], freightWeight: [{ validator: (m, R, v) => {
    (n.showType === "submit" || n.showType === "audit" && n.editFreight) && A(r.value.freightWeight) && (r.value.freightWeight || v(new Error("运输重量必须大于0"))), v();
  }, trigger: "blur" }], supplierId: [{ validator: (m, R, v) => {
    (n.showType === "submit" || n.showType === "audit" && n.editFreight) && A(r.value.freight) && Ae(r.value.supplierId) && v(new Error("请选择供应商")), v();
  }, trigger: "change" }] };
  async function f() {
    try {
      return u.value ? await u.value.validate() : true;
    } catch {
      return false;
    }
  }
  return o({ validate: f }), (m, R) => {
    const v = Ml, N = Ve("common-input-number"), P = Zi, L = Li;
    return E.value ? (w(), Q("div", FY, [s(v, null, { default: p(() => R[6] || (R[6] = [C("span", { class: "title" }, "物流信息", -1)])), _: 1, __: [6] }), s(L, { ref_key: "formRef", ref: u, model: r.value, disabled: n.disabled, rules: _, size: "default", inline: "", "label-position": "right", "label-width": "80px" }, { default: p(() => [e.showType === "submit" && y.value || e.showType !== "submit" ? (w(), U(P, { key: 0, label: "运费", prop: "freight", "label-width": "60px" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.freight, "onUpdate:modelValue": R[0] || (R[0] = (O) => r.value.freight = O), type: "text", min: 0, max: 999999999, disabled: !y.value || e.showType === "audit" && !e.editFreight, precision: l(Ze).YUAN, controls: false, placeholder: "运费", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && b.value || e.showType !== "submit" ? (w(), U(P, { key: 1, label: "运输重量（kg）", prop: "freightWeight", "label-width": "120px" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.freightWeight, "onUpdate:modelValue": R[1] || (R[1] = (O) => r.value.freightWeight = O), type: "text", disabled: !b.value || e.showType === "audit" && !e.editFreight, min: 0, max: 999999999, precision: l(Ze).COM_WT__KG, controls: false, placeholder: "运输重量", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && V.value || e.showType !== "submit" ? (w(), U(P, { key: 2, label: "装车费", prop: "loadingCharge" }, { default: p(() => [s(N, { class: "input-underline", modelValue: r.value.loadingCharge, "onUpdate:modelValue": R[2] || (R[2] = (O) => r.value.loadingCharge = O), min: 0, max: 999999999, disabled: !V.value || e.showType === "audit" && !e.editFreight, precision: l(Ze).YUAN, controls: false, size: "default", placeholder: "装车费", style: { width: "150px" } }, null, 8, ["modelValue", "disabled", "precision"])]), _: 1 })) : H("", true), e.showType === "submit" && M.value || e.showType !== "submit" ? (w(), U(P, { key: 3, class: "el-form-item-10", label: "发票及税率", prop: "invoiceType", "label-width": "100px" }, { default: p(() => [s(Xn, { class: "input-underline", invoiceType: r.value.invoiceType, "onUpdate:invoiceType": R[3] || (R[3] = (O) => r.value.invoiceType = O), taxRate: r.value.taxRate, "onUpdate:taxRate": R[4] || (R[4] = (O) => r.value.taxRate = O), disabled: r.value.boolUsed || !M.value || e.showType === "audit" && !e.editFreight, classification: l(Yn).LOGISTICS.V, default: (e.showType === "submit" || e.showType === "audit" && e.editFreight) && M.value, taxDefault: (e.showType === "submit" || e.showType === "audit" && e.editFreight) && M.value }, null, 8, ["invoiceType", "taxRate", "disabled", "classification", "default", "taxDefault"])]), _: 1 })) : H("", true), e.showType === "submit" && g.value || e.showType !== "submit" ? (w(), U(P, { key: 4, label: "物流单位", prop: "supplierId" }, { default: p(() => [s(k_, { class: "input-underline", modelValue: r.value.supplierId, "onUpdate:modelValue": R[5] || (R[5] = (O) => r.value.supplierId = O), type: l(vo).LOGISTICS.V, disabled: !g.value || e.showType === "audit" && !e.editFreight, placeholder: "可选择供应商搜索", style: { width: "250px" }, "logistics-createable": "", "show-type": false, clearable: "" }, null, 8, ["modelValue", "type", "disabled"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["model", "disabled"])])) : H("", true);
  };
} }, cd = ut(zY, [["__scopeId", "data-v-51e2ba61"]]), BY = Object.freeze(Object.defineProperty({ __proto__: null, default: cd }, Symbol.toStringTag, { value: "Module" })), wb = { __name: "raw-mat", props: { columns: { type: Object }, showUnitPriceE: { type: Boolean, default: false }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showInputVAT: { type: Boolean, default: true }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true }, showFreight: { type: Boolean, default: true }, inboundWay: { type: [Number, String] } }, setup(e) {
  const o = e, n = Ee(() => o.showInvoiceType && (Ae(o.columns) || o.columns.visible("invoiceType"))), c = Ee(() => o.showTaxRate && (Ae(o.columns) || o.columns.visible("taxRate"))), u = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("unitPrice"))), r = Ee(() => o.showAmountExcludingVAT && o.showUnitPriceE && (Ae(o.columns) || o.columns.visible("unitPriceExcludingVAT"))), E = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("amount"))), y = Ee(() => o.showAmountExcludingVAT && (Ae(o.columns) || o.columns.visible("amountExcludingVAT"))), b = Ee(() => o.showInputVAT && (Ae(o.columns) || o.columns.visible("inputVAT"))), V = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("unitPriceNoFreight"))), M = Ee(() => o.showAmountExcludingVAT && o.showUnitPriceE && (Ae(o.columns) || o.columns.visible("unitPriceExcludingVATNoFreight"))), g = Ee(() => o.showAmount && (Ae(o.columns) || o.columns.visible("amountNoFreight"))), S = Ee(() => o.showAmountExcludingVAT && (Ae(o.columns) || o.columns.visible("amountExcludingVATNoFreight"))), h = Ee(() => o.showInputVAT && (Ae(o.columns) || o.columns.visible("inputVATNoFreight")));
  return (T, _) => {
    const f = vt;
    return w(), Q(Qe, null, [n.value ? (w(), U(f, { key: "invoiceType", align: "center", label: "票据类型", "min-width": "70px", prop: "invoiceType", "show-overflow-tooltip": "" })) : H("", true), c.value ? (w(), U(f, { key: "taxRate", align: "center", label: "税率", "min-width": "70", prop: "taxRate", "show-overflow-tooltip": "" })) : H("", true), e.inboundWay !== l(si).OPENING_RECEIPT.V && V.value ? (w(), U(f, { key: "unitPriceNoFreight", align: "right", label: "含税单价", "min-width": "90px", prop: "unitPriceNoFreight", "show-overflow-tooltip": "" })) : H("", true), g.value ? (w(), U(f, { key: "amountNoFreight", align: "right", label: "含税金额", "min-width": "105px", prop: "amountNoFreight", "show-overflow-tooltip": "" })) : H("", true), M.value ? (w(), U(f, { key: "unitPriceExcludingVATNoFreight", align: "right", label: "不含税单价", "min-width": "90px", prop: "unitPriceExcludingVATNoFreight", "show-overflow-tooltip": "" })) : H("", true), S.value ? (w(), U(f, { key: "amountExcludingVATNoFreight", align: "right", label: "不含税金额", "min-width": "105px", prop: "amountExcludingVATNoFreight", "show-overflow-tooltip": "" })) : H("", true), e.inboundWay !== l(si).OPENING_RECEIPT.V && h.value ? (w(), U(f, { key: "inputVATNoFreight", align: "right", label: "进项税", "min-width": "90px", prop: "inputVATNoFreight", "show-overflow-tooltip": "" })) : H("", true), u.value && e.showFreight ? (w(), U(f, { key: "unitPrice", label: `含税单价
(含运费装车费)`, align: "right", "min-width": "160px", prop: "unitPrice", "show-overflow-tooltip": "" })) : H("", true), E.value && e.showFreight ? (w(), U(f, { key: "amount", label: `含税金额
(含运费装车费)`, align: "right", "min-width": "130px", prop: "amount", "show-overflow-tooltip": "" })) : H("", true), r.value && e.showFreight ? (w(), U(f, { key: "unitPriceExcludingVAT", label: `不含税单价
(含运费装车费)`, align: "right", "min-width": "130px", prop: "unitPriceExcludingVAT", "show-overflow-tooltip": "" })) : H("", true), y.value && e.showFreight ? (w(), U(f, { key: "amountExcludingVAT", label: `不含税金额
(含运费装车费)`, align: "right", "min-width": "130px", prop: "amountExcludingVAT", "show-overflow-tooltip": "" })) : H("", true), b.value && e.showFreight ? (w(), U(f, { key: "inputVAT", label: `进项税
(含运费装车费)`, align: "right", "min-width": "120px", prop: "inputVAT", "show-overflow-tooltip": "" })) : H("", true)], 64);
  };
} }, dc = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showInvoiceType: { type: Boolean, default: false }, showTaxRate: { type: Boolean, default: false }, showAmount: { type: Boolean, default: true }, showAmountExcludingVAT: { type: Boolean, default: true }, showFreight: { type: Boolean, default: true }, inboundWay: { type: [Number, String] } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return wb;
      default:
        return wb;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { columns: e.columns, "inbound-way": e.inboundWay, "show-amount": e.showAmount, "show-amount-excluding-v-a-t": e.showAmountExcludingVAT, "show-freight": e.showFreight, "show-invoice-type": e.showInvoiceType, "show-tax-rate": e.showTaxRate }, null, 8, ["columns", "inbound-way", "show-amount", "show-amount-excluding-v-a-t", "show-freight", "show-invoice-type", "show-tax-rate"]));
} };
const HY = { __name: "pagination", props: { pageSizes: { type: Array, default: () => [10, 20, 30, 40, 50, 100, 200, 500] }, total: { type: [String, Number] }, currentPage: { type: [String, Number], default: 1 }, pageSize: { type: [String, Number], default: 20 } }, emits: ["update:sizeChange", "update:pageChange"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(1), r = Z(20);
  Ce([() => c.currentPage, () => c.pageSize], ([b, V]) => {
    u.value = b, r.value = V;
  }, { immediate: true, deep: true });
  function E(b) {
    n("update:sizeChange", b);
  }
  function y(b) {
    n("update:pageChange", b);
  }
  return (b, V) => {
    const M = Fn;
    return w(), U(M, { "current-page": u.value, "onUpdate:currentPage": V[0] || (V[0] = (g) => u.value = g), "page-size": r.value, "onUpdate:pageSize": V[1] || (V[1] = (g) => r.value = g), "page-sizes": c.pageSizes, total: c.total, layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: E, onCurrentChange: y }, null, 8, ["current-page", "page-size", "page-sizes", "total"]);
  };
} }, mc = ut(HY, [["__scopeId", "data-v-6d34b553"]]), qY = Object.freeze(Object.defineProperty({ __proto__: null, default: mc }, Symbol.toStringTag, { value: "Module" }));
const GY = { key: 0, class: "footer" }, QY = { key: 3 }, ZY = { class: "inventory" }, JY = { class: "right-box" }, XY = { key: 1 }, $Y = { key: 1 }, eK = { class: "head-container", style: { "margin-top": "15px" } }, tK = { key: 1 }, iK = { key: 1 }, aK = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, { decimalPrecision: u } = Ln(), r = ft("permission"), E = Z([]), y = Z([]), b = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", u.value.wms]], ["unitPriceNoFreight", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["amountNoFreight", ["to-thousand", Ze.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["inputVATNoFreight", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), V = Z(), M = Z([]), { CRUD: g, crud: S, detail: h } = qi(), { inboundFillWayCfg: T } = aa(), _ = Z(), f = Z(), m = Z(false), R = Ee(() => {
    var G;
    let F = 0;
    return (G = h.list) == null || G.forEach((ie) => {
      F += Number(ie.mete) || 0;
    }), Be(F, ei.weight.precision);
  }), { maxHeight: v } = Kt({ mainBox: ".raw-mat-inbound-application-record-preview", extraBox: [".el-drawer__header", ".inspection-return-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 40 }, () => Ee(() => !S.detailLoading)), N = Ee(() => h.purchaseOrder || {}), P = Ee(() => h.reviewStatus === Lt.PASS.V && N.value.logisticsPayerType === Bi.DEMAND.V), L = Ee(() => A(T.value) ? Ae(N.value.details) && T.value.amountFillWay === $l.REVIEWING.V || A(N.value.details) && T.value.passedInboundState === Sl.MODIFY.V : false), O = Ee(() => Ai(r.showAmount) && (Ae(N.value.details) || A(N.value.details) && (T.value.passedInboundState === Sl.MODIFY.V || T.value.passedInboundState === Sl.SHOW.V))), x = Z(Lt.PASS.V), I = Ee(() => (h == null ? void 0 : h.supplyType) === Ni.PARTY_A.V), Y = Ee(() => h.basicClass & va.MANUFACTURED.V), ee = Ee(() => N.value.logisticsPayerType === Bi.DEMAND.V), B = Ee(() => h.inboundWay === si.OPENING_RECEIPT.V);
  yi("isBegin", B);
  const q = Ee(() => B.value ? S.detailLoading ? "入库单" : `入库单：${h.serialNumber}` : S.detailLoading ? "入库单" : `入库单：${h.serialNumber}（ ${N.value.supplier ? N.value.supplier.name : "无供应商"} ）`), ae = Ee(() => {
    const F = O.value && !I.value && N.value.projects && N.value.requisitionsSN, G = O.value && I.value && N.value.projects && N.value.requisitionsSN;
    return !(F || G);
  });
  g.HOOK.beforeDetailLoaded = async (F, G) => {
    if (_.value = void 0, G.list.map((ie) => {
      ie.originUnitPrice = ie.unitPrice, ie.originAmount = ie.amount;
    }), await Qt(G.list), G.list = await Ut(G.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] }), G.qualityTestingEnum & Pl.UNREVIEWED.V) {
      y.value = [], E.value = [], G.list.forEach((ie) => {
        ie.weightMeasurementMode === Wt.OVERWEIGHT.V && (ie.basicClass & Ge.STEEL_PLATE.V || ie.basicClass & Ge.SECTION_STEEL.V) ? y.value.push(ie) : E.value.push(ie);
      });
      return;
    }
    G.originList = At(G.list), G.list = G.originList.filter((ie) => ie.qualityTestingEnum & (Pl.ALL_PASS.V | Pl.NO.V)), y.value = [], E.value = [], G.list.forEach((ie) => {
      ie.weightMeasurementMode === Wt.OVERWEIGHT.V && (ie.basicClass & Ge.STEEL_PLATE.V || ie.basicClass & Ge.SECTION_STEEL.V) ? y.value.push(ie) : E.value.push(ie);
    }), G.returnList = G.originList.filter((ie) => ie.qualityTestingEnum & Pl.ALL_REFUSE.V), G.logistics = A(G.logistics) ? G.logistics : {}, G.originLogistics = A(G.logistics) ? At(G.logistics) : {};
  };
  function j(F) {
    return Hi({ ...F, data: $.value || [] }, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN], ["amountNoFreight", Ze.YUAN], ["amountExcludingVATNoFreight", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight", "amountExcludingVATNoFreight"] });
  }
  function le(F) {
    return Hi({ ...F, data: z.value || [] }, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN], ["amountNoFreight", Ze.YUAN], ["amountExcludingVATNoFreight", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight", "amountExcludingVATNoFreight"] });
  }
  const oe = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, ye = Ee(() => {
    const F = {};
    return L.value && !I.value && h.editMoney && x.value === Lt.PASS.V && Object.assign(F, oe), F;
  }), { tableValidate: ce, cleanUpData: se, wrongCellMask: he } = ui({ rules: ye });
  async function be() {
    let F = true;
    if (A(E.value)) {
      const { validResult: ue, dealList: ne } = ce(E.value);
      ue && (E.value = ne), F = ue;
    }
    let G = true;
    if (A(y.value)) {
      const { validResult: ue, dealList: ne } = ce(y.value);
      ue && (y.value = ne), G = ue;
    }
    let ie = true;
    return ee.value && f.value && (ie = await f.value.validate()), F && G && ie;
  }
  async function me(F) {
    return se(F.list), F.list = await Ut(F.list, { toSmallest: true, toNum: true }), F;
  }
  async function ge(F) {
    var G, ie, ue, ne, te, de, pe, re, we, Ke, Me, Ne, He, ze, Oe, Re, fe, Ue, Je;
    try {
      m.value = true, x.value = F;
      const Xe = c.componentName === at.INBOUND_PARTY_A.V ? _S : uv;
      let Ye = true;
      if (F === Lt.REFUSE.V ? (Ye = true, Ae(_.value) && (ot.error("请输入审批意见"), Ye = false)) : Ye = await be(h), !Ye) return;
      const Fe = At(h);
      E.value.forEach((gt) => {
        const qt = Fe.list.find((kt) => kt.id === gt.id);
        A(qt) && (qt.amount = gt.amount, qt.unitPrice = gt.unitPrice);
      }), y.value.forEach((gt) => {
        const qt = Fe.list.find((kt) => kt.id === gt.id);
        A(qt) && (qt.amount = gt.amount, qt.unitPrice = gt.unitPrice);
      });
      let et = await me(Fe);
      if (((G = N.value) == null ? void 0 : G.logisticsPayerType) === Bi.SUPPLIER.V && (et.logistics = void 0), Ae(et.logistics)) et.logistics = null;
      else {
        const gt = {};
        ((ie = et.originLogistics) == null ? void 0 : ie.freight) !== ((ue = et.logistics) == null ? void 0 : ue.freight) && (gt.freight = (ne = et.logistics) == null ? void 0 : ne.freight), ((te = et.originLogistics) == null ? void 0 : te.freightWeight) !== ((de = et.logistics) == null ? void 0 : de.freightWeight) && (gt.freightWeight = (pe = et.logistics) == null ? void 0 : pe.freightWeight), ((re = et.originLogistics) == null ? void 0 : re.loadingCharge) !== ((we = et.logistics) == null ? void 0 : we.loadingCharge) && (gt.loadingCharge = (Ke = et.logistics) == null ? void 0 : Ke.loadingCharge), ((Me = et.originLogistics) == null ? void 0 : Me.invoiceType) !== ((Ne = et.logistics) == null ? void 0 : Ne.invoiceType) && (gt.invoiceType = (He = et.logistics) == null ? void 0 : He.invoiceType), ((ze = et.originLogistics) == null ? void 0 : ze.taxRate) !== ((Oe = et.logistics) == null ? void 0 : Oe.taxRate) && (gt.taxRate = (Re = et.logistics) == null ? void 0 : Re.taxRate), ((fe = et.originLogistics) == null ? void 0 : fe.supplierId) !== ((Ue = et.logistics) == null ? void 0 : Ue.supplierId) && (gt.supplierId = (Je = et.logistics) == null ? void 0 : Je.supplierId), Ae(gt) ? et.logistics = null : et.logistics = gt;
      }
      const lt = { approveRecordId: h.approveRecordId, decision: F, opinion: _.value }, bt = [];
      h.editMoney && (et.list.map((gt) => {
        (gt.originUnitPrice !== gt.unitPrice || gt.originAmount !== gt.amount) && bt.push({ amount: gt.amount, id: gt.id, unitPrice: gt.unitPrice });
      }), et.inboundDetailMoneyDTOParams = bt), F === Lt.REFUSE.V && (et = { id: h.id }), await Xe(lt, et), n("auditSuccess");
    } catch (Xe) {
      console.log("入库审核提交", Xe);
    } finally {
      m.value = false;
    }
  }
  function Le(F, G) {
    Ho(F) > 10 && (G.unitPrice = Be(F, 10), F = G.unitPrice), G.amount = A(F) ? Be(F * G.mete, 2) : void 0;
  }
  function Ie(F, G) {
    G.unitPrice = A(F) ? Be(F / G.mete, 10) : void 0;
  }
  const Se = Z(1), X = Z(20), $ = Ee(() => (E.value || []).slice((Se.value - 1) * X.value, Se.value * X.value)), k = Z(1), J = Z(20), z = Ee(() => (y.value || []).slice((k.value - 1) * J.value, k.value * J.value));
  return (F, G) => {
    const ie = wi, ue = Ve("common-button"), ne = pa, te = La, de = qa, pe = Ga, re = Ml, we = Ve("common-input-number"), Ke = vt, Me = Ve("common-table"), Ne = Mt, He = Ve("common-drawer");
    return w(), U(He, { ref_key: "drawerRef", ref: V, "before-close": l(S).cancelDetail, "content-loading": l(S).detailLoading, "show-close": true, title: q.value, visible: l(S).detailVisible, "custom-class": "raw-mat-inbound-application-review-detail", size: "100%" }, { titleAfter: p(() => {
      var ze;
      return [s(ie, null, { default: p(() => [Te(K(l(h).supplyType === 1 ? "自购" : "甲供"), 1)]), _: 1 }), s(C_, { detail: l(h), order: N.value }, null, 8, ["detail", "order"]), s(ie, { type: (ze = l(Lt).V[l(h).reviewStatus]) == null ? void 0 : ze.TAG }, { default: p(() => [Te(K(l(Lt).VL[l(h).reviewStatus]), 1)]), _: 1 }, 8, ["type"]), s(ie, { effect: "plain" }, { default: p(() => [Te("入库时间：" + K(l(Qi)(l(h).createTime, "{y}-{m}-{d}")), 1)]), _: 1 })];
    }), titleRight: p(() => {
      var ze;
      return [c.ApprovalFlag ? (w(), Q("div", GY, [s(ne, { title: "确认通过", onConfirm: G[0] || (G[0] = (Oe) => ge(l(Lt).PASS.V)) }, { reference: p(() => [s(ue, { class: "filter-item", size: "default", type: "success", loading: m.value }, { default: p(() => G[9] || (G[9] = [Te("通过")])), _: 1, __: [9] }, 8, ["loading"])]), _: 1 }), s(ne, { title: "确认驳回", onConfirm: G[1] || (G[1] = (Oe) => ge(l(Lt).REFUSE.V)) }, { reference: p(() => [s(ue, { class: "filter-item", size: "default", type: "danger", loading: m.value }, { default: p(() => G[10] || (G[10] = [Te(" 驳回 ")])), _: 1, __: [10] }, 8, ["loading"])]), _: 1 })])) : H("", true), ((ze = l(h).wmsApproveRecordFlowDTOS) == null ? void 0 : ze.length) !== 0 ? (w(), U(te, { key: 1, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(ue, { size: "default" }, { default: p(() => G[11] || (G[11] = [Te("查看审批记录")])), _: 1, __: [11] })]), default: p(() => [s(tl, { data: l(h).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), s(br, { "purchase-id": N.value.id, size: "default" }, null, 8, ["purchase-id"])];
    }), content: p(() => {
      var ze, Oe, Re;
      return [l(A)(l(h).purchaseOrder) ? (w(), U(pe, { key: 0, column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(de, { label: "采购合同号", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe;
        return [Te(K((fe = l(h).purchaseOrder) == null ? void 0 : fe.serialNumber), 1)];
      }), _: 1 }), s(de, { label: "供应商", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe, Ue;
        return [Te(K((Ue = (fe = l(h).purchaseOrder) == null ? void 0 : fe.supplier) == null ? void 0 : Ue.name), 1)];
      }), _: 1 }), s(de, { label: "合同额", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe;
        return [Te(K(l(Mi)((fe = l(h).purchaseOrder) == null ? void 0 : fe.amount, l(Ze).YUAN)), 1)];
      }), _: 1 }), s(de, { label: "累计入库额(元)", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).sumAmount), 1)]), _: 1 }), s(de, { label: "采购创建人", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe;
        return [Te(K((fe = l(h).purchaseOrder) == null ? void 0 : fe.applicantName), 1)];
      }), _: 1 }), s(de, { label: "办理人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).applicantName), 1)]), _: 1 }), s(de, { label: "质检人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).qualityTestingEnum ? l(h).qualityTestingEnum === l(Pl).NO.V ? "无需质检" : l(h).qualityTestingUserName : "-"), 1)]), _: 1 }), l(A)(l(h).logistics) ? (w(), Q(Qe, { key: 0 }, [N.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(de, { key: 0, label: "运输费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe;
        return [Te(K((fe = l(h).logistics) == null ? void 0 : fe.freightInitial), 1)];
      }), _: 1 })) : H("", true), N.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(de, { key: 1, label: "装车费(元)", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe;
        return [Te(K((fe = l(h).logistics) == null ? void 0 : fe.loadingCharge), 1)];
      }), _: 1 })) : H("", true), N.value.logisticsPayerType === l(Bi).DEMAND.V ? (w(), U(de, { key: 2, label: "物流费发票及税率", "label-class-name": "contractLabel" }, { default: p(() => {
        var fe, Ue, Je;
        return [Te(K((fe = l(h).logistics) != null && fe.invoiceType ? l(fi).VL[(Ue = l(h).logistics) == null ? void 0 : Ue.invoiceType] + "【" + ((Je = l(h).logistics) == null ? void 0 : Je.taxRate) + "%】" : "-"), 1)];
      }), _: 1 })) : H("", true)], 64)) : H("", true), l(A)(l(h).logistics) && l(A)(l(h).logistics.freightWeight) ? (w(), U(de, { key: 1, label: "运输重量", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).logistics.freightWeight) + " " + K(l(ei).weight.unit), 1)]), _: 1 })) : H("", true), l(A)(l(h).logistics) && l(A)(l(h).logistics.supplierName) ? (w(), U(de, { key: 2, label: "物流单位", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).logistics.supplierName), 1)]), _: 1 })) : H("", true)]), _: 1 })) : (w(), U(pe, { key: 1, column: 3, border: "", style: { "margin-bottom": "10px" } }, { default: p(() => [s(de, { label: "录入办理人", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(l(h).applicantName), 1)]), _: 1 }), s(de, { label: "本次入库", "label-class-name": "contractLabel" }, { default: p(() => [Te(K(R.value), 1)]), _: 1 })]), _: 1 })), (ze = l(h).returnList) != null && ze.length ? (w(), U(P_, { key: 2, "basic-class": l(h).basicClass, boolPartyA: I.value, list: l(h).returnList, showAmount: O.value, showTableColumnSecondary: ae.value, class: "inspection-return-info" }, null, 8, ["basic-class", "boolPartyA", "list", "showAmount", "showTableColumnSecondary"])) : H("", true), s(re, null, { default: p(() => G[12] || (G[12] = [C("span", { class: "title" }, "入库明细", -1)])), _: 1, __: [12] }), l(h).basicClass & l(sl) ? (w(), Q("div", QY, [C("div", ZY, [G[13] || (G[13] = C("div", { class: "left-box" }, " 汇总 ", -1)), C("div", JY, K(R.value || 0) + K(l(ei).weight.unit), 1)])])) : H("", true), l(A)(E.value) ? (w(), Q(Qe, { key: 4 }, [s(ie, { type: "success", style: { "margin-bottom": "15px" } }, { default: p(() => G[14] || (G[14] = [Te("理计汇总")])), _: 1, __: [14] }), s(Me, { "cell-class-name": l(he), data: $.value, "data-format": b.value, "expand-row-keys": M.value, "max-height": l(v) - 180, "summary-method": j, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": M.value, "onUpdate:expandRowKeys": G[2] || (G[2] = (fe) => M.value = fe), data: l(h).list, fixed: "left", "row-key": "id" }, { default: p(({ row: fe }) => [ae.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": l(h).basicClass, row: fe, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [G[15] || (G[15] = Te(" 备注：")), C("span", null, K(fe.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(h).basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(za, { "basic-class": l(h).basicClass }, null, 8, ["basic-class"]), ae.value ? (w(), U(Ba, { key: 0, "basic-class": l(h).basicClass }, null, 8, ["basic-class"])) : H("", true), O.value && !I.value ? (w(), Q(Qe, { key: 1 }, [L.value && l(h).editMoney ? (w(), Q(Qe, { key: 0 }, [s(Ke, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, { default: p(({ row: { sourceRow: fe } }) => [fe && c.ApprovalFlag ? (w(), U(we, { key: 0, modelValue: fe.unitPrice, "onUpdate:modelValue": (Ue) => fe.unitPrice = Ue, controls: false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (Ue) => Le(Ue, fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (w(), Q("span", XY, K(fe.unitPrice || "-"), 1))]), _: 1 }), s(Ke, { align: "center", label: "金额", prop: "amount", width: "135px" }, { default: p(({ row: { sourceRow: fe } }) => [fe && c.ApprovalFlag ? (w(), U(we, { key: 0, modelValue: fe.amount, "onUpdate:modelValue": (Ue) => fe.amount = Ue, controls: false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "金额", size: "default", onChange: (Ue) => Ie(Ue, fe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (w(), Q("span", $Y, K(fe.amount || "-"), 1))]), _: 1 })], 64)) : (w(), U(dc, { key: 1, "inbound-way": l(h).inboundWay, showFreight: P.value }, null, 8, ["inbound-way", "showFreight"]))], 64)) : H("", true), s(Ke, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), Y.value ? (w(), U(Ke, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (w(), U(xl, { key: 2 }))]), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"]), s(mc, { total: (Oe = E.value) == null ? void 0 : Oe.length, "size-change": X.value, "onUpdate:sizeChange": G[3] || (G[3] = (fe) => X.value = fe), "page-change": Se.value, "onUpdate:pageChange": G[4] || (G[4] = (fe) => Se.value = fe) }, null, 8, ["total", "size-change", "page-change"])], 64)) : H("", true), l(A)(y.value) ? (w(), Q(Qe, { key: 5 }, [C("div", eK, [s(ie, { class: "filter-item" }, { default: p(() => G[16] || (G[16] = [Te("磅计汇总")])), _: 1, __: [16] })]), s(Me, { "cell-class-name": l(he), data: z.value, "data-format": b.value, "expand-row-keys": M.value, "max-height": l(v), "summary-method": le, "row-key": "id", "show-summary": "" }, { default: p(() => {
        var fe;
        return [s(Ha, { "expand-row-keys": M.value, "onUpdate:expandRowKeys": G[5] || (G[5] = (Ue) => M.value = Ue), data: l(h).list, fixed: "left", "row-key": "id" }, { default: p(({ row: Ue }) => [ae.value ? H("", true) : (w(), U(Xl, { key: 0, "basic-class": l(h).basicClass, row: Ue, "show-brand": "" }, null, 8, ["basic-class", "row"])), C("p", null, [G[17] || (G[17] = Te(" 备注：")), C("span", null, K(Ue.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(h).basicClass, fixed: "left" }, null, 8, ["basic-class"]), s(za, { "basic-class": l(h).basicClass }, null, 8, ["basic-class"]), ae.value ? (w(), U(Ba, { key: 0, "basic-class": l(h).basicClass }, null, 8, ["basic-class"])) : H("", true), O.value && !I.value ? (w(), Q(Qe, { key: 1 }, [l(Ae)((fe = l(h).purchaseOrder) == null ? void 0 : fe.details) && L.value && l(h).editMoney ? (w(), Q(Qe, { key: 0 }, [s(Ke, { align: "center", label: "含税单价", prop: "unitPrice", width: "135px" }, { default: p(({ row: { sourceRow: Ue } }) => [Ue && c.ApprovalFlag ? (w(), U(we, { key: 0, modelValue: Ue.unitPrice, "onUpdate:modelValue": (Je) => Ue.unitPrice = Je, controls: false, max: 9999999999, min: 0, step: 1, placeholder: "含税单价", size: "default", onChange: (Je) => Le(Je, Ue) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (w(), Q("span", tK, K(Ue.unitPrice || "-"), 1))]), _: 1 }), s(Ke, { align: "center", label: "金额", prop: "amount", width: "135px" }, { default: p(({ row: { sourceRow: Ue } }) => [Ue && c.ApprovalFlag ? (w(), U(we, { key: 0, modelValue: Ue.amount, "onUpdate:modelValue": (Je) => Ue.amount = Je, controls: false, max: 9999999999, min: 0, precision: l(Ze).YUAN, step: 1, placeholder: "金额", size: "default", onChange: (Je) => Ie(Je, Ue) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (w(), Q("span", iK, K(Ue.amount || "-"), 1))]), _: 1 })], 64)) : (w(), U(dc, { key: 1, showFreight: P.value }, null, 8, ["showFreight"]))], 64)) : H("", true), s(Ke, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), Y.value ? (w(), U(Ke, { key: 3, align: "left", label: "仓库", "min-width": "120px", prop: "workshop.name", "show-overflow-tooltip": "" })) : (w(), U(xl, { key: 2 }))];
      }), _: 1 }, 8, ["cell-class-name", "data", "data-format", "expand-row-keys", "max-height"]), s(mc, { key: "overWeightList", total: (Re = y.value) == null ? void 0 : Re.length, "size-change": J.value, "onUpdate:sizeChange": G[6] || (G[6] = (fe) => J.value = fe), "page-change": k.value, "onUpdate:pageChange": G[7] || (G[7] = (fe) => k.value = fe) }, null, 8, ["total", "size-change", "page-change"])], 64)) : H("", true), c.ApprovalFlag ? (w(), Q(Qe, { key: 6 }, [ee.value ? (w(), U(cd, { key: 0, ref_key: "logisticsRef", ref: f, disabled: F.formDisabled, form: l(h).logistics, showType: "audit", editFreight: l(h).editFreight, class: "logistics-form-content" }, null, 8, ["disabled", "form", "editFreight"])) : H("", true), s(Ne, { modelValue: _.value, "onUpdate:modelValue": G[8] || (G[8] = (fe) => _.value = fe), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px", width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])], 64)) : H("", true)];
    }), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, D_ = ut(aK, [["__scopeId", "data-v-dd201a0b"]]), lK = Object.freeze(Object.defineProperty({ __proto__: null, default: D_ }, Symbol.toStringTag, { value: "Module" }));
const oK = { key: 1, class: "footer" }, nK = { key: 0 }, sK = { style: { color: "brown" } }, rK = { style: { color: "#3a8ee6" } }, uK = { key: 1 }, cK = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z([]), E = Z(), y = Z(false), b = Z([...Da, ["outboundAddress", ["parse-enum", So]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: V, crud: M, detail: g } = qi(), { maxHeight: S } = Kt({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !M.detailLoading)), h = Ee(() => {
    switch (g.outboundTypeSelection) {
      case Jt.PRODUCE.V:
      case Jt.OUTSOURCE.V:
      case Jt.FOR_SALE.V:
      case Jt.CONSTRUCTION_SITE_USE.V:
        return bS;
      default:
        return null;
    }
  }), T = Ee(() => g && g.applicationSN ? `出库申请单：${g.applicationSN}` : "出库申请单");
  V.HOOK.beforeDetailLoaded = async (R, v) => {
    E.value = void 0, await Qt(v.list), v.list.forEach((N) => {
      var P, L, O, x, I, Y, ee, B;
      N.branchCompany = (P = N.outboundDetailSellDTO) == null ? void 0 : P.branchCompany, N.inputMete = (L = N.outboundDetailSellDTO) == null ? void 0 : L.inputMete, N.invoiceType = (O = N.outboundDetailSellDTO) == null ? void 0 : O.invoiceType, N.sellAmount = (x = N.outboundDetailSellDTO) == null ? void 0 : x.sellAmount, N.sellUnitPrice = (I = N.outboundDetailSellDTO) == null ? void 0 : I.sellUnitPrice, N.taxRate = (Y = N.outboundDetailSellDTO) == null ? void 0 : Y.taxRate, N.weightMeasurementMode = (ee = N.outboundDetailSellDTO) == null ? void 0 : ee.weightMeasurementMode, N.purchaser = (B = N.outboundDetailSellDTO) == null ? void 0 : B.purchaser, N.basicClass & ct.STEEL.V && (N.theoryTotalWeight = N.weightMeasurementMode === Wt.THEORY.V ? N.inputMete : null, N.weighingWeight = N.weightMeasurementMode === Wt.OVERWEIGHT.V ? N.inputMete : null);
    }), v.list = await Ut(v.list, { toSmallest: false, toNum: true }, { unitNetCalcMete: "inputMete", mete: ["actualTheoryWeight", "mete", "inputMete", "theoryTotalWeight", "weighingWeight"], amount: ["unitPrice", "sellUnitPrice"] });
  };
  function _(R) {
    return Hi(R, { props: ["quantity", ["mete", ei.weight.precision], ["theoryTotalWeight", ei.weight.precision], ["weighingWeight", ei.weight.precision], "sellAmount"] });
  }
  async function f(R) {
    return R.list = await Ut(R.list, { toSmallest: true, toNum: true }), R;
  }
  async function m(R) {
    try {
      y.value = true;
      const v = At(g), N = await f(v);
      if (R === Lt.REFUSE.V && !A(E.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const P = { approveRecordId: g.approveRecordId, decision: R, opinion: E.value };
      await h.value(P, N), R === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), n("auditSuccess");
    } catch (v) {
      console.log("出库(审批流)审核提交", v);
    } finally {
      y.value = false;
    }
  }
  return (R, v) => {
    const N = wi, P = Ve("common-button"), L = La, O = pa, x = vt, I = jt, Y = Ve("common-table"), ee = Mt, B = Ve("common-drawer");
    return w(), U(B, { ref_key: "drawerRef", ref: u, "before-close": l(M).cancelDetail, "content-loading": l(M).detailLoading, "show-close": true, title: T.value, visible: l(M).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: p(() => [l(g).applicant ? (w(), U(N, { key: 0, effect: "dark", type: "success" }, { default: p(() => [Te(K(`申请人：${l(g).applicant.name} | ${l(g).applicant.deptName}`), 1)]), _: 1 })) : H("", true), s(N, { effect: "plain" }, { default: p(() => [Te(K(`出库申请时间：${l(Qi)(l(g).createTime)}`), 1)]), _: 1 }), s(N, { effect: "plain", type: "warning" }, { default: p(() => [Te("出库类型：" + K(l(Jt).VL[l(g).outboundTypeSelection]), 1)]), _: 1 }), s(N, { effect: "plain" }, { default: p(() => [Te("备注：" + K(l(g).remark || "-"), 1)]), _: 1 })]), titleRight: p(() => {
      var q;
      return [((q = l(g).wmsApproveRecordFlowDTOS) == null ? void 0 : q.length) !== 0 ? (w(), U(L, { key: 0, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(P, { size: "default" }, { default: p(() => v[4] || (v[4] = [Te("查看审批记录")])), _: 1, __: [4] })]), default: p(() => [s(tl, { data: l(g).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), c.ApprovalFlag ? (w(), Q("div", oK, [s(O, { title: "确认通过", onConfirm: v[0] || (v[0] = (ae) => m(l(Lt).PASS.V)) }, { reference: p(() => [s(P, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => v[5] || (v[5] = [Te(" 通过 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 }), s(O, { title: "确认驳回", onConfirm: v[1] || (v[1] = (ae) => m(l(Lt).REFUSE.V)) }, { reference: p(() => [s(P, { loading: y.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => v[6] || (v[6] = [Te(" 驳回 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : H("", true)];
    }), content: p(() => [s(Y, { data: l(g).list, "data-format": b.value, "expand-row-keys": r.value, "max-height": l(S), "summary-method": _, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": r.value, "onUpdate:expandRowKeys": v[2] || (v[2] = (q) => r.value = q), data: l(g).list, fixed: "left", "row-key": "id" }, { default: p(({ row: q }) => [s(Xl, { "basic-class": q.basicClass, row: q, "show-graphics": "", "show-remark": "" }, { default: p(() => [q.boolTransfer ? (w(), Q("p", nK, [v[7] || (v[7] = Te(" 调拨： ")), v[8] || (v[8] = C("span", null, "（来源）", -1)), C("span", sK, K(q.sourceProject), 1), v[9] || (v[9] = C("span", null, " ▶ ", -1)), v[10] || (v[10] = C("span", null, "（目的）", -1)), C("span", rK, K(q.project), 1)])) : H("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(g).basicClass, fixed: "left", "show-outbound-mode": "" }, { afterMaterialSn: p(() => [s(x, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(Ba), s(za), l(g).outboundTypeSelection === l(Jt).PRODUCE.V ? (w(), U(x, { key: 0, align: "center", label: "理论重量", prop: "actualTheoryWeight", width: "100px" })) : H("", true), s(xl, { "show-area": false, "show-monomer": false, "show-project": l(g).outboundTypeSelection !== l(Jt).FOR_SALE.V, showOutboundWorkshop: l(g).outboundTypeSelection === l(Jt).PRODUCE.V || l(g).outboundTypeSelection === l(Jt).TEMPORARY_LOAN.V || l(g).outboundTypeSelection === l(Jt).CONSTRUCTION_SITE_USE.V, workshopLabel: l(g).outboundTypeSelection === l(Jt).PRODUCE.V || l(g).outboundTypeSelection === l(Jt).CONSTRUCTION_SITE_USE.V ? "领用车间" : "借用车间", "show-transfer": "", "show-workshop": "", showAreaBatchName: "" }, null, 8, ["show-project", "showOutboundWorkshop", "workshopLabel"]), l(g).outboundTypeSelection === l(Jt).PRODUCE.V ? (w(), U(x, { key: 1, align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" })) : H("", true), l(g).outboundTypeSelection === l(Jt).OUTSOURCE.V ? (w(), U(x, { key: "purchase.serialNumber", align: "center", label: "所属采购合同", prop: "purchase.serialNumber", width: "145px" })) : H("", true), l(g).outboundTypeSelection === l(Jt).OUTSOURCE.V || l(g).outboundTypeSelection === l(Jt).PRODUCE.V || l(g).outboundTypeSelection === l(Jt).TEMPORARY_LOAN.V ? (w(), U(x, { key: "recipient", label: l(g).outboundTypeSelection === l(Jt).TEMPORARY_LOAN.V ? "借用人" : "领用人", align: "center", width: "100px" }, { default: p(({ row: q }) => [q.recipient ? (w(), U(I, { key: 0, content: `${q.recipient.deptName}`, effect: "light", placement: "top" }, { default: p(() => [C("span", null, K(q.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : H("", true)]), _: 1 }, 8, ["label"])) : H("", true), l(g).outboundTypeSelection === l(Jt).FOR_SALE.V ? (w(), Q(Qe, { key: 4 }, [s(x, { align: "center", label: "理论重量", prop: "theoryTotalWeight", width: "100px" }, { default: p(({ row: q }) => [C("span", null, K(q.theoryTotalWeight || "-"), 1)]), _: 1 }), s(x, { align: "center", label: "过磅重量", prop: "weighingWeight", width: "100px" }, { default: p(({ row: q }) => [C("span", null, K(q.weighingWeight || "-"), 1)]), _: 1 }), s(x, { align: "center", label: "计量方式", width: "100px" }, { default: p(({ row: q }) => [C("span", null, K(l(Wt).VL[q.weightMeasurementMode] || "-"), 1)]), _: 1 }), s(x, { align: "center", label: "出售含税单价", width: "120px" }, { default: p(({ row: q }) => [C("span", null, K(q.sellUnitPrice || "-"), 1)]), _: 1 }), s(x, { align: "center", label: "出售含税金额", prop: "sellAmount", width: "120px" }, { default: p(({ row: q }) => [C("span", null, K(q.sellAmount || "-"), 1)]), _: 1 }), s(x, { align: "center", label: "出售票型及税率", width: "150px" }, { default: p(({ row: q }) => [C("span", null, K(`${l(fi).VL[q.invoiceType]}(${q.taxRate}%)` || "-"), 1)]), _: 1 }), s(x, { key: "purchaser", "show-overflow-tooltip": true, label: "购买方", "min-width": "120", prop: "purchaser" })], 64)) : H("", true), s(x, { key: "outboundTime", align: "center", label: "出库时间", prop: "outboundTime", width: "145px" }), s(x, { key: "usageStatus", align: "center", label: "领用情况", prop: "usageStatus", width: "145px" }, { default: p(({ row: { sourceRow: q } }) => {
      var ae;
      return [(ae = q.consumingDTO) != null && ae.length ? (w(), U(L, { key: 0, class: "box-item", placement: "bottom", title: "领用情况", trigger: "click", width: "327" }, { reference: p(() => [s(P, { type: "primary" }, { default: p(() => v[11] || (v[11] = [Te("查询")])), _: 1, __: [11] })]), default: p(() => [s(Y, { data: q.consumingDTO, "row-key": "id" }, { default: p(() => [s(x, { key: "consumingMete", label: `已领用量(${q.consumingUnit})`, align: "center", prop: "consumingMete", width: "100" }, null, 8, ["label"]), s(x, { key: "totalNetWeight", label: `清单净重(${q.consumingUnit})`, align: "center", prop: "totalNetWeight", width: "100" }, null, 8, ["label"]), s(x, { key: "totalGrossWeight", label: `清单毛重(${q.consumingUnit})`, align: "center", prop: "totalGrossWeight", width: "100" }, null, 8, ["label"])]), _: 2 }, 1032, ["data"])]), _: 2 }, 1024)) : (w(), Q("span", uK, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), c.ApprovalFlag ? (w(), U(ee, { key: 0, modelValue: E.value, "onUpdate:modelValue": v[3] || (v[3] = (q) => E.value = q), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, x_ = ut(cK, [["__scopeId", "data-v-89955f2a"]]), dK = Object.freeze(Object.defineProperty({ __proto__: null, default: x_ }, Symbol.toStringTag, { value: "Module" }));
const mK = { __name: "detail", setup(e) {
  const o = Z(), n = Z([]), c = Z([...Da, ["outboundAddress", ["parse-enum", So]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["reviewPassTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]], ["basicClass", ["parse-enum", bs, { f: "L" }]]]), { CRUD: u, crud: r, detail: E } = qi(), { maxHeight: y } = Kt({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !r.detailLoading)), b = Ee(() => E && E.serialNumber ? `出库单：${E.serialNumber}` : "出库单");
  u.HOOK.beforeDetailLoaded = async (M, g) => {
    g.list = await fo(g.list, { toSmallest: false, toNum: false }, { mete: ["mete"], quantity: ["quantity"] });
  };
  function V(M) {
    return Hi(M, { props: ["quantity", ["totalWeight", ei.weight.precision], "totalLength", "totalArea"] });
  }
  return (M, g) => {
    const S = wi, h = vt, T = Ve("common-table"), _ = Ve("common-drawer"), f = _t("parse-time");
    return w(), U(_, { ref_key: "drawerRef", ref: o, "before-close": l(r).cancelDetail, "content-loading": l(r).detailLoading, "show-close": true, title: b.value, visible: l(r).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: p(() => [l(E).applicant ? (w(), U(S, { key: 0, effect: "dark", type: "success" }, { default: p(() => [Te(K(`申请人：${l(E).applicant.name} | ${l(E).applicant.deptName}`), 1)]), _: 1 })) : H("", true), s(S, { effect: "plain" }, { default: p(() => [Te(K(`出库申请时间：${l(Qi)(l(E).createTime)}`), 1)]), _: 1 })]), titleRight: p(() => g[0] || (g[0] = [])), content: p(() => [s(T, { data: l(E).list, "data-format": c.value, "expand-row-keys": n.value, "max-height": l(y), "summary-method": V, "row-key": "id", "show-summary": "" }, { default: p(() => [s(h, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(h, { key: "basicClass", align: "center", label: "物料种类", prop: "basicClass", "show-overflow-tooltip": "" }), s(h, { key: "manufacturedName", align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(h, { key: "manufacturedSn", align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(h, { key: "specification", align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), s(h, { key: "project.name", align: "center", label: "项目", "min-width": "120px", prop: "project.name", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: m } }) => {
      var R, v, N;
      return [Te(K(l(A)((R = m.project) == null ? void 0 : R.name) ? `${(v = m.project) == null ? void 0 : v.serialNumber} ${(N = m.project) == null ? void 0 : N.name}` : "-"), 1)];
    }), _: 1 }), l(E).basicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(h, { key: "monomer.name", align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(h, { key: "area.name", align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(h, { key: "length", align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" })], 64)) : (w(), Q(Qe, { key: 1 }, [s(h, { key: "length", align: "center", label: "厚度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(h, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })], 64)), s(h, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), l(E).basicClass === l(Pe).ENCL_MANUFACTURED.V ? (w(), Q(Qe, { key: 2 }, [s(h, { key: "width", align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), s(h, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), s(h, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), s(h, { key: "length", align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(h, { key: "quantity", align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(h, { key: "totalLength", align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), s(h, { key: "totalArea", align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(h, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)) : (w(), Q(Qe, { key: 3 }, [s(h, { key: "quantity", align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: m } }) => [Te(K(m.quantity), 1)]), _: 1 }), l(E).basicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(h, { key: "weight", align: "center", label: "单重（kg）", "min-width": "120px", prop: "weight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: m } }) => [Te(K(m.weight), 1)]), _: 1 }), s(h, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: m } }) => [Te(K(m.totalWeight), 1)]), _: 1 })], 64)) : H("", true)], 64)), s(h, { key: "reviewPassTime", align: "center", label: "出库时间", width: "140px" }, { default: p(({ row: m }) => [qe(C("span", null, null, 512), [[f, m.reviewPassTime]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, dv = ut(mK, [["__scopeId", "data-v-b742460c"]]), pK = Object.freeze(Object.defineProperty({ __proto__: null, default: dv }, Symbol.toStringTag, { value: "Module" }));
const hK = { key: 1, class: "borrow-info" }, fK = { key: 0, class: "project-ware-text" }, gK = { key: 2, class: "direction-text" }, EK = { key: 0, class: "project-ware-text" }, yK = { key: 1, class: "public-ware-text" }, TK = { key: 2 }, _K = { key: 3 }, bK = { __name: "common-title-info", props: { detail: { type: Object, default: () => ({ direction: {} }) } }, setup(e) {
  const o = e, n = Ee(() => o.detail.direction && o.detail.transferType !== ur.RETURN_PARTY_A.V);
  return (c, u) => {
    const r = wi, E = _t("parse-enum"), y = _t("parse-project"), b = _t("empty-text");
    return w(), Q(Qe, null, [e.detail.transferType ? qe((w(), U(r, { key: 0, effect: "plain", type: e.detail.boolBorrowReturnNotSelf ? "danger" : void 0, style: { "margin-right": "20px" } }, null, 8, ["type"])), [[E, { e: l(ur), v: e.detail.transferType }]]) : H("", true), e.detail.borrowProject ? (w(), Q("span", hK, [u[0] || (u[0] = C("span", { class: "label" }, "借用项目：", -1)), e.detail.direction.project ? qe((w(), Q("span", fK, null, 512)), [[y, { project: e.detail.borrowProject, onlyShortName: true }], [b]]) : H("", true)])) : H("", true), n.value ? (w(), Q("span", gK, [u[1] || (u[1] = C("span", { class: "label" }, "调拨至：", -1)), e.detail.direction.project ? qe((w(), Q("span", EK, null, 512)), [[y, { project: e.detail.direction.project, onlyShortName: true }], [b]]) : (w(), Q("span", yK, "公共库")), u[2] || (u[2] = Te("   -   ")), e.detail.direction.workshop ? (w(), Q("span", TK, K(e.detail.direction.workshop.name), 1)) : H("", true), u[3] || (u[3] = Te("   -   ")), e.detail.direction.warehouse ? (w(), Q("span", _K, K(e.detail.direction.warehouse.name), 1)) : H("", true)])) : H("", true)], 64);
  };
} }, mv = ut(bK, [["__scopeId", "data-v-a8d83a04"]]), VK = Object.freeze(Object.defineProperty({ __proto__: null, default: mv }, Symbol.toStringTag, { value: "Module" })), wK = { key: 0 }, SK = { key: 1 }, Sb = { __name: "raw-mat", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, outboundTypeMode: { type: Boolean, default: false }, rejectTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, numberPropField: { type: String, default: "quantity" }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, field: { type: String, default: "material" } }, setup(e) {
  const o = e, n = ft("getInfo"), { loaded: c, baseUnit: u } = ai(), r = Ee(() => o.basicClass ? c.value ? u.value[o.basicClass] || {} : vi[o.basicClass] || {} : {}), E = Ee(() => {
    let f = "";
    if (o.showUnit && o.showSteelUnit) f = "核算量";
    else switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case ua:
        f = `重量(${r.value.weight.unit})`;
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        f = "核算量";
        break;
    }
    return (o.labelPrefix || "") + f;
  }), y = Ee(() => {
    let f = "";
    if (o.showUnit && o.showSteelUnit) f = "数量";
    else switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
        f = `数量(${r.value.measure.unit})`;
        break;
      case dt.SECTION_STEEL.V:
        f = `数量(${r.value.measure.unit})`;
        break;
      case dt.STEEL_COIL.V:
        f = `长度(${r.value.measure.unit})`;
        break;
      case ua:
        f = "数量";
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        f = "数量";
        break;
    }
    return (o.labelPrefix || "") + f;
  }), b = Ee(() => o.basicClass & ua ? o.showSteelUnit && o.showUnit : o.showUnit), V = Ee(() => b.value && (Ae(o.columns) || o.columns.visible(`${o.field}.measureUnit`))), M = Ee(() => b.value && (Ae(o.columns) || o.columns.visible(`${o.field}.accountingUnit`))), g = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.${o.quantityField}`)), S = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.${o.meteField}`)), h = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.outboundUnit`)), T = Ee(() => Ae(o.columns) || o.columns.visible("rejectUnit")), _ = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.${o.numberPropField}`));
  return (f, m) => {
    const R = vt;
    return e.outboundTypeMode ? (w(), Q(Qe, { key: 0 }, [h.value ? (w(), U(R, { key: `${e.field}.outboundUnit`, prop: `${e.field}.outboundUnit`, label: "单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, null, 8, ["prop"])) : H("", true), _.value ? (w(), U(R, { key: `${e.field}.${e.numberPropField}`, prop: `${e.field}.${e.numberPropField}`, label: "数量", align: "right", width: "100px", "show-overflow-tooltip": "" }, { default: p(({ row: v }) => [Te(K(l(n)(v, "outboundUnitType") === l(hi).MEASURE.V ? l(n)(v, e.quantityField) : l(n)(v, e.meteField)), 1)]), _: 1 }, 8, ["prop"])) : H("", true)], 64)) : e.rejectTypeMode ? (w(), Q(Qe, { key: 1 }, [T.value ? (w(), U(R, { key: `${e.field}.rejectUnit`, prop: `${e.field}.rejectUnit`, label: "单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, null, 8, ["prop"])) : H("", true), _.value ? (w(), U(R, { key: `${e.field}.${e.numberPropField}`, prop: `${e.field}.${e.numberPropField}`, label: "数量", align: "right", width: "100px", "show-overflow-tooltip": "" }, { default: p(({ row: v }) => [Te(K(l(n)(v, "rejectUnitType") === l(hi).MEASURE.V ? l(n)(v, e.quantityField) : l(n)(v, e.meteField)), 1)]), _: 1 }, 8, ["prop"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 2 }, [V.value ? (w(), U(R, { key: `${e.field}.measureUnit`, prop: `${e.field}.measureUnit`, label: "计量单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, null, 8, ["prop"])) : H("", true), g.value ? (w(), U(R, { key: `${e.field}.${e.quantityField}`, prop: `${e.field}.${e.quantityField}`, label: y.value, align: "right", width: "100px", "show-overflow-tooltip": "" }, { default: p(({ row: v }) => [l(n)(v, "measureUnit") ? (w(), Q("span", wK, K(l(n)(v, e.quantityField)), 1)) : (w(), Q("span", SK, "-"))]), _: 1 }, 8, ["prop", "label"])) : H("", true), M.value ? (w(), U(R, { key: `${e.field}.accountingUnit`, prop: `${e.field}.accountingUnit`, label: "核算单位", align: "center", width: "70px", "show-overflow-tooltip": "" }, null, 8, ["prop"])) : H("", true), S.value ? (w(), U(R, { key: 3, prop: `${e.field}.${e.meteField}`, label: E.value, align: "right", width: "100px", "show-overflow-tooltip": "" }, null, 8, ["prop", "label"])) : H("", true)], 64));
  };
} }, pv = { __name: "index", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, outboundTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, field: { type: String, default: "material" } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return Sb;
      default:
        return Sb;
    }
  });
  function c(u, r) {
    const E = o.field;
    if (!(Ae(u) || Ae(u[E]))) return r ? u[E][r] : u[E];
  }
  return yi("getInfo", c), (u, r) => (w(), U(Ri(n.value), ii(u.$attrs, { columns: o.columns, "basic-class": o.basicClass, showUnit: o.showUnit, "outbound-type-mode": e.outboundTypeMode, "label-prefix": o.labelPrefix, field: e.field }), null, 16, ["columns", "basic-class", "showUnit", "outbound-type-mode", "label-prefix", "field"]));
} }, vb = { __name: "steel", props: { basicClass: { type: Number }, columns: { type: Object }, showBatchNo: { type: Boolean, default: true }, field: { type: String, default: "material" }, fixed: { type: String } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
        return "炉批号";
      case dt.STEEL_COIL.V:
        return "卷号";
      default:
        return "炉批号/卷号";
    }
  }), c = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.brand`)), u = Ee(() => o.showBatchNo && (Ae(o.columns) || o.columns.visible(`${o.field}.heatNoAndBatchNo`)));
  return (r, E) => {
    const y = vt;
    return w(), Q(Qe, null, [c.value ? (w(), U(y, { key: `${e.field}.brand`, prop: `${e.field}.brand`, label: "品牌", align: "left", "min-width": "100px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["prop", "fixed"])) : H("", true), u.value ? (w(), U(y, { key: `${e.field}.heatNoAndBatchNo`, prop: `${e.field}.heatNoAndBatchNo`, label: n.value, align: "left", "min-width": "150px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["prop", "label", "fixed"])) : H("", true)], 64);
  };
} }, vK = { __name: "raw-mat", props: { basicClass: { type: Number }, columns: { type: Object }, field: { type: String, default: "material" }, fixed: { type: String } }, setup(e) {
  const o = e, n = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.brand`));
  return (c, u) => {
    const r = vt;
    return n.value ? (w(), U(r, { key: `${e.field}.brand`, prop: `${e.field}.brand`, label: "品牌", align: "left", "min-width": "100px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["prop", "fixed"])) : H("", true);
  };
} }, Wo = { __name: "index", props: { basicClass: { type: Number }, columns: { type: Object }, showBatchNo: { type: Boolean, default: true }, field: { type: String, default: "material" }, fixed: { type: String } }, setup(e) {
  const o = e, n = Ee(() => {
    if (o.basicClass & ua) return vb;
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
        return vb;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        return vK;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { basicClass: e.basicClass, columns: e.columns, "show-batch-no": e.showBatchNo, field: e.field, fixed: e.fixed }, null, 8, ["basicClass", "columns", "show-batch-no", "field", "fixed"]));
} }, Rb = { __name: "raw-mat", props: { showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: false }, columns: { type: Object }, field: { type: String, default: "material" }, fixed: { type: String } }, setup(e) {
  const o = e, n = ft("getInfo"), c = Ee(() => Ae(o.columns) || o.columns.visible(`${o.field}.warehouse`)), u = Ee(() => o.showProject && (Ae(o.columns) || o.columns.visible(`${o.field}.project`))), r = Ee(() => o.showMonomer && (Ae(o.columns) || o.columns.visible(`${o.field}.monomerName`))), E = Ee(() => o.showArea && (Ae(o.columns) || o.columns.visible(`${o.field}.areaName`)));
  return (y, b) => {
    const V = Ve("table-cell-tag"), M = vt;
    return w(), Q(Qe, null, [u.value ? (w(), U(M, { key: `${e.field}.project`, prop: `${e.field}.project`, label: "项目", align: "left", "min-width": "120px", "show-overflow-tooltip": "", fixed: e.fixed }, { default: p(({ row: g }) => {
      var S;
      return [e.showTransfer && l(n)(g, "outboundRelationType") && l(n)(g, "outboundRelationType") !== l(gl).ROUTINE.V ? (w(), U(V, { key: 0, name: (S = l(gl).VL) == null ? void 0 : S[l(n)(g, "outboundRelationType")], type: "transfer", offset: 15 }, null, 8, ["name"])) : H("", true), Te(" " + K(l(n)(g, "project")), 1)];
    }), _: 1 }, 8, ["prop", "fixed"])) : H("", true), r.value ? (w(), U(M, { key: `${e.field}.monomerName`, prop: `${e.field}.monomerName`, "show-overflow-tooltip": "", label: "单体", align: "left", "min-width": "100" }, null, 8, ["prop"])) : H("", true), E.value ? (w(), U(M, { key: `${e.field}.areaName`, prop: `${e.field}.areaName`, "show-overflow-tooltip": "", label: "区域", align: "left", "min-width": "100" }, null, 8, ["prop"])) : H("", true), c.value ? (w(), U(M, { key: `${e.field}.warehouse`, prop: `${e.field}.warehouse`, label: "仓库", align: "left", "min-width": "110px", "show-overflow-tooltip": "", fixed: e.fixed }, { default: p(({ row: g }) => [o.showWorkshop ? (w(), U(Os, { key: 0, id: l(n)(g, "workshop") ? l(n)(g, "workshop.id") : l(n)(g, "workshopId") }, null, 8, ["id"])) : H("", true), C("span", null, K(l(n)(g, "warehouse") ? l(n)(g, "warehouse.name") : l(n)(g, "warehouse")), 1)]), _: 1 }, 8, ["prop", "fixed"])) : H("", true)], 64);
  };
} }, hv = { __name: "index", props: { basicClass: { type: Number }, showProject: { type: Boolean, default: false }, showTransfer: { type: Boolean, default: false }, showMonomer: { type: Boolean, default: false }, showArea: { type: Boolean, default: false }, showWorkshop: { type: Boolean, default: false }, columns: { type: Object }, field: { type: String, default: "material" } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return Rb;
      default:
        return Rb;
    }
  });
  function c(u, r) {
    const E = o.field;
    if (r) {
      const y = r.split(".");
      return y.length === 1 ? u[E][y[0]] : y.reduce((b, V) => typeof b == "object" ? b[V] : void 0, u[E]);
    } else return u[E];
  }
  return yi("getInfo", c), (u, r) => (w(), U(Ri(n.value), { columns: e.columns, "show-project": e.showProject, "show-transfer": e.showTransfer, "show-monomer": e.showMonomer, "show-area": e.showArea, "show-workshop": e.showWorkshop, field: e.field }, null, 8, ["columns", "show-project", "show-transfer", "show-monomer", "show-area", "show-workshop", "field"]));
} };
const RK = { __name: "unfreeze-info", props: { basicClass: { type: Number }, list: { type: Array, default: () => [] } }, setup(e) {
  const o = e, n = Z(), c = Z(), u = Z([["remark", "empty-text"], ["createTime", "parse-time"], ["material.project", ["parse-project", { onlyShortName: true }]], ["material.quantity", ["to-fixed-field", "measurePrecision"]], ["material.mete", ["to-fixed-field", "accountingPrecision"]]]), r = Z([]);
  Ce(() => o.list, (V) => {
    y(V);
  }, { immediate: true });
  const { maxHeight: E } = Kt({ mainBox: ".wms-transfer-unfreeze-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, n);
  async function y(V) {
    if (r.value = [], Ae(V)) return;
    let M = [];
    const g = At(V);
    g.forEach((S) => M.push(S.material)), await Qt(M), M = await Ut(M, { toSmallest: false, toNum: false }), g.forEach((S, h) => {
      S.material = M[h];
    }), r.value = g;
  }
  function b() {
    n.value = true;
  }
  return (V, M) => {
    const g = vt, S = Ve("common-table"), h = Ve("common-dialog");
    return w(), Q(Qe, null, [C("span", ii(V.$attrs, { class: "tip", onClick: b }), " * 当前单据存在解冻操作，被解冻的物料数量已在单据中减少，点击可查看解冻的物料信息 ", 16), s(h, { title: "解冻办理", modelValue: n.value, "onUpdate:modelValue": M[1] || (M[1] = (T) => n.value = T), width: "80%", "show-close": true, "custom-class": "wms-transfer-unfreeze-list", top: "10vh" }, { default: p(() => [s(S, { ref: "tableRef", data: r.value, "data-format": u.value, "max-height": l(E), "default-expand-all": false, "expand-row-keys": c.value, "row-key": "id" }, { default: p(() => [s(Ha, { data: r.value, "expand-row-keys": c.value, "onUpdate:expandRowKeys": M[0] || (M[0] = (T) => c.value = T), "row-key": "id" }, { default: p(({ row: T }) => [T.material ? (w(), U(Xl, { key: 0, "basic-class": T.material.basicClass, row: T.material }, { default: p(() => [C("p", null, [M[2] || (M[2] = Te(" 备注：")), C("span", null, K(T.remark), 1)])]), _: 2 }, 1032, ["basic-class", "row"])) : H("", true)]), _: 1 }, 8, ["data", "expand-row-keys"]), s(jo, { "basic-class": e.basicClass, "spec-merge": "" }, null, 8, ["basic-class"]), s(pv, { "basic-class": e.basicClass, "label-prefix": "解冻", "outbound-type-mode": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": e.basicClass, "show-batch-no": false }, null, 8, ["basic-class"]), s(hv, { "show-project": "" }), s(g, { key: "applicantName", prop: "applicantName", label: "解冻人", align: "center", width: "90", "show-overflow-tooltip": "" }), s(g, { key: "createTime", prop: "createTime", label: "解冻时间", align: "center", width: "140", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, fu = ut(RK, [["__scopeId", "data-v-4b53f7ab"]]), MK = Object.freeze(Object.defineProperty({ __proto__: null, default: fu }, Symbol.toStringTag, { value: "Module" })), Vr = { __name: "closing-time-columns", props: { columns: { type: Object }, fixed: { type: String }, showLabel: { type: String, default: "实际时间" }, showFormatRow: { type: Boolean, default: false } }, setup(e) {
  const o = e, n = Ee(() => {
    const c = fr();
    return c && c === Qn.SELF.V && (Ae(o.columns) || o.columns.visible("realTime"));
  });
  return (c, u) => {
    const r = vt;
    return n.value ? (w(), Q(Qe, { key: 0 }, [e.showFormatRow ? (w(), U(r, { "show-overflow-tooltip": true, key: "realTimeFormatRow", prop: "realTime", label: e.showLabel, width: "230px", fixed: e.fixed, align: "center" }, { default: p(({ row: E }) => [C("span", null, K(E.realTime && E.realTime !== "-" ? l(Qi)(E.realTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }, 8, ["label", "fixed"])) : (w(), U(r, { "show-overflow-tooltip": true, key: "realTime", prop: "realTime", label: e.showLabel, fixed: e.fixed, width: "180px", align: "center" }, null, 8, ["label", "fixed"]))], 64)) : H("", true);
  };
} };
const AK = { key: 0, class: "invoice-type-info" }, NK = { key: 0 }, LK = { key: 1 }, IK = { __name: "detail", setup(e) {
  const { decimalPrecision: o } = Ln(), n = Z(), c = Z([]), u = Z(false), r = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", o.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", o.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"], ["realTime", "parse-time"]]), { CRUD: E, crud: y, detail: b } = qi(), { maxHeight: V } = Kt({ mainBox: ".raw-mat-transfer-application-review-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !y.detailLoading)), M = Ee(() => y.detailLoading ? "调拨单：" : `调拨单：${b.serialNumber || ""}`);
  E.HOOK.beforeDetailLoaded = async (S, h) => {
    if (await Qt(h.list), h.list = await Ut(h.list, { toSmallest: false, toNum: false }), h.transferType !== ur.RETURN_PARTY_A.V) {
      let T = 0;
      h.list.forEach((_) => {
        _.boolPartyA && _.partyATransferType === Mo.BUY_IN.V && T++;
      }), u.value = T > 0;
    } else u.value = false;
  };
  function g(S) {
    return Hi(S, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (S, h) => {
    const T = wi, _ = vt, f = Ve("common-table"), m = Ve("common-drawer"), R = _t("parse-enum");
    return w(), U(m, { ref_key: "drawerRef", ref: n, "before-close": l(y).cancelDetail, "content-loading": l(y).detailLoading, "show-close": true, title: M.value, visible: l(y).detailVisible, "custom-class": "raw-mat-transfer-application-review-detail", size: "100%" }, { titleAfter: p(() => [s(mv, { detail: l(b) }, null, 8, ["detail"])]), titleRight: p(() => [u.value && l(A)(l(b).invoiceType) ? (w(), Q("span", AK, [qe(C("span", null, null, 512), [[R, { e: l(fi), v: l(b).invoiceType }]]), l(b).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", NK, "（" + K(l(b).taxRate) + "%）", 1)) : H("", true)])) : H("", true), l(A)(l(b).reviewStatus) ? (w(), U(T, { key: 1, type: l(po).V[l(b).reviewStatus].TAG, size: "large", style: { "margin-right": "10px" } }, { default: p(() => [Te(K(l(po).VL[l(b).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)]), content: p(() => [l(b).boolHasUnfreeze ? (w(), U(fu, { key: 0, "basic-class": l(b).basicClass, list: l(b).unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : H("", true), s(f, { data: l(b).list, "data-format": r.value, "expand-row-keys": c.value, "max-height": l(V), "summary-method": g, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": c.value, "onUpdate:expandRowKeys": h[0] || (h[0] = (v) => c.value = v), data: l(b).list, fixed: "left", "row-key": "id" }, { default: p(({ row: v }) => [u.value ? (w(), U(Xl, { key: 0, "basic-class": l(b).basicClass, row: v, "show-brand": "" }, { default: p(() => [C("p", null, [h[1] || (h[1] = Te(" 备注：")), C("span", null, K(v.remark), 1)])]), _: 2 }, 1032, ["basic-class", "row"])) : (w(), Q("p", LK, [h[2] || (h[2] = Te(" 备注：")), C("span", null, K(v.remark), 1)]))]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(b).basicClass, fixed: "left", "show-party-a-transfer": "" }, { afterMaterialSn: p(() => [s(_, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(za, { "basic-class": l(b).basicClass }, null, 8, ["basic-class"]), u.value ? H("", true) : (w(), U(Ba, { key: 0, "basic-class": l(b).basicClass }, null, 8, ["basic-class"])), u.value ? (w(), U(cv, { key: 1 })) : H("", true), s(xl, { "show-project": "", "show-monomer": false, "show-area": false }), s(Vr, { label: "实际调拨时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, fv = ut(IK, [["__scopeId", "data-v-a27d6112"]]), CK = Object.freeze(Object.defineProperty({ __proto__: null, default: fv }, Symbol.toStringTag, { value: "Module" }));
const PK = { key: 0, class: "direction-text" }, OK = { key: 0 }, kK = { key: 1 }, DK = { __name: "common-title-info", props: { detail: { type: Object, default: () => ({ direction: {} }) } }, setup(e) {
  const o = e, n = Ee(() => o.detail && o.detail.directionWorkshop && o.detail.directionWarehouse);
  return (c, u) => n.value ? (w(), Q("span", PK, [u[0] || (u[0] = C("span", { class: "label" }, "移库至：", -1)), e.detail.directionWorkshop ? (w(), Q("span", OK, K(e.detail.directionWorkshop.name), 1)) : H("", true), u[1] || (u[1] = Te(" - ")), e.detail.directionWarehouse ? (w(), Q("span", kK, K(e.detail.directionWarehouse.name), 1)) : H("", true)])) : H("", true);
} }, U_ = ut(DK, [["__scopeId", "data-v-80074035"]]), xK = Object.freeze(Object.defineProperty({ __proto__: null, default: U_ }, Symbol.toStringTag, { value: "Module" }));
const UK = { key: 0, class: "invoice-type-info" }, YK = { key: 0 }, KK = { style: { width: "100%", "text-overflow": "ellipsis", "white-space": "nowrap", overflow: "hidden" } }, WK = { __name: "detail", setup(e) {
  const { decimalPrecision: o } = Ln(), n = Z(), c = Z([]), u = Z(false), r = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", o.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", o.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), { CRUD: E, crud: y, detail: b } = qi(), { maxHeight: V } = Kt({ mainBox: ".raw-mat-transfer-application-review-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !y.detailLoading)), M = Ee(() => y.detailLoading ? "移库单：" : `移库单：${b.serialNumber || ""}`);
  function g(h) {
    var f;
    const T = (f = h.sourceWorkshop) == null ? void 0 : f.name, _ = h.sourceWarehouse ? h.sourceWarehouse.name : h.sourceWarehouseName;
    return T ? T + "【" + _ + "】" : _;
  }
  E.HOOK.beforeDetailLoaded = async (h, T) => {
    await Qt(T.detailList), T.detailList = await Ut(T.detailList, { toSmallest: false, toNum: false });
  };
  function S(h) {
    return Hi(h, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (h, T) => {
    const _ = wi, f = vt, m = jt, R = Ve("common-table"), v = Ve("common-drawer"), N = _t("parse-enum");
    return w(), U(v, { ref_key: "drawerRef", ref: n, "before-close": l(y).cancelDetail, "content-loading": l(y).detailLoading, "show-close": true, title: M.value, visible: l(y).detailVisible, "custom-class": "raw-mat-transfer-application-review-detail", size: "100%" }, { titleAfter: p(() => [s(U_, { detail: l(b) }, null, 8, ["detail"])]), titleRight: p(() => [u.value && l(A)(l(b).invoiceType) ? (w(), Q("span", UK, [qe(C("span", null, null, 512), [[N, { e: l(fi), v: l(b).invoiceType }]]), l(b).invoiceType !== l(fi).RECEIPT.V ? (w(), Q("span", YK, "（" + K(l(b).taxRate) + "%）", 1)) : H("", true)])) : H("", true), l(A)(l(b).reviewStatus) ? (w(), U(_, { key: 1, type: l(po).V[l(b).reviewStatus].TAG, size: "large", style: { "margin-right": "10px" } }, { default: p(() => [Te(K(l(po).VL[l(b).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)]), content: p(() => [l(b).boolHasUnfreeze ? (w(), U(fu, { key: 0, "basic-class": l(b).basicClass, list: l(b).unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : H("", true), s(R, { data: l(b).detailList, "data-format": r.value, "expand-row-keys": c.value, "max-height": l(V), "summary-method": S, "row-key": "id", "show-summary": "" }, { default: p(() => [s(fa, { "basic-class": l(b).basicClass, "spec-merge": false, "classify-name-alias": "名称", "reject-detail-viewable": "", "show-classification": "", "show-reject-status": "", sortable: "", "spec-only": "" }, { afterMaterialSn: p(() => [s(f, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(f, { key: "measureUnit", "show-overflow-tooltip": true, align: "center", label: "计量单位", "min-width": "90", prop: "measureUnit" }, { default: p(({ row: P }) => [C("span", null, K(P.measureUnit || "-"), 1)]), _: 1 }), s(f, { key: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量", "min-width": "100", prop: "quantity" }, { default: p(({ row: P }) => [C("span", null, K(P.quantity || "-"), 1)]), _: 1 }), s(f, { key: "accountingUnit", "show-overflow-tooltip": true, align: "center", label: "核算单位", "min-width": "90", prop: "accountingUnit" }, { default: p(({ row: P }) => [C("span", null, K(P.accountingUnit || "-"), 1)]), _: 1 }), s(f, { key: "mete", "show-overflow-tooltip": true, align: "center", label: "核算量", "min-width": "100", prop: "mete" }, { default: p(({ row: P }) => [C("span", null, K(P.mete || "-"), 1)]), _: 1 }), s(f, { key: "project", "show-overflow-tooltip": true, align: "center", label: "关联项目", "min-width": "170", prop: "project" }, { default: p(({ row: P }) => [C("span", null, K(P.projectFullName || "-"), 1)]), _: 1 }), s(f, { key: "sourceWarehouse", align: "center", label: "所属仓库", "min-width": "170", prop: "sourceWarehouse" }, { default: p(({ row: P }) => [C("div", KK, [s(Os, { id: P.sourceWorkshop ? P.sourceWorkshop.id : P.sourceWorkshopId }, null, 8, ["id"]), s(m, { content: g(P), class: "item", effect: "dark", placement: "top-start" }, { default: p(() => [C("span", null, K(P.sourceWarehouse ? P.sourceWarehouse.name : P.sourceWarehouseName), 1)]), _: 2 }, 1032, ["content"])])]), _: 1 }), s(f, { key: "remark", "show-overflow-tooltip": true, label: "备注", "min-width": "170", prop: "remark" }, { default: p(({ row: P }) => [C("span", null, K(P.remark || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, gv = ut(WK, [["__scopeId", "data-v-c3955d96"]]), jK = Object.freeze(Object.defineProperty({ __proto__: null, default: gv }, Symbol.toStringTag, { value: "Module" })), pm = { __name: "raw-mat", props: { basicClass: { type: Number }, fixed: { type: String }, showQuantity: { type: Boolean, default: true }, showMete: { type: Boolean, default: true }, showNumber: { type: Boolean, default: true }, showUnit: { type: Boolean, default: true }, showSteelUnit: { type: Boolean, default: false }, outboundTypeMode: { type: Boolean, default: false }, rejectTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, numberPropField: { type: String, default: "quantity" }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" }, showTip: { type: Boolean, default: false } }, setup(e) {
  const o = e, { loaded: n, baseUnit: c } = ai(), u = Ee(() => o.basicClass ? n.value ? c.value[o.basicClass] || {} : vi[o.basicClass] || {} : {}), r = Ee(() => {
    let _ = "";
    if (o.showUnit && o.showSteelUnit) _ = "核算量";
    else switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case ua:
        _ = `重量(${u.value.weight.unit})`;
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        _ = "核算量";
        break;
    }
    return (o.labelPrefix || "") + _;
  }), E = Ee(() => {
    let _ = "";
    if (o.showUnit && o.showSteelUnit) _ = "数量";
    else switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
        _ = `数量(${u.value.measure.unit})`;
        break;
      case dt.SECTION_STEEL.V:
        _ = `数量(${u.value.measure.unit})`;
        break;
      case dt.STEEL_COIL.V:
        _ = `长度(${u.value.measure.unit})`;
        break;
      case ua:
        _ = "数量";
        break;
      case dt.MATERIAL.V:
      case dt.GAS.V:
      default:
        _ = "数量";
        break;
    }
    return (o.labelPrefix || "") + _;
  }), y = Ee(() => o.basicClass & ua ? o.showSteelUnit && o.showUnit : o.showUnit), b = Ee(() => y.value && (Ae(o.columns) || o.columns.visible("measureUnit"))), V = Ee(() => y.value && (Ae(o.columns) || o.columns.visible("accountingUnit"))), M = Ee(() => o.showQuantity && (Ae(o.columns) || o.columns.visible(o.quantityField))), g = Ee(() => o.showMete && (Ae(o.columns) || o.columns.visible(o.meteField))), S = Ee(() => Ae(o.columns) || o.columns.visible("outboundUnit")), h = Ee(() => Ae(o.columns) || o.columns.visible("rejectUnit")), T = Ee(() => o.showNumber && (Ae(o.columns) || o.columns.visible(o.numberPropField)));
  return (_, f) => {
    var R, v;
    const m = vt;
    return e.outboundTypeMode ? (w(), Q(Qe, { key: 0 }, [S.value ? (w(), U(m, { key: "outboundUnit", prop: "outboundUnit", label: "单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), T.value ? (w(), U(m, { key: e.numberPropField, prop: e.numberPropField, label: "数量", align: "right", width: "100px", fixed: e.fixed, "show-overflow-tooltip": "" }, { default: p(({ row: N }) => [Te(K(N.outboundUnitType === l(hi).MEASURE.V ? N[e.quantityField] : N[e.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed"])) : H("", true)], 64)) : e.rejectTypeMode ? (w(), Q(Qe, { key: 1 }, [h.value ? (w(), U(m, { key: "rejectUnit", prop: "rejectUnit", label: "单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), T.value ? (w(), U(m, { key: e.numberPropField, prop: e.numberPropField, label: "数量", align: "right", width: "100px", fixed: e.fixed, "show-overflow-tooltip": "" }, { default: p(({ row: N }) => [Te(K(N.rejectUnitType === l(hi).MEASURE.V ? N[e.quantityField] : N[e.meteField]), 1)]), _: 1 }, 8, ["prop", "fixed"])) : H("", true)], 64)) : (w(), Q(Qe, { key: 2 }, [b.value ? (w(), U(m, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), M.value ? (w(), U(m, { key: 1, prop: e.quantityField, label: E.value, align: "right", width: "100px", "show-overflow-tooltip": "", fixed: e.fixed }, null, 8, ["prop", "label", "fixed"])) : H("", true), V.value ? (w(), U(m, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "70px", fixed: e.fixed, "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), e.showTip && e.basicClass === l(dt).STEEL_PLATE.V ? (w(), Q(Qe, { key: 3 }, [s(m, { prop: "detailMete", label: `余料(${(R = u.value) == null ? void 0 : R.weight.unit})`, align: "right", width: "120px", "show-overflow-tooltip": "", fixed: e.fixed }, { default: p(({ row: N }) => [Te(K(N.boolReturns ? N.detailMete : "-"), 1)]), _: 1 }, 8, ["label", "fixed"]), s(m, { prop: "actualMete", label: `总重(${(v = u.value) == null ? void 0 : v.weight.unit})`, align: "right", width: "120px", "show-overflow-tooltip": "", fixed: e.fixed }, { default: p(({ row: N }) => [Te(K(N.mete), 1)]), _: 1 }, 8, ["label", "fixed"])], 64)) : (w(), Q(Qe, { key: 4 }, [g.value ? (w(), U(m, { key: 0, prop: e.meteField, label: r.value, align: "right", width: "100px", "show-overflow-tooltip": "", fixed: e.fixed }, null, 8, ["prop", "label", "fixed"])) : H("", true)], 64))], 64));
  };
} }, FK = Object.freeze(Object.defineProperty({ __proto__: null, default: pm }, Symbol.toStringTag, { value: "Module" })), Y_ = { __name: "index", props: { basicClass: { type: Number }, showUnit: { type: Boolean, default: true }, showMete: { type: Boolean, default: true }, outboundTypeMode: { type: Boolean, default: false }, columns: { type: Object }, labelPrefix: { type: String }, quantityField: { type: String, default: "quantity" }, meteField: { type: String, default: "mete" } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
      case dt.SECTION_STEEL.V:
      case dt.STEEL_COIL.V:
      case dt.MATERIAL.V:
      case dt.GAS.V:
        return pm;
      default:
        return pm;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), ii(c.$attrs, { columns: o.columns, "basic-class": o.basicClass, showUnit: o.showUnit, showMete: o.showMete, "outbound-type-mode": e.outboundTypeMode, "label-prefix": o.labelPrefix, "quantity-field": e.quantityField, "mete-field": e.meteField }), null, 16, ["columns", "basic-class", "showUnit", "showMete", "outbound-type-mode", "label-prefix", "quantity-field", "mete-field"]));
} }, zK = Object.freeze(Object.defineProperty({ __proto__: null, default: Y_ }, Symbol.toStringTag, { value: "Module" })), BK = { key: 0, class: "return-material-info" }, HK = { class: "info-item" }, qK = { class: "info-item" }, GK = { class: "info-item" }, QK = { class: "info-item" }, ZK = { class: "important-info" }, JK = { class: "info-item" }, XK = { class: "important-info" }, $K = { class: "info-item" }, eW = { class: "important-info" }, tW = { class: "info-item" }, iW = { class: "info-item" }, aW = { class: "info-item" }, lW = { class: "info-item" }, oW = { key: 0 }, nW = { class: "info-item" }, sW = { key: 0 }, rW = { class: "info-item" }, uW = { class: "info-item" }, cW = { class: "info-item" }, dW = { class: "info-item" }, mW = { class: "returnable-number" }, pW = { class: "info-item" }, hW = { key: 0, style: { color: "#e6a23c" } }, Ev = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) }, currentPlateRow: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, { baseUnit: n } = ai(o.basicClass), c = Ee(() => Be(o.material.returnableMete, o.material.accountingPrecision)), u = Ee(() => Be(o.material.returnableQuantity, o.material.measurePrecision));
  return (r, E) => {
    const y = _t("to-fixed"), b = _t("parse-project"), V = _t("empty-text"), M = _t("parse-time");
    return l(A)(e.material) ? (w(), Q("div", BK, [C("span", HK, [E[0] || (E[0] = C("span", null, "编号", -1)), C("span", null, K(e.material.serialNumber), 1)]), C("span", qK, [E[1] || (E[1] = C("span", null, "种类", -1)), C("span", null, K(e.material.classifyFullName), 1)]), C("span", GK, [E[2] || (E[2] = C("span", null, "规格", -1)), C("span", null, K(e.material.specification), 1)]), C("span", QK, [C("span", null, "厚度(" + K(l(n).thickness.unit) + ")", 1), qe(C("span", ZK, null, 512), [[y, { val: e.material.thickness || 0, dp: l(n).thickness.precision }]])]), C("span", JK, [C("span", null, "宽度(" + K(l(n).width.unit) + ")", 1), qe(C("span", XK, null, 512), [[y, { val: e.material.width || 0, dp: l(n).width.precision }]])]), C("span", $K, [C("span", null, "长度(" + K(l(n).length.unit) + ")", 1), qe(C("span", eW, null, 512), [[y, { val: e.material.length || 0, dp: l(n).length.precision }]])]), C("span", tW, [E[3] || (E[3] = C("span", null, "品牌", -1)), C("span", null, K(e.material.brand), 1)]), C("span", iW, [E[4] || (E[4] = C("span", null, "炉批号", -1)), C("span", null, K(e.material.heatNoAndBatchNo), 1)]), E[15] || (E[15] = C("br", null, null, -1)), C("span", aW, [E[5] || (E[5] = C("span", null, "项目", -1)), qe(C("span", null, null, 512), [[b, { project: e.material.project, onlyShortName: true }], [V]])]), C("span", lW, [E[6] || (E[6] = C("span", null, "车间", -1)), e.material.workshop ? (w(), Q("span", oW, K(e.material.workshop.name), 1)) : H("", true)]), C("span", nW, [E[7] || (E[7] = C("span", null, "仓库", -1)), e.material.warehouse ? (w(), Q("span", sW, K(e.material.warehouse.name), 1)) : H("", true)]), C("span", rW, [E[8] || (E[8] = C("span", null, "领用人", -1)), C("span", null, K(e.material.recipientName), 1)]), C("span", uW, [E[9] || (E[9] = C("span", null, "出库日期", -1)), qe(C("span", null, null, 512), [[M, { val: e.material.createTime, fmt: "{y}-{m}-{d}" }]])]), C("span", cW, [C("span", null, "数量(" + K(l(n).measure.unit) + ")", 1), qe(C("span", { style: ri({ color: u.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[y, { val: u.value || 0, dp: l(n).measure.precision }]]), E[10] || (E[10] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[y, { val: e.material.quantity || 0, dp: l(n).measure.precision }]])]), C("span", dW, [C("span", null, "单重(" + K(l(n).weight.unit) + ")", 1), qe(C("span", mW, null, 512), [[y, { val: e.material.singleReturnableMete || 0, dp: l(n).weight.precision }]]), E[11] || (E[11] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[y, { val: e.material.singleMete || 0, dp: l(n).weight.precision }]])]), C("span", pW, [C("span", null, "总重(" + K(l(n).weight.unit) + ")", 1), qe(C("span", { style: ri({ color: c.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[y, { val: c.value || 0, dp: l(n).weight.precision }]]), E[14] || (E[14] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[y, { val: e.material.mete || 0, dp: l(n).weight.precision }]]), e.currentPlateRow.boolReturns ? (w(), Q("span", hW, [E[12] || (E[12] = Te("(余料:")), qe(C("span", null, null, 512), [[y, { val: e.currentPlateRow.detailMete || 0, dp: l(n).weight.precision }]]), E[13] || (E[13] = Te(")"))])) : H("", true)])])) : H("", true);
  };
} }, fW = Object.freeze(Object.defineProperty({ __proto__: null, default: Ev }, Symbol.toStringTag, { value: "Module" })), gW = { key: 0, class: "return-material-info" }, EW = { class: "info-item" }, yW = { class: "info-item" }, TW = { class: "info-item" }, _W = { class: "info-item" }, bW = { class: "important-info" }, VW = { class: "info-item" }, wW = { class: "info-item" }, SW = { class: "info-item" }, vW = { class: "returnable-number" }, RW = { class: "info-item" }, MW = { class: "info-item" }, AW = { class: "info-item" }, NW = { key: 0 }, LW = { class: "info-item" }, IW = { key: 0 }, CW = { class: "info-item" }, PW = { class: "info-item" }, OW = { class: "info-item" }, kW = { class: "info-item" }, DW = { class: "returnable-number" }, xW = { class: "info-item" }, UW = { key: 0, style: { color: "#e6a23c" } }, yv = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) }, currentPlateRow: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, { baseUnit: n } = ai(o.basicClass), c = Ee(() => Be(o.material.returnableMete, o.material.accountingPrecision)), u = Ee(() => Be(o.material.returnableQuantity, o.material.measurePrecision)), r = Ee(() => Be(o.material.returnableLength, n.value ? n.value.length.precision : 0));
  return (E, y) => {
    const b = _t("to-fixed"), V = _t("parse-project"), M = _t("empty-text"), g = _t("parse-time");
    return l(A)(e.material) ? (w(), Q("div", gW, [C("span", EW, [y[0] || (y[0] = C("span", null, "编号", -1)), C("span", null, K(e.material.serialNumber), 1)]), C("span", yW, [y[1] || (y[1] = C("span", null, "种类", -1)), C("span", null, K(e.material.classifyFullName), 1)]), C("span", TW, [y[2] || (y[2] = C("span", null, "规格", -1)), C("span", null, K(e.material.specification), 1)]), C("span", _W, [C("span", null, "长度(" + K(l(n).length.unit) + ")", 1), qe(C("span", bW, null, 512), [[b, { val: e.material.length || 0, dp: l(n).length.precision }]])]), C("span", VW, [y[3] || (y[3] = C("span", null, "品牌", -1)), C("span", null, K(e.material.brand), 1)]), C("span", wW, [y[4] || (y[4] = C("span", null, "炉批号", -1)), C("span", null, K(e.material.heatNoAndBatchNo), 1)]), C("span", SW, [C("span", null, "单长度(" + K(l(n).length.unit) + ")", 1), qe(C("span", vW, null, 512), [[b, { val: e.material.singleReturnableLength || 0, dp: l(n).length.precision }]]), y[5] || (y[5] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.length || 0, dp: l(n).length.precision }]])]), C("span", RW, [C("span", null, "总长度(" + K(l(n).length.unit) + ")", 1), qe(C("span", { style: ri({ color: r.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[b, { val: r.value || 0, dp: l(n).length.precision }]]), y[6] || (y[6] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.totalLength || 0, dp: l(n).length.precision }]])]), y[17] || (y[17] = C("br", null, null, -1)), C("span", MW, [y[7] || (y[7] = C("span", null, "项目", -1)), qe(C("span", null, null, 512), [[V, { project: e.material.project, onlyShortName: true }], [M]])]), C("span", AW, [y[8] || (y[8] = C("span", null, "车间", -1)), e.material.workshop ? (w(), Q("span", NW, K(e.material.workshop.name), 1)) : H("", true)]), C("span", LW, [y[9] || (y[9] = C("span", null, "仓库", -1)), e.material.warehouse ? (w(), Q("span", IW, K(e.material.warehouse.name), 1)) : H("", true)]), C("span", CW, [y[10] || (y[10] = C("span", null, "领用人", -1)), C("span", null, K(e.material.recipientName), 1)]), C("span", PW, [y[11] || (y[11] = C("span", null, "出库日期", -1)), qe(C("span", null, null, 512), [[g, { val: e.material.createTime, fmt: "{y}-{m}-{d}" }]])]), C("span", OW, [C("span", null, "数量(" + K(l(n).measure.unit) + ")", 1), qe(C("span", { style: ri({ color: u.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[b, { val: u.value || 0, dp: l(n).measure.precision }]]), y[12] || (y[12] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.quantity || 0, dp: l(n).measure.precision }]])]), C("span", kW, [C("span", null, "单重(" + K(l(n).weight.unit) + ")", 1), C("span", DW, K(e.material.singleReturnableMete || 0), 1), y[13] || (y[13] = C("span", null, " / ", -1)), C("span", null, K(e.material.singleMete || 0), 1)]), C("span", xW, [C("span", null, "总重(" + K(l(n).weight.unit) + ")", 1), qe(C("span", { style: ri({ color: c.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[b, { val: c.value || 0, dp: l(n).weight.precision }]]), y[16] || (y[16] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.mete || 0, dp: l(n).weight.precision }]]), e.currentPlateRow.boolReturns ? (w(), Q("span", UW, [y[14] || (y[14] = Te("(余料:")), qe(C("span", null, null, 512), [[b, { val: e.currentPlateRow.detailMete || 0, dp: l(n).weight.precision }]]), y[15] || (y[15] = Te(")"))])) : H("", true)])])) : H("", true);
  };
} }, YW = Object.freeze(Object.defineProperty({ __proto__: null, default: yv }, Symbol.toStringTag, { value: "Module" })), KW = { key: 0, class: "return-material-info" }, WW = { class: "info-item" }, jW = { class: "info-item" }, FW = { class: "info-item" }, zW = { class: "info-item" }, BW = { class: "important-info" }, HW = { class: "info-item" }, qW = { class: "important-info" }, GW = { class: "info-item" }, QW = { class: "info-item" }, ZW = { class: "info-item" }, JW = { class: "info-item" }, XW = { class: "info-item" }, $W = { key: 0 }, ej = { class: "info-item" }, tj = { key: 0 }, ij = { class: "info-item" }, aj = { class: "info-item" }, lj = { class: "info-item" }, oj = { class: "returnable-number" }, nj = { class: "info-item" }, Tv = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, { baseUnit: n } = ai(o.basicClass), c = Ee(() => Be(o.material.returnableMete, o.material.accountingPrecision));
  return (u, r) => {
    var M;
    const E = _t("to-fixed"), y = _t("parse-project"), b = _t("empty-text"), V = _t("parse-time");
    return l(A)(e.material) ? (w(), Q("div", KW, [C("span", WW, [r[0] || (r[0] = C("span", null, "编号", -1)), C("span", null, K(e.material.serialNumber), 1)]), C("span", jW, [r[1] || (r[1] = C("span", null, "种类", -1)), C("span", null, K(e.material.classifyFullName), 1)]), C("span", FW, [r[2] || (r[2] = C("span", null, "规格", -1)), C("span", null, K(e.material.specification), 1)]), C("span", zW, [C("span", null, "厚度(" + K(l(n).thickness.unit) + ")", 1), qe(C("span", BW, null, 512), [[E, { val: e.material.thickness || 0, dp: l(n).thickness.precision }]])]), C("span", HW, [C("span", null, "宽度(" + K(l(n).width.unit) + ")", 1), qe(C("span", qW, null, 512), [[E, { val: e.material.width || 0, dp: l(n).width.precision }]])]), C("span", GW, [r[3] || (r[3] = C("span", null, "颜色", -1)), C("span", null, K(e.material.color), 1)]), C("span", QW, [r[4] || (r[4] = C("span", null, "品牌", -1)), C("span", null, K(e.material.brand), 1)]), C("span", ZW, [r[5] || (r[5] = C("span", null, "炉批号", -1)), C("span", null, K(e.material.heatNoAndBatchNo), 1)]), r[12] || (r[12] = C("br", null, null, -1)), C("span", JW, [r[6] || (r[6] = C("span", null, "项目", -1)), qe(C("span", null, null, 512), [[y, { project: e.material.project, onlyShortName: true }], [b]])]), C("span", XW, [r[7] || (r[7] = C("span", null, "车间", -1)), e.material.workshop ? (w(), Q("span", $W, K(e.material.workshop.name), 1)) : H("", true)]), C("span", ej, [r[8] || (r[8] = C("span", null, "仓库", -1)), e.material.warehouse ? (w(), Q("span", tj, K(e.material.warehouse.name), 1)) : H("", true)]), C("span", ij, [r[9] || (r[9] = C("span", null, "领用人", -1)), C("span", null, K(e.material.recipientName), 1)]), C("span", aj, [r[10] || (r[10] = C("span", null, "出库日期", -1)), qe(C("span", null, null, 512), [[V, { val: e.material.createTime, fmt: "{y}-{m}-{d}" }]])]), C("span", lj, [C("span", null, "长度(" + K(l(n).measure.unit) + ")", 1), qe(C("span", oj, null, 512), [[E, { val: e.material.quantity || 0, dp: ((M = e.material) == null ? void 0 : M.measurePrecision) || l(n).measure.precision }]])]), C("span", nj, [C("span", null, "总重(" + K(l(n).weight.unit) + ")", 1), qe(C("span", { style: ri({ color: c.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[E, { val: c.value || 0, dp: l(n).weight.precision }]]), r[11] || (r[11] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[E, { val: e.material.mete || 0, dp: l(n).weight.precision }]])])])) : H("", true);
  };
} }, sj = Object.freeze(Object.defineProperty({ __proto__: null, default: Tv }, Symbol.toStringTag, { value: "Module" })), rj = { key: 0, class: "return-material-info" }, uj = { class: "info-item" }, cj = { class: "info-item" }, dj = { class: "info-item" }, mj = { class: "info-item" }, pj = { class: "info-item" }, hj = { class: "info-item" }, fj = { class: "info-item" }, gj = { key: 0 }, Ej = { class: "info-item" }, yj = { key: 0 }, Tj = { class: "info-item" }, _j = { class: "info-item" }, bj = { class: "info-item" }, Vj = { class: "returnable-number" }, wj = { class: "important-info" }, Sj = { class: "info-item" }, vj = { class: "info-item" }, hm = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, n = Ee(() => Be(o.material.returnableMete, o.material.accountingPrecision)), c = Ee(() => Be(o.material.returnableQuantity, o.material.measurePrecision));
  return (u, r) => {
    const E = _t("parse-project"), y = _t("empty-text"), b = _t("parse-time"), V = _t("to-fixed");
    return l(A)(e.material) ? (w(), Q("div", rj, [C("span", uj, [r[0] || (r[0] = C("span", null, "编号", -1)), C("span", null, K(e.material.serialNumber), 1)]), C("span", cj, [r[1] || (r[1] = C("span", null, "种类", -1)), C("span", null, K(e.material.classifyFullName), 1)]), C("span", dj, [r[2] || (r[2] = C("span", null, "规格", -1)), C("span", null, K(e.material.specification), 1)]), C("span", mj, [r[3] || (r[3] = C("span", null, "颜色", -1)), C("span", null, K(e.material.color), 1)]), C("span", pj, [r[4] || (r[4] = C("span", null, "品牌", -1)), C("span", null, K(e.material.brand), 1)]), r[14] || (r[14] = C("br", null, null, -1)), C("span", hj, [r[5] || (r[5] = C("span", null, "项目", -1)), qe(C("span", null, null, 512), [[E, { project: e.material.project, onlyShortName: true }], [y]])]), C("span", fj, [r[6] || (r[6] = C("span", null, "车间", -1)), e.material.workshop ? (w(), Q("span", gj, K(e.material.workshop.name), 1)) : H("", true)]), C("span", Ej, [r[7] || (r[7] = C("span", null, "仓库", -1)), e.material.warehouse ? (w(), Q("span", yj, K(e.material.warehouse.name), 1)) : H("", true)]), C("span", Tj, [r[8] || (r[8] = C("span", null, "领用人", -1)), C("span", null, K(e.material.recipientName), 1)]), C("span", _j, [r[9] || (r[9] = C("span", null, "出库日期", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.createTime, fmt: "{y}-{m}-{d}" }]])]), e.material.measureUnit ? (w(), Q(Qe, { key: 0 }, [C("span", bj, [r[10] || (r[10] = C("span", null, " 单位净量 ", -1)), qe(C("span", Vj, null, 512), [[V, { val: e.material.outboundUnitType === l(hi).MEASURE.V ? e.material.unitNet : e.material.accountingUnitNet, dp: e.material.outboundUnitType === l(hi).MEASURE.V ? e.material.accountingPrecision : e.material.measurePrecision }]]), r[11] || (r[11] = Te("  ")), C("span", wj, K(e.material.outboundUnitType === l(hi).MEASURE.V ? `${e.material.accountingUnit} / ${e.material.measureUnit}` : `${e.material.measureUnit} / ${e.material.accountingUnit}`), 1)]), C("span", Sj, [C("span", null, "数量(" + K(e.material.measureUnit) + ")", 1), qe(C("span", { style: ri({ color: c.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[V, { val: c.value || 0, dp: e.material.measurePrecision }]]), r[12] || (r[12] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[V, { val: e.material.quantity || 0, dp: e.material.measurePrecision }]])])], 64)) : H("", true), C("span", vj, [C("span", null, "核算量(" + K(e.material.accountingUnit) + ")", 1), qe(C("span", { style: ri({ color: n.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[V, { val: n.value || 0, dp: e.material.accountingPrecision }]]), r[13] || (r[13] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[V, { val: e.material.mete || 0, dp: e.material.accountingPrecision }]])])])) : H("", true);
  };
} }, Rj = Object.freeze(Object.defineProperty({ __proto__: null, default: hm }, Symbol.toStringTag, { value: "Module" })), Mj = { key: 0, class: "return-material-info" }, Aj = { class: "info-item" }, Nj = { class: "info-item" }, Lj = { class: "info-item" }, Ij = { class: "info-item" }, Cj = { class: "info-item" }, Pj = { class: "info-item" }, Oj = { key: 0 }, kj = { class: "info-item" }, Dj = { key: 0 }, xj = { class: "info-item" }, Uj = { class: "info-item" }, Yj = { class: "info-item" }, Kj = { class: "returnable-number" }, Wj = { class: "important-info" }, jj = { class: "info-item" }, Fj = { class: "info-item" }, _v = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, n = Ee(() => Be(o.material.returnableMete, o.material.accountingPrecision)), c = Ee(() => Be(o.material.returnableQuantity, o.material.measurePrecision));
  return (u, r) => {
    const E = _t("parse-project"), y = _t("empty-text"), b = _t("parse-time"), V = _t("to-fixed");
    return l(A)(e.material) ? (w(), Q("div", Mj, [C("span", Aj, [r[0] || (r[0] = C("span", null, "编号", -1)), C("span", null, K(e.material.serialNumber), 1)]), C("span", Nj, [r[1] || (r[1] = C("span", null, "种类", -1)), C("span", null, K(e.material.classifyFullName), 1)]), C("span", Lj, [r[2] || (r[2] = C("span", null, "规格", -1)), C("span", null, K(e.material.specification), 1)]), C("span", Ij, [r[3] || (r[3] = C("span", null, "品牌", -1)), C("span", null, K(e.material.brand), 1)]), r[13] || (r[13] = C("br", null, null, -1)), C("span", Cj, [r[4] || (r[4] = C("span", null, "项目", -1)), qe(C("span", null, null, 512), [[E, { project: e.material.project, onlyShortName: true }], [y]])]), C("span", Pj, [r[5] || (r[5] = C("span", null, "车间", -1)), e.material.workshop ? (w(), Q("span", Oj, K(e.material.workshop.name), 1)) : H("", true)]), C("span", kj, [r[6] || (r[6] = C("span", null, "仓库", -1)), e.material.warehouse ? (w(), Q("span", Dj, K(e.material.warehouse.name), 1)) : H("", true)]), C("span", xj, [r[7] || (r[7] = C("span", null, "领用人", -1)), C("span", null, K(e.material.recipientName), 1)]), C("span", Uj, [r[8] || (r[8] = C("span", null, "出库日期", -1)), qe(C("span", null, null, 512), [[b, { val: e.material.createTime, fmt: "{y}-{m}-{d}" }]])]), e.material.measureUnit ? (w(), Q(Qe, { key: 0 }, [C("span", Yj, [r[9] || (r[9] = C("span", null, " 单位净量 ", -1)), qe(C("span", Kj, null, 512), [[V, { val: e.material.outboundUnitType === l(hi).MEASURE.V ? e.material.unitNet : e.material.accountingUnitNet, dp: e.material.outboundUnitType === l(hi).MEASURE.V ? e.material.accountingPrecision : e.material.measurePrecision }]]), r[10] || (r[10] = Te("  ")), C("span", Wj, K(e.material.outboundUnitType === l(hi).MEASURE.V ? `${e.material.accountingUnit} / ${e.material.measureUnit}` : `${e.material.measureUnit} / ${e.material.accountingUnit}`), 1)]), C("span", jj, [C("span", null, "数量(" + K(e.material.measureUnit) + ")", 1), qe(C("span", { style: ri({ color: c.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[V, { val: c.value || 0, dp: e.material.measurePrecision }]]), r[11] || (r[11] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[V, { val: e.material.quantity || 0, dp: e.material.measurePrecision }]])])], 64)) : H("", true), C("span", Fj, [C("span", null, "核算量(" + K(e.material.accountingUnit) + ")", 1), qe(C("span", { style: ri({ color: n.value < 0 ? "red" : "#67c23a" }) }, null, 4), [[V, { val: n.value || 0, dp: e.material.accountingPrecision }]]), r[12] || (r[12] = C("span", null, " / ", -1)), qe(C("span", null, null, 512), [[V, { val: e.material.mete || 0, dp: e.material.accountingPrecision }]])])])) : H("", true);
  };
} }, zj = Object.freeze(Object.defineProperty({ __proto__: null, default: _v }, Symbol.toStringTag, { value: "Module" }));
const Bj = { __name: "index", props: { basicClass: { type: Number }, material: { type: Object, default: () => ({}) }, currentPlateRow: { type: Object, default: () => ({}) } }, setup(e) {
  const o = e, n = Ee(() => {
    switch (o.basicClass) {
      case dt.STEEL_PLATE.V:
        return Ev;
      case dt.SECTION_STEEL.V:
        return yv;
      case dt.STEEL_COIL.V:
        return Tv;
      case dt.MATERIAL.V:
        return hm;
      case dt.GAS.V:
        return _v;
      default:
        return hm;
    }
  });
  return (c, u) => (w(), U(Ri(n.value), { basicClass: e.basicClass, material: e.material, currentPlateRow: e.currentPlateRow }, null, 8, ["basicClass", "material", "currentPlateRow"]));
} }, gu = ut(Bj, [["__scopeId", "data-v-10918443"]]), Hj = Object.freeze(Object.defineProperty({ __proto__: null, default: gu }, Symbol.toStringTag, { value: "Module" })), K_ = { __name: "title-after-info", props: { detail: { type: Object, default: () => ({}) } }, setup(e) {
  return (o, n) => {
    const c = wi;
    return w(), Q(Qe, null, [e.detail.applicant ? (w(), U(c, { key: 0, effect: "dark", type: "success" }, { default: p(() => [Te(K(`申请人：${e.detail.applicant.name} | ${e.detail.applicant.deptName}`), 1)]), _: 1 })) : H("", true), s(c, { effect: "plain" }, { default: p(() => [Te(K(`退库申请时间：${l(Qi)(e.detail.createTime)}`), 1)]), _: 1 }), s(c, { effect: "plain" }, { default: p(() => [Te(K(e.detail.boolRealReturn ? "真实" : "虚拟") + "退库", 1)]), _: 1 }), s(c, { effect: "plain", type: "warning" }, { default: p(() => {
      var u;
      return [Te("退库类型：" + K(l(Jt).VL[(u = e.detail) == null ? void 0 : u.outboundTypeSelection]), 1)];
    }), _: 1 }), s(c, { effect: "plain" }, { default: p(() => [Te(K(l(kl).VL[e.detail.returnDestination]), 1)]), _: 1 })], 64);
  };
} }, qj = Object.freeze(Object.defineProperty({ __proto__: null, default: K_ }, Symbol.toStringTag, { value: "Module" }));
const Gj = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, Qj = { __name: "detail", setup(e) {
  const o = Z(), n = Z(), c = Z([]), u = Z(), r = Z({}), E = Z([...Da, ["remark", "empty-text"], ["realTime", "parse-time"]]), { CRUD: y, crud: b, detail: V } = qi(), { baseUnit: M } = ai(), { maxHeight: g } = Kt({ mainBox: ".raw-mat-return-application-record-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !b.detailLoading)), S = Ee(() => V && V.serialNumber ? `退库单：${V.serialNumber}` : "退库单");
  y.HOOK.beforeDetailLoaded = async (f, m) => {
    c.value = [], u.value = void 0, r.value = {};
    const R = [], v = [];
    (m.basicClass === dt.STEEL_PLATE.V || m.basicClass & dt.SECTION_STEEL.V) && m.list.forEach(async (P) => {
      if (P.boolReturns && A(P.list)) {
        await Qt(P.list);
        const L = await Ut(P.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] }), O = P.list.map((I) => I.source);
        await Qt(O);
        const x = await Ut(O, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        R.push(L), v.push(x);
      }
    }), await Promise.all(v), await Promise.all(R), await Qt(m.list), await Ut(m.list, { toNum: true });
    const N = m.list.map((P) => P.source);
    await Qt(N), await Ut(N, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), m.list.forEach((P) => {
      P.actualMete = P.mete;
    }), (m.basicClass === dt.STEEL_PLATE.V || m.basicClass === dt.SECTION_STEEL.V) && m.list.forEach(async (P) => {
      if (P.uid = P.id, P.boolReturns && A(P.list)) {
        pt(() => {
          c.value.push[P.id];
        });
        let L = 0;
        P.list.forEach((O) => {
          O.pid = P.id, O.uid = O.id, O.singleReturnMete && (L += O.singleReturnMete);
        }), P.detailMete = Be(L, M.value[m.basicClass].weight.precision) * (P.quantity || 0), P.actualMete = P.detailMete;
      }
    });
  };
  function h(f, m, R) {
    r.value = f, u.value = f.source;
  }
  async function T(f) {
    f.loading = true;
    try {
      f.wmsApproveFlowDTOS = await Jn(f.approveRecordId);
    } catch (m) {
      console.log(m, "获取失败");
    } finally {
      f.loading = false;
    }
  }
  function _(f) {
    const m = V.basicClass && M.value && M.value[V.basicClass] ? M.value[V.basicClass].measure.precision : 0;
    return Hi(f, { props: [["quantity", m], ["actualMete", ei.weight.precision], "mete"] });
  }
  return (f, m) => {
    const R = Ve("common-button"), v = La, N = wi, P = vt, L = Ve("common-table"), O = Ve("common-drawer"), x = oi;
    return w(), U(O, { ref_key: "drawerRef", ref: o, "before-close": l(b).cancelDetail, "content-loading": l(b).detailLoading, "show-close": true, title: S.value, visible: l(b).detailVisible, "custom-class": "raw-mat-return-application-record-detail", size: "100%" }, { titleAfter: p(() => [s(K_, { detail: l(V) }, null, 8, ["detail"])]), titleRight: p(() => [s(v, { width: 400, placement: "bottom", trigger: "click", onShow: m[0] || (m[0] = (I) => T(l(V))) }, { reference: p(() => [s(R, { size: "default" }, { default: p(() => m[2] || (m[2] = [Te("查看审批记录")])), _: 1, __: [2] })]), default: p(() => [qe((w(), Q("div", Gj, [s(tl, { data: l(V).wmsApproveFlowDTOS }, null, 8, ["data"])])), [[x, l(V).loading]])]), _: 1 }), l(A)(l(V).reviewStatus) ? (w(), U(N, { key: 0, type: l(_n).V[l(V).reviewStatus].TAG, size: "large", style: { "margin-right": "10px" } }, { default: p(() => [Te(K(l(_n).VL[l(V).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)]), content: p(() => [s(gu, { "basic-class": l(V).basicClass, material: u.value, class: "material-info" }, null, 8, ["basic-class", "material"]), s(L, { ref_key: "tableRef", ref: n, data: l(V).list, "data-format": E.value, "expand-row-keys": c.value, "max-height": l(g), "summary-method": _, "default-expand-all": "", "highlight-current-row": "", "row-key": "id", "show-summary": "", onRowClick: h }, { default: p(() => [s(Ha, { "expand-row-keys": c.value, "onUpdate:expandRowKeys": m[1] || (m[1] = (I) => c.value = I), data: l(V).list, fixed: "left", "row-key": "id" }, { default: p(({ row: I }) => [(l(V).basicClass === l(dt).STEEL_PLATE.V || l(V).basicClass === l(dt).SECTION_STEEL.V) && I.boolReturns ? (w(), U(L, { key: I.id, class: Zt(r.value.uid === I.uid ? "child-table" : ""), data: I.list, stripe: false, style: { margin: "10px 0" } }, { default: p(() => [s(fa, { "basic-class": I.basicClass, fixed: "left" }, { afterMaterialSn: p(() => [s(P, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 2 }, 1032, ["basic-class"]), s(Ba, { "basic-class": I.basicClass }, null, 8, ["basic-class"]), s(P, { label: `数量 (${l(M)[l(V).basicClass].measure.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, null, 8, ["label"]), s(P, { key: "singleReturnMete", label: `总重 (${l(M)[l(V).basicClass].weight.unit})`, align: "center", prop: "singleReturnMete", width: "120px" }, null, 8, ["label"]), s(xl)]), _: 2 }, 1032, ["class", "data"])) : H("", true), s(Xl, { "basic-class": I.basicClass, row: I, "show-batch-no": false, "show-graphics": "", "show-remark": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(V).basicClass, showTip: l(V).basicClass === l(dt).STEEL_PLATE.V || l(V).basicClass === l(dt).SECTION_STEEL.V, fixed: "left" }, { afterMaterialSn: p(() => [s(P, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class", "showTip"]), s(Ba, { "basic-class": l(V).basicClass }, null, 8, ["basic-class"]), s(Y_, { "basic-class": l(V).basicClass, showTip: l(V).basicClass === l(dt).STEEL_PLATE.V || l(V).basicClass === l(dt).SECTION_STEEL.V }, null, 8, ["basic-class", "showTip"]), s(xl, { "show-project": "", "show-monomer": false, "show-area": false }), s(Vr, { label: "实际退库时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, bv = ut(Qj, [["__scopeId", "data-v-6ce87e31"]]), Zj = Object.freeze(Object.defineProperty({ __proto__: null, default: bv }, Symbol.toStringTag, { value: "Module" }));
const Jj = { __name: "manuf-detail", setup(e) {
  const o = Z(), n = Z(), c = Z([]), u = Z(), r = Z([...Da, ["remark", "empty-text"], ["basicClass", ["parse-enum", bs, { f: "L" }]]]), { CRUD: E, crud: y, detail: b } = qi(), { maxHeight: V } = Kt({ mainBox: ".raw-mat-return-application-record-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !y.detailLoading)), M = Ee(() => b && b.serialNumber ? `退库单：${b.serialNumber}` : "退库单");
  E.HOOK.beforeDetailLoaded = async (S, h) => {
    h.list = await fo(h.list, { toSmallest: false, toNum: false }, { mete: ["mete"], quantity: ["quantity"] });
  };
  function g(S) {
    return Hi(S, { props: ["quantity", ["totalWeight", ei.weight.precision], "totalLength", "totalArea"] });
  }
  return (S, h) => {
    const T = wi, _ = vt, f = Ve("common-table"), m = Ve("common-drawer");
    return w(), U(m, { ref_key: "drawerRef", ref: o, "before-close": l(y).cancelDetail, "content-loading": l(y).detailLoading, "show-close": true, title: M.value, visible: l(y).detailVisible, "custom-class": "raw-mat-return-application-record-detail", size: "100%" }, { titleAfter: p(() => [l(b).applicant ? (w(), U(T, { key: 0, effect: "dark", type: "success" }, { default: p(() => [Te(K(`申请人：${l(b).applicant.name} | ${l(b).applicant.deptName}`), 1)]), _: 1 })) : H("", true), s(T, { effect: "plain" }, { default: p(() => [Te(K(`退库申请时间：${l(Qi)(l(b).createTime)}`), 1)]), _: 1 }), s(T, { effect: "plain" }, { default: p(() => [Te(K(l(b).boolRealReturn ? "真实" : "虚拟") + "退库", 1)]), _: 1 })]), titleRight: p(() => [l(A)(l(b).reviewStatus) ? (w(), U(T, { key: 0, type: l(po).V[l(b).reviewStatus].TAG, size: "large", style: { "margin-right": "10px" } }, { default: p(() => [Te(K(l(po).VL[l(b).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)]), content: p(() => [s(gu, { "basic-class": l(b).basicClass, material: u.value, class: "material-info" }, null, 8, ["basic-class", "material"]), s(f, { ref_key: "tableRef", ref: n, data: l(b).list, "data-format": r.value, "expand-row-keys": c.value, "max-height": l(V), "summary-method": g, "default-expand-all": "", "highlight-current-row": "", "row-key": "id", "show-summary": "" }, { default: p(() => [s(_, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(_, { key: "basicClass", align: "center", label: "物料种类", prop: "basicClass", "show-overflow-tooltip": "" }), s(_, { key: "manufacturedName", align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), s(_, { key: "manufacturedSn", align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), s(_, { key: "specification", align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), l(b).basicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(_, { key: "monomer.name", align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), s(_, { key: "area.name", align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), s(_, { key: "length", align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" })], 64)) : (w(), Q(Qe, { key: 1 }, [s(_, { key: "length", align: "center", label: "厚度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(_, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })], 64)), s(_, { key: "material", align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), l(b).basicClass === l(Pe).ENCL_MANUFACTURED.V ? (w(), Q(Qe, { key: 2 }, [s(_, { key: "width", align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), s(_, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), s(_, { key: "color", align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), s(_, { key: "length", align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), s(_, { key: "quantity", align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), s(_, { key: "totalLength", align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: R } }) => [C("span", null, K(l(Be)(R.quantity * R.length, 2)), 1)]), _: 1 }), s(_, { key: "totalArea", align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), s(_, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)) : (w(), Q(Qe, { key: 3 }, [s(_, { key: "quantity", align: "center", label: "数量", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: R } }) => [Te(K(R.quantity), 1)]), _: 1 }), l(b).basicClass === l(Pe).STRUC_MANUFACTURED.V ? (w(), Q(Qe, { key: 0 }, [s(_, { key: "weight", align: "center", label: "单重（kg）", "min-width": "120px", prop: "weight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: R } }) => [Te(K(l(St)(l(Be)(R.weight, l(Ft).WEIGHT_DP), l(Ft).WEIGHT, "kg")), 1)]), _: 1 }), s(_, { key: "totalWeight", align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: p(({ row: { sourceRow: R } }) => [Te(K(l(St)(l(Be)(R.totalWeight, l(Ft).WEIGHT_DP), l(Ft).WEIGHT, "kg")), 1)]), _: 1 })], 64)) : H("", true)], 64))]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, Vv = ut(Jj, [["__scopeId", "data-v-30f53bc8"]]), Xj = Object.freeze(Object.defineProperty({ __proto__: null, default: Vv }, Symbol.toStringTag, { value: "Module" }));
const $j = { __name: "title-after-info", props: { order: { type: Object, default: () => ({}) }, detail: { type: Object, default: () => ({}) } }, setup(e) {
  return (o, n) => {
    const c = wi, u = _t("parse-enum");
    return w(), Q(Qe, null, [e.order.supplyType ? qe((w(), U(c, { key: 0, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Ni), v: e.order.supplyType }]]) : H("", true), e.order.weightMeasurementMode ? qe((w(), U(c, { key: 1, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Wt), v: e.order.weightMeasurementMode }]]) : H("", true), e.order.purchaseOrderPaymentMode ? qe((w(), U(c, { key: 2, type: "info", effect: "plain" }, null, 512)), [[u, { e: l(Jl), v: e.order.purchaseOrderPaymentMode }]]) : H("", true)], 64);
  };
} }, wv = ut($j, [["__scopeId", "data-v-fe9bd2f8"]]), eF = Object.freeze(Object.defineProperty({ __proto__: null, default: wv }, Symbol.toStringTag, { value: "Module" }));
const tF = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, iF = { key: 0, class: "footer" }, aF = { class: "remark" }, lF = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, { decimalPrecision: u } = Ln(), r = ft("permission"), E = Z(), y = Z([]), b = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", u.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", u.value.wms]], ["unitPriceExcludingVATNoFreight", ["to-thousand", u.value.wms]], ["unitPriceNoFreight", ["to-thousand", u.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["amountNoFreight", ["to-thousand", Ze.YUAN]], ["amountExcludingVATNoFreight", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["inputVATNoFreight", ["to-thousand", Ze.YUAN]], ["realTime", "parse-time"]]), { CRUD: V, crud: M, detail: g } = qi(), { maxHeight: S } = Kt({ mainBox: ".raw-mat-inbound-application-review-detail", extraBox: [".el-drawer__header", ".unfreeze-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !M.detailLoading)), h = Ee(() => g.purchaseOrder || {}), T = Ee(() => Ai(r.showAmount)), _ = Ee(() => {
    var L;
    return ((L = h.value) == null ? void 0 : L.supplyType) === Ni.PARTY_A.V;
  }), f = Ee(() => M.detailLoading ? "退货单" : `退货单：${g.serialNumber}（ ${h.value.supplier ? h.value.supplier.name : ""} ）`), m = Z(false), R = Z();
  V.HOOK.beforeDetailLoaded = async (L, O) => {
    R.value = void 0, await Qt(O.list), O.list = await Ut(O.list, { toSmallest: false, toNum: false }, { amount: ["unitPriceNoFreight", "unitPrice", "unitPriceExcludingVAT", "unitPriceExcludingVATNoFreight"] });
  };
  async function v(L) {
    L.loading = true;
    try {
      Ae(L.wmsApproveRecordFlowDTO) && (L.wmsApproveRecordFlowDTO = await Jn(L.journalId));
    } catch (O) {
      console.log(O, "获取失败");
    } finally {
      L.loading = false;
    }
  }
  async function N(L) {
    try {
      if (m.value = true, L === Lt.REFUSE.V && !A(R.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const O = { approveRecordId: g.approveRecordId, decision: L, opinion: R.value };
      await JU(O), L === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), n("auditSuccess");
    } catch (O) {
      console.log("出库(审批流)审核提交", O);
    } finally {
      m.value = false;
    }
  }
  function P(L) {
    return Hi(L, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN], ["amountExcludingVAT", Ze.YUAN], ["inputVAT", Ze.YUAN], ["amountNoFreight", Ze.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT", "amountNoFreight"] });
  }
  return (L, O) => {
    const x = wi, I = Ve("common-button"), Y = La, ee = pa, B = vt, q = Ve("common-table"), ae = Mt, j = Ve("common-drawer"), le = oi, oe = _t("empty-text");
    return w(), U(j, { ref_key: "drawerRef", ref: E, "before-close": l(M).cancelDetail, "content-loading": l(M).detailLoading, "show-close": true, title: f.value, visible: l(M).detailVisible, "custom-class": "raw-mat-inbound-application-review-detail", size: "100%" }, { titleAfter: p(() => [s(wv, { detail: l(g), order: h.value }, null, 8, ["detail", "order"]), l(g).rejectFreightType ? (w(), U(x, { key: 0 }, { default: p(() => [Te(K(l(kc).VL[l(g).rejectFreightType]), 1)]), _: 1 })) : H("", true), l(g).freight ? (w(), U(x, { key: 1, type: "warning" }, { default: p(() => [Te("退运费金额:" + K(l(Mi)(l(g).freight, l(Ze).YUAN)), 1)]), _: 1 })) : H("", true)]), titleRight: p(() => [s(Y, { width: 400, placement: "top", trigger: "click", onShow: O[0] || (O[0] = (ye) => v(l(g))) }, { reference: p(() => [s(I, { size: "default" }, { default: p(() => O[4] || (O[4] = [Te("查看审批记录")])), _: 1, __: [4] })]), default: p(() => [qe((w(), Q("div", tF, [s(tl, { data: l(g).wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[le, l(g).loading]])]), _: 1 }), c.ApprovalFlag ? (w(), Q("div", iF, [s(ee, { title: "确认通过", onConfirm: O[1] || (O[1] = (ye) => N(l(Lt).PASS.V)) }, { reference: p(() => [s(I, { loading: m.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => O[5] || (O[5] = [Te(" 通过 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 }), s(ee, { title: "确认驳回", onConfirm: O[2] || (O[2] = (ye) => N(l(Lt).REFUSE.V)) }, { reference: p(() => [s(I, { loading: m.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => O[6] || (O[6] = [Te(" 驳回 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : H("", true), T.value ? (w(), U(br, { key: 1, "purchase-id": h.value.id, size: "default" }, null, 8, ["purchase-id"])) : H("", true)]), content: p(() => [l(g).boolHasUnfreeze ? (w(), U(fu, { key: 0, "basic-class": l(g).basicClass, list: l(g).unfreezeList, class: "unfreeze-info" }, null, 8, ["basic-class", "list"])) : H("", true), s(q, { data: l(g).list, "data-format": b.value, "expand-row-keys": y.value, "max-height": l(S), "summary-method": P, "row-key": "id", "show-summary": "" }, { default: p(() => [s(fa, { "basic-class": l(g).basicClass }, { afterMaterialSn: p(() => [s(B, { key: "materialSnNew", "show-overflow-tooltip": true, label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class"]), s(Ba, { "basic-class": l(g).basicClass }, null, 8, ["basic-class"]), s(za, { "basic-class": l(g).basicClass }, null, 8, ["basic-class"]), T.value ? (w(), Q(Qe, { key: 0 }, [_.value ? H("", true) : (w(), U(dc, { key: 0 }))], 64)) : H("", true), s(xl, { "show-project": "", "show-monomer": false, "show-area": false }), s(Vr, { label: "实际退货时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), C("p", aF, [O[7] || (O[7] = C("span", { class: "label-after" }, "备注", -1)), qe(C("span", null, null, 512), [[oe, l(g).remark]])]), c.ApprovalFlag ? (w(), U(ae, { key: 1, modelValue: R.value, "onUpdate:modelValue": O[3] || (O[3] = (ye) => R.value = ye), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, W_ = ut(lF, [["__scopeId", "data-v-98016bd6"]]), oF = Object.freeze(Object.defineProperty({ __proto__: null, default: W_ }, Symbol.toStringTag, { value: "Module" })), j_ = (e) => {
  const o = Ht(), n = Ee(() => o.state.config.loaded.matClsTree);
  if (n.value || o.dispatch("config/fetchMatClsTree"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { manufClsLeafList: Ee(() => o.state.config.manufClsLeafList), rawMatClsLeafList: Ee(() => o.state.config.rawMatClsLeafList), matClsLeafList: Ee(() => o.state.config.matClsLeafList), rawMatClsKV: Ee(() => o.state.config.rawMatClsKV), matClsTree: Ee(() => o.state.config.matClsTree), firstLevelSubjectTree: Ee(() => o.state.config.firstLevelSubjectTree), loaded: n };
}, nF = { class: "main-content" }, sF = { class: "form-left" }, rF = { class: "project-name" }, Sv = { __name: "detail", setup(e) {
  const { CRUD: o, crud: n, detail: c } = qi(), { loaded: u } = j_();
  return o.HOOK.beforeDetailLoaded = async (r, E) => {
    E.supplementNo = E.serialNumber;
    const y = [E];
    await Qt(y), E = await Ut(y)[0];
  }, (r, E) => {
    var T;
    const y = Zi, b = Li, V = Ve("common-drawer"), M = _t("parse-time"), g = _t("empty-text"), S = _t("thousand"), h = _t("parse-enum");
    return w(), U(V, { ref: "drawerRef", visible: l(n).detailVisible, "content-loading": !l(u) || l(n).detailLoading, "before-close": l(n).cancelDetail, title: `调整单：${(T = l(c)) == null ? void 0 : T.supplementNo}`, "show-close": true, size: "620px", "custom-class": "purchase-order-raw-mat-detail" }, { content: p(() => [C("div", nF, [l(A)(l(c)) ? (w(), U(b, { key: 0, model: l(c), size: "default", "label-position": "left", "label-width": "100px" }, { default: p(() => [C("div", sF, [s(y, { label: "创建时间", prop: "createTime" }, { default: p(() => [qe(C("span", null, null, 512), [[M, l(c).createTime]])]), _: 1 }), s(y, { label: "退库单号", prop: "receipt.serialNumber" }, { default: p(() => {
      var _;
      return [qe((w(), Q("span", null, [Te(K((_ = l(c).receipt) == null ? void 0 : _.serialNumber), 1)])), [[g]])];
    }), _: 1 }), s(y, { label: "项目", prop: "project" }, { default: p(() => [C("span", rF, K(l(di)(l(c).project)), 1)]), _: 1 }), s(y, { label: "单体", prop: "monomerName" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).monomerName), 1)])), [[g]])]), _: 1 }), s(y, { label: "区域", prop: "areaName" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).areaName), 1)])), [[g]])]), _: 1 }), s(y, { label: "车间", prop: "workshop.name" }, { default: p(() => {
      var _;
      return [qe((w(), Q("span", null, [Te(K((_ = l(c).workshop) == null ? void 0 : _.name), 1)])), [[g]])];
    }), _: 1 }), s(y, { label: "调整金额", prop: "amount" }, { default: p(() => [qe(C("span", null, null, 512), [[S, l(c).amount]])]), _: 1 }), s(y, { label: "物料编号", prop: "serialNumber" }, { default: p(() => [qe(C("span", null, null, 512), [[S, l(c).serialNumber]])]), _: 1 }), s(y, { label: "物料种类", prop: "basicClass" }, { default: p(() => [qe(C("span", null, null, 512), [[h, { e: l(Ge), v: l(c).basicClass, bit: true, split: " | " }]])]), _: 1 }), s(y, { label: "规格", prop: "specification" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(Ki)(l(c))), 1)])), [[g]])]), _: 1 }), s(y, { label: "核算量", prop: "mete" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).mete), 1)])), [[g]])]), _: 1 }), s(y, { label: "核算单位", prop: "accountingUnit" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).accountingUnit), 1)])), [[g]])]), _: 1 }), s(y, { label: "品牌", prop: "brand" }, { default: p(() => [qe((w(), Q("span", null, [Te(K(l(c).brand), 1)])), [[g]])]), _: 1 })])]), _: 1 }, 8, ["model"])) : H("", true)])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, uF = Object.freeze(Object.defineProperty({ __proto__: null, default: Sv }, Symbol.toStringTag, { value: "Module" }));
const cF = { key: 0 }, dF = { key: 1 }, mF = { __name: "detail", setup(e) {
  const o = Z(), n = Z([["project", "parse-project"], ["quantity", ["to-fixed-field", "measurePrecision"]], ["mete", ["to-fixed-field", "accountingPrecision"]], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["boolOutbound", ["parse-enum", ea]]]), { CRUD: c, crud: u, detail: r } = qi(), { maxHeight: E } = Kt({ mainBox: ".convert-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, o);
  c.HOOK.beforeDetailLoaded = async (b, V) => {
    V.widthThick = V.thickness || V.width ? (V.thickness || "-") + "*" + (V.width || "-") : "-", await Qt(V.convertDetailDTOList), V.convertDetailDTOList = await Ut(V.convertDetailDTOList, { toSmallest: false, toNum: true });
  };
  function y(b) {
    return Hi(b, { props: ["quantity", ["mete", ei.weight.precision]] });
  }
  return (b, V) => {
    const M = wi, g = qa, S = Ga, h = Ml, T = vt, _ = Ve("common-table"), f = Ve("common-drawer"), m = oi;
    return w(), U(f, { ref_key: "drawerRef", ref: o, visible: l(u).detailVisible, "content-loading": l(u).detailLoading, "before-close": l(u).cancelDetail, title: "详情", "show-close": true, size: "85%", "custom-class": "convert-detail" }, { titleAfter: p(() => [s(M, { type: "success" }, { default: p(() => [Te("条板转换单：" + K(l(r).receiptSerialNumber), 1)]), _: 1 }), l(r).status === l(po).PASS.V ? (w(), U(M, { key: 0, type: "info" }, { default: p(() => [Te("出库单：" + K(l(r).outSerialNumber), 1)]), _: 1 })) : H("", true), l(r).boolPartyA ? (w(), U(M, { key: 1, type: "danger" }, { default: p(() => V[0] || (V[0] = [Te("甲供")])), _: 1, __: [0] })) : H("", true)]), titleRight: p(() => [s(ia, { params: { id: l(r).id }, fn: l(rv), size: "default" }, { default: p(() => V[1] || (V[1] = [Te("转换单详情下载")])), _: 1, __: [1] }, 8, ["params", "fn"])]), content: p(() => [s(M, { effect: "plain" }, { default: p(() => V[2] || (V[2] = [Te("原物料信息")])), _: 1, __: [2] }), s(S, { column: 3, border: "", style: { margin: "10px 0" } }, { default: p(() => [s(g, { "label-class-name": "contractLabel", label: "物料名称" }, { default: p(() => [Te(K(l(r).classifyName || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "物料编号" }, { default: p(() => [Te(K(l(r).serialNumber || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "规格" }, { default: p(() => [Te(K(l(r).specification || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "厚(mm)*宽(mm)" }, { default: p(() => [Te(K(l(r).widthThick || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "品牌" }, { default: p(() => [Te(K(l(r).brand || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "颜色" }, { default: p(() => [Te(K(l(r).color || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "卷号" }, { default: p(() => [Te(K(l(r).heatNoAndBatchNo || "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "项目" }, { default: p(() => [Te(K(l(r).project ? l(di)(l(r).project) : "-"), 1)]), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "仓库" }, { default: p(() => {
      var R;
      return [Te(K(((R = l(r).warehouse) == null ? void 0 : R.name) || "-"), 1)];
    }), _: 1 }), s(g, { "label-class-name": "contractLabel", label: "备注" }, { default: p(() => [Te(K(l(r).remark || "-"), 1)]), _: 1 })]), _: 1 }), s(h, null, { default: p(() => V[3] || (V[3] = [C("span", { class: "title" }, "转换后物料信息", -1)])), _: 1, __: [3] }), qe((w(), U(_, { data: l(r).convertDetailDTOList, "data-format": n.value, "show-summary": "", "summary-method": y, "max-height": l(E) - 220 }, { default: p(() => [s(T, { label: "序号", type: "index", align: "center", width: "60" }, { default: p(({ row: { sourceRow: R }, $index: v }) => [R.boolSurplus ? (w(), Q("span", cF, "余料")) : (w(), Q("span", dF, K(v + 1), 1))]), _: 1 }), s(T, { key: "serialNumber", prop: "serialNumber", label: "物料编号", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "length", prop: "length", label: "长(mm)", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "width", prop: "width", label: "宽(mm)", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "thickness", prop: "thickness", label: "厚(mm)", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "quantity", prop: "quantity", label: "数量（张）", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "mete", prop: "mete", label: "重量（kg）", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "150", "show-overflow-tooltip": "" }), s(T, { key: "monomerName", prop: "monomerName", label: "单体", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "areaName", prop: "areaName", label: "区域", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "workshopName", prop: "workshopName", label: "车间", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "warehouse.name", prop: "warehouse.name", label: "仓库", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "recipientName", prop: "recipientName", label: "领用人", align: "center", "show-overflow-tooltip": "" }), s(T, { key: "outboundTime", prop: "outboundTime", label: "出库时间", align: "center", "show-overflow-tooltip": "", width: "150" }), s(T, { key: "boolOutbound", prop: "boolOutbound", label: "是否出库", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[m, b.loading]])]), _: 1 }, 8, ["visible", "content-loading", "before-close"]);
  };
} }, vv = ut(mF, [["__scopeId", "data-v-b9816c18"]]), pF = Object.freeze(Object.defineProperty({ __proto__: null, default: vv }, Symbol.toStringTag, { value: "Module" }));
function hF(e) {
  return W({ module: "wms", url: "adjust/record/raw-adjust", method: "get", params: e });
}
function Eft(e) {
  return W({ module: "wms", url: "adjust/saveConvert", method: "put", data: e });
}
function Rv(e) {
  return W({ module: "wms", url: `adjust/receipt/${e}`, method: "get" });
}
function Mb(e) {
  return W({ url: "/api/wms/adjust/approval", method: "post", params: e });
}
function fF(e) {
  return W({ url: `/api/wms/adjust/revocation/${e.id}`, method: "post" });
}
const yft = { get: hF, detail: Rv };
const gF = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) }, submitType: { type: String, default: void 0 }, isReceipt: { type: Boolean, default: false }, journalId: { type: Number } }, emits: ["success", "update:modelValue"], setup(e, { emit: o }) {
  const { decimalPrecision: n } = Ln(), c = o, u = e, r = Ee(() => [...Da, ["invoiceType", ["parse-enum", fi, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", n.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", n.value.wms]], ["amount", ["to-thousand", Ze.YUAN]], ["amountExcludingVAT", ["to-thousand", Ze.YUAN]], ["inputVAT", ["to-thousand", Ze.YUAN]], ["pastAmount", ["to-thousand", Ze.YUAN]], ["pastAmountExcludingVAT", ["to-thousand", Ze.YUAN]], ["pastInputVAT", ["to-thousand", Ze.YUAN]], ["adjustAmount", ["to-thousand", Ze.YUAN]], ["adjustAmountExcludingVat", ["to-thousand", Ze.YUAN]], ["adjustInputVat", ["to-thousand", Ze.YUAN]], ["remark", "empty-text"]]), E = Z(), y = Z(false), b = Z(false), V = Z([]), M = Z(), g = Z({}), S = Ee(() => {
    var L;
    return y.value ? "入库单金额调整" : `调整单号：${(L = u.form) == null ? void 0 : L.showSerialNumber}金额调整`;
  }), { maxHeight: h } = Kt({ mainBox: ".raw-mat-price-adjust-review", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !y.value)), { visible: T, handleClose: _ } = Ta({ emit: c, props: u });
  Ce(() => u.form, async (L) => {
    f(), L && L.id && (M.value = L.id, y.value = true, m(L.id));
  }, { immediate: true, deep: true });
  function f() {
    y.value = false, b.value = false, V.value = [], g.value = { list: [] };
  }
  async function m(L) {
    if (!L) {
      g.value.list = [];
      return;
    }
    try {
      y.value = true, g.value.list = await Rv(L), await Qt(g.value.list), g.value.list = await Ut(g.value.list, { toSmallest: false, toNum: false }), console.log(g.value.list, "detailList");
    } catch (O) {
      console.log("加载失败", O);
    } finally {
      y.value = false;
    }
  }
  async function R() {
    try {
      const L = { id: u.form.id, approveRecordId: u.journalId, decision: Lt.PASS.V };
      b.value = true, await Mb(L), _(), c("success");
    } catch (L) {
      console.log("通过提交", L);
    } finally {
      b.value = false;
    }
  }
  async function v() {
    try {
      const L = { id: u.form.id, approveRecordId: u.journalId, decision: Lt.REFUSE.V };
      b.value = true, await Mb(L), _(), c("success");
    } catch (L) {
      console.log("通过提交", L);
    } finally {
      b.value = false;
    }
  }
  function N(L) {
    return Hi(L, { props: ["quantity", ["mete", ei.weight.precision], ["amount", Ze.YUAN]], toThousandFields: ["mete", "amount"] });
  }
  function P({ row: L, column: O, rowIndex: x, columnIndex: I }) {
    if (O.property && O.property.indexOf("past") !== -1) return { "background-color": "#fff9e9" };
    if (O.property && O.property.indexOf("adjust") !== -1) return { "background-color": "#fbf1eb" };
  }
  return (L, O) => {
    const x = wi, I = Ve("common-button"), Y = pa, ee = vt, B = Ve("common-table"), q = Ve("common-drawer");
    return w(), U(q, { ref_key: "drawerRef", ref: E, modelValue: l(T), "onUpdate:modelValue": O[0] || (O[0] = (ae) => Gt(T) ? T.value = ae : null), "before-close": l(_), "content-loading": y.value, "show-close": true, title: S.value, "custom-class": "raw-mat-price-adjust-review", size: "100%" }, { titleAfter: p(() => {
      var ae, j;
      return [(ae = e.form) != null && ae.reviewStatus ? (w(), U(x, { key: 0, type: (j = l(_n).V[e.form.reviewStatus]) == null ? void 0 : j.TAG }, { default: p(() => [Te(K(l(_n).VL[e.form.reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)];
    }), titleRight: p(() => [e.submitType === "audit" ? (w(), Q(Qe, { key: 0 }, [s(Y, { "cancel-button-text": "取消", "confirm-button-text": "确定", title: "确定通过吗?", onConfirm: R }, { reference: p(() => [s(I, { loading: b.value, size: "default", type: "primary" }, { default: p(() => O[1] || (O[1] = [Te("通过")])), _: 1, __: [1] }, 8, ["loading"])]), _: 1 }), s(Y, { "cancel-button-text": "取消", "confirm-button-text": "确定", title: "确定驳回?", onConfirm: v }, { reference: p(() => [s(I, { loading: b.value, size: "default", type: "danger" }, { default: p(() => O[2] || (O[2] = [Te("驳回")])), _: 1, __: [2] }, 8, ["loading"])]), _: 1 })], 64)) : H("", true)]), content: p(() => [s(B, { "cell-style": P, data: g.value.list, "data-format": r.value, "expand-row-keys": V.value, "max-height": l(h), "summary-method": N, "row-key": "id", "show-summary": "" }, { default: p(() => [s(fa, { "basic-class": g.value.basicClass }, null, 8, ["basic-class"]), s(za, { "basic-class": g.value.basicClass }, null, 8, ["basic-class"]), s(ee, { align: "left", label: "项目", "min-width": "120px", prop: "project", "show-overflow-tooltip": "" }), s(xl), s(ee, { label: "最近一次调整" }, { default: p(() => [s(ee, { align: "left", label: "含税金额", "min-width": "120px", prop: "pastAmount", "show-overflow-tooltip": "" }), s(ee, { align: "left", label: "不含税金额", "min-width": "120px", prop: "pastAmountExcludingVAT", "show-overflow-tooltip": "" }), s(ee, { align: "left", label: "进项税", "min-width": "120px", prop: "pastInputVAT", "show-overflow-tooltip": "" })]), _: 1 }), s(ee, { label: "本次调整" }, { default: p(() => [s(ee, { align: "left", label: "含税金额", "min-width": "120px", prop: "adjustAmount", "show-overflow-tooltip": "" }), s(ee, { align: "left", label: "不含税金额", "min-width": "120px", prop: "adjustAmountExcludingVat", "show-overflow-tooltip": "" }), s(ee, { align: "left", label: "进项税", "min-width": "120px", prop: "adjustInputVat", "show-overflow-tooltip": "" })]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close", "content-loading", "title"]);
  };
} }, F_ = ut(gF, [["__scopeId", "data-v-b129b929"]]), EF = Object.freeze(Object.defineProperty({ __proto__: null, default: F_ }, Symbol.toStringTag, { value: "Module" }));
const yF = { style: { display: "flex" } }, TF = { key: 0 }, _F = { key: 0, class: "inventory" }, bF = { class: "right-box" }, VF = { key: 0 }, wF = { key: 1 }, SF = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, vF = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, RF = { __name: "table-content", props: { list: { type: Array, default: () => [] }, form: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: void 0 }, submitType: { type: String, default: void 0 } }, setup(e) {
  const o = e, { baseUnit: n } = ai(), c = Z([]), u = { steelPlateList: { K: "steelPlateList", L: "钢板", V: Ge.STEEL_PLATE.V, DATA: [] }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: Ge.SECTION_STEEL.V, DATA: [] }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: Ge.STEEL_COIL.V, DATA: [] }, auxiliaryMaterialList: { K: "auxiliaryMaterialList", L: "辅材", V: Ge.MATERIAL.V, DATA: [] }, gasList: { K: "gasList", L: "气体", V: Ge.GAS.V, DATA: [] }, otherList: { K: "otherList", L: "其它", V: Ge.OTHER.V, DATA: [] } }, r = Z(), E = Z();
  Ce(() => o.list, (f) => {
    y();
  }, { immediate: true, deep: true });
  function y() {
    E.value = JSON.parse(JSON.stringify(o.list)), u.steelPlateList.DATA = [], u.sectionSteelList.DATA = [], u.steelCoilList.DATA = [], u.auxiliaryMaterialList.DATA = [], u.otherList.DATA = [], u.gasList.DATA = [], c.value = [];
    for (const f of E.value) switch (f.basicClass) {
      case Ge.STEEL_PLATE.V:
        c.value.findIndex((m) => m.V === Ge.STEEL_PLATE.V) < 0 && c.value.push({ K: "steelPlateList", L: "钢板", V: Ge.STEEL_PLATE.V }), u.steelPlateList.DATA.push(f);
        break;
      case Ge.SECTION_STEEL.V:
        c.value.findIndex((m) => m.V === Ge.SECTION_STEEL.V) < 0 && c.value.push({ K: "sectionSteelList", L: "型材", V: Ge.SECTION_STEEL.V }), u.sectionSteelList.DATA.push(f);
        break;
      case Ge.STEEL_COIL.V:
        c.value.findIndex((m) => m.V === Ge.STEEL_COIL.V) < 0 && c.value.push({ K: "steelCoilList", L: "钢卷", V: Ge.STEEL_COIL.V }), u.steelCoilList.DATA.push(f);
        break;
      case Ge.MATERIAL.V:
        c.value.findIndex((m) => m.V === Ge.MATERIAL.V) < 0 && c.value.push({ K: "auxiliaryMaterialList", L: "辅材", V: Ge.MATERIAL.V }), u.auxiliaryMaterialList.DATA.push(f);
        break;
      case Ge.GAS.V:
        c.value.findIndex((m) => m.V === Ge.GAS.V) < 0 && c.value.push({ K: "gasList", L: "气体", V: Ge.GAS.V }), u.gasList.DATA.push(f);
        break;
      case Ge.OTHER.V:
        c.value.findIndex((m) => m.V === Ge.OTHER.V) < 0 && c.value.push({ K: "otherList", L: "其它", V: Ge.OTHER.V }), u.otherList.DATA.push(f);
        break;
    }
  }
  function b(f, m) {
    const R = [], v = [];
    return A(f.thickness) && v.push(f.thickness), A(f.width) && v.push(f.width), A(f.length) && v.push(f.length), A(v) && R.push(v.join("*")), m === mo.LEFT_SPEC.V ? A(f.specification) && R.unshift(f.specification) : A(f.specification) && R.push(f.specification), R.join(" * ");
  }
  function V(f, m) {
    const R = [];
    return A(f.length) && R.push(f.length), m === mo.LEFT_SPEC.V ? A(f.specification) && f.specificationLabels !== "无规格" && R.unshift(f.specification) : A(f.specification) && f.specificationLabels !== "无规格" && R.push(f.specification), R.join(" * ");
  }
  function M(f, m) {
    const R = [], v = [];
    return A(f.thickness) && v.push(f.thickness), A(f.width) && v.push(f.width), A(f.length) && v.push(f.length), A(v) && R.push(v.join("*")), m === mo.LEFT_SPEC.V ? A(f.specification) && f.specificationLabels !== "无规格" && R.unshift(f.specification) : A(f.specification) && f.specificationLabels !== "无规格" && R.push(f.specification), R.join(" * ");
  }
  function g(f) {
    let m = Un();
    switch (Ae(m) && (_e.dispatch("wms/fetchWmsConfig"), m = Un()), f.basicClass) {
      case Ge.STEEL_PLATE.V:
        return b(f, m);
      case Ge.SECTION_STEEL.V:
        return V(f, m);
      case Ge.STEEL_COIL.V:
        return M(f, m);
      case Ge.MATERIAL.V:
        return S(f);
      case Ge.OTHER.V:
        return h(f);
      case Ge.GAS.V:
        return T(f);
      default:
        return f.spec;
    }
  }
  function S(f) {
    const m = [];
    return A(f.specification) && f.specificationLabels !== "无规格" && m.push(f.specification), m.join(" * ");
  }
  function h(f) {
    const m = [];
    return A(f.specification) && f.specificationLabels !== "无规格" && m.push(f.specification), m.join(" * ");
  }
  function T(f) {
    return f.specification;
  }
  function _(f) {
    return Hi(f, { props: ["quantity", "mete", "diffQuantity", "deficitMete"] });
  }
  return (f, m) => {
    var P;
    const R = Ve("common-radio-button"), v = vt, N = Ve("common-table");
    return w(), Q("div", null, [C("div", yF, [s(R, { modelValue: r.value, "onUpdate:modelValue": m[0] || (m[0] = (L) => r.value = L), "data-structure": { key: "K", label: "L", value: "K" }, options: c.value, clearable: "", "show-option-all": "", style: { "vertical-align": "middle", "margin-right": "6px" }, type: "other" }, { suffix: p(({ item: L }) => [u[L.K] && u[L.K].DATA.length ? (w(), Q("span", TF, "(" + K(u[L.K].DATA.length) + ")", 1)) : H("", true)]), _: 1 }, 8, ["modelValue", "options"]), e.form.deficitType ? (w(), Q("div", _F, [m[1] || (m[1] = C("div", { class: "left-box" }, " 成本归属 ", -1)), C("div", bF, K(l(Jr).VL[e.form.deficitType]), 1)])) : H("", true)]), s(N, { data: r.value ? ((P = u[r.value]) == null ? void 0 : P.DATA) || [] : E.value, maxHeight: e.maxHeight, "return-source-data": "", "row-key": "uid", "show-summary": "", "summary-method": _, "show-empty-symbol": "", style: { "margin-top": "20px" } }, { default: p(() => {
      var L, O, x;
      return [s(v, { align: "center", label: "序号", type: "index", width: "60" }), s(v, { align: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", width: "120" }), s(v, { align: "center", label: "规格", "min-width": "150px", prop: "specification", "show-overflow-tooltip": "" }, { default: p(({ row: I }) => [r.value ? (w(), Q("span", VF, K(I.specification), 1)) : (w(), Q("span", wF, K(g(I)), 1))]), _: 1 }), r.value === "steelPlateList" ? (w(), U(v, { key: 0, label: `厚 (${(L = l(n)[u[r.value].V]) == null ? void 0 : L.thickness.unit})`, align: "center", "min-width": "100px", prop: "thickness" }, null, 8, ["label"])) : H("", true), r.value === "steelPlateList" || r.value === "sectionSteelList" ? (w(), U(v, { key: 1, label: `宽 (${(O = l(n)[u[r.value].V]) == null ? void 0 : O.width.unit})`, align: "center", "min-width": "100px", prop: "width" }, null, 8, ["label"])) : H("", true), r.value === "steelPlateList" || r.value === "steelCoilList" ? (w(), U(v, { key: 2, label: `长 (${(x = l(n)[u[r.value].V]) == null ? void 0 : x.length.unit})`, align: "center", "min-width": "100px", prop: "length" }, null, 8, ["label"])) : H("", true), s(v, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }), !r.value || r.value === "auxiliaryMaterialList" || r.value === "otherList" ? (w(), U(v, { key: 3, align: "center", label: "颜色", "min-width": "100px", prop: "color" })) : H("", true), !r.value || r.value === "steelPlateList" || r.value === "sectionSteelList" || r.value === "steelCoilList" ? (w(), U(v, { key: 4, label: r.value ? r.value === "steelCoilList" ? "卷号" : "炉批号" : "炉批号/卷号", align: "center", "min-width": "150px", prop: "heatNoAndBatchNo" }, null, 8, ["label"])) : H("", true), s(v, { align: "center", label: "项目", "min-width": "100px", prop: "project" }, { default: p(({ row: I }) => [Te(K(I.projectId && I.projectId !== "-" ? l(di)(I.project) : "-"), 1)]), _: 1 }), s(v, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouse.name" }), s(v, { align: "center", label: "现存数量", "min-width": "135px", prop: "quantity" }), s(v, { key: "measureUnit", label: `计量
单位`, align: "center", prop: "measureUnit", width: "60" }), s(v, { key: "mete", label: "现存重量", align: "center", "min-width": "135px", prop: "mete" }, { default: p(({ row: I }) => [Te(K(I.mete ? I.mete.toFixed(I.accountingPrecision) : "-"), 1)]), _: 1 }), s(v, { key: "accountingUnit", label: `核算
单位`, align: "center", prop: "accountingUnit", width: "60px" }), s(v, { label: "盘亏数量", align: "right", "min-width": "135px", prop: "diffQuantity" }, { default: p(({ row: I }) => [C("span", null, [C("span", null, K(I.diffQuantity), 1), C("span", SF, K(I.outboundUnit), 1)])]), _: 1 }), e.submitType ? (w(), U(v, { key: 5, label: "盘亏重量", align: "right", "min-width": "135px", prop: "deficitMete" }, { default: p(({ row: I }) => [C("span", null, [C("span", null, K(I.deficitMete ? I.deficitMete.toFixed(I.accountingPrecision) : "-"), 1), C("span", vF, K(I.accountingUnit), 1)])]), _: 1 })) : H("", true), e.form.deficitType && e.form.deficitType === l(Jr).PROJECT.V ? (w(), U(v, { key: "deficitProject", label: "归属项目", align: "center", prop: "deficitProject", "min-width": "135px" }, { default: p(({ row: I }) => [Te(K(I.deficitProjectId && I.deficitProjectId !== "-" ? l(di)(I.deficitProject) : "-"), 1)]), _: 1 })) : H("", true), s(Vr, { label: "实际盘亏时间", showFormatRow: "" }), s(v, { label: "备注", align: "center", prop: "remark", "min-width": "135px" })];
    }), _: 1 }, 8, ["data", "maxHeight"])]);
  };
} }, Mv = ut(RF, [["__scopeId", "data-v-104c5b7c"]]), MF = Object.freeze(Object.defineProperty({ __proto__: null, default: Mv }, Symbol.toStringTag, { value: "Module" }));
const AF = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, form: { type: Object, default: () => ({}) }, submitType: { type: String, default: void 0 }, journalId: { type: Number, default: void 0 } }, emits: ["update:modelValue", "submit"], setup(e, { emit: o }) {
  const n = Z(), c = o, u = e, { visible: r, handleClose: E } = Ta({ emit: c, props: u }), y = Z(false), b = Z(false), V = Z([]), { maxHeight: M } = Kt({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, n);
  Ce(r, (T) => {
    T && g();
  });
  async function g() {
    console.log(u.form, "props.form");
    let T = [];
    b.value = true;
    try {
      const _ = await yO(u.form.id), f = [];
      _.forEach((m) => {
        f.includes(m.classifyId) || f.push(m.classifyId);
      }), await E_(f), await Qt(_), await Ut(_, { toSmallest: false, toNum: true }, { quantity: ["quantity", "deficitQuantity"], mete: ["mete", "deficitMete"] }), _.forEach((m) => {
        var R, v;
        m.diffQuantity = m.outboundUnitType === hi.MEASURE.V ? m.deficitQuantity : m.deficitMete, m.outboundUnit = m.outboundUnitType === hi.MEASURE.V ? m.measureUnit : m.accountingUnit, m.projectId = (R = m.project) == null ? void 0 : R.id, m.deficitProjectId = (v = m.deficitProject) == null ? void 0 : v.id;
      }), T = _;
    } catch (_) {
      console.log("获取可盘亏详情", _);
    } finally {
      V.value = T, b.value = false;
    }
  }
  async function S() {
    y.value = true;
    const T = { id: u.form.id, approveRecordId: u.journalId, decision: Lt.PASS.V };
    try {
      await H2(T), ot.success("盘亏通过成功"), c("success"), E(), y.value = false;
    } catch {
      y.value = false;
    }
  }
  async function h() {
    y.value = true;
    const T = { id: u.form.id, approveRecordId: u.journalId, decision: Lt.REFUSE.V };
    try {
      await H2(T), ot.success("盘亏驳回成功"), c("success"), E(), y.value = false;
    } catch {
      y.value = false;
    }
  }
  return (T, _) => {
    const f = wi, m = Ve("common-button"), R = pa, v = Ve("common-drawer"), N = oi;
    return w(), U(v, { ref_key: "drawerRef", ref: n, modelValue: l(r), "onUpdate:modelValue": _[0] || (_[0] = (P) => Gt(r) ? r.value = P : null), "before-close": l(E), title: `盘亏详情 ${e.form.serialNumber || ""}`, direction: "rtl", size: "100%" }, { titleAfter: p(() => {
      var P, L;
      return [(P = e.form) != null && P.reviewStatus ? (w(), U(f, { key: 0, type: (L = l(rr).V[e.form.reviewStatus]) == null ? void 0 : L.TAG }, { default: p(() => [Te(K(l(rr).VL[e.form.reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true)];
    }), titleRight: p(() => [e.submitType === "audit" ? (w(), Q(Qe, { key: 0 }, [s(R, { "cancel-button-text": "取消", "confirm-button-text": "确定", title: "确定通过吗?", onConfirm: S }, { reference: p(() => [s(m, { type: "primary", size: "default", loading: y.value }, { default: p(() => _[1] || (_[1] = [Te("通过")])), _: 1, __: [1] }, 8, ["loading"])]), _: 1 }), s(R, { "cancel-button-text": "取消", "confirm-button-text": "确定", title: "确定驳回?", onConfirm: h }, { reference: p(() => [s(m, { type: "danger", size: "default", loading: y.value }, { default: p(() => _[2] || (_[2] = [Te("驳回")])), _: 1, __: [2] }, 8, ["loading"])]), _: 1 })], 64)) : H("", true)]), content: p(() => [qe(s(l(Mv), { form: e.form, list: V.value, maxHeight: l(M), submitType: e.submitType }, null, 8, ["form", "list", "maxHeight", "submitType"]), [[N, b.value]])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, z_ = ut(AF, [["__scopeId", "data-v-b1422970"]]), NF = Object.freeze(Object.defineProperty({ __proto__: null, default: z_ }, Symbol.toStringTag, { value: "Module" })), LF = { class: "table-header" }, fm = { __name: "detail", props: { rowDetail: { type: Object, default: () => ({}) } }, setup(e) {
  const o = Z([]), n = Z([...Da, ...o.value]), c = Z(), { CRUD: u, crud: r, detail: E } = qi(), { maxHeight: y } = Kt({ mainBox: ".form-conversion-form-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !r.detailLoading));
  return u.HOOK.beforeDetailLoaded = async (b, V) => {
    var M;
    V.detailList = await Ut(V.detailList), (M = V.detailList) == null || M.forEach(async (g, S) => {
      g.index = S + 1, await Qt(g.detailList), g.detailList = await Ut(g.detailList), g.detailList.forEach((h, T) => {
        h.index = `${g.index}.${T + 1}`, h.project = g.project, h.warehouse = g.warehouse, h.workshop = g.workshop, h.projectFullName = di(h.project);
      });
    });
  }, (b, V) => {
    const M = wi, g = vt, S = Ve("common-table"), h = Ve("common-drawer");
    return w(), U(h, { ref_key: "drawerRef", ref: c, "before-close": l(r).cancelDetail, "content-loading": l(r).detailLoading, "show-close": true, title: `形态转换单:${l(E).receiptSerialNumber}`, visible: l(r).detailVisible, "custom-class": "form-conversion-form-detail", size: "100%" }, { titleAfter: p(() => [C("div", LF, [s(M, { class: "filter-item", effect: "plain", size: "large" }, { default: p(() => [Te("零件/套料工单号：" + K(l(E).taskOrderNumber), 1)]), _: 1 }), s(M, { class: "filter-item", effect: "plain", size: "large", style: { "margin-left": "10px" } }, { default: p(() => [Te(" 转换时间：" + K(l(Qi)(l(E).reviewTime)), 1)]), _: 1 })])]), content: p(() => [s(S, { data: l(E).detailList, "data-format": n.value, "max-height": l(y), "tree-props": { children: "detailList" }, "row-key": "id" }, { default: p(() => [s(g, { align: "center", fixed: "left", label: "序号", prop: "index", width: "110" }), s(fa, { showIndex: false, fixed: "left" }), s(g, { key: "brand", align: "center", label: "品牌", prop: "brand", width: "100" }), s(za), s(g, { key: "projectFullName", align: "center", label: "项目", prop: "projectFullName", width: "200" }), s(g, { key: "workshop", label: "仓库", "min-width": "150", prop: "workshop", "show-overflow-tooltip": "" }, { default: p(({ row: T }) => [s(Os, { id: T.workshop ? T.workshop.id : T.workshopId }, null, 8, ["id"]), Te(" " + K(T.warehouse ? T.warehouse.name : T.warehouseName), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, IF = Object.freeze(Object.defineProperty({ __proto__: null, default: fm }, Symbol.toStringTag, { value: "Module" })), CF = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, PF = { key: 0 }, OF = { class: "mtb-10", style: { "margin-left": "30px" } }, kF = { key: 0 }, DF = { key: 1 }, xF = { key: 0 }, UF = { key: 1 }, YF = { key: 0 }, KF = { key: 1 }, WF = { key: 0 }, jF = { key: 1 }, B_ = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, setup(e) {
  const o = Z([]), n = Ht(), c = e, u = Z([["arrivalTime", ["parse-time", "{y}-{m}-{d}"]]]), r = Z([...Da, ...u.value]), E = Z(), { CRUD: y, crud: b, detail: V } = qi(), { maxHeight: M } = Kt({ mainBox: ".profit-application-record-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !b.detailLoading)), g = Z();
  y.HOOK.beforeDetailLoaded = async (_, f) => {
    f.list = await Ut(f == null ? void 0 : f.detailDTOList, { toSmallest: false, toNum: true });
  };
  async function S(_) {
    const f = { dataId: V.id, decision: _, approveRecordId: V.approveRecordIdNow };
    await bO(f).then(async (m) => {
      _ === Lt.PASS.V ? ot.success("审批通过") : (ot.error("审批驳回"), await n.dispatch("approval_list/fetchRejNum", at.INVENTORY_PROFIT.V)), await n.dispatch("approval_list/fetchApprovalNum", at.INVENTORY_PROFIT.V), await n.dispatch("approval_list/fetchSubNum", at.INVENTORY_PROFIT.V), await b.toQuery(), await b.cancelDetail();
    });
  }
  async function h() {
    g.value = true;
    try {
      Ae(V.wmsApproveRecordFlowDTO) && (V.wmsApproveRecordFlowDTO = await Jn(V.approveRecordIdNow));
    } catch (_) {
      console.log(_, "获取失败");
    } finally {
      g.value = false;
    }
  }
  function T(_) {
    return Hi(_, { props: [["amount", 3], "quantity", "mete"], toThousandFields: ["amount", "quantity", "mete"] });
  }
  return (_, f) => {
    const m = Ve("common-button"), R = La, v = pa, N = Ve("table-cell-tag"), P = vt, L = Ve("common-table"), O = Ve("common-drawer"), x = oi;
    return w(), U(O, { ref_key: "drawerRef", ref: E, "before-close": l(b).cancelDetail, "content-loading": l(b).detailLoading, "show-close": true, visible: l(b).detailVisible, "custom-class": "profit-application-record-detail", size: "100%", title: "盘盈详情" }, { titleRight: p(() => [s(R, { width: 400, placement: "bottom", trigger: "click", onShow: h }, { reference: p(() => [s(m, null, { default: p(() => f[3] || (f[3] = [Te("查看审批记录")])), _: 1, __: [3] })]), default: p(() => [qe((w(), Q("div", CF, [s(tl, { data: l(V).wmsApproveRecordFlowDTO }, null, 8, ["data"])])), [[x, g.value]])]), _: 1 }), c.ApprovalFlag ? (w(), Q("div", PF, [s(v, { title: "确认通过", onConfirm: f[0] || (f[0] = (I) => S(l(Lt).PASS.V)) }, { reference: p(() => [s(m, { class: "filter-item", size: "default", type: "success" }, { default: p(() => f[4] || (f[4] = [Te("通过")])), _: 1, __: [4] })]), _: 1 }), s(v, { title: "确认驳回", onConfirm: f[1] || (f[1] = (I) => S(l(Lt).REFUSE.V)) }, { reference: p(() => [s(m, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => f[5] || (f[5] = [Te(" 驳回 ")])), _: 1, __: [5] })]), _: 1 })])) : H("", true)]), content: p(() => [s(L, { data: l(V).detailDTOList, "data-format": r.value, "max-height": l(M), stripe: false, "summary-method": T, "expand-row-keys": o.value, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": o.value, "onUpdate:expandRowKeys": f[2] || (f[2] = (I) => o.value = I), data: l(V).detailDTOList, "row-key": "id", fixed: "left" }, { default: p(({ row: I }) => [C("div", OF, [C("span", null, "备注：" + K(I.remark || "-"), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(P, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: p(({ row: I, $index: Y }) => [s(N, { show: !!I.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), C("span", null, K(Y + 1), 1)]), _: 1 }), s(fa, { showIndex: false, "show-is-whole": "" }), s(za), s(P, { align: "left", label: "发票类型", "min-width": "120px", prop: "invoiceType" }, { default: p(({ row: I }) => [I.boolPartyA ? (w(), Q("span", DF, "-")) : (w(), Q("span", kF, K(l(fi).VL[I.invoiceType]), 1))]), _: 1 }), s(P, { align: "left", label: "税率", "min-width": "100px", prop: "taxRate" }, { default: p(({ row: I }) => [I.boolPartyA ? (w(), Q("span", UF, "-")) : (w(), Q("span", xF, K(I.taxRate) + "%", 1))]), _: 1 }), s(P, { align: "left", label: "含税单价", "min-width": "100px", prop: "unitPrice" }, { default: p(({ row: I }) => [I.boolPartyA ? (w(), Q("span", KF, "-")) : (w(), Q("span", YF, K(I.unitPrice), 1))]), _: 1 }), s(P, { align: "left", label: "含税金额", "min-width": "100px", prop: "amount" }, { default: p(({ row: I }) => [I.boolPartyA ? (w(), Q("span", jF, "-")) : (w(), Q("span", WF, K(I.amount), 1))]), _: 1 }), s(P, { align: "left", label: "品牌", "min-width": "200px", prop: "brand" }), s(P, { align: "left", label: "炉批号/卷号", "min-width": "200px", prop: "heatNoAndBatchNo" }), s(P, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: p(({ row: { sourceRow: I } }) => [Te(K(l(di)(I.project) || "-"), 1)]), _: 1 }), s(P, { align: "left", label: "仓库", "min-width": "200px", prop: "workshop" }, { default: p(({ row: { sourceRow: I } }) => [s(Os, { id: I.workshop ? I.workshop.id : I.workshopId }, null, 8, ["id"]), Te(" " + K(I.warehouse ? I.warehouse.name : I.warehouseName), 1)]), _: 1 }), s(P, { align: "left", label: "供应商", "min-width": "200px", prop: "supplier.name" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, FF = Object.freeze(Object.defineProperty({ __proto__: null, default: B_ }, Symbol.toStringTag, { value: "Module" })), zF = { __name: "receipt-detail", props: { receipt: { type: [Array, Object], default: () => ({}) }, receiptTypes: { type: Array, default: () => [] } }, setup(e, { expose: o }) {
  const n = e, c = Z({}), u = Z(false), r = Z(false);
  Ce(() => n.receiptTypes, (me) => {
    se(me);
  }, { immediate: true });
  const { detailRef: E, openDetail: y } = hl(), { detailRef: b, openDetail: V } = hl(), { detailRef: M, openDetail: g } = hl(), { detailRef: S, openDetail: h } = hl(), { detailRef: T, openDetail: _ } = hl(), { detailRef: f, openDetail: m } = hl(), { detailRef: R, openDetail: v } = hl(), { detailRef: N, openDetail: P } = hl(), { detailRef: L, openDetail: O } = hl(), { detailRef: x, openDetail: I } = hl(), { detailRef: Y, openDetail: ee } = hl(), { detailRef: B, openDetail: q } = hl(), { detailRef: ae, openDetail: j } = hl(), { detailRef: le, openDetail: oe } = hl(), ye = Z(), ce = Z();
  function se(me = []) {
    const ge = { [It.REQUISITIONS.K]: false, [It.PURCHASE.K]: false, [It.INBOUND.K]: false, [It.OUTBOUND.K]: false, [It.FOR_SALE.K]: false, [It.SCRAPS.K]: false, [It.OUTSOURCE.K]: false, [It.TEMPORARY_LOAN.K]: false, [It.OUTBOUND_APPLY.K]: false, [It.MOVING_INVENTORY.K]: false, [It.TRANSFER.K]: false, [It.RETURN.K]: false, [It.REJECTED.K]: false, [It.SUPPLEMENT.K]: false, [It.CONVERT.K]: false, [It.ADJUST.K]: false, [It.INVENTORY_LOSS.K]: false, [It.INVENTORY_PROFIT.K]: false, [It.MANUF_OUTBOUND.K]: false, [It.MANUF_RETURN.K]: false, [It.MODAL_SHIFT.K]: false };
    me.forEach((Le) => {
      ge[Le] = true;
    }), c.value = ge;
  }
  function he() {
    u.value = true;
  }
  function be(me, ge) {
    switch (!ge && n.receiptTypes && n.receiptTypes.length === 1 && (ge = It[n.receiptTypes[0]].V), ge) {
      case It.REQUISITIONS.V:
        y(me);
        return;
      case It.PURCHASE.V:
        V(me);
        return;
      case It.INBOUND.V:
        g(me);
        return;
      case It.SCRAPS.V:
      case It.TEMPORARY_LOAN.V:
      case It.FOR_SALE.V:
      case It.OUTSOURCE.V:
      case It.OUTBOUND.V:
        h(me);
        return;
      case It.TRANSFER.V:
        m(me);
        return;
      case It.MOVING_INVENTORY.V:
        v(me);
        return;
      case It.RETURN.V:
        P(me);
        return;
      case It.REJECTED.V:
        I(me);
        return;
      case It.SUPPLEMENT.V:
        ee(me);
        return;
      case It.CONVERT.V:
        q(me);
        return;
      case It.OUTBOUND_APPLY.V:
        return;
      case It.ADJUST.V:
        he();
        return;
      case It.INVENTORY_LOSS.V:
        r.value = true;
        return;
      case It.INVENTORY_PROFIT.V:
        oe(me);
        return;
      case It.MANUF_OUTBOUND.V:
        _(me);
        return;
      case It.MANUF_RETURN.V:
        O(me);
        return;
      case It.MODAL_SHIFT.V:
        j(me);
        return;
      default:
        return null;
    }
  }
  return o({ openDetail: be }), (me, ge) => (w(), Q(Qe, null, [c.value[l(It).REQUISITIONS.K] ? (w(), U(ol, { key: 0, ref_key: "requisitionsRef", ref: E, api: l(iv) }, { default: p(() => [s($_)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).PURCHASE.K] ? (w(), U(ol, { key: 1, ref_key: "purchaseOrderRef", ref: b, api: l(Tr) }, { default: p(() => [s(ks, { "show-btn": false })]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).INBOUND.K] ? (w(), U(ol, { key: 2, ref_key: "inboundDetailRef", ref: M, api: l(lv) }, { default: p(() => [s(D_)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).OUTBOUND.K] || c.value[l(It).FOR_SALE.K] || c.value[l(It).TEMPORARY_LOAN.K] || c.value[l(It).OUTSOURCE.K] || c.value[l(It).SCRAPS.K] ? (w(), U(ol, { key: 3, ref_key: "outboundDetailRef", ref: S, api: l(y_) }, { default: p(() => [s(x_)]), _: 1 }, 8, ["api"])) : H("", true), s(ol, { ref_key: "manufOutboundDetailRef", ref: T, api: l(ov) }, { default: p(() => [s(dv)]), _: 1 }, 8, ["api"]), c.value[l(It).TRANSFER.K] ? (w(), U(ol, { key: 4, ref_key: "transferDetailRef", ref: f, api: l(nv) }, { default: p(() => [s(fv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).MOVING_INVENTORY.K] ? (w(), U(ol, { key: 5, ref_key: "movingInventoryDetailRef", ref: R, api: l(A_) }, { default: p(() => [s(gv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).RETURN.K] ? (w(), U(ol, { key: 6, ref_key: "returnDetailRef", ref: N, api: l(T_) }, { default: p(() => [s(bv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).MANUF_RETURN.K] ? (w(), U(ol, { key: 7, ref_key: "manufReturnDetailRef", ref: L, api: l(GU) }, { default: p(() => [s(Vv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).REJECTED.K] ? (w(), U(ol, { key: 8, ref_key: "rejectDetailRef", ref: x, api: l(N_) }, { default: p(() => [s(W_)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).SUPPLEMENT.K] ? (w(), U(ol, { key: 9, ref_key: "supplementDetailRef", ref: Y, api: l(XU) }, { default: p(() => [s(Sv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).CONVERT.K] ? (w(), U(ol, { key: 10, ref_key: "convertDetailRef", ref: B, api: l(sv) }, { default: p(() => [s(vv)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).ADJUST.K] ? (w(), U(F_, { key: 11, ref_key: "adjustDetailRef", ref: ye, modelValue: u.value, "onUpdate:modelValue": ge[0] || (ge[0] = (Le) => u.value = Le), form: e.receipt }, null, 8, ["modelValue", "form"])) : H("", true), c.value[l(It).INVENTORY_LOSS.K] ? (w(), U(z_, { key: 12, ref_key: "inventoryLossRef", ref: ce, modelValue: r.value, "onUpdate:modelValue": ge[1] || (ge[1] = (Le) => r.value = Le), form: e.receipt, submitType: "detail" }, null, 8, ["modelValue", "form"])) : H("", true), c.value[l(It).MODAL_SHIFT.K] ? (w(), U(ol, { key: 13, ref_key: "conversionRef", ref: ae, api: l(mm) }, { default: p(() => [s(fm)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).MODAL_SHIFT.K] ? (w(), U(ol, { key: 14, ref_key: "conversionRef", ref: ae, api: l(mm) }, { default: p(() => [s(fm)]), _: 1 }, 8, ["api"])) : H("", true), c.value[l(It).INVENTORY_PROFIT.K] ? (w(), U(ol, { key: 15, ref_key: "inventoryProfitRef", ref: le, api: l(__) }, { default: p(() => [s(B_)]), _: 1 }, 8, ["api"])) : H("", true)], 64));
} };
const BF = { __name: "clickable-permission-span", props: { permission: { type: Array }, text: { type: String } }, emits: ["click"], setup(e, { emit: o }) {
  const n = o, c = e;
  function u() {
    Ai(c.permission) && n("click");
  }
  return (r, E) => {
    const y = _t("empty-text");
    return l(A)(e.text) ? (w(), Q("span", ii({ key: 0 }, r.$attrs, { class: { "text-clickable": l(Ai)(c.permission) }, onClick: u }), K(e.text), 17)) : qe((w(), Q("span", Ol(ii({ key: 1 }, r.$attrs)), null, 16)), [[y]]);
  };
} }, HF = ut(BF, [["__scopeId", "data-v-57e97fbc"]]), qF = { key: 2 }, H_ = { __name: "receipt-sn-clickable", props: { receipt: { type: [Array, Object], default: () => ({}) }, receiptTypes: { type: Array, default: () => [] } }, setup(e) {
  const o = e, n = Z(), c = Z({}), u = Ee(() => Ae(o.receipt) && typeof o.receipt == "object" ? [] : Array.isArray(o.receipt) ? o.receipt : [o.receipt]), r = Ee(() => {
    if (o.receipt.receiptType) return o.receipt.receiptType;
    if (!o.receipt.receiptType && o.receiptTypes && o.receiptTypes.length === 1) return It[o.receiptTypes[0]].V;
  });
  function E(b, V, M) {
    c.value = M, A(c.value) && (c.value.showSerialNumber = c.value.serialNumber), n.value && n.value.openDetail(b, V);
  }
  function y(b) {
    switch (b) {
      case It.REQUISITIONS.V:
        return Il.requisitionsDetail;
      case It.PURCHASE.V:
        return Il.purchaseOrderDetail;
      case It.INBOUND.V:
        return Il.inboundReceiptDetail;
      case It.OUTBOUND.V:
        return Il.outboundReceiptDetail;
      case It.TRANSFER.V:
        return Il.transferReceiptDetail;
      case It.MOVING_INVENTORY.V:
        return Il.movingInventoryDetail;
      case It.RETURN.V:
        return Il.returnReceiptDetail;
      case It.REJECTED.V:
        return Il.rejectReceiptDetail;
      case It.SUPPLEMENT.V:
        return Il.supplementReceiptDetail;
      case It.CONVERT.V:
        return Il.convertListDetail;
      case It.ADJUST.V:
        return Il.adjustDetail;
      case It.INVENTORY_LOSS.V:
        return Il.inventoryLossDetail;
      case It.INVENTORY_PROFIT.V:
        return Il.inventoryProfitDetail;
      case It.MANUF_OUTBOUND.V:
        return Il.manufOutboundReceiptDetail;
      case It.MANUF_RETURN.V:
        return Il.manufReturnReceiptDetail;
      case It.MODAL_SHIFT.V:
        return Il.formConversionRecordDetail;
      default:
        return;
    }
  }
  return (b, V) => (w(), Q(Qe, null, [u.value.length > 0 ? (w(true), Q(Qe, { key: 0 }, ki(u.value, (M, g) => (w(), Q(Qe, { key: `${M.serialNumber}_${g}` }, [r.value === l(It).OUTBOUND_APPLY.V || r.value === l(It).CONSTRUCTION_SITE_USE.V ? (w(), Q("span", ii({ key: 0, ref_for: true }, b.$attrs), K(M.serialNumber), 17)) : (w(), U(HF, ii({ key: 1, permission: y(r.value), text: M.serialNumber }, { ref_for: true }, b.$attrs, { onClick: (S) => E(M.id, r.value, M) }), null, 16, ["permission", "text", "onClick"])), g !== u.value.length - 1 ? (w(), Q("span", qF, " 、")) : H("", true)], 64))), 128)) : (w(), Q("span", Ol(ii({ key: 1 }, b.$attrs)), "-", 16)), s(l(zF), { ref_key: "receiptDetailRef", ref: n, receipt: c.value, "receipt-types": o.receiptTypes }, null, 8, ["receipt", "receipt-types"])], 64));
} }, GF = { key: 0 }, QF = { key: 1 }, ZF = { key: 1 }, Eu = { __name: "material-freeze-record", props: { material: { type: Object, default: () => ({}) }, mode: { type: String, default: "fetch" }, records: { type: Array, default: () => [] } }, emits: ["unfreeze-success"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(false), r = Z([]), E = Z(false), y = Z(), b = Z([["project", ["parse-project", { onlyShortName: true }]], ["projectFullName", "parse-project", { source: "project" }], ["frozenTime", ["parse-time", "{y}-{m}-{d}"]], ["freezeTypeName", ["parse-enum", fl], ["suffix", "冻结"], { source: "freezeType" }]]);
  c.mode === "fetch" && Ce(() => c.material, (_) => {
    V();
  }, { immediate: true }), c.mode === "incoming" && Ce(() => c.records, async (_) => {
    r.value = await M(c.material, _);
  }, { immediate: true });
  async function V() {
    const _ = c.material;
    if (!(!_ || !_.id)) try {
      r.value = [], u.value = true;
      const { content: f = [] } = await UD(_.id);
      r.value = await M(_, f);
    } catch (f) {
      console.error("error", f);
    } finally {
      u.value = false;
    }
  }
  async function M(_, f = []) {
    return !_ || f.length === 0 ? f : await Ut(f, { measureUnit: _.measureUnit, accountingUnit: _.accountingUnit, accountingPrecision: _.accountingPrecision, measurePrecision: _.measurePrecision, toSmallest: false, toNum: true });
  }
  function g(_) {
    c.mode === "fetch" && V(), n("unfreeze-success", _, y.value, c.material);
  }
  function S(_) {
    E.value = true, y.value = _;
  }
  function h(_) {
    const f = T(_);
    return Ai(f);
  }
  function T(_) {
    switch (_) {
      case fl.PREPARATION.V:
        return Cu.preparationUnFreeze;
      case fl.OUTBOUND_APPLY.V:
        return Cu.outboundUnFreeze;
      case fl.TRANSFER.V:
        return Cu.transferUnFreeze;
      case fl.REJECTED.V:
        return Cu.rejectUnFreeze;
    }
  }
  return (_, f) => {
    const m = vt, R = Ve("common-button"), v = UV, N = ml, P = jt, L = Ve("common-table"), O = oi;
    return w(), Q(Qe, null, [qe((w(), U(L, ii({ data: r.value, "data-format": b.value, "row-key": "id" }, _.$attrs), { default: p(() => [s(m, { align: "center", label: "序号", type: "index", width: "60" }), s(m, { key: "freezeTypeName", "show-overflow-tooltip": true, align: "center", label: "类型", prop: "freezeTypeName", width: "100" }), s(m, { key: "receiptType", "show-overflow-tooltip": true, align: "center", label: "对应单据", prop: "receiptType", width: "120" }, { default: p(({ row: x }) => [l(fl).V[x.freezeType] ? (w(), Q("span", GF, K(l(fl).V[x.freezeType].DOC), 1)) : H("", true)]), _: 1 }), s(m, { key: "receipt", "show-overflow-tooltip": true, align: "center", label: "单据编号", "min-width": "120", prop: "receipt" }, { default: p(({ row: x }) => [s(l(H_), { receipt: x.receipt, "receipt-types": ["REQUISITIONS", "PREPARATION", "OUTBOUND_APPLY", "TRANSFER", "REJECTED", "CONVERT", "OUTBOUND", "FOR_SALE", "TEMPORARY_LOAN", "OUTSOURCE", "SCRAPS", "INVENTORY_LOSS", "MOVING_INVENTORY"] }, null, 8, ["receipt"])]), _: 1 }), s(m, { key: "project", label: "单据项目", "min-width": "170", prop: "project", "show-overflow-tooltip": "" }), s(m, { align: "center", label: "单位", prop: "outboundUnit", width: "70px" }, { default: p(() => [Te(K(e.material.outboundUnit), 1)]), _: 1 }), s(m, { align: "right", label: "数量", prop: "curQuantity", width: "100px" }, { default: p(({ row: x }) => [Te(K(e.material.outboundUnitType === l(hi).MEASURE.V ? x.quantity : x.mete), 1)]), _: 1 }), s(m, { key: "operatorName", "show-overflow-tooltip": true, align: "center", label: "冻结人", prop: "operatorName", width: "90" }), s(m, { key: "frozenTime", "show-overflow-tooltip": true, align: "center", label: "冻结日期", prop: "frozenTime", width: "100" }), s(m, { key: "remark", "show-overflow-tooltip": true, label: "备注", prop: "remark", width: "100" }), s(m, { align: "center", label: "操作", width: "85px" }, { default: p(({ row: { sourceRow: x } }) => [x.freezeType !== l(fl).PREPARATION.V && x.freezeType !== l(fl).NESTING.V && x.freezeType !== l(fl).INVENTORY_LOSS.V && x.freezeType !== l(fl).MES_OUTBOUND_APPLY.V ? (w(), Q(Qe, { key: 0 }, [h(x.freezeType) ? (w(), U(R, { key: 0, size: "default", type: "primary", onClick: (I) => S(x) }, { default: p(() => f[1] || (f[1] = [Te(" 解 冻 ")])), _: 2, __: [1] }, 1032, ["onClick"])) : (w(), Q("span", QF, "无权限"))], 64)) : (w(), Q("span", ZF, [s(P, { content: "备料冻结、套料、盘亏、排产出库冻结无法手动解冻", effect: "dark", placement: "top-start" }, { default: p(() => [s(N, { color: "#909399" }, { default: p(() => [s(v)]), _: 1 })]), _: 1 })]))]), _: 1 })]), _: 1 }, 16, ["data", "data-format"])), [[O, u.value]]), s(tv, { visible: E.value, "onUpdate:visible": f[0] || (f[0] = (x) => E.value = x), material: c.material, record: y.value, onSuccess: g }, null, 8, ["visible", "material", "record"])], 64);
  };
} }, JF = Object.freeze(Object.defineProperty({ __proto__: null, default: Eu }, Symbol.toStringTag, { value: "Module" })), XF = { key: 0, class: "table-cell-triangle-frozen" }, $F = ["onClick"], ez = { key: 1 }, jo = { __name: "index", props: { specMerge: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, showFrozenTip: { type: Boolean, default: false }, frozenViewable: { type: Boolean, default: false }, rejectDetailViewable: { type: Boolean, default: false }, showIndex: { type: Boolean, default: true }, showRejectStatus: { type: Boolean, default: false }, showPartyA: { type: Boolean, default: true }, partyAPosition: { type: String, default: "index" }, showPartyATransfer: { type: Boolean, default: false }, showOutboundMode: { type: Boolean, default: false }, showProject: { type: Boolean, default: false }, fixed: { type: String }, field: { type: String, default: "material" }, showTip: { type: Boolean, default: true } }, emits: ["refresh"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z({}), r = Z(false), E = Z(false), y = Z(0), b = Ee(() => !c.basicClass || c.basicClass > ua ? 150 : 120), V = Ee(() => Ae(c.columns) || c.columns.visible(`${c.field}.classifyName`)), M = Ee(() => Ae(c.columns) || c.columns.visible(`${c.field}.serialNumber`)), g = Ee(() => c.frozenViewable && Ai(sd.frozenDetail)), { maxHeight: S } = Kt({ mainBox: ".wms-material-freeze-record-view", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => r.value || E.value));
  function h(v) {
    const N = v.sourceRow ? v.sourceRow : v;
    y.value = 0, u.value = m(N), r.value = true;
  }
  function T(v) {
    if (!c.rejectDetailViewable) return;
    const N = v.sourceRow ? v.sourceRow : v;
    u.value = m(N), E.value = true;
  }
  function _() {
    ++y.value;
  }
  function f(v) {
    y.value > 0 && n("refresh"), v();
  }
  function m(v, N) {
    const P = c.field;
    if (!(Ae(v) || Ae(v[P]))) return N ? v[P][N] : v[P];
  }
  yi("getInfo", m);
  const R = Ee(() => {
    switch (c.basicClass) {
      case dt.STEEL_PLATE.V:
        return ID;
      case dt.SECTION_STEEL.V:
        return CD;
      case dt.STEEL_COIL.V:
        return PD;
      case dt.MATERIAL.V:
        return OD;
      case dt.GAS.V:
        return kD;
      default:
        return DD;
    }
  });
  return (v, N) => {
    var I;
    const P = Ve("table-cell-tag"), L = vt, O = jt, x = Ve("common-dialog");
    return w(), Q(Qe, null, [e.showIndex ? (w(), U(L, { key: 0, fixed: e.fixed, align: "center", label: "序号", type: "index", width: "55" }, { default: p(({ row: Y, $index: ee }) => [Y.overTipColor ? (w(), Q("div", { key: 0, style: ri({ "border-left-color": Y.overTipColor }), class: "left-triangle-tip" }, null, 4)) : H("", true), e.showPartyA && e.partyAPosition === "index" ? (w(), U(P, { key: 1, show: !!m(Y, "boolPartyA"), name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(ee + 1), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), xt(v.$slots, "afterIndex"), e.showProject ? (w(), U(L, { key: 1, fixed: e.fixed, prop: `${e.field}.project`, align: "left", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [e.showPartyA && e.partyAPosition === "project" ? (w(), U(P, { key: 0, offset: 15, show: !!m(Y, "boolPartyA"), name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), Te(" " + K(m(Y, "project")), 1)]), _: 1 }, 8, ["fixed", "prop"])) : H("", true), M.value ? (w(), U(L, { key: 2, fixed: e.fixed, prop: `${e.field}.serialNumber`, align: "center", label: "物料编号", "show-overflow-tooltip": "", width: "110px" }, { default: p(({ row: Y }) => [e.showPartyATransfer && m(Y, "partyATransferType") ? (w(), U(P, { key: 0, color: l(Mo).V[m(Y, "partyATransferType")].COLOR, name: l(Mo).VL[m(Y, "partyATransferType")], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOutboundMode && m(Y, "materialOutboundMode") === l(Oa).HALF.V ? (w(), U(P, { key: 1, color: l(Oa).V[m(Y, "materialOutboundMode")].COLOR, name: l(Oa).VL[m(Y, "materialOutboundMode")], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showRejectStatus ? (w(), Q(Qe, { key: 2 }, [v.isNotBlank(m(Y, "rejectStatus")) && m(Y, "rejectStatus") !== l(Wl).NONE.V ? (w(), U(P, { key: 0, class: Zt({ pointer: e.rejectDetailViewable }), color: l(Wl).V[m(Y, "rejectStatus")].COLOR, name: l(Wl).VL[m(Y, "rejectStatus")], onClick: (ee) => T(Y) }, null, 8, ["class", "color", "name", "onClick"])) : H("", true)], 64)) : H("", true), e.showTip && Y.basicClass === l(dt).STEEL_PLATE.V ? (w(), U(P, { key: 3, color: "#f23c3c", offset: 15, show: Y.boolReturns || !!Y.remnantId, name: "退余料" }, null, 8, ["show"])) : H("", true), C("span", null, K(m(Y, "serialNumber")), 1)]), _: 1 }, 8, ["fixed", "prop"])) : H("", true), V.value ? (w(), U(L, { key: `${e.field}.classifyName`, fixed: e.fixed, prop: `${e.field}.classifyName`, width: b.value, align: "center", label: "物料种类", "show-overflow-tooltip": "" }, { default: p(({ row: Y }) => [e.showFrozenTip && m(Y, "boolHasFrozen") ? (w(), Q("span", XF)) : H("", true), s(O, { content: m(Y, "classifyParentFullName"), disabled: !m(Y, "classifyParentFullName"), "show-after": 500, placement: "top" }, { default: p(() => [C("span", null, [g.value && m(Y, "boolHasFrozen") ? (w(), Q("span", { key: 0, class: "freeze-text", onClick: (ee) => h(Y) }, K(m(Y, "classifyName")), 9, $F)) : (w(), Q("span", ez, K(m(Y, "classifyName")), 1))])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["fixed", "prop", "width"])) : H("", true), (w(), U(Ri(R.value), ii({ "basic-class": c.basicClass, columns: c.columns, field: e.field, fixed: e.fixed, "spec-merge": c.specMerge }, v.$attrs), null, 16, ["basic-class", "columns", "field", "fixed", "spec-merge"])), s(x, { modelValue: r.value, "onUpdate:modelValue": N[0] || (N[0] = (Y) => r.value = Y), "before-close": f, title: `冻结记录：${u.value.classifyName} ${((I = u.value) == null ? void 0 : I.specification) || ""}`, "custom-class": "wms-material-freeze-record-view", "show-close": "", top: "10vh", width: "1300px" }, { default: p(() => [s(Eu, { material: u.value, "max-height": l(S), onUnfreezeSuccess: _ }, null, 8, ["material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"]), s(x, { modelValue: E.value, "onUpdate:modelValue": N[1] || (N[1] = (Y) => E.value = Y), title: `退货记录：${u.value.classifyName} ${u.value.specification}`, "custom-class": "wms-material-reject-material-record-view", "show-close": "", top: "10vh", width: "80%" }, { default: p(() => [s(yu, { "basic-class": u.value.basicClass, list: u.value.rejectList, material: u.value, "max-height": l(S), "has-border": "" }, null, 8, ["basic-class", "list", "material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"])], 64);
  };
} };
const tz = { key: 1 }, iz = { __name: "reject-info-table", props: { operable: { type: Boolean, default: false }, hasBorder: { type: Boolean, default: false }, material: { type: Object, default: () => ({}) }, basicClass: { type: Number }, list: { type: Array, default: () => [] } }, emits: ["del"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z([...ld, ["reviewStatus", ["parse-enum", um]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["realTime", "parse-time"]]), r = Ee(() => {
    if (!Ae(c.material)) return c.material.rejectUnitType === hi.MEASURE.V ? "quantity" : "mete";
  });
  function E(b) {
    const V = c.material.measurePrecision || 0, M = c.material.accountingPrecision || ei.weight.precision;
    return Hi(b, { props: [["material.quantity", V], ["material.mete", M]] });
  }
  function y(b, V) {
    c.list.splice(V, 1), n("del", c.material, b);
  }
  return (b, V) => {
    const M = wi, g = vt, S = Ve("common-button"), h = Ve("common-table");
    return w(), U(h, { class: Zt([{ "table-border-none": !e.hasBorder }, "raw-mat-reject-info-table"]), data: e.list, "data-format": u.value, "summary-method": E, "row-key": "id", "show-summary": "" }, { default: p(() => [s(jo, { "basic-class": e.basicClass, "spec-merge": "" }, null, 8, ["basic-class"]), s(Wo, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(pv, { "basic-class": e.basicClass, "number-prop-field": r.value, "reject-type-mode": "" }, null, 8, ["basic-class", "number-prop-field"]), s(hv, { "show-area": false, "show-monomer": false, "show-project": "" }), s(g, { key: "status", align: "center", label: "状态", prop: "status", "show-overflow-tooltip": "", width: "80" }, { default: p(({ row: T }) => [s(M, { type: l(jS).V[T.sourceRow.reviewStatus].TAG }, { default: p(() => [Te(K(T.reviewStatus), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), s(Vr, { label: "实际退货时间" }), s(g, { key: "createTime", prop: "createTime", label: "操作", align: "center", width: "120", "show-overflow-tooltip": "" }, { default: p(({ row: T, $index: _ }) => [T.sourceRow.reviewStatus === l(um).UNSUBMITTED.V && e.operable ? (w(), U(S, { key: 0, icon: "el-icon-delete", size: "default", type: "danger", onClick: (f) => y(T.sourceRow, _) }, null, 8, ["onClick"])) : (w(), Q("span", tz, K(T.createTime), 1))]), _: 1 })]), _: 1 }, 8, ["class", "data", "data-format"]);
  };
} }, yu = ut(iz, [["__scopeId", "data-v-83b71005"]]), az = Object.freeze(Object.defineProperty({ __proto__: null, default: yu }, Symbol.toStringTag, { value: "Module" }));
const lz = { class: "subscript" }, oz = { key: 0, class: "table-cell-triangle-frozen" }, nz = ["onClick"], sz = { key: 1, class: "text" }, rz = { __name: "index", props: { specMerge: { type: Boolean, default: false }, specOnly: { type: Boolean, default: false }, basicClass: { type: Number }, columns: { type: Object }, showIndex: { type: Boolean, default: true }, showClassification: { type: Boolean, default: false }, showSerialNumber: { type: Boolean, default: true }, showProject: { type: Boolean, default: false }, showRejectStatus: { type: Boolean, default: false }, showPartyA: { type: Boolean, default: true }, showPartyATransfer: { type: Boolean, default: false }, partyAPosition: { type: String, default: "index" }, showIsWhole: { type: Boolean, default: false }, showOutboundMode: { type: Boolean, default: false }, showOddmentByHalfOut: { type: Boolean, default: false }, showFrozenTip: { type: Boolean, default: false }, frozenViewable: { type: Boolean, default: false }, rejectDetailViewable: { type: Boolean, default: false }, fixed: { type: String }, sortable: { type: Boolean, default: false }, warehouseSort: { type: Boolean, default: false }, returnSortable: { type: Boolean, default: false }, classifyNameAlias: { type: String, default: "物料种类" }, showTip: { type: Boolean, default: false }, specificationLable: { type: String, default: "规格" }, isSerialNumber: { type: Boolean, default: true } }, emits: ["refresh", "unfreeze-success"], setup(e, { emit: o }) {
  const n = o, c = e, u = ft("isBegin", false), r = Z({}), E = Z(false), y = Z(false), b = Z(0), V = Ee(() => !!(c.basicClass & ho)), M = Ee(() => !c.basicClass || c.basicClass > ua ? 160 : 120), g = Ee(() => Ae(c.columns) || c.columns.visible("classifyName")), S = Ee(() => c.showSerialNumber && (Ae(c.columns) || c.columns.visible("serialNumber"))), h = Ee(() => c.frozenViewable && Ai(sd.frozenDetail)), T = Ee(() => c.sortable === true ? "custom" : false), { maxHeight: _ } = Kt({ mainBox: ".wms-material-freeze-record-view", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, Ee(() => E.value || y.value));
  function f(P) {
    const L = P.sourceRow ? P.sourceRow : P;
    b.value = 0, r.value = JSON.parse(JSON.stringify(L)), E.value = true;
  }
  function m(P) {
    if (!c.rejectDetailViewable) return;
    const L = P.sourceRow ? P.sourceRow : P;
    r.value = JSON.parse(JSON.stringify(L)), y.value = true;
  }
  function R(P, L, O) {
    ++b.value, n("unfreeze-success", P, L, O);
  }
  function v(P) {
    b.value > 0 && n("refresh"), P();
  }
  const N = Ee(() => {
    switch (c.basicClass) {
      case Pe.STEEL_PLATE.V:
        return wD;
      case Pe.SECTION_STEEL.V:
        return SD;
      case Pe.STEEL_COIL.V:
        return vD;
      case Pe.MATERIAL.V:
        return RD;
      case Pe.GAS.V:
        return MD;
      case Pe.STRUC_MANUFACTURED.V:
        return ND;
      case Pe.ENCL_MANUFACTURED.V:
        return AD;
      default:
        return LD;
    }
  });
  return (P, L) => {
    var ee;
    const O = Ve("table-cell-tag"), x = vt, I = jt, Y = Ve("common-dialog");
    return w(), Q(Qe, null, [xt(P.$slots, "indexTag", {}, void 0, true), e.showIndex ? (w(), U(x, { key: 0, fixed: e.fixed, align: "center", label: "序号", type: "index", width: "55" }, { default: p(({ row: B, $index: q }) => [e.showPartyA && e.partyAPosition === "index" ? (w(), U(O, { key: 0, show: !!B.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(q + 1), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), xt(P.$slots, "afterIndex", {}, void 0, true), e.showProject ? (w(), U(x, { key: 1, fixed: e.fixed, prop: "project", align: "left", label: "项目", "min-width": "120px", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [e.showPartyA && e.partyAPosition === "project" ? (w(), U(O, { key: 0, offset: 15, show: !!B.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : H("", true), C("span", null, K(B.project), 1)]), _: 1 }, 8, ["fixed"])) : H("", true), S.value ? (w(), U(x, { key: 2, fixed: e.fixed, prop: e.isSerialNumber ? "serialNumber" : "materialSn", sortable: T.value, align: "center", label: "物料编号", "min-width": "110px", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [xt(P.$slots, "snTag", { row: B }, void 0, true), e.showPartyATransfer && B.partyATransferType ? (w(), U(O, { key: 0, color: l(Mo).V[B.partyATransferType].COLOR, name: l(Mo).VL[B.partyATransferType], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showIsWhole && B.materialIsWhole === l(Dl).ODDMENT.V ? (w(), U(O, { key: 1, color: l(Dl).V[B.materialIsWhole].COLOR, name: l(Dl).VL[B.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOddmentByHalfOut ? (w(), U(O, { key: 2, color: B.outboundRelationType === l(gl).CUT.V || B.outboundRelationType === l(gl).CUT_TRANSFER.V ? "#214283" : "#e6a23c", name: B.outboundRelationType === l(gl).CUT.V || B.outboundRelationType === l(gl).CUT_TRANSFER.V ? "切割半出" : "半出余料", show: !!B.boolOddmentByHalfOut }, null, 8, ["color", "name", "show"])) : H("", true), e.showOutboundMode && B.materialOutboundMode === l(Oa).HALF.V ? (w(), U(O, { key: 3, color: l(Oa).V[B.materialOutboundMode].COLOR, name: l(Oa).VL[B.materialOutboundMode], offset: 15 }, null, 8, ["color", "name"])) : H("", true), e.showOutboundMode && B.basicClass & l(Ci).STEEL_COIL.V && B.length ? (w(), U(O, { key: 4, name: B.boolBasicClassChange ? "出至钢板库" : "条板出库", offset: 15, color: "#e6a23c" }, null, 8, ["name"])) : H("", true), e.showRejectStatus ? (w(), Q(Qe, { key: 5 }, [l(A)(B.rejectStatus) && B.rejectStatus !== l(Wl).NONE.V ? (w(), U(O, { key: 0, class: Zt({ pointer: e.rejectDetailViewable }), color: l(Wl).V[B.rejectStatus].COLOR, name: l(Wl).VL[B.rejectStatus], onClick: (q) => m(B) }, null, 8, ["class", "color", "name", "onClick"])) : H("", true)], 64)) : H("", true), e.showTip && (B.basicClass === l(Ci).STEEL_PLATE.V || B.basicClass === l(Ci).SECTION_STEEL.V) ? (w(), U(O, { key: 6, color: "#f23c3c", offset: 15, show: B.boolReturns || B.boolRemnant, name: "退余料" }, null, 8, ["show"])) : H("", true), C("span", null, K(e.isSerialNumber ? B.serialNumber : B.materialSn), 1)]), _: 3 }, 8, ["fixed", "prop", "sortable"])) : H("", true), xt(P.$slots, "afterMaterialSn", {}, void 0, true), e.showClassification && !V.value ? (w(), U(x, { key: 3, fixed: e.fixed, align: "center", label: "分类", "min-width": "100px", prop: "classification", "show-overflow-tooltip": "" }, null, 8, ["fixed"])) : H("", true), g.value ? (w(), U(x, { key: 4, fixed: e.fixed, label: e.classifyNameAlias, width: M.value, align: "center", prop: "classifyName", "show-overflow-tooltip": "" }, { default: p(({ row: B }) => [C("div", lz, [e.showFrozenTip && B.boolHasFrozen ? (w(), Q("span", oz)) : H("", true), s(I, { content: B.classifyParentFullName, disabled: !B.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [C("span", null, [h.value && B.boolHasFrozen ? (w(), Q("span", { key: 0, class: "freeze-text text", onClick: (q) => f(B) }, K(B.classifyName), 9, nz)) : (w(), Q("span", sz, K(B.classifyName), 1))])]), _: 2 }, 1032, ["content", "disabled"])])]), _: 1 }, 8, ["fixed", "label", "width"])) : H("", true), (w(), U(Ri(N.value), ii({ "basic-class": e.basicClass, columns: e.columns, fixed: e.fixed, "is-show-spec": l(u), returnSortable: e.returnSortable, sortable: T.value, "spec-merge": e.specMerge, specificationLable: c.specificationLable }, P.$attrs), null, 16, ["basic-class", "columns", "fixed", "is-show-spec", "returnSortable", "sortable", "spec-merge", "specificationLable"])), s(Y, { modelValue: E.value, "onUpdate:modelValue": L[0] || (L[0] = (B) => E.value = B), "before-close": v, title: `冻结记录：${r.value.classifyName} ${((ee = r.value) == null ? void 0 : ee.specification) || ""}`, "custom-class": "wms-material-freeze-record-view", "show-close": "", top: "10vh", width: "1300px" }, { default: p(() => [s(Eu, { material: r.value, "max-height": l(_), onUnfreezeSuccess: R }, null, 8, ["material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"]), s(Y, { modelValue: y.value, "onUpdate:modelValue": L[1] || (L[1] = (B) => y.value = B), title: `退货记录：${r.value.classifyName} ${r.value.specification}`, "custom-class": "wms-material-reject-material-record-view", "show-close": "", top: "10vh", width: "80%" }, { default: p(() => [s(yu, { "basic-class": r.value.basicClass, list: r.value.rejectList, material: r.value, "max-height": l(_), "has-border": "" }, null, 8, ["basic-class", "list", "material", "max-height"])]), _: 1 }, 8, ["modelValue", "title"])], 64);
  };
} }, fa = ut(rz, [["__scopeId", "data-v-80c89cd3"]]);
function pl({ headers: e, data: o, filename: n, sheetName: c = "Sheet1" }) {
  const u = Nu.utils.book_new(), r = o.map((b) => {
    const V = {};
    return e.forEach((M) => {
      V[M.title] = b[M.key];
    }), V;
  }), E = Nu.utils.json_to_sheet(r), y = e.map((b) => ({ wch: b.wch || 15 }));
  E["!cols"] = y, Nu.utils.book_append_sheet(u, E, c), Nu.writeFile(u, `${n}.xlsx`);
}
function eo(e, o, n) {
  const { workshopNameV2List: c, warehouseV2List: u, arr: r, errorList: E, supplierList: y, basicClass: b } = n;
  if (e.workshopName) {
    const V = c.find((M) => M.name === e.workshopName);
    A(V) ? e.workshopId = V == null ? void 0 : V.id : E.push({ rowIndex: o + 1, error: `没有查询到名为 "${e.workshopName}" 的仓库` });
  }
  if (e.warehouseName) {
    const V = u.find((M) => M.name === e.warehouseName && M.workshopId === (e == null ? void 0 : e.workshopId) && b & M.materialType);
    A(V) ? e.warehouseId = V == null ? void 0 : V.id : E.push({ rowIndex: o + 1, error: `没有查询到${Pe.VL[b]}: ${e.workshopName} 仓库下的 "${e.warehouseName}" 存储位置` });
  }
  if (e.projectSerialNumber) {
    const V = r.find((M) => M.serialNumber === e.projectSerialNumber);
    A(V) ? (e.projectId = V == null ? void 0 : V.id, e.projectFullName = V == null ? void 0 : V.fullName) : E.push({ rowIndex: o + 1, error: `没有查询到项目编号为 ${e.projectSerialNumber} 的项目` });
  }
  if (e != null && e.materialIsWholeName) if (["整料", "余料"].includes(e.materialIsWholeName)) {
    const V = [];
    for (const g in Dl.ENUM) V.push(Dl.ENUM[g]);
    const M = V.find((g) => g.L === e.materialIsWholeName);
    A(M) && (e.materialIsWhole = M.V);
  } else {
    const V = `不存在 "${e.materialIsWholeName}" 请正确填写【整料/余料】`;
    E.some((g) => g.error === V) || E.push({ rowIndex: o + 1, error: V });
  }
  if (e.supplierName) {
    const V = y.find((M) => M.name === e.supplierName);
    A(V) ? e.supplierId = V == null ? void 0 : V.id : E.push({ rowIndex: o + 1, error: `没有查询到名为 "${e.supplierName}" 的供应商` });
  }
}
const kr = vi[Ge.STEEL_PLATE.V];
function uz(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "钢板申购清单-错误清单", sheetName: "错误清单" });
}
const gm = { title: "钢板申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: kr.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: kr.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: kr.length.precision, excelField: "__EMPTY_4" }, { label: "数量（张）", field: "quantity", type: "number", precision: kr.measure.precision, excelField: "__EMPTY_5" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: kr.weight.precision, excelField: "__EMPTY_6" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_7" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var T;
  if (!gi(e, gm.rules)) return;
  const n = await _a();
  _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const c = _e.state.wms.steelDensityCfg;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const u = _e.state.config.rawMatClsList.filter((_) => _.basicClass === Ge.STEEL_PLATE.V), r = _e.state.config.rawMatClsKV, E = At(e), y = [];
  let b = [];
  const V = [], M = [], g = [];
  E.forEach((_, f) => {
    let m = false;
    const R = pi(_.classifyName.split("/"));
    if (R.length === 1) {
      const v = u.filter((N) => N.name === _.classifyName) || [];
      if (A(v)) if (v.length === 1) m = true, _.classifyId = v[0].id, y.push(v[0].id);
      else {
        const N = [];
        for (const L of v) if (L.isLeaf) for (let O = 0; O < L.fullPathId.length; O++) L.id !== L.fullPathId[O] && N.push(L.fullPathId[O]);
        const P = v.find((L) => Ae(L.parent) && !N.includes(L.id));
        if (A(P)) m = true, _.classifyId = P.id, y.push(P.id);
        else {
          const L = v.filter((O) => O.isLeaf) || [];
          if (L.length === 1) {
            let O = true;
            v.forEach((x) => {
              L[0].fullPathId.includes(x.id) || (O = false);
            }), O && (m = true, _.classifyId = L[0].id, y.push(L[0].id));
          } else for (const O of v) A(O.parent) && !N.includes(O.id) && V.push(O);
        }
      }
      V.length > 1 && g.push({ rowIndex: f + 1, error: `科目名称"${_.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const v of u) if (v.fullPathName.length >= R.length && mi(v.fullPathName.slice(-R.length), R)) {
      m = true, _.classifyId = v.id, y.push(v.id);
      break;
    }
    if (m || (b.push(_.classifyName), M.some((v) => v.classifyName === _.classifyName) || M.push({ rowIndex: f + 1, classifyName: _.classifyName })), _.shortName) {
      const v = _e.state.project.projectAllType.find((N) => N.shortName === _.shortName);
      v ? _.projectId = v.id : g.push({ rowIndex: f + 1, error: `名称为“${_.shortName}”的项目不存在”` });
    } else _.projectId = -1;
    _.arrivalTime ? _.arrivalTime = yr(_.arrivalTime) : _.arrivalTime = "同上";
  }), b = Array.from(new Set(b)), b.length > 0 && (g.push({ rowIndex: M[0].rowIndex, error: `${M.map((_) => `"${_.classifyName}"`).join("、")}${M.length > 1 ? "等" : ""}物料种类不存在` }), M.shift());
  const S = _e.state.config.classifySpec, h = y.filter((_) => S[_] === void 0);
  h.length > 0 && (h.forEach((_) => {
    S[_] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", h));
  for (const _ of E) {
    if (((T = r == null ? void 0 : r[_.classifyId]) == null ? void 0 : T.isLeaf) === false) {
      g.push({ rowIndex: E.indexOf(_) + 1, error: `${_.classifyName}不是末级科目` });
      continue;
    }
    const f = S[_.classifyId];
    if ((f == null ? void 0 : f.hasUnitConfig) === false) {
      g.push({ rowIndex: E.indexOf(_) + 1, error: `${_.classifyName}未配置核算单位` });
      continue;
    }
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
      for (const N in c) Number(N) === _.classifyId && (v = c[N]);
      _.steelDensity = v, _.theoryWeight = await na({ classifyId: _.classifyId, name: _.classifyFullName, length: _.length, width: _.width, thickness: _.thickness }), A(_.theoryWeight) && _.quantity ? _.theoryTotalWeight = Be(_.theoryWeight * _.quantity, n[Ge.STEEL_PLATE.V].weight.precision) : _.theoryTotalWeight = void 0, _.weighingTotalWeight = _.weighingTotalWeight && !isNaN(_.weighingTotalWeight) ? _.weighingTotalWeight : _.theoryTotalWeight, _.mete = _.weighingTotalWeight;
    } else {
      const v = `${_.classifyName}下不存在规格为"${R}"的材料，请联系管理员/仓库人员添加`;
      g.some((N) => N.error === v) || g.push({ rowIndex: E.indexOf(_) + 1, error: v });
      continue;
    }
  }
  if (g.length > 0) uz(g);
  else return E;
} }, Yd = vi[Ge.SECTION_STEEL.V];
function cz(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "型材申购清单-错误清单", sheetName: "错误清单" });
}
const Av = { title: "型材申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "spec", excelField: "__EMPTY_1" }, { label: "材质", field: "model", excelField: "__EMPTY_2" }, { label: "定尺长度（mm）", field: "length", type: "number", precision: Yd.length.precision, excelField: "__EMPTY_3" }, { label: "数量（根）", field: "quantity", type: "number", precision: Yd.measure.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Yd.weight.precision, excelField: "__EMPTY_5" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_6" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_7" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }], spec: [{ required: true, message: "型材规格不能为空" }], model: [{ required: true, message: "型材材质不能为空" }] }, format: async (e) => {
  var h, T, _;
  if (!gi(e, Av.rules)) return;
  const n = await _a();
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const c = _e.state.config.rawMatClsList.filter((f) => f.basicClass === Ge.SECTION_STEEL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [], V = [], M = [];
  r.forEach((f, m) => {
    let R = false;
    const v = pi(f.classifyName.split("/"));
    if (v.length === 1) {
      const N = c.filter((P) => P.name === f.classifyName) || [];
      if (A(N)) if (N.length === 1) R = true, f.classifyId = N[0].id, E.push(N[0].id);
      else {
        const P = [];
        for (const O of N) if (O.isLeaf) for (let x = 0; x < O.fullPathId.length; x++) O.id !== O.fullPathId[x] && P.push(O.fullPathId[x]);
        const L = N.find((O) => Ae(O.parent) && !P.includes(O.id));
        if (A(L)) R = true, f.classifyId = L.id, E.push(L.id);
        else {
          const O = N.filter((x) => x.isLeaf) || [];
          if (O.length === 1) {
            let x = true;
            N.forEach((I) => {
              O[0].fullPathId.includes(I.id) || (x = false);
            }), x && (R = true, f.classifyId = O[0].id, E.push(O[0].id));
          } else for (const x of N) A(x.parent) && !P.includes(x.id) && b.push(x);
        }
      }
      b.length > 1 && M.push({ rowIndex: m + 1, error: `科目名称"${f.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const N of c) if (N.fullPathName.length >= v.length && mi(N.fullPathName.slice(-v.length), v)) {
      R = true, f.classifyId = N.id, E.push(N.id);
      break;
    }
    if (R || (y.push(f.classifyName), V.some((N) => N.classifyName === f.classifyName) || V.push({ rowIndex: m + 1, classifyName: f.classifyName })), f.shortName) {
      const N = _e.state.project.projectAllType.find((P) => P.shortName === f.shortName);
      N ? f.projectId = N.id : M.push({ rowIndex: m + 1, error: `名称为“${f.shortName}”的项目不存在”` });
    } else f.projectId = -1;
    f.arrivalTime ? f.arrivalTime = yr(f.arrivalTime) : f.arrivalTime = "同上";
  }), y = Array.from(new Set(y)), y.length > 0 && (M.push({ rowIndex: V[0].rowIndex, error: `${V.map((f) => `"${f.classifyName}"`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在` }), V.shift());
  const g = _e.state.config.classifySpec, S = E.filter((f) => g[f] === void 0);
  S.length > 0 && (S.forEach((f) => {
    g[f] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const f of r) {
    if (((h = u == null ? void 0 : u[f.classifyId]) == null ? void 0 : h.isLeaf) === false) {
      M.push({ rowIndex: r.indexOf(f) + 1, error: `${f.classifyName}不是末级科目` });
      continue;
    }
    const m = g[f.classifyId];
    if ((m == null ? void 0 : m.hasUnitConfig) === false) {
      M.push({ rowIndex: r.indexOf(f) + 1, error: `${f.classifyName}未配置核算单位` });
      continue;
    }
    let R;
    const v = `${f.spec} * ${f.model}`, N = mz(v);
    if (m && Array.isArray(m.specList)) {
      for (const P of m.specList) if (N === P.spec) {
        if (P.status) R = P;
        else throw new Error(`${N}被禁用，请开启后重新导入`);
        break;
      }
    }
    if (R) {
      let P;
      if (R.classify.basicClass === Pe.SECTION_STEEL.V && (P = (_ = (T = R.nationalStandardOptions) == null ? void 0 : T.find((L) => L.boolDefault === true)) == null ? void 0 : _.standardId), f.uid = Tt(), f.sn = R.sn, f.specificationLabels = R.specificationLabels, f.serialNumber = R.serialNumber, f.classifySerialNumber = R.classify.serialNumber, f.classifyId = R.classify.id, f.classifyFullName = R.classify.fullName, f.classifyName = R.classify.name, f.classifyParentFullName = R.classify.parentFullName, f.basicClass = R.classify.basicClass, f.specification = R.spec, f.specificationMap = R.specKV, f.measureUnit = R.classify.measureUnit, f.accountingUnit = R.classify.accountingUnit, f.accountingPrecision = R.classify.accountingPrecision, f.measurePrecision = R.classify.measurePrecision, f.unitWeight = R.unitWeight, f.standardId = P, f.sectionSteelSpec = void 0, f.doNotSectionSteelSpec = void 0, f.basicClass === Pe.SECTION_STEEL.V) {
        let L;
        const O = [];
        for (const x in f.specificationMap) x.indexOf("standard") > -1 ? L = f.specificationMap[x] : O.push(f.specificationMap[x]);
        f.sectionSteelSpec = L, f.doNotSectionSteelSpec = O.join(" * ");
      }
      f.theoryWeight = await xa({ length: f.length, unitWeight: f.unitWeight }), A(f.theoryWeight) && f.quantity ? f.theoryTotalWeight = Be(f.theoryWeight * f.quantity, n[Ge.SECTION_STEEL.V].weight.precision) : f.theoryTotalWeight = void 0, f.weighingTotalWeight = f.weighingTotalWeight && !isNaN(f.weighingTotalWeight) ? f.weighingTotalWeight : f.theoryTotalWeight, dz(f), f.mete = f.weighingTotalWeight;
    } else {
      const P = `${f.classifyName}下不存在规格为"${N}"的材料，请联系管理员/仓库人员添加`;
      M.some((L) => L.error === P) || M.push({ rowIndex: r.indexOf(f) + 1, error: P });
      continue;
    }
  }
  if (M.length > 0) cz(M);
  else return r;
} };
function dz(e) {
  A(e.length) && e.quantity ? e.totalLength = Na({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
}
function mz(e) {
  const o = e.replace(/\s+/g, ""), n = o.lastIndexOf("*");
  return n > -1 ? o.substring(0, n) + " * " + o.substring(n + 1) : o.substring(n + 1);
}
const Pu = vi[Ge.STEEL_COIL.V];
function pz(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "钢卷申购清单-错误清单", sheetName: "错误清单" });
}
const Nv = { title: "钢卷申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "材质", field: "material", excelField: "__EMPTY_1" }, { label: "厚（mm）", field: "thickness", type: "number", precision: Pu.thickness.precision, excelField: "__EMPTY_2" }, { label: "宽（mm）", field: "width", type: "number", precision: Pu.width.precision, excelField: "__EMPTY_3" }, { label: "长（mm）", field: "length", type: "number", precision: Pu.length.precision, excelField: "__EMPTY_4" }, { label: "总重（t）", field: "weighingTotalWeight", type: "number", precision: Pu.weight.precision, excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_7" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var h;
  if (!gi(e, Nv.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree"), _e.state.wms.loaded.steelDensityCfg || await _e.dispatch("config/fetchSteelDensityCfg");
  const n = _e.state.wms.steelDensityCfg, c = _e.state.config.rawMatClsList.filter((T) => T.basicClass === Ge.STEEL_COIL.V), u = _e.state.config.rawMatClsKV, r = At(e), E = [];
  let y = [];
  const b = [], V = [], M = [];
  r.forEach((T, _) => {
    let f = false;
    const m = pi(T.classifyName.split("/"));
    if (m.length === 1) {
      const R = c.filter((v) => v.name === T.classifyName) || [];
      if (A(R)) if (R.length === 1) f = true, T.classifyId = R[0].id, E.push(R[0].id);
      else {
        const v = [];
        for (const P of R) if (P.isLeaf) for (let L = 0; L < P.fullPathId.length; L++) P.id !== P.fullPathId[L] && v.push(P.fullPathId[L]);
        const N = R.find((P) => Ae(P.parent) && !v.includes(P.id));
        if (A(N)) f = true, T.classifyId = N.id, E.push(N.id);
        else {
          const P = R.filter((L) => L.isLeaf) || [];
          if (P.length === 1) {
            let L = true;
            R.forEach((O) => {
              P[0].fullPathId.includes(O.id) || (L = false);
            }), L && (f = true, T.classifyId = P[0].id, E.push(P[0].id));
          } else for (const L of R) A(L.parent) && !v.includes(L.id) && b.push(L);
        }
      }
      b.length > 1 && M.push({ rowIndex: _ + 1, error: `科目名称"${T.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const R of c) if (R.fullPathName.length >= m.length && mi(R.fullPathName.slice(-m.length), m)) {
      f = true, T.classifyId = R.id, E.push(R.id);
      break;
    }
    if (f || (y.push(T.classifyName), V.some((R) => R.classifyName === T.classifyName) || V.push({ rowIndex: _ + 1, classifyName: T.classifyName })), T.shortName) {
      const R = _e.state.project.projectAllType.find((v) => v.shortName === T.shortName);
      R ? T.projectId = R.id : M.push({ rowIndex: _ + 1, error: `名称为“${T.shortName}”的项目不存在”` });
    } else T.projectId = -1;
    T.arrivalTime ? T.arrivalTime = yr(T.arrivalTime) : T.arrivalTime = "同上";
  }), y = Array.from(new Set(y)), y.length > 0 && (M.push({ rowIndex: V[0].rowIndex, error: `${V.map((T) => `"${T.classifyName}"`).join("、")}${V.length > 1 ? "等" : ""}物料种类不存在` }), V.shift());
  const g = _e.state.config.classifySpec, S = E.filter((T) => g[T] === void 0);
  S.length > 0 && (S.forEach((T) => {
    g[T] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", S));
  for (const T of r) {
    if (((h = u == null ? void 0 : u[T.classifyId]) == null ? void 0 : h.isLeaf) === false) {
      M.push({ rowIndex: r.indexOf(T) + 1, error: `${T.classifyName}不是末级科目` });
      continue;
    }
    const _ = g[T.classifyId];
    if ((_ == null ? void 0 : _.hasUnitConfig) === false) {
      M.push({ rowIndex: r.indexOf(T) + 1, error: `${T.classifyName}未配置核算单位` });
      continue;
    }
    let f;
    const m = T.material ?? "";
    if (_ && Array.isArray(_.specList)) {
      for (const R of _.specList) if (m === R.spec) {
        f = R;
        break;
      }
    }
    if (f) {
      T.uid = Tt(), T.sn = f.sn, T.specificationLabels = f.specificationLabels, T.serialNumber = f.serialNumber, T.classifySerialNumber = f.classify.serialNumber, T.classifyId = f.classify.id, T.classifyFullName = f.classify.fullName, T.classifyName = f.classify.name, T.classifyParentFullName = f.classify.parentFullName, T.basicClass = f.classify.basicClass, T.specification = f.spec, T.specificationMap = f.specKV, T.measureUnit = f.classify.measureUnit, T.accountingUnit = f.classify.accountingUnit, T.accountingPrecision = f.classify.accountingPrecision, T.measurePrecision = f.classify.measurePrecision;
      let R = 0;
      for (const v in n) Number(v) === T.classifyId && (R = n[v]);
      T.steelDensity = R, await hz(T), T.length = T.length || T.theoryLength, T.quantity = T.length, T.mete = T.weighingTotalWeight;
    } else {
      const R = `${T.classifyName}下不存在规格为"${m}"的材料，请联系管理员/仓库人员添加`;
      M.some((v) => v.error === R) || M.push({ rowIndex: r.indexOf(T) + 1, error: R });
      continue;
    }
  }
  if (M.length > 0) pz(M);
  else return r;
} };
async function hz(e) {
  e.theoryLength = await il({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
}
function fz(e, o) {
  const n = [{ title: "行号", key: "rowIndex", wch: 10 }, { title: "错误信息", key: "error", wch: 80 }], c = e.map((u) => ({ rowIndex: u.rowIndex, error: u.error }));
  Di({ type: "error", title: "导入失败,请查看错误清单", duration: 8e3 }), pl({ headers: n, data: c, filename: "其他钢材申购清单-错误清单", sheetName: "错误清单" });
}
const Lv = { title: "其他钢材申购清单", dlgWidth: "1500px", startRow: 2, endIgnoreRow: 1, fields: [{ label: "物料种类", field: "classifyName", excelField: "__EMPTY" }, { label: "规格", field: "specification", excelField: "__EMPTY_1" }, { label: "计量单位", field: "measureUnit", excelField: "__EMPTY_2" }, { label: "数量", field: "quantity", type: "number", excelField: "__EMPTY_3" }, { label: "核算单位", field: "accountingUnit", excelField: "__EMPTY_4" }, { label: "核算量", field: "mete", type: "number", excelField: "__EMPTY_5" }, { label: "颜色", field: "color", excelField: "__EMPTY_6" }, { label: "所属项目（简称）", field: "shortName", excelField: "__EMPTY_7" }, { label: "需求时间", field: "arrivalTime", excelField: "__EMPTY_8" }], rules: { classifyName: [{ required: true, message: "物料种类不能为空" }] }, format: async (e) => {
  var S;
  if (!gi(e, Lv.rules)) return;
  _e.state.config.loaded.matClsTree || await _e.dispatch("config/fetchMatClsTree");
  const n = _e.state.config.rawMatClsList.filter((h) => h.basicClass === Pe.OTHER_STEEL_MATERIALS.V), c = _e.state.config.rawMatClsKV, u = At(e), r = [];
  let E = [];
  const y = [], b = [], V = [];
  u.forEach((h, T) => {
    let _ = false;
    const f = pi(h.classifyName.split("/"));
    if (f.length === 1) {
      const m = n.filter((R) => R.name === h.classifyName) || [];
      if (A(m)) if (m.length === 1) _ = true, h.classifyId = m[0].id, r.push(m[0].id);
      else {
        const R = [];
        for (const N of m) if (N.isLeaf) for (let P = 0; P < N.fullPathId.length; P++) N.id !== N.fullPathId[P] && R.push(N.fullPathId[P]);
        const v = m.find((N) => Ae(N.parent) && !R.includes(N.id));
        if (A(v)) _ = true, h.classifyId = v.id, r.push(v.id);
        else {
          const N = m.filter((P) => P.isLeaf) || [];
          if (N.length === 1) {
            let P = true;
            m.forEach((L) => {
              N[0].fullPathId.includes(L.id) || (P = false);
            }), P && (_ = true, h.classifyId = N[0].id, r.push(N[0].id));
          } else for (const P of m) A(P.parent) && !R.includes(P.id) && y.push(P);
        }
      }
      y.length > 1 && V.push({ rowIndex: T + 1, error: `科目名称"${h.classifyName}"在科目配置中存在同名的情况，需要带上父级科目名称如"一级科目/二级科目/末级科目"` });
    } else for (const m of n) if (m.fullPathName.length >= f.length && mi(m.fullPathName.slice(-f.length), f)) {
      _ = true, h.classifyId = m.id, r.push(m.id);
      break;
    }
    if (_ || (E.push(h.classifyName), b.some((m) => m.classifyName === h.classifyName) || b.push({ rowIndex: T + 1, classifyName: h.classifyName })), h.shortName) {
      const m = _e.state.project.projectAllType.find((R) => R.shortName === h.shortName);
      m ? h.projectId = m.id : V.push({ rowIndex: T + 1, error: `名称为“${h.shortName}”的项目不存在”` });
    } else h.projectId = -1;
    h.arrivalTime ? h.arrivalTime = yr(h.arrivalTime) : h.arrivalTime = "同上";
  }), E = Array.from(new Set(E)), E.length > 0 && (V.push({ rowIndex: b[0].rowIndex, error: `${b.map((h) => `"${h.classifyName}"`).join("、")}${b.length > 1 ? "等" : ""}物料种类不存在` }), b.shift());
  const M = _e.state.config.classifySpec, g = r.filter((h) => M[h] === void 0);
  g.length > 0 && (g.forEach((h) => {
    M[h] = {};
  }), await _e.dispatch("config/fetchMarClsSpec", g));
  for (const h of u) {
    if (((S = c == null ? void 0 : c[h.classifyId]) == null ? void 0 : S.isLeaf) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}不是末级科目` });
      continue;
    }
    const T = M[h.classifyId];
    if ((T == null ? void 0 : T.hasUnitConfig) === false) {
      V.push({ rowIndex: u.indexOf(h) + 1, error: `${h.classifyName}未配置核算单位` });
      continue;
    }
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
    if (_) h.uid = Tt(), h.sn = _.sn, h.specificationLabels = _.specificationLabels, h.serialNumber = _.serialNumber, h.classifySerialNumber = _.classify.serialNumber, h.classifyId = _.classify.id, h.classifyFullPathId = _.classify.fullPathId, h.classifyFullName = _.classify.fullName, h.classifyName = _.classify.name, h.classifyParentFullName = _.classify.parentFullName, h.basicClass = _.classify.basicClass, h.specification = _.spec, h.specificationMap = _.specKV, h.measureUnit = _.classify.measureUnit, h.accountingUnit = _.classify.accountingUnit, h.accountingPrecision = _.classify.accountingPrecision, h.measurePrecision = _.classify.measurePrecision, h.quantity && (h.quantity = Be(h.quantity, h.measurePrecision)), h.mete && (h.mete = Be(h.mete, h.accountingPrecision)), h.measureUnit || (h.quantity = void 0);
    else {
      const m = `${h.classifyName}下不存在规格为"${f}"的材料，请联系管理员/仓库人员添加`;
      V.some((R) => R.error === m) || V.push({ rowIndex: u.indexOf(h) + 1, error: m });
      continue;
    }
  }
  if (V.length > 0) fz(V);
  else return u;
} }, Ms = {};
Ms.KEY_PREFIX = "ADD_FORM";
Ms.TYPE = { normal: 1, browserClose: 2 };
function gz(e, o, n, { useDraftCallback: c, clearDraftCallback: u } = {}) {
  const r = Ct({ key: e, expired: 6048e5, form: o.form, initForm: void 0, init: void 0, isRegister: false, saveStoreForm: () => Iv(r), resetForm: () => {
    Nb(r), o.resetForm(), r.init && r.init(), typeof u == "function" && u();
  } });
  return n.HOOK.afterToEdit = () => yz(r, c), n.HOOK.afterEditSuccess = () => {
    Nb(r), Ab(r);
  }, bl(() => {
    Lb(r, o), Ab(r);
  }), window.onbeforeunload = () => {
    Lb(r, o);
  }, yi("cuFmStore", r), r;
}
function Ez(e) {
  e.initForm = void 0;
}
function yz(e, o) {
  const n = _z(e.key);
  if (Ae(n)) e.init && e.init();
  else {
    const c = n.content;
    Tz(e.form, c), typeof o == "function" && o(e.form);
  }
  e.initForm = uo.cloneDeep(e.form), e.isRegister = true;
}
function Ab(e) {
  e.isRegister = false, Ez(e);
}
