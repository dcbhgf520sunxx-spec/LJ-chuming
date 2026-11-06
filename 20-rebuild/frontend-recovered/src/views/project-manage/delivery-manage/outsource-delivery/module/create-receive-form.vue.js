import { ref as y } from "vue";
import { watch as Ve } from "vue";
import { computed as Ue } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as c } from "vue";
import { createBlock as V } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as l } from "vue";
import { withKeys as P } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as k } from "vue";
import { withModifiers as D } from "vue";
import { createTextVNode as S } from "vue";
import { withDirectives as Me } from "vue";
import { toDisplayString as C } from "vue";
import { createElementBlock as R } from "vue";
import { Fragment as F } from "vue";
import { isRef as Ce } from "vue";
import { ElInput as _e } from "element-plus";
import { ElBadge as ke } from "element-plus";
import { ElTableColumn as Re } from "element-plus";
import { ElTooltip as Ae } from "element-plus";
import { vLoading as Qe } from "element-plus";
import { a as xe, b as Ie } from "../../../../../modules/outsourcing-receiving-3624908c.js";
import { u as Te, o as Ne, tV as f, G as W, pz as ze, pA as Ee, i as A, b as Y, jl as Pe, cO as De, c9 as T } from "../../../../../shared/runtime.js";
import { u as Fe } from "../../../../../modules/use-table-row-validate-5799de49.js";
import { s as je } from "../../../../../modules/index-8edb1b61.js";
import qe from "./receive-confirm-form.vue.js";
const Be = { class: "head-container" }, Le = { style: { "margin-bottom": "8px" } }, Se = { key: 0 }, He = { key: 1, class: "red-tip", style: { "font-size": "14px" } }, Ye = { __name: "create-receive-form", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(_, { emit: Z }) {
  const H = Z, K = _, N = y([]), O = y(), w = y(false), Q = y([]), m = y([]), j = y(false), d = y(), x = y({}), r = y({ supplierId: void 0, contractId: void 0 }), p = y({ name: void 0, serialNumber: void 0, material: void 0, specification: void 0 }), { visible: z, handleClose: ee } = Te({ emit: H, props: K });
  Ve(() => z.value, (n) => {
    r.value = {}, m.value = [], Q.value = [];
  }, { immediate: true });
  const ae = { selectQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }], actualMete: [{ required: true, message: "请填写实收量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }] }, te = { actualMete: [{ required: true, message: "请填写实收量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }] }, le = { selectQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }], manuActualMete: [{ required: true, message: "请填写实收量", trigger: "blur" }, { pattern: T, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: ne, wrongCellMask: ie } = Fe({ rules: (n) => n.tableRules }), { maxHeight: ue } = Ne({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: false, extraHeight: 90, navbar: false, clientHRepMainH: true }, O), oe = Ue(() => {
    var n;
    return (n = m.value) == null ? void 0 : n.map((a) => a.detailId);
  });
  function se(n, a) {
    n.selectQuantity = a, n.actualMete = n.selectQuantity * (n.mete / n.quantity);
  }
  function q(n, a) {
    n.selectQuantity = a, n.manuActualMete = (n.selectQuantity * (n.mete / n.quantity)).toFixed(2);
  }
  function ce(n, a) {
    n.actualMete = a;
  }
  function B(n, a) {
    n.manuActualMete = a;
  }
  async function re() {
    var n;
    if (!r.value.supplierId) {
      r.value.contractId = void 0, m.value = [];
      return;
    }
    try {
      const a = await xe({ supplierId: r.value.supplierId, projectId: (n = K.globalProject) == null ? void 0 : n.id });
      Q.value = a || [];
    } catch (a) {
      console.log(a, "获取采购合同号列表失败");
    }
  }
  async function b() {
    if (r.value.contractId) try {
      const n = await Ie({ contractId: r.value.contractId, ...p.value });
      N.value = n || [], N.value.forEach(async (a) => {
        var U;
        a.selectQuantity = a.canReceivedQuantity, a.actualMete = a.canReceivedMete, a.manuActualMete = a.canReceivedMete, a.tableRules = ((U = x.value) == null ? void 0 : U.materialType) === 96 ? le : A(a.accountingUnit) && Y(a.measureUnit) ? te : ae, d.value !== f.STRUC_MANUFACTURED.V && d.value !== f.ENCL_MANUFACTURED.V && d.value !== f.AUX_MANUFACTURED.V && await Pe(a, { toNum: true }, { mete: ["canReceivedMete", "selectCanReceivedMete", "mete", "actualMete"], quantity: ["canReceivedQuantity", "quantity", "selectQuantity"] });
      }), De(N.value);
    } catch (n) {
      console.log(n, "获取采购合同号列表失败");
    }
  }
  async function de(n) {
    var a, U, M;
    m.value = [], d.value = (U = (a = Q.value) == null ? void 0 : a.find((v) => v.id === n)) == null ? void 0 : U.basicClass, x.value = (M = Q.value) == null ? void 0 : M.find((v) => v.id === n), await b();
  }
  function me() {
    p.value = {}, b();
  }
  function pe(n) {
    const { validResult: a } = ne([n]);
    a && m.value.push(n);
  }
  async function ye() {
    m.value = [], await b(), H("success");
  }
  return (n, a) => {
    const U = I("common-select"), M = _e, v = I("common-button"), ge = ke, i = Re, fe = Ae, h = I("common-input-number"), be = I("common-table"), ve = I("common-drawer"), he = Qe;
    return c(), V(ve, { ref_key: "drawerRef", ref: O, title: "创建收货", "close-on-click-modal": false, modelValue: o(z), "onUpdate:modelValue": a[8] || (a[8] = (E) => Ce(z) ? z.value = E : null), direction: "rtl", "before-close": o(ee), size: "70%" }, { content: u(() => {
      var E, X, $, G;
      return [g("div", Be, [g("div", Le, [l(je, { modelValue: r.value.supplierId, "onUpdate:modelValue": a[0] || (a[0] = (s) => r.value.supplierId = s), class: "input-underline", clearable: "", filterable: "", style: { width: "300px", "margin-right": "6px" }, projectId: (E = _.globalProject) == null ? void 0 : E.id, placeholder: "请选择供应商", onChange: re }, null, 8, ["modelValue", "projectId"]), l(U, { modelValue: r.value.contractId, "onUpdate:modelValue": a[1] || (a[1] = (s) => r.value.contractId = s), options: Q.value, type: "other", dataStructure: { key: "id", label: "serialNumber", value: "id" }, size: "default", clearable: "", class: "input-underline", placeholder: "请选择采购合同号", noDataText: (X = r.value) != null && X.supplierId ? "暂无数据" : "请先选择供应商", style: { width: "300px" }, onChange: de }, null, 8, ["modelValue", "options", "noDataText"])]), l(M, { modelValue: p.value.name, "onUpdate:modelValue": a[2] || (a[2] = (s) => p.value.name = s), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: P(b, ["enter"]) }, null, 8, ["modelValue"]), l(M, { modelValue: p.value.serialNumber, "onUpdate:modelValue": a[3] || (a[3] = (s) => p.value.serialNumber = s), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: P(b, ["enter"]) }, null, 8, ["modelValue"]), d.value === o(f).STRUC_MANUFACTURED.V || d.value === o(f).ENCL_MANUFACTURED.V || d.value === o(f).AUX_MANUFACTURED.V ? (c(), V(M, { key: 0, modelValue: p.value.material, "onUpdate:modelValue": a[4] || (a[4] = (s) => p.value.material = s), modelModifiers: { trim: true }, placeholder: "材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: P(b, ["enter"]) }, null, 8, ["modelValue"])) : k("", true), l(M, { modelValue: p.value.specification, "onUpdate:modelValue": a[5] || (a[5] = (s) => p.value.specification = s), modelModifiers: { trim: true }, placeholder: "规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: P(b, ["enter"]) }, null, 8, ["modelValue"]), l(v, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: D(b, ["stop"]) }, { default: u(() => a[9] || (a[9] = [S(" 搜索 ")])), _: 1, __: [9] }), l(v, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: D(me, ["stop"]) }, { default: u(() => a[10] || (a[10] = [S(" 重置 ")])), _: 1, __: [10] }), o(W)(_.permission.summary) ? (c(), V(ge, { key: 1, value: ($ = m.value) == null ? void 0 : $.length, hidden: !((G = m.value) != null && G.length), style: { float: "right" } }, { default: u(() => {
        var s;
        return [l(v, { type: "warning", class: "filter-item", size: "default", disabled: !((s = m.value) != null && s.length), onClick: a[6] || (a[6] = D((L) => j.value = true, ["stop"])) }, { default: u(() => a[11] || (a[11] = [S("汇总")])), _: 1, __: [11] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value", "hidden"])) : k("", true)]), r.value.contractId ? Me((c(), V(be, { key: 0, data: N.value, "max-height": o(ue), returnSourceData: "", "show-empty-symbol": false, "cell-class-name": o(ie) }, { default: u(() => {
        var s, L;
        return [l(i, { label: "序号", type: "index", align: "center", width: "60" }), ((s = x.value) == null ? void 0 : s.materialType) === 96 ? (c(), V(i, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: u(({ row: e }) => {
          var t;
          return [g("span", null, C(((t = e.monomer) == null ? void 0 : t.name) || "-"), 1)];
        }), _: 1 })) : k("", true), ((L = x.value) == null ? void 0 : L.materialType) === 96 ? (c(), V(i, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: u(({ row: e }) => {
          var t;
          return [g("span", null, C(((t = e.area) == null ? void 0 : t.name) || "-"), 1)];
        }), _: 1 })) : k("", true), l(i, { key: "name", prop: "name", label: "名称", align: "center" }), l(i, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), l(i, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center" }, { default: u(({ row: e }) => [l(fe, { content: o(ze)(e), placement: "left" }, { default: u(() => [g("span", null, C(o(Ee)(e)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), d.value === o(f).STRUC_MANUFACTURED.V ? (c(), R(F, { key: 2 }, [l(i, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), l(i, { key: "material", prop: "material", label: "材质", align: "center" }), l(i, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.selectQuantity, "onUpdate:modelValue": (t) => e.selectQuantity = t, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (t) => q(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(i, { key: "canReceivedMete", prop: "canReceivedMete", label: "重量（kg）", align: "center" }), l(i, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.manuActualMete, "onUpdate:modelValue": (t) => e.manuActualMete = t, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (t) => B(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : d.value === o(f).ENCL_MANUFACTURED.V ? (c(), R(F, { key: 3 }, [l(i, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), l(i, { key: "selectQuantity", prop: "selectQuantity", label: "数量（张）", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.selectQuantity, "onUpdate:modelValue": (t) => e.selectQuantity = t, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (t) => q(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(i, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), l(i, { key: "canReceivedMete", prop: "canReceivedMete", label: "总量（m）", align: "center" }), l(i, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.manuActualMete, "onUpdate:modelValue": (t) => e.manuActualMete = t, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (t) => B(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : d.value === o(f).AUX_MANUFACTURED.V ? (c(), R(F, { key: 4 }, [l(i, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.selectQuantity, "onUpdate:modelValue": (t) => e.selectQuantity = t, controls: false, min: 0, max: e.canReceivedQuantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (t) => q(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), l(i, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), l(i, { key: "canReceivedMete", prop: "canReceivedMete", label: "总量", align: "center" }), l(i, { key: "manuActualMete", prop: "manuActualMete", label: "实收量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.manuActualMete, "onUpdate:modelValue": (t) => e.manuActualMete = t, controls: false, min: 0, size: "default", clearable: "", placeholder: "实收量", style: { width: "100%" }, onChange: (t) => B(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })], 64)) : (c(), R(F, { key: 5 }, [l(i, { key: "canReceivedQuantity", prop: "canReceivedQuantity", label: "数量", align: "center" }, { default: u(({ row: e }) => {
          var t;
          return [g("span", null, C(((t = e.canReceivedQuantity) == null ? void 0 : t.toFixed(+e.measurePrecision)) || "-"), 1), g("span", null, C(e.measureUnit || ""), 1)];
        }), _: 1 }), l(i, { key: "canReceivedMete", prop: "canReceivedMete", label: "核算量", align: "center" }, { default: u(({ row: e }) => {
          var t;
          return [g("span", null, C(((t = e.canReceivedMete) == null ? void 0 : t.toFixed(+e.accountingPrecision)) || "-"), 1), g("span", null, C(e.accountingUnit || ""), 1)];
        }), _: 1 }), l(i, { key: "selectQuantity", prop: "selectQuantity", label: "实收数量", align: "center" }, { default: u(({ row: e }) => [o(A)(e.accountingUnit) && o(Y)(e.measureUnit) ? (c(), R("span", Se, "-")) : o(A)(e.accountingUnit) && o(A)(e.measureUnit) ? (c(), V(h, { key: 1, modelValue: e.selectQuantity, "onUpdate:modelValue": (t) => e.selectQuantity = t, controls: false, min: 0, max: e.canReceivedQuantity, precision: +e.measurePrecision, size: "default", clearable: "", placeholder: "实收数量", style: { width: "100%" }, onChange: (t) => se(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : k("", true)]), _: 1 }), l(i, { key: "actualMete", prop: "actualMete", label: "实收量", align: "center" }, { default: u(({ row: e }) => [l(h, { modelValue: e.actualMete, "onUpdate:modelValue": (t) => e.actualMete = t, controls: false, min: 0, precision: +e.accountingPrecision, size: "default", clearable: "", disabled: !!(o(A)(e.accountingUnit) && o(A)(e.measureUnit) && e.accountingUnit === e.measureUnit), placeholder: "实收量", style: { width: "100%" }, onChange: (t) => ce(e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "disabled", "onChange"])]), _: 1 })], 64)), o(W)(_.permission.addRow) ? (c(), V(i, { key: 6, label: "操作", width: "80", align: "center" }, { default: u(({ row: e, $index: t }) => {
          var J;
          return [l(v, { size: "default", icon: "el-icon-plus", type: "success", onClick: D((Ke) => pe(e, t), ["stop"]), disabled: (J = oe.value) == null ? void 0 : J.includes(e.detailId) }, null, 8, ["onClick", "disabled"])];
        }), _: 1 })) : k("", true)];
      }), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[he, w.value]]) : (c(), R("div", He, "* 请选择合同号查看明细列表")), l(qe, { modelValue: j.value, "onUpdate:modelValue": a[7] || (a[7] = (s) => j.value = s), "summary-list": m.value, "detail-info": x.value, globalProject: _.globalProject, currentProductType: d.value, contractId: r.value.contractId, permission: _.permission, onSuccess: ye }, null, 8, ["modelValue", "summary-list", "detail-info", "globalProject", "currentProductType", "contractId", "permission"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ye as default
};
