import { ref as y } from "vue";
import { watch as ee } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as te } from "vue";
import { createElementVNode as m } from "vue";
import { createBlock as i } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as x } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as r } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as z } from "vue";
import { createVNode as g } from "vue";
import { withModifiers as ae } from "vue";
import { ElMessage as H } from "element-plus";
import { ElMessageBox as le } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElTableColumn as ne } from "element-plus";
import { ElPopover as ie } from "element-plus";
import { vLoading as re } from "element-plus";
import { g as Q, a as se, d as U } from "../../../../../modules/labor-setting-a0cbdb82.js";
import { _ as ue, x as de, o as ce, tQ as pe, bW as me, G as j, P as ge, ba as ye } from "../../../../../shared/runtime.js";
import { u as b } from "../../../../../modules/project-19a12d6b.js";
import fe from "./module/create-drawer.vue.js";
import "../../../../../modules/monomer-select-area-tabs-3dd3c2aa.js";
import "../../../../../modules/convert-product-type-fcb585d7.js";
import "../../../../../modules/index-8356a01a.js";
import "./module/handle-confirm.vue.js";
import "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
const be = { class: "head-container" }, ve = { style: { float: "right" } }, _e = { style: { "text-align": "right", margin: "0" } }, he = { __name: "index", props: { globalProjectId: { type: Number, default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(I) {
  const v = I, O = { add: false, edit: false, del: false, download: false }, S = y(), k = y([]), _ = y(false), w = y(false), C = y(), D = y({}), { crud: a, columns: c, CRUD: N } = de({ title: "劳务设置", sort: ["id.desc"], permission: { ...b }, optShow: { ...O }, requiredQuery: ["projectId"], crudApi: { get: Q }, hasPagination: true }, S), { maxHeight: R } = ce({ wrapperBox: ".subcontract-plan", paginate: true, extraHeight: 100 });
  ee(() => v.globalProjectId, (l) => {
    var e, p;
    l && (a.query.projectId = v.globalProjectId, a.query.monomerId = void 0, (e = v.globalProject) != null && e.installDivideMethod && ((p = v.globalProject) == null ? void 0 : p.installDivideMethod) === 2 && (V(), a.toQuery()));
  }, { immediate: true }), N.HOOK.beforeToQuery = () => (a.query.projectId = v.globalProjectId || void 0, a.crudApi.get = Q, !!a.query.projectId), N.HOOK.handleRefresh = (l, e) => {
  };
  async function V() {
    var l;
    try {
      const e = await se({ projectId: a.query.projectId });
      k.value = e || [], (l = k.value) == null || l.forEach((p) => {
        D.value[p.id] = p;
      });
    } catch (e) {
      console.log(e, "获取汇总列表数据失败");
    }
  }
  function $(l) {
    l.pop = false;
  }
  function K(l) {
    l.pop = true;
  }
  async function A(l) {
    _.value = true;
    try {
      await U([l.id]), H.success("删除成功"), P();
    } catch (e) {
      console.log(e, "删除失败");
    } finally {
      _.value = false, l.pop = false;
    }
  }
  async function F() {
    var l;
    _.value = true;
    try {
      const e = (l = a.selections) == null ? void 0 : l.map((p) => p.id);
      await le.confirm("您选了“批量删除”操作，是否确认？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await U(e), H.success("批量删除成功"), P();
    } catch (e) {
      console.log(e, "批量删除失败");
    } finally {
      _.value = false;
    }
  }
  function P() {
    V(), a.query.orderId = void 0, C.value = void 0, a.toQuery();
  }
  function G(l) {
    a.query.orderId = l, a.toQuery();
  }
  function J(l) {
    return ye(l, { props: ["quantity", "totalNetWeight"] });
  }
  return (l, e) => {
    var T, B;
    const p = oe, h = q("common-button"), X = q("print-table"), s = ne, Y = ie, Z = q("common-table"), L = re;
    return n(), te("div", null, [m("div", be, [(T = k.value) != null && T.length ? (n(), i(t(me), { key: 0, modelValue: C.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => C.value = o), class: "filter-item", style: "width:calc(100% - 125px)", data: k.value, itemKey: "id", onChange: G }, { default: u(({ item: o }) => {
      var d;
      return [m("span", null, x(t(pe).VL[o.productType]), 1), e[3] || (e[3] = m("span", { style: { margin: "0 6px" } }, " | ", -1)), m("span", null, x((d = o.supplier) == null ? void 0 : d.name), 1)];
    }), _: 1 }, 8, ["modelValue", "data"])) : r("", true), m("div", null, [t(a).query.orderId ? (n(), i(p, { key: 0, type: "primary", size: "default" }, { default: u(() => {
      var o;
      return [f("合计（吨）： " + x((o = D.value[t(a).query.orderId]) == null ? void 0 : o.mete), 1)];
    }), _: 1 })) : r("", true), m("div", ve, [t(j)(t(b).createList) ? (n(), i(h, { key: 0, type: "primary", icon: "el-icon-plus", size: "default", class: "filter-item", onClick: e[1] || (e[1] = (o) => w.value = true) }, { default: u(() => e[4] || (e[4] = [f(" 清单创建 ")])), _: 1, __: [4] })) : r("", true), t(j)(t(b).batchDel) ? z((n(), i(h, { key: 1, type: "danger", size: "default", class: "filter-item", disabled: !((B = t(a).selections) != null && B.length), onClick: F }, { default: u(() => e[5] || (e[5] = [f(" 批量删除 ")])), _: 1, __: [5] }, 8, ["disabled"])), [[L, _.value]]) : r("", true), t(j)(t(b).print) ? (n(), i(X, { key: 2, "api-key": "laborSettingList", params: { ...t(a).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : r("", true)])])]), z((n(), i(Z, { ref_key: "tableRef", ref: S, data: t(a).data, "empty-text": t(a).emptyText, "max-height": t(R), showEmptySymbol: true, stripe: false, style: { width: "100%" }, "show-summary": "", "summary-method": J, onSelectionChange: t(a).selectionChangeHandler }, { default: u(() => [g(s, { type: "selection", align: "center", width: "60" }), g(s, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), t(c).visible("monomer") ? (n(), i(s, { key: "monomer", prop: "monomer", label: "单体>区域", align: "center" }, { default: u((o) => {
      var d, E, M, W;
      return [f(x(((E = (d = o.row) == null ? void 0 : d.monomer) == null ? void 0 : E.name) + ">" + ((W = (M = o.row) == null ? void 0 : M.area) == null ? void 0 : W.name) || "-"), 1)];
    }), _: 1 })) : r("", true), t(c).visible("name") ? (n(), i(s, { key: "name", prop: "name", label: "名称", align: "center" })) : r("", true), t(c).visible("serialNumber") ? (n(), i(s, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" })) : r("", true), t(c).visible("specification") ? (n(), i(s, { key: "specification", prop: "specification", label: "规格", align: "center" })) : r("", true), t(c).visible("length") ? (n(), i(s, { key: "length", prop: "length", label: "长度（mm）", align: "center" })) : r("", true), t(c).visible("material") ? (n(), i(s, { key: "material", prop: "material", label: "材质", align: "center" })) : r("", true), t(c).visible("quantity") ? (n(), i(s, { key: "quantity", prop: "quantity", label: "数量", align: "center" })) : r("", true), t(c).visible("netWeight") ? (n(), i(s, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center" })) : r("", true), t(c).visible("totalNetWeight") ? (n(), i(s, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重（kg）", align: "center" })) : r("", true), t(j)(t(b).del) ? (n(), i(s, { key: 9, label: "操作", width: "90px", align: "center", fixed: "right" }, { default: u(({ row: o }) => [g(Y, { visible: o.pop, "onUpdate:visible": (d) => o.pop = d, placement: "top", width: "80", trigger: "manual" }, { reference: u(() => [g(h, { type: "danger", icon: "el-icon-delete", size: "default", onClick: ae((d) => K(o), ["stop"]) }, null, 8, ["onClick"])]), default: u(() => [e[8] || (e[8] = m("p", null, "确认删除本条数据吗？", -1)), m("div", _e, [g(h, { size: "default", link: "", type: "primary", onClick: (d) => $(o) }, { default: u(() => e[6] || (e[6] = [f("取消")])), _: 2, __: [6] }, 1032, ["onClick"]), g(h, { type: "primary", size: "default", onClick: (d) => A(o) }, { default: u(() => e[7] || (e[7] = [f("确定")])), _: 2, __: [7] }, 1032, ["onClick"])])]), _: 2, __: [8] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[L, t(a).loading]]), g(t(ge)), g(fe, { modelValue: w.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => w.value = o), globalProject: I.globalProject, globalProjectId: I.globalProjectId, onSuccess: P, permission: t(b) }, null, 8, ["modelValue", "globalProject", "globalProjectId", "permission"])]);
  };
} }, Ne = ue(he, [["__scopeId", "data-v-2ffa7464"]]);
export {
  Ne as default
};
