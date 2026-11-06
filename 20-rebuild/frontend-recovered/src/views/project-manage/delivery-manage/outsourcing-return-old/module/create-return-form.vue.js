import { ref as f } from "vue";
import { watch as je } from "vue";
import { computed as ke } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as c } from "vue";
import { createBlock as h } from "vue";
import { withCtx as r } from "vue";
import { unref as l } from "vue";
import { createVNode as n } from "vue";
import { withModifiers as N } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementVNode as T } from "vue";
import { withKeys as A } from "vue";
import { createElementBlock as b } from "vue";
import { withDirectives as Ae } from "vue";
import { toDisplayString as d } from "vue";
import { Fragment as Ue } from "vue";
import { renderList as Ie } from "vue";
import { isRef as Me } from "vue";
import { ElBadge as Qe } from "element-plus";
import { ElInput as Ee } from "element-plus";
import { ElDatePicker as Ce } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { ElTag as xe } from "element-plus";
import { ElTooltip as we } from "element-plus";
import { ElPagination as Pe } from "element-plus";
import { vLoading as Le } from "element-plus";
import { a as Se } from "../../../../../modules/outsourcing-return-1594aa02.js";
import { tS as R, u as ze, J as He, o as Ge, i as V, b as U, jl as Be, tW as o, c as j, cO as Oe, G as O, kx as We, I as Ke, p as qe, aN as De, bv as Fe, pz as Ye, pA as $e, c9 as W } from "../../../../../shared/runtime.js";
import { u as Je } from "../../../../../modules/use-table-row-validate-5799de49.js";
import { s as Xe } from "../../../../../modules/index-8edb1b61.js";
import Ze from "./return-confirm-form.vue.js";
import { _ as et } from "../../../../../modules/project-select-v3-7c9e02e1.js";
const tt = { class: "head-container" }, at = { style: { "margin-bottom": "8px" } }, lt = { key: 0 }, nt = { key: 0 }, ot = { key: 0 }, it = { key: 1 }, st = { key: 2 }, ut = { key: 1 }, ct = { key: 1 }, rt = { key: 1 }, pt = { key: 1, class: "red-tip", style: { "font-size": "14px" } }, Vt = { __name: "create-return-form", props: { modelValue: { type: Boolean, require: true }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(I, { emit: K }) {
  const L = K, q = f([R.MACHINE_PART.V, R.AUXILIARY_MATERIAL.V]), D = I, Q = f([]), S = f(), F = f(false), Y = f([]), _ = f([]), w = f(false), $ = f(), J = f({}), z = f({}), u = f({ supplierId: void 0, productType: void 0, receivedTime: [], monomerOrArea: void 0, name: void 0, purchaseSn: void 0, serialNumber: void 0, specification: void 0, userName: void 0 }), y = f({ projectId: void 0 }), { visible: E, handleClose: X } = ze({ emit: L, props: D }), { handleSizeChange: Z, handleCurrentChange: ee, total: te, setTotalPage: ae, queryPage: P } = He({ fetchHook: m });
  je(() => E.value, (s) => {
    u.value = {}, y.value = {}, _.value = [], Y.value = [];
  }, { immediate: true });
  const le = { selectMete: [{ required: true, message: "请填写退货量", trigger: "blur" }, { pattern: W, message: "数量必须大于0", trigger: "blur" }] }, ne = { selectQuantity: [{ required: true, message: "请填写退货数", trigger: "blur" }, { pattern: W, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: oe, wrongCellMask: ie } = Je({ rules: (s) => s.tableRules }), { maxHeight: se } = Ge({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, extraHeight: 90, navbar: false, clientHRepMainH: true }, S), ue = ke(() => {
    var s;
    return (s = _.value) == null ? void 0 : s.map((a) => a.id);
  });
  function ce(s, a) {
    s.selectQuantity = a, s.selectMete = s.selectQuantity * (s.canRejectActualReceivedMete / s.canRejectQuantity);
  }
  function re(s, a) {
    s.selectMete = a;
  }
  async function m() {
    if (y.value.projectId) try {
      const { content: s = [], totalElements: a } = await Se({ ...u.value, projectId: y.value.projectId, ...P });
      ae(a), Q.value = s || [], Q.value.forEach(async (t) => {
        t.selectQuantity = t.canRejectQuantity, t.selectMete = t.canRejectActualReceivedMete, t.tableRules = V(t.accountingUnit) && V(t.measureUnit) ? ne : V(t.accountingUnit) && U(t.measureUnit) || V(t.measureUnit) && U(t.accountingUnit) ? le : {}, t.productType === R.RAW_MATERIAL.V ? await Be(t, { toNum: true }, { mete: ["canRejectMete", "canRejectActualReceivedMete", "selectMete"], quantity: ["canRejectQuantity", "selectQuantity"] }) : (t.accountingUnit = t.wageQuotaType === o.WEIGHT.V ? o.WEIGHT.unit : t.wageQuotaType === o.LENGTH.V ? o.LENGTH.unit : t.wageQuotaType === o.QUANTITY.V ? o.QUANTITY.unit : t.wageQuotaType === o.AREA.V ? o.AREA.unit : "", t.accountingPrecision = t.wageQuotaType === o.WEIGHT.V ? o.WEIGHT.precision : t.wageQuotaType === o.LENGTH.V ? o.LENGTH.precision : t.wageQuotaType === o.QUANTITY.V ? o.QUANTITY.precision : t.wageQuotaType === o.AREA.V ? o.AREA.precision : 0, t.canRejectActualReceivedMete = t.wageQuotaType === o.WEIGHT.V ? j(t.canRejectActualReceivedMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.canRejectActualReceivedMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.canRejectActualReceivedMete, "mm²", "m²", 6) : t.canRejectActualReceivedMete, t.canRejectMete = t.wageQuotaType === o.WEIGHT.V ? j(t.canRejectMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.canRejectMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.canRejectMete, "mm²", "m²", 6) : t.canRejectMete, t.selectMete = t.wageQuotaType === o.WEIGHT.V ? j(t.selectMete, "g", "kg", 3) : t.wageQuotaType === o.LENGTH.V ? j(t.selectMete, "mm", "m", 3) : t.wageQuotaType === o.AREA.V ? j(t.selectMete, "mm²", "m²", 6) : t.selectMete);
      }), Oe(Q.value);
    } catch (s) {
      console.log(s, "获取采购合同号列表失败");
    }
  }
  function pe() {
    u.value = {}, m();
  }
  function de(s) {
    const { validResult: a } = oe([s]);
    a && _.value.push(s);
  }
  async function me() {
    _.value = [], await m(), L("success");
  }
  function ye(s) {
    z.value = s, _.value = [];
  }
  return (s, a) => {
    const t = M("common-button"), ge = Qe, fe = M("common-radio-button"), k = Ee, he = Ce, p = Ne, Te = xe, Ve = we, H = M("common-input-number"), be = M("common-table"), Re = Pe, _e = M("common-drawer"), ve = Le;
    return c(), h(_e, { ref_key: "drawerRef", ref: S, title: "外购退货办理", "close-on-click-modal": false, modelValue: l(E), "onUpdate:modelValue": a[12] || (a[12] = (e) => Me(E) ? E.value = e : null), direction: "rtl", "before-close": l(X), size: "100%" }, { titleRight: r(() => {
      var e, i;
      return [l(O)(I.permission.preview) ? (c(), h(ge, { key: 0, value: (e = _.value) == null ? void 0 : e.length, hidden: !((i = _.value) != null && i.length), style: { float: "right", "margin-right": "20px" } }, { default: r(() => {
        var g;
        return [n(t, { type: "warning", class: "filter-item", size: "default", disabled: !y.value.projectId || !((g = _.value) != null && g.length), onClick: a[0] || (a[0] = N((C) => w.value = true, ["stop"])) }, { default: r(() => a[13] || (a[13] = [x(" 外购退货预览列表 ")])), _: 1, __: [13] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value", "hidden"])) : v("", true)];
    }), content: r(() => [T("div", tt, [T("div", at, [n(et, { modelValue: y.value.projectId, "onUpdate:modelValue": a[1] || (a[1] = (e) => y.value.projectId = e), class: "filter-item", clearable: "", placeholder: "选择项目", style: { width: "240px" }, businessType: l(We).INSTALLATION.V, onChange: m, onProjectChange: ye }, null, 8, ["modelValue", "businessType"]), y.value.projectId ? (c(), h(fe, { key: 0, modelValue: u.value.productType, "onUpdate:modelValue": a[2] || (a[2] = (e) => u.value.productType = e), options: l(R).ENUM, type: "enum", unshowVal: q.value, showOptionAll: "", class: "filter-item", onChange: m }, null, 8, ["modelValue", "options", "unshowVal"])) : v("", true), y.value.projectId ? (c(), h(Xe, { key: 1, modelValue: u.value.supplierId, "onUpdate:modelValue": a[3] || (a[3] = (e) => u.value.supplierId = e), clearable: "", filterable: "", style: { width: "300px", "margin-right": "6px" }, projectId: y.value.projectId, placeholder: "供应商搜索", class: "filter-item", onChange: m }, null, 8, ["modelValue", "projectId"])) : v("", true), y.value.projectId ? (c(), h(k, { key: 2, modelValue: u.value.purchaseSn, "onUpdate:modelValue": a[4] || (a[4] = (e) => u.value.purchaseSn = e), size: "default", placeholder: "采购合同号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"])) : v("", true), y.value.projectId ? (c(), h(k, { key: 3, modelValue: u.value.userName, "onUpdate:modelValue": a[5] || (a[5] = (e) => u.value.userName = e), size: "default", placeholder: "办理人搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"])) : v("", true)]), y.value.projectId ? (c(), b("div", lt, [n(he, { modelValue: u.value.receivedTime, "onUpdate:modelValue": a[6] || (a[6] = (e) => u.value.receivedTime = e), type: "daterange", "range-separator": "-", "value-format": "x", shortcuts: l(Ke), "start-placeholder": "收货日期", "end-placeholder": "收货日期", class: "filter-item", onChange: m }, null, 8, ["modelValue", "shortcuts"]), n(k, { modelValue: u.value.monomerOrArea, "onUpdate:modelValue": a[7] || (a[7] = (e) => u.value.monomerOrArea = e), size: "default", placeholder: "单体区域/批次搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: u.value.specification, "onUpdate:modelValue": a[8] || (a[8] = (e) => u.value.specification = e), size: "default", placeholder: "规格搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: u.value.serialNumber, "onUpdate:modelValue": a[9] || (a[9] = (e) => u.value.serialNumber = e), size: "default", placeholder: "编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"]), n(k, { modelValue: u.value.name, "onUpdate:modelValue": a[10] || (a[10] = (e) => u.value.name = e), size: "default", placeholder: "名称搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: A(m, ["enter"]) }, null, 8, ["modelValue"]), n(t, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: N(m, ["stop"]) }, { default: r(() => a[14] || (a[14] = [x(" 搜索 ")])), _: 1, __: [14] }), n(t, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: N(pe, ["stop"]) }, { default: r(() => a[15] || (a[15] = [x(" 重置 ")])), _: 1, __: [15] })])) : v("", true)]), y.value.projectId ? (c(), b("div", nt, [Ae((c(), h(be, { data: Q.value, "max-height": l(se), returnSourceData: "", "show-empty-symbol": false, "cell-class-name": l(ie) }, { default: r(() => [n(p, { label: "序号", type: "index", align: "center", width: "60" }), n(p, { key: "createTime", prop: "createTime", label: "收货日期", align: "center", width: "140", "show-overflow-tooltip": true }, { default: r(({ row: e }) => [T("span", null, d(e.createTime ? l(qe)(e.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), n(p, { key: "supplier.name", prop: "supplier.name", label: "供应商", align: "center", "min-width": "120", "show-overflow-tooltip": true }), n(p, { key: "purchaseSn", prop: "purchaseSn", label: "采购合同号", align: "center", "min-width": "120", "show-overflow-tooltip": true }), n(p, { key: "userName", prop: "userName", label: "收货人", align: "center", "show-overflow-tooltip": true }), n(p, { key: "productType", prop: "productType", label: "材料类型", align: "center", width: "140", "show-overflow-tooltip": true }, { default: r((e) => [(c(true), b(Ue, null, Ie(l(De)(l(Fe).getBits(l(R), e.row.productType, "V")), (i) => (c(), h(Te, { style: { "margin-right": "5px" }, key: i, type: l(R).V[i].T, effect: "light", "disable-transitions": "" }, { default: r(() => [x(d(l(R).VL[i]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 }), n(p, { key: "productType", prop: "productType", label: "单体区域/批次", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r(({ row: e }) => {
      var i, g, C, G, B;
      return [e.productType === l(R).STRUCTURE.V ? (c(), b("span", ot, d(((i = e.monomer) != null && i.name || (g = e == null ? void 0 : e.area) != null && g.name) && (((C = e.monomer) == null ? void 0 : C.name) || "->" + ((G = e == null ? void 0 : e.area) == null ? void 0 : G.name)) || "-"), 1)) : e.productType === l(R).ENCLOSURE.V ? (c(), b("span", it, d(((B = e.batch) == null ? void 0 : B.name) || "-"), 1)) : (c(), b("span", st, "-"))];
    }), _: 1 }), n(p, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": true }), n(p, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), n(p, { key: "specificationMerge", prop: "specificationMerge", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": true }, { default: r(({ row: e }) => [e.productType === l(R).RAW_MATERIAL.V ? (c(), h(Ve, { key: 0, content: l(Ye)(e), placement: "left" }, { default: r(() => [T("span", null, d(l($e)(e)), 1)]), _: 2 }, 1032, ["content"])) : (c(), b("span", ut, d(e.specification || "-"), 1))]), _: 1 }), n(p, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "数量", align: "center" }, { default: r(({ row: e }) => [T("span", null, d(e.canRejectQuantity || "-"), 1), T("span", null, d(e.measureUnit || ""), 1)]), _: 1 }), n(p, { key: "canRejectMete", prop: "canRejectMete", label: "核算量", align: "center" }, { default: r(({ row: e }) => {
      var i;
      return [T("span", null, d(((i = e.canRejectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), T("span", null, d(e.accountingUnit || ""), 1)];
    }), _: 1 }), n(p, { key: "canRejectQuantity", prop: "canRejectQuantity", label: "实收数", align: "center" }, { default: r(({ row: e }) => [T("span", null, d(e.canRejectQuantity || "-"), 1), T("span", null, d(e.measureUnit || ""), 1)]), _: 1 }), n(p, { key: "canRejectActualReceivedMete", prop: "canRejectActualReceivedMete", label: "实收量", align: "center" }, { default: r(({ row: e }) => {
      var i;
      return [T("span", null, d(((i = e.canRejectActualReceivedMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1), T("span", null, d(e.accountingUnit || ""), 1)];
    }), _: 1 }), n(p, { key: "selectQuantity", prop: "selectQuantity", label: "本次退货数", align: "center", width: "140" }, { default: r(({ row: e }) => [l(V)(e.accountingUnit) && l(V)(e.measureUnit) ? (c(), h(H, { key: 0, modelValue: e.selectQuantity, "onUpdate:modelValue": (i) => e.selectQuantity = i, controls: false, min: 0, max: e.canRejectQuantity, precision: e.measurePrecision || 0, size: "default", clearable: "", placeholder: "退货数", style: { width: "100%" }, onChange: (i) => ce(e, i) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"])) : l(V)(e.accountingUnit) && l(U)(e.measureUnit) || l(V)(e.measureUnit) && l(U)(e.accountingUnit) ? (c(), b("span", ct, "-")) : v("", true)]), _: 1 }), n(p, { key: "selectMete", prop: "selectMete", label: "本次退货量", align: "center", width: "140" }, { default: r(({ row: e }) => {
      var i;
      return [l(V)(e.accountingUnit) && l(U)(e.measureUnit) || l(V)(e.measureUnit) && l(U)(e.accountingUnit) ? (c(), h(H, { key: 0, modelValue: e.selectMete, "onUpdate:modelValue": (g) => e.selectMete = g, controls: false, min: 0, size: "default", precision: e.accountingPrecision, clearable: "", placeholder: "退货量", style: { width: "100%" }, onChange: (g) => re(e, g) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : l(V)(e.accountingUnit) && l(V)(e.measureUnit) ? (c(), b("span", rt, d(((i = e.selectMete) == null ? void 0 : i.toFixed(e.accountingPrecision)) || "-"), 1)) : v("", true)];
    }), _: 1 }), l(O)(I.permission.addRow) ? (c(), h(p, { key: 0, label: "操作", width: "80", align: "center" }, { default: r(({ row: e, $index: i }) => {
      var g;
      return [n(t, { size: "default", icon: "el-icon-plus", type: "success", onClick: N((C) => de(e, i), ["stop"]), disabled: (g = ue.value) == null ? void 0 : g.includes(e.id) }, null, 8, ["onClick", "disabled"])];
    }), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[ve, F.value]]), n(Re, { total: l(te), "current-page": l(P).pageNumber, "page-size": l(P).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(Z), onCurrentChange: l(ee) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : (c(), b("div", pt, "* 请选择项目查看明细列表")), n(Ze, { modelValue: w.value, "onUpdate:modelValue": a[11] || (a[11] = (e) => w.value = e), "summary-list": _.value, "detail-info": J.value, "project-info": z.value, globalProject: I.globalProject, currentProductType: $.value, contractId: u.value.contractId, permission: I.permission, onSuccess: me }, null, 8, ["modelValue", "summary-list", "detail-info", "project-info", "globalProject", "currentProductType", "contractId", "permission"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Vt as default
};
