const Yne = { style: { overflow: "hidden" } }, Kne = { style: {} }, Wne = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, jne = { __name: "steel-coil-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, u = Z(false), r = Z({ resizable: true }), E = Z({ enabled: true, gt: 0, oSize: 5, scrollToTopOnChange: true, immediate: true }), y = (j, le) => !!j, b = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { validator: y, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: y, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: y, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "请填写长度", trigger: "blur" }, { validator: y, message: "长度必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, V = Ee(() => Object.assign({}, b)), M = ft("matSpecRef"), { baseUnit: g } = ai(c), { cu: S, form: h } = Wi(), T = Z(), _ = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: f, cleanUpData: m, wrongCellMask: R } = ui({ rules: V, ditto: _, errorMsg: "请修正【钢卷清单】中标红的信息" }), { steelDensityCfg: v } = cn();
  function N() {
  }
  function P({ row: j, rowIndex: le }) {
    var oe, ye;
    if ((ye = (oe = S == null ? void 0 : S.submitResult) == null ? void 0 : oe.data) != null && ye.includes(j.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function L(j) {
    const le = Ct({ uid: Tt(), sn: j.sn, specificationLabels: j.specificationLabels, serialNumber: j.serialNumber, classifyId: j.classify.id, classifyFullName: j.classify.fullName, classifyName: j.classify.name, classifyParentFullName: j.classify.parentFullName, classifySerialNumber: j.classify.serialNumber, basicClass: j.classify.basicClass, specification: j.spec, model: j.spec, specificationMap: j.specKV, measureUnit: j.classify.measureUnit, accountingUnit: j.classify.accountingUnit, accountingPrecision: j.classify.accountingPrecision, measurePrecision: j.classify.measurePrecision, quantity: void 0, color: void 0, brand: void 0, heatNoAndBatchNo: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, projectId: h.steelCoilList.length > 0 ? -1 : void 0, workshopId: h.steelCoilList.length > 0 ? -1 : void 0, warehouseId: h.steelCoilList.length > 0 ? -1 : void 0, steelDensity: A(j.steelDensity) ? j.steelDensity : v.value[j.classify.id] });
    return !n.boolPartyA && n.fillableAmount && (le.unitPrice = void 0, le.amount = void 0), O(le), le;
  }
  function O(j) {
    Ce(() => j, () => {
      var le, oe, ye;
      if (!n.boolPartyA && !n.noDetail && ((oe = (le = h.selectObj) == null ? void 0 : le[j.mergeId]) != null && oe.isSelected)) {
        const ce = (ye = h.selectObj[j.mergeId]) == null ? void 0 : ye.isSelected;
        h.selectObj[j.mergeId] = { ...h.selectObj[j.mergeId], ...j, mete: j.weighingTotalWeight, isSelected: ce };
      }
    }, { deep: true }), Ce([() => j.weighingTotalWeight, () => j.width, () => j.thickness, g], () => x(j)), Ce([() => j.theoryLength], () => I(j));
  }
  async function x(j) {
    j.theoryLength = await il({ classifyId: j.classifyId, name: j.classifyFullName, weight: j.weighingTotalWeight, width: j.width, thickness: j.thickness });
  }
  function I(j) {
    A(j.theoryLength) ? j.length = j.theoryLength * 1 : j.length = void 0;
  }
  function Y(j, le, oe) {
    var ye, ce, se, he;
    if ((ce = (ye = S == null ? void 0 : S.submitResult) == null ? void 0 : ye.data) != null && ce.includes(oe.classifyId)) {
      const be = (se = S == null ? void 0 : S.submitResult) == null ? void 0 : se.data.findIndex((ge) => ge === oe.classifyId);
      h.steelCoilList.filter((ge) => ge.classifyId === oe.classifyId).length === 1 && ((he = S == null ? void 0 : S.submitResult) == null || he.data.splice(be, 1));
    }
    if (M.value ? M.value.delListItem(j, le) : h.steelCoilList.splice(le, 1), A(h.steelCoilList) && h.steelCoilList.length > 0) {
      const be = h.steelCoilList[0];
      h.steelCoilList[0].projectId = be.projectId && be.projectId !== -1 ? be.projectId : void 0, h.steelCoilList[0].workshopId = be.workshopId && be.workshopId !== -1 ? be.workshopId : void 0, h.steelCoilList[0].warehouseId = be.warehouseId && be.warehouseId !== -1 ? be.warehouseId : void 0;
    }
  }
  function ee(j, le) {
    var ce;
    const oe = JSON.parse(JSON.stringify(j)), ye = Ct({ uid: Tt(), sn: oe.sn, specificationLabels: oe.specificationLabels, classifySerialNumber: oe.classifySerialNumber, serialNumber: oe.serialNumber, classifyId: oe.classifyId, classifyFullName: oe.classifyFullName, classifyName: oe.classifyName, classifyParentFullName: oe.classifyParentFullName, basicClass: oe.basicClass, specification: oe.specification, model: oe.model, specificationMap: oe.specificationMap, measureUnit: oe.measureUnit, accountingUnit: oe.accountingUnit, accountingPrecision: oe.accountingPrecision, measurePrecision: oe.measurePrecision, quantity: oe.quantity, color: oe.color, brand: oe.brand, heatNoAndBatchNo: oe.heatNoAndBatchNo, thickness: oe.thickness, length: oe.length, width: oe.width, theoryLength: oe.theoryLength, weighingTotalWeight: oe.weighingTotalWeight, projectId: oe.projectId, workshopId: oe.workshopId, warehouseId: oe.warehouseId, rowIndex: h.steelCoilList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : oe.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : oe.amount, steelDensity: A(oe.steelDensity) ? oe.steelDensity : v.value[oe.classify.id] });
    h.steelCoilList.push(ye), O(ye), (ce = M.value) == null || ce.initSelected([ye]);
  }
  function B() {
    if (Ae(h.steelCoilList)) return true;
    const j = h.steelCoilList.filter((oe, ye) => (oe.dataIndex = ye, true));
    if (Ae(j)) return true;
    const { validResult: le } = f(j);
    return le && (m(j), j.forEach((oe) => {
      var ye, ce;
      h.steelCoilList[oe.dataIndex].projectId = oe.projectId, h.steelCoilList[oe.dataIndex].workshopId = oe.workshopId || ((ye = oe.workshop) == null ? void 0 : ye.id), h.steelCoilList[oe.dataIndex].warehouseId = oe.warehouseId || ((ce = oe.warehouse) == null ? void 0 : ce.id);
    })), le;
  }
  function q(j, le) {
  }
  Ce(() => h.steelCoilList, (j) => {
    T.value && T.value.updateFooter();
  }, { deep: true, immediate: true });
  function ae(j) {
    var le;
    return [(le = j.columns) == null ? void 0 : le.map((oe, ye) => {
      if (ye === 0) return "合计";
      if (oe.property === "weighingTotalWeight") {
        const ce = j.data.reduce((se, he) => se + (Number(he.weighingTotalWeight) || 0), 0);
        return ce == null ? void 0 : ce.toFixed(g.value.weight.precision);
      }
      return null;
    })];
  }
  return o({ rowInit: L, rowWatch: O, toggleRowSelection: q, validate: B, setSelect: N }), (j, le) => {
    const oe = Mt, ye = Ve("vxe-column"), ce = Ve("vxe-tooltip"), se = Ve("common-input-number"), he = Ve("common-button"), be = Ve("vxe-table"), me = _t("empty-text"), ge = oi;
    return qe((w(), Q("div", Yne, [(w(), U(be, { key: `inbound_${l(c)}`, "cell-class-name": l(R), "column-config": r.value, data: l(h).steelCoilList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": P, "scroll-y": E.value, border: "", class: "myTable-style", ref_key: "tableRef", ref: T, "footer-method": ae, "show-footer": "", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(ye, { type: "expand", width: "60" }, { content: p(({ row: Le }) => [C("div", Kne, [s(oe, { modelValue: Le.remark, "onUpdate:modelValue": (Ie) => Le.remark = Ie, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Le.inboundList) ? (w(), Q("div", Wne, [s(l(al), { "basic-class": l(c), list: Le.inboundList, material: Le, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(ye, { title: "序号", type: "seq", width: "55" }), s(ye, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(ye, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Le }) => [s(ce, { content: Le.classifyParentFullName, disabled: !Le.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[me, Le.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(ye, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Le }) => [s(ce, { content: Le.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Le.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(ye, { title: `总重 (${l(g).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.weighingTotalWeight, "onUpdate:modelValue": (Ie) => Le.weighingTotalWeight = Ie, controls: false, max: 999999999, min: 0, precision: l(g).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" }, onBlur: (Ie) => j.inputNumberBlur(Ie, Le) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(ye, { title: `厚 (${l(g).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.thickness, "onUpdate:modelValue": (Ie) => Le.thickness = Ie, controls: false, max: 99999999, min: 0, precision: l(g).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" }, onBlur: (Ie) => j.inputNumberBlur(Ie, Le) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(ye, { title: `宽 (${l(g).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.width, "onUpdate:modelValue": (Ie) => Le.width = Ie, controls: false, max: 99999999, min: 0, precision: l(g).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (Ie) => j.inputNumberBlur(Ie, Le) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }, 8, ["title"]), s(ye, { title: `长度 (${l(g).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Le }) => [s(se, { modelValue: Le.length, "onUpdate:modelValue": (Ie) => Le.length = Ie, controls: false, max: 99999999, min: 0, precision: l(g).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }, 8, ["title"]), s(ye, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: Le }) => [s(oe, { modelValue: Le.color, "onUpdate:modelValue": (Ie) => Le.color = Ie, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(ye, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Le }) => [s(oe, { modelValue: Le.brand, "onUpdate:modelValue": (Ie) => Le.brand = Ie, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(ye, { align: "center", field: "heatNoAndBatchNo", title: "卷号", width: "120" }, { default: p(({ row: Le }) => [s(oe, { modelValue: Le.heatNoAndBatchNo, "onUpdate:modelValue": (Ie) => Le.heatNoAndBatchNo = Ie, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(Kn, { list: l(h).steelCoilList, order: e.order }, null, 8, ["list", "order"]), s(Wn, { list: l(h).steelCoilList, showWarehouse: "" }, null, 8, ["list"]), s(ye, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Le, rowIndex: Ie }) => [s(he, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Se) => ee(Le, Ie) }, null, 8, ["onClick"]), s(he, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Se) => Y(Le.sn, Ie, Le) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[ge, u.value]]);
  };
} }, P4 = ut(jne, [["__scopeId", "data-v-cea89dca"]]), Fne = Object.freeze(Object.defineProperty({ __proto__: null, default: P4 }, Symbol.toStringTag, { value: "Module" }));
const zne = { style: { overflow: "hidden" } }, Bne = { style: {} }, Hne = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, qne = { key: 1 }, Gne = { __name: "other-steel-material-table", props: { boolPartyA: { type: Boolean, default: false }, boolApplyPurchase: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, basicClass: { type: [String, Number], default: Pe.OTHER_STEEL_MATERIALS.V }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 } }, setup(e, { expose: o }) {
  const n = e, c = Pe.OTHER_STEEL_MATERIALS.V, u = ft("matSpecRef"), { cu: r, form: E } = Wi(), y = Z(false), b = Z({ resizable: true }), V = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: true }), S = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (ae, j) => (j.measureUnit && A(j.measurePrecision) && A(j.quantity) && (j.quantity = Be(j.quantity, j.measurePrecision)), j.measureUnit && A(j.measurePrecision) ? !!j.quantity : true), message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (ae, j) => (j.accountingUnit && A(j.accountingPrecision) && A(j.mete) && (j.mete = Be(j.mete, j.accountingPrecision)), !!j.mete), message: "核算量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, T = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (ae, j) => A(j.mete) && A(j.unitPrice) ? +Be(j.mete * j.unitPrice, Ze.YUAN) == +ae : false, message: "金额有误，请手动修改", trigger: "blur" }] }, _ = Ee(() => {
    let ae = Object.assign({}, S);
    return !n.boolPartyA && n.fillableAmount && (ae = Object.assign(ae, T)), ae;
  }), f = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: m, cleanUpData: R, wrongCellMask: v } = ui({ rules: _, ditto: f, errorMsg: "请修正【其它钢材清单】中标红的信息" });
  function N(ae = false) {
  }
  function P({ row: ae, rowIndex: j }) {
    var le, oe;
    if ((oe = (le = r == null ? void 0 : r.submitResult) == null ? void 0 : le.data) != null && oe.includes(ae.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function L(ae) {
    const j = Ct({ uid: Tt(), sn: ae.sn, specificationLabels: ae.specificationLabels, serialNumber: ae.serialNumber, classifyId: ae.classify.id, classifyFullPathId: ae.classify.fullPathId, classifyFullName: ae.classify.fullName, classifyName: ae.classify.name, classifyParentFullName: ae.classify.parentFullName, basicClass: ae.classify.basicClass, classifySerialNumber: ae.classify.serialNumber, specification: ae.spec, model: ae.spec, specificationMap: ae.specKV, measureUnit: ae.classify.measureUnit, accountingUnit: ae.classify.accountingUnit, accountingPrecision: ae.classify.accountingPrecision, measurePrecision: ae.classify.measurePrecision, outboundUnitType: ae.classify.outboundUnitType, unitNet: ae.unitNet, accountingUnitNet: ae.accountingUnitNet, mete: void 0, quantity: void 0, projectId: E.otherSteelMaterialList.length > 0 ? -1 : void 0, workshopId: E.otherSteelMaterialList.length > 0 ? -1 : void 0, warehouseId: E.otherSteelMaterialList.length > 0 ? -1 : void 0 });
    return !n.boolPartyA && n.fillableAmount && (j.unitPrice = void 0, j.amount = void 0), j;
  }
  function O(ae) {
    Ce([() => ae.boolApplyPurchase, () => ae == null ? void 0 : ae.applyPurchase], () => {
      var j, le;
      ae.boolApplyPurchase && (ae.quantity = (j = ae == null ? void 0 : ae.applyPurchase) == null ? void 0 : j.reduce((oe, ye) => oe + (ye.quantity || 0), 0), ae.mete = (le = ae == null ? void 0 : ae.applyPurchase) == null ? void 0 : le.reduce((oe, ye) => oe + (ye.mete || 0), 0));
    }, { deep: true }), Ce(() => ae, () => {
      var j, le, oe;
      if (!n.boolPartyA && !n.noDetail && ((le = (j = E.selectObj) == null ? void 0 : j[ae.mergeId]) != null && le.isSelected)) {
        const ye = (oe = E.selectObj[ae.mergeId]) == null ? void 0 : oe.isSelected;
        E.selectObj[ae.mergeId] = { ...E.selectObj[ae.mergeId], ...ae, isSelected: ye };
      }
    }, { deep: true }), Ce(() => ae.mete, () => {
      x(ae.mete, ae);
    });
  }
  function x(ae, j, le) {
    A(j.unitPrice) && A(ae) && (j.amount = Be(ae * j.unitPrice, Ze.YUAN)), ee(j, le || j);
  }
  function I(ae, j, le) {
    var oe, ye, ce, se;
    if ((ye = (oe = r == null ? void 0 : r.submitResult) == null ? void 0 : oe.data) != null && ye.includes(le.classifyId)) {
      const he = (ce = r == null ? void 0 : r.submitResult) == null ? void 0 : ce.data.findIndex((me) => me === le.classifyId);
      E.otherSteelMaterialList.filter((me) => me.classifyId === le.classifyId).length === 1 && ((se = r == null ? void 0 : r.submitResult) == null || se.data.splice(he, 1));
    }
    if (u.value ? u.value.delListItem(ae, j) : E.otherSteelMaterialList.splice(j, 1), A(E.otherSteelMaterialList) && E.otherSteelMaterialList.length > 0) {
      const he = E.otherSteelMaterialList[0];
      E.otherSteelMaterialList[0].projectId = he.projectId && he.projectId !== -1 ? he.projectId : void 0, E.otherSteelMaterialList[0].workshopId = he.workshopId && he.workshopId !== -1 ? he.workshopId : void 0, E.otherSteelMaterialList[0].warehouseId = he.warehouseId && he.warehouseId !== -1 ? he.warehouseId : void 0;
    }
  }
  function Y(ae, j) {
    const le = JSON.parse(JSON.stringify(ae)), oe = Ct({ uid: Tt(), sn: ae.sn, specificationLabels: le.specificationLabels, classifySerialNumber: le.classifySerialNumber, serialNumber: le.serialNumber, classifyId: le.classifyId, classifyFullPathId: le.classifyFullPathId, classifyFullName: le.classifyFullName, classifyName: le.classifyName, classifyParentFullName: le.classifyParentFullName, basicClass: le.basicClass, specification: le.specification, model: le.model, specificationMap: le.specificationMap, measureUnit: le.measureUnit, accountingUnit: le.accountingUnit, accountingPrecision: le.accountingPrecision, measurePrecision: le.measurePrecision, outboundUnitType: le.outboundUnitType, unitNet: le.unitNet, accountingUnitNet: le.accountingUnitNet, mete: le.mete, quantity: le.quantity, projectId: le.projectId, workshopId: le.workshopId, warehouseId: le.warehouseId, rowIndex: E.otherSteelMaterialList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : le.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : le.amount });
    E.otherSteelMaterialList.push(oe), O(oe), u.value.initSelected([oe]);
  }
  function ee(ae, { accountingUnitNet: j, measurePrecision: le }) {
    !n.boolPartyA && ae.measureUnit && j && (ae.quantity = Be(ae.mete * j, le));
  }
  function B() {
    if (Ae(E.otherSteelMaterialList)) return true;
    const ae = E.otherSteelMaterialList.filter((le, oe) => (le.dataIndex = oe, true));
    if (Ae(ae)) return true;
    const { validResult: j } = m(ae);
    return j && (R(ae), ae.forEach((le) => {
      var oe, ye;
      E.otherSteelMaterialList[le.dataIndex].projectId = le.projectId, E.otherSteelMaterialList[le.dataIndex].workshopId = le.workshopId || ((oe = le.workshop) == null ? void 0 : oe.id), E.otherSteelMaterialList[le.dataIndex].warehouseId = le.warehouseId || ((ye = le.warehouse) == null ? void 0 : ye.id), E.otherSteelMaterialList[le.dataIndex].quantity = le.measureUnit && A(le.measurePrecision) ? le.quantity : void 0;
    })), j;
  }
  function q(ae, j) {
  }
  return o({ rowInit: L, toggleRowSelection: q, setSelect: N, rowWatch: O, validate: B }), (ae, j) => {
    const le = Mt, oe = Ve("vxe-column"), ye = Ve("vxe-tooltip"), ce = Ve("common-input-number"), se = Ve("common-button"), he = Ve("vxe-table"), be = _t("empty-text"), me = oi;
    return qe((w(), Q("div", zne, [(w(), U(he, { key: `inbound_${l(c)}`, "cell-class-name": l(v), "column-config": b.value, data: l(E).otherSteelMaterialList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": P, "scroll-y": V.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(oe, { type: "expand", width: "60" }, { content: p(({ row: ge }) => [C("div", Bne, [s(le, { modelValue: ge.remark, "onUpdate:modelValue": (Le) => ge.remark = Le, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(ge.inboundList) ? (w(), Q("div", Hne, [s(l(Vd), { "basic-class": l(c), list: ge.inboundList, material: ge, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(oe, { title: "序号", type: "seq", width: "55" }), s(oe, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), s(oe, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ge }) => [s(ye, { content: ge.classifyParentFullName, disabled: !ge.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[be, ge.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(oe, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ge }) => [s(ye, { content: ge.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ge.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(oe, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: ge }) => [C("span", null, K(ge.measureUnit || "-"), 1)]), _: 1 }), s(oe, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: ge }) => [l(A)(ge.measureUnit) ? (w(), U(ce, { key: 0, modelValue: ge.quantity, "onUpdate:modelValue": (Le) => ge.quantity = Le, controls: false, max: 999999999, min: 0, precision: ge.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", qne, K(ge.quantity), 1))]), _: 1 }), s(oe, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: ge }) => [C("span", null, K(ge.accountingUnit || "-"), 1)]), _: 1 }), s(oe, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: ge }) => [s(ce, { modelValue: ge.mete, "onUpdate:modelValue": (Le) => ge.mete = Le, controls: false, max: 999999999, min: 1e-6, precision: ge.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), s(oe, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: ge }) => [s(le, { modelValue: ge.color, "onUpdate:modelValue": (Le) => ge.color = Le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(oe, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ge }) => [s(le, { modelValue: ge.brand, "onUpdate:modelValue": (Le) => ge.brand = Le, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(Kn, { list: l(E).otherSteelMaterialList, order: e.order }, null, 8, ["list", "order"]), s(Wn, { list: l(E).otherSteelMaterialList, showWarehouse: "" }, null, 8, ["list"]), s(oe, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: ge, rowIndex: Le }) => [s(se, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Ie) => Y(ge, Le) }, null, 8, ["onClick"]), s(se, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Ie) => I(ge.sn, Le, ge) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[me, y.value]]);
  };
} }, O4 = ut(Gne, [["__scopeId", "data-v-d589e106"]]), Qne = Object.freeze(Object.defineProperty({ __proto__: null, default: O4 }, Symbol.toStringTag, { value: "Module" }));
const Zne = { style: { overflow: "hidden" } }, Jne = { style: {} }, Xne = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, $ne = { key: 1 }, ese = { key: 1 }, tse = { key: 1 }, ise = { key: 1 }, ase = { key: 1 }, lse = { key: 1 }, ose = { key: 1 }, nse = { key: 1 }, sse = { __name: "steel-plate-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_PLATE.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => y.steelPlateList, (k) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var ie;
    let k = 0, J = 0, z = 0, F = 0, G = 0;
    (ie = y.steelPlateList) == null || ie.forEach((ue) => {
      k += Number(ue.quantity) || 0, J += Number(ue.mete) || 0, z += Number(ue.amount) || 0, F += Number(ue.amountExcludingVatFreight) || 0, G += Number(ue.weighingTotalWeight) || 0;
    }), J = J.toFixed(2), G = G.toFixed(2), z = z.toFixed(Ze.YUAN), F = F.toFixed(Ze.YUAN), f.value = [{ seq: "合计", quantity: k, mete: J, amountExcludingVatFreight: F, amount: z, weighingTotalWeight: G }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = (k, J) => !!k, ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "厚度必填", trigger: "blur" }, { validator: Y, message: "厚度必须大于0", trigger: "blur" }], width: [{ required: true, message: "宽度必填", trigger: "blur" }, { validator: Y, message: "宽度必须大于0", trigger: "blur" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: Y, message: "长度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: M, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: Y, message: "重量必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: Y, message: "数量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWholeName: [{ required: true, message: "请选择整料/余料", trigger: "blur" }] }, B = { amount: [{ required: true, message: "请填写金额", trigger: "blur" }] }, q = Ee(() => {
    let k = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (k = Object.assign(k, B)), k;
  }), ae = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: j, cleanUpData: le, wrongCellMask: oe } = ui({ rules: q, ditto: ae, errorMsg: "请修正【钢板清单】中标红的信息" });
  function ye() {
  }
  function ce({ row: k, rowIndex: J }) {
    var z, F;
    if ((F = (z = E == null ? void 0 : E.submitResult) == null ? void 0 : z.data) != null && F.includes(k.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function se(k) {
    Dt(() => {
      var J, z, F, G;
      k.needFirstCalcTheoryWeight && (k.boolApplyPurchase || (be(k), me(k)), k.boolApplyPurchase && ((z = (J = y.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected) && (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0)), k.needFirstCalcTheoryWeight = false), V(k);
    }), Ce([() => k.boolApplyPurchase, () => k == null ? void 0 : k.applyPurchase], () => {
      var J, z, F, G;
      k.boolApplyPurchase && ((z = (J = y.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected ? (k.quantity = (F = k == null ? void 0 : k.applyPurchase) == null ? void 0 : F.reduce((ie, ue) => ie + (ue.quantity || 0), 0), k.theoryTotalWeight = (G = k == null ? void 0 : k.applyPurchase) == null ? void 0 : G.reduce((ie, ue) => ie + (ue.theoryTotalWeight || 0), 0), k.weighingTotalWeight = k.theoryTotalWeight) : (k.quantity = 0, k.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => k, () => {
      var J, z, F;
      if (!n.boolPartyA && !n.noDetail && ((z = (J = y.selectObj) == null ? void 0 : J[k.mergeId]) != null && z.isSelected)) {
        const G = (F = y.selectObj[k.mergeId]) == null ? void 0 : F.isSelected;
        y.selectObj[k.mergeId] = { ...y.selectObj[k.mergeId], ...k, mete: k.weighingTotalWeight, isSelected: G };
      }
    }, { deep: true }), k.boolApplyPurchase || (Ce([() => k.length, () => k.width, () => k.thickness, r], () => be(k)), Ce([() => k.theoryWeight, () => k.quantity], () => me(k))), Ce(() => k.weighingTotalWeight, () => {
      ge(k);
    });
  }
  function he(k, J) {
    me(J);
  }
  async function be(k) {
    k.theoryWeight = await na({ classifyId: k.classifyId, name: k.classifyFullName, length: k.length, width: k.width, thickness: k.thickness });
  }
  function me(k) {
    A(k.theoryWeight) && k.quantity ? (k.theoryTotalWeight = Be(k.theoryWeight * k.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = Be(k.theoryWeight * k.quantity, r.value.weight.precision))) : (k.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (k.weighingTotalWeight = void 0));
  }
  function ge(k) {
    A(k.unitPrice) && A(k.weighingTotalWeight) ? k.amount = Be(k.weighingTotalWeight * k.unitPrice, Ze.YUAN) : k.amount = void 0;
  }
  function Le(k, J, z) {
    u.value ? u.value.delListItem(k, J) : y.steelPlateList.splice(J, 1);
  }
  function Ie(k, J) {
    var G;
    const z = JSON.parse(JSON.stringify(k)), F = Ct({ uid: Tt(), sn: z.sn, specificationLabels: z.specificationLabels, classifySerialNumber: z.classifySerialNumber, serialNumber: z.serialNumber, classifyId: z.classifyId, classifyFullName: z.classifyFullName, classifyName: z.classifyName, classifyParentFullName: z.classifyParentFullName, basicClass: z.basicClass, specification: z.specification, model: z.spec, specificationMap: z.specificationMap, measureUnit: z.measureUnit, accountingUnit: z.accountingUnit, accountingPrecision: z.accountingPrecision, measurePrecision: z.measurePrecision, quantity: z.quantity, thickness: z.thickness, length: z.length, width: z.width, theoryWeight: z.theoryWeight, theoryTotalWeight: z.theoryTotalWeight, weighingTotalWeight: z.weighingTotalWeight, rowIndex: y.steelPlateList.length, weightMeasurementMode: z.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : z.unitPrice, brand: z.brand, heatNoAndBatchNo: z.heatNoAndBatchNo, projectSerialNumber: z.projectSerialNumber, projectId: z.projectId, workshopName: z.workshopName, warehouseName: z.warehouseName, workshopId: z.workshopId, warehouseId: z.warehouseId, materialIsWholeName: z.materialIsWholeName });
    y.steelPlateList.push(F), se(F), (G = u.value) == null || G.initSelected([F]);
  }
  function Se() {
    const k = At(y.steelPlateList), { validResult: J } = j(y.steelPlateList);
    if (J) le(k), k.forEach((z) => {
    });
    else {
      const z = y.steelPlateList.find((F) => F.verify ? Object.values(F.verify).some((G) => G === false) : false);
      z && h.value && pt(() => {
        h.value.scrollToRow(z);
      });
    }
    return J;
  }
  function X(k, J) {
  }
  function $(k) {
    var z;
    const J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classify.serialNumber, serialNumber: k.serialNumber, classifyId: k.classify.id, classifyFullName: k.classify.fullName, classifyName: (z = k.classify) == null ? void 0 : z.name, classifyParentFullName: k.classify.parentFullName, basicClass: k.classify.basicClass, specification: k.spec, model: k.spec, specificationMap: k.specKV, measureUnit: k.classify.measureUnit, accountingUnit: k.classify.accountingUnit, accountingPrecision: k.classify.accountingPrecision, measurePrecision: k.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return se(J), J;
  }
  return o({ rowInit: $, rowWatch: se, toggleRowSelection: X, validate: Se, setSelect: ye }), (k, J) => {
    const z = Mt, F = Ve("vxe-column"), G = Ve("vxe-tooltip"), ie = ya, ue = Ve("common-input-number"), ne = jt, te = zo, de = Bo, pe = Ve("common-button"), re = Ve("vxe-table"), we = Ve("common-drawer"), Ke = _t("empty-text"), Me = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Zne, [(w(), U(re, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(oe), "column-config": T.value, data: l(y).steelPlateList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ce, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "Table-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(F, { type: "expand", width: "60" }, { content: p(({ row: Ne }) => [C("div", Jne, [s(z, { modelValue: Ne.remark, "onUpdate:modelValue": (He) => Ne.remark = He, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(Ne.inboundList) ? (w(), Q("div", Xne, [s(l(al), { "basic-class": l(c), list: Ne.inboundList, material: Ne, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(F, { title: "序号", type: "seq", width: "55" }), s(F, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: Ne }) => [s(G, { content: Ne.classifyParentFullName, disabled: !Ne.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Ke, Ne.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(F, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: Ne }) => {
      var He, ze, Oe;
      return [(ze = (He = l(y).selectObj) == null ? void 0 : He[Ne.mergeId]) != null && ze.isSelected && ((Oe = l(g)) == null ? void 0 : Oe.spec) & l(c) && !Ne.boolApplyPurchase ? (w(), U(ie, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Re) => l(x)(Ne) }, null, 8, ["onClick"])) : H("", true), s(G, { content: Ne.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(Ne.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(F, { title: `厚 (${l(r).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: Ne.thickness, "onUpdate:modelValue": (He) => Ne.thickness = He, controls: false, max: 99999999, min: 0, precision: l(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" }, onBlur: (He) => he(He, Ne) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", $ne, K(Ne.thickness), 1))]), _: 1 }, 8, ["title"]), s(F, { title: `宽 (${l(r).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: Ne.width, "onUpdate:modelValue": (He) => Ne.width = He, controls: false, max: 99999999, min: 0, precision: l(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (He) => he(He, Ne) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", ese, K(Ne.width), 1))]), _: 1 }, 8, ["title"]), s(F, { title: `长 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: Ne.length, "onUpdate:modelValue": (He) => Ne.length = He, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (He) => he(He, Ne) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", tse, K(Ne.length), 1))]), _: 1 }, 8, ["title"]), s(F, { title: `数量 （${l(r).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(ue, { key: 0, modelValue: Ne.quantity, "onUpdate:modelValue": (He) => Ne.quantity = He, controls: false, max: 99999999, min: 1, precision: l(r).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" }, onBlur: (He) => he(He, Ne) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", ise, K(Ne.quantity), 1))]), _: 1 }, 8, ["title"]), s(F, { title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(ne, { key: 0, content: `理论重量：${Ne.theoryTotalWeight} ${l(r).weight.unit}， ${l(b)}`, disabled: !Ne.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(ue, { modelValue: Ne.weighingTotalWeight, "onUpdate:modelValue": (He) => Ne.weighingTotalWeight = He, class: Zt({ "over-weight-tip": Ne.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", ase, K(Ne.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(F, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: Ne.brand, "onUpdate:modelValue": (He) => Ne.brand = He, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", lse, K(Ne.brand), 1))]), _: 1 }), s(F, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(z, { key: 0, modelValue: Ne.heatNoAndBatchNo, "onUpdate:modelValue": (He) => Ne.heatNoAndBatchNo = He, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", ose, K(Ne.heatNoAndBatchNo), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).steelPlateList }, null, 8, ["list"])) : (w(), U(F, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: Ne }) => [C("span", null, K(Ne.projectFullName || Ne.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).steelPlateList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(F, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: Ne }) => [C("span", null, K(Ne.workshopName), 1)]), _: 1 }), s(F, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: Ne }) => [C("span", null, K(Ne.warehouseName), 1)]), _: 1 })], 64)), s(F, { align: "center", field: "materialIsWholeName", title: "整料/余料", width: "140" }, { default: p(({ row: Ne }) => [e.isEdit ? (w(), U(de, { key: 0, modelValue: Ne.materialIsWholeName, "onUpdate:modelValue": (He) => Ne.materialIsWholeName = He, placeholder: "请选择", size: "default", style: { width: "100%" } }, { default: p(() => [s(te, { label: "整料", value: "整料" }), s(te, { label: "余料", value: "余料" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", nse, K(Ne.materialIsWholeName), 1))]), _: 1 }), e.isEdit ? (w(), U(F, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: Ne, rowIndex: He }) => [s(pe, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (ze) => Ie(Ne, He) }, null, 8, ["onClick"]), s(pe, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (ze) => Le(Ne.sn, He, Ne) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[Me, S.value]]), s(we, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": J[1] || (J[1] = (Ne) => Gt(O) ? O.value = Ne : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": J[0] || (J[0] = (Ne) => Gt(L) ? L.value = Ne : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, k4 = ut(sse, [["__scopeId", "data-v-b876c019"]]), rse = Object.freeze(Object.defineProperty({ __proto__: null, default: k4 }, Symbol.toStringTag, { value: "Module" }));
const use = { style: { overflow: "hidden" } }, cse = { style: {} }, dse = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, mse = { key: 1 }, pse = { key: 1 }, hse = { key: 1 }, fse = { key: 1 }, gse = { key: 1 }, Ese = { key: 1 }, yse = { key: 1 }, Tse = { __name: "section-steel-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.SECTION_STEEL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => y.sectionSteelList, (J) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var ue;
    let J = 0, z = 0, F = 0, G = 0, ie = 0;
    (ue = y.sectionSteelList) == null || ue.forEach((ne) => {
      J += Number(ne.quantity) || 0, z += Number(ne.mete) || 0, F += Number(ne.amount) || 0, G += Number(ne.amountExcludingVatFreight) || 0, ie += Number(ne.weighingTotalWeight) || 0;
    }), z = z.toFixed(2), ie = ie.toFixed(2), F = F.toFixed(Ze.YUAN), G = G.toFixed(Ze.YUAN), f.value = [{ seq: "合计", quantity: J, mete: z, amountExcludingVatFreight: G, amount: F, weighingTotalWeight: ie }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = (J, z) => !!J, ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], profileLibraryStandard: [{ required: true, message: "请选择型材库标准", trigger: "change" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: M, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: Y, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { validator: Y, message: "数量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }], materialIsWholeName: [{ required: true, message: "请选择整料/余料", trigger: "change" }] }, B = Ee(() => {
    let J = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (J = Object.assign(J, {})), J;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【型材清单】中标红的信息" });
  function oe() {
  }
  function ye(J, z, F) {
    const G = F.find((ie) => ie.name === J);
    z.standardId = G == null ? void 0 : G.standardId, z.unitWeight = G == null ? void 0 : G.unitWeight;
  }
  function ce({ row: J, rowIndex: z }) {
    var F, G;
    if ((G = (F = E == null ? void 0 : E.submitResult) == null ? void 0 : F.data) != null && G.includes(J.classifyId)) return { backgroundColor: "#ffdede" };
  }
  Ht();
  function se(J) {
    const z = J.nationalStandardOptions.find((de) => de.boolDefault === true), F = z == null ? void 0 : z.standardId, G = z == null ? void 0 : z.name, ie = z == null ? void 0 : z.unitWeight, ue = Ct({ uid: Tt(), sn: J.sn, specificationLabels: J.specificationLabels, classifySerialNumber: J.classify.serialNumber, serialNumber: J.serialNumber, classifyId: J.classify.id, classifyFullName: J.classify.fullName, classifyName: J.classify.name, classifyParentFullName: J.classify.parentFullName, basicClass: J.classify.basicClass, specification: J.arr[0], model: J.spec, specificationMap: J.specKV, measureUnit: J.classify.measureUnit, accountingUnit: J.classify.accountingUnit, accountingPrecision: J.classify.accountingPrecision, measurePrecision: J.classify.measurePrecision, material: J.arr[1], standardId: F, brand: J.brand, heatNoAndBatchNo: J.heatNoAndBatchNo, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, nationalStandardOptions: J.nationalStandardOptions, profileLibraryStandard: G, unitWeight: ie });
    let ne;
    const te = [];
    for (const de in ue.specificationMap) de.indexOf("standard") > -1 ? ne = ue.specificationMap[de] : te.push(ue.specificationMap[de]);
    return ue.sectionSteelSpec = ne, ue.doNotSectionSteelSpec = te.join(" * "), !n.boolPartyA && n.fillableAmount && (ue.unitPrice = void 0, ue.amount = void 0), he(ue), ue;
  }
  function he(J) {
    Dt(() => {
      var z, F, G, ie, ue, ne;
      V(J), J.needFirstCalcTheoryWeight && ((n.boolPartyA || n.noDetail || (F = (z = y.selectObj) == null ? void 0 : z[J.mergeId]) != null && F.isSelected && !J.boolApplyPurchase) && (be(J), Le(J)), J.boolApplyPurchase && ((ie = (G = y.selectObj) == null ? void 0 : G[J.mergeId]) != null && ie.isSelected) && (J == null || J.applyPurchase.map((te) => {
        A(te.length) && A(te.quantity) ? te.totalLength = Na({ length: te.length, quantity: te.quantity }) : te.totalLength = void 0;
      }), J.theoryTotalWeight = (ue = J == null ? void 0 : J.applyPurchase) == null ? void 0 : ue.reduce((te, de) => te + (de.theoryTotalWeight || 0), 0), J.totalLength = (ne = J == null ? void 0 : J.applyPurchase) == null ? void 0 : ne.reduce((te, de) => te + (de.totalLength || 0), 0)), J.needFirstCalcTheoryWeight = false);
    }), Ce([() => J.boolApplyPurchase, () => J == null ? void 0 : J.applyPurchase], () => {
      var z, F, G, ie, ue;
      J.boolApplyPurchase && ((F = (z = y.selectObj) == null ? void 0 : z[J.mergeId]) != null && F.isSelected) && (J.quantity = (G = J == null ? void 0 : J.applyPurchase) == null ? void 0 : G.reduce((ne, te) => ne + (te.quantity || 0), 0), J.theoryTotalWeight = (ie = J == null ? void 0 : J.applyPurchase) == null ? void 0 : ie.reduce((ne, te) => ne + (te.theoryTotalWeight || 0), 0), J.weighingTotalWeight = J.theoryTotalWeight, J.totalLength = (ue = J == null ? void 0 : J.applyPurchase) == null ? void 0 : ue.reduce((ne, te) => ne + (te.totalLength || 0), 0));
    }, { deep: true }), Ce(() => J, () => {
      var z, F, G;
      if (!n.boolPartyA && !n.noDetail && ((F = (z = y.selectObj) == null ? void 0 : z[J.mergeId]) != null && F.isSelected)) {
        const ie = (G = y.selectObj[J.mergeId]) == null ? void 0 : G.isSelected;
        y.selectObj[J.mergeId] = { ...y.selectObj[J.mergeId], ...J, mete: J.weighingTotalWeight, isSelected: ie };
      }
    }, { deep: true }), J.boolApplyPurchase || (Ce([() => J.length, () => J.unitWeight, r], () => be(J)), Ce([() => J.theoryWeight, () => J.quantity], () => {
      Le(J);
    })), Ce(() => J.weighingTotalWeight, () => {
      Ie(J);
    }), Ce([() => J.length, () => J.quantity], () => {
      ge(J);
    });
  }
  async function be(J) {
    J.theoryWeight = await xa({ length: J.length, unitWeight: J.unitWeight });
  }
  function me(J, z) {
    Le(z);
  }
  function ge(J) {
    var z, F;
    (n.boolPartyA || n.noDetail || (F = (z = y.selectObj) == null ? void 0 : z[J.mergeId]) != null && F.isSelected && !J.boolApplyPurchase) && (A(J.length) && J.quantity ? J.totalLength = Na({ length: J.length, quantity: J.quantity }) : J.totalLength = void 0);
  }
  function Le(J) {
    A(J.theoryWeight) && J.quantity ? (J.theoryTotalWeight = Be(J.theoryWeight * J.quantity, r.value.weight.precision), J.weighingTotalWeight = Be(J.theoryWeight * J.quantity, r.value.weight.precision)) : (J.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (J.weighingTotalWeight = void 0));
  }
  function Ie(J) {
    A(J.unitPrice) && A(J.weighingTotalWeight) ? J.amount = Be(J.weighingTotalWeight * J.unitPrice, Ze.YUAN) : J.amount = void 0;
  }
  function Se(J, z, F) {
    u.value ? u.value.delListItem(J, z) : y.sectionSteelList.splice(z, 1);
  }
  function X(J, z) {
    var ie;
    const F = JSON.parse(JSON.stringify(J)), G = Ct({ uid: Tt(), sn: F.sn, specificationLabels: F.specificationLabels, classifySerialNumber: F.classifySerialNumber, serialNumber: F.serialNumber, classifyId: F.classifyId, classifyFullName: F.classifyFullName, classifyName: F.classifyName, classifyParentFullName: F.classifyParentFullName, basicClass: F.basicClass, specification: F.specification, model: F.spec, specificationMap: F.specificationMap, measureUnit: F.measureUnit, accountingUnit: F.accountingUnit, accountingPrecision: F.accountingPrecision, measurePrecision: F.measurePrecision, material: F.material, quantity: F.quantity, thickness: F.thickness, length: F.length, width: F.width, theoryWeight: F.theoryWeight, theoryTotalWeight: F.theoryTotalWeight, weighingTotalWeight: F.weighingTotalWeight, rowIndex: y.sectionSteelList.length, weightMeasurementMode: F.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : F.unitPrice, profileLibraryStandard: F.profileLibraryStandard, nationalStandardOptions: F.nationalStandardOptions, standardId: F.standardId, unitWeight: F.unitWeight, brand: F.brand, heatNoAndBatchNo: F.heatNoAndBatchNo, projectSerialNumber: F.projectSerialNumber, projectId: F.projectId, workshopName: F.workshopName, warehouseName: F.warehouseName, workshopId: F.workshopId, warehouseId: F.warehouseId, materialIsWholeName: F.materialIsWholeName });
    y.sectionSteelList.push(G), he(G), (ie = u.value) == null || ie.initSelected([G]);
  }
  function $() {
    const J = At(y.sectionSteelList), { validResult: z } = ae(y.sectionSteelList);
    if (z) j(J), J.forEach((F) => {
    });
    else {
      const F = y.sectionSteelList.find((G) => G.verify ? Object.values(G.verify).some((ie) => ie === false) : false);
      F && h.value && pt(() => {
        h.value.scrollToRow(F);
      });
    }
    return z;
  }
  function k(J, z) {
  }
  return o({ rowInit: se, rowWatch: he, toggleRowSelection: k, validate: $, setSelect: oe }), (J, z) => {
    const F = Mt, G = Ve("vxe-column"), ie = Ve("vxe-tooltip"), ue = ya, ne = Ve("common-select"), te = Ve("common-input-number"), de = jt, pe = zo, re = Bo, we = Ve("common-button"), Ke = Ve("vxe-table"), Me = Ve("common-drawer"), Ne = _t("empty-text"), He = oi;
    return w(), Q("div", null, [qe((w(), Q("div", use, [(w(), U(Ke, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).sectionSteelList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ce, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "Table-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(G, { type: "expand", width: "60" }, { content: p(({ row: ze }) => [C("div", cse, [s(F, { modelValue: ze.remark, "onUpdate:modelValue": (Oe) => ze.remark = Oe, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(ze.inboundList) ? (w(), Q("div", dse, [s(l(al), { "basic-class": l(c), list: ze.inboundList, material: ze, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(G, { title: "序号", type: "seq", width: "55" }), s(G, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: ze }) => [s(ie, { content: ze.classifyParentFullName, disabled: !ze.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[Ne, ze.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(y).id ? H("", true) : (w(), U(G, { key: 0, align: "center", field: "material", "min-width": "100", title: "材质" })), s(G, { align: "center", field: "specification", "min-width": "120", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: ze }) => {
      var Oe, Re, fe;
      return [(Re = (Oe = l(y).selectObj) == null ? void 0 : Oe[ze.mergeId]) != null && Re.isSelected && ((fe = l(g)) == null ? void 0 : fe.spec) & l(c) && !ze.boolApplyPurchase ? (w(), U(ue, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Ue) => l(x)(ze) }, null, 8, ["onClick"])) : H("", true), s(ie, { content: ze.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(ze.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(G, { align: "center", field: "profileLibraryStandard", "min-width": "140", title: "型材库标准" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(ne, { key: 0, modelValue: ze.profileLibraryStandard, "onUpdate:modelValue": (Oe) => ze.profileLibraryStandard = Oe, dataStructure: { key: "standardId", label: "name", value: "name" }, options: ze.nationalStandardOptions || [], placeholder: "请选择标准", style: { width: "100%" }, type: "other", onChange: (Oe) => ye(Oe, ze, ze.nationalStandardOptions) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (w(), Q("span", mse, K(ze.profileLibraryStandard), 1))]), _: 1 }), s(G, { title: `定尺长度 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: ze.length, "onUpdate:modelValue": (Oe) => ze.length = Oe, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" }, onBlur: (Oe) => me(Oe, ze) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", pse, K(ze.length), 1))]), _: 1 }, 8, ["title"]), s(G, { title: `数量 （${l(r).measure.unit})`, align: "center", field: "quantity", "min-width": "120" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(te, { key: 0, modelValue: ze.quantity, "onUpdate:modelValue": (Oe) => ze.quantity = Oe, controls: false, max: 99999999, min: 1, precision: l(r).measure.precision, placeholder: "数量", size: "default", style: { width: "100%" }, onBlur: (Oe) => me(Oe, ze) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", hse, K(ze.quantity), 1))]), _: 1 }, 8, ["title"]), s(G, { title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(de, { key: 0, content: `单位重量：${ze.unitWeight} kg/m， 理论重量：${ze.theoryTotalWeight} ${l(r).weight.unit}， ${l(b)}`, disabled: !ze.hasOver, class: "item", effect: "dark", placement: "top" }, { default: p(() => [s(te, { modelValue: ze.weighingTotalWeight, "onUpdate:modelValue": (Oe) => ze.weighingTotalWeight = Oe, class: Zt({ "over-weight-tip": ze.hasOver }), controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "precision"])]), _: 2 }, 1032, ["content", "disabled"])) : (w(), Q("span", fse, K(ze.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(G, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(F, { key: 0, modelValue: ze.brand, "onUpdate:modelValue": (Oe) => ze.brand = Oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", gse, K(ze.brand), 1))]), _: 1 }), s(G, { align: "center", field: "heatNoAndBatchNo", title: "炉批号", width: "120" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(F, { key: 0, modelValue: ze.heatNoAndBatchNo, "onUpdate:modelValue": (Oe) => ze.heatNoAndBatchNo = Oe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Ese, K(ze.heatNoAndBatchNo), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 1, list: l(y).sectionSteelList }, null, 8, ["list"])) : (w(), U(G, { key: 2, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: ze }) => [C("span", null, K(ze.projectFullName || ze.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 3, "is-begin": true, list: l(y).sectionSteelList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 4 }, [s(G, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: ze }) => [C("span", null, K(ze.workshopName), 1)]), _: 1 }), s(G, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: ze }) => [C("span", null, K(ze.warehouseName), 1)]), _: 1 })], 64)), s(G, { align: "center", field: "materialIsWholeName", title: "整料/余料", width: "140" }, { default: p(({ row: ze }) => [e.isEdit ? (w(), U(re, { key: 0, modelValue: ze.materialIsWholeName, "onUpdate:modelValue": (Oe) => ze.materialIsWholeName = Oe, placeholder: "请选择", size: "default", style: { width: "100%" } }, { default: p(() => [s(pe, { label: "整料", value: "整料" }), s(pe, { label: "余料", value: "余料" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", yse, K(ze.materialIsWholeName), 1))]), _: 1 }), e.isEdit ? (w(), U(G, { key: 5, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: ze, rowIndex: Oe }) => [s(we, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Re) => X(ze, Oe) }, null, 8, ["onClick"]), s(we, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Re) => Se(ze.sn, Oe, ze) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[He, S.value]]), s(Me, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": z[1] || (z[1] = (ze) => Gt(O) ? O.value = ze : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": z[0] || (z[0] = (ze) => Gt(L) ? L.value = ze : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, D4 = ut(Tse, [["__scopeId", "data-v-8379b16a"]]), _se = Object.freeze(Object.defineProperty({ __proto__: null, default: D4 }, Symbol.toStringTag, { value: "Module" }));
const bse = { style: { overflow: "hidden" } }, Vse = { style: {} }, wse = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Sse = { key: 1 }, vse = { key: 1 }, Rse = { key: 1 }, Mse = { key: 1 }, Ase = { key: 1 }, Nse = { key: 1 }, Lse = { key: 1 }, Ise = { __name: "steel-coil-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.STEEL_COIL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", quantity: "-", mete: "-", amountExcludingVatFreight: "-", amount: "-", weighingTotalWeight: "-" }]);
  Ce(() => y.steelCoilList, (X) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var F;
    let X = 0, $ = 0, k = 0, J = 0, z = 0;
    (F = y.steelCoilList) == null || F.forEach((G) => {
      X += Number(G.length) || 0, $ += Number(G.mete) || 0, k += Number(G.amount) || 0, J += Number(G.amountExcludingVatFreight) || 0, z += Number(G.weighingTotalWeight) || 0;
    }), $ = $.toFixed(2), z = z.toFixed(2), k = k.toFixed(Ze.YUAN), J = J.toFixed(Ze.YUAN), f.value = [{ seq: "合计", length: X, mete: $, amountExcludingVatFreight: J, amount: k, weighingTotalWeight: z }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), Y = (X, $) => !!X, ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], thickness: [{ required: true, message: "厚度必填", trigger: "blur" }, { validator: Y, message: "厚度必须大于0", trigger: "blur" }], width: [{ required: true, message: "宽度必填", trigger: "blur" }, { validator: Y, message: "宽度必须大于0", trigger: "blur" }], length: [{ required: true, message: "长度必填", trigger: "blur" }, { validator: Y, message: "长度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: M, message: "超出误差允许范围,不可提交", trigger: "blur" }, { pattern: Vi, message: "重量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = Ee(() => {
    let X = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (X = Object.assign(X, {})), X;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function oe() {
  }
  function ye({ row: X, rowIndex: $ }) {
    var k, J;
    if ((J = (k = E == null ? void 0 : E.submitResult) == null ? void 0 : k.data) != null && J.includes(X.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce(X) {
    const $ = Ct({ uid: Tt(), sn: X.sn, specificationLabels: X.specificationLabels, classifySerialNumber: X.classify.serialNumber, serialNumber: X.serialNumber, classifyId: X.classify.id, classifyFullName: X.classify.fullName, classifyName: X.classify.name, classifyParentFullName: X.classify.parentFullName, basicClass: X.classify.basicClass, specification: X.spec, model: X.spec, specificationMap: X.specKV, measureUnit: X.classify.measureUnit, accountingUnit: X.classify.accountingUnit, accountingPrecision: X.classify.accountingPrecision, measurePrecision: X.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return !n.boolPartyA && n.fillableAmount && ($.unitPrice = void 0, $.amount = void 0), se($), $;
  }
  function se(X) {
    Ce(() => X, () => {
      var $, k, J;
      if (!n.boolPartyA && !n.noDetail && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected)) {
        const z = (J = y.selectObj[X.mergeId]) == null ? void 0 : J.isSelected;
        y.selectObj[X.mergeId] = { ...y.selectObj[X.mergeId], ...X, mete: X.weighingTotalWeight, isSelected: z };
      }
    }, { deep: true }), Ce([() => X.weighingTotalWeight, () => X.width, () => X.thickness, r], () => he(X)), Ce([() => X.theoryLength], () => me(X));
  }
  async function he(X) {
    X.theoryLength = await il({ classifyId: X.classifyId, name: X.classifyFullName, weight: X.weighingTotalWeight, width: X.width, thickness: X.thickness });
  }
  function be(X, $) {
    me($);
  }
  function me(X) {
    A(X.theoryLength) ? X.length = X.theoryLength * 1 : X.length = void 0;
  }
  function ge(X, $, k) {
    u.value ? u.value.delListItem(X, $) : y.steelCoilList.splice($, 1);
  }
  function Le(X, $) {
    var z;
    const k = JSON.parse(JSON.stringify(X)), J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classifySerialNumber, serialNumber: k.serialNumber, classifyId: k.classifyId, classifyFullName: k.classifyFullName, classifyName: k.classifyName, classifyParentFullName: k.classifyParentFullName, basicClass: k.basicClass, specification: k.specification, model: k.spec, specificationMap: k.specificationMap, measureUnit: k.measureUnit, accountingUnit: k.accountingUnit, accountingPrecision: k.accountingPrecision, measurePrecision: k.measurePrecision, quantity: k.quantity, thickness: k.thickness, length: k.length, width: k.width, theoryWeight: k.theoryWeight, theoryTotalWeight: k.theoryTotalWeight, weighingTotalWeight: k.weighingTotalWeight, rowIndex: y.steelCoilList.length, weightMeasurementMode: k.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : k.unitPrice, color: k.color, brand: k.brand, heatNoAndBatchNo: k.heatNoAndBatchNo, projectSerialNumber: k.projectSerialNumber, projectId: k.projectId, workshopName: k.workshopName, warehouseName: k.warehouseName, workshopId: k.workshopId, warehouseId: k.warehouseId });
    y.steelCoilList.push(J), se(J), (z = u.value) == null || z.initSelected([J]);
  }
  function Ie() {
    const X = At(y.steelCoilList), { validResult: $ } = ae(y.steelCoilList);
    if ($) j(X), X.forEach((k) => {
    });
    else {
      const k = y.steelCoilList.find((J) => J.verify ? Object.values(J.verify).some((z) => z === false) : false);
      k && h.value && pt(() => {
        h.value.scrollToRow(k);
      });
    }
    return $;
  }
  function Se(X, $) {
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Se, validate: Ie, setSelect: oe }), (X, $) => {
    const k = Mt, J = Ve("vxe-column"), z = Ve("vxe-tooltip"), F = ya, G = Ve("common-input-number"), ie = Ve("common-button"), ue = Ve("vxe-table"), ne = Ve("common-drawer"), te = _t("empty-text"), de = oi;
    return w(), Q("div", null, [qe((w(), Q("div", bse, [(w(), U(ue, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).steelCoilList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "Table-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(J, { type: "expand", width: "60" }, { content: p(({ row: pe }) => [C("div", Vse, [s(k, { modelValue: pe.remark, "onUpdate:modelValue": (re) => pe.remark = re, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(pe.inboundList) ? (w(), Q("div", wse, [s(l(al), { "basic-class": l(c), list: pe.inboundList, material: pe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(J, { title: "序号", type: "seq", width: "55" }), s(J, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: pe }) => [s(z, { content: pe.classifyParentFullName, disabled: !pe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[te, pe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(J, { align: "center", field: "material", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: pe }) => {
      var re, we, Ke;
      return [(we = (re = l(y).selectObj) == null ? void 0 : re[pe.mergeId]) != null && we.isSelected && ((Ke = l(g)) == null ? void 0 : Ke.spec) & l(c) && !pe.boolApplyPurchase ? (w(), U(F, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Me) => l(x)(pe) }, null, 8, ["onClick"])) : H("", true), s(z, { content: pe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(pe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(J, { title: `厚 (${l(r).thickness.unit})`, align: "center", field: "thickness", "min-width": "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.thickness, "onUpdate:modelValue": (re) => pe.thickness = re, controls: false, max: 99999999, min: 0, precision: l(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default", style: { width: "100%" }, onBlur: (re) => be(re, pe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", Sse, K(pe.thickness), 1))]), _: 1 }, 8, ["title"]), s(J, { title: `宽 (${l(r).width.unit})`, align: "center", field: "width", "min-width": "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.width, "onUpdate:modelValue": (re) => pe.width = re, controls: false, max: 99999999, min: 0, precision: l(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default", style: { width: "100%" }, onBlur: (re) => be(re, pe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", vse, K(pe.width), 1))]), _: 1 }, 8, ["title"]), s(J, { title: `总重 (${l(r).weight.unit})`, align: "center", field: "weighingTotalWeight", "min-width": "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.weighingTotalWeight, "onUpdate:modelValue": (re) => pe.weighingTotalWeight = re, controls: false, max: 999999999, min: 0, precision: l(r).weight.precision, placeholder: "总重", size: "default", style: { width: "100%" }, onBlur: (re) => be(re, pe) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])) : (w(), Q("span", Rse, K(pe.weighingTotalWeight), 1))]), _: 1 }, 8, ["title"]), s(J, { title: `长度 (${l(r).length.unit})`, align: "center", field: "length", "min-width": "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.length, "onUpdate:modelValue": (re) => pe.length = re, controls: false, max: 99999999, min: 0, precision: l(r).length.precision, placeholder: "长", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Mse, K(pe.length), 1))]), _: 1 }, 8, ["title"]), s(J, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.color, "onUpdate:modelValue": (re) => pe.color = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Ase, K(pe.color), 1))]), _: 1 }), s(J, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.brand, "onUpdate:modelValue": (re) => pe.brand = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Nse, K(pe.brand), 1))]), _: 1 }), s(J, { align: "center", field: "heatNoAndBatchNo", title: "卷号", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.heatNoAndBatchNo, "onUpdate:modelValue": (re) => pe.heatNoAndBatchNo = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "炉批号", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Lse, K(pe.heatNoAndBatchNo), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).steelCoilList }, null, 8, ["list"])) : (w(), U(J, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: pe }) => [C("span", null, K(pe.projectFullName || pe.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).steelCoilList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(J, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.workshopName), 1)]), _: 1 }), s(J, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(J, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: pe, rowIndex: re }) => [s(ie, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (we) => Le(pe, re) }, null, 8, ["onClick"]), s(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (we) => ge(pe.sn, re, pe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[de, S.value]]), s(ne, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": $[1] || ($[1] = (pe) => Gt(O) ? O.value = pe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": $[0] || ($[0] = (pe) => Gt(L) ? L.value = pe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, x4 = ut(Ise, [["__scopeId", "data-v-8b15bd0a"]]), Cse = Object.freeze(Object.defineProperty({ __proto__: null, default: x4 }, Symbol.toStringTag, { value: "Module" }));
const Pse = { style: { overflow: "hidden" } }, Ose = { style: {} }, kse = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Dse = { key: 1 }, xse = { key: 1 }, Use = { key: 1 }, Yse = { key: 1 }, Kse = { __name: "other-steel-begin-material-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Pe.OTHER.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => y.otherSteelMaterialList, (Se) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var $;
    let Se = 0, X = 0;
    ($ = y.otherSteelMaterialList) == null || $.forEach((k) => {
      Se += Number(k.amount) || 0, X += Number(k.amountExcludingVatFreight) || 0;
    }), Se = Se.toFixed(Ze.YUAN), X = X.toFixed(Ze.YUAN), f.value = [{ seq: "合计", amountExcludingVatFreight: X, amount: Se }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (Se, X) => !!Se, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: (Se, X) => A(X.measureUnit) ? !!X.quantity : true }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = Ee(() => {
    let Se = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (Se = Object.assign(Se, {})), Se;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【其他钢材清单】中标红的信息" });
  function oe() {
  }
  function ye({ row: Se, rowIndex: X }) {
    var $, k;
    if ((k = ($ = E == null ? void 0 : E.submitResult) == null ? void 0 : $.data) != null && k.includes(Se.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce(Se) {
    const X = Ct({ uid: Tt(), sn: Se.sn, specificationLabels: Se.specificationLabels, classifySerialNumber: Se.classify.serialNumber, serialNumber: Se.serialNumber, classifyId: Se.classify.id, classifyFullName: Se.classify.fullName, classifyName: Se.classify.name, classifyParentFullName: Se.classify.parentFullName, basicClass: Se.classify.basicClass, specification: Se.spec, model: Se.spec, specificationMap: Se.specKV, measureUnit: Se.classify.measureUnit, accountingUnit: Se.classify.accountingUnit, accountingPrecision: Se.classify.accountingPrecision, measurePrecision: Se.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, workshopId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, warehouseId: y.otherSteelMaterialList.length > 0 ? -1 : void 0, rowIndex: y.otherSteelMaterialList.length, mete: void 0 });
    return !n.boolPartyA && n.fillableAmount && (X.unitPrice = void 0, X.amount = void 0), se(X), X;
  }
  function se(Se) {
    Dt(() => {
      var X, $, k, J;
      Se.needFirstCalcTheoryWeight && (Se.boolApplyPurchase || he(Se), Se.boolApplyPurchase && (($ = (X = y.selectObj) == null ? void 0 : X[Se.mergeId]) != null && $.isSelected) && (Se.quantity = (k = Se == null ? void 0 : Se.applyPurchase) == null ? void 0 : k.reduce((z, F) => z + (F.quantity || 0), 0), Se.theoryTotalWeight = (J = Se == null ? void 0 : Se.applyPurchase) == null ? void 0 : J.reduce((z, F) => z + (F.theoryTotalWeight || 0), 0)), Se.needFirstCalcTheoryWeight = false), V(Se);
    }), Ce([() => Se.boolApplyPurchase, () => Se == null ? void 0 : Se.applyPurchase], () => {
      var X, $, k, J;
      Se.boolApplyPurchase && (($ = (X = y.selectObj) == null ? void 0 : X[Se.mergeId]) != null && $.isSelected ? (Se.quantity = (k = Se == null ? void 0 : Se.applyPurchase) == null ? void 0 : k.reduce((z, F) => z + (F.quantity || 0), 0), Se.theoryTotalWeight = (J = Se == null ? void 0 : Se.applyPurchase) == null ? void 0 : J.reduce((z, F) => z + (F.theoryTotalWeight || 0), 0), Se.weighingTotalWeight = Se.theoryTotalWeight) : (Se.quantity = 0, Se.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => Se, () => {
      var X, $, k;
      if (!n.boolPartyA && !n.noDetail && (($ = (X = y.selectObj) == null ? void 0 : X[Se.mergeId]) != null && $.isSelected)) {
        const J = (k = y.selectObj[Se.mergeId]) == null ? void 0 : k.isSelected;
        y.selectObj[Se.mergeId] = { ...y.selectObj[Se.mergeId], ...Se, mete: Se.weighingTotalWeight, isSelected: J };
      }
    }, { deep: true }), Se.boolApplyPurchase || Ce([() => Se.length, () => Se.width, () => Se.thickness, r], () => {
      console.log("触发理论重量计算:", { length: Se.length, width: Se.width, thickness: Se.thickness, name: Se.classifyFullName }), he(Se);
    }), Ce(() => Se.weighingTotalWeight, () => {
      be(Se);
    });
  }
  async function he(Se) {
    debugger;
    if (!Se.length || !Se.width || !Se.thickness || !Se.classifyFullName) {
      console.warn("缺少计算理论重量所需的参数:", { length: Se.length, width: Se.width, thickness: Se.thickness, name: Se.classifyFullName });
      return;
    }
    Se.theoryWeight = await na({ classifyId: Se.classifyId, name: Se.classifyFullName, length: Se.length, width: Se.width, thickness: Se.thickness });
  }
  function be(Se) {
    A(Se.unitPrice) && A(Se.weighingTotalWeight) ? Se.amount = Be(Se.weighingTotalWeight * Se.unitPrice, Ze.YUAN) : Se.amount = void 0;
  }
  function me(Se, X, $) {
    u.value ? u.value.delListItem(Se, X) : y.otherSteelMaterialList.splice(X, 1);
  }
  function ge(Se, X) {
    var J;
    const $ = JSON.parse(JSON.stringify(Se)), k = Ct({ uid: Tt(), sn: $.sn, specificationLabels: $.specificationLabels, classifySerialNumber: $.classifySerialNumber, serialNumber: $.serialNumber, classifyId: $.classifyId, classifyFullName: $.classifyFullName, classifyName: $.classifyName, classifyParentFullName: $.classifyParentFullName, basicClass: $.basicClass, specification: $.specification, model: $.spec, specificationMap: $.specificationMap, measureUnit: $.measureUnit, accountingUnit: $.accountingUnit, accountingPrecision: $.accountingPrecision, measurePrecision: $.measurePrecision, quantity: $.quantity, thickness: $.thickness, length: $.length, width: $.width, theoryWeight: $.theoryWeight, theoryTotalWeight: $.theoryTotalWeight, weighingTotalWeight: $.weighingTotalWeight, rowIndex: y.otherSteelMaterialList.length, weightMeasurementMode: $.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : $.unitPrice, mete: $.mete, color: $.color, brand: $.brand, projectSerialNumber: $.projectSerialNumber, projectId: $.projectId, workshopName: $.workshopName, warehouseName: $.warehouseName, workshopId: $.workshopId, warehouseId: $.warehouseId });
    y.otherSteelMaterialList.push(k), se(k), (J = u.value) == null || J.initSelected([k]);
  }
  function Le() {
    const Se = y.otherSteelMaterialList, { validResult: X } = ae(Se);
    if (X) j(Se), Se.forEach(($) => {
    });
    else {
      const $ = y.otherSteelMaterialList.find((k) => k.verify ? Object.values(k.verify).some((J) => J === false) : false);
      $ && h.value && pt(() => {
        h.value.scrollToRow($);
      });
    }
    return X;
  }
  function Ie(Se, X) {
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Ie, validate: Le, setSelect: oe }), (Se, X) => {
    const $ = Mt, k = Ve("vxe-column"), J = Ve("vxe-tooltip"), z = ya, F = Ve("common-input-number"), G = Ve("common-button"), ie = Ve("vxe-table"), ue = Ve("common-drawer"), ne = _t("empty-text"), te = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Pse, [(w(), U(ie, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).otherSteelMaterialList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "Table-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(k, { type: "expand", width: "60" }, { content: p(({ row: de }) => [C("div", Ose, [s($, { modelValue: de.remark, "onUpdate:modelValue": (pe) => de.remark = pe, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(de.inboundList) ? (w(), Q("div", kse, [s(l(al), { "basic-class": l(c), list: de.inboundList, material: de, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(k, { title: "序号", type: "seq", width: "55" }), s(k, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: de }) => [s(J, { content: de.classifyParentFullName, disabled: !de.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[ne, de.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(k, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: de }) => {
      var pe, re, we;
      return [(re = (pe = l(y).selectObj) == null ? void 0 : pe[de.mergeId]) != null && re.isSelected && ((we = l(g)) == null ? void 0 : we.spec) & l(c) && !de.boolApplyPurchase ? (w(), U(z, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Ke) => l(x)(de) }, null, 8, ["onClick"])) : H("", true), s(J, { content: de.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(de.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(k, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: de }) => [C("span", null, K(de.measureUnit || "-"), 1)]), _: 1 }), s(k, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: de }) => [e.isEdit && l(A)(de.measureUnit) ? (w(), U(F, { key: 0, modelValue: de.quantity, "onUpdate:modelValue": (pe) => de.quantity = pe, controls: false, max: 999999999, min: 0, precision: de.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Dse, K(de.quantity), 1))]), _: 1 }), s(k, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: de }) => [C("span", null, K(de.accountingUnit || "-"), 1)]), _: 1 }), s(k, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: de }) => [e.isEdit ? (w(), U(F, { key: 0, modelValue: de.mete, "onUpdate:modelValue": (pe) => de.mete = pe, controls: false, max: 999999999, min: 1e-6, precision: de.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", xse, K(de.mete), 1))]), _: 1 }), s(k, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: de }) => [e.isEdit ? (w(), U($, { key: 0, modelValue: de.color, "onUpdate:modelValue": (pe) => de.color = pe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Use, K(de.color), 1))]), _: 1 }), s(k, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: de }) => [e.isEdit ? (w(), U($, { key: 0, modelValue: de.brand, "onUpdate:modelValue": (pe) => de.brand = pe, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Yse, K(de.brand), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).otherSteelMaterialList }, null, 8, ["list"])) : (w(), U(k, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: de }) => [C("span", null, K(de.projectFullName || de.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).otherSteelMaterialList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(k, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: de }) => [C("span", null, K(de.workshopName), 1)]), _: 1 }), s(k, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: de }) => [C("span", null, K(de.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(k, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: de, rowIndex: pe }) => [s(G, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (re) => ge(de, pe) }, null, 8, ["onClick"]), s(G, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (re) => me(de.sn, pe, de) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[te, S.value]]), s(ue, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": X[1] || (X[1] = (de) => Gt(O) ? O.value = de : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": X[0] || (X[0] = (de) => Gt(L) ? L.value = de : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, U4 = ut(Kse, [["__scopeId", "data-v-bebae7a3"]]), Wse = Object.freeze(Object.defineProperty({ __proto__: null, default: U4 }, Symbol.toStringTag, { value: "Module" })), Ru = { __name: "begin-confirm", props: { visible: { type: Boolean, default: false }, basicClass: { type: Number }, viewList: { type: Array }, className: { type: String }, submit: { type: Function }, title: { type: String } }, emits: ["update:visible", "closed", "success"], setup(e, { expose: o, emit: n }) {
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
} }, jse = Object.freeze(Object.defineProperty({ __proto__: null, default: Ru }, Symbol.toStringTag, { value: "Module" }));
const Fse = { class: "steel-inbound-application-container" }, zse = { class: "filter-container" }, Bse = { class: "filter-left-box" }, Hse = { class: "filter-right-box" }, qse = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  const n = Ht(), c = o, { inboundFillWayCfg: u } = aa(), r = e, E = { steelPlateList: { K: "steelPlateList", L: "钢板", V: Pe.STEEL_PLATE.V, TABLE: I4, BEGINTABLE: k4 }, sectionSteelList: { K: "sectionSteelList", L: "型材", V: Pe.SECTION_STEEL.V, TABLE: C4, BEGINTABLE: D4 }, steelCoilList: { K: "steelCoilList", L: "钢卷", V: Pe.STEEL_COIL.V, TABLE: P4, BEGINTABLE: x4 }, otherSteelMaterialList: { K: "otherSteelMaterialList", L: "其它钢材", V: Pe.OTHER_STEEL_MATERIALS.V, TABLE: O4, BEGINTABLE: U4 } }, y = { inboundWay: si.ORDINARY_STORAGE.V, supplyType: Ni.PARTY_A.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], steelPlateList: [], sectionSteelList: [], steelCoilList: [], otherSteelMaterialList: [] }, b = Z(), V = Z(), M = Z(), g = Z(), S = Z(), h = Z(false), T = Z({}), _ = Z(false), f = Z(), m = Z([]), R = Z(true), v = Z(false), N = Ct({ steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }), { baseUnit: P } = ai(), L = Ee(() => u.value ? !!(u.value.amountFillWay === $l.APPLICATION.V && v.value) : false), O = Ee(() => f.value ? { basicClass: E[f.value].V } : {}), x = Ee(() => !!(f.value && S.value)), I = Ee(() => {
    var Me;
    return (Me = se.list) == null ? void 0 : Me.filter((Ne) => {
      var He, ze;
      return (ze = (He = ce == null ? void 0 : ce.submitResult) == null ? void 0 : He.data) == null ? void 0 : ze.includes(Ne.classifyId);
    });
  });
  function Y(Me) {
    var Ne, He, ze;
    return R.value || v ? ((Ne = se[Me]) == null ? void 0 : Ne.length) || 0 : ((ze = (He = se[Me]) == null ? void 0 : He.filter((Oe) => {
      var Re;
      return (Re = se.selectObj[Oe.mergeId]) == null ? void 0 : Re.isSelected;
    })) == null ? void 0 : ze.length) || 0;
  }
  const ee = Ee(() => {
    const Me = [];
    return A(se.steelPlateList) && se.steelPlateList.forEach((Ne) => {
      var He, ze;
      (R.value || !R.value && Ae((He = S.value) == null ? void 0 : He.details) || (ze = se.selectObj[Ne.mergeId]) != null && ze.isSelected) && Me.push(Ne);
    }), A(se.sectionSteelList) && se.sectionSteelList.forEach((Ne) => {
      var He, ze;
      (R.value || !R.value && Ae((He = S.value) == null ? void 0 : He.details) || (ze = se.selectObj[Ne.mergeId]) != null && ze.isSelected) && Me.push(Ne);
    }), A(se.steelCoilList) && se.steelCoilList.forEach((Ne) => {
      var He, ze;
      if (R.value || !R.value && Ae((He = S.value) == null ? void 0 : He.details) || (ze = se.selectObj[Ne.mergeId]) != null && ze.isSelected) {
        const Oe = { ...Ne };
        Oe.quantity = Oe.length, Me.push(Oe);
      }
    }), A(se.otherSteelMaterialList) && se.otherSteelMaterialList.forEach((Ne) => {
      var He, ze;
      if (R.value || !R.value && Ae((He = S.value) == null ? void 0 : He.details) || (ze = se.selectObj[Ne.mergeId]) != null && ze.isSelected) {
        const Oe = { ...Ne };
        Oe.weighingTotalWeight = Oe.mete, Me.push(Oe);
      }
    }), Me;
  }), B = Ee(() => {
    let Me = 0;
    return !R.value && L.value && ee.value.forEach((Ne) => {
      A(Ne.amount) && (Me += +Ne.amount);
    }), ji(Me, Ze.YUAN);
  }), q = Ee(() => {
    let Me = 0;
    return ee.value.forEach((Ne) => {
      A(Ne.weighingTotalWeight) && (Me += +Ne.weighingTotalWeight);
    }), ji(Me, ei.weight.precision);
  });
  yi("matSpecRef", V);
  const ae = Z(false), j = Ee(() => !r.edit && !ae.value), le = () => {
    ae.value = true, ye(se);
  };
  function oe() {
    ae.value = false, ue();
  }
  const ye = (Me) => {
    const Ne = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, He = { steelPlateList: null, sectionSteelList: null, steelCoilList: null, otherSteelMaterialList: null }, ze = ["steelPlateList", "sectionSteelList", "steelCoilList", "otherSteelMaterialList"];
    let Oe = false;
    ze.forEach((Re) => {
      if (A(Me[Re])) {
        if (!Oe) {
          Oe = true;
          const fe = Ce(h, (Ue) => {
            Ue && pt(() => {
              f.value = Re, fe();
            });
          }, { immediate: true });
        }
        Me[Re] = Me[Re].map((fe) => Ct(fe)), Ne[Re] = Ce(N, (fe) => {
          fe[Re] && (Me[Re].forEach((Ue) => {
            var Je, Xe;
            fe[Re].rowWatch(Ue), !R.value && !v.value && ((Xe = (Je = Me.selectObj) == null ? void 0 : Je[Ue.mergeId]) != null && Xe.isSelected) && fe[Re].toggleRowSelection(Ue, true);
          }), He[Re] = Ce(V, () => {
            V.value && (V.value.initSelected(Me[Re].map((Ue) => ({ sn: Ue.sn, classifyId: Ue.classifyId }))), pt(() => {
              He[Re]();
            }));
          }, { immediate: true }), pt(() => {
            Ne[Re]();
          }));
        }, { immediate: true, deep: true });
      }
    }), ge();
  }, { cu: ce, form: se, FORM: he } = Pa({ title: "钢材入库", formStore: !r.edit, formStoreKey: "WMS_INBOUND_APPLICATION_STEEL_PARTYA", permission: sb, useDraftCallback: le, defaultForm: y, clearDraftCallback: oe, api: r.edit ? mu : Hle }, M, r.detail), { maxHeight: be } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => g.value.loaded);
  let me = {};
  r.edit ? me = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 360, extraHeight: 20 } : me = { mainBox: ".steel-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 360, extraHeight: 20 };
  const { fixMaxHeight: ge, maxHeight: Le, maxHeightStyle: Ie } = Kt(me), Se = Ee(() => f.value ? te.value ? E[f.value].BEGINTABLE : E[f.value].TABLE : r.edit ? null : E.steelPlateList.TABLE), X = Ee(() => {
    const Me = S.value && S.value.weightMeasurementMode === Wt.OVERWEIGHT.V, Ne = !T.value.steelPlateList || !T.value.sectionSteelList;
    return Me && Ne;
  });
  Ce(f, (Me) => {
    Me ? (m.value = se[Me], pt(() => {
      var Ne;
      N[Me] || (N[Me] = b.value), (Ne = b.value) == null || Ne.setSelect();
    })) : m.value = [];
  }, { immediate: true, deep: true }), Ce(m, (Me) => {
    f.value && (se[f.value] = Me);
  }), Ce(() => q.value, (Me) => {
    ce.props.totalWeight = Me;
  }), ue();
  const { steelDensityCfg: $ } = cn();
  he.HOOK.beforeToEdit = async (Me, Ne) => {
    var He, ze;
    if (r.edit) {
      if (Ne.purchaseId = (He = Ne.purchaseOrder) == null ? void 0 : He.id, Ne.logistics || (Ne.logistics = {}), await Xr(Ne), Ne.basicClass & ct.STEEL.V && A(Ne.list)) {
        const Oe = [];
        let Re = [];
        const fe = [];
        if ((ze = Ne.list) == null || ze.forEach((Ue) => {
          (Ue.basicClass === Pe.STEEL_PLATE.V || Ue.basicClass === Pe.STEEL_COIL.V) && Ue.steelDensity !== $.value[Ue.classifyId] && (Oe.push({ classifyName: Ue.classifyName, classifyId: Ue.classifyId }), Ue.steelDensity = $.value[Ue.classifyId]);
        }), Re = k(Oe, "classifyId"), A(Re)) {
          Re.forEach((Je) => {
            fe.push(`当前【${Je.classifyName}】物料密度有变，最新密度为【${$.value[Je.classifyId]}】`);
          });
          const Ue = fe.join(`，
`);
          Ne.densityData = Re.map((Je) => Je.classifyId), (!te.value || Ne.basicClass === Pe.STEEL_PLATE.V) && zi.confirm(`${Ue}，
是否重新计算总重？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消" }).then(() => {
            Ne.densityData = Re.map((Je) => Je.classifyId), pt(() => {
              Ne.steelPlateList.forEach((Je) => {
                Ne.densityData.includes(Je.classifyId) && (Je.weighingTotalWeight = Je.theoryTotalWeight);
              }), Ne.steelCoilList.forEach((Je) => {
                Ne.densityData.includes(Je.classifyId) && (Je.length = Je.theoryLength);
              });
            });
          }).catch(() => {
            Ne.densityData = [];
          });
        }
      }
      ye(Ne);
    }
  };
  function k(Me, Ne) {
    return Me.filter((He, ze, Oe) => ze === Oe.findIndex((Re) => Ne ? Re[Ne] === He[Ne] : JSON.stringify(Re) === JSON.stringify(He)));
  }
  he.HOOK.afterSubmit = async () => {
    r.edit && c("success"), ue();
  };
  function J() {
    var Ne;
    if ((R.value || !R.value && Ae((Ne = S.value) == null ? void 0 : Ne.details)) && Ae(se.steelPlateList) && Ae(se.sectionSteelList) && Ae(se.steelCoilList) && Ae(se.otherSteelMaterialList)) return ot.warning("请填写数据"), false;
    if (!R.value && A(S.value.details) && Ae(ee.value)) return ot.warning("请选择数据"), false;
    if (te.value) return;
    const Me = z();
    if (Me) {
      const He = [];
      ee.value.forEach((ze) => {
        var Oe;
        if ((Oe = ze.applyPurchase) != null && Oe.length) {
          let Re = ze.weighingTotalWeight;
          ze.applyPurchase.forEach((fe, Ue) => {
            var Je, Xe;
            if (fe.quantity) {
              let Ye = 0;
              Ue !== ze.applyPurchase.length - 1 && Re !== 0 ? (Ye = ji(fe.theoryTotalWeight / ze.theoryTotalWeight * ze.weighingTotalWeight, P.value[ze.basicClass].weight.precision, { toNum: true }), Re -= Ye) : Ye += Re, He.push({ ...ze, ...fe, quantity: fe.quantity, projectId: (Je = fe.project) == null ? void 0 : Je.id, uid: Tt(), mete: Ye, weight: Ye, amount: ze.unitPrice ? Be(Ye * ze.unitPrice, Ze.YUAN) : void 0, applyPurchaseId: fe.applyPurchaseId, purchaseDetailId: fe.purchaseDetailId, purchaseProjectDisabled: fe.applyPurchaseId ? !((Xe = fe.project) != null && Xe.id) : false });
            }
          });
        } else He.push({ ...ze, uid: Tt(), mete: ze.weighingTotalWeight, weight: ze.weighingTotalWeight });
      }), se.list = He;
    }
    return A(I.value) ? (ot.error("请先删除标红数据并重新添加"), false) : Me;
  }
  function z() {
    return Object.keys(N).every((Me) => N[Me] ? N[Me].validate() : true);
  }
  function F(Me) {
    return b.value.rowInit(Me);
  }
  function G() {
    if (!se.loadingWeight) {
      ot.warning("请先输入过磅重量");
      return;
    }
    let Me = [], Ne = [], He = 0;
    if (A(se.steelPlateList) && (Me = se.steelPlateList.filter((fe) => (He += fe.theoryTotalWeight ? fe.theoryTotalWeight : 0, fe.theoryTotalWeight))), A(se.sectionSteelList) && (Ne = se.sectionSteelList.filter((fe) => (He += fe.theoryTotalWeight ? fe.theoryTotalWeight : 0, fe.theoryTotalWeight))), Ae(Me) && Ae(Ne)) {
      ot.warning("您未填写完整钢板或型材的信息, 或它们的理论重量过小");
      return;
    }
    let ze = 0;
    A(se.steelCoilList) && se.steelCoilList.forEach((fe) => {
      ze += fe.weighingTotalWeight ? fe.weighingTotalWeight : 0;
    }), A(se.otherSteelMaterialList) && se.otherSteelMaterialList.forEach((fe) => {
      ze += fe.mete ? fe.mete : 0;
    });
    let Oe = se.loadingWeight - ze - He;
    const Re = (fe) => {
      fe.weighingTotalWeight = Oe ? ji(fe.theoryTotalWeight / He * Oe + fe.theoryTotalWeight, P.value[fe.basicClass].weight.precision, { toNum: true }) : fe.theoryTotalWeight, Oe -= fe.weighingTotalWeight - fe.theoryTotalWeight, He -= fe.theoryTotalWeight;
    };
    Me.forEach((fe) => Re(fe)), Ne.forEach((fe) => Re(fe)), ot.warning("已自动分配车次/船次过磅重量");
  }
  async function ie(Me) {
    var Ne;
    ue(), S.value = Me, ce.props.order = Me, R.value = true, v.value = Ae(Me == null ? void 0 : Me.details), se.supplyType = Ni.PARTY_A.V, j.value && (se.list = []), Object.keys(E).forEach((He) => {
      if (j.value && (se[He] = []), E[He].V & (Me == null ? void 0 : Me.basicClass) ? T.value[He] = false : se[He] = [], j.value) {
        const ze = Ce(V, () => {
          V.value && (V.value.clearByBasicClass(E[He].V), pt(() => {
            ze();
          }));
        }, { immediate: true });
      }
    }), Me ? (pt(() => {
      N[f.value] = b.value, R.value && j.value && ye(se);
    }), !R.value && ((Ne = Me == null ? void 0 : Me.details) != null && Ne.length) && (se.list = Me.details || [], await Xr(se), ye(se))) : pt(() => {
      N.steelPlateList = null, N.sectionSteelList = null, N.steelCoilList = null, N.otherSteelMaterialList = null;
    }), h.value = true;
  }
  async function ue() {
    T.value = { steelPlateList: true, sectionSteelList: true, steelCoilList: true, otherSteelMaterialList: true }, f.value = void 0, h.value = false, R.value = true, await n.dispatch("wms/fetchSteelDensityCfg");
  }
  function ne() {
    if (A(I.value) && A(ce.submitResult.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    _.value = true;
  }
  ce.props.import = (Me) => {
    var Re;
    const Ne = f.value, He = se[Ne].length;
    Me.map((fe, Ue) => {
      fe.projectId = fe.projectId || (Ue > 0 || He > 0 ? -1 : void 0), fe.workshopId = fe.workshopId || (Ue > 0 || He > 0 ? -1 : void 0), fe.warehouseId = fe.warehouseId || (Ue > 0 || He > 0 ? -1 : void 0);
    }), se[Ne].push.apply(se[Ne], Me);
    const ze = se[Ne].length;
    for (let fe = He; fe < ze; fe++) L.value || (se[Ne][fe].amount = void 0, se[Ne][fe].unitPrice = void 0), A((Re = se[Ne][fe]) == null ? void 0 : Re.amount) && (se[Ne][fe].amount = Be(se[Ne][fe].amount, Ze.YUAN)), N[Ne].rowWatch(se[Ne][fe]);
    const Oe = Ce(V, () => {
      V.value && (V.value.initSelected(Me.map((fe) => ({ sn: fe.sn, classifyId: fe.classifyId }))), pt(() => {
        Oe();
      }));
    }, { immediate: true });
  };
  const te = Ee(() => (se == null ? void 0 : se.inboundWay) === si.OPENING_RECEIPT.V);
  Ce(() => se.inboundWay, (Me) => {
    se.steelPlateList = [], se.sectionSteelList = [], se.steelCoilList = [], se.otherSteelMaterialList = [], m.value = [], f.value = "steelPlateList", pt(() => {
      N.steelPlateList = b.value, N.sectionSteelList = null, N.steelCoilList = null, N.otherSteelMaterialList = null;
    });
  });
  function de() {
    var Ne;
    return !!((Ne = b.value) == null ? void 0 : Ne.validate());
  }
  const pe = Z();
  function re() {
    pe.value.handleClose();
  }
  async function we() {
    try {
      const Me = At(se[f.value]);
      if (Ae(Me)) return;
      Me.forEach((Ne) => {
        Ne.materialIsWholeName && (Ne.materialIsWhole = Ne.materialIsWholeName === "余料" ? 2 : 1), Ne.id && Ne.weighingTotalWeight ? Ne.mete = Ne.weighingTotalWeight : Ne.mete = Ne.mete || Ne.weighingTotalWeight, f.value === "sectionSteelList" && (Ne.weight = Ne.mete, Ne.specification = Ne.sectionSteelSpec + " * " + Ne.doNotSectionSteelSpec), f.value === "steelCoilList" && (Ne.quantity = Ne.length);
      }), await Ut(Me, { toSmallest: true, toNum: true }), se.list = Me, await qle(se), ce.submitSuccessNotify(), ce.resetForm(), re();
    } catch (Me) {
      throw console.error("期初入库提交失败:", Me), new Error(Me);
    }
  }
  function Ke() {
    c("beginClose");
  }
  return (Me, Ne) => {
    var Je, Xe, Ye, Fe;
    const He = Is, ze = Ve("common-button"), Oe = jt, Re = Li, fe = Ve("common-drawer"), Ue = _t("permission");
    return qe((w(), Q("div", Fse, [s(vu, { "basic-class": l(sl), "begin-permission": l(kd), "begin-validate": de, "contract-unit": (Je = S.value) == null ? void 0 : Je.meteUnit, "contract-value": (Xe = S.value) == null ? void 0 : Xe.mete, "current-basic-class": (Ye = E[f.value]) == null ? void 0 : Ye.V, edit: r.edit, "inbound-unit": l(ei).weight.unit, "inbound-value": (Fe = S.value) == null ? void 0 : Fe.inboundTotalMete, order: S.value, "show-total-amount": te.value ? false : !R.value && L.value, showContractTotal: !R.value && !!l(se).purchaseId, showInboundTotal: !R.value && !!l(se).purchaseId, "total-amount": B.value, "total-name": R.value ? "总量合计" : "本次实收", "total-value": q.value, validate: J, unit: "t", onPurchaseOrderChange: ie }, { beginPreview: p((et) => {
      var lt;
      return [s(Ru, { ref_key: "beginConfirmRef", ref: pe, "class-name": (lt = E[f.value]) == null ? void 0 : lt.L, submit: we, visible: et.visible, onSuccess: Ke, "onUpdate:visible": (bt) => et.onUpdateVisible(bt) }, { default: p(() => [(w(), U(Ri(Se.value), { ref_key: "steelRef", ref: b, "bool-party-a": R.value, fillableAmount: L.value, isEdit: false, "max-height": l(Le) + 120, noDetail: v.value, order: S.value, style: ri(l(Ie)) }, null, 8, ["bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"]))]), _: 2 }, 1032, ["class-name", "visible", "onUpdate:visible"])];
    }), default: p(() => {
      var et, lt;
      return [C("div", zse, [C("div", Bse, [s(l(Ls), { modelValue: f.value, "onUpdate:modelValue": Ne[0] || (Ne[0] = (bt) => f.value = bt), class: "filter-item", size: "default" }, { default: p(() => [(w(), Q(Qe, null, ki(E, (bt) => s(He, { key: bt.K, disabled: !!r.edit, label: bt.K }, { default: p(() => [Te(K(bt.L) + K(Y(bt.K) ? `(${Y(bt.K)})` : ""), 1)]), _: 2 }, 1032, ["disabled", "label"])), 64))]), _: 1 }, 8, ["modelValue"])]), C("div", Hse, [te.value && l(Ai)(l(kd).download) && f.value ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: E[f.value].V, boolPartyA: true }, class: "filter-item" }, { default: p(() => [Te(K(E[f.value].L) + "期初入库模版下载 ", 1)]), _: 1 }, 8, ["fn", "params"])) : H("", true), !te.value && (R.value || !R.value && l(Ae)((et = S.value) == null ? void 0 : et.details)) ? (w(), U(ia, { key: 1, disabled: !f.value, fn: l(bd), params: O.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(f.value ? E[f.value].L : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), X.value ? (w(), U(ze, { key: 2, disabled: !f.value, class: "filter-item", type: "warning", onClick: G }, { default: p(() => Ne[2] || (Ne[2] = [Te(" 按过磅重量自动分配（钢卷不参与分配) ")])), _: 1, __: [2] }, 8, ["disabled"])) : H("", true), te.value && !r.edit ? (w(), Q(Qe, { key: 3 }, [l(Ai)((lt = l(kd)) == null ? void 0 : lt.import) ? (w(), U(ze, { key: 0, class: "filter-item", type: "success", onClick: ne }, { default: p(() => Ne[3] || (Ne[3] = [Te(" 添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : H("", true), te.value ? H("", true) : (w(), U(Oe, { key: 4, disabled: x.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => {
        var bt;
        return [C("span", null, [R.value || !R.value && l(Ae)((bt = S.value) == null ? void 0 : bt.details) ? (w(), U(ze, { key: 0, disabled: !x.value, class: "filter-item", type: "success", onClick: ne }, { default: p(() => Ne[4] || (Ne[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])) : H("", true)])];
      }), _: 1 }, 8, ["disabled"]))])]), s(Re, { ref_key: "formRef", ref: M, model: l(se) }, { default: p(() => [(w(), U(Ri(Se.value), { ref_key: "steelRef", ref: b, "bool-party-a": R.value, fillableAmount: L.value, "max-height": l(Le), noDetail: v.value, style: ri(l(Ie)) }, null, 8, ["bool-party-a", "fillableAmount", "max-height", "noDetail", "style"]))]), _: 1 }, 8, ["model"])];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "contract-unit", "contract-value", "current-basic-class", "edit", "inbound-unit", "inbound-value", "order", "show-total-amount", "showContractTotal", "showInboundTotal", "total-amount", "total-name", "total-value"]), s(fe, { ref_key: "drawerRef", ref: g, modelValue: _.value, "onUpdate:modelValue": Ne[1] || (Ne[1] = (et) => _.value = et), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [te.value || x.value ? (w(), U(to, { key: l(se).inboundWay, ref_key: "matSpecRef", ref: V, "basic-class": E[f.value].V, "max-height": l(be), "model-value": l(se)[f.value], "row-init-fn": F, "table-width": 350, visible: _.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "max-height", "model-value", "visible"])) : H("", true)]), _: 1 }, 8, ["modelValue"])])), [[Ue, l(sb)]]);
  };
} }, Nm = ut(qse, [["__scopeId", "data-v-4eab088c"]]), Gse = Object.freeze(Object.defineProperty({ __proto__: null, default: Nm }, Symbol.toStringTag, { value: "Module" }));
const Qse = { __name: "inbound-info-table", props: { hasBorder: { type: Boolean, default: false }, material: { type: Object, default: () => ({}) }, basicClass: { type: Number }, list: { type: Array, default: () => [] } }, emits: ["del"], setup(e, { emit: o }) {
  const n = e, c = Z([...ld, ["inboundTime", ["parse-time", "{y}-{m}-{d}"]]]);
  function u(r) {
    const E = n.material.measurePrecision || 0, y = n.material.accountingPrecision || 2;
    return Hi(r, { props: [["quantity", E], ["mete", y]] });
  }
  return (r, E) => {
    const y = vt, b = Ve("common-table");
    return w(), U(b, { data: e.list, "data-format": c.value, "show-summary": false, "summary-method": u, "row-key": "id", style: { width: "100%" }, class: Zt({ "table-border-none": !e.hasBorder }) }, { default: p(() => [s(fa, { "basic-class": e.basicClass }, { afterIndex: p(() => [s(y, { prop: "inboundTime", "show-overflow-tooltip": "", align: "center", width: "100", label: "入库时间" }), s(y, { prop: "applyPurchaseSN", "show-overflow-tooltip": "", align: "center", "min-width": "120", label: "申购单" })]), _: 1 }, 8, ["basic-class"]), s(za, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(Ba, { "basic-class": e.basicClass }, null, 8, ["basic-class"]), s(y, { prop: "remark", "show-overflow-tooltip": "", align: "left", "min-width": "120", label: "备注" })]), _: 1 }, 8, ["data", "data-format", "class"]);
  };
} }, Y4 = ut(Qse, [["__scopeId", "data-v-4e12ec60"]]), Zse = Object.freeze(Object.defineProperty({ __proto__: null, default: Y4 }, Symbol.toStringTag, { value: "Module" }));
const Jse = { style: {} }, Xse = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, $se = { __name: "aux-mat-table", props: { boolPartyA: { type: Boolean, default: false }, boolApplyPurchase: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, basicClass: { type: [String, Number], default: Ge.MATERIAL.V }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, showColor: { type: Boolean, default: true }, maxHeight: { type: [String, Number], default: 360 } }, setup(e, { expose: o }) {
  const n = e;
  Z();
  const c = ft("matSpecRef"), { cu: u, form: r } = Wi(), E = Z(false), y = Z({ resizable: true }), b = Z({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), g = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (q, ae) => (ae.measureUnit && A(ae.measurePrecision) && A(ae.quantity) && (ae.quantity = Be(ae.quantity, ae.measurePrecision)), ae.measureUnit && A(ae.measurePrecision) ? !!ae.quantity : true), message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (q, ae) => (ae.accountingUnit && A(ae.accountingPrecision) && A(ae.mete) && (ae.mete = Be(ae.mete, ae.accountingPrecision)), !!ae.mete), message: "核算量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, h = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (q, ae) => A(ae.mete) && A(ae.unitPrice) ? +Be(ae.mete * ae.unitPrice, Ze.YUAN) == +q : false, message: "金额有误，请手动修改", trigger: "blur" }] }, T = Ee(() => {
    let q = Object.assign({}, g);
    return !n.boolPartyA && n.fillableAmount && (q = Object.assign(q, h)), q;
  }), _ = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: f, cleanUpData: m, wrongCellMask: R } = ui({ rules: T, ditto: _ });
  function v(q = false) {
  }
  function N({ row: q, rowIndex: ae }) {
    var j, le;
    if ((le = (j = u == null ? void 0 : u.submitResult) == null ? void 0 : j.data) != null && le.includes(q.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function P(q) {
    var j, le, oe;
    console.log(q, r.auxMatList, "form.auxMatList1111");
    const ae = Ct({ uid: Tt(), sn: q.sn, specificationLabels: q.specificationLabels, serialNumber: q.serialNumber, classifyId: q.classify.id, classifySerialNumber: q.classify.serialNumber, classifyFullPathId: q.classify.fullPathId, classifyFullName: q.classify.fullName, classifyName: q.classify.name, classifyParentFullName: q.classify.parentFullName, basicClass: q.classify.basicClass, specification: q.spec, specificationMap: q.specKV, measureUnit: q.classify.measureUnit, accountingUnit: q.classify.accountingUnit, accountingPrecision: q.classify.accountingPrecision, measurePrecision: q.classify.measurePrecision, outboundUnitType: q.classify.outboundUnitType, unitNet: q.unitNet, accountingUnitNet: q.accountingUnitNet, mete: void 0, quantity: void 0, projectId: ((j = r.auxMatList) == null ? void 0 : j.length) > 0 ? -1 : void 0, workshopId: ((le = r.auxMatList) == null ? void 0 : le.length) > 0 ? -1 : void 0, warehouseId: ((oe = r.auxMatList) == null ? void 0 : oe.length) > 0 ? -1 : void 0 });
    return !n.boolPartyA && n.fillableAmount && (ae.unitPrice = void 0, ae.amount = void 0), ae;
  }
  function L(q) {
    Ce(() => q.mete, () => {
      O(q.mete, q);
    });
  }
  function O(q, ae, j) {
    A(ae.unitPrice) && A(q) && (ae.amount = Be(q * ae.unitPrice, Ze.YUAN)), Y(ae, j || ae);
  }
  function x(q, ae, j) {
    var le, oe, ye, ce;
    if ((oe = (le = u == null ? void 0 : u.submitResult) == null ? void 0 : le.data) != null && oe.includes(j.classifyId)) {
      const se = (ye = u == null ? void 0 : u.submitResult) == null ? void 0 : ye.data.findIndex((be) => be === j.classifyId);
      r.auxMatList.filter((be) => be.classifyId === j.classifyId).length === 1 && ((ce = u == null ? void 0 : u.submitResult) == null || ce.data.splice(se, 1));
    }
    if (c.value ? c.value.delListItem(q, ae) : r.auxMatList.splice(ae, 1), A(r.auxMatList) && r.auxMatList.length > 0) {
      const se = r.auxMatList[0];
      r.auxMatList[0].projectId = se.projectId && se.projectId !== -1 ? se.projectId : void 0, r.auxMatList[0].workshopId = se.workshopId && se.workshopId !== -1 ? se.workshopId : void 0, r.auxMatList[0].warehouseId = se.warehouseId && se.warehouseId !== -1 ? se.warehouseId : void 0;
    }
  }
  function I(q, ae) {
    const j = JSON.parse(JSON.stringify(q)), le = Ct({ uid: Tt(), sn: q.sn, specificationLabels: j.specificationLabels, classifySerialNumber: j.classifySerialNumber, serialNumber: j.serialNumber, classifyId: j.classifyId, classifyFullPathId: j.classifyFullPathId, classifyFullName: j.classifyFullName, classifyName: j.classifyName, classifyParentFullName: j.classifyParentFullName, basicClass: j.basicClass, specification: j.specification, model: j.model, specificationMap: j.specificationMap, measureUnit: j.measureUnit, accountingUnit: j.accountingUnit, accountingPrecision: j.accountingPrecision, measurePrecision: j.measurePrecision, outboundUnitType: j.outboundUnitType, unitNet: j.unitNet, accountingUnitNet: j.accountingUnitNet, mete: j.mete, quantity: j.quantity, projectId: j.projectId, workshopId: j.workshopId, warehouseId: j.warehouseId, color: j.color, rowIndex: r.auxMatList.length, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : j.unitPrice, amount: n.boolPartyA || !n.fillableAmount ? void 0 : j.amount });
    r.auxMatList.push(le), L(le), c.value.initSelected([le]);
  }
  function Y(q, { accountingUnitNet: ae, measurePrecision: j }) {
    !n.boolPartyA && q.measureUnit && ae && (q.quantity = Be(q.mete * ae, j));
  }
  function ee() {
    if (Ae(r.auxMatList)) return true;
    const q = r.auxMatList.filter((j, le) => (j.dataIndex = le, true)), { validResult: ae } = f(q);
    return ae && (m(q), q.forEach((j) => {
      var le, oe;
      r.auxMatList[j.dataIndex].projectId = j.projectId, r.auxMatList[j.dataIndex].workshopId = j.workshopId || ((le = j.workshop) == null ? void 0 : le.id), r.auxMatList[j.dataIndex].warehouseId = j.warehouseId || ((oe = j.warehouse) == null ? void 0 : oe.id), r.auxMatList[j.dataIndex].quantity = j.measureUnit && A(j.measurePrecision) ? j.quantity : void 0;
    })), ae;
  }
  function B(q, ae) {
  }
  return o({ rowInit: P, toggleRowSelection: B, setSelect: v, rowWatch: L, validate: ee }), (q, ae) => {
    const j = Mt, le = Ve("vxe-column"), oe = Ve("vxe-tooltip"), ye = Ve("common-input-number"), ce = Ve("common-button"), se = Ve("vxe-table"), he = _t("empty-text"), be = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(se, { key: `inbound_${e.basicClass}`, "cell-class-name": l(R), "column-config": y.value, data: l(r).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": N, "scroll-y": b.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(le, { type: "expand", width: "60" }, { content: p(({ row: me }) => [C("div", Jse, [s(j, { modelValue: me.remark, "onUpdate:modelValue": (ge) => me.remark = ge, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(me.inboundList) ? (w(), Q("div", Xse, [s(l(Y4), { "basic-class": e.basicClass, list: me.inboundList, material: me, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(le, { title: "序号", type: "seq", width: "55" }), s(le, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: me }) => [s(oe, { content: me.classifyParentFullName, disabled: !me.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[he, me.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(le, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: me }) => [s(oe, { content: me.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(me.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(le, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: me }) => [C("span", null, K(me.measureUnit || "-"), 1)]), _: 1 }), s(le, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: me }) => [l(A)(me.measureUnit) ? (w(), U(ye, { key: 0, modelValue: me.quantity, "onUpdate:modelValue": (ge) => me.quantity = ge, controls: false, max: 999999999, min: 0, precision: me.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : H("", true)]), _: 1 }), s(le, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: me }) => [C("span", null, K(me.accountingUnit || "-"), 1)]), _: 1 }), s(le, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: me }) => [s(ye, { modelValue: me.mete, "onUpdate:modelValue": (ge) => me.mete = ge, controls: false, max: 999999999, min: 1e-6, precision: me.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), e.showColor ? (w(), U(le, { key: 0, align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: me }) => [s(j, { modelValue: me.color, "onUpdate:modelValue": (ge) => me.color = ge, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : H("", true), s(le, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: me }) => [s(j, { modelValue: me.brand, "onUpdate:modelValue": (ge) => me.brand = ge, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(Kn, { list: l(r).auxMatList, order: e.order }, null, 8, ["list", "order"]), s(Wn, { list: l(r).auxMatList, showWarehouse: "" }, null, 8, ["list"]), s(le, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: me, rowIndex: ge }) => [s(ce, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (Le) => I(me, ge) }, null, 8, ["onClick"]), s(ce, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (Le) => x(me.sn, ge, me) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[be, E.value]])]);
  };
} }, wd = ut($se, [["__scopeId", "data-v-7e15cf61"]]), ere = Object.freeze(Object.defineProperty({ __proto__: null, default: wd }, Symbol.toStringTag, { value: "Module" }));
const tre = { style: { overflow: "hidden" } }, ire = { style: {} }, are = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, lre = { key: 1 }, ore = { key: 1 }, nre = { key: 1 }, sre = { key: 1 }, rre = { __name: "aux-mat-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.MATERIAL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => y.auxMatList, (X) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var k;
    let X = 0, $ = 0;
    (k = y.auxMatList) == null || k.forEach((J) => {
      X += Number(J.amount) || 0, $ += Number(J.amountExcludingVatFreight) || 0;
    }), X = X.toFixed(Ze.YUAN), $ = $.toFixed(Ze.YUAN), f.value = [{ seq: "合计", amountExcludingVatFreight: $, amount: X }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (X, $) => A($.measureUnit) ? !!$.quantity : true }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (X, $) => !!X, message: "核算量必须大于0", trigger: "blur" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = Ee(() => {
    let X = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (X = Object.assign(X, {})), X;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【辅材清单】中标红的信息" });
  function oe() {
  }
  function ye({ row: X, rowIndex: $ }) {
    var k, J;
    if ((J = (k = E == null ? void 0 : E.submitResult) == null ? void 0 : k.data) != null && J.includes(X.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce(X) {
    const $ = Ct({ uid: Tt(), sn: X.sn, specificationLabels: X.specificationLabels, classifySerialNumber: X.classify.serialNumber, serialNumber: X.serialNumber, classifyId: X.classify.id, classifyFullName: X.classify.fullName, classifyName: X.classify.name, classifyParentFullName: X.classify.parentFullName, basicClass: X.classify.basicClass, specification: X.spec, model: X.spec, specificationMap: X.specKV, measureUnit: X.classify.measureUnit, accountingUnit: X.classify.accountingUnit, accountingPrecision: X.classify.accountingPrecision, measurePrecision: X.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return !n.boolPartyA && n.fillableAmount && ($.unitPrice = void 0, $.amount = void 0), $;
  }
  function se(X) {
    Dt(() => {
      var $, k, J, z;
      X.needFirstCalcTheoryWeight && (X.boolApplyPurchase || (he(X), be(X)), X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected) && (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0)), X.needFirstCalcTheoryWeight = false), V(X);
    }), Ce([() => X.boolApplyPurchase, () => X == null ? void 0 : X.applyPurchase], () => {
      var $, k, J, z;
      X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected ? (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0), X.weighingTotalWeight = X.theoryTotalWeight) : (X.quantity = 0, X.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => X, () => {
      var $, k, J;
      if (!n.boolPartyA && !n.noDetail && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected)) {
        const z = (J = y.selectObj[X.mergeId]) == null ? void 0 : J.isSelected;
        y.selectObj[X.mergeId] = { ...y.selectObj[X.mergeId], ...X, mete: X.weighingTotalWeight, isSelected: z };
      }
    }, { deep: true }), X.boolApplyPurchase || (Ce([() => X.length, () => X.width, () => X.thickness, r], () => he(X)), Ce([() => X.theoryWeight, () => X.quantity], () => be(X))), Ce(() => X.weighingTotalWeight, () => {
      me(X);
    });
  }
  async function he(X) {
    X.theoryWeight = await na({ classifyId: X.classifyId, name: X.classifyFullName, length: X.length, width: X.width, thickness: X.thickness });
  }
  function be(X) {
    A(X.theoryWeight) && X.quantity ? (X.theoryTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision))) : (X.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = void 0));
  }
  function me(X) {
    A(X.unitPrice) && A(X.weighingTotalWeight) ? X.amount = Be(X.weighingTotalWeight * X.unitPrice, Ze.YUAN) : X.amount = void 0;
  }
  function ge(X, $, k) {
    u.value ? u.value.delListItem(X, $) : y.auxMatList.splice($, 1);
  }
  function Le(X, $) {
    var z;
    const k = JSON.parse(JSON.stringify(X)), J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classifySerialNumber, serialNumber: k.serialNumber, classifyId: k.classifyId, classifyFullName: k.classifyFullName, classifyName: k.classifyName, classifyParentFullName: k.classifyParentFullName, basicClass: k.basicClass, specification: k.specification, model: k.spec, specificationMap: k.specificationMap, measureUnit: k.measureUnit, accountingUnit: k.accountingUnit, accountingPrecision: k.accountingPrecision, measurePrecision: k.measurePrecision, quantity: k.quantity, thickness: k.thickness, length: k.length, width: k.width, theoryWeight: k.theoryWeight, theoryTotalWeight: k.theoryTotalWeight, weighingTotalWeight: k.weighingTotalWeight, rowIndex: y.auxMatList.length, weightMeasurementMode: k.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : k.unitPrice, mete: k.mete, color: k.color, brand: k.brand, projectSerialNumber: k.projectSerialNumber, projectId: k.projectId, workshopName: k.workshopName, warehouseName: k.warehouseName, workshopId: k.workshopId, warehouseId: k.warehouseId });
    y.auxMatList.push(J), se(J), (z = u.value) == null || z.initSelected([J]);
  }
  function Ie() {
    const X = At(y.auxMatList), { validResult: $ } = ae(y.auxMatList);
    if ($) j(X), X.forEach((k) => {
    });
    else {
      const k = y.auxMatList.find((J) => J.verify ? Object.values(J.verify).some((z) => z === false) : false);
      k && h.value && pt(() => {
        h.value.scrollToRow(k);
      });
    }
    return $;
  }
  function Se(X, $) {
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Se, validate: Ie, setSelect: oe }), (X, $) => {
    const k = Mt, J = Ve("vxe-column"), z = Ve("vxe-tooltip"), F = ya, G = Ve("common-input-number"), ie = Ve("common-button"), ue = Ve("vxe-table"), ne = Ve("common-drawer"), te = _t("empty-text"), de = oi;
    return w(), Q("div", null, [qe((w(), Q("div", tre, [(w(), U(ue, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(J, { type: "expand", width: "60" }, { content: p(({ row: pe }) => [C("div", ire, [s(k, { modelValue: pe.remark, "onUpdate:modelValue": (re) => pe.remark = re, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(pe.inboundList) ? (w(), Q("div", are, [s(l(al), { "basic-class": l(c), list: pe.inboundList, material: pe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(J, { title: "序号", type: "seq", width: "55" }), s(J, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: pe }) => [s(z, { content: pe.classifyParentFullName, disabled: !pe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[te, pe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(J, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: pe }) => {
      var re, we, Ke;
      return [(we = (re = l(y).selectObj) == null ? void 0 : re[pe.mergeId]) != null && we.isSelected && ((Ke = l(g)) == null ? void 0 : Ke.spec) & l(c) && !pe.boolApplyPurchase ? (w(), U(F, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Me) => l(x)(pe) }, null, 8, ["onClick"])) : H("", true), s(z, { content: pe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(pe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(J, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.measureUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: pe }) => [e.isEdit && l(A)(pe.measureUnit) ? (w(), U(G, { key: 0, modelValue: pe.quantity, "onUpdate:modelValue": (re) => pe.quantity = re, controls: false, max: 999999999, min: 0, precision: pe.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", lre, K(pe.quantity), 1))]), _: 1 }), s(J, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.accountingUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.mete, "onUpdate:modelValue": (re) => pe.mete = re, controls: false, max: 999999999, min: 1e-6, precision: pe.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", ore, K(pe.mete), 1))]), _: 1 }), s(J, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.color, "onUpdate:modelValue": (re) => pe.color = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", nre, K(pe.color), 1))]), _: 1 }), s(J, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.brand, "onUpdate:modelValue": (re) => pe.brand = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", sre, K(pe.brand), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), U(J, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: pe }) => [C("span", null, K(pe.projectFullName || pe.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(J, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.workshopName), 1)]), _: 1 }), s(J, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(J, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: pe, rowIndex: re }) => [s(ie, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (we) => Le(pe, re) }, null, 8, ["onClick"]), s(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (we) => ge(pe.sn, re, pe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[de, S.value]]), s(ne, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": $[1] || ($[1] = (pe) => Gt(O) ? O.value = pe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": $[0] || ($[0] = (pe) => Gt(L) ? L.value = pe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Lm = ut(rre, [["__scopeId", "data-v-fcd5e181"]]), ure = Object.freeze(Object.defineProperty({ __proto__: null, default: Lm }, Symbol.toStringTag, { value: "Module" }));
const cre = { class: "aux-mat-inbound-application-container" }, dre = { class: "filter-container" }, mre = { class: "filter-right-box" }, pre = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  Ht();
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, supplyType: Ni.PARTY_A.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] }, r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(true), S = Z(false), h = Z(false), T = Ge.MATERIAL.V, { inboundFillWayCfg: _ } = aa(), f = Ee(() => ({ basicClass: T })), m = Ee(() => _.value ? _.value.amountFillWay === $l.APPLICATION.V : false), R = Ee(() => {
    var $, k;
    return !!((k = ($ = V.value) == null ? void 0 : $.applyPurchase) != null && k.length);
  }), v = Ee(() => !!(T && V.value)), N = Ee(() => {
    let $ = 0;
    return g.value || A(B.auxMatList) && B.auxMatList.forEach((k) => {
      A(k.amount) && ($ += +k.amount);
    }), ji($, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const P = Z(false), L = Ee(() => !c.edit && !P.value), O = () => {
    P.value = true, Y(B);
  }, x = Ee(() => {
    var $;
    return ($ = B.list) == null ? void 0 : $.filter((k) => {
      var J, z;
      return (z = (J = ee == null ? void 0 : ee.submitResult) == null ? void 0 : J.data) == null ? void 0 : z.includes(k.classifyId);
    });
  });
  function I() {
    P.value = false, he();
  }
  const Y = ($) => {
    var J;
    $.auxMatList = (J = $.auxMatList) == null ? void 0 : J.map((z) => Ct(z));
    const k = Ce(r, (z) => {
      if (z) {
        pt(() => {
          var G;
          (G = r.value) == null || G.setSelect();
        }), g.value || $.auxMatList.forEach((G) => {
          var ie, ue;
          r.value.rowWatch(G), !g.value && !S.value && ((ue = (ie = $.selectObj) == null ? void 0 : ie[G.mergeId]) != null && ue.isSelected) && r.value.toggleRowSelection(G, true);
        });
        const F = Ce(E, () => {
          E.value && (Array.isArray($.auxMatList) && E.value.initSelected($.auxMatList.map((G) => ({ sn: G.sn, classifyId: G.classifyId }))), pt(() => {
            L.value && (L.value = false), F();
          }));
        }, { immediate: true });
        pt(() => {
          k();
        });
      }
    }, { immediate: true, deep: true });
    le();
  }, { cu: ee, form: B, FORM: q } = Pa({ title: "辅材入库", formStore: !c.edit, formStoreKey: "WMS_INBOUND_APPLICATION_AUX_MAT_PARTYA", permission: rb, useDraftCallback: O, defaultForm: u, clearDraftCallback: I, api: c.edit ? mu : Gle }, y, c.detail), { maxHeight: ae } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded);
  let j = {};
  c.edit ? j = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 360, extraHeight: 20 } : j = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 360, extraHeight: 20 };
  const { fixMaxHeight: le, maxHeight: oe } = Kt(j, r);
  he(), q.HOOK.beforeToEdit = async ($, k) => {
    var J, z;
    if (c.edit && (k.purchaseId = (J = k.purchaseOrder) == null ? void 0 : J.id, k.logistics || (k.logistics = {}), g.value || S.value)) {
      const F = JSON.parse(k.jsonData);
      (z = k.list) != null && z.length || (k.list = F.list), k.auxMatList = k.list, Y(k);
    }
  }, q.HOOK.afterSubmit = () => {
    c.edit && n("success"), he();
  };
  function ye() {
    if (ge.value) return;
    const $ = r.value ? r.value.validate() : true;
    if ($) {
      const k = [];
      B.auxMatList.forEach((J) => {
        var z, F;
        (z = J.applyPurchase) != null && z.length ? J.applyPurchase.forEach((G) => {
          var ie, ue;
          (G.quantity || G.mete) && k.push({ ...J, quantity: G.quantity, projectId: (ie = G.project) == null ? void 0 : ie.id, uid: Tt(), mete: G.mete, applyPurchaseId: G.applyPurchaseId, purchaseDetailId: G.purchaseDetailId, purchaseProjectDisabled: G.applyPurchaseId ? !((ue = G.project) != null && ue.id) : false });
        }) : (g.value || S.value || (F = B.selectObj[J.mergeId]) != null && F.isSelected) && k.push(J);
      }), B.list = k;
    }
    return A(x.value) ? (ot.error("请先删除标红数据并重新添加"), false) : $;
  }
  function ce($) {
    return $.model = $.spec, r.value.rowInit($);
  }
  async function se($) {
    var k;
    if (he(), V.value = $, ee.props.order = $, g.value = true, S.value = Ae($ == null ? void 0 : $.details), B.supplyType = Ni.PARTY_A.V, L.value && (B.auxMatList = []), L.value) {
      const J = Ce(E, () => {
        E.value && (E.value.clearByBasicClass(T), pt(() => {
          J();
        }));
      }, { immediate: true });
    }
    g.value && L.value && Y(B), (k = $ == null ? void 0 : $.details) != null && k.length && (B.auxMatList = $.details.map((J) => (J.uid = Tt(), J)), Y(B)), M.value = true;
  }
  function he() {
    M.value = false, g.value = true;
  }
  function be() {
    var $;
    if (A(x.value) && A(($ = ee == null ? void 0 : ee.submitResult) == null ? void 0 : $.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    h.value = true;
  }
  ee.props.import = ($) => {
    if (B.inboundWay === si.OPENING_RECEIPT.V) return B.auxMatList.push.apply(B.auxMatList, $);
    m.value || $.forEach((z) => {
      z.amount = void 0, z.unitPrice = void 0;
    });
    const k = B.auxMatList.length;
    $.map((z, F) => {
      z.projectId = z.projectId || (F > 0 || k > 0 ? -1 : void 0), z.workshopId = z.workshopId || (F > 0 || k > 0 ? -1 : void 0), z.warehouseId = z.warehouseId || (F > 0 || k > 0 ? -1 : void 0);
    }), B.auxMatList.push.apply(B.auxMatList, $);
    const J = Ce(E, () => {
      E.value && (E.value.initSelected($.map((z) => ({ sn: z.sn, classifyId: z.classifyId }))), pt(() => {
        J();
      }));
    }, { immediate: true });
  };
  const me = Z(), ge = Ee(() => (B == null ? void 0 : B.inboundWay) === si.OPENING_RECEIPT.V);
  function Le() {
    me.value.handleClose();
  }
  function Ie() {
    return !!r.value.validate();
  }
  Ce(() => B.inboundWay, ($) => {
    B != null && B.id || (B.auxMatList = [], B.list = []);
  });
  async function Se() {
    try {
      const $ = At(B.auxMatList);
      if (Ae($)) return;
      await Ut($, { toSmallest: true, toNum: true }), B.list = $, await Qle(B), ee.submitSuccessNotify(), ee.resetForm(), Le();
    } catch ($) {
      throw console.error("辅助材料期初入库提交失败:", $), new Error($);
    }
  }
  function X() {
    n("beginClose");
  }
  return ($, k) => {
    const J = Ve("common-button"), z = jt, F = Li, G = Ve("common-drawer"), ie = _t("permission");
    return qe((w(), Q("div", cre, [s(vu, { "basic-class": l(T), "begin-permission": l(Dd), "begin-validate": Ie, edit: c.edit, "show-total": false, "show-total-amount": !g.value && m.value, "total-amount": N.value, validate: ye, onPurchaseOrderChange: se }, { beginPreview: p((ue) => [s(Ru, { ref_key: "beginConfirmRef", ref: me, onSuccess: X, submit: Se, visible: ue.visible, title: "辅材", "onUpdate:visible": (ne) => ue.onUpdateVisible(ne) }, { default: p(() => [s(Lm, { "is-edit": false, "max-height": l(oe) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var ue, ne;
      return [C("div", dre, [C("div", mre, [l(B).inboundWay === l(si).OPENING_RECEIPT.V && l(Ai)(l(Dd).download) && l(T) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).MATERIAL.V, boolPartyA: g.value }, class: "filter-item" }, { default: p(() => k[1] || (k[1] = [Te("辅材期初入库模版下载 ")])), _: 1, __: [1] }, 8, ["fn", "params"])) : H("", true), l(B).inboundWay === l(si).ORDINARY_STORAGE.V && (g.value || !g.value && l(Ae)((ue = V.value) == null ? void 0 : ue.details)) ? (w(), U(ia, { key: 1, disabled: !l(T), fn: l(bd), params: f.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(T) ? l(Ge).VL[l(T)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), ge.value ? (w(), Q(Qe, { key: 2 }, [l(Ai)((ne = l(Dd)) == null ? void 0 : ne.import) ? (w(), U(J, { key: 0, class: "filter-item", type: "success", onClick: be }, { default: p(() => k[2] || (k[2] = [Te("添加物料 ")])), _: 1, __: [2] })) : H("", true)], 64)) : (w(), U(z, { key: 3, disabled: v.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => {
        var te;
        return [C("span", null, [g.value || !g.value && l(Ae)((te = V.value) == null ? void 0 : te.details) ? (w(), U(J, { key: 0, disabled: !v.value, class: "filter-item", type: "success", onClick: be }, { default: p(() => k[3] || (k[3] = [Te(" 添加物料 ")])), _: 1, __: [3] }, 8, ["disabled"])) : H("", true)])];
      }), _: 1 }, 8, ["disabled"]))])]), l(B).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(F, { key: 0, ref_key: "formRef", ref: y, model: l(B) }, { default: p(() => [s(wd, { ref_key: "tableRef", ref: r, "bool-apply-purchase": R.value, "bool-party-a": g.value, fillableAmount: m.value, "max-height": l(oe), noDetail: S.value, order: V.value, style: ri($.maxHeightStyle) }, null, 8, ["bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"])]), _: 1 }, 8, ["model"])) : (w(), U(Lm, { key: 1, ref_key: "tableRef", ref: r, "max-height": l(oe) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "show-total-amount", "total-amount"]), s(G, { ref_key: "drawerRef", ref: b, modelValue: h.value, "onUpdate:modelValue": k[0] || (k[0] = (ue) => h.value = ue), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var ue;
      return [ge.value || v.value ? (w(), U(to, { key: l(B).inboundWay, ref_key: "matSpecRef", ref: E, "basic-class": l(T), "classify-ids": (ue = V.value) == null ? void 0 : ue.auxMaterialIds, "max-height": l(ae), "model-value": l(B).auxMatList, "row-init-fn": ce, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "classify-ids", "max-height", "model-value", "visible"])) : H("", true)];
    }), _: 1 }, 8, ["modelValue"])])), [[ie, l(rb)]]);
  };
} }, K4 = ut(pre, [["__scopeId", "data-v-06a70913"]]), hre = Object.freeze(Object.defineProperty({ __proto__: null, default: K4 }, Symbol.toStringTag, { value: "Module" }));
const fre = { style: {} }, gre = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Ere = { key: 1 }, yre = { key: 1 }, Tre = { key: 1 }, _re = { key: 1 }, bre = { __name: "office-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Pe.MATERIAL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => y.auxMatList, (X) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var k;
    let X = 0, $ = 0;
    (k = y.auxMatList) == null || k.forEach((J) => {
      X += Number(J.amount) || 0, $ += Number(J.amountExcludingVatFreight) || 0;
    }), X = X.toFixed(Ze.YUAN), $ = $.toFixed(Ze.YUAN), f.value = [{ seq: "合计", amountExcludingVatFreight: $, amount: X }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (X, $) => !!X, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: (X, $) => A($.measureUnit) ? !!$.quantity : true }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = Ee(() => {
    let X = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (X = Object.assign(X, {})), X;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【办公用品清单】中标红的信息" });
  function oe() {
  }
  function ye({ row: X, rowIndex: $ }) {
    var k, J;
    if ((J = (k = E == null ? void 0 : E.submitResult) == null ? void 0 : k.data) != null && J.includes(X.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce(X) {
    const $ = Ct({ uid: Tt(), sn: X.sn, specificationLabels: X.specificationLabels, classifySerialNumber: X.classify.serialNumber, serialNumber: X.serialNumber, classifyId: X.classify.id, classifyFullName: X.classify.fullName, classifyName: X.classify.name, classifyParentFullName: X.classify.parentFullName, basicClass: X.classify.basicClass, specification: X.spec, model: X.spec, specificationMap: X.specKV, measureUnit: X.classify.measureUnit, accountingUnit: X.classify.accountingUnit, accountingPrecision: X.classify.accountingPrecision, measurePrecision: X.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return !n.boolPartyA && n.fillableAmount && ($.unitPrice = void 0, $.amount = void 0), se($), $;
  }
  function se(X) {
    Dt(() => {
      var $, k, J, z;
      X.needFirstCalcTheoryWeight && (X.boolApplyPurchase || (he(X), be(X)), X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected) && (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0)), X.needFirstCalcTheoryWeight = false), V(X);
    }), Ce([() => X.boolApplyPurchase, () => X == null ? void 0 : X.applyPurchase], () => {
      var $, k, J, z;
      X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected ? (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0), X.weighingTotalWeight = X.theoryTotalWeight) : (X.quantity = 0, X.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => X, () => {
      var $, k, J;
      if (!n.boolPartyA && !n.noDetail && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected)) {
        const z = (J = y.selectObj[X.mergeId]) == null ? void 0 : J.isSelected;
        y.selectObj[X.mergeId] = { ...y.selectObj[X.mergeId], ...X, mete: X.weighingTotalWeight, isSelected: z };
      }
    }, { deep: true }), X.boolApplyPurchase || (Ce([() => X.length, () => X.width, () => X.thickness, r], () => he(X)), Ce([() => X.theoryWeight, () => X.quantity], () => be(X))), Ce(() => X.weighingTotalWeight, () => {
      me(X);
    });
  }
  async function he(X) {
    X.theoryWeight = await na({ classifyId: X.classifyId, name: X.classifyFullName, length: X.length, width: X.width, thickness: X.thickness });
  }
  function be(X) {
    A(X.theoryWeight) && X.quantity ? (X.theoryTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision))) : (X.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = void 0));
  }
  function me(X) {
    A(X.unitPrice) && A(X.weighingTotalWeight) ? X.amount = Be(X.weighingTotalWeight * X.unitPrice, Ze.YUAN) : X.amount = void 0;
  }
  function ge(X, $, k) {
    u.value ? u.value.delListItem(X, $) : y.auxMatList.splice($, 1);
  }
  function Le(X, $) {
    var z;
    const k = JSON.parse(JSON.stringify(X)), J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classifySerialNumber, serialNumber: k.serialNumber, classifyId: k.classifyId, classifyFullName: k.classifyFullName, classifyName: k.classifyName, classifyParentFullName: k.classifyParentFullName, basicClass: k.basicClass, specification: k.specification, model: k.spec, specificationMap: k.specificationMap, measureUnit: k.measureUnit, accountingUnit: k.accountingUnit, accountingPrecision: k.accountingPrecision, measurePrecision: k.measurePrecision, quantity: k.quantity, thickness: k.thickness, length: k.length, width: k.width, theoryWeight: k.theoryWeight, theoryTotalWeight: k.theoryTotalWeight, weighingTotalWeight: k.weighingTotalWeight, rowIndex: y.auxMatList.length, weightMeasurementMode: k.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : k.unitPrice, mete: k.mete, color: k.color, brand: k.brand, projectSerialNumber: k.projectSerialNumber, projectId: k.projectId, workshopName: k.workshopName, warehouseName: k.warehouseName, workshopId: k.workshopId, warehouseId: k.warehouseId });
    y.auxMatList.push(J), se(J), (z = u.value) == null || z.initSelected([J]);
  }
  function Ie() {
    const X = At(y.auxMatList), { validResult: $ } = ae(y.auxMatList);
    if ($) j(X), X.forEach((k) => {
    });
    else {
      const k = y.auxMatList.find((J) => J.verify ? Object.values(J.verify).some((z) => z === false) : false);
      k && h.value && pt(() => {
        h.value.scrollToRow(k);
      });
    }
    return $;
  }
  function Se(X, $) {
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Se, validate: Ie, setSelect: oe }), (X, $) => {
    const k = Mt, J = Ve("vxe-column"), z = Ve("vxe-tooltip"), F = ya, G = Ve("common-input-number"), ie = Ve("common-button"), ue = Ve("vxe-table"), ne = Ve("common-drawer"), te = _t("empty-text"), de = oi;
    return w(), Q("div", null, [qe((w(), Q("div", null, [(w(), U(ue, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(J, { type: "expand", width: "60" }, { content: p(({ row: pe }) => [C("div", fre, [s(k, { modelValue: pe.remark, "onUpdate:modelValue": (re) => pe.remark = re, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(pe.inboundList) ? (w(), Q("div", gre, [s(l(al), { "basic-class": l(c), list: pe.inboundList, material: pe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(J, { title: "序号", type: "seq", width: "55" }), s(J, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: pe }) => [s(z, { content: pe.classifyParentFullName, disabled: !pe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[te, pe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(J, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: pe }) => {
      var re, we, Ke;
      return [(we = (re = l(y).selectObj) == null ? void 0 : re[pe.mergeId]) != null && we.isSelected && ((Ke = l(g)) == null ? void 0 : Ke.spec) & l(c) && !pe.boolApplyPurchase ? (w(), U(F, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Me) => l(x)(pe) }, null, 8, ["onClick"])) : H("", true), s(z, { content: pe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(pe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(J, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.measureUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: pe }) => [e.isEdit && l(A)(pe.measureUnit) ? (w(), U(G, { key: 0, modelValue: pe.quantity, "onUpdate:modelValue": (re) => pe.quantity = re, controls: false, max: 999999999, min: 0, precision: pe.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Ere, K(pe.quantity), 1))]), _: 1 }), s(J, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.accountingUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.mete, "onUpdate:modelValue": (re) => pe.mete = re, controls: false, max: 999999999, min: 1e-6, precision: pe.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", yre, K(pe.mete), 1))]), _: 1 }), s(J, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.color, "onUpdate:modelValue": (re) => pe.color = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Tre, K(pe.color), 1))]), _: 1 }), s(J, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.brand, "onUpdate:modelValue": (re) => pe.brand = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", _re, K(pe.brand), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), U(J, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: pe }) => [C("span", null, K(pe.projectFullName || pe.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(J, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.workshopName), 1)]), _: 1 }), s(J, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(J, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: pe, rowIndex: re }) => [s(ie, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (we) => Le(pe, re) }, null, 8, ["onClick"]), s(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (we) => ge(pe.sn, re, pe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[de, S.value]]), s(ne, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": $[1] || ($[1] = (pe) => Gt(O) ? O.value = pe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": $[0] || ($[0] = (pe) => Gt(L) ? L.value = pe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Im = ut(bre, [["__scopeId", "data-v-c58fd670"]]), Vre = Object.freeze(Object.defineProperty({ __proto__: null, default: Im }, Symbol.toStringTag, { value: "Module" }));
const wre = { class: "aux-mat-inbound-application-container" }, Sre = { class: "filter-container" }, vre = { class: "filter-right-box" }, Rre = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  Ht();
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, supplyType: Ni.PARTY_A.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] }, r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(true), S = Z(false), h = Z(false), T = Pe.OTHER.V, _ = Ee(() => false), f = Ee(() => {
    var X, $;
    return !!(($ = (X = V.value) == null ? void 0 : X.applyPurchase) != null && $.length);
  }), m = Ee(() => ({ basicClass: T })), R = Ee(() => !!(T && V.value)), v = Ee(() => {
    let X = 0;
    return g.value || A(Y.auxMatList) && Y.auxMatList.forEach(($) => {
      A($.amount) && (X += +$.amount);
    }), ji(X, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const N = Z(false), P = Ee(() => !c.edit && !N.value), L = () => {
    N.value = true, x(Y);
  };
  function O() {
    N.value = false, he();
  }
  const x = (X) => {
    var k;
    X.auxMatList = (k = X.auxMatList) == null ? void 0 : k.map((J) => Ct(J));
    const $ = Ce(r, (J) => {
      if (J) {
        pt(() => {
          var F;
          (F = r.value) == null || F.setSelect();
        }), g.value || X.auxMatList.forEach((F) => {
          var G, ie;
          r.value.rowWatch(F), !g.value && !S.value && ((ie = (G = X.selectObj) == null ? void 0 : G[F.mergeId]) != null && ie.isSelected) && r.value.toggleRowSelection(F, true);
        });
        const z = Ce(E, () => {
          E.value && (E.value.initSelected(X.auxMatList.map((F) => ({ sn: F.sn, classifyId: F.classifyId }))), pt(() => {
            z();
          }));
        }, { immediate: true });
        pt(() => {
          $();
        });
      }
    }, { immediate: true, deep: true });
    j();
  }, { cu: I, form: Y, FORM: ee } = Pa({ title: "其它入库", formStore: !c.edit, formStoreKey: "WMS_INBOUND_APPLICATION_OTHER_MAT_PARTYA", permission: ub, useDraftCallback: L, defaultForm: u, clearDraftCallback: O, api: c.edit ? mu : Zle }, y, c.detail), { maxHeight: B } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded), q = Ee(() => {
    var X;
    return (X = Y.list) == null ? void 0 : X.filter(($) => {
      var k, J;
      return (J = (k = I == null ? void 0 : I.submitResult) == null ? void 0 : k.data) == null ? void 0 : J.includes($.classifyId);
    });
  });
  let ae = {};
  c.edit ? ae = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 360, extraHeight: 20 } : ae = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 360, extraHeight: 20 };
  const { fixMaxHeight: j, maxHeight: le } = Kt(ae, r);
  he(), ee.HOOK.beforeToEdit = async (X, $) => {
    var k;
    c.edit && ($.purchaseId = (k = $.purchaseOrder) == null ? void 0 : k.id, $.logistics || ($.logistics = {}), g.value && ($.auxMatList = $.list, x($)));
  }, ee.HOOK.afterSubmit = () => {
    c.edit && n("success"), he();
  };
  function oe() {
    if (be.value) return;
    const X = r.value ? r.value.validate() : true;
    if (X) {
      const $ = [];
      Y.auxMatList.forEach((k) => {
        var J, z;
        (J = k.applyPurchase) != null && J.length ? k.applyPurchase.forEach((F) => {
          var G, ie;
          (F.quantity || F.mete) && $.push({ ...k, quantity: F.quantity, projectId: (G = F.project) == null ? void 0 : G.id, uid: Tt(), mete: F.mete, applyPurchaseId: F.applyPurchaseId, purchaseDetailId: F.purchaseDetailId, purchaseProjectDisabled: F.applyPurchaseId ? !((ie = F.project) != null && ie.id) : false });
        }) : (g.value || S.value || (z = Y.selectObj[k.mergeId]) != null && z.isSelected) && $.push(k);
      }), Y.list = $;
    }
    return A(q.value) ? (ot.error("请先删除标红数据并重新添加"), false) : X;
  }
  function ye(X) {
    return X.model = X.spec, r.value.rowInit(X);
  }
  async function ce(X) {
    var k;
    he(), V.value = X, I.props.order = X, g.value = true, Y.supplyType = Ni.PARTY_A.V, S.value = Ae(X == null ? void 0 : X.details), P.value && (Y.auxMatList = [], x(Y));
    const $ = Ce(E, () => {
      E.value && (E.value.clearByBasicClass(T), pt(() => {
        $();
      }));
    }, { immediate: true });
    (k = X == null ? void 0 : X.details) != null && k.length && (Y.auxMatList = X.details.map((J) => (J.uid = Tt(), J)), x(Y)), M.value = true;
  }
  function se() {
    var X;
    if (A(q.value) && A((X = I == null ? void 0 : I.submitResult) == null ? void 0 : X.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    h.value = true;
  }
  function he() {
    M.value = false, g.value = true;
  }
  I.props.import = (X) => {
    if (Y.inboundWay === si.OPENING_RECEIPT.V) return Y.auxMatList.push.apply(Y.auxMatList, X);
    _.value || X.forEach((J) => {
      J.amount = void 0, J.unitPrice = void 0;
    });
    const $ = Y.auxMatList.length;
    X.map((J, z) => {
      J.projectId = J.projectId || (z > 0 || $ > 0 ? -1 : void 0), J.workshopId = J.workshopId || (z > 0 || $ > 0 ? -1 : void 0), J.warehouseId = J.warehouseId || (z > 0 || $ > 0 ? -1 : void 0);
    }), Y.auxMatList.push.apply(Y.auxMatList, X);
    const k = Ce(E, () => {
      E.value && (E.value.initSelected(X.map((J) => ({ sn: J.sn, classifyId: J.classifyId }))), pt(() => {
        k();
      }));
    }, { immediate: true });
  };
  const be = Ee(() => (Y == null ? void 0 : Y.inboundWay) === si.OPENING_RECEIPT.V);
  Ce(() => Y.inboundWay, (X) => {
    Y != null && Y.id || (Y.auxMatList = [], Y.list = []);
  });
  function me() {
    return !!r.value.validate();
  }
  const ge = Z();
  function Le() {
    ge.value.handleClose();
  }
  async function Ie() {
    try {
      const X = At(Y.auxMatList);
      if (Ae(X)) return;
      await Ut(X, { toSmallest: true, toNum: true }), Y.list = X, await Jle(Y), I.submitSuccessNotify(), I.resetForm(), Le();
    } catch (X) {
      throw console.error("其他材料期初入库提交失败:", X), new Error(X);
    }
  }
  function Se() {
    n("beginClose");
  }
  return (X, $) => {
    const k = Ve("common-button"), J = jt, z = Li, F = Ve("common-drawer"), G = _t("permission");
    return qe((w(), Q("div", wre, [s(vu, { "basic-class": l(T), "begin-permission": l(Ud), "begin-validate": me, edit: c.edit, "show-total": false, "show-total-amount": !g.value && _.value, "total-amount": v.value, validate: oe, onPurchaseOrderChange: ce }, { beginPreview: p((ie) => [s(Ru, { ref_key: "beginConfirmRef", ref: ge, submit: Ie, onSuccess: Se, visible: ie.visible, title: "办公用品", "onUpdate:visible": (ue) => ie.onUpdateVisible(ue) }, { default: p(() => [s(Im, { "is-edit": false, "max-height": l(le) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var ie;
      return [C("div", Sre, [C("div", vre, [be.value && l(Ai)(l(Ud).download) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).OTHER.V, boolPartyA: g.value }, class: "filter-item" }, { default: p(() => $[1] || ($[1] = [Te("办公用品期初入库模版下载 ")])), _: 1, __: [1] }, 8, ["fn", "params"])) : H("", true), !be.value && (g.value || S.value) ? (w(), U(ia, { key: 1, disabled: !l(T), fn: l(bd), params: m.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(T) ? l(Pe).VL[l(T)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), be.value ? (w(), Q(Qe, { key: 2 }, [l(Ai)((ie = l(Ud)) == null ? void 0 : ie.import) ? (w(), U(k, { key: 0, class: "filter-item", type: "success", onClick: se }, { default: p(() => $[2] || ($[2] = [Te("添加物料 ")])), _: 1, __: [2] })) : H("", true)], 64)) : (w(), U(J, { key: 3, disabled: R.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => [C("span", null, [g.value || S.value ? (w(), U(k, { key: 0, disabled: !R.value, class: "filter-item", type: "success", onClick: se }, { default: p(() => $[3] || ($[3] = [Te(" 添加物料 ")])), _: 1, __: [3] }, 8, ["disabled"])) : H("", true)])]), _: 1 }, 8, ["disabled"]))])]), l(Y).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(z, { key: 0, ref_key: "formRef", ref: y, model: l(Y) }, { default: p(() => [s(wd, { ref_key: "tableRef", ref: r, "basic-class": l(T), "bool-apply-purchase": f.value, "bool-party-a": g.value, fillableAmount: _.value, "max-height": l(le), noDetail: S.value, order: V.value, style: ri(X.maxHeightStyle) }, null, 8, ["basic-class", "bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"])]), _: 1 }, 8, ["model"])) : (w(), U(Im, { key: l(Y).inboundWay, ref_key: "tableRef", ref: r, "max-height": l(le) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "show-total-amount", "total-amount"]), s(F, { ref_key: "drawerRef", ref: b, modelValue: h.value, "onUpdate:modelValue": $[0] || ($[0] = (ie) => h.value = ie), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => {
      var ie;
      return [be.value || R.value ? (w(), U(to, { key: l(Y).inboundWay, ref_key: "matSpecRef", ref: E, "basic-class": l(T), "classify-ids": (ie = V.value) == null ? void 0 : ie.otherMaterialIds, "max-height": l(B), "model-value": l(Y).auxMatList, "row-init-fn": ye, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["basic-class", "classify-ids", "max-height", "model-value", "visible"])) : H("", true)];
    }), _: 1 }, 8, ["modelValue"])])), [[G, l(ub)]]);
  };
} }, W4 = ut(Rre, [["__scopeId", "data-v-2131901b"]]), Mre = Object.freeze(Object.defineProperty({ __proto__: null, default: W4 }, Symbol.toStringTag, { value: "Module" }));
const Are = { style: { overflow: "hidden" } }, Nre = { style: {} }, Lre = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, Ire = { key: 1 }, Cre = { key: 1 }, Pre = { key: 1 }, Ore = { key: 1 }, kre = { __name: "gas-begin-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, noDetail: { type: Boolean, default: false }, order: { type: Object, default: () => {
} }, maxHeight: { type: [String, Number], default: 100 }, isEdit: { type: Boolean, default: true } }, setup(e, { expose: o }) {
  const n = e, c = Ge.MATERIAL.V, u = ft("matSpecRef"), { baseUnit: r } = ai(c), { cu: E, form: y } = Wi(), { overDiffTip: b, weightOverDiff: V, diffSubmitValidate: M, currentCfg: g } = Va(r), S = Z(false), h = Z(null), T = Z({ resizable: true });
  Z({ enabled: true, gt: 0, oSize: 10, scrollToLeftOnChange: true });
  const _ = Z({ enabled: true, gt: 60, oSize: 10, scrollToTopOnChange: true, immediate: true }), f = Z([{ seq: "合计", amountExcludingVatFreight: "-", amount: "-" }]);
  Ce(() => y.auxMatList, (X) => {
    m();
  }, { deep: true, immediate: true });
  function m() {
    var k;
    let X = 0, $ = 0;
    (k = y.auxMatList) == null || k.forEach((J) => {
      X += Number(J.amount) || 0, $ += Number(J.amountExcludingVatFreight) || 0;
    }), X = X.toFixed(Ze.YUAN), $ = $.toFixed(Ze.YUAN), f.value = [{ seq: "合计", amountExcludingVatFreight: $, amount: X }];
  }
  const { specSelectMaxHeight: R, specRef: v, drawerRef: N, editRow: P, editList: L, materialSelectVisible: O, handleClickEditSpec: x, handleSpecChange: I } = Qa(), ee = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (X, $) => !!X, message: "核算量必须大于0", trigger: "blur" }], quantity: [{ validator: (X, $) => A($.measureUnit) ? !!$.quantity : true }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = Ee(() => {
    let X = Object.assign({}, ee);
    return !n.boolPartyA && n.fillableAmount && (X = Object.assign(X, {})), X;
  }), q = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: ae, cleanUpData: j, wrongCellMask: le } = ui({ rules: B, ditto: q, errorMsg: "请修正【气体清单】中标红的信息" });
  function oe() {
  }
  function ye({ row: X, rowIndex: $ }) {
    var k, J;
    if ((J = (k = E == null ? void 0 : E.submitResult) == null ? void 0 : k.data) != null && J.includes(X.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function ce(X) {
    const $ = Ct({ uid: Tt(), sn: X.sn, specificationLabels: X.specificationLabels, classifySerialNumber: X.classify.serialNumber, serialNumber: X.serialNumber, classifyId: X.classify.id, classifyFullName: X.classify.fullName, classifyName: X.classify.name, classifyParentFullName: X.classify.parentFullName, basicClass: X.classify.basicClass, specification: X.spec, model: X.spec, specificationMap: X.specKV, measureUnit: X.classify.measureUnit, accountingUnit: X.classify.accountingUnit, accountingPrecision: X.classify.accountingPrecision, measurePrecision: X.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0 });
    return !n.boolPartyA && n.fillableAmount && ($.unitPrice = void 0, $.amount = void 0), $;
  }
  function se(X) {
    Dt(() => {
      var $, k, J, z;
      X.needFirstCalcTheoryWeight && (X.boolApplyPurchase || (he(X), be(X)), X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected) && (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0)), X.needFirstCalcTheoryWeight = false), V(X);
    }), Ce([() => X.boolApplyPurchase, () => X == null ? void 0 : X.applyPurchase], () => {
      var $, k, J, z;
      X.boolApplyPurchase && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected ? (X.quantity = (J = X == null ? void 0 : X.applyPurchase) == null ? void 0 : J.reduce((F, G) => F + (G.quantity || 0), 0), X.theoryTotalWeight = (z = X == null ? void 0 : X.applyPurchase) == null ? void 0 : z.reduce((F, G) => F + (G.theoryTotalWeight || 0), 0), X.weighingTotalWeight = X.theoryTotalWeight) : (X.quantity = 0, X.theoryTotalWeight = 0));
    }, { deep: true }), Ce(() => X, () => {
      var $, k, J;
      if (!n.boolPartyA && !n.noDetail && ((k = ($ = y.selectObj) == null ? void 0 : $[X.mergeId]) != null && k.isSelected)) {
        const z = (J = y.selectObj[X.mergeId]) == null ? void 0 : J.isSelected;
        y.selectObj[X.mergeId] = { ...y.selectObj[X.mergeId], ...X, mete: X.weighingTotalWeight, isSelected: z };
      }
    }, { deep: true }), X.boolApplyPurchase || (Ce([() => X.length, () => X.width, () => X.thickness, r], () => he(X)), Ce([() => X.theoryWeight, () => X.quantity], () => be(X))), Ce(() => X.weighingTotalWeight, () => {
      me(X);
    });
  }
  async function he(X) {
    X.theoryWeight = await na({ classifyId: X.classifyId, name: X.classifyFullName, length: X.length, width: X.width, thickness: X.thickness });
  }
  function be(X) {
    A(X.theoryWeight) && X.quantity ? (X.theoryTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision), (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = Be(X.theoryWeight * X.quantity, r.value.weight.precision))) : (X.theoryTotalWeight = void 0, (n.boolPartyA || n.noDetail) && (X.weighingTotalWeight = void 0));
  }
  function me(X) {
    A(X.unitPrice) && A(X.weighingTotalWeight) ? X.amount = Be(X.weighingTotalWeight * X.unitPrice, Ze.YUAN) : X.amount = void 0;
  }
  function ge(X, $, k) {
    u.value ? u.value.delListItem(X, $) : y.auxMatList.splice($, 1);
  }
  function Le(X, $) {
    var z;
    const k = JSON.parse(JSON.stringify(X)), J = Ct({ uid: Tt(), sn: k.sn, specificationLabels: k.specificationLabels, classifySerialNumber: k.classifySerialNumber, serialNumber: k.serialNumber, classifyId: k.classifyId, classifyFullName: k.classifyFullName, classifyName: k.classifyName, classifyParentFullName: k.classifyParentFullName, basicClass: k.basicClass, specification: k.specification, model: k.spec, specificationMap: k.specificationMap, measureUnit: k.measureUnit, accountingUnit: k.accountingUnit, accountingPrecision: k.accountingPrecision, measurePrecision: k.measurePrecision, quantity: k.quantity, thickness: k.thickness, length: k.length, width: k.width, theoryWeight: k.theoryWeight, theoryTotalWeight: k.theoryTotalWeight, weighingTotalWeight: k.weighingTotalWeight, rowIndex: y.auxMatList.length, weightMeasurementMode: k.weightMeasurementMode, unitPrice: n.boolPartyA || !n.fillableAmount ? void 0 : k.unitPrice, mete: k.mete, color: k.color, brand: k.brand, projectSerialNumber: k.projectSerialNumber, projectId: k.projectId, workshopName: k.workshopName, warehouseName: k.warehouseName, workshopId: k.workshopId, warehouseId: k.warehouseId });
    y.auxMatList.push(J), se(J), (z = u.value) == null || z.initSelected([J]);
  }
  function Ie() {
    const X = At(y.auxMatList), { validResult: $ } = ae(y.auxMatList);
    if ($) j(X), X.forEach((k) => {
    });
    else {
      const k = y.auxMatList.find((J) => J.verify ? Object.values(J.verify).some((z) => z === false) : false);
      k && h.value && pt(() => {
        h.value.scrollToRow(k);
      });
    }
    return $;
  }
  function Se(X, $) {
  }
  return o({ rowInit: ce, rowWatch: se, toggleRowSelection: Se, validate: Ie, setSelect: oe }), (X, $) => {
    const k = Mt, J = Ve("vxe-column"), z = Ve("vxe-tooltip"), F = ya, G = Ve("common-input-number"), ie = Ve("common-button"), ue = Ve("vxe-table"), ne = Ve("common-drawer"), te = _t("empty-text"), de = oi;
    return w(), Q("div", null, [qe((w(), Q("div", Are, [(w(), U(ue, { ref_key: "tableRef", ref: h, key: `inbound_${l(c)}`, "cell-class-name": l(le), "column-config": T.value, data: l(y).auxMatList, "empty-text": "暂无数据", "max-height": e.maxHeight, "row-style": ye, "scroll-y": _.value, border: "", "footer-data": f.value, "show-footer": "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: p(() => [s(J, { type: "expand", width: "60" }, { content: p(({ row: pe }) => [C("div", Nre, [s(k, { modelValue: pe.remark, "onUpdate:modelValue": (re) => pe.remark = re, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), l(A)(pe.inboundList) ? (w(), Q("div", Lre, [s(l(al), { "basic-class": l(c), list: pe.inboundList, material: pe, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : H("", true)])]), _: 1 }), s(J, { title: "序号", type: "seq", width: "55" }), s(J, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: p(({ row: pe }) => [s(z, { content: pe.classifyParentFullName, disabled: !pe.classifyParentFullName, "show-after": 500, placement: "top" }, { default: p(() => [qe(C("span", null, null, 512), [[te, pe.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(J, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: p(({ row: pe }) => {
      var re, we, Ke;
      return [(we = (re = l(y).selectObj) == null ? void 0 : re[pe.mergeId]) != null && we.isSelected && ((Ke = l(g)) == null ? void 0 : Ke.spec) & l(c) && !pe.boolApplyPurchase ? (w(), U(F, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (Me) => l(x)(pe) }, null, 8, ["onClick"])) : H("", true), s(z, { content: pe.specificationLabels, placement: "top" }, { default: p(() => [C("span", null, K(pe.specification), 1)]), _: 2 }, 1032, ["content"])];
    }), _: 1 }), s(J, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.measureUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: p(({ row: pe }) => [e.isEdit && l(A)(pe.measureUnit) ? (w(), U(G, { key: 0, modelValue: pe.quantity, "onUpdate:modelValue": (re) => pe.quantity = re, controls: false, max: 999999999, min: 0, precision: pe.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Ire, K(pe.quantity), 1))]), _: 1 }), s(J, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: p(({ row: pe }) => [C("span", null, K(pe.accountingUnit || "-"), 1)]), _: 1 }), s(J, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(G, { key: 0, modelValue: pe.mete, "onUpdate:modelValue": (re) => pe.mete = re, controls: false, max: 999999999, min: 1e-6, precision: pe.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (w(), Q("span", Cre, K(pe.mete), 1))]), _: 1 }), s(J, { align: "center", field: "color", title: "颜色", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.color, "onUpdate:modelValue": (re) => pe.color = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "颜色", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Pre, K(pe.color), 1))]), _: 1 }), s(J, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: p(({ row: pe }) => [e.isEdit ? (w(), U(k, { key: 0, modelValue: pe.brand, "onUpdate:modelValue": (re) => pe.brand = re, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (w(), Q("span", Ore, K(pe.brand), 1))]), _: 1 }), e.isEdit ? (w(), U(zl, { key: 0, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), U(J, { key: 1, align: "center", field: "projectSerialNumber", "min-width": "180", title: "所属项目" }, { default: p(({ row: pe }) => [C("span", null, K(pe.projectFullName || pe.projectSerialNumber), 1)]), _: 1 })), e.isEdit ? (w(), U(Fl, { key: 2, "is-begin": true, list: l(y).auxMatList }, null, 8, ["list"])) : (w(), Q(Qe, { key: 3 }, [s(J, { align: "center", field: "workshopName", title: "仓库", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.workshopName), 1)]), _: 1 }), s(J, { align: "center", field: "warehouseId", title: "存储位置", width: "130" }, { default: p(({ row: pe }) => [C("span", null, K(pe.warehouseName), 1)]), _: 1 })], 64)), e.isEdit ? (w(), U(J, { key: 4, align: "center", fixed: "right", title: "操作", width: "160" }, { default: p(({ row: pe, rowIndex: re }) => [s(ie, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (we) => Le(pe, re) }, null, 8, ["onClick"]), s(ie, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (we) => ge(pe.sn, re, pe) }, null, 8, ["onClick"])]), _: 1 })) : H("", true)]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y", "footer-data"]))])), [[de, S.value]]), s(ne, { ref_key: "drawerRef", ref: N, modelValue: l(O), "onUpdate:modelValue": $[1] || ($[1] = (pe) => Gt(O) ? O.value = pe : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: p(() => [s(ba, { ref_key: "specRef", ref: v, modelValue: l(L), "onUpdate:modelValue": $[0] || ($[0] = (pe) => Gt(L) ? L.value = pe : null), classifyId: l(P).classifyId, "max-height": l(R), "show-classify": false, visible: l(O), "expand-query": "", mode: "selector", onChange: l(I) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Cm = ut(kre, [["__scopeId", "data-v-2ec9dc4e"]]), Dre = Object.freeze(Object.defineProperty({ __proto__: null, default: Cm }, Symbol.toStringTag, { value: "Module" }));
const xre = { class: "aux-mat-inbound-application-container" }, Ure = { class: "filter-container" }, Yre = { class: "filter-right-box" }, Kre = { __name: "index", props: { edit: { type: Boolean, default: false }, detail: { type: Object } }, emits: ["success", "beginClose"], setup(e, { emit: o }) {
  Ht();
  const n = o, c = e, u = { inboundWay: si.ORDINARY_STORAGE.V, supplyType: Ni.PARTY_A.V, purchaseId: null, loadingWeight: null, licensePlate: null, shipmentNumber: null, logistics: {}, list: [], auxMatList: [] }, r = Z(), E = Z(), y = Z(), b = Z(), V = Z(), M = Z(false), g = Z(true), S = Z(false), h = Z(false), T = Ge.GAS.V, { inboundFillWayCfg: _ } = aa(), f = Ee(() => ({ basicClass: T })), m = Ee(() => _.value ? _.value.amountFillWay === $l.APPLICATION.V : false), R = Ee(() => {
    var $, k;
    return !!((k = ($ = V.value) == null ? void 0 : $.applyPurchase) != null && k.length);
  }), v = Ee(() => !!(T && V.value)), N = Ee(() => {
    let $ = 0;
    return g.value || A(B.auxMatList) && B.auxMatList.forEach((k) => {
      A(k.amount) && ($ += +k.amount);
    }), ji($, Ze.YUAN);
  });
  yi("matSpecRef", E);
  const P = Z(false), L = Ee(() => !c.edit && !P.value), O = () => {
    P.value = true, Y(B);
  }, x = Ee(() => {
    var $;
    return ($ = B.list) == null ? void 0 : $.filter((k) => {
      var J, z;
      return (z = (J = ee == null ? void 0 : ee.submitResult) == null ? void 0 : J.data) == null ? void 0 : z.includes(k.classifyId);
    });
  });
  function I() {
    P.value = false, he();
  }
  const Y = ($) => {
    var J;
    $.auxMatList = (J = $.auxMatList) == null ? void 0 : J.map((z) => Ct(z));
    const k = Ce(r, (z) => {
      if (z) {
        pt(() => {
          var G;
          (G = r.value) == null || G.setSelect();
        }), g.value || $.auxMatList.forEach((G) => {
          var ie, ue;
          r.value.rowWatch(G), !g.value && !S.value && ((ue = (ie = $.selectObj) == null ? void 0 : ie[G.mergeId]) != null && ue.isSelected) && r.value.toggleRowSelection(G, true);
        });
        const F = Ce(E, () => {
          E.value && (E.value.initSelected($.auxMatList.map((G) => ({ sn: G.sn, classifyId: G.classifyId }))), pt(() => {
            L.value && (L.value = false), F();
          }));
        }, { immediate: true });
        pt(() => {
          k();
        });
      }
    }, { immediate: true, deep: true });
    le();
  }, { cu: ee, form: B, FORM: q } = Pa({ title: "气体入库", formStore: !c.edit, formStoreKey: "WMS_INBOUND_APPLICATION_GAS_PARTYA", permission: cb, useDraftCallback: O, defaultForm: u, clearDraftCallback: I, api: c.edit ? mu : Xle }, y, c.detail), { maxHeight: ae } = Kt({ mainBox: ".material-table-spec-select", extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300 }, () => b.value.loaded);
  let j = {};
  c.edit ? j = { mainBox: ".raw-mat-inbound-application-record-form", extraBox: [".el-drawer__header", ".filter-container", ".inbound-application-header", ".inbound-application-footer"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false, minHeight: 360, extraHeight: 20 } : j = { mainBox: ".aux-mat-inbound-application-container", extraBox: [".filter-container", ".inbound-application-header", ".inbound-application-footer"], navbar: true, minHeight: 360, extraHeight: 20 };
  const { fixMaxHeight: le, maxHeight: oe } = Kt(j, r);
  he(), q.HOOK.beforeToEdit = async ($, k) => {
    var J;
    c.edit && (k.purchaseId = (J = k.purchaseOrder) == null ? void 0 : J.id, k.logistics || (k.logistics = {}), (g.value || S.value) && (k.auxMatList = k.list, Y(k)));
  }, q.HOOK.afterSubmit = () => {
    c.edit && n("success"), he();
  };
  function ye() {
    if (me.value) return;
    const $ = r.value ? r.value.validate() : true;
    if ($) {
      const k = [];
      B.auxMatList.forEach((J) => {
        var z, F;
        (z = J.applyPurchase) != null && z.length ? J.applyPurchase.forEach((G) => {
          var ie, ue;
          (G.quantity || G.mete) && k.push({ ...J, quantity: G.quantity, projectId: (ie = G.project) == null ? void 0 : ie.id, uid: Tt(), mete: G.mete, applyPurchaseId: G.applyPurchaseId, purchaseDetailId: G.purchaseDetailId, purchaseProjectDisabled: G.applyPurchaseId ? !((ue = G.project) != null && ue.id) : false });
        }) : (g.value || S.value || (F = B.selectObj[J.mergeId]) != null && F.isSelected) && k.push(J);
      }), B.list = k;
    }
    return A(x.value) ? (ot.error("请先删除标红数据并重新添加"), false) : $;
  }
  function ce($) {
    return $.model = $.spec, r.value.rowInit($);
  }
  async function se($) {
    var k;
    if (he(), V.value = $, ee.props.order = $, g.value = true, S.value = Ae($ == null ? void 0 : $.details), B.supplyType = Ni.PARTY_A.V, L.value && (B.auxMatList = []), L.value) {
      const J = Ce(E, () => {
        E.value && (E.value.clearByBasicClass(T), pt(() => {
          J();
        }));
      }, { immediate: true });
    }
    g.value && L.value && Y(B), (k = $ == null ? void 0 : $.details) != null && k.length && (B.auxMatList = $.details.map((J) => (J.uid = Tt(), J)), Y(B)), M.value = true;
  }
  function he() {
    M.value = false, g.value = true;
  }
  function be() {
    var $;
    if (A(x.value) && A(($ = ee == null ? void 0 : ee.submitResult) == null ? void 0 : $.data)) {
      ot.error("请删除全部标红数据");
      return;
    }
    h.value = true;
  }
  ee.props.import = ($) => {
    m.value || $.forEach((z) => {
      z.amount = void 0, z.unitPrice = void 0;
    });
    const k = B.auxMatList.length;
    $.map((z, F) => {
      z.projectId = z.projectId || (F > 0 || k > 0 ? -1 : void 0), z.workshopId = z.workshopId || (F > 0 || k > 0 ? -1 : void 0), z.warehouseId = z.warehouseId || (F > 0 || k > 0 ? -1 : void 0);
    }), B.auxMatList.push.apply(B.auxMatList, $);
    const J = Ce(E, () => {
      E.value && (E.value.initSelected($.map((z) => ({ sn: z.sn, classifyId: z.classifyId }))), pt(() => {
        J();
      }));
    }, { immediate: true });
  };
  const me = Ee(() => (B == null ? void 0 : B.inboundWay) === si.OPENING_RECEIPT.V);
  Ce(() => B.inboundWay, ($) => {
    B != null && B.id || (B.list = [], B.auxMatList = []);
  });
  function ge() {
    return !!r.value.validate();
  }
  const Le = Z();
  function Ie() {
    Le.value.handleClose();
  }
  async function Se() {
    try {
      const $ = At(B.auxMatList);
      if (Ae($)) return;
      await Ut($, { toSmallest: true, toNum: true }), B.list = $, await $le(B), ee.submitSuccessNotify(), ee.resetForm(), Ie();
    } catch ($) {
      throw console.error("气体材料期初入库提交失败:", $), new Error($);
    }
  }
  function X() {
    n("beginClose");
  }
  return ($, k) => {
    const J = Ve("common-button"), z = jt, F = Li, G = Ve("common-drawer"), ie = _t("permission");
    return qe((w(), Q("div", xre, [s(vu, { "basic-class": l(T), "begin-permission": l(xd), "begin-validate": ge, edit: c.edit, "show-total": false, "show-total-amount": !g.value && m.value, "total-amount": N.value, validate: ye, onPurchaseOrderChange: se }, { beginPreview: p((ue) => [s(Ru, { ref_key: "beginConfirmRef", ref: Le, submit: Se, onSuccess: X, visible: ue.visible, title: "气体", "onUpdate:visible": (ne) => ue.onUpdateVisible(ne) }, { default: p(() => [s(Cm, { "is-edit": false, "max-height": l(oe) + 120 }, null, 8, ["max-height"])]), _: 2 }, 1032, ["visible", "onUpdate:visible"])]), default: p(() => {
      var ue;
      return [C("div", Ure, [C("div", Yre, [me.value && l(Ai)(l(xd).download) ? (w(), U(ia, { key: 0, fn: l(is), params: { basicClass: l(Pe).GAS.V, boolPartyA: true }, class: "filter-item" }, { default: p(() => k[2] || (k[2] = [Te("气体期初入库模版下载 ")])), _: 1, __: [2] }, 8, ["fn", "params"])) : H("", true), l(B).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(ia, { key: 1, disabled: !l(T), fn: l(bd), params: f.value, class: "filter-item", "response-header-result": "" }, { default: p(() => [Te(K(l(T) ? l(Ge).VL[l(T)] : "") + "入库模板下载 ", 1)]), _: 1 }, 8, ["disabled", "fn", "params"])) : H("", true), me.value ? (w(), Q(Qe, { key: 2 }, [l(Ai)((ue = l(xd)) == null ? void 0 : ue.import) ? (w(), U(J, { key: 0, class: "filter-item", type: "success", onClick: be }, { default: p(() => k[3] || (k[3] = [Te(" 添加物料 ")])), _: 1, __: [3] })) : H("", true)], 64)) : (w(), U(z, { key: 3, disabled: v.value, content: "请先选择采购合同编号", effect: "light", placement: "left-start" }, { default: p(() => [C("span", null, [s(J, { disabled: !v.value, class: "filter-item", type: "success", onClick: be }, { default: p(() => k[4] || (k[4] = [Te(" 添加物料 ")])), _: 1, __: [4] }, 8, ["disabled"])])]), _: 1 }, 8, ["disabled"]))])]), l(B).inboundWay === l(si).ORDINARY_STORAGE.V ? (w(), U(F, { key: 0, ref_key: "formRef", ref: y, model: l(B) }, { default: p(() => [s(wd, { ref_key: "tableRef", ref: r, "bool-apply-purchase": R.value, "bool-party-a": g.value, fillableAmount: m.value, "max-height": l(oe), noDetail: S.value, order: V.value, showColor: false, style: ri($.maxHeightStyle) }, null, 8, ["bool-apply-purchase", "bool-party-a", "fillableAmount", "max-height", "noDetail", "order", "style"])]), _: 1 }, 8, ["model"])) : (w(), U(Cm, { key: l(B).inboundWay, ref_key: "tableRef", ref: r, "max-height": l(oe) }, null, 8, ["max-height"]))];
    }), _: 1 }, 8, ["basic-class", "begin-permission", "edit", "show-total-amount", "total-amount"]), s(G, { ref_key: "drawerRef", ref: b, modelValue: h.value, "onUpdate:modelValue": k[1] || (k[1] = (ue) => h.value = ue), "show-close": true, size: 900, "custom-class": "material-table-spec-select", title: "物料选择" }, { content: p(() => [me.value || v.value ? (w(), U(to, { key: l(B).inboundWay, ref_key: "matSpecRef", ref: E, modelValue: l(B).auxMatList, "onUpdate:modelValue": k[0] || (k[0] = (ue) => l(B).auxMatList = ue), "basic-class": l(T), "max-height": l(ae), "row-init-fn": ce, "table-width": 430, visible: h.value, "auto-selected": "", "expand-query": "" }, null, 8, ["modelValue", "basic-class", "max-height", "visible"])) : H("", true)]), _: 1 }, 8, ["modelValue"])])), [[ie, l(cb)]]);
  };
} }, j4 = ut(Kre, [["__scopeId", "data-v-0433f9a6"]]), Wre = Object.freeze(Object.defineProperty({ __proto__: null, default: j4 }, Symbol.toStringTag, { value: "Module" }));
const jre = { __name: "form", setup(e) {
  const { CRUD: o, crud: n, form: c } = An(), { baseUnit: u } = ai(), r = Ee(() => {
    switch (c.basicClass) {
      case Ge.STEEL_PLATE.V:
      case Ge.SECTION_STEEL.V:
      case Ge.STEEL_COIL.V:
      case Pe.OTHER_STEEL_MATERIALS.V:
        return Nm;
      case Ge.MATERIAL.V:
        return K4;
      case Ge.GAS.V:
        return j4;
      case Ge.OTHER.V:
        return W4;
      default:
        return c.basicClass & ua ? Nm : void 0;
    }
  });
  function E(b) {
    var V, M;
    b.materialIsWholeName = b.materialIsWhole === 2 ? "余料" : "整料", b.profileLibraryStandard = (b == null ? void 0 : b.nationalStandard) || void 0, b.workshopName = (V = b == null ? void 0 : b.workshop) == null ? void 0 : V.name, b.warehouseName = (M = b == null ? void 0 : b.warehouse) == null ? void 0 : M.name, b.projectSerialNumber = di(b.project);
  }
  o.HOOK.beforeEditDetailLoaded = async (b, V) => {
    await Qt(V.list), V.list = await Ut(V.list, { toSmallest: false, toNum: true }), V.list.forEach((M) => {
      var g, S, h, T;
      V.inboundWay === si.OPENING_RECEIPT.V ? E(M) : M.warehouseName = ((g = M.workshop) == null ? void 0 : g.name) || M.warehouseName, M.workshopId = ((S = M.workshop) == null ? void 0 : S.id) || M.workshopId, M.warehouseId = ((h = M.warehouse) == null ? void 0 : h.id) || M.warehouseId, M.projectId = ((T = M.project) == null ? void 0 : T.id) || M.projectId;
    }), V.logistics = V.logisticsOrder, V.supplyType !== Ni.PARTY_A.V && A(V.purchaseOrder.details) && (V.originList = At(V.list), await Es(V.originList), V.list = [], V.editObj = {}, V.originList.forEach((M) => {
      var g, S;
      M.basicClass & (Ge.STEEL_PLATE.V | Ge.SECTION_STEEL.V) && (M.theoryTotalWeight = Be(M.theoryWeight * M.quantity, u.value[M.basicClass].weight.precision)), V.editObj[M.mergeId] ? (V.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId] ? V.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId].push({ ...M }) : V.editObj[M.mergeId].applyPurchaseObj[M.applyPurchaseId] = [{ ...M }], V.editObj[M.mergeId].quantity += M.quantity, V.editObj[M.mergeId].mete += M.mete) : (V.editObj[M.mergeId] = { ...M, applyPurchaseObj: { [M.applyPurchaseId]: [{ ...M }] }, isSelected: true }, M.basicClass & Ge.SECTION_STEEL.V && A(V.purchaseOrder) && (V.editObj[M.mergeId].length = ((S = (g = V.purchaseOrder) == null ? void 0 : g.details.find((h) => h.id === M.mergeId)) == null ? void 0 : S.length) || V.editObj[M.mergeId].length));
    })), V.inboundWay === si.OPENING_RECEIPT.V && (V.jsonData = JSON.stringify(V));
  };
  function y() {
    n.cancelCU(), n.refresh();
  }
  return (b, V) => {
    const M = wi, g = Ve("common-drawer");
    return w(), U(g, { ref: "drawerRef", "before-close": l(n).cancelCU, "content-loading": l(n).editDetailLoading, "show-close": true, title: l(n).status.title, visible: l(n).status.cu > l(o).STATUS.NORMAL, "custom-class": "raw-mat-inbound-application-record-form", size: "90%" }, { titleAfter: p(() => [s(M, null, { default: p(() => V[0] || (V[0] = [Te("甲供")])), _: 1, __: [0] })]), content: p(() => [(w(), U(Ri(r.value), { detail: l(c), edit: "", onSuccess: y, onBeginClose: l(n).cancelCU }, null, 40, ["detail", "onBeginClose"]))]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, F4 = ut(jre, [["__scopeId", "data-v-877d297c"]]), Fre = Object.freeze(Object.defineProperty({ __proto__: null, default: F4 }, Symbol.toStringTag, { value: "Module" }));
function zre(e) {
  return W({ module: "plan", url: "drawing/drawing/data", method: "get", params: e });
}
function xft(e) {
  return W({ module: "plan", url: "drawing/drawing/contrast", method: "get", params: e });
}
function Bre(e) {
  return W({ url: "/api/plan/drawing/deepen/delete", method: "delete", data: e });
}
function Hre({ id: e }) {
  return W({ module: "plan", url: `drawing/struct/${e}/export`, method: "get", responseType: "blob" });
}
function Uft(e) {
  return W({ module: "plan", url: "drawing/struct/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Yft(e) {
  return W({ module: "plan", url: "drawing/struct/upload/all", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Kft(e) {
  return W({ module: "plan", url: "drawing/weld/map/struct/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Wft(e) {
  return W({ module: "plan", url: "drawing/struct/upload", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, responseType: "blob", data: e });
}
function jft(e) {
  return W({ module: "plan", url: "drawing/struct/upload/choose", method: "post", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Fft(e) {
  return W({ module: "plan", url: "drawing/struct/update", method: "put", timeout: 6e6, headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function zft(e) {
  return W({ url: "/api/plan/drawing/download/dxfzip", method: "get", responseType: "blob", params: e });
}
function Bft(e) {
  return W({ url: "/api/plan/drawing/drawing/contrast/download", method: "get", responseType: "blob", params: e });
}
function Hft(e) {
  return W({ url: "/api/plan/drawing/download/pdf", method: "get", responseType: "blob", params: e });
}
function qft(e) {
  return W({ url: "/api/plan/drawing/download/pdfzip", method: "get", responseType: "blob", params: e });
}
function Gft(e) {
  return W({ url: "/api/plan/drawing/all/download/pdfzip", method: "get", responseType: "blob", params: e });
}
function Qft(e) {
  return W({ url: `/api/plan/monomer/listByProjectId/${e.projectId}`, method: "get", params: e });
}
function qre(e) {
  return W({ url: `/api/plan/technological_achievement_approve/download/${e.id}`, method: "get", responseType: "blob", params: e });
}
function Zft(e) {
  return W({ url: "/api/oa/flow/deepenDrawing", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: e });
}
function Jft() {
  return W({ url: "/api/oa/flow/deepenDrawing/getFixedData", method: "get" });
}
const Xft = { get: zre, del: Bre, download: Hre };
const Gre = { style: { "word-break": "break-all" } }, Qre = { style: { "word-break": "break-all" } }, Zre = { style: { "word-break": "break-all" } }, Jre = { style: { "word-break": "break-all" } }, Xre = { style: { "word-break": "break-all" } }, $re = ["onClick"], eue = { style: { "word-break": "break-all" } }, tue = { style: { "word-break": "break-all" } }, iue = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = Ht(), { CRUD: c, crud: u, detail: r } = qi(), E = o, y = e, b = Z(), V = Z({ dataId: void 0, opinion: void 0, decision: void 0 }), M = Z(), g = Z(false);
  c.HOOK.beforeDetailLoaded = async (T, { data: _ }) => {
    var v, N;
    b.value = _, V.value.opinion = void 0;
    const f = (v = b.value.attachmentIds) == null ? void 0 : v.split(","), m = (N = b.value.fileNames) == null ? void 0 : N.split(","), R = [];
    f == null || f.forEach((P, L) => {
      const O = {};
      O.attachmentId = Number(P), O.fileName = m[L], R.push(O);
    }), b.value.file = R;
  };
  async function S(T) {
    const _ = { approveProcessTypeName: r.rowDetail.approveProcessTypeName, approveRecordId: b.value.approveRecordId, dataId: b.value.dataId, decision: T, opinion: V.value.opinion };
    if (T === Lt.REFUSE.V && !A(_.opinion)) {
      ot.error("请输入审批意见");
      return;
    }
    await RL(_).then(async (f) => {
      T === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回"), await n.dispatch("approval_list/fetchSubNum", at.V[r.rowDetail.componentName].V), await n.dispatch("approval_list/fetchApprovalNum", at.V[r.rowDetail.componentName].V), await n.dispatch("approval_list/fetchRejNum", at.V[r.rowDetail.componentName].V), u.cancelDetail(), E("auditSuccess");
    });
  }
  function h(T) {
    M.value = T.id, g.value = true;
  }
  return (T, _) => {
    const f = Ve("common-button"), m = pa, R = qa, v = Mt, N = Ga, P = Ve("common-drawer");
    return w(), U(P, { ref: "drawerRef", "before-close": l(u).cancelDetail, "content-loading": l(u).detailLoading, "show-close": true, visible: l(u).detailVisible, "custom-class": "contract-change", size: "900px", title: "文件详情", top: "10vh", width: "600px" }, { titleRight: p(() => [y.ApprovalFlag ? (w(), U(m, { key: 0, title: "确认通过", onConfirm: _[0] || (_[0] = (L) => S(l(Lt).PASS.V)) }, { reference: p(() => [s(f, { class: "filter-item", size: "default", type: "success" }, { default: p(() => _[4] || (_[4] = [Te("通过")])), _: 1, __: [4] })]), _: 1 })) : H("", true), y.ApprovalFlag ? (w(), U(m, { key: 1, title: "确认驳回", onConfirm: _[1] || (_[1] = (L) => S(l(Lt).REFUSE.V)) }, { reference: p(() => [s(f, { class: "filter-item", size: "default", type: "danger" }, { default: p(() => _[5] || (_[5] = [Te(" 驳回 ")])), _: 1, __: [5] })]), _: 1 })) : H("", true)]), content: p(() => [s(N, { column: 2, border: "", class: "margin-top", "label-width": "110" }, { default: p(() => {
      var L, O, x, I;
      return [H("", true), s(R, { span: 2, label: "项目名称", "label-class-name": "projectName" }, { default: p(() => {
        var Y;
        return [C("div", Gre, K(((Y = b.value) == null ? void 0 : Y.projectName) || "-"), 1)];
      }), _: 1 }), s(R, { span: 2, label: "单体名称", "label-class-name": "monomerName" }, { default: p(() => {
        var Y;
        return [C("div", Qre, K(((Y = b.value) == null ? void 0 : Y.monomerName) || "-"), 1)];
      }), _: 1 }), s(R, { span: 2, label: "申请人姓名", "label-class-name": "applicantName" }, { default: p(() => {
        var Y;
        return [C("div", Zre, K(((Y = b.value) == null ? void 0 : Y.applicantName) || "-"), 1)];
      }), _: 1 }), (L = b.value) != null && L.areaName ? (w(), U(R, { key: 1, span: 2, label: "区域名称", "label-class-name": "areaName" }, { default: p(() => {
        var Y;
        return [C("div", Jre, K(((Y = b.value) == null ? void 0 : Y.areaName) || "-"), 1)];
      }), _: 1 })) : H("", true), (O = b.value) != null && O.productType ? (w(), U(R, { key: 2, span: 2, label: "产品类型", "label-class-name": "productType" }, { default: p(() => {
        var Y;
        return [C("div", Xre, K(l(li).VL[(Y = b.value) == null ? void 0 : Y.productType] || "-"), 1)];
      }), _: 1 })) : H("", true), (I = (x = b.value) == null ? void 0 : x.attachments) != null && I.length ? (w(), U(R, { key: 3, span: 2, label: "附件", "label-class-name": "attachments" }, { default: p(() => [(w(true), Q(Qe, null, ki(b.value.attachments, (Y) => {
        var ee;
        return w(), Q("div", { key: Y.id }, [C("span", { style: { cursor: "pointer", color: "#409eff", "margin-right": "10px" }, onClick: (B) => h(Y) }, K(Y.name), 9, $re), s(ia, { fn: l(qre), params: { id: Y.id, approvalRecordId: (ee = b.value) == null ? void 0 : ee.approveRecordId } }, null, 8, ["fn", "params"])]);
      }), 128))]), _: 1 })) : H("", true), s(R, { span: 2, label: "审批状态", "label-class-name": "approveStatus" }, { default: p(() => {
        var Y;
        return [C("div", eue, K(l(ws).VL[(Y = b.value) == null ? void 0 : Y.approveStatus] || "-"), 1)];
      }), _: 1 }), s(R, { span: 2, label: "备注", "label-class-name": "remark" }, { default: p(() => {
        var Y;
        return [C("div", tue, K(((Y = b.value) == null ? void 0 : Y.remark) || "-"), 1)];
      }), _: 1 }), y.ApprovalFlag ? (w(), U(R, { key: 4, span: 2, label: "审批意见", "label-class-name": "opinion" }, { default: p(() => [s(v, { modelValue: V.value.opinion, "onUpdate:modelValue": _[2] || (_[2] = (Y) => V.value.opinion = Y), class: "remark input-border-none", maxlength: "200", placeholder: "请填写审批意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })) : H("", true), y.ApprovalFlag ? H("", true) : (w(), U(R, { key: 5, span: 2, label: "审批意见", "label-class-name": "opinion" }, { default: p(() => {
        var Y;
        return [C("span", null, K((Y = b.value) == null ? void 0 : Y.opinion), 1)];
      }), _: 1 }))];
    }), _: 1 }), g.value ? (w(), U(l(AS), { key: 0, isVisible: g.value, showType: "attachment", id: M.value, onClose: _[3] || (_[3] = (L) => g.value = false) }, null, 8, ["isVisible", "id"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, z4 = ut(iue, [["__scopeId", "data-v-ba9a764c"]]), aue = Object.freeze(Object.defineProperty({ __proto__: null, default: z4 }, Symbol.toStringTag, { value: "Module" }));
const lue = { key: 1, class: "footer" }, oue = { key: 0 }, nue = { style: { color: "brown" } }, sue = { style: { color: "#3a8ee6" } }, rue = { key: 1 }, uue = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = o, c = e, u = Z(), r = Z([]), E = Z(), y = Z(false), b = Z([...Da, ["outboundAddress", ["parse-enum", So]], ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]), { CRUD: V, crud: M, detail: g } = qi(), { maxHeight: S } = Kt({ mainBox: ".raw-mat-inbound-application-record-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !M.detailLoading)), h = Ee(() => g && g.applicationSN ? `出库申请单：${g.applicationSN}` : "出库申请单");
  V.HOOK.beforeDetailLoaded = async (m, R) => {
    E.value = void 0, await Qt(R.list), R.list = await Ut(R.list, { toSmallest: false, toNum: true }, { mete: ["actualTheoryWeight", "mete", "frozenMete"] });
  };
  function T(m) {
    return Hi(m, { props: ["quantity", ["mete", ei.weight.precision]] });
  }
  async function _(m) {
    return m.list = await Ut(m.list, { toSmallest: true, toNum: true }), m;
  }
  async function f(m) {
    try {
      y.value = true;
      const R = At(g), v = await _(R);
      if (m === Lt.REFUSE.V && !A(E.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const N = { approveRecordId: g.approveRecordId, decision: m, opinion: E.value };
      await bS(N, v).then((P) => {
        m === Lt.PASS.V ? ot.success("审批通过") : ot.error("审批驳回");
      }), n("auditSuccess");
    } catch (R) {
      console.log("出库(审批流)审核提交", R);
    } finally {
      y.value = false;
    }
  }
  return (m, R) => {
    const v = wi, N = Ve("common-button"), P = La, L = pa, O = vt, x = jt, I = Ve("common-table"), Y = Mt, ee = Ve("common-drawer");
    return w(), U(ee, { ref_key: "drawerRef", ref: u, "before-close": l(M).cancelDetail, "content-loading": l(M).detailLoading, "show-close": true, title: h.value, visible: l(M).detailVisible, "custom-class": "raw-mat-inbound-application-record-detail", size: "100%" }, { titleAfter: p(() => [l(g).applicant ? (w(), U(v, { key: 0, effect: "dark", type: "success" }, { default: p(() => [Te(K(`申请人：${l(g).applicant.name} | ${l(g).applicant.deptName}`), 1)]), _: 1 })) : H("", true), s(v, { effect: "plain" }, { default: p(() => [Te(K(`出库申请时间：${l(Qi)(l(g).createTime)}`), 1)]), _: 1 }), s(v, { effect: "plain" }, { default: p(() => [Te("备注：" + K(l(g).remark || "-"), 1)]), _: 1 })]), titleRight: p(() => {
      var B;
      return [((B = l(g).wmsApproveRecordFlowDTOS) == null ? void 0 : B.length) !== 0 ? (w(), U(P, { key: 0, width: 400, placement: "bottom", trigger: "hover" }, { reference: p(() => [s(N, { size: "default" }, { default: p(() => R[4] || (R[4] = [Te("查看审批记录")])), _: 1, __: [4] })]), default: p(() => [s(tl, { data: l(g).wmsApproveRecordFlowDTOS || [] }, null, 8, ["data"])]), _: 1 })) : H("", true), c.ApprovalFlag ? (w(), Q("div", lue, [s(L, { title: "确认通过", onConfirm: R[0] || (R[0] = (q) => f(l(Lt).PASS.V)) }, { reference: p(() => [s(N, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => R[5] || (R[5] = [Te("通过 ")])), _: 1, __: [5] }, 8, ["loading"])]), _: 1 }), s(L, { title: "确认驳回", onConfirm: R[1] || (R[1] = (q) => f(l(Lt).REFUSE.V)) }, { reference: p(() => [s(N, { loading: y.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => R[6] || (R[6] = [Te(" 驳回 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : H("", true)];
    }), content: p(() => [s(I, { data: l(g).list, "data-format": b.value, "expand-row-keys": r.value, "max-height": l(S), "summary-method": T, "row-key": "id", "show-summary": "" }, { default: p(() => [s(Ha, { "expand-row-keys": r.value, "onUpdate:expandRowKeys": R[2] || (R[2] = (B) => r.value = B), data: l(g).list, fixed: "left", "row-key": "id" }, { default: p(({ row: B }) => [s(Xl, { "basic-class": B.basicClass, row: B, "show-graphics": "", "show-remark": "" }, { default: p(() => [B.boolTransfer ? (w(), Q("p", oue, [R[7] || (R[7] = Te(" 调拨： ")), R[8] || (R[8] = C("span", null, "（来源）", -1)), C("span", nue, K(B.sourceProject), 1), R[9] || (R[9] = C("span", null, " ▶ ", -1)), R[10] || (R[10] = C("span", null, "（目的）", -1)), C("span", sue, K(B.project), 1)])) : H("", true)]), _: 2 }, 1032, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(g).basicClass, fixed: "left", "show-outbound-mode": "" }, null, 8, ["basic-class"]), s(Ba), s(za), s(O, { align: "center", label: "理论重量", prop: "actualTheoryWeight", width: "100px" }), s(xl, { "show-area": false, "show-monomer": false, "show-project": "", showAreaBatchName: "", "show-transfer": "", showOutboundWorkshop: "" }), s(O, { align: "center", label: "出库目的地", prop: "outboundAddress", width: "100px" }), s(O, { key: "recipient", align: "center", label: "领用人", width: "100px" }, { default: p(({ row: B }) => [B.recipient ? (w(), U(x, { key: 0, content: `${B.recipient.deptName}`, effect: "light", placement: "top" }, { default: p(() => [C("span", null, K(B.recipient.name), 1)]), _: 2 }, 1032, ["content"])) : H("", true)]), _: 1 }), s(O, { key: "outboundTime", align: "center", label: "出库时间", prop: "outboundTime", width: "145px" }), s(O, { key: "usageStatus", align: "center", label: "领用情况", prop: "usageStatus", width: "145px" }, { default: p(({ row: { sourceRow: B } }) => {
      var q;
      return [(q = B.consumingDTO) != null && q.length ? (w(), U(P, { key: 0, class: "box-item", placement: "bottom", title: "领用情况", trigger: "click", width: "327" }, { reference: p(() => [s(N, { type: "primary" }, { default: p(() => R[11] || (R[11] = [Te("查询")])), _: 1, __: [11] })]), default: p(() => [s(I, { data: B.consumingDTO, "row-key": "id" }, { default: p(() => [s(O, { key: "consumingMete", label: `已领用量(${B.consumingUnit})`, align: "center", prop: "consumingMete", width: "100" }, null, 8, ["label"]), s(O, { key: "totalNetWeight", label: `清单净重(${B.consumingUnit})`, align: "center", prop: "totalNetWeight", width: "100" }, null, 8, ["label"]), s(O, { key: "totalGrossWeight", label: `清单毛重(${B.consumingUnit})`, align: "center", prop: "totalGrossWeight", width: "100" }, null, 8, ["label"])]), _: 2 }, 1032, ["data"])]), _: 2 }, 1024)) : (w(), Q("span", rue, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), c.ApprovalFlag ? (w(), U(Y, { key: 0, modelValue: E.value, "onUpdate:modelValue": R[3] || (R[3] = (B) => E.value = B), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, B4 = ut(uue, [["__scopeId", "data-v-56d92ead"]]), cue = Object.freeze(Object.defineProperty({ __proto__: null, default: B4 }, Symbol.toStringTag, { value: "Module" }));
function $ft(e) {
  return W({ module: "wms", url: `return/application/review/raw-materials/${e}`, method: "get" });
}
function egt(e) {
  return W({ module: "wms", url: "return/application/review/raw-materials/pending/ids", method: "get", params: e });
}
function tgt(e) {
  return W({ module: "wms", url: "return/application/review/raw-materials/returned", method: "put", data: e });
}
function igt(e) {
  return W({ module: "wms", url: "return/application/review/raw-materials/passed", method: "put", data: e });
}
function due(e, o) {
  return W({ url: "/api/v2/wms/return/application/review/raw-materials/sourcingReturnApproval", method: "put", params: e, data: o });
}
function mue(e) {
  return W({ url: "/api/v2/wms/return/review", method: "put", params: e });
}
function pue(e) {
  return W({ url: `/api/v2/wms/return/revocation/${e.id}`, method: "post" });
}
const hue = { style: { "max-height": "200px", overflow: "auto", "min-height": "150px" } }, fue = { key: 1, class: "footer" }, gue = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, componentName: { type: [String, Number], default: void 0 }, journalId: { type: [String, Number], default: void 0 } }, emits: ["auditSuccess"], setup(e, { emit: o }) {
  const n = Z(), c = Z(), u = Z([]), r = Z(), E = Z({}), y = Z(false), b = Z(), V = Z([...Da, ["remark", "empty-text"], ["realTime", "parse-time"]]), { CRUD: M, crud: g, detail: S } = qi(), { baseUnit: h } = ai(), T = o, _ = e, f = Ee(() => {
    switch (S.outboundTypeSelection) {
      case Jt.OUTSOURCE.V:
        return due;
      default:
        return mue;
    }
  }), { maxHeight: m } = Kt({ mainBox: ".raw-mat-return-application-record-detail", extraBox: [".el-drawer__header", ".material-info"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => Ee(() => !g.detailLoading)), R = Ee(() => S && S.serialNumber ? `退库单：${S.serialNumber}` : "退库单");
  M.HOOK.beforeDetailLoaded = async (x, I) => {
    b.value = void 0, r.value = void 0, E.value = {};
    const Y = [], ee = [];
    (I.basicClass === dt.STEEL_PLATE.V || I.basicClass & dt.SECTION_STEEL.V) && await Promise.all(I.list.map(async (q) => {
      if (q.boolReturns && A(q.list)) {
        await Qt(q.list);
        const ae = await returnPhysicalFormat(q.list, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] }), j = q.list.map((oe) => oe.source);
        await Qt(j);
        const le = await returnPhysicalFormat(j, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete", "singleReturnMete"] });
        Y.push(ae), ee.push(le);
      }
    })), await Promise.all(ee), await Promise.all(Y), await Qt(I.list), await returnPhysicalFormat(I.list, { toNum: true });
    const B = I.list.map((q) => q.source);
    await Qt(B), await returnPhysicalFormat(B, { toNum: true }, { mete: ["mete", "returnableMete", "singleMete", "singleReturnableMete"] }), I.list.forEach((q) => {
      q.actualMete = q.mete;
    }), (I.basicClass === dt.STEEL_PLATE.V || I.basicClass === dt.SECTION_STEEL.V) && await Promise.all(I.list.map(async (q) => {
      if (q.uid = q.id, q.boolReturns && A(q.list)) {
        let ae = 0;
        q.list.forEach((j) => {
          j.pid = q.id, j.uid = j.id, j.singleReturnMete && (ae += j.singleReturnMete);
        }), q.detailMete = returnPhysicalRound(ae, h.value[I.basicClass].weight.unit) * (q.quantity || 0), q.actualMete = q.detailMete;
      }
    }));
  };
  function v(x, I, Y) {
    E.value = x, r.value = x.source;
  }
  function N(x) {
    const I = S.basicClass && h.value && h.value[S.basicClass] ? h.value[S.basicClass].measure.precision : 0;
    return Hi(x, { props: [["quantity", I], ["actualMete", ei.weight.precision], "mete"] });
  }
  async function P(x) {
    return x.list = await returnPhysicalFormat(x.list, { toSmallest: true, toNum: true }), x;
  }
  async function L(x) {
    try {
      y.value = true;
      const I = At(S), Y = await P(I);
      if (x === Lt.REFUSE.V && !A(b.value)) {
        ot.error("请输入审批意见");
        return;
      }
      const ee = { approveRecordId: S.approveRecordId, decision: x, opinion: b.value };
      S.outboundTypeSelection === Jt.OUTSOURCE.V ? f.value(ee, Y) : await f.value(ee), T("auditSuccess");
    } catch (I) {
      console.log("退库(审批流)审核提交", I);
    } finally {
      y.value = false;
    }
  }
  async function O(x) {
    x.loading = true;
    try {
      x.wmsApproveFlowDTOS = await Jn(x.approveRecordId);
    } catch (I) {
      console.log(I, "获取失败");
    } finally {
      x.loading = false;
    }
  }
  return (x, I) => {
    const Y = Ve("common-button"), ee = La, B = wi, q = pa, ae = vt, j = Ve("common-table"), le = Mt, oe = Ve("common-drawer"), ye = oi;
    return w(), U(oe, { ref_key: "drawerRef", ref: n, "before-close": l(g).cancelDetail, "content-loading": l(g).detailLoading, "show-close": true, title: R.value, visible: l(g).detailVisible, "custom-class": "raw-mat-return-application-record-detail", size: "100%" }, { titleAfter: p(() => [s(K_, { detail: l(S) }, null, 8, ["detail"])]), titleRight: p(() => {
      var ce;
      return [s(ee, { width: 400, placement: "bottom", trigger: "click", onShow: I[0] || (I[0] = (se) => O(l(S))) }, { reference: p(() => [s(Y, { size: "default" }, { default: p(() => I[5] || (I[5] = [Te("查看审批记录")])), _: 1, __: [5] })]), default: p(() => [qe((w(), Q("div", hue, [s(tl, { data: l(S).wmsApproveFlowDTOS }, null, 8, ["data"])])), [[ye, l(S).loading]])]), _: 1 }), l(A)(l(S).reviewStatus) && l(S).outboundTypeSelection === l(Jt).PRODUCE.V ? (w(), U(B, { key: 0, type: (ce = l(_n).V[l(S).reviewStatus]) == null ? void 0 : ce.TAG, size: "large", style: { "margin-right": "10px" } }, { default: p(() => [Te(K(l(_n).VL[l(S).reviewStatus]), 1)]), _: 1 }, 8, ["type"])) : H("", true), _.ApprovalFlag ? (w(), Q("div", fue, [s(q, { title: "确认通过", onConfirm: I[1] || (I[1] = (se) => L(l(Lt).PASS.V)) }, { reference: p(() => [s(Y, { loading: y.value, class: "filter-item", size: "default", type: "success" }, { default: p(() => I[6] || (I[6] = [Te("通过 ")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 }), s(q, { title: "确认驳回", onConfirm: I[2] || (I[2] = (se) => L(l(Lt).REFUSE.V)) }, { reference: p(() => [s(Y, { loading: y.value, class: "filter-item", size: "default", type: "danger" }, { default: p(() => I[7] || (I[7] = [Te(" 驳回 ")])), _: 1, __: [7] }, 8, ["loading"])]), _: 1 })])) : H("", true)];
    }), content: p(() => [s(gu, { "basic-class": l(S).basicClass, material: r.value, class: "material-info" }, null, 8, ["basic-class", "material"]), s(j, { ref_key: "tableRef", ref: c, data: l(S).list, "data-format": V.value, "expand-row-keys": u.value, "max-height": l(m), "summary-method": N, "default-expand-all": "", "highlight-current-row": "", "row-key": "id", "show-summary": "", onRowClick: v }, { default: p(() => [s(Ha, { "expand-row-keys": u.value, "onUpdate:expandRowKeys": I[3] || (I[3] = (ce) => u.value = ce), data: l(S).list, fixed: "left", "row-key": "id" }, { default: p(({ row: ce }) => [(l(S).basicClass === l(dt).STEEL_PLATE.V || l(S).basicClass === l(dt).SECTION_STEEL.V) && ce.boolReturns ? (w(), U(j, { key: ce.id, class: Zt(E.value.uid === ce.uid ? "child-table" : ""), data: ce.list, stripe: false, style: { margin: "10px 0" } }, { default: p(() => {
      var se, he, be, me;
      return [s(fa, { "basic-class": ce.basicClass, fixed: "left" }, { afterMaterialSn: p(() => [s(ae, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 2 }, 1032, ["basic-class"]), s(Ba, { "basic-class": ce.basicClass }, null, 8, ["basic-class"]), s(ae, { label: `数量 (${(he = (se = l(h)[ce.basicClass]) == null ? void 0 : se.measure) == null ? void 0 : he.unit})`, align: "center", prop: "singleQuantity", width: "110px" }, null, 8, ["label"]), s(ae, { key: "singleReturnMete", label: `总重 (${(me = (be = l(h)[ce.basicClass]) == null ? void 0 : be.weight) == null ? void 0 : me.unit})`, align: "center", prop: "singleReturnMete", width: "120px" }, null, 8, ["label"]), s(xl)];
    }), _: 2 }, 1032, ["class", "data"])) : H("", true), s(Xl, { "basic-class": ce.basicClass, row: ce, "show-batch-no": false, "show-graphics": "", "show-remark": "" }, null, 8, ["basic-class", "row"])]), _: 1 }, 8, ["expand-row-keys", "data"]), s(fa, { "basic-class": l(S).basicClass, showTip: l(S).basicClass === l(dt).STEEL_PLATE.V || l(S).basicClass === l(dt).SECTION_STEEL.V, fixed: "left" }, { afterMaterialSn: p(() => [s(ae, { key: "materialSnNew", "show-overflow-tooltip": true, fixed: "left", label: "材料编码", prop: "materialSnNew", width: "125" })]), _: 1 }, 8, ["basic-class", "showTip"]), s(Ba, { "basic-class": l(S).basicClass }, null, 8, ["basic-class"]), s(Y_, { "basic-class": l(S).basicClass, showTip: l(S).basicClass === l(dt).STEEL_PLATE.V || l(S).basicClass === l(dt).SECTION_STEEL.V }, null, 8, ["basic-class", "showTip"]), s(xl, { "show-area": false, "show-monomer": false, "show-project": "" }), s(Vr, { label: "实际退库时间" })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), _.ApprovalFlag ? (w(), U(le, { key: 0, modelValue: b.value, "onUpdate:modelValue": I[4] || (I[4] = (ce) => b.value = ce), rows: 2, class: "approval-comments", maxlength: "1000", placeholder: "审核意见", "show-word-limit": "", style: { "margin-top": "5px" }, type: "textarea" }, null, 8, ["modelValue"])) : H("", true)]), _: 1 }, 8, ["before-close", "content-loading", "title", "visible"]);
  };
} }, H4 = ut(gue, [["__scopeId", "data-v-a6b99170"]]), Eue = Object.freeze(Object.defineProperty({ __proto__: null, default: H4 }, Symbol.toStringTag, { value: "Module" }));
function q4(e) {
  return W({ module: "wms", url: "return/application/steel-plate", method: "post", data: e });
}
function G4(e) {
  return W({ module: "wms", url: "return/application/section-steel", method: "post", data: e });
}
function Q4(e) {
  return W({ module: "wms", url: "return/application/steel-coil", method: "post", data: e });
}
function Z4(e) {
  return W({ module: "wms", url: "return/application/auxiliary-material", method: "post", data: e });
}
