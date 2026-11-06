import { ref as c } from "vue";
import { reactive as Se } from "vue";
import { provide as P } from "vue";
import { watch as we } from "vue";
import { onMounted as ke } from "vue";
import { resolveComponent as X } from "vue";
import { resolveDirective as xe } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as E } from "vue";
import { createVNode as a } from "vue";
import { unref as n } from "vue";
import { normalizeStyle as O } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as w } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as H } from "vue";
import { vShow as Q } from "vue";
import { ElDivider as Ee } from "element-plus";
import { ElBadge as qe } from "element-plus";
import { ElCard as Ce } from "element-plus";
import { ElTag as Ne } from "element-plus";
import { ElDescriptionsItem as Ie } from "element-plus";
import { ElDescriptions as De } from "element-plus";
import { ElTableColumn as Re } from "element-plus";
import { vLoading as Le } from "element-plus";
import { _ as Pe, x as Te, rF as k, qB as Oe, o as Y, qC as He, oW as Z, bV as Qe, P as Be, ba as Ve, G as canEliminate } from "../../../../shared/runtime.js";
import We from "./module/header.vue.js";
import je from "./module/preview.vue.js";
import Me from "./module/project-list.vue.js";
import Ae from "./module/eliminate-dialog.vue.js";
import "./module/materials-drawer.vue.js";
import "./module/binding-detail.vue.js";
import "./module/stock.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "../common/project-header-time.vue.js";
const Ue = { class: "app-container wrap" }, ze = { class: "wrap-left" }, $e = { class: "wrap-right" }, Fe = { key: 0, class: "head-container" }, Ke = { style: { float: "right" } }, Ge = { key: 1, class: "head-send" }, Je = { __name: "index", setup(Xe) {
  const ee = { add: false, edit: false, del: false, download: false }, te = c(), x = c(), u = c([]), d = c([]), q = c(false), ae = c(), le = Se([{ id: true, name: "有工序" }, { id: false, name: "无工序" }]), f = c([]), { crud: l, CRUD: B } = Te({ title: "型材排产", sort: [], permission: { ...k }, optShow: { ...ee }, crudApi: { ...Oe }, queryOnPresenterCreated: false, hasPagination: true, requiredQuery: ["taskOrderIds"] }, x);
  l.page.size = 100;
  const { maxHeight: ne } = Y({ extraBox: "", paginate: false }), ie = (e) => !d.value.includes(e.id), { maxHeight: V } = Y({ paginate: true }), _ = c({ totalNeedWeight: 0, totalSchedulingQuantity: 0 }), C = c([]), S = c(false), p = c([]), N = c(false), W = c({});
  P("workShopList", C), P("process", le), P("permission", k), we(() => l.query.sendNestingStatus, () => {
    j();
  });
  async function j() {
    try {
      const e = await He({ steelPlateTypeEnum: [Z.SECTION_STEEL.V], sendNestingStatus: l.query.sendNestingStatus || S.value });
      C.value = e;
    } catch (e) {
      console.log(e, "获取车间列表");
    }
  }
  ke(() => {
    j();
  });
  function oe({ taskOrderIds: e, sendNestingStatus: t, projectId: s }, i, g) {
    l.query.steelPlateTypeEnum = [Z.SECTION_STEEL.V], l.query.yearMonthArray = i, l.query.sendNestingStatus = t, l.query.taskOrderIds = e, I.value = s, e.length || (_.value = {}), M !== I.value && (u.value = [], p.value = [], d.value = []), M = I.value, l.toQuery();
  }
  function se(e) {
    f.value = e;
  }
  const I = c(void 0);
  let M = "";
  function re(e) {
    S.value = e, l.query.taskOrderIds = [];
  }
  async function ue() {
    l.toQuery(), d.value = d.value.filter((e) => !u.value.some((t) => t.id === e)), u.value = [], l.page.page = 1, l.toQuery();
  }
  function A({ row: e, id: t, type: s }) {
    d.value = d.value.filter((i) => i !== t), s === 1 ? u.value = u.value.filter((i) => i.id !== t) : s === 2 && (p.value = p.value.filter((i) => i.id !== t));
  }
  function U({ list: e, type: t }) {
    d.value = d.value.filter((s) => !e.some((i) => i.id === s)), t === 1 ? u.value = u.value.filter((s) => !e.some((i) => i.id === s.id)) : t === 2 && (p.value = p.value.filter((s) => !e.some((i) => i.id === s.id)));
  }
  const de = () => {
    u.value = u.value.concat(f.value), d.value = [...new Set(d.value.concat(f.value.map((e) => e.id)))], f.value.forEach((e) => {
      x.value.toggleRowSelection(e, false);
    });
  };
  function ce() {
    q.value = true;
  }
  const pe = () => {
    const e = f.value, t = new Set(e.map((s) => s.id));
    p.value = [.../* @__PURE__ */ new Set([...p.value, ...e])], d.value = [.../* @__PURE__ */ new Set([...d.value, ...t])], e.forEach((s) => {
      x.value.toggleRowSelection(s, false);
    }), f.value = [];
  };
  function me() {
    if (!canEliminate(k.unProductDel)) return;
    N.value = true;
  }
  function ve() {
    W.value.checked = false;
  }
  async function fe() {
    l.toQuery(), d.value = d.value.filter((e) => !p.value.some((t) => t.id === e)), p.value = [], l.toQuery();
  }
  function ge(e) {
    return Ve({ ...e, data: e.data.map((t) => {
      const s = t.sourceRow || t;
      return { ...s, weight: s.weight * s.quantity };
    }) }, { props: ["weight", "quantity"] });
  }
  return B.HOOK.beforeRefresh = () => {
    _.value = { totalNetWeight: 0, quantity: 0 };
  }, B.HOOK.handleRefresh = (e, t) => {
    var s, i;
    _.value.totalNeedWeight = ((s = t.data.content[0]) == null ? void 0 : s.totalNeedWeight) || 0, _.value.totalSchedulingQuantity = ((i = t.data.content[0]) == null ? void 0 : i.totalSchedulingQuantity) || 0, t.data.content = t.data.content.map((g) => (e.query.sendNestingStatus && (g.quantity = g.needQuantity), g.state = false, g));
  }, (e, t) => {
    var z, $, F, K, G, J;
    const s = Ee, i = X("common-button"), g = qe, he = Ce, D = Ne, R = Ie, _e = De, v = Re, ye = X("common-table"), L = xe("permission"), be = Le;
    return h(), T("div", Ue, [E("div", ze, [a(n(Me), { ref_key: "projectListRef", ref: te, maxHeight: n(V), onProjectClick: oe, onSendStatus: re, workShopList: C.value }, null, 8, ["maxHeight", "workShopList"])]), a(s, { direction: "vertical", style: O(`height: ${n(ne)}px`) }, null, 8, ["style"]), E("div", $e, [E("div", null, [S.value ? H("", true) : (h(), T("div", Fe, [a(n(We), { ref_key: "headRef", ref: ae }, { searchRight: r(() => [a(he, { shadow: "always" }, { default: r(() => [y((h(), w(i, { type: "primary", class: "filter-item", icon: "el-icon-plus", disabled: !f.value.length, onClick: de }, { default: r(() => t[2] || (t[2] = [m(" 加入任务 ")])), _: 1, __: [2] }, 8, ["disabled"])), [[L, n(k).noNestingSave]]), a(i, { type: "danger", class: "filter-item", icon: "el-icon-plus", disabled: !f.value.length, onClick: pe }, { default: r(() => t[3] || (t[3] = [m(" 剔除 ")])), _: 1, __: [3] }, 8, ["disabled"]), E("span", Ke, [a(g, { value: p.value.length, hidden: !p.value.length, style: O({ marginRight: p.value.length ? "25px" : 0 }) }, { default: r(() => [y((h(), w(i, { type: "danger", class: "filter-item", icon: "el-icon-delete", round: "", plain: "", onClick: me }, { default: r(() => t[4] || (t[4] = [m(" 剔除汇总 ")])), _: 1, __: [4] })), [[L, n(k).unProductDel]])]), _: 1 }, 8, ["value", "hidden", "style"]), a(g, { value: u.value.length, hidden: !u.value.length, style: O({ marginRight: u.value.length ? "25px" : 0 }) }, { default: r(() => [y((h(), w(i, { type: "primary", class: "filter-item", icon: "el-icon-document", round: "", plain: "", disabled: !u.value.length, onClick: ce }, { default: r(() => t[5] || (t[5] = [m(" 排产汇总 ")])), _: 1, __: [5] }, 8, ["disabled"])), [[L, n(k).noNestingSave]])]), _: 1 }, 8, ["value", "hidden", "style"])])]), _: 1 })]), optLeft: r(() => [a(D, { effect: "plain", style: { "margin-right": "5px" } }, { default: r(() => {
      var o;
      return [m(" 总数量(件)：" + b(((o = _.value) == null ? void 0 : o.totalSchedulingQuantity) || 0), 1)];
    }), _: 1 }), a(D, { effect: "plain", style: { "margin-right": "10px" } }, { default: r(() => {
      var o;
      return [m(" 总重量(kg)：" + b(n(Qe)((o = _.value) == null ? void 0 : o.totalNeedWeight) || 0), 1)];
    }), _: 1 })]), _: 1 }, 512)])), S.value ? (h(), T("div", Ge, [a(_e, { column: 3, size: "large", border: "" }, { default: r(() => [a(R, { align: "center", label: "工单号：" }, { default: r(() => {
      var o;
      return [m(b(((o = n(l).data[0]) == null ? void 0 : o.orderNumber) || "-"), 1)];
    }), _: 1 }), a(R, { align: "center", label: "排产人：" }, { default: r(() => {
      var o;
      return [m(b(((o = n(l).data[0]) == null ? void 0 : o.userName) || "-"), 1)];
    }), _: 1 }), a(R, { align: "center", label: "排产日期：" }, { default: r(() => {
      var o;
      return [m(b(((o = n(l).data[0]) == null ? void 0 : o.schedulingDate) || "-"), 1)];
    }), _: 1 })]), _: 1 })])) : H("", true), y(a(D, { type: "info" }, { default: r(() => t[6] || (t[6] = [m(" * 请先选择项目或者班组进行零件排产 ")])), _: 1, __: [6] }, 512), [[Q, !(($ = (z = n(l).query) == null ? void 0 : z.taskOrderIds) != null && $.length)]]), y((h(), w(ye, { ref_key: "tableRef", ref: x, data: n(l).data, "show-summary": "", "summary-method": ge, "empty-text": n(l).emptyText, "max-height": n(V), style: { width: "100%" }, id: "listTable", onSelectionChange: se }, { default: r(() => [S.value ? H("", true) : (h(), w(v, { key: 0, type: "selection", width: "55", align: "center", selectable: ie })), a(v, { label: "序号", type: "index", align: "center", width: "55" }), a(v, { key: "partType", prop: "partType", label: "类型", align: "center" }), a(v, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), a(v, { key: "material", prop: "material", label: "材质", align: "center", width: "120", "show-overflow-tooltip": true }), a(v, { key: "specification", prop: "specification", label: "规格", align: "center", width: "200", "show-overflow-tooltip": true }), a(v, { key: "length", label: "长度(m)", align: "center" }, { default: r(({ row: o }) => [m(b(o.length / 1e3), 1)]), _: 1 }), a(v, { key: "weight", prop: "weight", label: "重量(kg)", align: "center" }), a(v, { key: "quantity", prop: "quantity", label: "数量", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[Q, (K = (F = n(l).query) == null ? void 0 : F.taskOrderIds) == null ? void 0 : K.length], [be, n(l).loading]]), y(a(n(Be), null, null, 512), [[Q, (J = (G = n(l).query) == null ? void 0 : G.taskOrderIds) == null ? void 0 : J.length]]), a(n(je), { visible: q.value, "onUpdate:visible": t[0] || (t[0] = (o) => q.value = o), "task-order-ids": n(l).query.taskOrderIds, list: u.value, onSuccess: ue, onHandleDel: A, onHandleBatchDel: U }, null, 8, ["visible", "task-order-ids", "list"]), a(n(Ae), { visible: N.value, "onUpdate:visible": t[1] || (t[1] = (o) => N.value = o), info: W.value, eliminateList: p.value, onClose: ve, onSuccess: fe, onHandleDel: A, onHandleBatchDel: U }, null, 8, ["visible", "info", "eliminateList"])])])]);
  };
} }, dt = Pe(Je, [["__scopeId", "data-v-fabaafb8"]]);
export {
  dt as default
};
