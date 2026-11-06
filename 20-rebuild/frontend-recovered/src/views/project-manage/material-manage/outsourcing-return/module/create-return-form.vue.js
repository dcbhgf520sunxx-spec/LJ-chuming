import { ref as f } from "vue";
import { watch as je } from "vue";
import { computed as ke } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as r } from "vue";
import { unref as l } from "vue";
import { createVNode as n } from "vue";
import { withModifiers as N } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementVNode as V } from "vue";
import { withKeys as U } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as Ue } from "vue";
import { toDisplayString as p } from "vue";
import { Fragment as Ae } from "vue";
import { renderList as Me } from "vue";
import { isRef as Ie } from "vue";
import { ElBadge as Qe } from "element-plus";
import { ElInput as Ee } from "element-plus";
import { ElDatePicker as Ce } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { ElTag as we } from "element-plus";
import { ElTooltip as xe } from "element-plus";
import { ElPagination as Pe } from "element-plus";
import { vLoading as Se } from "element-plus";
import { a as ze } from "../../../../../modules/outsourcing-return-1594aa02.js";
import { tS as R, u as He, J as Le, o as Ge, i as T, b as A, jl as Be, tW as o, c as j, cO as Oe, G as O, I as We, p as Ke, aN as qe, bv as De, pz as Fe, pA as Ye, c9 as W } from "../../../../../shared/runtime.js";
import { u as $e } from "../../../../../modules/use-table-row-validate-5799de49.js";
import { s as Je } from "../../../../../modules/index-8edb1b61.js";
import Xe from "./return-confirm-form.vue.js";
import { _ as Ze } from "../../../../../modules/project-select-v3-7c9e02e1.js";
const et = { class: "head-container" }, tt = { style: { "margin-bottom": "8px" } }, at = { key: 0 }, lt = { key: 0 }, nt = { key: 0 }, ot = { key: 1 }, it = { key: 2 }, ut = { key: 1 }, st = { key: 1 }, ct = { key: 1 }, rt = { key: 1, class: "red-tip", style: { "font-size": "14px" } }, Vt = { __name: "create-return-form", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(M, { emit: K }) {
  const S = K, q = f([R.MACHINE_PART.V, R.AUXILIARY_MATERIAL.V]), D = M, Q = f([]), z = f(), F = f(false), Y = f([]), _ = f([]), x = f(false), $ = f(), J = f({}), H = f({}), s = f({ supplierId: void 0, productType: void 0, receivedTime: [], monomerOrArea: void 0, name: void 0, purchaseSn: void 0, serialNumber: void 0, specification: void 0, userName: void 0 }), g = f({ projectId: void 0 }), { visible: E, handleClose: X } = He({ emit: S, props: D }), { handleSizeChange: Z, handleCurrentChange: ee, total: te, setTotalPage: ae, queryPage: P } = Le({ fetchHook: m });
  je(() => E.value, (u) => {
    s.value = {}, g.value = {}, _.value = [], Y.value = [];
  }, { immediate: true });
  const le = { selectMete: [{ required: true, message: "请填写退货量", trigger: "blur" }, { pattern: W, message: "数量必须大于0", trigger: "blur" }] }, ne = { selectQuantity: [{ required: true, message: "请填写退货数", trigger: "blur" }, { pattern: W, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: oe, wrongCellMask: ie } = $e({ rules: (u) => u.tableRules }), { maxHeight: ue } = Ge({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, extraHeight: 90, navbar: false, clientHRepMainH: true }, z), se = ke(() => {
    var u;
    return (u = _.value) == null ? void 0 : u.map((a) => a.id);
  });
  function ce(u, a) {
    u.selectQuantity = a, u.selectMete = u.selectQuantity * (u.canRejectActualReceivedMete / u.canRejectQuantity);
  }
  function re(u, a) {
    u.selectMete = a;
  }
  async function m() {
    if (g.value.projectId) try {
      const { content: u = [], totalElements: a } = await ze({ ...s.value, projectId: g.value.projectId, ...P });
      ae(a), Q.value = u || [], Q.value.forEach(async (t) => {
        t.selectQuantity = t.canRejectQuantity, t.selectMete = t.canRejectActualReceivedMete, t.tableRules = T(t.accountingUnit) && T(t.measureUnit) ? ne : T(t.accountingUnit) && A(t.measureUnit) || T(t.measureUnit) && A(t.accountingUnit) ? le : {}, t.productType === R.RAW_MATERIAL.V ? await Be(t, { toNum: true }, { mete: ["canRejectMete", "canRejectActualReceivedMete", "selectMete"], quantity: ["canRejectQuantity", "selectQuantity"] }) : (t.accountingUnit = t.wageQuotaType === o.WEIGHT.V ? o.WEIGHT.unit : t.wageQuotaType === o.LENGTH.V ? o.LENGTH.unit : t.wageQuotaType === o.QUANTITY.V ? o.QUANTITY.unit : t.wageQuotaType === o.AREA.V ? o.AREA.unit : "", t.accountingPrecision = t.wageQuotaType === o.WEIGHT.V ? o.WEIGHT.precision : t.wageQuotaType === o.LENGTH.V ? o.LENGTH.precision : t.wageQuotaType === o.QUANTITY.V ? o.QUANTITY.precision : t.wageQuotaType === o.AREA.V ? o.AREA.precision : 0, t.canRejectActualReceivedMete = t.wageQuotaType === o.WEIGHT.V ? j(t.canRejectActualReceivedMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.canRejectActualReceivedMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.canRejectActualReceivedMete, "mm²", "m²", 6) : t.canRejectActualReceivedMete, t.canRejectMete = t.wageQuotaType === o.WEIGHT.V ? j(t.canRejectMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.canRejectMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.canRejectMete, "mm²", "m²", 6) : t.canRejectMete, t.selectMete = t.wageQuotaType === o.WEIGHT.V ? j(t.selectMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.selectMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.selectMete, "mm²", "m²", 6) : t.selectMete);
      }), Oe(Q.value);
    } catch (u) {
      console.log(u, "获取采购合同号列表失败");
    }
  }
  function de() {
    s.value = {}, m();
  }
  function pe(u) {
    const { validResult: a } = oe([u]);
    a && _.value.push(u);
  }
  async function me() {
    _.value = [], await m(), S("success");
  }
  function ge(u) {
    H.value = u, _.value = [];
  }
  return (u, a) => {
    const t = I("common-button"), ye = Qe, fe = I("common-radio-button"), k = Ee, he = Ce, d = Ne, Ve = we, Te = xe, L = I("common-input-number"), be = I("common-table"), Re = Pe, _e = I("common-drawer"), ve = Se;
    return c(), h(_e, { ref_key: "drawerRef", ref: z, title: "外购退货办理", "close-on-click-modal": false, modelValue: l(E), "onUpdate:modelValue": a[12] || (a[12] = (e) => Ie(E) ? E.value = e : null), direction: "rtl", "before-close": l(X), size: "100%" }, { titleRight: r(() => {
      var e, i;
      return [l(O)(M.permission.preview) ? (c(), h(ye, { key: 0, value: (e = _.value) == null ? void 0 : e.length, hidden: !((i = _.value) != null && i.length), style: { float: "right", "margin-right": "20px" } }, { default: r(() => {
        var y;
        return [n(t, { type: "warning", class: "filter-item", size: "default", disabled: !g.value.projectId || !((y = _.value) != null && y.length), onClick: a[0] || (a[0] = N((C) => x.value = true, ["stop"])) }, { default: r(() => a[13] || (a[13] = [w(" 外购退货预览列表 ")])), _: 1, __: [13] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value", "hidden"])) : v("", true)];
    }), content: r(() => [V("div", et, [V("div", tt, [n(Ze, { modelValue: g.value.projectId, "onUpdate:modelValue": a[1] || (a[1] = (e) => g.value.projectId = e), class: "filter-item", dataStructure: { key: "id", label: "fullName", value: "id" }, clearable: "", placeholder: "选择项目", style: { width: "240px" }, onChange: m, onProjectChange: ge }, null, 8, ["modelValue"]), g.value.projectId ? (c(), h(fe, { key: 0, modelValue: s.value.productType, "onUpdate:modelValue": a[2] || (a[2] = (e) => s.value.productType = e), options: l(R).ENUM, type: "enum", unshowVal: q.value, showOptionAll: "", class: "filter-item", onChange: m }, null, 8, ["modelValue", "options", "unshowVal"])) : v("", true), g.value.projectId ? (c(), h(Je, { key: 1, modelValue: s.value.supplierId, "onUpdate:modelValue": a[3] || (a[3] = (e) => s.value.supplierId = e), clearable: "", filterable: "", style: { width: "300px", "margin-right": "6px" }, projectId: g.value.projectId, placeholder: "供应商搜索", class: "filter-item", onChange: m }, null, 8, ["modelValue", "projectId"])) : v("", true), g.value.projectId ? (c(), h(k, { key: 2, modelValue: s.value.purchaseSn, "onUpdate:modelValue": a[4] || (a[4] = (e) => s.value.purchaseSn = e), size: "default", placeholder: "采购合同号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"])) : v("", true), g.value.projectId ? (c(), h(k, { key: 3, modelValue: s.value.userName, "onUpdate:modelValue": a[5] || (a[5] = (e) => s.value.userName = e), size: "default", placeholder: "办理人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"])) : v("", true)]), g.value.projectId ? (c(), b("div", at, [n(he, { modelValue: s.value.receivedTime, "onUpdate:modelValue": a[6] || (a[6] = (e) => s.value.receivedTime = e), type: "daterange", "range-separator": "-", "value-format": "x", shortcuts: l(We), "start-placeholder": "收货日期", "end-placeholder": "收货日期", class: "filter-item", onChange: m }, null, 8, ["modelValue", "shortcuts"]), n(k, { modelValue: s.value.monomerOrArea, "onUpdate:modelValue": a[7] || (a[7] = (e) => s.value.monomerOrArea = e), size: "default", placeholder: "单体区域/批次搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: s.value.specification, "onUpdate:modelValue": a[8] || (a[8] = (e) => s.value.specification = e), size: "default", placeholder: "规格搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: s.value.serialNumber, "onUpdate:modelValue": a[9] || (a[9] = (e) => s.value.serialNumber = e), size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: s.value.name, "onUpdate:modelValue": a[10] || (a[10] = (e) => s.value.name = e), size: "default", placeholder: "名称搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: U(m, ["enter"]) }, null, 8, ["modelValue"]), n(t, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: N(m, ["stop"]) }, { default: r(() => a[14] || (a[14] = [w(" 搜索 ")])), _: 1, __: [14] }), n(t, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: N(de, ["stop"]) }, { default: r(() => a[15] || (a[15] = [w(" 重置 ")])), _: 1, __: [15] })])) : v("", true)]), g.value.projectId ? (c(), b("div", lt, [Ue((c(), h(be, { data: Q.value, "max-height": l(ue), returnSourceData: "", "show-empty-symbol": false, "cell-class-name": l(ie) }, { default: r(() => [n(d, { label: "序号", type: "index", align: "center", width: "60" }), n(d, { key: "createTime", prop: "createTime", label: "收货日期", align: "center", width: "140", "show-overflow-tooltip": true }, { default: r(({ row: e }) => [V("span", null, p(e.createTime ? l(Ke)(e.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), n(d, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true }), n(d, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true }), n(d, { key: "userName", prop: "userName", label: "收货人", align: "center", "show-overflow-tooltip": true }), n(d, { key: "productType", prop: "productType", label: "材料类型", align: "center", width: "140", "show-overflow-tooltip": true }, { default: r((e) => [(c(true), b(Ae, null, Me(l(qe)(l(De).getBits(l(R), e.row.productType, "V")), (i) => (c(), h(Ve, { style: { "margin-right": "5px" }, key: i, type: l(R).V[i].T, effect: "light", "disable-transitions": "" }, { default: r(() => [w(p(l(R).VL[i]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), n(d, { key: "productType", prop: "productType", label: "单体区域/批次", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r(({ row: e }) => {
      var i, y, C, G, B;
      return [e.productType === l(R).STRUCTURE.V ? (c(), b("span", nt, p(((i = e.monomer) != null && i.name || (y = e == null ? void 0 : e.area) != null && y.name) && (((C = e.monomer) == null ? void 0 : C.name) || "->" + ((G = e == null ? void 0 : e.area) == null ? void 0 : G.name)) || "-"), 1)) : e.productType === l(R).ENCLOSURE.V ? (c(), b("span", ot, p(((B = e.batch) == null ? void 0 : B.name) || "-"), 1)) : (c(), b("span", it, "-"))];
    }), _: 1 }), n(d, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), n(d, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), n(d, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r(({ row: e }) => [e.productType === l(R).RAW_MATERIAL.V ? (c(), h(Te, { key: 0, content: l(Fe)(e), placement: "left" }, { default: r(() => [V("span", null, p(l(Ye)(e)), 1)]), _: 2 }, 1032, ["content"])) : (c(), b("span", ut, p(e.specification || "-"), 1))]), _: 1 }), n(d, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "数量", align: "center" }, { default: r(({ row: e }) => [V("span", null, p(e.canRejectQuantity || "-"), 1), V("span", null, p(e.measureUnit || ""), 1)]), _: 1 }), n(d, { key: "canRejectMete", prop: "canRejectMete", label: "核算量", align: "center" }, { default: r(({ row: e }) => {
      var i;
      return [V("span", null, p(((i = e.canRejectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), V("span", null, p(e.accountingUnit || ""), 1)];
    }), _: 1 }), n(d, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "实收数", align: "center" }, { default: r(({ row: e }) => [V("span", null, p(e.canRejectQuantity || "-"), 1), V("span", null, p(e.measureUnit || ""), 1)]), _: 1 }), n(d, { key: "canRejectActualReceivedMete", prop: "canRejectActualReceivedMete", label: "实收量", align: "center" }, { default: r(({ row: e }) => {
      var i;
      return [V("span", null, p(((i = e.canRejectActualReceivedMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), V("span", null, p(e.accountingUnit || ""), 1)];
    }), _: 1 }), n(d, { key: "selectQuantity", prop: "selectQuantity", label: "本次退货数", align: "center", width: "140" }, { default: r(({ row: e }) => [l(T)(e.accountingUnit) && l(T)(e.measureUnit) ? (c(), h(L, { key: 0, modelValue: e.selectQuantity, "onUpdate:modelValue": (i) => e.selectQuantity = i, controls: false, min: 0, max: e.canRejectQuantity, precision: e.measurePrecision || 0, size: "default", clearable: "", placeholder: "退货数", style: { width: "100%" }, onChange: (i) => ce(e, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : l(T)(e.accountingUnit) && l(A)(e.measureUnit) || l(T)(e.measureUnit) && l(A)(e.accountingUnit) ? (c(), b("span", st, "-")) : v("", true)]), _: 1 }), n(d, { key: "selectMete", prop: "selectMete", label: "本次退货量", align: "center", width: "140" }, { default: r(({ row: e }) => {
      var i;
      return [l(T)(e.accountingUnit) && l(A)(e.measureUnit) || l(T)(e.measureUnit) && l(A)(e.accountingUnit) ? (c(), h(L, { key: 0, modelValue: e.selectMete, "onUpdate:modelValue": (y) => e.selectMete = y, controls: false, min: 0, size: "default", precision: e.accountingPrecision, clearable: "", placeholder: "退货量", style: { width: "100%" }, onChange: (y) => re(e, y) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : l(T)(e.accountingUnit) && l(T)(e.measureUnit) ? (c(), b("span", ct, p(((i = e.selectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1)) : v("", true)];
    }), _: 1 }), l(O)(M.permission.addRow) ? (c(), h(d, { key: 0, label: "操作", width: "80", align: "center" }, { default: r(({ row: e, $index: i }) => {
      var y;
      return [n(t, { size: "default", icon: "el-icon-plus", type: "success", onClick: N((C) => pe(e, i), ["stop"]), disabled: (y = se.value) == null ? void 0 : y.includes(e.id) }, null, 8, ["onClick", "disabled"])];
    }), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[ve, F.value]]), n(Re, { total: l(te), "current-page": l(P).pageNumber, "page-size": l(P).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(Z), onCurrentChange: l(ee) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : (c(), b("div", rt, "* 请选择项目查看明细列表")), n(Xe, { modelValue: x.value, "onUpdate:modelValue": a[11] || (a[11] = (e) => x.value = e), "summary-list": _.value, "detail-info": J.value, "project-info": H.value, globalProject: M.globalProject, currentProductType: $.value, contractId: s.value.contractId, permission: M.permission, onSuccess: me }, null, 8, ["modelValue", "summary-list", "detail-info", "project-info", "globalProject", "currentProductType", "contractId", "permission"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Vt as default
};
