import { inject as I } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as me } from "vue";
import { createVNode as s } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as fe } from "vue";
import { createElementVNode as j } from "vue";
import { unref as l } from "vue";
import { createBlock as V } from "vue";
import { createCommentVNode as C } from "vue";
import { toDisplayString as pe } from "vue";
import { mergeProps as ge } from "vue";
import { isRef as B } from "vue";
import { Fragment as he } from "vue";
import { reactive as be } from "vue";
import { watchEffect as ye } from "vue";
import { watch as k } from "vue";
import { ElTableColumn as _e } from "element-plus";
import { ElTooltip as Ve } from "element-plus";
import { Edit as Ce } from "@element-plus/icons-vue";
import { ElInput as ve } from "element-plus";
import { am as Ue, sQ as Ie, v4 as ke, v5 as Te, uY as xe, fE as T, fv as Le, v6 as Ne, aw as Se, aI as Re, va as je, i as g, b as w, uZ as Be, iX as we, D as Pe } from "../../../../../../../../shared/runtime.js";
import { u as Fe, _ as Ee } from "../../../../../../../../modules/factory-select-b8d0a4ac.js";
const Me = { __name: "steel-coil-table", setup(We, { expose: P }) {
  var R;
  const F = Ue.STEEL_COIL.V, f = I("cu");
  function E({ row: e, rowIndex: a }) {
    var n, d, r;
    if ((d = (n = f == null ? void 0 : f.submitResult) == null ? void 0 : n.data) != null && d.includes(e.classifyId) && ((r = f == null ? void 0 : f.submitResult) == null ? void 0 : r.code) === 40206) return { backgroundColor: "#ffdede" };
  }
  const W = (e, a) => g(a.weighingTotalWeight) && g(a.unitPrice) ? +we(a.weighingTotalWeight * a.unitPrice, Pe.YUAN) == +e : false, q = (e, a) => i.level === T.FACTORY.V ? !!e : true, h = (e, a) => g(e) ? e > 0 : true, A = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], width: [{ validator: h, message: "宽度必须大于0", trigger: "blur" }], thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }, { validator: h, message: "厚度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { validator: h, message: "重量必须大于0", trigger: "blur" }], length: [{ validator: h, message: "长度必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: W, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: q, message: "请选择工厂", trigger: "blur" }] }, x = I("matSpecRef"), i = (R = I("cu")) == null ? void 0 : R.form, { baseUnit: u } = Ie(F), { handleMeteChangeCalcPrice: D } = Be("weighingTotalWeight"), M = /* @__PURE__ */ new Map([["projectId", -1]]), { tableValidate: $, wrongCellMask: z, cleanUpData: O } = Se({ rules: A, errorMsg: "请修正【钢卷清单】中标红的信息", ditto: M }), { specSelectMaxHeight: Y, specRef: H, drawerRef: K, editRow: Q, editList: v, materialSelectVisible: b, handleClickEditSpec: X, handleSpecChange: Z } = ke();
  function G(e) {
    const a = be({ uid: Re(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullName: e.classify.fullName, classifySerialNumber: e.classify.serialNumber, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, quantity: void 0, color: void 0, brand: void 0, thickness: void 0, length: void 0, width: void 0, theoryLength: void 0, weighingTotalWeight: void 0, projectId: i.steelCoilList.length > 0 ? -1 : void 0 });
    return L(a), a;
  }
  function L(e) {
    ye(() => {
      S(e);
    }), k([() => e.weighingTotalWeight, () => e.width, () => e.thickness, u], () => J(e)), k([() => e.weighingTotalWeight], () => D(e)), k([() => e.theoryLength], () => ee(e)), e.isFirst = false;
  }
  async function J(e) {
    e.theoryLength = await je({ classifyId: e.classifyId, name: e.classifyFullName, weight: e.weighingTotalWeight, width: e.width, thickness: e.thickness });
  }
  function ee(e) {
    g(e.theoryLength) ? e.length = e.theoryLength * 1 : e.isFirst || (e.length = void 0);
  }
  function te(e, a, n) {
    if (n.purchaseSN) {
      i.steelCoilList.splice(a, 1);
      const d = ["list", "originList"];
      for (let r = 0; r < d.length; r++) if (g(i[d[r]])) {
        const m = i[d[r]].findIndex((y) => y.id === n.id);
        m > -1 && i[d[r]].splice(m, 1);
      }
    } else x.value ? x.value.delListItem(e, a) : i.steelCoilList.splice(a, 1);
  }
  function le() {
    const e = i.steelCoilList.filter((n) => true);
    if (w(e)) return true;
    const { validResult: a } = $(e);
    return a && N(e), a;
  }
  function N(e) {
    O(e), e.forEach((a, n) => {
      i.steelCoilList[n].projectId = a.projectId, i.steelCoilList[n].quantity = a.length;
    });
  }
  const { projectAllType: ae } = Te();
  function ie(e) {
    const a = ae.value.find((n) => n.id === e.projectId);
    e.project = a;
  }
  const { factories: ne } = Fe();
  function S(e) {
    const a = ne.value.find((n) => n.id === e.factoryId);
    e.factoryDTO = a;
  }
  function se() {
    if (w(i.steelCoilList)) return true;
    const e = i.steelCoilList.filter((a) => true);
    N(e);
  }
  return P({ rowInit: G, rowWatch: L, validate: le, TSValidate: se }), (e, a) => {
    const n = _e, d = Ve, r = Ce, m = _("common-input-number"), y = ve, oe = _("common-button"), ce = _("common-table"), de = _("common-drawer"), re = ue("empty-text");
    return p(), me(he, null, [s(ce, ge({ "cell-class-name": l(z), data: l(i).steelCoilList, "row-style": E, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [s(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), s(n, { align: "center", fixed: "left", label: "编号", prop: "serialNumber" }), s(n, { align: "center", fixed: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [s(d, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: c(() => [fe(j("span", null, null, 512), [[re, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(n, { align: "center", fixed: "left", label: "型号", prop: "specification", "show-overflow-tooltip": "" }, { default: c(({ row: t }) => [l(i).boolUsed ? C("", true) : (p(), V(r, { key: 0, class: "el-icon", style: { color: "#1881ef", "vertical-align": "middle", "margin-right": "5px", cursor: "pointer" }, onClick: (o) => l(X)(t) }, null, 8, ["onClick"])), s(d, { content: t.specificationLabels, placement: "top" }, { default: c(() => [j("span", null, pe(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), s(n, { key: "weighingTotalWeight", label: `总重 (${l(u).weight.unit})`, align: "center", "min-width": "135", prop: "weighingTotalWeight" }, { default: c(({ row: t }) => [s(m, { modelValue: t.weighingTotalWeight, "onUpdate:modelValue": (o) => t.weighingTotalWeight = o, controls: false, disabled: !!l(i).boolUsed, max: 999999999, min: 0, precision: l(u).weight.precision, "controls-position": "right", placeholder: "重量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(n, { label: `厚 (${l(u).thickness.unit})`, align: "center", "min-width": "120", prop: "thickness" }, { default: c(({ row: t }) => [s(m, { modelValue: t.thickness, "onUpdate:modelValue": (o) => t.thickness = o, controls: false, disabled: !!l(i).boolUsed, max: 999999, min: 0, precision: l(u).thickness.precision, "controls-position": "right", placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(n, { label: `宽 (${l(u).width.unit})`, align: "center", "min-width": "120", prop: "width" }, { default: c(({ row: t }) => [s(m, { modelValue: t.width, "onUpdate:modelValue": (o) => t.width = o, controls: false, disabled: !!l(i).boolUsed, max: 999999, min: 0, precision: l(u).width.precision, "controls-position": "right", placeholder: "宽", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }, 8, ["label"]), s(n, { label: "长 (m)", align: "center", "min-width": "120", prop: "length" }, { default: c(({ row: t }) => [s(m, { modelValue: t.length, "onUpdate:modelValue": (o) => t.length = o, controls: false, disabled: !!l(i).boolUsed, max: 999999999, min: 0, precision: t.measurePrecision, placeholder: "长", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "precision"])]), _: 1 }), s(xe), s(n, { align: "center", label: "颜色", prop: "color" }, { default: c(({ row: t }) => [s(y, { modelValue: t.color, "onUpdate:modelValue": (o) => t.color = o, modelModifiers: { trim: true }, disabled: !!l(i).boolUsed, maxlength: "20", placeholder: "颜色", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), s(n, { align: "center", label: "品牌", prop: "brand" }, { default: c(({ row: t }) => [s(y, { modelValue: t.brand, "onUpdate:modelValue": (o) => t.brand = o, modelModifiers: { trim: true }, disabled: !!l(i).boolUsed, maxlength: "60", placeholder: "品牌", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), l(i).level === l(T).FACTORY.V ? (p(), V(n, { key: 0, align: "center", label: "所属项目", "min-width": "180px", prop: "projectId" }, { default: c(({ row: t, $index: o }) => [s(l(Le), { modelValue: t.projectId, "onUpdate:modelValue": (U) => t.projectId = U, branchCompanyId: l(i).branchCompanyId, disabled: !!l(i).boolUsed, projectAttribute: l(i).projectAttribute, "show-extra": o !== 0, class: "filter-item", clearable: "", placeholder: "可选择项目搜索", style: { width: "100%" }, onChange: (U) => ie(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "branchCompanyId", "disabled", "projectAttribute", "show-extra", "onChange"])]), _: 1 })) : C("", true), l(i).level === l(T).FACTORY.V ? (p(), V(n, { key: 1, align: "center", label: "所属工厂", prop: "factoryId", width: "140px" }, { default: c(({ row: t }) => [s(Ee, { modelValue: t.factoryId, "onUpdate:modelValue": (o) => t.factoryId = o, disabled: !!l(i).boolUsed, placeholder: "选择工厂", onChange: (o) => S(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onChange"])]), _: 1 })) : C("", true), l(i).boolUsed ? C("", true) : (p(), V(n, { key: 2, align: "center", fixed: "right", label: "操作", width: "70" }, { default: c(({ row: t, $index: o }) => [s(oe, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (U) => te(t.sn, o, t) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 16, ["cell-class-name", "data"]), s(de, { ref_key: "drawerRef", ref: K, modelValue: l(b), "onUpdate:modelValue": a[1] || (a[1] = (t) => B(b) ? b.value = t : null), "show-close": true, size: 900, "custom-class": "material-spec-select", title: "钢卷选择" }, { content: c(() => [s(Ne, { ref_key: "specRef", ref: H, modelValue: l(v), "onUpdate:modelValue": a[0] || (a[0] = (t) => B(v) ? v.value = t : null), classifyId: l(Q).classifyId, "max-height": l(Y), "show-classify": false, visible: l(b), "expand-query": "", mode: "selector", onChange: l(Z) }, null, 8, ["modelValue", "classifyId", "max-height", "visible", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  Me as default
};
