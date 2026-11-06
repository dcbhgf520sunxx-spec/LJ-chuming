import { ref as _ } from "vue";
import { watch as X } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as u } from "vue";
import { createBlock as V } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as r } from "vue";
import { createElementVNode as p } from "vue";
import { unref as n } from "vue";
import { withModifiers as G } from "vue";
import { createCommentVNode as P } from "vue";
import { withDirectives as J } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as K } from "vue";
import { renderList as Z } from "vue";
import { isRef as ee } from "vue";
import { ElMessageBox as te } from "element-plus";
import { ElNotification as ae } from "element-plus";
import { ElTag as ne } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { vLoading as ie } from "element-plus";
import { g as se, p as ce } from "../../../../../modules/outsourcing-return-1594aa02.js";
import { tS as d, u as re, o as ue, cO as pe, jl as de, tW as l, c as Q, G as W, tX as j, p as me, aN as fe, bv as ye, pz as ge, pA as Te } from "../../../../../shared/runtime.js";
const Ae = { class: "head-container" }, be = { key: 0 }, _e = { key: 1 }, Ve = { key: 2 }, he = { key: 1 }, Re = { __name: "return-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: Boolean, default: false } }, emits: ["update:modelValue", "success"], setup(f, { emit: D }) {
  const L = D, z = _([d.MACHINE_PART.V, d.AUXILIARY_MATERIAL.V]), E = _(), w = _(false), N = f, { visible: R, handleClose: U } = re({ emit: L, props: N });
  X(R, (y) => {
    y && (E.value = void 0, H());
  });
  const O = _(), T = _([]), x = _(), M = _(false), { maxHeight: F } = ue({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, x);
  async function H() {
    var a, m, A;
    let y = [];
    M.value = true;
    try {
      const g = await se({ rejectId: (a = N.detailInfo) == null ? void 0 : a.id, productType: E.value });
      y = (g == null ? void 0 : g.dtoList) || [];
    } catch (g) {
      console.log("收货明细", g);
    } finally {
      T.value = y, pe(T.value);
      const g = (m = T.value) == null ? void 0 : m.filter((t) => t.productType === d.RAW_MATERIAL.V);
      await de(g, { toNum: true }, { quantity: ["rejectQuantity"], mete: ["rejectMete", "rejectActualReceivedMete"] });
      const i = (A = T.value) == null ? void 0 : A.filter((t) => t.productType !== d.RAW_MATERIAL.V);
      i == null || i.forEach(async (t) => {
        t.accountingUnit = t.wageQuotaType === l.WEIGHT.V ? l.WEIGHT.unit : t.wageQuotaType === l.LENGTH.V ? l.LENGTH.unit : t.wageQuotaType === l.QUANTITY.V ? l.QUANTITY.unit : t.wageQuotaType === l.AREA.V ? l.AREA.unit : "", t.accountingPrecision = t.wageQuotaType === l.WEIGHT.V ? l.WEIGHT.precision : t.wageQuotaType === l.LENGTH.V ? l.LENGTH.precision : t.wageQuotaType === l.QUANTITY.V ? l.QUANTITY.precision : t.wageQuotaType === l.AREA.V ? l.AREA.precision : 0, t.rejectActualReceivedMete = t.wageQuotaType === l.WEIGHT.V ? Q(t.rejectActualReceivedMete, "g", "kg", 3) : t.wageQuotaType === l.LENGTH.V ? Q(t.rejectActualReceivedMete, "mm", "m", 3) : t.wageQuotaType === l.AREA.V ? Q(t.rejectActualReceivedMete, "mm²", "m²", 6) : t.rejectActualReceivedMete;
      }), M.value = false;
    }
  }
  function S(y) {
    var m;
    const a = { dataId: (m = N.detailInfo) == null ? void 0 : m.id, decision: y };
    te.confirm(`是否确认${y === j.PASS.V ? "通过" : "驳回"}审核？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      w.value = true, await ce(a), ae({ title: y === j.PASS.V ? "审核通过成功" : "审核驳回成功", type: "success", duration: 2500 }), U(), L("success");
    }).catch((A) => {
      console.log(A, "审核失败");
    }).finally(() => {
      w.value = false;
    });
  }
  return (y, a) => {
    const m = ne, A = k("common-button"), g = k("common-radio-button"), i = le, t = oe, Y = k("common-table"), q = k("common-drawer"), $ = ie;
    return u(), V(q, { ref_key: "drawerRef", ref: x, title: "外购退货详情列表", "close-on-click-modal": false, modelValue: n(R), "onUpdate:modelValue": a[3] || (a[3] = (e) => ee(R) ? R.value = e : null), direction: "rtl", "before-close": n(U), "custom-class": "delivery-detail", size: "100%" }, { titleAfter: o(() => [s(m, { type: "primary", effect: "plain", size: "large" }, { default: o(() => {
      var e, c, b, h;
      return [I(r(((c = (e = f.detailInfo) == null ? void 0 : e.project) == null ? void 0 : c.serialNumber) + " " + ((h = (b = f.detailInfo) == null ? void 0 : b.project) == null ? void 0 : h.name)), 1)];
    }), _: 1 }), s(m, { type: "danger", effect: "plain", size: "large" }, { default: o(() => {
      var e;
      return [a[4] || (a[4] = p("span", null, "退货日期：", -1)), p("span", null, r(((e = f.detailInfo) == null ? void 0 : e.createTime) || "-"), 1)];
    }), _: 1, __: [4] }), s(m, { type: "warning", effect: "plain", size: "large" }, { default: o(() => {
      var e;
      return [a[5] || (a[5] = p("span", null, "退货人：", -1)), p("span", null, r(((e = f.detailInfo) == null ? void 0 : e.applicantName) || "-"), 1)];
    }), _: 1, __: [5] })]), titleRight: o(() => {
      var e, c;
      return [n(W)(f.permission.pass) && f.showType ? (u(), V(A, { key: 0, loading: w.value, type: "success", size: "default", disabled: !((e = T.value) != null && e.length), onClick: a[0] || (a[0] = G((b) => S(n(j).PASS.V), ["stop"])) }, { default: o(() => a[6] || (a[6] = [I(" 通过 ")])), _: 1, __: [6] }, 8, ["loading", "disabled"])) : P("", true), n(W)(f.permission.reject) && f.showType ? (u(), V(A, { key: 1, loading: w.value, type: "danger", size: "default", disabled: !((c = T.value) != null && c.length), onClick: a[1] || (a[1] = G((b) => S(n(j).REFUSE.V), ["stop"])) }, { default: o(() => a[7] || (a[7] = [I(" 拒绝 ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])) : P("", true)];
    }), content: o(() => [p("div", Ae, [s(g, { modelValue: E.value, "onUpdate:modelValue": a[2] || (a[2] = (e) => E.value = e), options: n(d).ENUM, type: "enum", unshowVal: z.value, showOptionAll: "", class: "filter-item", onChange: H }, null, 8, ["modelValue", "options", "unshowVal"])]), J((u(), V(Y, { ref_key: "tableRef", ref: O, data: T.value, "max-height": n(F) }, { default: o(() => [s(i, { label: "序号", type: "index", align: "center", width: "60" }), s(i, { key: "receivedDate", prop: "receivedDate", label: "收货日期", align: "center", width: "140" }, { default: o(({ row: e }) => [p("span", null, r(e.receivedDate ? n(me)(e.receivedDate, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), s(i, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true }), s(i, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true }), s(i, { key: "receivedUserName", prop: "receivedUserName", label: "收货人", align: "center" }), s(i, { key: "productType", prop: "productType", label: "材料类型", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: o((e) => [(u(true), v(K, null, Z(n(fe)(n(ye).getBits(n(d), e.row.productType, "V")), (c) => (u(), V(m, { style: { "margin-right": "5px" }, key: c, type: n(d).V[c].T, effect: "light", "disable-transitions": "" }, { default: o(() => [I(r(n(d).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), s(i, { key: "productType", prop: "productType", label: "单体区域/批次", align: "center", "show-overflow-tooltip": true }, { default: o(({ row: e }) => {
      var c, b, h, B, C;
      return [e.productType === n(d).STRUCTURE.V ? (u(), v("span", be, r(((c = e.monomer) != null && c.name || (b = e == null ? void 0 : e.area) != null && b.name) && (((h = e.monomer) == null ? void 0 : h.name) || "->" + ((B = e == null ? void 0 : e.area) == null ? void 0 : B.name)) || "-"), 1)) : e.productType === n(d).ENCLOSURE.V ? (u(), v("span", _e, r(((C = e.batch) == null ? void 0 : C.name) || "-"), 1)) : (u(), v("span", Ve, "-"))];
    }), _: 1 }), s(i, { key: "name", prop: "name", label: "名称", align: "center" }), s(i, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), s(i, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true }, { default: o(({ row: e }) => [e.productType === n(d).RAW_MATERIAL.V ? (u(), V(t, { key: 0, content: n(ge)(e), placement: "left" }, { default: o(() => [p("span", null, r(n(Te)(e)), 1)]), _: 2 }, 1032, ["content"])) : (u(), v("span", he, r(e.specification || "-"), 1))]), _: 1 }), s(i, { key: "rejectQuantity", prop: "rejectQuantity", label: "本次退货数", align: "center" }, { default: o(({ row: e }) => [p("span", null, r(e.rejectQuantity || "-"), 1), p("span", null, r(e.measureUnit || ""), 1)]), _: 1 }), s(i, { key: "rejectActualReceivedMete", prop: "rejectActualReceivedMete", label: "本次退货量", align: "center" }, { default: o(({ row: e }) => {
      var c;
      return [p("span", null, r(((c = e.rejectActualReceivedMete) == null ? void 0 : c.toFixed(e.accountingPrecision)) || "-"), 1), p("span", null, r(e.accountingUnit || ""), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[$, M.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Re as default
};
