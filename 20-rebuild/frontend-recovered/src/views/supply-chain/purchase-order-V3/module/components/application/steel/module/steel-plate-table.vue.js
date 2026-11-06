import { inject as k } from "vue";
import { computed as Ve } from "vue";
import { resolveComponent as v } from "vue";
import { resolveDirective as Te } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as Ue } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { unref as a } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as We } from "vue";
import { createElementVNode as R } from "vue";
import { toDisplayString as ke } from "vue";
import { normalizeClass as Ce } from "vue";
import { mergeProps as Ie } from "vue";
import { isRef as D } from "vue";
import { Fragment as xe } from "vue";
import { reactive as Ne } from "vue";
import { watchEffect as Pe } from "vue";
import { watch as C } from "vue";
import { ElTableColumn as Se } from "element-plus";
import { ElTooltip as qe } from "element-plus";
import { Edit as Re } from "@element-plus/icons-vue";
import { ElInput as De } from "element-plus";
import { am as je, sQ as Le, v7 as j, v8 as Be, v5 as Fe, uY as $e, fE as I, fv as Ee, v6 as Ae, i as f, iX as V, D as L, aw as Oe, aI as ze, sT as Me, b as B } from "../../../../../../../../shared/runtime.js";
import { u as Ye, _ as we } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const Ge = { __name: "steel-plate-table", setup(He, { expose: F }) {
  var q;
  const $ = je.STEEL_PLATE.V, x = k("matSpecRef"), n = (q = k("cu")) == null ? void 0 : q.form, p = k("cu");
  function E({ row: e, rowIndex: i }) {
    var l, d, u;
    if ((d = (l = p == null ? void 0 : p.submitResult) == null ? void 0 : l.data) != null && d.includes(e.classifyId) && ((u = p == null ? void 0 : p.submitResult) == null ? void 0 : u.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const { baseUnit: r } = Le($), { overDiffTip: A, weightOverDiff: O } = j(r, { cfgType: "purchase", weightField: "weighingTotalWeight", compareWeightField: "purchaseTotalWeight", weightTip: "申购重量" }), { overDiffTip: z, weightOverDiff: M, diffSubmitValidate: Y } = j(r), { specSelectMaxHeight: w, specRef: H, drawerRef: K, editRow: Q, editList: T, materialSelectVisible: y, handleClickEditSpec: X, handleSpecChange: G } = Be(), J = (e, i) => f(i.weighingTotalWeight) && f(i.unitPrice) ? +V(i.weighingTotalWeight * i.unitPrice, L.YUAN) == +e : false, Z = (e, i) => n.level === I.FACTORY.V ? !!e : true, _ = (e, i) => f(e) ? e > 0 : true, ee = (e, i) => f(e) ? e >= 0 : true, te = (e, i) => f(i.purchaseSN) ? !!e : Y(e, i), ae = Ve(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ validator: _, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: _, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: te, message: "超出误差允许范围,不可提交", trigger: "blur" }, { validator: _, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: _, message: "长度必须大于0", trigger: "blur" }], quantity: [{ validator: ee, message: "数量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: J, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: Z, message: "请选择工厂", trigger: "blur" }] })), ie = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: le, wrongCellMask: ne, cleanUpData: se } = Oe({ rules: ae, errorMsg: "请修正【钢板清单】中标红的信息", ditto: ie });
  function oe(e) {
    const i = Ne({ uid: ze(), sn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, quantity: void 0, thickness: void 0, length: void 0, width: void 0, theoryWeight: void 0, theoryTotalWeight: void 0, weighingTotalWeight: void 0, projectId: n.steelPlateList.length > 0 ? -1 : void 0 });
    return P(i), i;
  }
  const { projectAllType: ce } = Fe();
  function re(e) {
    const i = ce.value.find((l) => l.id === e.projectId);
    e.project = i;
  }
  const { factories: de } = Ye();
  function N(e) {
    const i = de.value.find((l) => l.id === e.factoryId);
    e.factoryDTO = i;
  }
  function P(e) {
    Pe(() => {
      N(e), e.purchaseSN ? O(e) : M(e);
    }), C([() => e.length, () => e.width, () => e.thickness, r], () => ue(e)), C([() => e.theoryWeight, () => e.quantity], () => {
      fe(e);
    }), C(() => e.weighingTotalWeight, () => {
      me(e);
    });
  }
  async function ue(e) {
    e.theoryWeight = await Me({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function fe(e) {
    f(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = V(e.theoryWeight * e.quantity, r.value.weight.precision), e.weighingTotalWeight = V(e.theoryWeight * e.quantity, r.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.isFirst || (e.weighingTotalWeight = void 0)), e.isFirst = false;
  }
  function me(e) {
    f(e.unitPrice) && f(e.weighingTotalWeight) ? e.amount = V(e.weighingTotalWeight * e.unitPrice, L.YUAN) : e.amount = void 0;
  }
  function pe(e, i, l) {
    if (l.purchaseSN) {
      n.steelPlateList.splice(i, 1);
      const d = ["list", "originList"];
      for (let u = 0; u < d.length; u++) if (f(n[d[u]])) {
        const m = n[d[u]].findIndex((U) => U.id === l.id);
        m > -1 && n[d[u]].splice(m, 1);
      }
    } else x.value ? x.value.delListItem(e, i) : n.steelPlateList.splice(i, 1);
  }
  function ge() {
    const e = n.steelPlateList.filter((l) => true);
    if (B(e)) return true;
    const { validResult: i } = le(e);
    return i && S(e), i;
  }
  function S(e) {
    se(e), e.forEach((i, l) => {
      n.steelPlateList[l].projectId = i.projectId;
    });
  }
  function he() {
    if (B(n.steelPlateList)) return true;
    const e = n.steelPlateList.filter((i) => true);
    S(e);
  }
  return F({ rowInit: oe, rowWatch: P, validate: ge, TSValidate: he }), (e, i) => {
    const l = Se, d = qe, u = Re, m = v("common-input-number"), U = De, be = v("common-button"), ye = v("common-table"), _e = v("common-drawer"), ve = Te("empty-text");
    return g(), Ue(xe, null, [s(ye, Ie({ "cell-class-name": a(ne), data: a(n).steelPlateList, "row-style": E, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [s(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), a(n).useRequisitions ? (g(), h(l, { key: 0, align: "center", fixed: "left", label: "申购单号", prop: "purchaseSN", width: "140" })) : b("", true), s(l, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(l, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [s(d, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [We(R("span", null, null, 512), [[ve, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(l, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [a(n).boolUsed ? b("", true) : (g(), h(u, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (o) => a(X)(t) }, null, 8, ["onClick"])), s(d, { content: t.specificationLabels, placement: "top" }, { default: c(() => [R("span", null, ke(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(l, { label: `厚 (${a(r).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: c(({ row: t }) => [s(m, { modelValue: t.thickness, "onUpdate:modelValue": (o) => t.thickness = o, controls: false, disabled: !!a(n).boolUsed, max: 999999, min: 0, precision: a(r).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(l, { label: `宽 (${a(r).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: c(({ row: t }) => [s(m, { modelValue: t.width, "onUpdate:modelValue": (o) => t.width = o, controls: false, disabled: !!a(n).boolUsed, max: 999999, min: 0, precision: a(r).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(l, { label: `长 (${a(r).length.unit})`, align: "center", "min-width": "120", prop: "length" }, { default: c(({ row: t }) => [s(m, { modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, disabled: !!a(n).boolUsed, max: 999999999, min: 0, precision: a(r).length.precision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(l, { label: `数量 (${a(r).measure.unit})`, align: "center", "min-width": "120", prop: "quantity" }, { default: c(({ row: t }) => [s(m, { modelValue: t.quantity, "onUpdate:modelValue": (o) => t.quantity = o, controls: false, disabled: !!a(n).boolUsed, max: 999999999, min: 0, precision: a(r).measure.precision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(l, { key: "weighingTotalWeight", label: `总重 (${a(r).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => [s(d, { content: t.purchaseSN ? `申购重量：${t.purchaseTotalWeight} kg， ${a(A)}` : `理论重量：${t.theoryTotalWeight} kg， ${a(z)}`, disabled: !t.hasOver, class: "item", effect: "dark", placement: "top" }, { default: c(() => [s(m, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, class: Ce({ "over-weight-tip": t.hasOver }), controls: false, disabled: !!a(n).boolUsed, max: 999999999, min: 0, precision: a(r).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "disabled", "precision"])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }, 8, ["label"]), s($e), s(l, { align: "center", label: "品牌", prop: "brand" }, { default: c(({ row: t }) => [s(U, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(n).level === a(I).FACTORY.V ? (g(), h(l, { key: 1, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: c(({ row: t, $index: o }) => [s(a(Ee), { modelValue: t.projectId, "onUpdate:modelValue": (W) => t.projectId = W, branchCompanyId: a(n).branchCompanyId, disabled: !!a(n).boolUsed, projectAttribute: a(n).projectAttribute, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (W) => re(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : b("", true), a(n).level === a(I).FACTORY.V ? (g(), h(l, { key: 2, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: c(({ row: t }) => [s(we, { modelValue: t.factoryId, "onUpdate:modelValue": (o) => t.factoryId = o, disabled: !!a(n).boolUsed, placeholder: "选择工厂", onChange: (o) => N(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : b("", true), a(n).boolUsed ? b("", true) : (g(), h(l, { key: 3, align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: o }) => [s(be, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (W) => pe(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]), s(_e, { ref_key: "drawerRef", ref: K, modelValue: a(y), "onUpdate:modelValue": i[1] || (i[1] = (t) => D(y) ? y.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢材规格选择" }, { content: c(() => [s(Ae, { ref_key: "specRef", ref: H, modelValue: a(T), "onUpdate:modelValue": i[0] || (i[0] = (t) => D(T) ? T.value = t : null), classifyId: a(Q).classifyId, "max-height": a(w), "show-classify": false, visible: a(y), "expand-query": "", mode: "selector", onChange: a(G) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Ge as default
};
