import { ref as I } from "vue";
import { watch as ae } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as s } from "vue";
import { createBlock as g } from "vue";
import { withCtx as c } from "vue";
import { unref as i } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as M } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as H } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as d } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as C } from "vue";
import { isRef as te } from "vue";
import { ElNotification as le } from "element-plus";
import { ElDescriptionsItem as ne } from "element-plus";
import { ElDescriptions as ce } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElTooltip as ue } from "element-plus";
import { vLoading as oe } from "element-plus";
import { d as se } from "../../../../../modules/outsourcing-receiving-3624908c.js";
import { m as me, u as de, cO as re, o as pe, G as q, p as ye, pz as ge, pA as fe, tV as E, i as h, b as O, jl as be, tW as R, c as P } from "../../../../../shared/runtime.js";
import { u as he } from "../../../../../modules/use-table-row-validate-5799de49.js";
const Ve = { class: "head-container" }, _e = { key: 0 }, Qe = { __name: "receive-confirm-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, summaryList: { type: Array, default: () => [] }, currentProductType: { type: Number }, contractId: { type: Number } }, emits: ["update:modelValue", "success"], setup(r, { emit: S }) {
  const { user: G } = me(["user"]), A = S, b = r, p = I([]), z = I(), B = I(false), { visible: k, handleClose: L } = de({ emit: A, props: b }), { tableValidate: W, wrongCellMask: X } = he({ rules: (n) => n.tableRules });
  ae(k, async (n) => {
    n && (p.value = b.summaryList, re(p.value));
  });
  const { maxHeight: Y } = pe({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: false, extraHeight: 90, navbar: false, clientHRepMainH: true }, z);
  function $(n) {
    p.value.splice(n, 1), A("success");
  }
  function J(n, o) {
    n.selectQuantity = o, n.actualMete = n.selectQuantity * (n.mete / n.quantity);
  }
  function T(n, o) {
    n.selectQuantity = o, n.manuActualMete = (n.selectQuantity * (n.mete / n.quantity)).toFixed(2);
  }
  function K(n, o) {
    n.actualMete = o;
  }
  function x(n, o) {
    n.manuActualMete = o;
  }
  async function Z() {
    var o, V;
    const { validResult: n } = W(p.value);
    if (n) try {
      p.value = await be(p.value, { toSmallest: true, toNum: true }, { mete: ["canReceivedMete", "selectCanReceivedMete", "mete", "actualMete"], quantity: ["canReceivedQuantity", "quantity", "selectQuantity"] });
      const y = (o = p.value) == null ? void 0 : o.map((t) => {
        var U, m;
        return { detailId: t.detailId, receivedQuantity: ((U = b.detailInfo) == null ? void 0 : U.materialType) === 96 ? t.selectQuantity : h(t.accountingUnit) && O(t.measureUnit) ? t.actualMete : t.selectQuantity, actualReceivedMete: ((m = b.detailInfo) == null ? void 0 : m.materialType) !== 96 ? t.actualMete : t.wageQuotaType === R.WEIGHT.V ? P(t.manuActualMete, "kg", "g") : t.wageQuotaType === R.LENGTH.V ? P(t.manuActualMete, "m", "mm") : t.wageQuotaType === R.QUANTITY.V ? t.manuActualMete : t.wageQuotaType === R.AREA.V ? P(t.manuActualMete, "m²", "mm²") : t.manuActualMete };
      }), N = { projectId: (V = b.globalProject) == null ? void 0 : V.id, contractId: b.contractId, receiveDTOParam: y };
      await se(N), le({ title: "收货成功", type: "success" }), A("success"), L();
    } catch (y) {
      console.log("确认收货失败", y);
    }
  }
  return (n, o) => {
    const V = Q("common-button"), y = ne, N = ce, t = ie, U = ue, m = Q("common-input-number"), w = Q("common-table"), ee = Q("common-drawer"), j = oe;
    return s(), g(ee, { ref_key: "drawerRef", ref: z, title: "收货明细", "close-on-click-modal": false, modelValue: i(k), "onUpdate:modelValue": o[0] || (o[0] = (u) => te(k) ? k.value = u : null), direction: "rtl", "before-close": i(L), size: "70%" }, { titleRight: c(() => {
      var u;
      return [i(q)(r.permission.confirm) ? (s(), g(V, { key: 0, type: "success", size: "default", disabled: !((u = p.value) != null && u.length), onClick: F(Z, ["stop"]) }, { default: c(() => o[1] || (o[1] = [_("确认收货")])), _: 1, __: [1] }, 8, ["disabled"])) : M("", true)];
    }), content: c(() => [f("div", Ve, [H((s(), g(N, { column: 2, border: "" }, { default: c(() => [l(y, { align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: c(() => {
      var u;
      return [_(d((u = r.detailInfo) == null ? void 0 : u.projectName), 1)];
    }), _: 1 }), l(y, { align: "center", "label-class-name": "contractLabel", label: "供应商" }, { default: c(() => {
      var u;
      return [_(d((u = r.detailInfo) == null ? void 0 : u.supplierName), 1)];
    }), _: 1 }), l(y, { align: "center", "label-class-name": "contractLabel", label: "收货人" }, { default: c(() => {
      var u;
      return [_(d((u = i(G)) == null ? void 0 : u.name), 1)];
    }), _: 1 }), l(y, { align: "center", "label-class-name": "contractLabel", label: "收货日期" }, { default: c(() => [_(d(i(ye)((/* @__PURE__ */ new Date()).getTime(), "{y}-{m}-{d}") || "-"), 1)]), _: 1 })]), _: 1 })), [[j, B.value]])]), H((s(), g(w, { data: p.value, "return-source-data": "", "show-empty-symbol": false, "max-height": i(Y), "cell-class-name": i(X) }, { default: c(() => {
      var u, D;
      return [l(t, { label: "序号", type: "index", align: "center", width: "60" }), ((u = r.detailInfo) == null ? void 0 : u.materialType) === 96 ? (s(), g(t, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: c(({ row: e }) => {
        var a;
        return [f("span", null, d(((a = e.monomer) == null ? void 0 : a.name) || "-"), 1)];
      }), _: 1 })) : M("", true), ((D = r.detailInfo) == null ? void 0 : D.materialType) === 96 ? (s(), g(t, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: c(({ row: e }) => {
        var a;
        return [f("span", null, d(((a = e.area) == null ? void 0 : a.name) || "-"), 1)];
      }), _: 1 })) : M("", true), l(t, { key: "name", prop: "name", label: "名称", align: "center" }), l(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), l(t, { key: "specification", prop: "specification", label: "规格", align: "center" }, { default: c(({ row: e }) => [l(U, { content: i(ge)(e), placement: "left" }, { default: c(() => [f("span", null, d(i(fe)(e)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), r.currentProductType === i(E).STRUC_MANUFACTURED.V ? (s(), v(C, { key: 2 }, [l(t, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), l(t, { key: "material", prop: "material", label: "材质", align: "center" }), l(t, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.selectQuantity, "onUpdate:modelValue": (a) => e.selectQuantity = a, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (a) => T(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(t, { key: "canReceivedMete", prop: "canReceivedMete", label: "重量（kg）", align: "center" }), l(t, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.manuActualMete, "onUpdate:modelValue": (a) => e.manuActualMete = a, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (a) => x(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : r.currentProductType === i(E).ENCL_MANUFACTURED.V ? (s(), v(C, { key: 3 }, [l(t, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), l(t, { key: "selectQuantity", prop: "selectQuantity", label: "数量（张）", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.selectQuantity, "onUpdate:modelValue": (a) => e.selectQuantity = a, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (a) => T(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), l(t, { key: "canReceivedMete", prop: "canReceivedMete", label: "总量（m）", align: "center" }), l(t, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.manuActualMete, "onUpdate:modelValue": (a) => e.manuActualMete = a, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (a) => x(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : r.currentProductType === i(E).AUX_MANUFACTURED.V ? (s(), v(C, { key: 4 }, [l(t, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.selectQuantity, "onUpdate:modelValue": (a) => e.selectQuantity = a, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (a) => T(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), l(t, { key: "canReceivedMete", prop: "canReceivedMete", label: "总量", align: "center" }), l(t, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.manuActualMete, "onUpdate:modelValue": (a) => e.manuActualMete = a, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (a) => x(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : (s(), v(C, { key: 5 }, [l(t, { key: "canReceivedQuantity", prop: "canReceivedQuantity", label: "数量", align: "center" }, { default: c(({ row: e }) => {
        var a;
        return [f("span", null, d(((a = e.canReceivedQuantity) == null ? void 0 : a.toFixed(+e.measurePrecision)) || "-"), 1), f("span", null, d(e.measureUnit || ""), 1)];
      }), _: 1 }), l(t, { key: "canReceivedMete", prop: "canReceivedMete", label: "核算量", align: "center" }, { default: c(({ row: e }) => {
        var a;
        return [f("span", null, d(((a = e.canReceivedMete) == null ? void 0 : a.toFixed(+e.accountingPrecision)) || "-"), 1), f("span", null, d(e.accountingUnit || ""), 1)];
      }), _: 1 }), l(t, { key: "selectQuantity", prop: "selectQuantity", label: "实收数量", align: "center" }, { default: c(({ row: e }) => [i(h)(e.accountingUnit) && i(O)(e.measureUnit) ? (s(), v("span", _e, "-")) : i(h)(e.accountingUnit) && i(h)(e.measureUnit) ? (s(), g(m, { key: 1, modelValue: e.selectQuantity, "onUpdate:modelValue": (a) => e.selectQuantity = a, controls: false, min: 0, max: e.canReceivedQuantity, precision: +e.measurePrecision, size: "default", clearable: "", placeholder: "实收数量", style: { width: "100%" }, onChange: (a) => J(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : M("", true)]), _: 1 }), l(t, { key: "actualMete", prop: "actualMete", label: "实收量", align: "center" }, { default: c(({ row: e }) => [l(m, { modelValue: e.actualMete, "onUpdate:modelValue": (a) => e.actualMete = a, controls: false, min: 0, precision: +e.accountingPrecision, size: "default", clearable: "", disabled: !!(i(h)(e.accountingUnit) && i(h)(e.measureUnit) && e.accountingUnit === e.measureUnit), placeholder: "实收量", style: { width: "100%" }, onChange: (a) => K(e, a) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "disabled", "onChange"])]), _: 1 })], 64)), i(q)(r.permission.del) ? (s(), g(t, { key: 6, label: "操作", width: "80", align: "center" }, { default: c(({ $index: e }) => [l(V, { size: "default", icon: "el-icon-delete", type: "danger", onClick: F((a) => $(e), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : M("", true)];
    }), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[j, B.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Qe as default
};
