import { ref as v } from "vue";
import { watch as W } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as u } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as j } from "vue";
import { toDisplayString as r } from "vue";
import { unref as t } from "vue";
import { withModifiers as x } from "vue";
import { createCommentVNode as U } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as le } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as ie } from "vue";
import { renderList as oe } from "vue";
import { isRef as se } from "vue";
import { ElMessageBox as ce } from "element-plus";
import { ElNotification as ue } from "element-plus";
import { ElTag as re } from "element-plus";
import { ElTableColumn as pe } from "element-plus";
import { ElTooltip as de } from "element-plus";
import { vLoading as me } from "element-plus";
import { b as ye } from "../../../../../modules/outsourcing-return-1594aa02.js";
import { tS as p, u as fe, cO as ge, o as he, G as w, p as _e, aN as be, bv as Re, pz as ve, pA as ke, i as h, b as E, jl as Te, tW as P, c as z } from "../../../../../shared/runtime.js";
import { u as Ve } from "../../../../../modules/use-table-row-validate-5799de49.js";
const Me = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, Ae = { key: 0 }, je = { key: 1 }, Ue = { key: 1 }, Le = { key: 1 }, Ce = { key: 1 }, Ie = { __name: "return-confirm-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, summaryList: { type: Array, default: () => [] }, currentProductType: { type: Number }, contractId: { type: Number } }, emits: ["update:modelValue", "success"], setup(g, { emit: q }) {
  const S = q, D = v([p.MACHINE_PART.V, p.AUXILIARY_MATERIAL.V]), N = v(), _ = g, m = v([]), H = v(), G = v(false), I = v(false), { visible: L, handleClose: B } = fe({ emit: S, props: _ }), { tableValidate: X, wrongCellMask: Y } = Ve({ rules: (n) => n.tableRules });
  W(L, async (n) => {
    n && (m.value = _.summaryList, ge(m.value));
  }), W(() => N.value, (n) => {
    var a;
    n ? m.value = (a = _.summaryList) == null ? void 0 : a.filter((b) => b.productType === n) : m.value = _.summaryList;
  }, { immediate: true });
  const { maxHeight: $ } = he({ extraBox: [".el-drawer__header"], wrapperBox: ".el-drawer__body", paginate: false, extraHeight: 90, navbar: false, clientHRepMainH: true }, H);
  function J(n) {
    m.value.splice(n, 1);
  }
  function K(n, a) {
    n.selectQuantity = a, n.selectMete = n.selectQuantity * (n.canRejectActualReceivedMete / n.canRejectQuantity);
  }
  function Z(n, a) {
    n.selectMete = a;
  }
  async function ee() {
    const { validResult: n } = X(_.summaryList);
    if (n) try {
      ce.confirm("是否确认发起审核？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
        var C, M, Q;
        I.value = true;
        const a = (C = m.value) == null ? void 0 : C.filter((c) => c.productType === p.RAW_MATERIAL.V), b = (M = m.value) == null ? void 0 : M.filter((c) => c.productType !== p.RAW_MATERIAL.V), V = [...await Te(a, { toNum: true, toSmallest: true }, { quantity: ["selectQuantity", "canRejectQuantity"], mete: ["canRejectMete", "canRejectActualReceivedMete", "selectMete"] }), ...b], s = V == null ? void 0 : V.map((c) => ({ receivedId: c.id, rejectActualReceivedMete: c.productType === p.RAW_MATERIAL.V ? c.selectMete : c.wageQuotaType === P.WEIGHT.V ? z(c.selectMete, "kg", "g") : c.wageQuotaType === P.LENGTH.V ? z(c.selectMete, "m", "mm") : c.wageQuotaType === P.AREA.V ? z(c.selectMete, "m²", "mm²") : c.selectMete, rejectQuantity: c.selectQuantity }));
        await ye(s, { projectId: (Q = _.projectInfo) == null ? void 0 : Q.id }), ue({ title: "提交审核成功", type: "success" }), S("success"), B();
      }).catch((a) => {
        console.log(a, "审核失败");
      }).finally(() => {
        I.value = false;
      });
    } catch (a) {
      console.log("提交审核失败", a);
    }
  }
  function te() {
    B();
  }
  function ae() {
    var n;
    m.value.splice(0, (n = m.value) == null ? void 0 : n.length);
  }
  return (n, a) => {
    const b = re, T = A("common-button"), V = A("common-radio-button"), s = pe, C = de, M = A("common-input-number"), Q = A("common-table"), c = A("common-drawer"), ne = me;
    return u(), f(c, { ref_key: "drawerRef", ref: H, title: "外购退货预览列表", "close-on-click-modal": false, modelValue: t(L), "onUpdate:modelValue": a[1] || (a[1] = (y) => se(L) ? L.value = y : null), direction: "rtl", "before-close": t(B), size: "100%" }, { titleAfter: l(() => [o(b, { type: "primary", effect: "plain", size: "large" }, { default: l(() => {
      var y, e;
      return [j(r(((y = g.projectInfo) == null ? void 0 : y.serialNumber) + " " + ((e = g.projectInfo) == null ? void 0 : e.fullName)), 1)];
    }), _: 1 })]), titleRight: l(() => {
      var y;
      return [t(w)(g.permission.confirm) ? (u(), f(T, { key: 0, type: "success", size: "default", disabled: !((y = g.summaryList) != null && y.length), loading: I.value, onClick: x(ee, ["stop"]) }, { default: l(() => a[2] || (a[2] = [j(" 提交审核 ")])), _: 1, __: [2] }, 8, ["disabled", "loading"])) : U("", true), o(T, { type: "warning", size: "default", onClick: x(te, ["stop"]) }, { default: l(() => a[3] || (a[3] = [j(" 返回上一步 ")])), _: 1, __: [3] })];
    }), content: l(() => {
      var y;
      return [d("div", Me, [o(V, { modelValue: N.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => N.value = e), options: t(p).ENUM, type: "enum", unshowVal: D.value, showOptionAll: "", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal"]), t(w)(g.permission.del) ? (u(), f(T, { key: 0, type: "danger", size: "default", class: "filter-item", disabled: !((y = g.summaryList) != null && y.length), onClick: x(ae, ["stop"]) }, { default: l(() => a[4] || (a[4] = [j(" 全部删除 ")])), _: 1, __: [4] }, 8, ["disabled"])) : U("", true)]), le((u(), f(Q, { data: m.value, "return-source-data": "", "show-empty-symbol": false, "max-height": t($), "cell-class-name": t(Y) }, { default: l(() => [o(s, { label: "序号", type: "index", align: "center", width: "60" }), o(s, { key: "createTime", prop: "createTime", label: "收货日期", align: "center", width: "140", "show-overflow-tooltip": true }, { default: l(({ row: e }) => [d("span", null, r(e.createTime ? t(_e)(e.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), o(s, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true }), o(s, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true }), o(s, { key: "userName", prop: "userName", label: "收货人", align: "center", "show-overflow-tooltip": true }), o(s, { key: "productType", prop: "productType", label: "材料类型", align: "center", width: "140", "show-overflow-tooltip": true }, { default: l((e) => [(u(true), k(ie, null, oe(t(be)(t(Re).getBits(t(p), e.row.productType, "V")), (i) => (u(), f(b, { style: { "margin-right": "5px" }, key: i, type: t(p).V[i].T, effect: "light", "disable-transitions": "" }, { default: l(() => [j(r(t(p).VL[i]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), o(s, { key: "productType", prop: "productType", label: "单体区域/批次", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l(({ row: e }) => {
        var i, R, O, F;
        return [e.productType === t(p).STRUCTURE.V || e.productType === t(p).ENCLOSURE.V ? (u(), k("span", Ae, r((i = e.monomer) != null && i.name && ((R = e == null ? void 0 : e.area) != null && R.name) ? ((O = e.monomer) == null ? void 0 : O.name) + ">" + ((F = e == null ? void 0 : e.area) == null ? void 0 : F.name) : "-"), 1)) : (u(), k("span", je, "-"))];
      }), _: 1 }), o(s, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), o(s, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), o(s, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: l(({ row: e }) => [e.productType === t(p).RAW_MATERIAL.V ? (u(), f(C, { key: 0, content: t(ve)(e), placement: "left" }, { default: l(() => [d("span", null, r(t(ke)(e)), 1)]), _: 2 }, 1032, ["content"])) : (u(), k("span", Ue, r(e.specification || "-"), 1))]), _: 1 }), o(s, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "数量", align: "center" }, { default: l(({ row: e }) => [d("span", null, r(e.canRejectQuantity || "-"), 1), d("span", null, r(e.measureUnit || ""), 1)]), _: 1 }), o(s, { key: "canRejectMete", prop: "canRejectMete", label: "核算量", align: "center" }, { default: l(({ row: e }) => {
        var i;
        return [d("span", null, r(((i = e.canRejectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), d("span", null, r(e.accountingUnit || ""), 1)];
      }), _: 1 }), o(s, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "实收数", align: "center" }, { default: l(({ row: e }) => [d("span", null, r(e.canRejectQuantity || "-"), 1), d("span", null, r(e.measureUnit || ""), 1)]), _: 1 }), o(s, { key: "canRejectActualReceivedMete", prop: "canRejectActualReceivedMete", label: "实收量", align: "center" }, { default: l(({ row: e }) => {
        var i;
        return [d("span", null, r(((i = e.canRejectActualReceivedMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), d("span", null, r(e.accountingUnit || ""), 1)];
      }), _: 1 }), o(s, { key: "selectQuantity", prop: "selectQuantity", label: "本次退货数", align: "center", width: "140" }, { default: l(({ row: e }) => [t(h)(e.accountingUnit) && t(h)(e.measureUnit) ? (u(), f(M, { key: 0, modelValue: e.selectQuantity, "onUpdate:modelValue": (i) => e.selectQuantity = i, controls: false, min: 0, max: e.canRejectQuantity, precision: e.measurePrecision || 0, size: "default", clearable: "", placeholder: "退货数", style: { width: "100%" }, onChange: (i) => K(e, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : t(h)(e.accountingUnit) && t(E)(e.measureUnit) || t(h)(e.measureUnit) && t(E)(e.accountingUnit) ? (u(), k("span", Le, "-")) : U("", true)]), _: 1 }), o(s, { key: "selectMete", prop: "selectMete", label: "本次退货量", align: "center", width: "140" }, { default: l(({ row: e }) => {
        var i;
        return [t(h)(e.accountingUnit) && t(E)(e.measureUnit) || t(h)(e.measureUnit) && t(E)(e.accountingUnit) ? (u(), f(M, { key: 0, modelValue: e.selectMete, "onUpdate:modelValue": (R) => e.selectMete = R, controls: false, precision: e.accountingPrecision, min: 0, size: "default", clearable: "", placeholder: "退货量", style: { width: "100%" }, onChange: (R) => Z(e, R) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : t(h)(e.accountingUnit) && t(h)(e.measureUnit) ? (u(), k("span", Ce, r(((i = e.selectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1)) : U("", true)];
      }), _: 1 }), t(w)(g.permission.del) ? (u(), f(s, { key: 0, label: "操作", width: "80", align: "center" }, { default: l(({ $index: e }) => [o(T, { size: "default", icon: "el-icon-delete", type: "danger", onClick: x((i) => J(e), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : U("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[ne, G.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Ie as default
};
